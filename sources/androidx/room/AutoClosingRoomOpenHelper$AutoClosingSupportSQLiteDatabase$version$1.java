package androidx.room;

import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public /* synthetic */ class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$version$1 extends MutablePropertyReference1Impl {
    public static final AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$version$1 INSTANCE = new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$version$1();

    public AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$version$1() {
        super(SupportSQLiteDatabase.class, "version", "getVersion()I", 0);
    }

    @Nullable
    public Object get(@Nullable Object obj) {
        return Integer.valueOf(((SupportSQLiteDatabase) obj).getVersion());
    }

    public void set(@Nullable Object obj, @Nullable Object obj2) {
        ((SupportSQLiteDatabase) obj).setVersion(((Number) obj2).intValue());
    }
}
