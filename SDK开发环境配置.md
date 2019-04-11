# SDK开发环境配置

### 1.引入依赖包

 在应用的gradle的dependencies下引入依赖

```
implementation 'com.zbcm.sdk.ad:ad:1.0.0'
```

### 2.Manifest.xml配置

 按如下格式，添加SDK的权限和组件声明

```
 <?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
          ......>
          ......
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
    <uses-permission android:name="android.permission.REQUEST_INSTALL_PACKAGES" />

    <application
          ...... >
          ...... 
        <receiver android:name="com.zbsw.sdk.ad.util.download.DownloadReceiver" >
            <intent-filter>
                <action android:name="android.intent.action.DOWNLOAD_COMPLETE" />
            </intent-filter>
            <intent-filter>
                <action android:name="android.intent.action.PACKAGE_ADDED" />
                <data android:scheme="package" />
            </intent-filter>
        </receiver>
        <activity android:name="com.zbsw.sdk.ad.uikit.adbrowser.AdBrowserActivity"/>
        ...... 
    </application>

</manifest>
```



