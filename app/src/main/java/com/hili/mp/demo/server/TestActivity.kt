package com.hili.mp.demo.server

import android.app.Activity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import com.hili.sdk.mp.server.browser.EsData
import com.hili.sdk.mp.server.browser.EsManager
import java.text.SimpleDateFormat


/**
 * Create by WeiPeng on 2021/04/13 19:32
 */
class TestActivity : Activity() {

    companion object {
        private const val ES_ID = "4073571a49b56914234dd4f79fac51eb"
        private const val ES_PKG = "es.com.hili.mp.demo.client"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.setContentView(R.layout.activity_test)

        EsManager.get().showDebugView(this, Gravity.RIGHT)
    }

    fun startEsApp(view: View) {
        EsManager.get().start(EsData().setAppPackage(ES_PKG))
    }

}