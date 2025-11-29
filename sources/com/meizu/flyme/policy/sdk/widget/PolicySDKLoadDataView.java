package com.meizu.flyme.policy.sdk.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.honey.account.x2.a;
import com.honey.account.x2.b;
import com.meizu.common.widget.EmptyView;
import com.meizu.common.widget.LoadingView;
import com.meizu.flyme.policy.sdk.R;
import com.meizu.flyme.policy.sdk.util.PolicySdkLogUtils;
import java.lang.ref.WeakReference;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 32\u00020\u0001:\u00013B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020!J\u0010\u0010#\u001a\u00020!2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J4\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\t2\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020\tH\u0007J\u0006\u0010,\u001a\u00020!J\u0006\u0010-\u001a\u00020!J\u001e\u0010.\u001a\u00020!*\u00020/2\u0006\u00100\u001a\u00020(2\b\b\u0002\u00101\u001a\u000202H\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/meizu/flyme/policy/sdk/widget/PolicySDKLoadDataView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "btnSettingNetWork", "Landroid/widget/Button;", "layoutEmptyView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getLayoutEmptyView", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setLayoutEmptyView", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "mContext", "mEmptyView", "Lcom/meizu/common/widget/EmptyView;", "mHandler", "Landroid/os/Handler;", "mLoadingView", "Lcom/meizu/common/widget/LoadingView;", "mProgressShowRunnable", "Ljava/lang/Runnable;", "mProgressView", "Landroid/widget/RelativeLayout;", "refContext", "Ljava/lang/ref/WeakReference;", "hideEmptyView", "", "hideProgress", "initView", "showEmptyView", "titleId", "drawableId", "onRetryClickListener", "Landroid/view/View$OnClickListener;", "showSettingButton", "", "btnId", "showProgress", "showProgressNoDelay", "setDebounceClickListener", "Landroid/view/View;", "listener", "time", "", "Companion", "policysdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PolicySDKLoadDataView extends FrameLayout {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int DURATION_ANIMATION = 100;
    @Nullable
    private Button btnSettingNetWork;
    @Nullable
    private ConstraintLayout layoutEmptyView;
    @Nullable
    private Context mContext;
    @Nullable
    private EmptyView mEmptyView;
    @Nullable
    private Handler mHandler;
    @Nullable
    private LoadingView mLoadingView;
    @NotNull
    private final Runnable mProgressShowRunnable = new a(this);
    @Nullable
    private RelativeLayout mProgressView;
    @Nullable
    private WeakReference<Context> refContext;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/meizu/flyme/policy/sdk/widget/PolicySDKLoadDataView$Companion;", "", "()V", "DURATION_ANIMATION", "", "policysdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PolicySDKLoadDataView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        WeakReference<Context> weakReference = new WeakReference<>(context);
        this.refContext = weakReference;
        this.mContext = weakReference.get();
        initView(context);
    }

    private final void initView(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.policysdk_load_data_view, this);
        View findViewById = inflate.findViewById(R.id.loading_view);
        if (findViewById != null) {
            this.mProgressView = (RelativeLayout) findViewById;
            View findViewById2 = inflate.findViewById(com.meizu.common.R.id.mc_loading_view);
            if (findViewById2 != null) {
                this.mLoadingView = (LoadingView) findViewById2;
                View findViewById3 = inflate.findViewById(R.id.empty_view);
                if (findViewById3 != null) {
                    this.mEmptyView = (EmptyView) findViewById3;
                    this.layoutEmptyView = (ConstraintLayout) findViewById(R.id.layout_empty_view);
                    View findViewById4 = inflate.findViewById(R.id.btn_setting_net_work);
                    if (findViewById4 != null) {
                        this.btnSettingNetWork = (Button) findViewById4;
                        this.mHandler = new Handler(Looper.getMainLooper());
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.Button");
                }
                throw new NullPointerException("null cannot be cast to non-null type com.meizu.common.widget.EmptyView");
            }
            throw new NullPointerException("null cannot be cast to non-null type com.meizu.common.widget.LoadingView");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout");
    }

    /* access modifiers changed from: private */
    /* renamed from: mProgressShowRunnable$lambda-0  reason: not valid java name */
    public static final void m9mProgressShowRunnable$lambda0(PolicySDKLoadDataView policySDKLoadDataView) {
        Intrinsics.checkNotNullParameter(policySDKLoadDataView, "this$0");
        policySDKLoadDataView.showProgressNoDelay();
    }

    private final void setDebounceClickListener(View view, View.OnClickListener onClickListener, long j) {
        view.setOnClickListener(new b(new Ref.ObjectRef(), j, onClickListener));
    }

    public static /* synthetic */ void setDebounceClickListener$default(PolicySDKLoadDataView policySDKLoadDataView, View view, View.OnClickListener onClickListener, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 500;
        }
        policySDKLoadDataView.setDebounceClickListener(view, onClickListener, j);
    }

    /* access modifiers changed from: private */
    /* renamed from: setDebounceClickListener$lambda-1  reason: not valid java name */
    public static final void m10setDebounceClickListener$lambda1(Ref.ObjectRef objectRef, long j, View.OnClickListener onClickListener, View view) {
        Intrinsics.checkNotNullParameter(objectRef, "$job");
        Intrinsics.checkNotNullParameter(onClickListener, "$listener");
        Job job = (Job) objectRef.element;
        if (job != null) {
            Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
        }
        objectRef.element = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.c()), (CoroutineContext) null, (CoroutineStart) null, new PolicySDKLoadDataView$setDebounceClickListener$1$1(j, onClickListener, view, (Continuation<? super PolicySDKLoadDataView$setDebounceClickListener$1$1>) null), 3, (Object) null);
    }

    public static /* synthetic */ void showEmptyView$default(PolicySDKLoadDataView policySDKLoadDataView, int i, int i2, View.OnClickListener onClickListener, boolean z, int i3, int i4, Object obj) {
        if ((i4 & 16) != 0) {
            i3 = 0;
        }
        policySDKLoadDataView.showEmptyView(i, i2, onClickListener, z, i3);
    }

    @Nullable
    public final ConstraintLayout getLayoutEmptyView() {
        return this.layoutEmptyView;
    }

    public final void hideEmptyView() {
        EmptyView emptyView = this.mEmptyView;
        if (emptyView != null) {
            emptyView.setVisibility(8);
        }
        ConstraintLayout constraintLayout = this.layoutEmptyView;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
        }
        Button button = this.btnSettingNetWork;
        if (button != null) {
            button.setVisibility(8);
        }
    }

    public final void hideProgress() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mProgressShowRunnable);
        }
        RelativeLayout relativeLayout = this.mProgressView;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        LoadingView loadingView = this.mLoadingView;
        if (loadingView != null) {
            loadingView.setVisibility(8);
        }
        LoadingView loadingView2 = this.mLoadingView;
        if (loadingView2 != null) {
            loadingView2.stopAnimator();
        }
    }

    public final void setLayoutEmptyView(@Nullable ConstraintLayout constraintLayout) {
        this.layoutEmptyView = constraintLayout;
    }

    @JvmOverloads
    public final void showEmptyView(int i, int i2, @Nullable View.OnClickListener onClickListener, boolean z) {
        showEmptyView$default(this, i, i2, onClickListener, z, 0, 16, (Object) null);
    }

    public final void showProgress() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mProgressShowRunnable);
        }
        Handler handler2 = this.mHandler;
        if (handler2 != null) {
            handler2.postDelayed(this.mProgressShowRunnable, 500);
        }
        Button button = this.btnSettingNetWork;
        if (button != null) {
            button.setVisibility(8);
        }
        hideEmptyView();
    }

    public final void showProgressNoDelay() {
        setVisibility(0);
        RelativeLayout relativeLayout = this.mProgressView;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        LoadingView loadingView = this.mLoadingView;
        if (loadingView != null) {
            loadingView.setVisibility(0);
        }
        LoadingView loadingView2 = this.mLoadingView;
        if (loadingView2 != null) {
            loadingView2.startAnimator();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PolicySDKLoadDataView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        WeakReference<Context> weakReference = new WeakReference<>(context);
        this.refContext = weakReference;
        this.mContext = weakReference.get();
        initView(context);
    }

    @JvmOverloads
    public final void showEmptyView(int i, int i2, @Nullable View.OnClickListener onClickListener, boolean z, int i3) {
        try {
            setVisibility(0);
            EmptyView emptyView = this.mEmptyView;
            if (emptyView != null) {
                emptyView.setVisibility(0);
            }
            ConstraintLayout constraintLayout = this.layoutEmptyView;
            if (constraintLayout != null) {
                constraintLayout.setVisibility(0);
            }
            if (i != 0) {
                Context context = this.mContext;
                String valueOf = String.valueOf(context == null ? null : context.getText(i));
                if (!TextUtils.isEmpty(valueOf)) {
                    EmptyView emptyView2 = this.mEmptyView;
                    if (emptyView2 != null) {
                        emptyView2.setTitle(valueOf);
                    }
                }
            }
            if (i2 > 0) {
                EmptyView emptyView3 = this.mEmptyView;
                if (emptyView3 != null) {
                    emptyView3.setImageDrawable(ContextCompat.getDrawable(getContext(), i2));
                }
            } else if (i2 < 0) {
                EmptyView emptyView4 = this.mEmptyView;
                if (emptyView4 != null) {
                    emptyView4.setImageDrawable((Drawable) null);
                }
            }
            if (z) {
                Button button = this.btnSettingNetWork;
                if (button != null) {
                    button.setVisibility(0);
                }
                Button button2 = this.btnSettingNetWork;
                if (button2 != null) {
                    button2.setText(i3);
                }
            } else {
                Button button3 = this.btnSettingNetWork;
                if (button3 != null) {
                    button3.setVisibility(8);
                }
            }
            if (onClickListener == null) {
                Button button4 = this.btnSettingNetWork;
                if (button4 != null) {
                    button4.setOnClickListener((View.OnClickListener) null);
                }
            } else {
                Button button5 = this.btnSettingNetWork;
                if (button5 != null) {
                    setDebounceClickListener(button5, onClickListener, 500);
                }
            }
            EmptyView emptyView5 = this.mEmptyView;
            if (emptyView5 != null) {
                emptyView5.setAlpha(0.0f);
            }
            EmptyView emptyView6 = this.mEmptyView;
            if (emptyView6 != null) {
                ViewPropertyAnimator animate = emptyView6.animate();
                if (animate != null) {
                    ViewPropertyAnimator alpha = animate.alpha(1.0f);
                    if (alpha != null) {
                        ViewPropertyAnimator duration = alpha.setDuration(100);
                        if (duration != null) {
                            duration.start();
                        }
                    }
                }
            }
        } catch (Exception e) {
            if (e.getMessage() != null) {
                PolicySdkLogUtils.Companion.e("showEmptyView", Intrinsics.stringPlus("Exception = ", e.getMessage()));
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PolicySDKLoadDataView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        initView(context);
    }
}
