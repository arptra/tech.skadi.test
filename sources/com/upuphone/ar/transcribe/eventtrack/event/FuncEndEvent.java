package com.upuphone.ar.transcribe.eventtrack.event;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018R\u001a\u0010\u0006\u001a\u00020\u00048\u0006X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0017\u001a\u0004\b\u0013\u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0019\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/upuphone/ar/transcribe/eventtrack/event/FuncEndEvent;", "", "", "status", "", "startTime", "endTime", "transType", "<init>", "(IJJI)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "I", "c", "b", "J", "()J", "d", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class FuncEndEvent {

    /* renamed from: a  reason: collision with root package name */
    public final int f6063a;
    public final long b;
    public final long c;
    public final int d;

    public FuncEndEvent(int i, long j, long j2, int i2) {
        this.f6063a = i;
        this.b = j;
        this.c = j2;
        this.d = i2;
    }

    public final long a() {
        return this.c;
    }

    public final long b() {
        return this.b;
    }

    public final int c() {
        return this.f6063a;
    }

    public final int d() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FuncEndEvent)) {
            return false;
        }
        FuncEndEvent funcEndEvent = (FuncEndEvent) obj;
        return this.f6063a == funcEndEvent.f6063a && this.b == funcEndEvent.b && this.c == funcEndEvent.c && this.d == funcEndEvent.d;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.f6063a) * 31) + Long.hashCode(this.b)) * 31) + Long.hashCode(this.c)) * 31) + Integer.hashCode(this.d);
    }

    public String toString() {
        int i = this.f6063a;
        long j = this.b;
        long j2 = this.c;
        int i2 = this.d;
        return "FuncEndEvent(status=" + i + ", startTime=" + j + ", endTime=" + j2 + ", transType=" + i2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FuncEndEvent(int i, long j, long j2, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i3 & 2) != 0 ? System.currentTimeMillis() / ((long) 1000) : j, (i3 & 4) != 0 ? System.currentTimeMillis() / ((long) 1000) : j2, i2);
    }
}
