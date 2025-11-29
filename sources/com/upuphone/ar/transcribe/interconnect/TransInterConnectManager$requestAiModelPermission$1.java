package com.upuphone.ar.transcribe.interconnect;

import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.xr.interconnect.common.IPermissonResult;
import com.upuphone.xr.interconnect.entity.PermissionResult;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/upuphone/ar/transcribe/interconnect/TransInterConnectManager$requestAiModelPermission$1", "Lcom/upuphone/xr/interconnect/common/IPermissonResult$Stub;", "permissonResult", "", "result", "Lcom/upuphone/xr/interconnect/entity/PermissionResult;", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TransInterConnectManager$requestAiModelPermission$1 extends IPermissonResult.Stub {
    public void permissonResult(@Nullable PermissionResult permissionResult) {
        if (permissionResult != null) {
            boolean isResult = permissionResult.isResult();
            LogExt.g("requestAiModelPermission result=" + isResult, "TranscribeConnectManager");
        }
    }
}
