package com.xjsd.ai.assistant.phone.tts;

import android.text.TextUtils;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.ContextHelper;
import com.xjsd.ai.assistant.core.api.tts.TtsData;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.nlg.NlgAbility;
import com.xjsd.ai.assistant.nlg.NlgTts;
import com.xjsd.ai.assistant.phone.R;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fR \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/xjsd/ai/assistant/phone/tts/TtsDataTransform;", "", "<init>", "()V", "Lcom/xjsd/ai/assistant/core/api/tts/TtsData;", "ttsData", "", "isWakeup", "", "a", "(Lcom/xjsd/ai/assistant/core/api/tts/TtsData;Z)V", "b", "(Lcom/xjsd/ai/assistant/core/api/tts/TtsData;)V", "", "", "Ljava/util/Map;", "emotionMap", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TtsDataTransform {

    /* renamed from: a  reason: collision with root package name */
    public static final TtsDataTransform f8607a = new TtsDataTransform();
    public static final Map b = MapsKt.mapOf(TuplesKt.to("诶。", "happy"));

    public final void a(TtsData ttsData, boolean z) {
        Intrinsics.checkNotNullParameter(ttsData, "ttsData");
        Locale locale = Locale.getDefault();
        ILog.a("TtsDataTransform", "手机当前语言为->" + locale);
        String nlgId = ttsData.getNlgId();
        String functionId = ttsData.getFunctionId();
        if (!TextUtils.isEmpty(functionId) || !TextUtils.isEmpty(nlgId)) {
            NlgAbility nlgAbility = (NlgAbility) AbilityManager.b.b(NlgAbility.class);
            Intrinsics.checkNotNull(nlgAbility);
            NlgTts tts = nlgAbility.getTts(nlgId, functionId, ttsData.getSlots());
            if (tts != null && !TextUtils.isEmpty(tts.getTts())) {
                ILog.a("TtsDataTransform", "nlgTts: " + tts);
                ttsData.setText(tts.getTts());
                String mode = tts.getMode();
                ttsData.setEmotionType((mode == null || mode.length() <= 0) ? (String) b.get(ttsData.getText()) : tts.getMode());
            }
        }
        String text = ttsData.getText();
        if (text == null || text.length() == 0) {
            ttsData.setText(ContextHelper.b(R.string.tts_common_error, new Object[0]));
        }
        if (z) {
            ILog.e("wake_up_tts_result", ttsData.getText());
        } else {
            ILog.e("tts_result", ttsData.getText());
        }
    }

    public final void b(TtsData ttsData) {
        Intrinsics.checkNotNullParameter(ttsData, "ttsData");
        String nlgId = ttsData.getNlgId();
        String functionId = ttsData.getFunctionId();
        if (!TextUtils.isEmpty(functionId) || !TextUtils.isEmpty(nlgId)) {
            NlgAbility nlgAbility = (NlgAbility) AbilityManager.b.b(NlgAbility.class);
            Intrinsics.checkNotNull(nlgAbility);
            NlgTts tts = nlgAbility.getTts(nlgId, functionId, ttsData.getSlots());
            if (tts != null && !TextUtils.isEmpty(tts.getTts())) {
                ILog.a("TtsDataTransform", "nlgTts: " + tts);
                ttsData.setText(tts.getTts());
                String mode = tts.getMode();
                ttsData.setEmotionType((mode == null || mode.length() <= 0) ? (String) b.get(ttsData.getText()) : tts.getMode());
            }
        }
        String text = ttsData.getText();
        if (text == null || text.length() == 0) {
            ttsData.setText(ContextHelper.b(R.string.tts_common_error, new Object[0]));
        }
    }
}
