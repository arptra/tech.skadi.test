package com.upuphone.xr.sapp.datatrack;

import com.upuphone.star.core.log.ULog;
import com.upuphone.star.httplib.HttpUtils;
import com.upuphone.xr.sapp.config.NetConfig;
import com.upuphone.xr.sapp.datatrack.db.DataTrackRuleDb;
import com.upuphone.xr.sapp.glass.GlassHelper;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001+\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u0003J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0004H@¢\u0006\u0004\b\f\u0010\rJ8\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00122\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000eH@¢\u0006\u0004\b\u0015\u0010\u0016J \u0010\u0019\u001a\u00020\u00062\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u000eH@¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001b\u0010\u0003J\u000f\u0010\u001c\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001c\u0010\u0003R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R \u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0$8\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00102\u001a\u00020/8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b0\u00101¨\u00063"}, d2 = {"Lcom/upuphone/xr/sapp/datatrack/DataTrackRuleHelper;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "", "glassModel", "", "k", "(Ljava/lang/String;)V", "m", "event", "", "p", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "deviceTypes", "", "eventUseTypes", "Lcom/upuphone/star/httplib/HttpResult;", "Lcom/upuphone/xr/sapp/entity/BasicResponse;", "Lcom/upuphone/xr/sapp/datatrack/DataTrackRuleConfig;", "l", "(Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/upuphone/xr/sapp/datatrack/DataTrackRule;", "list", "n", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "q", "j", "c", "Ljava/util/List;", "caredEventTypes", "Lkotlinx/coroutines/Job;", "d", "Lkotlinx/coroutines/Job;", "fetchConfigJob", "", "e", "Ljava/util/Map;", "fetchConfigResult", "f", "Z", "needSyncConfig", "com/upuphone/xr/sapp/datatrack/DataTrackRuleHelper$deviceConnectListener$1", "g", "Lcom/upuphone/xr/sapp/datatrack/DataTrackRuleHelper$deviceConnectListener$1;", "deviceConnectListener", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nDataTrackRuleHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DataTrackRuleHelper.kt\ncom/upuphone/xr/sapp/datatrack/DataTrackRuleHelper\n+ 2 HttpUtils.kt\ncom/upuphone/star/httplib/HttpUtils\n*L\n1#1,229:1\n381#2,10:230\n*S KotlinDebug\n*F\n+ 1 DataTrackRuleHelper.kt\ncom/upuphone/xr/sapp/datatrack/DataTrackRuleHelper\n*L\n119#1:230,10\n*E\n"})
public final class DataTrackRuleHelper implements CoroutineScope {
    public static final DataTrackRuleHelper b = new DataTrackRuleHelper();
    public static final List c = CollectionsKt.listOf(2, 3);
    public static Job d;
    public static final Map e = new LinkedHashMap();
    public static boolean f;
    public static final DataTrackRuleHelper$deviceConnectListener$1 g;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f6916a = CoroutineScopeKt.b();

    static {
        DataTrackRuleHelper$deviceConnectListener$1 dataTrackRuleHelper$deviceConnectListener$1 = new DataTrackRuleHelper$deviceConnectListener$1();
        g = dataTrackRuleHelper$deviceConnectListener$1;
        GlassHelper.f7049a.l(dataTrackRuleHelper$deviceConnectListener$1);
    }

    public CoroutineContext getCoroutineContext() {
        return this.f6916a.getCoroutineContext();
    }

    public final void j() {
        ULog.Delegate delegate = ULog.f6446a;
        boolean z = f;
        delegate.a("DataTrackRuleHelper", "ensureSyncConfigToGlass, needSyncConfig: " + z);
        if (f) {
            q();
        }
    }

