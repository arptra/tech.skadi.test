package com.upuphone.ar.transcribe.phone.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.honey.account.y4.h;
import com.honey.account.y4.i;
import com.meizu.common.R;
import com.meizu.common.widget.Switch;
import com.upuphone.ar.transcribe.databinding.TrsbSettingItemBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J4\u0010\u0017\u001a\u00020\f2%\b\u0002\u0010\u0016\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\f\u0018\u00010\u0013¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR3\u0010\u001f\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\f\u0018\u00010\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/upuphone/ar/transcribe/phone/view/TransSettingItem;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "i", "()V", "", "isChecked", "setSettingChecked", "(Z)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "callback", "setSettingCallback", "(Lkotlin/jvm/functions/Function1;)V", "Lcom/upuphone/ar/transcribe/databinding/TrsbSettingItemBinding;", "a", "Lcom/upuphone/ar/transcribe/databinding/TrsbSettingItemBinding;", "binding", "b", "Lkotlin/jvm/functions/Function1;", "switchCallback", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TransSettingItem extends ConstraintLayout {

    /* renamed from: a  reason: collision with root package name */
    public TrsbSettingItemBinding f6133a;
    public Function1 b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TransSettingItem(@NotNull Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void i() {
        Switch switchR = this.f6133a.b;
        switchR.setTrackOnColor(R.color.mz_theme_color_blue);
        switchR.setTrackOffColor(com.upuphone.ar.transcribe.R.color.tb_mz_switch_disable);
        setOnClickListener(new h(this));
        this.f6133a.b.setOnClickListener(new i(this));
    }

    public static final void j(TransSettingItem transSettingItem, View view) {
        Intrinsics.checkNotNullParameter(transSettingItem, "this$0");
        Switch switchR = transSettingItem.f6133a.b;
        switchR.setChecked(!switchR.isChecked());
        Function1 function1 = transSettingItem.b;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(transSettingItem.f6133a.b.isChecked()));
        }
    }

    public static final void k(TransSettingItem transSettingItem, View view) {
        Intrinsics.checkNotNullParameter(transSettingItem, "this$0");
        Function1 function1 = transSettingItem.b;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(transSettingItem.f6133a.b.isChecked()));
        }
    }

    public final void setSettingCallback(@Nullable Function1<? super Boolean, Unit> function1) {
        this.b = function1;
    }

    public final void setSettingChecked(boolean z) {
        this.f6133a.b.setChecked(z);
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
        TrsbSettingItemBinding c = TrsbSettingItemBinding.c(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.f6133a = c;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.upuphone.ar.transcribe.R.styleable.TransSettingItem);
        TextView textView = this.f6133a.d;
        String string = obtainStyledAttributes.getString(com.upuphone.ar.transcribe.R.styleable.TransSettingItem_setting_title);
        String str = "";
        textView.setText(string == null ? str : string);
        TextView textView2 = this.f6133a.c;
        String string2 = obtainStyledAttributes.getString(com.upuphone.ar.transcribe.R.styleable.TransSettingItem_setting_subtitle);
        textView2.setText(string2 != null ? string2 : str);
        obtainStyledAttributes.recycle();
        i();
    }
}
