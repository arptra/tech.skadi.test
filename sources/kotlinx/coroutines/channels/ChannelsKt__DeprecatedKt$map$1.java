package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nDeprecated.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$map$1\n+ 2 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt\n*L\n1#1,479:1\n105#2:480\n82#2,6:481\n106#2,2:487\n92#2:489\n88#2,3:490\n*S KotlinDebug\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$map$1\n*L\n332#1:480\n332#1:481,6\n332#1:487,2\n332#1:489\n332#1:490,3\n*E\n"})
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H@"}, d2 = {"<anonymous>", "", "E", "R", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$map$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 2, 2}, l = {487, 333, 333}, m = "invokeSuspend", n = {"$this$produce", "$this$consume$iv$iv", "$this$produce", "$this$consume$iv$iv", "$this$produce", "$this$consume$iv$iv"}, s = {"L$0", "L$2", "L$0", "L$2", "L$0", "L$2"})
final class ChannelsKt__DeprecatedKt$map$1 extends SuspendLambda implements Function2<ProducerScope<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveChannel<Object> $this_map;
    final /* synthetic */ Function2<Object, Continuation<Object>, Object> $transform;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelsKt__DeprecatedKt$map$1(ReceiveChannel<Object> receiveChannel, Function2<Object, ? super Continuation<Object>, ? extends Object> function2, Continuation<? super ChannelsKt__DeprecatedKt$map$1> continuation) {
        super(2, continuation);
        this.$this_map = receiveChannel;
        this.$transform = function2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$map$1 channelsKt__DeprecatedKt$map$1 = new ChannelsKt__DeprecatedKt$map$1(this.$this_map, this.$transform, continuation);
        channelsKt__DeprecatedKt$map$1.L$0 = obj;
        return channelsKt__DeprecatedKt$map$1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0091 A[Catch:{ all -> 0x0027 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c0  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L_0x0063
            if (r1 == r4) goto L_0x004f
            if (r1 == r3) goto L_0x0032
            if (r1 != r2) goto L_0x002a
            java.lang.Object r1 = r11.L$3
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r6 = r11.L$2
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r7 = r11.L$1
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            java.lang.Object r8 = r11.L$0
            kotlinx.coroutines.channels.ProducerScope r8 = (kotlinx.coroutines.channels.ProducerScope) r8
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x0027 }
            r12 = r8
            goto L_0x0075
        L_0x0027:
            r11 = move-exception
            goto L_0x00cd
        L_0x002a:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0032:
            java.lang.Object r1 = r11.L$4
            kotlinx.coroutines.channels.ProducerScope r1 = (kotlinx.coroutines.channels.ProducerScope) r1
            java.lang.Object r6 = r11.L$3
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r11.L$2
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r8 = r11.L$1
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            java.lang.Object r9 = r11.L$0
            kotlinx.coroutines.channels.ProducerScope r9 = (kotlinx.coroutines.channels.ProducerScope) r9
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x004b }
            goto L_0x00ad
        L_0x004b:
            r11 = move-exception
            r6 = r7
            goto L_0x00cd
        L_0x004f:
            java.lang.Object r1 = r11.L$3
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r6 = r11.L$2
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r7 = r11.L$1
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            java.lang.Object r8 = r11.L$0
            kotlinx.coroutines.channels.ProducerScope r8 = (kotlinx.coroutines.channels.ProducerScope) r8
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x0027 }
            goto L_0x0089
        L_0x0063:
            kotlin.ResultKt.throwOnFailure(r12)
            java.lang.Object r12 = r11.L$0
            kotlinx.coroutines.channels.ProducerScope r12 = (kotlinx.coroutines.channels.ProducerScope) r12
            kotlinx.coroutines.channels.ReceiveChannel<java.lang.Object> r6 = r11.$this_map
            kotlin.jvm.functions.Function2<java.lang.Object, kotlin.coroutines.Continuation<java.lang.Object>, java.lang.Object> r1 = r11.$transform
            kotlinx.coroutines.channels.ChannelIterator r7 = r6.iterator()     // Catch:{ all -> 0x0027 }
            r10 = r7
            r7 = r1
            r1 = r10
        L_0x0075:
            r11.L$0 = r12     // Catch:{ all -> 0x0027 }
            r11.L$1 = r7     // Catch:{ all -> 0x0027 }
            r11.L$2 = r6     // Catch:{ all -> 0x0027 }
            r11.L$3 = r1     // Catch:{ all -> 0x0027 }
            r11.label = r4     // Catch:{ all -> 0x0027 }
            java.lang.Object r8 = r1.a(r11)     // Catch:{ all -> 0x0027 }
            if (r8 != r0) goto L_0x0086
            return r0
        L_0x0086:
            r10 = r8
            r8 = r12
            r12 = r10
        L_0x0089:
            java.lang.Boolean r12 = (java.lang.Boolean) r12     // Catch:{ all -> 0x0027 }
            boolean r12 = r12.booleanValue()     // Catch:{ all -> 0x0027 }
            if (r12 == 0) goto L_0x00c5
            java.lang.Object r12 = r1.next()     // Catch:{ all -> 0x0027 }
            r11.L$0 = r8     // Catch:{ all -> 0x0027 }
            r11.L$1 = r7     // Catch:{ all -> 0x0027 }
            r11.L$2 = r6     // Catch:{ all -> 0x0027 }
            r11.L$3 = r1     // Catch:{ all -> 0x0027 }
            r11.L$4 = r8     // Catch:{ all -> 0x0027 }
            r11.label = r3     // Catch:{ all -> 0x0027 }
            java.lang.Object r12 = r7.invoke(r12, r11)     // Catch:{ all -> 0x0027 }
            if (r12 != r0) goto L_0x00a8
            return r0
        L_0x00a8:
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r1
            r1 = r9
        L_0x00ad:
            r11.L$0 = r9     // Catch:{ all -> 0x004b }
            r11.L$1 = r8     // Catch:{ all -> 0x004b }
            r11.L$2 = r7     // Catch:{ all -> 0x004b }
            r11.L$3 = r6     // Catch:{ all -> 0x004b }
            r11.L$4 = r5     // Catch:{ all -> 0x004b }
            r11.label = r2     // Catch:{ all -> 0x004b }
            java.lang.Object r12 = r1.L(r12, r11)     // Catch:{ all -> 0x004b }
            if (r12 != r0) goto L_0x00c0
            return r0
        L_0x00c0:
            r1 = r6
            r6 = r7
            r7 = r8
            r12 = r9
            goto L_0x0075
        L_0x00c5:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0027 }
            kotlinx.coroutines.channels.ChannelsKt.b(r6, r5)
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x00cd:
            throw r11     // Catch:{ all -> 0x00ce }
        L_0x00ce:
            r12 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.b(r6, r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$map$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull ProducerScope<Object> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$map$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
