package com.xjsd.ai.assistant.template;

import com.xjsd.ai.assistant.phone.R;

public enum TtsTodoTemplate implements TtsTemplate {
    TODO01_R01(R.string.tts_todo01_r01, "TODO01_R01"),
    TODO01_R02(R.string.tts_todo01_r02, "TODO01_R02"),
    TODO01_R03(R.string.tts_todo01_r03, "TODO01_R03"),
    TODO01_R04(R.string.tts_todo01_r04, "TODO01_R04"),
    TODO02_R01(R.string.tts_todo02_r01, "TODO02_R01"),
    TODO02_R02(R.string.tts_todo02_r02, "TODO02_R02"),
    TODO02_R03(R.string.tts_todo02_r03, "TODO02_R03"),
    TODO03_R01(R.string.tts_todo03_r01, "TODO03_R01"),
    TODO03_R02(R.string.tts_todo03_r02, "TODO03_R02"),
    TODO03_R05(R.string.tts_todo03_r05, "TODO03_R05"),
    TODO03_R06(R.string.tts_todo03_r06, "TODO03_R06"),
    TODO03_R07(R.string.tts_todo03_r07, "TODO03_R07"),
    TODO04_R01(R.string.tts_todo04_r01, "TODO04_R01"),
    TODO04_R02(R.string.tts_todo04_r02, "TODO04_R02"),
    TODO04_R07(R.string.tts_todo04_r07, "TODO04_R07");
    
    private final String functionId;
    private final int resId;

    private TtsTodoTemplate(int i, String str) {
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
