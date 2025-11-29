package com.upuphone.xr.interconnect.business.messenger;

import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.main.dispatcher.MessageDispatcher;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.interconnect.business.messenger.MainMessageDispatcher$dispatch$1", f = "MainMessageDispatcher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MainMessageDispatcher$dispatch$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CopyOnWriteArraySet<MessageDispatcher> $dispatchers;
    final /* synthetic */ String $logTag;
    final /* synthetic */ StarryNetMessage $message;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MainMessageDispatcher$dispatch$1(CopyOnWriteArraySet<MessageDispatcher> copyOnWriteArraySet, String str, StarryNetMessage starryNetMessage, Continuation<? super MainMessageDispatcher$dispatch$1> continuation) {
        super(2, continuation);
        this.$dispatchers = copyOnWriteArraySet;
        this.$logTag = str;
        this.$message = starryNetMessage;
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(Ref.BooleanRef booleanRef, StarryNetMessage starryNetMessage, MessageDispatcher messageDispatcher) {
        Object unused = BuildersKt__BuildersKt.b((CoroutineContext) null, new MainMessageDispatcher$dispatch$1$1$1(booleanRef, messageDispatcher, starryNetMessage, (Continuation<? super MainMessageDispatcher$dispatch$1$1$1>) null), 1, (Object) null);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MainMessageDispatcher$dispatch$1(this.$dispatchers, this.$logTag, this.$message, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            this.$dispatchers.forEach(new b(booleanRef, this.$message));
            if (!booleanRef.element) {
                String str = this.$logTag;
                String id = this.$message.getId();
                String receiverPkg = this.$message.getReceiverPkg();
                ILog.w(str, "#" + id + " to " + receiverPkg + " is not consumed by any dispatcher.");
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MainMessageDispatcher$dispatch$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
