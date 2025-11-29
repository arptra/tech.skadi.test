package com.xjsd.ai.assistant.nlg;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.upuphone.ai.NlgService;
import com.xjsd.ai.assistant.log.ILog;
import java.util.Map;

public class NlgAbilityImpl implements NlgAbility {
    private static final String TAG = "NlgAbilityImpl";

    public NlgTts getTts(String str, String str2, Map<String, String> map) {
        ILog.d("nlg_function_id", TextUtils.isEmpty(str2) ? str : str2);
        try {
            ILog.a(TAG, "getTts, nlgId:" + str + ", functionId:" + str2 + ", slots:" + map);
            String f = NlgService.d().f(str, str2, map, (String) null);
            StringBuilder sb = new StringBuilder();
            sb.append("getTts, nlgTts:");
            sb.append(f);
            ILog.a(TAG, sb.toString());
            return (NlgTts) new Gson().fromJson(f, NlgTts.class);
        } catch (Exception e) {
            ILog.i(TAG, "getTts exception: ", e.getMessage());
            return null;
        }
    }

    public String getTtsWithDefault(String str, String str2, Map<String, String> map, String str3) {
        NlgTts tts = getTts(str, str2, map);
        if (tts == null || TextUtils.isEmpty(tts.getTts())) {
            return str3;
        }
        ILog.a(TAG, "nlgTts: " + tts);
        return tts.getTts();
    }

    public /* bridge */ /* synthetic */ boolean isProxyInstance() {
        return super.isProxyInstance();
    }

    public /* bridge */ /* synthetic */ void register() {
        super.register();
    }
}
