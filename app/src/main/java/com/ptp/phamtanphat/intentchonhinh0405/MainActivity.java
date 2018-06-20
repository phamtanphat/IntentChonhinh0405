package com.ptp.phamtanphat.intentchonhinh0405;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imgHinhgoc, imgHinhchon;
    String[] arrayhinh;
    int Request_Code_Image = 123;
    public static ArrayList<String> manghinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgHinhchon = findViewById(R.id.imageviewHinhchon);
        imgHinhgoc = findViewById(R.id.imageviewHinhgoc);

        arrayhinh = getResources().getStringArray(R.array.Arrayhinh);

        // Convert tu String[] sang ArrayList = Arrays.asList(arrayhinh)
        manghinh = new ArrayList<>(Arrays.asList(arrayhinh));

        Collections.shuffle(manghinh);

        String tenhinhgoc = manghinh.get(0);

        //Cach lay file thong qua ten
        int idhinhgoc = getResources().getIdentifier(tenhinhgoc,"drawable",getPackageName());
        imgHinhgoc.setImageResource(idhinhgoc);
        imgHinhchon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SothuActivity.class);
                startActivityForResult(intent, Request_Code_Image);
            }
        });

    }

}
