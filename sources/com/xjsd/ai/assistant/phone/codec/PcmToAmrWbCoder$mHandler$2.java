package com.xjsd.ai.assistant.phone.codec;

import android.os.Handler;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/os/Handler;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class PcmToAmrWbCoder$mHandler$2 extends Lambda implements Function0<Handler> {
    final /* synthetic */ PcmToAmrWbCoder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PcmToAmrWbCoder$mHandler$2(PcmToAmrWbCoder pcmToAmrWbCoder) {
        super(0);
        this.this$0 = pcmToAmrWbCoder;
    }

    @NotNull
    public final Handler invoke() {
        this.this$0.f8553a.start();
        return new Handler(this.this$0.f8553a.getLooper());
    }
}
