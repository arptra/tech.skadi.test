package com.upuphone.xr.sapp.datatrack;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/upuphone/xr/sapp/datatrack/DataTrackEventHelper;", "", "<init>", "()V", "", "", "a", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class DataTrackEventHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final DataTrackEventHelper f6915a = new DataTrackEventHelper();

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(kotlin.coroutines.Continuation r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.upuphone.xr.sapp.datatrack.DataTrackEventHelper$buildCommonParams$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.upuphone.xr.sapp.datatrack.DataTrackEventHelper$buildCommonParams$1 r0 = (com.upuphone.xr.sapp.datatrack.DataTrackEventHelper$buildCommonParams$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.datatrack.DataTrackEventHelper$buildCommonParams$1 r0 = new com.upuphone.xr.sapp.datatrack.DataTrackEventHelper$buildCommonParams$1
            r0.<init>(r8, r9)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 2
            java.lang.String r3 = ""
            r4 = 1
            if (r1 == 0) goto L_0x0043
            if (r1 != r4) goto L_0x003b
            int r9 = r0.I$0
            java.lang.Object r1 = r0.L$2
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r4 = r0.L$1
            kotlin.Pair[] r4 = (kotlin.Pair[]) r4
            java.lang.Object r0 = r0.L$0
            kotlin.Pair[] r0 = (kotlin.Pair[]) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x00c1
        L_0x003b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0043:
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = 8
            kotlin.Pair[] r8 = new kotlin.Pair[r8]
            java.lang.String r1 = "ver"
            java.lang.String r5 = "1.0.0"
            kotlin.Pair r1 = kotlin.TuplesKt.to(r1, r5)
            r5 = 0
            r8[r5] = r1
            com.upuphone.xr.sapp.utils.ControlUtils r1 = com.upuphone.xr.sapp.utils.ControlUtils.f7858a
            com.upuphone.xr.sapp.entity.DeviceInfo r1 = r1.g()
            java.lang.String r1 = r1.getRomVersion()
            if (r1 != 0) goto L_0x0063
            r1 = r3
        L_0x0063:
            java.lang.String r5 = "rom_version"
            kotlin.Pair r1 = kotlin.TuplesKt.to(r5, r1)
            r8[r4] = r1
            java.lang.Boolean r1 = com.upuphone.xr.sapp.BuildConfig.b
            java.lang.String r5 = "THIRD_PLATFOM"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)
            boolean r1 = r1.booleanValue()
            r1 = r1 ^ r4
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            java.lang.String r5 = "devices_type"
            kotlin.Pair r1 = kotlin.TuplesKt.to(r5, r1)
            r8[r2] = r1
            java.lang.String r1 = android.os.Build.BRAND
            java.lang.String r5 = "phone_brand"
            kotlin.Pair r5 = kotlin.TuplesKt.to(r5, r1)
            r6 = 3
            r8[r6] = r5
            com.upuphone.xr.sapp.utils.PhoneRomVersionUtil r5 = com.upuphone.xr.sapp.utils.PhoneRomVersionUtil.f7911a
            java.lang.String r6 = "BRAND"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r6)
            java.lang.String r1 = r5.b(r1)
            java.lang.String r5 = "phone_rom_version"
            kotlin.Pair r1 = kotlin.TuplesKt.to(r5, r1)
            r5 = 4
            r8[r5] = r1
            com.upuphone.xr.sapp.utils.AppUtils r1 = com.upuphone.xr.sapp.utils.AppUtils.f7842a
            android.content.Context r5 = com.upuphone.xr.sapp.utils.GlobalExtKt.f()
            r0.L$0 = r8
            r0.L$1 = r8
            java.lang.String r6 = "phone_starrynet_version"
            r0.L$2 = r6
            r7 = 5
            r0.I$0 = r7
            r0.label = r4
            java.lang.Object r0 = r1.h(r5, r0)
            if (r0 != r9) goto L_0x00bc
            return r9
        L_0x00bc:
            r4 = r8
            r1 = r6
            r9 = r7
            r8 = r0
            r0 = r4
        L_0x00c1:
            kotlin.Pair r8 = kotlin.TuplesKt.to(r1, r8)
            r4[r9] = r8
            java.lang.String r8 = "glass_starrynet_version"
            kotlin.Pair r8 = kotlin.TuplesKt.to(r8, r3)
            r9 = 6
            r0[r9] = r8
            java.lang.String r8 = "data_reporting_source"
            java.lang.Integer r9 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r2)
            kotlin.Pair r8 = kotlin.TuplesKt.to(r8, r9)
            r9 = 7
            r0[r9] = r8
            java.util.Map r8 = kotlin.collections.MapsKt.mutableMapOf(r0)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.datatrack.DataTrackEventHelper.a(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
