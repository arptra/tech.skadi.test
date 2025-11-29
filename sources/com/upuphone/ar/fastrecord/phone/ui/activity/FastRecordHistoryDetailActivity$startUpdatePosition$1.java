package com.upuphone.ar.fastrecord.phone.ui.activity;

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
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordHistoryDetailActivity$startUpdatePosition$1", f = "FastRecordHistoryDetailActivity.kt", i = {}, l = {1468, 1474}, m = "invokeSuspend", n = {}, s = {})
public final class FastRecordHistoryDetailActivity$startUpdatePosition$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    Object L$0;
    int label;
    final /* synthetic */ FastRecordHistoryDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordHistoryDetailActivity$startUpdatePosition$1(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity, Continuation<? super FastRecordHistoryDetailActivity$startUpdatePosition$1> continuation) {
        super(2, continuation);
        this.this$0 = fastRecordHistoryDetailActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordHistoryDetailActivity$startUpdatePosition$1(this.this$0, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0074 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0077  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x002e
            if (r1 == r3) goto L_0x0022
            if (r1 != r2) goto L_0x001a
            int r1 = r9.I$1
            int r4 = r9.I$0
            java.lang.Object r5 = r9.L$0
            com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordHistoryDetailActivity r5 = (com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordHistoryDetailActivity) r5
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0075
        L_0x001a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0022:
            int r1 = r9.I$1
            int r4 = r9.I$0
            java.lang.Object r5 = r9.L$0
            com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordHistoryDetailActivity r5 = (com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordHistoryDetailActivity) r5
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0064
        L_0x002e:
            kotlin.ResultKt.throwOnFailure(r10)
            com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordHistoryDetailActivity r10 = r9.this$0
            r1 = 2147483647(0x7fffffff, float:NaN)
            r4 = 0
            r5 = r10
            r8 = r4
            r4 = r1
            r1 = r8
        L_0x003b:
            if (r1 >= r4) goto L_0x0077
            com.upuphone.ar.fastrecord.databinding.FastRecordHistoryDetailActivityBinding r10 = r5.getLayout()
            com.upuphone.ar.fastrecord.databinding.FastRecordDetailHistoryTitleBinding r10 = r10.k
            com.upuphone.ar.fastrecord.phone.ui.widget.SpeechRecognitionPlayerView r10 = r10.i
            boolean r10 = r10.isTouching()
            if (r10 != 0) goto L_0x0064
            kotlinx.coroutines.MainCoroutineDispatcher r10 = kotlinx.coroutines.Dispatchers.c()
            com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordHistoryDetailActivity$startUpdatePosition$1$1$1 r6 = new com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordHistoryDetailActivity$startUpdatePosition$1$1$1
            r7 = 0
            r6.<init>(r5, r7)
            r9.L$0 = r5
            r9.I$0 = r4
            r9.I$1 = r1
            r9.label = r3
            java.lang.Object r10 = kotlinx.coroutines.BuildersKt.g(r10, r6, r9)
            if (r10 != r0) goto L_0x0064
            return r0
        L_0x0064:
            r9.L$0 = r5
            r9.I$0 = r4
            r9.I$1 = r1
            r9.label = r2
            r6 = 500(0x1f4, double:2.47E-321)
            java.lang.Object r10 = kotlinx.coroutines.DelayKt.b(r6, r9)
            if (r10 != r0) goto L_0x0075
            return r0
        L_0x0075:
            int r1 = r1 + r3
            goto L_0x003b
        L_0x0077:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordHistoryDetailActivity$startUpdatePosition$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordHistoryDetailActivity$startUpdatePosition$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
