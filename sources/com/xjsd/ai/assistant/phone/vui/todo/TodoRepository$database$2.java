package com.xjsd.ai.assistant.phone.vui.todo;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.xjsd.ai.assistant.core.ContextHelper;
import com.xjsd.ai.assistant.json.GsonUtils;
import com.xjsd.ai.assistant.log.ILog;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/xjsd/ai/assistant/phone/vui/todo/TodoDatabase;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TodoRepository$database$2 extends Lambda implements Function0<TodoDatabase> {
    public static final TodoRepository$database$2 INSTANCE = new TodoRepository$database$2();

    public TodoRepository$database$2() {
        super(0);
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(String str, List list) {
        Intrinsics.checkNotNullParameter(str, "sql");
        Intrinsics.checkNotNullParameter(list, "bindArgs");
        String e = GsonUtils.e(list);
        ILog.a("TodoRepository", "Query->" + str + ", Args->" + e);
    }

    @NotNull
    public final TodoDatabase invoke() {
        Context a2 = ContextHelper.a();
        Intrinsics.checkNotNullExpressionValue(a2, "getContext(...)");
        RoomDatabase.Builder a3 = Room.a(a2, TodoDatabase.class, "todo-database");
        a aVar = new a();
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(newSingleThreadExecutor, "newSingleThreadExecutor(...)");
        return (TodoDatabase) a3.h(aVar, newSingleThreadExecutor).b(TodoRepository.c).d();
    }
}
