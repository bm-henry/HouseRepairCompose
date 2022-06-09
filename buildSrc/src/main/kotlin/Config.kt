import java.util.*

object Config {
     object BuildType {
        const val DEBUG = "debug"
        const val RELEASE = "release"
    }

     object ProductFlavors {
        const val DEV = "dev"
        const val INTERNAL = "internal"
        const val PUBLIC = "public"
    }


     object FlavorDimensions {
        const val DEFAULT = "default"
    }

     object Default {
        const val buildType = BuildType.DEBUG
        const val buildFlavor = ProductFlavors.DEV
        const val ENABLE_CRASH = "ENABLE_CRASH"
        const val BASE_URL = "BASE_URL"
        const val BASE_URL_DEV = "https://api-houserp.brickmate.kr/api/"
        const val BASE_URL_PROD = "https://api-houserp.brickmate.kr/api/"
        val BUILD_VARIANT = "${buildFlavor.capitalize(Locale.ROOT)}${buildType.capitalize(Locale.ROOT)}"

     }
}

