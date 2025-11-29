package com.honey.account.l5;

import com.alibaba.fastjson.serializer.ValueFilter;
import com.upuphone.ar.translation.utils.JsonUtils;

public final /* synthetic */ class a implements ValueFilter {
    public final Object process(Object obj, String str, Object obj2) {
        return JsonUtils.f(obj, str, obj2);
    }
}
