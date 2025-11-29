package com.upuphone.xr.sapp.common;

import android.app.Activity;
import android.view.OrientationEventListener;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000  2\u00020\u0001:\u0002!\"R\u001c\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0016\u0010\u0011\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR$\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00128F@FX\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u0019\u0010\u001f¨\u0006#"}, d2 = {"Lcom/upuphone/xr/sapp/common/OrientationSensorHelper;", "", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "a", "Ljava/lang/ref/WeakReference;", "mActivityWeakRef", "b", "Landroid/app/Activity;", "mActivity", "", "c", "Z", "isPortLock", "d", "isLandLock", "e", "isFullScreen", "", "f", "I", "degree", "g", "mOrientation", "Lcom/upuphone/xr/sapp/common/OrientationSensorHelper$ScreenState;", "h", "Lcom/upuphone/xr/sapp/common/OrientationSensorHelper$ScreenState;", "mScreenState", "orientation", "getOrientation", "()I", "(I)V", "i", "Companion", "ScreenState", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class OrientationSensorHelper {
    public static final Companion i = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference f6661a;
    public final Activity b;
    public boolean c;
    public boolean d;
    public boolean e;
    public int f;
    public int g;
    public ScreenState h;

    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/upuphone/xr/sapp/common/OrientationSensorHelper$1", "Landroid/view/OrientationEventListener;", "", "orientation", "", "onOrientationChanged", "(I)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    /* renamed from: com.upuphone.xr.sapp.common.OrientationSensorHelper$1  reason: invalid class name */
    public final class AnonymousClass1 extends OrientationEventListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OrientationSensorHelper f6662a;

        public void onOrientationChanged(int i) {
            int i2;
            if (i != -1) {
                if (i > 350 || i < 10) {
                    i2 = 0;
                } else if (i > 80 && i < 100) {
                    i2 = 90;
                } else if (i > 170 && i < 190) {
                    i2 = 180;
                } else if (i > 260 && i < 280) {
                    i2 = 270;
                } else {
                    return;
                }
                if (i2 != this.f6662a.f) {
                    this.f6662a.f = i2;
                    if ((this.f6662a.f == 90 || this.f6662a.f == 270) && !this.f6662a.c && ((Activity) this.f6662a.f6661a.get()) != null) {
                        if (this.f6662a.f == 90) {
                            if (this.f6662a.e) {
                                this.f6662a.h(8);
                            }
                        } else if (this.f6662a.f == 270 && this.f6662a.e) {
                            this.f6662a.h(0);
                        }
                    }
                    if ((this.f6662a.f != 0 && this.f6662a.f != 180) || this.f6662a.d || ((Activity) this.f6662a.f6661a.get()) == null) {
                        return;
                    }
                    if (this.f6662a.e) {
                        ScreenState c = this.f6662a.h;
                        if (c != null) {
                            c.a();
                        }
                        this.f6662a.h(1);
                        return;
                    }
                    this.f6662a.h(1);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/common/OrientationSensorHelper$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/common/OrientationSensorHelper$ScreenState;", "", "", "a", "()V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public interface ScreenState {
        void a();
    }

    public final void h(int i2) {
        this.g = i2;
        Activity activity = this.b;
        Intrinsics.checkNotNull(activity);
        activity.setRequestedOrientation(i2);
    }
}
