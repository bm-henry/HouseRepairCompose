object Dependencies {
    object BuildPlugin{
        object Version{
            const val androidApplicationVersion = "7.2.1"
            const val androidLibVersion = "7.2.1"
            const val kotlinVersion = "1.6.21"
        }
        const val androidApplication  = "com.android.application"
        const val androidLib = "com.android.library"
        const val kotlin = "org.jetbrains.kotlin.android"
    }
    object Libraries{
        object Version {
            const val coreKtxVersion = "1.7.0"
            const val composeVersion = "1.2.0-beta02"
            const val runtimeKtxVersion= "2.3.1"
            const val activityComposeVersion= "1.3.1"
            const val systemUiVersion = "0.24.9-beta"
            const val splashScreenVersion ="1.0.0-rc01"
            const val navVersion = "2.4.2"
            const val appCompatVersion = "1.4.2"
            const val jUnitVersion = "4.13.2"
            const val jUnitVersionExt = "1.1.3"
            const val espresso = "3.4.0"
            const val constraintlayoutVersion = "2.1.4"
            const val constraintlayoutComposeVersion = "2.1.4"

        }
        const val androidCore = "androidx.core:core-ktx:${Version.coreKtxVersion}"
        const val composeUI = "androidx.compose.ui:ui:${Version.composeVersion}"
        const val material = "androidx.compose.material:material:${Version.composeVersion}"
        const val composePreview = "androidx.compose.ui:ui-tooling-preview:${Version.composeVersion}"
        const val runtimeKTX = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.runtimeKtxVersion}"
        const val activityCompose ="androidx.activity:activity-compose:${Version.activityComposeVersion}"
        const val systemUI ="com.google.accompanist:accompanist-systemuicontroller:${Version.systemUiVersion}"
        const val splashScreen ="androidx.core:core-splashscreen:${Version.splashScreenVersion}"
        const val appCompat ="androidx.appcompat:appcompat:${Version.appCompatVersion}"
        const val jUnit = "junit:junit:${Version.jUnitVersion}"
        const val jUnitExt = "androidx.test.ext:junit:${Version.jUnitVersionExt}"
        const val espresso = "androidx.test.espresso:espresso-core:${Version.espresso}"
        const val composeTest = "androidx.compose.ui:ui-test-junit4:${Version.composeVersion}"
        const val composeUITest = "androidx.compose.ui:ui-tooling:${Version.composeVersion}"
        const val composeTestManifest = "androidx.compose.ui:ui-test-manifest:${Version.composeVersion}"
        const val constraintlayout = "androidx.constraintlayout:constraintlayout:${Version.constraintlayoutVersion}"
        const val constraintlayoutCompose = "androidx.constraintlayout:constraintlayout:${Version.constraintlayoutComposeVersion}"
        const val navigationFragment ="androidx.navigation:navigation-fragment:${Version.navVersion}"
        const val navigationUI ="androidx.navigation:navigation-fragment:${Version.navVersion}"
        const val navigationCompose ="androidx.navigation:navigation-fragment:${Version.navVersion}"

        // To use constraintlayout in compose

    }


}