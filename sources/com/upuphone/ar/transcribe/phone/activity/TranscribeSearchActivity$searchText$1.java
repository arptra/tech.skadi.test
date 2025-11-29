package com.upuphone.ar.transcribe.phone.activity;

import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.phone.helper.TranscribeDBHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.transcribe.phone.activity.TranscribeSearchActivity$searchText$1", f = "TranscribeSearchActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TranscribeSearchActivity$searchText$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $words;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TranscribeSearchActivity this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.ar.transcribe.phone.activity.TranscribeSearchActivity$searchText$1$1", f = "TranscribeSearchActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.ar.transcribe.phone.activity.TranscribeSearchActivity$searchText$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(y, transcribeSearchActivity, str, continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (y.isEmpty()) {
                    transcribeSearchActivity.showEmptyView();
                } else {
                    transcribeSearchActivity.showSearchResult(str, y);
                }
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
    public TranscribeSearchActivity$searchText$1(String str, TranscribeSearchActivity transcribeSearchActivity, Continuation<? super TranscribeSearchActivity$searchText$1> continuation) {
        super(2, continuation);
        this.$words = str;
        this.this$0 = transcribeSearchActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TranscribeSearchActivity$searchText$1 transcribeSearchActivity$searchText$1 = new TranscribeSearchActivity$searchText$1(this.$words, this.this$0, continuation);
        transcribeSearchActivity$searchText$1.L$0 = obj;
        return transcribeSearchActivity$searchText$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            final List y = TranscribeDBHelper.f6108a.y(StringsKt.trim((CharSequence) this.$words).toString());
            int size = y.size();
            LogExt.d("search result size: " + size, "TranscribeSearchActivity");
            MainCoroutineDispatcher c = Dispatchers.c();
            final TranscribeSearchActivity transcribeSearchActivity = this.this$0;
            final String str = this.$words;
            Job unused = BuildersKt__Builders_commonKt.d((CoroutineScope) this.L$0, c, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 2, (Object) null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TranscribeSearchActivity$searchText$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
