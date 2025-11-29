package rxhttp.wrapper.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import rxhttp.RxHttpPlugins;
import rxhttp.wrapper.entity.KeyValuePair;

public class CacheUtil {
    public static JsonObject a(JsonObject jsonObject) {
        if (jsonObject == null) {
            return null;
        }
        List e = RxHttpPlugins.e();
        if (e.isEmpty()) {
            return jsonObject;
        }
        JsonObject jsonObject2 = new JsonObject();
        for (Map.Entry next : jsonObject.entrySet()) {
            String str = (String) next.getKey();
            if (!e.contains(str)) {
                jsonObject2.add(str, (JsonElement) next.getValue());
            }
        }
        return jsonObject2;
    }

    public static List b(List list) {
        if (list == null) {
            return null;
        }
        List e = RxHttpPlugins.e();
        if (e.isEmpty()) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof KeyValuePair) {
                if (e.contains(((KeyValuePair) next).a())) {
                }
            } else if (next instanceof Map) {
            }
            arrayList.add(next);
        }
        return arrayList;
    }

    public static Map c(Map map) {
        if (map == null) {
            return null;
        }
        List e = RxHttpPlugins.e();
        if (e.isEmpty()) {
            return map;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            String obj = entry.getKey().toString();
            if (!e.contains(obj)) {
                linkedHashMap.put(obj, entry.getValue());
            }
        }
        return linkedHashMap;
    }
}
