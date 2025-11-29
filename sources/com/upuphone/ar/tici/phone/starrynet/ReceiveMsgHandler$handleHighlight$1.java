package com.upuphone.ar.tici.phone.starrynet;

import com.upuphone.ar.tici.phone.starrynet.msg.HighlightMsg;
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

@SourceDebugExtension({"SMAP\nReceiveMsgHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReceiveMsgHandler.kt\ncom/upuphone/ar/tici/phone/starrynet/ReceiveMsgHandler$handleHighlight$1\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n*L\n1#1,365:1\n120#2,10:366\n*S KotlinDebug\n*F\n+ 1 ReceiveMsgHandler.kt\ncom/upuphone/ar/tici/phone/starrynet/ReceiveMsgHandler$handleHighlight$1\n*L\n232#1:366,10\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.starrynet.ReceiveMsgHandler$handleHighlight$1", f = "ReceiveMsgHandler.kt", i = {0, 1, 1, 1, 2, 2, 3, 3, 3}, l = {371, 240, 241, 243}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "userId", "index", "$this$withLock_u24default$iv", "index", "$this$withLock_u24default$iv", "entity", "index"}, s = {"L$0", "L$0", "L$1", "I$0", "L$0", "I$0", "L$0", "L$1", "I$0"})
public final class ReceiveMsgHandler$handleHighlight$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ HighlightMsg $highlightMsg;
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ReceiveMsgHandler this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReceiveMsgHandler$handleHighlight$1(ReceiveMsgHandler receiveMsgHandler, HighlightMsg highlightMsg, Continuation<? super ReceiveMsgHandler$handleHighlight$1> continuation) {
        super(2, continuation);
        this.this$0 = receiveMsgHandler;
        this.$highlightMsg = highlightMsg;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ReceiveMsgHandler$handleHighlight$1(this.this$0, this.$highlightMsg, continuation);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0084, code lost:
        r5 = com.upuphone.ar.tici.phone.db.entity.TiciEntityKt.b(r5);
     */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c2 A[Catch:{ all -> 0x008f }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00da A[Catch:{ all -> 0x008f }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00dd A[Catch:{ all -> 0x008f }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x011b A[Catch:{ all -> 0x0026 }] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r13.label
            java.lang.String r2 = "ReceiveMsgHandler"
            r3 = 4
            r4 = 3
            r5 = 1
            r6 = 2
            r7 = 0
            if (r1 == 0) goto L_0x0066
            if (r1 == r5) goto L_0x0059
            if (r1 == r6) goto L_0x0043
            if (r1 == r4) goto L_0x0031
            if (r1 != r3) goto L_0x0029
            int r0 = r13.I$0
            java.lang.Object r1 = r13.L$1
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r1 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r1
            java.lang.Object r13 = r13.L$0
            kotlinx.coroutines.sync.Mutex r13 = (kotlinx.coroutines.sync.Mutex) r13
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x0026 }
            goto L_0x00f9
        L_0x0026:
            r14 = move-exception
            goto L_0x0138
        L_0x0029:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x0031:
            int r1 = r13.I$0
            java.lang.Object r4 = r13.L$0
            kotlinx.coroutines.sync.Mutex r4 = (kotlinx.coroutines.sync.Mutex) r4
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x003f }
            r12 = r4
            r4 = r14
            r14 = r12
            goto L_0x00d7
        L_0x003f:
            r14 = move-exception
            r13 = r4
            goto L_0x0138
        L_0x0043:
            int r1 = r13.I$0
            java.lang.Object r5 = r13.L$1
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r6 = r13.L$0
            kotlinx.coroutines.sync.Mutex r6 = (kotlinx.coroutines.sync.Mutex) r6
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x0055 }
            r10 = r5
            r5 = r14
            r14 = r6
            goto L_0x00be
        L_0x0055:
            r14 = move-exception
            r13 = r6
            goto L_0x0138
        L_0x0059:
            java.lang.Object r1 = r13.L$1
            com.upuphone.ar.tici.phone.starrynet.msg.HighlightMsg r1 = (com.upuphone.ar.tici.phone.starrynet.msg.HighlightMsg) r1
            java.lang.Object r5 = r13.L$0
            kotlinx.coroutines.sync.Mutex r5 = (kotlinx.coroutines.sync.Mutex) r5
            kotlin.ResultKt.throwOnFailure(r14)
            r14 = r5
            goto L_0x007e
        L_0x0066:
            kotlin.ResultKt.throwOnFailure(r14)
            com.upuphone.ar.tici.phone.starrynet.ReceiveMsgHandler r14 = r13.this$0
            kotlinx.coroutines.sync.Mutex r14 = r14.c
            com.upuphone.ar.tici.phone.starrynet.msg.HighlightMsg r1 = r13.$highlightMsg
            r13.L$0 = r14
            r13.L$1 = r1
            r13.label = r5
            java.lang.Object r5 = r14.c(r7, r13)
            if (r5 != r0) goto L_0x007e
            return r0
        L_0x007e:
            java.lang.String r5 = r1.getFileKey()     // Catch:{ all -> 0x008f }
            if (r5 == 0) goto L_0x0095
            java.lang.Long r5 = com.upuphone.ar.tici.phone.db.entity.TiciEntityKt.b(r5)     // Catch:{ all -> 0x008f }
            if (r5 == 0) goto L_0x0095
            long r8 = r5.longValue()     // Catch:{ all -> 0x008f }
            goto L_0x0097
        L_0x008f:
            r13 = move-exception
            r12 = r14
            r14 = r13
            r13 = r12
            goto L_0x0138
        L_0x0095:
            r8 = 0
        L_0x0097:
            int r1 = r1.getIndex()     // Catch:{ all -> 0x008f }
            com.upuphone.ar.tici.phone.TiciApp r5 = com.upuphone.ar.tici.phone.TiciApp.b     // Catch:{ all -> 0x008f }
            java.lang.String r10 = r5.g()     // Catch:{ all -> 0x008f }
            if (r10 == 0) goto L_0x012d
            int r11 = r10.length()     // Catch:{ all -> 0x008f }
            if (r11 != 0) goto L_0x00ab
            goto L_0x012d
        L_0x00ab:
            com.upuphone.ar.tici.phone.db.TiciDao r5 = r5.w()     // Catch:{ all -> 0x008f }
            r13.L$0 = r14     // Catch:{ all -> 0x008f }
            r13.L$1 = r10     // Catch:{ all -> 0x008f }
            r13.I$0 = r1     // Catch:{ all -> 0x008f }
            r13.label = r6     // Catch:{ all -> 0x008f }
            java.lang.Object r5 = r5.q(r8, r13)     // Catch:{ all -> 0x008f }
            if (r5 != r0) goto L_0x00be
            return r0
        L_0x00be:
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r5 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r5     // Catch:{ all -> 0x008f }
            if (r5 != 0) goto L_0x00da
            com.upuphone.ar.tici.phone.TiciApp r5 = com.upuphone.ar.tici.phone.TiciApp.b     // Catch:{ all -> 0x008f }
            com.upuphone.ar.tici.phone.db.TiciDao r5 = r5.w()     // Catch:{ all -> 0x008f }
            r13.L$0 = r14     // Catch:{ all -> 0x008f }
            r13.L$1 = r7     // Catch:{ all -> 0x008f }
            r13.I$0 = r1     // Catch:{ all -> 0x008f }
            r13.label = r4     // Catch:{ all -> 0x008f }
            java.lang.Object r4 = r5.d(r10, r13)     // Catch:{ all -> 0x008f }
            if (r4 != r0) goto L_0x00d7
            return r0
        L_0x00d7:
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r4 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r4     // Catch:{ all -> 0x008f }
            goto L_0x00db
        L_0x00da:
            r4 = r5
        L_0x00db:
            if (r4 == 0) goto L_0x011b
            com.upuphone.ar.tici.phone.TiciApp r5 = com.upuphone.ar.tici.phone.TiciApp.b     // Catch:{ all -> 0x008f }
            com.upuphone.ar.tici.phone.db.TiciDao r5 = r5.w()     // Catch:{ all -> 0x008f }
            long r8 = r4.getId()     // Catch:{ all -> 0x008f }
            r13.L$0 = r14     // Catch:{ all -> 0x008f }
            r13.L$1 = r4     // Catch:{ all -> 0x008f }
            r13.I$0 = r1     // Catch:{ all -> 0x008f }
            r13.label = r3     // Catch:{ all -> 0x008f }
            java.lang.Object r13 = r5.x(r1, r8, r13)     // Catch:{ all -> 0x008f }
            if (r13 != r0) goto L_0x00f6
            return r0
        L_0x00f6:
            r13 = r14
            r0 = r1
            r1 = r4
        L_0x00f9:
            long r3 = r1.getId()     // Catch:{ all -> 0x0026 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x0026 }
            r14.<init>()     // Catch:{ all -> 0x0026 }
            java.lang.String r1 = "handleHighlight, updateIndex, index: "
            r14.append(r1)     // Catch:{ all -> 0x0026 }
            r14.append(r0)     // Catch:{ all -> 0x0026 }
            java.lang.String r1 = ", id: "
            r14.append(r1)     // Catch:{ all -> 0x0026 }
            r14.append(r3)     // Catch:{ all -> 0x0026 }
            java.lang.String r14 = r14.toString()     // Catch:{ all -> 0x0026 }
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r14, r2)     // Catch:{ all -> 0x0026 }
            r1 = r0
            goto L_0x011c
        L_0x011b:
            r13 = r14
        L_0x011c:
            com.upuphone.ar.tici.phone.TiciApp r14 = com.upuphone.ar.tici.phone.TiciApp.b     // Catch:{ all -> 0x0026 }
            com.upuphone.ar.tici.phone.TiciAppViewModel r14 = r14.c()     // Catch:{ all -> 0x0026 }
            r14.m0(r1)     // Catch:{ all -> 0x0026 }
            kotlin.Unit r14 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0026 }
            r13.d(r7)
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        L_0x012d:
            java.lang.String r13 = "handleHighlight, userId is null"
            com.upuphone.ar.tici.phone.utils.CommonExtKt.d(r13, r2, r7, r6, r7)     // Catch:{ all -> 0x008f }
            kotlin.Unit r13 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x008f }
            r14.d(r7)
            return r13
        L_0x0138:
            r13.d(r7)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.starrynet.ReceiveMsgHandler$handleHighlight$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ReceiveMsgHandler$handleHighlight$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
