plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = 32
    defaultConfig {
        applicationId = "com.brickmate.houserepairingcompose"
        minSdk = 26
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.Libraries.Version.composeVersion
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
//    val compose_version ="1.2.0-beta02"
//    val system_ui_version ="0.24.9-beta"
//    val nav_version = "2.4.2"

    implementation(Dependencies.Libraries.androidCore)
    implementation(Dependencies.Libraries.composeUI)
    implementation(Dependencies.Libraries.material)
    implementation(Dependencies.Libraries.composePreview)
    implementation(Dependencies.Libraries.runtimeKTX)
    implementation(Dependencies.Libraries.activityCompose)
    implementation(Dependencies.Libraries.systemUI)
    implementation(Dependencies.Libraries.splashScreen)
    implementation(Dependencies.Libraries.appCompat)

    implementation(Dependencies.Libraries.composeUITest)
    implementation(Dependencies.Libraries.composeTestManifest)
    implementation(Dependencies.Libraries.constraintlayout)
    implementation(Dependencies.Libraries.constraintlayoutCompose)
    implementation(Dependencies.Libraries.navigationUI)
    implementation(Dependencies.Libraries.navigationFragment)
    implementation(Dependencies.Libraries.navigationCompose)


    //test
    testImplementation(Dependencies.Libraries.jUnit)
    androidTestImplementation(Dependencies.Libraries.jUnitExt)
    androidTestImplementation(Dependencies.Libraries.espresso)
    androidTestImplementation(Dependencies.Libraries.composeTest)


}

private object BuildType {
    const val DEBUG = "debug"
    const val RELEASE = "release"
}

private object ProductFlavors {
    const val DEV = "dev"
    const val INTERNAL = "internal"
    const val PUBLIC = "public"
}


private object FlavorDimensions {
    const val DEFAULT = "default"
}

private object Default {
    const val buildType = BuildType.DEBUG
    const val buildFlavor = ProductFlavors.DEV
    const val ENABLE_CRASH = "ENABLE_CRASH"
    const val BASE_URL = "BASE_URL"
    const val BASE_URL_DEV = "https://api-houserp.brickmate.kr/api/"
    const val BASE_URL_PROD = "https://api-houserp.brickmate.kr/api/"
    val BUILD_VARIANT = "${buildFlavor.capitalize()}${buildType.capitalize()}"

}

