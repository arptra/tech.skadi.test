package com.bumptech.glide.request.target;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import com.bumptech.glide.request.transition.Transition;

public class AppWidgetTarget extends CustomTarget<Bitmap> {
    public final int[] d;
    public final ComponentName e;
    public final RemoteViews f;
    public final Context g;
    public final int h;

    /* renamed from: b */
    public void e(Bitmap bitmap, Transition transition) {
        f(bitmap);
    }

    public void d(Drawable drawable) {
        f((Bitmap) null);
    }

    public final void f(Bitmap bitmap) {
        this.f.setImageViewBitmap(this.h, bitmap);
        k();
    }

    public final void k() {
        AppWidgetManager instance = AppWidgetManager.getInstance(this.g);
        ComponentName componentName = this.e;
        if (componentName != null) {
            instance.updateAppWidget(componentName, this.f);
        } else {
            instance.updateAppWidget(this.d, this.f);
        }
    }
}
