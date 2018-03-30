package com.example.jsyoo8.ms_hw09_201302436;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import static com.example.jsyoo8.ms_hw09_201302436.MainActivity.height;
import static com.example.jsyoo8.ms_hw09_201302436.MainActivity.width;

/**
 * Created by jsyoo8 on 2017-11-13.
 */


class MyView extends View {
    int randomX = (int) (Math.random() * width);
    int randomY = (int) (Math.random() * height);
    int x = randomX, y = randomY;

    public MyView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);

        canvas.drawRect(x - 100, y - 100, x + 100, y + 100, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            default:
                x = (int) motionEvent.getX();
                y = (int) motionEvent.getY();
                invalidate();
        }
        return true;
    }
}