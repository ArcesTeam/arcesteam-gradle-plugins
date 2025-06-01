/*
 * Copyright (c) 2025 ArcesTeam. All rights reserved.
 * This project is licensed under the MIT License. See the LICENSE file for details.
 * This software is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the MIT License for more details.
 *
 */

package arcesteam.gradle.plugin

import arcesteam.gradle.plugin.deps.DependencyCatalog
import arcesteam.gradle.plugin.extension.root.ArcesPluginExtension
import arcesteam.gradle.plugin.extension.root.JunitConfig
import arcesteam.gradle.plugin.extension.sub.ArcesSubPluginExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.findByType
import org.gradle.kotlin.dsl.getByName
import org.gradle.kotlin.dsl.register
import org.gradle.kotlin.dsl.withType
import org.gradle.testing.jacoco.tasks.JacocoReport


class BasePlugin : Plugin<Project> {
    override fun apply(root: Project) {
        if (root != root.rootProject) {
            throw IllegalStateException("arcesteam.gradle.plugin.BasePlugin must be applied to the root project only.")
        }

        val rootExtension = root.extensions.create("arcesteam", ArcesPluginExtension::class.java)

        root.subprojects.forEach { project ->
            // 将根项目的扩展配置传递给子项目
            project.extensions.create("arcesteam", ArcesSubPluginExtension::class.java)
        }

        root.gradle.projectsEvaluated {
            BaseAuthorization().registerRepositories(root)

            root.allprojects {
                tasks.withType<JavaCompile>().configureEach {
                    // 设置 Java 编译器的版本
                    sourceCompatibility = rootExtension.javaVersion
                    targetCompatibility = rootExtension.javaVersion

                    options.apply {
                        encoding = "UTF-8"
                        release.set(rootExtension.javaVersion.toInt())
                    }
                }
            }

            root.subprojects.forEach { project ->
                // 确保子项目也应用了基础插件
                val rootExt = root.extensions.findByType<ArcesPluginExtension>()
                val subExt = project.extensions.findByType<ArcesSubPluginExtension>()

                if (checkJunitEnabled(rootExt, subExt)) applyJunit(project, rootExt)
                if (checkJacocoEnabled(rootExt, subExt)) applyJacoco(project, rootExt)

                DependencyCatalog.injectInto(project)
            }

            root.tasks.register("printGitHubAuth") {
                group = "help"
                description = "Print GitHub authentication information."

                doLast {
                    val config = BaseAuthorization().getConfig(root)
                    println("GitHub Actor: ${config.actor}")
                    println("GitHub Token: ${config.token.take(4)}... (truncated for security)")
                    println("Dependency Repository: ${config.depRepo}")
                    println("Public Repository: ${config.pubRepo}")
                }
            }

            root.tasks.register("verifyAllReports") {
                group = "verification"
                description = "Run all tests and generate all Jacoco reports."

                dependsOn(root.subprojects.flatMap { subProject ->
                    listOfNotNull(
                        subProject.tasks.findByName("test"),
                        subProject.tasks.findByName("jacocoTestReport")
                    )
                })
            }
        }
    }

    private fun checkJunitEnabled(rootExt: ArcesPluginExtension?, subExt: ArcesSubPluginExtension?): Boolean {
        val junitRootEnabled = when {
            rootExt?.junit?.enabled == null -> false
            else -> rootExt.junit.enabled
        }

        val junitSubEnabled = when {
            subExt?.junit?.enabled == null -> true
            else -> subExt.junit.enabled
        }

        return junitRootEnabled && junitSubEnabled;
    }

    private fun applyJunit(project: Project, rootExt: ArcesPluginExtension?) {
        // JUnit 插件必须应用于 java 插件的项目
        if (!project.plugins.hasPlugin("java")) {
            println("Warning: JUnit plugin can only be applied to projects with the Java plugin. Skipping JUnit configuration for project '${project.name}'.")
            return
        }

        // 获取 JUnit 配置项
        val version = rootExt?.junit?.version ?: JunitConfig().version

        // 注入 JUnit 相关依赖
        project.dependencies.apply {
            add("testImplementation", platform("org.junit:junit-bom:${version}"))
            add("testRuntimeOnly", "org.junit.platform:junit-platform-launcher")
            add("testRuntimeOnly", "org.junit.jupiter:junit-jupiter-engine")
        }

        // 配置 JUnit 任务
        project.tasks.withType<Test>().configureEach {
            useJUnitPlatform()
        }

    }

    private fun checkJacocoEnabled(rootExt: ArcesPluginExtension?, subExt: ArcesSubPluginExtension?): Boolean {
        val jacocoRootEnabled = when {
            rootExt?.jacoco?.enabled == null -> false
            else -> rootExt.jacoco.enabled
        }

        val jacocoSubEnabled = when {
            subExt?.jacoco?.enabled == null -> true
            else -> subExt.jacoco.enabled
        }

        return jacocoRootEnabled && jacocoSubEnabled;
    }

    private fun Project.configureJacocoReportTask(
        taskName: String,
        html: Boolean,
        xml: Boolean
    ): JacocoReport {
        if (tasks.findByName(taskName) != null) {
            // 如果任务已经存在，则直接返回
            return tasks.getByName<JacocoReport>(taskName)
        }
        return tasks.register<JacocoReport>(taskName) {
            group = "verification"
            dependsOn(project.tasks.named("test"))

            reports {
                this.html.required.set(html)
                this.xml.required.set(xml)
                this.csv.required.set(false)

                if (html) this.html.outputLocation.set(project.layout.buildDirectory.dir("reports/jacoco/html"))
                if (xml) this.xml.outputLocation.set(project.layout.buildDirectory.file("reports/jacoco/report.xml"))
            }

            sourceDirectories.setFrom(project.fileTree("src") {
                include("main/java")
                include("main/kotlin")
            })

            classDirectories.setFrom(project.fileTree("build/classes") {
                include("**/*.class")
                exclude("**/module-info.class") // 排除模块信息文件
            })

            executionData.setFrom(project.fileTree("build/jacoco") {
                include("test.exec")
                include("jacocoTest.exec")
            })
        }.get()
    }

    private fun applyJacoco(project: Project, rootExt: ArcesPluginExtension?) {
        // Jacoco 插件必须应用于 java 插件的项目
        if (!project.plugins.hasPlugin("java")) {
            println("Warning: Jacoco plugin can only be applied to projects with the Java plugin. Skipping Jacoco configuration for project '${project.name}'.")
            return
        }

        // 获取 Jacoco 配置项
        val excludeProjects = rootExt?.jacoco?.excludeProjects ?: emptyList()

        if (excludeProjects.isNotEmpty() && project.name in excludeProjects) {
            // 如果当前项目在排除列表中，则不应用 Jacoco
            return
        }

        // 应用 Jacoco 插件
        project.plugins.apply("jacoco")

        // 配置 Jacoco 任务
        project.configureJacocoReportTask("jacocoTest", html = false, xml = false)
        project.configureJacocoReportTask("jacocoTestReport", html = true, xml = true)
    }
}
