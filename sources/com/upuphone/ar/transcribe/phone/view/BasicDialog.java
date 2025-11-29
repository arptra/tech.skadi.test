package com.upuphone.ar.transcribe.phone.view;

import android.app.AlertDialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.honey.account.y4.a;
import com.upuphone.ar.transcribe.R;
import com.upuphone.ar.transcribe.databinding.BaseDialogBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/view/BasicDialog;", "Landroid/app/AlertDialog;", "", "show", "()V", "Lcom/upuphone/ar/transcribe/databinding/BaseDialogBinding;", "a", "Lcom/upuphone/ar/transcribe/databinding/BaseDialogBinding;", "mBinding", "", "b", "Z", "mIsNavigationBar", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nBasicDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BasicDialog.kt\ncom/upuphone/ar/transcribe/phone/view/BasicDialog\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,143:1\n262#2,2:144\n*S KotlinDebug\n*F\n+ 1 BasicDialog.kt\ncom/upuphone/ar/transcribe/phone/view/BasicDialog\n*L\n53#1:144,2\n*E\n"})
public final class BasicDialog extends AlertDialog {

    /* renamed from: a  reason: collision with root package name */
    public BaseDialogBinding f6125a;
    public boolean b;

    public static final void b(BasicDialog basicDialog) {
        Intrinsics.checkNotNullParameter(basicDialog, "this$0");
        View view = basicDialog.f6125a.b;
        Intrinsics.checkNotNullExpressionValue(view, "dialogBottom");
        view.setVisibility(basicDialog.b ^ true ? 0 : 8);
    }

    public void show() {
        super.show();
        LinearLayout a2 = this.f6125a.getRoot();
        ViewGroup.LayoutParams layoutParams = this.f6125a.getRoot().getLayoutParams();
        layoutParams.width = getContext().getResources().getDisplayMetrics().widthPixels - (getContext().getResources().getDimensionPixelSize(R.dimen.dimen_lang_select_dialog_margin) * 2);
        a2.setLayoutParams(layoutParams);
        this.f6125a.getRoot().post(new a(this));
    }
}
