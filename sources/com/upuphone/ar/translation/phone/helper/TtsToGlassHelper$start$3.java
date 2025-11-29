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

@SourceDebugExtension({"SMAP\nTtsToGlassHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TtsToGlassHelper.kt\ncom/upuphone/ar/translation/phone/helper/TtsToGlassHelper$start$3\n+ 2 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt\n*L\n1#1,301:1\n105#2:302\n82#2,6:303\n106#2,2:309\n92#2:311\n88#2,3:312\n*S KotlinDebug\n*F\n+ 1 TtsToGlassHelper.kt\ncom/upuphone/ar/translation/phone/helper/TtsToGlassHelper$start$3\n*L\n127#1:302\n127#1:303,6\n127#1:309,2\n127#1:311\n127#1:312,3\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.helper.TtsToGlassHelper$start$3", f = "TtsToGlassHelper.kt", i = {0, 0, 1, 1}, l = {309, 139}, m = "invokeSuspend", n = {"receiveList", "$this$consume$iv$iv", "receiveList", "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class TtsToGlassHelper$start$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public TtsToGlassHelper$start$3(Continuation<? super TtsToGlassHelper$start$3> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TtsToGlassHelper$start$3(continuation);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00d8, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00d9, code lost:
        kotlinx.coroutines.channels.ChannelsKt.b(r4, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00dc, code lost:
        throw r12;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0064 A[Catch:{ all -> 0x00d8 }] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x003a
            if (r1 == r3) goto L_0x002a
            if (r1 != r2) goto L_0x0022
            java.lang.Object r1 = r11.L$2
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r11.L$1
            kotlinx.coroutines.channels.ReceiveChannel r4 = (kotlinx.coroutines.channels.ReceiveChannel) r4
            java.lang.Object r5 = r11.L$0
            java.util.List r5 = (java.util.List) r5
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x001f }
            goto L_0x00ab
        L_0x001f:
            r11 = move-exception
            goto L_0x00d7
        L_0x0022:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x002a:
            java.lang.Object r1 = r11.L$2
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r11.L$1
            kotlinx.coroutines.channels.ReceiveChannel r4 = (kotlinx.coroutines.channels.ReceiveChannel) r4
            java.lang.Object r5 = r11.L$0
            java.util.List r5 = (java.util.List) r5
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x001f }
            goto L_0x005c
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r12)
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            kotlinx.coroutines.channels.Channel r4 = com.upuphone.ar.translation.phone.helper.TtsToGlassHelper.f
            kotlinx.coroutines.channels.ChannelIterator r1 = r4.iterator()     // Catch:{ all -> 0x001f }
        L_0x004a:
            r11.L$0 = r12     // Catch:{ all -> 0x001f }
            r11.L$1 = r4     // Catch:{ all -> 0x001f }
            r11.L$2 = r1     // Catch:{ all -> 0x001f }
            r11.label = r3     // Catch:{ all -> 0x001f }
            java.lang.Object r5 = r1.a(r11)     // Catch:{ all -> 0x001f }
            if (r5 != r0) goto L_0x0059
            return r0
        L_0x0059:
            r10 = r5
            r5 = r12
            r12 = r10
        L_0x005c:
            java.lang.Boolean r12 = (java.lang.Boolean) r12     // Catch:{ all -> 0x001f }
            boolean r12 = r12.booleanValue()     // Catch:{ all -> 0x001f }
            if (r12 == 0) goto L_0x00cb
            java.lang.Object r12 = r1.next()     // Catch:{ all -> 0x001f }
            com.upuphone.ar.translation.phone.helper.TtsToGlassHelper$OpusTtsData r12 = (com.upuphone.ar.translation.phone.helper.TtsToGlassHelper.OpusTtsData) r12     // Catch:{ all -> 0x001f }
            byte[] r6 = r12.a()     // Catch:{ all -> 0x001f }
            int r6 = r6.length     // Catch:{ all -> 0x001f }
            if (r6 != 0) goto L_0x0073
            r6 = r3
            goto L_0x0074
        L_0x0073:
            r6 = 0
        L_0x0074:
            r6 = r6 ^ r3
            if (r6 == 0) goto L_0x007e
            byte[] r6 = r12.a()     // Catch:{ all -> 0x001f }
            r5.add(r6)     // Catch:{ all -> 0x001f }
        L_0x007e:
            int r6 = r5.size()     // Catch:{ all -> 0x001f }
            r7 = 40
            if (r6 < r7) goto L_0x00ad
            com.upuphone.ar.translation.phone.helper.TtsToGlassHelper r6 = com.upuphone.ar.translation.phone.helper.TtsToGlassHelper.f6315a     // Catch:{ all -> 0x001f }
            java.util.List r7 = kotlin.collections.CollectionsKt.toMutableList(r5)     // Catch:{ all -> 0x001f }
            long r8 = r12.b()     // Catch:{ all -> 0x001f }
            boolean r12 = r12.c()     // Catch:{ all -> 0x001f }
            r6.j(r7, r8, r12)     // Catch:{ all -> 0x001f }
            r5.clear()     // Catch:{ all -> 0x001f }
            r11.L$0 = r5     // Catch:{ all -> 0x001f }
            r11.L$1 = r4     // Catch:{ all -> 0x001f }
            r11.L$2 = r1     // Catch:{ all -> 0x001f }
            r11.label = r2     // Catch:{ all -> 0x001f }
            r6 = 100
            java.lang.Object r12 = kotlinx.coroutines.DelayKt.b(r6, r11)     // Catch:{ all -> 0x001f }
            if (r12 != r0) goto L_0x00ab
            return r0
        L_0x00ab:
            r12 = r5
            goto L_0x004a
        L_0x00ad:
            boolean r6 = r12.c()     // Catch:{ all -> 0x001f }
            if (r6 == 0) goto L_0x00ab
            boolean r6 = r5.isEmpty()     // Catch:{ all -> 0x001f }
            r6 = r6 ^ r3
            if (r6 == 0) goto L_0x00ab
            com.upuphone.ar.translation.phone.helper.TtsToGlassHelper r6 = com.upuphone.ar.translation.phone.helper.TtsToGlassHelper.f6315a     // Catch:{ all -> 0x001f }
            java.util.List r7 = kotlin.collections.CollectionsKt.toMutableList(r5)     // Catch:{ all -> 0x001f }
            long r8 = r12.b()     // Catch:{ all -> 0x001f }
            r6.j(r7, r8, r3)     // Catch:{ all -> 0x001f }
            r5.clear()     // Catch:{ all -> 0x001f }
            goto L_0x00ab
        L_0x00cb:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x001f }
            r11 = 0
            kotlinx.coroutines.channels.ChannelsKt.b(r4, r11)
            r5.clear()
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x00d7:
            throw r11     // Catch:{ all -> 0x00d8 }
        L_0x00d8:
            r12 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.b(r4, r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.phone.helper.TtsToGlassHelper$start$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TtsToGlassHelper$start$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
