package io.ktor.utils.io;

import com.upuphone.runasone.relay.api.IntentKey;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ChildHandle;
import kotlinx.coroutines.ChildJob;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0001¢\u0006\u0004\b\f\u0010\rJ\"\u0010\u0012\u001a\u00020\u00112\u0010\b\u0002\u0010\u0010\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000fH\u0001¢\u0006\u0004\b\u0012\u0010\u0013J8\u0010\u0019\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00142\u0006\u0010\u0015\u001a\u00028\u00002\u0018\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00028\u00000\u0016H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ*\u0010\u001e\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u001b*\u00020\u00172\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0014\u0010 \u001a\u00060\u000ej\u0002`\u000fH\u0001¢\u0006\u0004\b \u0010!JM\u0010,\u001a\u00020+2\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020\"2'\u0010*\u001a#\u0012\u0015\u0012\u0013\u0018\u00010&¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110%j\u0002`)H\u0001¢\u0006\u0004\b,\u0010-J9\u0010.\u001a\u00020+2'\u0010*\u001a#\u0012\u0015\u0012\u0013\u0018\u00010&¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110%j\u0002`)H\u0001¢\u0006\u0004\b.\u0010/J\u0013\u00100\u001a\u00020\u0011HAø\u0001\u0000¢\u0006\u0004\b0\u00101J\u001c\u00103\u001a\u0002022\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001cH\u0001¢\u0006\u0004\b3\u00104J\u0018\u00106\u001a\u0002022\u0006\u00105\u001a\u000202H\u0003¢\u0006\u0004\b6\u00107J\u0010\u00108\u001a\u00020\"H\u0001¢\u0006\u0004\b8\u00109J\u000f\u0010;\u001a\u00020:H\u0016¢\u0006\u0004\b;\u0010<R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010=R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0004¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u0014\u0010B\u001a\u00020\"8\u0016X\u0005¢\u0006\u0006\u001a\u0004\bB\u00109R\u0014\u0010C\u001a\u00020\"8\u0016X\u0005¢\u0006\u0006\u001a\u0004\bC\u00109R\u0014\u0010D\u001a\u00020\"8\u0016X\u0005¢\u0006\u0006\u001a\u0004\bD\u00109R\u0018\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001c8\u0016X\u0005¢\u0006\u0006\u001a\u0004\bE\u0010FR\u0016\u0010I\u001a\u0004\u0018\u00010\u00038\u0016X\u0005¢\u0006\u0006\u001a\u0004\bG\u0010H\u0002\u0004\n\u0002\b\u0019¨\u0006J"}, d2 = {"Lio/ktor/utils/io/ChannelJob;", "Lio/ktor/utils/io/ReaderJob;", "Lio/ktor/utils/io/WriterJob;", "Lkotlinx/coroutines/Job;", "delegate", "Lio/ktor/utils/io/ByteChannel;", "channel", "<init>", "(Lkotlinx/coroutines/Job;Lio/ktor/utils/io/ByteChannel;)V", "Lkotlinx/coroutines/ChildJob;", "child", "Lkotlinx/coroutines/ChildHandle;", "N", "(Lkotlinx/coroutines/ChildJob;)Lkotlinx/coroutines/ChildHandle;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", "", "a", "(Ljava/util/concurrent/CancellationException;)V", "R", "initial", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext$Element;", "operation", "fold", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "E", "Lkotlin/coroutines/CoroutineContext$Key;", "key", "get", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "U", "()Ljava/util/concurrent/CancellationException;", "", "onCancelling", "invokeImmediately", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "Lkotlinx/coroutines/DisposableHandle;", "S", "(ZZLkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "r", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "i0", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "minusKey", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext;", "context", "plus", "(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;", "start", "()Z", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/Job;", "b", "Lio/ktor/utils/io/ByteChannel;", "e", "()Lio/ktor/utils/io/ByteChannel;", "isActive", "isCancelled", "isCompleted", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "getParent", "()Lkotlinx/coroutines/Job;", "parent", "ktor-io"}, k = 1, mv = {1, 8, 0})
final class ChannelJob implements ReaderJob, WriterJob, Job {

    /* renamed from: a  reason: collision with root package name */
    public final Job f9079a;
    public final ByteChannel b;

    public ChannelJob(Job job, ByteChannel byteChannel) {
        Intrinsics.checkNotNullParameter(job, "delegate");
        Intrinsics.checkNotNullParameter(byteChannel, "channel");
        this.f9079a = job;
        this.b = byteChannel;
    }

    public ChildHandle N(ChildJob childJob) {
        Intrinsics.checkNotNullParameter(childJob, "child");
        return this.f9079a.N(childJob);
    }

    public DisposableHandle S(boolean z, boolean z2, Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "handler");
        return this.f9079a.S(z, z2, function1);
    }

    public CancellationException U() {
        return this.f9079a.U();
    }

    public void a(CancellationException cancellationException) {
        this.f9079a.a(cancellationException);
    }

    /* renamed from: e */
    public ByteChannel b() {
        return this.b;
    }

    public Object fold(Object obj, Function2 function2) {
        Intrinsics.checkNotNullParameter(function2, "operation");
        return this.f9079a.fold(obj, function2);
    }

    public CoroutineContext.Element get(CoroutineContext.Key key) {
        Intrinsics.checkNotNullParameter(key, IntentKey.ACTIVITY.ACTION_KEY);
        return this.f9079a.get(key);
    }

    public CoroutineContext.Key getKey() {
        return this.f9079a.getKey();
    }

    public Job getParent() {
        return this.f9079a.getParent();
    }

    public Object i0(Continuation continuation) {
        return this.f9079a.i0(continuation);
    }

    public boolean isActive() {
        return this.f9079a.isActive();
    }

    public boolean isCancelled() {
        return this.f9079a.isCancelled();
    }

    public boolean isCompleted() {
        return this.f9079a.isCompleted();
    }

    public CoroutineContext minusKey(CoroutineContext.Key key) {
        Intrinsics.checkNotNullParameter(key, IntentKey.ACTIVITY.ACTION_KEY);
        return this.f9079a.minusKey(key);
    }

    public CoroutineContext plus(CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(coroutineContext, "context");
        return this.f9079a.plus(coroutineContext);
    }

    public DisposableHandle r(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "handler");
        return this.f9079a.r(function1);
    }

    public boolean start() {
        return this.f9079a.start();
    }

    public String toString() {
        return "ChannelJob[" + this.f9079a + ']';
    }
}
