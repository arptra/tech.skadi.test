package com.upuphone.ar.tici.phone.epoxy;

import android.view.View;
import com.airbnb.epoxy.EpoxyHolder;
import com.upuphone.ar.tici.databinding.TiciHistoryDateItemBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u000f\u001a\u00020\t8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0007\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/upuphone/ar/tici/phone/epoxy/TiciDateHolder;", "Lcom/airbnb/epoxy/EpoxyHolder;", "<init>", "()V", "Landroid/view/View;", "itemView", "", "a", "(Landroid/view/View;)V", "Lcom/upuphone/ar/tici/databinding/TiciHistoryDateItemBinding;", "Lcom/upuphone/ar/tici/databinding/TiciHistoryDateItemBinding;", "b", "()Lcom/upuphone/ar/tici/databinding/TiciHistoryDateItemBinding;", "c", "(Lcom/upuphone/ar/tici/databinding/TiciHistoryDateItemBinding;)V", "binding", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
public final class TiciDateHolder extends EpoxyHolder {

    /* renamed from: a  reason: collision with root package name */
    public TiciHistoryDateItemBinding f5970a;

    public void a(View view) {
        Intrinsics.checkNotNullParameter(view, "itemView");
        TiciHistoryDateItemBinding a2 = TiciHistoryDateItemBinding.a(view);
        Intrinsics.checkNotNullExpressionValue(a2, "bind(...)");
        c(a2);
    }

    public final TiciHistoryDateItemBinding b() {
        TiciHistoryDateItemBinding ticiHistoryDateItemBinding = this.f5970a;
        if (ticiHistoryDateItemBinding != null) {
            return ticiHistoryDateItemBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void c(TiciHistoryDateItemBinding ticiHistoryDateItemBinding) {
        Intrinsics.checkNotNullParameter(ticiHistoryDateItemBinding, "<set-?>");
        this.f5970a = ticiHistoryDateItemBinding;
    }
}
