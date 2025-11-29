package com.xjsd.ai.assistant.template;

import com.xjsd.ai.assistant.phone.R;

public enum TtsNaviTemplate implements TtsTemplate {
    NAVI01_P08(R.string.tts_navi01_p08, "NAVI01_P08"),
    NAVI01_P09(R.string.tts_navi01_p09, "NAVI01_P09"),
    NAVI01_P10(R.string.tts_navi01_p10, "NAVI01_P10"),
    NAVI02_P01(R.string.tts_navi02_p01, "NAVI02_P01"),
    NAVI02_P02(R.string.tts_navi02_p02, "NAVI02_P02"),
    NAVI02_P03(R.string.tts_navi02_p03, "NAVI02_P03"),
    NAVI02_P05(R.string.tts_navi02_p05, "NAVI02_P05"),
    NAVI02_P06(R.string.tts_navi02_p06, "NAVI02_P06"),
    NAVI02_P07(R.string.tts_navi02_p07, "NAVI02_P07"),
    NAVI03_P01(R.string.tts_navi03_p01, "NAVI03_P01"),
    NAVI04_P01(R.string.tts_navi04_p01, "NAVI04_P01"),
    NAVI04_P02(R.string.tts_navi04_p02, "NAVI04_P02"),
    NAVI04_P03(R.string.tts_navi04_p03, "NAVI04_P03"),
    NAVI05_P01(R.string.tts_navi05_p01, "NAVI05_P01"),
    NAVI05_P02(R.string.tts_navi05_p02, "NAVI05_P02"),
    NAVI05_P03(R.string.tts_navi05_p03, "NAVI05_P03"),
    NAVI06_P01(R.string.tts_navi06_p01, "NAVI06_P01"),
    NAVI07_P01(R.string.tts_navi07_p01, "NAVI07_P01"),
    NAVI08_P01(R.string.tts_navi08_p01, "NAVI08_P01"),
    NAVI08_P02(R.string.tts_navi08_p02, "NAVI08_P02"),
    NAVI08_P04(R.string.tts_navi08_p04, "NAVI08_P04"),
    NAVI09_P01(R.string.tts_navi09_p01, "NAVI09_P01"),
    NAVI09_P02(R.string.tts_navi09_p02, "NAVI09_P02"),
    NAVI10_P01(R.string.tts_navi10_p01, "NAVI10_P01"),
    NAVI10_P02(R.string.tts_navi10_p02, "NAVI10_P02"),
    NAVI10_P03(R.string.tts_navi10_p03, "NAVI10_P03"),
    NAVI10_P04(R.string.tts_navi10_p04, "NAVI10_P04"),
    NAVI11_P01(R.string.tts_navi11_p01, "NAVI11_P01"),
    NAVI11_P02(R.string.tts_navi11_p02, "NAVI11_P02"),
    NAVI11_P03(R.string.tts_navi11_p03, "NAVI11_P03"),
    NAVI11_P04(R.string.tts_navi11_p04, "NAVI11_P04"),
    NAVI14_P01(R.string.tts_navi14_p01, "NAVI14_P01"),
    NAVI15_P01(R.string.tts_navi15_p01, "NAVI15_P01"),
    NAVI15_P02(R.string.tts_navi15_p02, "NAVI15_P02"),
    NAVI16_P01(R.string.tts_navi16_p01, "NAVI16_P01"),
    NAVI17_P01(R.string.tts_navi17_p01, "NAVI17_P01"),
    NAVI17_P02(R.string.tts_navi17_p02, "NAVI17_P02"),
    NAVI17_P03(R.string.tts_navi17_p03, "NAVI17_P03"),
    NAVI19_P03(R.string.tts_navi19_p03, "NAVI19_P03"),
    NAVI21_P01(R.string.tts_navi21_p01, "NAVI21_P01"),
    NAVI21_P02(R.string.tts_navi21_p02, "NAVI21_P02"),
    NAVI21_P03(R.string.tts_navi21_p03, "NAVI21_P03"),
    NAVI21_P04(R.string.tts_navi21_p04, "NAVI21_P04"),
    NAVI21_P05(R.string.tts_navi21_p05, "NAVI21_P05"),
    NAVI22_P01(R.string.tts_navi22_p01, "NAVI22_P01");
    
    private final String functionId;
    private final int resId;

    private TtsNaviTemplate(int i, String str) {
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
