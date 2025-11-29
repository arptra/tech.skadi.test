package com.upuphone.xr.sapp.fragment;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.upuphone.xr.sapp.R;
import com.xjsd.ai.assistant.phone.helper.AssistantSettingUtils;
import flyme.support.v7.app.AlertDialog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lflyme/support/v7/app/AlertDialog;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class VoiceAssistantsSettingsFragment$mLlmReplyDialog$2 extends Lambda implements Function0<AlertDialog> {
    final /* synthetic */ VoiceAssistantsSettingsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VoiceAssistantsSettingsFragment$mLlmReplyDialog$2(VoiceAssistantsSettingsFragment voiceAssistantsSettingsFragment) {
        super(0);
        this.this$0 = voiceAssistantsSettingsFragment;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(VoiceAssistantsSettingsFragment voiceAssistantsSettingsFragment, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(voiceAssistantsSettingsFragment, "this$0");
        voiceAssistantsSettingsFragment.e = i;
        dialogInterface.dismiss();
        if (i == 0) {
            AssistantSettingUtils assistantSettingUtils = AssistantSettingUtils.b;
            assistantSettingUtils.c(voiceAssistantsSettingsFragment.getContext(), "chat_gpt_tts_play", true);
            assistantSettingUtils.c(voiceAssistantsSettingsFragment.getContext(), "chat_gpt_card_display", true);
        } else if (i == 1) {
            AssistantSettingUtils assistantSettingUtils2 = AssistantSettingUtils.b;
            assistantSettingUtils2.c(voiceAssistantsSettingsFragment.getContext(), "chat_gpt_tts_play", true);
            assistantSettingUtils2.c(voiceAssistantsSettingsFragment.getContext(), "chat_gpt_card_display", false);
        } else if (i == 2) {
            AssistantSettingUtils assistantSettingUtils3 = AssistantSettingUtils.b;
            assistantSettingUtils3.c(voiceAssistantsSettingsFragment.getContext(), "chat_gpt_tts_play", false);
            assistantSettingUtils3.c(voiceAssistantsSettingsFragment.getContext(), "chat_gpt_card_display", true);
        }
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$1(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }

    public final AlertDialog invoke() {
        AlertDialog create = new AlertDialog.Builder(this.this$0.requireActivity()).setSingleChoiceItems((CharSequence[]) new String[]{this.this$0.getString(R.string.settings_voice_llm_reply_option_all), this.this$0.getString(R.string.settings_voice_llm_reply_option_tts), this.this$0.getString(R.string.settings_voice_llm_reply_option_text)}, this.this$0.e, (DialogInterface.OnClickListener) new h(this.this$0)).create();
        create.setCustomTitle(LayoutInflater.from(this.this$0.requireContext()).inflate(R.layout.dialog_llm_reply_custom_title_view, (ViewGroup) null));
        create.setButton(-2, (CharSequence) this.this$0.getString(R.string.cancel), (DialogInterface.OnClickListener) new i());
        return create;
    }
}
