package com.upuphone.xr.sapp;

import com.upuphone.star.httplib.HttpInstance;
import com.upuphone.star.httplib.HttpUtils;
import com.upuphone.star.httplib.ResponseParser;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/upuphone/star/httplib/HttpInstance;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class AppContextImpl$Companion$appHttpInstance$2 extends Lambda implements Function0<HttpInstance> {
    public static final AppContextImpl$Companion$appHttpInstance$2 INSTANCE = new AppContextImpl$Companion$appHttpInstance$2();

    public AppContextImpl$Companion$appHttpInstance$2() {
        super(0);
    }

    @NotNull
    public final HttpInstance invoke() {
        HttpUtils httpUtils = HttpUtils.f6479a;
        HttpInstance httpInstance = new HttpInstance(httpUtils.j(AnonymousClass1.INSTANCE), (ResponseParser) null, 2, (DefaultConstructorMarker) null);
        httpUtils.k(true);
        return httpInstance;
    }
}
