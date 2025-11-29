package com.upuphone.ai.ttsengine.engines.cloud;

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

@SourceDebugExtension({"SMAP\nCloudEngine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CloudEngine.kt\ncom/upuphone/ai/ttsengine/engines/cloud/CloudEngine$launchChannel$1\n+ 2 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt\n*L\n1#1,659:1\n105#2:660\n82#2,6:661\n106#2,2:667\n92#2:669\n88#2,3:670\n*S KotlinDebug\n*F\n+ 1 CloudEngine.kt\ncom/upuphone/ai/ttsengine/engines/cloud/CloudEngine$launchChannel$1\n*L\n481#1:660\n481#1:661,6\n481#1:667,2\n481#1:669\n481#1:670,3\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ai.ttsengine.engines.cloud.CloudEngine$launchChannel$1", f = "CloudEngine.kt", i = {0}, l = {667}, m = "invokeSuspend", n = {"$this$consume$iv$iv"}, s = {"L$1"})
public final class CloudEngine$launchChannel$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ CloudEngine this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CloudEngine$launchChannel$1(CloudEngine cloudEngine, Continuation<? super CloudEngine$launchChannel$1> continuation) {
        super(2, continuation);
        this.this$0 = cloudEngine;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CloudEngine$launchChannel$1(this.this$0, continuation);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0060, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0061, code lost:
        kotlinx.coroutines.channels.ChannelsKt.b(r3, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0064, code lost:
        throw r6;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004e A[Catch:{ all -> 0x0060 }] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 1
            if (r1 == 0) goto L_0x0025
            if (r1 != r2) goto L_0x001d
            java.lang.Object r1 = r5.L$2
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r3 = r5.L$1
            kotlinx.coroutines.channels.ReceiveChannel r3 = (kotlinx.coroutines.channels.ReceiveChannel) r3
            java.lang.Object r4 = r5.L$0
            com.upuphone.ai.ttsengine.engines.cloud.CloudEngine r4 = (com.upuphone.ai.ttsengine.engines.cloud.CloudEngine) r4
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x001b }
            goto L_0x0046
        L_0x001b:
            r5 = move-exception
            goto L_0x005f
        L_0x001d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0025:
            kotlin.ResultKt.throwOnFailure(r6)
            com.upuphone.ai.ttsengine.engines.cloud.CloudEngine r6 = r5.this$0
            kotlinx.coroutines.channels.Channel r3 = r6.channel
            if (r3 == 0) goto L_0x0065
            com.upuphone.ai.ttsengine.engines.cloud.CloudEngine r6 = r5.this$0
            kotlinx.coroutines.channels.ChannelIterator r1 = r3.iterator()     // Catch:{ all -> 0x001b }
            r4 = r6
        L_0x0037:
            r5.L$0 = r4     // Catch:{ all -> 0x001b }
            r5.L$1 = r3     // Catch:{ all -> 0x001b }
            r5.L$2 = r1     // Catch:{ all -> 0x001b }
            r5.label = r2     // Catch:{ all -> 0x001b }
            java.lang.Object r6 = r1.a(r5)     // Catch:{ all -> 0x001b }
            if (r6 != r0) goto L_0x0046
            return r0
        L_0x0046:
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ all -> 0x001b }
            boolean r6 = r6.booleanValue()     // Catch:{ all -> 0x001b }
            if (r6 == 0) goto L_0x0058
            java.lang.Object r6 = r1.next()     // Catch:{ all -> 0x001b }
            com.upuphone.ai.ttsengine.engines.cloud.Status$AudioData r6 = (com.upuphone.ai.ttsengine.engines.cloud.Status.AudioData) r6     // Catch:{ all -> 0x001b }
            r4.processAudio(r6)     // Catch:{ all -> 0x001b }
            goto L_0x0037
        L_0x0058:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x001b }
            r5 = 0
            kotlinx.coroutines.channels.ChannelsKt.b(r3, r5)
            goto L_0x0065
        L_0x005f:
            throw r5     // Catch:{ all -> 0x0060 }
        L_0x0060:
            r6 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.b(r3, r5)
            throw r6
        L_0x0065:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ai.ttsengine.engines.cloud.CloudEngine$launchChannel$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CloudEngine$launchChannel$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
