package com.xjsd.ai.assistant.net.http;

import android.text.TextUtils;
import com.upuphone.runasone.api.ApiConstant;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.api.cache.CacheAbility;
import com.xjsd.ai.assistant.json.GsonUtils;
import com.xjsd.ai.assistant.net.http.TokenResBody;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u0011\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ3\u0010\u0013\u001a\u00020\u00062\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000f2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/xjsd/ai/assistant/net/http/TokenGenerator;", "", "<init>", "()V", "Lokhttp3/Interceptor$Chain;", "chain", "", "a", "(Lokhttp3/Interceptor$Chain;)Ljava/lang/String;", "c", "()Ljava/lang/String;", "b", "Lokhttp3/Request;", "d", "()Lokhttp3/Request;", "", "signMap", "userKey", "userSecret", "f", "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Lokhttp3/Response;", "response", "e", "(Lokhttp3/Response;)Ljava/lang/String;", "lib_assistant_release"}, k = 1, mv = {1, 9, 0})
public final class TokenGenerator {

    /* renamed from: a  reason: collision with root package name */
    public static final TokenGenerator f8505a = new TokenGenerator();

    public final String a(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        try {
            Request d = d();
            TokenGeneratorKt.a("获取token，request->" + d, "TokenGenerator");
            return d == null ? "" : e(chain.proceed(d));
        } catch (Exception e) {
            String stackTraceToString = ExceptionsKt.stackTraceToString(e);
            TokenGeneratorKt.a("获取token，发生异常->" + stackTraceToString, "TokenGenerator");
            return "";
        }
    }

    public final String b() {
        try {
            Request d = d();
            TokenGeneratorKt.a("获取token，request->" + d, "TokenGenerator");
            return d == null ? "" : e(OkHttpClientManager.f8504a.d().newCall(d).execute());
        } catch (Exception e) {
            String stackTraceToString = ExceptionsKt.stackTraceToString(e);
            TokenGeneratorKt.a("获取token，发生异常->" + stackTraceToString, "TokenGenerator");
            return "";
        }
    }

