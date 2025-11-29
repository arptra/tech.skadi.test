package com.upuphone.ar.transcribe.phone.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.honey.account.y4.j;
import com.honey.account.y4.k;
import com.honey.account.y4.l;
import com.honey.account.y4.m;
import com.honey.account.y4.n;
import com.upuphone.ar.transcribe.R;
import com.upuphone.ar.transcribe.databinding.TranscribeTitleBarLayoutBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u000201B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\b\b\u0001\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\r2\b\b\u0001\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0018\u0010\u000fJ\u0017\u0010\u0019\u001a\u00020\r2\b\b\u0001\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0019\u0010\u000fJ\u0015\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u001a\u0010\u0017J\u001b\u0010\u001d\u001a\u00020\r2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010 \u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u0014¢\u0006\u0004\b \u0010\u0017J\u0015\u0010!\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b!\u0010\u0017J\u0015\u0010\"\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u0014¢\u0006\u0004\b\"\u0010\u0017J\u0017\u0010#\u001a\u00020\r2\b\b\u0001\u0010\f\u001a\u00020\t¢\u0006\u0004\b#\u0010\u000fJ\u0015\u0010$\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u0014¢\u0006\u0004\b$\u0010\u0017J\u0015\u0010%\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b%\u0010\u0017J\u0017\u0010&\u001a\u00020\r2\b\b\u0001\u0010\f\u001a\u00020\t¢\u0006\u0004\b&\u0010\u000fJ\u0015\u0010'\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b'\u0010\u0017J\u001b\u0010(\u001a\u00020\r2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u001b¢\u0006\u0004\b(\u0010\u001eJ\u001b\u0010)\u001a\u00020\r2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u001b¢\u0006\u0004\b)\u0010\u001eJ\u001b\u0010*\u001a\u00020\r2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u001b¢\u0006\u0004\b*\u0010\u001eJ\u001b\u0010+\u001a\u00020\r2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u001b¢\u0006\u0004\b+\u0010\u001eR\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010.¨\u00062"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/view/TransTitleBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "resId", "", "setIconBack", "(I)V", "", "title", "setBarTitle", "(Ljava/lang/String;)V", "", "isVisible", "setBarTitleVisible", "(Z)V", "setIconMenu", "setTextMenu", "setTextMenuVisible", "Lkotlin/Function0;", "onClick", "t", "(Lkotlin/jvm/functions/Function0;)V", "enable", "setTextMenuEnable", "setIconMenuVisible", "setIconMenuEnable", "setIconMenu2", "setMenu2Enable", "setIconMenu2Visible", "setIconMenu3", "setIconMenu3Visible", "l", "r", "n", "p", "Lcom/upuphone/ar/transcribe/databinding/TranscribeTitleBarLayoutBinding;", "a", "Lcom/upuphone/ar/transcribe/databinding/TranscribeTitleBarLayoutBinding;", "mBinding", "BackClickListener", "MenuClickListener", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nTransTitleBar.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TransTitleBar.kt\ncom/upuphone/ar/transcribe/phone/view/TransTitleBar\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,280:1\n283#2,2:281\n262#2,2:283\n262#2,2:285\n262#2,2:287\n262#2,2:289\n*S KotlinDebug\n*F\n+ 1 TransTitleBar.kt\ncom/upuphone/ar/transcribe/phone/view/TransTitleBar\n*L\n100#1:281,2\n117#1:283,2\n136#1:285,2\n162#1:287,2\n180#1:289,2\n*E\n"})
public final class TransTitleBar extends ConstraintLayout {

    /* renamed from: a  reason: collision with root package name */
    public TranscribeTitleBarLayoutBinding f6136a;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/view/TransTitleBar$BackClickListener;", "", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
    public interface BackClickListener {
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/view/TransTitleBar$MenuClickListener;", "", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
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
        this.f6136a.b.setOnClickListener(new l(function0));
    }

