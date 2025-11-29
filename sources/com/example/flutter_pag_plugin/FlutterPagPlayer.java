package com.example.flutter_pag_plugin;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import org.libpag.PAGFile;
import org.libpag.PAGPlayer;

public class FlutterPagPlayer extends PAGPlayer {
    public final ValueAnimator b = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
    public boolean c;
    public long d = 0;
    public double e = 0.0d;
    public double f = 0.0d;
    public ReleaseListener g;
    public MethodChannel h;
    public long i;
    public final ValueAnimator.AnimatorUpdateListener j = new ValueAnimator.AnimatorUpdateListener() {
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            FlutterPagPlayer.this.e = (double) ((Float) valueAnimator.getAnimatedValue()).floatValue();
            FlutterPagPlayer flutterPagPlayer = FlutterPagPlayer.this;
            flutterPagPlayer.d = (long) (flutterPagPlayer.e * ((double) FlutterPagPlayer.this.b.getDuration()));
            FlutterPagPlayer flutterPagPlayer2 = FlutterPagPlayer.this;
            flutterPagPlayer2.setProgress(flutterPagPlayer2.e);
            FlutterPagPlayer.this.flush();
        }
    };
    public final AnimatorListenerAdapter k = new AnimatorListenerAdapter() {
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            FlutterPagPlayer.this.h("onAnimationCancel");
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            int repeatCount = ((ValueAnimator) animator).getRepeatCount();
            if (repeatCount >= 0 && animator.getDuration() > 0 && FlutterPagPlayer.this.d / animator.getDuration() > ((long) repeatCount)) {
                FlutterPagPlayer.this.h("onAnimationEnd");
            }
        }

        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            FlutterPagPlayer.this.h("onAnimationRepeat");
        }

        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            FlutterPagPlayer.this.h("onAnimationStart");
        }
    };

    public interface ReleaseListener {
        void a();
    }

    public void f(PAGFile pAGFile, int i2, double d2, MethodChannel methodChannel, long j2) {
        setComposition(pAGFile);
        this.h = methodChannel;
        this.i = j2;
        this.e = d2;
        this.f = d2;
        g(i2);
    }

    public boolean flush() {
        if (this.c) {
            return false;
        }
        return super.flush();
    }

    public final void g(int i2) {
        this.b.setDuration(duration() / 1000);
        this.b.setInterpolator(new LinearInterpolator());
        this.b.addUpdateListener(this.j);
        this.b.addListener(this.k);
        if (i2 < 0) {
            i2 = 0;
        }
        this.b.setRepeatCount(i2 - 1);
        j(this.f);
    }

    public void h(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("textureId", Long.valueOf(this.i));
        hashMap.put("PAGEvent", str);
        this.h.invokeMethod("PAGCallback", hashMap);
    }

    public void i() {
        this.b.pause();
    }

    public void j(double d2) {
        double max = Math.max(0.0d, Math.min(d2, 1.0d));
        this.e = max;
        long duration = (long) (max * ((double) this.b.getDuration()));
        this.d = duration;
        this.b.setCurrentPlayTime(duration);
        setProgress(this.e);
        flush();
    }

    public void k(ReleaseListener releaseListener) {
        this.g = releaseListener;
    }

    public void l() {
        this.b.start();
    }

    public void m() {
        i();
        j(this.f);
    }

    public void release() {
        super.release();
        this.b.removeUpdateListener(this.j);
        this.b.removeListener(this.k);
        ReleaseListener releaseListener = this.g;
        if (releaseListener != null) {
            releaseListener.a();
        }
        this.c = true;
    }
}
