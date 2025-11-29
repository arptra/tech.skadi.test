package com.upuphone.ar.tici.phone.epoxy;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.epoxy.EpoxyModelClass;
import com.upuphone.ar.tici.R;
import com.upuphone.ar.tici.databinding.TiciHistoryDateItemBinding;
import com.upuphone.xr.sapp.utils.DimensExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@EpoxyModelClass
@SourceDebugExtension({"SMAP\nTiciDateModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TiciDateModel.kt\ncom/upuphone/ar/tici/phone/epoxy/TiciDateModel\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,51:1\n329#2,4:52\n*S KotlinDebug\n*F\n+ 1 TiciDateModel.kt\ncom/upuphone/ar/tici/phone/epoxy/TiciDateModel\n*L\n33#1:52,4\n*E\n"})
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\b'\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/upuphone/ar/tici/phone/epoxy/TiciDateModel;", "Lcom/upuphone/ar/tici/phone/epoxy/BasicEpoxyModel;", "Lcom/upuphone/ar/tici/phone/epoxy/TiciDateHolder;", "<init>", "()V", "holder", "", "d0", "(Lcom/upuphone/ar/tici/phone/epoxy/TiciDateHolder;)V", "", "m", "Ljava/lang/String;", "e0", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "date", "", "n", "Z", "f0", "()Z", "g0", "(Z)V", "isFirstItem", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
public abstract class TiciDateModel extends BasicEpoxyModel<TiciDateHolder> {
    public String m;
    public boolean n;

    public TiciDateModel() {
        super(R.layout.tici_history_date_item);
    }

    /* renamed from: d0 */
    public void t(TiciDateHolder ticiDateHolder) {
        Intrinsics.checkNotNullParameter(ticiDateHolder, "holder");
        super.t(ticiDateHolder);
        TiciHistoryDateItemBinding b = ticiDateHolder.b();
        b.b.setText(e0());
        FrameLayout b2 = b.getRoot();
        Intrinsics.checkNotNullExpressionValue(b2, "getRoot(...)");
        ViewGroup.LayoutParams layoutParams = b2.getLayoutParams();
        if (layoutParams != null) {
            RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
            layoutParams2.topMargin = this.n ? DimensExtKt.b(12) : DimensExtKt.b(32);
            layoutParams2.bottomMargin = DimensExtKt.b(8);
            b2.setLayoutParams(layoutParams2);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
    }

    public final String e0() {
        String str = this.m;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("date");
        return null;
    }

    public final boolean f0() {
        return this.n;
    }

    public final void g0(boolean z) {
        this.n = z;
    }
}
