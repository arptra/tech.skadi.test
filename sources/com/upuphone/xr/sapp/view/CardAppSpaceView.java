package com.upuphone.xr.sapp.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.CardAppSpaceLayoutBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0015\u0010\u0010J\u0017\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0016\u0010\u0014J\u0017\u0010\u0019\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001b\u0010\fJ\u0017\u0010\u001d\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u001d\u0010\u001aJ\u001f\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001e\u0010\u0007R\"\u0010&\u001a\u00020\u001f8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006'"}, d2 = {"Lcom/upuphone/xr/sapp/view/CardAppSpaceView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/graphics/drawable/Drawable;", "drawable", "", "setRightIconDrawable", "(Landroid/graphics/drawable/Drawable;)V", "", "dimension", "setTitleSize", "(F)V", "", "color", "setTitleColor", "(I)V", "setSubTitleSize", "setSubTitleColor", "", "value", "setCardSubTitle", "(Ljava/lang/String;)V", "setIconDrawable", "string", "setTitleText", "g", "Lcom/upuphone/xr/sapp/databinding/CardAppSpaceLayoutBinding;", "a", "Lcom/upuphone/xr/sapp/databinding/CardAppSpaceLayoutBinding;", "getBinding", "()Lcom/upuphone/xr/sapp/databinding/CardAppSpaceLayoutBinding;", "setBinding", "(Lcom/upuphone/xr/sapp/databinding/CardAppSpaceLayoutBinding;)V", "binding", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nCardAppSpaceView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CardAppSpaceView.kt\ncom/upuphone/xr/sapp/view/CardAppSpaceView\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,117:1\n256#2,2:118\n256#2,2:120\n*S KotlinDebug\n*F\n+ 1 CardAppSpaceView.kt\ncom/upuphone/xr/sapp/view/CardAppSpaceView\n*L\n79#1:118,2\n96#1:120,2\n*E\n"})
public final class CardAppSpaceView extends ConstraintLayout {

    /* renamed from: a  reason: collision with root package name */
    public CardAppSpaceLayoutBinding f7941a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CardAppSpaceView(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        g(context, attributeSet);
    }

    private final void setRightIconDrawable(Drawable drawable) {
        getBinding().c.setVisibility(drawable != null ? 0 : 4);
        getBinding().c.setImageDrawable(drawable);
    }

    private final void setSubTitleColor(int i) {
        getBinding().d.setTextColor(i);
    }

    private final void setSubTitleSize(float f) {
        getBinding().d.setTextSize(0, f);
    }

    private final void setTitleColor(int i) {
        getBinding().e.setTextColor(i);
    }

    private final void setTitleSize(float f) {
        getBinding().e.setTextSize(0, f);
    }

    public final void g(Context context, AttributeSet attributeSet) {
        CardAppSpaceLayoutBinding a2 = CardAppSpaceLayoutBinding.a(LayoutInflater.from(context).inflate(R.layout.card_app_space_layout, this));
        Intrinsics.checkNotNullExpressionValue(a2, "bind(...)");
        setBinding(a2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CardAppSpaceView);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        setIconDrawable(obtainStyledAttributes.getDrawable(R.styleable.CardAppSpaceView_app_space_icon));
        setRightIconDrawable(obtainStyledAttributes.getDrawable(R.styleable.CardAppSpaceView_app_space_right_icon));
        setTitleText(obtainStyledAttributes.getString(R.styleable.CardAppSpaceView_app_space_title));
        setCardSubTitle(obtainStyledAttributes.getString(R.styleable.CardAppSpaceView_app_space_sub_title));
        obtainStyledAttributes.recycle();
    }

    @NotNull
    public final CardAppSpaceLayoutBinding getBinding() {
        CardAppSpaceLayoutBinding cardAppSpaceLayoutBinding = this.f7941a;
        if (cardAppSpaceLayoutBinding != null) {
            return cardAppSpaceLayoutBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(@NotNull CardAppSpaceLayoutBinding cardAppSpaceLayoutBinding) {
        Intrinsics.checkNotNullParameter(cardAppSpaceLayoutBinding, "<set-?>");
        this.f7941a = cardAppSpaceLayoutBinding;
    }

    public final void setCardSubTitle(@Nullable String str) {
        getBinding().d.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
        getBinding().d.setText(str);
    }

    public final void setIconDrawable(@Nullable Drawable drawable) {
        TextView textView = getBinding().e;
        Intrinsics.checkNotNullExpressionValue(textView, "cardTitle");
        int i = 0;
        if (!(drawable != null)) {
            i = 8;
        }
        textView.setVisibility(i);
        getBinding().b.setImageDrawable(drawable);
    }

    public final void setTitleText(@Nullable String str) {
        TextView textView = getBinding().e;
        Intrinsics.checkNotNullExpressionValue(textView, "cardTitle");
        int i = 0;
        if (!(true ^ (str == null || StringsKt.isBlank(str)))) {
            i = 8;
        }
        textView.setVisibility(i);
        getBinding().e.setText(str);
    }
}
