package com.xjsd.ai.assistant.flutter.nlp;

import com.upuphone.xr.interconnect.listener.NaviActionResult;
import com.xjsd.ai.assistant.log.ILog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/xjsd/ai/assistant/flutter/nlp/NavNlpPreprocessor$navigateCallback$2$1", "invoke", "()Lcom/xjsd/ai/assistant/flutter/nlp/NavNlpPreprocessor$navigateCallback$2$1;"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class NavNlpPreprocessor$navigateCallback$2 extends Lambda implements Function0<AnonymousClass1> {
    public static final NavNlpPreprocessor$navigateCallback$2 INSTANCE = new NavNlpPreprocessor$navigateCallback$2();

    public NavNlpPreprocessor$navigateCallback$2() {
        super(0);
    }

    @NotNull
    public final AnonymousClass1 invoke() {
        return new NaviActionResult() {
            public void actionFailure(@Nullable String str, int i) {
                ILog.a("NavNlpPreprocessor", "actionFailure: " + str + "----" + i);
            }

            public void actionSuceess(@Nullable String str, int i) {
                ILog.a("NavNlpPreprocessor", "actionSuccess: " + str + "----" + i);
            }
        };
    }
}
