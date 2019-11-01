package com.example.sy.boom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by yiyi on 2017/5/10.
 */

public class ViewScore extends TextView implements IModelListener {
    private TargetModel t;
    private ControllerScore controller;

    public ViewScore(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //The setMVC method updates the text of the ViewScore to display the score of the user.
    public void setMVC(TargetModel md, ControllerScore ct){
        this.t = md;
        this.controller = ct;
        md.addListener(this);
        notifyModelListener();
    }

    @Override
    public void notifyModelListener() {
        this.setText("score: " + t.getScore());
    }

}
