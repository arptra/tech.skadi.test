package com.upuphone.xr.sapp.utils;

import androidx.appcompat.app.AppCompatActivity;
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
@DebugMetadata(c = "com.upuphone.xr.sapp.utils.AppUpdateHelper$checkUpdate$1", f = "AppUpdateHelper.kt", i = {2}, l = {123, 126, 127, 146}, m = "invokeSuspend", n = {"httpResult"}, s = {"L$0"})
public final class AppUpdateHelper$checkUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppCompatActivity $activity;
    final /* synthetic */ long $delay;
    Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppUpdateHelper$checkUpdate$1(long j, AppCompatActivity appCompatActivity, Continuation<? super AppUpdateHelper$checkUpdate$1> continuation) {
        super(2, continuation);
        this.$delay = j;
        this.$activity = appCompatActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AppUpdateHelper$checkUpdate$1(this.$delay, this.$activity, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0066 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00db  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 4
            r3 = 3
            r4 = 2
            java.lang.String r5 = "AppUpdateHelper"
            r6 = 1
            if (r1 == 0) goto L_0x0033
            if (r1 == r6) goto L_0x002f
            if (r1 == r4) goto L_0x002b
            if (r1 == r3) goto L_0x0023
            if (r1 != r2) goto L_0x001b
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00d8
        L_0x001b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0023:
            java.lang.Object r1 = r9.L$0
            com.upuphone.star.httplib.HttpResult r1 = (com.upuphone.star.httplib.HttpResult) r1
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0067
        L_0x002b:
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0055
        L_0x002f:
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0041
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r10)
            long r7 = r9.$delay
            r9.label = r6
            java.lang.Object r10 = kotlinx.coroutines.DelayKt.b(r7, r9)
            if (r10 != r0) goto L_0x0041
            return r0
        L_0x0041:
            com.upuphone.star.core.log.ULog$Delegate r10 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r1 = "checkUpdate, start"
            r10.a(r5, r1)
            com.upuphone.xr.sapp.utils.AppUpdateHelper r10 = com.upuphone.xr.sapp.utils.AppUpdateHelper.f7841a
            androidx.appcompat.app.AppCompatActivity r1 = r9.$activity
            r9.label = r4
            java.lang.Object r10 = r10.y(r1, r9)
            if (r10 != r0) goto L_0x0055
            return r0
        L_0x0055:
            r1 = r10
            com.upuphone.star.httplib.HttpResult r1 = (com.upuphone.star.httplib.HttpResult) r1
            kotlinx.coroutines.flow.MutableSharedFlow r10 = com.upuphone.xr.sapp.utils.AppUpdateHelper.f
            r9.L$0 = r1
            r9.label = r3
            java.lang.Object r10 = r10.emit(r1, r9)
            if (r10 != r0) goto L_0x0067
            return r0
        L_0x0067:
            r10 = 0
            java.lang.Object r1 = com.upuphone.star.httplib.HttpResultKt.b(r1)     // Catch:{ Exception -> 0x006f }
            com.upuphone.xr.sapp.entity.BasicResponse r1 = (com.upuphone.xr.sapp.entity.BasicResponse) r1     // Catch:{ Exception -> 0x006f }
            goto L_0x0087
        L_0x006f:
            r1 = move-exception
            com.upuphone.star.core.log.ULog$Delegate r3 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r7 = "checkUpdate, error: "
            r4.append(r7)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            r3.c(r5, r1)
            r1 = r10
        L_0x0087:
            com.upuphone.star.core.log.ULog$Delegate r3 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r7 = "checkUpdate, appUpdateResult: "
            r4.append(r7)
            r4.append(r1)
            java.lang.String r4 = r4.toString()
            r3.a(r5, r4)
            if (r1 == 0) goto L_0x00a6
            java.lang.Object r3 = r1.getData()
            com.upuphone.xr.sapp.entity.AppUpdateInfo r3 = (com.upuphone.xr.sapp.entity.AppUpdateInfo) r3
            goto L_0x00a7
        L_0x00a6:
            r3 = r10
        L_0x00a7:
            com.upuphone.xr.sapp.utils.AppUpdateHelper.d = r3
            if (r3 == 0) goto L_0x00b7
            boolean r3 = r3.getExistsUpdate()
            if (r3 != 0) goto L_0x00b7
            com.upuphone.xr.sapp.glass.GlassCompatHelper r3 = com.upuphone.xr.sapp.glass.GlassCompatHelper.b
            r3.l()
        L_0x00b7:
            com.upuphone.xr.sapp.utils.AppUpdateHelper r3 = com.upuphone.xr.sapp.utils.AppUpdateHelper.f7841a
            r3.G()
            if (r1 == 0) goto L_0x00db
            boolean r1 = com.upuphone.xr.sapp.entity.BasicResponseKt.isSuccess(r1)
            if (r1 != r6) goto L_0x00db
            com.upuphone.xr.sapp.entity.AppUpdateInfo r1 = com.upuphone.xr.sapp.utils.AppUpdateHelper.d
            if (r1 != 0) goto L_0x00cb
            goto L_0x00db
        L_0x00cb:
            androidx.appcompat.app.AppCompatActivity r1 = r9.$activity
            r9.L$0 = r10
            r9.label = r2
            java.lang.Object r9 = r3.r(r1, r9)
            if (r9 != r0) goto L_0x00d8
            return r0
        L_0x00d8:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L_0x00db:
            com.upuphone.xr.sapp.utils.AppUpdateHelper.e = r6
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.utils.AppUpdateHelper$checkUpdate$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AppUpdateHelper$checkUpdate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
