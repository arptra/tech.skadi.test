package io.ktor.client.plugins.api;

import io.ktor.client.HttpClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\tR\u0014\u0010\r\u001a\u00028\u00008\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lio/ktor/client/plugins/api/HookHandler;", "T", "", "Lio/ktor/client/HttpClient;", "client", "", "a", "(Lio/ktor/client/HttpClient;)V", "Lio/ktor/client/plugins/api/ClientHook;", "Lio/ktor/client/plugins/api/ClientHook;", "hook", "b", "Ljava/lang/Object;", "handler", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
public final class HookHandler<T> {

    /* renamed from: a  reason: collision with root package name */
    public final ClientHook f8877a;
    public final Object b;

    public final void a(HttpClient httpClient) {
        Intrinsics.checkNotNullParameter(httpClient, "client");
        this.f8877a.a(httpClient, this.b);
    }
}
