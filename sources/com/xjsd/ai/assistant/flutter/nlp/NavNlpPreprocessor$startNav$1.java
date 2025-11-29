package com.xjsd.ai.assistant.flutter.nlp;

import com.upuphone.xr.interconnect.listener.NaviActionResult;
import com.xjsd.ai.assistant.log.ILog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/xjsd/ai/assistant/flutter/nlp/NavNlpPreprocessor$startNav$1", "Lcom/upuphone/xr/interconnect/listener/NaviActionResult;", "actionFailure", "", "p0", "", "p1", "", "actionSuceess", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class NavNlpPreprocessor$startNav$1 extends NaviActionResult {
    public void actionFailure(@Nullable String str, int i) {
        ILog.a("NavNlpPreprocessor", "发起导航失败: " + str + "/" + i);
    }

    public void actionSuceess(@Nullable String str, int i) {
        ILog.a("NavNlpPreprocessor", "发起导航成功: " + str + "/" + i);
    }
}
