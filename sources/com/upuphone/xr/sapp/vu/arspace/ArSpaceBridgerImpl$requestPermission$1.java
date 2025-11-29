package com.upuphone.xr.sapp.vu.arspace;

import com.upuphone.xr.sapp.vu.VuTouchpadActivity;
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
@DebugMetadata(c = "com.upuphone.xr.sapp.vu.arspace.ArSpaceBridgerImpl$requestPermission$1", f = "ArSpaceBridgerImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ArSpaceBridgerImpl$requestPermission$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $desc;
    final /* synthetic */ String $detail;
    final /* synthetic */ String[] $permissions;
    final /* synthetic */ String $requestTag;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ArSpaceBridgerImpl$requestPermission$1(String str, String str2, String str3, String[] strArr, Continuation<? super ArSpaceBridgerImpl$requestPermission$1> continuation) {
        super(2, continuation);
        this.$requestTag = str;
        this.$desc = str2;
        this.$detail = str3;
        this.$permissions = strArr;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ArSpaceBridgerImpl$requestPermission$1(this.$requestTag, this.$desc, this.$detail, this.$permissions, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            VuTouchpadActivity b = VuTouchpadActivity.w.b();
            if (b != null) {
                b.y1(this.$requestTag, this.$desc, this.$detail, this.$permissions);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ArSpaceBridgerImpl$requestPermission$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
