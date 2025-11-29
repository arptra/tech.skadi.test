package com.upuphone.ar.translation.phone.activity;

import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.adapter.SearchRecordAdapter;
import com.upuphone.ar.translation.phone.bean.NoteBean;
import com.upuphone.ar.translation.phone.bean.OperateMessage;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.activity.TranslatorSearchActivity$handleUiUpdateCallback$1", f = "TranslatorSearchActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TranslatorSearchActivity$handleUiUpdateCallback$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ OperateMessage<T> $operateMessage;
    int label;
    final /* synthetic */ TranslatorSearchActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslatorSearchActivity$handleUiUpdateCallback$1(OperateMessage<T> operateMessage, TranslatorSearchActivity translatorSearchActivity, Continuation<? super TranslatorSearchActivity$handleUiUpdateCallback$1> continuation) {
        super(2, continuation);
        this.$operateMessage = operateMessage;
        this.this$0 = translatorSearchActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TranslatorSearchActivity$handleUiUpdateCallback$1(this.$operateMessage, this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$operateMessage.getType() != 1000) {
                return Unit.INSTANCE;
            }
            T operateObject = this.$operateMessage.getOperateObject();
            if (operateObject instanceof NoteBean) {
                LogExt.j("删除搜索列表中翻译记录", "TranslatorSearchActivity");
                SearchRecordAdapter access$getMSearchRecordAdapter$p = this.this$0.mSearchRecordAdapter;
                if (access$getMSearchRecordAdapter$p != null) {
                    TranslatorSearchActivity translatorSearchActivity = this.this$0;
                    Iterator it = access$getMSearchRecordAdapter$p.getData().iterator();
                    int i = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        int i2 = i + 1;
                        if (((NoteBean) operateObject).getId() == ((NoteBean) it.next()).getId()) {
                            access$getMSearchRecordAdapter$p.i0(i);
                            break;
                        }
                        i = i2;
                    }
                    translatorSearchActivity.showEmptyView(access$getMSearchRecordAdapter$p.getData().isEmpty());
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TranslatorSearchActivity$handleUiUpdateCallback$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
