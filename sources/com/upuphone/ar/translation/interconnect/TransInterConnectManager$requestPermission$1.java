package com.upuphone.ar.translation.interconnect;

import com.upuphone.xr.interconnect.common.IPermissonResult;
import com.upuphone.xr.interconnect.entity.PermissionResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/upuphone/ar/translation/interconnect/TransInterConnectManager$requestPermission$1", "Lcom/upuphone/xr/interconnect/common/IPermissonResult$Stub;", "Lcom/upuphone/xr/interconnect/entity/PermissionResult;", "result", "", "permissonResult", "(Lcom/upuphone/xr/interconnect/entity/PermissionResult;)V", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TransInterConnectManager$requestPermission$1 extends IPermissonResult.Stub {
    final /* synthetic */ Function1<Boolean, Unit> $callback;

    public TransInterConnectManager$requestPermission$1(Function1<? super Boolean, Unit> function1) {
        this.$callback = function1;
    }

    public void permissonResult(@Nullable PermissionResult permissionResult) {
        this.$callback.invoke(Boolean.valueOf(permissionResult != null ? permissionResult.isResult() : false));
    }
}
