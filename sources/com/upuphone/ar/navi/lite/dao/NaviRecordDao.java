package com.upuphone.ar.navi.lite.dao;

import androidx.room.Dao;
import com.upuphone.ar.navi.lite.base.NaviRecord;
import java.util.List;

@Dao
public interface NaviRecordDao {
    List a(String str, String str2, double d, double d2);

    List b(String str);

    List c(String str, int i);

    List d();

    void e(NaviRecord... naviRecordArr);

    void f(NaviRecord... naviRecordArr);

    List g(String str);

    List h(String str);

    void i(String str);

    void j(NaviRecord... naviRecordArr);
}
