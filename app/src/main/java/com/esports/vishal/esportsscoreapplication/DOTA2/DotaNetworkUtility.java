package com.esports.vishal.esportsscoreapplication.DOTA2;

import android.net.Uri;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by sagar on 8/4/17.
 */

public class DotaNetworkUtility {
    static ArrayList<Dota2Item> dota2Items=new ArrayList <Dota2Item>();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String currentDate = sdf.format(new Date());

    String formatter = new SimpleDateFormat().toString();

    private static String DOTA2_BASE_URL = "https://api.sportradar.us/dota2-t1/us/schedules/2017-08-03/results.json";
    private static final String API_KEY_PARAM = "api_key";
    private static final String API_KEY = "rqu5v6psgjgmx3ekxgffmwu8";
    public static URL makeURL(){

        Uri uri = Uri.parse(DOTA2_BASE_URL).buildUpon()
                .appendQueryParameter(API_KEY_PARAM,API_KEY)
                .build();


        URL url = null;
        try{
            url = new URL(uri.toString());
        }
        catch(MalformedURLException e)
        {
            e.printStackTrace();
        }

        return url;
    }

    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
        try{
            InputStream in = urlConnection.getInputStream();
            Scanner input = new Scanner(in);

            input.useDelimiter("\\A");
            return (input.hasNext())? input.next():null;

        }finally{
            urlConnection.disconnect();
        }
    }

    public static ArrayList<Dota2Item> parseJSON(String json) throws JSONException {


        JSONObject jsonObject = new JSONObject(json);
        JSONArray jsonArray = jsonObject.getJSONArray("results");
        //JSONArray jsonA=jsonObject.getJSONArray("sport_event").getJSONArray("competitor");
        //     Log.d("Array length: ", String.valueOf(jsonArray.length()));
        for(int i=0; i <= jsonArray.length()-1; i++)
        {
            JSONObject mainObject = jsonArray.getJSONObject(i);

            String d_dateandtimeofgame = mainObject.getJSONObject("sport_event").getString("scheduled");
            String d_season_name=mainObject.getJSONObject("sport_event").getJSONObject("tournament").getString("name");
            //  for(int j=0;j<=jsonA.length()-1;j++)

            JSONArray d_team_1_abbreviations = mainObject.getJSONObject("sport_event").getJSONArray("competitors");
            JSONObject jobj = d_team_1_abbreviations.getJSONObject(1);
            String team_1_abbreviation = jobj.getString("name");


            //   String team_1_abbreviation = (String) mainObject.getJSONObject("sport_event").getJSONObject("competitors").get("name");
            Dota2Item dota2Item = new Dota2Item(d_dateandtimeofgame,d_season_name);
            dota2Items.add(dota2Item);
 //           dota2Item.add(dota2Item);
            //    Log.d("got it",dateandtimeofgame);
        }
        return dota2Items;
    }

}