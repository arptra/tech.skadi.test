package io.ktor.client.plugins.api;

import com.upuphone.runasone.relay.api.IntentKey;
import io.ktor.client.HttpClient;
import io.ktor.util.AttributeKey;
import io.ktor.util.KtorDsl;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B-\b\u0000\u0012\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0004\b\t\u0010\nR&\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00038\u0000X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\b\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R$\u0010\u001c\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00180\u00178\u0000X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u000b\u0010\u001bR(\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u000f\u0010!\"\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lio/ktor/client/plugins/api/ClientPluginBuilder;", "", "PluginConfig", "Lio/ktor/util/AttributeKey;", "Lio/ktor/client/plugins/api/ClientPluginInstance;", "key", "Lio/ktor/client/HttpClient;", "client", "pluginConfig", "<init>", "(Lio/ktor/util/AttributeKey;Lio/ktor/client/HttpClient;Ljava/lang/Object;)V", "a", "Lio/ktor/util/AttributeKey;", "getKey$ktor_client_core", "()Lio/ktor/util/AttributeKey;", "b", "Lio/ktor/client/HttpClient;", "getClient", "()Lio/ktor/client/HttpClient;", "c", "Ljava/lang/Object;", "getPluginConfig", "()Ljava/lang/Object;", "", "Lio/ktor/client/plugins/api/HookHandler;", "d", "Ljava/util/List;", "()Ljava/util/List;", "hooks", "Lkotlin/Function0;", "", "e", "Lkotlin/jvm/functions/Function0;", "()Lkotlin/jvm/functions/Function0;", "setOnClose$ktor_client_core", "(Lkotlin/jvm/functions/Function0;)V", "onClose", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
@KtorDsl
public final class ClientPluginBuilder<PluginConfig> {

    /* renamed from: a  reason: collision with root package name */
    public final AttributeKey f8874a;
    public final HttpClient b;
    public final Object c;
    public final List d = new ArrayList();
    public Function0 e = ClientPluginBuilder$onClose$1.INSTANCE;

    public ClientPluginBuilder(AttributeKey attributeKey, HttpClient httpClient, Object obj) {
        Intrinsics.checkNotNullParameter(attributeKey, IntentKey.ACTIVITY.ACTION_KEY);
        Intrinsics.checkNotNullParameter(httpClient, "client");
        Intrinsics.checkNotNullParameter(obj, "pluginConfig");
        this.f8874a = attributeKey;
        this.b = httpClient;
        this.c = obj;
    }

    public final List a() {
        return this.d;
    }

    public final Function0 b() {
        return this.e;
    }
}
