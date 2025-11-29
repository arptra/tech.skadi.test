package com.upuphone.xr.interconnect.resource;

import com.upuphone.xr.interconnect.entity.ResourceDescription;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/upuphone/xr/interconnect/resource/ResourceOpenInfo;", "", "resource", "Lcom/upuphone/xr/interconnect/entity/ResourceDescription;", "(Lcom/upuphone/xr/interconnect/entity/ResourceDescription;)V", "getResource", "()Lcom/upuphone/xr/interconnect/entity/ResourceDescription;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ResourceOpenInfo {
    @NotNull
    private final ResourceDescription resource;

    public ResourceOpenInfo(@NotNull ResourceDescription resourceDescription) {
        Intrinsics.checkNotNullParameter(resourceDescription, "resource");
        this.resource = resourceDescription;
    }

    public static /* synthetic */ ResourceOpenInfo copy$default(ResourceOpenInfo resourceOpenInfo, ResourceDescription resourceDescription, int i, Object obj) {
        if ((i & 1) != 0) {
            resourceDescription = resourceOpenInfo.resource;
        }
        return resourceOpenInfo.copy(resourceDescription);
    }

    @NotNull
    public final ResourceDescription component1() {
        return this.resource;
    }

    @NotNull
    public final ResourceOpenInfo copy(@NotNull ResourceDescription resourceDescription) {
        Intrinsics.checkNotNullParameter(resourceDescription, "resource");
        return new ResourceOpenInfo(resourceDescription);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ResourceOpenInfo) && Intrinsics.areEqual((Object) this.resource, (Object) ((ResourceOpenInfo) obj).resource);
    }

    @NotNull
    public final ResourceDescription getResource() {
        return this.resource;
    }

    public int hashCode() {
        return this.resource.hashCode();
    }

    @NotNull
    public String toString() {
        ResourceDescription resourceDescription = this.resource;
        return "ResourceOpenInfo(resource=" + resourceDescription + ")";
    }
}
