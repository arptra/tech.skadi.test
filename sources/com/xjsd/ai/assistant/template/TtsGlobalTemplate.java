package com.xjsd.ai.assistant.template;

import com.xjsd.ai.assistant.phone.R;

public enum TtsGlobalTemplate implements TtsTemplate {
    GLOBAL01_P01(R.string.tts_global01_p01, "GLOBAL01_P01"),
    GLOBAL01_P02(R.string.tts_global01_p02, "GLOBAL01_P02"),
    GLOBAL01_P03(R.string.tts_global01_p03, "GLOBAL01_P03"),
    GLOBAL01_P04(R.string.tts_global01_p04, "GLOBAL01_P04"),
    GLOBAL01_P05(R.string.tts_global01_p05, "GLOBAL01_P05"),
    GLOBAL01_P06(R.string.tts_global01_p06, "GLOBAL01_P06"),
    GLOBAL01_P07(R.string.tts_global01_p07, "GLOBAL01_P07"),
    GLOBAL01_P09(R.string.tts_global01_p09, "GLOBAL01_P09"),
    GLOBAL01_P10(R.string.tts_global01_p10, "GLOBAL01_P10"),
    GLOBAL01_P12(R.string.tts_global01_p12, "GLOBAL01_P12"),
    GLOBAL01_P13(R.string.tts_global01_p13, "GLOBAL01_P13"),
    GLOBAL01_P19(R.string.tts_global01_p19, "GLOBAL01_P19"),
    GLOBAL01_P20(R.string.tts_global01_p20, "GLOBAL01_P20"),
    GLOBAL01_P21(R.string.tts_global01_p21, "GLOBAL01_P21"),
    GLOBAL01_P22(R.string.tts_global01_p22, "GLOBAL01_P22"),
    GLOBAL01_P23(R.string.tts_global01_p23, "GLOBAL01_P23"),
    GLOBAL01_P24(R.string.tts_global01_p24, "GLOBAL01_P24"),
    GLOBAL01_P25(R.string.tts_global01_p25, "GLOBAL01_P25"),
    GLOBAL01_P26(R.string.tts_global01_p26, "GLOBAL01_P26"),
    GLOBAL01_P27(R.string.tts_global01_p27, "GLOBAL01_P27"),
    GLOBAL01_P28(R.string.tts_global01_p28, "GLOBAL01_P28"),
    GLOBAL02_R01(R.string.tts_global02_r01, "GLOBAL02_R01"),
    GLOBAL02_R02(R.string.tts_global02_r02, "GLOBAL02_R02"),
    GLOBAL02_R03(R.string.tts_global02_r03, "GLOBAL02_R03"),
    GLOBAL02_R04(R.string.tts_global02_r03, "GLOBAL02_R03"),
    GLOBAL02_R05(R.string.tts_global02_r05, "GLOBAL02_R05"),
    GLOBAL02_R08(R.string.tts_global02_r08, "GLOBAL02_R08"),
    GLOBAL02_R09(R.string.tts_global02_r09, "GLOBAL02_R09"),
    GLOBAL02_R10(R.string.tts_global02_r10, "GLOBAL02_R10"),
    GLOBAL02_R11(R.string.tts_global02_r11, "GLOBAL02_R11"),
    GLOBAL03_P01(R.string.tts_global03_p01, "GLOBAL03_P01"),
    GLOBAL03_P02(R.string.tts_global03_p02, "GLOBAL03_P02"),
    GLOBAL03_P03(R.string.tts_global03_p03, "GLOBAL03_P03"),
    GLOBAL03_P04(R.string.tts_global03_p04, "GLOBAL03_P04"),
    GLOBAL03_P05(R.string.tts_global03_p05, "GLOBAL03_P05"),
    GLOBAL03_P06(R.string.tts_global03_p06, "GLOBAL03_P06"),
    GLOBAL04_R06(R.string.tts_global04_r06, "GLOBAL04_R06"),
    GLOBAL04_R07(R.string.tts_global04_r07, "GLOBAL04_R07"),
    GLOBAL05_P01(R.string.tts_global05_p01, "GLOBAL05_P01"),
    GLOBAL05_P02(R.string.tts_global05_p02, "GLOBAL05_P02"),
    GLOBAL05_P03(R.string.tts_global05_p03, "GLOBAL05_P03"),
    GLOBAL05_P04(R.string.tts_global05_p04, "GLOBAL05_P04"),
    GLOBAL06_P01(R.string.tts_global06_p01, "GLOBAL06_P01"),
    GLOBAL06_P02(R.string.tts_global06_p02, "GLOBAL06_P02"),
    GLOBAL06_P03(R.string.tts_global06_p03, "GLOBAL06_P03"),
    GLOBAL06_P04(R.string.tts_global06_p04, "GLOBAL06_P04"),
    GLOBAL06_P05(R.string.tts_global06_p05, "GLOBAL06_P05");
    
    private final String functionId;
    private final int resId;

    private TtsGlobalTemplate(int i, String str) {
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
