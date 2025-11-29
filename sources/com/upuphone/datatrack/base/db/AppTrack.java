package com.upuphone.datatrack.base.db;

import androidx.annotation.Keep;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.upuphone.starrynet.payload.PayloadConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sdk.meizu.account.factor.authentication.sdk.constant.ConstantKt;

@Keep
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000  2\u00020\u0001:\u0001 B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003JI\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006!"}, d2 = {"Lcom/upuphone/datatrack/base/db/AppTrack;", "", "id", "", "packageName", "", "name", "msg", "iotDeviceId", "iotDeviceRom", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()J", "getIotDeviceId", "()Ljava/lang/String;", "getIotDeviceRom", "getMsg", "getName", "getPackageName", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "datatrack-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Entity
public final class AppTrack {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @PrimaryKey
    private final long id;
    @Nullable
    private final String iotDeviceId;
    @Nullable
    private final String iotDeviceRom;
    @NotNull
    private final String msg;
    @NotNull
    private final String name;
    @NotNull
    private final String packageName;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J;\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/upuphone/datatrack/base/db/AppTrack$Companion;", "", "<init>", "()V", "", "packageName", "name", "msg", "iotDeviceId", "iotDeviceRom", "Lcom/upuphone/datatrack/base/db/AppTrack;", "a", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/upuphone/datatrack/base/db/AppTrack;", "datatrack-base_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AppTrack a(String str, String str2, String str3, String str4, String str5) {
            Intrinsics.checkNotNullParameter(str, ConstantKt.FACTOR_PARAMS_PACKAGE_NAME);
            Intrinsics.checkNotNullParameter(str2, "name");
            Intrinsics.checkNotNullParameter(str3, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
            return new AppTrack(0, str, str2, str3, str4, str5);
        }

        public Companion() {
        }
    }

    public AppTrack(long j, @NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5) {
        Intrinsics.checkNotNullParameter(str, ConstantKt.FACTOR_PARAMS_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        this.id = j;
        this.packageName = str;
        this.name = str2;
        this.msg = str3;
        this.iotDeviceId = str4;
        this.iotDeviceRom = str5;
    }

    public static /* synthetic */ AppTrack copy$default(AppTrack appTrack, long j, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        AppTrack appTrack2 = appTrack;
        return appTrack.copy((i & 1) != 0 ? appTrack2.id : j, (i & 2) != 0 ? appTrack2.packageName : str, (i & 4) != 0 ? appTrack2.name : str2, (i & 8) != 0 ? appTrack2.msg : str3, (i & 16) != 0 ? appTrack2.iotDeviceId : str4, (i & 32) != 0 ? appTrack2.iotDeviceRom : str5);
    }

    @JvmStatic
    @NotNull
    public static final AppTrack newInstance(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5) {
        return Companion.a(str, str2, str3, str4, str5);
    }

    public final long component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.packageName;
    }

    @NotNull
    public final String component3() {
        return this.name;
    }

    @NotNull
    public final String component4() {
        return this.msg;
    }

    @Nullable
    public final String component5() {
        return this.iotDeviceId;
    }

    @Nullable
    public final String component6() {
        return this.iotDeviceRom;
    }

    @NotNull
    public final AppTrack copy(long j, @NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5) {
        Intrinsics.checkNotNullParameter(str, ConstantKt.FACTOR_PARAMS_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        return new AppTrack(j, str, str2, str3, str4, str5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppTrack)) {
            return false;
        }
        AppTrack appTrack = (AppTrack) obj;
        return this.id == appTrack.id && Intrinsics.areEqual((Object) this.packageName, (Object) appTrack.packageName) && Intrinsics.areEqual((Object) this.name, (Object) appTrack.name) && Intrinsics.areEqual((Object) this.msg, (Object) appTrack.msg) && Intrinsics.areEqual((Object) this.iotDeviceId, (Object) appTrack.iotDeviceId) && Intrinsics.areEqual((Object) this.iotDeviceRom, (Object) appTrack.iotDeviceRom);
    }

    public final long getId() {
        return this.id;
    }

    @Nullable
    public final String getIotDeviceId() {
        return this.iotDeviceId;
    }

    @Nullable
    public final String getIotDeviceRom() {
        return this.iotDeviceRom;
    }

    @NotNull
    public final String getMsg() {
        return this.msg;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getPackageName() {
        return this.packageName;
    }

    public int hashCode() {
        int hashCode = ((((((Long.hashCode(this.id) * 31) + this.packageName.hashCode()) * 31) + this.name.hashCode()) * 31) + this.msg.hashCode()) * 31;
        String str = this.iotDeviceId;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.iotDeviceRom;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        return "AppTrack(id=" + this.id + ", packageName=" + this.packageName + ", name=" + this.name + ", msg=" + this.msg + ", iotDeviceId=" + this.iotDeviceId + ", iotDeviceRom=" + this.iotDeviceRom + ')';
    }
}
