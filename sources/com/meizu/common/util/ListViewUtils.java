package com.meizu.common.util;

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
import android.widget.BaseAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;

public class ListViewUtils {
    private static final int DEFAULT_DURATION = 300;
    private static final int DELAY_ANIMATION = 33;
    private Interpolator mAlInterpolator = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
    HashMap<Long, Integer> mItemIdTopMap = new HashMap<>();
    private Interpolator mTrInterpolator = new PathInterpolator(0.5f, 0.0f, 0.5f, 1.0f);
    /* access modifiers changed from: private */
    public Interpolator mUpInterpolator = new PathInterpolator(0.33f, 0.0f, 0.4f, 1.0f);

    public interface OnListViewFadeListener {
        void onEndListViewFadedOut();

        void onEndResetListView();

        void onStartListViewFadeOut();
    }

    /* access modifiers changed from: private */
    public void animateRemoval(final ListView listView, View view, final OnListViewFadeListener onListViewFadeListener) {
        final ArrayList arrayList = new ArrayList();
        for (int i = 0; i < listView.getCount(); i++) {
            arrayList.add(Integer.valueOf(i));
        }
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        for (int i2 = 0; i2 < listView.getChildCount(); i2++) {
            View childAt = listView.getChildAt(i2);
            if (childAt != view) {
                this.mItemIdTopMap.put(Long.valueOf((long) (firstVisiblePosition + i2)), Integer.valueOf(childAt.getTop()));
            }
        }
        if (onListViewFadeListener != null) {
            onListViewFadeListener.onEndListViewFadedOut();
            arrayList.remove(listView.getPositionForView(view));
        }
        listView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                listView.getViewTreeObserver().removeOnPreDrawListener(this);
                int firstVisiblePosition = listView.getFirstVisiblePosition();
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < listView.getChildCount(); i++) {
                    View childAt = listView.getChildAt(i);
                    Integer num = ListViewUtils.this.mItemIdTopMap.get(Long.valueOf((long) ((Integer) arrayList.get(firstVisiblePosition + i)).intValue()));
                    int top2 = childAt.getTop();
                    if (num == null) {
                        int height = childAt.getHeight() + listView.getDividerHeight();
                        if (i <= 0) {
                            height = -height;
                        }
                        Keyframe ofFloat = Keyframe.ofFloat(0.0f, (float) ((height + top2) - top2));
                        Keyframe ofFloat2 = Keyframe.ofFloat(1.0f, 0.0f);
                        ofFloat2.setInterpolator(ListViewUtils.this.mUpInterpolator);
                        arrayList.add(ObjectAnimator.ofPropertyValuesHolder(childAt, new PropertyValuesHolder[]{PropertyValuesHolder.ofKeyframe("translationY", new Keyframe[]{ofFloat, ofFloat2})}));
                    } else if (num.intValue() != top2) {
                        Keyframe ofFloat3 = Keyframe.ofFloat(0.0f, (float) (num.intValue() - top2));
                        Keyframe ofFloat4 = Keyframe.ofFloat(1.0f, 0.0f);
                        ofFloat4.setInterpolator(ListViewUtils.this.mUpInterpolator);
                        arrayList.add(ObjectAnimator.ofPropertyValuesHolder(childAt, new PropertyValuesHolder[]{PropertyValuesHolder.ofKeyframe("translationY", new Keyframe[]{ofFloat3, ofFloat4})}));
                    }
                }
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(arrayList);
                animatorSet.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        OnListViewFadeListener onListViewFadeListener = onListViewFadeListener;
                        if (onListViewFadeListener != null) {
                            onListViewFadeListener.onEndResetListView();
                        }
                    }
                });
                animatorSet.start();
                ListViewUtils.this.mItemIdTopMap.clear();
                return true;
            }
        });
    }

    public void fadeOutItemView(ListView listView, int i, int i2, OnListViewFadeListener onListViewFadeListener, BaseAdapter baseAdapter) {
        final int firstVisiblePosition = listView.getFirstVisiblePosition();
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (int i4 = i; i4 <= i2; i4++) {
            View childAt = listView.getChildAt(i4 - firstVisiblePosition);
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
        final OnListViewFadeListener onListViewFadeListener2 = onListViewFadeListener;
        final int i5 = i;
        final int i6 = i2;
        final ListView listView2 = listView;
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                int i = i5;
                if (i == i6) {
                    ListViewUtils listViewUtils = ListViewUtils.this;
                    ListView listView = listView2;
                    listViewUtils.animateRemoval(listView, listView.getChildAt(i - firstVisiblePosition), onListViewFadeListener2);
                } else {
                    OnListViewFadeListener onListViewFadeListener = onListViewFadeListener2;
                    if (onListViewFadeListener != null) {
                        onListViewFadeListener.onEndListViewFadedOut();
                    }
                }
                for (int i2 = i5; i2 <= i6; i2++) {
                    View childAt = listView2.getChildAt(i2 - firstVisiblePosition);
                    if (childAt != null) {
                        childAt.setTranslationX(0.0f);
                        childAt.setAlpha(1.0f);
                    }
                }
            }

            public void onAnimationStart(Animator animator) {
                OnListViewFadeListener onListViewFadeListener = onListViewFadeListener2;
                if (onListViewFadeListener != null) {
                    onListViewFadeListener.onStartListViewFadeOut();
                }
            }
        });
        animatorSet.start();
    }
}
