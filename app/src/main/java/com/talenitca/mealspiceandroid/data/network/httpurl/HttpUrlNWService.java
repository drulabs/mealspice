package com.talenitca.mealspiceandroid.data.network.httpurl;

import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUrlNWService extends AsyncTask<Void, Void, String> {

    private INetworkServiceCallback mCallback;
    private String mUrl;

    public HttpUrlNWService(String url,INetworkServiceCallback callback){
        mCallback = callback;
        mUrl = url;
    }
    @Override
    protected String doInBackground(Void... voids) {
        String result = null;
        try {
            URL url = new URL(mUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            result = inputStreamToString(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        mCallback.onDataReceived(s);
    }

    private String inputStreamToString(InputStream inputStream) {
        String line = "";
        StringBuilder result = new StringBuilder();
        InputStreamReader isr = new InputStreamReader(inputStream);
        BufferedReader rd = new BufferedReader(isr);

        try {
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
