package com.upuphone.ar.transcribe.phone.vm;

import com.upuphone.ar.transcribe.phone.db.entity.AiSummaryEntity;
import com.upuphone.ar.transcribe.phone.repo.AiResponseSensitive;
import com.upuphone.ar.transcribe.phone.repo.AiResponseSummary;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/vm/SummaryData;", "", "()V", "CloudData", "DbData", "Loading", "ReportStatus", "SensitiveData", "Lcom/upuphone/ar/transcribe/phone/vm/SummaryData$CloudData;", "Lcom/upuphone/ar/transcribe/phone/vm/SummaryData$DbData;", "Lcom/upuphone/ar/transcribe/phone/vm/SummaryData$Loading;", "Lcom/upuphone/ar/transcribe/phone/vm/SummaryData$ReportStatus;", "Lcom/upuphone/ar/transcribe/phone/vm/SummaryData$SensitiveData;", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class SummaryData {

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/vm/SummaryData$CloudData;", "Lcom/upuphone/ar/transcribe/phone/vm/SummaryData;", "Lcom/upuphone/ar/transcribe/phone/repo/AiResponseSummary;", "data", "<init>", "(Lcom/upuphone/ar/transcribe/phone/repo/AiResponseSummary;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Lcom/upuphone/ar/transcribe/phone/repo/AiResponseSummary;", "()Lcom/upuphone/ar/transcribe/phone/repo/AiResponseSummary;", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class CloudData extends SummaryData {

        /* renamed from: a  reason: collision with root package name */
        public final AiResponseSummary f6141a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CloudData(AiResponseSummary aiResponseSummary) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(aiResponseSummary, "data");
            this.f6141a = aiResponseSummary;
        }

        public final AiResponseSummary a() {
            return this.f6141a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CloudData) && Intrinsics.areEqual((Object) this.f6141a, (Object) ((CloudData) obj).f6141a);
        }

        public int hashCode() {
            return this.f6141a.hashCode();
        }

        public String toString() {
            AiResponseSummary aiResponseSummary = this.f6141a;
            return "CloudData(data=" + aiResponseSummary + ")";
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/vm/SummaryData$DbData;", "Lcom/upuphone/ar/transcribe/phone/vm/SummaryData;", "Lcom/upuphone/ar/transcribe/phone/db/entity/AiSummaryEntity;", "data", "<init>", "(Lcom/upuphone/ar/transcribe/phone/db/entity/AiSummaryEntity;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Lcom/upuphone/ar/transcribe/phone/db/entity/AiSummaryEntity;", "()Lcom/upuphone/ar/transcribe/phone/db/entity/AiSummaryEntity;", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class DbData extends SummaryData {

        /* renamed from: a  reason: collision with root package name */
        public final AiSummaryEntity f6142a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DbData(AiSummaryEntity aiSummaryEntity) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(aiSummaryEntity, "data");
            this.f6142a = aiSummaryEntity;
        }

        public final AiSummaryEntity a() {
            return this.f6142a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DbData) && Intrinsics.areEqual((Object) this.f6142a, (Object) ((DbData) obj).f6142a);
        }

        public int hashCode() {
            return this.f6142a.hashCode();
        }

        public String toString() {
            AiSummaryEntity aiSummaryEntity = this.f6142a;
            return "DbData(data=" + aiSummaryEntity + ")";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/vm/SummaryData$Loading;", "Lcom/upuphone/ar/transcribe/phone/vm/SummaryData;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Loading extends SummaryData {

        /* renamed from: a  reason: collision with root package name */
        public static final Loading f6143a = new Loading();

        public Loading() {
            super((DefaultConstructorMarker) null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Loading);
        }

        public int hashCode() {
            return 322338480;
        }

        public String toString() {
            return "Loading";
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/vm/SummaryData$ReportStatus;", "Lcom/upuphone/ar/transcribe/phone/vm/SummaryData;", "", "success", "<init>", "(Z)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "a", "Z", "()Z", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class ReportStatus extends SummaryData {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f6144a;

        public ReportStatus(boolean z) {
            super((DefaultConstructorMarker) null);
            this.f6144a = z;
        }

        public final boolean a() {
            return this.f6144a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ReportStatus) && this.f6144a == ((ReportStatus) obj).f6144a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f6144a);
        }

        public String toString() {
            boolean z = this.f6144a;
            return "ReportStatus(success=" + z + ")";
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/vm/SummaryData$SensitiveData;", "Lcom/upuphone/ar/transcribe/phone/vm/SummaryData;", "Lcom/upuphone/ar/transcribe/phone/repo/AiResponseSensitive;", "data", "<init>", "(Lcom/upuphone/ar/transcribe/phone/repo/AiResponseSensitive;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Lcom/upuphone/ar/transcribe/phone/repo/AiResponseSensitive;", "()Lcom/upuphone/ar/transcribe/phone/repo/AiResponseSensitive;", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class SensitiveData extends SummaryData {

        /* renamed from: a  reason: collision with root package name */
        public final AiResponseSensitive f6145a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SensitiveData(AiResponseSensitive aiResponseSensitive) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(aiResponseSensitive, "data");
            this.f6145a = aiResponseSensitive;
        }

        public final AiResponseSensitive a() {
            return this.f6145a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SensitiveData) && Intrinsics.areEqual((Object) this.f6145a, (Object) ((SensitiveData) obj).f6145a);
        }

        public int hashCode() {
            return this.f6145a.hashCode();
        }

        public String toString() {
            AiResponseSensitive aiResponseSensitive = this.f6145a;
            return "SensitiveData(data=" + aiResponseSensitive + ")";
        }
    }

    public /* synthetic */ SummaryData(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public SummaryData() {
    }
}
