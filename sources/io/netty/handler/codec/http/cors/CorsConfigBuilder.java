package io.netty.handler.codec.http.cors;

import com.honey.account.constant.AccountConstantKt;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.util.internal.ObjectUtil;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;

public final class CorsConfigBuilder {
    boolean allowCredentials;
    boolean allowNullOrigin;
    boolean allowPrivateNetwork;
    final boolean anyOrigin;
    boolean enabled;
    final Set<String> exposeHeaders;
    long maxAge;
    private boolean noPreflightHeaders;
    final Set<String> origins;
    final Map<CharSequence, Callable<?>> preflightHeaders;
    final Set<String> requestHeaders;
    final Set<HttpMethod> requestMethods;
    boolean shortCircuit;

    public static final class ConstantValueGenerator implements Callable<Object> {
        private final Object value;

        public Object call() {
            return this.value;
        }

        private ConstantValueGenerator(Object obj) {
            this.value = ObjectUtil.checkNotNullWithIAE(obj, AccountConstantKt.RESPONSE_VALUE);
        }
    }

    public static final class DateValueGenerator implements Callable<Date> {
        static final DateValueGenerator INSTANCE = new DateValueGenerator();

        private DateValueGenerator() {
        }

        public Date call() throws Exception {
            return new Date();
        }
    }

    public CorsConfigBuilder(String... strArr) {
        this.enabled = true;
        this.exposeHeaders = new HashSet();
        this.requestMethods = new HashSet();
        this.requestHeaders = new HashSet();
        this.preflightHeaders = new HashMap();
        this.origins = new LinkedHashSet(Arrays.asList(strArr));
        this.anyOrigin = false;
    }

    public static CorsConfigBuilder forAnyOrigin() {
        return new CorsConfigBuilder();
    }

    public static CorsConfigBuilder forOrigin(String str) {
        return "*".equals(str) ? new CorsConfigBuilder() : new CorsConfigBuilder(str);
    }

    public static CorsConfigBuilder forOrigins(String... strArr) {
        return new CorsConfigBuilder(strArr);
    }

    public CorsConfigBuilder allowCredentials() {
        this.allowCredentials = true;
        return this;
    }

    public CorsConfigBuilder allowNullOrigin() {
        this.allowNullOrigin = true;
        return this;
    }

    public CorsConfigBuilder allowPrivateNetwork() {
        this.allowPrivateNetwork = true;
        return this;
    }

    public CorsConfigBuilder allowedRequestHeaders(String... strArr) {
        this.requestHeaders.addAll(Arrays.asList(strArr));
        return this;
    }

    public CorsConfigBuilder allowedRequestMethods(HttpMethod... httpMethodArr) {
        this.requestMethods.addAll(Arrays.asList(httpMethodArr));
        return this;
    }

    public CorsConfig build() {
        if (this.preflightHeaders.isEmpty() && !this.noPreflightHeaders) {
            this.preflightHeaders.put(HttpHeaderNames.DATE, DateValueGenerator.INSTANCE);
            this.preflightHeaders.put(HttpHeaderNames.CONTENT_LENGTH, new ConstantValueGenerator("0"));
        }
        return new CorsConfig(this);
    }

    public CorsConfigBuilder disable() {
        this.enabled = false;
        return this;
    }

    public CorsConfigBuilder exposeHeaders(String... strArr) {
        this.exposeHeaders.addAll(Arrays.asList(strArr));
        return this;
    }

    public CorsConfigBuilder maxAge(long j) {
        this.maxAge = j;
        return this;
    }

    public CorsConfigBuilder noPreflightResponseHeaders() {
        this.noPreflightHeaders = true;
        return this;
    }

    public CorsConfigBuilder preflightResponseHeader(CharSequence charSequence, Object... objArr) {
        if (objArr.length == 1) {
            this.preflightHeaders.put(charSequence, new ConstantValueGenerator(objArr[0]));
        } else {
            preflightResponseHeader(charSequence, Arrays.asList(objArr));
        }
        return this;
    }

    public CorsConfigBuilder shortCircuit() {
        this.shortCircuit = true;
        return this;
    }

    public CorsConfigBuilder allowedRequestHeaders(CharSequence... charSequenceArr) {
        for (CharSequence charSequence : charSequenceArr) {
            this.requestHeaders.add(charSequence.toString());
        }
        return this;
    }

    public CorsConfigBuilder exposeHeaders(CharSequence... charSequenceArr) {
        for (CharSequence charSequence : charSequenceArr) {
            this.exposeHeaders.add(charSequence.toString());
        }
        return this;
    }

    public <T> CorsConfigBuilder preflightResponseHeader(CharSequence charSequence, Iterable<T> iterable) {
        this.preflightHeaders.put(charSequence, new ConstantValueGenerator(iterable));
        return this;
    }

    public <T> CorsConfigBuilder preflightResponseHeader(CharSequence charSequence, Callable<T> callable) {
        this.preflightHeaders.put(charSequence, callable);
        return this;
    }

    public CorsConfigBuilder() {
        this.enabled = true;
        this.exposeHeaders = new HashSet();
        this.requestMethods = new HashSet();
        this.requestHeaders = new HashSet();
        this.preflightHeaders = new HashMap();
        this.anyOrigin = true;
        this.origins = Collections.emptySet();
    }
}
