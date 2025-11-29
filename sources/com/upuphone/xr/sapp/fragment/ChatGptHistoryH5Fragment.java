package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.honey.account.h8.b1;
import com.honey.account.h8.c1;
import com.honey.account.h8.d1;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$3;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$4;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$5;
import com.upuphone.xr.sapp.databinding.FragmentChatGptHistoryH5Binding;
import com.upuphone.xr.sapp.databinding.LayoutLoadFailBinding;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.utils.WebViewHybridCall;
import com.upuphone.xr.sapp.utils.WebViewPool;
import com.upuphone.xr.sapp.utils.WebViewStateDelegate;
import com.upuphone.xr.sapp.view.BaseWebView;
import com.upuphone.xr.sapp.vm.SuperViewModel;
import com.xjsd.ai.assistant.chatgpt.ChatGptAbility;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00152\u00020\u00012\u00020\u0002:\u0001=B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J-\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u0004J\u000f\u0010\u0016\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\u0018\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0018\u0010\u0004R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001b\u0010&\u001a\u00020!8BX\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001d\u0010+\u001a\u0004\u0018\u00010'8BX\u0002¢\u0006\f\n\u0004\b(\u0010#\u001a\u0004\b)\u0010*R\u001b\u00100\u001a\u00020,8BX\u0002¢\u0006\f\n\u0004\b-\u0010#\u001a\u0004\b.\u0010/R\u001b\u00105\u001a\u0002018BX\u0002¢\u0006\f\n\u0004\b2\u0010#\u001a\u0004\b3\u00104R$\u0010<\u001a\u0002062\u0006\u00107\u001a\u0002068\u0002@BX\u000e¢\u0006\f\n\u0004\b8\u00109\"\u0004\b:\u0010;¨\u0006>"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/ChatGptHistoryH5Fragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "Lcom/upuphone/xr/sapp/utils/WebViewHybridCall$IWebCallback;", "<init>", "()V", "", "initView", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onDestroy", "q", "E", "N0", "M0", "Lcom/upuphone/xr/sapp/databinding/FragmentChatGptHistoryH5Binding;", "j", "Lcom/upuphone/xr/sapp/databinding/FragmentChatGptHistoryH5Binding;", "binding", "Lcom/upuphone/xr/sapp/databinding/LayoutLoadFailBinding;", "k", "Lcom/upuphone/xr/sapp/databinding/LayoutLoadFailBinding;", "mErrorBinding", "Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "l", "Lkotlin/Lazy;", "getViewModel", "()Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "viewModel", "Lcom/xjsd/ai/assistant/chatgpt/ChatGptAbility;", "m", "H0", "()Lcom/xjsd/ai/assistant/chatgpt/ChatGptAbility;", "gptAbility", "Lcom/upuphone/xr/sapp/view/BaseWebView;", "n", "I0", "()Lcom/upuphone/xr/sapp/view/BaseWebView;", "mWebView", "Lcom/upuphone/xr/sapp/utils/WebViewHybridCall;", "o", "J0", "()Lcom/upuphone/xr/sapp/utils/WebViewHybridCall;", "mWebViewHybirdCall", "", "value", "p", "I", "O0", "(I)V", "mLoadingState", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nChatGptHistoryH5Fragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChatGptHistoryH5Fragment.kt\ncom/upuphone/xr/sapp/fragment/ChatGptHistoryH5Fragment\n+ 2 GlobalViewStoreExt.kt\ncom/upuphone/xr/sapp/common/GlobalViewStoreExtKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,163:1\n32#2,12:164\n256#3,2:176\n*S KotlinDebug\n*F\n+ 1 ChatGptHistoryH5Fragment.kt\ncom/upuphone/xr/sapp/fragment/ChatGptHistoryH5Fragment\n*L\n41#1:164,12\n52#1:176,2\n*E\n"})
public final class ChatGptHistoryH5Fragment extends BaseFragment implements WebViewHybridCall.IWebCallback {
    public static final Companion q = new Companion((DefaultConstructorMarker) null);
    public FragmentChatGptHistoryH5Binding j;
    public LayoutLoadFailBinding k;
    public final Lazy l;
    public final Lazy m = LazyKt.lazy(ChatGptHistoryH5Fragment$gptAbility$2.INSTANCE);
    public final Lazy n = LazyKt.lazy(new ChatGptHistoryH5Fragment$mWebView$2(this));
    public final Lazy o = LazyKt.lazy(ChatGptHistoryH5Fragment$mWebViewHybirdCall$2.INSTANCE);
    public int p;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/ChatGptHistoryH5Fragment$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public ChatGptHistoryH5Fragment() {
        Class<SuperViewModel> cls = SuperViewModel.class;
        this.l = GlobalViewStoreExtKt.a(this, Reflection.getOrCreateKotlinClass(cls), new GlobalViewStoreExtKt$cachedViewModels$3(cls.getName()), new GlobalViewStoreExtKt$cachedViewModels$4((Function0<? extends CreationExtras>) null, this), new GlobalViewStoreExtKt$cachedViewModels$5(this));
    }

    public static final void G0(ChatGptHistoryH5Fragment chatGptHistoryH5Fragment) {
        Intrinsics.checkNotNullParameter(chatGptHistoryH5Fragment, "this$0");
        StaticMethodUtilsKt.q(chatGptHistoryH5Fragment);
    }

