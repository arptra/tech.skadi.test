package io.ktor.client.plugins;

import io.ktor.client.plugins.UserAgent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lio/ktor/client/plugins/UserAgent$Config;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class UserAgentKt$BrowserUserAgent$1 extends Lambda implements Function1<UserAgent.Config, Unit> {
    public static final UserAgentKt$BrowserUserAgent$1 INSTANCE = new UserAgentKt$BrowserUserAgent$1();

    public UserAgentKt$BrowserUserAgent$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((UserAgent.Config) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull UserAgent.Config config) {
        Intrinsics.checkNotNullParameter(config, "$this$install");
        config.b("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Ubuntu Chromium/70.0.3538.77 Chrome/70.0.3538.77 Safari/537.36");
    }
}
