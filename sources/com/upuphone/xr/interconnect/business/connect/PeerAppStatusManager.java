package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.runasone.constant.Constants;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.api.StarryNetAppChangeListener;
import com.upuphone.xr.interconnect.api.StarryNetAppManager;
import com.upuphone.xr.interconnect.api.StarryNetAppManagerImpl;
import com.upuphone.xr.interconnect.petastep.PetaStepSerializer;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bH\u0016J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bH\u0016J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bH\u0016J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bH\u0016J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bH\u0016J\u0010\u0010\u001b\u001a\u00020\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dR\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R*\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00110\u0010j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0011`\u0012X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/upuphone/xr/interconnect/business/connect/PeerAppStatusManager;", "Lcom/upuphone/xr/interconnect/petastep/PetaStepSerializer;", "Lcom/upuphone/xr/interconnect/business/connect/PeerStateListener;", "baseConnectionManager", "Lcom/upuphone/xr/interconnect/business/connect/BaseConnectionManager;", "(Lcom/upuphone/xr/interconnect/business/connect/BaseConnectionManager;)V", "appearedInstallationStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "confirmedAvailableDeviceIds", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "removalConfirmationJobMap", "Ljava/util/HashMap;", "Lkotlinx/coroutines/Job;", "Lkotlin/collections/HashMap;", "reportedAvailableDeviceIds", "onPeerAvailable", "", "deviceId", "onPeerNegotiated", "onPeerStarted", "onPeerStopped", "onPeerUnavailable", "warmUpListener", "listener", "Lcom/upuphone/xr/interconnect/api/StarryNetAppChangeListener;", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PeerAppStatusManager extends PetaStepSerializer implements PeerStateListener {
    /* access modifiers changed from: private */
    @NotNull
    public final MutableStateFlow<Boolean> appearedInstallationStateFlow = StateFlowKt.a((Object) null);
    /* access modifiers changed from: private */
    @NotNull
    public final BaseConnectionManager baseConnectionManager;
    /* access modifiers changed from: private */
    @NotNull
    public final HashSet<String> confirmedAvailableDeviceIds = new HashSet<>();
    @NotNull
    private final CoroutineScope mainScope;
    /* access modifiers changed from: private */
    @NotNull
    public final HashMap<String, Job> removalConfirmationJobMap = new HashMap<>();
    /* access modifiers changed from: private */
    @NotNull
    public final HashSet<String> reportedAvailableDeviceIds = new HashSet<>();

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.xr.interconnect.business.connect.PeerAppStatusManager$2", f = "PeerAppStatusManager.kt", i = {}, l = {28}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.xr.interconnect.business.connect.PeerAppStatusManager$2  reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PeerAppStatusManager this$0;

        {
            this.this$0 = r1;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableStateFlow access$getAppearedInstallationStateFlow$p = this.this$0.appearedInstallationStateFlow;
                final PeerAppStatusManager peerAppStatusManager = this.this$0;
                AnonymousClass1 r1 = new FlowCollector() {
                    @Nullable
                    public final Object emit(@Nullable Boolean bool, @NotNull Continuation<? super Unit> continuation) {
                        String access$getTag = peerAppStatusManager.getTag();
                        ILog.d(access$getTag, "Happened appeared installation state update: " + bool);
                        if (Intrinsics.areEqual((Object) bool, (Object) Boxing.boxBoolean(true))) {
                            StarryNetAppManager starryNetAppManager = InterconnectManager.getInstance().getStarryNetAppManager();
                            Intrinsics.checkNotNull(starryNetAppManager, "null cannot be cast to non-null type com.upuphone.xr.interconnect.api.StarryNetAppManagerImpl");
                            ((StarryNetAppManagerImpl) starryNetAppManager).notifyPeerAppInstalled();
                        } else if (Intrinsics.areEqual((Object) bool, (Object) Boxing.boxBoolean(false))) {
                            StarryNetAppManager starryNetAppManager2 = InterconnectManager.getInstance().getStarryNetAppManager();
                            Intrinsics.checkNotNull(starryNetAppManager2, "null cannot be cast to non-null type com.upuphone.xr.interconnect.api.StarryNetAppManagerImpl");
                            ((StarryNetAppManagerImpl) starryNetAppManager2).notifyPeerAppRemoved();
                        }
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (access$getAppearedInstallationStateFlow$p.collect(r1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PeerAppStatusManager(@NotNull BaseConnectionManager baseConnectionManager2) {
        super(AnonymousClass1.INSTANCE, (String) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(baseConnectionManager2, "baseConnectionManager");
        this.baseConnectionManager = baseConnectionManager2;
        CoroutineScope a2 = CoroutineScopeKt.a(Dispatchers.c().getImmediate().plus(SupervisorKt.b((Job) null, 1, (Object) null)));
        this.mainScope = a2;
        Job unused = BuildersKt__Builders_commonKt.d(a2, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass2(this, (Continuation<? super AnonymousClass2>) null), 3, (Object) null);
    }

    public void onPeerAvailable(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        serialize("peer available", new PeerAppStatusManager$onPeerAvailable$1(this, str));
    }

    public void onPeerNegotiated(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        onPeerAvailable(str);
    }

    public void onPeerStarted(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        onPeerAvailable(str);
    }

    public void onPeerStopped(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
    }

    public void onPeerUnavailable(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        serialize("peer unavailable", new PeerAppStatusManager$onPeerUnavailable$1(this, str));
    }

    public final void warmUpListener(@Nullable StarryNetAppChangeListener starryNetAppChangeListener) {
        serialize("warm up " + starryNetAppChangeListener, new PeerAppStatusManager$warmUpListener$1(this, starryNetAppChangeListener));
    }
}
