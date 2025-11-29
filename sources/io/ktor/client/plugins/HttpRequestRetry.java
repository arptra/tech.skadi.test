package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.events.EventDefinition;
import io.ktor.util.AttributeKey;
import io.ktor.util.KtorDsl;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 42\u00020\u0001:\u000656789:B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\t\u0010\nJL\u0010\u0017\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2#\u0010\u0014\u001a\u001f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u000e¢\u0006\u0002\b\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018JT\u0010\u001d\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2#\u0010\u0014\u001a\u001f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00120\u000e¢\u0006\u0002\b\u00132\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u0019H\u0002¢\u0006\u0004\b \u0010!R1\u0010\u0014\u001a\u001f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u000e¢\u0006\u0002\b\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R1\u0010%\u001a\u001f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00120\u000e¢\u0006\u0002\b\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010#R+\u0010+\u001a\u0019\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020(0&¢\u0006\u0002\b\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R3\u0010.\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0,\u0012\u0006\u0012\u0004\u0018\u00010\u00010&8\u0002X\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b-\u0010*R\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R+\u00103\u001a\u0019\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\b0&¢\u0006\u0002\b\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u0010*\u0002\u0004\n\u0002\b\u0019¨\u0006;"}, d2 = {"Lio/ktor/client/plugins/HttpRequestRetry;", "", "Lio/ktor/client/plugins/HttpRequestRetry$Configuration;", "configuration", "<init>", "(Lio/ktor/client/plugins/HttpRequestRetry$Configuration;)V", "Lio/ktor/client/HttpClient;", "client", "", "l", "(Lio/ktor/client/HttpClient;)V", "", "retryCount", "maxRetries", "Lkotlin/Function3;", "Lio/ktor/client/plugins/HttpRequestRetry$ShouldRetryContext;", "Lio/ktor/client/request/HttpRequest;", "Lio/ktor/client/statement/HttpResponse;", "", "Lkotlin/ExtensionFunctionType;", "shouldRetry", "Lio/ktor/client/call/HttpClientCall;", "call", "n", "(IILkotlin/jvm/functions/Function3;Lio/ktor/client/call/HttpClientCall;)Z", "Lio/ktor/client/request/HttpRequestBuilder;", "", "subRequest", "cause", "o", "(IILkotlin/jvm/functions/Function3;Lio/ktor/client/request/HttpRequestBuilder;Ljava/lang/Throwable;)Z", "request", "m", "(Lio/ktor/client/request/HttpRequestBuilder;)Lio/ktor/client/request/HttpRequestBuilder;", "a", "Lkotlin/jvm/functions/Function3;", "b", "shouldRetryOnException", "Lkotlin/Function2;", "Lio/ktor/client/plugins/HttpRequestRetry$DelayContext;", "", "c", "Lkotlin/jvm/functions/Function2;", "delayMillis", "Lkotlin/coroutines/Continuation;", "d", "delay", "e", "I", "Lio/ktor/client/plugins/HttpRequestRetry$ModifyRequestContext;", "f", "modifyRequest", "g", "Configuration", "DelayContext", "ModifyRequestContext", "Plugin", "RetryEventData", "ShouldRetryContext", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
public final class HttpRequestRetry {
    public static final Plugin g = new Plugin((DefaultConstructorMarker) null);
    public static final AttributeKey h = new AttributeKey("RetryFeature");
    public static final EventDefinition i = new EventDefinition();

    /* renamed from: a  reason: collision with root package name */
    public final Function3 f8856a;
    public final Function3 b;
    public final Function2 c;
    public final Function2 d;
    public final int e;
    public final Function2 f;

