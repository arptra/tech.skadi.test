package com.upuphone.xr.sapp.fragment;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.entity.ConfigDataBean;
import com.upuphone.xr.sapp.fragment.FeedBackFragment;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.fragment.FeedBackFragment$getConfig$1$1$1", f = "FeedBackFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FeedBackFragment$getConfig$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ConfigDataBean $config;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedBackFragment$getConfig$1$1$1(ConfigDataBean configDataBean, Continuation<? super FeedBackFragment$getConfig$1$1$1> continuation) {
        super(2, continuation);
        this.$config = configDataBean;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FeedBackFragment$getConfig$1$1$1(this.$config, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ULog.Delegate delegate = ULog.f6446a;
            ConfigDataBean configDataBean = this.$config;
            delegate.a("FeedBackFragment", "getConfig" + configDataBean);
            FeedBackFragment.Companion companion = FeedBackFragment.w;
            String feedBackPageId = this.$config.getFeedBackPageId();
            Intrinsics.checkNotNullExpressionValue(feedBackPageId, "getFeedBackPageId(...)");
            companion.g(feedBackPageId);
            if (this.$config.getQuestionCategoryConfigList().size() == 2) {
                String categoryId = this.$config.getQuestionCategoryConfigList().get(0).getCategoryId();
                Intrinsics.checkNotNullExpressionValue(categoryId, "getCategoryId(...)");
                companion.e(categoryId);
                String categoryId2 = this.$config.getQuestionCategoryConfigList().get(0).getCategoryId();
                Intrinsics.checkNotNullExpressionValue(categoryId2, "getCategoryId(...)");
                companion.f(categoryId2);
                String categoryId3 = this.$config.getQuestionCategoryConfigList().get(1).getCategoryId();
                Intrinsics.checkNotNullExpressionValue(categoryId3, "getCategoryId(...)");
                companion.d(categoryId3);
            } else if (this.$config.getQuestionCategoryConfigList().size() == 3) {
                String categoryId4 = this.$config.getQuestionCategoryConfigList().get(0).getCategoryId();
                Intrinsics.checkNotNullExpressionValue(categoryId4, "getCategoryId(...)");
                companion.e(categoryId4);
                String categoryId5 = this.$config.getQuestionCategoryConfigList().get(1).getCategoryId();
                Intrinsics.checkNotNullExpressionValue(categoryId5, "getCategoryId(...)");
                companion.d(categoryId5);
                String categoryId6 = this.$config.getQuestionCategoryConfigList().get(2).getCategoryId();
                Intrinsics.checkNotNullExpressionValue(categoryId6, "getCategoryId(...)");
                companion.f(categoryId6);
            }
            if (this.$config.getAttributeCategoryConfigList().size() == 4) {
                String categoryId7 = this.$config.getAttributeCategoryConfigList().get(0).getCategoryId();
                Intrinsics.checkNotNullExpressionValue(categoryId7, "getCategoryId(...)");
                companion.i(categoryId7);
                String categoryId8 = this.$config.getAttributeCategoryConfigList().get(1).getCategoryId();
                Intrinsics.checkNotNullExpressionValue(categoryId8, "getCategoryId(...)");
                companion.k(categoryId8);
                String categoryId9 = this.$config.getAttributeCategoryConfigList().get(2).getCategoryId();
                Intrinsics.checkNotNullExpressionValue(categoryId9, "getCategoryId(...)");
                companion.j(categoryId9);
                String categoryId10 = this.$config.getAttributeCategoryConfigList().get(3).getCategoryId();
                Intrinsics.checkNotNullExpressionValue(categoryId10, "getCategoryId(...)");
                companion.h(categoryId10);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FeedBackFragment$getConfig$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
