package com.upuphone.xr.sapp.vu.vm;

import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.hardware.usb.UsbDevice;
import android.os.Handler;
import android.view.Display;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.honey.account.constant.AccountConstantKt;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.PhoneTypeUtils;
import com.upuphone.xr.sapp.vu.receiver.ViewGlassesConnectListener;
import com.upuphone.xr.sapp.vu.utils.ArSpaceUtil;
import com.upuphone.xr.sapp.vu.utils.UsbPermissionHelper;
import com.upuphone.xr.sapp.vu.utils.VuGlassesHelper;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0006*\u0001J\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001NB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0003J\r\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0003J\r\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0003J\u0017\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b\u001a\u0010\u0019J\r\u0010\u001b\u001a\u00020\u0017¢\u0006\u0004\b\u001b\u0010\u0019J\r\u0010\u001c\u001a\u00020\u0017¢\u0006\u0004\b\u001c\u0010\u0019J\u0010\u0010\u001d\u001a\u00020\u0017H@¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u0004¢\u0006\u0004\b\u001f\u0010\u0003J\r\u0010 \u001a\u00020\u0004¢\u0006\u0004\b \u0010\u0003J\u0017\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b%\u0010$R\u001c\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0&8\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010'R\u001f\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0)8\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001f\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0)8\u0006¢\u0006\f\n\u0004\b/\u0010+\u001a\u0004\b0\u0010-R\u001d\u00104\u001a\b\u0012\u0004\u0012\u00020\u00170)8\u0006¢\u0006\f\n\u0004\b2\u0010+\u001a\u0004\b3\u0010-R\u0014\u00108\u001a\u0002058\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u001e\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001098\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010?\u001a\u00020\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R#\u0010F\u001a\n A*\u0004\u0018\u00010@0@8BX\u0002¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u0016\u0010I\u001a\u00020\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010M\u001a\u00020J8\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010L¨\u0006O"}, d2 = {"Lcom/upuphone/xr/sapp/vu/vm/VuGlassControlModel;", "Lcom/upuphone/xr/sapp/vu/receiver/ViewGlassesConnectListener;", "<init>", "()V", "", "p", "n", "", "r", "()J", "", "defaultName", "Lcom/upuphone/xr/sapp/vu/vm/VuGlassControlModel$ViewGlassesInfo;", "q", "(Ljava/lang/String;)Lcom/upuphone/xr/sapp/vu/vm/VuGlassControlModel$ViewGlassesInfo;", "B", "C", "m", "newName", "F", "(Ljava/lang/String;)V", "o", "()Lcom/upuphone/xr/sapp/vu/vm/VuGlassControlModel$ViewGlassesInfo;", "", "x", "()Z", "y", "z", "w", "A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "D", "E", "Landroid/hardware/usb/UsbDevice;", "usbDevice", "b", "(Landroid/hardware/usb/UsbDevice;)V", "a", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/MutableLiveData;", "_glassesInfo", "Landroidx/lifecycle/LiveData;", "c", "Landroidx/lifecycle/LiveData;", "v", "()Landroidx/lifecycle/LiveData;", "glassesInfo", "d", "u", "glassesDevice", "e", "s", "connectState", "Lkotlinx/coroutines/CoroutineScope;", "f", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Lkotlinx/coroutines/Deferred;", "g", "Lkotlinx/coroutines/Deferred;", "checkDisplayDeferred", "h", "Ljava/lang/String;", "defaultGlassName", "Landroid/hardware/display/DisplayManager;", "kotlin.jvm.PlatformType", "i", "Lkotlin/Lazy;", "t", "()Landroid/hardware/display/DisplayManager;", "displayManager", "j", "Z", "isStarted", "com/upuphone/xr/sapp/vu/vm/VuGlassControlModel$displayListener$1", "k", "Lcom/upuphone/xr/sapp/vu/vm/VuGlassControlModel$displayListener$1;", "displayListener", "ViewGlassesInfo", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nVuGlassControlModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VuGlassControlModel.kt\ncom/upuphone/xr/sapp/vu/vm/VuGlassControlModel\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,412:1\n314#2,11:413\n*S KotlinDebug\n*F\n+ 1 VuGlassControlModel.kt\ncom/upuphone/xr/sapp/vu/vm/VuGlassControlModel\n*L\n239#1:413,11\n*E\n"})
public final class VuGlassControlModel implements ViewGlassesConnectListener {