    @KtorDsl
    @Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J<\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\t\u001a\u00020\b2#\u0010\u0010\u001a\u001f\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\n¢\u0006\u0002\b\u000f¢\u0006\u0004\b\u0012\u0010\u0013J<\u0010\u0016\u001a\u00020\u00112\b\b\u0002\u0010\t\u001a\u00020\b2#\u0010\u0010\u001a\u001f\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000e0\n¢\u0006\u0002\b\u000f¢\u0006\u0004\b\u0016\u0010\u0013J!\u0010\u0018\u001a\u00020\u00112\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\u000e¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00112\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00112\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u001c\u0010\u001bJE\u0010#\u001a\u00020\u00112\b\b\u0002\u0010\u001d\u001a\u00020\u000e2,\u0010\u0010\u001a(\u0012\u0004\u0012\u00020\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00040\u001e¢\u0006\u0002\b\u000f¢\u0006\u0004\b#\u0010$J5\u0010(\u001a\u00020\u00112\b\b\u0002\u0010&\u001a\u00020%2\b\b\u0002\u0010'\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u001d\u001a\u00020\u000e¢\u0006\u0004\b(\u0010)R?\u00100\u001a\u001f\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\n¢\u0006\u0002\b\u000f8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R?\u00103\u001a\u001f\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000e0\n¢\u0006\u0002\b\u000f8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b#\u0010+\u001a\u0004\b1\u0010-\"\u0004\b2\u0010/R9\u00109\u001a\u0019\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u001e¢\u0006\u0002\b\u000f8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b(\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R9\u0010>\u001a\u0019\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u001e¢\u0006\u0002\b\u000f8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b;\u00104\u001a\u0004\b<\u00106\"\u0004\b=\u00108RA\u0010B\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110?\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001e8\u0000@\u0000X\u000eø\u0001\u0000¢\u0006\u0012\n\u0004\b@\u00104\u001a\u0004\b@\u00106\"\u0004\bA\u00108R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b5\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010\u001b\u0002\u0004\n\u0002\b\u0019¨\u0006G"}, d2 = {"Lio/ktor/client/plugins/HttpRequestRetry$Configuration;", "", "<init>", "()V", "", "randomizationMs", "k", "(J)J", "", "maxRetries", "Lkotlin/Function3;", "Lio/ktor/client/plugins/HttpRequestRetry$ShouldRetryContext;", "Lio/ktor/client/request/HttpRequest;", "Lio/ktor/client/statement/HttpResponse;", "", "Lkotlin/ExtensionFunctionType;", "block", "", "l", "(ILkotlin/jvm/functions/Function3;)V", "Lio/ktor/client/request/HttpRequestBuilder;", "", "o", "retryOnTimeout", "m", "(IZ)V", "q", "(I)V", "p", "respectRetryAfterHeader", "Lkotlin/Function2;", "Lio/ktor/client/plugins/HttpRequestRetry$DelayContext;", "Lkotlin/ParameterName;", "name", "retry", "b", "(ZLkotlin/jvm/functions/Function2;)V", "", "base", "maxDelayMs", "c", "(DJJZ)V", "a", "Lkotlin/jvm/functions/Function3;", "i", "()Lkotlin/jvm/functions/Function3;", "s", "(Lkotlin/jvm/functions/Function3;)V", "shouldRetry", "j", "t", "shouldRetryOnException", "Lkotlin/jvm/functions/Function2;", "f", "()Lkotlin/jvm/functions/Function2;", "r", "(Lkotlin/jvm/functions/Function2;)V", "delayMillis", "Lio/ktor/client/plugins/HttpRequestRetry$ModifyRequestContext;", "d", "h", "setModifyRequest$ktor_client_core", "modifyRequest", "Lkotlin/coroutines/Continuation;", "e", "setDelay$ktor_client_core", "delay", "I", "g", "()I", "setMaxRetries", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
    public static final class Configuration {

        /* renamed from: a  reason: collision with root package name */
        public Function3 f8857a;
        public Function3 b;
        public Function2 c;
        public Function2 d = HttpRequestRetry$Configuration$modifyRequest$1.INSTANCE;
        public Function2 e = new HttpRequestRetry$Configuration$delay$1((Continuation<? super HttpRequestRetry$Configuration$delay$1>) null);
        public int f;

        public Configuration() {
            p(3);
            d(this, 0.0d, 0, 0, false, 15, (Object) null);
        }

        public static /* synthetic */ void d(Configuration configuration, double d2, long j, long j2, boolean z, int i, Object obj) {
            configuration.c((i & 1) != 0 ? 2.0d : d2, (i & 2) != 0 ? 60000 : j, (i & 4) != 0 ? 1000 : j2, (i & 8) != 0 ? true : z);
        }

        public static /* synthetic */ void n(Configuration configuration, int i, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = -1;
            }
            if ((i2 & 2) != 0) {
                z = false;
            }
            configuration.m(i, z);
        }

        public final void b(boolean z, Function2 function2) {
            Intrinsics.checkNotNullParameter(function2, "block");
            r(new HttpRequestRetry$Configuration$delayMillis$1(z, function2));
        }

        public final void c(double d2, long j, long j2, boolean z) {
            if (d2 <= 0.0d) {
                throw new IllegalStateException("Check failed.".toString());
            } else if (j <= 0) {
                throw new IllegalStateException("Check failed.".toString());
            } else if (j2 >= 0) {
                b(z, new HttpRequestRetry$Configuration$exponentialDelay$1(d2, j, this, j2));
            } else {
                throw new IllegalStateException("Check failed.".toString());
            }
        }

        public final Function2 e() {
            return this.e;
        }

        public final Function2 f() {
            Function2 function2 = this.c;
            if (function2 != null) {
                return function2;
            }
            Intrinsics.throwUninitializedPropertyAccessException("delayMillis");
            return null;
        }

        public final int g() {
            return this.f;
        }

        public final Function2 h() {
            return this.d;
        }

