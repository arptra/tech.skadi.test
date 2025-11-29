package com.upuphone.ai.ttsengine.engines.cache.db;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Database
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000 \u00072\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/upuphone/ai/ttsengine/engines/cache/db/CacheDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "Lcom/upuphone/ai/ttsengine/engines/cache/db/PCMCacheDao;", "g", "()Lcom/upuphone/ai/ttsengine/engines/cache/db/PCMCacheDao;", "a", "Companion", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
public abstract class CacheDatabase extends RoomDatabase {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f5541a = new Companion((DefaultConstructorMarker) null);
    public static CacheDatabase b;
    public static final CacheDatabase$Companion$MIGRATION_1_2$1 c = new CacheDatabase$Companion$MIGRATION_1_2$1();

    @Metadata(d1 = {"\u0000)\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0006*\u0001\f\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002XT¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/upuphone/ai/ttsengine/engines/cache/db/CacheDatabase$Companion;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lcom/upuphone/ai/ttsengine/engines/cache/db/CacheDatabase;", "a", "(Landroid/content/Context;)Lcom/upuphone/ai/ttsengine/engines/cache/db/CacheDatabase;", "", "DB_NAME", "Ljava/lang/String;", "com/upuphone/ai/ttsengine/engines/cache/db/CacheDatabase$Companion$MIGRATION_1_2$1", "MIGRATION_1_2", "Lcom/upuphone/ai/ttsengine/engines/cache/db/CacheDatabase$Companion$MIGRATION_1_2$1;", "instance", "Lcom/upuphone/ai/ttsengine/engines/cache/db/CacheDatabase;", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CacheDatabase a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            CacheDatabase d = CacheDatabase.b;
            if (d == null) {
                synchronized (this) {
                    d = CacheDatabase.b;
                    if (d == null) {
                        CacheDatabase cacheDatabase = (CacheDatabase) Room.a(context, CacheDatabase.class, "ttsCache").b(CacheDatabase.c).d();
                        CacheDatabase.b = cacheDatabase;
                        d = cacheDatabase;
                    }
                }
            }
            return d;
        }

        public Companion() {
        }
    }

    public abstract PCMCacheDao g();
}
