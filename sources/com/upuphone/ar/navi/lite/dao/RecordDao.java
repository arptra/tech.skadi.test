package com.upuphone.ar.navi.lite.dao;

import androidx.room.Dao;
import com.upuphone.ar.navi.lite.base.Record;
import java.util.List;

@Dao
public abstract class RecordDao {
    public abstract int a();

    public abstract int b(Record... recordArr);

    public abstract void c(String str);

    public abstract void d(String str, int i);

    public void e(Record record) {
        f(record);
        int a2 = a();
        if (a2 > 60) {
            d(record.a(), a2 - 60);
        }
    }

    public abstract void f(Record... recordArr);

    public abstract List g(String str);

    public abstract List h();

    public abstract List i(String str, int i, int i2);

    public abstract void j(Record... recordArr);
}
