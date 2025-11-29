package com.upuphone.xr.interconnect.business.messenger;

import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.common.IMessageReceiver;
import com.upuphone.xr.interconnect.common.IMessageTransport;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.ipc.IpcClientManager;
import com.upuphone.xr.interconnect.main.dispatcher.MessageDispatcher;
import com.upuphone.xr.interconnect.petastep.PetaStepSerializer;
import com.upuphone.xr.interconnect.remote.BinderClient;
import com.upuphone.xr.interconnect.remote.BinderClientDiedCallback;
import com.upuphone.xr.interconnect.util.collection.Buckets;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H@¢\u0006\u0002\u0010\u0015J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/upuphone/xr/interconnect/business/messenger/IpcMessageDispatcher;", "Lcom/upuphone/xr/interconnect/petastep/PetaStepSerializer;", "Lcom/upuphone/xr/interconnect/main/dispatcher/MessageDispatcher;", "Lcom/upuphone/xr/interconnect/remote/BinderClientDiedCallback;", "()V", "receiverBuckets", "Lcom/upuphone/xr/interconnect/util/collection/Buckets;", "", "Lcom/upuphone/xr/interconnect/common/IMessageReceiver;", "receiverIds", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "transporter", "Lcom/upuphone/xr/interconnect/common/IMessageTransport$Stub;", "getTransporter", "()Lcom/upuphone/xr/interconnect/common/IMessageTransport$Stub;", "dispatch", "", "message", "Lcom/upuphone/xr/interconnect/entity/StarryNetMessage;", "(Lcom/upuphone/xr/interconnect/entity/StarryNetMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onClientDied", "", "client", "Lcom/upuphone/xr/interconnect/remote/BinderClient;", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class IpcMessageDispatcher extends PetaStepSerializer implements MessageDispatcher, BinderClientDiedCallback {
    /* access modifiers changed from: private */
    @NotNull
    public final Buckets<Integer, IMessageReceiver> receiverBuckets = new Buckets<>();
    /* access modifiers changed from: private */
    @NotNull
    public final HashSet<String> receiverIds = new HashSet<>();
    @NotNull
    private final IMessageTransport.Stub transporter = new IpcMessageDispatcher$transporter$1(this);

    public IpcMessageDispatcher() {
        super(AnonymousClass1.INSTANCE, "iMGdTE");
        InterconnectManager.getInstance().getMainDispatcher().addMessageDispatcher(this);
        IpcClientManager.INSTANCE.addListener(this);
    }

    @Nullable
    public Object dispatch(@NotNull StarryNetMessage starryNetMessage, @NotNull Continuation<? super Boolean> continuation) {
        CompletableDeferred a2 = CompletableDeferredKt.a(Boxing.boxBoolean(false));
        serialize("dispatching", new IpcMessageDispatcher$dispatch$2(starryNetMessage, this, a2));
        return a2.c(continuation);
    }

    @NotNull
    public final IMessageTransport.Stub getTransporter() {
        return this.transporter;
    }

    public void onClientDied(@Nullable BinderClient binderClient) {
        serialize("client death", new IpcMessageDispatcher$onClientDied$1(binderClient, this));
    }
}
