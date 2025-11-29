package com.upuphone.ar.translation.phone.helper;

import android.content.Context;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.R;
import com.upuphone.ar.translation.phone.bean.IntelExtnTodo;
import com.upuphone.ar.translation.phone.bean.NoteBean;
import com.xjsd.xr.sapp.asr.dao.SmartExTodo;
import java.util.ArrayList;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.helper.TranslatorSmExHelper$writeTodosToDb$1", f = "TranslatorSmExHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TranslatorSmExHelper$writeTodosToDb$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ SmartExTodo $exTodo;
    final /* synthetic */ NoteBean $noteBean;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslatorSmExHelper$writeTodosToDb$1(SmartExTodo smartExTodo, Context context, NoteBean noteBean, Continuation<? super TranslatorSmExHelper$writeTodosToDb$1> continuation) {
        super(2, continuation);
        this.$exTodo = smartExTodo;
        this.$context = context;
        this.$noteBean = noteBean;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TranslatorSmExHelper$writeTodosToDb$1(this.$exTodo, this.$context, this.$noteBean, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ArrayList<SmartExTodo.ToDo> todoList = this.$exTodo.getTodoList();
            if (todoList.isEmpty()) {
                return Unit.INSTANCE;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<SmartExTodo.ToDo> it = todoList.iterator();
            int i = 0;
            while (it.hasNext()) {
                i++;
                SmartExTodo.ToDo next = it.next();
                IntelExtnTodo intelExtnTodo = new IntelExtnTodo();
                Context context = this.$context;
                NoteBean noteBean = this.$noteBean;
                SmartExTodo smartExTodo = this.$exTodo;
                intelExtnTodo.setItemType(0);
                intelExtnTodo.setTitle(context.getString(R.string.tl_to_do_simple) + " " + i);
                intelExtnTodo.setContent(next.getContent());
                intelExtnTodo.setOriginalContent(next.getContent());
                intelExtnTodo.setStartTime(next.getStartTime());
                intelExtnTodo.setEndTime(next.getEndTime());
                intelExtnTodo.setAccountId(noteBean.getAccountId());
                intelExtnTodo.setRecognizeId(noteBean.getRecognizeId());
                intelExtnTodo.setRequestId(smartExTodo.getRequestId());
                arrayList.add(intelExtnTodo);
            }
            LogExt.j("writeSummaryToDb success ids=" + TranslatorDbHelper.f6307a.b().a(arrayList), "TranslatorSmExHelper");
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TranslatorSmExHelper$writeTodosToDb$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
