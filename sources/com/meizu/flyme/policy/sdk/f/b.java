package com.meizu.flyme.policy.sdk.f;

import com.meizu.flyme.policy.sdk.e.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/meizu/flyme/policy/sdk/net/PolicySdkRetrofitHelper;", "", "()V", "apiService", "Lcom/meizu/flyme/policy/sdk/api/IPolicyApiService;", "getApiService", "()Lcom/meizu/flyme/policy/sdk/api/IPolicyApiService;", "policysdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final b f3204a = new b();
    @NotNull
    public static final a b;

    static {
        a aVar = a.f3201a;
        Class cls = a.class;
        Intrinsics.checkNotNullParameter(cls, "clazz");
        Object value = a.c.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-retrofit>(...)");
        b = (a) ((Retrofit) value).create(cls);
    }
}
