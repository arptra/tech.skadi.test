package com.upuphone.ar.tici.phone.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/upuphone/ar/tici/phone/data/TiciInfoState;", "", "()V", "Loading", "Success", "Lcom/upuphone/ar/tici/phone/data/TiciInfoState$Loading;", "Lcom/upuphone/ar/tici/phone/data/TiciInfoState$Success;", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class TiciInfoState {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/upuphone/ar/tici/phone/data/TiciInfoState$Loading;", "Lcom/upuphone/ar/tici/phone/data/TiciInfoState;", "()V", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Loading extends TiciInfoState {

        /* renamed from: a  reason: collision with root package name */
        public static final Loading f5923a = new Loading();

        public Loading() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/upuphone/ar/tici/phone/data/TiciInfoState$Success;", "Lcom/upuphone/ar/tici/phone/data/TiciInfoState;", "Lcom/upuphone/ar/tici/phone/data/TiciInfo;", "txtInfo", "<init>", "(Lcom/upuphone/ar/tici/phone/data/TiciInfo;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Lcom/upuphone/ar/tici/phone/data/TiciInfo;", "()Lcom/upuphone/ar/tici/phone/data/TiciInfo;", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
    public static final class Success extends TiciInfoState {

        /* renamed from: a  reason: collision with root package name */
        public final TiciInfo f5924a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Success(TiciInfo ticiInfo) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(ticiInfo, "txtInfo");
            this.f5924a = ticiInfo;
        }

        public final TiciInfo a() {
            return this.f5924a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Success) && Intrinsics.areEqual((Object) this.f5924a, (Object) ((Success) obj).f5924a);
        }

        public int hashCode() {
            return this.f5924a.hashCode();
        }

        public String toString() {
            TiciInfo ticiInfo = this.f5924a;
            return "Success(txtInfo=" + ticiInfo + ")";
        }
    }

    public /* synthetic */ TiciInfoState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public TiciInfoState() {
    }
}
