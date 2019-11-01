package com.example.sy.boom;

/**
 * Created by yiyi on 2017/5/15.
 */

public class Controllergame1hard {
    private TargetModel model;
    private  Viewgame1hard v;

    public Controllergame1hard(TargetModel m){
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
