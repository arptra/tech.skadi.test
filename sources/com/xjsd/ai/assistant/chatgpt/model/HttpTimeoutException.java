package com.xjsd.ai.assistant.chatgpt.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/xjsd/ai/assistant/chatgpt/model/HttpTimeoutException;", "Lcom/xjsd/ai/assistant/chatgpt/model/GptException;", "message", "", "throwable", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class HttpTimeoutException extends GptException {
    public HttpTimeoutException() {
        this((String) null, (Throwable) null, 3, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HttpTimeoutException(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : th);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HttpTimeoutException(@org.jetbrains.annotations.Nullable java.lang.String r2, @org.jetbrains.annotations.Nullable java.lang.Throwable r3) {
        /*
            r1 = this;
            if (r3 == 0) goto L_0x000a
            java.lang.String r0 = r3.getMessage()
            if (r0 != 0) goto L_0x0009
            goto L_0x000a
        L_0x0009:
            r2 = r0
        L_0x000a:
            r1.<init>(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.chatgpt.model.HttpTimeoutException.<init>(java.lang.String, java.lang.Throwable):void");
    }
}
