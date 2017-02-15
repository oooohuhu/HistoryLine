package com.asuka.android.asukaandroid.demo.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.asuka.android.asukaandroid.demo.R;

/**
 * Created by Administrator on 2017/1/16.
 */

public class HistoryLine extends View {
    private boolean isHead=false;
    Context mcontext;
    private int group_width;
    private int group_height;

    public HistoryLine(Context context) {
        super(context);
        mcontext=context;
        showhead(false);
    }

    public HistoryLine(Context context, AttributeSet attrs) {
        super(context, attrs);
        mcontext=context;
        showhead(false);
    }

    public HistoryLine(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mcontext=context;
        showhead(false);
    }

    public HistoryLine(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mcontext=context;
        showhead(false);
    }

    public void  showhead(Boolean b){
        isHead=b;
        invalidate();
    }


//    @Override
//    protected void onLayout(boolean changed, int l, int t, int r, int b) {
//        View v=getChildAt(0);
//        if (v!=null){
//            v.layout(0,group_height/8,group_width,group_height/8+group_width);
//        }
//    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap;
        Bitmap bitmap2;
        int bitmap_w;
        if (isHead){
             bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.icon_sign);
            bitmap_w= bitmap.getWidth();
        }else {
             bitmap2= BitmapFactory.decodeResource(getResources(),R.drawable.icon_sign);
             bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.icon_moren);
            bitmap_w= bitmap2.getWidth();
        }
        Paint paint=new Paint();
        paint.setColor(0xffb2b2b2);                    //设置画笔颜色
        paint.setStrokeWidth((float) 3.0);              //设置线宽
        //消除锯齿
        paint.setAntiAlias(true);
        //设置镂空（方便查看效果）
        paint.setStyle(Paint.Style.STROKE);
        if (isHead){
            canvas.drawLine(bitmap_w/2,group_height/8,bitmap_w/2,group_height,paint);
            canvas.drawBitmap(bitmap,0,group_height/8,paint);
        }else {
            canvas.drawLine(bitmap_w/2,0,bitmap_w/2,group_height,paint);
            canvas.drawBitmap(bitmap,(bitmap_w-bitmap.getWidth())/2,group_height/8,paint);
        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        group_width=getMeasuredWidth();
        group_height=getMeasuredHeight();
    }
}
