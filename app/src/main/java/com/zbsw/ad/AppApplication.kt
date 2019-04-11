package com.zbsw.ad

import android.app.Application
import com.zbsw.sdk.ad.manager.AdSdkConfig
import com.zbsw.sdk.ad.manager.SDKManager

/**
 * Created by RogerShi on 2019/3/22.
 */
class AppApplication:Application() {

    override fun onCreate() {
        super.onCreate()
        SDKManager.instance.init(this,"b110e14bd", AdSdkConfig())
    }
}