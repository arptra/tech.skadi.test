package com.upuphone.ar.fastrecord.phone.ui.widget;

import android.text.InputFilter;
import android.text.Spanned;
import java.lang.Character;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0002J<\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\tH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001a"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/widget/FastRecordEditTitleInputFilter;", "Landroid/text/InputFilter;", "size", "", "(I)V", "getSize", "()I", "calculateLength", "charSequence", "", "filter", "source", "start", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "isChinese", "", "char", "", "isEmoji", "spannedIsEmoji", "data", "Companion", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FastRecordEditTitleInputFilter implements InputFilter {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int MAX_INPUT_LEN = 30;
    private final int size;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/widget/FastRecordEditTitleInputFilter$Companion;", "", "()V", "MAX_INPUT_LEN", "", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public FastRecordEditTitleInputFilter() {
        this(0, 1, (DefaultConstructorMarker) null);
    }

    private final int calculateLength(CharSequence charSequence) {
        int i = 0;
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char charAt = charSequence.charAt(i2);
            int i3 = 2;
            if (!isChinese(charAt) && (!isEmoji(charAt) || !Character.isHighSurrogate(charAt))) {
                i3 = 1;
            }
            i += i3;
        }
        return i;
    }

    private final boolean isChinese(char c) {
        Character.UnicodeBlock of = Character.UnicodeBlock.of(c);
        return Intrinsics.areEqual((Object) of, (Object) Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) || Intrinsics.areEqual((Object) of, (Object) Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) || Intrinsics.areEqual((Object) of, (Object) Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) || Intrinsics.areEqual((Object) of, (Object) Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B) || Intrinsics.areEqual((Object) of, (Object) Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) || Intrinsics.areEqual((Object) of, (Object) Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) || Intrinsics.areEqual((Object) of, (Object) Character.UnicodeBlock.GENERAL_PUNCTUATION);
    }

    private final boolean isEmoji(char c) {
        int type = Character.getType(c);
        return type == 19 || type == 28;
    }

    private final boolean spannedIsEmoji(CharSequence charSequence) {
        for (int i = 0; i < charSequence.length(); i++) {
            if (isEmoji(charSequence.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public CharSequence filter(@Nullable CharSequence charSequence, int i, int i2, @Nullable Spanned spanned, int i3, int i4) {
        if (charSequence == null || spanned == null) {
            return "";
        }
        int calculateLength = calculateLength(spanned);
        int calculateLength2 = calculateLength(charSequence.subSequence(i, i2));
        if (spannedIsEmoji(charSequence) && calculateLength + calculateLength2 > this.size) {
            return "";
        }
        int i5 = calculateLength2 + calculateLength;
        int i6 = this.size;
        if (i5 > i6) {
            int i7 = i6 - calculateLength;
            int i8 = 0;
            for (int i9 = i; i9 < i2; i9++) {
                i8 += isChinese(charSequence.charAt(i9)) ? 2 : 1;
                if (i8 > i7) {
                    return charSequence.subSequence(i, i9);
                }
            }
        }
        return charSequence.subSequence(i, i2);
    }

    public final int getSize() {
        return this.size;
    }

    public FastRecordEditTitleInputFilter(int i) {
        this.size = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FastRecordEditTitleInputFilter(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 30 : i);
    }
}
