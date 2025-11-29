package com.upuphone.ar.tici.phone.viewmodel;

import com.upuphone.ar.tici.phone.data.TiciInfo;
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
@DebugMetadata(c = "com.upuphone.ar.tici.phone.viewmodel.TiciMainViewModel$highlightByProgress$1", f = "TiciMainViewModel.kt", i = {0, 1}, l = {214, 230}, m = "invokeSuspend", n = {"pageInfo", "pageInfo"}, s = {"L$0", "L$0"})
public final class TiciMainViewModel$highlightByProgress$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $needSendMsg;
    final /* synthetic */ int $progress;
    final /* synthetic */ TiciInfo $ticiInfo;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TiciMainViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciMainViewModel$highlightByProgress$1(int i, TiciInfo ticiInfo, TiciMainViewModel ticiMainViewModel, boolean z, Continuation<? super TiciMainViewModel$highlightByProgress$1> continuation) {
        super(2, continuation);
        this.$progress = i;
        this.$ticiInfo = ticiInfo;
        this.this$0 = ticiMainViewModel;
        this.$needSendMsg = z;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TiciMainViewModel$highlightByProgress$1 ticiMainViewModel$highlightByProgress$1 = new TiciMainViewModel$highlightByProgress$1(this.$progress, this.$ticiInfo, this.this$0, this.$needSendMsg, continuation);
        ticiMainViewModel$highlightByProgress$1.L$0 = obj;
        return ticiMainViewModel$highlightByProgress$1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x016f  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            r2 = 0
            r3 = 2
            r4 = 1
            java.lang.String r5 = "TiciMainViewModel"
            if (r1 == 0) goto L_0x002b
            if (r1 == r4) goto L_0x0022
            if (r1 != r3) goto L_0x001a
            java.lang.Object r0 = r12.L$0
            com.upuphone.ar.tici.phone.data.PageInfo r0 = (com.upuphone.ar.tici.phone.data.PageInfo) r0
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x011d
        L_0x001a:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0022:
            java.lang.Object r0 = r12.L$0
            com.upuphone.ar.tici.phone.data.PageInfo r0 = (com.upuphone.ar.tici.phone.data.PageInfo) r0
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00a8
        L_0x002b:
            kotlin.ResultKt.throwOnFailure(r13)
            java.lang.Object r13 = r12.L$0
            kotlinx.coroutines.CoroutineScope r13 = (kotlinx.coroutines.CoroutineScope) r13
            int r13 = r12.$progress
            com.upuphone.ar.tici.phone.data.TiciInfo r1 = r12.$ticiInfo
            int r1 = r1.getTotalParagraphSize()
            if (r13 < r1) goto L_0x0044
            java.lang.String r12 = "highlightByProgress, reach last"
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r12, r5)
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x0044:
            com.upuphone.ar.tici.phone.data.TiciInfo r13 = r12.$ticiInfo
            int r1 = r12.$progress
            com.upuphone.ar.tici.phone.data.PageInfo r13 = r13.findPageInfo(r1)
            if (r13 != 0) goto L_0x0056
            java.lang.String r12 = "highlightByProgress, can`t find pageInfo"
            com.upuphone.ar.tici.phone.utils.CommonExtKt.d(r12, r5, r2, r3, r2)
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x0056:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r6 = "highlightByProgress, pageInfo: "
            r1.append(r6)
            r1.append(r13)
            java.lang.String r1 = r1.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r1, r5)
            int r1 = r13.getPage()
            com.upuphone.ar.tici.phone.data.TiciInfo r6 = r12.$ticiInfo
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r6 = r6.getTiciEntity()
            int r6 = r6.getCurrentPage()
            if (r1 == r6) goto L_0x0101
            com.upuphone.ar.tici.phone.viewmodel.TiciMainViewModel r1 = r12.this$0
            androidx.lifecycle.MutableLiveData r1 = r1.k
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            r1.setValue(r6)
            com.upuphone.ar.tici.phone.TiciApp r1 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.db.TiciDao r6 = r1.w()
            int r7 = r13.getPage()
            int r8 = r13.getIndex()
            com.upuphone.ar.tici.phone.data.TiciInfo r1 = r12.$ticiInfo
            long r9 = com.upuphone.ar.tici.phone.data.TiciInfoKt.b(r1)
            r12.L$0 = r13
            r12.label = r4
            r11 = r12
            java.lang.Object r1 = r6.w(r7, r8, r9, r11)
            if (r1 != r0) goto L_0x00a7
            return r0
        L_0x00a7:
            r0 = r13
        L_0x00a8:
            java.lang.String r13 = "highlightByProgress, currentPage changed, reloadTiciContent"
            com.upuphone.ar.tici.phone.utils.CommonExtKt.d(r13, r5, r2, r3, r2)
            com.upuphone.ar.tici.phone.TiciApp r13 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.TiciAppViewModel r1 = r13.c()
            boolean r1 = r1.s0()
            com.upuphone.ar.tici.phone.viewmodel.TiciMainViewModel r2 = r12.this$0
            com.upuphone.ar.tici.phone.data.TiciInfo r3 = r12.$ticiInfo
            long r3 = com.upuphone.ar.tici.phone.data.TiciInfoKt.b(r3)
            java.lang.Long r3 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r3)
            int r4 = r0.getPage()
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            r7 = 12
            r8 = 0
            r5 = 0
            r6 = 0
            com.upuphone.ar.tici.phone.viewmodel.TiciMainViewModel.F(r2, r3, r4, r5, r6, r7, r8)
            if (r1 == 0) goto L_0x00fe
            boolean r1 = r13.n()
            if (r1 != 0) goto L_0x00fe
            com.upuphone.ar.tici.phone.TiciAppViewModel r2 = r13.c()
            com.upuphone.ar.tici.phone.data.TiciInfo r12 = r12.$ticiInfo
            long r3 = com.upuphone.ar.tici.phone.data.TiciInfoKt.b(r12)
            com.upuphone.ar.tici.phone.data.OpenTiciFrom r5 = com.upuphone.ar.tici.phone.data.OpenTiciFrom.TiciHomePage
            int r12 = r0.getPage()
            int r13 = r0.getIndex()
            java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r12)
            java.lang.Integer r9 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r13)
            r10 = 4
            r11 = 0
            r6 = 0
            r7 = 0
            com.upuphone.ar.tici.phone.TiciAppViewModel.N0(r2, r3, r5, r6, r7, r8, r9, r10, r11)
        L_0x00fe:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x0101:
            com.upuphone.ar.tici.phone.TiciApp r1 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.db.TiciDao r1 = r1.w()
            int r2 = r13.getIndex()
            com.upuphone.ar.tici.phone.data.TiciInfo r6 = r12.$ticiInfo
            long r6 = com.upuphone.ar.tici.phone.data.TiciInfoKt.b(r6)
            r12.L$0 = r13
            r12.label = r3
            java.lang.Object r1 = r1.x(r2, r6, r12)
            if (r1 != r0) goto L_0x011c
            return r0
        L_0x011c:
            r0 = r13
        L_0x011d:
            int r13 = r0.getIndex()
            com.upuphone.ar.tici.phone.data.TiciInfo r1 = r12.$ticiInfo
            long r1 = com.upuphone.ar.tici.phone.data.TiciInfoKt.b(r1)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r6 = "highlightByProgress, updateIndex, index: "
            r3.append(r6)
            r3.append(r13)
            java.lang.String r13 = ", id: "
            r3.append(r13)
            r3.append(r1)
            java.lang.String r13 = r3.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r13, r5)
            com.upuphone.ar.tici.phone.viewmodel.TiciMainViewModel r13 = r12.this$0
            androidx.lifecycle.MutableLiveData r13 = r13.e
            com.upuphone.ar.tici.phone.data.ParagraphProgress r1 = new com.upuphone.ar.tici.phone.data.ParagraphProgress
            int r2 = r12.$progress
            r1.<init>(r0, r2)
            r13.setValue(r1)
            com.upuphone.ar.tici.phone.viewmodel.TiciMainViewModel r13 = r12.this$0
            androidx.lifecycle.MutableLiveData r13 = r13.g
            com.upuphone.ar.tici.phone.viewmodel.TiciMainViewModel r1 = r12.this$0
            int r2 = r12.$progress
            int r2 = r2 + r4
            com.upuphone.ar.tici.phone.data.TiciInfo r3 = r12.$ticiInfo
            int r3 = r3.getTotalParagraphSize()
            java.lang.String r1 = r1.n(r2, r3)
            r13.postValue(r1)
            boolean r13 = r12.$needSendMsg
            if (r13 == 0) goto L_0x01a9
            com.upuphone.ar.tici.phone.TiciApp r13 = com.upuphone.ar.tici.phone.TiciApp.b
            boolean r1 = r13.l()
            if (r1 == 0) goto L_0x0196
            com.upuphone.ar.tici.phone.starrynet.TiciStarryMsgManager r13 = r13.q()
            com.upuphone.ar.tici.phone.starrynet.msg.HighlightMsgV3 r1 = new com.upuphone.ar.tici.phone.starrynet.msg.HighlightMsgV3
            com.upuphone.ar.tici.phone.data.TiciInfo r12 = r12.$ticiInfo
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r12 = r12.getTiciEntity()
            java.lang.String r12 = com.upuphone.ar.tici.phone.db.entity.TiciEntityKt.a(r12)
            int r2 = r0.getIndex()
            int r0 = r0.getPage()
            r1.<init>(r12, r2, r0)
            r13.sendHighlightMsg(r1)
            goto L_0x01a9
        L_0x0196:
            com.upuphone.ar.tici.phone.starrynet.TiciStarryMsgManager r13 = r13.q()
            int r0 = r12.$progress
            com.upuphone.ar.tici.phone.data.TiciInfo r12 = r12.$ticiInfo
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r12 = r12.getTiciEntity()
            java.lang.String r12 = com.upuphone.ar.tici.phone.db.entity.TiciEntityKt.a(r12)
            r13.sendHighlightMsg(r0, r12)
        L_0x01a9:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.viewmodel.TiciMainViewModel$highlightByProgress$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TiciMainViewModel$highlightByProgress$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