    public static final void K0(ChatGptHistoryH5Fragment chatGptHistoryH5Fragment, ViewStub viewStub, View view) {
        TextView textView;
        Intrinsics.checkNotNullParameter(chatGptHistoryH5Fragment, "this$0");
        LayoutLoadFailBinding a2 = LayoutLoadFailBinding.a(view);
        chatGptHistoryH5Fragment.k = a2;
        if (a2 != null && (textView = a2.c) != null) {
            textView.setOnClickListener(new d1(chatGptHistoryH5Fragment));
        }
    }

    public static final void L0(ChatGptHistoryH5Fragment chatGptHistoryH5Fragment, View view) {
        Intrinsics.checkNotNullParameter(chatGptHistoryH5Fragment, "this$0");
        if (chatGptHistoryH5Fragment.p == -1) {
            chatGptHistoryH5Fragment.startActivity(new Intent("android.settings.SETTINGS"));
            return;
        }
        chatGptHistoryH5Fragment.O0(0);
        chatGptHistoryH5Fragment.N0();
    }

    private final void initView() {
        J0().a(this);
        FragmentChatGptHistoryH5Binding fragmentChatGptHistoryH5Binding = this.j;
        FragmentChatGptHistoryH5Binding fragmentChatGptHistoryH5Binding2 = null;
        if (fragmentChatGptHistoryH5Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentChatGptHistoryH5Binding = null;
        }
        fragmentChatGptHistoryH5Binding.getRoot().addView(I0(), 0, new ViewGroup.LayoutParams(-1, -1));
        I0().setLifecycleOwner(this);
        FragmentChatGptHistoryH5Binding fragmentChatGptHistoryH5Binding3 = this.j;
        if (fragmentChatGptHistoryH5Binding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentChatGptHistoryH5Binding2 = fragmentChatGptHistoryH5Binding3;
        }
        fragmentChatGptHistoryH5Binding2.b.setOnInflateListener(new c1(this));
    }

    public void E() {
        UToast.Companion companion = UToast.f6444a;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        String string = getString(R.string.use_network_toast);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        companion.d(requireContext, string);
    }

    public final ChatGptAbility H0() {
        return (ChatGptAbility) this.m.getValue();
    }

    public final BaseWebView I0() {
        return (BaseWebView) this.n.getValue();
    }

    public final WebViewHybridCall J0() {
        return (WebViewHybridCall) this.o.getValue();
    }

    public final void M0() {
        new WebViewStateDelegate(new ChatGptHistoryH5Fragment$initWebView$webViewStateDelegate$1(this)).d(I0());
        I0().addJavascriptInterface(J0(), "SuperObj");
    }

    public final void N0() {
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), Dispatchers.b(), (CoroutineStart) null, new ChatGptHistoryH5Fragment$loadUrl$1(this, (Continuation<? super ChatGptHistoryH5Fragment$loadUrl$1>) null), 2, (Object) null);
    }

    public final void O0(int i) {
        this.p = i;
        TextView textView = null;
        if (i < 0) {
            FragmentChatGptHistoryH5Binding fragmentChatGptHistoryH5Binding = this.j;
            if (fragmentChatGptHistoryH5Binding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentChatGptHistoryH5Binding = null;
            }
            if (fragmentChatGptHistoryH5Binding.b.getParent() != null) {
                ULog.f6446a.a("ProtocolActivity", "执行懒加载view stub");
                FragmentChatGptHistoryH5Binding fragmentChatGptHistoryH5Binding2 = this.j;
                if (fragmentChatGptHistoryH5Binding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentChatGptHistoryH5Binding2 = null;
                }
                fragmentChatGptHistoryH5Binding2.b.inflate();
            }
        }
        LayoutLoadFailBinding layoutLoadFailBinding = this.k;
        LinearLayout b = layoutLoadFailBinding != null ? layoutLoadFailBinding.getRoot() : null;
        if (b != null) {
            int i2 = 0;
            if (!(i < 0)) {
                i2 = 8;
            }
            b.setVisibility(i2);
        }
        if (i == -2) {
            LayoutLoadFailBinding layoutLoadFailBinding2 = this.k;
            TextView textView2 = layoutLoadFailBinding2 != null ? layoutLoadFailBinding2.d : null;
            if (textView2 != null) {
                textView2.setText(getString(R.string.network_error_pls_retry_later));
            }
            LayoutLoadFailBinding layoutLoadFailBinding3 = this.k;
            if (layoutLoadFailBinding3 != null) {
                textView = layoutLoadFailBinding3.c;
            }
            if (textView != null) {
                textView.setText(getString(R.string.retry));
            }
        } else if (i == -1) {
            LayoutLoadFailBinding layoutLoadFailBinding4 = this.k;
            TextView textView3 = layoutLoadFailBinding4 != null ? layoutLoadFailBinding4.d : null;
            if (textView3 != null) {
                textView3.setText(getString(R.string.network_not_available_pls_check));
            }
            LayoutLoadFailBinding layoutLoadFailBinding5 = this.k;
            if (layoutLoadFailBinding5 != null) {
                textView = layoutLoadFailBinding5.c;
            }
            if (textView != null) {
                textView.setText(getString(R.string.network_setting));
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentChatGptHistoryH5Binding c = FragmentChatGptHistoryH5Binding.c(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.j = c;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            c = null;
        }
        return c.getRoot();
    }

    public void onDestroy() {
        super.onDestroy();
        I0().getSettings().setCacheMode(2);
        J0().a((WebViewHybridCall.IWebCallback) null);
        I0().clearCache(true);
        WebViewPool.e.a().i(I0());
    }

    public void onResume() {
        super.onResume();
        N0();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initView();
        M0();
    }

    public void q() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new b1(this));
        }
    }
}
