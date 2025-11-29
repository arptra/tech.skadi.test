package com.upuphone.xr.sapp.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.CardItemLayoutBinding;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 /2\u00020\u0001:\u0001VB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0007J\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0017\u0010\u0015J\u0019\u0010\u0018\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0018\u0010\u0011J\u0017\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001a\u0010\u0015J\u0017\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001b\u0010\u0015J\u0017\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001c\u0010\u0015J\u0017\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001e\u0010\rJ\u0017\u0010 \u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001fH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\"\u0010\u0015J\u0017\u0010$\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u0012H\u0002¢\u0006\u0004\b$\u0010\u0015J\u000f\u0010%\u001a\u00020\bH\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010'¢\u0006\u0004\b)\u0010*J\r\u0010+\u001a\u00020\b¢\u0006\u0004\b+\u0010&J\u0017\u0010)\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010,¢\u0006\u0004\b)\u0010-J\r\u0010.\u001a\u00020\b¢\u0006\u0004\b.\u0010&J\r\u0010/\u001a\u00020\b¢\u0006\u0004\b/\u0010&J\u0017\u00101\u001a\u00020\b2\b\u00100\u001a\u0004\u0018\u00010'¢\u0006\u0004\b1\u0010*J\u0017\u00102\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b2\u0010\u0011J\u0017\u00104\u001a\u00020\b2\b\b\u0001\u00103\u001a\u00020\u0012¢\u0006\u0004\b4\u0010\u0015J\u0017\u00106\u001a\u00020\b2\b\u00105\u001a\u0004\u0018\u00010'¢\u0006\u0004\b6\u0010*J\u0015\u00108\u001a\u00020\b2\u0006\u00107\u001a\u00020\n¢\u0006\u0004\b8\u0010\rJ\u0017\u0010;\u001a\u00020\b2\b\u0010:\u001a\u0004\u0018\u000109¢\u0006\u0004\b;\u0010<J\u0015\u0010>\u001a\u00020\b2\u0006\u0010=\u001a\u00020\n¢\u0006\u0004\b>\u0010\rJ\r\u0010?\u001a\u00020\n¢\u0006\u0004\b?\u0010@J\u0017\u0010C\u001a\u00020\b2\u0006\u0010B\u001a\u00020AH\u0007¢\u0006\u0004\bC\u0010DJ\u0017\u0010F\u001a\u00020\b2\b\u0010E\u001a\u0004\u0018\u00010'¢\u0006\u0004\bF\u0010*J\u0015\u0010H\u001a\u00020\b2\u0006\u0010G\u001a\u00020\n¢\u0006\u0004\bH\u0010\rJ\u0017\u0010I\u001a\u00020\b2\b\u00105\u001a\u0004\u0018\u00010'¢\u0006\u0004\bI\u0010*J\u0017\u0010J\u001a\u00020\b2\u0006\u0010=\u001a\u00020\nH\u0016¢\u0006\u0004\bJ\u0010\rR\"\u0010N\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\t\u0010K\u001a\u0004\bL\u0010@\"\u0004\bM\u0010\rR\"\u0010U\u001a\u00020O8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b+\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010T¨\u0006W"}, d2 = {"Lcom/upuphone/xr/sapp/view/CardItemView;", "Landroid/widget/RelativeLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "a", "", "center", "setContentGravity", "(Z)V", "Landroid/graphics/drawable/Drawable;", "drawable", "setCardDrawable", "(Landroid/graphics/drawable/Drawable;)V", "", "type", "setCardType", "(I)V", "size", "setIconSize", "setRightIconDrawable", "dimension", "setTitleMarginStart", "setSubTitleMarginStart", "setIconMarginStart", "isBold", "setTitleStyle", "", "setTitleSize", "(F)V", "setTitleLineHeight", "color", "setTitleColor", "e", "()V", "", "value", "setCardSubTitle", "(Ljava/lang/String;)V", "b", "Landroid/text/SpannableString;", "(Landroid/text/SpannableString;)V", "d", "c", "str", "setRightContent", "setIconDrawable", "resId", "setIcon", "string", "setTitleText", "isShow", "setNotifyBadgeState", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "listener", "setSwitchListener", "(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V", "state", "setSwitchState", "getSwitchState", "()Z", "Landroid/view/View$OnTouchListener;", "onTouchListener", "setSwitchOnTouchListener", "(Landroid/view/View$OnTouchListener;)V", "text", "setRedTipText", "isVisible", "setRedTipBadgeState", "setCardTitleText", "setStartIconState", "Z", "getIconStarted", "setIconStarted", "iconStarted", "Lcom/upuphone/xr/sapp/databinding/CardItemLayoutBinding;", "Lcom/upuphone/xr/sapp/databinding/CardItemLayoutBinding;", "getBinding", "()Lcom/upuphone/xr/sapp/databinding/CardItemLayoutBinding;", "setBinding", "(Lcom/upuphone/xr/sapp/databinding/CardItemLayoutBinding;)V", "binding", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nCardItemView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CardItemView.kt\ncom/upuphone/xr/sapp/view/CardItemView\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,344:1\n256#2,2:345\n256#2,2:347\n256#2,2:349\n256#2,2:351\n256#2,2:353\n*S KotlinDebug\n*F\n+ 1 CardItemView.kt\ncom/upuphone/xr/sapp/view/CardItemView\n*L\n197#1:345,2\n205#1:347,2\n246#1:349,2\n270#1:351,2\n317#1:353,2\n*E\n"})
public class CardItemView extends RelativeLayout {
    public static final Companion c = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public boolean f7942a;
    public CardItemLayoutBinding b;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/sapp/view/CardItemView$Companion;", "", "()V", "TYPE_ADJION_ICON", "", "TYPE_GLASS_MANAGER", "TYPE_IMAGE", "TYPE_START_ICON", "TYPE_SWITCH", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CardItemView(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        a(context, attributeSet);
    }

    private final void setCardDrawable(Drawable drawable) {
        if (drawable != null) {
            getBinding().getRoot().setBackground(drawable);
        }
    }

    private final void setCardType(int i) {
        if (i == 1) {
            getBinding().d.setVisibility(8);
            getBinding().e.setVisibility(8);
            getBinding().i.setVisibility(0);
            getBinding().c.setVisibility(8);
            setSubTitleMarginStart(StaticMethodUtilsKt.h(0.0f));
        } else if (i == 2) {
            getBinding().c.setVisibility(8);
            setSubTitleMarginStart(StaticMethodUtilsKt.h(0.0f));
            getBinding().i.setVisibility(8);
        } else if (i == 3) {
            getBinding().c.setVisibility(8);
            setSubTitleMarginStart(StaticMethodUtilsKt.h(0.0f));
            getBinding().j.setVisibility(0);
        } else if (i != 4) {
            getBinding().i.setVisibility(8);
        } else {
            getBinding().c.setVisibility(0);
        }
    }

    private final void setContentGravity(boolean z) {
        getBinding().b.setGravity(z ? 1 : 8388611);
    }

    private final void setIconMarginStart(int i) {
        ViewGroup.LayoutParams layoutParams = getBinding().c.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            marginLayoutParams.setMarginStart(i);
        }
    }

    private final void setIconSize(int i) {
        ViewGroup.LayoutParams layoutParams = getBinding().c.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = i;
        getBinding().c.setLayoutParams(layoutParams);
    }

    private final void setRightIconDrawable(Drawable drawable) {
        getBinding().d.setVisibility(drawable != null ? 0 : 4);
        getBinding().d.setImageDrawable(drawable);
    }

    private final void setSubTitleMarginStart(int i) {
        ViewGroup.LayoutParams layoutParams = getBinding().g.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            marginLayoutParams.setMarginStart(i);
        }
    }

    private final void setTitleColor(int i) {
        getBinding().h.setTextColor(i);
    }

    private final void setTitleLineHeight(int i) {
        if (i > 0) {
            getBinding().h.setLineHeight(i);
        }
    }

    private final void setTitleMarginStart(int i) {
        ViewGroup.LayoutParams layoutParams = getBinding().h.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            marginLayoutParams.setMarginStart(i);
        }
        setSubTitleMarginStart(i);
    }

    private final void setTitleSize(float f) {
        getBinding().h.setTextSize(0, f);
    }

    private final void setTitleStyle(boolean z) {
        if (z) {
            getBinding().h.setTypeface(Typeface.DEFAULT_BOLD);
        }
    }

    public final void a(Context context, AttributeSet attributeSet) {
        CardItemLayoutBinding a2 = CardItemLayoutBinding.a(LayoutInflater.from(context).inflate(R.layout.card_item_layout, this));
        Intrinsics.checkNotNullExpressionValue(a2, "bind(...)");
        setBinding(a2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CardItemView);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        if (obtainStyledAttributes.getBoolean(R.styleable.CardItemView_card_shortcut_instruction, false)) {
            e();
        }
        setContentGravity(obtainStyledAttributes.getBoolean(R.styleable.CardItemView_card_gravity_center, false));
        setCardDrawable(obtainStyledAttributes.getDrawable(R.styleable.CardItemView_card_background));
        setIconDrawable(obtainStyledAttributes.getDrawable(R.styleable.CardItemView_card_icon));
        setIconSize(obtainStyledAttributes.getDimensionPixelSize(R.styleable.CardItemView_card_icon_size, StaticMethodUtilsKt.h(20.0f)));
        setRightIconDrawable(obtainStyledAttributes.getDrawable(R.styleable.CardItemView_card_right_icon));
        setTitleText(obtainStyledAttributes.getString(R.styleable.CardItemView_card_title));
        setTitleMarginStart(obtainStyledAttributes.getDimensionPixelSize(R.styleable.CardItemView_card_title_margin, 0));
        setIconMarginStart(obtainStyledAttributes.getDimensionPixelSize(R.styleable.CardItemView_card_icon_margin, 0));
        setTitleStyle(obtainStyledAttributes.getBoolean(R.styleable.CardItemView_card_title_bold, false));
        setCardSubTitle(obtainStyledAttributes.getString(R.styleable.CardItemView_card_sub_title));
        setTitleSize(obtainStyledAttributes.getDimension(R.styleable.CardItemView_card_title_size, context.getResources().getDimension(R.dimen.card_default_title_size)));
        setCardType(obtainStyledAttributes.getInt(R.styleable.CardItemView_card_type, 0));
        setTitleLineHeight(obtainStyledAttributes.getDimensionPixelSize(R.styleable.CardItemView_card_title_line_height, (int) TypedValue.applyDimension(2, 0.0f, context.getResources().getDisplayMetrics())));
        setTitleColor(obtainStyledAttributes.getColor(R.styleable.CardItemView_card_title_color, context.getColor(R.color.title_text_color)));
        setRedTipText(obtainStyledAttributes.getString(R.styleable.CardItemView_card_red_tip_text));
        setRightContent(obtainStyledAttributes.getString(R.styleable.CardItemView_card_right_content));
        obtainStyledAttributes.recycle();
    }

    public final void b() {
        getBinding().g.setMovementMethod(LinkMovementMethod.getInstance());
        getBinding().g.setHighlightColor(0);
    }

    public final void c() {
        getBinding().g.setMaxLines(1);
        getBinding().g.setEllipsize(TextUtils.TruncateAt.END);
    }

    public final void d() {
        getBinding().g.setMovementMethod(LinkMovementMethod.getInstance());
        getBinding().g.setHighlightColor(0);
    }

    public final void e() {
        getBinding().e.setVisibility(8);
        getBinding().d.setVisibility(8);
        getBinding().m.setVisibility(8);
        getBinding().i.setVisibility(8);
    }

    @NotNull
    public final CardItemLayoutBinding getBinding() {
        CardItemLayoutBinding cardItemLayoutBinding = this.b;
        if (cardItemLayoutBinding != null) {
            return cardItemLayoutBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final boolean getIconStarted() {
        return this.f7942a;
    }

    public final boolean getSwitchState() {
        return getBinding().i.isChecked();
    }

    public final void setBinding(@NotNull CardItemLayoutBinding cardItemLayoutBinding) {
        Intrinsics.checkNotNullParameter(cardItemLayoutBinding, "<set-?>");
        this.b = cardItemLayoutBinding;
    }

    public final void setCardSubTitle(@Nullable String str) {
        getBinding().g.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
        getBinding().g.setText(str);
    }

    public final void setCardTitleText(@Nullable String str) {
        getBinding().h.setText(str);
    }

    public final void setIcon(@DrawableRes int i) {
        ImageView imageView = getBinding().c;
        Intrinsics.checkNotNullExpressionValue(imageView, "cardIcon");
        imageView.setVisibility(0);
        getBinding().c.setImageResource(i);
    }

    public final void setIconDrawable(@Nullable Drawable drawable) {
        TextView textView = getBinding().h;
        Intrinsics.checkNotNullExpressionValue(textView, "cardTitle");
        int i = 0;
        if (!(drawable != null)) {
            i = 8;
        }
        textView.setVisibility(i);
        getBinding().c.setImageDrawable(drawable);
    }

    public final void setIconStarted(boolean z) {
        this.f7942a = z;
    }

    public final void setNotifyBadgeState(boolean z) {
        ImageView imageView = getBinding().e;
        Intrinsics.checkNotNullExpressionValue(imageView, "cardRightNotifyIcon");
        imageView.setVisibility(z ? 0 : 8);
    }

    public final void setRedTipBadgeState(boolean z) {
        TextView textView = getBinding().l;
        Intrinsics.checkNotNullExpressionValue(textView, "tvRedTips");
        textView.setVisibility(z ? 0 : 8);
    }

    public final void setRedTipText(@Nullable String str) {
        getBinding().l.setText(str);
    }

    public final void setRightContent(@Nullable String str) {
        getBinding().m.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
        getBinding().m.setText(str);
    }

    public void setStartIconState(boolean z) {
        this.f7942a = z;
        if (z) {
            getBinding().j.setBackground(getResources().getDrawable(R.drawable.permission_started_icon));
            getBinding().j.setTextColor(getContext().getColor(R.color.card_start_icon_text_color_setted));
            getBinding().j.setText(GlobalExtKt.h(R.string.permission_started));
            return;
        }
        getBinding().j.setBackground(getResources().getDrawable(R.drawable.permission_goto_start_icon));
        getBinding().j.setTextColor(getContext().getColor(R.color.white));
        getBinding().j.setText(GlobalExtKt.h(R.string.goto_start_permission));
    }

    public final void setSwitchListener(@Nullable CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        getBinding().i.setOnCheckedChangeListener(onCheckedChangeListener);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void setSwitchOnTouchListener(@NotNull View.OnTouchListener onTouchListener) {
        Intrinsics.checkNotNullParameter(onTouchListener, "onTouchListener");
        getBinding().i.setOnTouchListener(onTouchListener);
    }

    public final void setSwitchState(boolean z) {
        getBinding().i.setChecked(z);
    }

    public final void setTitleText(@Nullable String str) {
        TextView textView = getBinding().h;
        Intrinsics.checkNotNullExpressionValue(textView, "cardTitle");
        int i = 0;
        if (!(true ^ (str == null || StringsKt.isBlank(str)))) {
            i = 8;
        }
        textView.setVisibility(i);
        getBinding().h.setText(str);
    }

    public final void setCardSubTitle(@Nullable SpannableString spannableString) {
        getBinding().g.setVisibility(TextUtils.isEmpty(spannableString) ? 8 : 0);
        getBinding().g.setText(spannableString);
    }
}
