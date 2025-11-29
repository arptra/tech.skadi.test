package com.upuphone.ar.tici.phone.starrynet;

import com.upuphone.ar.tici.phone.TiciApp;
import com.upuphone.ar.tici.phone.TiciAppViewModel;
import com.upuphone.ar.tici.phone.data.OpenTiciFrom;
import com.upuphone.ar.tici.phone.db.TiciDao;
import com.upuphone.ar.tici.phone.starrynet.msg.SendContentPageRequest;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.starrynet.ReceiveMsgHandler$onRequestSendContentPage$1", f = "ReceiveMsgHandler.kt", i = {}, l = {353}, m = "invokeSuspend", n = {}, s = {})
public final class ReceiveMsgHandler$onRequestSendContentPage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $id;
    final /* synthetic */ SendContentPageRequest $request;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReceiveMsgHandler$onRequestSendContentPage$1(SendContentPageRequest sendContentPageRequest, long j, Continuation<? super ReceiveMsgHandler$onRequestSendContentPage$1> continuation) {
        super(2, continuation);
        this.$request = sendContentPageRequest;
        this.$id = j;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ReceiveMsgHandler$onRequestSendContentPage$1(this.$request, this.$id, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            TiciDao w = TiciApp.b.w();
            int targetPage = this.$request.getTargetPage();
            long j = this.$id;
            this.label = 1;
            if (w.w(targetPage, 0, j, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        TiciApp ticiApp = TiciApp.b;
        ticiApp.c().y0(this.$request);
        TiciAppViewModel.N0(ticiApp.c(), this.$id, OpenTiciFrom.Glass, false, false, Boxing.boxInt(this.$request.getTargetPage()), Boxing.boxInt(0), 4, (Object) null);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ReceiveMsgHandler$onRequestSendContentPage$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
