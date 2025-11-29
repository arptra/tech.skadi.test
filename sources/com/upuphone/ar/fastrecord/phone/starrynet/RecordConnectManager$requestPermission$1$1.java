package com.upuphone.ar.fastrecord.phone.starrynet;

import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.xr.interconnect.common.IPermissonResult;
import com.upuphone.xr.interconnect.entity.PermissionResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/upuphone/ar/fastrecord/phone/starrynet/RecordConnectManager$requestPermission$1$1", "Lcom/upuphone/xr/interconnect/common/IPermissonResult$Stub;", "permissonResult", "", "permissionResult", "Lcom/upuphone/xr/interconnect/entity/PermissionResult;", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RecordConnectManager$requestPermission$1$1 extends IPermissonResult.Stub {
    public void permissonResult(@NotNull PermissionResult permissionResult) {
        Intrinsics.checkNotNullParameter(permissionResult, "permissionResult");
        int size = permissionResult.getDeniedPermissionList().size();
        for (int i = 0; i < size; i++) {
            LogExt.logE("requestPermission permission[" + i + "]=" + permissionResult.getDeniedPermissionList().get(i), "FastRecordInterConnectHelper");
        }
    }
}
