package com.xjmz.myvu.dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Layout;
import android.text.StaticLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.honey.account.p9.f;
import com.honey.account.p9.g;
import com.honey.account.p9.h;
import com.honey.account.p9.i;
import com.honey.account.p9.j;
import com.honey.account.p9.k;
import com.meizu.common.widget.MzButton;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.NormalTwoBtnDialogBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 A2\u00020\u0001:\u0001BBo\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001d\u0010\u0013J'\u0010#\u001a\u00020!2\u0006\u0010\u0014\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\nH\u0002¢\u0006\u0004\b%\u0010\u0013J\u000f\u0010&\u001a\u00020\nH\u0002¢\u0006\u0004\b&\u0010\u0013J\u001f\u0010)\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u0004H\u0002¢\u0006\u0004\b)\u0010*R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b/\u0010,\u001a\u0004\b0\u0010.R\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b1\u0010,\u001a\u0004\b2\u0010.R\u0017\u0010\b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b3\u0010,\u001a\u0004\b4\u0010.R\u001f\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001f\u0010\f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b9\u00106\u001a\u0004\b:\u00108R\u001f\u0010\r\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b;\u00106\u001a\u0004\b<\u00108R\u0014\u0010@\u001a\u00020=8\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?¨\u0006C"}, d2 = {"Lcom/xjmz/myvu/dialog/NormalTwoBtnDialog;", "Lcom/xjmz/myvu/dialog/GlobalDialogFragment;", "Landroid/view/View;", "dialogView", "", "title", "content", "refuseText", "confirmText", "Lkotlin/Function0;", "", "refuseCallback", "confirmCallback", "cancelCallback", "", "touchOutSideClose", "<init>", "(Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Z)V", "initView", "()V", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/content/DialogInterface;", "dialog", "onCancel", "(Landroid/content/DialogInterface;)V", "u0", "Landroid/widget/TextView;", "", "text", "", "widthPx", "s0", "(Landroid/widget/TextView;Ljava/lang/CharSequence;I)I", "z0", "v0", "textView", "prefix", "E0", "(Landroid/widget/TextView;Ljava/lang/String;)V", "c", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "d", "getContent", "e", "getRefuseText", "f", "getConfirmText", "g", "Lkotlin/jvm/functions/Function0;", "getRefuseCallback", "()Lkotlin/jvm/functions/Function0;", "h", "getConfirmCallback", "i", "getCancelCallback", "Lcom/upuphone/xr/sapp/databinding/NormalTwoBtnDialogBinding;", "j", "Lcom/upuphone/xr/sapp/databinding/NormalTwoBtnDialogBinding;", "binding", "k", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nNormalTwoBtnDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NormalTwoBtnDialog.kt\ncom/xjmz/myvu/dialog/NormalTwoBtnDialog\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,185:1\n254#2:186\n254#2:187\n256#2,2:188\n256#2,2:190\n256#2,2:192\n256#2,2:194\n*S KotlinDebug\n*F\n+ 1 NormalTwoBtnDialog.kt\ncom/xjmz/myvu/dialog/NormalTwoBtnDialog\n*L\n89#1:186\n98#1:187\n144#1:188,2\n145#1:190,2\n157#1:192,2\n158#1:194,2\n*E\n"})
public final class NormalTwoBtnDialog extends GlobalDialogFragment {
    public static final Companion k = new Companion((DefaultConstructorMarker) null);
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final Function0 g;
    public final Function0 h;
    public final Function0 i;
    public final NormalTwoBtnDialogBinding j;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00068\u0002XT¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/xjmz/myvu/dialog/NormalTwoBtnDialog$Companion;", "", "<init>", "()V", "Landroidx/fragment/app/FragmentActivity;", "rootActivity", "", "title", "content", "confirmText", "refuseText", "Lkotlin/Function0;", "", "confirmCallback", "refuseCallback", "cancelCallback", "", "touchOutSideClose", "cancelable", "Lcom/xjmz/myvu/dialog/NormalTwoBtnDialog;", "a", "(Landroidx/fragment/app/FragmentActivity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ZZ)Lcom/xjmz/myvu/dialog/NormalTwoBtnDialog;", "TAG", "Ljava/lang/String;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ NormalTwoBtnDialog b(Companion companion, FragmentActivity fragmentActivity, String str, String str2, String str3, String str4, Function0 function0, Function0 function02, Function0 function03, boolean z, boolean z2, int i, Object obj) {
            int i2 = i;
            return companion.a(fragmentActivity, str, str2, str3, str4, (i2 & 32) != 0 ? null : function0, (i2 & 64) != 0 ? null : function02, (i2 & 128) != 0 ? null : function03, (i2 & 256) != 0 ? true : z, (i2 & 512) != 0 ? true : z2);
        }

