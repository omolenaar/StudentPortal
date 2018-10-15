package com.example.olgam.studentportal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

import java.net.URL;
import java.util.List;
import java.util.regex.Pattern;

public class AddPortal extends AppCompatActivity {

    private static final String Tag = "TAG";
    EditText mNewPortalText;
    EditText mNewPortalLink;
    String input;

//    private PortalAdapter mAdapter;
//    private List<Portal> mPortals;

 /*   public static boolean checkURL(CharSequence input) {
        if (TextUtils.isEmpty(input)) {
            return false;
        }
        Pattern URL_PATTERN = Patterns.WEB_URL;
        boolean isURL = URL_PATTERN.matcher(input).matches();
        if (!isURL) {
            String urlString = input + "";
            if (URLUtil.isNetworkUrl(urlString)) {
                try {
                    new URL(urlString);
                    isURL = true;
                } catch (Exception e) {
                }
            }
        }
        return isURL;
    }
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_portal);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        //Initialize the local vars
        mNewPortalText = findViewById(R.id.editPortalName);
        mNewPortalLink = findViewById(R.id.editPortalLink);
        Log.e(Tag, "Text = "+mNewPortalText+" Link = "+mNewPortalLink);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Inputs
                String nameText = mNewPortalText.getText().toString();
                String linkText = mNewPortalLink.getText().toString();
                Log.e(Tag, "Text = "+nameText+" Link = "+linkText);

                    //Portal newPortal= new Portal(nameText, linkText);
                    if (!(TextUtils.isEmpty(nameText))) {
                        Log.e(Tag, "now in OnClick, sending text and link back ");
                        mNewPortalText.setText("");
                        mNewPortalLink.setText("");
                        //Return to startscreen
                        Intent result = new Intent();
                        Bundle extras = new Bundle();
                        extras.putString("Name", nameText);
                        extras.putString("Link", linkText);
                        result.putExtras(extras);
                        setResult(Activity.RESULT_OK, result);
                        finish();

                    } else {
                        Snackbar.make(view, "To do", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                }
            });
    }


}

