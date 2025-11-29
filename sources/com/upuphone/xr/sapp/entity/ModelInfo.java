package com.upuphone.xr.sapp.entity;

import android.graphics.drawable.Drawable;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J3\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006!"}, d2 = {"Lcom/upuphone/xr/sapp/entity/ModelInfo;", "", "logoRes", "Landroid/graphics/drawable/Drawable;", "name", "", "modelID", "Lcom/upuphone/xr/sapp/entity/ModelID;", "showBadge", "", "(Landroid/graphics/drawable/Drawable;Ljava/lang/String;Lcom/upuphone/xr/sapp/entity/ModelID;Z)V", "getLogoRes", "()Landroid/graphics/drawable/Drawable;", "getModelID", "()Lcom/upuphone/xr/sapp/entity/ModelID;", "setModelID", "(Lcom/upuphone/xr/sapp/entity/ModelID;)V", "getName", "()Ljava/lang/String;", "getShowBadge", "()Z", "setShowBadge", "(Z)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class ModelInfo {
    @Nullable
    private final Drawable logoRes;
    @NotNull
    private ModelID modelID;
    @NotNull
    private final String name;
    private boolean showBadge;

    public ModelInfo(@Nullable Drawable drawable, @NotNull String str, @NotNull ModelID modelID2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(modelID2, "modelID");
        this.logoRes = drawable;
        this.name = str;
        this.modelID = modelID2;
        this.showBadge = z;
    }

    public static /* synthetic */ ModelInfo copy$default(ModelInfo modelInfo, Drawable drawable, String str, ModelID modelID2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            drawable = modelInfo.logoRes;
        }
        if ((i & 2) != 0) {
            str = modelInfo.name;
        }
        if ((i & 4) != 0) {
            modelID2 = modelInfo.modelID;
        }
        if ((i & 8) != 0) {
            z = modelInfo.showBadge;
        }
        return modelInfo.copy(drawable, str, modelID2, z);
    }

    @Nullable
    public final Drawable component1() {
        return this.logoRes;
    }

    @NotNull
    public final String component2() {
        return this.name;
    }

    @NotNull
    public final ModelID component3() {
        return this.modelID;
    }

    public final boolean component4() {
        return this.showBadge;
    }

    @NotNull
    public final ModelInfo copy(@Nullable Drawable drawable, @NotNull String str, @NotNull ModelID modelID2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(modelID2, "modelID");
        return new ModelInfo(drawable, str, modelID2, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ModelInfo)) {
            return false;
        }
        ModelInfo modelInfo = (ModelInfo) obj;
        return Intrinsics.areEqual((Object) this.logoRes, (Object) modelInfo.logoRes) && Intrinsics.areEqual((Object) this.name, (Object) modelInfo.name) && this.modelID == modelInfo.modelID && this.showBadge == modelInfo.showBadge;
    }

    @Nullable
    public final Drawable getLogoRes() {
        return this.logoRes;
    }

    @NotNull
    public final ModelID getModelID() {
        return this.modelID;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final boolean getShowBadge() {
        return this.showBadge;
    }

    public int hashCode() {
        Drawable drawable = this.logoRes;
        return ((((((drawable == null ? 0 : drawable.hashCode()) * 31) + this.name.hashCode()) * 31) + this.modelID.hashCode()) * 31) + Boolean.hashCode(this.showBadge);
    }

    public final void setModelID(@NotNull ModelID modelID2) {
        Intrinsics.checkNotNullParameter(modelID2, "<set-?>");
        this.modelID = modelID2;
    }

    public final void setShowBadge(boolean z) {
        this.showBadge = z;
    }

    @NotNull
    public String toString() {
        Drawable drawable = this.logoRes;
        String str = this.name;
        ModelID modelID2 = this.modelID;
        boolean z = this.showBadge;
        return "ModelInfo(logoRes=" + drawable + ", name=" + str + ", modelID=" + modelID2 + ", showBadge=" + z + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ModelInfo(Drawable drawable, String str, ModelID modelID2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(drawable, str, (i & 4) != 0 ? ModelID.NOTDISTURB : modelID2, (i & 8) != 0 ? false : z);
    }
}
