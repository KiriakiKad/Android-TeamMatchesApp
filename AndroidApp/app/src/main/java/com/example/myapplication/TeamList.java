package com.example.myapplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TeamList {

    private ArrayList<Team> tList = new ArrayList<>();

    public TeamList(String ip){
        String url = "http://" + ip + "/matches/getMembers.php";
        try {
            OkHttpHandler okHttpHandler = new OkHttpHandler();
            tList = okHttpHandler.getTeamMembers(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public HashMap<String, String> getPlayersMap(String teamName) {
        for (int i = 0; i < tList.size(); i++) {
            if (tList.get(i).hasName(teamName)) {
                return tList.get(i).getPlayersMap();
            }
        }
        return new HashMap<>();
    }

    public String getImageForTeam(String teamName) {
        for (int i = 0; i < tList.size(); i++) {
            if (tList.get(i).hasName(teamName)) {
                return tList.get(i).getEmblem();
            }
        }
        return null;
    }
}
