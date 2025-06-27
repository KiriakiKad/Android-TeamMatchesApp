package com.example.myapplication;

import android.os.StrictMode;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpHandler {

    public OkHttpHandler() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    public ArrayList<String> getFixtures(String url) throws Exception {
        ArrayList<String> meetingsList = new ArrayList<>();
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create("", MediaType.parse("text/plain"));
        Request request = new Request.Builder().url(url).method("POST", body).build();
        Response response = client.newCall(request).execute();
        String data = response.body().string();
        System.out.println("Fixtures Response: " + data);
        try {
            JSONObject json = new JSONObject(data);
            Iterator<String> keys = json.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                meetingsList.add(key);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return meetingsList;
    }

    public ArrayList<Team> getTeamMembers(String url) throws Exception {
        ArrayList<Team> tList = new ArrayList<>();
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create("", MediaType.parse("text/plain"));
        Request request = new Request.Builder().url(url).method("POST", body).build();
        Response response = client.newCall(request).execute();
        String data = response.body().string();
        System.out.println("My Response: " + data);

        try {
            JSONObject json = new JSONObject(data);
            Iterator<String> keys = json.keys();
            while(keys.hasNext()) {
                String team = keys.next();
                String emblem = json.getJSONObject(team).getString("emblem").toString();
                String players = json.getJSONObject(team).getString("players").toString();
                String images = json.getJSONObject(team).getString("images").toString();
                tList.add(new Team(team, emblem, players, images));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return tList;
    }
}
