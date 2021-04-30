package com.hili.mp.demo.server

import android.app.Application
import com.hili.sdk.mp.imgloader.glide.GlideImageLoader
import com.hili.sdk.mp.server.component.MiniComponentManager

/**
 * Create by sorosunrain on 2021/04/30 14:42
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        MiniComponentManager.get().registerModule(GlideImageLoader())
    }

}