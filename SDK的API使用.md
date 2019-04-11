# SDK的API使用

1. 在应用Application里初始化SDK

   ```
    override fun onCreate() {
           super.onCreate()
           SDKManager.instance.init(this,"XXX", AdSdkConfig())
       }
   ```

2. 获取SDK版本号

   ```
   SDKManager.instance.version()
   ```

3. 横幅广告

   ```
    val bannerAd = BannerAd(applicationContext, adId)
    bannerAd.setAdSize(0, container.height)
    container.addView(bannerAd)
   ```

4. 插屏广告

   插屏广告有一下两种加载方法

   * 实时展示

     ```
      val interstitialAd = InterstitialAd(applicationContext, adId, width, height)
      container.addView(interstitialAd)
     ```

   * 加载完成后展示

   ```
   //创建插屏广告
   val interstitialAd = InterstitialAd(context, adId, width, height)
   //加载插屏广告
   interstitialAd.loadAd(object : IAdListener {
       override fun onAdLoadSuccess() {
       //展示广告弹窗
       ......
   }
       override fun onAdClick() {}
       override fun onAdLoadFailure(code: String, msg: String) {}
   })
   ```

5. 开屏广告

   ```
   val ad = SplashAd(applicationContext, adId, width, height)
           ad.setAdListener(object : IAdListener {
               override fun onAdLoadFailure(code: String, msg: String) {
               }
               override fun onAdLoadSuccess() {
                   container.addView(ad)
               }
               override fun onAdClick() {
               }
           })
           ad.loadAd()
   ```

6. 原生广告

   ```
    val nativeAd = NativeAd(applicationContext,adId,nativeAdTypes)
           nativeAd.loadAd(object : INativeListener {
               override fun onLoadFailed(code: String, msg: String) {
               }
   
               override fun onLoadSuccess(data: List<NativeAdInfo>) {
                   //处理原生广告
               }
           })
   ```

   