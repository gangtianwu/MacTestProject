package com.example.mactestproject.viewmodel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public class ViewPagerWen extends ViewGroup {

    private Scroller mScroller;

    public ViewPagerWen(Context context) {
        super(context);
        initViewPager();
    }

    private void initViewPager() {
       setWillNotDraw(false);
       setDescendantFocusability(FOCUS_AFTER_DESCENDANTS);
       setFocusable(true);
       final  Context context = getContext();
        mScroller = new Scroller(context, sInterpolator);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        viewConfiguration.getScaledDoubleTapSlop();
    }

    public ViewPagerWen(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViewPager();
    }

    public ViewPagerWen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViewPager();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }


    private static final Interpolator sInterpolator = new Interpolator() {
        @Override
        public float getInterpolation(float t) {
            t -= 1.0f;
            return t * t * t * t * t + 1.0f;
        }
    };
}
