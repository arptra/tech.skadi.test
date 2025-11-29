package com.xjmz.myvu.flutter.base;

import com.xjmz.myvu.modules.home.SearchGlassHandler;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/xjmz/myvu/modules/home/SearchGlassHandler;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class BaseFlutterFragment$searchGlassTimeoutHandler$2 extends Lambda implements Function0<SearchGlassHandler> {
    final /* synthetic */ BaseFlutterFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseFlutterFragment$searchGlassTimeoutHandler$2(BaseFlutterFragment baseFlutterFragment) {
        super(0);
        this.this$0 = baseFlutterFragment;
    }

    @NotNull
    public final SearchGlassHandler invoke() {
        return new SearchGlassHandler(this.this$0.k0());
    }
}
