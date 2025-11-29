package com.upuphone.xr.interconnect.resource;

import com.upuphone.runasone.constant.Constants;
import com.upuphone.xr.interconnect.api.DataBinderOperator;
import com.upuphone.xr.interconnect.api.DataBinderSlice;
import com.upuphone.xr.interconnect.common.IResourceManager;
import com.upuphone.xr.interconnect.entity.Function;
import com.upuphone.xr.interconnect.entity.ResourceDescription;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.main.handler.MessageHandler;
import com.upuphone.xr.interconnect.task.TaskManager;
import com.upuphone.xr.interconnect.util.DeviceExtKt;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u0010\u0011\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u000eJ\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u001c\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J(\u0010\u001d\u001a\u00020\u00182\b\u0010\u001e\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u000eJ\u0016\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u000eJ\u001e\u0010!\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020#R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/upuphone/xr/interconnect/resource/ResourceManager;", "Lcom/upuphone/xr/interconnect/main/handler/MessageHandler;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "dataBinderOperator", "Lcom/upuphone/xr/interconnect/api/DataBinderOperator;", "taskManager", "Lcom/upuphone/xr/interconnect/task/TaskManager;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lcom/upuphone/xr/interconnect/api/DataBinderOperator;Lcom/upuphone/xr/interconnect/task/TaskManager;)V", "dataSlice", "Lcom/upuphone/xr/interconnect/api/DataBinderSlice;", "openerMap", "", "", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getAvailability", "deviceId", "type", "identifier", "getHandleType", "", "handle", "", "message", "Lcom/upuphone/xr/interconnect/entity/StarryNetMessage;", "function", "Lcom/upuphone/xr/interconnect/entity/Function;", "openResource", "targetDeviceId", "registerOpener", "name", "setAvailability", "available", "", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ResourceManager implements MessageHandler {
    @NotNull
    private final DataBinderSlice dataSlice;
    @NotNull
    private final Map<Byte, String> openerMap = new ConcurrentHashMap();
    @NotNull
    private final CoroutineScope scope;
    @NotNull
    private final TaskManager taskManager;

    public ResourceManager(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull DataBinderOperator dataBinderOperator, @NotNull TaskManager taskManager2) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(dataBinderOperator, "dataBinderOperator");
        Intrinsics.checkNotNullParameter(taskManager2, "taskManager");
        this.taskManager = taskManager2;
        this.scope = CoroutineScopeKt.a(SupervisorKt.b((Job) null, 1, (Object) null).plus(coroutineDispatcher));
        this.dataSlice = dataBinderOperator.getSlice("resources");
    }

    public final byte getAvailability(@Nullable String str, byte b, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str2, "identifier");
        ILog.d(IResourceManager.TAG, "Checking availability, dev=" + str + " type=" + b + " id=" + str2 + ".");
        Boolean bool = this.dataSlice.getBoolean(DeviceExtKt.getDataBinderDeviceId(str), String.valueOf(b), str2);
        if (Intrinsics.areEqual((Object) bool, (Object) Boolean.TRUE)) {
            return 1;
        }
        if (Intrinsics.areEqual((Object) bool, (Object) Boolean.FALSE)) {
            return 0;
        }
        if (bool == null) {
            return -1;
        }
        throw new NoWhenBranchMatchedException();
    }

    public int getHandleType() {
        return 17;
    }

    public void handle(@Nullable StarryNetMessage starryNetMessage, @Nullable Function function) {
        ILog.d(IResourceManager.TAG, "Handling resource open request from remote device: " + starryNetMessage + " / " + function);
        if (function != null && starryNetMessage != null) {
            ResourceOpenInfo resourceOpenInfo = (ResourceOpenInfo) function.parseData(ResourceOpenInfo.class);
            String str = this.openerMap.get(Byte.valueOf(resourceOpenInfo.getResource().type));
            if (str != null) {
                this.taskManager.execute((String) null, str, resourceOpenInfo.getResource());
            }
        }
    }

    public final void openResource(@Nullable String str, @NotNull String str2, byte b, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str2, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str3, "identifier");
        ILog.d(IResourceManager.TAG, "Opening resource, target=" + str + " source=" + str2 + " type=" + b + " id=" + str3 + ".");
        if (DeviceExtKt.isSelfDevice(str)) {
            String str4 = this.openerMap.get(Byte.valueOf(b));
            if (str4 != null) {
                TaskManager taskManager2 = this.taskManager;
                ResourceDescription resourceDescription = new ResourceDescription();
                resourceDescription.deviceId = str2;
                resourceDescription.type = b;
                resourceDescription.identifier = str3;
                new ResourceOpenInfo(resourceDescription);
                Unit unit = Unit.INSTANCE;
                taskManager2.execute((String) null, str4, resourceDescription);
                return;
            }
            return;
        }
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new ResourceManager$openResource$2(str3, b, str2, (Continuation<? super ResourceManager$openResource$2>) null), 3, (Object) null);
    }

    public final void registerOpener(byte b, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        ILog.d(IResourceManager.TAG, "Registering opener, type=" + b + " name=" + str + ".");
        this.openerMap.put(Byte.valueOf(b), str);
    }

    public final void setAvailability(byte b, @NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "identifier");
        ILog.d(IResourceManager.TAG, "Updating availability, type=" + b + " id=" + str + " avail=" + z + ".");
        this.dataSlice.set(new String[]{String.valueOf(b), str}, z);
    }
}
