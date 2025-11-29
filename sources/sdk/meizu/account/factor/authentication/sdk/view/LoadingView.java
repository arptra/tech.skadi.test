package sdk.meizu.account.factor.authentication.sdk.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sdk.meizu.account.factor.authentication.sdk.R;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\nB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u000bJ\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u000e\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!R\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u0019\u0010\u000f¨\u0006\""}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/view/LoadingView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "loadingError", "Landroid/widget/LinearLayout;", "getLoadingError", "()Landroid/widget/LinearLayout;", "loadingError$delegate", "Lkotlin/Lazy;", "loadingListener", "Lsdk/meizu/account/factor/authentication/sdk/view/LoadingListener;", "getLoadingListener", "()Lsdk/meizu/account/factor/authentication/sdk/view/LoadingListener;", "setLoadingListener", "(Lsdk/meizu/account/factor/authentication/sdk/view/LoadingListener;)V", "loadingStart", "getLoadingStart", "loadingStart$delegate", "onClick", "", "v", "Landroid/view/View;", "updateState", "state", "Lsdk/meizu/account/factor/authentication/sdk/view/LoadingState;", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LoadingView extends FrameLayout implements View.OnClickListener {
    @NotNull
    private final Lazy loadingError$delegate;
    @Nullable
    private LoadingListener loadingListener;
    @NotNull
    private final Lazy loadingStart$delegate;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                sdk.meizu.account.factor.authentication.sdk.view.LoadingState[] r0 = sdk.meizu.account.factor.authentication.sdk.view.LoadingState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                sdk.meizu.account.factor.authentication.sdk.view.LoadingState r1 = sdk.meizu.account.factor.authentication.sdk.view.LoadingState.LOADING     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                sdk.meizu.account.factor.authentication.sdk.view.LoadingState r1 = sdk.meizu.account.factor.authentication.sdk.view.LoadingState.ERROR     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                sdk.meizu.account.factor.authentication.sdk.view.LoadingState r1 = sdk.meizu.account.factor.authentication.sdk.view.LoadingState.SUCCESS     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: sdk.meizu.account.factor.authentication.sdk.view.LoadingView.WhenMappings.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoadingView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.loadingStart$delegate = LazyKt.lazy(new LoadingView$loadingStart$2(this));
        this.loadingError$delegate = LazyKt.lazy(new LoadingView$loadingError$2(this));
        LayoutInflater.from(context).inflate(R.layout.view_loading, this, true);
        getLoadingError().setOnClickListener(this);
    }

    private final LinearLayout getLoadingError() {
        Object value = this.loadingError$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (LinearLayout) value;
    }

    private final LinearLayout getLoadingStart() {
        Object value = this.loadingStart$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (LinearLayout) value;
    }

    @Nullable
    public final LoadingListener getLoadingListener() {
        return this.loadingListener;
    }

    public void onClick(@Nullable View view) {
        LoadingListener loadingListener2;
        if (view != null && view.getId() == R.id.loading_error && (loadingListener2 = this.loadingListener) != null) {
            loadingListener2.loadingStart();
        }
    }

    public final void setLoadingListener(@Nullable LoadingListener loadingListener2) {
        this.loadingListener = loadingListener2;
    }

    public final void updateState(@NotNull LoadingState loadingState) {
        Intrinsics.checkNotNullParameter(loadingState, "state");
        int i = WhenMappings.$EnumSwitchMapping$0[loadingState.ordinal()];
        if (i == 1) {
            getLoadingStart().setVisibility(0);
            getLoadingError().setVisibility(8);
        } else if (i == 2) {
            getLoadingStart().setVisibility(8);
            getLoadingError().setVisibility(0);
        } else if (i == 3) {
            getLoadingStart().setVisibility(8);
            getLoadingError().setVisibility(8);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LoadingView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LoadingView(@NotNull Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
