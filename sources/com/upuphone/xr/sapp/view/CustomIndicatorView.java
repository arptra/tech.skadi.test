package com.upuphone.xr.sapp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.CustomIndicatorLayoutBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/upuphone/xr/sapp/view/CustomIndicatorView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lcom/upuphone/xr/sapp/databinding/CustomIndicatorLayoutBinding;", "a", "Lcom/upuphone/xr/sapp/databinding/CustomIndicatorLayoutBinding;", "binding", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class CustomIndicatorView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public CustomIndicatorLayoutBinding f7943a;

    public CustomIndicatorView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        CustomIndicatorLayoutBinding a2 = CustomIndicatorLayoutBinding.a(LayoutInflater.from(context).inflate(R.layout.custom_indicator_layout, this));
        Intrinsics.checkNotNullExpressionValue(a2, "bind(...)");
        this.f7943a = a2;
    }
}
