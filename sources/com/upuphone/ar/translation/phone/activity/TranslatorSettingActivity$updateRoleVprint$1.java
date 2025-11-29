package com.upuphone.ar.translation.phone.activity;

import com.upuphone.ar.translation.constants.TranslatorConstants;
import com.upuphone.ar.translation.phone.view.TransSettingItem;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nTranslatorSettingActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TranslatorSettingActivity.kt\ncom/upuphone/ar/translation/phone/activity/TranslatorSettingActivity$updateRoleVprint$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,604:1\n262#2,2:605\n*S KotlinDebug\n*F\n+ 1 TranslatorSettingActivity.kt\ncom/upuphone/ar/translation/phone/activity/TranslatorSettingActivity$updateRoleVprint$1\n*L\n346#1:605,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity$updateRoleVprint$1", f = "TranslatorSettingActivity.kt", i = {}, l = {349, 355}, m = "invokeSuspend", n = {}, s = {})
public final class TranslatorSettingActivity$updateRoleVprint$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ TranslatorSettingActivity this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity$updateRoleVprint$1$1", f = "TranslatorSettingActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.ar.translation.phone.activity.TranslatorSettingActivity$updateRoleVprint$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(translatorSettingActivity, continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return Boxing.boxBoolean(translatorSettingActivity.getMTranslatorSettingsVm().m());
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslatorSettingActivity$updateRoleVprint$1(TranslatorSettingActivity translatorSettingActivity, Continuation<? super TranslatorSettingActivity$updateRoleVprint$1> continuation) {
        super(2, continuation);
        this.this$0 = translatorSettingActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TranslatorSettingActivity$updateRoleVprint$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        TransSettingItem transSettingItem;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!TranslatorConstants.isAirPro()) {
                return Unit.INSTANCE;
            }
            TransSettingItem transSettingItem2 = this.this$0.getMBinding().j;
            Intrinsics.checkNotNullExpressionValue(transSettingItem2, "tsiOnlyOther");
            transSettingItem2.setVisibility(0);
            CoroutineDispatcher b = Dispatchers.b();
            TranslatorSettingActivity$updateRoleVprint$1$isShowOnlyOther$1 translatorSettingActivity$updateRoleVprint$1$isShowOnlyOther$1 = new TranslatorSettingActivity$updateRoleVprint$1$isShowOnlyOther$1((Continuation<? super TranslatorSettingActivity$updateRoleVprint$1$isShowOnlyOther$1>) null);
            this.label = 1;
            obj = BuildersKt.g(b, translatorSettingActivity$updateRoleVprint$1$isShowOnlyOther$1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            transSettingItem = (TransSettingItem) this.L$0;
            ResultKt.throwOnFailure(obj);
            transSettingItem.setSettingTipVisible(((Boolean) obj).booleanValue());
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.getMBinding().j.setSettingChecked(((Boolean) obj).booleanValue());
        TransSettingItem transSettingItem3 = this.this$0.getMBinding().n;
        CoroutineDispatcher b2 = Dispatchers.b();
        final TranslatorSettingActivity translatorSettingActivity = this.this$0;
        AnonymousClass1 r4 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
        this.L$0 = transSettingItem3;
        this.label = 2;
        Object g = BuildersKt.g(b2, r4, this);
        if (g == coroutine_suspended) {
            return coroutine_suspended;
        }
        TransSettingItem transSettingItem4 = transSettingItem3;
        obj = g;
        transSettingItem = transSettingItem4;
        transSettingItem.setSettingTipVisible(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TranslatorSettingActivity$updateRoleVprint$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
