package com.upuphone.ar.tici.phone.epoxy;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.airbnb.epoxy.EpoxyModelClass;
import com.honey.account.q4.c;
import com.honey.account.q4.d;
import com.honey.account.q4.e;
import com.upuphone.ar.tici.R;
import com.upuphone.ar.tici.databinding.TiciHistoryFileItemBinding;
import com.upuphone.ar.tici.phone.data.TiciHistory;
import com.upuphone.ar.tici.phone.data.TiciHistoryKt;
import com.upuphone.ar.tici.phone.listener.TiciHistoryItemListener;
import com.upuphone.ar.tici.phone.utils.CommonExtKt;
import com.upuphone.xr.sapp.utils.ViewExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@EpoxyModelClass
@SourceDebugExtension({"SMAP\nTiciHistoryFileModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TiciHistoryFileModel.kt\ncom/upuphone/ar/tici/phone/epoxy/TiciHistoryFileModel\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,123:1\n262#2,2:124\n262#2,2:126\n262#2,2:128\n262#2,2:130\n262#2,2:132\n262#2,2:134\n262#2,2:136\n262#2,2:138\n262#2,2:140\n262#2,2:142\n262#2,2:144\n262#2,2:146\n262#2,2:148\n262#2,2:150\n262#2,2:152\n262#2,2:154\n262#2,2:156\n262#2,2:158\n260#2,4:160\n*S KotlinDebug\n*F\n+ 1 TiciHistoryFileModel.kt\ncom/upuphone/ar/tici/phone/epoxy/TiciHistoryFileModel\n*L\n55#1:124,2\n56#1:126,2\n57#1:128,2\n58#1:130,2\n59#1:132,2\n60#1:134,2\n67#1:136,2\n69#1:138,2\n70#1:140,2\n71#1:142,2\n72#1:144,2\n73#1:146,2\n75#1:148,2\n77#1:150,2\n78#1:152,2\n79#1:154,2\n80#1:156,2\n81#1:158,2\n84#1:160,4\n*E\n"})
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\b\b'\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010$\u001a\u00020\u00198\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001b\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR\"\u0010(\u001a\u00020\u00198\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b%\u0010\u001b\u001a\u0004\b&\u0010\u001d\"\u0004\b'\u0010\u001fR\"\u0010,\u001a\u00020\u00198\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b)\u0010\u001b\u001a\u0004\b*\u0010\u001d\"\u0004\b+\u0010\u001fR$\u00104\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u00065"}, d2 = {"Lcom/upuphone/ar/tici/phone/epoxy/TiciHistoryFileModel;", "Lcom/upuphone/ar/tici/phone/epoxy/BasicEpoxyModel;", "Lcom/upuphone/ar/tici/phone/epoxy/TiciHistoryFileHolder;", "<init>", "()V", "holder", "", "g0", "(Lcom/upuphone/ar/tici/phone/epoxy/TiciHistoryFileHolder;)V", "Lcom/upuphone/ar/tici/phone/data/TiciHistory;", "m", "Lcom/upuphone/ar/tici/phone/data/TiciHistory;", "m0", "()Lcom/upuphone/ar/tici/phone/data/TiciHistory;", "setTiciHistory", "(Lcom/upuphone/ar/tici/phone/data/TiciHistory;)V", "ticiHistory", "", "n", "I", "k0", "()I", "s0", "(I)V", "itemBgRes", "", "o", "Z", "p0", "()Z", "v0", "(Z)V", "isLoading", "p", "q0", "w0", "isRunning", "q", "n0", "r0", "isImpatient", "r", "o0", "t0", "isLastItem", "Lcom/upuphone/ar/tici/phone/listener/TiciHistoryItemListener;", "s", "Lcom/upuphone/ar/tici/phone/listener/TiciHistoryItemListener;", "l0", "()Lcom/upuphone/ar/tici/phone/listener/TiciHistoryItemListener;", "u0", "(Lcom/upuphone/ar/tici/phone/listener/TiciHistoryItemListener;)V", "listener", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
public abstract class TiciHistoryFileModel extends BasicEpoxyModel<TiciHistoryFileHolder> {
    public TiciHistory m;
    public int n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public TiciHistoryItemListener s;

    public TiciHistoryFileModel() {
        super(R.layout.tici_history_file_item);
    }

    public static final void h0(TiciHistoryFileModel ticiHistoryFileModel, View view) {
        Intrinsics.checkNotNullParameter(ticiHistoryFileModel, "this$0");
        TiciHistoryItemListener ticiHistoryItemListener = ticiHistoryFileModel.s;
        if (ticiHistoryItemListener != null) {
            ticiHistoryItemListener.d(ticiHistoryFileModel.m0());
        }
    }

    public static final void i0(TiciHistoryFileModel ticiHistoryFileModel, View view) {
        Intrinsics.checkNotNullParameter(ticiHistoryFileModel, "this$0");
        TiciHistoryItemListener ticiHistoryItemListener = ticiHistoryFileModel.s;
        if (ticiHistoryItemListener != null) {
            Intrinsics.checkNotNull(view);
            ticiHistoryItemListener.a(view, ticiHistoryFileModel.m0());
        }
    }

    public static final void j0(TiciHistoryFileModel ticiHistoryFileModel, View view) {
        Intrinsics.checkNotNullParameter(ticiHistoryFileModel, "this$0");
        TiciHistoryItemListener ticiHistoryItemListener = ticiHistoryFileModel.s;
        if (ticiHistoryItemListener != null) {
            ticiHistoryItemListener.c(ticiHistoryFileModel.m0());
        }
    }

    /* renamed from: g0 */
    public void t(TiciHistoryFileHolder ticiHistoryFileHolder) {
        TiciHistoryItemListener ticiHistoryItemListener;
        Intrinsics.checkNotNullParameter(ticiHistoryFileHolder, "holder");
        super.t(ticiHistoryFileHolder);
        TiciHistoryFileItemBinding b = ticiHistoryFileHolder.b();
        b.getRoot().setBackgroundResource(this.n);
        b.g.setText(m0().getFileName());
        TextView textView = b.f;
        Context context = b.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        textView.setText(CommonExtKt.a(context, m0().getLastModified()));
        int i = 8;
        if (this.o) {
            TextView textView2 = b.f;
            Intrinsics.checkNotNullExpressionValue(textView2, "tvFileDate");
            textView2.setVisibility(8);
            ImageView imageView = b.c;
            Intrinsics.checkNotNullExpressionValue(imageView, "ivDotMenu");
            imageView.setVisibility(8);
            TextView textView3 = b.h;
            Intrinsics.checkNotNullExpressionValue(textView3, "tvLoading");
            textView3.setVisibility(0);
            ProgressBar progressBar = b.e;
            Intrinsics.checkNotNullExpressionValue(progressBar, "loading");
            progressBar.setVisibility(0);
            ImageView imageView2 = b.b;
            Intrinsics.checkNotNullExpressionValue(imageView2, "btnClose");
            imageView2.setVisibility(0);
            TextView textView4 = b.i;
            Intrinsics.checkNotNullExpressionValue(textView4, "tvTiciRunning");
            textView4.setVisibility(8);
            if (this.q) {
                b.h.setText(R.string.tici_loading_long_time);
            } else {
                b.h.setText(R.string.tici_loading);
            }
        } else if (this.p) {
            TextView textView5 = b.f;
            Intrinsics.checkNotNullExpressionValue(textView5, "tvFileDate");
            textView5.setVisibility(0);
            ImageView imageView3 = b.c;
            Intrinsics.checkNotNullExpressionValue(imageView3, "ivDotMenu");
            imageView3.setVisibility(TiciHistoryKt.b(m0()) ^ true ? 0 : 8);
            TextView textView6 = b.h;
            Intrinsics.checkNotNullExpressionValue(textView6, "tvLoading");
            textView6.setVisibility(8);
            ProgressBar progressBar2 = b.e;
            Intrinsics.checkNotNullExpressionValue(progressBar2, "loading");
            progressBar2.setVisibility(8);
            ImageView imageView4 = b.b;
            Intrinsics.checkNotNullExpressionValue(imageView4, "btnClose");
            imageView4.setVisibility(8);
            TextView textView7 = b.i;
            Intrinsics.checkNotNullExpressionValue(textView7, "tvTiciRunning");
            textView7.setVisibility(0);
        } else {
            TextView textView8 = b.f;
            Intrinsics.checkNotNullExpressionValue(textView8, "tvFileDate");
            textView8.setVisibility(0);
            ImageView imageView5 = b.c;
            Intrinsics.checkNotNullExpressionValue(imageView5, "ivDotMenu");
            imageView5.setVisibility(TiciHistoryKt.b(m0()) ^ true ? 0 : 8);
            TextView textView9 = b.h;
            Intrinsics.checkNotNullExpressionValue(textView9, "tvLoading");
            textView9.setVisibility(8);
            ProgressBar progressBar3 = b.e;
            Intrinsics.checkNotNullExpressionValue(progressBar3, "loading");
            progressBar3.setVisibility(8);
            ImageView imageView6 = b.b;
            Intrinsics.checkNotNullExpressionValue(imageView6, "btnClose");
            imageView6.setVisibility(8);
            TextView textView10 = b.i;
            Intrinsics.checkNotNullExpressionValue(textView10, "tvTiciRunning");
            textView10.setVisibility(8);
        }
        View view = b.j;
        Intrinsics.checkNotNullExpressionValue(view, "viewLine");
        ImageView imageView7 = b.c;
        Intrinsics.checkNotNullExpressionValue(imageView7, "ivDotMenu");
        if (imageView7.getVisibility() == 0) {
            i = 0;
        }
        view.setVisibility(i);
        if (this.p) {
            b.g.setTextColor(b.getRoot().getContext().getColor(R.color.tici_blue));
            b.f.setTextColor(b.getRoot().getContext().getColor(R.color.tici_blue));
        } else {
            b.g.setTextColor(b.getRoot().getContext().getColor(R.color.tici_title_color));
            b.f.setTextColor(b.getRoot().getContext().getColor(R.color.tici_content_color));
        }
        ImageView imageView8 = b.b;
        Intrinsics.checkNotNullExpressionValue(imageView8, "btnClose");
        ViewExtKt.b(imageView8, new c(this));
        ImageView imageView9 = b.c;
        Intrinsics.checkNotNullExpressionValue(imageView9, "ivDotMenu");
        ViewExtKt.b(imageView9, new d(this));
        View view2 = b.d;
        Intrinsics.checkNotNullExpressionValue(view2, "layItemClickArea");
        ViewExtKt.b(view2, new e(this));
        if (this.r && (ticiHistoryItemListener = this.s) != null) {
            ticiHistoryItemListener.b(m0());
        }
        if (!this.p || TiciHistoryKt.a(m0())) {
            b.c.setEnabled(true);
        } else {
            b.c.setEnabled(false);
        }
    }

    public final int k0() {
        return this.n;
    }

    public final TiciHistoryItemListener l0() {
        return this.s;
    }

    public final TiciHistory m0() {
        TiciHistory ticiHistory = this.m;
        if (ticiHistory != null) {
            return ticiHistory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ticiHistory");
        return null;
    }

    public final boolean n0() {
        return this.q;
    }

    public final boolean o0() {
        return this.r;
    }

    public final boolean p0() {
        return this.o;
    }

    public final boolean q0() {
        return this.p;
    }

    public final void r0(boolean z) {
        this.q = z;
    }

    public final void s0(int i) {
        this.n = i;
    }

    public final void t0(boolean z) {
        this.r = z;
    }

    public final void u0(TiciHistoryItemListener ticiHistoryItemListener) {
        this.s = ticiHistoryItemListener;
    }

    public final void v0(boolean z) {
        this.o = z;
    }

    public final void w0(boolean z) {
        this.p = z;
    }
}
