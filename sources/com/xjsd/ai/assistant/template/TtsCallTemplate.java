package com.xjsd.ai.assistant.template;

import com.xjsd.ai.assistant.phone.R;

public enum TtsCallTemplate implements TtsTemplate {
    CALL01_P02(R.string.tts_call01_p02, "CALL01_P02"),
    CALL01_P03(R.string.tts_call01_p03, "CALL01_P03"),
    CALL01_P05(R.string.tts_call01_p05, "CALL01_P05"),
    CALL01_P06(R.string.tts_call01_p06, "CALL01_P06"),
    CALL01_P07(R.string.tts_call01_p07, "CALL01_P07"),
    CALL01_P08(R.string.tts_call01_p08, "CALL01_P08"),
    CALL02_P01(R.string.tts_call02_p01, "CALL02_P01"),
    CALL02_P02(R.string.tts_call02_p02, "CALL02_P02"),
    CALL02_P03(R.string.tts_call02_p03, "CALL02_P03"),
    CALL02_P04(R.string.tts_call02_p04, "CALL02_P04"),
    CALL02_P05(R.string.tts_call02_p05, "CALL02_P05"),
    CALL02_P06(R.string.tts_call02_p06, "CALL02_P06"),
    CALL02_P11(R.string.tts_call02_p11, "CALL02_P11"),
    CALL02_P13(R.string.tts_call02_p13, "CALL02_P13"),
    CALL07_P01(R.string.tts_call07_p01, "CALL07_P01"),
    CALL09_P01(R.string.tts_call09_p01, "CALL09_P01");
    
    private final String functionId;
    private final int resId;

    private TtsCallTemplate(int i, String str) {
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
