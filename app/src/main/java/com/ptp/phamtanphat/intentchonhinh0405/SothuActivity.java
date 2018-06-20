package com.ptp.phamtanphat.intentchonhinh0405;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

public class SothuActivity extends AppCompatActivity {

    TableLayout tableLayout;
    int index = 0;
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
        for (int i = 0 ; i < sohang ; i++){
            TableRow tableRow = new TableRow(this);
            for (int y = 0; y <socot ; y++){

                ImageView imageView = new ImageView(this);
                index = socot * (i ) + y ;
                int idhinh = getResources().getIdentifier(MainActivity.manghinh.get(index),"drawable",getPackageName());
                TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(250,250);
                imageView.setLayoutParams(layoutParams);
                imageView.setImageResource(idhinh);
                tableRow.addView(imageView);
            }

            tableLayout.addView(tableRow);
        }


    }
}
