package com.example.sy.boom;

import android.util.Log;

/**
 * Created by yiyi on 2017/5/11.
 */
public class Controllergame2 {
    private EludeModel model;

    private  Viewgame1 v;

    public Controllergame2(EludeModel m){
        this.model = m;
    }

    public void showobject(int w, int h){
        model.addObject(w,h);
    }

    public void setXY(float x,float y){
        model.reDraw(x,y);
    }


}
