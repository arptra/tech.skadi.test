package com.honey.account.data;

import com.google.android.gms.common.Scopes;
import com.upuphone.xr.sapp.contract.ProtocolCategory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001b\b\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0002\u0010\u000eJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003J\t\u0010\u001f\u001a\u00020\u000bHÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003Jc\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\"\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0013R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0013R\u0011\u0010\r\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006&"}, d2 = {"Lcom/honey/account/data/AccountData;", "", "userId", "", "email", "", "flyme", "icon", "nickname", "phone", "isAnswerEnable", "", "isDefaultIcon", "isSelfSetPassword", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZ)V", "getEmail", "()Ljava/lang/String;", "getFlyme", "getIcon", "()Z", "getNickname", "getPhone", "getUserId", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AccountData {
    @NotNull
    private final String email;
    @NotNull

    /* renamed from: flyme  reason: collision with root package name */
    private final String f9187flyme;
    @NotNull
    private final String icon;
    private final boolean isAnswerEnable;
    private final boolean isDefaultIcon;
    private final boolean isSelfSetPassword;
    @NotNull
    private final String nickname;
    @NotNull
    private final String phone;
    private final int userId;

    public AccountData(int i, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(str, Scopes.EMAIL);
        Intrinsics.checkNotNullParameter(str2, ProtocolCategory.FLYME);
        Intrinsics.checkNotNullParameter(str3, "icon");
        Intrinsics.checkNotNullParameter(str4, "nickname");
        Intrinsics.checkNotNullParameter(str5, "phone");
        this.userId = i;
        this.email = str;
        this.f9187flyme = str2;
        this.icon = str3;
        this.nickname = str4;
        this.phone = str5;
        this.isAnswerEnable = z;
        this.isDefaultIcon = z2;
        this.isSelfSetPassword = z3;
    }

    public static /* synthetic */ AccountData copy$default(AccountData accountData, int i, String str, String str2, String str3, String str4, String str5, boolean z, boolean z2, boolean z3, int i2, Object obj) {
        AccountData accountData2 = accountData;
        int i3 = i2;
        return accountData.copy((i3 & 1) != 0 ? accountData2.userId : i, (i3 & 2) != 0 ? accountData2.email : str, (i3 & 4) != 0 ? accountData2.f9187flyme : str2, (i3 & 8) != 0 ? accountData2.icon : str3, (i3 & 16) != 0 ? accountData2.nickname : str4, (i3 & 32) != 0 ? accountData2.phone : str5, (i3 & 64) != 0 ? accountData2.isAnswerEnable : z, (i3 & 128) != 0 ? accountData2.isDefaultIcon : z2, (i3 & 256) != 0 ? accountData2.isSelfSetPassword : z3);
    }

    public final int component1() {
        return this.userId;
    }

    @NotNull
    public final String component2() {
        return this.email;
    }

    @NotNull
    public final String component3() {
        return this.f9187flyme;
    }

    @NotNull
    public final String component4() {
        return this.icon;
    }

    @NotNull
    public final String component5() {
        return this.nickname;
    }

    @NotNull
    public final String component6() {
        return this.phone;
    }

    public final boolean component7() {
        return this.isAnswerEnable;
    }

    public final boolean component8() {
        return this.isDefaultIcon;
    }

    public final boolean component9() {
        return this.isSelfSetPassword;
    }

    @NotNull
    public final AccountData copy(int i, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(str, Scopes.EMAIL);
        Intrinsics.checkNotNullParameter(str2, ProtocolCategory.FLYME);
        Intrinsics.checkNotNullParameter(str3, "icon");
        String str6 = str4;
        Intrinsics.checkNotNullParameter(str6, "nickname");
        String str7 = str5;
        Intrinsics.checkNotNullParameter(str7, "phone");
        return new AccountData(i, str, str2, str3, str6, str7, z, z2, z3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccountData)) {
            return false;
        }
        AccountData accountData = (AccountData) obj;
        return this.userId == accountData.userId && Intrinsics.areEqual((Object) this.email, (Object) accountData.email) && Intrinsics.areEqual((Object) this.f9187flyme, (Object) accountData.f9187flyme) && Intrinsics.areEqual((Object) this.icon, (Object) accountData.icon) && Intrinsics.areEqual((Object) this.nickname, (Object) accountData.nickname) && Intrinsics.areEqual((Object) this.phone, (Object) accountData.phone) && this.isAnswerEnable == accountData.isAnswerEnable && this.isDefaultIcon == accountData.isDefaultIcon && this.isSelfSetPassword == accountData.isSelfSetPassword;
    }

    @NotNull
    public final String getEmail() {
        return this.email;
    }

    @NotNull
    public final String getFlyme() {
        return this.f9187flyme;
    }

    @NotNull
    public final String getIcon() {
        return this.icon;
    }

    @NotNull
    public final String getNickname() {
        return this.nickname;
    }

    @NotNull
    public final String getPhone() {
        return this.phone;
    }

    public final int getUserId() {
        return this.userId;
    }

    public int hashCode() {
        int hashCode = ((((((((((Integer.hashCode(this.userId) * 31) + this.email.hashCode()) * 31) + this.f9187flyme.hashCode()) * 31) + this.icon.hashCode()) * 31) + this.nickname.hashCode()) * 31) + this.phone.hashCode()) * 31;
        boolean z = this.isAnswerEnable;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (hashCode + (z ? 1 : 0)) * 31;
        boolean z3 = this.isDefaultIcon;
        if (z3) {
            z3 = true;
        }
        int i2 = (i + (z3 ? 1 : 0)) * 31;
        boolean z4 = this.isSelfSetPassword;
        if (!z4) {
            z2 = z4;
        }
        return i2 + (z2 ? 1 : 0);
    }

    public final boolean isAnswerEnable() {
        return this.isAnswerEnable;
    }

    public final boolean isDefaultIcon() {
        return this.isDefaultIcon;
    }

    public final boolean isSelfSetPassword() {
        return this.isSelfSetPassword;
    }

    @NotNull
    public String toString() {
        return "AccountData(userId=" + this.userId + ", email=" + this.email + ", flyme=" + this.f9187flyme + ", icon=" + this.icon + ", nickname=" + this.nickname + ", phone=" + this.phone + ", isAnswerEnable=" + this.isAnswerEnable + ", isDefaultIcon=" + this.isDefaultIcon + ", isSelfSetPassword=" + this.isSelfSetPassword + ')';
    }
}
