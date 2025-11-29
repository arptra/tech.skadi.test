package kotlinx.coroutines.reactive;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.channels.ReceiveChannel;
import org.reactivestreams.Publisher;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a7\u0010\u0005\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0002HHø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a/\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\n\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"T", "Lorg/reactivestreams/Publisher;", "Lkotlin/Function1;", "", "action", "a", "(Lorg/reactivestreams/Publisher;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "request", "Lkotlinx/coroutines/channels/ReceiveChannel;", "b", "(Lorg/reactivestreams/Publisher;I)Lkotlinx/coroutines/channels/ReceiveChannel;", "kotlinx-coroutines-reactive"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Channel.kt\nkotlinx/coroutines/reactive/ChannelKt\n+ 2 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt\n*L\n1#1,111:1\n105#2:112\n82#2,6:113\n106#2,2:119\n92#2:121\n88#2,3:122\n82#2,6:125\n106#2,2:131\n92#2:133\n88#2,3:134\n*S KotlinDebug\n*F\n+ 1 Channel.kt\nkotlinx/coroutines/reactive/ChannelKt\n*L\n19#1:112\n19#1:113,6\n19#1:119,2\n19#1:121\n19#1:122,3\n19#1:125,6\n19#1:131,2\n19#1:133\n19#1:134,3\n*E\n"})
public final class ChannelKt {
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006e A[Catch:{ all -> 0x0078 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object a(org.reactivestreams.Publisher r6, kotlin.jvm.functions.Function1 r7, kotlin.coroutines.Continuation r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.reactive.ChannelKt$collect$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            kotlinx.coroutines.reactive.ChannelKt$collect$1 r0 = (kotlinx.coroutines.reactive.ChannelKt$collect$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.reactive.ChannelKt$collect$1 r0 = new kotlinx.coroutines.reactive.ChannelKt$collect$1
            r0.<init>(r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0044
            if (r2 != r3) goto L_0x003c
            java.lang.Object r6 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r2 = r0.L$0
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x003a }
            r5 = r0
            r0 = r7
            r7 = r2
        L_0x0038:
            r2 = r5
            goto L_0x0066
        L_0x003a:
            r6 = move-exception
            goto L_0x0090
        L_0x003c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = 0
            kotlinx.coroutines.channels.ReceiveChannel r6 = c(r6, r8, r3, r4)
            kotlinx.coroutines.channels.ChannelIterator r8 = r6.iterator()     // Catch:{ all -> 0x008c }
            r5 = r8
            r8 = r6
            r6 = r5
        L_0x0053:
            r0.L$0 = r7     // Catch:{ all -> 0x0089 }
            r0.L$1 = r8     // Catch:{ all -> 0x0089 }
            r0.L$2 = r6     // Catch:{ all -> 0x0089 }
            r0.label = r3     // Catch:{ all -> 0x0089 }
            java.lang.Object r2 = r6.a(r0)     // Catch:{ all -> 0x0089 }
            if (r2 != r1) goto L_0x0062
            return r1
        L_0x0062:
            r5 = r0
            r0 = r8
            r8 = r2
            goto L_0x0038
        L_0x0066:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x0078 }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x0078 }
            if (r8 == 0) goto L_0x007b
            java.lang.Object r8 = r6.next()     // Catch:{ all -> 0x0078 }
            r7.invoke(r8)     // Catch:{ all -> 0x0078 }
            r8 = r0
            r0 = r2
            goto L_0x0053
        L_0x0078:
            r6 = move-exception
            r7 = r0
            goto L_0x0090
        L_0x007b:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0078 }
            kotlin.jvm.internal.InlineMarker.finallyStart(r3)
            kotlinx.coroutines.channels.ChannelsKt.b(r0, r4)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r3)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x0089:
            r6 = move-exception
            r7 = r8
            goto L_0x0090
        L_0x008c:
            r7 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
        L_0x0090:
            throw r6     // Catch:{ all -> 0x0091 }
        L_0x0091:
            r8 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r3)
            kotlinx.coroutines.channels.ChannelsKt.b(r7, r6)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r3)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.reactive.ChannelKt.a(org.reactivestreams.Publisher, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final ReceiveChannel b(Publisher publisher, int i) {
        SubscriptionChannel subscriptionChannel = new SubscriptionChannel(i);
        publisher.subscribe(subscriptionChannel);
        return subscriptionChannel;
    }

    public static /* synthetic */ ReceiveChannel c(Publisher publisher, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        return b(publisher, i);
    }
}
