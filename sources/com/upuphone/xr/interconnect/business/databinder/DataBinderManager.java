package com.upuphone.xr.interconnect.business.databinder;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.honey.account.constant.AccountConstantKt;
import com.upuphone.runasone.constant.Constants;
import com.upuphone.xr.interconnect.api.DataBinderOperator;
import com.upuphone.xr.interconnect.business.databinder.DataBinderEvent;
import com.upuphone.xr.interconnect.common.IDataBinder;
import com.upuphone.xr.interconnect.common.IDataBinderItemUpdateListener;
import com.upuphone.xr.interconnect.entity.DataBinderValue;
import com.upuphone.xr.interconnect.entity.Function;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.main.handler.MessageHandler;
import com.upuphone.xr.interconnect.util.log.ILog;
import com.upuphone.xr.interconnect.util.statemachine.StartFlow;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u0001/B\u0005¢\u0006\u0002\u0010\u0003J\u001f\u0010\u0017\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00072\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u001c\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0018\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010#2\u0006\u0010\u0018\u001a\u00020\u0006H\u0016J\u000e\u0010$\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u0006J\u000e\u0010%\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u0006J\u001d\u0010&\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u00062\n\u0010'\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0002J\u001e\u0010(\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010)\u001a\u00020*J \u0010(\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010)\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u0006H\u0016J\u001e\u0010-\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010)\u001a\u00020*J \u0010-\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010)\u001a\u00020+H\u0016J\u000e\u0010.\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u0006R*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00050\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/upuphone/xr/interconnect/business/databinder/DataBinderManager;", "Lcom/upuphone/xr/interconnect/api/DataBinderOperator;", "Lcom/upuphone/xr/interconnect/main/handler/MessageHandler;", "()V", "allData", "", "", "Lcom/upuphone/xr/interconnect/entity/DataBinderValue;", "eventFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/upuphone/xr/interconnect/business/databinder/DataBinderEvent;", "eventFlowLock", "Lkotlinx/coroutines/sync/Semaphore;", "itemSubscribeManager", "Lcom/upuphone/xr/interconnect/business/databinder/DataBinderItemSubscribeManager;", "getItemSubscribeManager$SharedImpl_intlRelease", "()Lcom/upuphone/xr/interconnect/business/databinder/DataBinderItemSubscribeManager;", "localData", "requestHandler", "getRequestHandler", "()Lcom/upuphone/xr/interconnect/main/handler/MessageHandler;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "get", "deviceId", "name", "getHandleType", "", "handle", "", "message", "Lcom/upuphone/xr/interconnect/entity/StarryNetMessage;", "function", "Lcom/upuphone/xr/interconnect/entity/Function;", "list", "", "onRemoteServiceDied", "onRemoteServiceStarted", "set", "value", "subscribe", "listener", "Lcom/upuphone/xr/interconnect/business/databinder/DataBinderItemUpdateListener;", "Lcom/upuphone/xr/interconnect/common/IDataBinderItemUpdateListener;", "unset", "unsubscribe", "updateAllData", "Companion", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDataBinderManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DataBinderManager.kt\ncom/upuphone/xr/interconnect/business/databinder/DataBinderManager\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,252:1\n26#2:253\n*S KotlinDebug\n*F\n+ 1 DataBinderManager.kt\ncom/upuphone/xr/interconnect/business/databinder/DataBinderManager\n*L\n249#1:253\n*E\n"})
public final class DataBinderManager extends DataBinderOperator implements MessageHandler {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final Gson gson;
    @NotNull
    private static final Class<? extends DataBinderOperation[]> operationArrayType = DataBinderOperation[].class;
    /* access modifiers changed from: private */
    @NotNull
    public final Map<String, Map<String, DataBinderValue<?>>> allData;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableSharedFlow<DataBinderEvent> eventFlow = SharedFlowKt.b(0, Integer.MAX_VALUE, BufferOverflow.SUSPEND, 1, (Object) null);
    /* access modifiers changed from: private */
    @NotNull
    public final Semaphore eventFlowLock = SemaphoreKt.a(1, 1);
    @NotNull
    private final DataBinderItemSubscribeManager itemSubscribeManager = new DataBinderItemSubscribeManager(this);
    /* access modifiers changed from: private */
    @NotNull
    public final Map<String, DataBinderValue<?>> localData;
    @NotNull
    private final MessageHandler requestHandler;
    @NotNull
    private final CoroutineScope scope;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.xr.interconnect.business.databinder.DataBinderManager$1", f = "DataBinderManager.kt", i = {}, l = {43}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.xr.interconnect.business.databinder.DataBinderManager$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DataBinderManager this$0;

