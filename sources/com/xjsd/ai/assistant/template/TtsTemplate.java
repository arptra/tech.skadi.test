package com.xjsd.ai.assistant.template;

import com.xjsd.ai.assistant.core.ContextHelper;

public interface TtsTemplate {
    String getFunctionId();

    int getResId();

    String getTts(Object... objArr) {
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            Object obj = objArr[i];
            if (!(obj instanceof String)) {
                objArr[i] = String.valueOf(obj);
            }
        }
        return ContextHelper.b(getResId(), objArr);
    }
}
