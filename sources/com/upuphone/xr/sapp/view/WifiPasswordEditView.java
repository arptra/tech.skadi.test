package com.upuphone.xr.sapp.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.honey.account.constant.AccountConstantKt;
import com.honey.account.x8.a0;
import com.honey.account.x8.z;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.WifiPasswordEditviewBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\nJ\u0015\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u000fJ\u0015\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0019\u0010\nR\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lcom/upuphone/xr/sapp/view/WifiPasswordEditView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "o", "()V", "p", "", "show", "n", "(Z)V", "m", "Landroid/text/TextWatcher;", "tw", "l", "(Landroid/text/TextWatcher;)V", "", "password", "setEditTextContent", "(Ljava/lang/String;)V", "i", "Lcom/upuphone/xr/sapp/databinding/WifiPasswordEditviewBinding;", "a", "Lcom/upuphone/xr/sapp/databinding/WifiPasswordEditviewBinding;", "binding", "b", "Z", "showPwdState", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nWifiPasswordEditView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WifiPasswordEditView.kt\ncom/upuphone/xr/sapp/view/WifiPasswordEditView\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,114:1\n254#2:115\n256#2,2:116\n256#2,2:118\n256#2,2:120\n*S KotlinDebug\n*F\n+ 1 WifiPasswordEditView.kt\ncom/upuphone/xr/sapp/view/WifiPasswordEditView\n*L\n82#1:115\n83#1:116,2\n96#1:118,2\n97#1:120,2\n*E\n"})
public final class WifiPasswordEditView extends ConstraintLayout {

    /* renamed from: a  reason: collision with root package name */
    public WifiPasswordEditviewBinding f7993a;
    public boolean b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WifiPasswordEditView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        WifiPasswordEditviewBinding c = WifiPasswordEditviewBinding.c(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.f7993a = c;
        o();
        i();
    }

    public static final void j(WifiPasswordEditView wifiPasswordEditView, View view) {
        Intrinsics.checkNotNullParameter(wifiPasswordEditView, "this$0");
        WifiPasswordEditviewBinding wifiPasswordEditviewBinding = wifiPasswordEditView.f7993a;
        if (wifiPasswordEditviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            wifiPasswordEditviewBinding = null;
        }
        wifiPasswordEditviewBinding.g.setText("");
    }

    public static final void k(WifiPasswordEditView wifiPasswordEditView, View view) {
        int i;
        Intrinsics.checkNotNullParameter(wifiPasswordEditView, "this$0");
        Context context = wifiPasswordEditView.getContext();
        if (wifiPasswordEditView.b) {
            wifiPasswordEditView.b = false;
            i = R.drawable.icon_wifi_psd_hide;
        } else {
            wifiPasswordEditView.b = true;
            i = R.drawable.icon_wifi_psd_show;
        }
        Drawable drawable = ContextCompat.getDrawable(context, i);
        WifiPasswordEditviewBinding wifiPasswordEditviewBinding = wifiPasswordEditView.f7993a;
        WifiPasswordEditviewBinding wifiPasswordEditviewBinding2 = null;
        if (wifiPasswordEditviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            wifiPasswordEditviewBinding = null;
        }
        wifiPasswordEditviewBinding.f.setImageDrawable(drawable);
        WifiPasswordEditviewBinding wifiPasswordEditviewBinding3 = wifiPasswordEditView.f7993a;
        if (wifiPasswordEditviewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            wifiPasswordEditviewBinding3 = null;
        }
        wifiPasswordEditviewBinding3.g.setInputType(wifiPasswordEditView.b ? 145 : 129);
        WifiPasswordEditviewBinding wifiPasswordEditviewBinding4 = wifiPasswordEditView.f7993a;
        if (wifiPasswordEditviewBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            wifiPasswordEditviewBinding4 = null;
        }
        AppCompatEditText appCompatEditText = wifiPasswordEditviewBinding4.g;
        WifiPasswordEditviewBinding wifiPasswordEditviewBinding5 = wifiPasswordEditView.f7993a;
        if (wifiPasswordEditviewBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            wifiPasswordEditviewBinding2 = wifiPasswordEditviewBinding5;
        }
        Editable text = wifiPasswordEditviewBinding2.g.getText();
        Intrinsics.checkNotNull(text);
        appCompatEditText.setSelection(text.length());
    }

    private final void o() {
        WifiPasswordEditviewBinding wifiPasswordEditviewBinding = this.f7993a;
        WifiPasswordEditviewBinding wifiPasswordEditviewBinding2 = null;
        if (wifiPasswordEditviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            wifiPasswordEditviewBinding = null;
        }
        wifiPasswordEditviewBinding.g.setInputType(129);
        WifiPasswordEditviewBinding wifiPasswordEditviewBinding3 = this.f7993a;
        if (wifiPasswordEditviewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            wifiPasswordEditviewBinding2 = wifiPasswordEditviewBinding3;
        }
        wifiPasswordEditviewBinding2.g.setText("");
    }

