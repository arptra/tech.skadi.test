package com.upuphone.xr.interconnect.business.databinder;

import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.api.StarryNetMessenger;
import com.upuphone.xr.interconnect.common.IDataBinder;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import com.upuphone.xr.interconnect.main.StarryNetMessageFactory;
import com.upuphone.xr.interconnect.util.log.ILog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.interconnect.business.databinder.FullDataRequester$doRequest$1", f = "FullDataRequester.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FullDataRequester$doRequest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FullDataRequester<E> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FullDataRequester$doRequest$1(FullDataRequester<E> fullDataRequester, Continuation<? super FullDataRequester$doRequest$1> continuation) {
        super(2, continuation);
        this.this$0 = fullDataRequester;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FullDataRequester$doRequest$1 fullDataRequester$doRequest$1 = new FullDataRequester$doRequest$1(this.this$0, continuation);
        fullDataRequester$doRequest$1.L$0 = obj;
        return fullDataRequester$doRequest$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            StarryNetMessage createInnerMessage = StarryNetMessageFactory.createInnerMessage();
            createInnerMessage.setMessage(FullDataRequesterKt.getRequestMessage());
            StarryNetMessenger starryNetMessenger = InterconnectManager.getInstance().getStarryNetMessenger();
            final FullDataRequester<E> fullDataRequester = this.this$0;
            starryNetMessenger.sendMessage(createInnerMessage, new SendMessageListener() {
                public void onFail(@Nullable String str, int i) {
                    ILog.d(IDataBinder.TAG, "Request message not sent due to error " + i + ": " + str + ".");
                    Job unused = BuildersKt__Builders_commonKt.d(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new FullDataRequester$doRequest$1$1$onFail$1(fullDataRequester, (Continuation<? super FullDataRequester$doRequest$1$1$onFail$1>) null), 3, (Object) null);
                }

                public void onSuccess(@Nullable String str) {
                    ILog.d(IDataBinder.TAG, "Request message successfully sent.");
                    fullDataRequester.lastRequestJob = null;
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FullDataRequester$doRequest$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
