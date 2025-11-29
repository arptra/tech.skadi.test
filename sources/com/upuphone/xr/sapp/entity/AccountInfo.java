package com.upuphone.xr.sapp.entity;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.google.android.gms.common.Scopes;
import com.upuphone.xr.sapp.contract.ProtocolCategory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\bD\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0016J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u000fHÆ\u0003J\t\u0010C\u001a\u00020\u000fHÆ\u0003J\t\u0010D\u001a\u00020\u0012HÆ\u0003J\t\u0010E\u001a\u00020\u0012HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0003HÆ\u0003J·\u0001\u0010P\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010Q\u001a\u00020\u000f2\b\u0010R\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010S\u001a\u00020\u0003J\t\u0010T\u001a\u00020\u0012HÖ\u0001J\t\u0010U\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\u001a\u0010\u0013\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0018\"\u0004\b(\u0010\u001aR\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0018\"\u0004\b*\u0010\u001aR\u001a\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0018\"\u0004\b,\u0010\u001aR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0018\"\u0004\b.\u0010\u001aR\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010 \"\u0004\b0\u0010\"R\u001a\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0018\"\u0004\b2\u0010\u001aR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0018\"\u0004\b4\u0010\u001aR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0018\"\u0004\b6\u0010\u001aR\u001a\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0018\"\u0004\b8\u0010\u001aR\u001a\u0010\f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0018\"\u0004\b:\u0010\u001aR\u001a\u0010\r\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0018\"\u0004\b<\u0010\u001aR\u001a\u0010\u0010\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010$\"\u0004\b>\u0010&¨\u0006V"}, d2 = {"Lcom/upuphone/xr/sapp/entity/AccountInfo;", "", "id", "", "backgroundColor", "backgroundImage", "bakIcon", "email", "flyme", "icon", "message", "nickname", "phone", "qmImage", "defaultIcon", "", "qmStatus", "indexStatus", "", "code", "mzUid", "mzToken", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZIILjava/lang/String;Ljava/lang/String;)V", "getBackgroundColor", "()Ljava/lang/String;", "setBackgroundColor", "(Ljava/lang/String;)V", "getBackgroundImage", "setBackgroundImage", "getBakIcon", "setBakIcon", "getCode", "()I", "setCode", "(I)V", "getDefaultIcon", "()Z", "setDefaultIcon", "(Z)V", "getEmail", "setEmail", "getFlyme", "setFlyme", "getIcon", "setIcon", "getId", "setId", "getIndexStatus", "setIndexStatus", "getMessage", "setMessage", "getMzToken", "setMzToken", "getMzUid", "setMzUid", "getNickname", "setNickname", "getPhone", "setPhone", "getQmImage", "setQmImage", "getQmStatus", "setQmStatus", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "getPhoneWithoutSensitivities", "hashCode", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class AccountInfo {
    @NotNull
    private String backgroundColor;
    @NotNull
    private String backgroundImage;
    @NotNull
    private String bakIcon;
    private int code;
    private boolean defaultIcon;
    @NotNull
    private String email;
    @NotNull

    /* renamed from: flyme  reason: collision with root package name */
    private String f6937flyme;
    @NotNull
    private String icon;
    @NotNull
    private String id;
    private int indexStatus;
    @NotNull
    private String message;
    @Nullable
    private String mzToken;
    @Nullable
    private String mzUid;
    @NotNull
    private String nickname;
    @NotNull
    private String phone;
    @NotNull
    private String qmImage;
    private boolean qmStatus;

    public AccountInfo(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10, @NotNull String str11, boolean z, boolean z2, int i, int i2, @Nullable String str12, @Nullable String str13) {
        String str14 = str3;
        String str15 = str4;
        String str16 = str5;
        String str17 = str6;
        String str18 = str7;
        String str19 = str8;
        String str20 = str9;
        String str21 = str10;
        String str22 = str11;
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "backgroundColor");
        Intrinsics.checkNotNullParameter(str14, "backgroundImage");
        Intrinsics.checkNotNullParameter(str15, "bakIcon");
        Intrinsics.checkNotNullParameter(str16, Scopes.EMAIL);
        Intrinsics.checkNotNullParameter(str17, ProtocolCategory.FLYME);
        Intrinsics.checkNotNullParameter(str18, "icon");
        Intrinsics.checkNotNullParameter(str19, "message");
        Intrinsics.checkNotNullParameter(str20, "nickname");
        Intrinsics.checkNotNullParameter(str21, "phone");
        Intrinsics.checkNotNullParameter(str22, "qmImage");
        this.id = str;
        this.backgroundColor = str2;
        this.backgroundImage = str14;
        this.bakIcon = str15;
        this.email = str16;
        this.f6937flyme = str17;
        this.icon = str18;
        this.message = str19;
        this.nickname = str20;
        this.phone = str21;
        this.qmImage = str22;
        this.defaultIcon = z;
        this.qmStatus = z2;
        this.indexStatus = i;
        this.code = i2;
        this.mzUid = str12;
        this.mzToken = str13;
    }

    public static /* synthetic */ AccountInfo copy$default(AccountInfo accountInfo, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, boolean z, boolean z2, int i, int i2, String str12, String str13, int i3, Object obj) {
        AccountInfo accountInfo2 = accountInfo;
        int i4 = i3;
        return accountInfo.copy((i4 & 1) != 0 ? accountInfo2.id : str, (i4 & 2) != 0 ? accountInfo2.backgroundColor : str2, (i4 & 4) != 0 ? accountInfo2.backgroundImage : str3, (i4 & 8) != 0 ? accountInfo2.bakIcon : str4, (i4 & 16) != 0 ? accountInfo2.email : str5, (i4 & 32) != 0 ? accountInfo2.f6937flyme : str6, (i4 & 64) != 0 ? accountInfo2.icon : str7, (i4 & 128) != 0 ? accountInfo2.message : str8, (i4 & 256) != 0 ? accountInfo2.nickname : str9, (i4 & 512) != 0 ? accountInfo2.phone : str10, (i4 & 1024) != 0 ? accountInfo2.qmImage : str11, (i4 & 2048) != 0 ? accountInfo2.defaultIcon : z, (i4 & 4096) != 0 ? accountInfo2.qmStatus : z2, (i4 & 8192) != 0 ? accountInfo2.indexStatus : i, (i4 & 16384) != 0 ? accountInfo2.code : i2, (i4 & 32768) != 0 ? accountInfo2.mzUid : str12, (i4 & 65536) != 0 ? accountInfo2.mzToken : str13);
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @NotNull
    public final String component10() {
        return this.phone;
    }

    @NotNull
    public final String component11() {
        return this.qmImage;
    }

    public final boolean component12() {
        return this.defaultIcon;
    }

    public final boolean component13() {
        return this.qmStatus;
    }

    public final int component14() {
        return this.indexStatus;
    }

    public final int component15() {
        return this.code;
    }

    @Nullable
    public final String component16() {
        return this.mzUid;
    }

    @Nullable
    public final String component17() {
        return this.mzToken;
    }

    @NotNull
    public final String component2() {
        return this.backgroundColor;
    }

    @NotNull
    public final String component3() {
        return this.backgroundImage;
    }

    @NotNull
    public final String component4() {
        return this.bakIcon;
    }

    @NotNull
    public final String component5() {
        return this.email;
    }

    @NotNull
    public final String component6() {
        return this.f6937flyme;
    }

    @NotNull
    public final String component7() {
        return this.icon;
    }

    @NotNull
    public final String component8() {
        return this.message;
    }

    @NotNull
    public final String component9() {
        return this.nickname;
    }

    @NotNull
    public final AccountInfo copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10, @NotNull String str11, boolean z, boolean z2, int i, int i2, @Nullable String str12, @Nullable String str13) {
        String str14 = str;
        Intrinsics.checkNotNullParameter(str14, "id");
        Intrinsics.checkNotNullParameter(str2, "backgroundColor");
        Intrinsics.checkNotNullParameter(str3, "backgroundImage");
        Intrinsics.checkNotNullParameter(str4, "bakIcon");
        Intrinsics.checkNotNullParameter(str5, Scopes.EMAIL);
        Intrinsics.checkNotNullParameter(str6, ProtocolCategory.FLYME);
        Intrinsics.checkNotNullParameter(str7, "icon");
        Intrinsics.checkNotNullParameter(str8, "message");
        Intrinsics.checkNotNullParameter(str9, "nickname");
        Intrinsics.checkNotNullParameter(str10, "phone");
        Intrinsics.checkNotNullParameter(str11, "qmImage");
        return new AccountInfo(str14, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, z, z2, i, i2, str12, str13);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccountInfo)) {
            return false;
        }
        AccountInfo accountInfo = (AccountInfo) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) accountInfo.id) && Intrinsics.areEqual((Object) this.backgroundColor, (Object) accountInfo.backgroundColor) && Intrinsics.areEqual((Object) this.backgroundImage, (Object) accountInfo.backgroundImage) && Intrinsics.areEqual((Object) this.bakIcon, (Object) accountInfo.bakIcon) && Intrinsics.areEqual((Object) this.email, (Object) accountInfo.email) && Intrinsics.areEqual((Object) this.f6937flyme, (Object) accountInfo.f6937flyme) && Intrinsics.areEqual((Object) this.icon, (Object) accountInfo.icon) && Intrinsics.areEqual((Object) this.message, (Object) accountInfo.message) && Intrinsics.areEqual((Object) this.nickname, (Object) accountInfo.nickname) && Intrinsics.areEqual((Object) this.phone, (Object) accountInfo.phone) && Intrinsics.areEqual((Object) this.qmImage, (Object) accountInfo.qmImage) && this.defaultIcon == accountInfo.defaultIcon && this.qmStatus == accountInfo.qmStatus && this.indexStatus == accountInfo.indexStatus && this.code == accountInfo.code && Intrinsics.areEqual((Object) this.mzUid, (Object) accountInfo.mzUid) && Intrinsics.areEqual((Object) this.mzToken, (Object) accountInfo.mzToken);
    }

    @NotNull
    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    @NotNull
    public final String getBackgroundImage() {
        return this.backgroundImage;
    }

    @NotNull
    public final String getBakIcon() {
        return this.bakIcon;
    }

    public final int getCode() {
        return this.code;
    }

    public final boolean getDefaultIcon() {
        return this.defaultIcon;
    }

    @NotNull
    public final String getEmail() {
        return this.email;
    }

    @NotNull
    public final String getFlyme() {
        return this.f6937flyme;
    }

    @NotNull
    public final String getIcon() {
        return this.icon;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    public final int getIndexStatus() {
        return this.indexStatus;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    public final String getMzToken() {
        return this.mzToken;
    }

    @Nullable
    public final String getMzUid() {
        return this.mzUid;
    }

    @NotNull
    public final String getNickname() {
        return this.nickname;
    }

    @NotNull
    public final String getPhone() {
        return this.phone;
    }

    @NotNull
    public final String getPhoneWithoutSensitivities() {
        if (TextUtils.isEmpty(this.phone)) {
            return this.phone;
        }
        String substring = this.phone.substring(0, 3);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        String str = this.phone;
        String substring2 = str.substring(7, str.length());
        Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
        return substring + "****" + substring2;
    }

    @NotNull
    public final String getQmImage() {
        return this.qmImage;
    }

    public final boolean getQmStatus() {
        return this.qmStatus;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((((((((((((this.id.hashCode() * 31) + this.backgroundColor.hashCode()) * 31) + this.backgroundImage.hashCode()) * 31) + this.bakIcon.hashCode()) * 31) + this.email.hashCode()) * 31) + this.f6937flyme.hashCode()) * 31) + this.icon.hashCode()) * 31) + this.message.hashCode()) * 31) + this.nickname.hashCode()) * 31) + this.phone.hashCode()) * 31) + this.qmImage.hashCode()) * 31) + Boolean.hashCode(this.defaultIcon)) * 31) + Boolean.hashCode(this.qmStatus)) * 31) + Integer.hashCode(this.indexStatus)) * 31) + Integer.hashCode(this.code)) * 31;
        String str = this.mzUid;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.mzToken;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public final void setBackgroundColor(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.backgroundColor = str;
    }

    public final void setBackgroundImage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.backgroundImage = str;
    }

    public final void setBakIcon(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bakIcon = str;
    }

    public final void setCode(int i) {
        this.code = i;
    }

    public final void setDefaultIcon(boolean z) {
        this.defaultIcon = z;
    }

    public final void setEmail(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.email = str;
    }

    public final void setFlyme(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f6937flyme = str;
    }

    public final void setIcon(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.icon = str;
    }

    public final void setId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final void setIndexStatus(int i) {
        this.indexStatus = i;
    }

    public final void setMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.message = str;
    }

    public final void setMzToken(@Nullable String str) {
        this.mzToken = str;
    }

    public final void setMzUid(@Nullable String str) {
        this.mzUid = str;
    }

    public final void setNickname(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.nickname = str;
    }

    public final void setPhone(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.phone = str;
    }

    public final void setQmImage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.qmImage = str;
    }

    public final void setQmStatus(boolean z) {
        this.qmStatus = z;
    }

    @NotNull
    public String toString() {
        String str = this.id;
        String str2 = this.backgroundColor;
        String str3 = this.backgroundImage;
        String str4 = this.bakIcon;
        String str5 = this.email;
        String str6 = this.f6937flyme;
        String str7 = this.icon;
        String str8 = this.message;
        String str9 = this.nickname;
        String str10 = this.phone;
        String str11 = this.qmImage;
        boolean z = this.defaultIcon;
        boolean z2 = this.qmStatus;
        int i = this.indexStatus;
        int i2 = this.code;
        String str12 = this.mzUid;
        String str13 = this.mzToken;
        return "AccountInfo(id=" + str + ", backgroundColor=" + str2 + ", backgroundImage=" + str3 + ", bakIcon=" + str4 + ", email=" + str5 + ", flyme=" + str6 + ", icon=" + str7 + ", message=" + str8 + ", nickname=" + str9 + ", phone=" + str10 + ", qmImage=" + str11 + ", defaultIcon=" + z + ", qmStatus=" + z2 + ", indexStatus=" + i + ", code=" + i2 + ", mzUid=" + str12 + ", mzToken=" + str13 + ")";
    }
}
