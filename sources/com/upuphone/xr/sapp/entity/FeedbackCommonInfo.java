package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J1\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0011¨\u0006 "}, d2 = {"Lcom/upuphone/xr/sapp/entity/FeedbackCommonInfo;", "", "isSelect", "", "icon", "", "name", "", "id", "(ZILjava/lang/String;Ljava/lang/String;)V", "getIcon", "()I", "setIcon", "(I)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "()Z", "setSelect", "(Z)V", "getName", "setName", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class FeedbackCommonInfo {
    private int icon;
    @NotNull
    private String id;
    private boolean isSelect;
    @NotNull
    private String name;

    public FeedbackCommonInfo(boolean z, int i, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "id");
        this.isSelect = z;
        this.icon = i;
        this.name = str;
        this.id = str2;
    }

    public static /* synthetic */ FeedbackCommonInfo copy$default(FeedbackCommonInfo feedbackCommonInfo, boolean z, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = feedbackCommonInfo.isSelect;
        }
        if ((i2 & 2) != 0) {
            i = feedbackCommonInfo.icon;
        }
        if ((i2 & 4) != 0) {
            str = feedbackCommonInfo.name;
        }
        if ((i2 & 8) != 0) {
            str2 = feedbackCommonInfo.id;
        }
        return feedbackCommonInfo.copy(z, i, str, str2);
    }

    public final boolean component1() {
        return this.isSelect;
    }

    public final int component2() {
        return this.icon;
    }

    @NotNull
    public final String component3() {
        return this.name;
    }

    @NotNull
    public final String component4() {
        return this.id;
    }

    @NotNull
    public final FeedbackCommonInfo copy(boolean z, int i, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "id");
        return new FeedbackCommonInfo(z, i, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedbackCommonInfo)) {
            return false;
        }
        FeedbackCommonInfo feedbackCommonInfo = (FeedbackCommonInfo) obj;
        return this.isSelect == feedbackCommonInfo.isSelect && this.icon == feedbackCommonInfo.icon && Intrinsics.areEqual((Object) this.name, (Object) feedbackCommonInfo.name) && Intrinsics.areEqual((Object) this.id, (Object) feedbackCommonInfo.id);
    }

    public final int getIcon() {
        return this.icon;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.isSelect) * 31) + Integer.hashCode(this.icon)) * 31) + this.name.hashCode()) * 31) + this.id.hashCode();
    }

    public final boolean isSelect() {
        return this.isSelect;
    }

    public final void setIcon(int i) {
        this.icon = i;
    }

    public final void setId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final void setName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final void setSelect(boolean z) {
        this.isSelect = z;
    }

    @NotNull
    public String toString() {
        boolean z = this.isSelect;
        int i = this.icon;
        String str = this.name;
        String str2 = this.id;
        return "FeedbackCommonInfo(isSelect=" + z + ", icon=" + i + ", name=" + str + ", id=" + str2 + ")";
    }
}
