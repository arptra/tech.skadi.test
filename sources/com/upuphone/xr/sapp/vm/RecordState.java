package com.upuphone.xr.sapp.vm;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u0003\u0004\u0005\u0006\u0007\b\tB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0007\n\u000b\f\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/upuphone/xr/sapp/vm/RecordState;", "", "()V", "Failed", "Finished", "Recording", "Start", "Success", "Tts", "Warning", "Lcom/upuphone/xr/sapp/vm/RecordState$Failed;", "Lcom/upuphone/xr/sapp/vm/RecordState$Finished;", "Lcom/upuphone/xr/sapp/vm/RecordState$Recording;", "Lcom/upuphone/xr/sapp/vm/RecordState$Start;", "Lcom/upuphone/xr/sapp/vm/RecordState$Success;", "Lcom/upuphone/xr/sapp/vm/RecordState$Tts;", "Lcom/upuphone/xr/sapp/vm/RecordState$Warning;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class RecordState {

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/upuphone/xr/sapp/vm/RecordState$Failed;", "Lcom/upuphone/xr/sapp/vm/RecordState;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Failed extends RecordState {

        /* renamed from: a  reason: collision with root package name */
        public static final Failed f8000a = new Failed();

        public Failed() {
            super((DefaultConstructorMarker) null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Failed);
        }

        public int hashCode() {
            return 174671721;
        }

        public String toString() {
            return "Failed";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/upuphone/xr/sapp/vm/RecordState$Finished;", "Lcom/upuphone/xr/sapp/vm/RecordState;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Finished extends RecordState {

        /* renamed from: a  reason: collision with root package name */
        public static final Finished f8001a = new Finished();

        public Finished() {
            super((DefaultConstructorMarker) null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Finished);
        }

        public int hashCode() {
            return -993306466;
        }

        public String toString() {
            return "Finished";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/upuphone/xr/sapp/vm/RecordState$Recording;", "Lcom/upuphone/xr/sapp/vm/RecordState;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Recording extends RecordState {

        /* renamed from: a  reason: collision with root package name */
        public static final Recording f8002a = new Recording();

        public Recording() {
            super((DefaultConstructorMarker) null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Recording);
        }

        public int hashCode() {
            return -325522619;
        }

        public String toString() {
            return "Recording";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/upuphone/xr/sapp/vm/RecordState$Start;", "Lcom/upuphone/xr/sapp/vm/RecordState;", "", "count", "", "des", "<init>", "(ILjava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "I", "b", "Ljava/lang/String;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Start extends RecordState {

        /* renamed from: a  reason: collision with root package name */
        public final int f8003a;
        public final String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Start(int i, String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "des");
            this.f8003a = i;
            this.b = str;
        }

        public final int a() {
            return this.f8003a;
        }

        public final String b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Start)) {
                return false;
            }
            Start start = (Start) obj;
            return this.f8003a == start.f8003a && Intrinsics.areEqual((Object) this.b, (Object) start.b);
        }

        public int hashCode() {
            return (Integer.hashCode(this.f8003a) * 31) + this.b.hashCode();
        }

        public String toString() {
            int i = this.f8003a;
            String str = this.b;
            return "Start(count=" + i + ", des=" + str + ")";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/upuphone/xr/sapp/vm/RecordState$Success;", "Lcom/upuphone/xr/sapp/vm/RecordState;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Success extends RecordState {

        /* renamed from: a  reason: collision with root package name */
        public static final Success f8004a = new Success();

        public Success() {
            super((DefaultConstructorMarker) null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Success);
        }

        public int hashCode() {
            return 339276375;
        }

        public String toString() {
            return "Success";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/upuphone/xr/sapp/vm/RecordState$Tts;", "Lcom/upuphone/xr/sapp/vm/RecordState;", "", "status", "<init>", "(I)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "I", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Tts extends RecordState {

        /* renamed from: a  reason: collision with root package name */
        public final int f8005a;

        public Tts(int i) {
            super((DefaultConstructorMarker) null);
            this.f8005a = i;
        }

        public final int a() {
            return this.f8005a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Tts) && this.f8005a == ((Tts) obj).f8005a;
        }

        public int hashCode() {
            return Integer.hashCode(this.f8005a);
        }

        public String toString() {
            int i = this.f8005a;
            return "Tts(status=" + i + ")";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/upuphone/xr/sapp/vm/RecordState$Warning;", "Lcom/upuphone/xr/sapp/vm/RecordState;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Warning extends RecordState {

        /* renamed from: a  reason: collision with root package name */
        public static final Warning f8006a = new Warning();

        public Warning() {
            super((DefaultConstructorMarker) null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Warning);
        }

        public int hashCode() {
            return -964075024;
        }

        public String toString() {
            return "Warning";
        }
    }

    public /* synthetic */ RecordState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public RecordState() {
    }
}
