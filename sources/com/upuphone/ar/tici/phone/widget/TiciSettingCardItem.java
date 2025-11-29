package com.upuphone.ar.tici.phone.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.meizu.common.widget.Switch;
import com.upuphone.ar.tici.R;
import com.upuphone.ar.tici.databinding.TiciSettingCardItemBinding;
import com.upuphone.ar.tici.phone.utils.CommonExtKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u0001:\u0001 B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000f\u0010\u000eJ\u0015\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001e\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/upuphone/ar/tici/phone/widget/TiciSettingCardItem;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "text", "", "setTitle", "(Ljava/lang/String;)V", "setSubTitle", "", "isVisible", "setBottomLineVisible", "(Z)V", "itemType", "setItemType", "(I)V", "Lcom/upuphone/ar/tici/databinding/TiciSettingCardItemBinding;", "a", "Lcom/upuphone/ar/tici/databinding/TiciSettingCardItemBinding;", "layout", "Lcom/meizu/common/widget/Switch;", "getSwitchButton", "()Lcom/meizu/common/widget/Switch;", "switchButton", "b", "Companion", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nTiciSettingCardItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TiciSettingCardItem.kt\ncom/upuphone/ar/tici/phone/widget/TiciSettingCardItem\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,94:1\n262#2,2:95\n262#2,2:97\n262#2,2:99\n262#2,2:101\n262#2,2:103\n262#2,2:105\n260#2:107\n*S KotlinDebug\n*F\n+ 1 TiciSettingCardItem.kt\ncom/upuphone/ar/tici/phone/widget/TiciSettingCardItem\n*L\n70#1:95,2\n77#1:97,2\n84#1:99,2\n85#1:101,2\n86#1:103,2\n87#1:105,2\n88#1:107\n*E\n"})
public final class TiciSettingCardItem extends ConstraintLayout {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final TiciSettingCardItemBinding f6007a;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/upuphone/ar/tici/phone/widget/TiciSettingCardItem$Companion;", "", "()V", "ITEM_TYPE_ARROW", "", "ITEM_TYPE_CHECK", "ITEM_TYPE_EMPTY", "ITEM_TYPE_LOADING", "ITEM_TYPE_SWITCH", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TiciSettingCardItem(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @NotNull
    public final Switch getSwitchButton() {
        Switch switchR = this.f6007a.f;
        Intrinsics.checkNotNullExpressionValue(switchR, "switchSetting");
        return switchR;
    }

    public final void setBottomLineVisible(boolean z) {
        View view = this.f6007a.i;
        Intrinsics.checkNotNullExpressionValue(view, "viewBottomLine");
        view.setVisibility(z ? 0 : 8);
    }

    public final void setItemType(int i) {
        View view = this.f6007a.c;
        Intrinsics.checkNotNullExpressionValue(view, "checkView");
        boolean z = true;
        int i2 = 0;
        view.setVisibility(i == 2 ? 0 : 8);
        Switch switchR = this.f6007a.f;
        Intrinsics.checkNotNullExpressionValue(switchR, "switchSetting");
        switchR.setVisibility(i == 1 ? 0 : 8);
        View view2 = this.f6007a.b;
        Intrinsics.checkNotNullExpressionValue(view2, "arrowView");
        view2.setVisibility(i == 3 ? 0 : 8);
        ProgressBar progressBar = this.f6007a.e;
        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
        if (i != 4) {
            z = false;
        }
        if (!z) {
            i2 = 8;
        }
        progressBar.setVisibility(i2);
        TextView textView = this.f6007a.g;
        Intrinsics.checkNotNullExpressionValue(textView, "tvSettingSubTitle");
        if (textView.getVisibility() == 0) {
            View view3 = this.f6007a.d;
            Intrinsics.checkNotNullExpressionValue(view3, "paddingPlaceholder");
            CommonExtKt.f(view3);
            return;
        }
        View view4 = this.f6007a.d;
        Intrinsics.checkNotNullExpressionValue(view4, "paddingPlaceholder");
        CommonExtKt.g(view4);
    }

    public final void setSubTitle(@Nullable String str) {
        this.f6007a.g.setText(str);
        TextView textView = this.f6007a.g;
        Intrinsics.checkNotNullExpressionValue(textView, "tvSettingSubTitle");
        int i = 0;
        if (!(!(str == null || str.length() == 0))) {
            i = 8;
        }
        textView.setVisibility(i);
    }

    public final void setTitle(@Nullable String str) {
        this.f6007a.h.setText(str);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TiciSettingCardItem(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TiciSettingCardItem(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TiciSettingCardItem(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        TiciSettingCardItemBinding b2 = TiciSettingCardItemBinding.b(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(b2, "inflate(...)");
        this.f6007a = b2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TiciSettingCardItem, i, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        setTitle(obtainStyledAttributes.getString(R.styleable.TiciSettingCardItem_title));
        setSubTitle(obtainStyledAttributes.getString(R.styleable.TiciSettingCardItem_subTitle2));
        setBottomLineVisible(obtainStyledAttributes.getBoolean(R.styleable.TiciSettingCardItem_showBottomLine, false));
        setItemType(obtainStyledAttributes.getInt(R.styleable.TiciSettingCardItem_itemType, 0));
        obtainStyledAttributes.recycle();
    }
}
