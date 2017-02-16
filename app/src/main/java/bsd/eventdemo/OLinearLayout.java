package bsd.eventdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by ShiDa.Bian on 2017/1/5.
 * 最外层的viewgroup
 * 1----如果这一层中，把事件拦截了，无论点击的是那一层，效果都是一样的，将只有这一层的拦截事件和touch事件触发
 * <p/>
 * 2----如果这里不分发，那么其touch将不触发,并且分发事件将触发2次
 */
public class OLinearLayout extends LinearLayout {
    public OLinearLayout(Context context) {
        super(context);
    }

    public OLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i("=========", getClass().getSimpleName() + "==dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.i("=========", getClass().getSimpleName() + "==onInterceptTouchEvent");
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i("=========", getClass().getSimpleName() + "==onTouchEvent");
                //即使父布局拦截了事件，如果手动的让子布局手动的调用分发事件，子布局还是可以获得事件的
//                getChildAt(0).dispatchTouchEvent(ev);
                break;
        }
        return super.onTouchEvent(ev);
    }
}
