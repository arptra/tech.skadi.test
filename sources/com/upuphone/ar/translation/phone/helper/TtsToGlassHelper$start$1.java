package com.upuphone.ar.translation.phone.helper;

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

@SourceDebugExtension({"SMAP\nTtsToGlassHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TtsToGlassHelper.kt\ncom/upuphone/ar/translation/phone/helper/TtsToGlassHelper$start$1\n+ 2 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt\n*L\n1#1,301:1\n105#2:302\n82#2,6:303\n106#2,2:309\n92#2:311\n88#2,3:312\n*S KotlinDebug\n*F\n+ 1 TtsToGlassHelper.kt\ncom/upuphone/ar/translation/phone/helper/TtsToGlassHelper$start$1\n*L\n69#1:302\n69#1:303,6\n69#1:309,2\n69#1:311\n69#1:312,3\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.helper.TtsToGlassHelper$start$1", f = "TtsToGlassHelper.kt", i = {0, 0, 1, 1}, l = {309, 81}, m = "invokeSuspend", n = {"receiveList", "$this$consume$iv$iv", "receiveList", "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class TtsToGlassHelper$start$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public TtsToGlassHelper$start$1(Continuation<? super TtsToGlassHelper$start$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TtsToGlassHelper$start$1(continuation);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00cc, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00cd, code lost:
        kotlinx.coroutines.channels.ChannelsKt.b(r4, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d0, code lost:
        throw r10;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0064 A[Catch:{ all -> 0x00cc }] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x003a
            if (r1 == r3) goto L_0x002a
            if (r1 != r2) goto L_0x0022
            java.lang.Object r1 = r9.L$2
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r9.L$1
            kotlinx.coroutines.channels.ReceiveChannel r4 = (kotlinx.coroutines.channels.ReceiveChannel) r4
            java.lang.Object r5 = r9.L$0
            java.util.List r5 = (java.util.List) r5
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x001f }
            goto L_0x00a3
        L_0x001f:
            r9 = move-exception
            goto L_0x00cb
        L_0x0022:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x002a:
            java.lang.Object r1 = r9.L$2
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r9.L$1
            kotlinx.coroutines.channels.ReceiveChannel r4 = (kotlinx.coroutines.channels.ReceiveChannel) r4
            java.lang.Object r5 = r9.L$0
            java.util.List r5 = (java.util.List) r5
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x001f }
            goto L_0x005c
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r10)
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            kotlinx.coroutines.channels.Channel r4 = com.upuphone.ar.translation.phone.helper.TtsToGlassHelper.d
            kotlinx.coroutines.channels.ChannelIterator r1 = r4.iterator()     // Catch:{ all -> 0x001f }
        L_0x004a:
            r9.L$0 = r10     // Catch:{ all -> 0x001f }
            r9.L$1 = r4     // Catch:{ all -> 0x001f }
            r9.L$2 = r1     // Catch:{ all -> 0x001f }
            r9.label = r3     // Catch:{ all -> 0x001f }
            java.lang.Object r5 = r1.a(r9)     // Catch:{ all -> 0x001f }
            if (r5 != r0) goto L_0x0059
            return r0
        L_0x0059:
            r8 = r5
            r5 = r10
            r10 = r8
        L_0x005c:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ all -> 0x001f }
            boolean r10 = r10.booleanValue()     // Catch:{ all -> 0x001f }
            if (r10 == 0) goto L_0x00bf
            java.lang.Object r10 = r1.next()     // Catch:{ all -> 0x001f }
            com.upuphone.ar.translation.phone.helper.TtsToGlassHelper$OpusTtsData r10 = (com.upuphone.ar.translation.phone.helper.TtsToGlassHelper.OpusTtsData) r10     // Catch:{ all -> 0x001f }
            byte[] r6 = r10.a()     // Catch:{ all -> 0x001f }
            int r6 = r6.length     // Catch:{ all -> 0x001f }
            if (r6 != 0) goto L_0x0073
            r6 = r3
            goto L_0x0074
        L_0x0073:
            r6 = 0
        L_0x0074:
            r6 = r6 ^ r3
            if (r6 == 0) goto L_0x007e
            byte[] r6 = r10.a()     // Catch:{ all -> 0x001f }
            r5.add(r6)     // Catch:{ all -> 0x001f }
        L_0x007e:
            int r6 = r5.size()     // Catch:{ all -> 0x001f }
            r7 = 40
            if (r6 < r7) goto L_0x00a5
            com.upuphone.ar.translation.phone.helper.TtsToGlassHelper r10 = com.upuphone.ar.translation.phone.helper.TtsToGlassHelper.f6315a     // Catch:{ all -> 0x001f }
            java.util.List r6 = kotlin.collections.CollectionsKt.toMutableList(r5)     // Catch:{ all -> 0x001f }
            r10.l(r6)     // Catch:{ all -> 0x001f }
            r5.clear()     // Catch:{ all -> 0x001f }
            r9.L$0 = r5     // Catch:{ all -> 0x001f }
            r9.L$1 = r4     // Catch:{ all -> 0x001f }
            r9.L$2 = r1     // Catch:{ all -> 0x001f }
            r9.label = r2     // Catch:{ all -> 0x001f }
            r6 = 100
            java.lang.Object r10 = kotlinx.coroutines.DelayKt.b(r6, r9)     // Catch:{ all -> 0x001f }
            if (r10 != r0) goto L_0x00a3
            return r0
        L_0x00a3:
            r10 = r5
            goto L_0x004a
        L_0x00a5:
            boolean r10 = r10.c()     // Catch:{ all -> 0x001f }
            if (r10 == 0) goto L_0x00a3
            boolean r10 = r5.isEmpty()     // Catch:{ all -> 0x001f }
            r10 = r10 ^ r3
            if (r10 == 0) goto L_0x00a3
            com.upuphone.ar.translation.phone.helper.TtsToGlassHelper r10 = com.upuphone.ar.translation.phone.helper.TtsToGlassHelper.f6315a     // Catch:{ all -> 0x001f }
            java.util.List r6 = kotlin.collections.CollectionsKt.toMutableList(r5)     // Catch:{ all -> 0x001f }
            r10.l(r6)     // Catch:{ all -> 0x001f }
            r5.clear()     // Catch:{ all -> 0x001f }
            goto L_0x00a3
        L_0x00bf:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x001f }
            r9 = 0
            kotlinx.coroutines.channels.ChannelsKt.b(r4, r9)
            r5.clear()
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L_0x00cb:
            throw r9     // Catch:{ all -> 0x00cc }
        L_0x00cc:
            r10 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.b(r4, r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.phone.helper.TtsToGlassHelper$start$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TtsToGlassHelper$start$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
