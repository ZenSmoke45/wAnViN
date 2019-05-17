package com.example.nekit.wanted_vinyl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

public class Window{

    private Paint mPaint = new Paint();

    public Window(MainActivity mainActivity) {

    }

    public void draw(Canvas canvas){
        mPaint.setColor(Color.rgb(0,139,139));
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
    }
}
