package com.upuphone.xr.sapp.monitor.net;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.honey.account.constant.AccountConstantKt;
import com.meizu.common.util.LunarCalendar;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.monitor.net.GwTokenResBody;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.SortedMap;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0010%\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H@¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001b\u0010\u001aJ/\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u001e2\u0014\b\u0002\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u001c¢\u0006\u0004\b\u001f\u0010 J\u001b\u0010!\u001a\u00020\u00062\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b!\u0010\bJ\u0011\u0010\"\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\"\u0010#J\u0018\u0010$\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0006H@¢\u0006\u0004\b$\u0010\u0016J3\u0010(\u001a\u00020\u00062\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u001c2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u0006H\u0002¢\u0006\u0004\b(\u0010)R\u001d\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00060*8\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b+\u0010-¨\u0006/"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/net/TokenUtil;", "", "<init>", "()V", "Lcom/upuphone/xr/sapp/monitor/net/GwTokenResBody$GwTokenData;", "tokenData", "", "d", "(Lcom/upuphone/xr/sapp/monitor/net/GwTokenResBody$GwTokenData;)Ljava/lang/String;", "Lcom/upuphone/xr/sapp/monitor/net/GwTokenResBody;", "response", "", "n", "(Lcom/upuphone/xr/sapp/monitor/net/GwTokenResBody;)V", "i", "()Ljava/lang/String;", "Lcom/upuphone/xr/sapp/monitor/net/TokenResBody;", "o", "(Lcom/upuphone/xr/sapp/monitor/net/TokenResBody;)V", "mzToken", "", "m", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lokhttp3/Interceptor$Chain;", "chain", "j", "(Lokhttp3/Interceptor$Chain;)Ljava/lang/String;", "k", "", "queryMap", "", "g", "(Ljava/util/Map;)Ljava/util/Map;", "c", "f", "()Lcom/upuphone/xr/sapp/monitor/net/GwTokenResBody$GwTokenData;", "l", "signMap", "userKey", "userSecret", "p", "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "", "b", "Ljava/util/List;", "()Ljava/util/List;", "GW_HOST", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nTokenUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TokenUtil.kt\ncom/upuphone/xr/sapp/monitor/net/TokenUtil\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 HttpInstance.kt\ncom/upuphone/star/httplib/HttpInstance\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,356:1\n215#2,2:357\n125#2:360\n152#2,3:361\n125#2:365\n152#2,3:366\n208#3:359\n1#4:364\n*S KotlinDebug\n*F\n+ 1 TokenUtil.kt\ncom/upuphone/xr/sapp/monitor/net/TokenUtil\n*L\n149#1:357,2\n191#1:360\n191#1:361,3\n299#1:365\n299#1:366,3\n160#1:359\n*E\n"})
public final class TokenUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final TokenUtil f7744a = new TokenUtil();
    public static final List b = CollectionsKt.listOf("gw.myvu.cn", "gw-uat.myvu.cn", "gw-global-uat.myvu.cn", "gw-global.myvu.cn");

    public static /* synthetic */ String e(TokenUtil tokenUtil, GwTokenResBody.GwTokenData gwTokenData, int i, Object obj) {
        if ((i & 1) != 0) {
            gwTokenData = tokenUtil.f();
        }
        return tokenUtil.d(gwTokenData);
    }

    public static /* synthetic */ Map h(TokenUtil tokenUtil, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = MapsKt.emptyMap();
        }
        return tokenUtil.g(map);
    }

    public final List b() {
        return b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = r1.getRefreshToken();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String c(com.upuphone.xr.sapp.monitor.net.GwTokenResBody.GwTokenData r1) {
        /*
            r0 = this;
            if (r1 == 0) goto L_0x0008
            java.lang.String r0 = r1.getRefreshToken()
            if (r0 != 0) goto L_0x000a
        L_0x0008:
            java.lang.String r0 = ""
        L_0x000a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.monitor.net.TokenUtil.c(com.upuphone.xr.sapp.monitor.net.GwTokenResBody$GwTokenData):java.lang.String");
    }

    public final String d(GwTokenResBody.GwTokenData gwTokenData) {
        if ((gwTokenData != null ? gwTokenData.getAccessToken() : null) == null) {
            return "";
        }
        String lowerCase = gwTokenData.getTokenType().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (!Intrinsics.areEqual((Object) lowerCase, (Object) "bearer")) {
            return gwTokenData.getAccessToken();
        }
        String accessToken = gwTokenData.getAccessToken();
        return "Bearer " + accessToken;
    }

    public final GwTokenResBody.GwTokenData f() {
        String str = (String) DataStoreUtils.i(DataStoreUtils.e.a(), "gw_token", "", (Context) null, 4, (Object) null);
        try {
            return (GwTokenResBody.GwTokenData) new Gson().fromJson(str, GwTokenResBody.GwTokenData.class);
        } catch (JsonSyntaxException unused) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.c("TokenUtil", "parse account error  ... " + str);
            return null;
        }
    }

    public final Map g(Map map) {
        Intrinsics.checkNotNullParameter(map, "queryMap");
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        String substring = StringsKt.replace$default(uuid, LunarCalendar.DATE_SEPARATOR, "", false, 4, (Object) null).substring(0, 6);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        String valueOf = String.valueOf(System.currentTimeMillis());
        Pair pair = TuplesKt.to("ver", "v1");
        Pair pair2 = TuplesKt.to("alg", MessageDigestAlgorithms.MD5);
        HttpConfig httpConfig = HttpConfig.f7742a;
        Map mutableMapOf = MapsKt.mutableMapOf(pair, pair2, TuplesKt.to("ak", httpConfig.a()), TuplesKt.to("nonce", substring), TuplesKt.to("ts", valueOf));
        Map mutableMap = MapsKt.toMutableMap(mutableMapOf);
        mutableMap.putAll(map);
        mutableMapOf.put(AccountConstantKt.REQUEST_HEADER_SIGN, p(mutableMap, httpConfig.e(), httpConfig.e()));
        return mutableMapOf;
    }

    public final String i() {
        return (String) DataStoreUtils.i(DataStoreUtils.e.a(), "xj_token", "", (Context) null, 4, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0111 A[Catch:{ Exception -> 0x00e7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0119 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String j(okhttp3.Interceptor.Chain r15) {
        /*
            r14 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = "TokenUtil"
            java.lang.String r2 = "chain"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r2)
            com.upuphone.xr.sapp.config.NetConfig$Companion r2 = com.upuphone.xr.sapp.config.NetConfig.f6666a
            java.lang.String r3 = "sMyvuAuth"
            java.lang.String r3 = r2.v(r3)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            java.lang.String r3 = "/"
            r4.append(r3)
            java.lang.String r3 = "oauth/token"
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            com.upuphone.xr.sapp.monitor.net.GwTokenResBody$GwTokenData r4 = r14.f()
            java.lang.String r5 = r14.c(r4)
            java.lang.String r6 = "refresh_token"
            kotlin.Pair r5 = kotlin.TuplesKt.to(r6, r5)
            java.lang.String r7 = "grant_type"
            kotlin.Pair r6 = kotlin.TuplesKt.to(r7, r6)
            java.lang.String r7 = "client_id"
            java.lang.String r8 = r2.c()
            kotlin.Pair r7 = kotlin.TuplesKt.to(r7, r8)
            java.lang.String r8 = "client_secret"
            java.lang.String r2 = r2.t()
            kotlin.Pair r2 = kotlin.TuplesKt.to(r8, r2)
            kotlin.Pair[] r2 = new kotlin.Pair[]{r5, r6, r7, r2}
            java.util.HashMap r2 = kotlin.collections.MapsKt.hashMapOf(r2)
            java.util.ArrayList r5 = new java.util.ArrayList
            int r6 = r2.size()
            r5.<init>(r6)
            java.util.Set r2 = r2.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x0068:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto L_0x0098
            java.lang.Object r6 = r2.next()
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6
            java.lang.Object r7 = r6.getKey()
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r6 = r6.getValue()
            java.lang.String r6 = (java.lang.String) r6
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r7)
            java.lang.String r7 = "="
            r8.append(r7)
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            r5.add(r6)
            goto L_0x0068
        L_0x0098:
            r12 = 62
            r13 = 0
            java.lang.String r6 = "&"
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            java.lang.String r2 = kotlin.collections.CollectionsKt.joinToString$default(r5, r6, r7, r8, r9, r10, r11, r12, r13)
            okhttp3.Request$Builder r5 = new okhttp3.Request$Builder
            r5.<init>()
            okhttp3.Request$Builder r3 = r5.url((java.lang.String) r3)
            java.lang.String r5 = "Authorization"
            java.lang.String r4 = r14.d(r4)
            okhttp3.Request$Builder r3 = r3.header(r5, r4)
            okhttp3.RequestBody$Companion r4 = okhttp3.RequestBody.Companion
            okhttp3.MediaType$Companion r5 = okhttp3.MediaType.Companion
            java.lang.String r6 = "application/x-www-form-urlencoded; charset=utf-8"
            okhttp3.MediaType r5 = r5.get(r6)
            okhttp3.RequestBody r2 = r4.create((java.lang.String) r2, (okhttp3.MediaType) r5)
            okhttp3.Request$Builder r2 = r3.post(r2)
            okhttp3.Request r2 = r2.build()
            com.upuphone.star.core.log.ULog$Delegate r3 = com.upuphone.star.core.log.ULog.f6446a     // Catch:{ Exception -> 0x00e7 }
            java.lang.String r4 = "refreshGwToken->"
            r3.g(r1, r4)     // Catch:{ Exception -> 0x00e7 }
            okhttp3.Response r15 = r15.proceed(r2)     // Catch:{ Exception -> 0x00e7 }
            okhttp3.ResponseBody r15 = r15.body()     // Catch:{ Exception -> 0x00e7 }
            if (r15 == 0) goto L_0x00e9
            java.lang.String r15 = r15.string()     // Catch:{ Exception -> 0x00e7 }
            if (r15 != 0) goto L_0x00ea
            goto L_0x00e9
        L_0x00e7:
            r14 = move-exception
            goto L_0x011a
        L_0x00e9:
            r15 = r0
        L_0x00ea:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e7 }
            r2.<init>()     // Catch:{ Exception -> 0x00e7 }
            java.lang.String r4 = "refreshGwToken 获取token，response--"
            r2.append(r4)     // Catch:{ Exception -> 0x00e7 }
            r2.append(r15)     // Catch:{ Exception -> 0x00e7 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00e7 }
            r3.g(r1, r2)     // Catch:{ Exception -> 0x00e7 }
            com.google.gson.Gson r2 = new com.google.gson.Gson     // Catch:{ Exception -> 0x00e7 }
            r2.<init>()     // Catch:{ Exception -> 0x00e7 }
            java.lang.Class<com.upuphone.xr.sapp.monitor.net.GwTokenResBody> r3 = com.upuphone.xr.sapp.monitor.net.GwTokenResBody.class
            java.lang.Object r15 = r2.fromJson((java.lang.String) r15, r3)     // Catch:{ Exception -> 0x00e7 }
            com.upuphone.xr.sapp.monitor.net.GwTokenResBody r15 = (com.upuphone.xr.sapp.monitor.net.GwTokenResBody) r15     // Catch:{ Exception -> 0x00e7 }
            com.upuphone.xr.sapp.monitor.net.GwTokenResBody$GwTokenData r2 = r15.getData()     // Catch:{ Exception -> 0x00e7 }
            if (r2 == 0) goto L_0x0119
            r14.n(r15)     // Catch:{ Exception -> 0x00e7 }
            java.lang.String r14 = r14.d(r2)     // Catch:{ Exception -> 0x00e7 }
            return r14
        L_0x0119:
            return r0
        L_0x011a:
            com.upuphone.star.core.log.ULog$Delegate r15 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "refreshGwToken-> "
            r2.append(r3)
            r2.append(r14)
            java.lang.String r14 = r2.toString()
            r15.c(r1, r14)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.monitor.net.TokenUtil.j(okhttp3.Interceptor$Chain):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x010a A[Catch:{ Exception -> 0x00e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0112 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String k(okhttp3.Interceptor.Chain r14) {
        /*
            r13 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = "TokenUtil"
            java.lang.String r2 = "chain"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r2)
            com.upuphone.xr.sapp.monitor.net.HttpConfig r2 = com.upuphone.xr.sapp.monitor.net.HttpConfig.f7742a
            java.lang.String r3 = r2.c()
            java.lang.String r4 = r2.f()
            java.lang.String r5 = r2.b()
            java.lang.String r2 = r2.g()
            com.upuphone.xr.sapp.utils.DataStoreUtils$Companion r6 = com.upuphone.xr.sapp.utils.DataStoreUtils.e
            com.upuphone.xr.sapp.utils.DataStoreUtils r7 = r6.a()
            r11 = 4
            r12 = 0
            java.lang.String r8 = "device_id"
            java.lang.String r9 = "test111"
            r10 = 0
            java.lang.Object r6 = com.upuphone.xr.sapp.utils.DataStoreUtils.i(r7, r8, r9, r10, r11, r12)
            java.lang.String r6 = (java.lang.String) r6
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r3)
            java.lang.String r3 = "/"
            r7.append(r3)
            java.lang.String r3 = "token/get"
            r7.append(r3)
            java.lang.String r3 = r7.toString()
            okhttp3.Headers$Builder r7 = new okhttp3.Headers$Builder
            r7.<init>()
            java.lang.String r8 = "Content-Type"
            java.lang.String r9 = "application/json; charset=utf-8"
            okhttp3.Headers$Builder r7 = r7.add((java.lang.String) r8, (java.lang.String) r9)
            java.lang.String r8 = "WR-Client-Id"
            okhttp3.Headers$Builder r6 = r7.add((java.lang.String) r8, (java.lang.String) r6)
            java.lang.String r7 = "WR-ukey"
            okhttp3.Headers$Builder r6 = r6.add((java.lang.String) r7, (java.lang.String) r4)
            okhttp3.Headers r6 = r6.build()
            long r7 = java.lang.System.currentTimeMillis()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.lang.String r8 = "appid"
            kotlin.Pair r5 = kotlin.TuplesKt.to(r8, r5)
            java.lang.String r8 = "ukey"
            kotlin.Pair r8 = kotlin.TuplesKt.to(r8, r4)
            java.lang.String r10 = "authType"
            java.lang.String r11 = "3"
            kotlin.Pair r10 = kotlin.TuplesKt.to(r10, r11)
            java.lang.String r11 = "time"
            kotlin.Pair r7 = kotlin.TuplesKt.to(r11, r7)
            kotlin.Pair[] r5 = new kotlin.Pair[]{r5, r8, r10, r7}
            java.util.HashMap r5 = kotlin.collections.MapsKt.hashMapOf(r5)
            java.lang.String r2 = r13.p(r5, r4, r2)
            java.lang.String r4 = "sign"
            r5.put(r4, r2)
            okhttp3.Request$Builder r2 = new okhttp3.Request$Builder
            r2.<init>()
            okhttp3.Request$Builder r2 = r2.url((java.lang.String) r3)
            okhttp3.Request$Builder r2 = r2.headers(r6)
            okhttp3.RequestBody$Companion r3 = okhttp3.RequestBody.Companion
            com.google.gson.Gson r4 = new com.google.gson.Gson
            r4.<init>()
            java.lang.String r4 = r4.toJson((java.lang.Object) r5)
            java.lang.String r5 = "toJson(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            okhttp3.MediaType$Companion r5 = okhttp3.MediaType.Companion
            okhttp3.MediaType r5 = r5.get(r9)
            okhttp3.RequestBody r3 = r3.create((java.lang.String) r4, (okhttp3.MediaType) r5)
            okhttp3.Request$Builder r2 = r2.post(r3)
            okhttp3.Request r2 = r2.build()
            com.upuphone.star.core.log.ULog$Delegate r3 = com.upuphone.star.core.log.ULog.f6446a     // Catch:{ Exception -> 0x00e0 }
            java.lang.String r4 = "refreshXjToken->"
            r3.g(r1, r4)     // Catch:{ Exception -> 0x00e0 }
            okhttp3.Response r14 = r14.proceed(r2)     // Catch:{ Exception -> 0x00e0 }
            okhttp3.ResponseBody r14 = r14.body()     // Catch:{ Exception -> 0x00e0 }
            if (r14 == 0) goto L_0x00e2
            java.lang.String r14 = r14.string()     // Catch:{ Exception -> 0x00e0 }
            if (r14 != 0) goto L_0x00e3
            goto L_0x00e2
        L_0x00e0:
            r13 = move-exception
            goto L_0x0113
        L_0x00e2:
            r14 = r0
        L_0x00e3:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e0 }
            r2.<init>()     // Catch:{ Exception -> 0x00e0 }
            java.lang.String r4 = "refreshXjToken 获取token，response--"
            r2.append(r4)     // Catch:{ Exception -> 0x00e0 }
            r2.append(r14)     // Catch:{ Exception -> 0x00e0 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00e0 }
            r3.g(r1, r2)     // Catch:{ Exception -> 0x00e0 }
            com.google.gson.Gson r2 = new com.google.gson.Gson     // Catch:{ Exception -> 0x00e0 }
            r2.<init>()     // Catch:{ Exception -> 0x00e0 }
            java.lang.Class<com.upuphone.xr.sapp.monitor.net.TokenResBody> r3 = com.upuphone.xr.sapp.monitor.net.TokenResBody.class
            java.lang.Object r14 = r2.fromJson((java.lang.String) r14, r3)     // Catch:{ Exception -> 0x00e0 }
            com.upuphone.xr.sapp.monitor.net.TokenResBody r14 = (com.upuphone.xr.sapp.monitor.net.TokenResBody) r14     // Catch:{ Exception -> 0x00e0 }
            com.upuphone.xr.sapp.monitor.net.TokenResBody$Data r2 = r14.getData()     // Catch:{ Exception -> 0x00e0 }
            if (r2 == 0) goto L_0x0112
            r13.o(r14)     // Catch:{ Exception -> 0x00e0 }
            java.lang.String r13 = r2.getAccessToken()     // Catch:{ Exception -> 0x00e0 }
            return r13
        L_0x0112:
            return r0
        L_0x0113:
            com.upuphone.star.core.log.ULog$Delegate r14 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "refreshXjToken-> "
            r2.append(r3)
            r2.append(r13)
            java.lang.String r13 = r2.toString()
            r14.c(r1, r13)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.monitor.net.TokenUtil.k(okhttp3.Interceptor$Chain):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0157 A[Catch:{ Exception -> 0x0034 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object l(java.lang.String r12, kotlin.coroutines.Continuation r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof com.upuphone.xr.sapp.monitor.net.TokenUtil$requestGwToken$1
            if (r0 == 0) goto L_0x0013
            r0 = r13
            com.upuphone.xr.sapp.monitor.net.TokenUtil$requestGwToken$1 r0 = (com.upuphone.xr.sapp.monitor.net.TokenUtil$requestGwToken$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.monitor.net.TokenUtil$requestGwToken$1 r0 = new com.upuphone.xr.sapp.monitor.net.TokenUtil$requestGwToken$1
            r0.<init>(r11, r13)
        L_0x0018:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = "requestGwToken-> "
            r4 = 0
            java.lang.String r5 = "TokenUtil"
            r6 = 0
            r7 = 1
            if (r2 == 0) goto L_0x003f
            if (r2 != r7) goto L_0x0037
            java.lang.Object r11 = r0.L$0
            com.upuphone.xr.sapp.monitor.net.TokenUtil r11 = (com.upuphone.xr.sapp.monitor.net.TokenUtil) r11
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ Exception -> 0x0034 }
            goto L_0x0129
        L_0x0034:
            r11 = move-exception
            goto L_0x0186
        L_0x0037:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x003f:
            kotlin.ResultKt.throwOnFailure(r13)
            com.upuphone.xr.sapp.config.NetConfig$Companion r13 = com.upuphone.xr.sapp.config.NetConfig.f6666a
            java.lang.String r2 = "sMyvuAuth"
            java.lang.String r2 = r13.v(r2)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r2)
            java.lang.String r2 = "/"
            r8.append(r2)
            java.lang.String r2 = "api/v2/oauth/user/login/flyme/token"
            r8.append(r2)
            java.lang.String r2 = r8.toString()
            java.lang.String r8 = "accessToken"
            kotlin.Pair r8 = kotlin.TuplesKt.to(r8, r12)
            java.lang.String r9 = "autocrt"
            java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            kotlin.Pair r9 = kotlin.TuplesKt.to(r9, r10)
            java.lang.String r10 = "clientId"
            java.lang.String r13 = r13.c()
            kotlin.Pair r13 = kotlin.TuplesKt.to(r10, r13)
            kotlin.Pair[] r13 = new kotlin.Pair[]{r8, r9, r13}
            java.util.HashMap r13 = kotlin.collections.MapsKt.hashMapOf(r13)
            java.util.Map r8 = h(r11, r6, r7, r6)
            okhttp3.HttpUrl$Companion r9 = okhttp3.HttpUrl.Companion
            okhttp3.HttpUrl r2 = r9.parse(r2)
            if (r2 == 0) goto L_0x019f
            okhttp3.HttpUrl$Builder r2 = r2.newBuilder()
            if (r2 != 0) goto L_0x0096
            goto L_0x019f
        L_0x0096:
            java.util.Set r8 = r8.entrySet()
            java.util.Iterator r8 = r8.iterator()
        L_0x009e:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x00ba
            java.lang.Object r9 = r8.next()
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9
            java.lang.Object r10 = r9.getKey()
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r9 = r9.getValue()
            java.lang.String r9 = (java.lang.String) r9
            r2.addQueryParameter(r10, r9)
            goto L_0x009e
        L_0x00ba:
            okhttp3.Request$Builder r8 = new okhttp3.Request$Builder
            r8.<init>()
            okhttp3.HttpUrl r2 = r2.build()
            okhttp3.Request$Builder r2 = r8.url((okhttp3.HttpUrl) r2)
            okhttp3.RequestBody$Companion r8 = okhttp3.RequestBody.Companion
            com.google.gson.Gson r9 = new com.google.gson.Gson
            r9.<init>()
            java.lang.String r13 = r9.toJson((java.lang.Object) r13)
            java.lang.String r9 = "toJson(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r9)
            okhttp3.MediaType$Companion r9 = okhttp3.MediaType.Companion
            java.lang.String r10 = "application/json; charset=utf-8"
            okhttp3.MediaType r9 = r9.get(r10)
            okhttp3.RequestBody r13 = r8.create((java.lang.String) r13, (okhttp3.MediaType) r9)
            okhttp3.Request$Builder r13 = r2.post(r13)
            okhttp3.Request r13 = r13.build()
            com.upuphone.star.core.log.ULog$Delegate r2 = com.upuphone.star.core.log.ULog.f6446a     // Catch:{ Exception -> 0x0034 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0034 }
            r8.<init>()     // Catch:{ Exception -> 0x0034 }
            java.lang.String r9 = "requestGwToken-> mzToken: "
            r8.append(r9)     // Catch:{ Exception -> 0x0034 }
            r8.append(r12)     // Catch:{ Exception -> 0x0034 }
            java.lang.String r12 = r8.toString()     // Catch:{ Exception -> 0x0034 }
            r2.g(r5, r12)     // Catch:{ Exception -> 0x0034 }
            com.upuphone.star.httplib.HttpInstance r12 = new com.upuphone.star.httplib.HttpInstance     // Catch:{ Exception -> 0x0034 }
            com.upuphone.star.httplib.HttpUtils r2 = com.upuphone.star.httplib.HttpUtils.f6479a     // Catch:{ Exception -> 0x0034 }
            com.upuphone.xr.sapp.monitor.net.TokenUtil$requestGwToken$http$1 r8 = com.upuphone.xr.sapp.monitor.net.TokenUtil$requestGwToken$http$1.INSTANCE     // Catch:{ Exception -> 0x0034 }
            okhttp3.OkHttpClient r2 = r2.j(r8)     // Catch:{ Exception -> 0x0034 }
            r8 = 2
            r12.<init>(r2, r6, r8, r6)     // Catch:{ Exception -> 0x0034 }
            com.upuphone.xr.sapp.monitor.net.TokenUtil$requestGwToken$$inlined$request$1 r2 = new com.upuphone.xr.sapp.monitor.net.TokenUtil$requestGwToken$$inlined$request$1     // Catch:{ Exception -> 0x0034 }
            r2.<init>()     // Catch:{ Exception -> 0x0034 }
            java.lang.reflect.Type r2 = r2.getType()     // Catch:{ Exception -> 0x0034 }
            java.lang.String r8 = "object : TypeToken<T>() {}.type"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r8)     // Catch:{ Exception -> 0x0034 }
            r0.L$0 = r11     // Catch:{ Exception -> 0x0034 }
            r0.label = r7     // Catch:{ Exception -> 0x0034 }
            java.lang.Object r13 = r12.h(r13, r2, r0)     // Catch:{ Exception -> 0x0034 }
            if (r13 != r1) goto L_0x0129
            return r1
        L_0x0129:
            com.upuphone.star.httplib.HttpResult r13 = (com.upuphone.star.httplib.HttpResult) r13     // Catch:{ Exception -> 0x0034 }
            com.upuphone.star.core.log.ULog$Delegate r12 = com.upuphone.star.core.log.ULog.f6446a     // Catch:{ Exception -> 0x0034 }
            java.lang.Object r0 = r13.b()     // Catch:{ Exception -> 0x0034 }
            java.lang.String r1 = com.xjsd.xr.sapp.asr.utils.GsonHelper.toJson(r13)     // Catch:{ Exception -> 0x0034 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0034 }
            r2.<init>()     // Catch:{ Exception -> 0x0034 }
            r2.append(r3)     // Catch:{ Exception -> 0x0034 }
            r2.append(r0)     // Catch:{ Exception -> 0x0034 }
            java.lang.String r0 = " response:"
            r2.append(r0)     // Catch:{ Exception -> 0x0034 }
            r2.append(r1)     // Catch:{ Exception -> 0x0034 }
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x0034 }
            r12.g(r5, r0)     // Catch:{ Exception -> 0x0034 }
            java.lang.Object r12 = r13.b()     // Catch:{ Exception -> 0x0034 }
            com.upuphone.xr.sapp.monitor.net.GwTokenResBody r12 = (com.upuphone.xr.sapp.monitor.net.GwTokenResBody) r12     // Catch:{ Exception -> 0x0034 }
            if (r12 == 0) goto L_0x015b
            com.upuphone.xr.sapp.monitor.net.GwTokenResBody$GwTokenData r6 = r12.getData()     // Catch:{ Exception -> 0x0034 }
        L_0x015b:
            boolean r12 = r13.e()     // Catch:{ Exception -> 0x0034 }
            if (r12 == 0) goto L_0x0181
            java.lang.Object r12 = r13.b()     // Catch:{ Exception -> 0x0034 }
            com.upuphone.xr.sapp.monitor.net.GwTokenResBody r12 = (com.upuphone.xr.sapp.monitor.net.GwTokenResBody) r12     // Catch:{ Exception -> 0x0034 }
            if (r12 == 0) goto L_0x0181
            int r12 = r12.getStatus()     // Catch:{ Exception -> 0x0034 }
            r0 = 200(0xc8, float:2.8E-43)
            if (r12 != r0) goto L_0x0181
            if (r6 == 0) goto L_0x0181
            java.lang.Object r12 = r13.b()     // Catch:{ Exception -> 0x0034 }
            com.upuphone.xr.sapp.monitor.net.GwTokenResBody r12 = (com.upuphone.xr.sapp.monitor.net.GwTokenResBody) r12     // Catch:{ Exception -> 0x0034 }
            r11.n(r12)     // Catch:{ Exception -> 0x0034 }
            java.lang.Boolean r11 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)     // Catch:{ Exception -> 0x0034 }
            return r11
        L_0x0181:
            java.lang.Boolean r11 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)     // Catch:{ Exception -> 0x0034 }
            return r11
        L_0x0186:
            com.upuphone.star.core.log.ULog$Delegate r12 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r3)
            r13.append(r11)
            java.lang.String r11 = r13.toString()
            r12.c(r5, r11)
            java.lang.Boolean r11 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r11
        L_0x019f:
            java.lang.Boolean r11 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.monitor.net.TokenUtil.l(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object m(String str, Continuation continuation) {
        return BuildersKt.g(Dispatchers.b(), new TokenUtil$requestNewGwToken$2(str, (Continuation<? super TokenUtil$requestNewGwToken$2>) null), continuation);
    }

    public final void n(GwTokenResBody gwTokenResBody) {
        String str;
        if (gwTokenResBody == null) {
            str = "";
        } else {
            GwTokenResBody.GwTokenData data = gwTokenResBody.getData();
            if (data != null) {
                Long tstamp = gwTokenResBody.getTstamp();
                data.setTstamp(tstamp != null ? tstamp.longValue() : System.currentTimeMillis());
            }
            str = new Gson().toJson((Object) gwTokenResBody.getData());
        }
        DataStoreUtils.e.a().o("gw_token", str);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("TokenUtil", "saveGwToken-> " + str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r8 = r9.getData();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void o(com.upuphone.xr.sapp.monitor.net.TokenResBody r9) {
        /*
            r8 = this;
            if (r9 == 0) goto L_0x000d
            com.upuphone.xr.sapp.monitor.net.TokenResBody$Data r8 = r9.getData()
            if (r8 == 0) goto L_0x000d
            java.lang.String r8 = r8.getAccessToken()
            goto L_0x000e
        L_0x000d:
            r8 = 0
        L_0x000e:
            java.lang.String r0 = "xj_token_expire"
            java.lang.String r1 = "xj_token"
            if (r8 == 0) goto L_0x0077
            int r2 = r8.length()
            if (r2 != 0) goto L_0x001d
            goto L_0x0077
        L_0x001d:
            long r2 = java.lang.System.currentTimeMillis()
            com.upuphone.xr.sapp.monitor.net.TokenResBody$Data r9 = r9.getData()
            int r9 = r9.getExp()
            com.upuphone.star.core.log.ULog$Delegate r4 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "saveXjTokenData--"
            r5.append(r6)
            r5.append(r8)
            java.lang.String r6 = ", time--"
            r5.append(r6)
            r5.append(r2)
            java.lang.String r5 = r5.toString()
            java.lang.String r6 = "TokenUtil"
            r4.g(r6, r5)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = "saveXjTokenData--exp: "
            r5.append(r7)
            r5.append(r9)
            java.lang.String r5 = r5.toString()
            r4.g(r6, r5)
            com.upuphone.xr.sapp.utils.DataStoreUtils$Companion r4 = com.upuphone.xr.sapp.utils.DataStoreUtils.e
            com.upuphone.xr.sapp.utils.DataStoreUtils r5 = r4.a()
            r5.o(r1, r8)
            com.upuphone.xr.sapp.utils.DataStoreUtils r8 = r4.a()
            long r4 = (long) r9
            r6 = 1000(0x3e8, double:4.94E-321)
            long r4 = r4 * r6
            long r4 = r4 + r2
            java.lang.Long r9 = java.lang.Long.valueOf(r4)
            r8.o(r0, r9)
            goto L_0x008e
        L_0x0077:
            com.upuphone.xr.sapp.utils.DataStoreUtils$Companion r8 = com.upuphone.xr.sapp.utils.DataStoreUtils.e
            com.upuphone.xr.sapp.utils.DataStoreUtils r9 = r8.a()
            java.lang.String r2 = ""
            r9.o(r1, r2)
            com.upuphone.xr.sapp.utils.DataStoreUtils r8 = r8.a()
            r9 = 0
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r8.o(r0, r9)
        L_0x008e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.monitor.net.TokenUtil.o(com.upuphone.xr.sapp.monitor.net.TokenResBody):void");
    }

    public final String p(Map map, String str, String str2) {
        if (map.isEmpty()) {
            ULog.f6446a.g("TokenUtil", "tokenSign signMap is null!");
            return "";
        }
        SortedMap sortedMap = MapsKt.toSortedMap(map);
        ArrayList arrayList = new ArrayList(sortedMap.size());
        for (Map.Entry entry : sortedMap.entrySet()) {
            arrayList.add(((String) entry.getKey()) + "=" + ((String) entry.getValue()));
        }
        String str3 = str + CollectionsKt.joinToString$default(arrayList, "&", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) + str2;
        char[] encodeHex = Hex.encodeHex(DigestUtils.md5(str3));
        Intrinsics.checkNotNullExpressionValue(encodeHex, "encodeHex(...)");
        String str4 = new String(encodeHex);
        ULog.f6446a.g("TokenUtil", "tokenSign signBody--" + str3 + ", sign--" + str4);
        return str4;
    }
}
