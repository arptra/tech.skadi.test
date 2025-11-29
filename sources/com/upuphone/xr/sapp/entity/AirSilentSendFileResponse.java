package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJH\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0011\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010¨\u0006 "}, d2 = {"Lcom/upuphone/xr/sapp/entity/AirSilentSendFileResponse;", "", "code", "", "fileName", "", "md5", "fileOffset", "fileLength", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getCode", "()I", "getFileLength", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFileName", "()Ljava/lang/String;", "getFileOffset", "getMd5", "component1", "component2", "component3", "component4", "component5", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/upuphone/xr/sapp/entity/AirSilentSendFileResponse;", "equals", "", "other", "hashCode", "toString", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class AirSilentSendFileResponse {
    public static final int CODE_FAIL = 1;
    public static final int CODE_SUCCESS = 0;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final int code;
    @Nullable
    private final Integer fileLength;
    @Nullable
    private final String fileName;
    @Nullable
    private final Integer fileOffset;
    @Nullable
    private final String md5;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/upuphone/xr/sapp/entity/AirSilentSendFileResponse$Companion;", "", "()V", "CODE_FAIL", "", "CODE_SUCCESS", "fail", "Lcom/upuphone/xr/sapp/entity/AirSilentSendFileResponse;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AirSilentSendFileResponse fail() {
            return new AirSilentSendFileResponse(1, (String) null, (String) null, (Integer) null, (Integer) null, 30, (DefaultConstructorMarker) null);
        }

        private Companion() {
        }
    }

    public AirSilentSendFileResponse(int i, @Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable Integer num2) {
        this.code = i;
        this.fileName = str;
        this.md5 = str2;
        this.fileOffset = num;
        this.fileLength = num2;
    }

    public static /* synthetic */ AirSilentSendFileResponse copy$default(AirSilentSendFileResponse airSilentSendFileResponse, int i, String str, String str2, Integer num, Integer num2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = airSilentSendFileResponse.code;
        }
        if ((i2 & 2) != 0) {
            str = airSilentSendFileResponse.fileName;
        }
        String str3 = str;
        if ((i2 & 4) != 0) {
            str2 = airSilentSendFileResponse.md5;
        }
        String str4 = str2;
        if ((i2 & 8) != 0) {
            num = airSilentSendFileResponse.fileOffset;
        }
        Integer num3 = num;
        if ((i2 & 16) != 0) {
            num2 = airSilentSendFileResponse.fileLength;
        }
        return airSilentSendFileResponse.copy(i, str3, str4, num3, num2);
    }

    public final int component1() {
        return this.code;
    }

    @Nullable
    public final String component2() {
        return this.fileName;
    }

    @Nullable
    public final String component3() {
        return this.md5;
    }

    @Nullable
    public final Integer component4() {
        return this.fileOffset;
    }

    @Nullable
    public final Integer component5() {
        return this.fileLength;
    }

    @NotNull
    public final AirSilentSendFileResponse copy(int i, @Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable Integer num2) {
        return new AirSilentSendFileResponse(i, str, str2, num, num2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AirSilentSendFileResponse)) {
            return false;
        }
        AirSilentSendFileResponse airSilentSendFileResponse = (AirSilentSendFileResponse) obj;
        return this.code == airSilentSendFileResponse.code && Intrinsics.areEqual((Object) this.fileName, (Object) airSilentSendFileResponse.fileName) && Intrinsics.areEqual((Object) this.md5, (Object) airSilentSendFileResponse.md5) && Intrinsics.areEqual((Object) this.fileOffset, (Object) airSilentSendFileResponse.fileOffset) && Intrinsics.areEqual((Object) this.fileLength, (Object) airSilentSendFileResponse.fileLength);
    }

    public final int getCode() {
        return this.code;
    }

    @Nullable
    public final Integer getFileLength() {
        return this.fileLength;
    }

    @Nullable
    public final String getFileName() {
        return this.fileName;
    }

    @Nullable
    public final Integer getFileOffset() {
        return this.fileOffset;
    }

    @Nullable
    public final String getMd5() {
        return this.md5;
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.code) * 31;
        String str = this.fileName;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.md5;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.fileOffset;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.fileLength;
        if (num2 != null) {
            i = num2.hashCode();
        }
        return hashCode4 + i;
    }

    @NotNull
    public String toString() {
        int i = this.code;
        String str = this.fileName;
        String str2 = this.md5;
        Integer num = this.fileOffset;
        Integer num2 = this.fileLength;
        return "AirSilentSendFileResponse(code=" + i + ", fileName=" + str + ", md5=" + str2 + ", fileOffset=" + num + ", fileLength=" + num2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AirSilentSendFileResponse(int i, String str, String str2, Integer num, Integer num2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : num, (i2 & 16) != 0 ? null : num2);
    }
}
