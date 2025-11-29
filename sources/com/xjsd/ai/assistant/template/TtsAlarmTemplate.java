package com.xjsd.ai.assistant.template;

import com.xjsd.ai.assistant.phone.R;

public enum TtsAlarmTemplate implements TtsTemplate {
    ALARM01_R01(R.string.tts_alarm01_r01, "ALARM01_R01"),
    ALARM01_R02(R.string.tts_alarm01_r02, "ALARM01_R02"),
    ALARM01_R03(R.string.tts_alarm01_r03, "ALARM01_R03"),
    ALARM01_R04(R.string.tts_alarm01_r04, "ALARM01_R04"),
    ALARM02_R01(R.string.tts_alarm02_r01, "ALARM02_R01"),
    ALARM02_R02(R.string.tts_alarm02_r02, "ALARM02_R02"),
    ALARM02_R03(R.string.tts_alarm02_r03, "ALARM02_R03"),
    ALARM02_R04(R.string.tts_alarm02_r04, "ALARM02_R04"),
    ALARM02_R05(R.string.tts_alarm02_r05, "ALARM02_R05"),
    ALARM02_R06(R.string.tts_alarm02_r06, "ALARM02_R06"),
    ALARM02_R07(R.string.tts_alarm02_r07, "ALARM02_R07"),
    ALARM02_R08(R.string.tts_alarm02_r08, "ALARM02_R08"),
    ALARM03_R01(R.string.tts_alarm03_r01, "ALARM03_R01"),
    ALARM03_R02(R.string.tts_alarm03_r02, "ALARM03_R02"),
    ALARM03_R03(R.string.tts_alarm03_r03, "ALARM03_R03"),
    ALARM04_R01(R.string.tts_alarm04_r01, "ALARM04_R01"),
    ALARM04_R02(R.string.tts_alarm04_r02, "ALARM04_R02"),
    ALARM04_R03(R.string.tts_alarm04_r03, "ALARM04_R03"),
    ALARM04_R04(R.string.tts_alarm04_r04, "ALARM04_R04");
    
    private final String functionId;
    private final int resId;

    private TtsAlarmTemplate(int i, String str) {
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
