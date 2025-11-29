package com.upuphone.xr.sapp.glass;

import androidx.lifecycle.LiveData;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.entity.BasicGlassInfo;
import com.upuphone.xr.sapp.entity.BasicGlassInfoKt;
import com.upuphone.xr.sapp.monitor.starry.StarryMessageHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.glass.GlassContextDelegate$initGlassVersion$1", f = "GlassContextDelegate.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class GlassContextDelegate$initGlassVersion$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GlassContextDelegate this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlassContextDelegate$initGlassVersion$1(GlassContextDelegate glassContextDelegate, Continuation<? super GlassContextDelegate$initGlassVersion$1> continuation) {
        super(2, continuation);
        this.this$0 = glassContextDelegate;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GlassContextDelegate$initGlassVersion$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ULog.f6446a.g("GlassContextImpl", "initGlassVersion");
            StarryMessageHelper starryMessageHelper = StarryMessageHelper.f7799a;
            final GlassContextDelegate glassContextDelegate = this.this$0;
            starryMessageHelper.d(new Function1<Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Integer) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Integer num) {
                    ULog.Delegate delegate = ULog.f6446a;
                    int g = glassContextDelegate.b;
                    delegate.g("GlassContextImpl", "peerVersion: " + num + ", peerVersionCache: " + g);
                    if (num != null) {
                        glassContextDelegate.b = num.intValue();
                    }
                    glassContextDelegate.f7045a.postValue(num);
                }
            });
            LiveData A0 = GlassUpdateHelper.b.A0();
            final GlassContextDelegate glassContextDelegate2 = this.this$0;
            A0.observeForever(new GlassContextDelegate$sam$androidx_lifecycle_Observer$0(new Function1<BasicGlassInfo, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((BasicGlassInfo) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable BasicGlassInfo basicGlassInfo) {
                    ULog.Delegate delegate = ULog.f6446a;
                    delegate.g("GlassContextImpl", "glassInfoData: " + basicGlassInfo);
                    GlassPreference.f7059a.b(basicGlassInfo);
                    SimpleGlassInfo toSimpleGlassInfo = basicGlassInfo != null ? BasicGlassInfoKt.getToSimpleGlassInfo(basicGlassInfo) : null;
                    glassContextDelegate2.d = toSimpleGlassInfo;
                    glassContextDelegate2.c.postValue(toSimpleGlassInfo);
                }
            }));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GlassContextDelegate$initGlassVersion$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
