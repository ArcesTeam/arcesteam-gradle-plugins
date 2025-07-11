/*
 * Copyright (c) 2025 ArcesTeam. All rights reserved.
 * This project is licensed under the MIT License. See the LICENSE file for details.
 * This software is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the MIT License for more details.
 *
 */

rootProject.name = "arcesteam-gradle-plugins"

file("plugins").listFiles()?.forEach { file ->
    if (file.isDirectory) {
        include("plugins:${file.name}")
    }
}