        public final Function3 i() {
            Function3 function3 = this.f8857a;
            if (function3 != null) {
                return function3;
            }
            Intrinsics.throwUninitializedPropertyAccessException("shouldRetry");
            return null;
        }

        public final Function3 j() {
            Function3 function3 = this.b;
            if (function3 != null) {
                return function3;
            }
            Intrinsics.throwUninitializedPropertyAccessException("shouldRetryOnException");
            return null;
        }

        public final long k(long j) {
            if (j == 0) {
                return 0;
            }
            return Random.Default.nextLong(j);
        }

        public final void l(int i, Function3 function3) {
            Intrinsics.checkNotNullParameter(function3, "block");
            if (i != -1) {
                this.f = i;
            }
            s(function3);
        }

        public final void m(int i, boolean z) {
            o(i, new HttpRequestRetry$Configuration$retryOnException$1(z));
        }

        public final void o(int i, Function3 function3) {
            Intrinsics.checkNotNullParameter(function3, "block");
            if (i != -1) {
                this.f = i;
            }
            t(function3);
        }

        public final void p(int i) {
            q(i);
            n(this, i, false, 2, (Object) null);
        }

        public final void q(int i) {
            l(i, HttpRequestRetry$Configuration$retryOnServerErrors$1.INSTANCE);
        }

        public final void r(Function2 function2) {
            Intrinsics.checkNotNullParameter(function2, "<set-?>");
            this.c = function2;
        }

        public final void s(Function3 function3) {
            Intrinsics.checkNotNullParameter(function3, "<set-?>");
            this.f8857a = function3;
        }

