package com.upuphone.xr.sapp.monitor.notification.model;

import android.graphics.drawable.Drawable;
import androidx.annotation.Keep;
import com.meizu.common.fastscrollletter.FastScrollLetterCursorColumn;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sdk.meizu.account.factor.authentication.sdk.constant.ConstantKt;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b!\b\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\n¢\u0006\u0002\u0010\rJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010#\u001a\u00020\nHÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\nHÆ\u0003JQ\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\nHÆ\u0001J\u0013\u0010'\u001a\u00020\n2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0006HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006+"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/model/AppInfoModel;", "", "name", "", "packageName", "uid", "", "icon", "Landroid/graphics/drawable/Drawable;", "disableState", "", "letter", "mIsHeader", "(Ljava/lang/String;Ljava/lang/String;ILandroid/graphics/drawable/Drawable;ZLjava/lang/String;Z)V", "getDisableState", "()Z", "setDisableState", "(Z)V", "getIcon", "()Landroid/graphics/drawable/Drawable;", "getLetter", "()Ljava/lang/String;", "setLetter", "(Ljava/lang/String;)V", "getMIsHeader", "setMIsHeader", "getName", "setName", "getPackageName", "getUid", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class AppInfoModel {
    private boolean disableState;
    @Nullable
    private final Drawable icon;
    @NotNull
    private String letter;
    private boolean mIsHeader;
    @NotNull
    private String name;
    @NotNull
    private final String packageName;
    private final int uid;

    public AppInfoModel(@NotNull String str, @NotNull String str2, int i, @Nullable Drawable drawable, boolean z, @NotNull String str3, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, ConstantKt.FACTOR_PARAMS_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(str3, FastScrollLetterCursorColumn.LETTER);
        this.name = str;
        this.packageName = str2;
        this.uid = i;
        this.icon = drawable;
        this.disableState = z;
        this.letter = str3;
        this.mIsHeader = z2;
    }

    public static /* synthetic */ AppInfoModel copy$default(AppInfoModel appInfoModel, String str, String str2, int i, Drawable drawable, boolean z, String str3, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = appInfoModel.name;
        }
        if ((i2 & 2) != 0) {
            str2 = appInfoModel.packageName;
        }
        String str4 = str2;
        if ((i2 & 4) != 0) {
            i = appInfoModel.uid;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            drawable = appInfoModel.icon;
        }
        Drawable drawable2 = drawable;
        if ((i2 & 16) != 0) {
            z = appInfoModel.disableState;
        }
        boolean z3 = z;
        if ((i2 & 32) != 0) {
            str3 = appInfoModel.letter;
        }
        String str5 = str3;
        if ((i2 & 64) != 0) {
            z2 = appInfoModel.mIsHeader;
        }
        return appInfoModel.copy(str, str4, i3, drawable2, z3, str5, z2);
    }

    @NotNull
    public final String component1() {
        return this.name;
    }

    @NotNull
    public final String component2() {
        return this.packageName;
    }

    public final int component3() {
        return this.uid;
    }

    @Nullable
    public final Drawable component4() {
        return this.icon;
    }

    public final boolean component5() {
        return this.disableState;
    }

    @NotNull
    public final String component6() {
        return this.letter;
    }

    public final boolean component7() {
        return this.mIsHeader;
    }

    @NotNull
    public final AppInfoModel copy(@NotNull String str, @NotNull String str2, int i, @Nullable Drawable drawable, boolean z, @NotNull String str3, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, ConstantKt.FACTOR_PARAMS_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(str3, FastScrollLetterCursorColumn.LETTER);
        return new AppInfoModel(str, str2, i, drawable, z, str3, z2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppInfoModel)) {
            return false;
        }
        AppInfoModel appInfoModel = (AppInfoModel) obj;
        return Intrinsics.areEqual((Object) this.name, (Object) appInfoModel.name) && Intrinsics.areEqual((Object) this.packageName, (Object) appInfoModel.packageName) && this.uid == appInfoModel.uid && Intrinsics.areEqual((Object) this.icon, (Object) appInfoModel.icon) && this.disableState == appInfoModel.disableState && Intrinsics.areEqual((Object) this.letter, (Object) appInfoModel.letter) && this.mIsHeader == appInfoModel.mIsHeader;
    }

    public final boolean getDisableState() {
        return this.disableState;
    }

    @Nullable
    public final Drawable getIcon() {
        return this.icon;
    }

    @NotNull
    public final String getLetter() {
        return this.letter;
    }

    public final boolean getMIsHeader() {
        return this.mIsHeader;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getPackageName() {
        return this.packageName;
    }

    public final int getUid() {
        return this.uid;
    }

    public int hashCode() {
        int hashCode = ((((this.name.hashCode() * 31) + this.packageName.hashCode()) * 31) + Integer.hashCode(this.uid)) * 31;
        Drawable drawable = this.icon;
        return ((((((hashCode + (drawable == null ? 0 : drawable.hashCode())) * 31) + Boolean.hashCode(this.disableState)) * 31) + this.letter.hashCode()) * 31) + Boolean.hashCode(this.mIsHeader);
    }

    public final void setDisableState(boolean z) {
        this.disableState = z;
    }

    public final void setLetter(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.letter = str;
    }

    public final void setMIsHeader(boolean z) {
        this.mIsHeader = z;
    }

    public final void setName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    @NotNull
    public String toString() {
        String str = this.name;
        String str2 = this.packageName;
        int i = this.uid;
        Drawable drawable = this.icon;
        boolean z = this.disableState;
        String str3 = this.letter;
        boolean z2 = this.mIsHeader;
        return "AppInfoModel(name=" + str + ", packageName=" + str2 + ", uid=" + i + ", icon=" + drawable + ", disableState=" + z + ", letter=" + str3 + ", mIsHeader=" + z2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AppInfoModel(String str, String str2, int i, Drawable drawable, boolean z, String str3, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i, (i2 & 8) != 0 ? null : drawable, (i2 & 16) != 0 ? false : z, (i2 & 32) != 0 ? "" : str3, (i2 & 64) != 0 ? false : z2);
    }
}
