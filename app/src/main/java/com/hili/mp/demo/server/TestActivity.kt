package com.hili.mp.demo.server

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.Window
import com.hili.sdk.mp.server.browser.EsData
import com.hili.sdk.mp.server.browser.EsManager


/**
 * Create by WeiPeng on 2021/04/13 19:32
 */
class TestActivity : Activity() {

    companion object {
        private const val ES_PKG = "es.com.hili.mp.demo.client"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_NO_TITLE)
        super.setContentView(R.layout.activity_test)

        EsManager.get().showDebugView(this, Gravity.RIGHT)
    }

    fun startEsApp(view: View) {
        EsManager.get().start(
            EsData()
                .setAppPackage(ES_PKG)
                .setArgs(
                    """
                {
                  "store": {
                    "book": [
                      {
                        "category": "reference",
                        "sold": false,
                        "author": "Nigel Rees",
                        "title": "Sayings of the Century",
                        "price": 8.95
                      }
                    ],
                    "bicycle": {
                      "color": "red",
                      "price": 19.95
                    }
                  }
                }
            """.trimIndent()
                )
        )
    }

    fun startWithIntent(view: View) {  // 模拟其它apk调起esApp的方式一

        startActivity(Intent().apply {
            action = "$packageName.ES_ACTION_LAUNCH"
            putExtra("es_pkg", ES_PKG)
            putExtra("es_args", "12345") // 非必须
            putExtra("light", true) // 非必须
        })

    }

    fun startWithScheme(view: View) {  // 模拟其它apk调起esApp的方式二
        startActivity(Intent().apply {
            setPackage(packageName)
            data = Uri.parse("extendscreen://action/skip?es_pkg=$ES_PKG&light=true")
        })
    }

}