package com.upuphone.xr.sapp.vu.vm;

import com.upuphone.xr.sapp.vu.ota.VuUpdateStatus;
import com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nVuGlassesOtaModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VuGlassesOtaModel.kt\ncom/upuphone/xr/sapp/vu/vm/VuGlassesOtaModel$onStatusChange$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,337:1\n1855#2,2:338\n*S KotlinDebug\n*F\n+ 1 VuGlassesOtaModel.kt\ncom/upuphone/xr/sapp/vu/vm/VuGlassesOtaModel$onStatusChange$2\n*L\n225#1:338,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel$onStatusChange$2", f = "VuGlassesOtaModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class VuGlassesOtaModel$onStatusChange$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ VuUpdateStatus $status;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VuGlassesOtaModel$onStatusChange$2(VuUpdateStatus vuUpdateStatus, Continuation<? super VuGlassesOtaModel$onStatusChange$2> continuation) {
        super(2, continuation);
        this.$status = vuUpdateStatus;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VuGlassesOtaModel$onStatusChange$2(this.$status, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CopyOnWriteArraySet<VuGlassesOtaModel.UpdateStatusChangeListener> g = VuGlassesOtaModel.h;
            VuUpdateStatus vuUpdateStatus = this.$status;
            for (VuGlassesOtaModel.UpdateStatusChangeListener a2 : g) {
                a2.a(vuUpdateStatus);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((VuGlassesOtaModel$onStatusChange$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
