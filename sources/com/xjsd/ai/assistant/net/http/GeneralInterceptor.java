package com.xjsd.ai.assistant.net.http;

import com.upuphone.runasone.api.ApiConstant;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.api.cache.CacheAbility;
import com.xjsd.ai.assistant.core.util.DeviceUtils;
import com.xjsd.ai.assistant.env.EnvAbility;
import com.xjsd.ai.assistant.env.Environment;
import com.xjsd.ai.assistant.log.ILog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/xjsd/ai/assistant/net/http/GeneralInterceptor;", "Lokhttp3/Interceptor;", "<init>", "()V", "Lokhttp3/Interceptor$Chain;", "chain", "", "validToken", "Lokhttp3/Response;", "a", "(Lokhttp3/Interceptor$Chain;Z)Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "Companion", "lib_assistant_release"}, k = 1, mv = {1, 9, 0})
public final class GeneralInterceptor implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f8503a = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjsd/ai/assistant/net/http/GeneralInterceptor$Companion;", "", "()V", "TAG", "", "lib_assistant_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    private final Response a(Interceptor.Chain chain, boolean z) {
        String str;
        Environment currentEnv;
        AbilityManager abilityManager = AbilityManager.b;
        CacheAbility cacheAbility = (CacheAbility) abilityManager.b(CacheAbility.class);
        Request request = chain.request();
        if (cacheAbility != null) {
            String persistValue = cacheAbility.getPersistValue(ApiConstant.KEY_TOKEN);
            String a2 = DeviceUtils.a();
            EnvAbility envAbility = (EnvAbility) abilityManager.b(EnvAbility.class);
            if (envAbility == null || (currentEnv = envAbility.getCurrentEnv()) == null || (str = currentEnv.getUserKey()) == null) {
                str = "";
            }
            Request.Builder newBuilder = request.newBuilder();
            Intrinsics.checkNotNull(persistValue);
            Request.Builder header = newBuilder.header("WR-Authorization", persistValue);
            Intrinsics.checkNotNull(a2);
            request = header.header("WR-Client-Id", a2).header("WR-ukey", str).build();
        }
        String url = request.url().url().toString();
        Intrinsics.checkNotNullExpressionValue(url, "toString(...)");
        Response proceed = chain.proceed(request);
        Headers headers = request.headers();
        int code = proceed.code();
        ILog.a("GeneralInterceptor", "request url->" + url + ", headers->" + headers + ", response code->" + code);
        if (!z || proceed.code() != 401) {
            return proceed;
        }
        Response build = proceed.newBuilder().build();
        proceed.close();
        return StringUtils.isEmpty(TokenGenerator.f8505a.a(chain)) ? build : a(chain, false);
    }

    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        return a(chain, true);
    }
}
