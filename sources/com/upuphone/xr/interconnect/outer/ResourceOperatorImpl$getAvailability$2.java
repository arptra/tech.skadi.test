package com.upuphone.xr.interconnect.outer;

import com.upuphone.xr.interconnect.common.IResourceManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001*\n \u0003*\u0004\u0018\u00010\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "Lcom/upuphone/xr/interconnect/common/IResourceManager;", "kotlin.jvm.PlatformType", "invoke", "(Lcom/upuphone/xr/interconnect/common/IResourceManager;)Ljava/lang/Byte;"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class ResourceOperatorImpl$getAvailability$2 extends Lambda implements Function1<IResourceManager, Byte> {
    final /* synthetic */ String $deviceId;
    final /* synthetic */ String $identifier;
    final /* synthetic */ byte $type;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ResourceOperatorImpl$getAvailability$2(String str, byte b, String str2) {
        super(1);
        this.$deviceId = str;
        this.$type = b;
        this.$identifier = str2;
    }

    @NotNull
    public final Byte invoke(IResourceManager iResourceManager) {
        return Byte.valueOf(iResourceManager.getAvailability(this.$deviceId, this.$type, this.$identifier));
    }
}
