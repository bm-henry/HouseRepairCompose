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
            const val hiltVersion = "2.38.1"
            const val retrofitVersion ="2.9.0"
            const val coroutineVersion ="1.3.9"
            const val lifecycleVersion ="2.5.0-rc01"
            const val okhttp3Version = "3.14.9"

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
        const val constraintlayoutCompose = "androidx.constraintlayout:constraintlayout:${Version.constraintlayoutComposeVersion}"
        const val navigationFragment ="androidx.navigation:navigation-fragment:${Version.navVersion}"
        const val navigationUI ="androidx.navigation:navigation-fragment:${Version.navVersion}"
        const val navigationCompose ="androidx.navigation:navigation-fragment:${Version.navVersion}"
        const val hiltPlugin  = "dagger.hilt.android.plugin"
        const val safeArgs  = "androidx.navigation.safeargs"
        const val safeArgsKotlin  = "androidx.navigation.safeargs.kotlin"
        const val hilt = "com.google.dagger:hilt-android:${Version.hiltVersion}"
        const val hiltComplier = "com.google.dagger:hilt-android-compiler:${Version.hiltVersion}"

        const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofitVersion}"
        const val retrofitConverter = "com.squareup.retrofit2:converter-gson:${Version.retrofitVersion}"
        const val gSon = "com.google.code.gson:gson:${Version.retrofitVersion}"

        const val okhttp3 ="com.squareup.okhttp3:okhttp:${Version.okhttp3Version}"
        const val okhttp3Logging ="com.squareup.okhttp3:logging-interceptor:${Version.okhttp3Version}"


        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutineVersion}"

        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifecycleVersion}"
        const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:${Version.lifecycleVersion}"
        const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.lifecycleVersion}"
        const val viewModelState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Version.lifecycleVersion}"
        const val lifeCycleProcessor = "androidx.lifecycle:lifecycle-compiler:${Version.lifecycleVersion}"


        // To use constraintlayout in compose

    }


}