package com.xjmz.myvu.modules.home;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.tips.TipsKey;
import com.upuphone.xr.sapp.tips.TipsManager;
import com.upuphone.xr.sapp.utils.DeviceCaptifyHelper;
import com.xjmz.myvu.flutter.pigeon.AndroidAppApi;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.api.cache.CacheAbility;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjmz.myvu.modules.home.HomeFragment$initViewModel$5", f = "HomeFragment.kt", i = {}, l = {422}, m = "invokeSuspend", n = {}, s = {})
public final class HomeFragment$initViewModel$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ HomeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeFragment$initViewModel$5(HomeFragment homeFragment, Continuation<? super HomeFragment$initViewModel$5> continuation) {
        super(2, continuation);
        this.this$0 = homeFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new HomeFragment$initViewModel$5(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MutableStateFlow c = DeviceCaptifyHelper.f7877a.c();
            final HomeFragment homeFragment = this.this$0;
            AnonymousClass1 r1 = new FlowCollector() {
                public final Object d(boolean z, Continuation continuation) {
                    String str = z ? "Air_captify" : "";
                    CacheAbility cacheAbility = (CacheAbility) AbilityManager.b.b(CacheAbility.class);
                    if (cacheAbility != null) {
                        cacheAbility.cache("nlu_device_type", str);
                    }
                    if (z) {
                        TipsManager.f7827a.d(TipsKey.TIPS_USER_GUIDE);
                    }
                    homeFragment.o0().f(Boxing.boxBoolean(z), new AndroidAppApi.VoidResult() {
                        public void error(Throwable th) {
                            Intrinsics.checkNotNullParameter(th, "error");
                            ULog.f6446a.g("HomeFragment", "onCaptifyStateChange error");
                        }

                        public void success() {
                            ULog.f6446a.g("HomeFragment", "onCaptifyStateChange success");
                        }
                    });
                    return Unit.INSTANCE;
                }

                public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                    return d(((Boolean) obj).booleanValue(), continuation);
                }
            };
            this.label = 1;
            if (c.collect(r1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((HomeFragment$initViewModel$5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
