package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.HashMap;

public class TeamDetails extends AppCompatActivity {

    private  TeamList tl;
    private final int EMBLEMSIZE = 150;
    private final int ICONSIZE = 50;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String teamNames[] = intent.getStringExtra("match").split("-");
        String myIp = intent.getStringExtra("ip");
        tl = new TeamList(myIp);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_details);

        TextView homeTeam = findViewById(R.id.textHome);
        homeTeam.setText(teamNames[0]);

        TextView awayTeam = findViewById(R.id.textAway);
        awayTeam.setText(teamNames[1]);

        ImageView HomeImage = findViewById(R.id.imageHome);
        ImageView AwayImage = findViewById(R.id.imageAway);

        Picasso.get().load(tl.getImageForTeam(teamNames[0])).resize(EMBLEMSIZE,
                0).into(HomeImage);

        Picasso.get().load(tl.getImageForTeam(teamNames[1])).resize(EMBLEMSIZE,
                0).into(AwayImage);

        LinearLayout layouts[] = new LinearLayout[2];
        layouts[0] = findViewById(R.id.HomeLayout);
        layouts[1] = findViewById(R.id.AwayLayout);
        int counter=0;

        for(int k = 0; k<2; k++) {
            HashMap<String, String> players = tl.getPlayersMap(teamNames[k]);
            for (String pname : players.keySet()) {
                LinearLayout row = new LinearLayout(this);
                row.setOrientation(LinearLayout.HORIZONTAL);  // Σημαντικό!
                row.setGravity(Gravity.CENTER_VERTICAL);
                row.setPadding(4, 8, 0, 8);
                row.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
                TextView pText = new TextView(this);
                ImageView pImage = new ImageView(this);
                pImage.setLayoutParams(new LinearLayout.LayoutParams(ICONSIZE,
                        ICONSIZE));
                Picasso.get().load(players.get(pname)).into(pImage);
                pImage.setId(1000 + counter);
                pText.setLayoutParams(new
                        LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
                pText.setText(pname);
                pText.setPadding(4, 0, 4, 0);
                pText.setSingleLine(false);
                pText.setMaxLines(3);
                pText.setId(1000 + counter);
                pImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
                row.addView(pImage);
                row.addView(pText);
                counter++;
                layouts[k].addView(row);
            }
        }

    }
}