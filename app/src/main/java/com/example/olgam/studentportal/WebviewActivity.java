package com.example.olgam.studentportal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebviewActivity extends AppCompatActivity {

    private static final String Tag = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        WebView myWebView = (WebView) findViewById(R.id.webview);
        //Enable JavaScript
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        myWebView.getSettings().setUseWideViewPort(true);
        //leaving the below line in results in seeing the whole website,
        //but very zoomed out, not sure what is best.
        //myWebView.getSettings().setLoadWithOverviewMode(true);

        //Prevent redirects from opening outside the app
        myWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });

        //Obtain the parameters provided by MainActivity
        Intent getIntent = getIntent();
        String toLoadString = getIntent.getStringExtra("myUrl");
        Log.e(Tag, "toLoadString = "+toLoadString);
        myWebView.loadUrl(toLoadString);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Replace with returning the result
                Intent data = new Intent();

                //Send the result back to the activity
                setResult(Activity.RESULT_OK, data);
                finish();
            }
        });
    }
}

