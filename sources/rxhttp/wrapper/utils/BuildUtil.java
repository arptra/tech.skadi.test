package rxhttp.wrapper.utils;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import rxhttp.wrapper.entity.KeyValuePair;
import rxhttp.wrapper.param.IRequest;

public class BuildUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f3569a = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");

    public static RequestBody a(List list) {
        FormBody.Builder builder = new FormBody.Builder();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                KeyValuePair keyValuePair = (KeyValuePair) it.next();
                Object b = keyValuePair.b();
                if (b != null) {
                    String a2 = keyValuePair.a();
                    if (keyValuePair.c()) {
                        builder.addEncoded(a2, b.toString());
                    } else {
                        builder.add(a2, b.toString());
                    }
                }
            }
        }
        return builder.build();
    }

    public static RequestBody b(MediaType mediaType, List list, List list2) {
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(mediaType);
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                KeyValuePair keyValuePair = (KeyValuePair) it.next();
                Object b = keyValuePair.b();
                if (b != null) {
                    builder.addFormDataPart(keyValuePair.a(), b.toString());
                }
            }
        }
        if (list2 != null) {
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                builder.addPart((MultipartBody.Part) it2.next());
            }
        }
        return builder.build();
    }

    public static Request c(IRequest iRequest, Request.Builder builder) {
        builder.url(iRequest.d()).method(iRequest.getMethod().name(), iRequest.g());
        Headers a2 = iRequest.a();
        if (a2 != null) {
            builder.headers(a2);
        }
        return builder.build();
    }

    public static HttpUrl d(String str, List list, List list2) {
        if (list2 != null) {
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                KeyValuePair keyValuePair = (KeyValuePair) it.next();
                String a2 = keyValuePair.a();
                Object b = keyValuePair.b();
                if (b != null) {
                    String a3 = PathEncoderKt.a(b.toString(), keyValuePair.c());
                    str = str.replace("{" + a2 + "}", a3);
                    if (f3569a.matcher(str).matches()) {
                        throw new IllegalArgumentException("Path parameters shouldn't perform path traversal ('.' or '..'): " + a2 + " is " + b);
                    }
                } else {
                    throw new IllegalArgumentException("Path parameter \"" + a2 + "\" value must not be null.");
                }
            }
        }
        HttpUrl httpUrl = HttpUrl.get(str);
        if (list == null || list.size() == 0) {
            return httpUrl;
        }
        HttpUrl.Builder newBuilder = httpUrl.newBuilder();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            KeyValuePair keyValuePair2 = (KeyValuePair) it2.next();
            String a4 = keyValuePair2.a();
            Object b2 = keyValuePair2.b();
            String obj = b2 == null ? null : b2.toString();
            if (keyValuePair2.c()) {
                newBuilder.addEncodedQueryParameter(a4, obj);
            } else {
                newBuilder.addQueryParameter(a4, obj);
            }
        }
        return newBuilder.build();
    }
}
