package com.upuphone.xr.interconnect.business.connect.primary;

import com.upuphone.starrynetsdk.ability.relay.RemoteListener;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.HashMap;
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
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class VersionSendManager$retryVersionSend$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ RemoteListener $callback;
    final /* synthetic */ String $deviceId;
    final /* synthetic */ int $version;
    final /* synthetic */ VersionSendManager this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.xr.interconnect.business.connect.primary.VersionSendManager$retryVersionSend$1$1", f = "VersionSendManager.kt", i = {}, l = {55}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.xr.interconnect.business.connect.primary.VersionSendManager$retryVersionSend$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(versionSendManager, str3, i2, remoteListener, continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.b(5000, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            versionSendManager.sendVersion(str3, i2, remoteListener);
            return Unit.INSTANCE;
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VersionSendManager$retryVersionSend$1(VersionSendManager versionSendManager, int i, String str, RemoteListener remoteListener) {
        super(0);
        this.this$0 = versionSendManager;
        this.$version = i;
        this.$deviceId = str;
        this.$callback = remoteListener;
    }

    public final void invoke() {
        String access$getTag = this.this$0.getTag();
        int i = this.$version;
        String str = this.$deviceId;
        ILog.d(access$getTag, "Retrying to send version " + i + " to #" + str + ".");
        HashMap access$getVersionSendJobMap$p = this.this$0.versionSendJobMap;
        String str2 = this.$deviceId;
        CoroutineScope access$getJobScope$p = this.this$0.jobScope;
        final VersionSendManager versionSendManager = this.this$0;
        final String str3 = this.$deviceId;
        final int i2 = this.$version;
        final RemoteListener remoteListener = this.$callback;
        access$getVersionSendJobMap$p.put(str2, BuildersKt__Builders_commonKt.d(access$getJobScope$p, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null));
    }
}
