package com.xjsd.ai.assistant.chatgpt.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u0017\u0010\u0012\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u0004R\u0017\u0010\u0018\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/xjsd/ai/assistant/chatgpt/model/ResponseMessage;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "getRole", "role", "b", "getContent", "content", "", "c", "J", "getTimestamp", "()J", "timestamp", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ResponseMessage {

    /* renamed from: a  reason: collision with root package name */
    public final String f8398a;
    public final String b;
    public final long c;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResponseMessage)) {
            return false;
        }
        ResponseMessage responseMessage = (ResponseMessage) obj;
        return Intrinsics.areEqual((Object) this.f8398a, (Object) responseMessage.f8398a) && Intrinsics.areEqual((Object) this.b, (Object) responseMessage.b) && this.c == responseMessage.c;
    }

    public int hashCode() {
        return (((this.f8398a.hashCode() * 31) + this.b.hashCode()) * 31) + Long.hashCode(this.c);
    }

    public String toString() {
        String str = this.f8398a;
        String str2 = this.b;
        long j = this.c;
        return "ResponseMessage(role=" + str + ", content=" + str2 + ", timestamp=" + j + ")";
    }
}
