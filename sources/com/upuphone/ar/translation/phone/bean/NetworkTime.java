package com.upuphone.ar.translation.phone.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0014B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/upuphone/ar/translation/phone/bean/NetworkTime;", "", "code", "", "data", "Lcom/upuphone/ar/translation/phone/bean/NetworkTime$Data;", "(ILcom/upuphone/ar/translation/phone/bean/NetworkTime$Data;)V", "getCode", "()I", "getData", "()Lcom/upuphone/ar/translation/phone/bean/NetworkTime$Data;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "Data", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class NetworkTime {
    private final int code;
    @Nullable
    private final Data data;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/upuphone/ar/translation/phone/bean/NetworkTime$Data;", "", "now", "", "nowTime", "", "(Ljava/lang/String;J)V", "getNow", "()Ljava/lang/String;", "getNowTime", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Data {
        @NotNull
        private final String now;
        @SerializedName("now_time")
        private final long nowTime;

        public Data() {
            this((String) null, 0, 3, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Data copy$default(Data data, String str, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                str = data.now;
            }
            if ((i & 2) != 0) {
                j = data.nowTime;
            }
            return data.copy(str, j);
        }

        @NotNull
        public final String component1() {
            return this.now;
        }

        public final long component2() {
            return this.nowTime;
        }

        @NotNull
        public final Data copy(@NotNull String str, long j) {
            Intrinsics.checkNotNullParameter(str, "now");
            return new Data(str, j);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Data)) {
                return false;
            }
            Data data = (Data) obj;
            return Intrinsics.areEqual((Object) this.now, (Object) data.now) && this.nowTime == data.nowTime;
        }

        @NotNull
        public final String getNow() {
            return this.now;
        }

        public final long getNowTime() {
            return this.nowTime;
        }

        public int hashCode() {
            return (this.now.hashCode() * 31) + Long.hashCode(this.nowTime);
        }

        @NotNull
        public String toString() {
            String str = this.now;
            long j = this.nowTime;
            return "Data(now='" + str + "', nowTime=" + j + ")";
        }

        public Data(@NotNull String str, long j) {
            Intrinsics.checkNotNullParameter(str, "now");
            this.now = str;
            this.nowTime = j;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Data(String str, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? 0 : j);
        }
    }

    public NetworkTime() {
        this(0, (Data) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ NetworkTime copy$default(NetworkTime networkTime, int i, Data data2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = networkTime.code;
        }
        if ((i2 & 2) != 0) {
            data2 = networkTime.data;
        }
        return networkTime.copy(i, data2);
    }

    public final int component1() {
        return this.code;
    }

    @Nullable
    public final Data component2() {
        return this.data;
    }

    @NotNull
    public final NetworkTime copy(int i, @Nullable Data data2) {
        return new NetworkTime(i, data2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkTime)) {
            return false;
        }
        NetworkTime networkTime = (NetworkTime) obj;
        return this.code == networkTime.code && Intrinsics.areEqual((Object) this.data, (Object) networkTime.data);
    }

    public final int getCode() {
        return this.code;
    }

    @Nullable
    public final Data getData() {
        return this.data;
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.code) * 31;
        Data data2 = this.data;
        return hashCode + (data2 == null ? 0 : data2.hashCode());
    }

    @NotNull
    public String toString() {
        int i = this.code;
        Data data2 = this.data;
        return "NetworkTime(code=" + i + ", data=" + data2 + ")";
    }

    public NetworkTime(int i, @Nullable Data data2) {
        this.code = i;
        this.data = data2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NetworkTime(int i, Data data2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? null : data2);
    }
}
