package com.upuphone.xr.sapp.utils;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.utils.CustomFrameAnimation;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.utils.CustomFrameAnimation$showAnimate$4", f = "CustomFrameAnimation.kt", i = {}, l = {260}, m = "invokeSuspend", n = {}, s = {})
public final class CustomFrameAnimation$showAnimate$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CustomFrameAnimation.IAnimState $anim;
    final /* synthetic */ ImageView $imageView;
    final /* synthetic */ List<CustomFrameAnimation.MyFrame> $myFrames;
    final /* synthetic */ boolean $repeatAnim;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CustomFrameAnimation this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.xr.sapp.utils.CustomFrameAnimation$showAnimate$4$1", f = "CustomFrameAnimation.kt", i = {}, l = {261}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.xr.sapp.utils.CustomFrameAnimation$showAnimate$4$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(myFrame2, b, customFrameAnimation, list, imageView, z, iAnimState, continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            CustomFrameAnimation.MyFrame myFrame;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CustomFrameAnimation.MyFrame myFrame2 = myFrame2;
                Deferred<BitmapDrawable> deferred = b;
                this.L$0 = myFrame2;
                this.label = 1;
                Object c = deferred.c(this);
                if (c == coroutine_suspended) {
                    return coroutine_suspended;
                }
                myFrame = myFrame2;
                obj = c;
            } else if (i == 1) {
                myFrame = (CustomFrameAnimation.MyFrame) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            myFrame.f((Drawable) obj);
            if (myFrame2.d()) {
                CustomFrameAnimation customFrameAnimation = customFrameAnimation;
                customFrameAnimation.l(list, imageView, customFrameAnimation.b + 1, z, iAnimState);
            } else {
                myFrame2.h(true);
            }
            return Unit.INSTANCE;
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomFrameAnimation$showAnimate$4(List<CustomFrameAnimation.MyFrame> list, CustomFrameAnimation customFrameAnimation, ImageView imageView, boolean z, CustomFrameAnimation.IAnimState iAnimState, Continuation<? super CustomFrameAnimation$showAnimate$4> continuation) {
        super(2, continuation);
        this.$myFrames = list;
        this.this$0 = customFrameAnimation;
        this.$imageView = imageView;
        this.$repeatAnim = z;
        this.$anim = iAnimState;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        CustomFrameAnimation$showAnimate$4 customFrameAnimation$showAnimate$4 = new CustomFrameAnimation$showAnimate$4(this.$myFrames, this.this$0, this.$imageView, this.$repeatAnim, this.$anim, continuation);
        customFrameAnimation$showAnimate$4.L$0 = obj;
        return customFrameAnimation$showAnimate$4;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            CustomFrameAnimation.MyFrame myFrame = this.$myFrames.get(this.this$0.b + 1);
            final Deferred b = BuildersKt__Builders_commonKt.b(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new CustomFrameAnimation$showAnimate$4$async$1(this.$imageView, myFrame, (Continuation<? super CustomFrameAnimation$showAnimate$4$async$1>) null), 3, (Object) null);
            MainCoroutineDispatcher c = Dispatchers.c();
            final CustomFrameAnimation customFrameAnimation = this.this$0;
            final List<CustomFrameAnimation.MyFrame> list = this.$myFrames;
            final ImageView imageView = this.$imageView;
            final boolean z = this.$repeatAnim;
            final CustomFrameAnimation.IAnimState iAnimState = this.$anim;
            final CustomFrameAnimation.MyFrame myFrame2 = myFrame;
            AnonymousClass1 r4 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.label = 1;
            if (BuildersKt.g(c, r4, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e) {
                ULog.Delegate delegate = ULog.f6446a;
                String message = e.getMessage();
                delegate.c("CustomFrameAnimation", "anim error : " + message);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CustomFrameAnimation$showAnimate$4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
