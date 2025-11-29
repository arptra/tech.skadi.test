package com.upuphone.ar.transcribe.phone.helper;

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

@SourceDebugExtension({"SMAP\nTtsDataSender.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TtsDataSender.kt\ncom/upuphone/ar/transcribe/phone/helper/TtsDataSender$start$1\n+ 2 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt\n*L\n1#1,157:1\n105#2:158\n82#2,6:159\n106#2,2:165\n92#2:167\n88#2,3:168\n*S KotlinDebug\n*F\n+ 1 TtsDataSender.kt\ncom/upuphone/ar/transcribe/phone/helper/TtsDataSender$start$1\n*L\n54#1:158\n54#1:159,6\n54#1:165,2\n54#1:167\n54#1:168,3\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.transcribe.phone.helper.TtsDataSender$start$1", f = "TtsDataSender.kt", i = {0, 0, 1, 1}, l = {165, 64}, m = "invokeSuspend", n = {"receiveList", "$this$consume$iv$iv", "receiveList", "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class TtsDataSender$start$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public TtsDataSender$start$1(Continuation<? super TtsDataSender$start$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TtsDataSender$start$1(continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x006d A[Catch:{ all -> 0x0021, all -> 0x00e9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00f6  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r19) {
        /*
            r18 = this;
            r0 = r18
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003f
            if (r2 == r4) goto L_0x002d
            if (r2 != r3) goto L_0x0025
            java.lang.Object r2 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            java.lang.Object r5 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r5 = (kotlinx.coroutines.channels.ReceiveChannel) r5
            java.lang.Object r6 = r0.L$0
            java.util.List r6 = (java.util.List) r6
            kotlin.ResultKt.throwOnFailure(r19)     // Catch:{ all -> 0x0021 }
            goto L_0x00b8
        L_0x0021:
            r0 = move-exception
            r1 = r0
            goto L_0x00e8
        L_0x0025:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x002d:
            java.lang.Object r2 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            java.lang.Object r5 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r5 = (kotlinx.coroutines.channels.ReceiveChannel) r5
            java.lang.Object r6 = r0.L$0
            java.util.List r6 = (java.util.List) r6
            kotlin.ResultKt.throwOnFailure(r19)     // Catch:{ all -> 0x0021 }
            r7 = r19
            goto L_0x0065
        L_0x003f:
            kotlin.ResultKt.throwOnFailure(r19)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            kotlinx.coroutines.channels.Channel r5 = com.upuphone.ar.transcribe.phone.helper.TtsDataSender.c
            if (r5 == 0) goto L_0x00ef
            kotlinx.coroutines.channels.ChannelIterator r6 = r5.iterator()     // Catch:{ all -> 0x0021 }
        L_0x0051:
            r0.L$0 = r2     // Catch:{ all -> 0x0021 }
            r0.L$1 = r5     // Catch:{ all -> 0x0021 }
            r0.L$2 = r6     // Catch:{ all -> 0x0021 }
            r0.label = r4     // Catch:{ all -> 0x0021 }
            java.lang.Object r7 = r6.a(r0)     // Catch:{ all -> 0x0021 }
            if (r7 != r1) goto L_0x0060
            return r1
        L_0x0060:
            r17 = r6
            r6 = r2
            r2 = r17
        L_0x0065:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x0021 }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x0021 }
            if (r7 == 0) goto L_0x00e0
            java.lang.Object r7 = r2.next()     // Catch:{ all -> 0x0021 }
            com.upuphone.ar.transcribe.phone.helper.TtsDataSender$OpusTtsData r7 = (com.upuphone.ar.transcribe.phone.helper.TtsDataSender.OpusTtsData) r7     // Catch:{ all -> 0x0021 }
            byte[] r8 = r7.a()     // Catch:{ all -> 0x0021 }
            int r8 = r8.length     // Catch:{ all -> 0x0021 }
            if (r8 != 0) goto L_0x007c
            r8 = r4
            goto L_0x007d
        L_0x007c:
            r8 = 0
        L_0x007d:
            r8 = r8 ^ r4
            if (r8 == 0) goto L_0x0087
            byte[] r8 = r7.a()     // Catch:{ all -> 0x0021 }
            r6.add(r8)     // Catch:{ all -> 0x0021 }
        L_0x0087:
            int r8 = r6.size()     // Catch:{ all -> 0x0021 }
            r9 = 20
            if (r8 < r9) goto L_0x00be
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ all -> 0x0021 }
            r11.<init>()     // Catch:{ all -> 0x0021 }
            r11.addAll(r6)     // Catch:{ all -> 0x0021 }
            com.upuphone.ar.transcribe.phone.helper.TtsDataSender r10 = com.upuphone.ar.transcribe.phone.helper.TtsDataSender.f6112a     // Catch:{ all -> 0x0021 }
            long r12 = r7.b()     // Catch:{ all -> 0x0021 }
            r15 = 4
            r16 = 0
            r14 = 0
            com.upuphone.ar.transcribe.phone.helper.TtsDataSender.e(r10, r11, r12, r14, r15, r16)     // Catch:{ all -> 0x0021 }
            r6.clear()     // Catch:{ all -> 0x0021 }
            r0.L$0 = r6     // Catch:{ all -> 0x0021 }
            r0.L$1 = r5     // Catch:{ all -> 0x0021 }
            r0.L$2 = r2     // Catch:{ all -> 0x0021 }
            r0.label = r3     // Catch:{ all -> 0x0021 }
            r7 = 60
            java.lang.Object r7 = kotlinx.coroutines.DelayKt.b(r7, r0)     // Catch:{ all -> 0x0021 }
            if (r7 != r1) goto L_0x00b8
            return r1
        L_0x00b8:
            r17 = r6
            r6 = r2
            r2 = r17
            goto L_0x0051
        L_0x00be:
            boolean r8 = r7.c()     // Catch:{ all -> 0x0021 }
            if (r8 == 0) goto L_0x00b8
            boolean r8 = r6.isEmpty()     // Catch:{ all -> 0x0021 }
            r8 = r8 ^ r4
            if (r8 == 0) goto L_0x00b8
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ all -> 0x0021 }
            r8.<init>()     // Catch:{ all -> 0x0021 }
            r8.addAll(r6)     // Catch:{ all -> 0x0021 }
            com.upuphone.ar.transcribe.phone.helper.TtsDataSender r9 = com.upuphone.ar.transcribe.phone.helper.TtsDataSender.f6112a     // Catch:{ all -> 0x0021 }
            long r10 = r7.b()     // Catch:{ all -> 0x0021 }
            r9.d(r8, r10, r4)     // Catch:{ all -> 0x0021 }
            r9.g()     // Catch:{ all -> 0x0021 }
            goto L_0x00b8
        L_0x00e0:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0021 }
            r0 = 0
            kotlinx.coroutines.channels.ChannelsKt.b(r5, r0)
            r2 = r6
            goto L_0x00ef
        L_0x00e8:
            throw r1     // Catch:{ all -> 0x00e9 }
        L_0x00e9:
            r0 = move-exception
            r2 = r0
            kotlinx.coroutines.channels.ChannelsKt.b(r5, r1)
            throw r2
        L_0x00ef:
            boolean r0 = r2.isEmpty()
            r0 = r0 ^ r4
            if (r0 == 0) goto L_0x0108
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r4.addAll(r2)
            com.upuphone.ar.transcribe.phone.helper.TtsDataSender r3 = com.upuphone.ar.transcribe.phone.helper.TtsDataSender.f6112a
            r8 = 6
            r9 = 0
            r5 = 0
            r7 = 0
            com.upuphone.ar.transcribe.phone.helper.TtsDataSender.e(r3, r4, r5, r7, r8, r9)
        L_0x0108:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.transcribe.phone.helper.TtsDataSender$start$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TtsDataSender$start$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
