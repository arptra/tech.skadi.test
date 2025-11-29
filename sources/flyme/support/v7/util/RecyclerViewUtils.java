package flyme.support.v7.util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import flyme.support.v7.widget.MzRecyclerView;
import java.util.ArrayList;
import java.util.HashMap;

public class RecyclerViewUtils {
    private static final int DEFAULT_DURATION = 300;
    private static final int DELAY_ANIMATION = 33;
    private Interpolator mAlInterpolator = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
    HashMap<Long, Integer> mItemIdTopMap = new HashMap<>();
    private Interpolator mTrInterpolator = new PathInterpolator(0.5f, 0.0f, 0.5f, 1.0f);
    /* access modifiers changed from: private */
    public Interpolator mUpInterpolator = new PathInterpolator(0.33f, 0.0f, 0.4f, 1.0f);

    public interface OnRecyclerViewFadeListener {
        void onEndRecyclerViewFadedOut();

        void onEndResetRecyclerViewStatus();

        void onStartRecyclerViewFadeOut();
    }

    /* access modifiers changed from: private */
    public void animateRemoval(final MzRecyclerView mzRecyclerView, View view, final OnRecyclerViewFadeListener onRecyclerViewFadeListener) {
        final ArrayList arrayList = new ArrayList();
        for (int i = 0; i < mzRecyclerView.getCount(); i++) {
            arrayList.add(Integer.valueOf(i));
        }
        int firstPosition = mzRecyclerView.getFirstPosition();
        for (int i2 = 0; i2 < mzRecyclerView.getChildCount(); i2++) {
            View childAt = mzRecyclerView.getChildAt(i2);
            if (childAt != view) {
                this.mItemIdTopMap.put(Long.valueOf((long) (firstPosition + i2)), Integer.valueOf(childAt.getTop()));
            }
        }
        if (onRecyclerViewFadeListener != null) {
            onRecyclerViewFadeListener.onEndRecyclerViewFadedOut();
            arrayList.remove(mzRecyclerView.getPositionForView(view));
        }
        mzRecyclerView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                mzRecyclerView.getViewTreeObserver().removeOnPreDrawListener(this);
                int firstPosition = mzRecyclerView.getFirstPosition();
                ArrayList arrayList = new ArrayList();
                if (arrayList.size() > 0) {
                    for (int i = 0; i < mzRecyclerView.getChildCount(); i++) {
                        View childAt = mzRecyclerView.getChildAt(i);
                        Integer num = RecyclerViewUtils.this.mItemIdTopMap.get(Long.valueOf((long) ((Integer) arrayList.get(firstPosition + i)).intValue()));
                        int top2 = childAt.getTop();
                        if (num == null) {
                            int decoratedMeasuredHeight = mzRecyclerView.getLayoutManager().getDecoratedMeasuredHeight(childAt);
                            if (i <= 0) {
                                decoratedMeasuredHeight = -decoratedMeasuredHeight;
                            }
                            Keyframe ofFloat = Keyframe.ofFloat(0.0f, (float) ((decoratedMeasuredHeight + top2) - top2));
                            Keyframe ofFloat2 = Keyframe.ofFloat(1.0f, 0.0f);
                            ofFloat2.setInterpolator(RecyclerViewUtils.this.mUpInterpolator);
                            arrayList.add(ObjectAnimator.ofPropertyValuesHolder(childAt, new PropertyValuesHolder[]{PropertyValuesHolder.ofKeyframe("translationY", new Keyframe[]{ofFloat, ofFloat2})}));
                        } else if (num.intValue() != top2) {
                            Keyframe ofFloat3 = Keyframe.ofFloat(0.0f, (float) (num.intValue() - top2));
                            Keyframe ofFloat4 = Keyframe.ofFloat(1.0f, 0.0f);
                            ofFloat4.setInterpolator(RecyclerViewUtils.this.mUpInterpolator);
                            arrayList.add(ObjectAnimator.ofPropertyValuesHolder(childAt, new PropertyValuesHolder[]{PropertyValuesHolder.ofKeyframe("translationY", new Keyframe[]{ofFloat3, ofFloat4})}));
                        }
                    }
                }
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(arrayList);
                animatorSet.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        OnRecyclerViewFadeListener onRecyclerViewFadeListener = onRecyclerViewFadeListener;
                        if (onRecyclerViewFadeListener != null) {
                            onRecyclerViewFadeListener.onEndResetRecyclerViewStatus();
                        }
                    }
                });
                animatorSet.start();
                RecyclerViewUtils.this.mItemIdTopMap.clear();
                return true;
            }
        });
    }

    public void fadeOutItemView(MzRecyclerView mzRecyclerView, int i, int i2, OnRecyclerViewFadeListener onRecyclerViewFadeListener) {
        final int firstPosition = mzRecyclerView.getFirstPosition();
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (int i4 = i; i4 <= i2; i4++) {
            View childAt = mzRecyclerView.getChildAt(i4 - firstPosition);
            if (childAt != null) {
                Keyframe ofFloat = Keyframe.ofFloat(0.0f, 1.0f);
                Keyframe ofFloat2 = Keyframe.ofFloat(1.0f, 0.0f);
                ofFloat2.setInterpolator(this.mAlInterpolator);
                Keyframe ofFloat3 = Keyframe.ofFloat(0.0f, 0.0f);
                Keyframe ofFloat4 = Keyframe.ofFloat(1.0f, (float) (-childAt.getWidth()));
                ofFloat4.setInterpolator(this.mTrInterpolator);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(childAt, new PropertyValuesHolder[]{PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[]{ofFloat, ofFloat2}), PropertyValuesHolder.ofKeyframe("translationX", new Keyframe[]{ofFloat3, ofFloat4})});
                ofPropertyValuesHolder.setDuration(300);
                ofPropertyValuesHolder.setStartDelay((long) (i3 * 33));
                arrayList.add(ofPropertyValuesHolder);
                i3++;
            }
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        final OnRecyclerViewFadeListener onRecyclerViewFadeListener2 = onRecyclerViewFadeListener;
        final int i5 = i;
        final int i6 = i2;
        final MzRecyclerView mzRecyclerView2 = mzRecyclerView;
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                int i = i5;
                if (i == i6) {
                    RecyclerViewUtils recyclerViewUtils = RecyclerViewUtils.this;
                    MzRecyclerView mzRecyclerView = mzRecyclerView2;
                    recyclerViewUtils.animateRemoval(mzRecyclerView, mzRecyclerView.getChildAt(i - firstPosition), onRecyclerViewFadeListener2);
                } else {
                    OnRecyclerViewFadeListener onRecyclerViewFadeListener = onRecyclerViewFadeListener2;
                    if (onRecyclerViewFadeListener != null) {
                        onRecyclerViewFadeListener.onEndRecyclerViewFadedOut();
                    }
                }
                for (int i2 = i5; i2 <= i6; i2++) {
                    View childAt = mzRecyclerView2.getChildAt(i2 - firstPosition);
                    if (childAt != null) {
                        childAt.setTranslationX(0.0f);
                        childAt.setAlpha(1.0f);
                    }
                }
            }

            public void onAnimationStart(Animator animator) {
                OnRecyclerViewFadeListener onRecyclerViewFadeListener = onRecyclerViewFadeListener2;
                if (onRecyclerViewFadeListener != null) {
                    onRecyclerViewFadeListener.onStartRecyclerViewFadeOut();
                }
            }
        });
        animatorSet.start();
    }
}
