package com.zbsw.ad

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.zbsw.sdk.ad.core.INativeListener
import com.zbsw.sdk.ad.net.bean.NativeAdInfo
import com.zbsw.sdk.ad.uikit.NativeAd
import com.zbsw.sdk.ad.util.Constants
import com.zbsw.sdk.ad.util.image.ImageLoader
import kotlinx.android.synthetic.main.activity_native.*

/**
 * Created by RogerShi on 2019/4/1.
 */
class NativeActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_native)

        var adId = intent.getStringExtra("ID")
        if(adId.isEmpty()){
            adId = "310057"
        }

        val nativeAd = NativeAd(applicationContext,adId,"${Constants.NativeAdType.IMAGE_LEFT.type}")
        nativeAd.loadAd(object : INativeListener {
            override fun onLoadFailed(code: String, msg: String) {
            }

            override fun onLoadSuccess(data: List<NativeAdInfo>) {
                //处理原生广告
            }
        })


        nativeAd.loadAd(object : INativeListener {
            override fun onLoadFailed(code: String, msg: String) {

            }

            override fun onLoadSuccess(data: List<NativeAdInfo>) {

                ImageLoader.showImage(imgNative,data[0].url?:"")
//                data.forEach {
//                    when(it.id){
//                        Constants.MaterialNumber.THUMB_IMAGE.code->{
//                            ImageLoader.showImage(imgInfo,it.url?:"")
//                        }
//                        Constants.MaterialNumber.TITLE.code->{
//                            tvTitle.text = it.text
//                        }
//
//                        Constants.MaterialNumber.DESCRIBE.code->{
//                            tvInfo.text = it.text
//                        }
//                    }
//                }

                nativeAd.onAdShow()
                imgNative.setOnClickListener {
                    nativeAd.onAdClick()
                }

            }

        })

    }
}