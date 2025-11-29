package com.upuphone.xr.sapp.fragment;

import com.upuphone.xr.sapp.utils.ControlUtils;
import com.upuphone.xr.sapp.vm.internal.SuperMessageManger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.fragment.GlassManagerFragment$getStateFromGlass$1", f = "GlassManagerFragment.kt", i = {}, l = {250}, m = "invokeSuspend", n = {}, s = {})
public final class GlassManagerFragment$getStateFromGlass$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GlassManagerFragment this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.xr.sapp.fragment.GlassManagerFragment$getStateFromGlass$1$1", f = "GlassManagerFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.xr.sapp.fragment.GlassManagerFragment$getStateFromGlass$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(glassManagerFragment, continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                SuperMessageManger.Companion companion = SuperMessageManger.m;
                companion.a().E();
                companion.a().n();
                String packageName = glassManagerFragment.m0().getPackageName();
                if (packageName != null) {
                    GlassManagerFragment glassManagerFragment = glassManagerFragment;
                    ControlUtils controlUtils = ControlUtils.f7858a;
                    controlUtils.l(packageName);
                    controlUtils.j(packageName);
                    glassManagerFragment.f1();
                    controlUtils.i(packageName);
                    controlUtils.k(packageName);
                    controlUtils.K(packageName);
                    if (glassManagerFragment.r) {
                        controlUtils.J(packageName);
                        controlUtils.H(packageName);
                        controlUtils.G(packageName);
                        controlUtils.L(packageName);
                        controlUtils.F(packageName);
                    }
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
    public GlassManagerFragment$getStateFromGlass$1(GlassManagerFragment glassManagerFragment, Continuation<? super GlassManagerFragment$getStateFromGlass$1> continuation) {
        super(2, continuation);
        this.this$0 = glassManagerFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GlassManagerFragment$getStateFromGlass$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineDispatcher b = Dispatchers.b();
            final GlassManagerFragment glassManagerFragment = this.this$0;
            AnonymousClass1 r1 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.label = 1;
            if (BuildersKt.g(b, r1, this) == coroutine_suspended) {
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
        return ((GlassManagerFragment$getStateFromGlass$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
