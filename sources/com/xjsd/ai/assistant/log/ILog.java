package com.xjsd.ai.assistant.log;

import com.alibaba.fastjson.JSONObject;
import com.honey.account.constant.AccountConstantKt;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ILog {

    /* renamed from: a  reason: collision with root package name */
    public static ILogger f8501a;
    public static ILogger b;

    static {
        DefaultLogger defaultLogger = new DefaultLogger();
        f8501a = defaultLogger;
        b = defaultLogger;
    }

    public static void a(String str, String str2) {
        ILogger iLogger = f8501a;
        iLogger.d("VSP@" + str, str2);
    }

    public static void b(String str, String str2, Throwable th) {
        ILogger iLogger = f8501a;
        iLogger.d("VSP@" + str, str2, th);
    }

    public static void c(String str, String str2, Object... objArr) {
        ILogger iLogger = f8501a;
        iLogger.d("VSP@" + str, String.format(str2, objArr));
    }

    public static void d(String str, Object obj) {
        ILogger iLogger = b;
        iLogger.d("VSP@AutoTest", " -- " + str + AccountConstantKt.CODE_SEPARTOR + obj);
    }

    public static void e(String str, Object obj) {
        String format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS").format(LocalDateTime.now());
        JSONObject jSONObject = new JSONObject();
        if (obj == null) {
            obj = "";
        }
        jSONObject.put("result", obj);
        jSONObject.put(RtspHeaders.Values.TIME, (Object) format);
        ILogger iLogger = b;
        iLogger.d("VSP@AutoTest", " -- " + str + AccountConstantKt.CODE_SEPARTOR + jSONObject.toJSONString());
    }

    public static void f(String str) {
        DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        ILogger iLogger = b;
        iLogger.d("VSP@AutoTest", " -- " + str + AccountConstantKt.CODE_SEPARTOR + ofPattern.format(LocalDateTime.now()));
    }

    public static void g(String str, String str2) {
        ILogger iLogger = f8501a;
        iLogger.e("VSP@" + str, str2);
    }

    public static void h(String str, String str2, Throwable th) {
        ILogger iLogger = f8501a;
        iLogger.e("VSP@" + str, str2, th);
    }

    public static void i(String str, String str2, Object... objArr) {
        ILogger iLogger = f8501a;
        iLogger.e("VSP@" + str, String.format(str2, objArr));
    }

    public static void j(String str, String str2) {
        ILogger iLogger = f8501a;
        iLogger.i("VSP@" + str, str2);
    }

    public static void k(String str, String str2, Object... objArr) {
        ILogger iLogger = f8501a;
        iLogger.i("VSP@" + str, String.format(str2, objArr));
    }

    public static void l(ILogger iLogger) {
        b = iLogger;
        iLogger.setEnable(true);
        f8501a = iLogger;
    }

    public static void m(String str, String str2) {
        ILogger iLogger = f8501a;
        iLogger.w("VSP@" + str, str2);
    }

    public static void n(String str, String str2, Throwable th) {
        ILogger iLogger = f8501a;
        iLogger.w("VSP@" + str, str2, th);
    }
}
