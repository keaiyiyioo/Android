package com.example.sy.boom;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.EditText;

public class game1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1);

        TargetModel model = new TargetModel();

        Controllergame1 cg = new Controllergame1(model);
        Viewgame1 vg = (Viewgame1)findViewById(R.id.view);
        vg.setMVC(model,cg);

        ControllerScore cs = new ControllerScore(model);
        ViewScore vs = (ViewScore)findViewById(R.id.socre);
        vs.setMVC(model,cs);

        ControllerHeart ch = new ControllerHeart(model);
        ViewHeart vh = (ViewHeart)findViewById(R.id.heart);
        vh.setMVC(model,ch);

    }

    protected void onResume() {
        super.onResume(); // Mandatory or exception!
        Viewgame1 vl = (Viewgame1)findViewById(R.id.view);
        vl.startTicker(); //call the startTicker method in viewBubbles class
    }

    protected void onPause() {
        super.onPause(); // Mandatory or exception!
        Viewgame1 vl = (Viewgame1)findViewById(R.id.view);
        vl.stopTicker();//call the stopTicker method in viewBubbles class
    }
}

