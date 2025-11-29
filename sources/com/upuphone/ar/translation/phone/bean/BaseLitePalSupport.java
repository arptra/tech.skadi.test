package com.upuphone.ar.translation.phone.bean;

import com.upuphone.ar.translation.utils.JsonUtils;
import java.io.Serializable;
import org.litepal.crud.LitePalSupport;

public class BaseLitePalSupport extends LitePalSupport implements Serializable {
    public String toString() {
        return JsonUtils.d(this);
    }
}
