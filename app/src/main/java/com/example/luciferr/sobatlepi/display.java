package com.example.luciferr.sobatlepi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;

public class display extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        BackgroundTask backgroundTask = new BackgroundTask(display.this);
        backgroundTask.execute();
    }
}
