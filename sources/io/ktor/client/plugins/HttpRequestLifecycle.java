package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.util.AttributeKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00042\u00020\u0001:\u0001\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lio/ktor/client/plugins/HttpRequestLifecycle;", "", "<init>", "()V", "a", "Plugin", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
public final class HttpRequestLifecycle {

    /* renamed from: a  reason: collision with root package name */
    public static final Plugin f8854a = new Plugin((DefaultConstructorMarker) null);
    public static final AttributeKey b = new AttributeKey("RequestLifecycle");

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\t\u001a\u00020\u00032\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0002\b\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00108\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lio/ktor/client/plugins/HttpRequestLifecycle$Plugin;", "Lio/ktor/client/plugins/HttpClientPlugin;", "", "Lio/ktor/client/plugins/HttpRequestLifecycle;", "<init>", "()V", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "block", "d", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/client/plugins/HttpRequestLifecycle;", "plugin", "Lio/ktor/client/HttpClient;", "scope", "c", "(Lio/ktor/client/plugins/HttpRequestLifecycle;Lio/ktor/client/HttpClient;)V", "Lio/ktor/util/AttributeKey;", "key", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
    public static final class Plugin implements HttpClientPlugin<Unit, HttpRequestLifecycle> {
        public /* synthetic */ Plugin(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: c */
        public void b(HttpRequestLifecycle httpRequestLifecycle, HttpClient httpClient) {
            Intrinsics.checkNotNullParameter(httpRequestLifecycle, "plugin");
            Intrinsics.checkNotNullParameter(httpClient, "scope");
            httpClient.n().l(HttpRequestPipeline.g.a(), new HttpRequestLifecycle$Plugin$install$1(httpClient, (Continuation<? super HttpRequestLifecycle$Plugin$install$1>) null));
        }

        /* renamed from: d */
        public HttpRequestLifecycle a(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            return new HttpRequestLifecycle((DefaultConstructorMarker) null);
        }

        public AttributeKey getKey() {
            return HttpRequestLifecycle.b;
        }

        public Plugin() {
        }
    }

    public /* synthetic */ HttpRequestLifecycle(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public HttpRequestLifecycle() {
    }
}
