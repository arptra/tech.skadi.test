package rxhttp.wrapper.callback;

import java.lang.reflect.Type;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

public interface IConverter {
    Object a(ResponseBody responseBody, Type type, boolean z);

    RequestBody convert(Object obj) {
        return RequestBody.create((MediaType) null, new byte[0]);
    }
}
