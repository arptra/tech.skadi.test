package com.upuphone.ar.transcribe.phone.vm;

import com.upuphone.ar.transcribe.phone.repo.AiResponseSensitive;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\b\u0003\u0004\u0005\u0006\u0007\b\t\nB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\b\u000b\f\r\u000e\u000f\u0010\u0011\u0012¨\u0006\u0013"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/vm/TodoData;", "", "()V", "CalenderAdded", "CloudData", "DbData", "Empty", "Fail", "Loading", "ReportStatus", "Sensitive", "Lcom/upuphone/ar/transcribe/phone/vm/TodoData$CalenderAdded;", "Lcom/upuphone/ar/transcribe/phone/vm/TodoData$CloudData;", "Lcom/upuphone/ar/transcribe/phone/vm/TodoData$DbData;", "Lcom/upuphone/ar/transcribe/phone/vm/TodoData$Empty;", "Lcom/upuphone/ar/transcribe/phone/vm/TodoData$Fail;", "Lcom/upuphone/ar/transcribe/phone/vm/TodoData$Loading;", "Lcom/upuphone/ar/transcribe/phone/vm/TodoData$ReportStatus;", "Lcom/upuphone/ar/transcribe/phone/vm/TodoData$Sensitive;", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class TodoData {

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/vm/TodoData$CalenderAdded;", "Lcom/upuphone/ar/transcribe/phone/vm/TodoData;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class CalenderAdded extends TodoData {

        /* renamed from: a  reason: collision with root package name */
        public static final CalenderAdded f6147a = new CalenderAdded();

        public CalenderAdded() {
            super((DefaultConstructorMarker) null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof CalenderAdded);
        }

        public int hashCode() {
            return -740609386;
        }

        public String toString() {
            return "CalenderAdded";
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/vm/TodoData$CloudData;", "Lcom/upuphone/ar/transcribe/phone/vm/TodoData;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "Lcom/upuphone/ar/transcribe/phone/db/entity/AiTodoEntity;", "a", "Ljava/util/List;", "()Ljava/util/List;", "data", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class CloudData extends TodoData {

        /* renamed from: a  reason: collision with root package name */
        public final List f6148a;

        public final List a() {
            return this.f6148a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CloudData) && Intrinsics.areEqual((Object) this.f6148a, (Object) ((CloudData) obj).f6148a);
        }

        public int hashCode() {
            return this.f6148a.hashCode();
        }

        public String toString() {
            List list = this.f6148a;
            return "CloudData(data=" + list + ")";
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/vm/TodoData$DbData;", "Lcom/upuphone/ar/transcribe/phone/vm/TodoData;", "", "Lcom/upuphone/ar/transcribe/phone/db/entity/AiTodoEntity;", "data", "<init>", "(Ljava/util/List;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/util/List;", "()Ljava/util/List;", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class DbData extends TodoData {

        /* renamed from: a  reason: collision with root package name */
        public final List f6149a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DbData(List list) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(list, "data");
            this.f6149a = list;
        }

        public final List a() {
            return this.f6149a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DbData) && Intrinsics.areEqual((Object) this.f6149a, (Object) ((DbData) obj).f6149a);
        }

        public int hashCode() {
            return this.f6149a.hashCode();
        }

        public String toString() {
            List list = this.f6149a;
            return "DbData(data=" + list + ")";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/vm/TodoData$Empty;", "Lcom/upuphone/ar/transcribe/phone/vm/TodoData;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Empty extends TodoData {

        /* renamed from: a  reason: collision with root package name */
        public static final Empty f6150a = new Empty();

        public Empty() {
            super((DefaultConstructorMarker) null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Empty);
        }

        public int hashCode() {
            return -1324110211;
        }

        public String toString() {
            return "Empty";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/vm/TodoData$Fail;", "Lcom/upuphone/ar/transcribe/phone/vm/TodoData;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Fail extends TodoData {

        /* renamed from: a  reason: collision with root package name */
        public static final Fail f6151a = new Fail();

        public Fail() {
            super((DefaultConstructorMarker) null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Fail);
        }

        public int hashCode() {
            return 511494126;
        }

        public String toString() {
            return "Fail";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/vm/TodoData$Loading;", "Lcom/upuphone/ar/transcribe/phone/vm/TodoData;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Loading extends TodoData {

        /* renamed from: a  reason: collision with root package name */
        public static final Loading f6152a = new Loading();

        public Loading() {
            super((DefaultConstructorMarker) null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Loading);
        }

        public int hashCode() {
            return 800882284;
        }

        public String toString() {
            return "Loading";
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/vm/TodoData$ReportStatus;", "Lcom/upuphone/ar/transcribe/phone/vm/TodoData;", "", "success", "<init>", "(Z)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "a", "Z", "()Z", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class ReportStatus extends TodoData {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f6153a;

        public ReportStatus(boolean z) {
            super((DefaultConstructorMarker) null);
            this.f6153a = z;
        }

        public final boolean a() {
            return this.f6153a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ReportStatus) && this.f6153a == ((ReportStatus) obj).f6153a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f6153a);
        }

        public String toString() {
            boolean z = this.f6153a;
            return "ReportStatus(success=" + z + ")";
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/vm/TodoData$Sensitive;", "Lcom/upuphone/ar/transcribe/phone/vm/TodoData;", "Lcom/upuphone/ar/transcribe/phone/repo/AiResponseSensitive;", "data", "<init>", "(Lcom/upuphone/ar/transcribe/phone/repo/AiResponseSensitive;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Lcom/upuphone/ar/transcribe/phone/repo/AiResponseSensitive;", "()Lcom/upuphone/ar/transcribe/phone/repo/AiResponseSensitive;", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Sensitive extends TodoData {

        /* renamed from: a  reason: collision with root package name */
        public final AiResponseSensitive f6154a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Sensitive(AiResponseSensitive aiResponseSensitive) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(aiResponseSensitive, "data");
            this.f6154a = aiResponseSensitive;
        }

        public final AiResponseSensitive a() {
            return this.f6154a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Sensitive) && Intrinsics.areEqual((Object) this.f6154a, (Object) ((Sensitive) obj).f6154a);
        }

        public int hashCode() {
            return this.f6154a.hashCode();
        }

        public String toString() {
            AiResponseSensitive aiResponseSensitive = this.f6154a;
            return "Sensitive(data=" + aiResponseSensitive + ")";
        }
    }

    public /* synthetic */ TodoData(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public TodoData() {
    }
}
