package com.ucar.vehiclesdk;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import androidx.annotation.Nullable;
import com.easy.logger.EasyLog;
import com.honey.account.h3.a0;
import com.honey.account.h3.b0;
import com.honey.account.h3.c0;
import com.honey.account.h3.d0;
import com.ucar.vehiclesdk.SurfaceProvider;
import com.ucar.vehiclesdk.UCarCommon;
import java.util.ArrayList;
import java.util.List;

public class UCarTextureView extends TextureView implements ISurfaceEventListener {

    /* renamed from: a  reason: collision with root package name */
    public final List f5398a;
    public final Object b;
    public final VideoSurfaceProvider c;
    public boolean d;
    public Surface e;

    public class VideoSurfaceProvider extends SurfaceProvider {
        public VideoSurfaceProvider() {
        }

        public void a(int i, UCarCommon.VisibleRegion visibleRegion) {
            float c;
            float h;
            float f;
            int i2;
            float width = (float) UCarTextureView.this.getWidth();
            float f2 = width / 2.0f;
            float height = (float) UCarTextureView.this.getHeight();
            float f3 = height / 2.0f;
            float f4 = width * 1.0f;
            float f5 = f4 / height;
            float f6 = height * 1.0f;
            float f7 = f6 / width;
            Matrix matrix = new Matrix();
            if (i == 0) {
                matrix.postRotate(0.0f, f2, f3);
            } else if (i == 1) {
                matrix.postRotate(-90.0f, f2, f3);
                matrix.postScale(f5, f7, f2, f3);
            } else if (i == 2) {
                matrix.postRotate(-180.0f, f2, f3);
            } else {
                matrix.postRotate(-270.0f, f2, f3);
                matrix.postScale(f5, f7, f2, f3);
            }
            if (visibleRegion != null && visibleRegion.d()) {
                if (i == 1 || i == 3) {
                    c = f4 / ((float) visibleRegion.c());
                    h = f6 / ((float) visibleRegion.h());
                    f = (f4 / ((float) visibleRegion.f)) / c;
                    i2 = visibleRegion.e;
                } else {
                    c = f4 / ((float) visibleRegion.h());
                    h = f6 / ((float) visibleRegion.c());
                    f = (f4 / ((float) visibleRegion.e)) / c;
                    i2 = visibleRegion.f;
                }
                matrix.postScale(1.0f / f, 1.0f / ((f6 / ((float) i2)) / h), f2, f3);
                if (!(visibleRegion.g() == visibleRegion.a() && visibleRegion.e() == visibleRegion.f())) {
                    if (i == 0) {
                        matrix.postTranslate((((float) (visibleRegion.f() - visibleRegion.e())) / 2.0f) * c, (((float) (visibleRegion.a() - visibleRegion.g())) / 2.0f) * h);
                    } else if (i == 1) {
                        matrix.postTranslate((((float) (visibleRegion.a() - visibleRegion.g())) / 2.0f) * c, (((float) (visibleRegion.e() - visibleRegion.f())) / 2.0f) * h);
                    } else if (i == 2) {
                        matrix.postTranslate((((float) (visibleRegion.e() - visibleRegion.f())) / 2.0f) * c, (((float) (visibleRegion.g() - visibleRegion.a())) / 2.0f) * h);
                    } else {
                        matrix.postTranslate((((float) (visibleRegion.g() - visibleRegion.a())) / 2.0f) * c, (((float) (visibleRegion.f() - visibleRegion.e())) / 2.0f) * h);
                    }
                }
            }
            UCarTextureView.this.setTransform(matrix);
        }
    }

    public UCarTextureView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    public void p() {
        EasyLog.a("UCarTextureView", "notifySurfaceChanged");
        this.d = true;
        synchronized (this.b) {
            this.f5398a.forEach(new c0(this));
        }
    }

    /* access modifiers changed from: private */
    public void r() {
        EasyLog.a("UCarTextureView", "notifySurfaceCreated");
        synchronized (this.b) {
            this.f5398a.forEach(new a0(this));
        }
    }

