package com.upuphone.xr.sapp.utils;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Handler;
import android.util.AttributeSet;
import com.honey.account.w8.j;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.view.BaseWebView;
import java.util.Stack;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001$B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0019\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001a8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\"¨\u0006%"}, d2 = {"Lcom/upuphone/xr/sapp/utils/WebViewPool;", "", "<init>", "()V", "", "size", "", "j", "(I)V", "Landroid/content/Context;", "context", "initSize", "f", "(Landroid/content/Context;I)V", "Lcom/upuphone/xr/sapp/view/BaseWebView;", "e", "(Landroid/content/Context;)Lcom/upuphone/xr/sapp/view/BaseWebView;", "webView", "i", "(Lcom/upuphone/xr/sapp/view/BaseWebView;)V", "Landroid/os/Handler;", "a", "Lkotlin/Lazy;", "d", "()Landroid/os/Handler;", "mHandler", "Ljava/util/Stack;", "b", "Ljava/util/Stack;", "sPool", "", "c", "[B", "lock", "I", "maxSize", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nWebViewPool.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebViewPool.kt\ncom/upuphone/xr/sapp/utils/WebViewPool\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,100:1\n1#2:101\n1855#3,2:102\n*S KotlinDebug\n*F\n+ 1 WebViewPool.kt\ncom/upuphone/xr/sapp/utils/WebViewPool\n*L\n92#1:102,2\n*E\n"})
public final class WebViewPool {
    public static final Companion e = new Companion((DefaultConstructorMarker) null);
    public static volatile WebViewPool f;

    /* renamed from: a  reason: collision with root package name */
    public final Lazy f7933a;
    public final Stack b;
    public final byte[] c;
    public int d;

    @SourceDebugExtension({"SMAP\nWebViewPool.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebViewPool.kt\ncom/upuphone/xr/sapp/utils/WebViewPool$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,100:1\n1#2:101\n*E\n"})
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/upuphone/xr/sapp/utils/WebViewPool$Companion;", "", "<init>", "()V", "Lcom/upuphone/xr/sapp/utils/WebViewPool;", "a", "()Lcom/upuphone/xr/sapp/utils/WebViewPool;", "", "TAG", "Ljava/lang/String;", "instance", "Lcom/upuphone/xr/sapp/utils/WebViewPool;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WebViewPool a() {
            WebViewPool b = WebViewPool.f;
            if (b == null) {
                synchronized (this) {
                    b = WebViewPool.f;
                    if (b == null) {
                        b = new WebViewPool((DefaultConstructorMarker) null);
                        WebViewPool.f = b;
                    }
                }
            }
            return b;
        }

        public Companion() {
        }
    }

    public /* synthetic */ WebViewPool(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* synthetic */ void g(WebViewPool webViewPool, Context context, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = webViewPool.d;
        }
        webViewPool.f(context, i);
    }

    public static final void h(Context context, WebViewPool webViewPool) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(webViewPool, "this$0");
        webViewPool.b.push(new BaseWebView(new MutableContextWrapper(context), (AttributeSet) null, 2, (DefaultConstructorMarker) null));
    }

    public final Handler d() {
        return (Handler) this.f7933a.getValue();
    }

    public final BaseWebView e(Context context) {
        BaseWebView baseWebView;
        Intrinsics.checkNotNullParameter(context, "context");
        synchronized (this.c) {
            try {
                if (this.b.size() > 0) {
                    Object pop = this.b.pop();
                    Intrinsics.checkNotNullExpressionValue(pop, "pop(...)");
                    baseWebView = (BaseWebView) pop;
                    ULog.f6446a.a("WebViewPool", "getWebView from pool");
                } else {
                    baseWebView = new BaseWebView(new MutableContextWrapper(context), (AttributeSet) null, 2, (DefaultConstructorMarker) null);
                    ULog.f6446a.a("WebViewPool", "getWebView from create");
                }
                Context context2 = baseWebView.getContext();
                Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type android.content.MutableContextWrapper");
                ((MutableContextWrapper) context2).setBaseContext(context);
                baseWebView.clearCache(true);
            } catch (Throwable th) {
                throw th;
            }
        }
        return baseWebView;
    }

    public final void f(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        for (int i2 = 0; i2 < i; i2++) {
            d().post(new j(context, this));
        }
    }

    public final void i(BaseWebView baseWebView) {
        Intrinsics.checkNotNullParameter(baseWebView, "webView");
        ULog.f6446a.g("WebViewPool", "destory webview");
        baseWebView.destroy();
    }

    public final void j(int i) {
        synchronized (this.c) {
            this.d = i;
            Unit unit = Unit.INSTANCE;
        }
    }

    public WebViewPool() {
        this.f7933a = LazyKt.lazy(WebViewPool$mHandler$2.INSTANCE);
        this.b = new Stack();
        this.c = new byte[0];
        this.d = 1;
    }
}
