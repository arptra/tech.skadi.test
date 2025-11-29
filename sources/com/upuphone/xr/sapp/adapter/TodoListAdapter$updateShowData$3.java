package com.upuphone.xr.sapp.adapter;

import com.xjsd.ai.assistant.phone.vui.todo.TodoEntry;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "todoEntry", "Lcom/xjsd/ai/assistant/phone/vui/todo/TodoEntry;", "kotlin.jvm.PlatformType", "invoke", "(Lcom/xjsd/ai/assistant/phone/vui/todo/TodoEntry;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TodoListAdapter$updateShowData$3 extends Lambda implements Function1<TodoEntry, Boolean> {
    public static final TodoListAdapter$updateShowData$3 INSTANCE = new TodoListAdapter$updateShowData$3();

    public TodoListAdapter$updateShowData$3() {
        super(1);
    }

    @NotNull
    public final Boolean invoke(TodoEntry todoEntry) {
        return Boolean.valueOf(todoEntry.getCompleted());
    }
}
