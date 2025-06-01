/*
 * Copyright (c) 2025 ArcesTeam. All rights reserved.
 * This project is licensed under the MIT License. See the LICENSE file for details.
 * This software is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the MIT License for more details.
 *
 */

plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    kotlin("jvm")
    `maven-publish`
}

gradlePlugin {
    plugins {
        register("base") {
            id = "arcesteam.base"
            implementationClass = "arcesteam.gradle.plugin.BasePlugin"
            displayName = "ArcesTeam 基础构建约定插件"
            description = "ArcesTeam 基础构建约定插件，提供一系列通用的 Gradle 构建配置和约定。"
        }
    }
}

dependencies {
    implementation(gradleApi())
}

publishing {}
