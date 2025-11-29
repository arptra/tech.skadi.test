package io.ktor.client.plugins.cookies;

import io.ktor.http.Cookie;
import io.ktor.util.date.GMTDate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "cookie", "Lio/ktor/http/Cookie;", "invoke", "(Lio/ktor/http/Cookie;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class AcceptAllCookiesStorage$cleanup$1 extends Lambda implements Function1<Cookie, Boolean> {
    final /* synthetic */ long $timestamp;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AcceptAllCookiesStorage$cleanup$1(long j) {
        super(1);
        this.$timestamp = j;
    }

    @NotNull
    public final Boolean invoke(@NotNull Cookie cookie) {
        Intrinsics.checkNotNullParameter(cookie, "cookie");
        GMTDate e = cookie.e();
        if (e == null) {
            return Boolean.FALSE;
        }
        return Boolean.valueOf(e.d() < this.$timestamp);
    }
}
