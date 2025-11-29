package com.meizu.common.util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.ListView;
import java.util.concurrent.ConcurrentHashMap;

public class ListViewEnterAnimateUtil {
    private static int DEFAULTDELAY = 0;
    private static int DEFAULTDURATION = 200;
    private static int DEFAULTINTERVAL = 25;
    private static float DEFAULTOFFSETRATIO = 0.125f;
    /* access modifiers changed from: private */
    public ConcurrentHashMap<Integer, Animator> mAnimatorMap = new ConcurrentHashMap<>();
    private int mDelay = DEFAULTDELAY;
    private int mDuration = DEFAULTDURATION;
    private int mInterval = DEFAULTINTERVAL;
    private float mItemOffsetRatio = DEFAULTOFFSETRATIO;
    private ListView mListView;

    public ListViewEnterAnimateUtil(ListView listView) {
        this.mListView = listView;
    }

    /* access modifiers changed from: private */
    public void reset(View view) {
        view.setAlpha(1.0f);
        view.setTranslationY(0.0f);
    }

    private void startItemAnimate(final int i, final View view, int i2, int i3) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{((float) view.getHeight()) * this.mItemOffsetRatio, 0.0f});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                view.setAlpha(animatedFraction);
                view.setTranslationY(floatValue);
            }
        });
        ofFloat.setDuration((long) i3);
        ofFloat.setStartDelay((long) i2);
        ofFloat.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ListViewEnterAnimateUtil.this.reset(view);
                ListViewEnterAnimateUtil.this.mAnimatorMap.remove(Integer.valueOf(i));
            }
        });
        this.mAnimatorMap.put(Integer.valueOf(i), ofFloat);
        ofFloat.start();
    }

    public void runEnterAnimation() {
        if (this.mAnimatorMap.size() != 0) {
            stopEnterAnimation();
        }
        for (int i = 0; i < this.mListView.getChildCount(); i++) {
            View childAt = this.mListView.getChildAt(i);
            childAt.setAlpha(0.0f);
            startItemAnimate(i, childAt, (this.mInterval * i) + this.mDelay, this.mDuration);
        }
    }

    public void setDelay(int i) {
        this.mDelay = i;
    }

    public void setInterval(int i) {
        this.mInterval = i;
    }

    public void setItemDuration(int i) {
        this.mDuration = i;
    }

    public void setItemOffsetRatio(float f) {
        this.mItemOffsetRatio = f;
    }

    public void stopEnterAnimation() {
        for (Animator cancel : this.mAnimatorMap.values()) {
            cancel.cancel();
        }
    }
}
