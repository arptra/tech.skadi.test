package com.upuphone.ar.tici.phone.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/upuphone/ar/tici/phone/data/TiciHistoryWrapper;", "", "Date", "Item", "Lcom/upuphone/ar/tici/phone/data/TiciHistoryWrapper$Date;", "Lcom/upuphone/ar/tici/phone/data/TiciHistoryWrapper$Item;", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
public abstract class TiciHistoryWrapper {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/upuphone/ar/tici/phone/data/TiciHistoryWrapper$Date;", "Lcom/upuphone/ar/tici/phone/data/TiciHistoryWrapper;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "getTime", "time", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
    public static final class Date extends TiciHistoryWrapper {

        /* renamed from: a  reason: collision with root package name */
        public final String f5921a;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Date) && Intrinsics.areEqual((Object) this.f5921a, (Object) ((Date) obj).f5921a);
        }

        public int hashCode() {
            return this.f5921a.hashCode();
        }

        public String toString() {
            String str = this.f5921a;
            return "Date(time=" + str + ")";
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/upuphone/ar/tici/phone/data/TiciHistoryWrapper$Item;", "Lcom/upuphone/ar/tici/phone/data/TiciHistoryWrapper;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/upuphone/ar/tici/phone/data/TiciHistory;", "a", "Lcom/upuphone/ar/tici/phone/data/TiciHistory;", "getTiciHistory", "()Lcom/upuphone/ar/tici/phone/data/TiciHistory;", "ticiHistory", "b", "Ljava/lang/String;", "getDateStr", "dateStr", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
    public static final class Item extends TiciHistoryWrapper {

        /* renamed from: a  reason: collision with root package name */
        public final TiciHistory f5922a;
        public final String b;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Item)) {
                return false;
            }
            Item item = (Item) obj;
            return Intrinsics.areEqual((Object) this.f5922a, (Object) item.f5922a) && Intrinsics.areEqual((Object) this.b, (Object) item.b);
        }

        public int hashCode() {
            return (this.f5922a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            TiciHistory ticiHistory = this.f5922a;
            String str = this.b;
            return "Item(ticiHistory=" + ticiHistory + ", dateStr=" + str + ")";
        }
    }
}
