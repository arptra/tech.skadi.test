package com.upuphone.ar.tici.phone.viewmodel;

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
@DebugMetadata(c = "com.upuphone.ar.tici.phone.viewmodel.TiciHistoryViewModel$loadTiciHistory$1", f = "TiciHistoryViewModel.kt", i = {}, l = {44, 47, 50}, m = "invokeSuspend", n = {}, s = {})
public final class TiciHistoryViewModel$loadTiciHistory$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Long $time;
    final /* synthetic */ String $userId;
    int label;
    final /* synthetic */ TiciHistoryViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciHistoryViewModel$loadTiciHistory$1(Long l, String str, TiciHistoryViewModel ticiHistoryViewModel, Continuation<? super TiciHistoryViewModel$loadTiciHistory$1> continuation) {
        super(2, continuation);
        this.$time = l;
        this.$userId = str;
        this.this$0 = ticiHistoryViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TiciHistoryViewModel$loadTiciHistory$1(this.$time, this.$userId, this.this$0, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0097 A[RETURN] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0026
            if (r1 == r4) goto L_0x0022
            if (r1 == r3) goto L_0x001e
            if (r1 != r2) goto L_0x0016
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0098
        L_0x0016:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x007e
        L_0x0022:
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x005f
        L_0x0026:
            kotlin.ResultKt.throwOnFailure(r12)
            java.lang.Long r12 = r11.$time
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = "loadTiciHistory, "
            r1.append(r5)
            r1.append(r12)
            java.lang.String r12 = r1.toString()
            java.lang.String r1 = "TiciHistoryViewModel"
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r12, r1)
            java.lang.Long r12 = r11.$time
            if (r12 == 0) goto L_0x0062
            com.upuphone.ar.tici.phone.TiciApp r12 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.db.TiciDao r5 = r12.w()
            java.lang.String r6 = r11.$userId
            java.lang.Long r12 = r11.$time
            long r7 = r12.longValue()
            r11.label = r4
            r9 = 20
            r10 = r11
            java.lang.Object r12 = r5.u(r6, r7, r9, r10)
            if (r12 != r0) goto L_0x005f
            return r0
        L_0x005f:
            java.util.List r12 = (java.util.List) r12
            goto L_0x0080
        L_0x0062:
            com.upuphone.ar.tici.phone.viewmodel.TiciHistoryViewModel r12 = r11.this$0
            java.util.List r12 = r12.e
            r12.clear()
            com.upuphone.ar.tici.phone.TiciApp r12 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.db.TiciDao r12 = r12.w()
            java.lang.String r1 = r11.$userId
            r11.label = r3
            r3 = 20
            java.lang.Object r12 = r12.c(r1, r3, r11)
            if (r12 != r0) goto L_0x007e
            return r0
        L_0x007e:
            java.util.List r12 = (java.util.List) r12
        L_0x0080:
            com.upuphone.ar.tici.phone.viewmodel.TiciHistoryViewModel r1 = r11.this$0
            java.util.List r1 = r1.e
            r1.addAll(r12)
            com.upuphone.ar.tici.phone.viewmodel.TiciHistoryViewModel r12 = r11.this$0
            java.util.List r1 = r12.e
            r11.label = r2
            java.lang.Object r11 = r12.h(r1, r11)
            if (r11 != r0) goto L_0x0098
            return r0
        L_0x0098:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.viewmodel.TiciHistoryViewModel$loadTiciHistory$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TiciHistoryViewModel$loadTiciHistory$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