    public final String c() {
        CacheAbility cacheAbility = (CacheAbility) AbilityManager.b.b(CacheAbility.class);
        String str = null;
        String persistValue = cacheAbility != null ? cacheAbility.getPersistValue("tokenExp") : null;
        String str2 = "";
        if (persistValue == null) {
            persistValue = str2;
        }
        if (cacheAbility != null) {
            str = cacheAbility.getPersistValue(ApiConstant.KEY_TOKEN);
        }
        if (str != null) {
            str2 = str;
        }
        return (str2.length() == 0 || persistValue.length() == 0 || System.currentTimeMillis() > Long.parseLong(persistValue)) ? b() : str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0027, code lost:
        r5 = (r5 = r2.getCurrentEnv()).getUserKey();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final okhttp3.Request d() {
        /*
            r14 = this;
            java.lang.String r0 = "application/json; charset=utf-8"
            java.lang.String r1 = "TokenGenerator"
            com.xjsd.ai.assistant.core.AbilityManager r2 = com.xjsd.ai.assistant.core.AbilityManager.b
            java.lang.Class<com.xjsd.ai.assistant.env.EnvAbility> r3 = com.xjsd.ai.assistant.env.EnvAbility.class
            com.xjsd.ai.assistant.core.Ability r2 = r2.b(r3)
            com.xjsd.ai.assistant.env.EnvAbility r2 = (com.xjsd.ai.assistant.env.EnvAbility) r2
            java.lang.String r3 = ""
            if (r2 == 0) goto L_0x001e
            com.xjsd.ai.assistant.env.Environment r4 = r2.getCurrentEnv()
            if (r4 == 0) goto L_0x001e
            java.lang.String r4 = r4.getNluUrl()
            if (r4 != 0) goto L_0x001f
        L_0x001e:
            r4 = r3
        L_0x001f:
            if (r2 == 0) goto L_0x0030
            com.xjsd.ai.assistant.env.Environment r5 = r2.getCurrentEnv()
            if (r5 == 0) goto L_0x0030
            java.lang.String r5 = r5.getUserKey()
            if (r5 != 0) goto L_0x002e
            goto L_0x0030
        L_0x002e:
            r8 = r5
            goto L_0x0031
        L_0x0030:
            r8 = r3
        L_0x0031:
            if (r2 == 0) goto L_0x0042
            com.xjsd.ai.assistant.env.Environment r5 = r2.getCurrentEnv()
            if (r5 == 0) goto L_0x0042
            java.lang.String r5 = r5.getAppId()
            if (r5 != 0) goto L_0x0040
            goto L_0x0042
        L_0x0040:
            r7 = r5
            goto L_0x0043
        L_0x0042:
            r7 = r3
        L_0x0043:
            if (r2 == 0) goto L_0x0053
            com.xjsd.ai.assistant.env.Environment r2 = r2.getCurrentEnv()
            if (r2 == 0) goto L_0x0053
            java.lang.String r2 = r2.getUserSecret()
            if (r2 != 0) goto L_0x0052
            goto L_0x0053
        L_0x0052:
            r3 = r2
        L_0x0053:
            java.lang.String r2 = com.xjsd.ai.assistant.core.util.DeviceUtils.a()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010b }
            r5.<init>()     // Catch:{ Exception -> 0x010b }
            r5.append(r4)     // Catch:{ Exception -> 0x010b }
            java.lang.String r4 = "/auth/token/get"
            r5.append(r4)     // Catch:{ Exception -> 0x010b }
            java.lang.String r4 = r5.toString()     // Catch:{ Exception -> 0x010b }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010b }
            r5.<init>()     // Catch:{ Exception -> 0x010b }
            java.lang.String r6 = "getToken tokenUrl->"
            r5.append(r6)     // Catch:{ Exception -> 0x010b }
            r5.append(r4)     // Catch:{ Exception -> 0x010b }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x010b }
            com.xjsd.ai.assistant.net.http.TokenGeneratorKt.a(r5, r1)     // Catch:{ Exception -> 0x010b }
            okhttp3.Headers$Builder r5 = new okhttp3.Headers$Builder     // Catch:{ Exception -> 0x010b }
            r5.<init>()     // Catch:{ Exception -> 0x010b }
            java.lang.String r6 = "Content-Type"
            okhttp3.Headers$Builder r5 = r5.add((java.lang.String) r6, (java.lang.String) r0)     // Catch:{ Exception -> 0x010b }
            java.lang.String r6 = "WR-Client-Id"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)     // Catch:{ Exception -> 0x010b }
            okhttp3.Headers$Builder r2 = r5.add((java.lang.String) r6, (java.lang.String) r2)     // Catch:{ Exception -> 0x010b }
            java.lang.String r5 = "WR-ukey"
            okhttp3.Headers$Builder r2 = r2.add((java.lang.String) r5, (java.lang.String) r8)     // Catch:{ Exception -> 0x010b }
            okhttp3.Headers r2 = r2.build()     // Catch:{ Exception -> 0x010b }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x010b }
            java.lang.String r10 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x010b }
            java.lang.String r5 = "appid"
            kotlin.Pair r5 = kotlin.TuplesKt.to(r5, r7)     // Catch:{ Exception -> 0x010b }
            java.lang.String r6 = "ukey"
            kotlin.Pair r6 = kotlin.TuplesKt.to(r6, r8)     // Catch:{ Exception -> 0x010b }
            java.lang.String r9 = "authType"
            java.lang.String r11 = "3"
            kotlin.Pair r9 = kotlin.TuplesKt.to(r9, r11)     // Catch:{ Exception -> 0x010b }
            java.lang.String r11 = "time"
            kotlin.Pair r11 = kotlin.TuplesKt.to(r11, r10)     // Catch:{ Exception -> 0x010b }
            kotlin.Pair[] r5 = new kotlin.Pair[]{r5, r6, r9, r11}     // Catch:{ Exception -> 0x010b }
            java.util.HashMap r5 = kotlin.collections.MapsKt.hashMapOf(r5)     // Catch:{ Exception -> 0x010b }
            okhttp3.RequestBody$Companion r12 = okhttp3.RequestBody.Companion     // Catch:{ Exception -> 0x010b }
            com.xjsd.ai.assistant.net.http.TokenReqBody r13 = new com.xjsd.ai.assistant.net.http.TokenReqBody     // Catch:{ Exception -> 0x010b }
            java.lang.String r11 = r14.f(r5, r8, r3)     // Catch:{ Exception -> 0x010b }
            r9 = 3
            r6 = r13
            r6.<init>(r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x010b }
            java.lang.String r14 = com.xjsd.ai.assistant.json.GsonUtils.e(r13)     // Catch:{ Exception -> 0x010b }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010b }
            r3.<init>()     // Catch:{ Exception -> 0x010b }
            java.lang.String r5 = "getToken body json->"
            r3.append(r5)     // Catch:{ Exception -> 0x010b }
            r3.append(r14)     // Catch:{ Exception -> 0x010b }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x010b }
            com.xjsd.ai.assistant.net.http.TokenGeneratorKt.a(r3, r1)     // Catch:{ Exception -> 0x010b }
            okhttp3.MediaType$Companion r3 = okhttp3.MediaType.Companion     // Catch:{ Exception -> 0x010b }
            okhttp3.MediaType r0 = r3.get(r0)     // Catch:{ Exception -> 0x010b }
            okhttp3.RequestBody r14 = r12.create((java.lang.String) r14, (okhttp3.MediaType) r0)     // Catch:{ Exception -> 0x010b }
            okhttp3.Request$Builder r0 = new okhttp3.Request$Builder     // Catch:{ Exception -> 0x010b }
            r0.<init>()     // Catch:{ Exception -> 0x010b }
            okhttp3.Request$Builder r0 = r0.url((java.lang.String) r4)     // Catch:{ Exception -> 0x010b }
            okhttp3.Request$Builder r0 = r0.headers(r2)     // Catch:{ Exception -> 0x010b }
            okhttp3.Request$Builder r14 = r0.post(r14)     // Catch:{ Exception -> 0x010b }
            okhttp3.Request r14 = r14.build()     // Catch:{ Exception -> 0x010b }
            goto L_0x0126
        L_0x010b:
            r14 = move-exception
            java.lang.String r14 = kotlin.ExceptionsKt.stackTraceToString(r14)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "拼装token request数据异常->"
            r0.append(r2)
            r0.append(r14)
            java.lang.String r14 = r0.toString()
            com.xjsd.ai.assistant.net.http.TokenGeneratorKt.a(r14, r1)
            r14 = 0
        L_0x0126:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.net.http.TokenGenerator.d():okhttp3.Request");
    }

    public final String e(Response response) {
        ResponseBody body = response.body();
        String str = null;
        String string = body != null ? body.string() : null;
        TokenGeneratorKt.a("获取token，response->" + string, "TokenGenerator");
        if (string == null) {
            string = "";
        }
        TokenResBody tokenResBody = (TokenResBody) GsonUtils.a(string, TokenResBody.class);
        TokenResBody.Data data = tokenResBody.getData();
        if (data != null) {
            str = data.getAccessToken();
        }
        if (!TextUtils.isEmpty(str)) {
            long currentTimeMillis = System.currentTimeMillis();
            TokenGeneratorKt.a("获取token->" + str + ", time->" + currentTimeMillis, "TokenGenerator");
            CacheAbility cacheAbility = (CacheAbility) AbilityManager.b.b(CacheAbility.class);
            if (cacheAbility != null) {
                cacheAbility.persist(ApiConstant.KEY_TOKEN, str);
            }
            TokenResBody.Data data2 = tokenResBody.getData();
            int exp = data2 != null ? data2.getExp() : 0;
            if (cacheAbility != null) {
                cacheAbility.persist("tokenExp", String.valueOf(currentTimeMillis + ((long) (exp * 1000))));
            }
        }
        return str == null ? "" : str;
    }

    public final String f(Map map, String str, String str2) {
        if (map.isEmpty()) {
            TokenGeneratorKt.a("tokenSign signMap is null!", "TokenGenerator");
            return "";
        }
        List<String> sorted = CollectionsKt.sorted(CollectionsKt.toList(map.keySet()));
        if (sorted.isEmpty()) {
            TokenGeneratorKt.a("tokenSign signList is null!", "TokenGenerator");
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String str3 : sorted) {
            int i2 = i + 1;
            if (i != 0) {
                sb.append("&");
                sb.append(str3);
                sb.append("=");
                sb.append((String) map.get(str3));
            } else {
                sb.append(str3);
                sb.append("=");
                sb.append((String) map.get(str3));
            }
            i = i2;
        }
        String str4 = str + sb + str2;
        char[] encodeHex = Hex.encodeHex(DigestUtils.md5(str4));
        Intrinsics.checkNotNullExpressionValue(encodeHex, "encodeHex(...)");
        String str5 = new String(encodeHex);
        TokenGeneratorKt.a("tokenSign signBody->" + str4 + ", sign->" + str5, "TokenGenerator");
        return str5;
    }
}
