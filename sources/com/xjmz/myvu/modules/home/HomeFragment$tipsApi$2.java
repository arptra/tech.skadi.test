package com.xjmz.myvu.modules.home;

import com.xjmz.myvu.flutter.pigeon.AndroidAppApi;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/xjmz/myvu/flutter/pigeon/AndroidAppApi$TipsFlutterApi;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class HomeFragment$tipsApi$2 extends Lambda implements Function0<AndroidAppApi.TipsFlutterApi> {
    final /* synthetic */ HomeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeFragment$tipsApi$2(HomeFragment homeFragment) {
        super(0);
        this.this$0 = homeFragment;
    }

    @NotNull
    public final AndroidAppApi.TipsFlutterApi invoke() {
        return new AndroidAppApi.TipsFlutterApi(this.this$0.s0().getDartExecutor().getBinaryMessenger());
    }
}
