package com.xjmz.myvu.account;

import androidx.annotation.Keep;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b,\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0011J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J¦\u0001\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u00100J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u000205HÖ\u0001J\t\u00106\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0015R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001c\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0013¨\u00067"}, d2 = {"Lcom/xjmz/myvu/account/UserProfileData;", "", "id", "", "socialSuid", "", "socialTuid", "uid", "name", "phone", "email", "nick", "logo", "score", "level", "state", "source", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "getEmail", "()Ljava/lang/String;", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getLevel", "getLogo", "getName", "getNick", "getPhone", "getScore", "getSocialSuid", "getSocialTuid", "getSource", "getState", "getUid", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lcom/xjmz/myvu/account/UserProfileData;", "equals", "", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class UserProfileData {
    @Nullable
    private final String email;
    @Nullable
    private final Long id;
    @Nullable
    private final Long level;
    @Nullable
    private final String logo;
    @Nullable
    private final String name;
    @Nullable
    private final String nick;
    @Nullable
    private final String phone;
    @Nullable
    private final Long score;
    @NotNull
    private final String socialSuid;
    @Nullable
    private final String socialTuid;
    @Nullable
    private final String source;
    @Nullable
    private final String state;
    @NotNull
    private final String uid;

    public UserProfileData() {
        this((Long) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Long) null, (Long) null, (String) null, (String) null, 8191, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ UserProfileData copy$default(UserProfileData userProfileData, Long l, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Long l2, Long l3, String str9, String str10, int i, Object obj) {
        UserProfileData userProfileData2 = userProfileData;
        int i2 = i;
        return userProfileData.copy((i2 & 1) != 0 ? userProfileData2.id : l, (i2 & 2) != 0 ? userProfileData2.socialSuid : str, (i2 & 4) != 0 ? userProfileData2.socialTuid : str2, (i2 & 8) != 0 ? userProfileData2.uid : str3, (i2 & 16) != 0 ? userProfileData2.name : str4, (i2 & 32) != 0 ? userProfileData2.phone : str5, (i2 & 64) != 0 ? userProfileData2.email : str6, (i2 & 128) != 0 ? userProfileData2.nick : str7, (i2 & 256) != 0 ? userProfileData2.logo : str8, (i2 & 512) != 0 ? userProfileData2.score : l2, (i2 & 1024) != 0 ? userProfileData2.level : l3, (i2 & 2048) != 0 ? userProfileData2.state : str9, (i2 & 4096) != 0 ? userProfileData2.source : str10);
    }

    @Nullable
    public final Long component1() {
        return this.id;
    }

    @Nullable
    public final Long component10() {
        return this.score;
    }

    @Nullable
    public final Long component11() {
        return this.level;
    }

    @Nullable
    public final String component12() {
        return this.state;
    }

    @Nullable
    public final String component13() {
        return this.source;
    }

    @NotNull
    public final String component2() {
        return this.socialSuid;
    }

    @Nullable
    public final String component3() {
        return this.socialTuid;
    }

    @NotNull
    public final String component4() {
        return this.uid;
    }

    @Nullable
    public final String component5() {
        return this.name;
    }

    @Nullable
    public final String component6() {
        return this.phone;
    }

    @Nullable
    public final String component7() {
        return this.email;
    }

    @Nullable
    public final String component8() {
        return this.nick;
    }

    @Nullable
    public final String component9() {
        return this.logo;
    }

    @NotNull
    public final UserProfileData copy(@Nullable Long l, @NotNull String str, @Nullable String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable Long l2, @Nullable Long l3, @Nullable String str9, @Nullable String str10) {
        String str11 = str;
        Intrinsics.checkNotNullParameter(str11, "socialSuid");
        String str12 = str3;
        Intrinsics.checkNotNullParameter(str12, Oauth2AccessToken.KEY_UID);
        return new UserProfileData(l, str11, str2, str12, str4, str5, str6, str7, str8, l2, l3, str9, str10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserProfileData)) {
            return false;
        }
        UserProfileData userProfileData = (UserProfileData) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) userProfileData.id) && Intrinsics.areEqual((Object) this.socialSuid, (Object) userProfileData.socialSuid) && Intrinsics.areEqual((Object) this.socialTuid, (Object) userProfileData.socialTuid) && Intrinsics.areEqual((Object) this.uid, (Object) userProfileData.uid) && Intrinsics.areEqual((Object) this.name, (Object) userProfileData.name) && Intrinsics.areEqual((Object) this.phone, (Object) userProfileData.phone) && Intrinsics.areEqual((Object) this.email, (Object) userProfileData.email) && Intrinsics.areEqual((Object) this.nick, (Object) userProfileData.nick) && Intrinsics.areEqual((Object) this.logo, (Object) userProfileData.logo) && Intrinsics.areEqual((Object) this.score, (Object) userProfileData.score) && Intrinsics.areEqual((Object) this.level, (Object) userProfileData.level) && Intrinsics.areEqual((Object) this.state, (Object) userProfileData.state) && Intrinsics.areEqual((Object) this.source, (Object) userProfileData.source);
    }

    @Nullable
    public final String getEmail() {
        return this.email;
    }

    @Nullable
    public final Long getId() {
        return this.id;
    }

    @Nullable
    public final Long getLevel() {
        return this.level;
    }

    @Nullable
    public final String getLogo() {
        return this.logo;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getNick() {
        return this.nick;
    }

    @Nullable
    public final String getPhone() {
        return this.phone;
    }

    @Nullable
    public final Long getScore() {
        return this.score;
    }

    @NotNull
    public final String getSocialSuid() {
        return this.socialSuid;
    }

    @Nullable
    public final String getSocialTuid() {
        return this.socialTuid;
    }

    @Nullable
    public final String getSource() {
        return this.source;
    }

    @Nullable
    public final String getState() {
        return this.state;
    }

    @NotNull
    public final String getUid() {
        return this.uid;
    }

    public int hashCode() {
        Long l = this.id;
        int i = 0;
        int hashCode = (((l == null ? 0 : l.hashCode()) * 31) + this.socialSuid.hashCode()) * 31;
        String str = this.socialTuid;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.uid.hashCode()) * 31;
        String str2 = this.name;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.phone;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.email;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.nick;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.logo;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Long l2 = this.score;
        int hashCode8 = (hashCode7 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Long l3 = this.level;
        int hashCode9 = (hashCode8 + (l3 == null ? 0 : l3.hashCode())) * 31;
        String str7 = this.state;
        int hashCode10 = (hashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.source;
        if (str8 != null) {
            i = str8.hashCode();
        }
        return hashCode10 + i;
    }

    @NotNull
    public String toString() {
        Long l = this.id;
        String str = this.socialSuid;
        String str2 = this.socialTuid;
        String str3 = this.uid;
        String str4 = this.name;
        String str5 = this.phone;
        String str6 = this.email;
        String str7 = this.nick;
        String str8 = this.logo;
        Long l2 = this.score;
        Long l3 = this.level;
        String str9 = this.state;
        String str10 = this.source;
        return "UserProfileData(id=" + l + ", socialSuid=" + str + ", socialTuid=" + str2 + ", uid=" + str3 + ", name=" + str4 + ", phone=" + str5 + ", email=" + str6 + ", nick=" + str7 + ", logo=" + str8 + ", score=" + l2 + ", level=" + l3 + ", state=" + str9 + ", source=" + str10 + ")";
    }

    public UserProfileData(@Nullable Long l, @NotNull String str, @Nullable String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable Long l2, @Nullable Long l3, @Nullable String str9, @Nullable String str10) {
        Intrinsics.checkNotNullParameter(str, "socialSuid");
        Intrinsics.checkNotNullParameter(str3, Oauth2AccessToken.KEY_UID);
        this.id = l;
        this.socialSuid = str;
        this.socialTuid = str2;
        this.uid = str3;
        this.name = str4;
        this.phone = str5;
        this.email = str6;
        this.nick = str7;
        this.logo = str8;
        this.score = l2;
        this.level = l3;
        this.state = str9;
        this.source = str10;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ UserProfileData(java.lang.Long r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.Long r24, java.lang.Long r25, java.lang.String r26, java.lang.String r27, int r28, kotlin.jvm.internal.DefaultConstructorMarker r29) {
        /*
            r14 = this;
            r0 = r28
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r15
        L_0x000a:
            r3 = r0 & 2
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x0012
            r3 = r4
            goto L_0x0014
        L_0x0012:
            r3 = r16
        L_0x0014:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x001a
            r5 = r2
            goto L_0x001c
        L_0x001a:
            r5 = r17
        L_0x001c:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0021
            goto L_0x0023
        L_0x0021:
            r4 = r18
        L_0x0023:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0029
            r6 = r2
            goto L_0x002b
        L_0x0029:
            r6 = r19
        L_0x002b:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0031
            r7 = r2
            goto L_0x0033
        L_0x0031:
            r7 = r20
        L_0x0033:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0039
            r8 = r2
            goto L_0x003b
        L_0x0039:
            r8 = r21
        L_0x003b:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0041
            r9 = r2
            goto L_0x0043
        L_0x0041:
            r9 = r22
        L_0x0043:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0049
            r10 = r2
            goto L_0x004b
        L_0x0049:
            r10 = r23
        L_0x004b:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0051
            r11 = r2
            goto L_0x0053
        L_0x0051:
            r11 = r24
        L_0x0053:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0059
            r12 = r2
            goto L_0x005b
        L_0x0059:
            r12 = r25
        L_0x005b:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0061
            r13 = r2
            goto L_0x0063
        L_0x0061:
            r13 = r26
        L_0x0063:
            r0 = r0 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x0068
            goto L_0x006a
        L_0x0068:
            r2 = r27
        L_0x006a:
            r15 = r1
            r16 = r3
            r17 = r5
            r18 = r4
            r19 = r6
            r20 = r7
            r21 = r8
            r22 = r9
            r23 = r10
            r24 = r11
            r25 = r12
            r26 = r13
            r27 = r2
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjmz.myvu.account.UserProfileData.<init>(java.lang.Long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Long, java.lang.Long, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
