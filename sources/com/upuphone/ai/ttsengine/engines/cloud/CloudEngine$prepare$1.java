package com.upuphone.ai.ttsengine.engines.cloud;

import com.upuphone.ai.ttsengine.base.utils.AILOG;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nCloudEngine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CloudEngine.kt\ncom/upuphone/ai/ttsengine/engines/cloud/CloudEngine$prepare$1\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n*L\n1#1,659:1\n120#2,10:660\n*S KotlinDebug\n*F\n+ 1 CloudEngine.kt\ncom/upuphone/ai/ttsengine/engines/cloud/CloudEngine$prepare$1\n*L\n156#1:660,10\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ai.ttsengine.engines.cloud.CloudEngine$prepare$1", f = "CloudEngine.kt", i = {0}, l = {665}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
public final class CloudEngine$prepare$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ CloudEngine this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CloudEngine$prepare$1(CloudEngine cloudEngine, Continuation<? super CloudEngine$prepare$1> continuation) {
        super(2, continuation);
        this.this$0 = cloudEngine;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CloudEngine$prepare$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Mutex mutex;
        CloudEngine cloudEngine;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            mutex = this.this$0.connectLock;
            CloudEngine cloudEngine2 = this.this$0;
            this.L$0 = mutex;
            this.L$1 = cloudEngine2;
            this.label = 1;
            if (mutex.c((Object) null, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            cloudEngine = cloudEngine2;
        } else if (i == 1) {
            cloudEngine = (CloudEngine) this.L$1;
            mutex = (Mutex) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        try {
            if (cloudEngine.webSocket == null) {
                cloudEngine.getAiLog().c("prepare create new websocket", new Object[0]);
                cloudEngine.webSocket = new TtsWebsocket(cloudEngine.audioListener);
                TtsWebsocket access$getWebSocket$p = cloudEngine.webSocket;
                Intrinsics.checkNotNull(access$getWebSocket$p);
                String uuid = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
                if (!access$getWebSocket$p.connect(uuid)) {
                    cloudEngine.getAiLog().c("prepare websocket connect failed", new Object[0]);
                }
            } else {
                AILOG access$getAiLog = cloudEngine.getAiLog();
                TtsWebsocket access$getWebSocket$p2 = cloudEngine.webSocket;
                access$getAiLog.c("prepare websocket reused: " + access$getWebSocket$p2, new Object[0]);
            }
            Unit unit = Unit.INSTANCE;
            mutex.d((Object) null);
            this.this$0.scheduleCloseWS(true);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            mutex.d((Object) null);
            throw th;
        }
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CloudEngine$prepare$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
