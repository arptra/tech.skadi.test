package com.meizu.flyme.policy.sdk.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.content.FileProvider;
import androidx.lifecycle.LifecycleOwnerKt;
import com.meizu.flyme.policy.sdk.PolicySdk;
import com.meizu.flyme.policy.sdk.R;
import com.meizu.flyme.policy.sdk.bean.PolicySdkResultBean;
import com.meizu.flyme.policy.sdk.config.PolicySdkConstants;
import com.meizu.flyme.policy.sdk.util.HookMacAddressUtils;
import com.meizu.flyme.policy.sdk.util.PolicySdkLogUtils;
import com.meizu.flyme.policy.sdk.util.PolicySdkNetworkUtil;
import com.meizu.flyme.policy.sdk.util.PolicySdkStatusbarColorUtils;
import com.meizu.flyme.policy.sdk.util.PolicySdkToolsUtils;
import com.meizu.flyme.policy.sdk.util.SmartBarPaddingUtil;
import com.meizu.flyme.policy.sdk.widget.PolicySDKLoadDataView;
import com.upuphone.runasone.uupcast.CaptureType;
import flyme.support.v7.app.ActionBar;
import flyme.support.v7.app.AppCompatActivity;
import java.io.File;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 02\u00020\u0001:\u00010B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u0004J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u001bH\u0016J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!H\u0016J\u0012\u0010\"\u001a\u00020\u001b2\b\u0010#\u001a\u0004\u0018\u00010\u0004H\u0014J\b\u0010$\u001a\u00020\u001bH\u0014J\b\u0010%\u001a\u00020\u0010H\u0016J\u0006\u0010&\u001a\u00020\u001bJ\u0010\u0010'\u001a\u00020\u001b2\b\u0010(\u001a\u0004\u0018\u00010)J\u001a\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020,2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0002J\u0006\u0010-\u001a\u00020\u001bJ\u0006\u0010.\u001a\u00020\u001bJ\u000e\u0010/\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/meizu/flyme/policy/sdk/activity/PolicyWebViewActivity;", "Lflyme/support/v7/app/AppCompatActivity;", "()V", "bundle", "Landroid/os/Bundle;", "loadDataView", "Lcom/meizu/flyme/policy/sdk/widget/PolicySDKLoadDataView;", "getLoadDataView", "()Lcom/meizu/flyme/policy/sdk/widget/PolicySDKLoadDataView;", "setLoadDataView", "(Lcom/meizu/flyme/policy/sdk/widget/PolicySDKLoadDataView;)V", "mActivity", "Landroid/app/Activity;", "mContext", "Landroid/content/Context;", "mNeedLoadData", "", "getMNeedLoadData", "()Z", "setMNeedLoadData", "(Z)V", "mTitle", "", "mUri", "mWebView", "Landroid/webkit/WebView;", "fetchPolicyData", "", "fitStatusBarWithUiMode", "initWebview", "onBackPressed", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "onDestroy", "onSupportNavigateUp", "setHomeAsUpEnabled", "setViewContainerPadding", "viewGroup", "Landroid/view/ViewGroup;", "showLoadDataView", "errorCode", "", "showNetWorkErrorView", "showNotNetWorkView", "webViewLoadData", "Companion", "policysdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PolicyWebViewActivity extends AppCompatActivity {
    @NotNull
    public static final a Companion = new a();
    /* access modifiers changed from: private */
    @Nullable
    public static Function1<? super Context, Unit> webViewSettingBtnCallback;
    @Nullable
    private Bundle bundle;
    @Nullable
    private PolicySDKLoadDataView loadDataView;
    /* access modifiers changed from: private */
    @Nullable
    public Activity mActivity;
    /* access modifiers changed from: private */
    @Nullable
    public Context mContext;
    private boolean mNeedLoadData;
    @Nullable
    private String mTitle;
    /* access modifiers changed from: private */
    @Nullable
    public String mUri;
    /* access modifiers changed from: private */
    @Nullable
    public WebView mWebView;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u000b\u001a\u00020\u00062\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004J,\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\"\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010R(\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/meizu/flyme/policy/sdk/activity/PolicyWebViewActivity$Companion;", "", "()V", "webViewSettingBtnCallback", "Lkotlin/Function1;", "Landroid/content/Context;", "", "getWebViewSettingBtnCallback", "()Lkotlin/jvm/functions/Function1;", "setWebViewSettingBtnCallback", "(Lkotlin/jvm/functions/Function1;)V", "setSettingBtnCallback", "mWebViewSettingBtnCallback", "startOnLineWebViewActivity", "context", "uri", "", "title", "bundle", "Landroid/os/Bundle;", "startWebViewActivity", "policysdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        public final void a(@NotNull Context context, @Nullable String str, @Nullable String str2) {
            Class<PolicyWebViewActivity> cls = PolicyWebViewActivity.class;
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("uri", str);
            intent.putExtra("title", str2);
            try {
                intent.setClass(context, cls);
                context.startActivity(intent);
            } catch (Exception unused) {
                intent.addFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
                intent.setClass(context, cls);
                context.startActivity(intent);
            }
        }

        public final void a(@NotNull Context context, @Nullable String str, @Nullable String str2, @Nullable Bundle bundle) {
            Class<PolicyWebViewActivity> cls = PolicyWebViewActivity.class;
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("uri", str);
            intent.putExtra("title", str2);
            intent.putExtras(bundle);
            try {
                intent.setClass(context, cls);
                context.startActivity(intent);
            } catch (Exception unused) {
                intent.addFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
                intent.setClass(context, cls);
                context.startActivity(intent);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/meizu/flyme/policy/sdk/activity/PolicyWebViewActivity$fetchPolicyData$1", "Lcom/meizu/flyme/policy/sdk/PolicySdk$PolicySdkCallback;", "getResult", "", "policySdkResultBean", "Lcom/meizu/flyme/policy/sdk/bean/PolicySdkResultBean;", "policysdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b implements PolicySdk.PolicySdkCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PolicyWebViewActivity f3191a;
        public final /* synthetic */ Ref.ObjectRef<String> b;

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
        @DebugMetadata(c = "com.meizu.flyme.policy.sdk.activity.PolicyWebViewActivity$fetchPolicyData$1$getResult$1", f = "PolicyWebViewActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PolicyWebViewActivity f3192a;
            public final /* synthetic */ PolicySdkResultBean b;
            public final /* synthetic */ Ref.ObjectRef<String> c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(PolicyWebViewActivity policyWebViewActivity, PolicySdkResultBean policySdkResultBean, Ref.ObjectRef<String> objectRef, Continuation<? super a> continuation) {
                super(2, continuation);
                this.f3192a = policyWebViewActivity;
                this.b = policySdkResultBean;
                this.c = objectRef;
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new a(this.f3192a, this.b, this.c, continuation);
            }

            public Object invoke(Object obj, Object obj2) {
                CoroutineScope coroutineScope = (CoroutineScope) obj;
                return new a(this.f3192a, this.b, this.c, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
            }

            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Context access$getMContext$p;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                ResultKt.throwOnFailure(obj);
                PolicySDKLoadDataView loadDataView = this.f3192a.getLoadDataView();
                if (loadDataView != null) {
                    loadDataView.hideProgress();
                }
                PolicySdkResultBean policySdkResultBean = this.b;
                if (policySdkResultBean != null && policySdkResultBean.getCode() == 0) {
                    this.f3192a.mUri = this.b.getPolicyUrl();
                    this.f3192a.webViewLoadData(this.b.getPolicyUrl());
                } else {
                    Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    T policyNewestPath = PolicySdk.getPolicyNewestPath(this.f3192a.mActivity, (String) this.c.element);
                    objectRef.element = policyNewestPath;
                    if (!(policyNewestPath.getCode() == 0 || (access$getMContext$p = this.f3192a.mContext) == null)) {
                        objectRef.element = PolicySdk.getPolicyNewestPath(access$getMContext$p.createDeviceProtectedStorageContext(), (String) this.c.element);
                    }
                    if (((PolicySdkResultBean) objectRef.element).getCode() == 0) {
                        PolicySdkResultBean policySdkResultBean2 = (PolicySdkResultBean) objectRef.element;
                        T t = null;
                        String policyNewestPath2 = policySdkResultBean2 == null ? null : policySdkResultBean2.getPolicyNewestPath();
                        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                        objectRef2.element = new File(policyNewestPath2);
                        PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
                        companion.d("PolicyManager", "newestFile exists = " + ((File) objectRef2.element).exists() + ' ');
                        Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
                        Activity access$getMActivity$p = this.f3192a.mActivity;
                        if (access$getMActivity$p != null) {
                            Activity access$getMActivity$p2 = this.f3192a.mActivity;
                            if (access$getMActivity$p2 != null) {
                                t = access$getMActivity$p2.getPackageName();
                            }
                            t = FileProvider.getUriForFile(access$getMActivity$p, Intrinsics.stringPlus(t, ".PolicySdk.FileProvider"), (File) objectRef2.element);
                        }
                        objectRef3.element = t;
                        companion.d("PolicyManager", "fetchPolicyData  getLocalPolicySdkResultBean = " + policyNewestPath2 + ' ');
                        if (policyNewestPath2 != null) {
                            this.f3192a.webViewLoadData(String.valueOf(objectRef3.element));
                        }
                    } else {
                        this.f3192a.showNetWorkErrorView();
                    }
                }
                return Unit.INSTANCE;
            }
        }

        public b(PolicyWebViewActivity policyWebViewActivity, Ref.ObjectRef<String> objectRef) {
            this.f3191a = policyWebViewActivity;
            this.b = objectRef;
        }

        public void getResult(@Nullable PolicySdkResultBean policySdkResultBean) {
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
            StringBuilder sb = new StringBuilder();
            sb.append("getPolicy  getResult = ");
            sb.append(policySdkResultBean == null ? null : Integer.valueOf(policySdkResultBean.getCode()));
            sb.append(' ');
            companion.d("fetchPolicyData", sb.toString());
            Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this.f3191a), (CoroutineContext) null, (CoroutineStart) null, new a(this.f3191a, policySdkResultBean, this.b, (Continuation<? super a>) null), 3, (Object) null);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/meizu/flyme/policy/sdk/activity/PolicyWebViewActivity$initWebview$1", "Landroid/webkit/WebViewClient;", "shouldOverrideUrlLoading", "", "view", "Landroid/webkit/WebView;", "url", "", "policysdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c extends WebViewClient {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PolicyWebViewActivity f3193a;

        public c(PolicyWebViewActivity policyWebViewActivity) {
            this.f3193a = policyWebViewActivity;
        }

        public boolean shouldOverrideUrlLoading(@NotNull WebView webView, @NotNull String str) {
            Intrinsics.checkNotNullParameter(webView, "view");
            Intrinsics.checkNotNullParameter(str, "url");
            PolicySdkLogUtils.Companion.d("shouldOverrideUrlLoading", Intrinsics.stringPlus("url = ", str));
            Context access$getMContext$p = this.f3193a.mContext;
            if (access$getMContext$p == null) {
                return true;
            }
            PolicySdkToolsUtils.Companion companion = PolicySdkToolsUtils.Companion;
            Uri parse = Uri.parse(str);
            Intrinsics.checkNotNullExpressionValue(parse, "parse(url)");
            companion.startBrowser(access$getMContext$p, parse);
            return true;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.meizu.flyme.policy.sdk.activity.PolicyWebViewActivity$onBackPressed$1", f = "PolicyWebViewActivity.kt", i = {}, l = {408}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f3194a;
        public final /* synthetic */ PolicyWebViewActivity b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(PolicyWebViewActivity policyWebViewActivity, Continuation<? super d> continuation) {
            super(2, continuation);
            this.b = policyWebViewActivity;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new d(this.b, continuation);
        }

        public Object invoke(Object obj, Object obj2) {
            CoroutineScope coroutineScope = (CoroutineScope) obj;
            return new d(this.b, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f3194a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.f3194a = 1;
                if (DelayKt.b(100, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            WebView access$getMWebView$p = this.b.mWebView;
            if (access$getMWebView$p != null) {
                access$getMWebView$p.setVisibility(0);
            }
            PolicySDKLoadDataView loadDataView = this.b.getLoadDataView();
            if (loadDataView != null) {
                loadDataView.hideEmptyView();
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.meizu.flyme.policy.sdk.activity.PolicyWebViewActivity$onSupportNavigateUp$1", f = "PolicyWebViewActivity.kt", i = {}, l = {390}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f3195a;
        public final /* synthetic */ PolicyWebViewActivity b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(PolicyWebViewActivity policyWebViewActivity, Continuation<? super e> continuation) {
            super(2, continuation);
            this.b = policyWebViewActivity;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new e(this.b, continuation);
        }

        public Object invoke(Object obj, Object obj2) {
            CoroutineScope coroutineScope = (CoroutineScope) obj;
            return new e(this.b, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f3195a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.f3195a = 1;
                if (DelayKt.b(100, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            WebView access$getMWebView$p = this.b.mWebView;
            if (access$getMWebView$p != null) {
                access$getMWebView$p.setVisibility(0);
            }
            PolicySDKLoadDataView loadDataView = this.b.getLoadDataView();
            if (loadDataView != null) {
                loadDataView.hideEmptyView();
            }
            return Unit.INSTANCE;
        }
    }

    private final void fitStatusBarWithUiMode() {
        boolean z;
        WebSettings webSettings = null;
        if ((getResources().getConfiguration().uiMode & 48) == 32) {
            if (Build.VERSION.SDK_INT >= 33) {
                WebView webView = this.mWebView;
                if (webView != null) {
                    webSettings = webView.getSettings();
                }
                if (webSettings != null) {
                    z = true;
                } else {
                    return;
                }
            } else {
                return;
            }
        } else if (Build.VERSION.SDK_INT >= 33) {
            WebView webView2 = this.mWebView;
            if (webView2 != null) {
                webSettings = webView2.getSettings();
            }
            if (webSettings != null) {
                z = false;
            } else {
                return;
            }
        } else {
            return;
        }
        webSettings.setAlgorithmicDarkeningAllowed(z);
    }

    private final void initWebview() {
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.setWebViewClient(new c(this));
        }
        WebView webView2 = this.mWebView;
        WebSettings settings = webView2 == null ? null : webView2.getSettings();
        if (settings != null) {
            settings.setLoadWithOverviewMode(true);
        }
        if (settings != null) {
            settings.setUseWideViewPort(true);
        }
        if (settings != null) {
            settings.setJavaScriptEnabled(true);
        }
        if (settings != null) {
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
        }
        if (settings != null) {
            settings.setDomStorageEnabled(true);
        }
        if (settings != null) {
            settings.setAllowFileAccess(true);
        }
        if (settings != null) {
            settings.setAllowContentAccess(true);
        }
        PolicySdkLogUtils.Companion.d("PolicyWebViewActivity", Intrinsics.stringPlus("initWebview: ", this.mUri));
        WebView webView3 = this.mWebView;
        if (webView3 != null) {
            webView3.setOverScrollMode(2);
        }
    }

    private final void showLoadDataView(int i, Bundle bundle2) {
        if (i == -10003) {
            showNotNetWorkView();
        } else if (i == 0 && bundle2 != null) {
            fetchPolicyData(bundle2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showNetWorkErrorView$lambda-4  reason: not valid java name */
    public static final void m5showNetWorkErrorView$lambda4(PolicyWebViewActivity policyWebViewActivity, View view) {
        Intrinsics.checkNotNullParameter(policyWebViewActivity, "this$0");
        Bundle bundle2 = policyWebViewActivity.bundle;
        if (bundle2 != null) {
            policyWebViewActivity.fetchPolicyData(bundle2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showNotNetWorkView$lambda-7  reason: not valid java name */
    public static final void m6showNotNetWorkView$lambda7(PolicyWebViewActivity policyWebViewActivity, View view) {
        Context context;
        Intrinsics.checkNotNullParameter(policyWebViewActivity, "this$0");
        Function1<? super Context, Unit> function1 = webViewSettingBtnCallback;
        if (!(function1 == null || (context = policyWebViewActivity.mContext) == null)) {
            function1.invoke(context);
        }
        policyWebViewActivity.startActivity(new Intent("android.settings.SETTINGS"));
        policyWebViewActivity.mNeedLoadData = true;
    }

    /* access modifiers changed from: private */
    /* renamed from: webViewLoadData$lambda-8  reason: not valid java name */
    public static final void m7webViewLoadData$lambda8(PolicyWebViewActivity policyWebViewActivity, String str) {
        Intrinsics.checkNotNullParameter(policyWebViewActivity, "this$0");
        Intrinsics.checkNotNullParameter(str, "$mUri");
        try {
            WebView webView = policyWebViewActivity.mWebView;
            if (webView != null) {
                webView.setVisibility(0);
            }
            PolicySDKLoadDataView policySDKLoadDataView = policyWebViewActivity.loadDataView;
            if (policySDKLoadDataView != null) {
                policySDKLoadDataView.hideEmptyView();
            }
            WebView webView2 = policyWebViewActivity.mWebView;
            if (webView2 != null) {
                webView2.loadData("", "text/html", "UTF-8");
            }
            WebView webView3 = policyWebViewActivity.mWebView;
            if (webView3 != null) {
                webView3.loadUrl(str);
            }
        } catch (Exception e2) {
            PolicySdkLogUtils.Companion.e("PolicyWebViewActivity", Intrinsics.stringPlus("webViewLoadData Exception: ", e2.getMessage()));
        }
    }

    public final void fetchPolicyData(@NotNull Bundle bundle2) {
        Intrinsics.checkNotNullParameter(bundle2, "bundle");
        PolicySDKLoadDataView policySDKLoadDataView = this.loadDataView;
        if (policySDKLoadDataView != null) {
            policySDKLoadDataView.showProgress();
        }
        String string = bundle2.getString(PolicySdkConstants.BUNDLE_KEY_LANGUAGE);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = bundle2.getString(PolicySdkConstants.BUNDLE_KEY_CATEGORY);
        long j = bundle2.getLong(PolicySdkConstants.BUNDLE_KEY_VERSION);
        if (PolicySdkNetworkUtil.isNetworkAvailable(this.mActivity)) {
            try {
                PolicySdk.getPolicy(string, (String) objectRef.element, Long.valueOf(j), new b(this, objectRef));
            } catch (Exception e2) {
                showNetWorkErrorView();
                PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
                StringBuilder sb = new StringBuilder();
                sb.append("Exception= ");
                e2.printStackTrace();
                sb.append(Unit.INSTANCE);
                sb.append(' ');
                companion.d("fetchPolicyData", sb.toString());
            }
        } else {
            showNotNetWorkView();
        }
    }

    @Nullable
    public final PolicySDKLoadDataView getLoadDataView() {
        return this.loadDataView;
    }

    public final boolean getMNeedLoadData() {
        return this.mNeedLoadData;
    }

    public void onBackPressed() {
        WebView webView = this.mWebView;
        if (webView != null && webView.canGoBack()) {
            WebView webView2 = this.mWebView;
            if (webView2 != null) {
                webView2.goBack();
            }
            Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new d(this, (Continuation<? super d>) null), 3, (Object) null);
            return;
        }
        super.onBackPressed();
    }

    public void onConfigurationChanged(@NotNull Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        fitStatusBarWithUiMode();
    }

    public void onCreate(@Nullable Bundle bundle2) {
        super.onCreate(bundle2);
        try {
            HookMacAddressUtils.INSTANCE.hookMacAddress(this);
            PolicySdkStatusbarColorUtils.setStatusBarDarkIcon((Activity) this, true);
            setContentView(R.layout.activity_policysdk_webview);
            setViewContainerPadding((ViewGroup) findViewById(R.id.root_layout));
            setHomeAsUpEnabled();
            WeakReference weakReference = new WeakReference(this);
            this.mActivity = (Activity) new WeakReference(this).get();
            this.mContext = (Context) weakReference.get();
            this.mWebView = (WebView) findViewById(R.id.webView);
            this.loadDataView = (PolicySDKLoadDataView) findViewById(R.id.load_data_view);
            Bundle extras = getIntent().getExtras();
            this.bundle = extras;
            Integer num = null;
            if (extras != null) {
                this.mUri = extras.getString("uri");
                Bundle bundle3 = this.bundle;
                this.mTitle = bundle3 == null ? null : bundle3.getString("title");
            }
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null && !TextUtils.isEmpty(this.mTitle)) {
                supportActionBar.setTitle((CharSequence) this.mTitle);
            }
            fitStatusBarWithUiMode();
            initWebview();
            String str = this.mUri;
            if (str == null || !StringsKt.equals$default(str, PolicySdkConstants.ONLINE_POLICY_WEB_VIEW, false, 2, (Object) null)) {
                String str2 = this.mUri;
                if (str2 != null) {
                    webViewLoadData(str2);
                    return;
                }
                return;
            }
            Bundle bundle4 = this.bundle;
            if (bundle4 != null) {
                num = Integer.valueOf(bundle4.getInt(PolicySdkConstants.ONLINE_POLICY_WEB_VIEW_BUNDLE_KEY));
            }
            if (num != null) {
                showLoadDataView(num.intValue(), this.bundle);
            }
        } catch (Exception e2) {
            PolicySdkLogUtils.Companion.e("onCreate", Intrinsics.stringPlus("PolicyWebViewActivity  Exception = ", e2.getMessage()));
        }
    }

    public void onDestroy() {
        Companion.getClass();
        webViewSettingBtnCallback = null;
        WebView webView = this.mWebView;
        ViewParent parent = webView == null ? null : webView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.mWebView);
        }
        WebView webView2 = this.mWebView;
        if (webView2 != null) {
            webView2.destroy();
        }
        HookMacAddressUtils.INSTANCE.closeHookMacAddress();
        this.mActivity = null;
        this.mContext = null;
        super.onDestroy();
    }

    public boolean onSupportNavigateUp() {
        PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
        WebView webView = this.mWebView;
        companion.d("onSupportNavigateUp", Intrinsics.stringPlus("mWebView?.canGoBack() = ", webView == null ? null : Boolean.valueOf(webView.canGoBack())));
        WebView webView2 = this.mWebView;
        if (webView2 != null && webView2.canGoBack()) {
            WebView webView3 = this.mWebView;
            if (webView3 != null) {
                webView3.goBack();
            }
            Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new e(this, (Continuation<? super e>) null), 3, (Object) null);
        } else {
            WebView webView4 = this.mWebView;
            if (webView4 != null) {
                webView4.clearHistory();
            }
            finish();
        }
        return super.onSupportNavigateUp();
    }

    public final void setHomeAsUpEnabled() {
        try {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setDisplayShowHomeEnabled(false);
            }
            ActionBar supportActionBar2 = getSupportActionBar();
            if (supportActionBar2 != null) {
                supportActionBar2.setDisplayHomeAsUpEnabled(true);
            }
            ActionBar supportActionBar3 = getSupportActionBar();
            if (supportActionBar3 != null) {
                supportActionBar3.setHomeButtonEnabled(true);
            }
        } catch (Exception unused) {
        }
    }

    public final void setLoadDataView(@Nullable PolicySDKLoadDataView policySDKLoadDataView) {
        this.loadDataView = policySDKLoadDataView;
    }

    public final void setMNeedLoadData(boolean z) {
        this.mNeedLoadData = z;
    }

    public final void setViewContainerPadding(@Nullable ViewGroup viewGroup) {
        if (viewGroup != null) {
            SmartBarPaddingUtil.setPaddingActionBar(this, viewGroup);
        }
    }

    public final void showNetWorkErrorView() {
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.setVisibility(8);
        }
        PolicySDKLoadDataView policySDKLoadDataView = this.loadDataView;
        if (policySDKLoadDataView != null) {
            policySDKLoadDataView.showEmptyView(R.string.policy_sdk_network_error, R.drawable.policy_mz_ic_empty_view_no_network, new com.honey.account.v2.b(this), true, R.string.policy_sdk_network_retry);
        }
    }

    public final void showNotNetWorkView() {
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.setVisibility(8);
        }
        PolicySDKLoadDataView policySDKLoadDataView = this.loadDataView;
        if (policySDKLoadDataView != null) {
            policySDKLoadDataView.showEmptyView(R.string.policy_mz_wif_setting_dialog_message, R.drawable.policy_mz_ic_empty_view_no_network, new com.honey.account.v2.d(this), true, R.string.policy_sdk_btn_setting_network);
        }
    }

    public final void webViewLoadData(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "mUri");
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.post(new com.honey.account.v2.c(this, str));
        }
    }
}