        public final void t(Function3 function3) {
            Intrinsics.checkNotNullParameter(function3, "<set-?>");
            this.b = function3;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u000f\u0018\u00002\u00020\u0001B%\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u0010R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lio/ktor/client/plugins/HttpRequestRetry$DelayContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "request", "Lio/ktor/client/statement/HttpResponse;", "response", "", "cause", "<init>", "(Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/client/statement/HttpResponse;Ljava/lang/Throwable;)V", "a", "Lio/ktor/client/request/HttpRequestBuilder;", "getRequest", "()Lio/ktor/client/request/HttpRequestBuilder;", "b", "Lio/ktor/client/statement/HttpResponse;", "()Lio/ktor/client/statement/HttpResponse;", "c", "Ljava/lang/Throwable;", "getCause", "()Ljava/lang/Throwable;", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
    public static final class DelayContext {

        /* renamed from: a  reason: collision with root package name */
        public final HttpRequestBuilder f8858a;
        public final HttpResponse b;
        public final Throwable c;

        public DelayContext(HttpRequestBuilder httpRequestBuilder, HttpResponse httpResponse, Throwable th) {
            Intrinsics.checkNotNullParameter(httpRequestBuilder, "request");
            this.f8858a = httpRequestBuilder;
            this.b = httpResponse;
            this.c = th;
        }

        public final HttpResponse a() {
            return this.b;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\u0018\u00002\u00020\u0001B-\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lio/ktor/client/plugins/HttpRequestRetry$ModifyRequestContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "request", "Lio/ktor/client/statement/HttpResponse;", "response", "", "cause", "", "retryCount", "<init>", "(Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/client/statement/HttpResponse;Ljava/lang/Throwable;I)V", "a", "Lio/ktor/client/request/HttpRequestBuilder;", "getRequest", "()Lio/ktor/client/request/HttpRequestBuilder;", "b", "Lio/ktor/client/statement/HttpResponse;", "getResponse", "()Lio/ktor/client/statement/HttpResponse;", "c", "Ljava/lang/Throwable;", "getCause", "()Ljava/lang/Throwable;", "d", "I", "getRetryCount", "()I", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
    public static final class ModifyRequestContext {

        /* renamed from: a  reason: collision with root package name */
        public final HttpRequestBuilder f8859a;
        public final HttpResponse b;
        public final Throwable c;
        public final int d;

        public ModifyRequestContext(HttpRequestBuilder httpRequestBuilder, HttpResponse httpResponse, Throwable th, int i) {
            Intrinsics.checkNotNullParameter(httpRequestBuilder, "request");
            this.f8859a = httpRequestBuilder;
            this.b = httpResponse;
            this.c = th;
            this.d = i;
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\n\u001a\u00020\u00032\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00118\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lio/ktor/client/plugins/HttpRequestRetry$Plugin;", "Lio/ktor/client/plugins/HttpClientPlugin;", "Lio/ktor/client/plugins/HttpRequestRetry$Configuration;", "Lio/ktor/client/plugins/HttpRequestRetry;", "<init>", "()V", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "e", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/client/plugins/HttpRequestRetry;", "plugin", "Lio/ktor/client/HttpClient;", "scope", "d", "(Lio/ktor/client/plugins/HttpRequestRetry;Lio/ktor/client/HttpClient;)V", "Lio/ktor/util/AttributeKey;", "key", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "Lio/ktor/events/EventDefinition;", "Lio/ktor/client/plugins/HttpRequestRetry$RetryEventData;", "HttpRequestRetryEvent", "Lio/ktor/events/EventDefinition;", "c", "()Lio/ktor/events/EventDefinition;", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
    public static final class Plugin implements HttpClientPlugin<Configuration, HttpRequestRetry> {
        public /* synthetic */ Plugin(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final EventDefinition c() {
            return HttpRequestRetry.i;
        }

        /* renamed from: d */
        public void b(HttpRequestRetry httpRequestRetry, HttpClient httpClient) {
            Intrinsics.checkNotNullParameter(httpRequestRetry, "plugin");
            Intrinsics.checkNotNullParameter(httpClient, "scope");
            httpRequestRetry.l(httpClient);
        }

        /* renamed from: e */
        public HttpRequestRetry a(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            Configuration configuration = new Configuration();
            function1.invoke(configuration);
            return new HttpRequestRetry(configuration);
        }

        public AttributeKey getKey() {
            return HttpRequestRetry.h;
        }

        public Plugin() {
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0010\u0018\u00002\u00020\u0001B-\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0016\u001a\u0004\b\f\u0010\u0017¨\u0006\u0018"}, d2 = {"Lio/ktor/client/plugins/HttpRequestRetry$RetryEventData;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "request", "", "retryCount", "Lio/ktor/client/statement/HttpResponse;", "response", "", "cause", "<init>", "(Lio/ktor/client/request/HttpRequestBuilder;ILio/ktor/client/statement/HttpResponse;Ljava/lang/Throwable;)V", "a", "Lio/ktor/client/request/HttpRequestBuilder;", "b", "()Lio/ktor/client/request/HttpRequestBuilder;", "I", "d", "()I", "c", "Lio/ktor/client/statement/HttpResponse;", "()Lio/ktor/client/statement/HttpResponse;", "Ljava/lang/Throwable;", "()Ljava/lang/Throwable;", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
    public static final class RetryEventData {

        /* renamed from: a  reason: collision with root package name */
        public final HttpRequestBuilder f8860a;
        public final int b;
        public final HttpResponse c;
        public final Throwable d;

        public RetryEventData(HttpRequestBuilder httpRequestBuilder, int i, HttpResponse httpResponse, Throwable th) {
            Intrinsics.checkNotNullParameter(httpRequestBuilder, "request");
            this.f8860a = httpRequestBuilder;
            this.b = i;
            this.c = httpResponse;
            this.d = th;
        }

        public final Throwable a() {
            return this.d;
        }

        public final HttpRequestBuilder b() {
            return this.f8860a;
        }

        public final HttpResponse c() {
            return this.c;
        }

        public final int d() {
            return this.b;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lio/ktor/client/plugins/HttpRequestRetry$ShouldRetryContext;", "", "", "retryCount", "<init>", "(I)V", "a", "I", "getRetryCount", "()I", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
    public static final class ShouldRetryContext {

        /* renamed from: a  reason: collision with root package name */
        public final int f8861a;

        public ShouldRetryContext(int i) {
            this.f8861a = i;
        }
    }

    public HttpRequestRetry(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.f8856a = configuration.i();
        this.b = configuration.j();
        this.c = configuration.f();
        this.d = configuration.e();
        this.e = configuration.g();
        this.f = configuration.h();
    }

    public final void l(HttpClient httpClient) {
        Intrinsics.checkNotNullParameter(httpClient, "client");
        ((HttpSend) HttpClientPluginKt.b(httpClient, HttpSend.c)).d(new HttpRequestRetry$intercept$1(this, httpClient, (Continuation<? super HttpRequestRetry$intercept$1>) null));
    }

    public final HttpRequestBuilder m(HttpRequestBuilder httpRequestBuilder) {
        HttpRequestBuilder o = new HttpRequestBuilder().o(httpRequestBuilder);
        httpRequestBuilder.g().r(new HttpRequestRetry$prepareRequest$1(o));
        return o;
    }

    public final boolean n(int i2, int i3, Function3 function3, HttpClientCall httpClientCall) {
        return i2 < i3 && ((Boolean) function3.invoke(new ShouldRetryContext(i2 + 1), httpClientCall.f(), httpClientCall.g())).booleanValue();
    }

    public final boolean o(int i2, int i3, Function3 function3, HttpRequestBuilder httpRequestBuilder, Throwable th) {
        return i2 < i3 && ((Boolean) function3.invoke(new ShouldRetryContext(i2 + 1), httpRequestBuilder, th)).booleanValue();
    }
}
