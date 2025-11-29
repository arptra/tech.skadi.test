package com.upuphone.xr.interconnect.business.databinder;

import com.upuphone.xr.interconnect.common.IDataBinder;
import com.upuphone.xr.interconnect.entity.Function;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.main.handler.MessageHandler;
import com.upuphone.xr.interconnect.util.log.ILog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"com/upuphone/xr/interconnect/business/databinder/DataBinderManager$requestHandler$1", "Lcom/upuphone/xr/interconnect/main/handler/MessageHandler;", "getHandleType", "", "handle", "", "message", "Lcom/upuphone/xr/interconnect/entity/StarryNetMessage;", "function", "Lcom/upuphone/xr/interconnect/entity/Function;", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DataBinderManager$requestHandler$1 implements MessageHandler {
    final /* synthetic */ DataBinderManager this$0;

    public DataBinderManager$requestHandler$1(DataBinderManager dataBinderManager) {
        this.this$0 = dataBinderManager;
    }

    public int getHandleType() {
        return 16;
    }

    public void handle(@Nullable StarryNetMessage starryNetMessage, @Nullable Function function) {
        String connectedDeviceId = EnvironmentExtKt.getConnectedDeviceId();
        if (connectedDeviceId != null) {
            ILog.d(IDataBinder.TAG, "Responding request for all data to be updated to " + connectedDeviceId + ".");
            this.this$0.updateAllData(connectedDeviceId);
        }
    }
}
