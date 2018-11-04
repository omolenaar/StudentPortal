package com.example.olgam.studentportal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class AddPortal extends AppCompatActivity {

    private static final String Tag = "TAG";
    private EditText mNewPortalText;
    private EditText mNewPortalLink;
    String input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_portal);

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
                    if (!(nameText.equals(""))) {
                        Log.e(Tag, "now in OnClick, sending text and link back ");
                        mNewPortalText.setText("");
                        mNewPortalLink.setText("");
                        //Return to startScreen
                        Intent result = new Intent();
                        Bundle extras = new Bundle();
                        extras.putString("Name", nameText);
                        extras.putString("Link", linkText);
                        result.putExtras(extras);
                        setResult(Activity.RESULT_OK, result);
                        finish();

                    } else {
                        feedbackInvalidUrl();
                        Intent result = null;
                        setResult(Activity.RESULT_CANCELED, null);
                        finish();
                    }
                }
            });
    }
    private void feedbackInvalidUrl() {
        Toast invalidUrl = Toast.makeText(this, "empty portal, nothing added", Toast.LENGTH_LONG);
        invalidUrl.show();
    }
}

