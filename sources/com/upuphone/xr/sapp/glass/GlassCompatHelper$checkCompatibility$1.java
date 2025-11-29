package com.upuphone.xr.sapp.glass;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nGlassCompatHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlassCompatHelper.kt\ncom/upuphone/xr/sapp/glass/GlassCompatHelper$checkCompatibility$1\n+ 2 Runnable.kt\nkotlinx/coroutines/RunnableKt\n*L\n1#1,275:1\n17#2:276\n*S KotlinDebug\n*F\n+ 1 GlassCompatHelper.kt\ncom/upuphone/xr/sapp/glass/GlassCompatHelper$checkCompatibility$1\n*L\n155#1:276\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.glass.GlassCompatHelper$checkCompatibility$1", f = "GlassCompatHelper.kt", i = {0, 1, 2, 2}, l = {121, 124, 140}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "$this$launch", "glassInfo"}, s = {"L$0", "L$0", "L$0", "L$1"})
public final class GlassCompatHelper$checkCompatibility$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delay;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlassCompatHelper$checkCompatibility$1(long j, Continuation<? super GlassCompatHelper$checkCompatibility$1> continuation) {
        super(2, continuation);
        this.$delay = j;
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0() {
        GlassCompatHelper.h(GlassCompatHelper.b, 0, 1, (Object) null);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GlassCompatHelper$checkCompatibility$1 glassCompatHelper$checkCompatibility$1 = new GlassCompatHelper$checkCompatibility$1(this.$delay, continuation);
        glassCompatHelper$checkCompatibility$1.L$0 = obj;
        return glassCompatHelper$checkCompatibility$1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00fb  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            java.lang.String r6 = "GlassCompatHelper"
            if (r1 == 0) goto L_0x003f
            if (r1 == r4) goto L_0x0037
            if (r1 == r3) goto L_0x002c
            if (r1 != r2) goto L_0x0024
            java.lang.Object r0 = r9.L$1
            com.upuphone.xr.sapp.entity.BasicGlassInfo r0 = (com.upuphone.xr.sapp.entity.BasicGlassInfo) r0
            java.lang.Object r9 = r9.L$0
            kotlinx.coroutines.CoroutineScope r9 = (kotlinx.coroutines.CoroutineScope) r9
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ Exception -> 0x0021 }
            goto L_0x0097
        L_0x0021:
            r9 = move-exception
            goto L_0x00a2
        L_0x0024:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x002c:
            java.lang.Object r1 = r9.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ Exception -> 0x0034 }
            goto L_0x0061
        L_0x0034:
            r9 = move-exception
            goto L_0x010d
        L_0x0037:
            java.lang.Object r1 = r9.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0054
        L_0x003f:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.Object r10 = r9.L$0
            kotlinx.coroutines.CoroutineScope r10 = (kotlinx.coroutines.CoroutineScope) r10
            long r7 = r9.$delay
            r9.L$0 = r10
            r9.label = r4
            java.lang.Object r1 = kotlinx.coroutines.DelayKt.b(r7, r9)
            if (r1 != r0) goto L_0x0053
            return r0
        L_0x0053:
            r1 = r10
        L_0x0054:
            com.upuphone.xr.sapp.glass.GlassUpdateHelper r10 = com.upuphone.xr.sapp.glass.GlassUpdateHelper.b     // Catch:{ Exception -> 0x0034 }
            r9.L$0 = r1     // Catch:{ Exception -> 0x0034 }
            r9.label = r3     // Catch:{ Exception -> 0x0034 }
            java.lang.Object r10 = r10.z0(r9)     // Catch:{ Exception -> 0x0034 }
            if (r10 != r0) goto L_0x0061
            return r0
        L_0x0061:
            com.upuphone.xr.sapp.entity.BasicGlassInfo r10 = (com.upuphone.xr.sapp.entity.BasicGlassInfo) r10     // Catch:{ Exception -> 0x0034 }
            if (r10 != 0) goto L_0x006f
            com.upuphone.star.core.log.ULog$Delegate r9 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r10 = "checkCompatibility, glassInfo is null"
            r9.c(r6, r10)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L_0x006f:
            com.upuphone.xr.sapp.utils.NetworkUtils r3 = com.upuphone.xr.sapp.utils.NetworkUtils.f7898a
            boolean r3 = r3.g()
            if (r3 != 0) goto L_0x0086
            java.util.concurrent.CopyOnWriteArraySet r9 = com.upuphone.xr.sapp.glass.GlassCompatHelper.f
            com.upuphone.xr.sapp.glass.a r10 = new com.upuphone.xr.sapp.glass.a
            r10.<init>()
            r9.add(r10)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L_0x0086:
            com.upuphone.xr.sapp.glass.GlassCompatHelper r3 = com.upuphone.xr.sapp.glass.GlassCompatHelper.b     // Catch:{ Exception -> 0x00a0 }
            r9.L$0 = r1     // Catch:{ Exception -> 0x00a0 }
            r9.L$1 = r10     // Catch:{ Exception -> 0x00a0 }
            r9.label = r2     // Catch:{ Exception -> 0x00a0 }
            java.lang.Object r9 = r3.j(r10, r9)     // Catch:{ Exception -> 0x00a0 }
            if (r9 != r0) goto L_0x0095
            return r0
        L_0x0095:
            r0 = r10
            r10 = r9
        L_0x0097:
            com.upuphone.star.httplib.HttpResult r10 = (com.upuphone.star.httplib.HttpResult) r10     // Catch:{ Exception -> 0x0021 }
            java.lang.Object r9 = com.upuphone.star.httplib.HttpResultKt.b(r10)     // Catch:{ Exception -> 0x0021 }
            com.upuphone.xr.sapp.entity.BasicResponse r9 = (com.upuphone.xr.sapp.entity.BasicResponse) r9     // Catch:{ Exception -> 0x0021 }
            goto L_0x00b9
        L_0x00a0:
            r9 = move-exception
            r0 = r10
        L_0x00a2:
            com.upuphone.star.core.log.ULog$Delegate r10 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "checkCompatibility, error: "
            r1.append(r2)
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            r10.a(r6, r9)
            r9 = r5
        L_0x00b9:
            com.upuphone.star.core.log.ULog$Delegate r10 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "checkCompatibility, result: "
            r1.append(r2)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            r10.a(r6, r1)
            if (r9 == 0) goto L_0x00fb
            boolean r10 = com.upuphone.xr.sapp.entity.BasicResponseKt.isSuccess(r9)
            if (r10 != r4) goto L_0x00fb
            java.lang.Object r10 = r9.getData()
            com.upuphone.xr.sapp.entity.DeviceCompatInfo r10 = (com.upuphone.xr.sapp.entity.DeviceCompatInfo) r10
            if (r10 == 0) goto L_0x00f4
            com.upuphone.xr.sapp.glass.GlassCompatHelper r1 = com.upuphone.xr.sapp.glass.GlassCompatHelper.b
            java.lang.Object r9 = r9.getData()
            kotlin.Pair r9 = kotlin.TuplesKt.to(r0, r9)
            com.upuphone.xr.sapp.glass.GlassCompatHelper.g = r9
            com.upuphone.xr.sapp.glass.GlassCompatHelper r9 = com.upuphone.xr.sapp.glass.GlassCompatHelper.b
            r9.k(r0, r10)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x00f5
        L_0x00f4:
            r9 = r5
        L_0x00f5:
            if (r9 != 0) goto L_0x010a
            com.upuphone.xr.sapp.glass.GlassCompatHelper.g = r5
            goto L_0x010a
        L_0x00fb:
            com.upuphone.xr.sapp.glass.GlassCompatHelper.g = r5
            java.util.concurrent.CopyOnWriteArraySet r9 = com.upuphone.xr.sapp.glass.GlassCompatHelper.f
            com.upuphone.xr.sapp.glass.GlassCompatHelper$checkCompatibility$1$invokeSuspend$$inlined$Runnable$1 r10 = new com.upuphone.xr.sapp.glass.GlassCompatHelper$checkCompatibility$1$invokeSuspend$$inlined$Runnable$1
            r10.<init>()
            r9.add(r10)
        L_0x010a:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L_0x010d:
            com.upuphone.star.core.log.ULog$Delegate r10 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "checkCompatibility, getGlassInfo error: "
            r0.append(r1)
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            r10.c(r6, r9)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.glass.GlassCompatHelper$checkCompatibility$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GlassCompatHelper$checkCompatibility$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