    /* renamed from: a  reason: collision with root package name */
    public static final VuGlassControlModel f8109a = new VuGlassControlModel();
    public static final MutableLiveData b;
    public static final LiveData c;
    public static final LiveData d;
    public static final LiveData e;
    public static final CoroutineScope f = CoroutineScopeKt.a(Dispatchers.c().plus(SupervisorKt.b((Job) null, 1, (Object) null)));
    public static Deferred g;
    public static final String h;
    public static final Lazy i = LazyKt.lazy(VuGlassControlModel$displayManager$2.INSTANCE);
    public static volatile boolean j;
    public static final VuGlassControlModel$displayListener$1 k = new VuGlassControlModel$displayListener$1();

    static {
        MutableLiveData mutableLiveData = new MutableLiveData((Object) null);
        b = mutableLiveData;
        c = Transformations.a(mutableLiveData);
        d = Transformations.a(Transformations.c(mutableLiveData, VuGlassControlModel$glassesDevice$1.INSTANCE));
        e = Transformations.a(Transformations.c(mutableLiveData, VuGlassControlModel$connectState$1.INSTANCE));
        String string = MainApplication.k.f().getString(R.string.view_glasses);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        h = string;
        mutableLiveData.setValue(ViewGlassesInfo.f.a((String) DataStoreUtils.i(DataStoreUtils.e.a(), "vu_connected_view_glass", "", (Context) null, 4, (Object) null)));
    }

