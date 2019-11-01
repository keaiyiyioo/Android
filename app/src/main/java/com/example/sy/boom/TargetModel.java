package com.example.sy.boom;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Canvas;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by yiyi on 2017/5/4.
 */

public class TargetModel {
    private int score;
    private int heart=5;
    private ArrayList<Target> targets;
    private ArrayList<IModelListener> listeners;
    private final Random r = new Random();
    private Object object;
    private int ballspeedx = 5;
    private int ballspeedy = 5;
    private EludeModel model;

    public TargetModel() {
        this.targets = new ArrayList<Target>();
        this.listeners = new ArrayList<IModelListener>();
    }


    public int getScore(){
        return score;
    }

    public int getHeart(){
        return heart;
    }

    public void addTarget(int w, int h){
        Target t = new Target(r.nextInt(w), r.nextInt(h));
        targets.add(t);
        notifyAllModelListeners();
    }


    public void addListener(IModelListener listener){
        listeners.add(listener);
    }

    public void drawAll(Canvas c){
        for(Target target : targets) {
            //Log.d("target sizd is ",String.valueOf(targets.size()));
            //Log.d("haha","baobao");
            target.draw(c);
        }
    }

    public boolean WarningAtPoint(float x, float y){
        //Log.d("debug","1");

        for(int i =0; i<targets.size()-1;i++) {
            //Log.d("debug","2");
            if (targets.get(i).isIn(x, y) == true){
                targets.remove(i);
//                object.setRadius(object.getRadius()+10);
//                float r = object.getRadius() + 10;
                heart = heart - 1;
                if(heart==0) {
                    // throw new NoHeartException("no heart");
                    return true;
                    //break;
                }
            }
            else {
                score = score + 1;
            }
        }
        return false;
    }


    public boolean deletetargetAtPoint(float x, float y) throws NoHeartException{
        for(int i = targets.size()-1; i>=0;i--) {
//            System.out.println(targets.get(i).isIn(x,y));
            if(targets.get(i).isIn(x,y)==true){
                //Log.d("a",targets.get(i).getC());
                if(targets.get(i).getC()=="red") {
                    score = score + 10;
                }
                else{
                    heart = heart - 1;
                    if(heart==0) {
                         //new NoHeartException("no heart");

                        return true;
                    }
                }
                targets.remove(targets.get(i));
                notifyAllModelListeners();
            }
        }
        return false;
    }

    public boolean delete(){
        String a="true";
        for(int i =0; i<targets.size()-1;i++) {
            //Log.d("b",targets.get(i).getC());
            if(targets.get(i).getC()=="red") {
                heart = heart - 1;
                if(heart==0) {
                   // throw new NoHeartException("no heart");
                    return true;
                    //break;
                }
            }
            targets.remove(targets.get(i));
            notifyAllModelListeners();
        }
        return false;
    }



    private void notifyAllModelListeners() {
        for(IModelListener listener : listeners){
            listener.notifyModelListener();
        }
    }


    public void moveAll(int width, int height) {
        for (int i = 0; i < targets.size(); i++) {
            //Log.d("chulai", "chul");
            Random r = new Random();
            Random b = new Random();
            int g = b.nextInt(4);
            ballspeedx = r.nextInt(40)-20;
            //ballspeedy = r.nextInt(30)-15;
            targets.get(i).setX(targets.get(i).getX() + ballspeedx);
            targets.get(i).setY(targets.get(i).getY() + 15);
            this.notifyAllModelListeners();
        }
    }


    public void clearInvisibles(int w, int h) {
        for(int i = targets.size() - 1; i > -1; i--) {
            if(targets.get(i).isVisible(w, h)==false){//clear bubble from the last one
                targets.remove(i);
                this.notifyAllModelListeners();
            }
        }
    }

}
