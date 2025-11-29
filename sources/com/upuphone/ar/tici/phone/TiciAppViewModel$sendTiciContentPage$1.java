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
@DebugMetadata(c = "com.upuphone.ar.tici.phone.TiciAppViewModel$sendTiciContentPage$1", f = "TiciAppViewModel.kt", i = {1}, l = {423, 428}, m = "invokeSuspend", n = {"ticiEntity"}, s = {"L$0"})
final class TiciAppViewModel$sendTiciContentPage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $id;
    final /* synthetic */ int $targetIndex;
    final /* synthetic */ int $targetPage;
    Object L$0;
    int label;
    final /* synthetic */ TiciAppViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciAppViewModel$sendTiciContentPage$1(long j, int i, int i2, TiciAppViewModel ticiAppViewModel, Continuation<? super TiciAppViewModel$sendTiciContentPage$1> continuation) {
        super(2, continuation);
        this.$id = j;
        this.$targetPage = i;
        this.$targetIndex = i2;
        this.this$0 = ticiAppViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TiciAppViewModel$sendTiciContentPage$1(this.$id, this.$targetPage, this.$targetIndex, this.this$0, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0092  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            java.lang.String r2 = "TiciAppViewModel"
            r3 = 1
            r4 = 2
            r5 = 0
            if (r1 == 0) goto L_0x0025
            if (r1 == r3) goto L_0x0021
            if (r1 != r4) goto L_0x0019
            java.lang.Object r0 = r10.L$0
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r0 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r0
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0086
        L_0x0019:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0021:
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0063
        L_0x0025:
            kotlin.ResultKt.throwOnFailure(r11)
            long r6 = r10.$id
            int r11 = r10.$targetPage
            int r1 = r10.$targetIndex
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "sendTiciContentPage, id: "
            r8.append(r9)
            r8.append(r6)
            java.lang.String r6 = ", targetPage: "
            r8.append(r6)
            r8.append(r11)
            java.lang.String r11 = ", targetIndex: "
            r8.append(r11)
            r8.append(r1)
            java.lang.String r11 = r8.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.b(r11, r2)
            com.upuphone.ar.tici.phone.TiciApp r11 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.db.TiciDao r11 = r11.w()
            long r6 = r10.$id
            r10.label = r3
            java.lang.Object r11 = r11.q(r6, r10)
            if (r11 != r0) goto L_0x0063
            return r0
        L_0x0063:
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r11 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r11
            if (r11 != 0) goto L_0x006f
            java.lang.String r10 = "sendTiciContentPage, can`t find ticiEntity"
            com.upuphone.ar.tici.phone.utils.CommonExtKt.d(r10, r2, r5, r4, r5)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x006f:
            com.upuphone.ar.tici.phone.TiciApp r1 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.db.TiciDao r1 = r1.w()
            long r6 = r10.$id
            int r8 = r10.$targetPage
            r10.L$0 = r11
            r10.label = r4
            java.lang.Object r1 = r1.b(r6, r8, r10)
            if (r1 != r0) goto L_0x0084
            return r0
        L_0x0084:
            r0 = r11
            r11 = r1
        L_0x0086:
            com.upuphone.ar.tici.phone.db.entity.TiciContentPart r11 = (com.upuphone.ar.tici.phone.db.entity.TiciContentPart) r11
            if (r11 != 0) goto L_0x0092
            java.lang.String r10 = "sendTiciContentPage, can`t find contentPart"
            com.upuphone.ar.tici.phone.utils.CommonExtKt.d(r10, r2, r5, r4, r5)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x0092:
            com.upuphone.ar.tici.phone.TiciAppViewModel r1 = r10.this$0
            r1.H0(r0)
            com.upuphone.ar.tici.phone.TiciApp r1 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.starrynet.TiciStarryMsgManager r2 = r1.q()
            int r4 = r10.$targetPage
            int r10 = r10.$targetIndex
            java.lang.Integer r10 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r10)
            r2.sendTiciContentPage(r0, r11, r4, r10)
            com.upuphone.ar.tici.phone.starrynet.TiciStarryMsgManager r10 = r1.q()
            r0 = 0
            com.upuphone.ar.tici.phone.starrynet.TiciStarryMsgManager.startImpatientTiciCount$default(r10, r0, r3, r5)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.TiciAppViewModel$sendTiciContentPage$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TiciAppViewModel$sendTiciContentPage$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
