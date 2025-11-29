package com.upuphone.xr.sapp.contract;

import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.upuphone.xr.sapp.databinding.DialogAssistantUserGuideBinding;
import flyme.support.v7.app.AlertDialog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lflyme/support/v7/app/AlertDialog;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class AssistantUserGuideDialogController$assistantUserGuideDialog$2 extends Lambda implements Function0<AlertDialog> {
    final /* synthetic */ AssistantUserGuideDialogController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AssistantUserGuideDialogController$assistantUserGuideDialog$2(AssistantUserGuideDialogController assistantUserGuideDialogController) {
        super(0);
        this.this$0 = assistantUserGuideDialogController;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(AssistantUserGuideDialogController assistantUserGuideDialogController, View view) {
        Intrinsics.checkNotNullParameter(assistantUserGuideDialogController, "this$0");
        assistantUserGuideDialogController.l(2);
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$1(AssistantUserGuideDialogController assistantUserGuideDialogController, View view) {
        Intrinsics.checkNotNullParameter(assistantUserGuideDialogController, "this$0");
        assistantUserGuideDialogController.l(1);
    }

    public final AlertDialog invoke() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.this$0.f6688a);
        DialogAssistantUserGuideBinding c = DialogAssistantUserGuideBinding.c(LayoutInflater.from(this.this$0.f6688a));
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        TextView textView = c.c;
        textView.setText(this.this$0.g(textView.getText().toString()));
        c.c.setMovementMethod(LinkMovementMethod.getInstance());
        c.b.setOnClickListener(new f(this.this$0));
        c.f.setOnClickListener(new g(this.this$0));
        AlertDialog create = builder.setView((View) c.getRoot()).create();
        create.setCancelable(false);
        create.setCanceledOnTouchOutside(false);
        return create;
    }
}
