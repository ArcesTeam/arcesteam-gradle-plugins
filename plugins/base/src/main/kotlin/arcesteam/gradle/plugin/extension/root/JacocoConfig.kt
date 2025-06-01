/*
 * Copyright (c) 2025 ArcesTeam. All rights reserved.
 * This project is licensed under the MIT License. See the LICENSE file for details.
 * This software is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the MIT License for more details.
 *
 */

package arcesteam.gradle.plugin.extension.root

/**
 * Jacoco 配置扩展类，用于配置 Jacoco 测试覆盖率相关的设置。
 */
open class JacocoConfig {

    /**
     * 默认不启用该配置
     */
    var enabled: Boolean = false

    /**
     * 排除的项目列表
     */
    var excludeProjects: MutableList<String> = mutableListOf()

    /**
     * 添加要排除的项目名称。
     *
     * @param names 要排除的项目名称列表。
     */
    fun exclude(vararg names: String) {
        excludeProjects.addAll(names)
    }
}
