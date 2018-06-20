package com.ptp.phamtanphat.intentchonhinh0405;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

public class SothuActivity extends AppCompatActivity {

    TableLayout tableLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sothu);

        tableLayout = findViewById(R.id.tablelayout);

        int sohang = 6;
        int socot = 3;

        for (int i = 0 ; i < sohang ; i++){
            TableRow tableRow = new TableRow(this);
            for (int y = 0 ; y < socot ; y++){
                ImageView imageView = new ImageView(this);
                imageView.setImageResource(R.drawable.bo);
                tableRow.addView(imageView);
            }
            tableLayout.addView(tableRow);
        }


    }
}
