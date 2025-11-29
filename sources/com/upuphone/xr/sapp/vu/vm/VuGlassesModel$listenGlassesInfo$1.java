package com.upuphone.xr.sapp.vu.vm;

import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.vu.vm.VuGlassControlModel;
import com.xjmz.myvu.flutter.pigeon.AndroidConnectApi;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/xr/sapp/vu/vm/VuGlassControlModel$ViewGlassesInfo;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class VuGlassesModel$listenGlassesInfo$1 extends Lambda implements Function1<VuGlassControlModel.ViewGlassesInfo, Unit> {
    final /* synthetic */ VuGlassesModel this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.xr.sapp.vu.vm.VuGlassesModel$listenGlassesInfo$1$1", f = "VuGlassesModel.kt", i = {}, l = {152}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.xr.sapp.vu.vm.VuGlassesModel$listenGlassesInfo$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(vuGlassesModel, viewGlassesInfo2, z2, z, continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            String str;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                vuGlassesModel.z().e1();
                this.label = 1;
                if (DelayKt.b(200, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AndroidConnectApi.ConnectState.Builder builder = new AndroidConnectApi.ConnectState.Builder();
            VuGlassControlModel.ViewGlassesInfo viewGlassesInfo = viewGlassesInfo2;
            if (viewGlassesInfo == null || (str = viewGlassesInfo.b()) == null) {
                str = "";
            }
            AndroidConnectApi.ConnectState.Builder d = builder.c(str).b("view").d("view");
            Intrinsics.checkNotNullExpressionValue(d, "setModelId(...)");
            if (z2) {
                d.e(AndroidConnectApi.StateEnum.CONNECT_SUCC);
                VuGlassesModel vuGlassesModel = vuGlassesModel;
                AndroidConnectApi.ConnectState a2 = d.a();
                Intrinsics.checkNotNullExpressionValue(a2, "build(...)");
                vuGlassesModel.G(a2);
                vuGlassesModel.y();
            } else {
                VuGlassControlModel.ViewGlassesInfo viewGlassesInfo2 = viewGlassesInfo2;
                if (viewGlassesInfo2 != null && viewGlassesInfo2.g()) {
                    d.e(AndroidConnectApi.StateEnum.CONNECT_NOT_SUPPORT);
                    VuGlassesModel vuGlassesModel2 = vuGlassesModel;
                    AndroidConnectApi.ConnectState a3 = d.a();
                    Intrinsics.checkNotNullExpressionValue(a3, "build(...)");
                    vuGlassesModel2.G(a3);
                    vuGlassesModel.R();
                } else if (!z) {
                    d.e(AndroidConnectApi.StateEnum.CONNECT_FAILED);
                    VuGlassesModel vuGlassesModel3 = vuGlassesModel;
                    AndroidConnectApi.ConnectState a4 = d.a();
                    Intrinsics.checkNotNullExpressionValue(a4, "build(...)");
                    vuGlassesModel3.G(a4);
                    vuGlassesModel.y();
                }
            }
            if (z2 && vuGlassesModel.k) {
                ULog.Delegate delegate = ULog.f6446a;
                boolean g = vuGlassesModel.k;
                delegate.a("VuGlassesModel", "autoOpenWhenConnect: " + g);
                vuGlassesModel.k = false;
                vuGlassesModel.K(true);
            }
            return Unit.INSTANCE;
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VuGlassesModel$listenGlassesInfo$1(VuGlassesModel vuGlassesModel) {
        super(1);
        this.this$0 = vuGlassesModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((VuGlassControlModel.ViewGlassesInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable VuGlassControlModel.ViewGlassesInfo viewGlassesInfo) {
        if (viewGlassesInfo != null && !this.this$0.m) {
            this.this$0.m = true;
            this.this$0.M();
        }
        final boolean z = viewGlassesInfo != null && viewGlassesInfo.e();
        final boolean z2 = viewGlassesInfo != null && viewGlassesInfo.f();
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("VuGlassesModel", "listenGlassesInfo: isConnected " + z + ", isDisplayReady " + z2);
        LifecycleCoroutineScope a2 = LifecycleOwnerKt.a(this.this$0.z());
        final VuGlassesModel vuGlassesModel = this.this$0;
        final VuGlassControlModel.ViewGlassesInfo viewGlassesInfo2 = viewGlassesInfo;
        Job unused = BuildersKt__Builders_commonKt.d(a2, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
    }
}