    public final void n(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "onClick");
        this.f6136a.d.setOnClickListener(new n(function0));
    }

    public final void p(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "onClick");
        this.f6136a.e.setOnClickListener(new m(function0));
    }

    public final void r(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "onClick");
        this.f6136a.c.setOnClickListener(new j(function0));
    }

    public final void setBarTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.f6136a.g.setText(str);
    }

    public final void setBarTitleVisible(boolean z) {
        TextView textView = this.f6136a.g;
        Intrinsics.checkNotNullExpressionValue(textView, "tvTitle");
        textView.setVisibility(z ^ true ? 4 : 0);
    }

    public final void setIconBack(@DrawableRes int i) {
        this.f6136a.b.setImageResource(i);
    }

    public final void setIconMenu(@DrawableRes int i) {
        this.f6136a.c.setImageResource(i);
    }

    public final void setIconMenu2(@DrawableRes int i) {
        this.f6136a.d.setImageResource(i);
    }

    public final void setIconMenu2Visible(boolean z) {
        ImageView imageView = this.f6136a.d;
        Intrinsics.checkNotNullExpressionValue(imageView, "ivMenu2");
        imageView.setVisibility(z ? 0 : 8);
    }

    public final void setIconMenu3(@DrawableRes int i) {
        this.f6136a.e.setImageResource(i);
    }

    public final void setIconMenu3Visible(boolean z) {
        ImageView imageView = this.f6136a.e;
        Intrinsics.checkNotNullExpressionValue(imageView, "ivMenu3");
        imageView.setVisibility(z ? 0 : 8);
    }

    public final void setIconMenuEnable(boolean z) {
        this.f6136a.c.setEnabled(z);
    }

    public final void setIconMenuVisible(boolean z) {
        ImageView imageView = this.f6136a.c;
        Intrinsics.checkNotNullExpressionValue(imageView, "ivMenu");
        imageView.setVisibility(z ? 0 : 8);
    }

    public final void setMenu2Enable(boolean z) {
        this.f6136a.d.setEnabled(z);
    }

    public final void setTextMenu(@StringRes int i) {
        this.f6136a.f.setText(i);
    }

    public final void setTextMenuEnable(boolean z) {
        this.f6136a.f.setEnabled(z);
    }

    public final void setTextMenuVisible(boolean z) {
        TextView textView = this.f6136a.f;
        Intrinsics.checkNotNullExpressionValue(textView, "tvMenu");
        textView.setVisibility(z ? 0 : 8);
    }

    public final void t(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "onClick");
        this.f6136a.f.setOnClickListener(new k(function0));
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
        TranscribeTitleBarLayoutBinding c = TranscribeTitleBarLayoutBinding.c(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.f6136a = c;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TransTitleBar);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.TransTitleBar_bar_icon_back, R.drawable.trans_ic_back);
        String string = obtainStyledAttributes.getString(R.styleable.TransTitleBar_bar_title);
        string = string == null ? "" : string;
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.TransTitleBar_bar_title_visible, false);
        int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.TransTitleBar_bar_icon_menu, R.drawable.ic_setting);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.TransTitleBar_bar_icon_menu_visible, false);
        int resourceId3 = obtainStyledAttributes.getResourceId(R.styleable.TransTitleBar_bar_icon_menu2, R.drawable.icon_share);
        boolean z3 = obtainStyledAttributes.getBoolean(R.styleable.TransTitleBar_bar_icon_menu2_visible, false);
        int resourceId4 = obtainStyledAttributes.getResourceId(R.styleable.TransTitleBar_bar_icon_menu3, R.drawable.icon_share);
        boolean z4 = obtainStyledAttributes.getBoolean(R.styleable.TransTitleBar_bar_icon_menu3_visible, false);
        obtainStyledAttributes.recycle();
        setIconBack(resourceId);
        setBarTitle(string);
        setBarTitleVisible(z);
        setIconMenu(resourceId2);
        setIconMenuVisible(z2);
        setIconMenu2(resourceId3);
        setIconMenu2Visible(z3);
        setIconMenu3(resourceId4);
        setIconMenu3Visible(z4);
    }
}
