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
@DebugMetadata(c = "com.upuphone.ar.tici.phone.viewmodel.TiciMainViewModel$loadLastTiciContent$1", f = "TiciMainViewModel.kt", i = {0, 1, 2, 2, 2, 3, 3}, l = {104, 105, 113, 123}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "$this$launch", "ticiEntity", "newPage", "$this$launch", "ticiEntity"}, s = {"L$0", "L$0", "L$0", "L$1", "I$0", "L$0", "L$1"})
public final class TiciMainViewModel$loadLastTiciContent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $restartIfReachLast;
    final /* synthetic */ boolean $showLoading;
    final /* synthetic */ Long $targetId;
    final /* synthetic */ Integer $targetPage;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ TiciMainViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciMainViewModel$loadLastTiciContent$1(Long l, Integer num, boolean z, boolean z2, TiciMainViewModel ticiMainViewModel, Continuation<? super TiciMainViewModel$loadLastTiciContent$1> continuation) {
        super(2, continuation);
        this.$targetId = l;
        this.$targetPage = num;
        this.$restartIfReachLast = z;
        this.$showLoading = z2;
        this.this$0 = ticiMainViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TiciMainViewModel$loadLastTiciContent$1 ticiMainViewModel$loadLastTiciContent$1 = new TiciMainViewModel$loadLastTiciContent$1(this.$targetId, this.$targetPage, this.$restartIfReachLast, this.$showLoading, this.this$0, continuation);
        ticiMainViewModel$loadLastTiciContent$1.L$0 = obj;
        return ticiMainViewModel$loadLastTiciContent$1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00af, code lost:
        if (r15 == null) goto L_0x00b4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0166 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0176  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r14.label
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            java.lang.String r6 = "TiciMainViewModel"
            if (r1 == 0) goto L_0x004b
            if (r1 == r5) goto L_0x0043
            if (r1 == r4) goto L_0x003a
            if (r1 == r3) goto L_0x002b
            if (r1 != r2) goto L_0x0023
            java.lang.Object r0 = r14.L$1
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r0 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r0
            java.lang.Object r1 = r14.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0169
        L_0x0023:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L_0x002b:
            int r1 = r14.I$0
            java.lang.Object r3 = r14.L$1
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r3 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r3
            java.lang.Object r7 = r14.L$0
            kotlinx.coroutines.CoroutineScope r7 = (kotlinx.coroutines.CoroutineScope) r7
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x011d
        L_0x003a:
            java.lang.Object r1 = r14.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00c1
        L_0x0043:
            java.lang.Object r1 = r14.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00ad
        L_0x004b:
            kotlin.ResultKt.throwOnFailure(r15)
            java.lang.Object r15 = r14.L$0
            r1 = r15
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            java.lang.Long r15 = r14.$targetId
            java.lang.Integer r7 = r14.$targetPage
            boolean r8 = r14.$restartIfReachLast
            boolean r9 = r14.$showLoading
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "loadLastTiciContent, targetId: "
            r10.append(r11)
            r10.append(r15)
            java.lang.String r15 = ", targetPage: "
            r10.append(r15)
            r10.append(r7)
            java.lang.String r15 = ", restartIfReachLast: "
            r10.append(r15)
            r10.append(r8)
            java.lang.String r15 = ", showLoading: "
            r10.append(r15)
            r10.append(r9)
            java.lang.String r15 = r10.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r15, r6)
            com.upuphone.ar.tici.phone.viewmodel.TiciMainViewModel r15 = r14.this$0
            androidx.lifecycle.MutableLiveData r15 = r15.k
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            r15.setValue(r7)
            java.lang.Long r15 = r14.$targetId
            if (r15 == 0) goto L_0x00b4
            com.upuphone.ar.tici.phone.TiciApp r7 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.db.TiciDao r7 = r7.w()
            long r8 = r15.longValue()
            r14.L$0 = r1
            r14.label = r5
            java.lang.Object r15 = r7.q(r8, r14)
            if (r15 != r0) goto L_0x00ad
            return r0
        L_0x00ad:
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r15 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r15
            if (r15 != 0) goto L_0x00b2
            goto L_0x00b4
        L_0x00b2:
            r7 = r1
            goto L_0x00c4
        L_0x00b4:
            com.upuphone.ar.tici.phone.utils.TiciHelper r15 = com.upuphone.ar.tici.phone.utils.TiciHelper.f6002a
            r14.L$0 = r1
            r14.label = r4
            java.lang.Object r15 = r15.e(r14)
            if (r15 != r0) goto L_0x00c1
            return r0
        L_0x00c1:
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r15 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r15
            goto L_0x00b2
        L_0x00c4:
            java.lang.String r1 = r15.toSimpleString()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "loadLastTiciContent, ticiEntity: "
            r8.append(r9)
            r8.append(r1)
            java.lang.String r1 = r8.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r1, r6)
            java.lang.Integer r1 = r14.$targetPage
            if (r1 == 0) goto L_0x00e5
            int r1 = r1.intValue()
            goto L_0x00e9
        L_0x00e5:
            int r1 = r15.getCurrentPage()
        L_0x00e9:
            boolean r8 = r14.$showLoading
            if (r8 == 0) goto L_0x0154
            int r8 = r15.getTotalPage()
            r9 = 40
            if (r8 < r9) goto L_0x0101
            com.upuphone.ar.tici.phone.viewmodel.TiciMainViewModel r3 = r14.this$0
            androidx.lifecycle.MutableLiveData r3 = r3.c
            com.upuphone.ar.tici.phone.data.TiciInfoState$Loading r8 = com.upuphone.ar.tici.phone.data.TiciInfoState.Loading.f5923a
            r3.setValue(r8)
            goto L_0x0154
        L_0x0101:
            com.upuphone.ar.tici.phone.TiciApp r8 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.db.TiciDao r8 = r8.w()
            long r9 = r15.getId()
            r14.L$0 = r7
            r14.L$1 = r15
            r14.I$0 = r1
            r14.label = r3
            java.lang.Object r3 = r8.l(r9, r1, r14)
            if (r3 != r0) goto L_0x011a
            return r0
        L_0x011a:
            r13 = r3
            r3 = r15
            r15 = r13
        L_0x011d:
            java.lang.Long r15 = (java.lang.Long) r15
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "loadLastTiciContent, newPage: "
            r8.append(r9)
            r8.append(r1)
            java.lang.String r9 = ", partSize: "
            r8.append(r9)
            r8.append(r15)
            java.lang.String r8 = r8.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r8, r6)
            if (r15 == 0) goto L_0x0153
            com.upuphone.ar.tici.phone.viewmodel.TiciMainViewModel r8 = r14.this$0
            long r9 = r15.longValue()
            r11 = 71680(0x11800, double:3.54146E-319)
            int r15 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r15 < 0) goto L_0x0153
            androidx.lifecycle.MutableLiveData r15 = r8.c
            com.upuphone.ar.tici.phone.data.TiciInfoState$Loading r8 = com.upuphone.ar.tici.phone.data.TiciInfoState.Loading.f5923a
            r15.setValue(r8)
        L_0x0153:
            r15 = r3
        L_0x0154:
            com.upuphone.ar.tici.phone.db.TiciDBHelper r3 = com.upuphone.ar.tici.phone.db.TiciDBHelper.f5925a
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            r14.L$0 = r7
            r14.L$1 = r15
            r14.label = r2
            java.lang.Object r1 = r3.d(r15, r1, r14)
            if (r1 != r0) goto L_0x0167
            return r0
        L_0x0167:
            r0 = r15
            r15 = r1
        L_0x0169:
            com.upuphone.ar.tici.phone.data.TiciInfo r15 = (com.upuphone.ar.tici.phone.data.TiciInfo) r15
            r1 = 0
            if (r15 != 0) goto L_0x0176
            java.lang.String r14 = "loadLastTiciContent, can`t find ticiInfo"
            com.upuphone.ar.tici.phone.utils.CommonExtKt.d(r14, r6, r1, r4, r1)
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        L_0x0176:
            java.lang.String r2 = r15.toSimpleString()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "loadLastTiciContent, ticiInfo: "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r2, r6)
            com.upuphone.ar.tici.phone.viewmodel.TiciMainViewModel r2 = r14.this$0
            androidx.lifecycle.MutableLiveData r2 = r2.c
            com.upuphone.ar.tici.phone.data.TiciInfoState$Success r3 = new com.upuphone.ar.tici.phone.data.TiciInfoState$Success
            r3.<init>(r15)
            r2.setValue(r3)
            com.upuphone.ar.tici.phone.viewmodel.TiciMainViewModel r2 = r14.this$0
            androidx.lifecycle.MutableLiveData r2 = r2.k
            r3 = 0
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            r2.setValue(r4)
            com.upuphone.ar.tici.phone.TiciApp r2 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.TiciAppViewModel r4 = r2.c()
            boolean r4 = r4.s0()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "loadLastTiciContent, isGlassTiciRunning: "
            r7.append(r8)
            r7.append(r4)
            java.lang.String r7 = r7.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r7, r6)
            int r7 = r0.getCurrentPage()
            int r8 = r0.getIndex()
            int r7 = r15.computeProgress(r7, r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "loadLastTiciContent, progress: "
            r8.append(r9)
            r8.append(r7)
            java.lang.String r8 = r8.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r8, r6)
            boolean r8 = r14.$restartIfReachLast
            if (r8 == 0) goto L_0x01ff
            boolean r15 = r15.isReachLast(r7)
            if (r15 == 0) goto L_0x01ff
            if (r4 != 0) goto L_0x01ff
            java.lang.String r15 = "loadLastTiciContent, isReachLast, highlightParagraph: 0"
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r15, r6)
            com.upuphone.ar.tici.phone.viewmodel.TiciMainViewModel r15 = r14.this$0
            r15.x(r3, r3, r5)
            goto L_0x0223
        L_0x01ff:
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r3 = "loadLastTiciContent, highlightParagraph: "
            r15.append(r3)
            r15.append(r7)
            java.lang.String r15 = r15.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r15, r6)
            com.upuphone.ar.tici.phone.viewmodel.TiciMainViewModel r7 = r14.this$0
            int r8 = r0.getCurrentPage()
            int r9 = r0.getIndex()
            r11 = 4
            r12 = 0
            r10 = 0
            com.upuphone.ar.tici.phone.viewmodel.TiciMainViewModel.y(r7, r8, r9, r10, r11, r12)
        L_0x0223:
            boolean r15 = r2.j()
            if (r15 == 0) goto L_0x0231
            com.upuphone.ar.tici.phone.viewmodel.TiciMainViewModel r14 = r14.this$0
            r2 = 0
            com.upuphone.ar.tici.phone.viewmodel.TiciMainViewModel.m(r14, r2, r5, r1)
            goto L_0x0238
        L_0x0231:
            com.upuphone.ar.tici.phone.TiciAppViewModel r14 = r2.c()
            r14.P0()
        L_0x0238:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.viewmodel.TiciMainViewModel$loadLastTiciContent$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TiciMainViewModel$loadLastTiciContent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
