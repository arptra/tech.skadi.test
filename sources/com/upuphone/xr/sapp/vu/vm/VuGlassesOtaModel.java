package com.upuphone.xr.sapp.vu.vm;

import android.os.Build;
import androidx.lifecycle.Observer;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.honey.account.f9.a;
import com.upuphone.star.core.log.ULog;
import com.upuphone.star.fota.phone.GlassUpdateApiManager;
import com.upuphone.star.fota.phone.GlassUpdateResultParam;
import com.upuphone.starrynet.payload.PayloadConstant;
import com.upuphone.xr.sapp.entity.DeviceInfo;
import com.upuphone.xr.sapp.utils.AppUtils;
import com.upuphone.xr.sapp.utils.DataTrackUtil;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
import com.upuphone.xr.sapp.vu.ota.VuGlassUpdateHelper;
import com.upuphone.xr.sapp.vu.ota.VuUpdateInfo;
import com.upuphone.xr.sapp.vu.ota.VuUpdateStatus;
import com.upuphone.xr.sapp.vu.vm.VuGlassControlModel;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.LinkedHashMap;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003VWXB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH@¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H@¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0015\u0010\u0003J\u000f\u0010\u0016\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0016\u0010\u0003J\u0018\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H@¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001cH@¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010\"\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\u0015\u0010$\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b$\u0010#J\u0015\u0010&\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020%¢\u0006\u0004\b&\u0010'J\u0015\u0010(\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020%¢\u0006\u0004\b(\u0010'J\r\u0010)\u001a\u00020\u0004¢\u0006\u0004\b)\u0010\u0006J\u0019\u0010+\u001a\u00020\u000e2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b+\u0010,J\r\u0010-\u001a\u00020\u000e¢\u0006\u0004\b-\u0010\u0003R$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0016\u00106\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00105R\"\u0010<\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010\u0006\"\u0004\b:\u0010;R\u0014\u0010@\u001a\u00020=8\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010D\u001a\u00020A8\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u001e\u0010H\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010E8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u001a\u0010L\u001a\b\u0012\u0004\u0012\u00020 0I8\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u001a\u0010N\u001a\b\u0012\u0004\u0012\u00020%0I8\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010KR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u001c\u0010U\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010R0Q8\u0002X\u0004¢\u0006\u0006\n\u0004\bS\u0010T¨\u0006Y"}, d2 = {"Lcom/upuphone/xr/sapp/vu/vm/VuGlassesOtaModel;", "", "<init>", "()V", "", "z", "()Z", "y", "Lcom/upuphone/xr/sapp/entity/DeviceInfo;", "deviceInfo", "I", "(Lcom/upuphone/xr/sapp/entity/DeviceInfo;)Z", "Lcom/upuphone/xr/sapp/vu/ota/VuUpdateInfo;", "updateInfo", "", "D", "(Lcom/upuphone/xr/sapp/vu/ota/VuUpdateInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/upuphone/xr/sapp/vu/ota/VuUpdateStatus;", "status", "C", "(Lcom/upuphone/xr/sapp/vu/ota/VuUpdateStatus;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "B", "K", "", "updateVersion", "Lcom/upuphone/xr/sapp/vu/ota/VuUpdateResult;", "t", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/upuphone/xr/sapp/vu/vm/VuGlassesOtaModel$GlassUpdateReportInfo;", "reportInfo", "G", "(Lcom/upuphone/xr/sapp/vu/vm/VuGlassesOtaModel$GlassUpdateReportInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/upuphone/xr/sapp/vu/vm/VuGlassesOtaModel$UpdateStatusChangeListener;", "listener", "r", "(Lcom/upuphone/xr/sapp/vu/vm/VuGlassesOtaModel$UpdateStatusChangeListener;)V", "E", "Lcom/upuphone/xr/sapp/vu/vm/VuGlassesOtaModel$UpdateInfoChangeListener;", "s", "(Lcom/upuphone/xr/sapp/vu/vm/VuGlassesOtaModel$UpdateInfoChangeListener;)V", "F", "A", "info", "u", "(Lcom/upuphone/xr/sapp/entity/DeviceInfo;)V", "J", "b", "Lcom/upuphone/xr/sapp/vu/ota/VuUpdateInfo;", "w", "()Lcom/upuphone/xr/sapp/vu/ota/VuUpdateInfo;", "setUpdateInfo", "(Lcom/upuphone/xr/sapp/vu/ota/VuUpdateInfo;)V", "c", "Lcom/upuphone/xr/sapp/vu/ota/VuUpdateStatus;", "currentStatus", "d", "Z", "v", "H", "(Z)V", "showUpdateDialog", "Lcom/upuphone/xr/sapp/vu/ota/VuGlassUpdateHelper;", "e", "Lcom/upuphone/xr/sapp/vu/ota/VuGlassUpdateHelper;", "updateHelper", "Lkotlinx/coroutines/CoroutineScope;", "f", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Lkotlinx/coroutines/Deferred;", "g", "Lkotlinx/coroutines/Deferred;", "updateJob", "Ljava/util/concurrent/CopyOnWriteArraySet;", "h", "Ljava/util/concurrent/CopyOnWriteArraySet;", "statusChangeListeners", "i", "updateInfoChangeListeners", "j", "Lcom/upuphone/xr/sapp/vu/vm/VuGlassesOtaModel$GlassUpdateReportInfo;", "Landroidx/lifecycle/Observer;", "Lcom/upuphone/xr/sapp/vu/vm/VuGlassControlModel$ViewGlassesInfo;", "k", "Landroidx/lifecycle/Observer;", "glassStatusObserver", "GlassUpdateReportInfo", "UpdateInfoChangeListener", "UpdateStatusChangeListener", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class VuGlassesOtaModel {

    /* renamed from: a  reason: collision with root package name */
    public static final VuGlassesOtaModel f8117a = new VuGlassesOtaModel();
    public static VuUpdateInfo b;
    public static VuUpdateStatus c = new VuUpdateStatus(0, (Object) null, 2, (DefaultConstructorMarker) null);
    public static boolean d = true;
    public static final VuGlassUpdateHelper e = new VuGlassUpdateHelper();
    public static final CoroutineScope f = CoroutineScopeKt.a(Dispatchers.b().plus(SupervisorKt.b((Job) null, 1, (Object) null)));
    public static Deferred g;
    public static final CopyOnWriteArraySet h = new CopyOnWriteArraySet();
    public static final CopyOnWriteArraySet i = new CopyOnWriteArraySet();
    public static GlassUpdateReportInfo j = new GlassUpdateReportInfo((String) null, (String) null, (String) null, (String) null, (String) null, 0, 0, false, (String) null, 511, (DefaultConstructorMarker) null);
    public static final Observer k = new a();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bæ\u0001\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/upuphone/xr/sapp/vu/vm/VuGlassesOtaModel$UpdateInfoChangeListener;", "", "Lcom/upuphone/xr/sapp/vu/ota/VuUpdateInfo;", "updateInfo", "", "a", "(Lcom/upuphone/xr/sapp/vu/ota/VuUpdateInfo;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public interface UpdateInfoChangeListener {
        void a(VuUpdateInfo vuUpdateInfo);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bæ\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/upuphone/xr/sapp/vu/vm/VuGlassesOtaModel$UpdateStatusChangeListener;", "", "Lcom/upuphone/xr/sapp/vu/ota/VuUpdateStatus;", "status", "", "a", "(Lcom/upuphone/xr/sapp/vu/ota/VuUpdateStatus;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public interface UpdateStatusChangeListener {
        void a(VuUpdateStatus vuUpdateStatus);
    }

    public static final void x(VuGlassControlModel.ViewGlassesInfo viewGlassesInfo) {
        if (viewGlassesInfo == null || !viewGlassesInfo.e()) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("VuGlassesOtaModel", "glass disconnected");
            Deferred deferred = g;
            if (deferred != null && deferred.isActive()) {
                delegate.a("VuGlassesOtaModel", "update running canceled");
                Deferred deferred2 = g;
                if (deferred2 != null) {
                    Job.DefaultImpls.a(deferred2, (CancellationException) null, 1, (Object) null);
                }
            }
        }
    }

    public final boolean A() {
        return c.b() == 3;
    }

    public final void B() {
        Job unused = BuildersKt__Builders_commonKt.d(f, Dispatchers.c(), (CoroutineStart) null, new VuGlassesOtaModel$listenerConnectStatus$1((Continuation<? super VuGlassesOtaModel$listenerConnectStatus$1>) null), 2, (Object) null);
    }

    public final Object C(VuUpdateStatus vuUpdateStatus, Continuation continuation) {
        c = vuUpdateStatus;
        Object g2 = BuildersKt.g(Dispatchers.c(), new VuGlassesOtaModel$onStatusChange$2(vuUpdateStatus, (Continuation<? super VuGlassesOtaModel$onStatusChange$2>) null), continuation);
        return g2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? g2 : Unit.INSTANCE;
    }

    public final Object D(VuUpdateInfo vuUpdateInfo, Continuation continuation) {
        b = vuUpdateInfo;
        Object g2 = BuildersKt.g(Dispatchers.c(), new VuGlassesOtaModel$onUpdateInfoChange$2(vuUpdateInfo, (Continuation<? super VuGlassesOtaModel$onUpdateInfoChange$2>) null), continuation);
        return g2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? g2 : Unit.INSTANCE;
    }

    public final void E(UpdateStatusChangeListener updateStatusChangeListener) {
        Intrinsics.checkNotNullParameter(updateStatusChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        h.remove(updateStatusChangeListener);
    }

    public final void F(UpdateInfoChangeListener updateInfoChangeListener) {
        Intrinsics.checkNotNullParameter(updateInfoChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        i.remove(updateInfoChangeListener);
    }

    public final Object G(GlassUpdateReportInfo glassUpdateReportInfo, Continuation continuation) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("glasses_type", glassUpdateReportInfo.d());
        linkedHashMap.put("status_initiate", glassUpdateReportInfo.j());
        linkedHashMap.put("status_finish", glassUpdateReportInfo.c());
        linkedHashMap.put(RtspHeaders.Values.TIME, Boxing.boxLong(glassUpdateReportInfo.a()));
        linkedHashMap.put("result", Boxing.boxInt(glassUpdateReportInfo.f() ? 1 : 2));
        String str = "";
        linkedHashMap.put("error_msg", glassUpdateReportInfo.f() ? str : glassUpdateReportInfo.e());
        DataTrackUtil dataTrackUtil = DataTrackUtil.f7875a;
        String f2 = dataTrackUtil.f(glassUpdateReportInfo.h());
        DataTrackUtil.m(dataTrackUtil, "app_glasses_ota", linkedHashMap, f2, glassUpdateReportInfo.d(), glassUpdateReportInfo.g(), false, 32, (Object) null);
        String d2 = glassUpdateReportInfo.d();
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        String j2 = glassUpdateReportInfo.j();
        String c2 = glassUpdateReportInfo.c();
        long i2 = glassUpdateReportInfo.i();
        long b2 = glassUpdateReportInfo.b();
        if (!glassUpdateReportInfo.f()) {
            str = glassUpdateReportInfo.e();
        }
        String str2 = str;
        String str3 = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(str3, "MODEL");
        String str4 = Build.BRAND;
        Intrinsics.checkNotNullExpressionValue(str4, "BRAND");
        Object k2 = GlassUpdateApiManager.f6471a.k(new GlassUpdateResultParam("View", d2, f2, uuid, j2, c2, i2, b2, str2, str3, str4, glassUpdateReportInfo.f() ? 1 : 0, Boxing.boxBoolean(true)), continuation);
        return k2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? k2 : Unit.INSTANCE;
    }

    public final void H(boolean z) {
        d = z;
    }

    public final boolean I(DeviceInfo deviceInfo) {
        String serialNo;
        String romVersion = deviceInfo.getRomVersion();
        if (romVersion == null || romVersion.length() == 0 || (serialNo = deviceInfo.getSerialNo()) == null || serialNo.length() == 0 || !VuGlassControlModel.f8109a.z()) {
            return false;
        }
        Pair g2 = AppUtils.f7842a.g(GlobalExtKt.f());
        String str = (String) g2.component1();
        String str2 = (String) g2.component2();
        if (!y()) {
            if (!z()) {
                return false;
            }
            VuUpdateInfo vuUpdateInfo = b;
            String str3 = null;
            if (Intrinsics.areEqual((Object) vuUpdateInfo != null ? vuUpdateInfo.a() : null, (Object) deviceInfo.getRomVersion())) {
                VuUpdateInfo vuUpdateInfo2 = b;
                if (Intrinsics.areEqual((Object) vuUpdateInfo2 != null ? vuUpdateInfo2.e() : null, (Object) str)) {
                    VuUpdateInfo vuUpdateInfo3 = b;
                    if (vuUpdateInfo3 != null) {
                        str3 = vuUpdateInfo3.c();
                    }
                    return !Intrinsics.areEqual((Object) str3, (Object) str2);
                }
            }
        }
    }

    public final void J() {
        if (A()) {
            ULog.f6446a.a("VuGlassesOtaModel", "startUpdate isUpdating");
        } else {
            Job unused = BuildersKt__Builders_commonKt.d(f, (CoroutineContext) null, (CoroutineStart) null, new VuGlassesOtaModel$startUpdate$1((Continuation<? super VuGlassesOtaModel$startUpdate$1>) null), 3, (Object) null);
        }
    }

    public final void K() {
        Job unused = BuildersKt__Builders_commonKt.d(f, Dispatchers.c(), (CoroutineStart) null, new VuGlassesOtaModel$unlistenerConnectStatus$1((Continuation<? super VuGlassesOtaModel$unlistenerConnectStatus$1>) null), 2, (Object) null);
    }

    public final void r(UpdateStatusChangeListener updateStatusChangeListener) {
        Intrinsics.checkNotNullParameter(updateStatusChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        updateStatusChangeListener.a(c);
        h.add(updateStatusChangeListener);
    }

    public final void s(UpdateInfoChangeListener updateInfoChangeListener) {
        Intrinsics.checkNotNullParameter(updateInfoChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        updateInfoChangeListener.a(b);
        i.add(updateInfoChangeListener);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object t(java.lang.String r14, kotlin.coroutines.Continuation r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel$checkResult$1
            if (r0 == 0) goto L_0x0013
            r0 = r15
            com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel$checkResult$1 r0 = (com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel$checkResult$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel$checkResult$1 r0 = new com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel$checkResult$1
            r0.<init>(r13, r15)
        L_0x0018:
            java.lang.Object r13 = r0.result
            java.lang.Object r15 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 5
            r3 = 4
            r4 = 2
            r5 = 2000(0x7d0, double:9.88E-321)
            r7 = 0
            r8 = 3
            r9 = 1
            r10 = -1
            if (r1 == 0) goto L_0x007a
            if (r1 == r9) goto L_0x006e
            if (r1 == r4) goto L_0x0060
            if (r1 == r8) goto L_0x0057
            if (r1 == r3) goto L_0x0048
            if (r1 != r2) goto L_0x0040
            int r14 = r0.I$0
            java.lang.Object r1 = r0.L$0
            java.lang.String r1 = (java.lang.String) r1
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0139
        L_0x0040:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x0048:
            int r14 = r0.I$0
            java.lang.Object r1 = r0.L$1
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r4 = r0.L$0
            java.lang.String r4 = (java.lang.String) r4
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00f9
        L_0x0057:
            java.lang.Object r14 = r0.L$0
            java.lang.String r14 = (java.lang.String) r14
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00ca
        L_0x0060:
            int r14 = r0.I$1
            int r1 = r0.I$0
            java.lang.Object r11 = r0.L$0
            java.lang.String r11 = (java.lang.String) r11
            kotlin.ResultKt.throwOnFailure(r13)
        L_0x006b:
            r13 = r14
            r14 = r11
            goto L_0x00ac
        L_0x006e:
            int r14 = r0.I$1
            int r1 = r0.I$0
            java.lang.Object r11 = r0.L$0
            java.lang.String r11 = (java.lang.String) r11
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0093
        L_0x007a:
            kotlin.ResultKt.throwOnFailure(r13)
            r1 = r7
            r13 = r8
        L_0x007f:
            if (r13 <= 0) goto L_0x00b1
            r0.L$0 = r14
            r0.I$0 = r13
            r0.I$1 = r1
            r0.label = r9
            java.lang.Object r11 = kotlinx.coroutines.DelayKt.b(r5, r0)
            if (r11 != r15) goto L_0x0090
            return r15
        L_0x0090:
            r11 = r14
            r14 = r1
            r1 = r13
        L_0x0093:
            com.upuphone.xr.sapp.vu.vm.VuGlassControlModel r13 = com.upuphone.xr.sapp.vu.vm.VuGlassControlModel.f8109a
            boolean r13 = r13.z()
            if (r13 == 0) goto L_0x009d
            r14 = r11
            goto L_0x00b2
        L_0x009d:
            r0.L$0 = r11
            r0.I$0 = r1
            r0.I$1 = r14
            r0.label = r4
            java.lang.Object r13 = kotlinx.coroutines.DelayKt.b(r5, r0)
            if (r13 != r15) goto L_0x006b
            return r15
        L_0x00ac:
            int r1 = r1 + r10
            r12 = r1
            r1 = r13
            r13 = r12
            goto L_0x007f
        L_0x00b1:
            r9 = r1
        L_0x00b2:
            if (r9 != 0) goto L_0x00bd
            com.upuphone.xr.sapp.vu.ota.VuUpdateResult r13 = new com.upuphone.xr.sapp.vu.ota.VuUpdateResult
            java.lang.String r14 = "重启后未监听到眼镜连接成功"
            r13.<init>(r10, r14)
            return r13
        L_0x00bd:
            com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager r13 = com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager.f8100a
            r0.L$0 = r14
            r0.label = r8
            java.lang.Object r13 = r13.y(r0)
            if (r13 != r15) goto L_0x00ca
            return r15
        L_0x00ca:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 != 0) goto L_0x00db
            com.upuphone.xr.sapp.vu.ota.VuUpdateResult r13 = new com.upuphone.xr.sapp.vu.ota.VuUpdateResult
            java.lang.String r14 = "usb打开失败"
            r13.<init>(r10, r14)
            return r13
        L_0x00db:
            r13 = 10
        L_0x00dd:
            if (r13 <= 0) goto L_0x013d
            com.upuphone.xr.sapp.vu.utils.VuGlassesHidUtil r1 = com.upuphone.xr.sapp.vu.utils.VuGlassesHidUtil.f8104a
            java.lang.String r4 = r1.g()
            r0.L$0 = r14
            r0.L$1 = r4
            r0.I$0 = r13
            r0.label = r3
            java.lang.Object r1 = r1.l(r0)
            if (r1 != r15) goto L_0x00f4
            return r15
        L_0x00f4:
            r12 = r14
            r14 = r13
            r13 = r1
            r1 = r4
            r4 = r12
        L_0x00f9:
            java.lang.String r13 = (java.lang.String) r13
            int r1 = r1.length()
            if (r1 <= 0) goto L_0x0128
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r13, (java.lang.Object) r4)
            if (r14 == 0) goto L_0x0110
            com.upuphone.xr.sapp.vu.ota.VuUpdateResult r13 = new com.upuphone.xr.sapp.vu.ota.VuUpdateResult
            java.lang.String r14 = "版本一致"
            r13.<init>(r7, r14)
            return r13
        L_0x0110:
            com.upuphone.xr.sapp.vu.ota.VuUpdateResult r14 = new com.upuphone.xr.sapp.vu.ota.VuUpdateResult
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r0 = "眼镜版本和升级版本不一致: "
            r15.append(r0)
            r15.append(r13)
            java.lang.String r13 = r15.toString()
            r14.<init>(r10, r13)
            return r14
        L_0x0128:
            r0.L$0 = r4
            r13 = 0
            r0.L$1 = r13
            r0.I$0 = r14
            r0.label = r2
            java.lang.Object r13 = kotlinx.coroutines.DelayKt.b(r5, r0)
            if (r13 != r15) goto L_0x0138
            return r15
        L_0x0138:
            r1 = r4
        L_0x0139:
            int r13 = r14 + -1
            r14 = r1
            goto L_0x00dd
        L_0x013d:
            com.upuphone.xr.sapp.vu.ota.VuUpdateResult r13 = new com.upuphone.xr.sapp.vu.ota.VuUpdateResult
            java.lang.String r14 = "安装成功"
            r13.<init>(r7, r14)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.t(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void u(DeviceInfo deviceInfo) {
        ULog.Delegate delegate = ULog.f6446a;
        int b2 = c.b();
        delegate.a("VuGlassesOtaModel", "checkUpdate: status: " + b2);
        Job unused = BuildersKt__Builders_commonKt.d(f, (CoroutineContext) null, (CoroutineStart) null, new VuGlassesOtaModel$checkUpdate$1(deviceInfo, (Continuation<? super VuGlassesOtaModel$checkUpdate$1>) null), 3, (Object) null);
    }

    public final boolean v() {
        return d;
    }

    public final VuUpdateInfo w() {
        return b;
    }

    public final boolean y() {
        return c.b() == 0 || c.b() == 5;
    }

    public final boolean z() {
        return c.b() == 2;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u001f\b\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u001a\u001a\u0004\b\u001b\u0010\u0013\"\u0004\b\u001c\u0010\u001dR\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\u0013\"\u0004\b \u0010\u001dR\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001a\u001a\u0004\b\"\u0010\u0013\"\u0004\b#\u0010\u001dR\"\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001a\u001a\u0004\b$\u0010\u0013\"\u0004\b%\u0010\u001dR\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b&\u0010\u001a\u001a\u0004\b!\u0010\u0013\"\u0004\b'\u0010\u001dR\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\u0011\"\u0004\b+\u0010,R\"\u0010\n\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\"\u0010)\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b-\u0010,R\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010.\u001a\u0004\b(\u0010/\"\u0004\b0\u00101R\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b*\u0010\u001a\u001a\u0004\b&\u0010\u0013\"\u0004\b2\u0010\u001d¨\u00063"}, d2 = {"Lcom/upuphone/xr/sapp/vu/vm/VuGlassesOtaModel$GlassUpdateReportInfo;", "", "", "model", "sn", "rom", "startVersion", "endVersion", "", "startTime", "endTime", "", "result", "reason", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJZLjava/lang/String;)V", "a", "()J", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "d", "m", "(Ljava/lang/String;)V", "b", "h", "q", "c", "g", "p", "j", "s", "e", "l", "f", "J", "i", "r", "(J)V", "k", "Z", "()Z", "o", "(Z)V", "n", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class GlassUpdateReportInfo {

        /* renamed from: a  reason: collision with root package name */
        public String f8118a;
        public String b;
        public String c;
        public String d;
        public String e;
        public long f;
        public long g;
        public boolean h;
        public String i;

        public GlassUpdateReportInfo(String str, String str2, String str3, String str4, String str5, long j, long j2, boolean z, String str6) {
            Intrinsics.checkNotNullParameter(str, "model");
            Intrinsics.checkNotNullParameter(str2, PayloadConstant.PARAMS_KEY_STR_SN);
            Intrinsics.checkNotNullParameter(str3, "rom");
            Intrinsics.checkNotNullParameter(str4, "startVersion");
            Intrinsics.checkNotNullParameter(str5, "endVersion");
            Intrinsics.checkNotNullParameter(str6, "reason");
            this.f8118a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = str5;
            this.f = j;
            this.g = j2;
            this.h = z;
            this.i = str6;
        }

        public final long a() {
            return this.g - this.f;
        }

        public final long b() {
            return this.g;
        }

        public final String c() {
            return this.e;
        }

        public final String d() {
            return this.f8118a;
        }

        public final String e() {
            return this.i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof GlassUpdateReportInfo)) {
                return false;
            }
            GlassUpdateReportInfo glassUpdateReportInfo = (GlassUpdateReportInfo) obj;
            return Intrinsics.areEqual((Object) this.f8118a, (Object) glassUpdateReportInfo.f8118a) && Intrinsics.areEqual((Object) this.b, (Object) glassUpdateReportInfo.b) && Intrinsics.areEqual((Object) this.c, (Object) glassUpdateReportInfo.c) && Intrinsics.areEqual((Object) this.d, (Object) glassUpdateReportInfo.d) && Intrinsics.areEqual((Object) this.e, (Object) glassUpdateReportInfo.e) && this.f == glassUpdateReportInfo.f && this.g == glassUpdateReportInfo.g && this.h == glassUpdateReportInfo.h && Intrinsics.areEqual((Object) this.i, (Object) glassUpdateReportInfo.i);
        }

        public final boolean f() {
            return this.h;
        }

        public final String g() {
            return this.c;
        }

        public final String h() {
            return this.b;
        }

        public int hashCode() {
            return (((((((((((((((this.f8118a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + Long.hashCode(this.f)) * 31) + Long.hashCode(this.g)) * 31) + Boolean.hashCode(this.h)) * 31) + this.i.hashCode();
        }

        public final long i() {
            return this.f;
        }

        public final String j() {
            return this.d;
        }

        public final void k(long j) {
            this.g = j;
        }

        public final void l(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.e = str;
        }

        public final void m(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.f8118a = str;
        }

        public final void n(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.i = str;
        }

        public final void o(boolean z) {
            this.h = z;
        }

        public final void p(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.c = str;
        }

        public final void q(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.b = str;
        }

        public final void r(long j) {
            this.f = j;
        }

        public final void s(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.d = str;
        }

        public String toString() {
            String str = this.f8118a;
            String str2 = this.b;
            String str3 = this.c;
            String str4 = this.d;
            String str5 = this.e;
            long j = this.f;
            long j2 = this.g;
            boolean z = this.h;
            String str6 = this.i;
            return "GlassUpdateReportInfo(model=" + str + ", sn=" + str2 + ", rom=" + str3 + ", startVersion=" + str4 + ", endVersion=" + str5 + ", startTime=" + j + ", endTime=" + j2 + ", result=" + z + ", reason=" + str6 + ")";
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ GlassUpdateReportInfo(java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, long r18, long r20, boolean r22, java.lang.String r23, int r24, kotlin.jvm.internal.DefaultConstructorMarker r25) {
            /*
                r12 = this;
                r0 = r24
                r1 = r0 & 1
                java.lang.String r2 = ""
                if (r1 == 0) goto L_0x000a
                r1 = r2
                goto L_0x000b
            L_0x000a:
                r1 = r13
            L_0x000b:
                r3 = r0 & 2
                if (r3 == 0) goto L_0x0011
                r3 = r2
                goto L_0x0012
            L_0x0011:
                r3 = r14
            L_0x0012:
                r4 = r0 & 4
                if (r4 == 0) goto L_0x0018
                r4 = r2
                goto L_0x0019
            L_0x0018:
                r4 = r15
            L_0x0019:
                r5 = r0 & 8
                if (r5 == 0) goto L_0x001f
                r5 = r2
                goto L_0x0021
            L_0x001f:
                r5 = r16
            L_0x0021:
                r6 = r0 & 16
                if (r6 == 0) goto L_0x0027
                r6 = r2
                goto L_0x0029
            L_0x0027:
                r6 = r17
            L_0x0029:
                r7 = r0 & 32
                r8 = 0
                if (r7 == 0) goto L_0x0031
                r10 = r8
                goto L_0x0033
            L_0x0031:
                r10 = r18
            L_0x0033:
                r7 = r0 & 64
                if (r7 == 0) goto L_0x0038
                goto L_0x003a
            L_0x0038:
                r8 = r20
            L_0x003a:
                r7 = r0 & 128(0x80, float:1.794E-43)
                if (r7 == 0) goto L_0x0040
                r7 = 0
                goto L_0x0042
            L_0x0040:
                r7 = r22
            L_0x0042:
                r0 = r0 & 256(0x100, float:3.59E-43)
                if (r0 == 0) goto L_0x0047
                goto L_0x0049
            L_0x0047:
                r2 = r23
            L_0x0049:
                r13 = r1
                r14 = r3
                r15 = r4
                r16 = r5
                r17 = r6
                r18 = r10
                r20 = r8
                r22 = r7
                r23 = r2
                r12.<init>(r13, r14, r15, r16, r17, r18, r20, r22, r23)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel.GlassUpdateReportInfo.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, long, long, boolean, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }
    }
}
