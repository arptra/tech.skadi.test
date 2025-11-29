package com.upuphone.xr.interconnect.business.connect;

import android.os.RemoteException;
import com.upuphone.xr.interconnect.util.log.ILog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "L", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.interconnect.business.connect.ConnectionListenerManager$safeCallRemoteListener$1", f = "ConnectionListenerManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ConnectionListenerManager$safeCallRemoteListener$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<L, Unit> $action;
    final /* synthetic */ L $this_safeCallRemoteListener;
    int label;
    final /* synthetic */ ConnectionListenerManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConnectionListenerManager$safeCallRemoteListener$1(Function1<? super L, Unit> function1, L l, ConnectionListenerManager connectionListenerManager, Continuation<? super ConnectionListenerManager$safeCallRemoteListener$1> continuation) {
        super(2, continuation);
        this.$action = function1;
        this.$this_safeCallRemoteListener = l;
        this.this$0 = connectionListenerManager;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ConnectionListenerManager$safeCallRemoteListener$1(this.$action, this.$this_safeCallRemoteListener, this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                this.$action.invoke(this.$this_safeCallRemoteListener);
            } catch (RemoteException e) {
                e.printStackTrace();
                String access$getTag = this.this$0.getTag();
                String localizedMessage = e.getLocalizedMessage();
                ILog.e(access$getTag, "Failed calling remote listener: " + localizedMessage);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ConnectionListenerManager$safeCallRemoteListener$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
