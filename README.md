# flitto-android-multi-build-sample
Sample for Multi-project Builds by using Build Variants

# Why?
There are two projects to support Global(googleplay, naver, etc) and China(360, wandoujia, etc) in same project. And they have lots of dependencies with third-party libraries as well, unfortunately we have to use multidex for [Building Apps with Over 65K Methods](http://developer.android.com/intl/ko/tools/building/multidex.html). So we used [Build variants](http://developer.android.com/intl/ko/tools/building/configuring-gradle.html) to make it works seperate builds which are global and china build.

# Build.gradle
```
apply plugin: 'com.android.application'

android {
    compileSdkVersion 23        // 컴파일 할 sdk 버전
    buildToolsVersion "23.0.2"  // 빌드 툴 버전

    defaultConfig {
        applicationId "com.flitto.android.buildsystemsample"    // 패키지 이름, 앱 아이디
        minSdkVersion 14        // 최소 지원 안드로이드 sdk 버전
        targetSdkVersion 23     // 개발 안드로이드 sdk 버전
        versionCode 1
        versionName "1.0"
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
        debug {
            debuggable true
        }
    }

    productFlavors {
        global {
            versionCode 1
            versionName "1.0-global"
        }
        china {
            versionCode 1
            versionName "1.0-china"
        }
    }
}

dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    testCompile 'junit:junit:4.12'
    compile 'com.android.support:appcompat-v7:23.1.1'
    compile 'com.android.support:design:23.1.1'

    chinaCompile 'com.mcxiaoke.volley:library:1.0.19'
    chinaCompile fileTree(dir: 'src/china/library-china', include: ['*.jar'])

    globalCompile 'com.nostra13.universalimageloader:universal-image-loader:1.9.3'
    globalCompile fileTree(dir: 'src/global/library-global', include: ['*.jar'])
}
```

Written by KimKevin at Flitto, and distributed under MIT license.
