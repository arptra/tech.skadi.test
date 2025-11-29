package com.upuphone.xr.sapp.utils;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.upuphone.xr.sapp.utils.CustomFrameAnimation;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Landroid/graphics/drawable/BitmapDrawable;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.utils.CustomFrameAnimation$showAnimate$4$async$1", f = "CustomFrameAnimation.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CustomFrameAnimation$showAnimate$4$async$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BitmapDrawable>, Object> {
    final /* synthetic */ ImageView $imageView;
    final /* synthetic */ CustomFrameAnimation.MyFrame $nextFrame;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomFrameAnimation$showAnimate$4$async$1(ImageView imageView, CustomFrameAnimation.MyFrame myFrame, Continuation<? super CustomFrameAnimation$showAnimate$4$async$1> continuation) {
        super(2, continuation);
        this.$imageView = imageView;
        this.$nextFrame = myFrame;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CustomFrameAnimation$showAnimate$4$async$1(this.$imageView, this.$nextFrame, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Resources resources = this.$imageView.getContext().getResources();
            byte[] a2 = this.$nextFrame.a();
            byte[] a3 = this.$nextFrame.a();
            Intrinsics.checkNotNull(a3);
            return new BitmapDrawable(resources, BitmapFactory.decodeByteArray(a2, 0, a3.length));
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super BitmapDrawable> continuation) {
        return ((CustomFrameAnimation$showAnimate$4$async$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
