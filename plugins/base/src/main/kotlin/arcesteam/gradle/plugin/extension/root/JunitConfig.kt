/*
 * Copyright (c) 2025 ArcesTeam. All rights reserved.
 * This project is licensed under the MIT License. See the LICENSE file for details.
 * This software is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the MIT License for more details.
 *
 */

package arcesteam.gradle.plugin.extension.root

/**
 * JUnit 配置扩展类，用于配置 JUnit 测试相关的设置。
 *
 * 该配置默认使用 JUnit 平台来进行相关配置
 *
 * @property enabled 是否启用该配置，默认为 false。
 * @property version JUnit 平台版本，默认为 "5.12.2"。
 */
open class JunitConfig {

    /**
     * 默认不启用该配置
     */
    var enabled: Boolean = false

    /**
     * JUnit 平台版本，默认为 "5.12.2"。
     */
    var version: String = "5.12.2"
}
