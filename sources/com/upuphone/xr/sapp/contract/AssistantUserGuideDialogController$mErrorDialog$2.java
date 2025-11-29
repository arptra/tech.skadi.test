package com.upuphone.xr.sapp.contract;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import androidx.core.util.Consumer;
import com.upuphone.xr.sapp.databinding.DialogNetworkErrorBinding;
import flyme.support.v7.app.AlertDialog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nAssistantUserGuideDialogController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AssistantUserGuideDialogController.kt\ncom/upuphone/xr/sapp/contract/AssistantUserGuideDialogController$mErrorDialog$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,183:1\n1#2:184\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lflyme/support/v7/app/AlertDialog;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class AssistantUserGuideDialogController$mErrorDialog$2 extends Lambda implements Function0<AlertDialog> {
    final /* synthetic */ AssistantUserGuideDialogController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AssistantUserGuideDialogController$mErrorDialog$2(AssistantUserGuideDialogController assistantUserGuideDialogController) {
        super(0);
        this.this$0 = assistantUserGuideDialogController;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(AssistantUserGuideDialogController assistantUserGuideDialogController, View view) {
        Intrinsics.checkNotNullParameter(assistantUserGuideDialogController, "this$0");
        assistantUserGuideDialogController.i().dismiss();
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$2(AssistantUserGuideDialogController assistantUserGuideDialogController, DialogInterface dialogInterface) {
        Consumer d;
        Intrinsics.checkNotNullParameter(assistantUserGuideDialogController, "this$0");
        UserGuideAuthResult c = assistantUserGuideDialogController.b;
        if (c != null && (d = assistantUserGuideDialogController.c) != null) {
            d.accept(c);
        }
    }

    public final AlertDialog invoke() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.this$0.f6688a);
        DialogNetworkErrorBinding c = DialogNetworkErrorBinding.c(LayoutInflater.from(this.this$0.f6688a));
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        c.b.setOnClickListener(new h(this.this$0));
        AlertDialog create = builder.setView((View) c.getRoot()).create();
        create.setOnDismissListener(new i(this.this$0));
        create.setCancelable(true);
        create.setCanceledOnTouchOutside(true);
        return create;
    }
}
