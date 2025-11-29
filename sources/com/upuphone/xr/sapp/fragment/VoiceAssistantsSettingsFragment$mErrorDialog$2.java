package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.upuphone.xr.sapp.databinding.DialogNetworkErrorBinding;
import flyme.support.v7.app.AlertDialog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lflyme/support/v7/app/AlertDialog;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class VoiceAssistantsSettingsFragment$mErrorDialog$2 extends Lambda implements Function0<AlertDialog> {
    final /* synthetic */ VoiceAssistantsSettingsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VoiceAssistantsSettingsFragment$mErrorDialog$2(VoiceAssistantsSettingsFragment voiceAssistantsSettingsFragment) {
        super(0);
        this.this$0 = voiceAssistantsSettingsFragment;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(VoiceAssistantsSettingsFragment voiceAssistantsSettingsFragment, View view) {
        Intrinsics.checkNotNullParameter(voiceAssistantsSettingsFragment, "this$0");
        voiceAssistantsSettingsFragment.B0().dismiss();
    }

    public final AlertDialog invoke() {
        Context requireContext = this.this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext);
        DialogNetworkErrorBinding c = DialogNetworkErrorBinding.c(LayoutInflater.from(requireContext));
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        c.b.setOnClickListener(new g(this.this$0));
        AlertDialog create = builder.setView((View) c.getRoot()).create();
        create.setCancelable(true);
        create.setCanceledOnTouchOutside(true);
        return create;
    }
}
