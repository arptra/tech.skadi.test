package com.upuphone.starrycommon.egl;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.upuphone.starrycommon.egl.EglBase;
import com.upuphone.starrycommon.utils.StarryCastLog;

public class EglBase10 extends EglBase {

    /* renamed from: com.upuphone.starrycommon.egl.EglBase10$1FakeSurfaceHolder  reason: invalid class name */
    class AnonymousClass1FakeSurfaceHolder implements SurfaceHolder {

        /* renamed from: a  reason: collision with root package name */
        public final Surface f6486a;

        public void addCallback(SurfaceHolder.Callback callback) {
            StarryCastLog.a("addCallback");
        }

        public Surface getSurface() {
            return this.f6486a;
        }

        public Rect getSurfaceFrame() {
            return null;
        }

        public boolean isCreating() {
            return false;
        }

        public Canvas lockCanvas() {
            return null;
        }

        public void removeCallback(SurfaceHolder.Callback callback) {
            StarryCastLog.a("removeCallback");
        }

        public void setFixedSize(int i, int i2) {
            StarryCastLog.a("setFixedSize");
        }

        public void setFormat(int i) {
            StarryCastLog.a("setFormat");
        }

        public void setKeepScreenOn(boolean z) {
            StarryCastLog.a("setKeepScreenOn");
        }

        public void setSizeFromLayout() {
            StarryCastLog.a("setSizeFromLayout");
        }

        public void setType(int i) {
            StarryCastLog.a("setType");
        }

        public void unlockCanvasAndPost(Canvas canvas) {
            StarryCastLog.a("unlockCanvasAndPost");
        }

        public Canvas lockCanvas(Rect rect) {
            return null;
        }
    }

    public static class Context extends EglBase.Context {
    }
}
