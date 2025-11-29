package com.upuphone.ar.translation.phone.view;

import android.app.AlertDialog;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.honey.account.h5.a;
import com.upuphone.ar.translation.phone.databinding.LayoutBasicDialogBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/upuphone/ar/translation/phone/view/BasicDialog;", "Landroid/app/AlertDialog;", "", "show", "()V", "Lcom/upuphone/ar/translation/phone/databinding/LayoutBasicDialogBinding;", "a", "Lcom/upuphone/ar/translation/phone/databinding/LayoutBasicDialogBinding;", "mBinding", "", "b", "Z", "mIsNavigationBar", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nBasicDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BasicDialog.kt\ncom/upuphone/ar/translation/phone/view/BasicDialog\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,153:1\n262#2,2:154\n*S KotlinDebug\n*F\n+ 1 BasicDialog.kt\ncom/upuphone/ar/translation/phone/view/BasicDialog\n*L\n63#1:154,2\n*E\n"})
public final class BasicDialog extends AlertDialog {

    /* renamed from: a  reason: collision with root package name */
    public LayoutBasicDialogBinding f6319a;
    public boolean b;

    public static final void b(BasicDialog basicDialog) {
        Intrinsics.checkNotNullParameter(basicDialog, "this$0");
        View view = basicDialog.f6319a.b;
        Intrinsics.checkNotNullExpressionValue(view, "dialogBottom");
        view.setVisibility(basicDialog.b ^ true ? 0 : 8);
    }

    public void show() {
        super.show();
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.copyFrom(window.getAttributes());
            layoutParams.width = -1;
            window.setAttributes(layoutParams);
        }
        this.f6319a.getRoot().post(new a(this));
    }
}
