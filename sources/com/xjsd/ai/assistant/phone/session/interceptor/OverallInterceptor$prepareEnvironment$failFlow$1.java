package com.xjsd.ai.assistant.phone.session.interceptor;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class OverallInterceptor$prepareEnvironment$failFlow$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ OverallInterceptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OverallInterceptor$prepareEnvironment$failFlow$1(OverallInterceptor overallInterceptor) {
        super(0);
        this.this$0 = overallInterceptor;
    }

    public final void invoke() {
        OverallInterceptor overallInterceptor = this.this$0;
        overallInterceptor.Z(false, String.valueOf(overallInterceptor.g.getErrorCode()));
    }
}
