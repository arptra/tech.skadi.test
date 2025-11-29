package com.upuphone.xr.sapp.vu.arspace;

import com.upuphone.star.core.log.ULog;
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

@SourceDebugExtension({"SMAP\nArSpaceBridgerImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ArSpaceBridgerImpl.kt\ncom/upuphone/xr/sapp/vu/arspace/ArSpaceBridgerImpl$onRequestPermissionResult$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,665:1\n1855#2,2:666\n*S KotlinDebug\n*F\n+ 1 ArSpaceBridgerImpl.kt\ncom/upuphone/xr/sapp/vu/arspace/ArSpaceBridgerImpl$onRequestPermissionResult$1\n*L\n608#1:666,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.vu.arspace.ArSpaceBridgerImpl$onRequestPermissionResult$1", f = "ArSpaceBridgerImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ArSpaceBridgerImpl$onRequestPermissionResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $requestTag;
    final /* synthetic */ boolean $result;
    int label;
    final /* synthetic */ ArSpaceBridgerImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ArSpaceBridgerImpl$onRequestPermissionResult$1(ArSpaceBridgerImpl arSpaceBridgerImpl, String str, boolean z, Continuation<? super ArSpaceBridgerImpl$onRequestPermissionResult$1> continuation) {
        super(2, continuation);
        this.this$0 = arSpaceBridgerImpl;
        this.$requestTag = str;
        this.$result = z;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ArSpaceBridgerImpl$onRequestPermissionResult$1(this.this$0, this.$requestTag, this.$result, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CopyOnWriteArraySet<IOnRequestPermissionResultListener> access$getOnRequestPermissionResultListeners$p = this.this$0.onRequestPermissionResultListeners;
            String str = this.$requestTag;
            boolean z = this.$result;
            for (IOnRequestPermissionResultListener onRequestPermissionResult : access$getOnRequestPermissionResultListeners$p) {
                try {
                    onRequestPermissionResult.onRequestPermissionResult(str, z);
                } catch (Exception e) {
                    ULog.Delegate delegate = ULog.f6446a;
                    delegate.c("ArSpaceBridgerImpl", "onRequestPermissionResult: " + e);
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ArSpaceBridgerImpl$onRequestPermissionResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
