/*
 * Copyright (c) 2025 ArcesTeam. All rights reserved.
 * This project is licensed under the MIT License. See the LICENSE file for details.
 * This software is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the MIT License for more details.
 *
 */

plugins {
    `kotlin-dsl`
    `maven-publish`
}

allprojects {
    group = "arcesteam"
    version = "0.1.0"

    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

tasks.processResources {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/ArcesTeam/arcesteam-gradle-plugins")
            credentials {
                username = System.getenv("GITHUB_ACTOR") ?: "github-actions"
                password = System.getenv("GITHUB_TOKEN") ?: ""
            }
        }
    }
}
