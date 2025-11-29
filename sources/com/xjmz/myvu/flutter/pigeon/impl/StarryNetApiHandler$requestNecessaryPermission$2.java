package com.xjmz.myvu.flutter.pigeon.impl;

import androidx.fragment.app.Fragment;
import com.upuphone.xr.sapp.utils.OSHelper;
import kotlin.Metadata;
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
@DebugMetadata(c = "com.xjmz.myvu.flutter.pigeon.impl.StarryNetApiHandler$requestNecessaryPermission$2", f = "StarryNetApiHandler.kt", i = {}, l = {507, 509}, m = "invokeSuspend", n = {}, s = {})
public final class StarryNetApiHandler$requestNecessaryPermission$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Fragment $fragment;
    int label;
    final /* synthetic */ StarryNetApiHandler this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StarryNetApiHandler$requestNecessaryPermission$2(StarryNetApiHandler starryNetApiHandler, Fragment fragment, Continuation<? super StarryNetApiHandler$requestNecessaryPermission$2> continuation) {
        super(2, continuation);
        this.this$0 = starryNetApiHandler;
        this.$fragment = fragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new StarryNetApiHandler$requestNecessaryPermission$2(this.this$0, this.$fragment, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (OSHelper.f7904a.d()) {
                StarryNetApiHandler starryNetApiHandler = this.this$0;
                Fragment fragment = this.$fragment;
                this.label = 1;
                if (starryNetApiHandler.j0(fragment, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                StarryNetApiHandler starryNetApiHandler2 = this.this$0;
                Fragment fragment2 = this.$fragment;
                this.label = 2;
                if (starryNetApiHandler2.i0(fragment2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1 || i == 2) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((StarryNetApiHandler$requestNecessaryPermission$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
