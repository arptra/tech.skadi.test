package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.engine.HttpClientEngineCapability;
import io.ktor.util.AttributeKey;
import io.ktor.util.KtorDsl;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \u000f2\u00020\u0001:\u0002\u0010\u0011B'\b\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\f¨\u0006\u0012"}, d2 = {"Lio/ktor/client/plugins/HttpTimeout;", "", "", "requestTimeoutMillis", "connectTimeoutMillis", "socketTimeoutMillis", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "", "f", "()Z", "a", "Ljava/lang/Long;", "b", "c", "d", "HttpTimeoutCapabilityConfiguration", "Plugin", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
public final class HttpTimeout {
    public static final Plugin d = new Plugin((DefaultConstructorMarker) null);
    public static final AttributeKey e = new AttributeKey("TimeoutPlugin");

    /* renamed from: a  reason: collision with root package name */
    public final Long f8867a;
    public final Long b;
    public final Long c;

    @KtorDsl
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001!B-\b\u0016\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0015R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0015R(\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00028F@FX\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR(\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00028F@FX\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u001b\"\u0004\b\u001e\u0010\u001dR(\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00028F@FX\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001d¨\u0006\""}, d2 = {"Lio/ktor/client/plugins/HttpTimeout$HttpTimeoutCapabilityConfiguration;", "", "", "requestTimeoutMillis", "connectTimeoutMillis", "socketTimeoutMillis", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "Lio/ktor/client/plugins/HttpTimeout;", "a", "()Lio/ktor/client/plugins/HttpTimeout;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "value", "b", "(Ljava/lang/Long;)Ljava/lang/Long;", "Ljava/lang/Long;", "_requestTimeoutMillis", "_connectTimeoutMillis", "c", "_socketTimeoutMillis", "d", "()Ljava/lang/Long;", "g", "(Ljava/lang/Long;)V", "f", "e", "h", "Companion", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
    public static final class HttpTimeoutCapabilityConfiguration {
        public static final Companion d = new Companion((DefaultConstructorMarker) null);
        public static final AttributeKey e = new AttributeKey("TimeoutConfiguration");

        /* renamed from: a  reason: collision with root package name */
        public Long f8868a;
        public Long b;
        public Long c;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/ktor/client/plugins/HttpTimeout$HttpTimeoutCapabilityConfiguration$Companion;", "", "<init>", "()V", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public Companion() {
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ HttpTimeoutCapabilityConfiguration(Long l, Long l2, Long l3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : l2, (i & 4) != 0 ? null : l3);
        }

        public final HttpTimeout a() {
            return new HttpTimeout(d(), c(), e(), (DefaultConstructorMarker) null);
        }

        public final Long b(Long l) {
            if (l == null || l.longValue() > 0) {
                return l;
            }
            throw new IllegalArgumentException("Only positive timeout values are allowed, for infinite timeout use HttpTimeout.INFINITE_TIMEOUT_MS".toString());
        }

        public final Long c() {
            return this.b;
        }

        public final Long d() {
            return this.f8868a;
        }

        public final Long e() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || HttpTimeoutCapabilityConfiguration.class != obj.getClass()) {
                return false;
            }
            HttpTimeoutCapabilityConfiguration httpTimeoutCapabilityConfiguration = (HttpTimeoutCapabilityConfiguration) obj;
            return Intrinsics.areEqual((Object) this.f8868a, (Object) httpTimeoutCapabilityConfiguration.f8868a) && Intrinsics.areEqual((Object) this.b, (Object) httpTimeoutCapabilityConfiguration.b) && Intrinsics.areEqual((Object) this.c, (Object) httpTimeoutCapabilityConfiguration.c);
        }

        public final void f(Long l) {
            this.b = b(l);
        }

        public final void g(Long l) {
            this.f8868a = b(l);
        }

        public final void h(Long l) {
            this.c = b(l);
        }

        public int hashCode() {
            Long l = this.f8868a;
            int i = 0;
            int hashCode = (l != null ? l.hashCode() : 0) * 31;
            Long l2 = this.b;
            int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
            Long l3 = this.c;
            if (l3 != null) {
                i = l3.hashCode();
            }
            return hashCode2 + i;
        }

        public HttpTimeoutCapabilityConfiguration(Long l, Long l2, Long l3) {
            this.f8868a = 0L;
            this.b = 0L;
            this.c = 0L;
            g(l);
            f(l2);
            h(l3);
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u0004B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J(\u0010\u000b\u001a\u00020\u00032\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00128\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0006XT¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lio/ktor/client/plugins/HttpTimeout$Plugin;", "Lio/ktor/client/plugins/HttpClientPlugin;", "Lio/ktor/client/plugins/HttpTimeout$HttpTimeoutCapabilityConfiguration;", "Lio/ktor/client/plugins/HttpTimeout;", "Lio/ktor/client/engine/HttpClientEngineCapability;", "<init>", "()V", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "d", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/client/plugins/HttpTimeout;", "plugin", "Lio/ktor/client/HttpClient;", "scope", "c", "(Lio/ktor/client/plugins/HttpTimeout;Lio/ktor/client/HttpClient;)V", "Lio/ktor/util/AttributeKey;", "key", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "", "INFINITE_TIMEOUT_MS", "J", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
    public static final class Plugin implements HttpClientPlugin<HttpTimeoutCapabilityConfiguration, HttpTimeout>, HttpClientEngineCapability<HttpTimeoutCapabilityConfiguration> {
        public /* synthetic */ Plugin(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: c */
        public void b(HttpTimeout httpTimeout, HttpClient httpClient) {
            Intrinsics.checkNotNullParameter(httpTimeout, "plugin");
            Intrinsics.checkNotNullParameter(httpClient, "scope");
            ((HttpSend) HttpClientPluginKt.b(httpClient, HttpSend.c)).d(new HttpTimeout$Plugin$install$1(httpTimeout, httpClient, (Continuation<? super HttpTimeout$Plugin$install$1>) null));
        }

        /* renamed from: d */
        public HttpTimeout a(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            HttpTimeoutCapabilityConfiguration httpTimeoutCapabilityConfiguration = new HttpTimeoutCapabilityConfiguration((Long) null, (Long) null, (Long) null, 7, (DefaultConstructorMarker) null);
            function1.invoke(httpTimeoutCapabilityConfiguration);
            return httpTimeoutCapabilityConfiguration.a();
        }

        public AttributeKey getKey() {
            return HttpTimeout.e;
        }

        public Plugin() {
        }
    }

    public /* synthetic */ HttpTimeout(Long l, Long l2, Long l3, DefaultConstructorMarker defaultConstructorMarker) {
        this(l, l2, l3);
    }

    public final boolean f() {
        return (this.f8867a == null && this.b == null && this.c == null) ? false : true;
    }

    public HttpTimeout(Long l, Long l2, Long l3) {
        this.f8867a = l;
        this.b = l2;
        this.c = l3;
    }
}
