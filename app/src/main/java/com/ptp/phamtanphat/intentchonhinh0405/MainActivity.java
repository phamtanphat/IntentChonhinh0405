package com.ptp.phamtanphat.intentchonhinh0405;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
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
    String tenhinhgoc ="";
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

        RandomHinh();
        imgHinhchon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SothuActivity.class);
                startActivityForResult(intent, Request_Code_Image);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Request_Code_Image && resultCode == RESULT_OK && data != null){
            String tenhinhchon = data.getStringExtra("tenhinh");
            int idhinhchon = getResources().getIdentifier(tenhinhchon,"drawable",getPackageName());
            imgHinhchon.setImageResource(idhinhchon);
            if (tenhinhchon.equals(tenhinhgoc)){
                Toast.makeText(this, "Dung roi!!", Toast.LENGTH_SHORT).show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        RandomHinh();
                    }
                },2000);
            }else {
                Toast.makeText(this, "Sai roi!!", Toast.LENGTH_SHORT).show();
            }
        }
        if (requestCode == Request_Code_Image && resultCode == RESULT_CANCELED){
//            Toast.makeText(this, "Ban khong chon hinh", Toast.LENGTH_SHORT).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    private void RandomHinh(){
        Collections.shuffle(manghinh);

        tenhinhgoc = manghinh.get(0);

        //Cach lay file thong qua ten
        int idhinhgoc = getResources().getIdentifier(tenhinhgoc,"drawable",getPackageName());
        imgHinhgoc.setImageResource(idhinhgoc);
    }
}
