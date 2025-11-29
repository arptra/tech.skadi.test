package com.upuphone.ar.transcribe.phone.db.entity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b.\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B§\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0013J\u0010\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010=\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\bHÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010G\u001a\u00020\bHÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003J°\u0001\u0010J\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010KJ\t\u0010L\u001a\u00020\bHÖ\u0001J\u0013\u0010M\u001a\u00020 2\b\u0010N\u001a\u0004\u0018\u00010OH\u0002J\b\u0010P\u001a\u00020\bH\u0016J\t\u0010Q\u001a\u00020\u0005HÖ\u0001J\u0019\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\bHÖ\u0001R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001f\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010!R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0015\"\u0004\b%\u0010\u0017R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0015\"\u0004\b'\u0010\u0017R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0015\"\u0004\b-\u0010\u0017R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0015\"\u0004\b/\u0010\u0017R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0015\"\u0004\b1\u0010\u0017R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0015\"\u0004\b3\u0010\u0017R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0015\"\u0004\b5\u0010\u0017R\u001a\u0010\u000b\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00107\"\u0004\b;\u00109¨\u0006W"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/db/entity/TranscribeBean;", "Landroid/os/Parcelable;", "id", "", "transResult", "", "recordTime", "xrType", "", "title", "location", "type", "account", "superTitle", "title2", "recognizeId", "language", "fullLocation", "simpleLocation", "(Ljava/lang/Long;Ljava/lang/String;JILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccount", "()Ljava/lang/String;", "setAccount", "(Ljava/lang/String;)V", "getFullLocation", "setFullLocation", "getId", "()Ljava/lang/Long;", "setId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "isValid", "", "()Z", "getLanguage", "setLanguage", "getLocation", "setLocation", "getRecognizeId", "setRecognizeId", "getRecordTime", "()J", "setRecordTime", "(J)V", "getSimpleLocation", "setSimpleLocation", "getSuperTitle", "setSuperTitle", "getTitle", "setTitle", "getTitle2", "setTitle2", "getTransResult", "setTransResult", "getType", "()I", "setType", "(I)V", "getXrType", "setXrType", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Long;Ljava/lang/String;JILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/upuphone/ar/transcribe/phone/db/entity/TranscribeBean;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Parcelize
@Entity
public final class TranscribeBean implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<TranscribeBean> CREATOR = new Creator();
    @Nullable
    private String account;
    @Nullable
    private String fullLocation;
    @Nullable
    @PrimaryKey
    private Long id;
    @Nullable
    private String language;
    @Nullable
    private String location;
    @Nullable
    private String recognizeId;
    private long recordTime;
    @Nullable
    private String simpleLocation;
    @Nullable
    private String superTitle;
    @Nullable
    private String title;
    @Nullable
    private String title2;
    @Nullable
    private String transResult;
    private int type;
    private int xrType;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<TranscribeBean> {
        /* renamed from: a */
        public final TranscribeBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new TranscribeBean(parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readString(), parcel.readLong(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* renamed from: b */
        public final TranscribeBean[] newArray(int i) {
            return new TranscribeBean[i];
        }
    }

    public TranscribeBean() {
        this((Long) null, (String) null, 0, 0, (String) null, (String) null, 0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 16383, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ TranscribeBean copy$default(TranscribeBean transcribeBean, Long l, String str, long j, int i, String str2, String str3, int i2, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i3, Object obj) {
        TranscribeBean transcribeBean2 = transcribeBean;
        int i4 = i3;
        return transcribeBean.copy((i4 & 1) != 0 ? transcribeBean2.id : l, (i4 & 2) != 0 ? transcribeBean2.transResult : str, (i4 & 4) != 0 ? transcribeBean2.recordTime : j, (i4 & 8) != 0 ? transcribeBean2.xrType : i, (i4 & 16) != 0 ? transcribeBean2.title : str2, (i4 & 32) != 0 ? transcribeBean2.location : str3, (i4 & 64) != 0 ? transcribeBean2.type : i2, (i4 & 128) != 0 ? transcribeBean2.account : str4, (i4 & 256) != 0 ? transcribeBean2.superTitle : str5, (i4 & 512) != 0 ? transcribeBean2.title2 : str6, (i4 & 1024) != 0 ? transcribeBean2.recognizeId : str7, (i4 & 2048) != 0 ? transcribeBean2.language : str8, (i4 & 4096) != 0 ? transcribeBean2.fullLocation : str9, (i4 & 8192) != 0 ? transcribeBean2.simpleLocation : str10);
    }

    @Nullable
    public final Long component1() {
        return this.id;
    }

    @Nullable
    public final String component10() {
        return this.title2;
    }

    @Nullable
    public final String component11() {
        return this.recognizeId;
    }

    @Nullable
    public final String component12() {
        return this.language;
    }

    @Nullable
    public final String component13() {
        return this.fullLocation;
    }

    @Nullable
    public final String component14() {
        return this.simpleLocation;
    }

    @Nullable
    public final String component2() {
        return this.transResult;
    }

    public final long component3() {
        return this.recordTime;
    }

    public final int component4() {
        return this.xrType;
    }

    @Nullable
    public final String component5() {
        return this.title;
    }

    @Nullable
    public final String component6() {
        return this.location;
    }

    public final int component7() {
        return this.type;
    }

    @Nullable
    public final String component8() {
        return this.account;
    }

    @Nullable
    public final String component9() {
        return this.superTitle;
    }

    @NotNull
    public final TranscribeBean copy(@Nullable Long l, @Nullable String str, long j, int i, @Nullable String str2, @Nullable String str3, int i2, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10) {
        return new TranscribeBean(l, str, j, i, str2, str3, i2, str4, str5, str6, str7, str8, str9, str10);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof TranscribeBean) && Intrinsics.areEqual((Object) this.id, (Object) ((TranscribeBean) obj).id);
    }

    @Nullable
    public final String getAccount() {
        return this.account;
    }

    @Nullable
    public final String getFullLocation() {
        return this.fullLocation;
    }

    @Nullable
    public final Long getId() {
        return this.id;
    }

    @Nullable
    public final String getLanguage() {
        return this.language;
    }

    @Nullable
    public final String getLocation() {
        return this.location;
    }

    @Nullable
    public final String getRecognizeId() {
        return this.recognizeId;
    }

    public final long getRecordTime() {
        return this.recordTime;
    }

    @Nullable
    public final String getSimpleLocation() {
        return this.simpleLocation;
    }

    @Nullable
    public final String getSuperTitle() {
        return this.superTitle;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getTitle2() {
        return this.title2;
    }

    @Nullable
    public final String getTransResult() {
        return this.transResult;
    }

    public final int getType() {
        return this.type;
    }

    public final int getXrType() {
        return this.xrType;
    }

    public int hashCode() {
        Long l = this.id;
        if (l != null) {
            return l.hashCode();
        }
        return -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r4 = r4.xrType;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isValid() {
        /*
            r4 = this;
            long r0 = r4.recordTime
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x0010
            int r4 = r4.xrType
            r0 = 1
            if (r4 == 0) goto L_0x0011
            if (r4 != r0) goto L_0x0010
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean.isValid():boolean");
    }

    public final void setAccount(@Nullable String str) {
        this.account = str;
    }

    public final void setFullLocation(@Nullable String str) {
        this.fullLocation = str;
    }

    public final void setId(@Nullable Long l) {
        this.id = l;
    }

    public final void setLanguage(@Nullable String str) {
        this.language = str;
    }

    public final void setLocation(@Nullable String str) {
        this.location = str;
    }

    public final void setRecognizeId(@Nullable String str) {
        this.recognizeId = str;
    }

    public final void setRecordTime(long j) {
        this.recordTime = j;
    }

    public final void setSimpleLocation(@Nullable String str) {
        this.simpleLocation = str;
    }

    public final void setSuperTitle(@Nullable String str) {
        this.superTitle = str;
    }

    public final void setTitle(@Nullable String str) {
        this.title = str;
    }

    public final void setTitle2(@Nullable String str) {
        this.title2 = str;
    }

    public final void setTransResult(@Nullable String str) {
        this.transResult = str;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public final void setXrType(int i) {
        this.xrType = i;
    }

    @NotNull
    public String toString() {
        Long l = this.id;
        String str = this.transResult;
        long j = this.recordTime;
        int i = this.xrType;
        String str2 = this.title;
        String str3 = this.location;
        int i2 = this.type;
        String str4 = this.account;
        String str5 = this.superTitle;
        String str6 = this.title2;
        String str7 = this.recognizeId;
        String str8 = this.language;
        String str9 = this.fullLocation;
        String str10 = this.simpleLocation;
        return "TranscribeBean(id=" + l + ", transResult=" + str + ", recordTime=" + j + ", xrType=" + i + ", title=" + str2 + ", location=" + str3 + ", type=" + i2 + ", account=" + str4 + ", superTitle=" + str5 + ", title2=" + str6 + ", recognizeId=" + str7 + ", language=" + str8 + ", fullLocation=" + str9 + ", simpleLocation=" + str10 + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        Long l = this.id;
        if (l == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        }
        parcel.writeString(this.transResult);
        parcel.writeLong(this.recordTime);
        parcel.writeInt(this.xrType);
        parcel.writeString(this.title);
        parcel.writeString(this.location);
        parcel.writeInt(this.type);
        parcel.writeString(this.account);
        parcel.writeString(this.superTitle);
        parcel.writeString(this.title2);
        parcel.writeString(this.recognizeId);
        parcel.writeString(this.language);
        parcel.writeString(this.fullLocation);
        parcel.writeString(this.simpleLocation);
    }

    public TranscribeBean(@Nullable Long l, @Nullable String str, long j, int i, @Nullable String str2, @Nullable String str3, int i2, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10) {
        this.id = l;
        this.transResult = str;
        this.recordTime = j;
        this.xrType = i;
        this.title = str2;
        this.location = str3;
        this.type = i2;
        this.account = str4;
        this.superTitle = str5;
        this.title2 = str6;
        this.recognizeId = str7;
        this.language = str8;
        this.fullLocation = str9;
        this.simpleLocation = str10;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TranscribeBean(java.lang.Long r17, java.lang.String r18, long r19, int r21, java.lang.String r22, java.lang.String r23, int r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, int r32, kotlin.jvm.internal.DefaultConstructorMarker r33) {
        /*
            r16 = this;
            r0 = r32
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000b
        L_0x0009:
            r1 = r17
        L_0x000b:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0011
            r3 = r2
            goto L_0x0013
        L_0x0011:
            r3 = r18
        L_0x0013:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x001a
            r4 = 0
            goto L_0x001c
        L_0x001a:
            r4 = r19
        L_0x001c:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0022
            r6 = 0
            goto L_0x0024
        L_0x0022:
            r6 = r21
        L_0x0024:
            r7 = r0 & 16
            java.lang.String r8 = ""
            if (r7 == 0) goto L_0x002c
            r7 = r8
            goto L_0x002e
        L_0x002c:
            r7 = r22
        L_0x002e:
            r9 = r0 & 32
            if (r9 == 0) goto L_0x0034
            r9 = r2
            goto L_0x0036
        L_0x0034:
            r9 = r23
        L_0x0036:
            r10 = r0 & 64
            if (r10 == 0) goto L_0x003c
            r10 = 1
            goto L_0x003e
        L_0x003c:
            r10 = r24
        L_0x003e:
            r11 = r0 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x0044
            r11 = r2
            goto L_0x0046
        L_0x0044:
            r11 = r25
        L_0x0046:
            r12 = r0 & 256(0x100, float:3.59E-43)
            if (r12 == 0) goto L_0x004c
            r12 = r2
            goto L_0x004e
        L_0x004c:
            r12 = r26
        L_0x004e:
            r13 = r0 & 512(0x200, float:7.175E-43)
            if (r13 == 0) goto L_0x0054
            r13 = r8
            goto L_0x0056
        L_0x0054:
            r13 = r27
        L_0x0056:
            r14 = r0 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x005c
            r14 = r8
            goto L_0x005e
        L_0x005c:
            r14 = r28
        L_0x005e:
            r15 = r0 & 2048(0x800, float:2.87E-42)
            if (r15 == 0) goto L_0x0063
            goto L_0x0065
        L_0x0063:
            r8 = r29
        L_0x0065:
            r15 = r0 & 4096(0x1000, float:5.74E-42)
            if (r15 == 0) goto L_0x006b
            r15 = r2
            goto L_0x006d
        L_0x006b:
            r15 = r30
        L_0x006d:
            r0 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x0072
            goto L_0x0074
        L_0x0072:
            r2 = r31
        L_0x0074:
            r17 = r1
            r18 = r3
            r19 = r4
            r21 = r6
            r22 = r7
            r23 = r9
            r24 = r10
            r25 = r11
            r26 = r12
            r27 = r13
            r28 = r14
            r29 = r8
            r30 = r15
            r31 = r2
            r16.<init>(r17, r18, r19, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean.<init>(java.lang.Long, java.lang.String, long, int, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
