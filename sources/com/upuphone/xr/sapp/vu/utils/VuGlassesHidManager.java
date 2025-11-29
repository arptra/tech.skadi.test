package com.upuphone.xr.sapp.vu.utils;

import android.hardware.usb.UsbDevice;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.utils.PhoneTypeUtils;
import com.upuphone.xr.sapp.vu.ArSpaceService;
import com.upuphone.xr.sapp.vu.utils.GlassesManager;
import com.upuphone.xr.sapp.vu.vm.VuGlassControlModel;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u00016B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\u0003J#\u0010\r\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u000bH@¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000bH@¢\u0006\u0004\b\u0011\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\t¢\u0006\u0004\b\u0015\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u000bH@¢\u0006\u0004\b\u0016\u0010\u0010J\u0010\u0010\u0017\u001a\u00020\u000bH@¢\u0006\u0004\b\u0017\u0010\u0010J\u0010\u0010\u0018\u001a\u00020\u000bH@¢\u0006\u0004\b\u0018\u0010\u0010J\u001a\u0010\u001b\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H@¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001d\u0010\u0003J\u0017\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0004H\u0002¢\u0006\u0004\b!\u0010\u0003R\u0014\u0010%\u001a\u00020\"8\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\t0&8\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00010&8\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010(R\u0016\u0010.\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u001e\u00102\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00105\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00104¨\u00067"}, d2 = {"Lcom/upuphone/xr/sapp/vu/utils/VuGlassesHidManager;", "Lcom/upuphone/xr/sapp/vu/utils/GlassesManager$IGlassesServiceConnection;", "<init>", "()V", "", "p", "o", "onServiceConnected", "a", "Lcom/upuphone/xr/sapp/vu/utils/VuGlassesHidManager$UsbOpenResultListener;", "openResultListener", "", "restart", "w", "(Lcom/upuphone/xr/sapp/vu/utils/VuGlassesHidManager$UsbOpenResultListener;Z)V", "y", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "m", "listener", "l", "(Lcom/upuphone/xr/sapp/vu/utils/VuGlassesHidManager$UsbOpenResultListener;)V", "t", "u", "v", "z", "Landroid/hardware/usb/UsbDevice;", "usbDevice", "s", "(Landroid/hardware/usb/UsbDevice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "n", "device", "q", "(Landroid/hardware/usb/UsbDevice;)V", "r", "Lkotlinx/coroutines/CoroutineScope;", "b", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Ljava/util/concurrent/CopyOnWriteArraySet;", "c", "Ljava/util/concurrent/CopyOnWriteArraySet;", "usbOpenResultListeners", "d", "hidServiceConnectionListeners", "e", "Z", "isResumed", "Lkotlinx/coroutines/Deferred;", "f", "Lkotlinx/coroutines/Deferred;", "openUsbDeferred", "g", "Landroid/hardware/usb/UsbDevice;", "connectedUsbDevice", "UsbOpenResultListener", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nVuGlassesHidManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VuGlassesHidManager.kt\ncom/upuphone/xr/sapp/vu/utils/VuGlassesHidManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,295:1\n1855#2,2:296\n1855#2,2:298\n1855#2,2:311\n314#3,11:300\n*S KotlinDebug\n*F\n+ 1 VuGlassesHidManager.kt\ncom/upuphone/xr/sapp/vu/utils/VuGlassesHidManager\n*L\n60#1:296,2\n69#1:298,2\n203#1:311,2\n154#1:300,11\n*E\n"})
public final class VuGlassesHidManager implements GlassesManager.IGlassesServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public static final VuGlassesHidManager f8100a;
    public static final CoroutineScope b = CoroutineScopeKt.a(Dispatchers.b().plus(SupervisorKt.b((Job) null, 1, (Object) null)));
    public static final CopyOnWriteArraySet c = new CopyOnWriteArraySet();
    public static final CopyOnWriteArraySet d = new CopyOnWriteArraySet();
    public static volatile boolean e;
    public static volatile Deferred f;
    public static volatile UsbDevice g;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bæ\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/upuphone/xr/sapp/vu/utils/VuGlassesHidManager$UsbOpenResultListener;", "", "", "result", "", "b", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public interface UsbOpenResultListener {
        Object b(boolean z, Continuation continuation);
    }

    static {
        VuGlassesHidManager vuGlassesHidManager = new VuGlassesHidManager();
        f8100a = vuGlassesHidManager;
        VuGlassesHidUtil.f8104a.v(vuGlassesHidManager);
        vuGlassesHidManager.n();
    }

    public static /* synthetic */ void x(VuGlassesHidManager vuGlassesHidManager, UsbOpenResultListener usbOpenResultListener, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            usbOpenResultListener = null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        vuGlassesHidManager.w(usbOpenResultListener, z);
    }

    public void a() {
        ULog.f6446a.a("VuGlassesHidManager", "Glasses onServiceDisconnected");
        ArSpaceService.j.d();
        for (GlassesManager.IGlassesServiceConnection a2 : d) {
            a2.a();
        }
        Deferred deferred = f;
        if (deferred != null) {
            Job.DefaultImpls.a(deferred, (CancellationException) null, 1, (Object) null);
        }
        f = null;
        Job unused = BuildersKt__Builders_commonKt.d(b, Dispatchers.c(), (CoroutineStart) null, new VuGlassesHidManager$onServiceDisconnected$2((Continuation<? super VuGlassesHidManager$onServiceDisconnected$2>) null), 2, (Object) null);
    }

    public final void l(UsbOpenResultListener usbOpenResultListener) {
        Intrinsics.checkNotNullParameter(usbOpenResultListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        c.add(usbOpenResultListener);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m(kotlin.coroutines.Continuation r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager$checkUsbPermission$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager$checkUsbPermission$1 r0 = (com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager$checkUsbPermission$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager$checkUsbPermission$1 r0 = new com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager$checkUsbPermission$1
            r0.<init>(r6, r7)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L_0x0036
            if (r1 != r2) goto L_0x002e
            boolean r1 = r0.Z$0
            int r3 = r0.I$0
            kotlin.ResultKt.throwOnFailure(r6)
        L_0x002c:
            r6 = r3
            goto L_0x003b
        L_0x002e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            r6 = 3
            r1 = 0
        L_0x003b:
            java.lang.String r3 = "VuGlassesHidManager"
            if (r6 <= 0) goto L_0x0060
            com.upuphone.star.core.log.ULog$Delegate r1 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r4 = "checkUsbAgain wait device connect"
            r1.a(r3, r4)
            com.upuphone.xr.sapp.vu.vm.VuGlassControlModel r1 = com.upuphone.xr.sapp.vu.vm.VuGlassControlModel.f8109a
            boolean r1 = r1.w()
            if (r1 == 0) goto L_0x004f
            goto L_0x0060
        L_0x004f:
            int r3 = r6 + -1
            r0.I$0 = r3
            r0.Z$0 = r1
            r0.label = r2
            r4 = 50
            java.lang.Object r6 = kotlinx.coroutines.DelayKt.b(r4, r0)
            if (r6 != r7) goto L_0x002c
            return r7
        L_0x0060:
            com.upuphone.star.core.log.ULog$Delegate r6 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "checkUsbAgain: connect result: "
            r7.append(r0)
            r7.append(r1)
            java.lang.String r7 = r7.toString()
            r6.a(r3, r7)
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r1)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager.m(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void n() {
        VuGlassControlModel.f8109a.u().observeForever(new VuGlassesHidManager$sam$androidx_lifecycle_Observer$0(VuGlassesHidManager$listenViewGlassConnect$1.INSTANCE));
    }

    public final void o() {
        e = false;
    }

    public void onServiceConnected() {
        ULog.f6446a.a("VuGlassesHidManager", "Glasses onServiceConnected");
        for (GlassesManager.IGlassesServiceConnection onServiceConnected : d) {
            onServiceConnected.onServiceConnected();
        }
        VuGlassesEventDispatcher.f8098a.m();
    }

    public final void p() {
        e = true;
        ULog.f6446a.a("VuGlassesHidManager", "onResume");
        if (PhoneTypeUtils.f7912a.h()) {
            Job unused = BuildersKt__Builders_commonKt.d(b, (CoroutineContext) null, (CoroutineStart) null, new VuGlassesHidManager$onResume$1((Continuation<? super VuGlassesHidManager$onResume$1>) null), 3, (Object) null);
        }
    }

    public final void q(UsbDevice usbDevice) {
        ULog.f6446a.a("VuGlassesHidManager", "onViewGlassConnected");
        g = usbDevice;
        VuGlassesActiveHelper.f8097a.h();
    }

    public final void r() {
        ULog.Delegate delegate = ULog.f6446a;
        UsbDevice usbDevice = g;
        delegate.a("VuGlassesHidManager", "onViewGlassDisconnected: " + usbDevice);
        UsbDevice usbDevice2 = g;
        g = null;
        Deferred deferred = f;
        if (deferred != null) {
            Job.DefaultImpls.a(deferred, (CancellationException) null, 1, (Object) null);
        }
        if (usbDevice2 != null) {
            try {
                delegate.a("VuGlassesHidManager", "notifyUsbDetached");
                VuGlassesHidUtil.f8104a.r(usbDevice2);
            } catch (Exception e2) {
                ULog.Delegate delegate2 = ULog.f6446a;
                String message = e2.getMessage();
                delegate2.c("VuGlassesHidManager", "onViewGlassDisconnected error: " + message);
            }
        }
        VuGlassesActiveHelper.f8097a.g();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0094 A[EDGE_INSN: B:27:0x0094->B:25:0x0094 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object s(android.hardware.usb.UsbDevice r8, kotlin.coroutines.Continuation r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager$openUsb$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager$openUsb$1 r0 = (com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager$openUsb$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager$openUsb$1 r0 = new com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager$openUsb$1
            r0.<init>(r7, r9)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 1
            java.lang.String r3 = "VuGlassesHidManager"
            if (r1 == 0) goto L_0x003d
            if (r1 != r2) goto L_0x0035
            boolean r8 = r0.Z$0
            int r1 = r0.I$0
            java.lang.Object r4 = r0.L$0
            android.hardware.usb.UsbDevice r4 = (android.hardware.usb.UsbDevice) r4
            kotlin.ResultKt.throwOnFailure(r7)
            r7 = r8
            r8 = r4
            goto L_0x0050
        L_0x0035:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r7)
            r7 = 0
            if (r8 != 0) goto L_0x004f
            com.upuphone.star.core.log.ULog$Delegate r8 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r9 = "openUsb device null"
            r8.a(r3, r9)
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            return r7
        L_0x004f:
            r1 = 3
        L_0x0050:
            if (r1 <= 0) goto L_0x0094
            com.upuphone.star.core.log.ULog$Delegate r7 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r4 = "start real open usb"
            r7.a(r3, r4)
            com.upuphone.xr.sapp.vu.utils.VuGlassesHidUtil r4 = com.upuphone.xr.sapp.vu.utils.VuGlassesHidUtil.f8104a
            boolean r4 = r4.s(r8)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Glasses openUsb: retryCount: "
            r5.append(r6)
            r5.append(r1)
            java.lang.String r6 = ", openResult "
            r5.append(r6)
            r5.append(r4)
            java.lang.String r5 = r5.toString()
            r7.a(r3, r5)
            if (r4 == 0) goto L_0x007f
            r7 = r4
            goto L_0x0094
        L_0x007f:
            int r1 = r1 + -1
            r0.L$0 = r8
            r0.I$0 = r1
            r0.Z$0 = r4
            r0.label = r2
            r5 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r7 = kotlinx.coroutines.DelayKt.b(r5, r0)
            if (r7 != r9) goto L_0x0092
            return r9
        L_0x0092:
            r7 = r4
            goto L_0x0050
        L_0x0094:
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager.s(android.hardware.usb.UsbDevice, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void t(UsbOpenResultListener usbOpenResultListener) {
        Intrinsics.checkNotNullParameter(usbOpenResultListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        c.remove(usbOpenResultListener);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object u(kotlin.coroutines.Continuation r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager$startHidService$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager$startHidService$1 r0 = (com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager$startHidService$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager$startHidService$1 r0 = new com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager$startHidService$1
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            java.lang.String r4 = "VuGlassesHidManager"
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x005d
        L_0x002b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r6)
            com.upuphone.xr.sapp.vu.vm.VuGlassControlModel r6 = com.upuphone.xr.sapp.vu.vm.VuGlassControlModel.f8109a
            boolean r6 = r6.z()
            if (r6 != 0) goto L_0x004c
            com.upuphone.star.core.log.ULog$Delegate r5 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r6 = "startHidService: glass not connected"
            r5.a(r4, r6)
            r5 = 0
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            return r5
        L_0x004c:
            com.upuphone.star.core.log.ULog$Delegate r6 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r2 = "startHidService"
            r6.a(r4, r2)
            r0.label = r3
            java.lang.Object r6 = r5.v(r0)
            if (r6 != r1) goto L_0x005d
            return r1
        L_0x005d:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r5 = r6.booleanValue()
            com.upuphone.star.core.log.ULog$Delegate r6 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "startHidService: "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            r6.a(r4, r0)
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager.u(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0049 A[Catch:{ CancellationException -> 0x0055 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004e A[Catch:{ CancellationException -> 0x0055 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object v(kotlin.coroutines.Continuation r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager$startHidServiceInternal$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager$startHidServiceInternal$1 r0 = (com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager$startHidServiceInternal$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager$startHidServiceInternal$1 r0 = new com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager$startHidServiceInternal$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r4 = r0.result
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L_0x0031
            if (r1 != r2) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r4)     // Catch:{ CancellationException -> 0x0055 }
            goto L_0x0045
        L_0x0029:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r4)
            com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager$startHidServiceInternal$2 r4 = new com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager$startHidServiceInternal$2     // Catch:{ CancellationException -> 0x0055 }
            r1 = 0
            r4.<init>(r1)     // Catch:{ CancellationException -> 0x0055 }
            r0.label = r2     // Catch:{ CancellationException -> 0x0055 }
            r1 = 5000(0x1388, double:2.4703E-320)
            java.lang.Object r4 = kotlinx.coroutines.TimeoutKt.d(r1, r4, r0)     // Catch:{ CancellationException -> 0x0055 }
            if (r4 != r5) goto L_0x0045
            return r5
        L_0x0045:
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ CancellationException -> 0x0055 }
            if (r4 == 0) goto L_0x004e
            boolean r4 = r4.booleanValue()     // Catch:{ CancellationException -> 0x0055 }
            goto L_0x0060
        L_0x004e:
            com.upuphone.xr.sapp.vu.utils.VuGlassesHidUtil r4 = com.upuphone.xr.sapp.vu.utils.VuGlassesHidUtil.f8104a     // Catch:{ CancellationException -> 0x0055 }
            boolean r4 = r4.q()     // Catch:{ CancellationException -> 0x0055 }
            goto L_0x0060
        L_0x0055:
            com.upuphone.star.core.log.ULog$Delegate r4 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r5 = "VuGlassesHidManager"
            java.lang.String r0 = "startHidServiceInternal: cancelled"
            r4.a(r5, r0)
            r4 = 0
        L_0x0060:
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager.v(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void w(UsbOpenResultListener usbOpenResultListener, boolean z) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("VuGlassesHidManager", "tryOpenUsb: " + usbOpenResultListener);
        if (z) {
            Deferred deferred = f;
            if (deferred != null) {
                Job.DefaultImpls.a(deferred, (CancellationException) null, 1, (Object) null);
            }
            f = null;
        }
        if (f == null) {
            Job unused = BuildersKt__Builders_commonKt.d(b, (CoroutineContext) null, (CoroutineStart) null, new VuGlassesHidManager$tryOpenUsb$1(usbOpenResultListener, (Continuation<? super VuGlassesHidManager$tryOpenUsb$1>) null), 3, (Object) null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object y(kotlin.coroutines.Continuation r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager$tryOpenUsbBlock$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager$tryOpenUsbBlock$1 r0 = (com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager$tryOpenUsbBlock$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager$tryOpenUsbBlock$1 r0 = new com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager$tryOpenUsbBlock$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r4 = r0.result
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L_0x0031
            if (r1 != r2) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r4)     // Catch:{ CancellationException -> 0x0063 }
            goto L_0x005c
        L_0x0029:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r4)
            r0.label = r2     // Catch:{ CancellationException -> 0x0063 }
            kotlinx.coroutines.CancellableContinuationImpl r4 = new kotlinx.coroutines.CancellableContinuationImpl     // Catch:{ CancellationException -> 0x0063 }
            kotlin.coroutines.Continuation r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r0)     // Catch:{ CancellationException -> 0x0063 }
            r4.<init>(r1, r2)     // Catch:{ CancellationException -> 0x0063 }
            r4.x()     // Catch:{ CancellationException -> 0x0063 }
            com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager$tryOpenUsbBlock$2$openResultListener$1 r1 = new com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager$tryOpenUsbBlock$2$openResultListener$1     // Catch:{ CancellationException -> 0x0063 }
            r1.<init>(r4)     // Catch:{ CancellationException -> 0x0063 }
            com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager r3 = f8100a     // Catch:{ CancellationException -> 0x0063 }
            r3.w(r1, r2)     // Catch:{ CancellationException -> 0x0063 }
            java.lang.Object r4 = r4.u()     // Catch:{ CancellationException -> 0x0063 }
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()     // Catch:{ CancellationException -> 0x0063 }
            if (r4 != r1) goto L_0x0059
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)     // Catch:{ CancellationException -> 0x0063 }
        L_0x0059:
            if (r4 != r5) goto L_0x005c
            return r5
        L_0x005c:
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ CancellationException -> 0x0063 }
            boolean r4 = r4.booleanValue()     // Catch:{ CancellationException -> 0x0063 }
            goto L_0x006e
        L_0x0063:
            com.upuphone.star.core.log.ULog$Delegate r4 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r5 = "VuGlassesHidManager"
            java.lang.String r0 = "tryOpenUsbBlock cancelled"
            r4.a(r5, r0)
            r4 = 0
        L_0x006e:
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager.y(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b8, code lost:
        if (com.upuphone.xr.sapp.vu.utils.VuGlassesHidUtil.f8104a.q() != false) goto L_0x00bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00be, code lost:
        return kotlin.coroutines.jvm.internal.Boxing.boxBoolean(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00bf, code lost:
        r0.L$0 = r8;
        r0.label = 2;
        r9 = r8.m(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c8, code lost:
        if (r9 != r1) goto L_0x00cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ca, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00cb, code lost:
        r9 = ((java.lang.Boolean) r9).booleanValue();
        com.upuphone.star.core.log.ULog.f6446a.a("VuGlassesHidManager", "tryOpenUsb isGlassConnected: hasPermission: " + r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00e8, code lost:
        if (r9 != false) goto L_0x00f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ea, code lost:
        r9 = com.upuphone.xr.sapp.vu.vm.VuGlassControlModel.f8109a;
        r0.L$0 = r8;
        r0.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00f5, code lost:
        if (r9.A(r0) != r1) goto L_0x00f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00f7, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00f8, code lost:
        r0.L$0 = r8;
        r0.label = 4;
        r9 = r8.m(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0101, code lost:
        if (r9 != r1) goto L_0x0104;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0103, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x010a, code lost:
        if (((java.lang.Boolean) r9).booleanValue() != false) goto L_0x0118;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x010c, code lost:
        com.upuphone.star.core.log.ULog.f6446a.a("VuGlassesHidManager", "Glasses requestPermission false");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0117, code lost:
        return kotlin.coroutines.jvm.internal.Boxing.boxBoolean(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x011e, code lost:
        if (com.upuphone.xr.sapp.vu.utils.VuGlassesHidUtil.f8104a.e() != 1) goto L_0x0122;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0120, code lost:
        r9 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0122, code lost:
        r9 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0123, code lost:
        r2 = com.upuphone.star.core.log.ULog.f6446a;
        r2.a("VuGlassesHidManager", "tryOpenUsb usb open state: " + r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x013a, code lost:
        if (r9 == false) goto L_0x0141;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0140, code lost:
        return kotlin.coroutines.jvm.internal.Boxing.boxBoolean(true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0143, code lost:
        if (g != null) goto L_0x0150;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0145, code lost:
        r2.a("VuGlassesHidManager", "tryOpenUsbInner check connectedUsbDevice again false");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x014f, code lost:
        return kotlin.coroutines.jvm.internal.Boxing.boxBoolean(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0150, code lost:
        r9 = g;
        r0.L$0 = null;
        r0.label = 5;
        r9 = r8.s(r9, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x015c, code lost:
        if (r9 != r1) goto L_0x015f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x015e, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x015f, code lost:
        r8 = ((java.lang.Boolean) r9).booleanValue();
        r2 = c.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0170, code lost:
        if (r2.hasNext() == false) goto L_0x0186;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0172, code lost:
        r0.L$0 = r2;
        r0.Z$0 = r8;
        r0.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0183, code lost:
        if (((com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager.UsbOpenResultListener) r2.next()).b(r8, r0) != r1) goto L_0x016c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0185, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0186, code lost:
        com.upuphone.star.core.log.ULog.f6446a.a("VuGlassesHidManager", "Glasses openUsb: " + r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01a0, code lost:
        return kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r8);
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object z(kotlin.coroutines.Continuation r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager$tryOpenUsbInner$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager$tryOpenUsbInner$1 r0 = (com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager$tryOpenUsbInner$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager$tryOpenUsbInner$1 r0 = new com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager$tryOpenUsbInner$1
            r0.<init>(r8, r9)
        L_0x0018:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            java.lang.String r5 = "VuGlassesHidManager"
            switch(r2) {
                case 0: goto L_0x0062;
                case 1: goto L_0x005a;
                case 2: goto L_0x0051;
                case 3: goto L_0x0048;
                case 4: goto L_0x003f;
                case 5: goto L_0x003a;
                case 6: goto L_0x002f;
                default: goto L_0x0027;
            }
        L_0x0027:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x002f:
            boolean r8 = r0.Z$0
            java.lang.Object r2 = r0.L$0
            java.util.Iterator r2 = (java.util.Iterator) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x016c
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x015f
        L_0x003f:
            java.lang.Object r8 = r0.L$0
            com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager r8 = (com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0104
        L_0x0048:
            java.lang.Object r8 = r0.L$0
            com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager r8 = (com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x00f8
        L_0x0051:
            java.lang.Object r8 = r0.L$0
            com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager r8 = (com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x00cb
        L_0x005a:
            java.lang.Object r8 = r0.L$0
            com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager r8 = (com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x00b2
        L_0x0062:
            kotlin.ResultKt.throwOnFailure(r9)
            android.hardware.usb.UsbDevice r9 = g
            if (r9 == 0) goto L_0x006b
            r9 = r3
            goto L_0x006c
        L_0x006b:
            r9 = r4
        L_0x006c:
            com.upuphone.star.core.log.ULog$Delegate r2 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "tryOpenUsb isGlassConnected: "
            r6.append(r7)
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            r2.a(r5, r6)
            if (r9 != 0) goto L_0x008a
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r8
        L_0x008a:
            com.upuphone.xr.sapp.vu.utils.VuGlassesHidUtil r9 = com.upuphone.xr.sapp.vu.utils.VuGlassesHidUtil.f8104a
            boolean r9 = r9.q()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "tryOpenUsb isServiceConnected: "
            r6.append(r7)
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            r2.a(r5, r6)
            if (r9 != 0) goto L_0x00b2
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r9 = r8.u(r0)
            if (r9 != r1) goto L_0x00b2
            return r1
        L_0x00b2:
            com.upuphone.xr.sapp.vu.utils.VuGlassesHidUtil r9 = com.upuphone.xr.sapp.vu.utils.VuGlassesHidUtil.f8104a
            boolean r9 = r9.q()
            if (r9 != 0) goto L_0x00bf
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r8
        L_0x00bf:
            r0.L$0 = r8
            r9 = 2
            r0.label = r9
            java.lang.Object r9 = r8.m(r0)
            if (r9 != r1) goto L_0x00cb
            return r1
        L_0x00cb:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            com.upuphone.star.core.log.ULog$Delegate r2 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "tryOpenUsb isGlassConnected: hasPermission: "
            r6.append(r7)
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            r2.a(r5, r6)
            if (r9 != 0) goto L_0x00f8
            com.upuphone.xr.sapp.vu.vm.VuGlassControlModel r9 = com.upuphone.xr.sapp.vu.vm.VuGlassControlModel.f8109a
            r0.L$0 = r8
            r2 = 3
            r0.label = r2
            java.lang.Object r9 = r9.A(r0)
            if (r9 != r1) goto L_0x00f8
            return r1
        L_0x00f8:
            r0.L$0 = r8
            r9 = 4
            r0.label = r9
            java.lang.Object r9 = r8.m(r0)
            if (r9 != r1) goto L_0x0104
            return r1
        L_0x0104:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 != 0) goto L_0x0118
            com.upuphone.star.core.log.ULog$Delegate r8 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r9 = "Glasses requestPermission false"
            r8.a(r5, r9)
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r8
        L_0x0118:
            com.upuphone.xr.sapp.vu.utils.VuGlassesHidUtil r9 = com.upuphone.xr.sapp.vu.utils.VuGlassesHidUtil.f8104a
            int r9 = r9.e()
            if (r9 != r3) goto L_0x0122
            r9 = r3
            goto L_0x0123
        L_0x0122:
            r9 = r4
        L_0x0123:
            com.upuphone.star.core.log.ULog$Delegate r2 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "tryOpenUsb usb open state: "
            r6.append(r7)
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            r2.a(r5, r6)
            if (r9 == 0) goto L_0x0141
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r8
        L_0x0141:
            android.hardware.usb.UsbDevice r9 = g
            if (r9 != 0) goto L_0x0150
            java.lang.String r8 = "tryOpenUsbInner check connectedUsbDevice again false"
            r2.a(r5, r8)
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r8
        L_0x0150:
            android.hardware.usb.UsbDevice r9 = g
            r2 = 0
            r0.L$0 = r2
            r2 = 5
            r0.label = r2
            java.lang.Object r9 = r8.s(r9, r0)
            if (r9 != r1) goto L_0x015f
            return r1
        L_0x015f:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r8 = r9.booleanValue()
            java.util.concurrent.CopyOnWriteArraySet r9 = c
            java.util.Iterator r9 = r9.iterator()
            r2 = r9
        L_0x016c:
            boolean r9 = r2.hasNext()
            if (r9 == 0) goto L_0x0186
            java.lang.Object r9 = r2.next()
            com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager$UsbOpenResultListener r9 = (com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager.UsbOpenResultListener) r9
            r0.L$0 = r2
            r0.Z$0 = r8
            r3 = 6
            r0.label = r3
            java.lang.Object r9 = r9.b(r8, r0)
            if (r9 != r1) goto L_0x016c
            return r1
        L_0x0186:
            com.upuphone.star.core.log.ULog$Delegate r9 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Glasses openUsb: "
            r0.append(r1)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            r9.a(r5, r0)
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager.z(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
