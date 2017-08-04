package com.esports.vishal.esportsscoreapplication;

import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by VISHAL on 7/24/2017.
 */

public class NetworkUtils {

    private static final String CSGO_BASE_URL = "https://api.sportradar.us/csgo-t1/us/schedules/2016-06-05/results.json";
    private static final String API_KEY_PARAM = "api_key";
    private static final String API_KEY = "29qbv2sgm6pendyxuy9fmdkg";

    protected static URL makeURL(){
        Uri uri = Uri.parse(CSGO_BASE_URL).buildUpon()
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
}
// https://api.sportradar.us/csgo-t1/us/schedules/2016-06-05/results.json?api_key={your_api_key}