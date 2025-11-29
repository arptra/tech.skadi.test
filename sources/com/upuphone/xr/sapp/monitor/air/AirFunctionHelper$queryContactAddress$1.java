package com.upuphone.xr.sapp.monitor.air;

import com.upuphone.xr.interconnect.listener.SendMessageListener;
import com.upuphone.xr.sapp.monitor.starry.StarryMessageHelper;
import com.upuphone.xr.sapp.utils.ContactHelper;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.monitor.air.AirFunctionHelper$queryContactAddress$1", f = "AirFunctionHelper.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, s = {})
public final class AirFunctionHelper$queryContactAddress$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AirRequestModel $model;
    final /* synthetic */ AirResultModel $resultModel;
    int label;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.xr.sapp.monitor.air.AirFunctionHelper$queryContactAddress$1$1", f = "AirFunctionHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.xr.sapp.monitor.air.AirFunctionHelper$queryContactAddress$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(airResultModel, airRequestModel, continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                StarryMessageHelper.p(StarryMessageHelper.f7799a, (byte[]) null, "AIR_FUNCTION", airResultModel, (SendMessageListener) null, airRequestModel.getTargetPackage(), 9, (Object) null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AirFunctionHelper$queryContactAddress$1(AirRequestModel airRequestModel, AirResultModel airResultModel, Continuation<? super AirFunctionHelper$queryContactAddress$1> continuation) {
        super(2, continuation);
        this.$model = airRequestModel;
        this.$resultModel = airResultModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AirFunctionHelper$queryContactAddress$1(this.$model, this.$resultModel, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String valueOf = String.valueOf(this.$model.getParam().get("phoneNo"));
            HashMap<String, Object> data = this.$resultModel.getData();
            ContactHelper contactHelper = ContactHelper.f7857a;
            data.put("geo", contactHelper.d(valueOf));
            this.$resultModel.getData().put("displayName", contactHelper.c(valueOf));
            MainCoroutineDispatcher c = Dispatchers.c();
            final AirResultModel airResultModel = this.$resultModel;
            final AirRequestModel airRequestModel = this.$model;
            AnonymousClass1 r1 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.label = 1;
            if (BuildersKt.g(c, r1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AirFunctionHelper$queryContactAddress$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
