/*
 * Copyright (c) 2025 ArcesTeam. All rights reserved.
 * This project is licensed under the MIT License. See the LICENSE file for details.
 * This software is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the MIT License for more details.
 *
 */

package arcesteam.gradle.plugin.deps

import org.gradle.api.Project

data class DependencyDescriptor(
    val scope: DependencyScope,
    val group: String,
    val name: String,
    val defaultVersion: String = "",
    val key: String = "$group:$name",
    val isPlatform: Boolean = false
) {
    fun toNotation(project: Project): String {

        if (defaultVersion.isEmpty()) {
            return "$group:$name"
        }

        if (isPlatform) {
            return "$group:$name:$defaultVersion"
        }

        val versionOverride = project.findProperty(key) as? String
            ?: project.findProperty(name)
            ?: defaultVersion

        return "$group:$name:$versionOverride"
    }
}
