package com.example.myapplication;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Team {
    private String teamName;
    private String emblem;
    private List<String> playersList;
    private HashMap<String, Media> media = new HashMap<>();

    public Team(String teamName, String emblem, String players, String images) {
        this.teamName = teamName;
        this.emblem = emblem;
        this.playersList = Arrays.asList(players.split(","));
        String[] imageArray = images.split(",");
        for (int i=0; i<this.playersList.size(); i++) {
            media.put(this.playersList.get(i),new Media(imageArray[i]));
        }
    }


    public boolean hasName(String b) {
        return teamName.equals(b);
    }

    public String getEmblem() {
        return emblem;
    }

    public HashMap<String, String> getPlayersMap() {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < playersList.size(); i++) {
            map.put(playersList.get(i), media.get(playersList.get(i)).getImage());
        }
        return map;
    }
}
