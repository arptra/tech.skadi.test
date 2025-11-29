package com.upuphone.ar.fastrecord.phone.utils;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.utils.ViewUtil$startFastRecordIngDetailActivity$1", f = "ViewUtil.kt", i = {}, l = {48, 49}, m = "invokeSuspend", n = {}, s = {})
public final class ViewUtil$startFastRecordIngDetailActivity$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Function0<Unit> $callback;
    final /* synthetic */ long $recordId;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewUtil$startFastRecordIngDetailActivity$1(long j, Function0<Unit> function0, Activity activity, Continuation<? super ViewUtil$startFastRecordIngDetailActivity$1> continuation) {
        super(2, continuation);
        this.$recordId = j;
        this.$callback = function0;
        this.$activity = activity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ViewUtil$startFastRecordIngDetailActivity$1(this.$recordId, this.$callback, this.$activity, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x006a  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x001e
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0066
        L_0x0012:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x001a:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x004f
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r8)
            long r4 = r7.$recordId
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "startFastRecordIngDetailActivity start recordId = "
            r8.append(r1)
            r8.append(r4)
            java.lang.String r8 = r8.toString()
            java.lang.String r1 = "ViewUtil"
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r8, r1)
            com.upuphone.ar.fastrecord.phone.FastRecordManager$Companion r8 = com.upuphone.ar.fastrecord.phone.FastRecordManager.Companion
            com.upuphone.ar.fastrecord.phone.FastRecordManager r8 = r8.getInstance()
            com.upuphone.ar.fastrecord.phone.db.FastRecordDao r8 = r8.fastRecordDao()
            long r4 = r7.$recordId
            r7.label = r3
            r1 = 0
            java.lang.Object r8 = r8.updateRecordIsNewRecordItemState(r4, r1, r7)
            if (r8 != r0) goto L_0x004f
            return r0
        L_0x004f:
            kotlinx.coroutines.MainCoroutineDispatcher r8 = kotlinx.coroutines.Dispatchers.c()
            com.upuphone.ar.fastrecord.phone.utils.ViewUtil$startFastRecordIngDetailActivity$1$1 r1 = new com.upuphone.ar.fastrecord.phone.utils.ViewUtil$startFastRecordIngDetailActivity$1$1
            long r3 = r7.$recordId
            android.app.Activity r5 = r7.$activity
            r6 = 0
            r1.<init>(r3, r5, r6)
            r7.label = r2
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.g(r8, r1, r7)
            if (r8 != r0) goto L_0x0066
            return r0
        L_0x0066:
            kotlin.jvm.functions.Function0<kotlin.Unit> r7 = r7.$callback
            if (r7 == 0) goto L_0x006d
            r7.invoke()
        L_0x006d:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.utils.ViewUtil$startFastRecordIngDetailActivity$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ViewUtil$startFastRecordIngDetailActivity$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
