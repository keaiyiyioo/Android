package com.example.sy.boom;

import android.graphics.Canvas;

/**
 * Created by yiyi on 2017/4/13.
 */

public abstract class Shape implements IShape{
    private float x;
    private float y;

    public Shape(float x, float y){
        this.x = x;
        this.y = y;
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public void setX(float x) {
        this.x=x;
    }

    @Override
    public void setY(float y) {
        this.y=y;
    }

    @Override
    public abstract boolean isVisible(int w, int h);
    @Override
    public abstract boolean isIn(float x, float y);

    @Override
    public abstract void draw(Canvas c);

}
