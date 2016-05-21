package com.example.luciferr.sobatlepi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void rekomen(View v) {
        Intent buka = new Intent(MainActivity.this, Rekomendasi.class);
        startActivity(buka);
    }
    public void tips(View s){
        Intent tip = new Intent(MainActivity.this, ListTips.class);
        startActivity(tip);
    }

}

