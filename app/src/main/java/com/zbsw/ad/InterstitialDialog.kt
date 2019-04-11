package com.zbsw.ad

import android.content.Context
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.FragmentManager
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zbsw.sdk.ad.core.IAdListener
import com.zbsw.sdk.ad.uikit.InterstitialAd
import com.zbsw.sdk.ad.util.DeviceUtil
import kotlinx.android.synthetic.main.layout_interstitial.*

/**
 * Created by RogerShi on 2019/4/1.
 */
class InterstitialDialog : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NO_FRAME, R.style.dialog)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.layout_interstitial, container)
    }

    var interstitialAd: InterstitialAd? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        interstitialAd?.let {
            flAd.addView(it)
        }
        imgClose.setOnClickListener {
            dismissAllowingStateLoss()
        }

    }

    companion object {
        fun showAd(context: Context, fragmentManager: FragmentManager, adId: String) {
            //创建插屏广告
            val interstitialAd = InterstitialAd(
                context, if (adId.isEmpty()) "310041" else adId,
                DeviceUtil.dip2px(context, 300f), DeviceUtil.dip2px(context, 350f)
            )
            //加载插屏广告
            interstitialAd.loadAd(object : IAdListener {
                override fun onAdLoadSuccess() {
                    //展示广告弹窗
                    val dialog = InterstitialDialog()
                    dialog.interstitialAd = interstitialAd
                    dialog.show(fragmentManager, "InterstitialDialog")
                }

                override fun onAdClick() {
                }

                override fun onAdLoadFailure(code: String, msg: String) {
                }
            })
        }
    }


    override fun onStart() {
        super.onStart()
        if (null == dialog) return
        val window = dialog.window
        window.setGravity(Gravity.CENTER)
    }

}