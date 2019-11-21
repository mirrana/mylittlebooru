//buildscript {
//    ext.kotlin_version = '1.3.31'
//    repositories {
//        google()
//        jcenter()
//    }
//    dependencies {
//        classpath 'com.android.tools.build:gradle:3.4.1'
//        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
//    }
//}
//
//apply plugin: 'com.android.application'
//apply plugin: 'kotlin-android'
//apply plugin: 'kotlin-android-extensions'
//
//android {
//    compileSdkVersion 28
//    defaultConfig {
//        applicationId "com.abopu.booru"
//        minSdkVersion 28
//        targetSdkVersion 28
//        versionCode 1
//        versionName "1.0"
//        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
//    }
//    buildTypes {
//        release {
//            minifyEnabled false
//            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
//        }
//    }
//}
//
//repositories {
//    google()
//    jcenter()
//}
//
//dependencies {
//    implementation fileTree(dir: 'libs', include: ['*.jar'])
//    implementation"org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
//    implementation 'com.android.support:appcompat-v7:28.0.0'
//    implementation 'com.android.support.constraint:constraint-layout:1.1.3'
//    testImplementation 'junit:junit:4.12'
//    androidTestImplementation 'com.android.support.test:runner:1.0.2'
//    androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.2'
//}
