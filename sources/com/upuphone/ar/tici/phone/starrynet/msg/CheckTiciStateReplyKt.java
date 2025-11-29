package com.upuphone.ar.tici.phone.starrynet.msg;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\r\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\"\u0017\u0010\u0007\u001a\u00020\u0004*\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/upuphone/ar/tici/phone/starrynet/msg/CheckTiciStateReply;", "a", "()Lcom/upuphone/ar/tici/phone/starrynet/msg/CheckTiciStateReply;", "", "", "b", "(Ljava/lang/Integer;)Z", "supportLargeFile", "ar-tici_release"}, k = 2, mv = {1, 9, 0})
public final class CheckTiciStateReplyKt {
    public static final CheckTiciStateReply a() {
        return new CheckTiciStateReply(false, (String) null, 0, false, 0.0f, 1, 0);
    }

    public static final boolean b(Integer num) {
        return (num != null ? num.intValue() : 0) >= 3;
    }
}