        {
            this.this$0 = r1;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, continuation);
            r0.L$0 = obj;
            return r0;
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                final DataBinderMessageQueue dataBinderMessageQueue = new DataBinderMessageQueue(DataBinderManager.Companion.getGson(), new MessageQueueSendScheduler(DataBinderEvent.SendMessage.INSTANCE, ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED, 8, this.this$0.eventFlow, coroutineScope.getCoroutineContext()));
                final FullDataRequester fullDataRequester = new FullDataRequester(DataBinderEvent.RequestUpdate.INSTANCE, this.this$0.eventFlow, coroutineScope.getCoroutineContext());
                Flow J = FlowKt.J(new StartFlow(DataBinderEvent.Start.INSTANCE), this.this$0.eventFlow);
                final DataBinderManager dataBinderManager = this.this$0;
                AnonymousClass1 r5 = new FlowCollector() {
                    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.upuphone.xr.interconnect.entity.DataBinderValue} */
                    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: com.upuphone.xr.interconnect.entity.DataBinderValue} */
                    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: java.lang.Object} */
                    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v16, resolved type: com.upuphone.xr.interconnect.entity.DataBinderValue} */
                    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v11, resolved type: java.lang.Object} */
                    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v17, resolved type: com.upuphone.xr.interconnect.entity.DataBinderValue} */
                    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v19, resolved type: com.upuphone.xr.interconnect.entity.DataBinderValue} */
                    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v18, resolved type: java.lang.Object} */
                    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v20, resolved type: com.upuphone.xr.interconnect.entity.DataBinderValue} */
                    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v22, resolved type: com.upuphone.xr.interconnect.entity.DataBinderValue} */
                    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v23, resolved type: com.upuphone.xr.interconnect.entity.DataBinderValue} */
                    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v24, resolved type: com.upuphone.xr.interconnect.entity.DataBinderValue} */
                    /* JADX WARNING: Multi-variable type inference failed */
                    @org.jetbrains.annotations.Nullable
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final java.lang.Object emit(@org.jetbrains.annotations.NotNull com.upuphone.xr.interconnect.business.databinder.DataBinderEvent r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
                        /*
                            r8 = this;
                            java.lang.String r0 = r9.stringify()
                            java.lang.StringBuilder r1 = new java.lang.StringBuilder
                            r1.<init>()
                            java.lang.String r2 = "Happened "
                            r1.append(r2)
                            r1.append(r0)
                            java.lang.String r0 = "."
                            r1.append(r0)
                            java.lang.String r0 = r1.toString()
                            java.lang.String r1 = "DataBinder"
                            com.upuphone.xr.interconnect.util.log.ILog.d(r1, r0)
                            boolean r0 = r9 instanceof com.upuphone.xr.interconnect.business.databinder.DataBinderDeviceEvent.ServiceDown
                            if (r0 == 0) goto L_0x004a
                            com.upuphone.xr.interconnect.business.databinder.DataBinderManager r10 = r6
                            java.util.Map r10 = r10.allData
                            com.upuphone.xr.interconnect.business.databinder.DataBinderDeviceEvent$ServiceDown r9 = (com.upuphone.xr.interconnect.business.databinder.DataBinderDeviceEvent.ServiceDown) r9
                            java.lang.String r0 = r9.getDeviceId()
                            r10.remove(r0)
                            com.upuphone.xr.interconnect.business.databinder.DataBinderMessageQueue r10 = r2
                            java.lang.String r0 = r9.getDeviceId()
                            r10.onRemoteServiceDown(r0)
                            com.upuphone.xr.interconnect.business.databinder.DataBinderManager r8 = r6
                            com.upuphone.xr.interconnect.business.databinder.DataBinderItemSubscribeManager r8 = r8.getItemSubscribeManager$SharedImpl_intlRelease()
                            java.lang.String r9 = r9.getDeviceId()
                            r8.onRemoteServiceDown(r9)
                            goto L_0x02e7
                        L_0x004a:
                            boolean r0 = r9 instanceof com.upuphone.xr.interconnect.business.databinder.DataBinderDeviceEvent.ServiceUp
                            r1 = 0
                            if (r0 == 0) goto L_0x00a4
                            com.upuphone.xr.interconnect.business.databinder.DataBinderManager r10 = r6
                            java.util.Map r10 = r10.allData
                            com.upuphone.xr.interconnect.business.databinder.DataBinderDeviceEvent$ServiceUp r9 = (com.upuphone.xr.interconnect.business.databinder.DataBinderDeviceEvent.ServiceUp) r9
                            java.lang.String r0 = r9.getDeviceId()
                            boolean r10 = r10.containsKey(r0)
                            if (r10 != 0) goto L_0x02e7
                            com.upuphone.xr.interconnect.business.databinder.DataBinderManager r10 = r6
                            java.util.Map r10 = r10.allData
                            java.lang.String r0 = r9.getDeviceId()
                            java.util.concurrent.ConcurrentHashMap r2 = new java.util.concurrent.ConcurrentHashMap
                            r2.<init>()
                            r10.put(r0, r2)
                            com.upuphone.xr.interconnect.business.databinder.DataBinderMessageQueue r10 = r2
                            java.lang.String r0 = r9.getDeviceId()
                            r10.onRemoteServiceUp(r0)
                            com.upuphone.xr.interconnect.business.databinder.DataBinderManager r10 = r6
                            com.upuphone.xr.interconnect.business.databinder.DataBinderItemSubscribeManager r10 = r10.getItemSubscribeManager$SharedImpl_intlRelease()
                            java.lang.String r0 = r9.getDeviceId()
                            r10.onRemoteServiceUp(r0)
                            kotlinx.coroutines.CoroutineScope r2 = r10
                            com.upuphone.xr.interconnect.business.databinder.DataBinderManager$1$1$1 r5 = new com.upuphone.xr.interconnect.business.databinder.DataBinderManager$1$1$1
                            com.upuphone.xr.interconnect.business.databinder.DataBinderManager r10 = r6
                            r5.<init>(r10, r1)
                            r6 = 3
                            r7 = 0
                            r3 = 0
                            r4 = 0
                            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.d(r2, r3, r4, r5, r6, r7)
                            com.upuphone.xr.interconnect.business.databinder.DataBinderManager r8 = r6
                            java.lang.String r9 = r9.getDeviceId()
                            r8.updateAllData(r9)
                            goto L_0x02e7
                        L_0x00a4:
                            com.upuphone.xr.interconnect.business.databinder.DataBinderEvent$RequestUpdate r0 = com.upuphone.xr.interconnect.business.databinder.DataBinderEvent.RequestUpdate.INSTANCE
                            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r0)
                            if (r0 == 0) goto L_0x00c5
                            com.upuphone.xr.interconnect.business.databinder.FullDataRequester<com.upuphone.xr.interconnect.business.databinder.DataBinderEvent$RequestUpdate> r9 = r3
                            r9.cancelLastRequest()
                            com.upuphone.xr.interconnect.business.databinder.DataBinderManager r9 = r6
                            java.util.Map r9 = r9.allData
                            int r9 = r9.size()
                            r10 = 1
                            if (r9 <= r10) goto L_0x02e7
                            com.upuphone.xr.interconnect.business.databinder.FullDataRequester<com.upuphone.xr.interconnect.business.databinder.DataBinderEvent$RequestUpdate> r8 = r3
                            r8.doRequest()
                            goto L_0x02e7
                        L_0x00c5:
                            com.upuphone.xr.interconnect.business.databinder.DataBinderEvent$SendMessage r0 = com.upuphone.xr.interconnect.business.databinder.DataBinderEvent.SendMessage.INSTANCE
                            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r0)
                            if (r0 == 0) goto L_0x00dd
                            com.upuphone.xr.interconnect.business.databinder.DataBinderMessageQueue r8 = r2
                            java.lang.Object r8 = r8.doSend(r10)
                            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                            if (r8 != r9) goto L_0x00da
                            return r8
                        L_0x00da:
                            kotlin.Unit r8 = kotlin.Unit.INSTANCE
                            return r8
                        L_0x00dd:
                            com.upuphone.xr.interconnect.business.databinder.DataBinderEvent$Start r10 = com.upuphone.xr.interconnect.business.databinder.DataBinderEvent.Start.INSTANCE
                            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r10)
                            if (r10 == 0) goto L_0x00f0
                            com.upuphone.xr.interconnect.business.databinder.DataBinderManager r8 = r6
                            kotlinx.coroutines.sync.Semaphore r8 = r8.eventFlowLock
                            r8.release()
                            goto L_0x02e7
                        L_0x00f0:
                            boolean r10 = r9 instanceof com.upuphone.xr.interconnect.business.databinder.DataBinderDeviceEvent.Subscribe
                            if (r10 == 0) goto L_0x0131
                            com.upuphone.xr.interconnect.business.databinder.DataBinderManager r10 = r6
                            com.upuphone.xr.interconnect.business.databinder.DataBinderItemSubscribeManager r10 = r10.getItemSubscribeManager$SharedImpl_intlRelease()
                            com.upuphone.xr.interconnect.business.databinder.DataBinderDeviceEvent$Subscribe r9 = (com.upuphone.xr.interconnect.business.databinder.DataBinderDeviceEvent.Subscribe) r9
                            java.lang.String r0 = r9.getDeviceId()
                            java.lang.String r2 = r9.getName()
                            com.upuphone.xr.interconnect.business.databinder.DataBinderItemUpdateListener r3 = r9.getListener()
                            r10.subscribe(r0, r2, r3)
                            com.upuphone.xr.interconnect.business.databinder.DataBinderItemUpdateListener r10 = r9.getListener()
                            com.upuphone.xr.interconnect.business.databinder.DataBinderManager r8 = r6
                            java.util.Map r8 = r8.allData
                            java.lang.String r0 = r9.getDeviceId()
                            java.lang.Object r8 = r8.get(r0)
                            java.util.Map r8 = (java.util.Map) r8
                            if (r8 == 0) goto L_0x012c
                            java.lang.String r9 = r9.getName()
                            java.lang.Object r8 = r8.get(r9)
                            r1 = r8
                            com.upuphone.xr.interconnect.entity.DataBinderValue r1 = (com.upuphone.xr.interconnect.entity.DataBinderValue) r1
                        L_0x012c:
                            r10.onUpdate(r1)
                            goto L_0x02e7
                        L_0x0131:
                            boolean r10 = r9 instanceof com.upuphone.xr.interconnect.business.databinder.DataBinderDeviceEvent.Unsubscribe
                            if (r10 == 0) goto L_0x014e
                            com.upuphone.xr.interconnect.business.databinder.DataBinderManager r8 = r6
                            com.upuphone.xr.interconnect.business.databinder.DataBinderItemSubscribeManager r8 = r8.getItemSubscribeManager$SharedImpl_intlRelease()
                            com.upuphone.xr.interconnect.business.databinder.DataBinderDeviceEvent$Unsubscribe r9 = (com.upuphone.xr.interconnect.business.databinder.DataBinderDeviceEvent.Unsubscribe) r9
                            java.lang.String r10 = r9.getDeviceId()
                            java.lang.String r0 = r9.getName()
                            com.upuphone.xr.interconnect.business.databinder.DataBinderItemUpdateListener r9 = r9.getListener()
                            r8.unsubscribe((java.lang.String) r10, (java.lang.String) r0, (com.upuphone.xr.interconnect.business.databinder.DataBinderItemUpdateListener) r9)
                            goto L_0x02e7
                        L_0x014e:
                            boolean r10 = r9 instanceof com.upuphone.xr.interconnect.business.databinder.DataBinderDeviceEvent.SubscribeInner
                            if (r10 == 0) goto L_0x018f
                            com.upuphone.xr.interconnect.business.databinder.DataBinderManager r10 = r6
                            com.upuphone.xr.interconnect.business.databinder.DataBinderItemSubscribeManager r10 = r10.getItemSubscribeManager$SharedImpl_intlRelease()
                            com.upuphone.xr.interconnect.business.databinder.DataBinderDeviceEvent$SubscribeInner r9 = (com.upuphone.xr.interconnect.business.databinder.DataBinderDeviceEvent.SubscribeInner) r9
                            java.lang.String r0 = r9.getDeviceId()
                            java.lang.String r2 = r9.getName()
                            com.upuphone.xr.interconnect.common.IDataBinderItemUpdateListener r3 = r9.getListener()
                            r10.subscribeInner(r0, r2, r3)
                            com.upuphone.xr.interconnect.common.IDataBinderItemUpdateListener r10 = r9.getListener()
                            com.upuphone.xr.interconnect.business.databinder.DataBinderManager r8 = r6
                            java.util.Map r8 = r8.allData
                            java.lang.String r0 = r9.getDeviceId()
                            java.lang.Object r8 = r8.get(r0)
                            java.util.Map r8 = (java.util.Map) r8
                            if (r8 == 0) goto L_0x018a
                            java.lang.String r9 = r9.getName()
                            java.lang.Object r8 = r8.get(r9)
                            r1 = r8
                            com.upuphone.xr.interconnect.entity.DataBinderValue r1 = (com.upuphone.xr.interconnect.entity.DataBinderValue) r1
                        L_0x018a:
                            r10.onUpdate(r1)
                            goto L_0x02e7
                        L_0x018f:
                            boolean r10 = r9 instanceof com.upuphone.xr.interconnect.business.databinder.DataBinderDeviceEvent.UnsubscribeInner
                            if (r10 == 0) goto L_0x01ac
                            com.upuphone.xr.interconnect.business.databinder.DataBinderManager r8 = r6
                            com.upuphone.xr.interconnect.business.databinder.DataBinderItemSubscribeManager r8 = r8.getItemSubscribeManager$SharedImpl_intlRelease()
                            com.upuphone.xr.interconnect.business.databinder.DataBinderDeviceEvent$UnsubscribeInner r9 = (com.upuphone.xr.interconnect.business.databinder.DataBinderDeviceEvent.UnsubscribeInner) r9
                            java.lang.String r10 = r9.getDeviceId()
                            java.lang.String r0 = r9.getName()
                            com.upuphone.xr.interconnect.common.IDataBinderItemUpdateListener r9 = r9.getListener()
                            r8.unsubscribeInner(r10, r0, r9)
                            goto L_0x02e7
                        L_0x01ac:
                            boolean r10 = r9 instanceof com.upuphone.xr.interconnect.business.databinder.DataBinderDeviceEvent.HandleOperation
                            if (r10 == 0) goto L_0x029e
                            com.upuphone.xr.interconnect.business.databinder.DataBinderDeviceEvent$HandleOperation r9 = (com.upuphone.xr.interconnect.business.databinder.DataBinderDeviceEvent.HandleOperation) r9
                            com.upuphone.xr.interconnect.business.databinder.DataBinderOperation r10 = r9.getOperation()
                            boolean r0 = r10 instanceof com.upuphone.xr.interconnect.business.databinder.DataBinderOperation.Delete
                            if (r0 == 0) goto L_0x020e
                            com.upuphone.xr.interconnect.business.databinder.DataBinderManager r0 = r6
                            java.util.Map r0 = r0.allData
                            java.lang.String r2 = r9.getDeviceId()
                            java.lang.Object r0 = r0.get(r2)
                            java.util.Map r0 = (java.util.Map) r0
                            if (r0 == 0) goto L_0x0288
                            java.lang.String r2 = r10.getName()
                            java.lang.Object r0 = r0.remove(r2)
                            com.upuphone.xr.interconnect.entity.DataBinderValue r0 = (com.upuphone.xr.interconnect.entity.DataBinderValue) r0
                            if (r0 == 0) goto L_0x0288
                            com.upuphone.xr.interconnect.business.databinder.DataBinderManager r0 = r6
                            com.upuphone.xr.interconnect.business.databinder.DataBinderItemSubscribeManager r0 = r0.getItemSubscribeManager$SharedImpl_intlRelease()
                            java.util.Map r0 = r0.getSubscribers$SharedImpl_intlRelease()
                            java.lang.String r2 = r9.getDeviceId()
                            java.lang.Object r0 = r0.get(r2)
                            java.util.Map r0 = (java.util.Map) r0
                            if (r0 == 0) goto L_0x0288
                            java.lang.String r10 = r10.getName()
                            java.lang.Object r10 = r0.get(r10)
                            java.util.Set r10 = (java.util.Set) r10
                            if (r10 == 0) goto L_0x0288
                            java.util.Iterator r10 = r10.iterator()
                        L_0x01fe:
                            boolean r0 = r10.hasNext()
                            if (r0 == 0) goto L_0x0288
                            java.lang.Object r0 = r10.next()
                            com.upuphone.xr.interconnect.business.databinder.DataBinderItemUpdateListener r0 = (com.upuphone.xr.interconnect.business.databinder.DataBinderItemUpdateListener) r0
                            r0.onUpdate(r1)
                            goto L_0x01fe
                        L_0x020e:
                            boolean r0 = r10 instanceof com.upuphone.xr.interconnect.business.databinder.DataBinderOperation.Update
                            if (r0 == 0) goto L_0x0288
                            com.upuphone.xr.interconnect.business.databinder.DataBinderManager r0 = r6
                            java.util.Map r0 = r0.allData
                            java.lang.String r2 = r9.getDeviceId()
                            java.lang.Object r0 = r0.get(r2)
                            java.util.Map r0 = (java.util.Map) r0
                            if (r0 == 0) goto L_0x0236
                            java.lang.String r2 = r10.getName()
                            r3 = r10
                            com.upuphone.xr.interconnect.business.databinder.DataBinderOperation$Update r3 = (com.upuphone.xr.interconnect.business.databinder.DataBinderOperation.Update) r3
                            com.upuphone.xr.interconnect.entity.DataBinderValue r3 = r3.getValue()
                            java.lang.Object r0 = r0.put(r2, r3)
                            com.upuphone.xr.interconnect.entity.DataBinderValue r0 = (com.upuphone.xr.interconnect.entity.DataBinderValue) r0
                            goto L_0x0237
                        L_0x0236:
                            r0 = r1
                        L_0x0237:
                            if (r0 == 0) goto L_0x023d
                            java.lang.Object r1 = r0.getValue()
                        L_0x023d:
                            r0 = r10
                            com.upuphone.xr.interconnect.business.databinder.DataBinderOperation$Update r0 = (com.upuphone.xr.interconnect.business.databinder.DataBinderOperation.Update) r0
                            com.upuphone.xr.interconnect.entity.DataBinderValue r2 = r0.getValue()
                            java.lang.Object r2 = r2.getValue()
                            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
                            if (r1 != 0) goto L_0x0288
                            com.upuphone.xr.interconnect.business.databinder.DataBinderManager r1 = r6
                            com.upuphone.xr.interconnect.business.databinder.DataBinderItemSubscribeManager r1 = r1.getItemSubscribeManager$SharedImpl_intlRelease()
                            java.util.Map r1 = r1.getSubscribers$SharedImpl_intlRelease()
                            java.lang.String r2 = r9.getDeviceId()
                            java.lang.Object r1 = r1.get(r2)
                            java.util.Map r1 = (java.util.Map) r1
                            if (r1 == 0) goto L_0x0288
                            java.lang.String r10 = r10.getName()
                            java.lang.Object r10 = r1.get(r10)
                            java.util.Set r10 = (java.util.Set) r10
                            if (r10 == 0) goto L_0x0288
                            java.util.Iterator r10 = r10.iterator()
                        L_0x0274:
                            boolean r1 = r10.hasNext()
                            if (r1 == 0) goto L_0x0288
                            java.lang.Object r1 = r10.next()
                            com.upuphone.xr.interconnect.business.databinder.DataBinderItemUpdateListener r1 = (com.upuphone.xr.interconnect.business.databinder.DataBinderItemUpdateListener) r1
                            com.upuphone.xr.interconnect.entity.DataBinderValue r2 = r0.getValue()
                            r1.onUpdate(r2)
                            goto L_0x0274
                        L_0x0288:
                            java.lang.String r10 = r9.getDeviceId()
                            java.lang.String r0 = ""
                            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r0)
                            if (r10 == 0) goto L_0x02e7
                            com.upuphone.xr.interconnect.business.databinder.DataBinderMessageQueue r8 = r2
                            com.upuphone.xr.interconnect.business.databinder.DataBinderOperation r9 = r9.getOperation()
                            r8.onOperation(r9)
                            goto L_0x02e7
                        L_0x029e:
                            boolean r9 = r9 instanceof com.upuphone.xr.interconnect.business.databinder.DataBinderDeviceEvent.HandleRequest
                            if (r9 == 0) goto L_0x02e7
                            com.upuphone.xr.interconnect.business.databinder.DataBinderManager r9 = r6
                            java.util.Map r9 = r9.localData
                            java.util.Set r9 = r9.entrySet()
                            com.upuphone.xr.interconnect.business.databinder.DataBinderMessageQueue r10 = r2
                            java.util.Iterator r9 = r9.iterator()
                        L_0x02b2:
                            boolean r0 = r9.hasNext()
                            if (r0 == 0) goto L_0x02d3
                            java.lang.Object r0 = r9.next()
                            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
                            java.lang.Object r1 = r0.getKey()
                            java.lang.String r1 = (java.lang.String) r1
                            java.lang.Object r0 = r0.getValue()
                            com.upuphone.xr.interconnect.entity.DataBinderValue r0 = (com.upuphone.xr.interconnect.entity.DataBinderValue) r0
                            com.upuphone.xr.interconnect.business.databinder.DataBinderOperation$Update r2 = new com.upuphone.xr.interconnect.business.databinder.DataBinderOperation$Update
                            r2.<init>(r1, r0)
                            r10.onOperation(r2)
                            goto L_0x02b2
                        L_0x02d3:
                            java.lang.String r9 = com.upuphone.xr.interconnect.business.databinder.EnvironmentExtKt.getConnectedDeviceId()
                            if (r9 == 0) goto L_0x02e7
                            com.upuphone.xr.interconnect.business.databinder.DataBinderManager r8 = r6
                            kotlinx.coroutines.flow.MutableSharedFlow r8 = r8.eventFlow
                            com.upuphone.xr.interconnect.business.databinder.DataBinderDeviceEvent$ServiceUp r10 = new com.upuphone.xr.interconnect.business.databinder.DataBinderDeviceEvent$ServiceUp
                            r10.<init>(r9)
                            com.upuphone.xr.interconnect.util.statemachine.FlowExtKt.emitOrErr(r8, r10)
                        L_0x02e7:
                            kotlin.Unit r8 = kotlin.Unit.INSTANCE
                            return r8
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.interconnect.business.databinder.DataBinderManager.AnonymousClass1.AnonymousClass1.emit(com.upuphone.xr.interconnect.business.databinder.DataBinderEvent, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                };
                this.label = 1;
                if (J.collect(r5, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/upuphone/xr/interconnect/business/databinder/DataBinderManager$Companion;", "", "()V", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "operationArrayType", "Ljava/lang/Class;", "", "Lcom/upuphone/xr/interconnect/business/databinder/DataBinderOperation;", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Gson getGson() {
            return DataBinderManager.gson;
        }

        private Companion() {
        }
    }

    static {
        Gson create = new GsonBuilder().registerTypeAdapter(DataBinderOperation.class, new DataBinderOperationTypeAdapter()).create();
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        gson = create;
    }

    public DataBinderManager() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.allData = concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        this.localData = concurrentHashMap2;
        CoroutineScope a2 = CoroutineScopeKt.a(Dispatchers.a().plus(SupervisorKt.b((Job) null, 1, (Object) null)));
        this.scope = a2;
        concurrentHashMap.put("", concurrentHashMap2);
        Job unused = BuildersKt__Builders_commonKt.d(a2, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this, (Continuation<? super AnonymousClass1>) null), 3, (Object) null);
        this.requestHandler = new DataBinderManager$requestHandler$1(this);
    }

    @Nullable
    public DataBinderValue<?> get(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str2, "name");
        ILog.d(IDataBinder.TAG, "Getting data on " + str + " with name " + str2 + ".");
        Map map = this.allData.get(str);
        if (map != null) {
            return (DataBinderValue) map.get(str2);
        }
        return null;
    }

    public int getHandleType() {
        return 15;
    }

    @NotNull
    public final DataBinderItemSubscribeManager getItemSubscribeManager$SharedImpl_intlRelease() {
        return this.itemSubscribeManager;
    }

    @NotNull
    public final MessageHandler getRequestHandler() {
        return this.requestHandler;
    }

    public void handle(@Nullable StarryNetMessage starryNetMessage, @Nullable Function function) {
        String connectedDeviceId = EnvironmentExtKt.getConnectedDeviceId();
        if (connectedDeviceId != null && function != null && starryNetMessage != null) {
            DataBinderOperation[] dataBinderOperationArr = (DataBinderOperation[]) function.parseData(gson, operationArrayType);
            Intrinsics.checkNotNull(dataBinderOperationArr);
            String joinToString$default = ArraysKt.joinToString$default((Object[]) dataBinderOperationArr, (CharSequence) "; ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
            ILog.d(IDataBinder.TAG, "Handling update operations [" + joinToString$default + "].");
            Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new DataBinderManager$handle$1(this, dataBinderOperationArr, connectedDeviceId, (Continuation<? super DataBinderManager$handle$1>) null), 3, (Object) null);
        }
    }

    @Nullable
    public List<String> list(@NotNull String str) {
        Set keySet;
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Map map = this.allData.get(str);
        if (map == null || (keySet = map.keySet()) == null) {
            return null;
        }
        return CollectionsKt.toList(keySet);
    }

    public final void onRemoteServiceDied(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new DataBinderManager$onRemoteServiceDied$1(this, str, (Continuation<? super DataBinderManager$onRemoteServiceDied$1>) null), 3, (Object) null);
    }

    public final void onRemoteServiceStarted(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new DataBinderManager$onRemoteServiceStarted$1(this, str, (Continuation<? super DataBinderManager$onRemoteServiceStarted$1>) null), 3, (Object) null);
    }

    public void set(@NotNull String str, @NotNull DataBinderValue<?> dataBinderValue) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(dataBinderValue, AccountConstantKt.RESPONSE_VALUE);
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new DataBinderManager$set$1(this, str, dataBinderValue, (Continuation<? super DataBinderManager$set$1>) null), 3, (Object) null);
    }

    public final void subscribe(@NotNull String str, @NotNull String str2, @NotNull DataBinderItemUpdateListener dataBinderItemUpdateListener) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(dataBinderItemUpdateListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new DataBinderManager$subscribe$1(this, str, str2, dataBinderItemUpdateListener, (Continuation<? super DataBinderManager$subscribe$1>) null), 3, (Object) null);
    }

    public void unset(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new DataBinderManager$unset$1(this, str, (Continuation<? super DataBinderManager$unset$1>) null), 3, (Object) null);
    }

    public final void unsubscribe(@NotNull String str, @NotNull String str2, @NotNull DataBinderItemUpdateListener dataBinderItemUpdateListener) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(dataBinderItemUpdateListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new DataBinderManager$unsubscribe$1(this, str, str2, dataBinderItemUpdateListener, (Continuation<? super DataBinderManager$unsubscribe$1>) null), 3, (Object) null);
    }

    public final void updateAllData(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new DataBinderManager$updateAllData$1(this, str, (Continuation<? super DataBinderManager$updateAllData$1>) null), 3, (Object) null);
    }

    public void subscribe(@NotNull String str, @NotNull String str2, @NotNull IDataBinderItemUpdateListener iDataBinderItemUpdateListener) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(iDataBinderItemUpdateListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new DataBinderManager$subscribe$2(this, str, str2, iDataBinderItemUpdateListener, (Continuation<? super DataBinderManager$subscribe$2>) null), 3, (Object) null);
    }

    public void unsubscribe(@NotNull String str, @NotNull String str2, @NotNull IDataBinderItemUpdateListener iDataBinderItemUpdateListener) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(iDataBinderItemUpdateListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new DataBinderManager$unsubscribe$2(this, str, str2, iDataBinderItemUpdateListener, (Continuation<? super DataBinderManager$unsubscribe$2>) null), 3, (Object) null);
    }
}
