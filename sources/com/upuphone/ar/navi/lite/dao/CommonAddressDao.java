package com.upuphone.ar.navi.lite.dao;

import androidx.room.Dao;
import com.upuphone.ar.navi.lite.base.CommonAddress;
import java.util.List;

@Dao
public interface CommonAddressDao {
    void a(String str, String str2);

    void b(CommonAddress... commonAddressArr);

    void c(CommonAddress... commonAddressArr);

    List d(String str);

    void e(CommonAddress... commonAddressArr);

    List f(String str, String str2);

    List g();

    void h(String str, String str2, String str3);

    List i(String str);
}
