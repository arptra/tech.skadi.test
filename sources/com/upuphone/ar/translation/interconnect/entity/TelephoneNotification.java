package com.upuphone.ar.translation.interconnect.entity;

import com.google.gson.annotations.SerializedName;
import com.honey.account.view.web.WebJs;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001\u0014B\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/upuphone/ar/translation/interconnect/entity/TelephoneNotification;", "", "action", "", "data", "Lcom/upuphone/ar/translation/interconnect/entity/TelephoneNotification$Data;", "(Ljava/lang/String;Lcom/upuphone/ar/translation/interconnect/entity/TelephoneNotification$Data;)V", "getAction", "()Ljava/lang/String;", "getData", "()Lcom/upuphone/ar/translation/interconnect/entity/TelephoneNotification$Data;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Data", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TelephoneNotification {
    @SerializedName("action")
    @NotNull
    private final String action;
    @SerializedName("data")
    @NotNull
    private final Data data;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\b\u0010\u0012\u001a\u00020\u0003H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/upuphone/ar/translation/interconnect/entity/TelephoneNotification$Data;", "", "action", "", "status", "", "(Ljava/lang/String;I)V", "getAction", "()Ljava/lang/String;", "getStatus", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Data {
        @SerializedName("action")
        @NotNull
        private final String action;
        @SerializedName("status")
        private final int status;

        public Data() {
            this((String) null, 0, 3, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Data copy$default(Data data, String str, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = data.action;
            }
            if ((i2 & 2) != 0) {
                i = data.status;
            }
            return data.copy(str, i);
        }

        @NotNull
        public final String component1() {
            return this.action;
        }

        public final int component2() {
            return this.status;
        }

        @NotNull
        public final Data copy(@NotNull String str, int i) {
            Intrinsics.checkNotNullParameter(str, WebJs.ACTION);
            return new Data(str, i);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Data)) {
                return false;
            }
            Data data = (Data) obj;
            return Intrinsics.areEqual((Object) this.action, (Object) data.action) && this.status == data.status;
        }

        @NotNull
        public final String getAction() {
            return this.action;
        }

        public final int getStatus() {
            return this.status;
        }

        public int hashCode() {
            return (this.action.hashCode() * 31) + Integer.hashCode(this.status);
        }

        @NotNull
        public String toString() {
            String str = this.action;
            int i = this.status;
            return "Data(action='" + str + "', status=" + i + ")";
        }

        public Data(@NotNull String str, int i) {
            Intrinsics.checkNotNullParameter(str, WebJs.ACTION);
            this.action = str;
            this.status = i;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Data(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? "telephone_notification" : str, (i2 & 2) != 0 ? 1 : i);
        }
    }

    public TelephoneNotification(@NotNull String str, @NotNull Data data2) {
        Intrinsics.checkNotNullParameter(str, WebJs.ACTION);
        Intrinsics.checkNotNullParameter(data2, "data");
        this.action = str;
        this.data = data2;
    }

    public static /* synthetic */ TelephoneNotification copy$default(TelephoneNotification telephoneNotification, String str, Data data2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = telephoneNotification.action;
        }
        if ((i & 2) != 0) {
            data2 = telephoneNotification.data;
        }
        return telephoneNotification.copy(str, data2);
    }

    @NotNull
    public final String component1() {
        return this.action;
    }

    @NotNull
    public final Data component2() {
        return this.data;
    }

    @NotNull
    public final TelephoneNotification copy(@NotNull String str, @NotNull Data data2) {
        Intrinsics.checkNotNullParameter(str, WebJs.ACTION);
        Intrinsics.checkNotNullParameter(data2, "data");
        return new TelephoneNotification(str, data2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TelephoneNotification)) {
            return false;
        }
        TelephoneNotification telephoneNotification = (TelephoneNotification) obj;
        return Intrinsics.areEqual((Object) this.action, (Object) telephoneNotification.action) && Intrinsics.areEqual((Object) this.data, (Object) telephoneNotification.data);
    }

    @NotNull
    public final String getAction() {
        return this.action;
    }

    @NotNull
    public final Data getData() {
        return this.data;
    }

    public int hashCode() {
        return (this.action.hashCode() * 31) + this.data.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.action;
        Data data2 = this.data;
        return "TelephoneNotification(action='" + str + "', data=" + data2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TelephoneNotification(String str, Data data2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "translator" : str, data2);
    }
}
