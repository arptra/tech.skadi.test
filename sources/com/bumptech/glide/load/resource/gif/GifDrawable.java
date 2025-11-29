package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.gif.GifFrameLoader;
import com.bumptech.glide.util.Preconditions;
import com.xjsd.ai.assistant.protocol.CmdCode;
import java.nio.ByteBuffer;
import java.util.List;

public class GifDrawable extends Drawable implements GifFrameLoader.FrameCallback, Animatable, Animatable2Compat {

    /* renamed from: a  reason: collision with root package name */
    public final GifState f2663a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public int f;
    public int g;
    public boolean h;
    public Paint i;
    public Rect j;
    public List k;

    public static final class GifState extends Drawable.ConstantState {
        @VisibleForTesting
        final GifFrameLoader frameLoader;

        public GifState(GifFrameLoader gifFrameLoader) {
            this.frameLoader = gifFrameLoader;
        }

        public int getChangingConfigurations() {
            return 0;
        }

        @NonNull
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        @NonNull
        public Drawable newDrawable() {
            return new GifDrawable(this);
        }
    }

    public GifDrawable(Context context, GifDecoder gifDecoder, Transformation transformation, int i2, int i3, Bitmap bitmap) {
        this(new GifState(new GifFrameLoader(Glide.c(context), gifDecoder, i2, i3, transformation, bitmap)));
    }

    public void a() {
        if (b() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (g() == f() - 1) {
            this.f++;
        }
        int i2 = this.g;
        if (i2 != -1 && this.f >= i2) {
            j();
            stop();
        }
    }

    public final Drawable.Callback b() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        return callback;
    }

    public ByteBuffer c() {
        return this.f2663a.frameLoader.getBuffer();
    }

    public final Rect d() {
        if (this.j == null) {
            this.j = new Rect();
        }
        return this.j;
    }

    public void draw(Canvas canvas) {
        if (!this.d) {
            if (this.h) {
                Gravity.apply(CmdCode.CODE_RESET_VAD_STATUS, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), d());
                this.h = false;
            }
            canvas.drawBitmap(this.f2663a.frameLoader.getCurrentFrame(), (Rect) null, d(), h());
        }
    }

    public Bitmap e() {
        return this.f2663a.frameLoader.getFirstFrame();
    }

    public int f() {
        return this.f2663a.frameLoader.getFrameCount();
    }

    public int g() {
        return this.f2663a.frameLoader.getCurrentIndex();
    }

    public Drawable.ConstantState getConstantState() {
        return this.f2663a;
    }

    public int getIntrinsicHeight() {
        return this.f2663a.frameLoader.getHeight();
    }

    public int getIntrinsicWidth() {
        return this.f2663a.frameLoader.getWidth();
    }

    public int getOpacity() {
        return -2;
    }

    public final Paint h() {
        if (this.i == null) {
            this.i = new Paint(2);
        }
        return this.i;
    }

    public int i() {
        return this.f2663a.frameLoader.getSize();
    }

    public boolean isRunning() {
        return this.b;
    }

    public final void j() {
        List list = this.k;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((Animatable2Compat.AnimationCallback) this.k.get(i2)).onAnimationEnd(this);
            }
        }
    }

    public void k() {
        this.d = true;
        this.f2663a.frameLoader.clear();
    }

    public final void l() {
        this.f = 0;
    }

    public void m(Transformation transformation, Bitmap bitmap) {
        this.f2663a.frameLoader.setFrameTransformation(transformation, bitmap);
    }

    public final void n() {
        Preconditions.a(!this.d, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f2663a.frameLoader.getFrameCount() == 1) {
            invalidateSelf();
        } else if (!this.b) {
            this.b = true;
            this.f2663a.frameLoader.subscribe(this);
            invalidateSelf();
        }
    }

    public final void o() {
        this.b = false;
        this.f2663a.frameLoader.unsubscribe(this);
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.h = true;
    }

    public void setAlpha(int i2) {
        h().setAlpha(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        h().setColorFilter(colorFilter);
    }

    public boolean setVisible(boolean z, boolean z2) {
        Preconditions.a(!this.d, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.e = z;
        if (!z) {
            o();
        } else if (this.c) {
            n();
        }
        return super.setVisible(z, z2);
    }

    public void start() {
        this.c = true;
        l();
        if (this.e) {
            n();
        }
    }

    public void stop() {
        this.c = false;
        o();
    }

    public GifDrawable(GifState gifState) {
        this.e = true;
        this.g = -1;
        this.f2663a = (GifState) Preconditions.d(gifState);
    }
}
