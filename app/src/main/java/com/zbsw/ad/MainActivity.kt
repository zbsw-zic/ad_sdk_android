package com.zbsw.ad

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnBanner.setOnClickListener {
            val intent = Intent(applicationContext, BannerActivity::class.java)
            intent.putExtra("ID", etBanner.text.toString())
            startActivity(intent)
        }


        btnInter.setOnClickListener {
            InterstitialDialog.showAd(applicationContext, supportFragmentManager, etInter.text.toString())
        }


        btnNative.setOnClickListener {
            val intent = Intent(applicationContext, NativeActivity::class.java)
            intent.putExtra("ID", etNative.text.toString())
            startActivity(intent)
        }


        btnSplash.setOnClickListener {
            val intent = Intent(applicationContext, SplashActivity::class.java)
            intent.putExtra("ID", etSplash.text.toString())
            startActivity(intent)
        }
    }
}
