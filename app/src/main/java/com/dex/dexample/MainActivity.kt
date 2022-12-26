package com.dex.dexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val myWeb = findViewById<WebView>(R.id.wb_webView)

        //if(myWeb.canGoBack()) myWeb.goBack() else super.onBackPressed()

        myWeb.apply {
            loadUrl("https://mobile.twitter.com/")
            settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled = true
            settings.cacheMode = WebSettings.LOAD_NO_CACHE

        }


        myWeb.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                // Handle any URL that you want to stay within the app
                view.loadUrl("https://mobile.twitter.com/")
                return true
            }
        }
    }

    override fun onBackPressed() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Are you sure you want to exit?")
            .setCancelable(false)
            .setPositiveButton("Yes") { _, _ ->
                // Finish the activity
                finish()
            }
            .setNegativeButton("No") { dialog, _ ->
                // Close the dialog
                dialog.cancel()
            }
        val alert = builder.create()
        alert.show()
    }

/*    override fun onBackPressed() {
        // Get a reference to the WebView
        val myWeb = findViewById<WebView>(R.id.wb_webView)

        // If the WebView can go back, go back to the previous page
        if (myWeb.canGoBack()) {
            myWeb.goBack()
        } else {
            // Otherwise, finish the activity
            super.onBackPressed()
        }
    }*/
}
