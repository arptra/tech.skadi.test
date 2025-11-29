package com.upuphone.xr.account.util;

import androidx.annotation.RequiresApi;
import com.honey.account.o7.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.StringJoiner;

public class StringUtil {
    @RequiresApi
    public static String createLinkString(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList);
        StringJoiner stringJoiner = new StringJoiner("&");
        arrayList.forEach(new a(stringJoiner, map));
        return stringJoiner.toString();
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$createLinkString$0(StringJoiner stringJoiner, Map map, String str) {
        try {
            stringJoiner.add(str + "=" + map.get(str));
        } catch (Exception unused) {
        }
    }
}
