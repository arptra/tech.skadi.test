package com.upuphone.xr.sapp.monitor.net;

import com.upuphone.star.core.log.ULog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.monitor.net.TokenUtil$requestNewGwToken$2", f = "TokenUtil.kt", i = {}, l = {118}, m = "invokeSuspend", n = {}, s = {})
public final class TokenUtil$requestNewGwToken$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $mzToken;
    int label;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.xr.sapp.monitor.net.TokenUtil$requestNewGwToken$2$1", f = "TokenUtil.kt", i = {}, l = {123}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.xr.sapp.monitor.net.TokenUtil$requestNewGwToken$2$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(str, continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            boolean z;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ULog.Delegate delegate = ULog.f6446a;
                String str = str;
                delegate.g("TokenUtil", "requestNewGwToken start-> mzToken: " + str);
                String str2 = str;
                if (str2 == null || StringsKt.isBlank(str2)) {
                    z = false;
                    return Boxing.boxBoolean(z);
                }
                TokenUtil tokenUtil = TokenUtil.f7744a;
                String str3 = str;
                this.label = 1;
                obj = tokenUtil.l(str3, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Boolean bool = (Boolean) obj;
            boolean booleanValue = bool.booleanValue();
            ULog.Delegate delegate2 = ULog.f6446a;
            delegate2.g("TokenUtil", "requestNewGwToken finish-> result: " + booleanValue);
            z = bool.booleanValue();
            return Boxing.boxBoolean(z);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TokenUtil$requestNewGwToken$2(String str, Continuation<? super TokenUtil$requestNewGwToken$2> continuation) {
        super(2, continuation);
        this.$mzToken = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TokenUtil$requestNewGwToken$2(this.$mzToken, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final String str = this.$mzToken;
            AnonymousClass1 r5 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.label = 1;
            obj = TimeoutKt.d(4000, r5, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Boolean bool = (Boolean) obj;
        return Boxing.boxBoolean(bool != null ? bool.booleanValue() : false);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
        return ((TokenUtil$requestNewGwToken$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
