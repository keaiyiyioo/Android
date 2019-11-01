package com.example.sy.boom;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

/**
 * Created by yiyi on 2017/5/4.
 */

public class Viewgame1 extends View implements IModelListener {
    private TargetModel model;
    private Controllergame1 controller;
    private Handler h;
    private long delay = 1000;
    private long delay2 = 2000;

    public Viewgame1(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setMVC(TargetModel md, Controllergame1 ct) {
        this.model = md;
        this.controller = ct;
        model.addListener(this);
        notifyModelListener();
        //creates a handler
        h = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {

                switch (msg.what) {
                    case 0:
                        try {
                            controller.showTargets(getWidth(), getHeight());
                        } catch (NoHeartException e) {
                            e.printStackTrace();
                        }
                        Message m = h.obtainMessage(0); //send message to hanlder
                        h.sendMessageDelayed(m, delay); // Send another message.
                        break;
                    case 1:
                        if (controller.deleteTargets() == true) {
                            System.out.println("die");
                            popup();
                        }
                        Message m2 = h.obtainMessage(1); //send message to hanlder
                        h.sendMessageDelayed(m2, delay2); // Send another message.
                        //Log.d("a",m.toString());
                        break;
                }
                return false;
            }
        });


        this.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    try {
                        if (controller.clickTargets(event.getX(), event.getY()) == true) {
                            System.out.println("die");
                            popup();
                        }
                    } catch (NoHeartException e) {
                        e.printStackTrace();
                    }
                }
                return true;
            }
        });
    }


    @Override
    public void notifyModelListener() {
        invalidate();
    }

    public void onDraw(Canvas c) {
        model.drawAll(c);
    }

    public void startTicker() {
        Message m = h.obtainMessage(0);
        h.sendMessageDelayed(m, delay); // Send first message into queue.
        Message m2 = h.obtainMessage(1);
        h.sendMessageDelayed(m2, delay2); // Send first message into queue.
    }

    public void stopTicker() {
        h.removeMessages(0); // Remove messages from queue.
        h.removeMessages(1); // Remove messages from queue.
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
                Bundle bundle = new Bundle();
                bundle.putInt("socre",model.getScore());
                i.putExtras(bundle);
                a.startActivity(i);
            }
        });
        adInfo.setIcon(R.drawable.popup);
        adInfo.create();
        adInfo.show();
    }
}
