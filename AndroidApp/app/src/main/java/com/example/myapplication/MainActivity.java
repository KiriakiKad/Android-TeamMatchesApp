package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private MeetingList mList ;
    private final String myIP = "put your ip here";

    private Button selectButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mList = new MeetingList(myIP);

        Spinner dropDown = findViewById(R.id.spinner);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, mList.getAllMeetings());
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropDown.setAdapter(arrayAdapter);

        selectButton = findViewById(R.id.selectBtn);
        selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String match = String.valueOf(dropDown.getSelectedItem());

                Intent intent = new Intent(MainActivity.this, TeamDetails.class);
                intent.putExtra("match", match);
                intent.putExtra("ip", myIP);
                startActivity(intent);
            }
        });
    }
}

