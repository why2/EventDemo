package bsd.eventdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by ShiDa.Bian on 2017/1/5.
 * 中间层的viewgroup
 * <p/>
 * 1，如果这里不分发,那么这里的touch事件和分发事件将不会触发。此时还需要向外层的viewGroup传递事件
 * 那么此时外层的viewGroup同样不会触发touch事件，但是之前的分发事件和拦截事件还是会触发的。
 * <p/>
 * 2,这里的拦截事件，而不做其他任何操作，那么外层将没有任何影响
 * <p/>
 * 3，如果这里的touch事件消耗掉，那么此时外层的viewGroup同样不会触发touch事件，但是之前的分发事件和拦截事件还是会触发的。
 */
public class MLinearLayout extends LinearLayout {
    public MLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MLinearLayout(Context context) {
        super(context);
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
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i("=========", getClass().getSimpleName() + "==onTouchEvent");
                break;
        }
        return super.onTouchEvent(event);
    }
}
