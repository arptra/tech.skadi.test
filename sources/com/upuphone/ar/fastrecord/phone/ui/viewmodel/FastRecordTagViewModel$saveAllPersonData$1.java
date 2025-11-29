package com.upuphone.ar.fastrecord.phone.ui.viewmodel;

import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTagViewModel$saveAllPersonData$1", f = "FastRecordTagViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FastRecordTagViewModel$saveAllPersonData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $callBack;
    final /* synthetic */ String $curPersonType;
    final /* synthetic */ String $inputPersonTagValue;
    int label;
    final /* synthetic */ FastRecordTagViewModel this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTagViewModel$saveAllPersonData$1$1", f = "FastRecordTagViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTagViewModel$saveAllPersonData$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(fastRecordTagViewModel, str, function0, continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                LogExt.logE("saveAllPersonData saveNormalPersonTag", "FastRecordTagViewModel");
                fastRecordTagViewModel.saveNormalPersonTag(str);
                FastRecordTagViewModel.saveAllNormalPersonToHistory$default(fastRecordTagViewModel, false, 1, (Object) null);
                FastRecordTagViewModel fastRecordTagViewModel = fastRecordTagViewModel;
                fastRecordTagViewModel.realDeleteHistoryPerson(fastRecordTagViewModel.needDelHistoryPersonList);
                function0.invoke();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordTagViewModel$saveAllPersonData$1(String str, FastRecordTagViewModel fastRecordTagViewModel, String str2, Function0<Unit> function0, Continuation<? super FastRecordTagViewModel$saveAllPersonData$1> continuation) {
        super(2, continuation);
        this.$inputPersonTagValue = str;
        this.this$0 = fastRecordTagViewModel;
        this.$curPersonType = str2;
        this.$callBack = function0;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordTagViewModel$saveAllPersonData$1(this.$inputPersonTagValue, this.this$0, this.$curPersonType, this.$callBack, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$inputPersonTagValue.length() > 0) {
                LogExt.logE("saveAllPersonData start addPersonTag", "FastRecordTagViewModel");
                this.this$0.addPersonTag(this.$inputPersonTagValue, this.$curPersonType, System.currentTimeMillis());
                LogExt.logE("saveAllPersonData end addPersonTag", "FastRecordTagViewModel");
            }
            CoroutineScope access$getScope$p = this.this$0.scope;
            final FastRecordTagViewModel fastRecordTagViewModel = this.this$0;
            final String str = this.$curPersonType;
            final Function0<Unit> function0 = this.$callBack;
            Job unused = BuildersKt__Builders_commonKt.d(access$getScope$p, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordTagViewModel$saveAllPersonData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
