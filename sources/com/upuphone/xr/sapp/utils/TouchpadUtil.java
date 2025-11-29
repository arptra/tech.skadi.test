package com.upuphone.xr.sapp.utils;

import android.os.Vibrator;
import com.google.gson.JsonObject;
import com.honey.account.view.web.WebJs;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.monitor.starry.StarryMessageHelper;
import io.netty.handler.codec.rtsp.RtspHeaders;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004*\u0001 \bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJE\u0010\u0012\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\u0003J\r\u0010\u0019\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u0003J\u000f\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\u0003R\u001b\u0010\u001f\u001a\u00020\u001b8BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u001eR\u0016\u0010\"\u001a\u00020 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010!¨\u0006#"}, d2 = {"Lcom/upuphone/xr/sapp/utils/TouchpadUtil;", "", "<init>", "()V", "", "clickType", "", "c", "(Ljava/lang/String;)V", "", "flingType", "", "x1", "y1", "x2", "y2", "velocityX", "velocityY", "d", "(IFFFFFF)V", "Lcom/google/gson/JsonObject;", "data", "a", "(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;", "e", "f", "g", "Landroid/os/Vibrator;", "b", "Lkotlin/Lazy;", "()Landroid/os/Vibrator;", "vibrator", "com/upuphone/xr/sapp/utils/TouchpadUtil$listener$1", "Lcom/upuphone/xr/sapp/utils/TouchpadUtil$listener$1;", "listener", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TouchpadUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final TouchpadUtil f7927a = new TouchpadUtil();
    public static final Lazy b = LazyKt.lazy(TouchpadUtil$vibrator$2.INSTANCE);
    public static TouchpadUtil$listener$1 c = new TouchpadUtil$listener$1();

    public final JsonObject a(JsonObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "data");
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty(WebJs.ACTION, "phonepad");
        jsonObject2.add("data", jsonObject);
        return jsonObject2;
    }

    public final Vibrator b() {
        return (Vibrator) b.getValue();
    }

    public final void c(String str) {
        Intrinsics.checkNotNullParameter(str, "clickType");
        g();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(WebJs.ACTION, str);
        jsonObject.addProperty(RtspHeaders.Values.TIME, (Number) Long.valueOf(System.currentTimeMillis()));
        JsonObject a2 = a(jsonObject);
        StarryMessageHelper starryMessageHelper = StarryMessageHelper.f7799a;
        String jsonElement = a2.toString();
        Intrinsics.checkNotNullExpressionValue(jsonElement, "toString(...)");
        starryMessageHelper.l(jsonElement, c, "com.upuphone.star.launcher");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("TouchpadUtil", "sendClickEvent: " + a2);
    }

    public final void d(int i, float f, float f2, float f3, float f4, float f5, float f6) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(WebJs.ACTION, "gestureMode");
        jsonObject.addProperty("actionType", (Number) Integer.valueOf(i));
        jsonObject.addProperty("startX", (Number) Float.valueOf(f));
        jsonObject.addProperty("startY", (Number) Float.valueOf(f2));
        jsonObject.addProperty("endX", (Number) Float.valueOf(f3));
        jsonObject.addProperty("endY", (Number) Float.valueOf(f4));
        jsonObject.addProperty("speedX", (Number) Float.valueOf(f5));
        jsonObject.addProperty("speedY", (Number) Float.valueOf(f6));
        jsonObject.addProperty(RtspHeaders.Values.TIME, (Number) Long.valueOf(System.currentTimeMillis()));
        JsonObject a2 = a(jsonObject);
        StarryMessageHelper starryMessageHelper = StarryMessageHelper.f7799a;
        String jsonElement = a2.toString();
        Intrinsics.checkNotNullExpressionValue(jsonElement, "toString(...)");
        starryMessageHelper.l(jsonElement, c, "com.upuphone.star.launcher");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("TouchpadUtil", "sendGestureEvent: " + a2);
    }

    public final void e() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(WebJs.ACTION, MzContactsContract.START_PARAM_KEY);
        jsonObject.addProperty(RtspHeaders.Values.TIME, (Number) Long.valueOf(System.currentTimeMillis()));
        JsonObject a2 = a(jsonObject);
        StarryMessageHelper starryMessageHelper = StarryMessageHelper.f7799a;
        String jsonElement = a2.toString();
        Intrinsics.checkNotNullExpressionValue(jsonElement, "toString(...)");
        starryMessageHelper.l(jsonElement, c, "com.upuphone.star.launcher");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("TouchpadUtil", "sendStartEvent: " + a2);
    }

    public final void f() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(WebJs.ACTION, "stop");
        jsonObject.addProperty(RtspHeaders.Values.TIME, (Number) Long.valueOf(System.currentTimeMillis()));
        JsonObject a2 = a(jsonObject);
        StarryMessageHelper starryMessageHelper = StarryMessageHelper.f7799a;
        String jsonElement = a2.toString();
        Intrinsics.checkNotNullExpressionValue(jsonElement, "toString(...)");
        starryMessageHelper.l(jsonElement, c, "com.upuphone.star.launcher");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("TouchpadUtil", "sendStopEvent: " + a2);
    }

    public final void g() {
        b().vibrate(100);
    }
}
