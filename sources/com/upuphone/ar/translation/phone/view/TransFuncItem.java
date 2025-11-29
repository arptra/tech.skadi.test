package com.upuphone.ar.translation.phone.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.upuphone.ar.translation.constants.TranslatorConstants;
import com.upuphone.ar.translation.ext.ContextExtKt;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.R;
import com.upuphone.ar.translation.phone.databinding.TransFuncItemLayoutBinding;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0002#$B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u000e2\b\b\u0001\u0010\u0015\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\f¢\u0006\u0004\b\u0019\u0010\u0010J\u001f\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u001a\u001a\u00020\t¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001d\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006%"}, d2 = {"Lcom/upuphone/ar/translation/phone/view/TransFuncItem;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "subtitle", "", "setNormalSubtitle", "(Ljava/lang/String;)V", "", "enabled", "setFuncEnabled", "(Z)V", "resId", "setFuncIcon", "(I)V", "title", "setFuncTitle", "arrayType", "g", "(Ljava/lang/String;I)V", "i", "Lcom/upuphone/ar/translation/phone/databinding/TransFuncItemLayoutBinding;", "a", "Lcom/upuphone/ar/translation/phone/databinding/TransFuncItemLayoutBinding;", "mBinding", "b", "Companion", "SubTitleArrowType", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nTransFuncItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TransFuncItem.kt\ncom/upuphone/ar/translation/phone/view/TransFuncItem\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,179:1\n262#2,2:180\n262#2,2:182\n262#2,2:184\n*S KotlinDebug\n*F\n+ 1 TransFuncItem.kt\ncom/upuphone/ar/translation/phone/view/TransFuncItem\n*L\n57#1:180,2\n115#1:182,2\n151#1:184,2\n*E\n"})
public final class TransFuncItem extends ConstraintLayout {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public TransFuncItemLayoutBinding f6325a;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/upuphone/ar/translation/phone/view/TransFuncItem$Companion;", "", "()V", "SUBTITLE_SPLIT_MARK", "", "TAG", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.CLASS, AnnotationTarget.VALUE_PARAMETER})
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_PARAMETER})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/translation/phone/view/TransFuncItem$SubTitleArrowType;", "", "<init>", "()V", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    public @interface SubTitleArrowType {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/upuphone/ar/translation/phone/view/TransFuncItem$SubTitleArrowType$Companion;", "", "<init>", "()V", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
        public static final class Companion {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ Companion f6326a = new Companion();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TransFuncItem(@NotNull Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static /* synthetic */ void h(TransFuncItem transFuncItem, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 1;
        }
        transFuncItem.g(str, i);
    }

    private final void setNormalSubtitle(String str) {
        if (TranslatorConstants.isMicroSoftAsr()) {
            this.f6325a.d.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        TextView textView = this.f6325a.d;
        Intrinsics.checkNotNullExpressionValue(textView, "tvSubtitle");
        textView.setVisibility(0);
        this.f6325a.d.setText(str);
    }

    public final void g(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "subtitle");
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "&&", false, 2, (Object) null)) {
            i(str, i);
        } else {
            setNormalSubtitle(str);
        }
    }

    public final void i(String str, int i) {
        TextView textView = this.f6325a.d;
        Intrinsics.checkNotNullExpressionValue(textView, "tvSubtitle");
        textView.setVisibility(0);
        this.f6325a.d.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        Matcher matcher = new Regex("&&").toPattern().matcher(str);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        int i2 = i == 2 ? R.drawable.icon_trans_arrow_two_way : R.drawable.icon_trans_arrow_one_way;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        CenterImageSpan centerImageSpan = new CenterImageSpan(context, i2, ContextExtKt.f(context2));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            LogExt.j("setSplitSubtitle start=" + start + ", end=" + end, "TransFuncItem");
            spannableStringBuilder.setSpan(centerImageSpan, matcher.start(), matcher.end(), 33);
        }
        this.f6325a.d.setText(spannableStringBuilder);
    }

    public final void setFuncEnabled(boolean z) {
        View view = this.f6325a.f;
        Intrinsics.checkNotNullExpressionValue(view, "vFuncDisable");
        view.setVisibility(z ^ true ? 0 : 8);
    }

    public final void setFuncIcon(@DrawableRes int i) {
        ImageView imageView = this.f6325a.c;
        Drawable drawable = ContextCompat.getDrawable(getContext(), i);
        if (drawable != null) {
            drawable.setAutoMirrored(true);
        } else {
            drawable = null;
        }
        imageView.setImageDrawable(drawable);
    }

    public final void setFuncTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.f6325a.e.setText(str);
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
        TransFuncItemLayoutBinding c = TransFuncItemLayoutBinding.c(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.f6325a = c;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TransFuncItem);
        setFuncEnabled(obtainStyledAttributes.getBoolean(R.styleable.TransFuncItem_func_enabled, true));
        setFuncIcon(obtainStyledAttributes.getResourceId(R.styleable.TransFuncItem_func_icon, 0));
        String string = obtainStyledAttributes.getString(R.styleable.TransFuncItem_func_title);
        String str = "";
        string = string == null ? str : string;
        Intrinsics.checkNotNull(string);
        setFuncTitle(string);
        String string2 = obtainStyledAttributes.getString(R.styleable.TransFuncItem_func_subtitle);
        str = string2 != null ? string2 : str;
        Intrinsics.checkNotNull(str);
        h(this, str, 0, 2, (Object) null);
        obtainStyledAttributes.recycle();
    }
}
