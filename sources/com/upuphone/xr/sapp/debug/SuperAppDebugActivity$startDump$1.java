package com.upuphone.xr.sapp.debug;

import com.upuphone.xr.sapp.databinding.ActivityDebugInfoBinding;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.debug.SuperAppDebugActivity$startDump$1", f = "SuperAppDebugActivity.kt", i = {}, l = {217}, m = "invokeSuspend", n = {}, s = {})
public final class SuperAppDebugActivity$startDump$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SuperAppDebugActivity this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.xr.sapp.debug.SuperAppDebugActivity$startDump$1$1", f = "SuperAppDebugActivity.kt", i = {}, l = {218}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.xr.sapp.debug.SuperAppDebugActivity$startDump$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(b, superAppDebugActivity, str2, continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Deferred<Boolean> deferred = b;
                this.label = 1;
                obj = deferred.c(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            boolean booleanValue = ((Boolean) obj).booleanValue();
            ActivityDebugInfoBinding C0 = superAppDebugActivity.f6930a;
            ActivityDebugInfoBinding activityDebugInfoBinding = null;
            if (C0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                C0 = null;
            }
            C0.e.b.setEnabled(true);
            ActivityDebugInfoBinding C02 = superAppDebugActivity.f6930a;
            if (C02 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                C02 = null;
            }
            C02.e.b.setText("dump");
            if (booleanValue) {
                superAppDebugActivity.W0("dump success");
                ActivityDebugInfoBinding C03 = superAppDebugActivity.f6930a;
                if (C03 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityDebugInfoBinding = C03;
                }
                activityDebugInfoBinding.e.c.setText("文件保存路径：" + str2);
            } else {
                superAppDebugActivity.W0("dump failed");
            }
            return Unit.INSTANCE;
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuperAppDebugActivity$startDump$1(SuperAppDebugActivity superAppDebugActivity, Continuation<? super SuperAppDebugActivity$startDump$1> continuation) {
        super(2, continuation);
        this.this$0 = superAppDebugActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SuperAppDebugActivity$startDump$1 superAppDebugActivity$startDump$1 = new SuperAppDebugActivity$startDump$1(this.this$0, continuation);
        superAppDebugActivity$startDump$1.L$0 = obj;
        return superAppDebugActivity$startDump$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            String str = this.this$0.getFilesDir().getAbsolutePath() + "/ulog/";
            File externalFilesDir = this.this$0.getExternalFilesDir("");
            final String str2 = (externalFilesDir != null ? externalFilesDir.getAbsolutePath() : null) + "/ulog.zip";
            final Deferred b = BuildersKt__Builders_commonKt.b(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new SuperAppDebugActivity$startDump$1$task$1(str, str2, (Continuation<? super SuperAppDebugActivity$startDump$1$task$1>) null), 3, (Object) null);
            MainCoroutineDispatcher c = Dispatchers.c();
            final SuperAppDebugActivity superAppDebugActivity = this.this$0;
            AnonymousClass1 r4 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.label = 1;
            if (BuildersKt.g(c, r4, this) == coroutine_suspended) {
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
        return ((SuperAppDebugActivity$startDump$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
