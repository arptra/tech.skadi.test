package rxhttp.wrapper.parse;

import okhttp3.Response;
import rxhttp.wrapper.utils.Converter;

public class SmartParser<T> extends TypeParser<T> {
    public Object a(Response response) {
        return Converter.a(response, this.f3565a[0]);
    }
}
