package com.upuphone.xr.sapp.utils;

import android.content.Context;
import android.widget.ImageView;
import com.upuphone.xr.sapp.utils.CustomFrameAnimation;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
@DebugMetadata(c = "com.upuphone.xr.sapp.utils.CustomFrameAnimation$loadFromXml$1", f = "CustomFrameAnimation.kt", i = {}, l = {156}, m = "invokeSuspend", n = {}, s = {})
public final class CustomFrameAnimation$loadFromXml$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CustomFrameAnimation.IAnimState $anim;
    final /* synthetic */ Context $context;
    final /* synthetic */ int $defaultDuration;
    final /* synthetic */ ImageView $imageView;
    final /* synthetic */ boolean $repeatAnim;
    final /* synthetic */ int $resourceId;
    final /* synthetic */ boolean $reversed;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CustomFrameAnimation this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.xr.sapp.utils.CustomFrameAnimation$loadFromXml$1$1", f = "CustomFrameAnimation.kt", i = {}, l = {157}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.xr.sapp.utils.CustomFrameAnimation$loadFromXml$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(b, customFrameAnimation, imageView, z, z2, iAnimState, continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Deferred<ArrayList<CustomFrameAnimation.MyFrame>> deferred = b;
                this.label = 1;
                obj = deferred.c(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ArrayList arrayList = (ArrayList) obj;
            customFrameAnimation.b = 0;
            CustomFrameAnimation.d.a().removeCallbacksAndMessages((Object) null);
            imageView.clearAnimation();
            if (z) {
                customFrameAnimation.m(CollectionsKt.reversed(arrayList), imageView, z2, iAnimState);
            } else {
                customFrameAnimation.m(arrayList, imageView, z2, iAnimState);
            }
            return Unit.INSTANCE;
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomFrameAnimation$loadFromXml$1(Context context, int i, int i2, CustomFrameAnimation customFrameAnimation, ImageView imageView, boolean z, boolean z2, CustomFrameAnimation.IAnimState iAnimState, Continuation<? super CustomFrameAnimation$loadFromXml$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$resourceId = i;
        this.$defaultDuration = i2;
        this.this$0 = customFrameAnimation;
        this.$imageView = imageView;
        this.$reversed = z;
        this.$repeatAnim = z2;
        this.$anim = iAnimState;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        CustomFrameAnimation$loadFromXml$1 customFrameAnimation$loadFromXml$1 = new CustomFrameAnimation$loadFromXml$1(this.$context, this.$resourceId, this.$defaultDuration, this.this$0, this.$imageView, this.$reversed, this.$repeatAnim, this.$anim, continuation);
        customFrameAnimation$loadFromXml$1.L$0 = obj;
        return customFrameAnimation$loadFromXml$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final Deferred b = BuildersKt__Builders_commonKt.b((CoroutineScope) this.L$0, (CoroutineContext) null, (CoroutineStart) null, new CustomFrameAnimation$loadFromXml$1$async$1(this.$context, this.$resourceId, this.$defaultDuration, (Continuation<? super CustomFrameAnimation$loadFromXml$1$async$1>) null), 3, (Object) null);
            MainCoroutineDispatcher c = Dispatchers.c();
            final CustomFrameAnimation customFrameAnimation = this.this$0;
            final ImageView imageView = this.$imageView;
            final boolean z = this.$reversed;
            final boolean z2 = this.$repeatAnim;
            final CustomFrameAnimation.IAnimState iAnimState = this.$anim;
            AnonymousClass1 r10 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.label = 1;
            if (BuildersKt.g(c, r10, this) == coroutine_suspended) {
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
        return ((CustomFrameAnimation$loadFromXml$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
