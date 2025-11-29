package com.upuphone.xr.sapp.contract;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/upuphone/xr/sapp/contract/UserGuideAuthResult;", "", "", "action", "", "submitResult", "<init>", "(IZ)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "a", "I", "b", "Z", "()Z", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class UserGuideAuthResult {

    /* renamed from: a  reason: collision with root package name */
    public final int f6707a;
    public final boolean b;

    public UserGuideAuthResult(int i, boolean z) {
        this.f6707a = i;
        this.b = z;
    }

    public final int a() {
        return this.f6707a;
    }

    public final boolean b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserGuideAuthResult)) {
            return false;
        }
        UserGuideAuthResult userGuideAuthResult = (UserGuideAuthResult) obj;
        return this.f6707a == userGuideAuthResult.f6707a && this.b == userGuideAuthResult.b;
    }

    public int hashCode() {
        return (Integer.hashCode(this.f6707a) * 31) + Boolean.hashCode(this.b);
    }

    public String toString() {
        int i = this.f6707a;
        boolean z = this.b;
        return "UserGuideAuthResult(action=" + i + ", submitResult=" + z + ")";
    }
}
