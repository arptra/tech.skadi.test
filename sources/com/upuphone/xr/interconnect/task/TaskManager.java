package com.upuphone.xr.interconnect.task;

import android.os.Bundle;
import com.honey.account.view.web.WebJs;
import com.upuphone.runasone.constant.Constants;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.api.DataBinderOperator;
import com.upuphone.xr.interconnect.api.DataBinderSlice;
import com.upuphone.xr.interconnect.common.ITaskActionHandler;
import com.upuphone.xr.interconnect.common.ITaskExecutor;
import com.upuphone.xr.interconnect.common.ITaskManager;
import com.upuphone.xr.interconnect.entity.DataBinderValue;
import com.upuphone.xr.interconnect.entity.Function;
import com.upuphone.xr.interconnect.entity.ResourceDescription;
import com.upuphone.xr.interconnect.entity.RunningTask;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.main.StarryNetMessageFactory;
import com.upuphone.xr.interconnect.main.handler.MessageHandler;
import com.upuphone.xr.interconnect.util.DataBinderValueExtKt;
import com.upuphone.xr.interconnect.util.DeviceExtKt;
import com.upuphone.xr.interconnect.util.log.ILog;
import com.upuphone.xr.interconnect.util.log.ResourcePrintingKt;
import com.upuphone.xr.interconnect.util.log.TaskPrintingKt;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J \u0010\u0019\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0007J \u0010\u0019\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007J.\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u00072\b\u0010 \u001a\u0004\u0018\u00010\u0018H@¢\u0006\u0002\u0010!J\u0016\u0010\"\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0010J\u000e\u0010$\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010$\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u0007J\u000e\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u001fR\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00100\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006'"}, d2 = {"Lcom/upuphone/xr/interconnect/task/TaskManager;", "", "dataBinderOperator", "Lcom/upuphone/xr/interconnect/api/DataBinderOperator;", "(Lcom/upuphone/xr/interconnect/api/DataBinderOperator;)V", "actionHandlerDict", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/upuphone/xr/interconnect/common/ITaskActionHandler;", "dataSlice", "Lcom/upuphone/xr/interconnect/api/DataBinderSlice;", "executionHandler", "Lcom/upuphone/xr/interconnect/main/handler/MessageHandler;", "getExecutionHandler", "()Lcom/upuphone/xr/interconnect/main/handler/MessageHandler;", "executorDict", "Lcom/upuphone/xr/interconnect/common/ITaskExecutor;", "runningTaskActionHandler", "getRunningTaskActionHandler", "execute", "", "deviceId", "name", "resource", "Lcom/upuphone/xr/interconnect/entity/ResourceDescription;", "performAction", "taskId", "", "action", "executorName", "queryRunning", "Lcom/upuphone/xr/interconnect/entity/RunningTask;", "occupiedResource", "(Ljava/lang/String;Ljava/lang/String;Lcom/upuphone/xr/interconnect/entity/ResourceDescription;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerExecutor", "executor", "removeRunning", "updateRunning", "task", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTaskManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TaskManager.kt\ncom/upuphone/xr/interconnect/task/TaskManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,231:1\n1#2:232\n1549#3:233\n1620#3,3:234\n1549#3:237\n1620#3,3:238\n*S KotlinDebug\n*F\n+ 1 TaskManager.kt\ncom/upuphone/xr/interconnect/task/TaskManager\n*L\n124#1:233\n124#1:234,3\n130#1:237\n130#1:238,3\n*E\n"})
public final class TaskManager {
    @NotNull
    private final ConcurrentHashMap<String, ITaskActionHandler> actionHandlerDict = new ConcurrentHashMap<>();
    @NotNull
    private final DataBinderSlice dataSlice;
    @NotNull
    private final MessageHandler executionHandler = new TaskManager$executionHandler$1(this);
    @NotNull
    private final ConcurrentHashMap<String, ITaskExecutor> executorDict = new ConcurrentHashMap<>();
    @NotNull
    private final MessageHandler runningTaskActionHandler = new TaskManager$runningTaskActionHandler$1(this);

    public TaskManager(@NotNull DataBinderOperator dataBinderOperator) {
        Intrinsics.checkNotNullParameter(dataBinderOperator, "dataBinderOperator");
        this.dataSlice = dataBinderOperator.getSlice("task");
    }

