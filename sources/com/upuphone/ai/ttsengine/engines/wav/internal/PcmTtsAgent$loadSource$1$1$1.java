package com.upuphone.ai.ttsengine.engines.wav.internal;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "line", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class PcmTtsAgent$loadSource$1$1$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ PcmTtsAgent $this_runCatching;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PcmTtsAgent$loadSource$1$1$1(PcmTtsAgent pcmTtsAgent) {
        super(1);
        this.$this_runCatching = pcmTtsAgent;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "line");
        List split$default = StringsKt.split$default((CharSequence) str, new String[]{"&"}, false, 0, 6, (Object) null);
        if (split$default.size() == 2) {
            String str2 = (String) split$default.get(0);
            String str3 = (String) split$default.get(1);
            if (str2.length() > 0 && str3.length() > 0) {
                Map access$getSupportWords$p = this.$this_runCatching.supportWords;
                access$getSupportWords$p.put(str2, "pcm/" + str3);
            }
        }
    }
}
