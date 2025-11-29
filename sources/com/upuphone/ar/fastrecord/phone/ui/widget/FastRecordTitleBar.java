package com.upuphone.ar.fastrecord.phone.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.databinding.FastRecordTitleBarLayoutBinding;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0011\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/widget/FastRecordTitleBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backImg", "Landroid/widget/ImageView;", "getBackImg", "()Landroid/widget/ImageView;", "layout", "Lcom/upuphone/ar/fastrecord/databinding/FastRecordTitleBarLayoutBinding;", "searchImage", "getSearchImage", "settingImg", "getSettingImg", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FastRecordTitleBar extends ConstraintLayout {
    @NotNull
    private final ImageView backImg;
    @NotNull
    private final FastRecordTitleBarLayoutBinding layout;
    @NotNull
    private final ImageView searchImage;
    @NotNull
    private final ImageView settingImg;
    @NotNull
    private final TextView title;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FastRecordTitleBar(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @NotNull
    public final ImageView getBackImg() {
        return this.backImg;
    }

    @NotNull
    public final ImageView getSearchImage() {
        return this.searchImage;
    }

    @NotNull
    public final ImageView getSettingImg() {
        return this.settingImg;
    }

    @NotNull
    public final TextView getTitle() {
        return this.title;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FastRecordTitleBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FastRecordTitleBar(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FastRecordTitleBar(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        FastRecordTitleBarLayoutBinding c = FastRecordTitleBarLayoutBinding.c(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.layout = c;
        TextView textView = c.e;
        Intrinsics.checkNotNullExpressionValue(textView, "title");
        this.title = textView;
        ImageView imageView = c.b;
        Intrinsics.checkNotNullExpressionValue(imageView, "backImg");
        this.backImg = imageView;
        ImageView imageView2 = c.d;
        Intrinsics.checkNotNullExpressionValue(imageView2, "settingImg");
        this.settingImg = imageView2;
        ImageView imageView3 = c.c;
        Intrinsics.checkNotNullExpressionValue(imageView3, "searchImg");
        this.searchImage = imageView3;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FastRecordTitleBar);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        String string = obtainStyledAttributes.getString(R.styleable.FastRecordTitleBar_bar_title);
        string = string == null ? "" : string;
        obtainStyledAttributes.recycle();
        textView.setText(string);
    }
}
