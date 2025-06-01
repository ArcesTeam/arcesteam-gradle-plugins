/*
 * Copyright (c) 2025 ArcesTeam. All rights reserved.
 * This project is licensed under the MIT License. See the LICENSE file for details.
 * This software is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the MIT License for more details.
 *
 */

package arcesteam.gradle.plugin

import arcesteam.gradle.plugin.extension.root.ArcesPluginExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.findByType

open class BaseAuthorization {

    open fun registerRepositories(project: Project) {
        val config = getConfig(project)

        project.repositories.apply {
            maven {
                name = "GitHub Dependencies Repository"
                url = project.uri(config.depRepo)
                credentials {
                    username = config.actor
                    password = config.token
                }
            }
            maven {
                name = "GitHub Public Repository"
                url = project.uri(config.pubRepo)
                credentials {
                    username = config.actor
                    password = config.token
                }
            }
        }

        if (config.actor.isEmpty() || config.actor.isBlank()) {
            project.logger.warn("⚠\uFE0F 未配置 github.actor,存在访问限制。\n请在 gradle.properties 中添加 github.actor 或者在环境变量中设置 GITHUB_ACTOR。\n同时请注意避免在代码提交中包含个人 Actor 信息。")
        }

        if (config.token.isEmpty() || config.token.isBlank()) {
            project.logger.warn("⚠\uFE0F 未配置 github.token,存在访问限制。\n请在 gradle.properties 中添加 github.token 或者在环境变量中设置 GITHUB_TOKEN。\n同时请注意避免在代码提交中包含个人 Token 信息。")
        }
    }

    fun getConfig(project: Project): Config {
        val ext = project.extensions.findByType<ArcesPluginExtension>()
        return Config(
            checkDepRepo(ext),
            checkPubRepo(ext, project),
            checkActor(ext, project),
            checkToken(ext, project)
        )
    }

    fun checkDepRepo(ext: ArcesPluginExtension?): String {
        return ext?.github?.depRepo
            ?: "https://maven.pkg.github.com/ArcesTeam"
    }

    fun checkPubRepo(ext: ArcesPluginExtension?, project: Project): String {
        return ext?.github?.pubRepo
            ?: "https://maven.pkg.github.com/ArcesTeam/${project.rootProject.name}"
    }

    fun checkActor(ext: ArcesPluginExtension?, project: Project): String {
        return ext?.github?.actor
            ?: project.findProperty("github.actor") as? String
            ?: System.getenv("GITHUB_ACTOR")
            ?: "github-actions"
    }

    fun checkToken(ext: ArcesPluginExtension?, project: Project): String {
        return ext?.github?.token
            ?: project.findProperty("github.token") as? String
            ?: System.getenv("GITHUB_TOKEN")
            ?: ""
    }

    data class Config(
        var depRepo: String,
        var pubRepo: String,
        var actor: String,
        var token: String
    )
}
