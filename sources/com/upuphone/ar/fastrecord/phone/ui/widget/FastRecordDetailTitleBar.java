package com.upuphone.ar.fastrecord.phone.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.databinding.FastRecordDetailTitleBarLayoutBinding;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\fR\u0011\u0010\u0019\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/widget/FastRecordDetailTitleBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "aiImg", "Landroid/widget/ImageView;", "getAiImg", "()Landroid/widget/ImageView;", "backImg", "getBackImg", "delImage", "getDelImage", "layout", "Lcom/upuphone/ar/fastrecord/databinding/FastRecordDetailTitleBarLayoutBinding;", "saveBtn", "Landroid/widget/TextView;", "getSaveBtn", "()Landroid/widget/TextView;", "share", "getShare", "title", "getTitle", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FastRecordDetailTitleBar extends ConstraintLayout {
    @NotNull
    private final ImageView aiImg;
    @NotNull
    private final ImageView backImg;
    @NotNull
    private final ImageView delImage;
    @NotNull
    private final FastRecordDetailTitleBarLayoutBinding layout;
    @NotNull
    private final TextView saveBtn;
    @NotNull
    private final ImageView share;
    @NotNull
    private final TextView title;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FastRecordDetailTitleBar(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @NotNull
    public final ImageView getAiImg() {
        return this.aiImg;
    }

    @NotNull
    public final ImageView getBackImg() {
        return this.backImg;
    }

    @NotNull
    public final ImageView getDelImage() {
        return this.delImage;
    }

    @NotNull
    public final TextView getSaveBtn() {
        return this.saveBtn;
    }

    @NotNull
    public final ImageView getShare() {
        return this.share;
    }

    @NotNull
    public final TextView getTitle() {
        return this.title;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FastRecordDetailTitleBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FastRecordDetailTitleBar(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FastRecordDetailTitleBar(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        FastRecordDetailTitleBarLayoutBinding c = FastRecordDetailTitleBarLayoutBinding.c(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.layout = c;
        TextView textView = c.f;
        Intrinsics.checkNotNullExpressionValue(textView, "title");
        this.title = textView;
        ImageView imageView = c.b;
        Intrinsics.checkNotNullExpressionValue(imageView, "backImg");
        this.backImg = imageView;
        ImageView imageView2 = c.c;
        Intrinsics.checkNotNullExpressionValue(imageView2, "ivAi");
        this.aiImg = imageView2;
        ImageView imageView3 = c.d;
        Intrinsics.checkNotNullExpressionValue(imageView3, "ivDel");
        this.delImage = imageView3;
        ImageView imageView4 = c.e;
        Intrinsics.checkNotNullExpressionValue(imageView4, "ivShare");
        this.share = imageView4;
        TextView textView2 = c.g;
        Intrinsics.checkNotNullExpressionValue(textView2, "tvFinish");
        this.saveBtn = textView2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FastRecordTitleBar);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        String string = obtainStyledAttributes.getString(R.styleable.FastRecordTitleBar_bar_title);
        string = string == null ? "" : string;
        obtainStyledAttributes.recycle();
        textView.setText(string);
    }
}
