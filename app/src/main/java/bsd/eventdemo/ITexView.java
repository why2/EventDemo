package bsd.eventdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * Created by ShiDa.Bian on 2017/1/5.
 * 最里层的view
 * <p/>
 * 这里为什么用的是textview，而没有用button，是因为像button这类可以自动获得焦点的view
 * 自身会在事件的触摸事件触发后消耗掉touch事件，这样不利于分析。
 * <p/>
 * 1，如果这里不分发,那么这里的touch事件将不会触发。此时还需要向外层的viewGroup传递事件
 * 那么此时外层的viewGroup同样不会触发touch事件，但是之前的分发事件和拦截事件还是会触发的。
 * <p/>
 * 2，如果这里的touch事件消耗掉，那么此时外层的viewGroup同样不会触发touch事件，但是之前的分发事件和拦截事件还是会触发的。
 */
public class ITexView extends TextView {
    public ITexView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ITexView(Context context) {
        super(context);
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

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i("=========", getClass().getSimpleName() + "==dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

}
