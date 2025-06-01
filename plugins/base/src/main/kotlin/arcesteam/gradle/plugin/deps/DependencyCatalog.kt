/*
 * Copyright (c) 2025 ArcesTeam. All rights reserved.
 * This project is licensed under the MIT License. See the LICENSE file for details.
 * This software is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the MIT License for more details.
 *
 */

package arcesteam.gradle.plugin.deps

import org.gradle.api.Project

/**
 * 所有依赖项集中维护类，支持自动注入与版本覆盖。
 */
object DependencyCatalog {

    private val deps: List<DependencyDescriptor> = listOf(
        DependencyDescriptor(
            scope = DependencyScope.IMPLEMENTATION,
            group = "org.slf4j",
            name = "slf4j-api",
            defaultVersion = "2.0.17"
        ),
        DependencyDescriptor(
            scope = DependencyScope.COMPILATION_ONLY,
            group = "org.jetbrains",
            name = "annotations",
            defaultVersion = "26.0.2"
        )
    )

    private val depsPlatform: List<DependencyDescriptor> = listOf()

    fun injectInto(project: Project) {
        project.dependencies.apply {
            depsPlatform.forEach { descriptor ->
                add(descriptor.scope.configurationName, platform(descriptor.toNotation(project)))
            }
            deps.forEach { descriptor ->
                add(descriptor.scope.configurationName, descriptor.toNotation(project))
            }
        }
    }
}
