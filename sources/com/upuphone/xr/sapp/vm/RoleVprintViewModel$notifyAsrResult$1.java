package com.upuphone.xr.sapp.vm;

import androidx.lifecycle.MutableLiveData;
import com.upuphone.xr.sapp.vm.RoleVprintViewModel;
import com.xjsd.xr.sapp.asr.dao.AsrResult;
import com.xjsd.xr.sapp.asr.dao.Dst;
import com.xjsd.xr.sapp.asr.dao.ResultExt;
import com.xjsd.xr.sapp.asr.dao.Src;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.vm.RoleVprintViewModel$notifyAsrResult$1", f = "RoleVprintViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class RoleVprintViewModel$notifyAsrResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Src $src;
    int label;
    final /* synthetic */ RoleVprintViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RoleVprintViewModel$notifyAsrResult$1(RoleVprintViewModel roleVprintViewModel, Src src, Continuation<? super RoleVprintViewModel$notifyAsrResult$1> continuation) {
        super(2, continuation);
        this.this$0 = roleVprintViewModel;
        this.$src = src;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RoleVprintViewModel$notifyAsrResult$1(this.this$0, this.$src, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            RoleVprintViewModel.RoleAsrResult j = this.this$0.h;
            if (j != null) {
                RoleVprintViewModel roleVprintViewModel = this.this$0;
                Src src = this.$src;
                String a2 = j.a();
                String b = j.b();
                int end = src.getEnd();
                roleVprintViewModel.S("notifyAsrResult end=" + end + ", src=" + a2 + ", tempSrc=" + b);
                MutableLiveData m = roleVprintViewModel.k;
                int end2 = src.getEnd();
                StringBuilder sb = new StringBuilder();
                sb.append(a2);
                sb.append(b);
                m.setValue(new AsrResult(new Src(end2, sb.toString(), 0, 0, 0, 0, 0, 124, (DefaultConstructorMarker) null), (Dst) null, (ResultExt) null, 6, (DefaultConstructorMarker) null));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RoleVprintViewModel$notifyAsrResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
