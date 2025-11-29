package com.upuphone.ar.transcribe.eventtrack.event;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0017\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/upuphone/ar/transcribe/eventtrack/event/ClickEvent;", "", "", "status", "", "time", "transType", "<init>", "(IJI)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "I", "b", "J", "()J", "c", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ClickEvent {

    /* renamed from: a  reason: collision with root package name */
    public final int f6062a;
    public final long b;
    public final int c;

    public ClickEvent(int i, long j, int i2) {
        this.f6062a = i;
        this.b = j;
        this.c = i2;
    }

    public final int a() {
        return this.f6062a;
    }

    public final long b() {
        return this.b;
    }

    public final int c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClickEvent)) {
            return false;
        }
        ClickEvent clickEvent = (ClickEvent) obj;
        return this.f6062a == clickEvent.f6062a && this.b == clickEvent.b && this.c == clickEvent.c;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.f6062a) * 31) + Long.hashCode(this.b)) * 31) + Integer.hashCode(this.c);
    }

    public String toString() {
        int i = this.f6062a;
        long j = this.b;
        int i2 = this.c;
        return "ClickEvent(status=" + i + ", time=" + j + ", transType=" + i2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ClickEvent(int i, long j, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i3 & 2) != 0 ? System.currentTimeMillis() / ((long) 1000) : j, i2);
    }
}
