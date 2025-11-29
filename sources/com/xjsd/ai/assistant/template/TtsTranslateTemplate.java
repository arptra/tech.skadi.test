package com.xjsd.ai.assistant.template;

import com.xjsd.ai.assistant.phone.R;

public enum TtsTranslateTemplate implements TtsTemplate {
    TRANS05_R01(R.string.tts_trans05_r01, "TRANS05_R01"),
    TRANS05_R02(R.string.tts_trans05_r02, "TRANS05_R02"),
    TRANS05_R03(R.string.tts_trans05_r03, "TRANS05_R03"),
    TRANS05_R04(R.string.tts_trans05_r04, "TRANS05_R04"),
    TRANS05_R05(R.string.tts_trans05_r05, "TRANS05_R05"),
    TRANS06_R01(R.string.tts_trans06_r01, "TRANS06_R01"),
    TRANS06_R02(R.string.tts_trans06_r02, "TRANS06_R02"),
    TRANS06_R03(R.string.tts_trans06_r03, "TRANS06_R03"),
    TRANSLATE03_P01(R.string.tts_translate03_p01, "TRANSLATE03_P01");
    
    private final String functionId;
    private final int resId;

    private TtsTranslateTemplate(int i, String str) {
        this.resId = i;
        this.functionId = str;
    }

    public String getFunctionId() {
        return this.functionId;
    }

    public int getResId() {
        return this.resId;
    }
}
