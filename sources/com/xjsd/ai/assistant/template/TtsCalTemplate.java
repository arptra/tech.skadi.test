package com.xjsd.ai.assistant.template;

import com.xjsd.ai.assistant.phone.R;

public enum TtsCalTemplate implements TtsTemplate {
    CAL01_R01(R.string.tts_cal01_r01, "CAL01_R01"),
    CAL01_R02(R.string.tts_cal01_r02, "CAL01_R02"),
    CAL01_R03(R.string.tts_cal01_r03, "CAL01_R03"),
    CAL01_R04(R.string.tts_cal01_r04, "CAL01_R04"),
    CAL01_R05(R.string.tts_cal01_r05, "CAL01_R05"),
    CAL01_R06(R.string.tts_cal01_r06, "CAL01_R06"),
    CAL02_R01(R.string.tts_cal02_r01, "CAL02_R01"),
    CAL02_R02(R.string.tts_cal02_r02, "CAL02_R02"),
    CAL02_R03(R.string.tts_cal02_r03, "CAL02_R03"),
    CAL02_R04(R.string.tts_cal02_r04, "CAL02_R04"),
    CAL02_R05(R.string.tts_cal02_r05, "CAL02_R05"),
    CAL02_R06(R.string.tts_cal02_r06, "CAL02_R06"),
    CAL04_R01(R.string.tts_cal04_r01, "CAL04_R01"),
    CAL04_R02(R.string.tts_cal04_r02, "CAL04_R02"),
    CAL04_R03(R.string.tts_cal04_r03, "CAL04_R03"),
    CAL04_R04(R.string.tts_cal04_r04, "CAL04_R04"),
    CAL05_R01(R.string.tts_cal05_r01, "CAL05_R01"),
    CAL05_R02(R.string.tts_cal05_r02, "CAL05_R02"),
    CAL05_R03(R.string.tts_cal05_r03, "CAL05_R03"),
    CAL05_R04(R.string.tts_cal05_r04, "CAL05_R04"),
    CAL05_R05(R.string.tts_cal05_r05, "CAL05_R05"),
    CAL05_R06(R.string.tts_cal05_r06, "CAL05_R06");
    
    private final String functionId;
    private final int resId;

    private TtsCalTemplate(int i, String str) {
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
