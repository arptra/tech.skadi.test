package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import com.upuphone.xr.sapp.monitor.notification.model.AppInfoModel;
import com.upuphone.xr.sapp.utils.PackageHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "Lcom/upuphone/xr/sapp/monitor/notification/model/AppInfoModel;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.fragment.PhoneNotifyFragment$queryPackage$1$async$1", f = "PhoneNotifyFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class PhoneNotifyFragment$queryPackage$1$async$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends AppInfoModel>>, Object> {
    int label;
    final /* synthetic */ PhoneNotifyFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhoneNotifyFragment$queryPackage$1$async$1(PhoneNotifyFragment phoneNotifyFragment, Continuation<? super PhoneNotifyFragment$queryPackage$1$async$1> continuation) {
        super(2, continuation);
        this.this$0 = phoneNotifyFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PhoneNotifyFragment$queryPackage$1$async$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            PackageHelper L0 = this.this$0.W0();
            Context requireContext = this.this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            return L0.e(requireContext, false);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super List<AppInfoModel>> continuation) {
        return ((PhoneNotifyFragment$queryPackage$1$async$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
