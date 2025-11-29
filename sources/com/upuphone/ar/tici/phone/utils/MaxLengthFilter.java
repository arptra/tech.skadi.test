package com.upuphone.ar.tici.phone.utils;

import android.text.InputFilter;
import android.text.Spanned;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJE\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/upuphone/ar/tici/phone/utils/MaxLengthFilter;", "Landroid/text/InputFilter$LengthFilter;", "", "max", "Lkotlin/Function0;", "", "maxCallback", "<init>", "(ILkotlin/jvm/functions/Function0;)V", "", "source", "start", "end", "Landroid/text/Spanned;", "dest", "dstart", "dend", "filter", "(Ljava/lang/CharSequence;IILandroid/text/Spanned;II)Ljava/lang/CharSequence;", "a", "Lkotlin/jvm/functions/Function0;", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
public class MaxLengthFilter extends InputFilter.LengthFilter {

    /* renamed from: a  reason: collision with root package name */
    public final Function0 f5994a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MaxLengthFilter(int i, Function0 function0) {
        super(i);
        Intrinsics.checkNotNullParameter(function0, "maxCallback");
        this.f5994a = function0;
    }

    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        int max = getMax();
        int i5 = 0;
        int length = charSequence != null ? charSequence.length() : 0;
        if (spanned != null) {
            i5 = spanned.length();
        }
        if (max - ((length + i5) - (i4 - i3)) < 0) {
            this.f5994a.invoke();
        }
        return super.filter(charSequence, i, i2, spanned, i3, i4);
    }
}
