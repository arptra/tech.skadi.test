package com.upuphone.ar.translation.phone.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.honey.account.h5.h;
import com.honey.account.h5.i;
import com.honey.account.h5.j;
import com.honey.account.h5.k;
import com.honey.account.h5.l;
import com.upuphone.ar.translation.phone.R;
import com.upuphone.ar.translation.phone.databinding.TransTitleBarLayoutBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0002>?B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\b\b\u0001\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\r2\b\b\u0001\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0018\u0010\u000fJ\u0015\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0019\u0010\u0017J\u0015\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0014¢\u0006\u0004\b\u001b\u0010\u0017J\u0015\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0014¢\u0006\u0004\b\u001d\u0010\u0017J\u0017\u0010\u001e\u001a\u00020\r2\b\b\u0001\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u001e\u0010\u000fJ\u0015\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u001f\u0010\u0017J\u0015\u0010 \u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0014¢\u0006\u0004\b \u0010\u0017J\u0015\u0010!\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0014¢\u0006\u0004\b!\u0010\u0017J\u0017\u0010\"\u001a\u00020\r2\b\b\u0001\u0010\f\u001a\u00020\t¢\u0006\u0004\b\"\u0010\u000fJ\u0015\u0010#\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b#\u0010\u0017J\u0015\u0010$\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0014¢\u0006\u0004\b$\u0010\u0017J\u0015\u0010%\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0014¢\u0006\u0004\b%\u0010\u0017J\u0015\u0010'\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u0010¢\u0006\u0004\b'\u0010\u0013J\u0015\u0010(\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b(\u0010\u0017J\u0015\u0010)\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0014¢\u0006\u0004\b)\u0010\u0017J\u001b\u0010,\u001a\u00020\r2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\r0*¢\u0006\u0004\b,\u0010-J\u001b\u0010.\u001a\u00020\r2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\r0*¢\u0006\u0004\b.\u0010-J\u001b\u0010/\u001a\u00020\r2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\r0*¢\u0006\u0004\b/\u0010-J\u001b\u00100\u001a\u00020\r2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\r0*¢\u0006\u0004\b0\u0010-J\u001b\u00101\u001a\u00020\r2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\r0*¢\u0006\u0004\b1\u0010-J\u0015\u00102\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b2\u0010\u0017R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00109\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010;\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u00108R\u0016\u0010=\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u00108¨\u0006@"}, d2 = {"Lcom/upuphone/ar/translation/phone/view/TransTitleBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "resId", "", "setIconBack", "(I)V", "", "title", "setBarTitle", "(Ljava/lang/String;)V", "", "isVisible", "setBarTitleVisible", "(Z)V", "setIconMenu", "setIconMenuVisible", "enable", "setIconMenuEnabled", "isAutoMirror", "setIconMenuAutoMirror", "setIconMenu1", "setIconMenu1Visible", "setIconMenu1Enabled", "setIconMenu1AutoMirror", "setIconMenu2", "setIconMenu2Visible", "setIconMenu2Enabled", "setIconMenu2AutoMirror", "text", "setTextMenu", "setTextMenuVisible", "setTextMenuEnabled", "Lkotlin/Function0;", "onClick", "l", "(Lkotlin/jvm/functions/Function0;)V", "r", "n", "p", "t", "setIconTipVisible", "Lcom/upuphone/ar/translation/phone/databinding/TransTitleBarLayoutBinding;", "a", "Lcom/upuphone/ar/translation/phone/databinding/TransTitleBarLayoutBinding;", "mBinding", "b", "Z", "mIsMenuAutoMirror", "c", "mIsMenu1AutoMirror", "d", "mIsMenu2AutoMirror", "BackClickListener", "MenuClickListener", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nTransTitleBar.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TransTitleBar.kt\ncom/upuphone/ar/translation/phone/view/TransTitleBar\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,492:1\n283#2,2:493\n262#2,2:495\n262#2,2:497\n262#2,2:499\n262#2,2:501\n262#2,2:503\n*S KotlinDebug\n*F\n+ 1 TransTitleBar.kt\ncom/upuphone/ar/translation/phone/view/TransTitleBar\n*L\n169#1:493,2\n194#1:495,2\n241#1:497,2\n288#1:499,2\n328#1:501,2\n469#1:503,2\n*E\n"})
public final class TransTitleBar extends ConstraintLayout {

