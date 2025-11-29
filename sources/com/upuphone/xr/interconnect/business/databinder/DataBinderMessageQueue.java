package com.upuphone.xr.interconnect.business.databinder;

import com.google.gson.Gson;
import com.upuphone.runasone.constant.Constants;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u000e\u0010\r\u001a\u00020\u000eH@¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000bJ\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\nJ\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000Rb\u0010\b\u001aV\u0012\u0004\u0012\u00020\n\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b`\f0\tj*\u0012\u0004\u0012\u00020\n\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b`\f`\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/upuphone/xr/interconnect/business/databinder/DataBinderMessageQueue;", "", "gson", "Lcom/google/gson/Gson;", "sendScheduler", "Lcom/upuphone/xr/interconnect/business/databinder/MessageQueueSendScheduler;", "Lcom/upuphone/xr/interconnect/business/databinder/DataBinderEvent;", "(Lcom/google/gson/Gson;Lcom/upuphone/xr/interconnect/business/databinder/MessageQueueSendScheduler;)V", "pendingOperationMap", "Ljava/util/HashMap;", "", "Lcom/upuphone/xr/interconnect/business/databinder/DataBinderOperation;", "Lkotlin/collections/HashMap;", "doSend", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onOperation", "operation", "onRemoteServiceDown", "deviceId", "onRemoteServiceUp", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDataBinderMessageQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DataBinderMessageQueue.kt\ncom/upuphone/xr/interconnect/business/databinder/DataBinderMessageQueue\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,88:1\n1855#2,2:89\n1#3:91\n*S KotlinDebug\n*F\n+ 1 DataBinderMessageQueue.kt\ncom/upuphone/xr/interconnect/business/databinder/DataBinderMessageQueue\n*L\n25#1:89,2\n*E\n"})
public final class DataBinderMessageQueue {
    @NotNull
    private final Gson gson;
    @NotNull
    private final HashMap<String, HashMap<String, DataBinderOperation>> pendingOperationMap = new HashMap<>();
    /* access modifiers changed from: private */
    @NotNull
    public final MessageQueueSendScheduler<DataBinderEvent> sendScheduler;

    public DataBinderMessageQueue(@NotNull Gson gson2, @NotNull MessageQueueSendScheduler<DataBinderEvent> messageQueueSendScheduler) {
        Intrinsics.checkNotNullParameter(gson2, "gson");
        Intrinsics.checkNotNullParameter(messageQueueSendScheduler, "sendScheduler");
        this.gson = gson2;
        this.sendScheduler = messageQueueSendScheduler;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.upuphone.xr.interconnect.business.databinder.DataBinderOperation[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object doSend(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof com.upuphone.xr.interconnect.business.databinder.DataBinderMessageQueue$doSend$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            com.upuphone.xr.interconnect.business.databinder.DataBinderMessageQueue$doSend$1 r0 = (com.upuphone.xr.interconnect.business.databinder.DataBinderMessageQueue$doSend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.interconnect.business.databinder.DataBinderMessageQueue$doSend$1 r0 = new com.upuphone.xr.interconnect.business.databinder.DataBinderMessageQueue$doSend$1
            r0.<init>(r11, r12)
        L_0x0018:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0044
            if (r2 != r3) goto L_0x003c
            java.lang.Object r11 = r0.L$3
            com.upuphone.xr.interconnect.entity.StarryNetMessage r11 = (com.upuphone.xr.interconnect.entity.StarryNetMessage) r11
            java.lang.Object r11 = r0.L$2
            com.upuphone.xr.interconnect.business.databinder.DataBinderOperation[] r11 = (com.upuphone.xr.interconnect.business.databinder.DataBinderOperation[]) r11
            java.lang.Object r11 = r0.L$1
            java.util.HashMap r11 = (java.util.HashMap) r11
            java.lang.Object r0 = r0.L$0
            com.upuphone.xr.interconnect.business.databinder.DataBinderMessageQueue r0 = (com.upuphone.xr.interconnect.business.databinder.DataBinderMessageQueue) r0
            kotlin.ResultKt.throwOnFailure(r12)
            r12 = r11
            r11 = r0
            goto L_0x0121
        L_0x003c:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r12)
            java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, com.upuphone.xr.interconnect.business.databinder.DataBinderOperation>> r12 = r11.pendingOperationMap
            java.util.Collection r12 = r12.values()
            java.lang.String r2 = "<get-values>(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r2)
            java.lang.Object r12 = kotlin.collections.CollectionsKt.firstOrNull(r12)
            java.util.HashMap r12 = (java.util.HashMap) r12
            java.lang.String r2 = "DataBinder"
            if (r12 != 0) goto L_0x0064
            java.lang.String r11 = "Skipping send as no device is connected."
            com.upuphone.xr.interconnect.util.log.ILog.d(r2, r11)
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x0064:
            boolean r4 = r12.isEmpty()
            if (r4 == 0) goto L_0x0072
            java.lang.String r11 = "Skipping send as no operation is pending."
            com.upuphone.xr.interconnect.util.log.ILog.d(r2, r11)
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x0072:
            kotlin.jvm.internal.Ref$IntRef r4 = new kotlin.jvm.internal.Ref$IntRef
            r4.<init>()
            r5 = 8
            com.upuphone.xr.interconnect.business.databinder.DataBinderOperation[] r6 = new com.upuphone.xr.interconnect.business.databinder.DataBinderOperation[r5]
            r7 = 0
            r8 = r7
        L_0x007d:
            if (r8 >= r5) goto L_0x0085
            r9 = 0
            r6[r8] = r9
            int r8 = r8 + 1
            goto L_0x007d
        L_0x0085:
            java.util.Set r8 = r12.entrySet()
            java.util.Iterator r8 = r8.iterator()
        L_0x008d:
            int r9 = r4.element
            if (r9 >= r5) goto L_0x00ad
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x00ad
            int r9 = r4.element
            int r10 = r9 + 1
            r4.element = r10
            java.lang.Object r10 = r8.next()
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10
            java.lang.Object r10 = r10.getValue()
            r6[r9] = r10
            r8.remove()
            goto L_0x008d
        L_0x00ad:
            int r5 = r4.element
            int r8 = r12.size()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Sending "
            r9.append(r10)
            r9.append(r5)
            java.lang.String r5 = " operations, with "
            r9.append(r5)
            r9.append(r8)
            java.lang.String r5 = " pending."
            r9.append(r5)
            java.lang.String r5 = r9.toString()
            com.upuphone.xr.interconnect.util.log.ILog.d(r2, r5)
            com.upuphone.xr.interconnect.entity.StarryNetMessage r2 = com.upuphone.xr.interconnect.main.StarryNetMessageFactory.createInnerMessage()
            com.upuphone.xr.interconnect.entity.Function r5 = new com.upuphone.xr.interconnect.entity.Function
            int r4 = r4.element
            java.lang.Object[] r4 = kotlin.collections.ArraysKt.copyOfRange((T[]) r6, (int) r7, (int) r4)
            r7 = 15
            r5.<init>(r7, r4)
            com.google.gson.Gson r4 = r11.gson
            java.lang.String r4 = r5.toString(r4)
            r2.setMessage(r4)
            r0.L$0 = r11
            r0.L$1 = r12
            r0.L$2 = r6
            r0.L$3 = r2
            r0.label = r3
            kotlin.coroutines.SafeContinuation r3 = new kotlin.coroutines.SafeContinuation
            kotlin.coroutines.Continuation r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r0)
            r3.<init>(r4)
            com.upuphone.xr.interconnect.InterconnectManager r4 = com.upuphone.xr.interconnect.InterconnectManager.getInstance()
            com.upuphone.xr.interconnect.api.StarryNetMessenger r4 = r4.getStarryNetMessenger()
            com.upuphone.xr.interconnect.business.databinder.DataBinderMessageQueue$doSend$3$1 r5 = new com.upuphone.xr.interconnect.business.databinder.DataBinderMessageQueue$doSend$3$1
            r5.<init>(r11, r3, r6, r12)
            r4.sendMessage(r2, r5)
            java.lang.Object r2 = r3.getOrThrow()
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r2 != r3) goto L_0x011e
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)
        L_0x011e:
            if (r2 != r1) goto L_0x0121
            return r1
        L_0x0121:
            com.upuphone.xr.interconnect.business.databinder.MessageQueueSendScheduler<com.upuphone.xr.interconnect.business.databinder.DataBinderEvent> r11 = r11.sendScheduler
            int r12 = r12.size()
            r11.scheduleNextSend(r12)
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.interconnect.business.databinder.DataBinderMessageQueue.doSend(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void onOperation(@NotNull DataBinderOperation dataBinderOperation) {
        Integer num;
        Intrinsics.checkNotNullParameter(dataBinderOperation, "operation");
        Collection<HashMap<String, DataBinderOperation>> values = this.pendingOperationMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        for (HashMap hashMap : values) {
            Intrinsics.checkNotNull(hashMap);
            hashMap.put(dataBinderOperation.getName(), dataBinderOperation);
        }
        this.sendScheduler.cancelNextSend();
        if (!this.pendingOperationMap.isEmpty()) {
            MessageQueueSendScheduler<DataBinderEvent> messageQueueSendScheduler = this.sendScheduler;
            Collection<HashMap<String, DataBinderOperation>> values2 = this.pendingOperationMap.values();
            Intrinsics.checkNotNullExpressionValue(values2, "<get-values>(...)");
            Iterator<T> it = values2.iterator();
            if (!it.hasNext()) {
                num = null;
            } else {
                Integer valueOf = Integer.valueOf(((HashMap) it.next()).size());
                while (it.hasNext()) {
                    Integer valueOf2 = Integer.valueOf(((HashMap) it.next()).size());
                    if (valueOf.compareTo(valueOf2) < 0) {
                        valueOf = valueOf2;
                    }
                }
                num = valueOf;
            }
            messageQueueSendScheduler.scheduleNextSend(num != null ? num.intValue() : 0);
        }
    }

    public final void onRemoteServiceDown(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        this.pendingOperationMap.remove(str);
    }

    public final void onRemoteServiceUp(@NotNull String str) {
        Integer num;
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        this.pendingOperationMap.putIfAbsent(str, new HashMap());
        if (!this.pendingOperationMap.isEmpty()) {
            MessageQueueSendScheduler<DataBinderEvent> messageQueueSendScheduler = this.sendScheduler;
            Collection<HashMap<String, DataBinderOperation>> values = this.pendingOperationMap.values();
            Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
            Iterator<T> it = values.iterator();
            if (!it.hasNext()) {
                num = null;
            } else {
                Integer valueOf = Integer.valueOf(((HashMap) it.next()).size());
                while (it.hasNext()) {
                    Integer valueOf2 = Integer.valueOf(((HashMap) it.next()).size());
                    if (valueOf.compareTo(valueOf2) < 0) {
                        valueOf = valueOf2;
                    }
                }
                num = valueOf;
            }
            messageQueueSendScheduler.scheduleNextSend(num != null ? num.intValue() : 0);
        }
    }
}
