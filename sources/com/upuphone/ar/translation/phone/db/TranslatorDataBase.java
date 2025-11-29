package com.upuphone.ar.translation.phone.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.upuphone.ar.translation.phone.dao.IntelExtnSummaryDao;
import com.upuphone.ar.translation.phone.dao.IntelExtnTodoDao;
import kotlin.Metadata;

@Database
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/upuphone/ar/translation/phone/db/TranslatorDataBase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "Lcom/upuphone/ar/translation/phone/dao/IntelExtnTodoDao;", "e", "()Lcom/upuphone/ar/translation/phone/dao/IntelExtnTodoDao;", "Lcom/upuphone/ar/translation/phone/dao/IntelExtnSummaryDao;", "d", "()Lcom/upuphone/ar/translation/phone/dao/IntelExtnSummaryDao;", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public abstract class TranslatorDataBase extends RoomDatabase {
    public abstract IntelExtnSummaryDao d();

    public abstract IntelExtnTodoDao e();
}
