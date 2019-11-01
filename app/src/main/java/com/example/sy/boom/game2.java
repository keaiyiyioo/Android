package com.example.sy.boom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class game2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);

        EludeModel model = new EludeModel();
        TargetModel tmodel = new TargetModel();

        Controllergame2 cg = new Controllergame2(model);
        Viewgame2 vg = (Viewgame2)findViewById(R.id.view2);
        vg.setMVC(model,cg);

        Controllergame21 cg2 = new Controllergame21(tmodel);
        Viewgame2 vg2 = (Viewgame2)findViewById(R.id.view2);
        vg2.setMVC(tmodel, cg2);

        ControllerScore cs = new ControllerScore(tmodel);
        ViewScore vs = (ViewScore)findViewById(R.id.socre);
        vs.setMVC(tmodel,cs);

        ControllerHeart ch = new ControllerHeart(tmodel);
        ViewHeart vh = (ViewHeart)findViewById(R.id.heart);
        vh.setMVC(tmodel,ch);
    }

    protected void onResume() {
        super.onResume();
        Viewgame2 mdv = (Viewgame2) findViewById(R.id.view2);
        mdv.startTicker();
    }

    protected void onPause() {
        super.onPause();
        Viewgame2 mdv = (Viewgame2) findViewById(R.id.view2);
        mdv.stopTicker();
    }
}
