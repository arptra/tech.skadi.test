package io.ktor.client.request;

import io.ktor.http.content.OutgoingContent;
import io.ktor.util.InternalAPI;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\t\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lio/ktor/client/request/ClientUpgradeContent;", "Lio/ktor/http/content/OutgoingContent$NoContent;", "<init>", "()V", "Lio/ktor/utils/io/ByteChannel;", "a", "Lkotlin/Lazy;", "getContent", "()Lio/ktor/utils/io/ByteChannel;", "content", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
@InternalAPI
public abstract class ClientUpgradeContent extends OutgoingContent.NoContent {

    /* renamed from: a  reason: collision with root package name */
    public final Lazy f8914a = LazyKt.lazy(ClientUpgradeContent$content$2.INSTANCE);
}
