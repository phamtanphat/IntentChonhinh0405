package com.ptp.phamtanphat.intentchonhinh0405;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SothuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sothu);
        Log.d("BBB",MainActivity.manghinh.size() + "");
    }
}
