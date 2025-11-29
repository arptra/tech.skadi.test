package kotlinx.coroutines.rx3;

import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.ObservableSource;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.channels.ReceiveChannel;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u001a*\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u0005H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a<\u0010\u000b\u001a\u00020\t\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u00012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\bHHø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a<\u0010\r\u001a\u00020\t\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u00052\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\bHHø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u0002\b\n\u0002\b9\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"T", "Lio/reactivex/rxjava3/core/MaybeSource;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "c", "(Lio/reactivex/rxjava3/core/MaybeSource;)Lkotlinx/coroutines/channels/ReceiveChannel;", "Lio/reactivex/rxjava3/core/ObservableSource;", "d", "(Lio/reactivex/rxjava3/core/ObservableSource;)Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlin/Function1;", "", "action", "a", "(Lio/reactivex/rxjava3/core/MaybeSource;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "b", "(Lio/reactivex/rxjava3/core/ObservableSource;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-rx3"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nRxChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RxChannel.kt\nkotlinx/coroutines/rx3/RxChannelKt\n+ 2 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt\n*L\n1#1,91:1\n105#2:92\n82#2,6:93\n106#2,2:99\n92#2:101\n88#2,3:102\n82#2,6:105\n106#2,2:111\n92#2:113\n88#2,3:114\n105#2:117\n82#2,6:118\n106#2,2:124\n92#2:126\n88#2,3:127\n105#2:130\n82#2,6:131\n106#2,2:137\n92#2:139\n88#2,3:140\n*S KotlinDebug\n*F\n+ 1 RxChannel.kt\nkotlinx/coroutines/rx3/RxChannelKt\n*L\n48#1:92\n48#1:93,6\n48#1:99,2\n48#1:101\n48#1:102,3\n48#1:105,6\n48#1:111,2\n48#1:113\n48#1:114,3\n56#1:117\n56#1:118,6\n56#1:124,2\n56#1:126\n56#1:127,3\n56#1:130\n56#1:131,6\n56#1:137,2\n56#1:139\n56#1:140,3\n*E\n"})
public final class RxChannelKt {
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006c A[Catch:{ all -> 0x0076 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object a(io.reactivex.rxjava3.core.MaybeSource r5, kotlin.jvm.functions.Function1 r6, kotlin.coroutines.Continuation r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.rx3.RxChannelKt$collect$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            kotlinx.coroutines.rx3.RxChannelKt$collect$1 r0 = (kotlinx.coroutines.rx3.RxChannelKt$collect$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.rx3.RxChannelKt$collect$1 r0 = new kotlinx.coroutines.rx3.RxChannelKt$collect$1
            r0.<init>(r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0043
            if (r2 != r3) goto L_0x003b
            java.lang.Object r5 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r6 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r2 = r0.L$0
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x0039 }
            r4 = r0
            r0 = r6
            r6 = r2
        L_0x0037:
            r2 = r4
            goto L_0x0064
        L_0x0039:
            r5 = move-exception
            goto L_0x008f
        L_0x003b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0043:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.channels.ReceiveChannel r5 = c(r5)
            kotlinx.coroutines.channels.ChannelIterator r7 = r5.iterator()     // Catch:{ all -> 0x008b }
            r4 = r7
            r7 = r5
            r5 = r4
        L_0x0051:
            r0.L$0 = r6     // Catch:{ all -> 0x0088 }
            r0.L$1 = r7     // Catch:{ all -> 0x0088 }
            r0.L$2 = r5     // Catch:{ all -> 0x0088 }
            r0.label = r3     // Catch:{ all -> 0x0088 }
            java.lang.Object r2 = r5.a(r0)     // Catch:{ all -> 0x0088 }
            if (r2 != r1) goto L_0x0060
            return r1
        L_0x0060:
            r4 = r0
            r0 = r7
            r7 = r2
            goto L_0x0037
        L_0x0064:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x0076 }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x0076 }
            if (r7 == 0) goto L_0x0079
            java.lang.Object r7 = r5.next()     // Catch:{ all -> 0x0076 }
            r6.invoke(r7)     // Catch:{ all -> 0x0076 }
            r7 = r0
            r0 = r2
            goto L_0x0051
        L_0x0076:
            r5 = move-exception
            r6 = r0
            goto L_0x008f
        L_0x0079:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0076 }
            kotlin.jvm.internal.InlineMarker.finallyStart(r3)
            r5 = 0
            kotlinx.coroutines.channels.ChannelsKt.b(r0, r5)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r3)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x0088:
            r5 = move-exception
            r6 = r7
            goto L_0x008f
        L_0x008b:
            r6 = move-exception
            r4 = r6
            r6 = r5
            r5 = r4
        L_0x008f:
            throw r5     // Catch:{ all -> 0x0090 }
        L_0x0090:
            r7 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r3)
            kotlinx.coroutines.channels.ChannelsKt.b(r6, r5)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r3)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.rx3.RxChannelKt.a(io.reactivex.rxjava3.core.MaybeSource, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006c A[Catch:{ all -> 0x0076 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object b(io.reactivex.rxjava3.core.ObservableSource r5, kotlin.jvm.functions.Function1 r6, kotlin.coroutines.Continuation r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.rx3.RxChannelKt$collect$2
            if (r0 == 0) goto L_0x0013
            r0 = r7
            kotlinx.coroutines.rx3.RxChannelKt$collect$2 r0 = (kotlinx.coroutines.rx3.RxChannelKt$collect$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.rx3.RxChannelKt$collect$2 r0 = new kotlinx.coroutines.rx3.RxChannelKt$collect$2
            r0.<init>(r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0043
            if (r2 != r3) goto L_0x003b
            java.lang.Object r5 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r6 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r2 = r0.L$0
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x0039 }
            r4 = r0
            r0 = r6
            r6 = r2
        L_0x0037:
            r2 = r4
            goto L_0x0064
        L_0x0039:
            r5 = move-exception
            goto L_0x008f
        L_0x003b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0043:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.channels.ReceiveChannel r5 = d(r5)
            kotlinx.coroutines.channels.ChannelIterator r7 = r5.iterator()     // Catch:{ all -> 0x008b }
            r4 = r7
            r7 = r5
            r5 = r4
        L_0x0051:
            r0.L$0 = r6     // Catch:{ all -> 0x0088 }
            r0.L$1 = r7     // Catch:{ all -> 0x0088 }
            r0.L$2 = r5     // Catch:{ all -> 0x0088 }
            r0.label = r3     // Catch:{ all -> 0x0088 }
            java.lang.Object r2 = r5.a(r0)     // Catch:{ all -> 0x0088 }
            if (r2 != r1) goto L_0x0060
            return r1
        L_0x0060:
            r4 = r0
            r0 = r7
            r7 = r2
            goto L_0x0037
        L_0x0064:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x0076 }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x0076 }
            if (r7 == 0) goto L_0x0079
            java.lang.Object r7 = r5.next()     // Catch:{ all -> 0x0076 }
            r6.invoke(r7)     // Catch:{ all -> 0x0076 }
            r7 = r0
            r0 = r2
            goto L_0x0051
        L_0x0076:
            r5 = move-exception
            r6 = r0
            goto L_0x008f
        L_0x0079:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0076 }
            kotlin.jvm.internal.InlineMarker.finallyStart(r3)
            r5 = 0
            kotlinx.coroutines.channels.ChannelsKt.b(r0, r5)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r3)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x0088:
            r5 = move-exception
            r6 = r7
            goto L_0x008f
        L_0x008b:
            r6 = move-exception
            r4 = r6
            r6 = r5
            r5 = r4
        L_0x008f:
            throw r5     // Catch:{ all -> 0x0090 }
        L_0x0090:
            r7 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r3)
            kotlinx.coroutines.channels.ChannelsKt.b(r6, r5)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r3)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.rx3.RxChannelKt.b(io.reactivex.rxjava3.core.ObservableSource, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final ReceiveChannel c(MaybeSource maybeSource) {
        SubscriptionChannel subscriptionChannel = new SubscriptionChannel();
        maybeSource.subscribe(subscriptionChannel);
        return subscriptionChannel;
    }

    public static final ReceiveChannel d(ObservableSource observableSource) {
        SubscriptionChannel subscriptionChannel = new SubscriptionChannel();
        observableSource.subscribe(subscriptionChannel);
        return subscriptionChannel;
    }
}
