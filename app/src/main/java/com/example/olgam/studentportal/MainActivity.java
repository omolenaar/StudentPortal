package com.example.olgam.studentportal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


import java.util.ArrayList;
import java.util.List;

import static com.example.olgam.studentportal.PortalAdapter.*;

public class MainActivity extends AppCompatActivity implements PortalClickListener {

    //private EditText mNewPortalText;
    //private EditText mNewPortalLink;
    private PortalAdapter mAdapter;
    private List<Portal> mPortals;
    private RecyclerView mPortalRecyclerView;
    private static final String Tag = "TAG";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        EditText mNewPortalText = findViewById(R.id.editPortalName);
        EditText mNewPortalLink = findViewById(R.id.editPortalLink);
        mPortals = new ArrayList<>();

        mPortalRecyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getParent(), 3);
        ((GridLayoutManager) mLayoutManager).setSpanCount(3);

        mPortalRecyclerView.setLayoutManager(mLayoutManager);
        final PortalAdapter mAdapter = new PortalAdapter(mPortals, this);

        mPortalRecyclerView.setAdapter(mAdapter);
        for (int i = 0; i < Portal.PRE_DEFINED_PORTAL_NAMES.length; i++) {
            mPortals.add(new Portal(Portal.PRE_DEFINED_PORTAL_NAMES[i],
                    Portal.PRE_DEFINED_PORTAL_LINKS[i]));
        }

        //CRUD: Create new portal
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddPortal.class);
                startActivityForResult(intent, 1234);
            }
        });
    }

    //Open and view link defined as portal in new activity
    public void portalOnClick(int i) {
        if (mPortals == null)
            Log.e(Tag, "mPortals is null!!");
        Intent intent = new Intent(MainActivity.this, WebviewActivity.class);
        String myUrl = mPortals.get(i).getmLink();
        intent.putExtra("myUrl", myUrl);
        startActivity(intent);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent result) {
        if (resultCode == Activity.RESULT_OK) {
            //Check if the request code is correct
            if (requestCode == 1234) {
                Bundle extras = result.getExtras();
                String newPortalName = extras.getString("Name");
                String newPortalLink = extras.getString("Link");
                Portal newPortal = new Portal(newPortalName, newPortalLink);
                mPortals.add(newPortal);
                updateUI();
            }
        }
    }

    private void updateUI() {
        if (mAdapter == null) {
            Log.e(Tag, "mAdapter was null, creating new PortalAdapter");
            mAdapter = new PortalAdapter(mPortals, this);
            Log.e(Tag, "new PortalAdapter with Portals: " + mPortals);
            mPortalRecyclerView.setAdapter(mAdapter);
        } else {
            Log.e(Tag, "notifyDataSetChanged");
            mAdapter.notifyDataSetChanged();
        }
    }
    //MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

