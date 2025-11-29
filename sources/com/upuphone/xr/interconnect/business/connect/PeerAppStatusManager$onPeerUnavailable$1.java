package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.xr.interconnect.petastep.PetaStepSerializer;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class PeerAppStatusManager$onPeerUnavailable$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $deviceId;
    final /* synthetic */ PeerAppStatusManager this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.xr.interconnect.business.connect.PeerAppStatusManager$onPeerUnavailable$1$1", f = "PeerAppStatusManager.kt", i = {}, l = {76}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.xr.interconnect.business.connect.PeerAppStatusManager$onPeerUnavailable$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(peerAppStatusManager, str3, continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.b(500, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            final PeerAppStatusManager peerAppStatusManager = peerAppStatusManager;
            final String str = str3;
            peerAppStatusManager.serialize("check if removal on " + str3 + " is real", new Function0<Unit>() {
                public final void invoke() {
                    Set<String> bleConnectedGlassDeviceIds = peerAppStatusManager.baseConnectionManager.getBleConnectedGlassDeviceIds();
                    String str = str;
                    if (!(bleConnectedGlassDeviceIds instanceof Collection) || !bleConnectedGlassDeviceIds.isEmpty()) {
                        Iterator<T> it = bleConnectedGlassDeviceIds.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            } else if (Intrinsics.areEqual((Object) (String) it.next(), (Object) str)) {
                                if (!peerAppStatusManager.reportedAvailableDeviceIds.contains(str)) {
                                    String access$getTag = peerAppStatusManager.getTag();
                                    String str2 = str;
                                    ILog.d(access$getTag, "Peer on " + str2 + " is really removed.");
                                    peerAppStatusManager.removalConfirmationJobMap.remove(str);
                                    peerAppStatusManager.confirmedAvailableDeviceIds.remove(str);
                                    peerAppStatusManager.appearedInstallationStateFlow.setValue(Boolean.FALSE);
                                    return;
                                }
                            }
                        }
                    }
                    String access$getTag2 = peerAppStatusManager.getTag();
                    String str3 = str;
                    ILog.d(access$getTag2, "Peer on " + str3 + " is not really removed.");
                }
            });
            return Unit.INSTANCE;
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PeerAppStatusManager$onPeerUnavailable$1(PeerAppStatusManager peerAppStatusManager, String str) {
        super(0);
        this.this$0 = peerAppStatusManager;
        this.$deviceId = str;
    }

    public final void invoke() {
        String access$getTag = this.this$0.getTag();
        String str = this.$deviceId;
        ILog.d(access$getTag, "Peer on " + str + " is reported to be removed.");
        this.this$0.reportedAvailableDeviceIds.remove(this.$deviceId);
        Job job = (Job) this.this$0.removalConfirmationJobMap.get(this.$deviceId);
        if (job != null) {
            Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
        }
        HashMap access$getRemovalConfirmationJobMap$p = this.this$0.removalConfirmationJobMap;
        String str2 = this.$deviceId;
        CoroutineScope scope = PetaStepSerializer.Companion.getScope();
        final PeerAppStatusManager peerAppStatusManager = this.this$0;
        final String str3 = this.$deviceId;
        access$getRemovalConfirmationJobMap$p.put(str2, BuildersKt__Builders_commonKt.d(scope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null));
    }
}
