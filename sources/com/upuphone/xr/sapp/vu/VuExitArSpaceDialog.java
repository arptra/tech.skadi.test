package com.upuphone.xr.sapp.vu;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.honey.account.b9.m;
import com.honey.account.b9.n;
import com.upuphone.xr.sapp.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/upuphone/xr/sapp/vu/VuExitArSpaceDialog;", "Landroid/app/Dialog;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "show", "()V", "Landroid/view/View$OnClickListener;", "a", "Landroid/view/View$OnClickListener;", "getOnConfirmListener", "()Landroid/view/View$OnClickListener;", "e", "(Landroid/view/View$OnClickListener;)V", "onConfirmListener", "b", "getOnCancelListener", "setOnCancelListener", "onCancelListener", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class VuExitArSpaceDialog extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public View.OnClickListener f8025a;
    public View.OnClickListener b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VuExitArSpaceDialog(Context context) {
        super(context, R.style.ViewExitArSpaceDialog);
        WindowManager.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(context, "context");
        setContentView(R.layout.dialog_vu_eixt_arspace);
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window == null || (layoutParams = window.getAttributes()) == null) {
            layoutParams = null;
        } else {
            layoutParams.width = -1;
            layoutParams.height = -2;
            layoutParams.gravity = 80;
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setAttributes(layoutParams);
            window2.setWindowAnimations(R.style.DialogAnimation);
            WindowInsetsControllerCompat a2 = WindowCompat.a(window2, window2.getDecorView());
            Intrinsics.checkNotNullExpressionValue(a2, "getInsetsController(...)");
            a2.e(2);
            a2.a(WindowInsetsCompat.Type.f());
        }
        findViewById(R.id.confirm).setOnClickListener(new m(this));
        findViewById(R.id.refuse).setOnClickListener(new n(this));
    }

    public static final void c(VuExitArSpaceDialog vuExitArSpaceDialog, View view) {
        Intrinsics.checkNotNullParameter(vuExitArSpaceDialog, "this$0");
        View.OnClickListener onClickListener = vuExitArSpaceDialog.f8025a;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        vuExitArSpaceDialog.dismiss();
    }

    public static final void d(VuExitArSpaceDialog vuExitArSpaceDialog, View view) {
        Intrinsics.checkNotNullParameter(vuExitArSpaceDialog, "this$0");
        View.OnClickListener onClickListener = vuExitArSpaceDialog.b;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        vuExitArSpaceDialog.cancel();
    }

    public final void e(View.OnClickListener onClickListener) {
        this.f8025a = onClickListener;
    }

    public void show() {
        super.show();
        Window window = getWindow();
        if (window != null) {
            WindowInsetsControllerCompat a2 = WindowCompat.a(window, window.getDecorView());
            Intrinsics.checkNotNullExpressionValue(a2, "getInsetsController(...)");
            a2.e(2);
            a2.a(WindowInsetsCompat.Type.f());
        }
    }
}
