package com.honey.account.sysconfig.data;

import android.database.Cursor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/honey/account/sysconfig/data/SysConfigData;", "", "countryInit", "", "(Z)V", "getCountryInit", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "Companion", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SysConfigData {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final boolean countryInit;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/honey/account/sysconfig/data/SysConfigData$Companion;", "", "()V", "parse", "Lcom/honey/account/sysconfig/data/SysConfigData;", "cursor", "Landroid/database/Cursor;", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final SysConfigData parse(@NotNull Cursor cursor) {
            Intrinsics.checkNotNullParameter(cursor, "cursor");
            if (!cursor.moveToFirst()) {
                return null;
            }
            boolean z = false;
            if (cursor.getInt(0) == 1) {
                z = true;
            }
            return new SysConfigData(z);
        }

        private Companion() {
        }
    }

    public SysConfigData(boolean z) {
        this.countryInit = z;
    }

    public static /* synthetic */ SysConfigData copy$default(SysConfigData sysConfigData, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = sysConfigData.countryInit;
        }
        return sysConfigData.copy(z);
    }

    public final boolean component1() {
        return this.countryInit;
    }

    @NotNull
    public final SysConfigData copy(boolean z) {
        return new SysConfigData(z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SysConfigData) && this.countryInit == ((SysConfigData) obj).countryInit;
    }

    public final boolean getCountryInit() {
        return this.countryInit;
    }

    public int hashCode() {
        boolean z = this.countryInit;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    @NotNull
    public String toString() {
        return "SysConfigData(countryInit=" + this.countryInit + ')';
    }
}
