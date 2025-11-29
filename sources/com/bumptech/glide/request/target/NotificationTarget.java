package com.bumptech.glide.request.target;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Preconditions;

public class NotificationTarget extends CustomTarget<Bitmap> {
    public final RemoteViews d;
    public final Context e;
    public final int f;
    public final String g;
    public final Notification h;
    public final int i;

    private void f(Bitmap bitmap) {
        this.d.setImageViewBitmap(this.i, bitmap);
        k();
    }

    private void k() {
        ((NotificationManager) Preconditions.d((NotificationManager) this.e.getSystemService("notification"))).notify(this.g, this.f, this.h);
    }

    /* renamed from: b */
    public void e(Bitmap bitmap, Transition transition) {
        f(bitmap);
    }

    public void d(Drawable drawable) {
        f((Bitmap) null);
    }
}
