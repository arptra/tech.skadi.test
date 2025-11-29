package com.luck.picture.lib.animators;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class AlphaInAnimationAdapter extends BaseAnimationAdapter {
    public final float f;

    public AlphaInAnimationAdapter(RecyclerView.Adapter adapter) {
        this(adapter, 0.0f);
    }

    public Animator[] g(View view) {
        return new Animator[]{ObjectAnimator.ofFloat(view, "alpha", new float[]{this.f, 1.0f})};
    }

    public AlphaInAnimationAdapter(RecyclerView.Adapter adapter, float f2) {
        super(adapter);
        this.f = f2;
    }
}
