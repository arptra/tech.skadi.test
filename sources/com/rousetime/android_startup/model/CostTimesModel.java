package com.rousetime.android_startup.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0012\b\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0014\u0010\u0019R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0018\u001a\u0004\b\u001a\u0010\u0019R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001b\u0010\u001dR\"\u0010\t\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001c\u001a\u0004\b\u0017\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/rousetime/android_startup/model/CostTimesModel;", "", "", "name", "", "callOnMainThread", "waitOnMainThread", "", "startTime", "endTime", "<init>", "(Ljava/lang/String;ZZJJ)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "c", "b", "Z", "()Z", "e", "d", "J", "()J", "f", "(J)V", "android-startup_release"}, k = 1, mv = {1, 4, 0})
public final class CostTimesModel {

    /* renamed from: a  reason: collision with root package name */
    public final String f9827a;
    public final boolean b;
    public final boolean c;
    public final long d;
    public long e;

    public CostTimesModel(String str, boolean z, boolean z2, long j, long j2) {
        this.f9827a = str;
        this.b = z;
        this.c = z2;
        this.d = j;
        this.e = j2;
    }

    public final boolean a() {
        return this.b;
    }

    public final long b() {
        return this.e;
    }

    public final String c() {
        return this.f9827a;
    }

    public final long d() {
        return this.d;
    }

    public final boolean e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CostTimesModel)) {
            return false;
        }
        CostTimesModel costTimesModel = (CostTimesModel) obj;
        return Intrinsics.areEqual((Object) this.f9827a, (Object) costTimesModel.f9827a) && this.b == costTimesModel.b && this.c == costTimesModel.c && this.d == costTimesModel.d && this.e == costTimesModel.e;
    }

    public final void f(long j) {
        this.e = j;
    }

    public int hashCode() {
        String str = this.f9827a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z = this.b;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (hashCode + (z ? 1 : 0)) * 31;
        boolean z3 = this.c;
        if (!z3) {
            z2 = z3;
        }
        long j = this.d;
        long j2 = this.e;
        return ((((i + (z2 ? 1 : 0)) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        return "CostTimesModel(name=" + this.f9827a + ", callOnMainThread=" + this.b + ", waitOnMainThread=" + this.c + ", startTime=" + this.d + ", endTime=" + this.e + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CostTimesModel(String str, boolean z, boolean z2, long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, z2, j, (i & 16) != 0 ? 0 : j2);
    }
}
