package com.upuphone.xr.sapp.vu;

import android.content.Context;
import android.hardware.usb.UsbDevice;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.RepeatOnLifecycleKt;
import com.upuphone.ar.translation.statemachine.annotation.MSG;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.vu.vm.VuGlassesDeviceModel;
import com.xjmz.myvu.MYVUActivity;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.vu.VuGlassesActivity$addViewGlassesObserver$1", f = "VuGlassesActivity.kt", i = {}, l = {248}, m = "invokeSuspend", n = {}, s = {})
public final class VuGlassesActivity$addViewGlassesObserver$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ VuGlassesActivity this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.xr.sapp.vu.VuGlassesActivity$addViewGlassesObserver$1$1", f = "VuGlassesActivity.kt", i = {}, l = {249}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.xr.sapp.vu.VuGlassesActivity$addViewGlassesObserver$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(vuGlassesActivity, continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableStateFlow c = VuGlassesDeviceModel.f8113a.c();
                final VuGlassesActivity vuGlassesActivity = vuGlassesActivity;
                AnonymousClass1 r1 = new FlowCollector() {
                    /* renamed from: d */
                    public final Object emit(UsbDevice usbDevice, Continuation continuation) {
                        if (usbDevice != null) {
                            boolean booleanValue = ((Boolean) DataStoreUtils.i(DataStoreUtils.e.a(), "vu_auto_connect_view_glass", Boxing.boxBoolean(false), (Context) null, 4, (Object) null)).booleanValue();
                            if (!vuGlassesActivity.p() || booleanValue) {
                                vuGlassesActivity.D();
                            } else {
                                StaticMethodUtilsKt.G(vuGlassesActivity.o(), CollectionsKt.arrayListOf(Boxing.boxInt(MSG.MSG_PREPARING_SUCCESS)), false, false, 4, (Object) null);
                            }
                        }
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (c.collect(r1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VuGlassesActivity$addViewGlassesObserver$1(VuGlassesActivity vuGlassesActivity, Continuation<? super VuGlassesActivity$addViewGlassesObserver$1> continuation) {
        super(2, continuation);
        this.this$0 = vuGlassesActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VuGlassesActivity$addViewGlassesObserver$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MYVUActivity o = this.this$0.o();
            Lifecycle.State state = Lifecycle.State.RESUMED;
            final VuGlassesActivity vuGlassesActivity = this.this$0;
            AnonymousClass1 r3 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.label = 1;
            if (RepeatOnLifecycleKt.b(o, state, r3, this) == coroutine_suspended) {
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
        return ((VuGlassesActivity$addViewGlassesObserver$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
