package com.xjsd.ai.assistant.phone.session.interceptor;

import com.xjsd.ai.assistant.phone.export.FeedAudioDataToCloudStrategy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/xjsd/ai/assistant/phone/export/FeedAudioDataToCloudStrategy;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class OverallInterceptor$feedAudioDataToCloudStrategy$2 extends Lambda implements Function0<FeedAudioDataToCloudStrategy> {
    final /* synthetic */ OverallInterceptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OverallInterceptor$feedAudioDataToCloudStrategy$2(OverallInterceptor overallInterceptor) {
        super(0);
        this.this$0 = overallInterceptor;
    }

    @NotNull
    public final FeedAudioDataToCloudStrategy invoke() {
        Object cache = this.this$0.h.getCache("FeedAudioDataToCloudStrategy");
        Intrinsics.checkNotNull(cache, "null cannot be cast to non-null type com.xjsd.ai.assistant.phone.export.FeedAudioDataToCloudStrategy");
        return (FeedAudioDataToCloudStrategy) cache;
    }
}
