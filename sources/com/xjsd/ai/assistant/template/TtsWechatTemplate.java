package com.xjsd.ai.assistant.template;

import com.xjsd.ai.assistant.phone.R;

public enum TtsWechatTemplate implements TtsTemplate {
    Wechat03_R01(R.string.tts_wechat03_r01, "Wechat03_R01"),
    Wechat03_R02(R.string.tts_wechat03_r02, "Wechat03_R02"),
    Wechat03_R03(R.string.tts_wechat03_r03, "Wechat03_R03"),
    Wechat03_R04(R.string.tts_wechat03_r04, "Wechat03_R04"),
    Wechat03_R05(R.string.tts_wechat03_r05, "Wechat03_R05"),
    Wechat03_R06(R.string.tts_wechat03_r06, "Wechat03_R06"),
    Wechat03_R07(R.string.tts_wechat03_r07, "Wechat03_R07"),
    Wechat03_R08(R.string.tts_wechat03_r08, "Wechat03_R08"),
    Wechat03_R09(R.string.tts_wechat03_r09, "Wechat03_R09"),
    Wechat04_R01(R.string.tts_wechat04_r01, "Wechat04_R01"),
    Wechat06_R01(R.string.tts_wechat06_r01, "Wechat06_R01"),
    Wechat07_R01(R.string.tts_wechat07_r01, "Wechat07_R01"),
    Wechat07_R02(R.string.tts_wechat07_r02, "Wechat07_R02"),
    Wechat07_R03(R.string.tts_wechat07_r03, "Wechat07_R03"),
    Wechat07_R04(R.string.tts_wechat07_r04, "Wechat07_R04"),
    Wechat07_R05(R.string.tts_wechat07_r05, "Wechat07_R05"),
    Wechat07_R06(R.string.tts_wechat07_r06, "Wechat07_R06"),
    Wechat07_R07(R.string.tts_wechat07_r07, "Wechat07_R07"),
    Wechat09_R01(R.string.tts_wechat09_r01, "Wechat09_R01"),
    Wechat10_R01(R.string.tts_wechat10_r01, "Wechat10_R01"),
    Wechat10_R02(R.string.tts_wechat10_r02, "Wechat10_R02");
    
    private final String functionId;
    private final int resId;

    private TtsWechatTemplate(int i, String str) {
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
