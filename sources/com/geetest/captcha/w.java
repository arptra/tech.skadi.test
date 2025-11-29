package com.geetest.captcha;

import com.upuphone.starrynet.payload.PayloadConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\rB!\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\fR\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/geetest/captcha/model/ErrorBean;", "", "", "code", "msg", "Lorg/json/JSONObject;", "desc", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V", "toJson", "()Ljava/lang/String;", "Ljava/lang/String;", "Lorg/json/JSONObject;", "Companion", "captcha_release"}, k = 1, mv = {1, 4, 1})
public final class w {
    public static final a d = new a();

    /* renamed from: a  reason: collision with root package name */
    public final String f2885a;
    public final String b;
    public final JSONObject c;

    public static final class a {
        public final w a(String str, String str2, JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(str, "code");
            Intrinsics.checkNotNullParameter(str2, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
            Intrinsics.checkNotNullParameter(jSONObject, "desc");
            return new w(str, str2, jSONObject);
        }
    }

    public w(String str, String str2, JSONObject jSONObject) {
        this.f2885a = str;
        this.b = str2;
        this.c = jSONObject;
    }

    public final String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", this.f2885a);
            jSONObject.put(PayloadConstant.PARAMS_KEY_CALLBACK_MSG, this.b);
            jSONObject.put("desc", this.c);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
        return jSONObject2;
    }
}
