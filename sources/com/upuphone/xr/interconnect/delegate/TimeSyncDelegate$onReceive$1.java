package com.upuphone.xr.interconnect.delegate;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.common.IMessageSendListener;
import com.upuphone.xr.interconnect.entity.Function;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.entity.SyncTimeResponseInfo;
import com.upuphone.xr.interconnect.main.StarryNetMessageFactory;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.interconnect.delegate.TimeSyncDelegate$onReceive$1", f = "TimeSyncDelegate.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TimeSyncDelegate$onReceive$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public TimeSyncDelegate$onReceive$1(Continuation<? super TimeSyncDelegate$onReceive$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TimeSyncDelegate$onReceive$1 timeSyncDelegate$onReceive$1 = new TimeSyncDelegate$onReceive$1(continuation);
        timeSyncDelegate$onReceive$1.L$0 = obj;
        return timeSyncDelegate$onReceive$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            try {
                Result.Companion companion = Result.Companion;
                ULog.f6446a.c("TimeSyncDelegate", "TimeSyncDelegate onReceive");
                StarryNetMessage createInnerMessage = StarryNetMessageFactory.createInnerMessage();
                createInnerMessage.setMessage(new Function(3, new SyncTimeResponseInfo(System.currentTimeMillis(), TimeZone.getDefault().getID())).toString());
                InterconnectManager.getInstance().getStarryNetMessenger().sendMessage(createInnerMessage, (IMessageSendListener) null);
                Result.m20constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.m20constructorimpl(ResultKt.createFailure(th));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TimeSyncDelegate$onReceive$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
