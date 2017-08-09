package com.esports.vishal.esportsscoreapplication.LOL;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.esports.vishal.esportsscoreapplication.R;

import org.json.JSONException;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class LolScoreActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ProgressBar loading;
    private SwipeRefreshLayout swipeContainer;
    private RecyclerView recyclerView;
    public RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<LolItem> lolItemArrayList;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lol_score);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        lolItemArrayList = new ArrayList<LolItem>();

        loading = (ProgressBar) findViewById(R.id.progressBar);
        //    recyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(this).build());
        adapter = new LolAdapter(lolItemArrayList);
        layoutManager = new LinearLayoutManager(this);
        // button = (Button) findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                FragmentManager fm = getSupportFragmentManager();
//
//                DateFragmenter frag = new DateFragmenter();
//
//                frag.show(fm, "select a date ");
//            }
//        });

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        fetchURL();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);




    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.lol_score, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void fetchURL(){
        LolScoreActivity.LolDataFetchTask lolDataFetchTask = new LolScoreActivity.LolDataFetchTask();
        LolNetworkUtility lolNetworkUtility = new LolNetworkUtility();
        URL url = lolNetworkUtility.makeURL();
        lolDataFetchTask.execute(url);
    }


    class LolDataFetchTask extends AsyncTask<URL,Void,ArrayList<LolItem>>
    {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loading.setVisibility(View.VISIBLE);
        }

        @Override
        protected ArrayList<LolItem> doInBackground(URL... params) {

            URL url = LolNetworkUtility.makeURL();

            try {

                String json = LolNetworkUtility.getResponseFromHttpUrl(url);
                lolItemArrayList = LolNetworkUtility.parseJSON(json);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return lolItemArrayList;
        }

        @Override
        protected void onPostExecute(final ArrayList<LolItem> lolItemArrayList) {
            loading.setVisibility(View.GONE);

            super.onPostExecute(lolItemArrayList);
            adapter.notifyDataSetChanged();

            if (lolItemArrayList != null)
            {
                LolAdapter adapter = new LolAdapter(lolItemArrayList, new LolAdapter.ItemClickListener() {
                    @Override
                    public void onItemClick(int clickedItemIndex) {

                    }
                });

                recyclerView.setAdapter(adapter);
            }
        }
    }
}