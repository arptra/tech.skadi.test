package io.ktor.client.plugins.api;

import io.ktor.client.HttpClient;
import io.ktor.util.AttributeKey;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J.\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\b\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\f\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rR&\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u000e8\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"io/ktor/client/plugins/api/CreatePluginUtilsKt$createClientPlugin$1", "Lio/ktor/client/plugins/api/ClientPlugin;", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "Lio/ktor/client/plugins/api/ClientPluginInstance;", "d", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/client/plugins/api/ClientPluginInstance;", "plugin", "Lio/ktor/client/HttpClient;", "scope", "c", "(Lio/ktor/client/plugins/api/ClientPluginInstance;Lio/ktor/client/HttpClient;)V", "Lio/ktor/util/AttributeKey;", "a", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "key", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
public final class CreatePluginUtilsKt$createClientPlugin$1 implements ClientPlugin<Object> {

    /* renamed from: a  reason: collision with root package name */
    public final AttributeKey f8876a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Function0 c;
    public final /* synthetic */ Function1 d;

    /* renamed from: c */
    public void b(ClientPluginInstance clientPluginInstance, HttpClient httpClient) {
        Intrinsics.checkNotNullParameter(clientPluginInstance, "plugin");
        Intrinsics.checkNotNullParameter(httpClient, "scope");
        clientPluginInstance.a(httpClient);
    }

    /* renamed from: d */
    public ClientPluginInstance a(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        Object invoke = this.c.invoke();
        function1.invoke(invoke);
        return new ClientPluginInstance(invoke, this.b, this.d);
    }

    public AttributeKey getKey() {
        return this.f8876a;
    }
}
