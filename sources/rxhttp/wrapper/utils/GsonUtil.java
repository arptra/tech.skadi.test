package rxhttp.wrapper.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.honey.account.sc.a;
import com.honey.account.sc.b;
import com.honey.account.sc.c;
import com.honey.account.sc.d;
import com.honey.account.sc.e;
import java.lang.reflect.Type;

public class GsonUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final JsonDeserializer f3570a = new a();
    public static final JsonDeserializer b = new b();
    public static final JsonDeserializer c = new c();
    public static final JsonDeserializer d = new d();
    public static final JsonDeserializer e = new e();

    public static final class GsonHolder {

        /* renamed from: a  reason: collision with root package name */
        public static final Gson f3571a = GsonUtil.n();
    }

    public static Gson g() {
        return GsonHolder.f3571a;
    }

    public static boolean h(JsonElement jsonElement) {
        try {
            String asString = jsonElement.getAsString();
            return "".equals(asString) || "null".equals(asString);
        } catch (Exception unused) {
            return false;
        }
    }

    public static /* synthetic */ String i(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        return jsonElement instanceof JsonPrimitive ? jsonElement.getAsString() : jsonElement.toString();
    }

    public static /* synthetic */ Integer j(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        return Integer.valueOf(h(jsonElement) ? 0 : jsonElement.getAsInt());
    }

    public static /* synthetic */ Float k(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        return Float.valueOf(h(jsonElement) ? 0.0f : jsonElement.getAsFloat());
    }

    public static /* synthetic */ Double l(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        return Double.valueOf(h(jsonElement) ? 0.0d : jsonElement.getAsDouble());
    }

    public static /* synthetic */ Long m(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        return Long.valueOf(h(jsonElement) ? 0 : jsonElement.getAsLong());
    }

    public static Gson n() {
        GsonBuilder registerTypeAdapter = new GsonBuilder().disableHtmlEscaping().registerTypeAdapter(String.class, f3570a);
        Class cls = Integer.TYPE;
        JsonDeserializer jsonDeserializer = b;
        GsonBuilder registerTypeAdapter2 = registerTypeAdapter.registerTypeAdapter(cls, jsonDeserializer).registerTypeAdapter(Integer.class, jsonDeserializer);
        Class cls2 = Float.TYPE;
        JsonDeserializer jsonDeserializer2 = c;
        GsonBuilder registerTypeAdapter3 = registerTypeAdapter2.registerTypeAdapter(cls2, jsonDeserializer2).registerTypeAdapter(Float.class, jsonDeserializer2);
        Class cls3 = Double.TYPE;
        JsonDeserializer jsonDeserializer3 = d;
        GsonBuilder registerTypeAdapter4 = registerTypeAdapter3.registerTypeAdapter(cls3, jsonDeserializer3).registerTypeAdapter(Double.class, jsonDeserializer3);
        Class cls4 = Long.TYPE;
        JsonDeserializer jsonDeserializer4 = e;
        return registerTypeAdapter4.registerTypeAdapter(cls4, jsonDeserializer4).registerTypeAdapter(Long.class, jsonDeserializer4).create();
    }

    public static String o(Object obj) {
        return g().toJson(obj);
    }
}
