package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import com.upuphone.xr.sapp.utils.WebViewPool;
import com.upuphone.xr.sapp.view.BaseWebView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/upuphone/xr/sapp/view/BaseWebView;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class H5Fragment$mWebView$2 extends Lambda implements Function0<BaseWebView> {
    final /* synthetic */ H5Fragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public H5Fragment$mWebView$2(H5Fragment h5Fragment) {
        super(0);
        this.this$0 = h5Fragment;
    }

    @NotNull
    public final BaseWebView invoke() {
        WebViewPool a2 = WebViewPool.e.a();
        Context requireContext = this.this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        return a2.e(requireContext);
    }
}
