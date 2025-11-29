package com.upuphone.ar.translation.eventtrack.event;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\rR\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017R\u001a\u0010\u0006\u001a\u00020\u00048\u0006X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0016\u001a\u0004\b\u0012\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/upuphone/ar/translation/eventtrack/event/FuncEndEvent;", "", "", "status", "", "startTime", "endTime", "<init>", "(IJJ)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "I", "c", "b", "J", "()J", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class FuncEndEvent {

    /* renamed from: a  reason: collision with root package name */
    public final int f6205a;
    public final long b;
    public final long c;

    public FuncEndEvent(int i, long j, long j2) {
        this.f6205a = i;
        this.b = j;
        this.c = j2;
    }

    public final long a() {
        return this.c;
    }

    public final long b() {
        return this.b;
    }

    public final int c() {
        return this.f6205a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FuncEndEvent)) {
            return false;
        }
        FuncEndEvent funcEndEvent = (FuncEndEvent) obj;
        return this.f6205a == funcEndEvent.f6205a && this.b == funcEndEvent.b && this.c == funcEndEvent.c;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.f6205a) * 31) + Long.hashCode(this.b)) * 31) + Long.hashCode(this.c);
    }

    public String toString() {
        int i = this.f6205a;
        long j = this.b;
        long j2 = this.c;
        return "FuncEndEvent(status=" + i + ", startTime=" + j + ", endTime=" + j2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FuncEndEvent(int i, long j, long j2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? System.currentTimeMillis() : j, (i2 & 4) != 0 ? System.currentTimeMillis() : j2);
    }
}
