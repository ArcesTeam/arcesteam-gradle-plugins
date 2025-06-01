/*
 * Copyright (c) 2025 ArcesTeam. All rights reserved.
 * This project is licensed under the MIT License. See the LICENSE file for details.
 * This software is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the MIT License for more details.
 *
 */

package arcesteam.gradle.plugin.extension.root

/**
 * ArcesPluginExtension 是 Arces 团队 Gradle 插件的根扩展类，
 */
open class ArcesPluginExtension {

    /**
     * 默认 Java 版本为 21。
     */
    var javaVersion: String = "21"

    /**
     * JUnit 配置扩展实例，用于配置 JUnit 测试相关的设置。
     *
     * 默认情况下，JUnit 配置是禁用的。
     */
    var junit = JunitConfig()

    fun junit(configure: JunitConfig.() -> Unit) {
        junit.apply(configure)
    }

    /**
     * Jacoco 配置扩展实例，用于配置 Jacoco 测试覆盖率相关的设置。
     *
     * 默认情况下，Jacoco 配置是禁用的。
     */
    var jacoco = JacocoConfig()

    fun jacoco(configure: JacocoConfig.() -> Unit) {
        jacoco.apply(configure)
    }

    /**
     * GitHub 配置
     */
    var github = GithubConfig()

    fun github(configure: GithubConfig.() -> Unit) {
        github.apply(configure)
    }
}
