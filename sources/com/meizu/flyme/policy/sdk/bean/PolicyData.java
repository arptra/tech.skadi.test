package com.meizu.flyme.policy.sdk.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b+\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003¢\u0006\u0002\u0010\u0011J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0006HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0006HÆ\u0003J\t\u0010/\u001a\u00020\u0006HÆ\u0003J\u0001\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u0003HÆ\u0001J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u00020\u0006HÖ\u0001J\t\u00105\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0010\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0013\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0013R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0013¨\u00066"}, d2 = {"Lcom/meizu/flyme/policy/sdk/bean/PolicyData;", "", "category", "", "effectTime", "id", "", "languageType", "name", "policyUid", "policyUrl", "regrantFlag", "version", "versionDesc", "versionName", "viewType", "contentTypes", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCategory", "()Ljava/lang/String;", "getContentTypes", "setContentTypes", "(Ljava/lang/String;)V", "getEffectTime", "getId", "()I", "getLanguageType", "getName", "getPolicyUid", "getPolicyUrl", "getRegrantFlag", "getVersion", "getVersionDesc", "getVersionName", "getViewType", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "policysdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PolicyData {
    @NotNull
    private final String category;
    @NotNull
    private String contentTypes;
    @NotNull
    private final String effectTime;
    private final int id;
    @NotNull
    private final String languageType;
    @NotNull
    private final String name;
    @NotNull
    private final String policyUid;
    @NotNull
    private final String policyUrl;
    private final int regrantFlag;
    private final int version;
    @NotNull
    private final String versionDesc;
    @NotNull
    private final String versionName;
    @NotNull
    private final String viewType;

    public PolicyData(@NotNull String str, @NotNull String str2, int i, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, int i2, int i3, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10) {
        Intrinsics.checkNotNullParameter(str, "category");
        Intrinsics.checkNotNullParameter(str2, "effectTime");
        Intrinsics.checkNotNullParameter(str3, "languageType");
        Intrinsics.checkNotNullParameter(str4, "name");
        Intrinsics.checkNotNullParameter(str5, "policyUid");
        Intrinsics.checkNotNullParameter(str6, "policyUrl");
        Intrinsics.checkNotNullParameter(str7, "versionDesc");
        Intrinsics.checkNotNullParameter(str8, "versionName");
        Intrinsics.checkNotNullParameter(str9, "viewType");
        Intrinsics.checkNotNullParameter(str10, "contentTypes");
        this.category = str;
        this.effectTime = str2;
        this.id = i;
        this.languageType = str3;
        this.name = str4;
        this.policyUid = str5;
        this.policyUrl = str6;
        this.regrantFlag = i2;
        this.version = i3;
        this.versionDesc = str7;
        this.versionName = str8;
        this.viewType = str9;
        this.contentTypes = str10;
    }

    public static /* synthetic */ PolicyData copy$default(PolicyData policyData, String str, String str2, int i, String str3, String str4, String str5, String str6, int i2, int i3, String str7, String str8, String str9, String str10, int i4, Object obj) {
        PolicyData policyData2 = policyData;
        int i5 = i4;
        return policyData.copy((i5 & 1) != 0 ? policyData2.category : str, (i5 & 2) != 0 ? policyData2.effectTime : str2, (i5 & 4) != 0 ? policyData2.id : i, (i5 & 8) != 0 ? policyData2.languageType : str3, (i5 & 16) != 0 ? policyData2.name : str4, (i5 & 32) != 0 ? policyData2.policyUid : str5, (i5 & 64) != 0 ? policyData2.policyUrl : str6, (i5 & 128) != 0 ? policyData2.regrantFlag : i2, (i5 & 256) != 0 ? policyData2.version : i3, (i5 & 512) != 0 ? policyData2.versionDesc : str7, (i5 & 1024) != 0 ? policyData2.versionName : str8, (i5 & 2048) != 0 ? policyData2.viewType : str9, (i5 & 4096) != 0 ? policyData2.contentTypes : str10);
    }

    @NotNull
    public final String component1() {
        return this.category;
    }

    @NotNull
    public final String component10() {
        return this.versionDesc;
    }

    @NotNull
    public final String component11() {
        return this.versionName;
    }

    @NotNull
    public final String component12() {
        return this.viewType;
    }

    @NotNull
    public final String component13() {
        return this.contentTypes;
    }

    @NotNull
    public final String component2() {
        return this.effectTime;
    }

    public final int component3() {
        return this.id;
    }

    @NotNull
    public final String component4() {
        return this.languageType;
    }

    @NotNull
    public final String component5() {
        return this.name;
    }

    @NotNull
    public final String component6() {
        return this.policyUid;
    }

    @NotNull
    public final String component7() {
        return this.policyUrl;
    }

    public final int component8() {
        return this.regrantFlag;
    }

    public final int component9() {
        return this.version;
    }

    @NotNull
    public final PolicyData copy(@NotNull String str, @NotNull String str2, int i, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, int i2, int i3, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10) {
        String str11 = str;
        Intrinsics.checkNotNullParameter(str11, "category");
        String str12 = str2;
        Intrinsics.checkNotNullParameter(str12, "effectTime");
        String str13 = str3;
        Intrinsics.checkNotNullParameter(str13, "languageType");
        String str14 = str4;
        Intrinsics.checkNotNullParameter(str14, "name");
        String str15 = str5;
        Intrinsics.checkNotNullParameter(str15, "policyUid");
        String str16 = str6;
        Intrinsics.checkNotNullParameter(str16, "policyUrl");
        String str17 = str7;
        Intrinsics.checkNotNullParameter(str17, "versionDesc");
        String str18 = str8;
        Intrinsics.checkNotNullParameter(str18, "versionName");
        String str19 = str9;
        Intrinsics.checkNotNullParameter(str19, "viewType");
        String str20 = str10;
        Intrinsics.checkNotNullParameter(str20, "contentTypes");
        return new PolicyData(str11, str12, i, str13, str14, str15, str16, i2, i3, str17, str18, str19, str20);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PolicyData)) {
            return false;
        }
        PolicyData policyData = (PolicyData) obj;
        return Intrinsics.areEqual((Object) this.category, (Object) policyData.category) && Intrinsics.areEqual((Object) this.effectTime, (Object) policyData.effectTime) && this.id == policyData.id && Intrinsics.areEqual((Object) this.languageType, (Object) policyData.languageType) && Intrinsics.areEqual((Object) this.name, (Object) policyData.name) && Intrinsics.areEqual((Object) this.policyUid, (Object) policyData.policyUid) && Intrinsics.areEqual((Object) this.policyUrl, (Object) policyData.policyUrl) && this.regrantFlag == policyData.regrantFlag && this.version == policyData.version && Intrinsics.areEqual((Object) this.versionDesc, (Object) policyData.versionDesc) && Intrinsics.areEqual((Object) this.versionName, (Object) policyData.versionName) && Intrinsics.areEqual((Object) this.viewType, (Object) policyData.viewType) && Intrinsics.areEqual((Object) this.contentTypes, (Object) policyData.contentTypes);
    }

    @NotNull
    public final String getCategory() {
        return this.category;
    }

    @NotNull
    public final String getContentTypes() {
        return this.contentTypes;
    }

    @NotNull
    public final String getEffectTime() {
        return this.effectTime;
    }

    public final int getId() {
        return this.id;
    }

    @NotNull
    public final String getLanguageType() {
        return this.languageType;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getPolicyUid() {
        return this.policyUid;
    }

    @NotNull
    public final String getPolicyUrl() {
        return this.policyUrl;
    }

    public final int getRegrantFlag() {
        return this.regrantFlag;
    }

    public final int getVersion() {
        return this.version;
    }

    @NotNull
    public final String getVersionDesc() {
        return this.versionDesc;
    }

    @NotNull
    public final String getVersionName() {
        return this.versionName;
    }

    @NotNull
    public final String getViewType() {
        return this.viewType;
    }

    public int hashCode() {
        return (((((((((((((((((((((((this.category.hashCode() * 31) + this.effectTime.hashCode()) * 31) + Integer.hashCode(this.id)) * 31) + this.languageType.hashCode()) * 31) + this.name.hashCode()) * 31) + this.policyUid.hashCode()) * 31) + this.policyUrl.hashCode()) * 31) + Integer.hashCode(this.regrantFlag)) * 31) + Integer.hashCode(this.version)) * 31) + this.versionDesc.hashCode()) * 31) + this.versionName.hashCode()) * 31) + this.viewType.hashCode()) * 31) + this.contentTypes.hashCode();
    }

    public final void setContentTypes(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.contentTypes = str;
    }

    @NotNull
    public String toString() {
        return "PolicyData(category=" + this.category + ", effectTime=" + this.effectTime + ", id=" + this.id + ", languageType=" + this.languageType + ", name=" + this.name + ", policyUid=" + this.policyUid + ", policyUrl=" + this.policyUrl + ", regrantFlag=" + this.regrantFlag + ", version=" + this.version + ", versionDesc=" + this.versionDesc + ", versionName=" + this.versionName + ", viewType=" + this.viewType + ", contentTypes=" + this.contentTypes + ')';
    }
}
