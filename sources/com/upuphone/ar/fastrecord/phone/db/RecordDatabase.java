package com.upuphone.ar.fastrecord.phone.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Database
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0014H&¨\u0006\u0016"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/db/RecordDatabase;", "Landroidx/room/RoomDatabase;", "()V", "fastRecordDao", "Lcom/upuphone/ar/fastrecord/phone/db/FastRecordDao;", "fastRecordPersonDao", "Lcom/upuphone/ar/fastrecord/phone/db/FastRecordPersonDao;", "fastRecordPersonHistoryDao", "Lcom/upuphone/ar/fastrecord/phone/db/FastRecordPersonHistoryDao;", "fastRecordSummaryDao", "Lcom/upuphone/ar/fastrecord/phone/db/FastRecordSummaryDao;", "fastRecordTagDao", "Lcom/upuphone/ar/fastrecord/phone/db/FastRecordTagDao;", "fastRecordTagHistoryDao", "Lcom/upuphone/ar/fastrecord/phone/db/FastRecordTagHistoryDao;", "fastRecordTodoItemDao", "Lcom/upuphone/ar/fastrecord/phone/db/FastRecordTodoItemDao;", "fastRecordVoiceDao", "Lcom/upuphone/ar/fastrecord/phone/db/FastRecordVoiceDao;", "fastRecordVoiceWordDao", "Lcom/upuphone/ar/fastrecord/phone/db/FastRecordVoiceWordDao;", "Companion", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@TypeConverters
public abstract class RecordDatabase extends RoomDatabase {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @Nullable
    public static RecordDatabase INSTANCE;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/db/RecordDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/upuphone/ar/fastrecord/phone/db/RecordDatabase;", "get", "context", "Landroid/content/Context;", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARNING: type inference failed for: r4v5, types: [androidx.room.RoomDatabase] */
        /* JADX WARNING: Multi-variable type inference failed */
        @org.jetbrains.annotations.NotNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.upuphone.ar.fastrecord.phone.db.RecordDatabase get(@org.jetbrains.annotations.NotNull android.content.Context r4) {
            /*
                r3 = this;
                java.lang.String r0 = "context"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                com.upuphone.ar.fastrecord.phone.db.RecordDatabase r0 = com.upuphone.ar.fastrecord.phone.db.RecordDatabase.INSTANCE
                if (r0 != 0) goto L_0x0039
                monitor-enter(r3)
                java.lang.Class<com.upuphone.ar.fastrecord.phone.db.RecordDatabase> r0 = com.upuphone.ar.fastrecord.phone.db.RecordDatabase.class
                java.lang.String r1 = "short_hand"
                androidx.room.RoomDatabase$Builder r4 = androidx.room.Room.a(r4, r0, r1)     // Catch:{ all -> 0x0036 }
                androidx.room.RoomDatabase$Builder r4 = r4.e()     // Catch:{ all -> 0x0036 }
                com.upuphone.ar.fastrecord.phone.db.RecordDatabase$Companion$get$1$instance$1 r0 = com.upuphone.ar.fastrecord.phone.db.RecordDatabase$Companion$get$1$instance$1.INSTANCE     // Catch:{ all -> 0x0036 }
                r1 = 62
                r2 = 63
                androidx.room.migration.Migration r0 = androidx.room.migration.MigrationKt.a(r1, r2, r0)     // Catch:{ all -> 0x0036 }
                androidx.room.migration.Migration[] r0 = new androidx.room.migration.Migration[]{r0}     // Catch:{ all -> 0x0036 }
                androidx.room.RoomDatabase$Builder r4 = r4.b(r0)     // Catch:{ all -> 0x0036 }
                androidx.room.RoomDatabase r4 = r4.d()     // Catch:{ all -> 0x0036 }
                r0 = r4
                com.upuphone.ar.fastrecord.phone.db.RecordDatabase r0 = (com.upuphone.ar.fastrecord.phone.db.RecordDatabase) r0     // Catch:{ all -> 0x0036 }
                com.upuphone.ar.fastrecord.phone.db.RecordDatabase.INSTANCE = r0     // Catch:{ all -> 0x0036 }
                monitor-exit(r3)
                goto L_0x0039
            L_0x0036:
                r4 = move-exception
                monitor-exit(r3)
                throw r4
            L_0x0039:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.db.RecordDatabase.Companion.get(android.content.Context):com.upuphone.ar.fastrecord.phone.db.RecordDatabase");
        }

        private Companion() {
        }
    }

    @NotNull
    public abstract FastRecordDao fastRecordDao();

    @NotNull
    public abstract FastRecordPersonDao fastRecordPersonDao();

    @NotNull
    public abstract FastRecordPersonHistoryDao fastRecordPersonHistoryDao();

    @NotNull
    public abstract FastRecordSummaryDao fastRecordSummaryDao();

    @NotNull
    public abstract FastRecordTagDao fastRecordTagDao();

    @NotNull
    public abstract FastRecordTagHistoryDao fastRecordTagHistoryDao();

    @NotNull
    public abstract FastRecordTodoItemDao fastRecordTodoItemDao();

    @NotNull
    public abstract FastRecordVoiceDao fastRecordVoiceDao();

    @NotNull
    public abstract FastRecordVoiceWordDao fastRecordVoiceWordDao();
}
