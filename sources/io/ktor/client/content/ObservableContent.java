package io.ktor.client.content;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.ktor.client.call.UnsupportedContentTypeException;
import io.ktor.client.utils.ByteChannelUtilsKt;
import io.ktor.http.ContentType;
import io.ktor.http.Headers;
import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteChannelCtorKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.CoroutinesKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.GlobalScope;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001Bb\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012F\u0010\u000f\u001aB\b\u0001\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0006ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018RW\u0010\u000f\u001aB\b\u0001\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00068\u0002X\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\u00128\u0002X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001b\u0012\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u0004\u0018\u00010\u001f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010 R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\"R\u0014\u0010%\u001a\u00020#8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010$\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, d2 = {"Lio/ktor/client/content/ObservableContent;", "Lio/ktor/http/content/OutgoingContent$ReadChannelContent;", "Lio/ktor/http/content/OutgoingContent;", "delegate", "Lkotlin/coroutines/CoroutineContext;", "callContext", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "bytesSentTotal", "contentLength", "Lkotlin/coroutines/Continuation;", "", "", "listener", "<init>", "(Lio/ktor/http/content/OutgoingContent;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function3;)V", "Lio/ktor/utils/io/ByteReadChannel;", "d", "()Lio/ktor/utils/io/ByteReadChannel;", "a", "Lio/ktor/http/content/OutgoingContent;", "b", "Lkotlin/coroutines/CoroutineContext;", "c", "Lkotlin/jvm/functions/Function3;", "Lio/ktor/utils/io/ByteReadChannel;", "getContent$annotations", "()V", "content", "Lio/ktor/http/ContentType;", "()Lio/ktor/http/ContentType;", "contentType", "()Ljava/lang/Long;", "Lio/ktor/http/Headers;", "()Lio/ktor/http/Headers;", "headers", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
public final class ObservableContent extends OutgoingContent.ReadChannelContent {

    /* renamed from: a  reason: collision with root package name */
    public final OutgoingContent f8822a;
    public final CoroutineContext b;
    public final Function3 c;
    public final ByteReadChannel d;

    public ObservableContent(OutgoingContent outgoingContent, CoroutineContext coroutineContext, Function3 function3) {
        ByteReadChannel byteReadChannel;
        Intrinsics.checkNotNullParameter(outgoingContent, "delegate");
        Intrinsics.checkNotNullParameter(coroutineContext, "callContext");
        Intrinsics.checkNotNullParameter(function3, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f8822a = outgoingContent;
        this.b = coroutineContext;
        this.c = function3;
        if (outgoingContent instanceof OutgoingContent.ByteArrayContent) {
            byteReadChannel = ByteChannelCtorKt.a(((OutgoingContent.ByteArrayContent) outgoingContent).d());
        } else if (outgoingContent instanceof OutgoingContent.ProtocolUpgrade) {
            throw new UnsupportedContentTypeException(outgoingContent);
        } else if (outgoingContent instanceof OutgoingContent.NoContent) {
            byteReadChannel = ByteReadChannel.f9077a.a();
        } else if (outgoingContent instanceof OutgoingContent.ReadChannelContent) {
            byteReadChannel = ((OutgoingContent.ReadChannelContent) outgoingContent).d();
        } else if (outgoingContent instanceof OutgoingContent.WriteChannelContent) {
            byteReadChannel = CoroutinesKt.b(GlobalScope.f3732a, coroutineContext, true, new ObservableContent$content$1(this, (Continuation<? super ObservableContent$content$1>) null)).b();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        this.d = byteReadChannel;
    }

    public Long a() {
        return this.f8822a.a();
    }

    public ContentType b() {
        return this.f8822a.b();
    }

    public Headers c() {
        return this.f8822a.c();
    }

    public ByteReadChannel d() {
        return ByteChannelUtilsKt.a(this.d, this.b, a(), this.c);
    }
}
