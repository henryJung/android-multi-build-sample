# flitto-android-multi-build-sample
This sample project consists of the two build types (debug and release) and two product flvaors as deploy type (global and china) to build multi-projects by using build variants.

# Why?
There are two projects to support Global(googleplay, naver, etc) and China(360, wandoujia, etc) in same project. And they have lots of dependencies with third-party libraries as well, unfortunately we have to use multidex for [Building Apps with Over 65K Methods](http://developer.android.com/intl/ko/tools/building/multidex.html). So we used [Build variants](http://developer.android.com/intl/ko/tools/building/configuring-gradle.html) to make it works seperate builds which are global and china build.

# Build.gradle
```
...

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

...
```

# Ref
* [Build System Overview](http://developer.android.com/intl/ko/sdk/installing/studio-build.html)
* [Configuring Gradle Builds](http://developer.android.com/intl/ko/tools/building/configuring-gradle.html)
* [Build System Concepts](http://tools.android.com/tech-docs/new-build-system/build-system-concepts)
* [Multi-project Builds](https://docs.gradle.org/current/userguide/multi_project_builds.html)

Written by KimKevin at Flitto
