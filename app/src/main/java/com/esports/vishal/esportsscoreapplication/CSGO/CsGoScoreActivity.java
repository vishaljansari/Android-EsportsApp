package com.esports.vishal.esportsscoreapplication.CSGO;

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
import android.util.Log;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CsGoScoreActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        DateFragmenter.OnDialogCloseListener{

    private ProgressBar loading;
    private SwipeRefreshLayout swipeContainer;
    private RecyclerView recyclerView;
    public RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<CsGoItem> csGoItemArrayList;
    DateFormat formatDateTime = DateFormat.getDateTimeInstance();
    Calendar date = Calendar.getInstance();

    private  Button button ;
    String date2;
    private final static String TAG= "csgo";
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    static String currentDate = sdf.format(new Date());




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports_score);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        csGoItemArrayList = new ArrayList<CsGoItem>();
        //csGoItemArrayList = null;

        loading = (ProgressBar) findViewById(R.id.progressBar);
        //    recyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(this).build());
        adapter = new CsGoAdapter(csGoItemArrayList);
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

        if(savedInstanceState==null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                date = null;

            } else {
                date2 = extras.getString("date");
            }
        }
        else{
            date2 = (String)savedInstanceState.getSerializable("date");
        }
        Log.d(TAG, "Date in csgo>>>>>>>>>>"+date2);




        //   swipeContainer = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);

        CsGoDataFetchTask csGoDataFetchTask = new CsGoDataFetchTask();
        csGoDataFetchTask.execute();
        //fetchURL();

//        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//
//            @Override
//            public void onRefresh() {
//            }
//
//        });
//
//        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright, android.R.color.holo_green_light, android.R.color.holo_orange_light, android.R.color.holo_red_light);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

    public ArrayList<CsGoItem> getCsGoItemArrayList() {
        return csGoItemArrayList;
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
            Intent intent = new Intent(CsGoScoreActivity.this, MainActivity.class);
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
        CsGoDataFetchTask csGoDataFetchTask = new CsGoDataFetchTask();
        CsGoNetworkUtility csGoNetworkUtility = new CsGoNetworkUtility();
        URL url = csGoNetworkUtility.makeURL(date2);
        csGoDataFetchTask.execute(url);
    }

    @Override
    public void closeDialog(int year, int month, int day) {


    }


    class CsGoDataFetchTask extends AsyncTask<URL,Void,ArrayList<CsGoItem>>
    {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loading.setVisibility(View.VISIBLE);
        }

        @Override
        protected ArrayList<CsGoItem> doInBackground(URL... params) {

            URL url = CsGoNetworkUtility.makeURL(date2);
            csGoItemArrayList = null;
            try {

                String json = CsGoNetworkUtility.getResponseFromHttpUrl(url);
                csGoItemArrayList = CsGoNetworkUtility.parseJSON(json);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return csGoItemArrayList;
        }

        @Override
        protected void onPostExecute(final ArrayList<CsGoItem> csGoItemArrayList) {
            loading.setVisibility(View.GONE);

            super.onPostExecute(csGoItemArrayList);
            adapter.notifyDataSetChanged();

            if (csGoItemArrayList != null)
            {
                CsGoAdapter adapter = new CsGoAdapter(csGoItemArrayList, new CsGoAdapter.ItemClickListener() {
                    @Override
                    public void onItemClick(int clickedItemIndex, String date) {

                        String tname = csGoItemArrayList.get(clickedItemIndex).getSeason_name();
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
