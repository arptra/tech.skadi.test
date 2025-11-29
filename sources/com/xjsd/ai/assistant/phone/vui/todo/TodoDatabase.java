package com.xjsd.ai.assistant.phone.vui.todo;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import kotlin.Metadata;

@Database
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/xjsd/ai/assistant/phone/vui/todo/TodoDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "Lcom/xjsd/ai/assistant/phone/vui/todo/TodoDao;", "d", "()Lcom/xjsd/ai/assistant/phone/vui/todo/TodoDao;", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
@TypeConverters
public abstract class TodoDatabase extends RoomDatabase {
    public abstract TodoDao d();
}