    /* JADX WARNING: type inference failed for: r0v7, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void execute(@org.jetbrains.annotations.Nullable java.lang.String r6, @org.jetbrains.annotations.NotNull java.lang.String r7, @org.jetbrains.annotations.Nullable com.upuphone.xr.interconnect.entity.ResourceDescription r8) {
        /*
            r5 = this;
            java.lang.String r0 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = 0
            if (r8 == 0) goto L_0x000d
            java.lang.String r1 = com.upuphone.xr.interconnect.util.log.ResourcePrintingKt.stringify(r8)
            goto L_0x000e
        L_0x000d:
            r1 = r0
        L_0x000e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Executing task, dev="
            r2.append(r3)
            r2.append(r6)
            java.lang.String r3 = " name="
            r2.append(r3)
            r2.append(r7)
            java.lang.String r3 = " res="
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = "."
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "TaskManager"
            com.upuphone.xr.interconnect.util.log.ILog.d(r3, r2)
            boolean r2 = com.upuphone.xr.interconnect.util.DeviceExtKt.isSelfDevice(r6)
            if (r2 == 0) goto L_0x0097
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.upuphone.xr.interconnect.common.ITaskExecutor> r6 = r5.executorDict
            java.lang.Object r6 = r6.get(r7)
            com.upuphone.xr.interconnect.common.ITaskExecutor r6 = (com.upuphone.xr.interconnect.common.ITaskExecutor) r6
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "Found executor "
            r2.append(r4)
            r2.append(r7)
            java.lang.String r4 = ": "
            r2.append(r4)
            r2.append(r6)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            com.upuphone.xr.interconnect.util.log.ILog.d(r3, r1)
            r1 = 0
            if (r6 == 0) goto L_0x006e
            com.upuphone.xr.interconnect.common.ITaskActionHandler r6 = r6.onLaunch(r1, r8)
            goto L_0x006f
        L_0x006e:
            r6 = r0
        L_0x006f:
            if (r6 != 0) goto L_0x0078
            java.lang.String r5 = "Task execution unsuccessful."
            com.upuphone.xr.interconnect.util.log.ILog.d(r3, r5)
            goto L_0x00f0
        L_0x0078:
            java.lang.String r2 = "Task successfully launched, saving running task."
            com.upuphone.xr.interconnect.util.log.ILog.d(r3, r2)
            com.upuphone.xr.interconnect.entity.RunningTask r2 = new com.upuphone.xr.interconnect.entity.RunningTask
            r2.<init>()
            r2.id = r1
            r2.executorName = r7
            if (r8 == 0) goto L_0x008c
            java.util.List r0 = kotlin.collections.CollectionsKt.listOf(r8)
        L_0x008c:
            r2.occupiedResources = r0
            r5.updateRunning(r2)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.upuphone.xr.interconnect.common.ITaskActionHandler> r5 = r5.actionHandlerDict
            r5.put(r7, r6)
            goto L_0x00f0
        L_0x0097:
            com.upuphone.xr.interconnect.InterconnectManager r5 = com.upuphone.xr.interconnect.InterconnectManager.getInstance()
            com.upuphone.xr.interconnect.api.StarryNetDeviceManager r5 = r5.getStarryNetDeviceManager()
            com.upuphone.runasone.device.StarryDevice r5 = r5.getConnectedDevice()
            if (r5 == 0) goto L_0x00a9
            java.lang.String r0 = r5.getId()
        L_0x00a9:
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r6)
            if (r5 != 0) goto L_0x00c9
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = "Cannot execute task as device "
            r5.append(r7)
            r5.append(r6)
            java.lang.String r6 = " is not connected."
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            com.upuphone.xr.interconnect.util.log.ILog.d(r3, r5)
            return
        L_0x00c9:
            com.upuphone.xr.interconnect.entity.StarryNetMessage r5 = com.upuphone.xr.interconnect.main.StarryNetMessageFactory.createInnerMessage()
            com.upuphone.xr.interconnect.entity.Function r0 = new com.upuphone.xr.interconnect.entity.Function
            com.upuphone.xr.interconnect.task.TaskExecutionRequest r1 = new com.upuphone.xr.interconnect.task.TaskExecutionRequest
            r1.<init>(r7, r8)
            r2 = 18
            r0.<init>(r2, r1)
            java.lang.String r0 = r0.toString()
            r5.setMessage(r0)
            com.upuphone.xr.interconnect.InterconnectManager r0 = com.upuphone.xr.interconnect.InterconnectManager.getInstance()
            com.upuphone.xr.interconnect.api.StarryNetMessenger r0 = r0.getStarryNetMessenger()
            com.upuphone.xr.interconnect.task.TaskManager$execute$1 r1 = new com.upuphone.xr.interconnect.task.TaskManager$execute$1
            r1.<init>(r7, r8, r6)
            r0.sendMessage(r5, r1)
        L_0x00f0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.interconnect.task.TaskManager.execute(java.lang.String, java.lang.String, com.upuphone.xr.interconnect.entity.ResourceDescription):void");
    }

    @NotNull
    public final MessageHandler getExecutionHandler() {
        return this.executionHandler;
    }

    @NotNull
    public final MessageHandler getRunningTaskActionHandler() {
        return this.runningTaskActionHandler;
    }

    public final void performAction(@Nullable String str, int i, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str2, WebJs.ACTION);
        ILog.d(ITaskManager.TAG, "Performing action, dev=" + str + " id=" + i + " act=" + str2);
        if (DeviceExtKt.isSelfDevice(str)) {
            ITaskActionHandler iTaskActionHandler = this.actionHandlerDict.get("com.upuphone.xr.screencast");
            if (iTaskActionHandler != null) {
                iTaskActionHandler.onAction(str2);
                return;
            }
            return;
        }
        StarryDevice connectedDevice = InterconnectManager.getInstance().getStarryNetDeviceManager().getConnectedDevice();
        if (!Intrinsics.areEqual((Object) connectedDevice != null ? connectedDevice.getId() : null, (Object) str)) {
            ILog.d(ITaskManager.TAG, "Cannot perform action as device " + str + " is not connected.");
            return;
        }
        StarryNetMessage createInnerMessage = StarryNetMessageFactory.createInnerMessage();
        createInnerMessage.setMessage(new Function(19, new RunningTaskActionRequest("com.upuphone.xr.screencast", str2)).toString());
        InterconnectManager.getInstance().getStarryNetMessenger().sendMessage(createInnerMessage, new TaskManager$performAction$1(str2, i, str));
    }

    @Nullable
    public final Object queryRunning(@Nullable String str, @Nullable String str2, @Nullable ResourceDescription resourceDescription, @NotNull Continuation<? super RunningTask> continuation) {
        List<ResourceDescription> list;
        String stringify = resourceDescription != null ? ResourcePrintingKt.stringify(resourceDescription) : null;
        ILog.d(ITaskManager.TAG, "Querying RunningTask, dev=" + str + " name=" + str2 + " res=" + stringify);
        if (str2 == null) {
            return null;
        }
        DataBinderValue<?> dataBinderValue = this.dataSlice.get(DeviceExtKt.getDataBinderDeviceId(str), "running", str2, "resources", "occupied");
        List<DataBinderValue<?>> asList = dataBinderValue != null ? DataBinderValueExtKt.asList(dataBinderValue) : null;
        if (resourceDescription != null && (asList == null || !RunningTaskExtKt.containsResource(asList, resourceDescription))) {
            return null;
        }
        RunningTask runningTask = new RunningTask();
        runningTask.executorName = str2;
        if (asList == null || (list = RunningTaskExtKt.asResourceDescriptionList(asList)) == null) {
            list = CollectionsKt.emptyList();
        }
        runningTask.occupiedResources = list;
        runningTask.param = new Bundle();
        runningTask.actions = CollectionsKt.emptyList();
        String stringify2 = TaskPrintingKt.stringify(runningTask);
        ILog.d(ITaskManager.TAG, "Found running task: " + stringify2);
        return runningTask;
    }

    public final void registerExecutor(@NotNull String str, @NotNull ITaskExecutor iTaskExecutor) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(iTaskExecutor, "executor");
        ILog.d(ITaskManager.TAG, "Registering task executor " + str + ": " + iTaskExecutor + ".");
        this.executorDict.put(str, iTaskExecutor);
    }

    public final void removeRunning(int i) {
        ILog.d(ITaskManager.TAG, "Removing RunningTask.");
        this.dataSlice.unset("running", "com.upuphone.xr.screencast", "resources", "occupied");
        this.dataSlice.unset("running", "com.upuphone.xr.screencast", "actions");
    }

    public final void updateRunning(@NotNull RunningTask runningTask) {
        Intrinsics.checkNotNullParameter(runningTask, "task");
        String stringify = TaskPrintingKt.stringify(runningTask);
        ILog.d(ITaskManager.TAG, "Updating " + stringify);
        List<ResourceDescription> list = runningTask.occupiedResources;
        if (list != null) {
            Intrinsics.checkNotNull(list);
            DataBinderSlice dataBinderSlice = this.dataSlice;
            String str = runningTask.executorName;
            Intrinsics.checkNotNullExpressionValue(str, "executorName");
            String[] strArr = {"running", str, "resources", "occupied"};
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (ResourceDescription resourceDescription : list) {
                String str2 = resourceDescription.deviceId;
                Intrinsics.checkNotNullExpressionValue(str2, Constants.DEVICE_ID);
                DataBinderValue.String dataBinderValue = DataBinderValueExtKt.toDataBinderValue(str2);
                DataBinderValue.Integer dataBinderValue2 = DataBinderValueExtKt.toDataBinderValue((int) resourceDescription.type);
                String str3 = resourceDescription.identifier;
                Intrinsics.checkNotNullExpressionValue(str3, "identifier");
                arrayList.add(DataBinderValueExtKt.toDataBinderValue((List<? extends DataBinderValue<?>>) CollectionsKt.listOf(dataBinderValue, dataBinderValue2, DataBinderValueExtKt.toDataBinderValue(str3))));
            }
            dataBinderSlice.set(strArr, (List<? extends DataBinderValue<?>>) arrayList);
        }
        List<String> list2 = runningTask.actions;
        if (list2 != null) {
            Intrinsics.checkNotNull(list2);
            DataBinderSlice dataBinderSlice2 = this.dataSlice;
            String str4 = runningTask.executorName;
            Intrinsics.checkNotNullExpressionValue(str4, "executorName");
            String[] strArr2 = {"running", str4, "actions"};
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (String dataBinderValue3 : list2) {
                arrayList2.add(DataBinderValueExtKt.toDataBinderValue(dataBinderValue3));
            }
            dataBinderSlice2.set(strArr2, (DataBinderValue<?>) DataBinderValueExtKt.toDataBinderValue((List<? extends DataBinderValue<?>>) arrayList2));
        }
    }

    public final void removeRunning(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "executorName");
        ILog.d(ITaskManager.TAG, "Removing RunningTask.");
        this.dataSlice.unset("running", str, "resources", "occupied");
        this.dataSlice.unset("running", str, "actions");
    }

    public final void performAction(@Nullable String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str2, "executorName");
        Intrinsics.checkNotNullParameter(str3, WebJs.ACTION);
        ILog.d(ITaskManager.TAG, "Performing action, dev=" + str + " exe=" + str2 + " act=" + str3);
        if (DeviceExtKt.isSelfDevice(str)) {
            ITaskActionHandler iTaskActionHandler = this.actionHandlerDict.get(str2);
            if (iTaskActionHandler != null) {
                iTaskActionHandler.onAction(str3);
                return;
            }
            return;
        }
        StarryDevice connectedDevice = InterconnectManager.getInstance().getStarryNetDeviceManager().getConnectedDevice();
        if (!Intrinsics.areEqual((Object) connectedDevice != null ? connectedDevice.getId() : null, (Object) str)) {
            ILog.d(ITaskManager.TAG, "Cannot perform action as device " + str + " is not connected.");
            return;
        }
        StarryNetMessage createInnerMessage = StarryNetMessageFactory.createInnerMessage();
        createInnerMessage.setMessage(new Function(19, new RunningTaskActionRequest(str2, str3)).toString());
        InterconnectManager.getInstance().getStarryNetMessenger().sendMessage(createInnerMessage, new TaskManager$performAction$2(str3, str2, str));
    }
}
