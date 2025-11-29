package com.upuphone.xr.sapp.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.meizu.common.widget.Switch;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.LayoutCardItemBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 %2\u00020\u0001:\u0001&B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0007J\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\b2\b\b\u0001\u0010\u0013\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\rJ\u0017\u0010\u0014\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0014\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\b2\b\b\u0001\u0010\u0013\u001a\u00020\n¢\u0006\u0004\b\u0014\u0010\rJ\u0017\u0010\u0017\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010$\u001a\u00020\u001d8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lcom/upuphone/xr/sapp/view/SettingView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "g", "", "type", "setCardType", "(I)V", "", "text", "setTitleText", "(Ljava/lang/String;)V", "setSubtitleText", "resId", "setIndicatorText", "Landroid/graphics/drawable/Drawable;", "drawable", "setIndicatorIcon", "(Landroid/graphics/drawable/Drawable;)V", "", "state", "setSwitchState", "(Z)V", "Lcom/upuphone/xr/sapp/databinding/LayoutCardItemBinding;", "a", "Lcom/upuphone/xr/sapp/databinding/LayoutCardItemBinding;", "getBinding", "()Lcom/upuphone/xr/sapp/databinding/LayoutCardItemBinding;", "setBinding", "(Lcom/upuphone/xr/sapp/databinding/LayoutCardItemBinding;)V", "binding", "b", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nSettingView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SettingView.kt\ncom/upuphone/xr/sapp/view/SettingView\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,116:1\n256#2,2:117\n256#2,2:119\n256#2,2:121\n256#2,2:123\n256#2,2:125\n256#2,2:127\n*S KotlinDebug\n*F\n+ 1 SettingView.kt\ncom/upuphone/xr/sapp/view/SettingView\n*L\n52#1:117,2\n53#1:119,2\n55#1:121,2\n56#1:123,2\n75#1:125,2\n80#1:127,2\n*E\n"})
public class SettingView extends ConstraintLayout {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public LayoutCardItemBinding f7985a;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/upuphone/xr/sapp/view/SettingView$Companion;", "", "()V", "TYPE_INDICATOR", "", "TYPE_SWITCH", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SettingView(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        g(context, attributeSet);
    }

    private final void g(Context context, AttributeSet attributeSet) {
        LayoutCardItemBinding a2 = LayoutCardItemBinding.a(LayoutInflater.from(context).inflate(R.layout.layout_card_item, this));
        Intrinsics.checkNotNullExpressionValue(a2, "bind(...)");
        setBinding(a2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SettingView);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        setCardType(obtainStyledAttributes.getInt(R.styleable.SettingView_setting_view_type, 0));
        setTitleText(obtainStyledAttributes.getString(R.styleable.SettingView_setting_view_title_text));
        setSubtitleText(obtainStyledAttributes.getString(R.styleable.SettingView_setting_view_subtitle_text));
        setIndicatorText(obtainStyledAttributes.getString(R.styleable.SettingView_setting_view_indicator_text));
        setIndicatorIcon(obtainStyledAttributes.getDrawable(R.styleable.SettingView_setting_view_indicator_icon));
        obtainStyledAttributes.recycle();
    }

    private final void setCardType(int i) {
        if (i == 0) {
            LinearLayout linearLayout = getBinding().e;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "llIndicator");
            linearLayout.setVisibility(8);
            Switch switchR = getBinding().f;
            Intrinsics.checkNotNullExpressionValue(switchR, "switchIndicator");
            switchR.setVisibility(0);
        } else if (i == 1) {
            LinearLayout linearLayout2 = getBinding().e;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "llIndicator");
            linearLayout2.setVisibility(0);
            Switch switchR2 = getBinding().f;
            Intrinsics.checkNotNullExpressionValue(switchR2, "switchIndicator");
            switchR2.setVisibility(8);
        }
    }

    @NotNull
    public final LayoutCardItemBinding getBinding() {
        LayoutCardItemBinding layoutCardItemBinding = this.f7985a;
        if (layoutCardItemBinding != null) {
            return layoutCardItemBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(@NotNull LayoutCardItemBinding layoutCardItemBinding) {
        Intrinsics.checkNotNullParameter(layoutCardItemBinding, "<set-?>");
        this.f7985a = layoutCardItemBinding;
    }

    public final void setIndicatorIcon(@Nullable Drawable drawable) {
        getBinding().d.setImageDrawable(drawable);
    }

    public final void setIndicatorText(@Nullable String str) {
        getBinding().g.setText(str);
    }

    public final void setSubtitleText(@Nullable String str) {
        TextView textView = getBinding().h;
        Intrinsics.checkNotNullExpressionValue(textView, "tvSubtitle");
        int i = 0;
        if (!(true ^ (str == null || str.length() == 0))) {
            i = 8;
        }
        textView.setVisibility(i);
        getBinding().h.setText(str);
    }

    public final void setSwitchState(boolean z) {
        getBinding().f.setChecked(z);
    }

    public final void setTitleText(@Nullable String str) {
        getBinding().i.setText(str);
    }

    public final void setIndicatorText(@StringRes int i) {
        getBinding().g.setText(i);
    }

    public final void setSubtitleText(@StringRes int i) {
        TextView textView = getBinding().h;
        Intrinsics.checkNotNullExpressionValue(textView, "tvSubtitle");
        textView.setVisibility(0);
        getBinding().h.setText(i);
    }
}
