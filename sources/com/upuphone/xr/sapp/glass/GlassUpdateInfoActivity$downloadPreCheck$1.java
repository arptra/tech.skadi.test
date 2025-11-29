package com.upuphone.xr.sapp.glass;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.glass.GlassUpdateInfoActivity$downloadPreCheck$1", f = "GlassUpdateInfoActivity.kt", i = {0, 0, 0, 0, 1, 1, 1, 2}, l = {754, 762, 769}, m = "invokeSuspend", n = {"glassUpdateInfo", "latestVersion", "digest", "requiredStorage", "glassUpdateInfo", "latestVersion", "digest", "glassUpdateInfo"}, s = {"L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "L$0"})
public final class GlassUpdateInfoActivity$downloadPreCheck$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ GlassUpdateInfoActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlassUpdateInfoActivity$downloadPreCheck$1(GlassUpdateInfoActivity glassUpdateInfoActivity, Continuation<? super GlassUpdateInfoActivity$downloadPreCheck$1> continuation) {
        super(2, continuation);
        this.this$0 = glassUpdateInfoActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GlassUpdateInfoActivity$downloadPreCheck$1(this.this$0, continuation);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0087, code lost:
        r0 = r0.getSecond();
     */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01ba A[Catch:{ all -> 0x0023 }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01cb A[SYNTHETIC, Splitter:B:82:0x01cb] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01eb A[Catch:{ all -> 0x0023 }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0203  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r18) {
        /*
            r17 = this;
            r1 = r17
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r1.label
            r3 = 3
            r4 = 1
            r5 = 2
            java.lang.String r6 = "GlassUpdateInfoActivity"
            r7 = 0
            r8 = 0
            if (r0 == 0) goto L_0x005b
            if (r0 == r4) goto L_0x0043
            if (r0 == r5) goto L_0x002e
            if (r0 != r3) goto L_0x0026
            java.lang.Object r0 = r1.L$0
            com.upuphone.star.fota.phone.GlassUpdateInfo r0 = (com.upuphone.star.fota.phone.GlassUpdateInfo) r0
            kotlin.ResultKt.throwOnFailure(r18)     // Catch:{ all -> 0x0023 }
            r12 = r0
            r0 = r18
            goto L_0x01e3
        L_0x0023:
            r0 = move-exception
            goto L_0x0305
        L_0x0026:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x002e:
            java.lang.Object r0 = r1.L$2
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r9 = r1.L$1
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r10 = r1.L$0
            com.upuphone.star.fota.phone.GlassUpdateInfo r10 = (com.upuphone.star.fota.phone.GlassUpdateInfo) r10
            kotlin.ResultKt.throwOnFailure(r18)     // Catch:{ all -> 0x0023 }
            r12 = r10
            r10 = r0
            r0 = r18
            goto L_0x01b2
        L_0x0043:
            long r9 = r1.J$0
            java.lang.Object r0 = r1.L$2
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r11 = r1.L$1
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r12 = r1.L$0
            com.upuphone.star.fota.phone.GlassUpdateInfo r12 = (com.upuphone.star.fota.phone.GlassUpdateInfo) r12
            kotlin.ResultKt.throwOnFailure(r18)     // Catch:{ all -> 0x0023 }
            r13 = r9
            r9 = r11
            r10 = r0
            r0 = r18
            goto L_0x0181
        L_0x005b:
            kotlin.ResultKt.throwOnFailure(r18)
            com.upuphone.xr.sapp.glass.GlassUpdateInfoActivity r0 = r1.this$0
            com.upuphone.xr.sapp.entity.GlassCheckUpdateState r0 = r0.g
            boolean r9 = r0 instanceof com.upuphone.xr.sapp.entity.GlassCheckUpdateState.Result
            if (r9 != 0) goto L_0x0081
            com.upuphone.star.core.log.ULog$Delegate r1 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "downloadPreCheck, invalid currentGlassCheckUpdateState: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.c(r6, r0)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0081:
            kotlin.Pair r0 = com.upuphone.xr.sapp.entity.GlassCheckUpdateStateKt.getResultOrNull(r0)
            if (r0 == 0) goto L_0x0095
            java.lang.Object r0 = r0.getSecond()
            com.upuphone.star.fota.phone.GlassCheckUpdateResult r0 = (com.upuphone.star.fota.phone.GlassCheckUpdateResult) r0
            if (r0 == 0) goto L_0x0095
            com.upuphone.star.fota.phone.GlassUpdateInfo r0 = com.upuphone.star.fota.phone.GlassCheckUpdateResultKt.a(r0)
            r12 = r0
            goto L_0x0096
        L_0x0095:
            r12 = r7
        L_0x0096:
            if (r12 != 0) goto L_0x00a2
            com.upuphone.star.core.log.ULog$Delegate r0 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r1 = "downloadPreCheck, glassUpdateInfo is null"
            r0.c(r6, r1)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x00a2:
            java.lang.String r9 = r12.getLatestVersion()
            java.lang.String r10 = r12.getDigest()
            java.lang.Long r0 = r12.getFileSize()
            r13 = 0
            if (r0 == 0) goto L_0x00b7
            long r15 = r0.longValue()
            goto L_0x00b8
        L_0x00b7:
            r15 = r13
        L_0x00b8:
            java.lang.String r0 = r12.getPackLink()
            if (r0 == 0) goto L_0x030f
            int r0 = r0.length()
            if (r0 != 0) goto L_0x00c6
            goto L_0x030f
        L_0x00c6:
            if (r9 == 0) goto L_0x030f
            int r0 = r9.length()
            if (r0 != 0) goto L_0x00d0
            goto L_0x030f
        L_0x00d0:
            if (r10 == 0) goto L_0x030f
            int r0 = r10.length()
            if (r0 != 0) goto L_0x00da
            goto L_0x030f
        L_0x00da:
            int r0 = (r15 > r13 ? 1 : (r15 == r13 ? 0 : -1))
            if (r0 > 0) goto L_0x00e0
            goto L_0x030f
        L_0x00e0:
            long r13 = com.upuphone.xr.sapp.glass.GlassExtKt.a(r12)
            android.os.StatFs r0 = new android.os.StatFs     // Catch:{ Exception -> 0x00f7 }
            java.io.File r11 = android.os.Environment.getDataDirectory()     // Catch:{ Exception -> 0x00f7 }
            java.lang.String r11 = r11.getAbsolutePath()     // Catch:{ Exception -> 0x00f7 }
            r0.<init>(r11)     // Catch:{ Exception -> 0x00f7 }
            long r15 = r0.getAvailableBytes()     // Catch:{ Exception -> 0x00f7 }
            r4 = r15
            goto L_0x0110
        L_0x00f7:
            r0 = move-exception
            com.upuphone.star.core.log.ULog$Delegate r11 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r3 = "downloadPreCheck, getDataDirectory availableBytes error: "
            r15.append(r3)
            r15.append(r0)
            java.lang.String r0 = r15.toString()
            r11.a(r6, r0)
            r4 = 0
        L_0x0110:
            int r0 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r0 >= 0) goto L_0x014d
            com.upuphone.star.core.log.ULog$Delegate r0 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "downloadPreCheck, phoneAvailableBytes("
            r2.append(r3)
            r2.append(r4)
            java.lang.String r3 = ") < requiredStorage("
            r2.append(r3)
            r2.append(r13)
            java.lang.String r3 = ")"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.a(r6, r2)
            com.upuphone.xr.sapp.glass.GlassUpdateInfoActivity r0 = r1.this$0
            r1 = 118(0x76, float:1.65E-43)
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            java.lang.Integer[] r1 = new java.lang.Integer[]{r1}
            java.util.ArrayList r1 = kotlin.collections.CollectionsKt.arrayListOf(r1)
            com.upuphone.xr.sapp.utils.StaticMethodUtilsKt.A(r0, r1, r8, r8)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x014d:
            com.upuphone.xr.sapp.glass.GlassHelper r0 = com.upuphone.xr.sapp.glass.GlassHelper.f7049a
            boolean r4 = r0.E()
            if (r4 != 0) goto L_0x0160
            com.upuphone.xr.sapp.glass.GlassUpdateInfoActivity r0 = r1.this$0
            int r1 = com.upuphone.xr.sapp.R.string.device_disconnect
            r2 = 2
            com.upuphone.xr.sapp.utils.ContextExtKt.f(r0, r1, r8, r2, r7)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0160:
            com.upuphone.xr.sapp.glass.GlassUpdateInfoActivity r4 = r1.this$0
            com.meizu.common.app.LoadingDialog r4 = r4.O0()
            r4.show()
            com.upuphone.xr.sapp.glass.GlassUpdateAdapter r4 = com.upuphone.xr.sapp.glass.GlassUpdateAdapter.b     // Catch:{ all -> 0x0023 }
            com.upuphone.xr.interconnect.entity.StarryNetDevice r0 = r0.x()     // Catch:{ all -> 0x0023 }
            r1.L$0 = r12     // Catch:{ all -> 0x0023 }
            r1.L$1 = r9     // Catch:{ all -> 0x0023 }
            r1.L$2 = r10     // Catch:{ all -> 0x0023 }
            r1.J$0 = r13     // Catch:{ all -> 0x0023 }
            r3 = 1
            r1.label = r3     // Catch:{ all -> 0x0023 }
            java.lang.Object r0 = r4.g(r0, r1)     // Catch:{ all -> 0x0023 }
            if (r0 != r2) goto L_0x0181
            return r2
        L_0x0181:
            java.lang.Number r0 = (java.lang.Number) r0     // Catch:{ all -> 0x0023 }
            int r0 = r0.intValue()     // Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x019a
            com.upuphone.xr.sapp.glass.GlassUpdateInfoActivity r2 = r1.this$0     // Catch:{ all -> 0x0023 }
            r2.Q0(r0)     // Catch:{ all -> 0x0023 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0023 }
            com.upuphone.xr.sapp.glass.GlassUpdateInfoActivity r1 = r1.this$0
            com.meizu.common.app.LoadingDialog r1 = r1.O0()
            r1.dismiss()
            return r0
        L_0x019a:
            com.upuphone.xr.sapp.glass.GlassUpdateAdapter r0 = com.upuphone.xr.sapp.glass.GlassUpdateAdapter.b     // Catch:{ all -> 0x0023 }
            com.upuphone.xr.sapp.glass.GlassHelper r4 = com.upuphone.xr.sapp.glass.GlassHelper.f7049a     // Catch:{ all -> 0x0023 }
            com.upuphone.xr.interconnect.entity.StarryNetDevice r4 = r4.x()     // Catch:{ all -> 0x0023 }
            r1.L$0 = r12     // Catch:{ all -> 0x0023 }
            r1.L$1 = r9     // Catch:{ all -> 0x0023 }
            r1.L$2 = r10     // Catch:{ all -> 0x0023 }
            r5 = 2
            r1.label = r5     // Catch:{ all -> 0x0023 }
            java.lang.Object r0 = r0.e(r4, r13, r1)     // Catch:{ all -> 0x0023 }
            if (r0 != r2) goto L_0x01b2
            return r2
        L_0x01b2:
            java.lang.Number r0 = (java.lang.Number) r0     // Catch:{ all -> 0x0023 }
            int r0 = r0.intValue()     // Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x01cb
            com.upuphone.xr.sapp.glass.GlassUpdateInfoActivity r2 = r1.this$0     // Catch:{ all -> 0x0023 }
            r2.Q0(r0)     // Catch:{ all -> 0x0023 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0023 }
            com.upuphone.xr.sapp.glass.GlassUpdateInfoActivity r1 = r1.this$0
            com.meizu.common.app.LoadingDialog r1 = r1.O0()
            r1.dismiss()
            return r0
        L_0x01cb:
            com.upuphone.xr.sapp.glass.GlassUpdateAdapter r0 = com.upuphone.xr.sapp.glass.GlassUpdateAdapter.b     // Catch:{ all -> 0x0023 }
            com.upuphone.xr.sapp.glass.GlassHelper r4 = com.upuphone.xr.sapp.glass.GlassHelper.f7049a     // Catch:{ all -> 0x0023 }
            com.upuphone.xr.interconnect.entity.StarryNetDevice r4 = r4.x()     // Catch:{ all -> 0x0023 }
            r1.L$0 = r12     // Catch:{ all -> 0x0023 }
            r1.L$1 = r7     // Catch:{ all -> 0x0023 }
            r1.L$2 = r7     // Catch:{ all -> 0x0023 }
            r5 = 3
            r1.label = r5     // Catch:{ all -> 0x0023 }
            java.lang.Object r0 = r0.f(r4, r9, r10, r1)     // Catch:{ all -> 0x0023 }
            if (r0 != r2) goto L_0x01e3
            return r2
        L_0x01e3:
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0023 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x0203
            com.upuphone.star.core.log.ULog$Delegate r0 = com.upuphone.star.core.log.ULog.f6446a     // Catch:{ all -> 0x0023 }
            java.lang.String r2 = "isUpdateFileExist=true, installUpdateNow"
            r0.a(r6, r2)     // Catch:{ all -> 0x0023 }
            com.upuphone.xr.sapp.glass.GlassUpdateHelper r0 = com.upuphone.xr.sapp.glass.GlassUpdateHelper.b     // Catch:{ all -> 0x0023 }
            r0.a1(r12)     // Catch:{ all -> 0x0023 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0023 }
            com.upuphone.xr.sapp.glass.GlassUpdateInfoActivity r1 = r1.this$0
            com.meizu.common.app.LoadingDialog r1 = r1.O0()
            r1.dismiss()
            return r0
        L_0x0203:
            com.upuphone.xr.sapp.glass.GlassUpdateInfoActivity r0 = r1.this$0
            com.meizu.common.app.LoadingDialog r0 = r0.O0()
            r0.dismiss()
            com.upuphone.xr.sapp.glass.GlassHelper r0 = com.upuphone.xr.sapp.glass.GlassHelper.f7049a
            com.upuphone.xr.interconnect.entity.StarryNetDevice r2 = r0.x()
            if (r2 != 0) goto L_0x021f
            com.upuphone.xr.sapp.glass.GlassUpdateInfoActivity r0 = r1.this$0
            int r1 = com.upuphone.xr.sapp.R.string.device_disconnect
            r2 = 2
            com.upuphone.xr.sapp.utils.ContextExtKt.f(r0, r1, r8, r2, r7)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x021f:
            boolean r0 = r0.G(r2)
            if (r0 == 0) goto L_0x02c2
            com.upuphone.xr.sapp.utils.NetworkUtils r0 = com.upuphone.xr.sapp.utils.NetworkUtils.f7898a
            boolean r2 = r0.l()
            if (r2 != 0) goto L_0x0243
            com.upuphone.xr.sapp.glass.GlassUpdateInfoActivity r0 = r1.this$0
            r1 = 152(0x98, float:2.13E-43)
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            java.lang.Integer[] r1 = new java.lang.Integer[]{r1}
            java.util.ArrayList r1 = kotlin.collections.CollectionsKt.arrayListOf(r1)
            com.upuphone.xr.sapp.utils.StaticMethodUtilsKt.A(r0, r1, r8, r8)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0243:
            boolean r0 = r0.k()
            if (r0 == 0) goto L_0x025f
            com.upuphone.xr.sapp.glass.GlassUpdateInfoActivity r0 = r1.this$0
            r1 = 156(0x9c, float:2.19E-43)
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            java.lang.Integer[] r1 = new java.lang.Integer[]{r1}
            java.util.ArrayList r1 = kotlin.collections.CollectionsKt.arrayListOf(r1)
            com.upuphone.xr.sapp.utils.StaticMethodUtilsKt.A(r0, r1, r8, r8)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x025f:
            com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils r0 = com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils.f7907a
            boolean r2 = r0.w()
            if (r2 != 0) goto L_0x0282
            com.upuphone.xr.sapp.glass.GlassUpdateInfoActivity r0 = r1.this$0
            androidx.activity.result.ActivityResultLauncher r0 = r0.m
            if (r0 != 0) goto L_0x0275
            java.lang.String r0 = "requestPermissionLauncher"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            goto L_0x0276
        L_0x0275:
            r7 = r0
        L_0x0276:
            java.lang.String r0 = "android.permission.ACCESS_FINE_LOCATION"
            java.lang.String[] r0 = new java.lang.String[]{r0}
            r7.a(r0)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0282:
            java.lang.Boolean r2 = r0.x()
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r8)
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r4)
            if (r2 == 0) goto L_0x02a6
            com.upuphone.xr.sapp.glass.GlassUpdateInfoActivity r0 = r1.this$0
            r1 = 155(0x9b, float:2.17E-43)
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            java.lang.Integer[] r1 = new java.lang.Integer[]{r1}
            java.util.ArrayList r1 = kotlin.collections.CollectionsKt.arrayListOf(r1)
            com.upuphone.xr.sapp.utils.StaticMethodUtilsKt.A(r0, r1, r8, r8)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x02a6:
            boolean r0 = r0.B()
            if (r0 != 0) goto L_0x02c2
            com.upuphone.xr.sapp.glass.GlassUpdateInfoActivity r0 = r1.this$0
            r1 = 153(0x99, float:2.14E-43)
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            java.lang.Integer[] r1 = new java.lang.Integer[]{r1}
            java.util.ArrayList r1 = kotlin.collections.CollectionsKt.arrayListOf(r1)
            com.upuphone.xr.sapp.utils.StaticMethodUtilsKt.A(r0, r1, r8, r8)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x02c2:
            com.upuphone.xr.sapp.utils.NetworkUtils r0 = com.upuphone.xr.sapp.utils.NetworkUtils.f7898a
            boolean r2 = r0.g()
            if (r2 != 0) goto L_0x02e0
            com.upuphone.xr.sapp.glass.GlassUpdateInfoActivity r0 = r1.this$0
            r1 = 120(0x78, float:1.68E-43)
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            java.lang.Integer[] r1 = new java.lang.Integer[]{r1}
            java.util.ArrayList r1 = kotlin.collections.CollectionsKt.arrayListOf(r1)
            com.upuphone.xr.sapp.utils.StaticMethodUtilsKt.A(r0, r1, r8, r8)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x02e0:
            boolean r0 = r0.f()
            if (r0 == 0) goto L_0x02fc
            com.upuphone.xr.sapp.glass.GlassUpdateInfoActivity r0 = r1.this$0
            r1 = 103(0x67, float:1.44E-43)
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            java.lang.Integer[] r1 = new java.lang.Integer[]{r1}
            java.util.ArrayList r1 = kotlin.collections.CollectionsKt.arrayListOf(r1)
            com.upuphone.xr.sapp.utils.StaticMethodUtilsKt.A(r0, r1, r8, r8)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x02fc:
            com.upuphone.xr.sapp.glass.GlassUpdateInfoActivity r0 = r1.this$0
            r1 = 1
            r0.K0(r1)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0305:
            com.upuphone.xr.sapp.glass.GlassUpdateInfoActivity r1 = r1.this$0
            com.meizu.common.app.LoadingDialog r1 = r1.O0()
            r1.dismiss()
            throw r0
        L_0x030f:
            com.upuphone.star.core.log.ULog$Delegate r0 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "downloadPreCheck, invalid glassUpdateInfo: "
            r2.append(r3)
            r2.append(r12)
            java.lang.String r2 = r2.toString()
            r0.c(r6, r2)
            com.upuphone.xr.sapp.glass.GlassUpdateInfoActivity r0 = r1.this$0
            int r1 = com.upuphone.xr.sapp.R.string.update_info_invalid
            r2 = 2
            com.upuphone.xr.sapp.utils.ContextExtKt.f(r0, r1, r8, r2, r7)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.glass.GlassUpdateInfoActivity$downloadPreCheck$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GlassUpdateInfoActivity$downloadPreCheck$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
