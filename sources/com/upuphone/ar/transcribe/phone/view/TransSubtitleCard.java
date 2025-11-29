package com.upuphone.ar.transcribe.phone.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.upuphone.ar.transcribe.R;
import com.upuphone.ar.transcribe.databinding.TranscribeSubtitleCardLayoutBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000  2\u00020\u0001:\u0001!B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0014¢\u0006\u0004\b\u0019\u0010\u0017J\u0017\u0010\u001b\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u001b\u0010\u0017R\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/upuphone/ar/transcribe/phone/view/TransSubtitleCard;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "type", "", "setCardType", "(I)V", "", "isSelected", "setCardSelected", "(Z)V", "", "srcText", "setCardSrcText", "(Ljava/lang/String;)V", "dstText", "setCardDstText", "desc", "setCardDesc", "Lcom/upuphone/ar/transcribe/databinding/TranscribeSubtitleCardLayoutBinding;", "a", "Lcom/upuphone/ar/transcribe/databinding/TranscribeSubtitleCardLayoutBinding;", "mBinding", "b", "Companion", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nTransSubtitleCard.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TransSubtitleCard.kt\ncom/upuphone/ar/transcribe/phone/view/TransSubtitleCard\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,135:1\n262#2,2:136\n262#2,2:138\n262#2,2:140\n262#2,2:142\n262#2,2:144\n262#2,2:146\n262#2,2:148\n262#2,2:150\n262#2,2:152\n262#2,2:154\n262#2,2:156\n262#2,2:158\n262#2,2:160\n262#2,2:162\n262#2,2:164\n*S KotlinDebug\n*F\n+ 1 TransSubtitleCard.kt\ncom/upuphone/ar/transcribe/phone/view/TransSubtitleCard\n*L\n63#1:136,2\n64#1:138,2\n65#1:140,2\n70#1:142,2\n71#1:144,2\n72#1:146,2\n77#1:148,2\n78#1:150,2\n79#1:152,2\n84#1:154,2\n85#1:156,2\n86#1:158,2\n91#1:160,2\n92#1:162,2\n93#1:164,2\n*E\n"})
public final class TransSubtitleCard extends ConstraintLayout {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final TranscribeSubtitleCardLayoutBinding f6135a;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/view/TransSubtitleCard$Companion;", "", "()V", "CARD_TYPE_DST", "", "CARD_TYPE_DST_DESC", "CARD_TYPE_SRC_DST", "CARD_TYPE_SRC_DST_DESC", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TransSubtitleCard(@NotNull Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void setCardType(int i) {
        if (i == 1) {
            TextView textView = this.f6135a.d;
            Intrinsics.checkNotNullExpressionValue(textView, "tvSubSrc");
            textView.setVisibility(0);
            TextView textView2 = this.f6135a.c;
            Intrinsics.checkNotNullExpressionValue(textView2, "tvSubDst");
            textView2.setVisibility(0);
            TextView textView3 = this.f6135a.b;
            Intrinsics.checkNotNullExpressionValue(textView3, "tvCardDesc");
            textView3.setVisibility(8);
        } else if (i == 2) {
            TextView textView4 = this.f6135a.d;
            Intrinsics.checkNotNullExpressionValue(textView4, "tvSubSrc");
            textView4.setVisibility(8);
            TextView textView5 = this.f6135a.c;
            Intrinsics.checkNotNullExpressionValue(textView5, "tvSubDst");
            textView5.setVisibility(0);
            TextView textView6 = this.f6135a.b;
            Intrinsics.checkNotNullExpressionValue(textView6, "tvCardDesc");
            textView6.setVisibility(8);
        } else if (i == 3) {
            TextView textView7 = this.f6135a.d;
            Intrinsics.checkNotNullExpressionValue(textView7, "tvSubSrc");
            textView7.setVisibility(0);
            TextView textView8 = this.f6135a.c;
            Intrinsics.checkNotNullExpressionValue(textView8, "tvSubDst");
            textView8.setVisibility(0);
            TextView textView9 = this.f6135a.b;
            Intrinsics.checkNotNullExpressionValue(textView9, "tvCardDesc");
            textView9.setVisibility(0);
        } else if (i != 4) {
            TextView textView10 = this.f6135a.d;
            Intrinsics.checkNotNullExpressionValue(textView10, "tvSubSrc");
            textView10.setVisibility(0);
            TextView textView11 = this.f6135a.c;
            Intrinsics.checkNotNullExpressionValue(textView11, "tvSubDst");
            textView11.setVisibility(0);
            TextView textView12 = this.f6135a.b;
            Intrinsics.checkNotNullExpressionValue(textView12, "tvCardDesc");
            textView12.setVisibility(0);
        } else {
            TextView textView13 = this.f6135a.d;
            Intrinsics.checkNotNullExpressionValue(textView13, "tvSubSrc");
            textView13.setVisibility(8);
            TextView textView14 = this.f6135a.c;
            Intrinsics.checkNotNullExpressionValue(textView14, "tvSubDst");
            textView14.setVisibility(0);
            TextView textView15 = this.f6135a.b;
            Intrinsics.checkNotNullExpressionValue(textView15, "tvCardDesc");
            textView15.setVisibility(0);
        }
    }

    public final void setCardDesc(@Nullable String str) {
        this.f6135a.b.setText(str);
    }

    public final void setCardDstText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "dstText");
        this.f6135a.c.setText(str);
    }

    public final void setCardSelected(boolean z) {
        this.f6135a.e.setSelected(z);
        this.f6135a.b.setSelected(z);
    }

    public final void setCardSrcText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "srcText");
        this.f6135a.d.setText(str);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TransSubtitleCard(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TransSubtitleCard(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        TranscribeSubtitleCardLayoutBinding c = TranscribeSubtitleCardLayoutBinding.c(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.f6135a = c;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TransSubtitleCard);
        setCardType(obtainStyledAttributes.getInt(R.styleable.TransSubtitleCard_card_type_phone, 1));
        String string = obtainStyledAttributes.getString(R.styleable.TransSubtitleCard_card_src_text);
        String str = "";
        string = string == null ? str : string;
        Intrinsics.checkNotNull(string);
        setCardSrcText(string);
        String string2 = obtainStyledAttributes.getString(R.styleable.TransSubtitleCard_card_dst_text);
        str = string2 != null ? string2 : str;
        Intrinsics.checkNotNull(str);
        setCardDstText(str);
        setCardDesc(obtainStyledAttributes.getString(R.styleable.TransSubtitleCard_card_desc));
        obtainStyledAttributes.recycle();
    }
}
