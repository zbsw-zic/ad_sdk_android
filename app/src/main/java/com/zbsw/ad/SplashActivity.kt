package com.zbsw.ad

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.zbsw.sdk.ad.core.IAdListener
import com.zbsw.sdk.ad.uikit.SplashAd
import kotlinx.android.synthetic.main.activity_splash.*

/**
 * Created by RogerShi on 2019/4/1.
 */
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        var adId = intent.getStringExtra("ID")
        if (adId.isEmpty()) {
            adId = "310092"
        }

        val ad = SplashAd(applicationContext, adId, flAd.width, flAd.height)
        ad.setAdListener(object : IAdListener {
            override fun onAdLoadFailure(code: String, msg: String) {
            }

            override fun onAdLoadSuccess() {
                flAd.addView(ad)
            }

            override fun onAdClick() {
            }

        })
        ad.loadAd()

        btnNext.setOnClickListener {
            finish()
        }
    }
}