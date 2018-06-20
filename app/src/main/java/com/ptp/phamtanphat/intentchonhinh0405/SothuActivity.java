package com.ptp.phamtanphat.intentchonhinh0405;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.util.Collections;

public class SothuActivity extends AppCompatActivity {

    TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sothu);

        tableLayout = findViewById(R.id.tablelayout);

        int sohang = 6;
        int socot = 3;
//Cach lay chieu ngang va cao thiet bi
//        DisplayMetrics displayMetrics = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
//        int height = displayMetrics.heightPixels;
//        int width = displayMetrics.widthPixels;
//
//        Log.d("BBB",height + "");
//        Log.d("BBB",width + "");
        Collections.shuffle(MainActivity.manghinh);
        for (int i = 0 ; i < sohang ; i++){
            TableRow tableRow = new TableRow(this);
            for (int y = 0; y <socot ; y++){
                ImageView imageView = new ImageView(this);
                final int index = socot * (i ) + y ;
                final int idhinh = getResources().getIdentifier(MainActivity.manghinh.get(index),"drawable",getPackageName());
                TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(250,250);
                imageView.setLayoutParams(layoutParams);
                imageView.setImageResource(idhinh);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.putExtra("tenhinh",MainActivity.manghinh.get(index));
                        setResult(RESULT_OK,intent);
                        finish();
                    }
                });
                tableRow.addView(imageView);
            }
            tableLayout.addView(tableRow);
        }


    }
}
