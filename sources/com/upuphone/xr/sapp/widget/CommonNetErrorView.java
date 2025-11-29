package com.upuphone.xr.sapp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import com.honey.account.g9.a;
import com.honey.account.g9.b;
import com.upuphone.xr.sapp.common.R;
import com.upuphone.xr.sapp.common.databinding.CommonNetErrorBinding;
import com.upuphone.xr.sapp.utils.ViewExtKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001b\u001cB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001d"}, d2 = {"Lcom/upuphone/xr/sapp/widget/CommonNetErrorView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "errorType", "", "setErrorType", "(I)V", "Lcom/upuphone/xr/sapp/common/databinding/CommonNetErrorBinding;", "a", "Lcom/upuphone/xr/sapp/common/databinding/CommonNetErrorBinding;", "binding", "Lcom/upuphone/xr/sapp/widget/CommonNetErrorView$Listener;", "b", "Lcom/upuphone/xr/sapp/widget/CommonNetErrorView$Listener;", "getListener", "()Lcom/upuphone/xr/sapp/widget/CommonNetErrorView$Listener;", "setListener", "(Lcom/upuphone/xr/sapp/widget/CommonNetErrorView$Listener;)V", "listener", "c", "Companion", "Listener", "lib_common_release"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nCommonNetErrorView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommonNetErrorView.kt\ncom/upuphone/xr/sapp/widget/CommonNetErrorView\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,64:1\n262#2,2:65\n262#2,2:67\n262#2,2:69\n262#2,2:71\n*S KotlinDebug\n*F\n+ 1 CommonNetErrorView.kt\ncom/upuphone/xr/sapp/widget/CommonNetErrorView\n*L\n50#1:65,2\n51#1:67,2\n54#1:69,2\n55#1:71,2\n*E\n"})
public final class CommonNetErrorView extends FrameLayout {
    public static final Companion c = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final CommonNetErrorBinding f8120a;
    public Listener b;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/upuphone/xr/sapp/widget/CommonNetErrorView$Companion;", "", "()V", "ERROR_NETWORK_ERROR", "", "ERROR_NO_NETWORK", "TAG", "", "lib_common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/upuphone/xr/sapp/widget/CommonNetErrorView$Listener;", "", "", "a", "()V", "b", "lib_common_release"}, k = 1, mv = {1, 9, 0})
    public interface Listener {
        void a();

        void b();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CommonNetErrorView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static final void c(CommonNetErrorView commonNetErrorView, View view) {
        Intrinsics.checkNotNullParameter(commonNetErrorView, "this$0");
        Listener listener = commonNetErrorView.b;
        if (listener != null) {
            listener.a();
        }
    }

    public static final void d(CommonNetErrorView commonNetErrorView, View view) {
        Intrinsics.checkNotNullParameter(commonNetErrorView, "this$0");
        Listener listener = commonNetErrorView.b;
        if (listener != null) {
            listener.b();
        }
    }

    @Nullable
    public final Listener getListener() {
        return this.b;
    }

    public final void setErrorType(int i) {
        if (i == 0) {
            Button button = this.f8120a.b;
            Intrinsics.checkNotNullExpressionValue(button, "btnRetry");
            button.setVisibility(8);
            Button button2 = this.f8120a.c;
            Intrinsics.checkNotNullExpressionValue(button2, "btnSetupNetwork");
            button2.setVisibility(0);
            this.f8120a.e.setText(R.string.network_not_available_pls_check);
            return;
        }
        Button button3 = this.f8120a.b;
        Intrinsics.checkNotNullExpressionValue(button3, "btnRetry");
        button3.setVisibility(0);
        Button button4 = this.f8120a.c;
        Intrinsics.checkNotNullExpressionValue(button4, "btnSetupNetwork");
        button4.setVisibility(8);
        this.f8120a.e.setText(R.string.network_error_pls_retry_later);
    }

    public final void setListener(@Nullable Listener listener) {
        this.b = listener;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CommonNetErrorView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CommonNetErrorView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CommonNetErrorView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        CommonNetErrorBinding c2 = CommonNetErrorBinding.c(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(c2, "inflate(...)");
        this.f8120a = c2;
        Button button = c2.c;
        Intrinsics.checkNotNullExpressionValue(button, "btnSetupNetwork");
        ViewExtKt.b(button, new a(this));
        Button button2 = c2.b;
        Intrinsics.checkNotNullExpressionValue(button2, "btnRetry");
        ViewExtKt.b(button2, new b(this));
    }
}
