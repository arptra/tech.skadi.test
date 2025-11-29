package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.util.AttributeKey;
import io.ktor.util.KtorDsl;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \b2\u00020\u0001:\u0002\n\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lio/ktor/client/plugins/UserAgent;", "", "", "agent", "<init>", "(Ljava/lang/String;)V", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "Config", "Plugin", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
public final class UserAgent {
    public static final Plugin b = new Plugin((DefaultConstructorMarker) null);
    public static final AttributeKey c = new AttributeKey("UserAgent");

    /* renamed from: a  reason: collision with root package name */
    public final String f8871a;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\n\u001a\u00020\u00032\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00118\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lio/ktor/client/plugins/UserAgent$Plugin;", "Lio/ktor/client/plugins/HttpClientPlugin;", "Lio/ktor/client/plugins/UserAgent$Config;", "Lio/ktor/client/plugins/UserAgent;", "<init>", "()V", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "d", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/client/plugins/UserAgent;", "plugin", "Lio/ktor/client/HttpClient;", "scope", "c", "(Lio/ktor/client/plugins/UserAgent;Lio/ktor/client/HttpClient;)V", "Lio/ktor/util/AttributeKey;", "key", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
    public static final class Plugin implements HttpClientPlugin<Config, UserAgent> {
        public /* synthetic */ Plugin(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: c */
        public void b(UserAgent userAgent, HttpClient httpClient) {
            Intrinsics.checkNotNullParameter(userAgent, "plugin");
            Intrinsics.checkNotNullParameter(httpClient, "scope");
            httpClient.n().l(HttpRequestPipeline.g.d(), new UserAgent$Plugin$install$1(userAgent, (Continuation<? super UserAgent$Plugin$install$1>) null));
        }

        /* renamed from: d */
        public UserAgent a(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            Config config = new Config((String) null, 1, (DefaultConstructorMarker) null);
            function1.invoke(config);
            return new UserAgent(config.a(), (DefaultConstructorMarker) null);
        }

        public AttributeKey getKey() {
            return UserAgent.c;
        }

        public Plugin() {
        }
    }

    public /* synthetic */ UserAgent(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public final String b() {
        return this.f8871a;
    }

    @KtorDsl
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\u0005¨\u0006\n"}, d2 = {"Lio/ktor/client/plugins/UserAgent$Config;", "", "", "agent", "<init>", "(Ljava/lang/String;)V", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "b", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
    public static final class Config {

        /* renamed from: a  reason: collision with root package name */
        public String f8872a;

        public Config(String str) {
            Intrinsics.checkNotNullParameter(str, "agent");
            this.f8872a = str;
        }

        public final String a() {
            return this.f8872a;
        }

        public final void b(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.f8872a = str;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Config(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "Ktor http-client" : str);
        }
    }

    public UserAgent(String str) {
        this.f8871a = str;
    }
}
