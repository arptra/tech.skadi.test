package com.upuphone.ar.transcribe.phone.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.upuphone.ar.transcribe.R;
import com.upuphone.ar.transcribe.databinding.TranscribeSettingSubCardBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/view/TransSettingSubCard;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "selected", "", "setSelected", "(Z)V", "Lcom/upuphone/ar/transcribe/databinding/TranscribeSettingSubCardBinding;", "a", "Lcom/upuphone/ar/transcribe/databinding/TranscribeSettingSubCardBinding;", "binding", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TransSettingSubCard extends ConstraintLayout {

    /* renamed from: a  reason: collision with root package name */
    public final TranscribeSettingSubCardBinding f6134a;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TransSettingSubCard(@NotNull Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void setSelected(boolean z) {
        super.setSelected(z);
        this.f6134a.b.setSelected(z);
        this.f6134a.d.setTextColor(z ? getContext().getColor(R.color.tb_color_setting_sub_card_title_select) : getContext().getColor(R.color.tb_color_setting_sub_card_title_normal));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TransSettingSubCard(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TransSettingSubCard(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        TranscribeSettingSubCardBinding c = TranscribeSettingSubCardBinding.c(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.f6134a = c;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TransSettingSubCard);
        TextView textView = c.d;
        String string = obtainStyledAttributes.getString(R.styleable.TransSettingSubCard_card_title);
        String str = "";
        textView.setText(string == null ? str : string);
        TextView textView2 = c.e;
        String string2 = obtainStyledAttributes.getString(R.styleable.TransSettingSubCard_card_tips);
        textView2.setText(string2 == null ? str : string2);
        TextView textView3 = c.f;
        String string3 = obtainStyledAttributes.getString(R.styleable.TransSettingSubCard_card_sub_tips);
        textView3.setText(string3 != null ? string3 : str);
        obtainStyledAttributes.recycle();
    }
}
