/*
 * Copyright (c) 2025 ArcesTeam. All rights reserved.
 * This project is licensed under the MIT License. See the LICENSE file for details.
 * This software is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the MIT License for more details.
 *
 */

package arcesteam.gradle.plugin.deps

/**
 * 表示一个 Gradle 依赖的作用域（例如 implementation、api 等）
 */
enum class DependencyScope(
    val configurationName: String,
    val isTest: Boolean = false,
    val isCompilation: Boolean = false,
    val isRuntime: Boolean = false
) {

    /**
     * 实现依赖，编译时需要，但不暴露给使用该模块的其他模块。
     */
    IMPLEMENTATION("implementation"),

    /**
     * API 依赖，编译时需要，并且会暴露给使用该模块的其他模块。
     */
    API("api"),

    /**
     * 编译时依赖，仅在编译时需要，但不包含在运行时。
     */
    COMPILATION_ONLY("compileOnly", isCompilation = true),

    /**
     * 运行时依赖，仅在运行时需要，但不包含在编译时。
     */
    RUNTIME_ONLY("runtimeOnly", isRuntime = true),

    /**
     * 测试依赖，仅在测试编译和运行时需要。
     */
    TEST_IMPLEMENTATION("testImplementation", isTest = true),

    /**
     * 测试 API 依赖，仅在测试编译和运行时需要，并且会暴露给使用该模块的其他测试。
     */
    TEST_API("testApi", isTest = true),

    /**
     * 测试编译时依赖，仅在测试编译时需要，但不包含在运行时。
     */
    TEST_COMPILE_ONLY("testCompileOnly", isTest = true, isCompilation = true),

    /**
     * 测试运行时依赖，仅在测试运行时需要，但不包含在测试编译时。
     */
    TEST_RUNTIME_ONLY("testRuntimeOnly", isTest = true, isRuntime = true),
}
