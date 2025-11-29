package com.upuphone.xr.sapp.monitor.net;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lokhttp3/OkHttpClient$Builder;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TokenUtil$requestGwToken$http$1 extends Lambda implements Function1<OkHttpClient.Builder, Unit> {
    public static final TokenUtil$requestGwToken$http$1 INSTANCE = new TokenUtil$requestGwToken$http$1();

    public TokenUtil$requestGwToken$http$1() {
        super(1);
    }

    public final void invoke(@NotNull OkHttpClient.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "$this$cloneHttpClient");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((OkHttpClient.Builder) obj);
        return Unit.INSTANCE;
    }
}
