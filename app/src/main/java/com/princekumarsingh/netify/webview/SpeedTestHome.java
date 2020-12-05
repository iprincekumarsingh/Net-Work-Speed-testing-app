package com.princekumarsingh.netify.webview;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.princekumarsingh.netify.R;

public class SpeedTestHome extends AppCompatActivity {

    private  ProgressBar progressBar;
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed_test_home);
Toolbar toolbar = findViewById(R.id.sss);
setSupportActionBar(toolbar);


        webView = (WebView) findViewById(R.id.speedtest);


        webView.setWebViewClient( new WebViewClient());

        webView.getSettings().setSupportZoom(false);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url)
            {
                // hide element by class name
                webView.loadUrl("javascript:(function() { " +
                        "document.getElementsByClassName('speedtest-logo')[0].style.display='none'; })()");

                // hide element by id
                webView.loadUrl("javascript:(function() { " +
                        "document.getElementById('your_id').style.display='none';})()");

            }
        });



        webView.loadUrl("https://mpdigisolution.speedtestcustom.com/");

        webView.loadUrl("javascript:(function() { " +
                "document.getElementsByClassName('promo-block')[0].style.display='none'; })()");


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.topside,menu);
        return true;
    }
}