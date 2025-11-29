package com.upuphone.ar.tici.phone.starrynet;

import com.upuphone.ar.tici.phone.starrynet.msg.OpenTiciMsgReplyV3;
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

@SourceDebugExtension({"SMAP\nReceiveMsgHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReceiveMsgHandler.kt\ncom/upuphone/ar/tici/phone/starrynet/ReceiveMsgHandler$handleOpenResultV3$1\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n*L\n1#1,365:1\n120#2,10:366\n*S KotlinDebug\n*F\n+ 1 ReceiveMsgHandler.kt\ncom/upuphone/ar/tici/phone/starrynet/ReceiveMsgHandler$handleOpenResultV3$1\n*L\n196#1:366,10\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.starrynet.ReceiveMsgHandler$handleOpenResultV3$1", f = "ReceiveMsgHandler.kt", i = {0, 1, 1, 2, 2, 2, 3, 3}, l = {371, 198, 210, 211}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "id", "$this$withLock_u24default$iv", "entity", "id", "$this$withLock_u24default$iv", "entity"}, s = {"L$0", "L$0", "J$0", "L$0", "L$3", "J$0", "L$0", "L$3"})
public final class ReceiveMsgHandler$handleOpenResultV3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TiciStarryMsgManager $msgManager;
    final /* synthetic */ OpenTiciMsgReplyV3 $reply;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ ReceiveMsgHandler this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReceiveMsgHandler$handleOpenResultV3$1(ReceiveMsgHandler receiveMsgHandler, OpenTiciMsgReplyV3 openTiciMsgReplyV3, TiciStarryMsgManager ticiStarryMsgManager, Continuation<? super ReceiveMsgHandler$handleOpenResultV3$1> continuation) {
        super(2, continuation);
        this.this$0 = receiveMsgHandler;
        this.$reply = openTiciMsgReplyV3;
        this.$msgManager = ticiStarryMsgManager;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ReceiveMsgHandler$handleOpenResultV3$1(this.this$0, this.$reply, this.$msgManager, continuation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v15, resolved type: kotlinx.coroutines.sync.Mutex} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d3 A[Catch:{ all -> 0x0055 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x013c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0152  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r19) {
        /*
            r18 = this;
            r0 = r18
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            java.lang.String r8 = "ReceiveMsgHandler"
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            r9 = 0
            if (r1 == 0) goto L_0x0086
            if (r1 == r5) goto L_0x0076
            if (r1 == r4) goto L_0x0059
            if (r1 == r3) goto L_0x003a
            if (r1 != r2) goto L_0x0032
            java.lang.Object r1 = r0.L$3
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r1 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r1
            java.lang.Object r2 = r0.L$2
            com.upuphone.ar.tici.phone.starrynet.TiciStarryMsgManager r2 = (com.upuphone.ar.tici.phone.starrynet.TiciStarryMsgManager) r2
            java.lang.Object r3 = r0.L$1
            com.upuphone.ar.tici.phone.starrynet.msg.OpenTiciMsgReplyV3 r3 = (com.upuphone.ar.tici.phone.starrynet.msg.OpenTiciMsgReplyV3) r3
            java.lang.Object r0 = r0.L$0
            r4 = r0
            kotlinx.coroutines.sync.Mutex r4 = (kotlinx.coroutines.sync.Mutex) r4
            kotlin.ResultKt.throwOnFailure(r19)     // Catch:{ all -> 0x002f }
            goto L_0x0141
        L_0x002f:
            r0 = move-exception
            goto L_0x0170
        L_0x0032:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x003a:
            long r3 = r0.J$0
            java.lang.Object r1 = r0.L$3
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r1 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r1
            java.lang.Object r5 = r0.L$2
            com.upuphone.ar.tici.phone.starrynet.TiciStarryMsgManager r5 = (com.upuphone.ar.tici.phone.starrynet.TiciStarryMsgManager) r5
            java.lang.Object r6 = r0.L$1
            com.upuphone.ar.tici.phone.starrynet.msg.OpenTiciMsgReplyV3 r6 = (com.upuphone.ar.tici.phone.starrynet.msg.OpenTiciMsgReplyV3) r6
            java.lang.Object r10 = r0.L$0
            kotlinx.coroutines.sync.Mutex r10 = (kotlinx.coroutines.sync.Mutex) r10
            kotlin.ResultKt.throwOnFailure(r19)     // Catch:{ all -> 0x0055 }
            r13 = r1
            r11 = r6
            r12 = r10
            r10 = r5
            goto L_0x0119
        L_0x0055:
            r0 = move-exception
            r4 = r10
            goto L_0x0170
        L_0x0059:
            long r10 = r0.J$0
            java.lang.Object r1 = r0.L$2
            com.upuphone.ar.tici.phone.starrynet.TiciStarryMsgManager r1 = (com.upuphone.ar.tici.phone.starrynet.TiciStarryMsgManager) r1
            java.lang.Object r6 = r0.L$1
            com.upuphone.ar.tici.phone.starrynet.msg.OpenTiciMsgReplyV3 r6 = (com.upuphone.ar.tici.phone.starrynet.msg.OpenTiciMsgReplyV3) r6
            java.lang.Object r12 = r0.L$0
            kotlinx.coroutines.sync.Mutex r12 = (kotlinx.coroutines.sync.Mutex) r12
            kotlin.ResultKt.throwOnFailure(r19)     // Catch:{ all -> 0x0072 }
            r13 = r19
            r16 = r10
            r10 = r12
            r11 = r16
            goto L_0x00cf
        L_0x0072:
            r0 = move-exception
            r4 = r12
            goto L_0x0170
        L_0x0076:
            java.lang.Object r1 = r0.L$2
            com.upuphone.ar.tici.phone.starrynet.TiciStarryMsgManager r1 = (com.upuphone.ar.tici.phone.starrynet.TiciStarryMsgManager) r1
            java.lang.Object r6 = r0.L$1
            com.upuphone.ar.tici.phone.starrynet.msg.OpenTiciMsgReplyV3 r6 = (com.upuphone.ar.tici.phone.starrynet.msg.OpenTiciMsgReplyV3) r6
            java.lang.Object r10 = r0.L$0
            kotlinx.coroutines.sync.Mutex r10 = (kotlinx.coroutines.sync.Mutex) r10
            kotlin.ResultKt.throwOnFailure(r19)
            goto L_0x00a7
        L_0x0086:
            kotlin.ResultKt.throwOnFailure(r19)
            com.upuphone.ar.tici.phone.starrynet.ReceiveMsgHandler r1 = r0.this$0
            kotlinx.coroutines.sync.Mutex r1 = r1.c
            com.upuphone.ar.tici.phone.starrynet.msg.OpenTiciMsgReplyV3 r6 = r0.$reply
            com.upuphone.ar.tici.phone.starrynet.TiciStarryMsgManager r10 = r0.$msgManager
            r0.L$0 = r1
            r0.L$1 = r6
            r0.L$2 = r10
            r0.label = r5
            java.lang.Object r11 = r1.c(r9, r0)
            if (r11 != r7) goto L_0x00a2
            return r7
        L_0x00a2:
            r16 = r10
            r10 = r1
            r1 = r16
        L_0x00a7:
            java.lang.String r11 = r6.getFileKey()     // Catch:{ all -> 0x0055 }
            java.lang.Long r11 = com.upuphone.ar.tici.phone.db.entity.TiciEntityKt.b(r11)     // Catch:{ all -> 0x0055 }
            if (r11 == 0) goto L_0x00b6
            long r11 = r11.longValue()     // Catch:{ all -> 0x0055 }
            goto L_0x00b8
        L_0x00b6:
            r11 = 0
        L_0x00b8:
            com.upuphone.ar.tici.phone.TiciApp r13 = com.upuphone.ar.tici.phone.TiciApp.b     // Catch:{ all -> 0x0055 }
            com.upuphone.ar.tici.phone.db.TiciDao r13 = r13.w()     // Catch:{ all -> 0x0055 }
            r0.L$0 = r10     // Catch:{ all -> 0x0055 }
            r0.L$1 = r6     // Catch:{ all -> 0x0055 }
            r0.L$2 = r1     // Catch:{ all -> 0x0055 }
            r0.J$0 = r11     // Catch:{ all -> 0x0055 }
            r0.label = r4     // Catch:{ all -> 0x0055 }
            java.lang.Object r13 = r13.q(r11, r0)     // Catch:{ all -> 0x0055 }
            if (r13 != r7) goto L_0x00cf
            return r7
        L_0x00cf:
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r13 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r13     // Catch:{ all -> 0x0055 }
            if (r13 == 0) goto L_0x0152
            long r14 = r13.getId()     // Catch:{ all -> 0x0055 }
            com.upuphone.ar.tici.phone.utils.SpUtilKt.o(r14)     // Catch:{ all -> 0x0055 }
            long r14 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0055 }
            r13.setLastShowTime(r14)     // Catch:{ all -> 0x0055 }
            r13.setLastModified(r14)     // Catch:{ all -> 0x0055 }
            java.util.List r4 = kotlin.collections.CollectionsKt.emptyList()     // Catch:{ all -> 0x0055 }
            r13.setParagraphIndexes(r4)     // Catch:{ all -> 0x0055 }
            r13.setFileStatus(r5)     // Catch:{ all -> 0x0055 }
            int r4 = r6.getCurrentPage()     // Catch:{ all -> 0x0055 }
            r13.setCurrentPage(r4)     // Catch:{ all -> 0x0055 }
            int r4 = r6.getHighlightIndex()     // Catch:{ all -> 0x0055 }
            r13.setIndex(r4)     // Catch:{ all -> 0x0055 }
            com.upuphone.ar.tici.phone.TiciApp r4 = com.upuphone.ar.tici.phone.TiciApp.b     // Catch:{ all -> 0x0055 }
            com.upuphone.ar.tici.phone.db.TiciDao r4 = r4.w()     // Catch:{ all -> 0x0055 }
            r0.L$0 = r10     // Catch:{ all -> 0x0055 }
            r0.L$1 = r6     // Catch:{ all -> 0x0055 }
            r0.L$2 = r1     // Catch:{ all -> 0x0055 }
            r0.L$3 = r13     // Catch:{ all -> 0x0055 }
            r0.J$0 = r11     // Catch:{ all -> 0x0055 }
            r0.label = r3     // Catch:{ all -> 0x0055 }
            java.lang.Object r3 = r4.n(r13, r0)     // Catch:{ all -> 0x0055 }
            if (r3 != r7) goto L_0x0115
            return r7
        L_0x0115:
            r3 = r11
            r11 = r6
            r12 = r10
            r10 = r1
        L_0x0119:
            com.upuphone.ar.tici.phone.db.TiciDBHelper r1 = com.upuphone.ar.tici.phone.db.TiciDBHelper.f5925a     // Catch:{ all -> 0x0072 }
            int r5 = r11.getCurrentPage()     // Catch:{ all -> 0x0072 }
            java.util.List r6 = r11.getParagraphIndexes()     // Catch:{ all -> 0x0072 }
            java.lang.String r6 = com.upuphone.ar.tici.phone.starrynet.msg.OpenTiciMsgReplyKt.c(r6)     // Catch:{ all -> 0x0072 }
            r0.L$0 = r12     // Catch:{ all -> 0x0072 }
            r0.L$1 = r11     // Catch:{ all -> 0x0072 }
            r0.L$2 = r10     // Catch:{ all -> 0x0072 }
            r0.L$3 = r13     // Catch:{ all -> 0x0072 }
            r0.label = r2     // Catch:{ all -> 0x0072 }
            r2 = r3
            r4 = r5
            r5 = r6
            r6 = r18
            java.lang.Object r0 = r1.f(r2, r4, r5, r6)     // Catch:{ all -> 0x0072 }
            if (r0 != r7) goto L_0x013d
            return r7
        L_0x013d:
            r2 = r10
            r3 = r11
            r4 = r12
            r1 = r13
        L_0x0141:
            com.upuphone.ar.tici.phone.TiciApp r0 = com.upuphone.ar.tici.phone.TiciApp.b     // Catch:{ all -> 0x002f }
            com.upuphone.ar.tici.phone.TiciAppViewModel r0 = r0.c()     // Catch:{ all -> 0x002f }
            r0.I0(r1)     // Catch:{ all -> 0x002f }
            java.lang.String r0 = "handleOpenResultV3, update db"
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r0, r8)     // Catch:{ all -> 0x002f }
            r1 = r2
            r6 = r3
            goto L_0x0158
        L_0x0152:
            java.lang.String r0 = "handleOpenResultV3, wrong reply"
            com.upuphone.ar.tici.phone.utils.CommonExtKt.d(r0, r8, r9, r4, r9)     // Catch:{ all -> 0x0055 }
            r4 = r10
        L_0x0158:
            com.upuphone.ar.tici.phone.TiciApp r0 = com.upuphone.ar.tici.phone.TiciApp.b     // Catch:{ all -> 0x002f }
            com.upuphone.ar.tici.phone.TiciAppViewModel r0 = r0.c()     // Catch:{ all -> 0x002f }
            r0.l0(r6)     // Catch:{ all -> 0x002f }
            java.lang.String r0 = r6.getMsgId()     // Catch:{ all -> 0x002f }
            r1.handleOpenResult$ar_tici_release(r0)     // Catch:{ all -> 0x002f }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x002f }
            r4.d(r9)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0170:
            r4.d(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.starrynet.ReceiveMsgHandler$handleOpenResultV3$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ReceiveMsgHandler$handleOpenResultV3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
