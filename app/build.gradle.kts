plugins {
    id(Dependencies.BuildPlugin.androidApplication)
    id(Dependencies.BuildPlugin.kotlin)
    id(Dependencies.Libraries.hiltPlugin)
    kotlin("kapt")


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
//    signingConfigs {
//        create("config") {
//            storeFile = file("../app/obelab-keystore.jks")
//            storePassword = "Obelab2)@2"
//            keyPassword = "Obelab2)@2"
//            keyAlias = "obelab-alias"
//        }
//    }


    buildTypes {
        getByName(Config.BuildType.DEBUG) {
            isMinifyEnabled = false
            isDebuggable = true
        //    signingConfig = signingConfigs["config"]
          //  buildConfigField("boolean",Config.Default.ENABLE_CRASH, "false")
        }
        getByName(Config.BuildType.RELEASE) {
            isMinifyEnabled = false
            isDebuggable = false
            isShrinkResources = false
      //      buildConfigField("boolean", Default.ENABLE_CRASH, "true")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        //    signingConfig = signingConfigs["config"]
        }
    }
    flavorDimensions.add(Config.FlavorDimensions.DEFAULT)


    productFlavors{
        create(Config.ProductFlavors.DEV){
            dimension = Config.FlavorDimensions.DEFAULT
            applicationIdSuffix = ".${Config.ProductFlavors.DEV}"
            versionNameSuffix = "-${Config.ProductFlavors.DEV}"
            buildConfigField("String", Config.Default.BASE_URL, "\"${Config.Default.BASE_URL_DEV}\"")
        }
        create(Config.ProductFlavors.PUBLIC) {
            dimension = Config.FlavorDimensions.DEFAULT
            buildConfigField("String", Config.Default.BASE_URL, "\"${Config.Default.BASE_URL_PROD}\"")
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
    implementation(Dependencies.Libraries.constraintlayoutCompose)
    implementation(Dependencies.Libraries.navigationUI)
    implementation(Dependencies.Libraries.navigationFragment)
    implementation(Dependencies.Libraries.navigationCompose)
    implementation(Dependencies.Libraries.retrofit)
    implementation(Dependencies.Libraries.retrofitConverter)
    implementation(Dependencies.Libraries.gSon)
    implementation(Dependencies.Libraries.viewModel)
    implementation(Dependencies.Libraries.viewModelCompose)
    implementation(Dependencies.Libraries.liveData)
    implementation(Dependencies.Libraries.viewModelState)
    implementation(Dependencies.Libraries.okhttp3)
    implementation(Dependencies.Libraries.okhttp3Logging)

    // hilt
    kapt (Dependencies.Libraries.hiltComplier)
    kapt (Dependencies.Libraries.lifeCycleProcessor)
    implementation (Dependencies.Libraries.hilt)


    //test
    testImplementation(Dependencies.Libraries.jUnit)
    androidTestImplementation(Dependencies.Libraries.jUnitExt)
    androidTestImplementation(Dependencies.Libraries.espresso)
    androidTestImplementation(Dependencies.Libraries.composeTest)

}
kapt {
    correctErrorTypes = true
}


