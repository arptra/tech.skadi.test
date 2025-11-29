package com.upuphone.ar.translation.phone.activity;

import com.upuphone.ar.translation.phone.adapter.SearchRecordAdapter;
import com.upuphone.ar.translation.phone.bean.NoteBean;
import com.upuphone.ar.translation.phone.bean.NoteBeanExtKt;
import com.upuphone.ar.translation.phone.helper.TranslatorLitePalHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.activity.TranslatorSearchActivity$searchRecord$1", f = "TranslatorSearchActivity.kt", i = {}, l = {241}, m = "invokeSuspend", n = {}, s = {})
public final class TranslatorSearchActivity$searchRecord$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $keyWord;
    int label;
    final /* synthetic */ TranslatorSearchActivity this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.ar.translation.phone.activity.TranslatorSearchActivity$searchRecord$1$2", f = "TranslatorSearchActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.ar.translation.phone.activity.TranslatorSearchActivity$searchRecord$1$2  reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass2(translatorSearchActivity, c, continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            List data;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                translatorSearchActivity.showEmptyView(c.isEmpty());
                SearchRecordAdapter access$getMSearchRecordAdapter$p = translatorSearchActivity.mSearchRecordAdapter;
                if (!(access$getMSearchRecordAdapter$p == null || (data = access$getMSearchRecordAdapter$p.getData()) == null)) {
                    data.clear();
                }
                SearchRecordAdapter access$getMSearchRecordAdapter$p2 = translatorSearchActivity.mSearchRecordAdapter;
                if (access$getMSearchRecordAdapter$p2 != null) {
                    access$getMSearchRecordAdapter$p2.r(c);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslatorSearchActivity$searchRecord$1(String str, TranslatorSearchActivity translatorSearchActivity, Continuation<? super TranslatorSearchActivity$searchRecord$1> continuation) {
        super(2, continuation);
        this.$keyWord = str;
        this.this$0 = translatorSearchActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TranslatorSearchActivity$searchRecord$1(this.$keyWord, this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final List<NoteBean> c = TranslatorLitePalHelper.f6309a.c(this.$keyWord);
            int i2 = 0;
            for (NoteBean noteBean : c) {
                noteBean.setContent(NoteBeanExtKt.assembleContent(noteBean));
                noteBean.setSrcContent("");
                noteBean.setDstContent("");
                Unit unit = Unit.INSTANCE;
                c.set(i2, noteBean);
                i2++;
            }
            MainCoroutineDispatcher c2 = Dispatchers.c();
            final TranslatorSearchActivity translatorSearchActivity = this.this$0;
            AnonymousClass2 r3 = new AnonymousClass2((Continuation<? super AnonymousClass2>) null);
            this.label = 1;
            if (BuildersKt.g(c2, r3, this) == coroutine_suspended) {
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
        return ((TranslatorSearchActivity$searchRecord$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
