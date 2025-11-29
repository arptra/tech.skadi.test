package com.honey.account.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.honey.account.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010+\u001a\u00020,J\u0010\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010,J\u0012\u00100\u001a\u00020.2\b\b\u0001\u0010\u0012\u001a\u00020\tH\u0002J\u0010\u00101\u001a\u00020.2\b\b\u0001\u0010\u0015\u001a\u00020\tJ\u0010\u00101\u001a\u00020.2\b\u00102\u001a\u0004\u0018\u00010,J\u0010\u00103\u001a\u00020.2\b\b\u0001\u00104\u001a\u00020\tJ\u0010\u00105\u001a\u00020.2\b\b\u0001\u0010\u001f\u001a\u00020\tJ\u0010\u00106\u001a\u00020.2\b\b\u0001\u0010!\u001a\u00020\tJ\u0010\u00106\u001a\u00020.2\b\u00107\u001a\u0004\u0018\u00010,J\u0010\u00108\u001a\u00020.2\b\b\u0001\u00104\u001a\u00020\tJ\u0010\u00109\u001a\u00020.2\b\b\u0001\u0010&\u001a\u00020\tR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u0016\u0010\u0014R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001d\u0010\u000eR\u001e\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t@BX\u000e¢\u0006\b\n\u0000\"\u0004\b \u0010\u0014R\u001e\u0010!\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\"\u0010\u0014R\u001b\u0010#\u001a\u00020\u00188BX\u0002¢\u0006\f\n\u0004\b%\u0010\u0010\u001a\u0004\b$\u0010\u001aR\u001e\u0010&\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t@BX\u000e¢\u0006\b\n\u0000\"\u0004\b'\u0010\u0014R\u001b\u0010(\u001a\u00020\u00188BX\u0002¢\u0006\f\n\u0004\b*\u0010\u0010\u001a\u0004\b)\u0010\u001a¨\u0006:"}, d2 = {"Lcom/honey/account/view/widget/OptionItemLayout;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "leftIconImg", "Landroid/widget/ImageView;", "getLeftIconImg", "()Landroid/widget/ImageView;", "leftIconImg$delegate", "Lkotlin/Lazy;", "value", "leftIconRes", "setLeftIconRes", "(I)V", "mainTitleRes", "setMainTitleRes", "mainTitleTv", "Landroid/widget/TextView;", "getMainTitleTv", "()Landroid/widget/TextView;", "mainTitleTv$delegate", "rightIconImg", "getRightIconImg", "rightIconImg$delegate", "rightIconRes", "setRightIconRes", "subTitleRes", "setSubTitleRes", "subtitleTv", "getSubtitleTv", "subtitleTv$delegate", "summaryRes", "setSummaryRes", "summaryTv", "getSummaryTv", "summaryTv$delegate", "getMainTitle", "", "setEndMessage", "", "summary", "setLeftIcon", "setMainTitle", "title", "setMainTitleColor", "color", "setRightIcon", "setSubtitle", "subTitle", "setSubtitleColor", "setSummary", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class OptionItemLayout extends LinearLayoutCompat {
    @NotNull
    private final Lazy leftIconImg$delegate;
    private int leftIconRes;
    private int mainTitleRes;
    @NotNull
    private final Lazy mainTitleTv$delegate;
    @NotNull
    private final Lazy rightIconImg$delegate;
    private int rightIconRes;
    private int subTitleRes;
    @NotNull
    private final Lazy subtitleTv$delegate;
    private int summaryRes;
    @NotNull
    private final Lazy summaryTv$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public OptionItemLayout(@NotNull Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final ImageView getLeftIconImg() {
        Object value = this.leftIconImg$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (ImageView) value;
    }

    private final TextView getMainTitleTv() {
        Object value = this.mainTitleTv$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (TextView) value;
    }

    private final ImageView getRightIconImg() {
        Object value = this.rightIconImg$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (ImageView) value;
    }

    private final TextView getSubtitleTv() {
        Object value = this.subtitleTv$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (TextView) value;
    }

    private final TextView getSummaryTv() {
        Object value = this.summaryTv$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (TextView) value;
    }

    private final void setLeftIcon(@DrawableRes int i) {
        ImageView leftIconImg = getLeftIconImg();
        leftIconImg.setVisibility(i == 0 ? 8 : 0);
        leftIconImg.setImageResource(i);
    }

    private final void setLeftIconRes(int i) {
        this.leftIconRes = i;
        setLeftIcon(i);
    }

    private final void setMainTitleRes(int i) {
        this.mainTitleRes = i;
        setMainTitle(i);
    }

    private final void setRightIconRes(int i) {
        this.rightIconRes = i;
        setRightIcon(i);
    }

    private final void setSubTitleRes(int i) {
        this.subTitleRes = i;
        setSubtitle(i);
    }

    private final void setSummaryRes(int i) {
        this.summaryRes = i;
        setSummary(i);
    }

    @NotNull
    public final String getMainTitle() {
        return getMainTitleTv().getText().toString();
    }

    public final void setEndMessage(@Nullable String str) {
        int i;
        TextView summaryTv = getSummaryTv();
        if (str == null || str.length() == 0) {
            i = 8;
        } else {
            summaryTv.setText(str);
            i = 0;
        }
        summaryTv.setVisibility(i);
    }

    public final void setMainTitle(@StringRes int i) {
        int i2;
        TextView mainTitleTv = getMainTitleTv();
        if (i == 0) {
            i2 = 8;
        } else {
            mainTitleTv.setText(getContext().getResources().getText(i));
            i2 = 0;
        }
        mainTitleTv.setVisibility(i2);
    }

    public final void setMainTitleColor(@ColorInt int i) {
        getMainTitleTv().setTextColor(i);
    }

    public final void setRightIcon(@DrawableRes int i) {
        ImageView rightIconImg = getRightIconImg();
        rightIconImg.setVisibility(i == 0 ? 8 : 0);
        rightIconImg.setImageResource(i);
    }

    public final void setSubtitle(@StringRes int i) {
        int i2;
        TextView subtitleTv = getSubtitleTv();
        if (i == 0) {
            i2 = 8;
        } else {
            subtitleTv.setText(getContext().getResources().getText(i));
            i2 = 0;
        }
        subtitleTv.setVisibility(i2);
    }

    public final void setSubtitleColor(@ColorInt int i) {
        getSubtitleTv().setTextColor(i);
    }

    public final void setSummary(@StringRes int i) {
        int i2;
        TextView summaryTv = getSummaryTv();
        if (i == 0) {
            i2 = 8;
        } else {
            summaryTv.setText(getContext().getResources().getText(i));
            i2 = 0;
        }
        summaryTv.setVisibility(i2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public OptionItemLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OptionItemLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.leftIconImg$delegate = LazyKt.lazy(new OptionItemLayout$leftIconImg$2(this));
        this.mainTitleTv$delegate = LazyKt.lazy(new OptionItemLayout$mainTitleTv$2(this));
        this.subtitleTv$delegate = LazyKt.lazy(new OptionItemLayout$subtitleTv$2(this));
        this.summaryTv$delegate = LazyKt.lazy(new OptionItemLayout$summaryTv$2(this));
        this.rightIconImg$delegate = LazyKt.lazy(new OptionItemLayout$rightIconImg$2(this));
        LayoutInflater.from(context).inflate(R.layout.option_item_layout, this, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.OptionItemLayout);
        setLeftIconRes(obtainStyledAttributes.getResourceId(R.styleable.OptionItemLayout_leftIcon, 0));
        setMainTitleRes(obtainStyledAttributes.getResourceId(R.styleable.OptionItemLayout_mainTitle, 0));
        setSubTitleRes(obtainStyledAttributes.getResourceId(R.styleable.OptionItemLayout_subTitle, 0));
        setSummaryRes(obtainStyledAttributes.getResourceId(R.styleable.OptionItemLayout_summary_text, 0));
        setRightIconRes(obtainStyledAttributes.getResourceId(R.styleable.OptionItemLayout_rightIcon, 0));
        obtainStyledAttributes.recycle();
    }

    public final void setMainTitle(@Nullable String str) {
        int i;
        TextView mainTitleTv = getMainTitleTv();
        if (str == null || str.length() == 0) {
            i = 8;
        } else {
            mainTitleTv.setText(str);
            i = 0;
        }
        mainTitleTv.setVisibility(i);
    }

    public final void setSubtitle(@Nullable String str) {
        int i;
        TextView subtitleTv = getSubtitleTv();
        if (str == null || str.length() == 0) {
            i = 8;
        } else {
            subtitleTv.setText(str);
            i = 0;
        }
        subtitleTv.setVisibility(i);
    }
}
