package com.xjsd.ai.assistant.phone.vui.todo;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import java.util.Date;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Dao
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0005\u0010\u0006J$\u0010\t\u001a\u00020\b2\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0007\"\u00020\u0002H§@¢\u0006\u0004\b\t\u0010\nJ$\u0010\u000b\u001a\u00020\b2\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0007\"\u00020\u0002H§@¢\u0006\u0004\b\u000b\u0010\nJ\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH§@¢\u0006\u0004\b\u000f\u0010\u0010J&\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011H§@¢\u0006\u0004\b\u0013\u0010\u0014J.\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0011H§@¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000e0\u0019H'¢\u0006\u0004\b\u001a\u0010\u001bJ#\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000e0\u00192\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/xjsd/ai/assistant/phone/vui/todo/TodoDao;", "", "Lcom/xjsd/ai/assistant/phone/vui/todo/TodoEntry;", "todoEntry", "", "a", "(Lcom/xjsd/ai/assistant/phone/vui/todo/TodoEntry;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "", "d", "([Lcom/xjsd/ai/assistant/phone/vui/todo/TodoEntry;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "c", "", "accountId", "", "b", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/util/Date;", "date", "h", "(Ljava/lang/String;Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startDate", "endDate", "e", "(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/lifecycle/LiveData;", "f", "()Landroidx/lifecycle/LiveData;", "g", "(Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "", "i", "(Ljava/lang/String;)I", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public interface TodoDao {
    Object a(TodoEntry todoEntry, Continuation continuation);

    Object b(String str, Continuation continuation);

    Object c(TodoEntry[] todoEntryArr, Continuation continuation);

    Object d(TodoEntry[] todoEntryArr, Continuation continuation);

    Object e(String str, Date date, Date date2, Continuation continuation);

    LiveData f();

    LiveData g(String str);

    Object h(String str, Date date, Continuation continuation);

    int i(String str);
}
