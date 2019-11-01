package com.example.sy.boom;

/**
 * Created by yiyi on 2017/5/10.
 */

public class Colour {
    private int r;
    private int g;
    private int b;
    private String name;

    public Colour(int r, int g, int b,String name){
        this.r=r;
        this.g=g;
        this.b=b;
        this.name=name;
    }

    public int getR(){
        return r;
    }

    public int getG(){
        return g;
    }

    public int getB(){
        return b;
    }
    public String getName(){
        return name;
    }
}
