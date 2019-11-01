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

public class First extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Button logout = (Button) findViewById(R.id.buttonLogout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity a = (Activity) v.getContext();
                a.finish();
            }
        });

        Button normal = (Button) findViewById(R.id.normal);
        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),game1.class);
                startActivity(i);
            }
        });
        Button Speed = (Button) findViewById(R.id.speed);
        Speed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),game1hard.class);
                startActivity(i);
            }
        });
    }
    public void speed(){

    }
}
