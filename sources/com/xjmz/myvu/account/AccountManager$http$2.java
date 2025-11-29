package com.xjmz.myvu.account;

import com.upuphone.star.fota.phone.GlassUpdateApiManager;
import com.upuphone.star.httplib.HttpInstance;
import com.upuphone.star.httplib.HttpUtils;
import com.upuphone.star.httplib.ResponseParser;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/upuphone/star/httplib/HttpInstance;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class AccountManager$http$2 extends Lambda implements Function0<HttpInstance> {
    public static final AccountManager$http$2 INSTANCE = new AccountManager$http$2();

    public AccountManager$http$2() {
        super(0);
    }

    @NotNull
    public final HttpInstance invoke() {
        HttpInstance httpInstance = new HttpInstance(HttpUtils.f6479a.j(AnonymousClass1.INSTANCE), (ResponseParser) null, 2, (DefaultConstructorMarker) null);
        GlassUpdateApiManager.f6471a.e(true);
        return httpInstance;
    }
}
