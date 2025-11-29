package com.upuphone.ar.fastrecord.phone.http;

import android.text.TextUtils;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.listener.IHttpResponse;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean.SummaryRequestBean;
import io.netty.handler.codec.http.HttpHeaders;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J \u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0016\u0010 \u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u001fJ\u0016\u0010\"\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u001fJ\u000e\u0010#\u001a\u00020$2\u0006\u0010\u0019\u001a\u00020\u0004J\u0010\u0010%\u001a\u00020$2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004J\u0010\u0010&\u001a\u00020$2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004J\u000e\u0010'\u001a\u00020$2\u0006\u0010\u0019\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/http/HttpRequestManger;", "", "()V", "KEY_ACCOUNT_ID", "", "KEY_APP_NAME", "KEY_FUNCTION_TYPE", "KEY_METADATA", "KEY_PAY_LOAD", "KEY_RECOGNIZE_ID", "KEY_SERVICES", "KEY_TERMINAL_TRACE_ID", "KEY_TYPE", "TAG", "TIME_OUT", "", "TYPE_SENSITIVE_LOCK", "TYPE_SENSITIVE_REQUEST", "TYPE_SENSITIVE_RESPONSE", "TYPE_SUMMARY", "TYPE_TODOS", "URL_BASE", "httpRequestClient", "Lokhttp3/OkHttpClient;", "createRequestBody", "type", "requestBean", "Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/bean/SummaryRequestBean;", "getSmartExtract", "", "httpResponse", "Lcom/upuphone/ar/fastrecord/phone/listener/IHttpResponse;", "getSummary", "response", "getTodoList", "isLockResult", "", "isRequestSensitive", "isResponseSensitive", "isSensitiveResult", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class HttpRequestManger {
    @NotNull
    public static final HttpRequestManger INSTANCE = new HttpRequestManger();
    @NotNull
    private static final String KEY_ACCOUNT_ID = "accountId";
    @NotNull
    private static final String KEY_APP_NAME = "appName";
    @NotNull
    private static final String KEY_FUNCTION_TYPE = "functionType";
    @NotNull
    private static final String KEY_METADATA = "metadata";
    @NotNull
    private static final String KEY_PAY_LOAD = "payload";
    @NotNull
    private static final String KEY_RECOGNIZE_ID = "recognizeId";
    @NotNull
    private static final String KEY_SERVICES = "services";
    @NotNull
    private static final String KEY_TERMINAL_TRACE_ID = "terminalTraceId";
    @NotNull
    private static final String KEY_TYPE = "type";
    @NotNull
    private static final String TAG = "HttpRequestManger";
    private static final long TIME_OUT = 180000;
    @NotNull
    private static final String TYPE_SENSITIVE_LOCK = "sensitive_Lock";
    @NotNull
    private static final String TYPE_SENSITIVE_REQUEST = "sensitive_request";
    @NotNull
    private static final String TYPE_SENSITIVE_RESPONSE = "sensitive_response";
    @NotNull
    private static final String TYPE_SUMMARY = "summary";
    @NotNull
    private static final String TYPE_TODOS = "todos";
    @NotNull
    private static final String URL_BASE = "https://km-uat.myvu.cn/central-manager/recoding";
    @NotNull
    private static final OkHttpClient httpRequestClient;

    static {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        httpRequestClient = builder.connectTimeout(180000, timeUnit).readTimeout(180000, timeUnit).build();
    }

    private HttpRequestManger() {
    }

    private final String createRequestBody(String str, SummaryRequestBean summaryRequestBean) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(KEY_RECOGNIZE_ID, summaryRequestBean.getRecognizeId());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("type", str);
        jSONObject2.put(KEY_PAY_LOAD, jSONObject);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("type", "llm");
        jSONObject3.put(KEY_PAY_LOAD, jSONObject2);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put(KEY_SERVICES, jSONArray);
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put(KEY_ACCOUNT_ID, summaryRequestBean.getAccountId());
        jSONObject5.put(KEY_TERMINAL_TRACE_ID, uuid);
        jSONObject5.put(KEY_FUNCTION_TYPE, 4);
        jSONObject5.put(KEY_APP_NAME, summaryRequestBean.getAppName());
        jSONObject4.put(KEY_METADATA, jSONObject5);
        LogExt.logE("createRequestBody  parameter=" + jSONObject4 + "\n uuId" + uuid, TAG);
        String jSONObject6 = jSONObject4.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject6, "toString(...)");
        return jSONObject6;
    }

    private final void getSmartExtract(String str, SummaryRequestBean summaryRequestBean, IHttpResponse iHttpResponse) {
        httpRequestClient.newCall(new Request.Builder().url(URL_BASE).post(RequestBody.Companion.create(MediaType.Companion.parse(HttpHeaders.Values.APPLICATION_JSON), createRequestBody(str, summaryRequestBean))).build()).enqueue(new HttpRequestManger$getSmartExtract$1(iHttpResponse));
    }

    public final void getSummary(@NotNull SummaryRequestBean summaryRequestBean, @NotNull IHttpResponse iHttpResponse) {
        Intrinsics.checkNotNullParameter(summaryRequestBean, "requestBean");
        Intrinsics.checkNotNullParameter(iHttpResponse, "response");
        getSmartExtract("summary", summaryRequestBean, iHttpResponse);
    }

    public final void getTodoList(@NotNull SummaryRequestBean summaryRequestBean, @NotNull IHttpResponse iHttpResponse) {
        Intrinsics.checkNotNullParameter(summaryRequestBean, "requestBean");
        Intrinsics.checkNotNullParameter(iHttpResponse, "response");
        getSmartExtract("todos", summaryRequestBean, iHttpResponse);
    }

    public final boolean isLockResult(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        return !TextUtils.isEmpty(str) && Intrinsics.areEqual((Object) str, (Object) TYPE_SENSITIVE_LOCK);
    }

    public final boolean isRequestSensitive(@Nullable String str) {
        return !TextUtils.isEmpty(str) && Intrinsics.areEqual((Object) str, (Object) "sensitive_request");
    }

    public final boolean isResponseSensitive(@Nullable String str) {
        return !TextUtils.isEmpty(str) && Intrinsics.areEqual((Object) str, (Object) TYPE_SENSITIVE_RESPONSE);
    }

    public final boolean isSensitiveResult(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Intrinsics.areEqual((Object) str, (Object) "sensitive_request") ? true : Intrinsics.areEqual((Object) str, (Object) TYPE_SENSITIVE_RESPONSE);
    }
}
