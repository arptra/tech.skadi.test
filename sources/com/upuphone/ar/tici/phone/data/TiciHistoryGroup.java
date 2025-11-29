package com.upuphone.ar.tici.phone.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/upuphone/ar/tici/phone/data/TiciHistoryGroup;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "getDate", "date", "", "Lcom/upuphone/ar/tici/phone/data/TiciHistory;", "b", "Ljava/util/List;", "getList", "()Ljava/util/List;", "list", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
public final class TiciHistoryGroup {

    /* renamed from: a  reason: collision with root package name */
    public final String f5920a;
    public final List b;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TiciHistoryGroup)) {
            return false;
        }
        TiciHistoryGroup ticiHistoryGroup = (TiciHistoryGroup) obj;
        return Intrinsics.areEqual((Object) this.f5920a, (Object) ticiHistoryGroup.f5920a) && Intrinsics.areEqual((Object) this.b, (Object) ticiHistoryGroup.b);
    }

    public int hashCode() {
        return (this.f5920a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        String str = this.f5920a;
        List list = this.b;
        return "TiciHistoryGroup(date=" + str + ", list=" + list + ")";
    }
}
