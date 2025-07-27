
package com.hady.build_logic

/**
 * This is shared between :app and :benchmarks module to provide configurations type safety.
 */
enum class HLauncherBuildType(val applicationIdSuffix: String? = null) {
    DEBUG(".debug"),
    RELEASE,
}
