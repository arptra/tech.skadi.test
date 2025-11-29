package com.upuphone.xr.sapp.contract;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.upuphone.xr.sapp.contract.AssistantTtsTimbreSelector;
import com.upuphone.xr.sapp.databinding.DialogAssistantTtsTimbreBinding;
import flyme.support.v7.app.AlertDialog;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lflyme/support/v7/app/AlertDialog;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class AssistantTtsTimbreSelector$mSelectDialog$2 extends Lambda implements Function0<AlertDialog> {
    final /* synthetic */ AssistantTtsTimbreSelector this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AssistantTtsTimbreSelector$mSelectDialog$2(AssistantTtsTimbreSelector assistantTtsTimbreSelector) {
        super(0);
        this.this$0 = assistantTtsTimbreSelector;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(AssistantTtsTimbreSelector assistantTtsTimbreSelector, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(assistantTtsTimbreSelector, "this$0");
        Job b = assistantTtsTimbreSelector.g;
        if (b != null) {
            Job.DefaultImpls.a(b, (CancellationException) null, 1, (Object) null);
        }
    }

    public final AlertDialog invoke() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.this$0.f6679a);
        DialogAssistantTtsTimbreBinding c = DialogAssistantTtsTimbreBinding.c(LayoutInflater.from(this.this$0.f6679a));
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        c.b.addItemDecoration(new AssistantTtsTimbreSelector.TtsTimbreItemDecoration());
        c.b.setAdapter(this.this$0.c);
        c.b.setLayoutManager(new LinearLayoutManager(this.this$0.f6679a, 1, false));
        AlertDialog create = builder.setView((View) c.getRoot()).create();
        create.setCancelable(true);
        create.setCanceledOnTouchOutside(true);
        create.setOnDismissListener(new e(this.this$0));
        return create;
    }
}