    public final void i() {
        WifiPasswordEditviewBinding wifiPasswordEditviewBinding = this.f7993a;
        WifiPasswordEditviewBinding wifiPasswordEditviewBinding2 = null;
        if (wifiPasswordEditviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            wifiPasswordEditviewBinding = null;
        }
        wifiPasswordEditviewBinding.b.setOnClickListener(new z(this));
        WifiPasswordEditviewBinding wifiPasswordEditviewBinding3 = this.f7993a;
        if (wifiPasswordEditviewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            wifiPasswordEditviewBinding2 = wifiPasswordEditviewBinding3;
        }
        wifiPasswordEditviewBinding2.f.setOnClickListener(new a0(this));
    }

    public final void l(TextWatcher textWatcher) {
        Intrinsics.checkNotNullParameter(textWatcher, "tw");
        WifiPasswordEditviewBinding wifiPasswordEditviewBinding = this.f7993a;
        if (wifiPasswordEditviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            wifiPasswordEditviewBinding = null;
        }
        wifiPasswordEditviewBinding.g.addTextChangedListener(textWatcher);
    }

    public final void m(boolean z) {
        WifiPasswordEditviewBinding wifiPasswordEditviewBinding = this.f7993a;
        WifiPasswordEditviewBinding wifiPasswordEditviewBinding2 = null;
        if (wifiPasswordEditviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            wifiPasswordEditviewBinding = null;
        }
        ImageView imageView = wifiPasswordEditviewBinding.b;
        Intrinsics.checkNotNullExpressionValue(imageView, "clearIv");
        int i = 8;
        imageView.setVisibility(z ? 0 : 8);
        WifiPasswordEditviewBinding wifiPasswordEditviewBinding3 = this.f7993a;
        if (wifiPasswordEditviewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            wifiPasswordEditviewBinding2 = wifiPasswordEditviewBinding3;
        }
        ImageView imageView2 = wifiPasswordEditviewBinding2.e;
        Intrinsics.checkNotNullExpressionValue(imageView2, "functionSplit");
        if (z) {
            i = 0;
        }
        imageView2.setVisibility(i);
    }

    public final void n(boolean z) {
        WifiPasswordEditviewBinding wifiPasswordEditviewBinding = this.f7993a;
        WifiPasswordEditviewBinding wifiPasswordEditviewBinding2 = null;
        if (wifiPasswordEditviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            wifiPasswordEditviewBinding = null;
        }
        TextView textView = wifiPasswordEditviewBinding.c;
        Intrinsics.checkNotNullExpressionValue(textView, "errorInfo");
        int i = 0;
        if ((textView.getVisibility() == 0) != z) {
            WifiPasswordEditviewBinding wifiPasswordEditviewBinding3 = this.f7993a;
            if (wifiPasswordEditviewBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                wifiPasswordEditviewBinding3 = null;
            }
            TextView textView2 = wifiPasswordEditviewBinding3.c;
            Intrinsics.checkNotNullExpressionValue(textView2, "errorInfo");
            if (!z) {
                i = 8;
            }
            textView2.setVisibility(i);
            WifiPasswordEditviewBinding wifiPasswordEditviewBinding4 = this.f7993a;
            if (wifiPasswordEditviewBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                wifiPasswordEditviewBinding2 = wifiPasswordEditviewBinding4;
            }
            wifiPasswordEditviewBinding2.d.setBackground(z ? ContextCompat.getDrawable(getContext(), R.drawable.error_edit_bg) : ContextCompat.getDrawable(getContext(), R.drawable.common_edit_bg));
        }
    }

    public final void p() {
        WifiPasswordEditviewBinding wifiPasswordEditviewBinding = this.f7993a;
        WifiPasswordEditviewBinding wifiPasswordEditviewBinding2 = null;
        if (wifiPasswordEditviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            wifiPasswordEditviewBinding = null;
        }
        wifiPasswordEditviewBinding.g.requestFocus();
        Object systemService = getContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        WifiPasswordEditviewBinding wifiPasswordEditviewBinding3 = this.f7993a;
        if (wifiPasswordEditviewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            wifiPasswordEditviewBinding2 = wifiPasswordEditviewBinding3;
        }
        inputMethodManager.showSoftInput(wifiPasswordEditviewBinding2.g, 0);
    }

    public final void setEditTextContent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.INTENT_PARAM_PASSWORD);
        WifiPasswordEditviewBinding wifiPasswordEditviewBinding = this.f7993a;
        if (wifiPasswordEditviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            wifiPasswordEditviewBinding = null;
        }
        wifiPasswordEditviewBinding.g.setText(str);
    }
}
