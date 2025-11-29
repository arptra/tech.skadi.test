package com.upuphone.ar.navi.lite.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.upuphone.ar.navi.lite.R;

public class NaviProgressView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public AnimationSet f5831a;

    public NaviProgressView(@NonNull Context context) {
        super(context);
        c();
        d(context);
    }

    public final void a() {
        AnimationSet animationSet = this.f5831a;
        if (animationSet != null) {
            animationSet.cancel();
            this.f5831a.getAnimations().clear();
        }
    }

    public void b() {
        a();
    }

    public final void c() {
        this.f5831a = new AnimationSet(true);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setStartOffset(0);
        rotateAnimation.setDuration(1000);
        this.f5831a.setInterpolator(new LinearInterpolator());
        this.f5831a.addAnimation(rotateAnimation);
    }

    public void d(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.navi_progress_view_layout, this);
        ((ImageView) findViewById(R.id.img_loading)).startAnimation(this.f5831a);
    }

    public NaviProgressView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
        d(context);
    }
}
