package com.upuphone.xr.sapp.monitor.notification.missedcall;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\rR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0015\u001a\u0004\b\u0018\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0019\u001a\u0004\b\u001a\u0010\u000fR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u001b\u001a\u0004\b\u0017\u0010\u001cR\"\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0019\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/missedcall/MissedCallInfo;", "", "", "name", "number", "", "slotIndex", "", "date", "count", "<init>", "(Ljava/lang/String;Ljava/lang/String;IJI)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "c", "b", "d", "I", "e", "J", "()J", "f", "(I)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
final class MissedCallInfo {

    /* renamed from: a  reason: collision with root package name */
    public final String f7772a;
    public final String b;
    public final int c;
    public final long d;
    public int e;

    public MissedCallInfo(String str, String str2, int i, long j, int i2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "number");
        this.f7772a = str;
        this.b = str2;
        this.c = i;
        this.d = j;
        this.e = i2;
    }

    public final int a() {
        return this.e;
    }

    public final long b() {
        return this.d;
    }

    public final String c() {
        return this.f7772a;
    }

    public final String d() {
        return this.b;
    }

    public final int e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MissedCallInfo)) {
            return false;
        }
        MissedCallInfo missedCallInfo = (MissedCallInfo) obj;
        return Intrinsics.areEqual((Object) this.f7772a, (Object) missedCallInfo.f7772a) && Intrinsics.areEqual((Object) this.b, (Object) missedCallInfo.b) && this.c == missedCallInfo.c && this.d == missedCallInfo.d && this.e == missedCallInfo.e;
    }

    public final void f(int i) {
        this.e = i;
    }

    public int hashCode() {
        return (((((((this.f7772a.hashCode() * 31) + this.b.hashCode()) * 31) + Integer.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31) + Integer.hashCode(this.e);
    }

    public String toString() {
        String str = this.f7772a;
        String str2 = this.b;
        int i = this.c;
        long j = this.d;
        int i2 = this.e;
        return "MissedCallInfo(name=" + str + ", number=" + str2 + ", slotIndex=" + i + ", date=" + j + ", count=" + i2 + ")";
    }
}
