package com.example.sy.boom;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

/**
 * Created by yiyi on 2017/5/13.
 */

public class Object extends Shape  {
    private float radius;
    private Paint p=new Paint();

    public Object(float x, float y) {
        super(x, y);
        this.radius=(float) 40.0;
        p.setColor(Color.rgb(242,156,177));
    }

    @Override
    public boolean isVisible(int w, int h) {
        return false;
    }


    @Override
    public boolean isIn(float x, float y) {
        float distanceSquare=(x-getX())*(x-getX())+(y-getY())*(y-getY());//computer the square of distance from mouse to center of a bubble
        //compare to square of distance and square of radious, if more than it and it means the mouse don'i inside the bublle and vice versa
        if(distanceSquare<= radius * radius){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void draw(Canvas c) {
        c.drawCircle(getX(),getY(),radius,p);
    }


    public void setRadius(float radius){
        this.radius = radius;
    }

    public float getRadius(){
        return radius;
    }

}
