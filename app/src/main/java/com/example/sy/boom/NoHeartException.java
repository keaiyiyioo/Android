package com.example.sy.boom;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

/**
 * Created by yiyi on 2017/5/4.
 */

public class NoHeartException extends Exception{
    public NoHeartException(String msg) {
        super(msg);
    }
}
