package com.zbsw.ad

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.zbsw.sdk.ad.uikit.BannerAd
import kotlinx.android.synthetic.main.activity_banner.*

/**
 * Created by RogerShi on 2019/4/1.
 */
class BannerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_banner)

        var adId = intent.getStringExtra("ID")
        if(adId.isEmpty()){
            adId = "310045"
        }
        val bannerAd = BannerAd(applicationContext, adId)
        bannerAd.setAdSize(0, flBanner.height)
        flBanner.addView(bannerAd)

    }
}