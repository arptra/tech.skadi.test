package com.upuphone.star.httplib;

import java.lang.reflect.Type;
import kotlin.Metadata;
import okhttp3.Response;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J+\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/upuphone/star/httplib/ResponseParser;", "", "T", "Lokhttp3/Response;", "response", "Ljava/lang/reflect/Type;", "type", "Lcom/upuphone/star/httplib/HttpResult;", "a", "(Lokhttp3/Response;Ljava/lang/reflect/Type;)Lcom/upuphone/star/httplib/HttpResult;", "super-http-lib_release"}, k = 1, mv = {1, 8, 0})
public interface ResponseParser {
    HttpResult a(Response response, Type type);
}
