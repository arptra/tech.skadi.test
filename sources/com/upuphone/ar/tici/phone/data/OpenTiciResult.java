package com.upuphone.ar.tici.phone.data;

import com.upuphone.ar.tici.phone.starrynet.msg.OpenTiciMsg;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0015\u0010\u0010R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u0019\u0010!¨\u0006\""}, d2 = {"Lcom/upuphone/ar/tici/phone/data/OpenTiciResult;", "", "Lcom/upuphone/ar/tici/phone/starrynet/msg/OpenTiciMsg;", "ticiMsg", "", "code", "", "id", "Lcom/upuphone/ar/tici/phone/data/OpenTiciFrom;", "from", "<init>", "(Lcom/upuphone/ar/tici/phone/starrynet/msg/OpenTiciMsg;IJLcom/upuphone/ar/tici/phone/data/OpenTiciFrom;)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Lcom/upuphone/ar/tici/phone/starrynet/msg/OpenTiciMsg;", "getTiciMsg", "()Lcom/upuphone/ar/tici/phone/starrynet/msg/OpenTiciMsg;", "b", "I", "c", "J", "getId", "()J", "d", "Lcom/upuphone/ar/tici/phone/data/OpenTiciFrom;", "()Lcom/upuphone/ar/tici/phone/data/OpenTiciFrom;", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
public final class OpenTiciResult {

    /* renamed from: a  reason: collision with root package name */
    public final OpenTiciMsg f5914a;
    public final int b;
    public final long c;
    public final OpenTiciFrom d;

    public OpenTiciResult(OpenTiciMsg openTiciMsg, int i, long j, OpenTiciFrom openTiciFrom) {
        Intrinsics.checkNotNullParameter(openTiciMsg, "ticiMsg");
        Intrinsics.checkNotNullParameter(openTiciFrom, "from");
        this.f5914a = openTiciMsg;
        this.b = i;
        this.c = j;
        this.d = openTiciFrom;
    }

    public final int a() {
        return this.b;
    }

    public final OpenTiciFrom b() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OpenTiciResult)) {
            return false;
        }
        OpenTiciResult openTiciResult = (OpenTiciResult) obj;
        return Intrinsics.areEqual((Object) this.f5914a, (Object) openTiciResult.f5914a) && this.b == openTiciResult.b && this.c == openTiciResult.c && this.d == openTiciResult.d;
    }

    public int hashCode() {
        return (((((this.f5914a.hashCode() * 31) + Integer.hashCode(this.b)) * 31) + Long.hashCode(this.c)) * 31) + this.d.hashCode();
    }

    public String toString() {
        OpenTiciMsg openTiciMsg = this.f5914a;
        int i = this.b;
        long j = this.c;
        OpenTiciFrom openTiciFrom = this.d;
        return "OpenTiciResult(ticiMsg=" + openTiciMsg + ", code=" + i + ", id=" + j + ", from=" + openTiciFrom + ")";
    }
}
