package com.upuphone.ar.tici.phone;

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
@DebugMetadata(c = "com.upuphone.ar.tici.phone.TiciAppViewModel$restoreDefaultTiciContent$1", f = "TiciAppViewModel.kt", i = {0, 1, 2, 3}, l = {468, 473, 476, 478, 482}, m = "invokeSuspend", n = {"userId", "userId", "userId", "ticiEntity"}, s = {"L$0", "L$0", "L$0", "L$0"})
public final class TiciAppViewModel$restoreDefaultTiciContent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ TiciAppViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciAppViewModel$restoreDefaultTiciContent$1(TiciAppViewModel ticiAppViewModel, Continuation<? super TiciAppViewModel$restoreDefaultTiciContent$1> continuation) {
        super(2, continuation);
        this.this$0 = ticiAppViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TiciAppViewModel$restoreDefaultTiciContent$1(this.this$0, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00b2 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c5 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00e2 A[RETURN] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r22) {
        /*
            r21 = this;
            r0 = r21
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 5
            r4 = 4
            r5 = 3
            r6 = 1
            r7 = 0
            java.lang.String r8 = "TiciAppViewModel"
            r9 = 2
            if (r2 == 0) goto L_0x0052
            if (r2 == r6) goto L_0x0047
            if (r2 == r9) goto L_0x003e
            if (r2 == r5) goto L_0x0033
            if (r2 == r4) goto L_0x0029
            if (r2 != r3) goto L_0x0021
            kotlin.ResultKt.throwOnFailure(r22)
            goto L_0x0115
        L_0x0021:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0029:
            java.lang.Object r2 = r0.L$0
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r2 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r2
            kotlin.ResultKt.throwOnFailure(r22)
        L_0x0030:
            r11 = r2
            goto L_0x00e3
        L_0x0033:
            java.lang.Object r2 = r0.L$0
            java.lang.String r2 = (java.lang.String) r2
            kotlin.ResultKt.throwOnFailure(r22)
            r5 = r22
            goto L_0x00c6
        L_0x003e:
            java.lang.Object r2 = r0.L$0
            java.lang.String r2 = (java.lang.String) r2
            kotlin.ResultKt.throwOnFailure(r22)
            goto L_0x00b9
        L_0x0047:
            java.lang.Object r2 = r0.L$0
            java.lang.String r2 = (java.lang.String) r2
            kotlin.ResultKt.throwOnFailure(r22)
            r10 = r2
            r2 = r22
            goto L_0x0090
        L_0x0052:
            kotlin.ResultKt.throwOnFailure(r22)
            java.lang.String r2 = "restoreDefaultTiciContent, start"
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r2, r8)
            com.upuphone.ar.tici.phone.TiciAppViewModel r2 = r0.this$0
            androidx.lifecycle.MutableLiveData r2 = r2.n
            java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            r2.setValue(r10)
            com.upuphone.ar.tici.phone.utils.SpUtilKt.a()
            com.upuphone.ar.tici.phone.TiciApp r2 = com.upuphone.ar.tici.phone.TiciApp.b
            java.lang.String r10 = r2.g()
            if (r10 == 0) goto L_0x00b3
            int r11 = r10.length()
            if (r11 != 0) goto L_0x0079
            goto L_0x00b3
        L_0x0079:
            com.upuphone.ar.tici.phone.db.TiciDao r2 = r2.w()
            kotlin.ranges.IntRange r11 = com.upuphone.ar.tici.phone.utils.ConstantsKt.i()
            java.util.List r11 = kotlin.collections.CollectionsKt.toList(r11)
            r0.L$0 = r10
            r0.label = r6
            java.lang.Object r2 = r2.m(r10, r11, r0)
            if (r2 != r1) goto L_0x0090
            return r1
        L_0x0090:
            java.util.List r2 = (java.util.List) r2
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r11 = "restoreDefaultTiciContent, defaultTiciId: "
            r6.append(r11)
            r6.append(r2)
            java.lang.String r6 = r6.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r6, r8)
            com.upuphone.ar.tici.phone.db.TiciDBHelper r6 = com.upuphone.ar.tici.phone.db.TiciDBHelper.f5925a
            r0.L$0 = r10
            r0.label = r9
            java.lang.Object r2 = r6.c(r2, r0)
            if (r2 != r1) goto L_0x00b8
            return r1
        L_0x00b3:
            java.lang.String r2 = "restoreDefaultTiciContent, userId is null"
            com.upuphone.ar.tici.phone.utils.CommonExtKt.d(r2, r8, r7, r9, r7)
        L_0x00b8:
            r2 = r10
        L_0x00b9:
            com.upuphone.ar.tici.phone.utils.TiciHelper r6 = com.upuphone.ar.tici.phone.utils.TiciHelper.f6002a
            r0.L$0 = r2
            r0.label = r5
            java.lang.Object r5 = r6.d(r0)
            if (r5 != r1) goto L_0x00c6
            return r1
        L_0x00c6:
            com.upuphone.ar.tici.phone.data.DefaultTiciContent r5 = (com.upuphone.ar.tici.phone.data.DefaultTiciContent) r5
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r2 = com.upuphone.ar.tici.phone.data.DefaultTiciContentKt.a(r5, r2)
            com.upuphone.ar.tici.phone.db.TiciDBHelper r6 = com.upuphone.ar.tici.phone.db.TiciDBHelper.f5925a
            java.lang.String r5 = r5.getContent()
            com.upuphone.ar.tici.phone.TiciAppViewModel r10 = r0.this$0
            boolean r10 = r10.V()
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r4 = r6.e(r2, r5, r10, r0)
            if (r4 != r1) goto L_0x0030
            return r1
        L_0x00e3:
            com.upuphone.ar.tici.phone.TiciAppViewModel r2 = r0.this$0
            boolean r2 = r2.s0()
            if (r2 != 0) goto L_0x011d
            com.upuphone.ar.tici.phone.TiciApp r2 = com.upuphone.ar.tici.phone.TiciApp.b
            android.content.Context r2 = r2.a()
            int r4 = com.upuphone.ar.tici.R.string.tici_reset_tici_file_success
            r5 = 0
            com.upuphone.ar.tici.phone.utils.CommonExtKt.j(r2, r4, r5, r9, r7)
            com.upuphone.ar.tici.phone.TiciAppViewModel r2 = r0.this$0
            androidx.lifecycle.MutableLiveData r2 = r2.n
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            r2.setValue(r4)
            com.upuphone.ar.tici.phone.TiciAppViewModel r2 = r0.this$0
            kotlinx.coroutines.flow.MutableSharedFlow r2 = r2.p
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r0 = r2.emit(r11, r0)
            if (r0 != r1) goto L_0x0115
            return r1
        L_0x0115:
            java.lang.String r0 = "restoreDefaultTiciContent, succeed"
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r0, r8)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x011d:
            com.upuphone.ar.tici.phone.TiciAppViewModel r10 = r0.this$0
            com.upuphone.ar.tici.phone.data.OpenTiciFrom r12 = com.upuphone.ar.tici.phone.data.OpenTiciFrom.ResetToDefaultTici
            r19 = 116(0x74, float:1.63E-43)
            r20 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            com.upuphone.ar.tici.phone.TiciAppViewModel.O0(r10, r11, r12, r13, r14, r15, r16, r17, r19, r20)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.TiciAppViewModel$restoreDefaultTiciContent$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TiciAppViewModel$restoreDefaultTiciContent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
