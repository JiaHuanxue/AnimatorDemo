package com.example.customviewdemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.example.customview.R;

/**
 * Created by 贾焕雪 on 2016-11-01.
 */
public class CustormViewDemo extends View {
    /**
     * 画笔对象的引用
     */
    private float mCircleXY=20;
    private float mRadius;
    private Paint mCirclePaint;
    private RectF mRectF;
    private Paint mArcPaint;
    private Paint mTextPaint;
    private int width;
    private int height;

    private Paint paint;

    private int circleColor=Color.BLUE;

    private int arcColor=Color.RED;

    private int textColor;

    private float textSize;

    private int startAngle;

    private int sweepAngle;

    private String text;

    public static final int STROKE = 0;
    public static final int FILL = 1;
    private  Paint Align;

    public CustormViewDemo(Context context) {
        super(context);
    }

    public CustormViewDemo(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustormViewDemo(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.obtainStyledAttributes(attrs,
                R.styleable.circleView);
        if (ta != null) {
            circleColor = ta.getColor(R.styleable.circleView_circleColor, 0);
            arcColor = ta.getColor(R.styleable.circleView_arcColor, 0);
            textColor = ta.getColor(R.styleable.circleView_textColor, 0);
            textSize = ta.getDimension(R.styleable.circleView_textSize, 50);
            text = ta.getString(R.styleable.circleView_text);
            startAngle = ta.getInt(R.styleable.circleView_starAngle, 0);
            sweepAngle = ta.getInt(R.styleable.circleView_sweepAngle, 90);
            ta.recycle();
        }

    }
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        init(w,h);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawSth(canvas);
    }

    private void init(int w, int h) {
        int length = Math.min(w, h);
        mCircleXY = length / 2;
        mRadius = length * 0.1f / 1;
        mCirclePaint = new Paint(Color.BLACK);
        mCirclePaint.setColor(Color.BLUE);
        mRectF = new RectF(length * 0.1f, length * 0.1f, length * 0.9f,
                length * 0.9f);

        mArcPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mArcPaint.setColor(Color.BLACK);
        mArcPaint.setStyle(Paint.Style.STROKE);
        mArcPaint.setStrokeWidth((w * 0.1f));

        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setTextSize(textSize);
        mTextPaint.setColor(Color.BLUE);
        mTextPaint.setTextAlign(Paint.Align.CENTER);

    }
    private void drawSth(Canvas canvas) {




        ////////
        canvas.drawCircle(mCircleXY, mCircleXY, mRadius, mCirclePaint);
        canvas.drawArc(mRectF, startAngle, sweepAngle,false, mArcPaint);

    }

}
