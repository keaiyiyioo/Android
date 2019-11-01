package com.example.sy.boom;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Debug;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by yiyi on 2017/5/11.
 */

public class Viewgame2 extends View implements IModelListener {
    private EludeModel model;
    private TargetModel tmodel;
    private Object object;
    private Controllergame2 controller;
    private Controllergame21 controller1;
    private long delay = 100;
    private Handler h;

    public Viewgame2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setMVC(EludeModel md, Controllergame2 ct) {
        this.model = md;
        this.controller = ct;
        model.addListener(this);
        notifyModelListener();

        controller.showobject(getWidth(),getHeight());

        this.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //Log.d("onTouch", event.toString());
                controller.setXY(event.getX(), event.getY());
                if (controller1.misstarget(event.getX(), event.getY())==true){
                    System.out.println("die");
                    popup();
                }else objectbig(event.getX(), event.getY());
                return true;
            }
        });
    }

    public void setMVC(TargetModel md, Controllergame21 ct){
        this.tmodel = md;
        this.controller1 = ct;
        tmodel.addListener(this);
        notifyModelListener();

        h = new Handler(new Handler.Callback(){
            @Override
            public boolean handleMessage(Message msg) {
                controller1.misstarget(getX(),getY());
                controller1.moveUp(getWidth(), getHeight());//move bubbles
                notifyModelListener();
                Message m = h.obtainMessage(0);
                h.sendMessageDelayed(m, delay);
                return false;
            }
        });
    }


    public void onDraw(Canvas c){
        //Log.d("asdsa","asds");
        model.drawObject(c);
        tmodel.drawAll(c);
    }

    @Override
    public void notifyModelListener() {
        invalidate();
    }

    public void startTicker(){
        Message m = h.obtainMessage(0);
        h.sendMessageDelayed(m, delay);
    }

    public void stopTicker(){
        h.removeMessages(0);
    }

    public void objectbig(float x, float y){
        String str;
        str = String.valueOf(x);
        Log.d("aa", str);
        //object.setRadius(object.getRadius() + 10);
        //model.reDraw(x, y);
    }

    public void popup() {
        final Activity a = (Activity) this.getContext();
        AlertDialog.Builder adInfo = new AlertDialog.Builder(a);
        adInfo.setTitle("game over,please try again and save your score");
        adInfo.setPositiveButton("sure", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                Intent i = new Intent(a,Finish.class);
                System.out.println("a"+tmodel.getScore());
                i.putExtra("socre", String.valueOf(tmodel.getScore()));
                a.startActivity(i);
            }
        });
        adInfo.setIcon(R.drawable.popup);
        adInfo.create();
        adInfo.show();
    }
}