    /* renamed from: a  reason: collision with root package name */
    public TransTitleBarLayoutBinding f6331a;
    public boolean b;
    public boolean c;
    public boolean d;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/upuphone/ar/translation/phone/view/TransTitleBar$BackClickListener;", "", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
    public interface BackClickListener {
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/upuphone/ar/translation/phone/view/TransTitleBar$MenuClickListener;", "", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
    public interface MenuClickListener {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TransTitleBar(@NotNull Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static final void m(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "$onClick");
        function0.invoke();
    }

    public static final void o(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "$onClick");
        function0.invoke();
    }

    public static final void q(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "$onClick");
        function0.invoke();
    }

    public static final void s(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "$onClick");
        function0.invoke();
    }

    public static final void u(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "$onClick");
        function0.invoke();
    }

    public final void l(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "onClick");
        this.f6331a.b.setOnClickListener(new j(function0));
    }

    public final void n(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "onClick");
        this.f6331a.d.setOnClickListener(new h(function0));
    }

    public final void p(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "onClick");
        this.f6331a.e.setOnClickListener(new i(function0));
    }

    public final void r(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "onClick");
        this.f6331a.c.setOnClickListener(new k(function0));
    }

    public final void setBarTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.f6331a.i.setText(str);
    }

    public final void setBarTitleVisible(boolean z) {
        TextView textView = this.f6331a.i;
        Intrinsics.checkNotNullExpressionValue(textView, "tvTitle");
        textView.setVisibility(z ^ true ? 4 : 0);
    }

    public final void setIconBack(@DrawableRes int i) {
        ImageView imageView = this.f6331a.b;
        Drawable drawable = ContextCompat.getDrawable(getContext(), i);
        if (drawable != null) {
            drawable.setAutoMirrored(true);
        } else {
            drawable = null;
        }
        imageView.setImageDrawable(drawable);
    }

    public final void setIconMenu(@DrawableRes int i) {
        ImageView imageView = this.f6331a.c;
        Drawable drawable = ContextCompat.getDrawable(getContext(), i);
        if (drawable != null) {
            drawable.setAutoMirrored(this.b);
        } else {
            drawable = null;
        }
        imageView.setImageDrawable(drawable);
    }

    public final void setIconMenu1(@DrawableRes int i) {
        ImageView imageView = this.f6331a.d;
        Drawable drawable = ContextCompat.getDrawable(getContext(), i);
        if (drawable != null) {
            drawable.setAutoMirrored(this.c);
        } else {
            drawable = null;
        }
        imageView.setImageDrawable(drawable);
    }

    public final void setIconMenu1AutoMirror(boolean z) {
        this.c = z;
        Drawable drawable = this.f6331a.d.getDrawable();
        if (drawable != null) {
            drawable.setAutoMirrored(z);
            this.f6331a.d.setImageDrawable(drawable);
        }
    }

    public final void setIconMenu1Enabled(boolean z) {
        this.f6331a.d.setEnabled(z);
    }

    public final void setIconMenu1Visible(boolean z) {
        ImageView imageView = this.f6331a.d;
        Intrinsics.checkNotNullExpressionValue(imageView, "ivMenu1");
        imageView.setVisibility(z ? 0 : 8);
    }

    public final void setIconMenu2(@DrawableRes int i) {
        ImageView imageView = this.f6331a.e;
        Drawable drawable = ContextCompat.getDrawable(getContext(), i);
        if (drawable != null) {
            drawable.setAutoMirrored(this.d);
        } else {
            drawable = null;
        }
        imageView.setImageDrawable(drawable);
    }

    public final void setIconMenu2AutoMirror(boolean z) {
        this.d = z;
        Drawable drawable = this.f6331a.e.getDrawable();
        if (drawable != null) {
            drawable.setAutoMirrored(z);
            this.f6331a.e.setImageDrawable(drawable);
        }
    }

    public final void setIconMenu2Enabled(boolean z) {
        this.f6331a.e.setEnabled(z);
    }

    public final void setIconMenu2Visible(boolean z) {
        ImageView imageView = this.f6331a.e;
        Intrinsics.checkNotNullExpressionValue(imageView, "ivMenu2");
        imageView.setVisibility(z ? 0 : 8);
    }

    public final void setIconMenuAutoMirror(boolean z) {
        this.b = z;
        Drawable drawable = this.f6331a.c.getDrawable();
        if (drawable != null) {
            drawable.setAutoMirrored(z);
            this.f6331a.c.setImageDrawable(drawable);
        }
    }

    public final void setIconMenuEnabled(boolean z) {
        this.f6331a.c.setEnabled(z);
    }

    public final void setIconMenuVisible(boolean z) {
        ImageView imageView = this.f6331a.c;
        Intrinsics.checkNotNullExpressionValue(imageView, "ivMenu");
        imageView.setVisibility(z ? 0 : 8);
    }

    public final void setIconTipVisible(boolean z) {
        ImageView imageView = this.f6331a.f;
        Intrinsics.checkNotNullExpressionValue(imageView, "ivTip");
        imageView.setVisibility(z ? 0 : 8);
    }

    public final void setTextMenu(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.f6331a.h.setText(str);
    }

    public final void setTextMenuEnabled(boolean z) {
        if (this.f6331a.h.isEnabled() != z) {
            this.f6331a.h.setEnabled(z);
            this.f6331a.h.setTextColor(getContext().getColor(z ? R.color.color_title_bar_menu_text_enable : R.color.color_title_bar_menu_text_disable));
        }
    }

    public final void setTextMenuVisible(boolean z) {
        TextView textView = this.f6331a.h;
        Intrinsics.checkNotNullExpressionValue(textView, "tvMenu");
        textView.setVisibility(z ? 0 : 8);
    }

    public final void t(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "onClick");
        this.f6331a.h.setOnClickListener(new l(function0));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TransTitleBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TransTitleBar(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        TransTitleBarLayoutBinding c2 = TransTitleBarLayoutBinding.c(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(c2, "inflate(...)");
        this.f6331a = c2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TransTitleBar);
        setIconBack(obtainStyledAttributes.getResourceId(R.styleable.TransTitleBar_bar_icon_back, R.drawable.trans_ic_back));
        String string = obtainStyledAttributes.getString(R.styleable.TransTitleBar_bar_title);
        String str = "";
        string = string == null ? str : string;
        Intrinsics.checkNotNull(string);
        setBarTitle(string);
        setBarTitleVisible(obtainStyledAttributes.getBoolean(R.styleable.TransTitleBar_bar_title_visible, false));
        setIconMenu(obtainStyledAttributes.getResourceId(R.styleable.TransTitleBar_bar_icon_menu, R.drawable.tl_icon_setting));
        setIconMenuVisible(obtainStyledAttributes.getBoolean(R.styleable.TransTitleBar_bar_icon_menu_visible, false));
        setIconMenuEnabled(obtainStyledAttributes.getBoolean(R.styleable.TransTitleBar_bar_icon_menu_enable, true));
        setIconMenuAutoMirror(obtainStyledAttributes.getBoolean(R.styleable.TransTitleBar_bar_icon_menu_mirror, true));
        setIconMenu1(obtainStyledAttributes.getResourceId(R.styleable.TransTitleBar_bar_icon_menu1, R.drawable.tl_icon_ai));
        setIconMenu1Visible(obtainStyledAttributes.getBoolean(R.styleable.TransTitleBar_bar_icon_menu1_visible, false));
        setIconMenu1Enabled(obtainStyledAttributes.getBoolean(R.styleable.TransTitleBar_bar_icon_menu1_enable, true));
        setIconMenu1AutoMirror(obtainStyledAttributes.getBoolean(R.styleable.TransTitleBar_bar_icon_menu1_mirror, true));
        setIconMenu2(obtainStyledAttributes.getResourceId(R.styleable.TransTitleBar_bar_icon_menu2, R.drawable.tl_icon_share));
        setIconMenu2Visible(obtainStyledAttributes.getBoolean(R.styleable.TransTitleBar_bar_icon_menu2_visible, false));
        setIconMenu2Enabled(obtainStyledAttributes.getBoolean(R.styleable.TransTitleBar_bar_icon_menu2_enable, true));
        setIconMenu2AutoMirror(obtainStyledAttributes.getBoolean(R.styleable.TransTitleBar_bar_icon_menu2_mirror, true));
        setIconTipVisible(obtainStyledAttributes.getBoolean(R.styleable.TransTitleBar_bar_icon_tip_visible, false));
        String string2 = obtainStyledAttributes.getString(R.styleable.TransTitleBar_bar_text_menu);
        str = string2 != null ? string2 : str;
        Intrinsics.checkNotNull(str);
        setTextMenu(str);
        setTextMenuVisible(obtainStyledAttributes.getBoolean(R.styleable.TransTitleBar_bar_text_menu_visible, false));
        setTextMenuEnabled(obtainStyledAttributes.getBoolean(R.styleable.TransTitleBar_bar_text_menu_enable, false));
        obtainStyledAttributes.recycle();
    }
}
