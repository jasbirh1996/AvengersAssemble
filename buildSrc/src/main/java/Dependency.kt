object UI {
    val material by lazy { "com.android.tools.build:gradle:${Versions.MATERIAL}" }
    val constraintLayout by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.CONSTRAINTS}" }
    val glide by lazy{"com.github.bumptech.glide:glide:${Versions.glide}"}

}
object DI{

    val daggerHilt by lazy { "com.google.dagger:hilt-android:${Versions.ANDROID_HILT}" }
    val hiltCompiler by lazy { "com.google.dagger:hilt-compiler:${Versions.HILT_COMPILER}" }
    val hiltGradlePlugin by lazy { "com.google.dagger:hilt-android-gradle-plugin:${Versions.ANDROID_HILT}" }
    val hiltNavigation by lazy { "androidx.hilt:hilt-navigation-fragment:${Versions.HILT_ANDROIDX}" }
    val androidXHiltCompiler by lazy { "androidx.hilt:hilt-compiler:${Versions.HILT_ANDROIDX}" }
    val fragmentktx by lazy { "androidx.fragment:fragment-ktx:${Versions.FRAGMENT_KTX}" }


}

object Kotlin {
    val livedata by lazy { "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIVEDATA}" }
    val viewmodel by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.VIEWMODEL}" }
    val runtimeKtx by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.RUNTIME_KTX}" }
    val kotlinStdLib by lazy { "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN_VERSION}" }


}

object Network {
    val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}" }
    val gsonConvertor by lazy { "com.squareup.retrofit2:converter-gson:${Versions.GSON_CONVERTOR}" }
    val okHttp3 by lazy { "com.squareup.okhttp3:okhttp:${Versions.OKHTTP}" }
    val loggingInterceptor by lazy { "com.squareup.okhttp3:logging-interceptor:${Versions.INTERCEPTOR}" }


}

object Persistence {
    val room  by lazy {"androidx.room:room-runtime:${Versions.room}"}
    val roomCompiler  by lazy {"androidx.room:room-compiler:${Versions.room}"}
    val roomKtx  by lazy {"androidx.room:room-ktx:${Versions.room}"}
}
object Navigation{
    val navigation  by lazy {"androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"}
    val navigationUi  by lazy {"androidx.navigation:navigation-ui-ktx:${Versions.navigation}"}
    val navigationDynamicFeature  by lazy {"androidx.navigation:navigation-dynamic-features-fragment:${Versions.navigation}"}
    val safeArgs  by lazy {"androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"}
}
object Room {

}

object Testing {

}

object Others{
    val timber by lazy {"com.jakewharton.timber:timber:${Versions.timber}"}
}

object Paging{
    val paging by lazy {"androidx.paging:paging-runtime:${Versions.paging}"}

}