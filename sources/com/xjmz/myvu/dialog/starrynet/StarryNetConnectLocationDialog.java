package com.xjmz.myvu.dialog.starrynet;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.honey.account.q9.n;
import com.honey.account.q9.o;
import com.honey.account.q9.p;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.xr.sapp.databinding.DialogStarrynetLocationBinding;
import com.upuphone.xr.sapp.utils.FlymeUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0010\u0010\u000bR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/xjmz/myvu/dialog/starrynet/StarryNetConnectLocationDialog;", "Landroid/app/AlertDialog;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "themeResId", "(Landroid/content/Context;I)V", "", "show", "()V", "", "isVisible", "h", "(Z)V", "d", "Lcom/upuphone/xr/sapp/databinding/DialogStarrynetLocationBinding;", "a", "Lcom/upuphone/xr/sapp/databinding/DialogStarrynetLocationBinding;", "binding", "b", "Z", "mIsNavigationBar", "c", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nStarryNetConnectLocationDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StarryNetConnectLocationDialog.kt\ncom/xjmz/myvu/dialog/starrynet/StarryNetConnectLocationDialog\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,131:1\n256#2,2:132\n*S KotlinDebug\n*F\n+ 1 StarryNetConnectLocationDialog.kt\ncom/xjmz/myvu/dialog/starrynet/StarryNetConnectLocationDialog\n*L\n118#1:132,2\n*E\n"})
public final class StarryNetConnectLocationDialog extends AlertDialog {
    public static final Companion c = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public DialogStarrynetLocationBinding f8239a;
    public boolean b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjmz/myvu/dialog/starrynet/StarryNetConnectLocationDialog$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StarryNetConnectLocationDialog(Context context) {
        this(context, R.style.LangPickerStyle);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static final void e(StarryNetConnectLocationDialog starryNetConnectLocationDialog, View view) {
        Intrinsics.checkNotNullParameter(starryNetConnectLocationDialog, "this$0");
        starryNetConnectLocationDialog.dismiss();
    }

    public static final void f(StarryNetConnectLocationDialog starryNetConnectLocationDialog, View view) {
        Intrinsics.checkNotNullParameter(starryNetConnectLocationDialog, "this$0");
        starryNetConnectLocationDialog.getContext().startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
        starryNetConnectLocationDialog.dismiss();
    }

    public static final void g(StarryNetConnectLocationDialog starryNetConnectLocationDialog) {
        Intrinsics.checkNotNullParameter(starryNetConnectLocationDialog, "this$0");
        View view = starryNetConnectLocationDialog.f8239a.d;
        Intrinsics.checkNotNullExpressionValue(view, "dialogBottom");
        view.setVisibility(starryNetConnectLocationDialog.b ^ true ? 0 : 8);
    }

    public final void d() {
        String string = getContext().getString(com.upuphone.xr.sapp.R.string.location_permission_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getContext().getString(Build.VERSION.SDK_INT < 31 ? com.upuphone.xr.sapp.R.string.flyme_internal_app_permission_location_text_android_r : com.upuphone.xr.sapp.R.string.flyme_internal_app_permission_location_text);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        this.f8239a.i.setText(string);
        this.f8239a.c.setText(string2);
        this.f8239a.g.setText(com.upuphone.xr.sapp.R.string.cancel);
        this.f8239a.b.setText(com.upuphone.xr.sapp.R.string.open_notification);
        this.f8239a.g.setOnClickListener(new o(this));
        this.f8239a.b.setOnClickListener(new p(this));
    }

    public final void h(boolean z) {
        this.b = z;
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
        this.f8239a.getRoot().post(new n(this));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StarryNetConnectLocationDialog(Context context, int i) {
        super(context, i);
        View decorView;
        Intrinsics.checkNotNullParameter(context, "context");
        setCanceledOnTouchOutside(false);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
        }
        DialogStarrynetLocationBinding c2 = DialogStarrynetLocationBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(c2, "inflate(...)");
        this.f8239a = c2;
        setView(c2.getRoot());
        FlymeUtils.a(this.f8239a.getRoot(), context);
        Window window2 = getWindow();
        if (!(window2 == null || (decorView = window2.getDecorView()) == null)) {
            decorView.setBackgroundColor(0);
        }
        d();
    }
}
