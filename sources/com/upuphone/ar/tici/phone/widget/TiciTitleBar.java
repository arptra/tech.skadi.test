package com.upuphone.ar.tici.phone.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.upuphone.ar.tici.R;
import com.upuphone.ar.tici.databinding.TiciTitleBarLayoutBinding;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001c\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018R\u0017\u0010\u001f\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0016\u001a\u0004\b\u001e\u0010\u0018R\u0011\u0010!\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b \u0010\u0012¨\u0006\""}, d2 = {"Lcom/upuphone/ar/tici/phone/widget/TiciTitleBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lcom/upuphone/ar/tici/databinding/TiciTitleBarLayoutBinding;", "a", "Lcom/upuphone/ar/tici/databinding/TiciTitleBarLayoutBinding;", "layout", "Landroid/widget/TextView;", "b", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "title", "Landroid/widget/ImageView;", "c", "Landroid/widget/ImageView;", "getBackImg", "()Landroid/widget/ImageView;", "backImg", "d", "getFolderImg", "folderImg", "e", "getSettingImg", "settingImg", "getTvSave", "tvSave", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
public final class TiciTitleBar extends ConstraintLayout {

    /* renamed from: a  reason: collision with root package name */
    public final TiciTitleBarLayoutBinding f6008a;
    public final TextView b;
    public final ImageView c;
    public final ImageView d;
    public final ImageView e;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TiciTitleBar(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @NotNull
    public final ImageView getBackImg() {
        return this.c;
    }

    @NotNull
    public final ImageView getFolderImg() {
        return this.d;
    }

    @NotNull
    public final ImageView getSettingImg() {
        return this.e;
    }

    @NotNull
    public final TextView getTitle() {
        return this.b;
    }

    @NotNull
    public final TextView getTvSave() {
        TextView textView = this.f6008a.f;
        Intrinsics.checkNotNullExpressionValue(textView, "tvSave");
        return textView;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TiciTitleBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TiciTitleBar(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TiciTitleBar(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        TiciTitleBarLayoutBinding c2 = TiciTitleBarLayoutBinding.c(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(c2, "inflate(...)");
        this.f6008a = c2;
        TextView textView = c2.e;
        Intrinsics.checkNotNullExpressionValue(textView, "title");
        this.b = textView;
        ImageView imageView = c2.b;
        Intrinsics.checkNotNullExpressionValue(imageView, "backImg");
        this.c = imageView;
        ImageView imageView2 = c2.c;
        Intrinsics.checkNotNullExpressionValue(imageView2, "folderImg");
        this.d = imageView2;
        ImageView imageView3 = c2.d;
        Intrinsics.checkNotNullExpressionValue(imageView3, "settingImg");
        this.e = imageView3;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TiciTitleBar);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        String string = obtainStyledAttributes.getString(R.styleable.TiciTitleBar_bar_title);
        string = string == null ? "" : string;
        obtainStyledAttributes.recycle();
        textView.setText(string);
    }
}
