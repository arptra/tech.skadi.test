package com.upuphone.xr.sapp.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.CustomSnackbarBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u0013\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\nB\u001d\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\u000bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/upuphone/xr/sapp/view/CustomSnackBar;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/graphics/drawable/Drawable;", "a", "Landroid/graphics/drawable/Drawable;", "mLayoutBackground", "b", "I", "mTitleTextAppearance", "Lcom/upuphone/xr/sapp/databinding/CustomSnackbarBinding;", "c", "Lcom/upuphone/xr/sapp/databinding/CustomSnackbarBinding;", "binding", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class CustomSnackBar extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public Drawable f7948a;
    public int b;
    public CustomSnackbarBinding c;

    public CustomSnackBar(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        CustomSnackbarBinding a2 = CustomSnackbarBinding.a(LayoutInflater.from(context).inflate(R.layout.custom_snackbar, this));
        Intrinsics.checkNotNullExpressionValue(a2, "bind(...)");
        this.c = a2;
        Intrinsics.checkNotNull(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.meizu.common.R.styleable.mzContentToastLayout, i, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.f7948a = obtainStyledAttributes.getDrawable(com.meizu.common.R.styleable.mzContentToastLayout_mzContentToastBackground);
        int resourceId = obtainStyledAttributes.getResourceId(com.meizu.common.R.styleable.mzContentToastLayout_mzTitleTextAppearance, 0);
        this.b = resourceId;
        this.c.d.setTextAppearance(resourceId);
        this.c.c.setBackground(this.f7948a);
        obtainStyledAttributes.recycle();
    }

    public CustomSnackBar(@Nullable Context context) {
        this(context, (AttributeSet) null);
    }

    public CustomSnackBar(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, com.meizu.common.R.attr.mzContentToastLayoutStyle);
    }
}