    public final void k(String str) {
        Job job = d;
        if (job == null || !job.isActive()) {
            d = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new DataTrackRuleHelper$fetchConfig$1(str, (Continuation<? super DataTrackRuleHelper$fetchConfig$1>) null), 3, (Object) null);
            return;
        }
        ULog.f6446a.a("DataTrackRuleHelper", "fetchConfig, fetchConfigJob?.isActive==true");
    }

    public final Object l(List list, List list2, Continuation continuation) {
        Map mapOf = MapsKt.mapOf(TuplesKt.to("deviceTypes", list), TuplesKt.to("eventUseTypes", list2));
        HttpUtils httpUtils = HttpUtils.f6479a;
        String str = NetConfig.f6666a.v("xrDatatrack") + "/client/data-track/rule/query/v1";
        Type type = new DataTrackRuleHelper$getDataTrackRuleConfig$$inlined$postJson$default$1().getType();
        Intrinsics.checkNotNullExpressionValue(type, "object : TypeToken<T>() {}.type");
        return httpUtils.p(str, mapOf, (Map) null, type, continuation);
    }

    public final void m() {
        q();
    }

    public final Object n(List list, Continuation continuation) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("DataTrackRuleHelper", "saveDataTrackRule, list: " + list);
        if (list == null || list.isEmpty()) {
            Object a2 = DataTrackRuleDb.f6927a.a().e().a(continuation);
            return a2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a2 : Unit.INSTANCE;
        }
        Object b2 = DataTrackRuleDb.f6927a.a().e().b(list, continuation);
        return b2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? b2 : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object p(java.lang.String r11, kotlin.coroutines.Continuation r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof com.upuphone.xr.sapp.datatrack.DataTrackRuleHelper$shouldBlockEvent$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            com.upuphone.xr.sapp.datatrack.DataTrackRuleHelper$shouldBlockEvent$1 r0 = (com.upuphone.xr.sapp.datatrack.DataTrackRuleHelper$shouldBlockEvent$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.datatrack.DataTrackRuleHelper$shouldBlockEvent$1 r0 = new com.upuphone.xr.sapp.datatrack.DataTrackRuleHelper$shouldBlockEvent$1
            r0.<init>(r10, r12)
        L_0x0018:
            java.lang.Object r10 = r0.result
            java.lang.Object r12 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0032
            if (r1 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x006c
        L_0x002a:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r10)
            com.upuphone.xr.sapp.utils.DataStoreUtils$Companion r10 = com.upuphone.xr.sapp.utils.DataStoreUtils.e
            com.upuphone.xr.sapp.utils.DataStoreUtils r4 = r10.a()
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            r8 = 4
            r9 = 0
            java.lang.String r5 = "sp_user_experience"
            r7 = 0
            java.lang.Object r10 = com.upuphone.xr.sapp.utils.DataStoreUtils.i(r4, r5, r6, r7, r8, r9)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x0055
            java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            return r10
        L_0x0055:
            com.upuphone.xr.sapp.datatrack.db.DataTrackRuleDb$Companion r10 = com.upuphone.xr.sapp.datatrack.db.DataTrackRuleDb.f6927a
            com.upuphone.xr.sapp.datatrack.db.DataTrackRuleDb r10 = r10.a()
            com.upuphone.xr.sapp.datatrack.db.DataTrackRuleDao r10 = r10.e()
            java.util.List r1 = c
            r0.label = r3
            java.lang.String r4 = "MYVU Android"
            java.lang.Object r10 = r10.d(r11, r4, r1, r0)
            if (r10 != r12) goto L_0x006c
            return r12
        L_0x006c:
            java.lang.Number r10 = (java.lang.Number) r10
            int r10 = r10.intValue()
            if (r10 > 0) goto L_0x0075
            r2 = r3
        L_0x0075:
            java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.datatrack.DataTrackRuleHelper.p(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void q() {
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new DataTrackRuleHelper$syncDataTrackRuleToGlass$1((Continuation<? super DataTrackRuleHelper$syncDataTrackRuleToGlass$1>) null), 3, (Object) null);
    }
}
