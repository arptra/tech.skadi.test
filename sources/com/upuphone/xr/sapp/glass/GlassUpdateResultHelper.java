package com.upuphone.xr.sapp.glass;

import android.os.Build;
import androidx.lifecycle.LifecycleOwner;
import com.meizu.common.widget.MzContactsContract;
import com.tencent.mmkv.MMKV;
import com.upuphone.star.core.log.ULog;
import com.upuphone.star.fota.phone.GlassUpdateResultParam;
import com.upuphone.starrynet.common.StarryNetConstant;
import com.upuphone.xr.sapp.entity.BasicGlassInfo;
import com.upuphone.xr.sapp.entity.BasicGlassInfoKt;
import com.upuphone.xr.sapp.entity.GlassUpdateState;
import com.upuphone.xr.sapp.entity.SealedClassJson;
import com.upuphone.xr.sapp.utils.DataTrackUtil;
import com.upuphone.xr.sapp.utils.JsonUtils;
import com.upuphone.xr.sapp.utils.NetworkUtils;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.LinkedHashMap;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001*\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0019\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\f\u0010\rJA\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J1\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u0016H@¢\u0006\u0004\b\u001e\u0010\u001fJ%\u0010\"\u001a\u00020\u00042\b\b\u0001\u0010\u001a\u001a\u00020 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\"\u0010#J?\u0010%\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0004H\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020\u00062\b\b\u0002\u0010'\u001a\u00020\u0011¢\u0006\u0004\b(\u0010)R\u0014\u0010-\u001a\u00020*8\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100R$\u00106\u001a\u00020\u00112\u0006\u00102\u001a\u00020\u00118B@BX\u000e¢\u0006\f\u001a\u0004\b3\u00104\"\u0004\b5\u0010)R(\u0010;\u001a\u0004\u0018\u00010\u000e2\b\u00102\u001a\u0004\u0018\u00010\u000e8B@BX\u000e¢\u0006\f\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R(\u0010?\u001a\u0004\u0018\u00010\u00042\b\u00102\u001a\u0004\u0018\u00010\u00048B@BX\u000e¢\u0006\f\u001a\u0004\b<\u0010=\"\u0004\b>\u0010\bR\u0014\u0010C\u001a\u00020@8\u0016X\u0005¢\u0006\u0006\u001a\u0004\bA\u0010B¨\u0006D"}, d2 = {"Lcom/upuphone/xr/sapp/glass/GlassUpdateResultHelper;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "", "msg", "", "x", "(Ljava/lang/String;)V", "y", "Lcom/upuphone/xr/sapp/entity/GlassUpdateState;", "glassUpdateState", "w", "(Lcom/upuphone/xr/sapp/entity/GlassUpdateState;)V", "Lcom/upuphone/xr/sapp/entity/BasicGlassInfo;", "glassInfo", "latestVersion", "", "updateStartedTime", "", "isSuccess", "uid", "Lcom/upuphone/star/fota/phone/GlassUpdateResultParam;", "p", "(Lcom/upuphone/xr/sapp/entity/BasicGlassInfo;Ljava/lang/String;JZLjava/lang/String;Ljava/lang/String;)Lcom/upuphone/star/fota/phone/GlassUpdateResultParam;", "errorMsg", "errorCode", "H", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "param", "I", "(Lcom/upuphone/star/fota/phone/GlassUpdateResultParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "extraErrorMsg", "q", "(ILjava/lang/String;)Ljava/lang/String;", "costTime", "A", "(Lcom/upuphone/xr/sapp/entity/BasicGlassInfo;Ljava/lang/String;JZLjava/lang/String;Ljava/lang/String;)V", "delayTime", "F", "(J)V", "com/upuphone/xr/sapp/glass/GlassUpdateResultHelper$networkCallback$1", "c", "Lcom/upuphone/xr/sapp/glass/GlassUpdateResultHelper$networkCallback$1;", "networkCallback", "Lkotlinx/coroutines/Job;", "d", "Lkotlinx/coroutines/Job;", "uploadResultTask", "value", "t", "()J", "D", "savedGlassUpdateStartedTime", "s", "()Lcom/upuphone/xr/sapp/entity/BasicGlassInfo;", "B", "(Lcom/upuphone/xr/sapp/entity/BasicGlassInfo;)V", "savedGlassInfo", "v", "()Ljava/lang/String;", "E", "savedGlassUpdateVersion", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nGlassUpdateResultHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlassUpdateResultHelper.kt\ncom/upuphone/xr/sapp/glass/GlassUpdateResultHelper\n+ 2 JsonUtils.kt\ncom/upuphone/xr/sapp/utils/JsonUtils\n*L\n1#1,464:1\n29#2,5:465\n*S KotlinDebug\n*F\n+ 1 GlassUpdateResultHelper.kt\ncom/upuphone/xr/sapp/glass/GlassUpdateResultHelper\n*L\n402#1:465,5\n*E\n"})
public final class GlassUpdateResultHelper implements CoroutineScope {
    public static final GlassUpdateResultHelper b;
    public static final GlassUpdateResultHelper$networkCallback$1 c;
    public static Job d;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f7067a = CoroutineScopeKt.b();

    static {
        GlassUpdateResultHelper glassUpdateResultHelper = new GlassUpdateResultHelper();
        b = glassUpdateResultHelper;
        GlassUpdateResultHelper$networkCallback$1 glassUpdateResultHelper$networkCallback$1 = new GlassUpdateResultHelper$networkCallback$1();
        c = glassUpdateResultHelper$networkCallback$1;
        GlassUpdateHelper glassUpdateHelper = GlassUpdateHelper.b;
        glassUpdateHelper.W(AnonymousClass1.INSTANCE);
        glassUpdateHelper.M0().observeForever(new GlassUpdateResultHelper$sam$androidx_lifecycle_Observer$0(AnonymousClass2.INSTANCE));
        NetworkUtils.f7898a.o((LifecycleOwner) null, glassUpdateResultHelper$networkCallback$1);
        glassUpdateResultHelper.F(3000);
    }

    /* access modifiers changed from: private */
    public final void E(String str) {
        MMKV.n().u("glass_update_result.glass_update_version", str);
    }

    public static /* synthetic */ void G(GlassUpdateResultHelper glassUpdateResultHelper, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        glassUpdateResultHelper.F(j);
    }

    public static /* synthetic */ String r(GlassUpdateResultHelper glassUpdateResultHelper, int i, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        return glassUpdateResultHelper.q(i, str);
    }

    /* access modifiers changed from: private */
    public final String v() {
        return MMKV.n().j("glass_update_result.glass_update_version");
    }

    /* access modifiers changed from: private */
    public final void x(String str) {
        ULog.f6446a.a("GlassUpdateResultHelper", str);
    }

    /* access modifiers changed from: private */
    public final void y(String str) {
        ULog.f6446a.c("GlassUpdateResultHelper", str);
    }

    public final void A(BasicGlassInfo basicGlassInfo, String str, long j, boolean z, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("glasses_type", BasicGlassInfoKt.getSafeSubModel(basicGlassInfo));
        linkedHashMap.put("status_initiate", basicGlassInfo.getRomVersion());
        linkedHashMap.put("status_finish", str);
        linkedHashMap.put(RtspHeaders.Values.TIME, Long.valueOf(j));
        linkedHashMap.put("result", Integer.valueOf(z ? 1 : 2));
        linkedHashMap.put("error_msg", str2);
        linkedHashMap.put(MzContactsContract.MzNetContacts.ERROR_CODE_KEY, str3);
        DataTrackUtil.n(DataTrackUtil.f7875a, "app_glasses_ota", linkedHashMap, false, 4, (Object) null);
    }

    public final void B(BasicGlassInfo basicGlassInfo) {
        if (basicGlassInfo == null) {
            MMKV.n().E("glass_update_result.glass_info");
            x("delete savedGlassInfo");
            return;
        }
        String name = basicGlassInfo.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        JsonUtils jsonUtils = JsonUtils.f7893a;
        String d2 = jsonUtils.d(new SealedClassJson(name, jsonUtils.d(basicGlassInfo)));
        MMKV.n().u("glass_update_result.glass_info", d2);
        x("savedGlassInfo success: " + d2);
    }

    public final void D(long j) {
        MMKV.n().s("glass_update_result.glass_update_start_time", j);
    }

    public final void F(long j) {
        Job job = d;
        if (job == null || !job.isActive()) {
            d = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new GlassUpdateResultHelper$startUploadResultTask$1(j, (Continuation<? super GlassUpdateResultHelper$startUploadResultTask$1>) null), 3, (Object) null);
            return;
        }
        x("uploadResultTask.isActive==true, return");
    }

    public final void H(boolean z, String str, String str2, String str3) {
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new GlassUpdateResultHelper$uploadUpdateResult$1(z, str, str2, str3, (Continuation<? super GlassUpdateResultHelper$uploadUpdateResult$1>) null), 3, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object I(com.upuphone.star.fota.phone.GlassUpdateResultParam r13, kotlin.coroutines.Continuation r14) {
        /*
            r12 = this;
            boolean r0 = r14 instanceof com.upuphone.xr.sapp.glass.GlassUpdateResultHelper$uploadUpdateResultLoop$1
            if (r0 == 0) goto L_0x0013
            r0 = r14
            com.upuphone.xr.sapp.glass.GlassUpdateResultHelper$uploadUpdateResultLoop$1 r0 = (com.upuphone.xr.sapp.glass.GlassUpdateResultHelper$uploadUpdateResultLoop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.glass.GlassUpdateResultHelper$uploadUpdateResultLoop$1 r0 = new com.upuphone.xr.sapp.glass.GlassUpdateResultHelper$uploadUpdateResultLoop$1
            r0.<init>(r12, r14)
        L_0x0018:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 3
            r6 = 1
            if (r2 == 0) goto L_0x0061
            if (r2 == r6) goto L_0x0053
            if (r2 == r4) goto L_0x0045
            if (r2 != r5) goto L_0x003d
            int r12 = r0.I$0
            java.lang.Object r13 = r0.L$1
            com.upuphone.star.fota.phone.GlassUpdateResultParam r13 = (com.upuphone.star.fota.phone.GlassUpdateResultParam) r13
            java.lang.Object r2 = r0.L$0
            com.upuphone.xr.sapp.glass.GlassUpdateResultHelper r2 = (com.upuphone.xr.sapp.glass.GlassUpdateResultHelper) r2
            kotlin.ResultKt.throwOnFailure(r14)
        L_0x0039:
            r14 = r13
            r13 = r12
            r12 = r2
            goto L_0x0066
        L_0x003d:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0045:
            int r12 = r0.I$0
            java.lang.Object r13 = r0.L$1
            com.upuphone.star.fota.phone.GlassUpdateResultParam r13 = (com.upuphone.star.fota.phone.GlassUpdateResultParam) r13
            java.lang.Object r2 = r0.L$0
            com.upuphone.xr.sapp.glass.GlassUpdateResultHelper r2 = (com.upuphone.xr.sapp.glass.GlassUpdateResultHelper) r2
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00b9
        L_0x0053:
            int r12 = r0.I$0
            java.lang.Object r13 = r0.L$1
            com.upuphone.star.fota.phone.GlassUpdateResultParam r13 = (com.upuphone.star.fota.phone.GlassUpdateResultParam) r13
            java.lang.Object r2 = r0.L$0
            com.upuphone.xr.sapp.glass.GlassUpdateResultHelper r2 = (com.upuphone.xr.sapp.glass.GlassUpdateResultHelper) r2
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x0082
        L_0x0061:
            kotlin.ResultKt.throwOnFailure(r14)
            r14 = r13
            r13 = r3
        L_0x0066:
            boolean r2 = kotlinx.coroutines.CoroutineScopeKt.h(r12)
            if (r2 == 0) goto L_0x0126
            com.upuphone.xr.sapp.utils.NetworkUtils r2 = com.upuphone.xr.sapp.utils.NetworkUtils.f7898a
            r0.L$0 = r12
            r0.L$1 = r14
            r0.I$0 = r13
            r0.label = r6
            java.lang.Object r2 = r2.h(r0)
            if (r2 != r1) goto L_0x007d
            return r1
        L_0x007d:
            r11 = r2
            r2 = r12
            r12 = r13
            r13 = r14
            r14 = r11
        L_0x0082:
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            boolean r14 = r14.booleanValue()
            if (r14 == 0) goto L_0x0126
            int r12 = r12 + r6
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r7 = "uploadUpdateResultLoop, start, count: "
            r14.append(r7)
            r14.append(r12)
            java.lang.String r7 = ", param: "
            r14.append(r7)
            r14.append(r13)
            java.lang.String r14 = r14.toString()
            r2.x(r14)
            com.upuphone.star.fota.phone.GlassUpdateApiManager r14 = com.upuphone.star.fota.phone.GlassUpdateApiManager.f6471a
            r0.L$0 = r2
            r0.L$1 = r13
            r0.I$0 = r12
            r0.label = r4
            java.lang.Object r14 = r14.k(r13, r0)
            if (r14 != r1) goto L_0x00b9
            return r1
        L_0x00b9:
            com.upuphone.star.fota.phone.BasicResult r14 = (com.upuphone.star.fota.phone.BasicResult) r14
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "uploadUpdateResultLoop, result: "
            r7.append(r8)
            r7.append(r14)
            java.lang.String r7 = r7.toString()
            r2.x(r7)
            boolean r14 = r14.isSuccess()
            if (r14 == 0) goto L_0x00db
            java.lang.Boolean r12 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            return r12
        L_0x00db:
            if (r12 < r5) goto L_0x00f3
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "uploadUpdateResultLoop, reach max count: "
            r13.append(r14)
            r13.append(r12)
            java.lang.String r12 = r13.toString()
            r2.x(r12)
            goto L_0x0126
        L_0x00f3:
            r7 = 5000(0x1388, double:2.4703E-320)
            long r9 = (long) r12
            long r9 = r9 * r7
            r7 = 20000(0x4e20, double:9.8813E-320)
            long r7 = kotlin.ranges.RangesKt.coerceAtMost((long) r9, (long) r7)
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r9 = "uploadUpdateResultLoop, delay: "
            r14.append(r9)
            r14.append(r7)
            java.lang.String r9 = " ms"
            r14.append(r9)
            java.lang.String r14 = r14.toString()
            r2.x(r14)
            r0.L$0 = r2
            r0.L$1 = r13
            r0.I$0 = r12
            r0.label = r5
            java.lang.Object r14 = kotlinx.coroutines.DelayKt.b(r7, r0)
            if (r14 != r1) goto L_0x0039
            return r1
        L_0x0126:
            java.lang.Boolean r12 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.glass.GlassUpdateResultHelper.I(com.upuphone.star.fota.phone.GlassUpdateResultParam, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public CoroutineContext getCoroutineContext() {
        return this.f7067a.getCoroutineContext();
    }

    public final GlassUpdateResultParam p(BasicGlassInfo basicGlassInfo, String str, long j, boolean z, String str2, String str3) {
        String str4;
        String f = DataTrackUtil.f7875a.f(basicGlassInfo.getSerial());
        String model = basicGlassInfo.getModel();
        String safeSubModel = BasicGlassInfoKt.getSafeSubModel(basicGlassInfo);
        String romVersion = basicGlassInfo.getRomVersion();
        long currentTimeMillis = System.currentTimeMillis();
        if (str3 == null) {
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
            str4 = uuid;
        } else {
            str4 = str3;
        }
        String str5 = Build.BRAND;
        String str6 = Build.MODEL;
        Intrinsics.checkNotNull(str6);
        Intrinsics.checkNotNull(str5);
        return new GlassUpdateResultParam(model, safeSubModel, f, str4, romVersion, str, j, currentTimeMillis, str2, str6, str5, z ? 1 : 0, Boolean.TRUE);
    }

    public final String q(int i, String str) {
        String str2;
        switch (i) {
            case 101:
                str2 = "glass_not_connected";
                break;
            case 103:
                str2 = "send_msg_get_glass_info_fail";
                break;
            case 104:
                str2 = "send_msg_get_glass_info_timeout";
                break;
            case 105:
                str2 = "glass_low_power";
                break;
            case 106:
                str2 = "glass_low_storage";
                break;
            case 107:
                str2 = "send_msg_show_update_dialog_on_glass_fail";
                break;
            case 108:
                str2 = "send_msg_show_update_dialog_on_glass_timeout";
                break;
            case 109:
                str2 = "update_file_not_exist";
                break;
            case 110:
                str2 = "send_msg_open_glass_ota_fail";
                break;
            case 111:
                str2 = "send_msg_open_glass_ota_timeout";
                break;
            case 112:
                str2 = "wrong_update_info";
                break;
            case 113:
                str2 = "fail_to_enable_p2p";
                break;
            case 114:
                str2 = "transfer_fail";
                break;
            case 115:
                str2 = "send_msg_fail";
                break;
            case 116:
                str2 = "send_msg_timeout";
                break;
            case 120:
                str2 = "transfer_disconnected, bluetooth_off";
                break;
            case 121:
                str2 = "transfer_disconnected, connect_timeout";
                break;
            case 122:
                str2 = "transfer_disconnected, disconnect_by_glass";
                break;
            case 123:
                str2 = "transfer_disconnected, disconnect_by_phone";
                break;
            case 124:
                str2 = "transfer_disconnected";
                break;
            default:
                str2 = "code=" + i;
                break;
        }
        if (str == null || str.length() == 0) {
            return str2;
        }
        return str2 + ", " + str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0042 A[Catch:{ Exception -> 0x0032 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.upuphone.xr.sapp.entity.BasicGlassInfo s() {
        /*
            r4 = this;
            com.tencent.mmkv.MMKV r0 = com.tencent.mmkv.MMKV.n()
            java.lang.String r1 = "glass_update_result.glass_info"
            java.lang.String r0 = r0.j(r1)
            com.upuphone.xr.sapp.utils.JsonUtils r1 = com.upuphone.xr.sapp.utils.JsonUtils.f7893a     // Catch:{ Exception -> 0x0032 }
            com.upuphone.xr.sapp.glass.GlassUpdateResultHelper$special$$inlined$fromJson$1 r2 = new com.upuphone.xr.sapp.glass.GlassUpdateResultHelper$special$$inlined$fromJson$1     // Catch:{ Exception -> 0x0032 }
            r2.<init>()     // Catch:{ Exception -> 0x0032 }
            java.lang.reflect.Type r2 = r2.getType()     // Catch:{ Exception -> 0x0032 }
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0032 }
            java.lang.Class r3 = r3.getClass()     // Catch:{ Exception -> 0x0032 }
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)     // Catch:{ Exception -> 0x0032 }
            if (r3 != 0) goto L_0x0034
            java.lang.Class<java.lang.Void> r3 = java.lang.Void.class
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)     // Catch:{ Exception -> 0x0032 }
            if (r3 == 0) goto L_0x002a
            goto L_0x0034
        L_0x002a:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)     // Catch:{ Exception -> 0x0032 }
            java.lang.Object r0 = r1.a(r0, r2)     // Catch:{ Exception -> 0x0032 }
            goto L_0x003e
        L_0x0032:
            r0 = move-exception
            goto L_0x005a
        L_0x0034:
            java.lang.String r0 = "{}"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)     // Catch:{ Exception -> 0x0032 }
            java.lang.Object r0 = r1.a(r0, r2)     // Catch:{ Exception -> 0x0032 }
        L_0x003e:
            com.upuphone.xr.sapp.entity.SealedClassJson r0 = (com.upuphone.xr.sapp.entity.SealedClassJson) r0     // Catch:{ Exception -> 0x0032 }
            if (r0 == 0) goto L_0x006e
            java.lang.String r2 = r0.getJson()     // Catch:{ Exception -> 0x0032 }
            java.lang.String r0 = r0.getClassName()     // Catch:{ Exception -> 0x0032 }
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x0032 }
            java.lang.String r3 = "forName(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)     // Catch:{ Exception -> 0x0032 }
            java.lang.Object r0 = r1.a(r2, r0)     // Catch:{ Exception -> 0x0032 }
            com.upuphone.xr.sapp.entity.BasicGlassInfo r0 = (com.upuphone.xr.sapp.entity.BasicGlassInfo) r0     // Catch:{ Exception -> 0x0032 }
            return r0
        L_0x005a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "get savedGlassInfo error: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r4.y(r0)
        L_0x006e:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.glass.GlassUpdateResultHelper.s():com.upuphone.xr.sapp.entity.BasicGlassInfo");
    }

    public final long t() {
        return MMKV.n().g("glass_update_result.glass_update_start_time", 0);
    }

    public final void w(GlassUpdateState glassUpdateState) {
        if (glassUpdateState instanceof GlassUpdateState.GlassUpdateSuccess) {
            x("GlassUpdateSuccess");
            H(true, "success", "0", ((GlassUpdateState.GlassUpdateSuccess) glassUpdateState).getUid());
        } else if (glassUpdateState instanceof GlassUpdateState.GlassUpdateFail) {
            x("GlassUpdateFail");
            GlassUpdateState.GlassUpdateFail glassUpdateFail = (GlassUpdateState.GlassUpdateFail) glassUpdateState;
            String errorMsg = glassUpdateFail.getErrorMsg();
            String str = StarryNetConstant.DEVICE_NAME_UNKNOWN;
            if (errorMsg == null) {
                errorMsg = str;
            }
            String errorCode = glassUpdateFail.getErrorCode();
            if (errorCode != null) {
                str = errorCode;
            }
            H(false, errorMsg, str, glassUpdateFail.getUid());
        } else if (glassUpdateState instanceof GlassUpdateState.TransferFail) {
            x("TransferFail");
            GlassUpdateState.TransferFail transferFail = (GlassUpdateState.TransferFail) glassUpdateState;
            H(false, q(transferFail.getErrorCode(), transferFail.getExtraErrorMsg()), String.valueOf(transferFail.getErrorCode()), transferFail.getUid());
        } else if (glassUpdateState instanceof GlassUpdateState.InstallFail) {
            x("InstallFail");
            GlassUpdateState.InstallFail installFail = (GlassUpdateState.InstallFail) glassUpdateState;
            H(false, r(this, installFail.getErrorCode(), (String) null, 2, (Object) null), String.valueOf(installFail.getErrorCode()), installFail.getUid());
        }
    }
}
