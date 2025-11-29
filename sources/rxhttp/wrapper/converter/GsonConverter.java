package rxhttp.wrapper.converter;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonWriter;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import kotlin.text.Charsets;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okio.Buffer;
import rxhttp.RxHttpPlugins;
import rxhttp.wrapper.callback.JsonConverter;
import rxhttp.wrapper.utils.GsonUtil;

public class GsonConverter implements JsonConverter {
    public final Gson b;
    public final MediaType c;

    public GsonConverter(Gson gson, MediaType mediaType) {
        this.b = gson;
        this.c = mediaType;
    }

    public static GsonConverter b() {
        return c(GsonUtil.g());
    }

    public static GsonConverter c(Gson gson) {
        return d(gson, JsonConverter.f3540a);
    }

    public static GsonConverter d(Gson gson, MediaType mediaType) {
        if (gson != null) {
            return new GsonConverter(gson, mediaType);
        }
        throw new NullPointerException("gson == null");
    }

    public Object a(ResponseBody responseBody, Type type, boolean z) {
        try {
            String string = responseBody.string();
            if (z) {
                string = RxHttpPlugins.i(string);
            }
            if (type == String.class) {
                responseBody.close();
                return string;
            }
            Object fromJson = this.b.fromJson(string, type);
            if (fromJson != null) {
                responseBody.close();
                return fromJson;
            }
            throw new IllegalStateException("GsonConverter Could not deserialize body as " + type);
        } catch (Throwable th) {
            responseBody.close();
            throw th;
        }
    }

    public RequestBody convert(Object obj) {
        TypeAdapter<?> adapter = this.b.getAdapter(TypeToken.get(obj.getClass()));
        Buffer buffer = new Buffer();
        JsonWriter newJsonWriter = this.b.newJsonWriter(new OutputStreamWriter(buffer.outputStream(), Charsets.UTF_8));
        adapter.write(newJsonWriter, obj);
        newJsonWriter.close();
        return RequestBody.create(this.c, buffer.readByteString());
    }
}
