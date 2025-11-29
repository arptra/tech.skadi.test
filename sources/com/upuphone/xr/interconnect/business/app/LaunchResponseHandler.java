package com.upuphone.xr.interconnect.business.app;

import com.upuphone.xr.interconnect.api.OpenRemoteStarryNetAppCallback;
import com.upuphone.xr.interconnect.entity.Function;
import com.upuphone.xr.interconnect.entity.LaunchAppParam;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.main.handler.MessageHandler;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/upuphone/xr/interconnect/business/app/LaunchResponseHandler;", "Lcom/upuphone/xr/interconnect/main/handler/MessageHandler;", "callbackMap", "", "", "Lcom/upuphone/xr/interconnect/api/OpenRemoteStarryNetAppCallback;", "(Ljava/util/Map;)V", "getHandleType", "", "handle", "", "message", "Lcom/upuphone/xr/interconnect/entity/StarryNetMessage;", "function", "Lcom/upuphone/xr/interconnect/entity/Function;", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LaunchResponseHandler implements MessageHandler {
    @NotNull
    private final Map<String, OpenRemoteStarryNetAppCallback> callbackMap;

    public LaunchResponseHandler(@NotNull Map<String, OpenRemoteStarryNetAppCallback> map) {
        Intrinsics.checkNotNullParameter(map, "callbackMap");
        this.callbackMap = map;
    }

    public int getHandleType() {
        return 12;
    }

    public void handle(@Nullable StarryNetMessage starryNetMessage, @NotNull Function function) {
        Intrinsics.checkNotNullParameter(function, "function");
        LaunchAppParam launchAppParam = (LaunchAppParam) function.parseData(LaunchAppParam.class);
        OpenRemoteStarryNetAppCallback remove = this.callbackMap.remove(launchAppParam.getRequestId());
        if (remove != null) {
            if (launchAppParam.isSuccess()) {
                remove.onSuccess();
                return;
            }
            int code = launchAppParam.getCode();
            if (code == 200) {
                remove.onSuccess();
            } else {
                remove.onFail(code);
            }
        }
    }
}
