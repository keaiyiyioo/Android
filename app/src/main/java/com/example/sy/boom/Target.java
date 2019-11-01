package com.example.sy.boom;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by yiyi on 2017/4/13.
 */

public class Target extends Shape {
    private float radius;
    private Paint p=new Paint();
    private Random r = new Random();
    private String colour;

    ArrayList<Colour> c= new ArrayList<Colour>();
    Colour red = new Colour(255,0,0,"red");
    Colour orange = new Colour(255,156,0,"orange");
    Colour yellow = new Colour(255,255,0,"yellow");
    Colour green = new Colour(0,255,0,"green");
    Colour cyan = new Colour(0,255,255,"cyan");
    Colour blue = new Colour(0,0,255,"blue");
    Colour purple = new Colour(255,0,255,"purple");

    public Target(float x, float y) {
        super(x, y);
        this.radius=(float) 30.0;
        c.add(red);
        c.add(orange);
        c.add(yellow);
        c.add(green);
        c.add(cyan);
        c.add(blue);
        c.add(purple);
        int m=r.nextInt(6);
        int randomR=c.get(m).getR();
        int randomG=c.get(m).getG();
        int randomB=c.get(m).getB();
        this.colour=c.get(m).getName();
        p.setColor(Color.rgb(randomR,randomG,randomB));
        p.setAlpha(155);
    }

    @Override
    public boolean isVisible(int w, int h) {
        float x = getX();
        float y = getY();
        float wx = (x < 0 ? 0 : (x > w ? w : x));
        float wy = (y < 0 ? 0 : (y > h ? h : y));
        float dx = wx - x;
        float dy = wy - y;
        return dx * dx + dy * dy <= radius * radius;
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

    public String getC(){
        return colour;
    }

    public float getRadius(){
        return radius;
    }
}
