package com.example.sy.boom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by yiyi on 2017/5/4.
 */

public class Second extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button logout = (Button) findViewById(R.id.buttonLogout2);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity a = (Activity)v.getContext();
                a.finish();
            }
        });

        Button Start = (Button) findViewById(R.id.buttonStart2);
        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),game2.class);
                startActivity(i);
            }
        });
    }
}
