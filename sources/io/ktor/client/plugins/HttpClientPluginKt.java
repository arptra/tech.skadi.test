package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a;\u0010\u0006\u001a\u0004\u0018\u00018\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\u00020\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a9\u0010\b\u001a\u00028\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\u00020\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0004\b\b\u0010\u0007\" \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0000X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r¨\u0006\u000f"}, d2 = {"", "B", "F", "Lio/ktor/client/HttpClient;", "Lio/ktor/client/plugins/HttpClientPlugin;", "plugin", "c", "(Lio/ktor/client/HttpClient;Lio/ktor/client/plugins/HttpClientPlugin;)Ljava/lang/Object;", "b", "Lio/ktor/util/AttributeKey;", "Lio/ktor/util/Attributes;", "a", "Lio/ktor/util/AttributeKey;", "()Lio/ktor/util/AttributeKey;", "PLUGIN_INSTALLED_LIST", "ktor-client-core"}, k = 2, mv = {1, 8, 0})
public final class HttpClientPluginKt {

    /* renamed from: a  reason: collision with root package name */
    public static final AttributeKey f8847a = new AttributeKey("ApplicationPluginRegistry");

    public static final AttributeKey a() {
        return f8847a;
    }

    public static final Object b(HttpClient httpClient, HttpClientPlugin httpClientPlugin) {
        Intrinsics.checkNotNullParameter(httpClient, "<this>");
        Intrinsics.checkNotNullParameter(httpClientPlugin, "plugin");
        Object c = c(httpClient, httpClientPlugin);
        if (c != null) {
            return c;
        }
        throw new IllegalStateException("Plugin " + httpClientPlugin + " is not installed. Consider using `install(" + httpClientPlugin.getKey() + ")` in client config first.");
    }

    public static final Object c(HttpClient httpClient, HttpClientPlugin httpClientPlugin) {
        Intrinsics.checkNotNullParameter(httpClient, "<this>");
        Intrinsics.checkNotNullParameter(httpClientPlugin, "plugin");
        Attributes attributes = (Attributes) httpClient.J().e(f8847a);
        if (attributes != null) {
            return attributes.e(httpClientPlugin.getKey());
        }
        return null;
    }
}
