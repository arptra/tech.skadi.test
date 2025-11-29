package com.upuphone.ar.tici.phone.utils;

import android.text.InputFilter;
import android.text.Spanned;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JE\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/upuphone/ar/tici/phone/utils/EmojiFilter;", "Landroid/text/InputFilter;", "<init>", "()V", "", "source", "", "start", "end", "Landroid/text/Spanned;", "dest", "dstart", "dend", "filter", "(Ljava/lang/CharSequence;IILandroid/text/Spanned;II)Ljava/lang/CharSequence;", "a", "Companion", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nEmojiFilter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EmojiFilter.kt\ncom/upuphone/ar/tici/phone/utils/EmojiFilter\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,48:1\n474#2:49\n492#2,2:50\n*S KotlinDebug\n*F\n+ 1 EmojiFilter.kt\ncom/upuphone/ar/tici/phone/utils/EmojiFilter\n*L\n31#1:49\n31#1:50,2\n*E\n"})
public final class EmojiFilter implements InputFilter {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f5981a = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/tici/phone/utils/EmojiFilter$Companion;", "", "()V", "TAG", "", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        if (charSequence == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            char charAt = charSequence.charAt(i5);
            boolean a2 = CharExtKt.a(charAt);
            if (a2) {
                CommonExtKt.e("char: '" + charAt + "', code: " + charAt + ", isEmoji=true", "EmojiFilter");
            }
            if (!a2) {
                sb.append(charAt);
            }
        }
        String obj = sb.toString();
        if (Intrinsics.areEqual((Object) obj, (Object) charSequence.toString())) {
            return null;
        }
        CommonExtKt.e("filter, filteredSource: '" + obj + "', source: '" + charSequence + "' not match", "EmojiFilter");
        return obj;
    }
}
