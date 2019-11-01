package com.example.sy.boom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class game1hard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1hard);
        TargetModel model = new TargetModel();

        Controllergame1hard cgh = new Controllergame1hard(model);
        Viewgame1hard vg = (Viewgame1hard) findViewById(R.id.viewhard);
        vg.setMVC(model,cgh);

        ControllerScore cs = new ControllerScore(model);
        ViewScore vs = (ViewScore)findViewById(R.id.socre);
        vs.setMVC(model,cs);

        ControllerHeart ch = new ControllerHeart(model);
        ViewHeart vh = (ViewHeart)findViewById(R.id.heart);
        vh.setMVC(model,ch);
    }
    protected void onResume() {
        super.onResume();
        Viewgame1hard mdv = (Viewgame1hard) findViewById(R.id.viewhard);
        mdv.startTicker();
    }

    protected void onPause() {
        super.onPause();
        Viewgame1hard mdv = (Viewgame1hard) findViewById(R.id.viewhard);
        mdv.stopTicker();
    }
}
