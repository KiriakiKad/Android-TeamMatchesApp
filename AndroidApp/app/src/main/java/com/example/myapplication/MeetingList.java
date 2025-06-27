package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

public class MeetingList {
    private ArrayList<String> mList = new ArrayList<>();

    public MeetingList(String ip) {
        String url = "http://" + ip + "/matches/getFixtures.php";
        try {
            OkHttpHandler okHttpHandler = new OkHttpHandler();
            mList = okHttpHandler.getFixtures(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getAllMeetings() {
        return new ArrayList<>(mList);
    }
}