    /* access modifiers changed from: private */
    public void s() {
        EasyLog.a("UCarTextureView", "notifySurfaceDestroyed");
        synchronized (this.b) {
            this.f5398a.forEach(new b0(this));
        }
    }

    public void a(int i, UCarCommon.VisibleRegion visibleRegion) {
        this.c.a(i, visibleRegion);
    }

    public SurfaceProvider getSurfaceProvider() {
        return this.c;
    }

    public final /* synthetic */ void l(SurfaceProvider.Callback callback) {
        callback.a(this.c, getWidth(), getHeight());
    }

    public final /* synthetic */ void m() {
        Surface surface;
        if (!this.d && (surface = this.e) != null && surface.isValid() && getWidth() > 0 && getHeight() > 0) {
            p();
        }
    }

    public final /* synthetic */ void n(SurfaceProvider.Callback callback) {
        callback.c(this.c);
    }

    public final /* synthetic */ void o(SurfaceProvider.Callback callback) {
        callback.b(this.c);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        EasyLog.a("UCarTextureView", "onAttachedToWindow");
        this.d = false;
        UCarAdapter.R0().a2(this);
        q();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        UCarAdapter.R0().B2(this);
        this.d = false;
        EasyLog.a("UCarTextureView", "onDetachedFromWindow");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        EasyLog.a("UCarTextureView", "onTouchEvent, action:" + motionEvent.getAction());
        int action = motionEvent.getAction();
        int pointerCount = motionEvent.getPointerCount();
        int[] iArr = new int[pointerCount];
        int[] iArr2 = new int[pointerCount];
        int[] iArr3 = new int[pointerCount];
        for (int i = 0; i < pointerCount; i++) {
            iArr[i] = motionEvent.getPointerId(i);
            iArr2[i] = (int) motionEvent.getX(i);
            iArr3[i] = (int) motionEvent.getY(i);
        }
        UCarAdapter.R0().n2(action, pointerCount, iArr, iArr2, iArr3);
        return true;
    }

    public final void q() {
        post(new d0(this));
    }

    public void setSurfaceTextureListener(@Nullable TextureView.SurfaceTextureListener surfaceTextureListener) {
        EasyLog.i("UCarTextureView", "call setSurfaceTextureListener will no effect.");
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        q();
    }

    public UCarTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5398a = new ArrayList();
        this.b = new Object();
        this.d = false;
        this.c = new VideoSurfaceProvider();
        super.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() {
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                EasyLog.a("UCarTextureView", "onSurfaceTextureAvailable. width: " + i + ", height: " + i2);
                if (UCarTextureView.this.e != null) {
                    UCarTextureView.this.s();
                    try {
                        UCarTextureView.this.e.release();
                    } catch (Exception e) {
                        EasyLog.d("UCarTextureView", "video surface release failed", e);
                    }
                    Surface unused = UCarTextureView.this.e = null;
                }
                Surface unused2 = UCarTextureView.this.e = new Surface(surfaceTexture);
                UCarTextureView.this.r();
                if (i > 0 && i2 > 0) {
                    UCarTextureView.this.p();
                }
            }

            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                EasyLog.a("UCarTextureView", "onSurfaceTextureDestroyed");
                boolean unused = UCarTextureView.this.d = false;
                UCarTextureView.this.s();
                if (UCarTextureView.this.e == null) {
                    return true;
                }
                try {
                    UCarTextureView.this.e.release();
                } catch (Exception e) {
                    EasyLog.d("UCarTextureView", "video surface release failed", e);
                }
                Surface unused2 = UCarTextureView.this.e = null;
                return true;
            }

            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                EasyLog.a("UCarTextureView", "onSurfaceTextureSizeChanged. width: " + i + ", height: " + i2);
                if (i > 0 && i2 > 0) {
                    UCarTextureView.this.p();
                }
            }

            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        });
    }
}
