package com.upuphone.xr.sapp.common;

import androidx.annotation.Keep;
import com.upuphone.xr.sapp.context.IAccountInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/upuphone/xr/sapp/common/AccountInfoImpl;", "Lcom/upuphone/xr/sapp/context/IAccountInfo;", "id", "", "mzUid", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getMzUid", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class AccountInfoImpl implements IAccountInfo {
    @NotNull
    private final String id;
    @NotNull
    private final String mzUid;

    public AccountInfoImpl(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "mzUid");
        this.id = str;
        this.mzUid = str2;
    }

    public static /* synthetic */ AccountInfoImpl copy$default(AccountInfoImpl accountInfoImpl, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = accountInfoImpl.id;
        }
        if ((i & 2) != 0) {
            str2 = accountInfoImpl.mzUid;
        }
        return accountInfoImpl.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.mzUid;
    }

    @NotNull
    public final AccountInfoImpl copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "mzUid");
        return new AccountInfoImpl(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccountInfoImpl)) {
            return false;
        }
        AccountInfoImpl accountInfoImpl = (AccountInfoImpl) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) accountInfoImpl.id) && Intrinsics.areEqual((Object) this.mzUid, (Object) accountInfoImpl.mzUid);
    }

    @NotNull
    public String getId() {
        return this.id;
    }

    @NotNull
    public String getMzUid() {
        return this.mzUid;
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + this.mzUid.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.id;
        String str2 = this.mzUid;
        return "AccountInfoImpl(id=" + str + ", mzUid=" + str2 + ")";
    }
}
