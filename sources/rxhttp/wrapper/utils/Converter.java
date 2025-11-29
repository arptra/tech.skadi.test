package rxhttp.wrapper.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.lang.reflect.Type;
import okhttp3.Response;
import okhttp3.ResponseBody;
import rxhttp.Platform;
import rxhttp.wrapper.OkHttpCompat;
import rxhttp.wrapper.callback.IConverter;

public class Converter {
    public static Object a(Response response, Type type) {
        ResponseBody o = OkHttpCompat.o(response);
        if (type == ResponseBody.class) {
            try {
                return OkHttpCompat.a(o);
            } finally {
                o.close();
            }
        } else if (Platform.b().c() && type == Bitmap.class) {
            return BitmapFactory.decodeStream(o.byteStream());
        } else {
            return ((IConverter) OkHttpCompat.n(response).tag(IConverter.class)).a(o, type, OkHttpCompat.h(response));
        }
    }
}
