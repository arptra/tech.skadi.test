package com.upuphone.ar.translation.eventtrack.event;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/upuphone/ar/translation/eventtrack/event/ClickEvent;", "", "", "status", "", "time", "<init>", "(IJ)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "I", "b", "J", "()J", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ClickEvent {

    /* renamed from: a  reason: collision with root package name */
    public final int f6204a;
    public final long b;

    public ClickEvent(int i, long j) {
        this.f6204a = i;
        this.b = j;
    }

    public final int a() {
        return this.f6204a;
    }

    public final long b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClickEvent)) {
            return false;
        }
        ClickEvent clickEvent = (ClickEvent) obj;
        return this.f6204a == clickEvent.f6204a && this.b == clickEvent.b;
    }

    public int hashCode() {
        return (Integer.hashCode(this.f6204a) * 31) + Long.hashCode(this.b);
    }

    public String toString() {
        int i = this.f6204a;
        long j = this.b;
        return "ClickEvent(status=" + i + ", time=" + j + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ClickEvent(int i, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? System.currentTimeMillis() : j);
    }
}
