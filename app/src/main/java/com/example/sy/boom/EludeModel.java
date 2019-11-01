package com.example.sy.boom;

import android.graphics.Canvas;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by yiyi on 2017/5/13.
 */

public class EludeModel {
    private int score;
    private int heart=5;
    private ArrayList<IModelListener> listeners;
    private Object object;
    private final Random r = new Random();

    public EludeModel() {
        this.listeners = new ArrayList<IModelListener>();
    }

    public void addObject(int w, int h){
        object= new Object(500, 500);
        notifyAllModelListeners();
    }
    public void drawObject(Canvas c){
        object.draw(c);
    }

    public void reDraw(float x,float y){
        if(object.isIn(x,y)==true){
            object.setX(x);
            object.setY(y);
        }
        notifyAllModelListeners();
    }

    public Object getObject(){
        return object;
    }

    public void addListener(IModelListener listener){
        listeners.add(listener);
    }

    private void notifyAllModelListeners() {
        for(IModelListener listener : listeners){
            listener.notifyModelListener();
        }
    }
}
