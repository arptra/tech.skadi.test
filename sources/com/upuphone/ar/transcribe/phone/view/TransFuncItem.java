package com.upuphone.ar.transcribe.phone.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.upuphone.ar.transcribe.R;
import com.upuphone.ar.transcribe.constants.TranscribeConstants;
import com.upuphone.ar.transcribe.databinding.TranscribeFuncItemLayoutBinding;
import com.upuphone.ar.transcribe.ext.LogExt;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u000e2\b\b\u0001\u0010\u0012\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\f¢\u0006\u0004\b\u0016\u0010\u0010J\u0015\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0017\u0010\u0010R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/view/TransFuncItem;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "subtitle", "", "setSplitSubtitle", "(Ljava/lang/String;)V", "setNormalSubtitle", "resId", "setFuncIcon", "(I)V", "title", "setFuncTitle", "setFuncSubtitle", "Lcom/upuphone/ar/transcribe/databinding/TranscribeFuncItemLayoutBinding;", "a", "Lcom/upuphone/ar/transcribe/databinding/TranscribeFuncItemLayoutBinding;", "mBinding", "b", "Companion", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nTransFuncItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TransFuncItem.kt\ncom/upuphone/ar/transcribe/phone/view/TransFuncItem\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,125:1\n262#2,2:126\n262#2,2:128\n*S KotlinDebug\n*F\n+ 1 TransFuncItem.kt\ncom/upuphone/ar/transcribe/phone/view/TransFuncItem\n*L\n90#1:126,2\n122#1:128,2\n*E\n"})
public final class TransFuncItem extends ConstraintLayout {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public TranscribeFuncItemLayoutBinding f6129a;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/view/TransFuncItem$Companion;", "", "()V", "SUBTITLE_SPLIT_MARK", "", "TAG", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TransFuncItem(@NotNull Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void setNormalSubtitle(String str) {
        if (TranscribeConstants.f6027a.m()) {
            this.f6129a.d.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        TextView textView = this.f6129a.d;
        Intrinsics.checkNotNullExpressionValue(textView, "tvSubtitle");
        textView.setVisibility(0);
        this.f6129a.d.setText(str);
    }

    private final void setSplitSubtitle(String str) {
        TextView textView = this.f6129a.d;
        Intrinsics.checkNotNullExpressionValue(textView, "tvSubtitle");
        textView.setVisibility(0);
        this.f6129a.d.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        Matcher matcher = new Regex("&&").toPattern().matcher(str);
        ImageSpan imageSpan = new ImageSpan(getContext(), R.drawable.icon_trans_arrow_src_dst, 2);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            LogExt.g("setSplitSubtitle start=" + start + ", end=" + end, "TransFuncItem");
            spannableStringBuilder.setSpan(imageSpan, matcher.start(), matcher.end(), 33);
        }
        this.f6129a.d.setText(spannableStringBuilder);
    }

    public final void setFuncIcon(@DrawableRes int i) {
        this.f6129a.c.setImageResource(i);
    }

    public final void setFuncSubtitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "subtitle");
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "&&", false, 2, (Object) null)) {
            setSplitSubtitle(str);
        } else {
            setNormalSubtitle(str);
        }
    }

    public final void setFuncTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.f6129a.e.setText(str);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TransFuncItem(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TransFuncItem(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        TranscribeFuncItemLayoutBinding c = TranscribeFuncItemLayoutBinding.c(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.f6129a = c;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TransFuncItem);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.TransFuncItem_func_icon, 0);
        String string = obtainStyledAttributes.getString(R.styleable.TransFuncItem_func_title);
        String str = "";
        string = string == null ? str : string;
        String string2 = obtainStyledAttributes.getString(R.styleable.TransFuncItem_func_subtitle);
        str = string2 != null ? string2 : str;
        obtainStyledAttributes.recycle();
        setFuncIcon(resourceId);
        setFuncTitle(string);
        setFuncSubtitle(str);
    }
}
