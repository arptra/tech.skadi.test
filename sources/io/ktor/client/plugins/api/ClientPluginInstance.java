package io.ktor.client.plugins.api;

import io.ktor.client.HttpClient;
import io.ktor.util.AttributeKey;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00060\u0003j\u0002`\u0004B8\b\u0000\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u001d\u0010\f\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0005\u001a\u00028\u00008\u0000X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0007\u001a\u00020\u00068\u0000X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR1\u0010\f\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000b8\u0000X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\n0 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lio/ktor/client/plugins/api/ClientPluginInstance;", "", "PluginConfig", "Ljava/io/Closeable;", "Lio/ktor/utils/io/core/Closeable;", "config", "", "name", "Lkotlin/Function1;", "Lio/ktor/client/plugins/api/ClientPluginBuilder;", "", "Lkotlin/ExtensionFunctionType;", "body", "<init>", "(Ljava/lang/Object;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "Lio/ktor/client/HttpClient;", "scope", "a", "(Lio/ktor/client/HttpClient;)V", "close", "()V", "Ljava/lang/Object;", "getConfig$ktor_client_core", "()Ljava/lang/Object;", "b", "Ljava/lang/String;", "getName$ktor_client_core", "()Ljava/lang/String;", "c", "Lkotlin/jvm/functions/Function1;", "getBody$ktor_client_core", "()Lkotlin/jvm/functions/Function1;", "Lkotlin/Function0;", "d", "Lkotlin/jvm/functions/Function0;", "onClose", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nClientPluginInstance.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClientPluginInstance.kt\nio/ktor/client/plugins/api/ClientPluginInstance\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,33:1\n1855#2,2:34\n*S KotlinDebug\n*F\n+ 1 ClientPluginInstance.kt\nio/ktor/client/plugins/api/ClientPluginInstance\n*L\n26#1:34,2\n*E\n"})
public final class ClientPluginInstance<PluginConfig> implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public final Object f8875a;
    public final String b;
    public final Function1 c;
    public Function0 d = ClientPluginInstance$onClose$1.INSTANCE;

    public ClientPluginInstance(Object obj, String str, Function1 function1) {
        Intrinsics.checkNotNullParameter(obj, "config");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function1, "body");
        this.f8875a = obj;
        this.b = str;
        this.c = function1;
    }

    public final void a(HttpClient httpClient) {
        Intrinsics.checkNotNullParameter(httpClient, "scope");
        ClientPluginBuilder clientPluginBuilder = new ClientPluginBuilder(new AttributeKey(this.b), httpClient, this.f8875a);
        this.c.invoke(clientPluginBuilder);
        this.d = clientPluginBuilder.b();
        for (HookHandler a2 : clientPluginBuilder.a()) {
            a2.a(httpClient);
        }
    }

    public void close() {
        this.d.invoke();
    }
}
