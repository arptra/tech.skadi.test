package com.upuphone.xr.interconnect.resource;

import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.common.IResourceManager;
import com.upuphone.xr.interconnect.entity.Function;
import com.upuphone.xr.interconnect.entity.ResourceDescription;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.main.StarryNetMessageFactory;
import com.upuphone.xr.interconnect.util.log.ILog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nResourceManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ResourceManager.kt\ncom/upuphone/xr/interconnect/resource/ResourceManager$openResource$2\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,120:1\n314#2,11:121\n*S KotlinDebug\n*F\n+ 1 ResourceManager.kt\ncom/upuphone/xr/interconnect/resource/ResourceManager$openResource$2\n*L\n91#1:121,11\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.interconnect.resource.ResourceManager$openResource$2", f = "ResourceManager.kt", i = {0}, l = {121}, m = "invokeSuspend", n = {"message"}, s = {"L$0"})
public final class ResourceManager$openResource$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $deviceId;
    final /* synthetic */ String $identifier;
    final /* synthetic */ byte $type;
    byte B$0;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ResourceManager$openResource$2(String str, byte b, String str2, Continuation<? super ResourceManager$openResource$2> continuation) {
        super(2, continuation);
        this.$identifier = str;
        this.$type = b;
        this.$deviceId = str2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ResourceManager$openResource$2(this.$identifier, this.$type, this.$deviceId, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (InterconnectManager.getInstance().getStarryNetDeviceManager().getConnectedDevice() == null) {
                String str = this.$identifier;
                byte b = this.$type;
                ILog.d(IResourceManager.TAG, "Cannot open resource " + str + "(" + b + ") as no remote device is connected.");
                return Unit.INSTANCE;
            }
            ResourceDescription resourceDescription = new ResourceDescription();
            String str2 = this.$deviceId;
            byte b2 = this.$type;
            String str3 = this.$identifier;
            resourceDescription.deviceId = str2;
            resourceDescription.type = (byte) b2;
            resourceDescription.identifier = str3;
            ResourceOpenInfo resourceOpenInfo = new ResourceOpenInfo(resourceDescription);
            StarryNetMessage createInnerMessage = StarryNetMessageFactory.createInnerMessage();
            createInnerMessage.setMessage(new Function(17, resourceOpenInfo).toString());
            String str4 = this.$identifier;
            byte b3 = this.$type;
            this.L$0 = createInnerMessage;
            this.L$1 = str4;
            this.B$0 = b3;
            this.label = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
            cancellableContinuationImpl.x();
            InterconnectManager.getInstance().getStarryNetMessenger().sendMessage(createInnerMessage, new ResourceManager$openResource$2$1$1(str4, (byte) b3, cancellableContinuationImpl));
            Object u = cancellableContinuationImpl.u();
            if (u == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(this);
            }
            if (u == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            String str5 = (String) this.L$1;
            StarryNetMessage starryNetMessage = (StarryNetMessage) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ResourceManager$openResource$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
