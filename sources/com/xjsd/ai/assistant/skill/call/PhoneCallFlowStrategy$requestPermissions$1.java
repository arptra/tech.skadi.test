package com.xjsd.ai.assistant.skill.call;

import com.upuphone.xr.interconnect.common.IPermissonResult;
import com.upuphone.xr.interconnect.entity.PermissionResult;
import com.xjsd.ai.assistant.log.ILog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/xjsd/ai/assistant/skill/call/PhoneCallFlowStrategy$requestPermissions$1", "Lcom/upuphone/xr/interconnect/common/IPermissonResult$Stub;", "permissonResult", "", "result", "Lcom/upuphone/xr/interconnect/entity/PermissionResult;", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PhoneCallFlowStrategy$requestPermissions$1 extends IPermissonResult.Stub {
    public void permissonResult(@NotNull PermissionResult permissionResult) {
        Intrinsics.checkNotNullParameter(permissionResult, "result");
        ILog.a("PhoneCallFlowStrategy", "requestPermission result->" + permissionResult);
    }
}
