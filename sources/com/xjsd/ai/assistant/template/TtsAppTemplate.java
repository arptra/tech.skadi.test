package com.xjsd.ai.assistant.template;

import com.xjsd.ai.assistant.phone.R;

public enum TtsAppTemplate implements TtsTemplate {
    APP01_R01(R.string.tts_app01_r01, "APP01_R01"),
    APP01_R02(R.string.tts_app01_r02, "APP01_R02"),
    APP01_R04(R.string.tts_app01_r04, "APP01_R04"),
    APP01_R07(R.string.tts_app01_r07, "APP01_R07"),
    APP01_R08(R.string.tts_app01_r08, "APP01_R08"),
    APP01_R09(R.string.tts_app01_r09, "APP01_R09"),
    APP01_R10(R.string.tts_app01_r10, "APP01_R10"),
    APP02_R01(R.string.tts_app02_r01, "APP02_R01"),
    APP02_R02(R.string.tts_app02_r02, "APP02_R02"),
    APP02_R03(R.string.tts_app02_r03, "APP02_R03"),
    APP02_R04(R.string.tts_app02_r04, "APP02_R04"),
    APP02_R05(R.string.tts_app02_r05, "APP02_R05"),
    APP02_R07(R.string.tts_app02_r07, "APP02_R07"),
    APP02_R08(R.string.tts_app02_r08, "APP02_R08");
    
    private final String functionId;
    private final int resId;

    private TtsAppTemplate(int i, String str) {
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
