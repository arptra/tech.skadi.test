package com.honey.account;

import com.honey.account.data.AccountData;
import com.honey.account.module.NetworkModule;
import com.honey.account.view.home.AccountRepository;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.honey.account.HoneyAccountManager$Companion$getDetail$1", f = "HoneyAccountManager.kt", i = {}, l = {142}, m = "invokeSuspend", n = {}, s = {})
public final class HoneyAccountManager$Companion$getDetail$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<Boolean, String, AccountData, Unit> $callback;
    int label;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.honey.account.HoneyAccountManager$Companion$getDetail$1$1", f = "HoneyAccountManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.honey.account.HoneyAccountManager$Companion$getDetail$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(obj2, function3, continuation);
            r0.L$0 = obj;
            return r0;
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Unit unit;
            String message;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                Object obj2 = obj2;
                if (Result.m26isFailureimpl(obj2)) {
                    obj2 = null;
                }
                AccountData accountData = (AccountData) obj2;
                String str = "";
                if (accountData != null) {
                    function3.invoke(Boxing.boxBoolean(true), str, accountData);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    Function3<Boolean, String, AccountData, Unit> function3 = function3;
                    Object obj3 = obj2;
                    Boolean boxBoolean = Boxing.boxBoolean(false);
                    Throwable r4 = Result.m23exceptionOrNullimpl(obj3);
                    if (!(r4 == null || (message = r4.getMessage()) == null)) {
                        str = message;
                    }
                    function3.invoke(boxBoolean, str, null);
                }
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
    public HoneyAccountManager$Companion$getDetail$1(Function3<? super Boolean, ? super String, ? super AccountData, Unit> function3, Continuation<? super HoneyAccountManager$Companion$getDetail$1> continuation) {
        super(2, continuation);
        this.$callback = function3;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new HoneyAccountManager$Companion$getDetail$1(this.$callback, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        final Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            NetworkModule networkModule = NetworkModule.INSTANCE;
            AccountRepository accountRepository = new AccountRepository(networkModule.provideAccountApiService(networkModule.provideRetrofit()));
            this.label = 1;
            obj2 = accountRepository.m1728getDetailIoAF18A(this);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            obj2 = ((Result) obj).m29unboximpl();
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        CoroutineScope a2 = CoroutineScopeKt.a(Dispatchers.c());
        final Function3<Boolean, String, AccountData, Unit> function3 = this.$callback;
        Job unused = BuildersKt__Builders_commonKt.d(a2, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((HoneyAccountManager$Companion$getDetail$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
