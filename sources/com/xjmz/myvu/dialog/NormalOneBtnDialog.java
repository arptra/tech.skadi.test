package com.xjmz.myvu.dialog;

import android.os.Bundle;
import android.view.View;
import com.honey.account.p9.c;
import com.upuphone.xr.sapp.databinding.NormalOneBtnDialogBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 !2\u00020\u0001:\u0001\"J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0010\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0013\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000fR\u0017\u0010\u0016\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u000fR\u001f\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/xjmz/myvu/dialog/NormalOneBtnDialog;", "Lcom/xjmz/myvu/dialog/GlobalDialogFragment;", "", "initView", "()V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "c", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "d", "getContent", "content", "e", "getConfirmText", "confirmText", "Lkotlin/Function0;", "f", "Lkotlin/jvm/functions/Function0;", "getConfirmCallback", "()Lkotlin/jvm/functions/Function0;", "confirmCallback", "Lcom/upuphone/xr/sapp/databinding/NormalOneBtnDialogBinding;", "g", "Lcom/upuphone/xr/sapp/databinding/NormalOneBtnDialogBinding;", "binding", "h", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class NormalOneBtnDialog extends GlobalDialogFragment {
    public static final Companion h = new Companion((DefaultConstructorMarker) null);
    public final String c;
    public final String d;
    public final String e;
    public final Function0 f;
    public final NormalOneBtnDialogBinding g;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/xjmz/myvu/dialog/NormalOneBtnDialog$Companion;", "", "<init>", "()V", "", "TAG", "Ljava/lang/String;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    private final void initView() {
        this.g.d.setText(this.c);
        if (this.c.length() == 0) {
            this.g.d.setVisibility(8);
        }
        this.g.c.setText(this.d);
        if (this.d.length() == 0) {
            this.g.c.setVisibility(8);
        }
        this.g.b.setText(this.e);
        this.g.b.setOnClickListener(new c(this));
    }

    public static final void k0(NormalOneBtnDialog normalOneBtnDialog, View view) {
        Intrinsics.checkNotNullParameter(normalOneBtnDialog, "this$0");
        normalOneBtnDialog.dismiss();
        Function0 function0 = normalOneBtnDialog.f;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initView();
    }
}
