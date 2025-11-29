package com.upuphone.ar.fastrecord.phone.db;

import androidx.room.TypeConverter;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\u0010\u0007J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/db/RecordDateConverter;", "", "()V", "fromDate", "", "date", "Ljava/util/Date;", "(Ljava/util/Date;)Ljava/lang/Long;", "toDate", "timestamp", "(Ljava/lang/Long;)Ljava/util/Date;", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRecordDateConverter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecordDateConverter.kt\ncom/upuphone/ar/fastrecord/phone/db/RecordDateConverter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,16:1\n1#2:17\n*E\n"})
public final class RecordDateConverter {
    @TypeConverter
    @Nullable
    public final Long fromDate(@Nullable Date date) {
        if (date != null) {
            return Long.valueOf(date.getTime());
        }
        return null;
    }

    @TypeConverter
    @Nullable
    public final Date toDate(@Nullable Long l) {
        if (l != null) {
            return new Date(l.longValue());
        }
        return null;
    }
}