    public final Object A(Continuation continuation) {
        if (w()) {
            return Boxing.boxBoolean(true);
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.x();
        UsbPermissionHelper usbPermissionHelper = UsbPermissionHelper.f8095a;
        ViewGlassesInfo viewGlassesInfo = (ViewGlassesInfo) b.getValue();
        usbPermissionHelper.d(viewGlassesInfo != null ? viewGlassesInfo.c() : null, new VuGlassControlModel$requestPermission$2$1(cancellableContinuationImpl));
        Job unused = BuildersKt__Builders_commonKt.d(f, (CoroutineContext) null, (CoroutineStart) null, new VuGlassControlModel$requestPermission$2$2(cancellableContinuationImpl, (Continuation<? super VuGlassControlModel$requestPermission$2$2>) null), 3, (Object) null);
        Object u = cancellableContinuationImpl.u();
        if (u == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return u;
    }

    public final void B() {
        if (!j) {
            ULog.f6446a.a("VuGlassControlModel", MzContactsContract.START_PARAM_KEY);
            j = true;
            t().registerDisplayListener(k, (Handler) null);
            Job unused = BuildersKt__Builders_commonKt.d(f, Dispatchers.b(), (CoroutineStart) null, new VuGlassControlModel$start$1((Continuation<? super VuGlassControlModel$start$1>) null), 2, (Object) null);
        }
    }

    public final void C() {
        if (j) {
            ULog.f6446a.a("VuGlassControlModel", "stop");
            j = false;
            MutableLiveData mutableLiveData = b;
            ViewGlassesInfo viewGlassesInfo = (ViewGlassesInfo) mutableLiveData.getValue();
            if (viewGlassesInfo != null) {
                mutableLiveData.setValue(new ViewGlassesInfo((UsbDevice) null, 0, viewGlassesInfo.b(), 0, 0));
            }
            t().unregisterDisplayListener(k);
        }
    }

    public final void D() {
        DataStoreUtils.e.a().o("vu_connected_view_glass", "");
        b.postValue(null);
    }

    public final void E() {
        D();
        ArSpaceUtil arSpaceUtil = ArSpaceUtil.f8089a;
        arSpaceUtil.b();
        arSpaceUtil.c();
    }

    public final void F(String str) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("VuGlassControlModel", "updateGlassesName: " + str);
        if (str != null && !StringsKt.isBlank(str)) {
            MutableLiveData mutableLiveData = b;
            ViewGlassesInfo viewGlassesInfo = new ViewGlassesInfo((ViewGlassesInfo) mutableLiveData.getValue());
            viewGlassesInfo.j(str);
            mutableLiveData.postValue(viewGlassesInfo);
            DataStoreUtils.e.a().o("vu_connected_view_glass", viewGlassesInfo.m());
        }
    }

    public void a(UsbDevice usbDevice) {
        String str;
        Intrinsics.checkNotNullParameter(usbDevice, "usbDevice");
        ULog.Delegate delegate = ULog.f6446a;
        int productId = usbDevice.getProductId();
        boolean z = j;
        delegate.g("VuGlassControlModel", "onDeviceRemoved: " + productId + ", " + z);
        Deferred deferred = g;
        if (deferred != null) {
            Job.DefaultImpls.a(deferred, (CancellationException) null, 1, (Object) null);
        }
        if (j) {
            delegate.g("VuGlassControlModel", "onDeviceRemoved: isViewDevice");
            MutableLiveData mutableLiveData = b;
            ViewGlassesInfo viewGlassesInfo = (ViewGlassesInfo) mutableLiveData.getValue();
            if (viewGlassesInfo == null || (str = viewGlassesInfo.b()) == null) {
                str = h;
            }
            mutableLiveData.setValue(new ViewGlassesInfo((UsbDevice) null, 0, str, 0, 0, 24, (DefaultConstructorMarker) null));
        }
    }

    public void b(UsbDevice usbDevice) {
        String str;
        Intrinsics.checkNotNullParameter(usbDevice, "usbDevice");
        ULog.Delegate delegate = ULog.f6446a;
        int productId = usbDevice.getProductId();
        boolean z = j;
        delegate.g("VuGlassControlModel", "onDeviceAdded: " + productId + ", " + z);
        if (j) {
            Deferred deferred = g;
            String str2 = null;
            if (deferred != null) {
                Job.DefaultImpls.a(deferred, (CancellationException) null, 1, (Object) null);
            }
            MutableLiveData mutableLiveData = b;
            ViewGlassesInfo viewGlassesInfo = (ViewGlassesInfo) mutableLiveData.getValue();
            Integer valueOf = viewGlassesInfo != null ? Integer.valueOf(viewGlassesInfo.a()) : null;
            if (viewGlassesInfo != null) {
                str2 = viewGlassesInfo.b();
            }
            delegate.g("VuGlassControlModel", "onDeviceAdded: isViewDevice, displayId: " + valueOf + ", name: " + str2);
            VuGlassesHelper vuGlassesHelper = VuGlassesHelper.f8099a;
            Display c2 = vuGlassesHelper.c();
            Point d2 = vuGlassesHelper.d(c2);
            int displayId = c2 != null ? c2.getDisplayId() : 0;
            if (viewGlassesInfo == null || (str = viewGlassesInfo.b()) == null) {
                str = h;
            }
            mutableLiveData.setValue(new ViewGlassesInfo(usbDevice, displayId, str, d2.x, d2.y));
            n();
        }
    }

    public final void m() {
        if (j) {
            Deferred deferred = g;
            if (deferred == null || !deferred.isActive()) {
                Job unused = BuildersKt__Builders_commonKt.d(f, (CoroutineContext) null, (CoroutineStart) null, new VuGlassControlModel$checkConnectedGlasses$1((Continuation<? super VuGlassControlModel$checkConnectedGlasses$1>) null), 3, (Object) null);
            }
        }
    }

    public final void n() {
        ULog.Delegate delegate = ULog.f6446a;
        Object value = b.getValue();
        delegate.g("VuGlassControlModel", "checkDisplayReady: isGlassConnected: " + value);
        if (!x()) {
            Deferred deferred = g;
            if (deferred == null || !deferred.isActive()) {
                delegate.a("VuGlassControlModel", "checkDisplayReady: display not connected");
                g = BuildersKt__Builders_commonKt.b(f, (CoroutineContext) null, (CoroutineStart) null, new VuGlassControlModel$checkDisplayReady$1((Continuation<? super VuGlassControlModel$checkDisplayReady$1>) null), 3, (Object) null);
            }
        }
    }

    public final ViewGlassesInfo o() {
        return (ViewGlassesInfo) b.getValue();
    }

    public final void p() {
        String str;
        MutableLiveData mutableLiveData = b;
        ViewGlassesInfo viewGlassesInfo = (ViewGlassesInfo) mutableLiveData.getValue();
        if (viewGlassesInfo == null || (str = viewGlassesInfo.b()) == null) {
            str = h;
        }
        ViewGlassesInfo q = q(str);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("VuGlassControlModel", "init: viewGlassesInfo=" + viewGlassesInfo);
        if (q != null) {
            viewGlassesInfo = q;
        }
        mutableLiveData.postValue(viewGlassesInfo);
        n();
    }

    public final ViewGlassesInfo q(String str) {
        String b2;
        ViewGlassesInfo viewGlassesInfo = (ViewGlassesInfo) b.getValue();
        VuGlassesHelper vuGlassesHelper = VuGlassesHelper.f8099a;
        UsbDevice b3 = vuGlassesHelper.b();
        if (b3 == null) {
            return null;
        }
        Display c2 = vuGlassesHelper.c();
        Point d2 = vuGlassesHelper.d(c2);
        return new ViewGlassesInfo(b3, c2 != null ? c2.getDisplayId() : viewGlassesInfo != null ? viewGlassesInfo.a() : 0, (viewGlassesInfo == null || (b2 = viewGlassesInfo.b()) == null) ? str : b2, d2.x, d2.y);
    }

    public final long r() {
        return PhoneTypeUtils.f7912a.d() ? 8000 : 5000;
    }

    public final LiveData s() {
        return e;
    }

    public final DisplayManager t() {
        return (DisplayManager) i.getValue();
    }

    public final LiveData u() {
        return d;
    }

    public final LiveData v() {
        return c;
    }

    public final boolean w() {
        ULog.Delegate delegate = ULog.f6446a;
        Object value = c.getValue();
        delegate.g("VuGlassControlModel", "hasPermission： glasses connected: " + value);
        UsbPermissionHelper usbPermissionHelper = UsbPermissionHelper.f8095a;
        ViewGlassesInfo viewGlassesInfo = (ViewGlassesInfo) b.getValue();
        return usbPermissionHelper.b(viewGlassesInfo != null ? viewGlassesInfo.c() : null);
    }

    public final boolean x() {
        MutableLiveData mutableLiveData = b;
        if (mutableLiveData.getValue() != null) {
            Object value = mutableLiveData.getValue();
            Intrinsics.checkNotNull(value);
            if (((ViewGlassesInfo) value).f()) {
                return true;
            }
        }
        return false;
    }

    public final boolean y() {
        MutableLiveData mutableLiveData = b;
        if (mutableLiveData.getValue() != null) {
            Object value = mutableLiveData.getValue();
            Intrinsics.checkNotNull(value);
            if (((ViewGlassesInfo) value).g()) {
                return true;
            }
        }
        return false;
    }

    public final boolean z() {
        MutableLiveData mutableLiveData = b;
        if (mutableLiveData.getValue() != null) {
            Object value = mutableLiveData.getValue();
            Intrinsics.checkNotNull(value);
            if (((ViewGlassesInfo) value).e()) {
                return true;
            }
        }
        return false;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b!\b\b\u0018\u0000 \u00112\u00020\u0001:\u0001.B;\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bB\u0013\b\u0016\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\n\u0010\rJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0010J\r\u0010\u0012\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0010J\r\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b\u0013\u0010\u0010J\r\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0019\u001a\u00020\u000e2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b#\u0010$R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010%R\"\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\"\u001a\u0004\b&\u0010\u0018\"\u0004\b'\u0010$R\"\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\"\u001a\u0004\b(\u0010\u0018\"\u0004\b)\u0010$R$\u0010-\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00068F@FX\u000e¢\u0006\f\u001a\u0004\b!\u0010\u0015\"\u0004\b+\u0010,¨\u0006/"}, d2 = {"Lcom/upuphone/xr/sapp/vu/vm/VuGlassControlModel$ViewGlassesInfo;", "", "Landroid/hardware/usb/UsbDevice;", "usbDevice", "", "displayId", "", "_name", "width", "height", "<init>", "(Landroid/hardware/usb/UsbDevice;ILjava/lang/String;II)V", "other", "(Lcom/upuphone/xr/sapp/vu/vm/VuGlassControlModel$ViewGlassesInfo;)V", "", "e", "()Z", "f", "g", "d", "m", "()Ljava/lang/String;", "toString", "hashCode", "()I", "equals", "(Ljava/lang/Object;)Z", "a", "Landroid/hardware/usb/UsbDevice;", "c", "()Landroid/hardware/usb/UsbDevice;", "k", "(Landroid/hardware/usb/UsbDevice;)V", "b", "I", "h", "(I)V", "Ljava/lang/String;", "getWidth", "l", "getHeight", "i", "value", "j", "(Ljava/lang/String;)V", "name", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class ViewGlassesInfo {
        public static final Companion f = new Companion((DefaultConstructorMarker) null);

        /* renamed from: a  reason: collision with root package name */
        public UsbDevice f8110a;
        public int b;
        public String c;
        public int d;
        public int e;

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/sapp/vu/vm/VuGlassControlModel$ViewGlassesInfo$Companion;", "", "<init>", "()V", "", "json", "Lcom/upuphone/xr/sapp/vu/vm/VuGlassControlModel$ViewGlassesInfo;", "a", "(Ljava/lang/String;)Lcom/upuphone/xr/sapp/vu/vm/VuGlassControlModel$ViewGlassesInfo;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final ViewGlassesInfo a(String str) {
                if (str == null || StringsKt.isBlank(str)) {
                    return null;
                }
                try {
                    String string = new JSONObject(str).getString("name");
                    Intrinsics.checkNotNull(string);
                    return new ViewGlassesInfo((UsbDevice) null, 0, string, 0, 0, 24, (DefaultConstructorMarker) null);
                } catch (Exception e) {
                    ULog.Delegate delegate = ULog.f6446a;
                    delegate.a("VuGlassControlModel", "ViewGlassesInfo fromJson error: " + e);
                    return null;
                }
            }

            public Companion() {
            }
        }

        public ViewGlassesInfo(UsbDevice usbDevice, int i, String str, int i2, int i3) {
            Intrinsics.checkNotNullParameter(str, "_name");
            this.f8110a = usbDevice;
            this.b = i;
            this.c = str;
            this.d = i2;
            this.e = i3;
        }

        public final int a() {
            return this.b;
        }

        public final String b() {
            String str = this.c;
            return StringsKt.isBlank(str) ? VuGlassControlModel.h : str;
        }

        public final UsbDevice c() {
            return this.f8110a;
        }

        public final boolean d() {
            return this.d == 3840;
        }

        public final boolean e() {
            return this.f8110a != null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ViewGlassesInfo)) {
                return false;
            }
            ViewGlassesInfo viewGlassesInfo = (ViewGlassesInfo) obj;
            return Intrinsics.areEqual((Object) this.f8110a, (Object) viewGlassesInfo.f8110a) && this.b == viewGlassesInfo.b && Intrinsics.areEqual((Object) this.c, (Object) viewGlassesInfo.c) && this.d == viewGlassesInfo.d && this.e == viewGlassesInfo.e;
        }

        public final boolean f() {
            return this.f8110a != null && this.b > 0;
        }

        public final boolean g() {
            return e() && this.b == -1;
        }

        public final void h(int i) {
            this.b = i;
        }

        public int hashCode() {
            UsbDevice usbDevice = this.f8110a;
            return ((((((((usbDevice == null ? 0 : usbDevice.hashCode()) * 31) + Integer.hashCode(this.b)) * 31) + this.c.hashCode()) * 31) + Integer.hashCode(this.d)) * 31) + Integer.hashCode(this.e);
        }

        public final void i(int i) {
            this.e = i;
        }

        public final void j(String str) {
            Intrinsics.checkNotNullParameter(str, AccountConstantKt.RESPONSE_VALUE);
            this.c = str;
        }

        public final void k(UsbDevice usbDevice) {
            this.f8110a = usbDevice;
        }

        public final void l(int i) {
            this.d = i;
        }

        public final String m() {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", b());
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
            return jSONObject2;
        }

        public String toString() {
            UsbDevice usbDevice = this.f8110a;
            int i = this.b;
            String str = this.c;
            int i2 = this.d;
            int i3 = this.e;
            return "ViewGlassesInfo(usbDevice=" + usbDevice + ", displayId=" + i + ", _name=" + str + ", width=" + i2 + ", height=" + i3 + ")";
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ ViewGlassesInfo(android.hardware.usb.UsbDevice r4, int r5, java.lang.String r6, int r7, int r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
            /*
                r3 = this;
                r10 = r9 & 1
                if (r10 == 0) goto L_0x0005
                r4 = 0
            L_0x0005:
                r10 = r9 & 2
                r0 = 0
                if (r10 == 0) goto L_0x000c
                r10 = r0
                goto L_0x000d
            L_0x000c:
                r10 = r5
            L_0x000d:
                r5 = r9 & 4
                if (r5 == 0) goto L_0x0013
                java.lang.String r6 = ""
            L_0x0013:
                r1 = r6
                r5 = r9 & 8
                if (r5 == 0) goto L_0x001a
                r2 = r0
                goto L_0x001b
            L_0x001a:
                r2 = r7
            L_0x001b:
                r5 = r9 & 16
                if (r5 == 0) goto L_0x0020
                goto L_0x0021
            L_0x0020:
                r0 = r8
            L_0x0021:
                r5 = r3
                r6 = r4
                r7 = r10
                r8 = r1
                r9 = r2
                r10 = r0
                r5.<init>(r6, r7, r8, r9, r10)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.vu.vm.VuGlassControlModel.ViewGlassesInfo.<init>(android.hardware.usb.UsbDevice, int, java.lang.String, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public ViewGlassesInfo(com.upuphone.xr.sapp.vu.vm.VuGlassControlModel.ViewGlassesInfo r8) {
            /*
                r7 = this;
                if (r8 == 0) goto L_0x0006
                android.hardware.usb.UsbDevice r0 = r8.f8110a
            L_0x0004:
                r2 = r0
                goto L_0x0008
            L_0x0006:
                r0 = 0
                goto L_0x0004
            L_0x0008:
                r0 = 0
                if (r8 == 0) goto L_0x000f
                int r1 = r8.b
                r3 = r1
                goto L_0x0010
            L_0x000f:
                r3 = r0
            L_0x0010:
                if (r8 == 0) goto L_0x001b
                java.lang.String r1 = r8.b()
                if (r1 != 0) goto L_0x0019
                goto L_0x001b
            L_0x0019:
                r4 = r1
                goto L_0x001e
            L_0x001b:
                java.lang.String r1 = ""
                goto L_0x0019
            L_0x001e:
                if (r8 == 0) goto L_0x0024
                int r1 = r8.d
                r5 = r1
                goto L_0x0025
            L_0x0024:
                r5 = r0
            L_0x0025:
                if (r8 == 0) goto L_0x002b
                int r8 = r8.e
                r6 = r8
                goto L_0x002c
            L_0x002b:
                r6 = r0
            L_0x002c:
                r1 = r7
                r1.<init>(r2, r3, r4, r5, r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.vu.vm.VuGlassControlModel.ViewGlassesInfo.<init>(com.upuphone.xr.sapp.vu.vm.VuGlassControlModel$ViewGlassesInfo):void");
        }
    }
}
