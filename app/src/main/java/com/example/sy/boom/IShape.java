package com.example.sy.boom;

import android.graphics.Canvas;

/**
 * Created by yiyi on 2017/4/13.
 */

public interface IShape {
    float getX();
    float getY();
    void setX(float x);
    void setY(float y);
    boolean isVisible(int w, int h);
    boolean isIn(float x, float y);
    void draw(Canvas c);
}
