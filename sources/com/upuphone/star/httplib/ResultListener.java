package com.upuphone.star.httplib;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH&J\u0015\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/upuphone/star/httplib/ResultListener;", "T", "", "onError", "", "code", "", "msg", "", "rawContent", "onResult", "result", "(Ljava/lang/Object;)V", "super-http-lib_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ResultListener<T> {
    void onError(int i, String str, String str2);

    void onResult(Object obj);
}
