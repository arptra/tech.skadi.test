package com.upuphone.ar.tici.phone.starrynet;

import com.upuphone.ar.tici.phone.starrynet.msg.SyncParagraphInfo;
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
@DebugMetadata(c = "com.upuphone.ar.tici.phone.starrynet.ReceiveMsgHandler$onSyncParagraphInfo$1", f = "ReceiveMsgHandler.kt", i = {0, 0, 1, 1}, l = {323, 332, 333}, m = "invokeSuspend", n = {"$this$launch", "id", "id", "currentPage"}, s = {"L$0", "J$0", "J$0", "I$0"})
public final class ReceiveMsgHandler$onSyncParagraphInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SyncParagraphInfo $paragraphInfo;
    int I$0;
    long J$0;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReceiveMsgHandler$onSyncParagraphInfo$1(SyncParagraphInfo syncParagraphInfo, Continuation<? super ReceiveMsgHandler$onSyncParagraphInfo$1> continuation) {
        super(2, continuation);
        this.$paragraphInfo = syncParagraphInfo;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ReceiveMsgHandler$onSyncParagraphInfo$1 receiveMsgHandler$onSyncParagraphInfo$1 = new ReceiveMsgHandler$onSyncParagraphInfo$1(this.$paragraphInfo, continuation);
        receiveMsgHandler$onSyncParagraphInfo$1.L$0 = obj;
        return receiveMsgHandler$onSyncParagraphInfo$1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b9 A[RETURN] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r14.label
            r2 = 3
            r3 = 1
            java.lang.String r4 = "ReceiveMsgHandler"
            r5 = 2
            if (r1 == 0) goto L_0x0035
            if (r1 == r3) goto L_0x002b
            if (r1 == r5) goto L_0x0020
            if (r1 != r2) goto L_0x0018
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00ba
        L_0x0018:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L_0x0020:
            int r1 = r14.I$0
            long r5 = r14.J$0
            kotlin.ResultKt.throwOnFailure(r15)
            r11 = r1
            r9 = r5
            goto L_0x00a4
        L_0x002b:
            long r6 = r14.J$0
            java.lang.Object r1 = r14.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0062
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r15)
            java.lang.Object r15 = r14.L$0
            kotlinx.coroutines.CoroutineScope r15 = (kotlinx.coroutines.CoroutineScope) r15
            com.upuphone.ar.tici.phone.starrynet.msg.SyncParagraphInfo r1 = r14.$paragraphInfo
            java.lang.String r1 = r1.getFileKey()
            java.lang.Long r1 = com.upuphone.ar.tici.phone.db.entity.TiciEntityKt.b(r1)
            if (r1 == 0) goto L_0x004d
            long r6 = r1.longValue()
            goto L_0x004f
        L_0x004d:
            r6 = 0
        L_0x004f:
            com.upuphone.ar.tici.phone.TiciApp r1 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.db.TiciDao r1 = r1.w()
            r14.L$0 = r15
            r14.J$0 = r6
            r14.label = r3
            java.lang.Object r15 = r1.q(r6, r14)
            if (r15 != r0) goto L_0x0062
            return r0
        L_0x0062:
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r15 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r15
            r1 = 0
            if (r15 == 0) goto L_0x00cb
            com.upuphone.ar.tici.phone.starrynet.msg.SyncParagraphInfo r3 = r14.$paragraphInfo
            java.lang.Integer r3 = r3.getCurrentPage()
            if (r3 == 0) goto L_0x0074
            int r3 = r3.intValue()
            goto L_0x007a
        L_0x0074:
            java.lang.String r3 = "onSyncParagraphInfo, fallback currentPage to 0"
            com.upuphone.ar.tici.phone.utils.CommonExtKt.d(r3, r4, r1, r5, r1)
            r3 = 0
        L_0x007a:
            java.util.List r8 = kotlin.collections.CollectionsKt.emptyList()
            r15.setParagraphIndexes(r8)
            com.upuphone.ar.tici.phone.starrynet.msg.SyncParagraphInfo r8 = r14.$paragraphInfo
            int r8 = r8.getHighlightIndex()
            r15.setIndex(r8)
            r15.setCurrentPage(r3)
            com.upuphone.ar.tici.phone.TiciApp r8 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.db.TiciDao r8 = r8.w()
            r14.L$0 = r1
            r14.J$0 = r6
            r14.I$0 = r3
            r14.label = r5
            java.lang.Object r15 = r8.n(r15, r14)
            if (r15 != r0) goto L_0x00a2
            return r0
        L_0x00a2:
            r11 = r3
            r9 = r6
        L_0x00a4:
            com.upuphone.ar.tici.phone.db.TiciDBHelper r8 = com.upuphone.ar.tici.phone.db.TiciDBHelper.f5925a
            com.upuphone.ar.tici.phone.starrynet.msg.SyncParagraphInfo r15 = r14.$paragraphInfo
            java.util.List r15 = r15.getParagraphIndexes()
            java.lang.String r12 = com.upuphone.ar.tici.phone.starrynet.msg.OpenTiciMsgReplyKt.c(r15)
            r14.label = r2
            r13 = r14
            java.lang.Object r15 = r8.f(r9, r11, r12, r13)
            if (r15 != r0) goto L_0x00ba
            return r0
        L_0x00ba:
            java.lang.String r15 = "onSyncParagraphInfo, update paragraphIndexes"
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r15, r4)
            com.upuphone.ar.tici.phone.TiciApp r15 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.TiciAppViewModel r15 = r15.c()
            com.upuphone.ar.tici.phone.starrynet.msg.SyncParagraphInfo r14 = r14.$paragraphInfo
            r15.R0(r14)
            goto L_0x00d0
        L_0x00cb:
            java.lang.String r14 = "onSyncParagraphInfo, 返回数据有问题"
            com.upuphone.ar.tici.phone.utils.CommonExtKt.d(r14, r4, r1, r5, r1)
        L_0x00d0:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.starrynet.ReceiveMsgHandler$onSyncParagraphInfo$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ReceiveMsgHandler$onSyncParagraphInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
