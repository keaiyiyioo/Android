package com.example.sy.boom;

import android.util.Log;

/**
 * Created by Shan on 2017/5/14.
 */

public class Controllergame21 {
    private TargetModel tmodel;

    public Controllergame21(TargetModel t){
        this.tmodel = t;
    }

    public boolean misstarget(float x, float y){
        //Log.d("gyug","gyg");
        return  tmodel.WarningAtPoint(x, y);
    }

    public void moveUp(int width, int height) {
        tmodel.moveAll(width,height);//everytime move one
        tmodel.clearInvisibles(width, height);//delete old one
        tmodel.addTarget(width, height);//build a new one
    }
}
