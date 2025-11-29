package com.upuphone.ar.tici.phone.data;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/upuphone/ar/tici/phone/data/ScanFileState;", "", "()V", "Loading", "Success", "Lcom/upuphone/ar/tici/phone/data/ScanFileState$Loading;", "Lcom/upuphone/ar/tici/phone/data/ScanFileState$Success;", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class ScanFileState {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/upuphone/ar/tici/phone/data/ScanFileState$Loading;", "Lcom/upuphone/ar/tici/phone/data/ScanFileState;", "()V", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Loading extends ScanFileState {

        /* renamed from: a  reason: collision with root package name */
        public static final Loading f5915a = new Loading();

        public Loading() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002¢\u0006\u0004\b\u0007\u0010\bR)\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/upuphone/ar/tici/phone/data/ScanFileState$Success;", "Lcom/upuphone/ar/tici/phone/data/ScanFileState;", "", "", "", "Lcom/upuphone/ar/tici/phone/data/SystemFileInfo;", "result", "<init>", "(Ljava/util/Map;)V", "a", "Ljava/util/Map;", "()Ljava/util/Map;", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
    public static final class Success extends ScanFileState {

        /* renamed from: a  reason: collision with root package name */
        public final Map f5916a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Success(Map map) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(map, "result");
            this.f5916a = map;
        }

        public final Map a() {
            return this.f5916a;
        }
    }

    public /* synthetic */ ScanFileState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public ScanFileState() {
    }
}
