package com.esports.vishal.esportsscoreapplication.DOTA2;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
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

import com.esports.vishal.esportsscoreapplication.MainActivity;
import com.esports.vishal.esportsscoreapplication.R;

import org.json.JSONException;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Dota2ScoreActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        DateFragmenter.OnDialogCloseListener{

    private ProgressBar loading;
    private SwipeRefreshLayout swipeContainer;
    private RecyclerView recyclerView;
    public RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Dota2Item> dota2ItemArrayList;
    DateFormat formatDateTime = DateFormat.getDateTimeInstance();
    Calendar date = Calendar.getInstance();

    private  Button button ;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports_score);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dota2ItemArrayList = new ArrayList<Dota2Item>();

        loading = (ProgressBar) findViewById(R.id.progressBar);
        //    recyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(this).build());
        adapter = new Dota2Adapter(dota2ItemArrayList);
        layoutManager = new LinearLayoutManager(this);

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

    public ArrayList<Dota2Item> getDota2ItemArrayList() {
        return dota2ItemArrayList;
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
        getMenuInflater().inflate(R.menu.sports_score, menu);
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

        if (id == R.id.select_home) {
            Intent intent = new Intent(Dota2ScoreActivity.this, MainActivity.class);
            startActivity(intent);
            // Handle the camera action
        } else if (id == R.id.select_date)
        {

            FragmentManager fm = getSupportFragmentManager();
            DateFragmenter fragmenter = new DateFragmenter();
            fragmenter.show(fm,"DateFragmenter");

            //  datePicker = (DatePicker) findViewById(R.id.datePicker);

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    public void fetchURL(){
        Dota2DataFetchTask dota2DataFetchTask = new Dota2DataFetchTask();
        Dota2NetworkUtility dota2NetworkUtility = new Dota2NetworkUtility();
        URL url = dota2NetworkUtility.makeURL();
        dota2DataFetchTask.execute(url);
    }

    @Override
    public void closeDialog(int year, int month, int day) {


    }


    class Dota2DataFetchTask extends AsyncTask<URL,Void,ArrayList<Dota2Item>>
    {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loading.setVisibility(View.VISIBLE);
        }

        @Override
        protected ArrayList<Dota2Item> doInBackground(URL... params) {

            URL url = Dota2NetworkUtility.makeURL();

            try {

                String json = Dota2NetworkUtility.getResponseFromHttpUrl(url);
                dota2ItemArrayList = Dota2NetworkUtility.parseJSON(json);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return dota2ItemArrayList;
        }

        @Override
        protected void onPostExecute(final ArrayList<Dota2Item> dota2ItemArrayList) {
            loading.setVisibility(View.GONE);

            super.onPostExecute(dota2ItemArrayList);
            adapter.notifyDataSetChanged();

            if (dota2ItemArrayList != null)
            {
                Dota2Adapter adapter = new Dota2Adapter(dota2ItemArrayList, new Dota2Adapter.ItemClickListener() {
                    @Override
                    public void onItemClick(int clickedItemIndex) {
                        String tname = dota2ItemArrayList.get(clickedItemIndex).getSeason_name();
                        tname = tname.replaceAll("[^a-zA-Z0-9]", "");

                        String url = "https://twitter.com/hashtag/"+tname+"?src=hash";
                        openWebPage(url);

                    }



                });

                recyclerView.setAdapter(adapter);
            }
        }
    }

    public void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
