package com.upuphone.xr.sapp.dialog;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.honey.account.g8.b;
import com.honey.account.g8.c;
import com.honey.account.g8.d;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.databinding.FragmentTouchpadDialogBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/upuphone/xr/sapp/dialog/TouchpadDialog;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "k", "()V", "j", "onAttachedToWindow", "Landroid/view/KeyEvent;", "event", "", "dispatchKeyEvent", "(Landroid/view/KeyEvent;)Z", "Landroidx/fragment/app/FragmentActivity;", "activity", "o", "(Landroidx/fragment/app/FragmentActivity;)V", "Lcom/upuphone/xr/sapp/databinding/FragmentTouchpadDialogBinding;", "a", "Lcom/upuphone/xr/sapp/databinding/FragmentTouchpadDialogBinding;", "binding", "Landroid/view/ViewGroup;", "b", "Landroid/view/ViewGroup;", "viewGroup", "c", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TouchpadDialog extends ConstraintLayout {
    public static final Companion c = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public FragmentTouchpadDialogBinding f6936a;
    public ViewGroup b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/dialog/TouchpadDialog$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TouchpadDialog(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        FragmentTouchpadDialogBinding c2 = FragmentTouchpadDialogBinding.c(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(c2, "inflate(...)");
        this.f6936a = c2;
        k();
    }

    private final void j() {
        ViewGroup viewGroup = this.b;
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
        this.b = null;
    }

    private final void k() {
        this.f6936a.b.setOnClickListener(new b(this));
        this.f6936a.g.setOnClickListener(new c(this));
        this.f6936a.j.setOnClickListener(new d());
    }

    public static final void l(TouchpadDialog touchpadDialog, View view) {
        Intrinsics.checkNotNullParameter(touchpadDialog, "this$0");
        touchpadDialog.j();
    }

    public static final void m(TouchpadDialog touchpadDialog, View view) {
        Intrinsics.checkNotNullParameter(touchpadDialog, "this$0");
        touchpadDialog.j();
    }

    public static final void n(View view) {
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "event");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("TouchpadDialog", "dispatchKeyEvent, event: " + keyEvent);
        if (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 4) {
            return super.dispatchKeyEvent(keyEvent);
        }
        j();
        return true;
    }

    public final void o(FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        View decorView = fragmentActivity.getWindow().getDecorView();
        Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) decorView;
        this.b = viewGroup;
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
        ViewGroup viewGroup2 = this.b;
        if (viewGroup2 != null) {
            viewGroup2.addView(this, layoutParams);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        requestFocusFromTouch();
    }
}
