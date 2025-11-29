package io.ktor.websocket;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.SendChannel;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a'\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a^\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00070\u00012\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\"\u0010\u0010\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000bH\u0000ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\"\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0014\"\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0014\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/channels/SendChannel;", "Lio/ktor/websocket/Frame$Pong;", "outgoing", "Lio/ktor/websocket/Frame$Ping;", "b", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/channels/SendChannel;)Lkotlinx/coroutines/channels/SendChannel;", "Lio/ktor/websocket/Frame;", "", "periodMillis", "timeoutMillis", "Lkotlin/Function2;", "Lio/ktor/websocket/CloseReason;", "Lkotlin/coroutines/Continuation;", "", "", "onTimeout", "a", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/channels/SendChannel;JJLkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/SendChannel;", "Lkotlinx/coroutines/CoroutineName;", "Lkotlinx/coroutines/CoroutineName;", "PongerCoroutineName", "PingerCoroutineName", "ktor-websockets"}, k = 2, mv = {1, 8, 0})
public final class PingPongKt {

    /* renamed from: a  reason: collision with root package name */
    public static final CoroutineName f9132a = new CoroutineName("ws-ponger");
    public static final CoroutineName b = new CoroutineName("ws-pinger");

    public static final SendChannel a(CoroutineScope coroutineScope, SendChannel sendChannel, long j, long j2, Function2 function2) {
        CoroutineScope coroutineScope2 = coroutineScope;
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        Intrinsics.checkNotNullParameter(sendChannel, "outgoing");
        Function2 function22 = function2;
        Intrinsics.checkNotNullParameter(function22, "onTimeout");
        CompletableJob b2 = JobKt__JobKt.b((Job) null, 1, (Object) null);
        Channel b3 = ChannelKt.b(Integer.MAX_VALUE, (BufferOverflow) null, (Function1) null, 6, (Object) null);
        Job unused = BuildersKt__Builders_commonKt.d(coroutineScope, b2.plus(b), (CoroutineStart) null, new PingPongKt$pinger$1(j, j2, function22, b3, sendChannel, (Continuation<? super PingPongKt$pinger$1>) null), 2, (Object) null);
        CoroutineContext.Element element = coroutineScope.getCoroutineContext().get(Job.b0);
        Intrinsics.checkNotNull(element);
        ((Job) element).r(new PingPongKt$pinger$2(b2));
        return b3;
    }

    public static final SendChannel b(CoroutineScope coroutineScope, SendChannel sendChannel) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        Intrinsics.checkNotNullParameter(sendChannel, "outgoing");
        Channel b2 = ChannelKt.b(5, (BufferOverflow) null, (Function1) null, 6, (Object) null);
        Job unused = BuildersKt__Builders_commonKt.d(coroutineScope, f9132a, (CoroutineStart) null, new PingPongKt$ponger$1(b2, sendChannel, (Continuation<? super PingPongKt$ponger$1>) null), 2, (Object) null);
        return b2;
    }
}
