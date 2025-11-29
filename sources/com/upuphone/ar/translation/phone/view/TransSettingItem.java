package com.upuphone.ar.translation.phone.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.honey.account.h5.f;
import com.honey.account.h5.g;
import com.meizu.common.R;
import com.meizu.common.widget.Switch;
import com.upuphone.ar.translation.phone.databinding.TransSettingItemBinding;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u0002?@B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\t¢\u0006\u0004\b\u0014\u0010\u0012J\u0015\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u0019¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010 \u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u0015¢\u0006\u0004\b \u0010\u0018J\u0015\u0010\"\u001a\u00020\f2\u0006\u0010!\u001a\u00020\u0015¢\u0006\u0004\b\"\u0010\u0018J\u0015\u0010$\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u0019¢\u0006\u0004\b$\u0010\u001cJ\u0015\u0010%\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u0019¢\u0006\u0004\b%\u0010\u001cJ\u0017\u0010(\u001a\u00020\f2\b\u0010'\u001a\u0004\u0018\u00010&¢\u0006\u0004\b(\u0010)JF\u00100\u001a\u00020\f2%\b\u0002\u0010-\u001a\u001f\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\f\u0018\u00010*2\u0010\b\u0002\u0010/\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010.¢\u0006\u0004\b0\u00101R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u00107R3\u0010;\u001a\u001f\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\f\u0018\u00010*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u001e\u0010>\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u0010=¨\u0006A"}, d2 = {"Lcom/upuphone/ar/translation/phone/view/TransSettingItem;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "l", "()V", "i", "model", "setSettingModel", "(I)V", "background", "setSettingBackground", "", "title", "setSettingTitle", "(Ljava/lang/String;)V", "", "isChecked", "setSettingChecked", "(Z)V", "m", "()Z", "subtitle", "setSettingSubtitle", "content", "setSettingContent", "isVisible", "setSettingContentVisible", "setSettingTipVisible", "Landroid/graphics/drawable/Drawable;", "drawable", "setSettingNextIcon", "(Landroid/graphics/drawable/Drawable;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "switchCallback", "Lkotlin/Function0;", "clickCallback", "n", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "Lcom/upuphone/ar/translation/phone/databinding/TransSettingItemBinding;", "a", "Lcom/upuphone/ar/translation/phone/databinding/TransSettingItemBinding;", "mBinding", "b", "I", "mSettingModel", "c", "Lkotlin/jvm/functions/Function1;", "mSwitchCallback", "d", "Lkotlin/jvm/functions/Function0;", "mClickCallback", "SettingBackground", "SettingModel", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nTransSettingItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TransSettingItem.kt\ncom/upuphone/ar/translation/phone/view/TransSettingItem\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,323:1\n262#2,2:324\n262#2,2:326\n262#2,2:328\n262#2,2:330\n262#2,2:332\n262#2,2:334\n262#2,2:336\n262#2,2:338\n262#2,2:340\n262#2,2:342\n262#2,2:344\n262#2,2:346\n262#2,2:348\n262#2,2:350\n*S KotlinDebug\n*F\n+ 1 TransSettingItem.kt\ncom/upuphone/ar/translation/phone/view/TransSettingItem\n*L\n108#1:324,2\n109#1:326,2\n110#1:328,2\n111#1:330,2\n115#1:332,2\n116#1:334,2\n117#1:336,2\n118#1:338,2\n122#1:340,2\n123#1:342,2\n124#1:344,2\n125#1:346,2\n214#1:348,2\n223#1:350,2\n*E\n"})
public final class TransSettingItem extends ConstraintLayout {

    /* renamed from: a  reason: collision with root package name */
    public TransSettingItemBinding f6327a;
    public int b;
    public Function1 c;
    public Function0 d;

    @Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.CLASS, AnnotationTarget.VALUE_PARAMETER})
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_PARAMETER})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/translation/phone/view/TransSettingItem$SettingBackground;", "", "<init>", "()V", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    public @interface SettingBackground {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/upuphone/ar/translation/phone/view/TransSettingItem$SettingBackground$Companion;", "", "<init>", "()V", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
        public static final class Companion {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ Companion f6328a = new Companion();
        }
    }

    @Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.CLASS, AnnotationTarget.VALUE_PARAMETER})
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_PARAMETER})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/translation/phone/view/TransSettingItem$SettingModel;", "", "<init>", "()V", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    public @interface SettingModel {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/upuphone/ar/translation/phone/view/TransSettingItem$SettingModel$Companion;", "", "<init>", "()V", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
        public static final class Companion {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ Companion f6329a = new Companion();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TransSettingItem(@NotNull Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void i() {
        this.f6327a.getRoot().setOnClickListener(new f(this));
        this.f6327a.e.setOnClickListener(new g(this));
    }

    public static final void j(TransSettingItem transSettingItem, View view) {
        Function0 function0;
        Intrinsics.checkNotNullParameter(transSettingItem, "this$0");
        int i = transSettingItem.b;
        if (i == 1) {
            transSettingItem.f6327a.e.setChecked(true ^ transSettingItem.m());
            Function1 function1 = transSettingItem.c;
            if (function1 != null) {
                function1.invoke(Boolean.valueOf(transSettingItem.m()));
            }
        } else if ((i == 2 || i == 3) && (function0 = transSettingItem.d) != null) {
            function0.invoke();
        }
    }

    public static final void k(TransSettingItem transSettingItem, View view) {
        Intrinsics.checkNotNullParameter(transSettingItem, "this$0");
        Function1 function1 = transSettingItem.c;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(transSettingItem.m()));
        }
    }

    private final void l() {
        Switch switchR = this.f6327a.e;
        switchR.setTrackOnColor(R.color.mz_theme_color_blue);
        switchR.setTrackOffColor(com.upuphone.ar.translation.phone.R.color.tl_color_mz_switch_disable);
    }

    public static /* synthetic */ void o(TransSettingItem transSettingItem, Function1 function1, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        transSettingItem.n(function1, function0);
    }

    public final boolean m() {
        return this.f6327a.e.isChecked();
    }

    public final void n(Function1 function1, Function0 function0) {
        this.c = function1;
        this.d = function0;
    }

    public final void setSettingBackground(int i) {
        if (i == 1) {
            this.f6327a.getRoot().setBackground(ContextCompat.getDrawable(getContext(), com.upuphone.ar.translation.phone.R.drawable.bg_card));
        } else if (i == 2) {
            this.f6327a.getRoot().setBackground(ContextCompat.getDrawable(getContext(), com.upuphone.ar.translation.phone.R.drawable.bg_card_top));
        } else if (i == 3) {
            this.f6327a.getRoot().setBackground(ContextCompat.getDrawable(getContext(), com.upuphone.ar.translation.phone.R.drawable.bg_card_bottom));
        } else if (i == 4) {
            this.f6327a.getRoot().setBackground(ContextCompat.getDrawable(getContext(), com.upuphone.ar.translation.phone.R.drawable.bg_card_not_corners));
        }
    }

    public final void setSettingChecked(boolean z) {
        this.f6327a.e.setChecked(z);
    }

    public final void setSettingContent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "content");
        this.f6327a.f.setText(str);
    }

    public final void setSettingContentVisible(boolean z) {
        TextView textView = this.f6327a.f;
        Intrinsics.checkNotNullExpressionValue(textView, "tvContent");
        textView.setVisibility(z ? 0 : 8);
    }

    public final void setSettingModel(int i) {
        this.b = i;
        if (i == 1) {
            Switch switchR = this.f6327a.e;
            Intrinsics.checkNotNullExpressionValue(switchR, "swSetting");
            switchR.setVisibility(0);
            ImageView imageView = this.f6327a.c;
            Intrinsics.checkNotNullExpressionValue(imageView, "ivSettingTip");
            imageView.setVisibility(8);
            TextView textView = this.f6327a.g;
            Intrinsics.checkNotNullExpressionValue(textView, "tvSettingSubtitle");
            textView.setVisibility(8);
            ImageView imageView2 = this.f6327a.b;
            Intrinsics.checkNotNullExpressionValue(imageView2, "ivSettingNext");
            imageView2.setVisibility(8);
        } else if (i == 2) {
            Switch switchR2 = this.f6327a.e;
            Intrinsics.checkNotNullExpressionValue(switchR2, "swSetting");
            switchR2.setVisibility(8);
            ImageView imageView3 = this.f6327a.c;
            Intrinsics.checkNotNullExpressionValue(imageView3, "ivSettingTip");
            imageView3.setVisibility(8);
            TextView textView2 = this.f6327a.g;
            Intrinsics.checkNotNullExpressionValue(textView2, "tvSettingSubtitle");
            textView2.setVisibility(0);
            ImageView imageView4 = this.f6327a.b;
            Intrinsics.checkNotNullExpressionValue(imageView4, "ivSettingNext");
            imageView4.setVisibility(0);
        } else if (i == 3) {
            Switch switchR3 = this.f6327a.e;
            Intrinsics.checkNotNullExpressionValue(switchR3, "swSetting");
            switchR3.setVisibility(8);
            ImageView imageView5 = this.f6327a.c;
            Intrinsics.checkNotNullExpressionValue(imageView5, "ivSettingTip");
            imageView5.setVisibility(8);
            TextView textView3 = this.f6327a.g;
            Intrinsics.checkNotNullExpressionValue(textView3, "tvSettingSubtitle");
            textView3.setVisibility(8);
            ImageView imageView6 = this.f6327a.b;
            Intrinsics.checkNotNullExpressionValue(imageView6, "ivSettingNext");
            imageView6.setVisibility(0);
        }
    }

    public final void setSettingNextIcon(@Nullable Drawable drawable) {
        if (drawable == null) {
            drawable = ContextCompat.getDrawable(getContext(), com.upuphone.ar.translation.phone.R.drawable.trans_setting_next_arrow);
        }
        if (drawable != null) {
            drawable.setAutoMirrored(true);
        }
        this.f6327a.b.setImageDrawable(drawable);
    }

    public final void setSettingSubtitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "subtitle");
        this.f6327a.g.setText(str);
    }

    public final void setSettingTipVisible(boolean z) {
        ImageView imageView = this.f6327a.c;
        Intrinsics.checkNotNullExpressionValue(imageView, "ivSettingTip");
        imageView.setVisibility(z ? 0 : 8);
    }

    public final void setSettingTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.f6327a.h.setText(str);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TransSettingItem(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TransSettingItem(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.b = 1;
        TransSettingItemBinding c2 = TransSettingItemBinding.c(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(c2, "inflate(...)");
        this.f6327a = c2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.upuphone.ar.translation.phone.R.styleable.TransSettingItem);
        setSettingModel(obtainStyledAttributes.getInt(com.upuphone.ar.translation.phone.R.styleable.TransSettingItem_setting_model, 1));
        setSettingBackground(obtainStyledAttributes.getInt(com.upuphone.ar.translation.phone.R.styleable.TransSettingItem_setting_bg_type, 1));
        String string = obtainStyledAttributes.getString(com.upuphone.ar.translation.phone.R.styleable.TransSettingItem_setting_title);
        String str = "";
        string = string == null ? str : string;
        Intrinsics.checkNotNull(string);
        setSettingTitle(string);
        String string2 = obtainStyledAttributes.getString(com.upuphone.ar.translation.phone.R.styleable.TransSettingItem_setting_subtitle);
        string2 = string2 == null ? str : string2;
        Intrinsics.checkNotNull(string2);
        setSettingSubtitle(string2);
        setSettingTipVisible(obtainStyledAttributes.getBoolean(com.upuphone.ar.translation.phone.R.styleable.TransSettingItem_setting_tip_visible, false));
        String string3 = obtainStyledAttributes.getString(com.upuphone.ar.translation.phone.R.styleable.TransSettingItem_setting_content);
        str = string3 != null ? string3 : str;
        Intrinsics.checkNotNull(str);
        setSettingContent(str);
        setSettingContentVisible(obtainStyledAttributes.getBoolean(com.upuphone.ar.translation.phone.R.styleable.TransSettingItem_setting_content_visible, false));
        setSettingNextIcon(obtainStyledAttributes.getDrawable(com.upuphone.ar.translation.phone.R.styleable.TransSettingItem_setting_next_icon));
        obtainStyledAttributes.recycle();
        l();
        i();
    }
}
