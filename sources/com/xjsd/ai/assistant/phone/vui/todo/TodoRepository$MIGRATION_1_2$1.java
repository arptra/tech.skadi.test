package com.xjsd.ai.assistant.phone.vui.todo;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.xjsd.ai.assistant.log.ILog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/xjsd/ai/assistant/phone/vui/todo/TodoRepository$MIGRATION_1_2$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TodoRepository$MIGRATION_1_2$1 extends Migration {
    public TodoRepository$MIGRATION_1_2$1() {
        super(1, 2);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "database");
        ILog.a("TodoRepository", "migrate: 数据迁移");
        try {
            supportSQLiteDatabase.P("ALTER TABLE todo ADD COLUMN account_id TEXT");
            if (!Intrinsics.areEqual((Object) TodoRepository.b, (Object) "")) {
                String a2 = TodoRepository.b;
                supportSQLiteDatabase.P("UPDATE todo SET account_id = " + a2);
                TodoRepository.f8656a.n();
            }
            ILog.a("TodoRepository", "migrate: Migration from 1 to 2 was successful.");
        } catch (Exception e) {
            ILog.h("TodoRepository", "migrate: Migration from 1 to 2 failed.", e);
        }
    }
}
