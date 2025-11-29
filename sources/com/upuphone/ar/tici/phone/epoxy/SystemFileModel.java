package com.upuphone.ar.tici.phone.epoxy;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.epoxy.EpoxyModelClass;
import com.honey.account.q4.a;
import com.honey.account.q4.b;
import com.meizu.common.widget.MzButton;
import com.upuphone.ar.tici.R;
import com.upuphone.ar.tici.databinding.TiciSystemFileItemBinding;
import com.upuphone.ar.tici.phone.data.SystemFileInfo;
import com.upuphone.ar.tici.phone.data.SystemFileInfoKt;
import com.upuphone.ar.tici.phone.listener.SystemFileItemListener;
import com.upuphone.ar.tici.phone.starrynet.msg.ParagraphItem;
import com.upuphone.ar.tici.phone.utils.CommonExtKt;
import com.upuphone.xr.sapp.utils.FileSizeExtKt;
import com.upuphone.xr.sapp.utils.ViewExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@EpoxyModelClass
@SourceDebugExtension({"SMAP\nSystemFileModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SystemFileModel.kt\ncom/upuphone/ar/tici/phone/epoxy/SystemFileModel\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,91:1\n262#2,2:92\n260#2,4:94\n260#2:98\n*S KotlinDebug\n*F\n+ 1 SystemFileModel.kt\ncom/upuphone/ar/tici/phone/epoxy/SystemFileModel\n*L\n60#1:92,2\n65#1:94,4\n80#1:98\n*E\n"})
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\b'\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010 \u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010(\u001a\u00020!8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006)"}, d2 = {"Lcom/upuphone/ar/tici/phone/epoxy/SystemFileModel;", "Lcom/upuphone/ar/tici/phone/epoxy/BasicEpoxyModel;", "Lcom/upuphone/ar/tici/phone/epoxy/SystemFileHolder;", "<init>", "()V", "holder", "", "f0", "(Lcom/upuphone/ar/tici/phone/epoxy/SystemFileHolder;)V", "Lcom/upuphone/ar/tici/phone/data/SystemFileInfo;", "m", "Lcom/upuphone/ar/tici/phone/data/SystemFileInfo;", "l0", "()Lcom/upuphone/ar/tici/phone/data/SystemFileInfo;", "setSystemFileInfo", "(Lcom/upuphone/ar/tici/phone/data/SystemFileInfo;)V", "systemFileInfo", "", "n", "I", "i0", "()I", "m0", "(I)V", "itemBgRes", "Lcom/upuphone/ar/tici/phone/listener/SystemFileItemListener;", "o", "Lcom/upuphone/ar/tici/phone/listener/SystemFileItemListener;", "j0", "()Lcom/upuphone/ar/tici/phone/listener/SystemFileItemListener;", "n0", "(Lcom/upuphone/ar/tici/phone/listener/SystemFileItemListener;)V", "listener", "", "p", "Z", "k0", "()Z", "o0", "(Z)V", "supportLargeFile", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
public abstract class SystemFileModel extends BasicEpoxyModel<SystemFileHolder> {
    public SystemFileInfo m;
    public int n;
    public SystemFileItemListener o;
    public boolean p;

    public SystemFileModel() {
        super(R.layout.tici_system_file_item);
    }

    public static final void g0(SystemFileModel systemFileModel, View view) {
        Intrinsics.checkNotNullParameter(systemFileModel, "this$0");
        SystemFileItemListener systemFileItemListener = systemFileModel.o;
        if (systemFileItemListener != null) {
            systemFileItemListener.a(systemFileModel.l0());
        }
    }

    public static final void h0(SystemFileModel systemFileModel, View view) {
        Intrinsics.checkNotNullParameter(systemFileModel, "this$0");
        SystemFileItemListener systemFileItemListener = systemFileModel.o;
        if (systemFileItemListener != null) {
            systemFileItemListener.b(systemFileModel.l0());
        }
    }

    /* renamed from: f0 */
    public void t(SystemFileHolder systemFileHolder) {
        Intrinsics.checkNotNullParameter(systemFileHolder, "holder");
        TiciSystemFileItemBinding b = systemFileHolder.b();
        b.getRoot().setBackgroundResource(this.n);
        if (SystemFileInfoKt.a(l0())) {
            b.c.setImageResource(R.drawable.ic_word_file);
        } else {
            b.c.setImageResource(R.drawable.ic_txt_file);
        }
        SpannableString spannableString = new SpannableString(l0().getName());
        ParagraphItem highlight = l0().getHighlight();
        if (highlight != null) {
            spannableString.setSpan(new ForegroundColorSpan(b.getRoot().getContext().getColor(R.color.tici_blue)), highlight.getStart(), highlight.getEnd(), 18);
        }
        b.e.setText(spannableString);
        b.f.setText(FileSizeExtKt.a(l0().getSize()));
        TextView textView = b.d;
        Context context = b.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        textView.setText(CommonExtKt.a(context, l0().getUpdateTime()));
        MzButton mzButton = b.b;
        Intrinsics.checkNotNullExpressionValue(mzButton, "btnImport");
        boolean z = false;
        int i = 8;
        mzButton.setVisibility(!this.p ? (l0().getSize() > 204800 ? 1 : (l0().getSize() == 204800 ? 0 : -1)) <= 0 : (l0().getSize() > 10485760 ? 1 : (l0().getSize() == 10485760 ? 0 : -1)) <= 0 ? 0 : 8);
        TextView textView2 = b.g;
        Intrinsics.checkNotNullExpressionValue(textView2, "tvOverSize");
        MzButton mzButton2 = b.b;
        Intrinsics.checkNotNullExpressionValue(mzButton2, "btnImport");
        if (!(mzButton2.getVisibility() == 0)) {
            i = 0;
        }
        textView2.setVisibility(i);
        b.g.setText(this.p ? R.string.tici_file_over_size_10m : R.string.tici_file_over_size_200k);
        MzButton mzButton3 = b.b;
        Intrinsics.checkNotNullExpressionValue(mzButton3, "btnImport");
        ViewExtKt.b(mzButton3, new a(this));
        ConstraintLayout b2 = b.getRoot();
        Intrinsics.checkNotNullExpressionValue(b2, "getRoot(...)");
        ViewExtKt.b(b2, new b(this));
        ConstraintLayout b3 = b.getRoot();
        MzButton mzButton4 = b.b;
        Intrinsics.checkNotNullExpressionValue(mzButton4, "btnImport");
        if (mzButton4.getVisibility() == 0) {
            z = true;
        }
        b3.setEnabled(!z);
    }

    public final int i0() {
        return this.n;
    }

    public final SystemFileItemListener j0() {
        return this.o;
    }

    public final boolean k0() {
        return this.p;
    }

    public final SystemFileInfo l0() {
        SystemFileInfo systemFileInfo = this.m;
        if (systemFileInfo != null) {
            return systemFileInfo;
        }
        Intrinsics.throwUninitializedPropertyAccessException("systemFileInfo");
        return null;
    }

    public final void m0(int i) {
        this.n = i;
    }

    public final void n0(SystemFileItemListener systemFileItemListener) {
        this.o = systemFileItemListener;
    }

    public final void o0(boolean z) {
        this.p = z;
    }
}