        public final NormalTwoBtnDialog a(FragmentActivity fragmentActivity, String str, String str2, String str3, String str4, Function0 function0, Function0 function02, Function0 function03, boolean z, boolean z2) {
            FragmentActivity fragmentActivity2 = fragmentActivity;
            Intrinsics.checkNotNullParameter(fragmentActivity, "rootActivity");
            Intrinsics.checkNotNullParameter(str, "title");
            String str5 = str2;
            Intrinsics.checkNotNullParameter(str5, "content");
            String str6 = str3;
            Intrinsics.checkNotNullParameter(str6, "confirmText");
            String str7 = str4;
            Intrinsics.checkNotNullParameter(str7, "refuseText");
            View inflate = fragmentActivity.getLayoutInflater().inflate(R.layout.normal_two_btn_dialog, (ViewGroup) null, false);
            Intrinsics.checkNotNull(inflate);
            NormalTwoBtnDialog normalTwoBtnDialog = new NormalTwoBtnDialog(inflate, str, str5, str7, str6, function02, function0, function03, z);
            normalTwoBtnDialog.setCancelable(z2);
            fragmentActivity.getSupportFragmentManager().s().e(normalTwoBtnDialog, (String) null).k();
            return normalTwoBtnDialog;
        }

        public Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NormalTwoBtnDialog(View view, String str, String str2, String str3, String str4, Function0 function0, Function0 function02, Function0 function03, boolean z) {
        super(view, z);
        Intrinsics.checkNotNullParameter(view, "dialogView");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "content");
        Intrinsics.checkNotNullParameter(str3, "refuseText");
        Intrinsics.checkNotNullParameter(str4, "confirmText");
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = function0;
        this.h = function02;
        this.i = function03;
        NormalTwoBtnDialogBinding a2 = NormalTwoBtnDialogBinding.a(view);
        Intrinsics.checkNotNullExpressionValue(a2, "bind(...)");
        this.j = a2;
    }

    public static final void A0(NormalTwoBtnDialog normalTwoBtnDialog, View view) {
        Intrinsics.checkNotNullParameter(normalTwoBtnDialog, "this$0");
        Function0 function0 = normalTwoBtnDialog.g;
        if (function0 != null) {
            function0.invoke();
        }
        normalTwoBtnDialog.dismiss();
    }

    public static final void B0(NormalTwoBtnDialog normalTwoBtnDialog, View view) {
        Intrinsics.checkNotNullParameter(normalTwoBtnDialog, "this$0");
        Function0 function0 = normalTwoBtnDialog.h;
        if (function0 != null) {
            function0.invoke();
        }
        normalTwoBtnDialog.dismiss();
    }

    public static final void C0(NormalTwoBtnDialog normalTwoBtnDialog) {
        Intrinsics.checkNotNullParameter(normalTwoBtnDialog, "this$0");
        TextView textView = normalTwoBtnDialog.j.h;
        Intrinsics.checkNotNullExpressionValue(textView, "title");
        normalTwoBtnDialog.E0(textView, "title");
    }

    public static final void D0(NormalTwoBtnDialog normalTwoBtnDialog) {
        Intrinsics.checkNotNullParameter(normalTwoBtnDialog, "this$0");
        TextView textView = normalTwoBtnDialog.j.b;
        Intrinsics.checkNotNullExpressionValue(textView, "content");
        normalTwoBtnDialog.E0(textView, "content");
    }

    private final void initView() {
        this.j.h.setText(this.c);
        if (this.c.length() == 0) {
            this.j.h.setVisibility(8);
        }
        TextView textView = this.j.h;
        Intrinsics.checkNotNullExpressionValue(textView, "title");
        if (textView.getVisibility() == 0) {
            this.j.h.post(new f(this));
        }
        this.j.b.setText(this.d);
        if (this.d.length() == 0) {
            this.j.b.setVisibility(8);
        }
        TextView textView2 = this.j.b;
        Intrinsics.checkNotNullExpressionValue(textView2, "content");
        if (textView2.getVisibility() == 0) {
            this.j.b.post(new g(this));
        }
        u0();
    }

    public static final void w0(NormalTwoBtnDialog normalTwoBtnDialog, View view) {
        Intrinsics.checkNotNullParameter(normalTwoBtnDialog, "this$0");
        Function0 function0 = normalTwoBtnDialog.g;
        if (function0 != null) {
            function0.invoke();
        }
        normalTwoBtnDialog.dismiss();
    }

    public static final void y0(NormalTwoBtnDialog normalTwoBtnDialog, View view) {
        Intrinsics.checkNotNullParameter(normalTwoBtnDialog, "this$0");
        Function0 function0 = normalTwoBtnDialog.h;
        if (function0 != null) {
            function0.invoke();
        }
        normalTwoBtnDialog.dismiss();
    }

    public final void E0(TextView textView, String str) {
        int lineCount = textView.getLineCount();
        if (lineCount > 1) {
            textView.setGravity(8388611);
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("NormalTwoBtnDialog", "setupTextViewGravity|" + str + ", lineCount: " + lineCount + ", gravity: START");
            return;
        }
        textView.setGravity(17);
        ULog.Delegate delegate2 = ULog.f6446a;
        delegate2.a("NormalTwoBtnDialog", "setupTextViewGravity|" + str + ", lineCount: " + lineCount + ", gravity: CENTER");
    }

    public void onCancel(DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialogInterface, "dialog");
        Function0 function0 = this.i;
        if (function0 != null) {
            function0.invoke();
        }
        super.onCancel(dialogInterface);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initView();
    }

    public final int s0(TextView textView, CharSequence charSequence, int i2) {
        StaticLayout build = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), textView.getPaint(), i2).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setIncludePad(textView.getIncludeFontPadding()).setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency()).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build.getLineCount();
    }

    public final void u0() {
        this.j.k.setText(this.e);
        this.j.j.setText(this.f);
        this.j.e.setText(this.e);
        this.j.d.setText(this.f);
        float f2 = this.j.c.getContext().getResources().getDisplayMetrics().density;
        int i0 = ((i0() - ((int) (((float) 72) * f2))) - ((int) ((((float) 30) * f2) * ((float) 2)))) / 2;
        MzButton mzButton = this.j.e;
        Intrinsics.checkNotNullExpressionValue(mzButton, "hRefuse");
        int s0 = s0(mzButton, this.e, i0);
        MzButton mzButton2 = this.j.j;
        Intrinsics.checkNotNullExpressionValue(mzButton2, "vConfirm");
        int s02 = s0(mzButton2, this.f, i0);
        if (s0 > 1 || s02 > 1) {
            z0();
        } else {
            v0();
        }
    }

    public final void v0() {
        LinearLayout linearLayout = this.j.c;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "hButtonLayout");
        linearLayout.setVisibility(0);
        LinearLayout linearLayout2 = this.j.i;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "vButtonLayout");
        linearLayout2.setVisibility(8);
        this.j.e.setOnClickListener(new j(this));
        this.j.d.setOnClickListener(new k(this));
    }

    public final void z0() {
        LinearLayout linearLayout = this.j.c;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "hButtonLayout");
        linearLayout.setVisibility(8);
        LinearLayout linearLayout2 = this.j.i;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "vButtonLayout");
        linearLayout2.setVisibility(0);
        this.j.k.setOnClickListener(new h(this));
        this.j.j.setOnClickListener(new i(this));
    }
}
