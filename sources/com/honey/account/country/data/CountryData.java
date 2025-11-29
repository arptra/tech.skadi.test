package com.honey.account.country.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.honey.account.country.db.CountryTable;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import org.slf4j.Marker;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 )2\u00020\u0001:\u0001)B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003JO\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u001f\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001J\u0019\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006*"}, d2 = {"Lcom/honey/account/country/data/CountryData;", "Landroid/os/Parcelable;", "primaryKey", "", "brief", "", "country", "code", "simpleCode", "isFirst", "", "sortKey", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getBrief", "()Ljava/lang/String;", "getCode", "getCountry", "()Z", "getPrimaryKey", "()I", "getSimpleCode", "getSortKey", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Parcelize
public final class CountryData implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<CountryData> CREATOR = new Creator();
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String TAG = "CountryData";
    @NotNull
    @JvmField
    public static final CountryData US_COUNTRY = new CountryData(0, "US", "United States", "001", "+1", false, "U");
    @NotNull
    private final String brief;
    @NotNull
    private final String code;
    @NotNull
    private final String country;
    private final boolean isFirst;
    private final int primaryKey;
    @NotNull
    private final String simpleCode;
    @NotNull
    private final String sortKey;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002J*\u0010\t\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/honey/account/country/data/CountryData$Companion;", "", "()V", "TAG", "", "US_COUNTRY", "Lcom/honey/account/country/data/CountryData;", "getSimpleCode", "code", "parse", "primaryKey", "", "sortKey", "isFirst", "", "result", "Lorg/json/JSONObject;", "toJson", "countryData", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final String getSimpleCode(String str) {
            return StringsKt.replace$default(str, "00", Marker.ANY_NON_NULL_MARKER, false, 4, (Object) null);
        }

        public static /* synthetic */ CountryData parse$default(Companion companion, int i, String str, boolean z, JSONObject jSONObject, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = 0;
            }
            return companion.parse(i, str, z, jSONObject);
        }

        @Nullable
        public final CountryData parse(int i, @NotNull String str, boolean z, @NotNull JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(str, "sortKey");
            Intrinsics.checkNotNullParameter(jSONObject, "result");
            try {
                String optString = jSONObject.optString(CountryTable.BRIEF);
                String optString2 = jSONObject.optString("country");
                String optString3 = jSONObject.optString("code");
                Intrinsics.checkNotNull(optString);
                Intrinsics.checkNotNull(optString2);
                Intrinsics.checkNotNull(optString3);
                return new CountryData(i, optString, optString2, optString3, getSimpleCode(optString3), z, str);
            } catch (Throwable unused) {
                return null;
            }
        }

        @NotNull
        public final JSONObject toJson(@NotNull CountryData countryData) {
            Intrinsics.checkNotNullParameter(countryData, "countryData");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("primaryKey", countryData.getPrimaryKey());
            jSONObject.put(CountryTable.BRIEF, countryData.getBrief());
            jSONObject.put("country", countryData.getCountry());
            jSONObject.put("code", countryData.getCode());
            jSONObject.put("simpleCode", countryData.getSimpleCode());
            jSONObject.put("isFirst", countryData.isFirst());
            jSONObject.put("sortKey", countryData.getSortKey());
            return jSONObject;
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CountryData> {
        @NotNull
        public final CountryData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CountryData(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString());
        }

        @NotNull
        public final CountryData[] newArray(int i) {
            return new CountryData[i];
        }
    }

    public CountryData(int i, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, boolean z, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, CountryTable.BRIEF);
        Intrinsics.checkNotNullParameter(str2, "country");
        Intrinsics.checkNotNullParameter(str3, "code");
        Intrinsics.checkNotNullParameter(str4, "simpleCode");
        Intrinsics.checkNotNullParameter(str5, "sortKey");
        this.primaryKey = i;
        this.brief = str;
        this.country = str2;
        this.code = str3;
        this.simpleCode = str4;
        this.isFirst = z;
        this.sortKey = str5;
    }

    public static /* synthetic */ CountryData copy$default(CountryData countryData, int i, String str, String str2, String str3, String str4, boolean z, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = countryData.primaryKey;
        }
        if ((i2 & 2) != 0) {
            str = countryData.brief;
        }
        String str6 = str;
        if ((i2 & 4) != 0) {
            str2 = countryData.country;
        }
        String str7 = str2;
        if ((i2 & 8) != 0) {
            str3 = countryData.code;
        }
        String str8 = str3;
        if ((i2 & 16) != 0) {
            str4 = countryData.simpleCode;
        }
        String str9 = str4;
        if ((i2 & 32) != 0) {
            z = countryData.isFirst;
        }
        boolean z2 = z;
        if ((i2 & 64) != 0) {
            str5 = countryData.sortKey;
        }
        return countryData.copy(i, str6, str7, str8, str9, z2, str5);
    }

    public final int component1() {
        return this.primaryKey;
    }

    @NotNull
    public final String component2() {
        return this.brief;
    }

    @NotNull
    public final String component3() {
        return this.country;
    }

    @NotNull
    public final String component4() {
        return this.code;
    }

    @NotNull
    public final String component5() {
        return this.simpleCode;
    }

    public final boolean component6() {
        return this.isFirst;
    }

    @NotNull
    public final String component7() {
        return this.sortKey;
    }

    @NotNull
    public final CountryData copy(int i, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, boolean z, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, CountryTable.BRIEF);
        Intrinsics.checkNotNullParameter(str2, "country");
        Intrinsics.checkNotNullParameter(str3, "code");
        Intrinsics.checkNotNullParameter(str4, "simpleCode");
        Intrinsics.checkNotNullParameter(str5, "sortKey");
        return new CountryData(i, str, str2, str3, str4, z, str5);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CountryData)) {
            return false;
        }
        CountryData countryData = (CountryData) obj;
        return this.primaryKey == countryData.primaryKey && Intrinsics.areEqual((Object) this.brief, (Object) countryData.brief) && Intrinsics.areEqual((Object) this.country, (Object) countryData.country) && Intrinsics.areEqual((Object) this.code, (Object) countryData.code) && Intrinsics.areEqual((Object) this.simpleCode, (Object) countryData.simpleCode) && this.isFirst == countryData.isFirst && Intrinsics.areEqual((Object) this.sortKey, (Object) countryData.sortKey);
    }

    @NotNull
    public final String getBrief() {
        return this.brief;
    }

    @NotNull
    public final String getCode() {
        return this.code;
    }

    @NotNull
    public final String getCountry() {
        return this.country;
    }

    public final int getPrimaryKey() {
        return this.primaryKey;
    }

    @NotNull
    public final String getSimpleCode() {
        return this.simpleCode;
    }

    @NotNull
    public final String getSortKey() {
        return this.sortKey;
    }

    public int hashCode() {
        int hashCode = ((((((((Integer.hashCode(this.primaryKey) * 31) + this.brief.hashCode()) * 31) + this.country.hashCode()) * 31) + this.code.hashCode()) * 31) + this.simpleCode.hashCode()) * 31;
        boolean z = this.isFirst;
        if (z) {
            z = true;
        }
        return ((hashCode + (z ? 1 : 0)) * 31) + this.sortKey.hashCode();
    }

    public final boolean isFirst() {
        return this.isFirst;
    }

    @NotNull
    public String toString() {
        return "CountryData(primaryKey=" + this.primaryKey + ", brief=" + this.brief + ", country=" + this.country + ", code=" + this.code + ", simpleCode=" + this.simpleCode + ", isFirst=" + this.isFirst + ", sortKey=" + this.sortKey + ')';
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.primaryKey);
        parcel.writeString(this.brief);
        parcel.writeString(this.country);
        parcel.writeString(this.code);
        parcel.writeString(this.simpleCode);
        parcel.writeInt(this.isFirst ? 1 : 0);
        parcel.writeString(this.sortKey);
    }
}
