package com.example.olgam.studentportal;

import android.app.Activity;
import android.content.Intent;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;

import static android.util.Log.*;

public class WebviewActivity extends AppCompatActivity {

    private static final String Tag = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        WebView myWebView = (WebView) findViewById(R.id.webview);

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
    };


}

