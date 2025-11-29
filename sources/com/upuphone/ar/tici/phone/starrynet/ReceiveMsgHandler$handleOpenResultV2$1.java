package com.upuphone.ar.tici.phone.starrynet;

import com.upuphone.ar.tici.phone.starrynet.msg.OpenTiciMsgReplyV2;
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

@SourceDebugExtension({"SMAP\nReceiveMsgHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReceiveMsgHandler.kt\ncom/upuphone/ar/tici/phone/starrynet/ReceiveMsgHandler$handleOpenResultV2$1\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n*L\n1#1,365:1\n120#2,10:366\n*S KotlinDebug\n*F\n+ 1 ReceiveMsgHandler.kt\ncom/upuphone/ar/tici/phone/starrynet/ReceiveMsgHandler$handleOpenResultV2$1\n*L\n149#1:366,10\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.starrynet.ReceiveMsgHandler$handleOpenResultV2$1", f = "ReceiveMsgHandler.kt", i = {0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3}, l = {371, 156, 171, 172}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "currentIndex", "currentPage", "id", "$this$withLock_u24default$iv", "entity", "currentPage", "id", "$this$withLock_u24default$iv", "entity"}, s = {"L$0", "L$0", "L$3", "I$0", "J$0", "L$0", "L$3", "I$0", "J$0", "L$0", "L$3"})
public final class ReceiveMsgHandler$handleOpenResultV2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TiciStarryMsgManager $msgManager;
    final /* synthetic */ OpenTiciMsgReplyV2 $reply;
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ ReceiveMsgHandler this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReceiveMsgHandler$handleOpenResultV2$1(ReceiveMsgHandler receiveMsgHandler, TiciStarryMsgManager ticiStarryMsgManager, OpenTiciMsgReplyV2 openTiciMsgReplyV2, Continuation<? super ReceiveMsgHandler$handleOpenResultV2$1> continuation) {
        super(2, continuation);
        this.this$0 = receiveMsgHandler;
        this.$msgManager = ticiStarryMsgManager;
        this.$reply = openTiciMsgReplyV2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ReceiveMsgHandler$handleOpenResultV2$1(this.this$0, this.$msgManager, this.$reply, continuation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v13, resolved type: kotlinx.coroutines.sync.Mutex} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0123 A[Catch:{ all -> 0x0082 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0183 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0199  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r22) {
        /*
            r21 = this;
            r0 = r21
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 4
            r3 = 3
            java.lang.String r8 = "ReceiveMsgHandler"
            r4 = 2
            r5 = 1
            r9 = 0
            if (r1 == 0) goto L_0x0099
            if (r1 == r5) goto L_0x0086
            if (r1 == r4) goto L_0x005d
            if (r1 == r3) goto L_0x003a
            if (r1 != r2) goto L_0x0032
            java.lang.Object r1 = r0.L$3
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r1 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r1
            java.lang.Object r2 = r0.L$2
            com.upuphone.ar.tici.phone.starrynet.msg.OpenTiciMsgReplyV2 r2 = (com.upuphone.ar.tici.phone.starrynet.msg.OpenTiciMsgReplyV2) r2
            java.lang.Object r3 = r0.L$1
            com.upuphone.ar.tici.phone.starrynet.TiciStarryMsgManager r3 = (com.upuphone.ar.tici.phone.starrynet.TiciStarryMsgManager) r3
            java.lang.Object r0 = r0.L$0
            r4 = r0
            kotlinx.coroutines.sync.Mutex r4 = (kotlinx.coroutines.sync.Mutex) r4
            kotlin.ResultKt.throwOnFailure(r22)     // Catch:{ all -> 0x002f }
            goto L_0x0188
        L_0x002f:
            r0 = move-exception
            goto L_0x01b7
        L_0x0032:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x003a:
            long r3 = r0.J$0
            int r1 = r0.I$0
            java.lang.Object r5 = r0.L$3
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r5 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r5
            java.lang.Object r6 = r0.L$2
            com.upuphone.ar.tici.phone.starrynet.msg.OpenTiciMsgReplyV2 r6 = (com.upuphone.ar.tici.phone.starrynet.msg.OpenTiciMsgReplyV2) r6
            java.lang.Object r10 = r0.L$1
            com.upuphone.ar.tici.phone.starrynet.TiciStarryMsgManager r10 = (com.upuphone.ar.tici.phone.starrynet.TiciStarryMsgManager) r10
            java.lang.Object r11 = r0.L$0
            kotlinx.coroutines.sync.Mutex r11 = (kotlinx.coroutines.sync.Mutex) r11
            kotlin.ResultKt.throwOnFailure(r22)     // Catch:{ all -> 0x0059 }
            r2 = r3
            r15 = r10
            r14 = r11
            r4 = r1
            r10 = r5
            r11 = r6
            goto L_0x016a
        L_0x0059:
            r0 = move-exception
            r4 = r11
            goto L_0x01b7
        L_0x005d:
            long r10 = r0.J$0
            int r1 = r0.I$0
            java.lang.Object r6 = r0.L$3
            java.lang.Integer r6 = (java.lang.Integer) r6
            java.lang.Object r12 = r0.L$2
            com.upuphone.ar.tici.phone.starrynet.msg.OpenTiciMsgReplyV2 r12 = (com.upuphone.ar.tici.phone.starrynet.msg.OpenTiciMsgReplyV2) r12
            java.lang.Object r13 = r0.L$1
            com.upuphone.ar.tici.phone.starrynet.TiciStarryMsgManager r13 = (com.upuphone.ar.tici.phone.starrynet.TiciStarryMsgManager) r13
            java.lang.Object r14 = r0.L$0
            kotlinx.coroutines.sync.Mutex r14 = (kotlinx.coroutines.sync.Mutex) r14
            kotlin.ResultKt.throwOnFailure(r22)     // Catch:{ all -> 0x0082 }
            r15 = r13
            r18 = r6
            r6 = r22
            r19 = r10
            r11 = r18
            r10 = r12
            r12 = r19
            goto L_0x011f
        L_0x0082:
            r0 = move-exception
            r4 = r14
            goto L_0x01b7
        L_0x0086:
            java.lang.Object r1 = r0.L$2
            com.upuphone.ar.tici.phone.starrynet.msg.OpenTiciMsgReplyV2 r1 = (com.upuphone.ar.tici.phone.starrynet.msg.OpenTiciMsgReplyV2) r1
            java.lang.Object r6 = r0.L$1
            com.upuphone.ar.tici.phone.starrynet.TiciStarryMsgManager r6 = (com.upuphone.ar.tici.phone.starrynet.TiciStarryMsgManager) r6
            java.lang.Object r10 = r0.L$0
            kotlinx.coroutines.sync.Mutex r10 = (kotlinx.coroutines.sync.Mutex) r10
            kotlin.ResultKt.throwOnFailure(r22)
            r12 = r1
            r13 = r6
            r1 = r10
            goto L_0x00b7
        L_0x0099:
            kotlin.ResultKt.throwOnFailure(r22)
            com.upuphone.ar.tici.phone.starrynet.ReceiveMsgHandler r1 = r0.this$0
            kotlinx.coroutines.sync.Mutex r1 = r1.c
            com.upuphone.ar.tici.phone.starrynet.TiciStarryMsgManager r6 = r0.$msgManager
            com.upuphone.ar.tici.phone.starrynet.msg.OpenTiciMsgReplyV2 r10 = r0.$reply
            r0.L$0 = r1
            r0.L$1 = r6
            r0.L$2 = r10
            r0.label = r5
            java.lang.Object r11 = r1.c(r9, r0)
            if (r11 != r7) goto L_0x00b5
            return r7
        L_0x00b5:
            r13 = r6
            r12 = r10
        L_0x00b7:
            java.lang.String r6 = r12.getMsgId()     // Catch:{ all -> 0x00c6 }
            com.upuphone.ar.tici.phone.data.OpenTiciConfig r6 = r13.findOpenTiciConfig$ar_tici_release(r6)     // Catch:{ all -> 0x00c6 }
            if (r6 == 0) goto L_0x00ca
            int r10 = r6.b()     // Catch:{ all -> 0x00c6 }
            goto L_0x00cb
        L_0x00c6:
            r0 = move-exception
            r4 = r1
            goto L_0x01b7
        L_0x00ca:
            r10 = 0
        L_0x00cb:
            if (r6 == 0) goto L_0x00d6
            int r11 = r6.a()     // Catch:{ all -> 0x00c6 }
            java.lang.Integer r11 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r11)     // Catch:{ all -> 0x00c6 }
            goto L_0x00d7
        L_0x00d6:
            r11 = r9
        L_0x00d7:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c6 }
            r14.<init>()     // Catch:{ all -> 0x00c6 }
            java.lang.String r15 = "handleOpenResultV2, openTiciConfig: "
            r14.append(r15)     // Catch:{ all -> 0x00c6 }
            r14.append(r6)     // Catch:{ all -> 0x00c6 }
            java.lang.String r6 = r14.toString()     // Catch:{ all -> 0x00c6 }
            com.upuphone.ar.tici.phone.utils.CommonExtKt.b(r6, r8)     // Catch:{ all -> 0x00c6 }
            java.lang.String r6 = r12.getFileKey()     // Catch:{ all -> 0x00c6 }
            java.lang.Long r6 = com.upuphone.ar.tici.phone.db.entity.TiciEntityKt.b(r6)     // Catch:{ all -> 0x00c6 }
            if (r6 == 0) goto L_0x00fa
            long r14 = r6.longValue()     // Catch:{ all -> 0x00c6 }
            goto L_0x00fc
        L_0x00fa:
            r14 = 0
        L_0x00fc:
            com.upuphone.ar.tici.phone.TiciApp r6 = com.upuphone.ar.tici.phone.TiciApp.b     // Catch:{ all -> 0x00c6 }
            com.upuphone.ar.tici.phone.db.TiciDao r6 = r6.w()     // Catch:{ all -> 0x00c6 }
            r0.L$0 = r1     // Catch:{ all -> 0x00c6 }
            r0.L$1 = r13     // Catch:{ all -> 0x00c6 }
            r0.L$2 = r12     // Catch:{ all -> 0x00c6 }
            r0.L$3 = r11     // Catch:{ all -> 0x00c6 }
            r0.I$0 = r10     // Catch:{ all -> 0x00c6 }
            r0.J$0 = r14     // Catch:{ all -> 0x00c6 }
            r0.label = r4     // Catch:{ all -> 0x00c6 }
            java.lang.Object r6 = r6.q(r14, r0)     // Catch:{ all -> 0x00c6 }
            if (r6 != r7) goto L_0x0117
            return r7
        L_0x0117:
            r18 = r14
            r14 = r1
            r1 = r10
            r10 = r12
            r15 = r13
            r12 = r18
        L_0x011f:
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r6 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r6     // Catch:{ all -> 0x0082 }
            if (r6 == 0) goto L_0x0199
            long r16 = r6.getId()     // Catch:{ all -> 0x0082 }
            com.upuphone.ar.tici.phone.utils.SpUtilKt.o(r16)     // Catch:{ all -> 0x0082 }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0082 }
            r6.setLastShowTime(r2)     // Catch:{ all -> 0x0082 }
            r6.setLastModified(r2)     // Catch:{ all -> 0x0082 }
            java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()     // Catch:{ all -> 0x0082 }
            r6.setParagraphIndexes(r2)     // Catch:{ all -> 0x0082 }
            r6.setFileStatus(r5)     // Catch:{ all -> 0x0082 }
            r6.setCurrentPage(r1)     // Catch:{ all -> 0x0082 }
            if (r11 == 0) goto L_0x014a
            int r2 = r11.intValue()     // Catch:{ all -> 0x0082 }
            r6.setIndex(r2)     // Catch:{ all -> 0x0082 }
        L_0x014a:
            com.upuphone.ar.tici.phone.TiciApp r2 = com.upuphone.ar.tici.phone.TiciApp.b     // Catch:{ all -> 0x0082 }
            com.upuphone.ar.tici.phone.db.TiciDao r2 = r2.w()     // Catch:{ all -> 0x0082 }
            r0.L$0 = r14     // Catch:{ all -> 0x0082 }
            r0.L$1 = r15     // Catch:{ all -> 0x0082 }
            r0.L$2 = r10     // Catch:{ all -> 0x0082 }
            r0.L$3 = r6     // Catch:{ all -> 0x0082 }
            r0.I$0 = r1     // Catch:{ all -> 0x0082 }
            r0.J$0 = r12     // Catch:{ all -> 0x0082 }
            r3 = 3
            r0.label = r3     // Catch:{ all -> 0x0082 }
            java.lang.Object r2 = r2.n(r6, r0)     // Catch:{ all -> 0x0082 }
            if (r2 != r7) goto L_0x0166
            return r7
        L_0x0166:
            r4 = r1
            r11 = r10
            r2 = r12
            r10 = r6
        L_0x016a:
            com.upuphone.ar.tici.phone.db.TiciDBHelper r1 = com.upuphone.ar.tici.phone.db.TiciDBHelper.f5925a     // Catch:{ all -> 0x0082 }
            java.lang.String r5 = com.upuphone.ar.tici.phone.starrynet.msg.OpenTiciMsgReplyKt.b(r11)     // Catch:{ all -> 0x0082 }
            r0.L$0 = r14     // Catch:{ all -> 0x0082 }
            r0.L$1 = r15     // Catch:{ all -> 0x0082 }
            r0.L$2 = r11     // Catch:{ all -> 0x0082 }
            r0.L$3 = r10     // Catch:{ all -> 0x0082 }
            r6 = 4
            r0.label = r6     // Catch:{ all -> 0x0082 }
            r6 = r21
            java.lang.Object r0 = r1.f(r2, r4, r5, r6)     // Catch:{ all -> 0x0082 }
            if (r0 != r7) goto L_0x0184
            return r7
        L_0x0184:
            r1 = r10
            r2 = r11
            r4 = r14
            r3 = r15
        L_0x0188:
            com.upuphone.ar.tici.phone.TiciApp r0 = com.upuphone.ar.tici.phone.TiciApp.b     // Catch:{ all -> 0x002f }
            com.upuphone.ar.tici.phone.TiciAppViewModel r0 = r0.c()     // Catch:{ all -> 0x002f }
            r0.I0(r1)     // Catch:{ all -> 0x002f }
            java.lang.String r0 = "handleOpenResultV2, update db"
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r0, r8)     // Catch:{ all -> 0x002f }
            r10 = r2
            r15 = r3
            goto L_0x019f
        L_0x0199:
            java.lang.String r0 = "handleOpenResultV2, 返回数据有问题"
            com.upuphone.ar.tici.phone.utils.CommonExtKt.d(r0, r8, r9, r4, r9)     // Catch:{ all -> 0x0082 }
            r4 = r14
        L_0x019f:
            com.upuphone.ar.tici.phone.TiciApp r0 = com.upuphone.ar.tici.phone.TiciApp.b     // Catch:{ all -> 0x002f }
            com.upuphone.ar.tici.phone.TiciAppViewModel r0 = r0.c()     // Catch:{ all -> 0x002f }
            r0.k0(r10)     // Catch:{ all -> 0x002f }
            java.lang.String r0 = r10.getMsgId()     // Catch:{ all -> 0x002f }
            r15.handleOpenResult$ar_tici_release(r0)     // Catch:{ all -> 0x002f }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x002f }
            r4.d(r9)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x01b7:
            r4.d(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.starrynet.ReceiveMsgHandler$handleOpenResultV2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ReceiveMsgHandler$handleOpenResultV2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
