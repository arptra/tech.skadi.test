package com.xjsd.ai.assistant.template;

import com.xjsd.ai.assistant.phone.R;

public enum TtsSettingTemplate implements TtsTemplate {
    SET02_P01(R.string.tts_set02_p01, "SET02_P01"),
    SET02_P02(R.string.tts_set02_p02, "SET02_P02"),
    SET03_P07(R.string.tts_set03_p07, "SET03_P07"),
    SET05_P01(R.string.tts_set05_p01, "SET05_P01"),
    SET05_P02(R.string.tts_set05_p02, "SET05_P02"),
    SET05_P03(R.string.tts_set05_p03, "SET05_P03"),
    SET05_P04(R.string.tts_set05_p04, "SET05_P04"),
    SET08_P01(R.string.tts_set08_p01, "SET08_P01"),
    SET08_P02(R.string.tts_set08_p02, "SET08_P02"),
    SET08_P03(R.string.tts_set08_p03, "SET08_P03"),
    SET08_P04(R.string.tts_set08_p04, "SET08_P04"),
    SET08_P05(R.string.tts_set08_p05, "SET08_P05"),
    SET08_P06(R.string.tts_set08_p06, "SET08_P06"),
    SET08_P07(R.string.tts_set08_p07, "SET08_P07"),
    SET08_P08(R.string.tts_set08_p08, "SET08_P08"),
    SET08_P09(R.string.tts_set08_p09, "SET08_P09"),
    SET08_P10(R.string.tts_set08_p10, "SET08_P10"),
    SET08_P11(R.string.tts_set08_p11, "SET08_P11"),
    SET09_P01(R.string.tts_set09_p01, "SET09_P01"),
    SET09_P02(R.string.tts_set09_p02, "SET09_P02"),
    SET09_P03(R.string.tts_set09_p03, "SET09_P03"),
    SET09_P04(R.string.tts_set09_p04, "SET09_P04"),
    SET09_P05(R.string.tts_set09_p05, "SET09_P05"),
    SET09_P06(R.string.tts_set09_p06, "SET09_P06"),
    SET09_P07(R.string.tts_set09_p07, "SET09_P07"),
    SET09_P08(R.string.tts_set09_p08, "SET09_P08"),
    SET09_P09(R.string.tts_set09_p09, "SET09_P09"),
    SET11_R01(R.string.tts_set11_r01, "SET11_R01");
    
    private final String functionId;
    private final int resId;

    private TtsSettingTemplate(int i, String str) {
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
