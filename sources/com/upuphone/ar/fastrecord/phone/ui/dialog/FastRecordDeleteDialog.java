package com.upuphone.ar.fastrecord.phone.ui.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.honey.account.w3.a;
import com.honey.account.w3.b;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.databinding.FastRecordDeleteDialogBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u000e\u001a\u00020\fH\u0002J*\u0010\u000f\u001a\u00020\f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bJ\u000e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0014J\b\u0010\u0017\u001a\u00020\fH\u0016J\u0006\u0010\u0018\u001a\u00020\fR\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/dialog/FastRecordDeleteDialog;", "Landroid/app/AlertDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "themeResId", "", "(Landroid/content/Context;I)V", "mBinding", "Lcom/upuphone/ar/fastrecord/databinding/FastRecordDeleteDialogBinding;", "mClickCancel", "Lkotlin/Function0;", "", "mClickOk", "initView", "registerButtonClick", "clickOk", "clickCancel", "setCancelText", "cancelText", "", "setTitleText", "commandText", "show", "unRegisterButtonClick", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FastRecordDeleteDialog extends AlertDialog {
    @NotNull
    private FastRecordDeleteDialogBinding mBinding;
    @Nullable
    private Function0<Unit> mClickCancel;
    @Nullable
    private Function0<Unit> mClickOk;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FastRecordDeleteDialog(@NotNull Context context) {
        this(context, R.style.FastRecordLangPickerStyle);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void initView() {
        this.mBinding.c.setOnClickListener(new a(this));
        this.mBinding.b.setOnClickListener(new b(this));
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$2(FastRecordDeleteDialog fastRecordDeleteDialog, View view) {
        Intrinsics.checkNotNullParameter(fastRecordDeleteDialog, "this$0");
        fastRecordDeleteDialog.dismiss();
        Function0<Unit> function0 = fastRecordDeleteDialog.mClickOk;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$3(FastRecordDeleteDialog fastRecordDeleteDialog, View view) {
        Intrinsics.checkNotNullParameter(fastRecordDeleteDialog, "this$0");
        fastRecordDeleteDialog.dismiss();
        Function0<Unit> function0 = fastRecordDeleteDialog.mClickCancel;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public static /* synthetic */ void registerButtonClick$default(FastRecordDeleteDialog fastRecordDeleteDialog, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        if ((i & 2) != 0) {
            function02 = null;
        }
        fastRecordDeleteDialog.registerButtonClick(function0, function02);
    }

    public final void registerButtonClick(@Nullable Function0<Unit> function0, @Nullable Function0<Unit> function02) {
        this.mClickOk = function0;
        this.mClickCancel = function02;
    }

    public final void setCancelText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "cancelText");
        this.mBinding.b.setText(str);
    }

    public final void setTitleText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "commandText");
        this.mBinding.c.setText(str);
    }

    public void show() {
        super.show();
        ConstraintLayout b = this.mBinding.getRoot();
        ViewGroup.LayoutParams layoutParams = this.mBinding.getRoot().getLayoutParams();
        layoutParams.width = getContext().getResources().getDisplayMetrics().widthPixels - (getContext().getResources().getDimensionPixelSize(R.dimen.record_dimen_dialog_margin) * 2);
        b.setLayoutParams(layoutParams);
    }

    public final void unRegisterButtonClick() {
        this.mClickOk = null;
        this.mClickCancel = null;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordDeleteDialog(@NotNull Context context, int i) {
        super(context, i);
        View decorView;
        Intrinsics.checkNotNullParameter(context, "context");
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = context.getResources().getDimensionPixelSize(R.dimen.fast_record_delete_dialog_bottom_margin);
            window.setAttributes(attributes);
        }
        FastRecordDeleteDialogBinding c = FastRecordDeleteDialogBinding.c(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.mBinding = c;
        setView(c.getRoot());
        Window window2 = getWindow();
        if (!(window2 == null || (decorView = window2.getDecorView()) == null)) {
            decorView.setBackgroundColor(0);
        }
        initView();
    }
}
