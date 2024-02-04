plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kapt)
}

android {
    namespace = "apps.forever.mealsguide"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "apps.forever.mealsguide"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = libs.versions.versionCode.get().toInt()
        versionName = libs.versions.versionName.get()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    signingConfigs {
        getByName("debug") {
            keyAlias = "mg_debug"
            keyPassword = "mg@20240204!"
            storeFile = file("../keys/mg_debug.jks")
            storePassword = "mg@20240204!"
        }
        create("release") {
            keyAlias = System.getenv("SIGNING_KEY_ALIAS")
            keyPassword = System.getenv("SIGNING_KEY_PASSWORD")
            storeFile = file("../keys/mg_rel.jks")
            storePassword = System.getenv("SIGNING_STORE_PASSWORD")
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            signingConfig = signingConfigs.getByName("release")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            isMinifyEnabled=false
            versionNameSuffix = "-DEBUG"
            signingConfig = signingConfigs.getByName("debug")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = libs.versions.jvmTarget.get()
    }
    buildFeatures {
        dataBinding = true

    }

    android.applicationVariants.all {
        outputs.all {
            if (outputFile != null && outputFile.name.endsWith(".apk")) {
                (this as com.android.build.gradle.internal.api.BaseVariantOutputImpl).outputFileName =
                    outputFileName.replace(
                        "app",
                        "mealsGuide_V_${libs.versions.versionName.get()}(${libs.versions.versionCode.get()})"
                    )
            }
        }
    }
}

/**
 * Dependency versions are defined in the top level build.gradle file. This helps keeping track of
 * all versions in a single place. This improves readability and helps managing project complexity.
 */
dependencies {
    // region kotlin
    implementation(libs.androidx.core.ktx)
    //endregion
    // region ui
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.appcompat)
    implementation(libs.android.material)
    implementation(libs.lottie.animation)
    //endregion
    //region network
    implementation(libs.retrofit.networking)
    implementation(libs.retrofit.gson.converter)
    implementation(libs.retrofit.adapter)
    implementation(libs.retrofit.logging.interceptor)
    //endregion
    //region imaging
    implementation (libs.picaso.imaging)
    //endregion
    //region Di
    implementation(libs.koin.di)
    //endregion
    // region serialisation
    implementation(libs.serialisation)
    //endregion
    //region test
    testImplementation(libs.junit4)
    testImplementation(libs.androidx.test.ext)
    androidTestImplementation(libs.androidx.test.espresso.core)
    //endregion
}