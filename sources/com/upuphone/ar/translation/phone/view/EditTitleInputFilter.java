package com.upuphone.ar.translation.phone.view;

import android.text.InputFilter;
import android.text.Spanned;
import com.upuphone.ar.translation.ext.StringExtKt;
import java.lang.Character;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JC\u0010\r\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/upuphone/ar/translation/phone/view/EditTitleInputFilter;", "Landroid/text/InputFilter;", "<init>", "()V", "", "source", "", "start", "end", "Landroid/text/Spanned;", "dest", "dstart", "dend", "filter", "(Ljava/lang/CharSequence;IILandroid/text/Spanned;II)Ljava/lang/CharSequence;", "charSequence", "a", "(Ljava/lang/CharSequence;)I", "", "char", "", "b", "(C)Z", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class EditTitleInputFilter implements InputFilter {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f6323a = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/translation/phone/view/EditTitleInputFilter$Companion;", "", "()V", "MAX_INPUT_LEN", "", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public final int a(CharSequence charSequence) {
        int i = 0;
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            i += b(charSequence.charAt(i2)) ? 2 : 1;
        }
        return i;
    }

    public final boolean b(char c) {
        Character.UnicodeBlock of = Character.UnicodeBlock.of(c);
        return Intrinsics.areEqual((Object) of, (Object) Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) || Intrinsics.areEqual((Object) of, (Object) Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) || Intrinsics.areEqual((Object) of, (Object) Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) || Intrinsics.areEqual((Object) of, (Object) Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B) || Intrinsics.areEqual((Object) of, (Object) Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) || Intrinsics.areEqual((Object) of, (Object) Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) || Intrinsics.areEqual((Object) of, (Object) Character.UnicodeBlock.GENERAL_PUNCTUATION);
    }

    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        if (charSequence == null || spanned == null) {
            return "";
        }
        int a2 = a(spanned);
        if (a(charSequence.subSequence(i, i2)) + a2 > 30) {
            int i5 = 30 - a2;
            int i6 = 0;
            for (int i7 = i; i7 < i2; i7++) {
                i6 += b(charSequence.charAt(i7)) ? 2 : 1;
                if (i6 > i5) {
                    return charSequence.subSequence(i, i7);
                }
            }
        }
        return StringExtKt.d(charSequence.subSequence(i, i2).toString());
    }
}
