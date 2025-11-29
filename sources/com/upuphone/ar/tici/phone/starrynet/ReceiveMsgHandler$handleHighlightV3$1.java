package com.upuphone.ar.tici.phone.starrynet;

import com.upuphone.ar.tici.phone.starrynet.msg.HighlightMsgV3;
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

@SourceDebugExtension({"SMAP\nReceiveMsgHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReceiveMsgHandler.kt\ncom/upuphone/ar/tici/phone/starrynet/ReceiveMsgHandler$handleHighlightV3$1\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n*L\n1#1,365:1\n120#2,10:366\n*S KotlinDebug\n*F\n+ 1 ReceiveMsgHandler.kt\ncom/upuphone/ar/tici/phone/starrynet/ReceiveMsgHandler$handleHighlightV3$1\n*L\n256#1:366,10\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.starrynet.ReceiveMsgHandler$handleHighlightV3$1", f = "ReceiveMsgHandler.kt", i = {0, 1, 1, 2, 2, 2}, l = {371, 259, 261}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "index", "$this$withLock_u24default$iv", "entity", "index"}, s = {"L$0", "L$0", "I$0", "L$0", "L$2", "I$0"})
public final class ReceiveMsgHandler$handleHighlightV3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ HighlightMsgV3 $highlightMsg;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ReceiveMsgHandler this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReceiveMsgHandler$handleHighlightV3$1(ReceiveMsgHandler receiveMsgHandler, HighlightMsgV3 highlightMsgV3, Continuation<? super ReceiveMsgHandler$handleHighlightV3$1> continuation) {
        super(2, continuation);
        this.this$0 = receiveMsgHandler;
        this.$highlightMsg = highlightMsgV3;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ReceiveMsgHandler$handleHighlightV3$1(this.this$0, this.$highlightMsg, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a2 A[Catch:{ all -> 0x007a }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00eb A[Catch:{ all -> 0x0025 }] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r13.label
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L_0x0053
            if (r1 == r4) goto L_0x0046
            if (r1 == r3) goto L_0x0030
            if (r1 != r2) goto L_0x0028
            int r0 = r13.I$0
            java.lang.Object r1 = r13.L$2
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r1 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r1
            java.lang.Object r2 = r13.L$1
            com.upuphone.ar.tici.phone.starrynet.msg.HighlightMsgV3 r2 = (com.upuphone.ar.tici.phone.starrynet.msg.HighlightMsgV3) r2
            java.lang.Object r13 = r13.L$0
            kotlinx.coroutines.sync.Mutex r13 = (kotlinx.coroutines.sync.Mutex) r13
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x0025 }
            goto L_0x00c7
        L_0x0025:
            r14 = move-exception
            goto L_0x00fd
        L_0x0028:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x0030:
            int r1 = r13.I$0
            java.lang.Object r3 = r13.L$1
            com.upuphone.ar.tici.phone.starrynet.msg.HighlightMsgV3 r3 = (com.upuphone.ar.tici.phone.starrynet.msg.HighlightMsgV3) r3
            java.lang.Object r4 = r13.L$0
            kotlinx.coroutines.sync.Mutex r4 = (kotlinx.coroutines.sync.Mutex) r4
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x0042 }
            r12 = r3
            r3 = r14
            r14 = r4
            r4 = r12
            goto L_0x009e
        L_0x0042:
            r14 = move-exception
            r13 = r4
            goto L_0x00fd
        L_0x0046:
            java.lang.Object r1 = r13.L$1
            com.upuphone.ar.tici.phone.starrynet.msg.HighlightMsgV3 r1 = (com.upuphone.ar.tici.phone.starrynet.msg.HighlightMsgV3) r1
            java.lang.Object r4 = r13.L$0
            kotlinx.coroutines.sync.Mutex r4 = (kotlinx.coroutines.sync.Mutex) r4
            kotlin.ResultKt.throwOnFailure(r14)
            r14 = r4
            goto L_0x006b
        L_0x0053:
            kotlin.ResultKt.throwOnFailure(r14)
            com.upuphone.ar.tici.phone.starrynet.ReceiveMsgHandler r14 = r13.this$0
            kotlinx.coroutines.sync.Mutex r14 = r14.c
            com.upuphone.ar.tici.phone.starrynet.msg.HighlightMsgV3 r1 = r13.$highlightMsg
            r13.L$0 = r14
            r13.L$1 = r1
            r13.label = r4
            java.lang.Object r4 = r14.c(r5, r13)
            if (r4 != r0) goto L_0x006b
            return r0
        L_0x006b:
            java.lang.String r4 = r1.getFileKey()     // Catch:{ all -> 0x007a }
            java.lang.Long r4 = com.upuphone.ar.tici.phone.db.entity.TiciEntityKt.b(r4)     // Catch:{ all -> 0x007a }
            if (r4 == 0) goto L_0x0080
            long r6 = r4.longValue()     // Catch:{ all -> 0x007a }
            goto L_0x0082
        L_0x007a:
            r13 = move-exception
            r12 = r14
            r14 = r13
            r13 = r12
            goto L_0x00fd
        L_0x0080:
            r6 = 0
        L_0x0082:
            int r4 = r1.getIndex()     // Catch:{ all -> 0x007a }
            com.upuphone.ar.tici.phone.TiciApp r8 = com.upuphone.ar.tici.phone.TiciApp.b     // Catch:{ all -> 0x007a }
            com.upuphone.ar.tici.phone.db.TiciDao r8 = r8.w()     // Catch:{ all -> 0x007a }
            r13.L$0 = r14     // Catch:{ all -> 0x007a }
            r13.L$1 = r1     // Catch:{ all -> 0x007a }
            r13.I$0 = r4     // Catch:{ all -> 0x007a }
            r13.label = r3     // Catch:{ all -> 0x007a }
            java.lang.Object r3 = r8.q(r6, r13)     // Catch:{ all -> 0x007a }
            if (r3 != r0) goto L_0x009b
            return r0
        L_0x009b:
            r12 = r4
            r4 = r1
            r1 = r12
        L_0x009e:
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r3 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r3     // Catch:{ all -> 0x007a }
            if (r3 == 0) goto L_0x00eb
            com.upuphone.ar.tici.phone.TiciApp r6 = com.upuphone.ar.tici.phone.TiciApp.b     // Catch:{ all -> 0x007a }
            com.upuphone.ar.tici.phone.db.TiciDao r6 = r6.w()     // Catch:{ all -> 0x007a }
            int r7 = r4.getCurrentPage()     // Catch:{ all -> 0x007a }
            long r9 = r3.getId()     // Catch:{ all -> 0x007a }
            r13.L$0 = r14     // Catch:{ all -> 0x007a }
            r13.L$1 = r4     // Catch:{ all -> 0x007a }
            r13.L$2 = r3     // Catch:{ all -> 0x007a }
            r13.I$0 = r1     // Catch:{ all -> 0x007a }
            r13.label = r2     // Catch:{ all -> 0x007a }
            r8 = r1
            r11 = r13
            java.lang.Object r13 = r6.w(r7, r8, r9, r11)     // Catch:{ all -> 0x007a }
            if (r13 != r0) goto L_0x00c3
            return r0
        L_0x00c3:
            r13 = r14
            r0 = r1
            r1 = r3
            r2 = r4
        L_0x00c7:
            long r3 = r1.getId()     // Catch:{ all -> 0x0025 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x0025 }
            r14.<init>()     // Catch:{ all -> 0x0025 }
            java.lang.String r1 = "handleHighlightV3, updateIndex, index: "
            r14.append(r1)     // Catch:{ all -> 0x0025 }
            r14.append(r0)     // Catch:{ all -> 0x0025 }
            java.lang.String r0 = ", id: "
            r14.append(r0)     // Catch:{ all -> 0x0025 }
            r14.append(r3)     // Catch:{ all -> 0x0025 }
            java.lang.String r14 = r14.toString()     // Catch:{ all -> 0x0025 }
            java.lang.String r0 = "ReceiveMsgHandler"
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r14, r0)     // Catch:{ all -> 0x0025 }
            r4 = r2
            goto L_0x00ec
        L_0x00eb:
            r13 = r14
        L_0x00ec:
            com.upuphone.ar.tici.phone.TiciApp r14 = com.upuphone.ar.tici.phone.TiciApp.b     // Catch:{ all -> 0x0025 }
            com.upuphone.ar.tici.phone.TiciAppViewModel r14 = r14.c()     // Catch:{ all -> 0x0025 }
            r14.n0(r4)     // Catch:{ all -> 0x0025 }
            kotlin.Unit r14 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0025 }
            r13.d(r5)
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        L_0x00fd:
            r13.d(r5)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.starrynet.ReceiveMsgHandler$handleHighlightV3$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ReceiveMsgHandler$handleHighlightV3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
