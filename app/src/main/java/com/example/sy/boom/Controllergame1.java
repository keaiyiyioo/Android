package com.example.sy.boom;

import java.util.ArrayList;

/**
 * Created by yiyi on 2017/5/4.
 */
public class Controllergame1 {
    private TargetModel model;
    private  Viewgame1 v;

    public Controllergame1(TargetModel m){
        this.model = m;
    }

    public void showTargets(int w, int h) throws NoHeartException {
        model.addTarget(w,h);
    }
    public boolean deleteTargets(){
        return model.delete();
    }

    public boolean clickTargets(float x, float y)  throws NoHeartException{
        return model.deletetargetAtPoint(x,y);
    }
}
