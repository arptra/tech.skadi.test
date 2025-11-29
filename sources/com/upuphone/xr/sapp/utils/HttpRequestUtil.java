package com.upuphone.xr.sapp.utils;

import android.content.Context;
import android.os.Build;
import com.flyme.xjfms.ums.sign.jdk.dto.SignDTO;
import com.flyme.xjfms.ums.sign.jdk.service.SignServiceImpl;
import com.google.gson.Gson;
import com.honey.account.constant.AccountConstantKt;
import com.upuphone.datatrack.base.utils.XJPackageUtil;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.config.NetConfig;
import com.upuphone.xr.sapp.contract.ContractEntry;
import com.upuphone.xr.sapp.contract.ProtocolType;
import com.upuphone.xr.sapp.contract.RegionsEntry;
import com.upuphone.xr.sapp.entity.DeviceInfo;
import com.upuphone.xr.sapp.entity.PolicyInfo;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.xjsd.ai.assistant.encrypt.DigestUtils;
import io.netty.handler.codec.http.HttpHeaders;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u0015\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\r¢\u0006\u0004\b\u001b\u0010\u0003J\r\u0010\u001c\u001a\u00020\r¢\u0006\u0004\b\u001c\u0010\u0003J\r\u0010\u001d\u001a\u00020\r¢\u0006\u0004\b\u001d\u0010\u0003J\u0018\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u0006H@¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\rH@¢\u0006\u0004\b!\u0010\"J\u0018\u0010#\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u0006H@¢\u0006\u0004\b#\u0010 J\u0015\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0006¢\u0006\u0004\b%\u0010\u001aJ\u001d\u0010'\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b'\u0010(J%\u0010*\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b*\u0010\u000fJ;\u0010.\u001a\u00020\r2\u0006\u0010+\u001a\u00020\u00062\b\u0010&\u001a\u0004\u0018\u00010\u00062\u0006\u0010,\u001a\u00020\u00062\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b.\u0010/J/\u00101\u001a\u00020\r2\u0006\u0010+\u001a\u00020\u00062\b\u0010&\u001a\u0004\u0018\u00010\u00062\u0006\u00100\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b1\u00102J/\u00105\u001a\u00020\r2\u0006\u0010+\u001a\u00020\u00062\b\u00103\u001a\u0004\u0018\u00010\u00062\u0006\u00104\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b5\u00102J\r\u00106\u001a\u00020\u0006¢\u0006\u0004\b6\u00107R\u001b\u0010<\u001a\u0002088BX\u0002¢\u0006\f\n\u0004\b\u001c\u00109\u001a\u0004\b:\u0010;R\u001b\u0010>\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\u001d\u00109\u001a\u0004\b=\u00107R\u001b\u0010@\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\u0007\u00109\u001a\u0004\b?\u00107R\u001b\u0010B\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\u0016\u00109\u001a\u0004\bA\u00107R\u001b\u0010D\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b:\u00109\u001a\u0004\bC\u00107R\u001b\u0010G\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\bE\u00109\u001a\u0004\bF\u00107R\u001b\u0010I\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b6\u00109\u001a\u0004\bH\u00107R\u001b\u0010K\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\u0019\u00109\u001a\u0004\bJ\u00107R\u001b\u0010L\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\bH\u00109\u001a\u0004\bE\u00107¨\u0006M"}, d2 = {"Lcom/upuphone/xr/sapp/utils/HttpRequestUtil;", "", "<init>", "()V", "", "reqTime", "", "d", "(J)Ljava/lang/String;", "url", "bodyRaw", "Lokhttp3/Callback;", "callback", "", "r", "(Ljava/lang/String;Ljava/lang/String;Lokhttp3/Callback;)V", "Lcom/upuphone/xr/sapp/contract/ProtocolType;", "protocolType", "appId", "signId", "x", "(Lcom/upuphone/xr/sapp/contract/ProtocolType;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "e", "(JLjava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "language", "i", "(Ljava/lang/String;)Ljava/lang/String;", "k", "b", "c", "agree", "t", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "u", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "v", "deviceID", "q", "xjAccountId", "w", "(Ljava/lang/String;Lokhttp3/Callback;)V", "state", "y", "policyId", "deviceType", "cacheSn", "s", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lokhttp3/Callback;)V", "agreeTime", "z", "(Ljava/lang/String;Ljava/lang/String;JLokhttp3/Callback;)V", "country", "cancelTime", "a", "h", "()Ljava/lang/String;", "Lokhttp3/OkHttpClient;", "Lkotlin/Lazy;", "f", "()Lokhttp3/OkHttpClient;", "client", "m", "REPORT_RECORD_URL", "n", "REQUEST_AI_HOST_RELEASE", "o", "SUBMIT_AI_HOST_RELEASE", "l", "QUERY_EXPIRE_HOSE", "g", "p", "SUBMIT_EXPIRE_HOSE", "j", "PRIVACY_CANCEL_URL", "getUPGRADE_PROTOCOL_URL", "UPGRADE_PROTOCOL_URL", "GET_POLICY_URL", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nHttpRequestUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HttpRequestUtil.kt\ncom/upuphone/xr/sapp/utils/HttpRequestUtil\n+ 2 HttpUtils.kt\ncom/upuphone/star/httplib/HttpUtils\n*L\n1#1,430:1\n253#2:431\n*S KotlinDebug\n*F\n+ 1 HttpRequestUtil.kt\ncom/upuphone/xr/sapp/utils/HttpRequestUtil\n*L\n349#1:431\n*E\n"})
public final class HttpRequestUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final HttpRequestUtil f7890a = new HttpRequestUtil();
    public static final Lazy b = LazyKt.lazy(HttpRequestUtil$client$2.INSTANCE);
    public static final Lazy c = LazyKt.lazy(HttpRequestUtil$REPORT_RECORD_URL$2.INSTANCE);
    public static final Lazy d = LazyKt.lazy(HttpRequestUtil$REQUEST_AI_HOST_RELEASE$2.INSTANCE);
    public static final Lazy e = LazyKt.lazy(HttpRequestUtil$SUBMIT_AI_HOST_RELEASE$2.INSTANCE);
    public static final Lazy f = LazyKt.lazy(HttpRequestUtil$QUERY_EXPIRE_HOSE$2.INSTANCE);
    public static final Lazy g = LazyKt.lazy(HttpRequestUtil$SUBMIT_EXPIRE_HOSE$2.INSTANCE);
    public static final Lazy h = LazyKt.lazy(HttpRequestUtil$PRIVACY_CANCEL_URL$2.INSTANCE);
    public static final Lazy i = LazyKt.lazy(HttpRequestUtil$UPGRADE_PROTOCOL_URL$2.INSTANCE);
    public static final Lazy j = LazyKt.lazy(HttpRequestUtil$GET_POLICY_URL$2.INSTANCE);

    public final void a(String str, String str2, long j2, Callback callback) {
        Intrinsics.checkNotNullParameter(str, "policyId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("HttpRequestUtil", "cancelPrivacy: policyId is->" + str + ", country->" + str2);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("uuid", AppUtils.f7842a.e());
        jSONObject.put("policyId", str);
        jSONObject.put("appId", NetConfig.f6666a.e());
        jSONObject.put("cancelTime", j2);
        jSONObject.put("deviceType", DynamicAdapterUtils.f7879a.a());
        jSONObject.put("country", str2);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
        r(j(), jSONObject2, callback);
    }

    public final void b() {
        DataStoreUtils.Companion companion = DataStoreUtils.e;
        companion.a().o(ProtocolType.CATEGORY_UP.getStoreKey(), "");
        companion.a().o(ProtocolType.CATEGORY_PP.getStoreKey(), "");
        companion.a().o(ProtocolType.GLASS_AIR_UP.getStoreKey(), "");
        companion.a().o(ProtocolType.GLASS_AIR_PP.getStoreKey(), "");
    }

    public final void c() {
        DataStoreUtils.Companion companion = DataStoreUtils.e;
        companion.a().o(ProtocolType.CATEGORY_UP.getStoreKey(), "");
        companion.a().o(ProtocolType.CATEGORY_PP.getStoreKey(), "");
        companion.a().o(ProtocolType.CATEGORY_AIUP.getStoreKey(), "");
    }

    public final String d(long j2) {
        NetConfig.Companion companion = NetConfig.f6666a;
        String a2 = new SignServiceImpl().a(new SignDTO(companion.e(), companion.h(), Long.valueOf(j2)));
        Intrinsics.checkNotNullExpressionValue(a2, "getSign(...)");
        return a2;
    }

    public final String e(long j2, String str, String str2) {
        String a2 = new SignServiceImpl().a(new SignDTO(str, str2, Long.valueOf(j2)));
        Intrinsics.checkNotNullExpressionValue(a2, "getSign(...)");
        return a2;
    }

    public final OkHttpClient f() {
        return (OkHttpClient) b.getValue();
    }

    public final String g() {
        return (String) j.getValue();
    }

    public final String h() {
        Locale locale = GlobalExtKt.f().getResources().getConfiguration().locale;
        String language = locale.getLanguage();
        String str = language + AccountConstantKt.DEFAULT_SEGMENT + locale.getCountry();
        ContractEntry contractEntry = ContractEntry.f6691a;
        if (contractEntry.m()) {
            return contractEntry.h();
        }
        boolean z = true;
        if (!(Intrinsics.areEqual((Object) str, (Object) RegionsEntry.RegionsZH.ZH_CN.value()) ? true : Intrinsics.areEqual((Object) str, (Object) RegionsEntry.RegionsZH.ZH_HK.value()) ? true : Intrinsics.areEqual((Object) str, (Object) RegionsEntry.RegionsZH.ZH_TW.value()) ? true : Intrinsics.areEqual((Object) str, (Object) RegionsEntry.RegionsOS.MS_MY.value()) ? true : Intrinsics.areEqual((Object) str, (Object) RegionsEntry.RegionsOS.VI_VN.value()) ? true : Intrinsics.areEqual((Object) str, (Object) RegionsEntry.RegionsOS.MY_MM.value()) ? true : Intrinsics.areEqual((Object) str, (Object) RegionsEntry.RegionsSA.FIL_PH.value()))) {
            z = Intrinsics.areEqual((Object) str, (Object) RegionsEntry.RegionsSA.TH_TH.value());
        }
        if (z) {
            return str;
        }
        if (Intrinsics.areEqual((Object) str, (Object) RegionsEntry.RegionsSA.IN_ID.getRegion())) {
            return RegionsEntry.RegionsSA.ID_ID.value();
        }
        Intrinsics.checkNotNull(language);
        return i(language);
    }

    public final String i(String str) {
        RegionsEntry.RegionsZH regionsZH = RegionsEntry.RegionsZH.ZH_CN;
        if (Intrinsics.areEqual((Object) str, (Object) regionsZH.getLanguage())) {
            return regionsZH.value();
        }
        RegionsEntry.RegionsOS regionsOS = RegionsEntry.RegionsOS.MS_MY;
        if (Intrinsics.areEqual((Object) str, (Object) regionsOS.getLanguage())) {
            return regionsOS.value();
        }
        RegionsEntry.RegionsOS regionsOS2 = RegionsEntry.RegionsOS.EN_US;
        if (Intrinsics.areEqual((Object) str, (Object) regionsOS2.getLanguage())) {
            return regionsOS2.value();
        }
        RegionsEntry.RegionsOS regionsOS3 = RegionsEntry.RegionsOS.MY_MM;
        if (Intrinsics.areEqual((Object) str, (Object) regionsOS3.getLanguage())) {
            return regionsOS3.value();
        }
        RegionsEntry.RegionsOS regionsOS4 = RegionsEntry.RegionsOS.VI_VN;
        if (Intrinsics.areEqual((Object) str, (Object) regionsOS4.getLanguage())) {
            return regionsOS4.value();
        }
        RegionsEntry.RegionsSA regionsSA = RegionsEntry.RegionsSA.TH_TH;
        if (Intrinsics.areEqual((Object) str, (Object) regionsSA.getLanguage())) {
            return regionsSA.value();
        }
        RegionsEntry.RegionsSA regionsSA2 = RegionsEntry.RegionsSA.FIL_PH;
        return Intrinsics.areEqual((Object) str, (Object) regionsSA2.getLanguage()) ? regionsSA2.value() : Intrinsics.areEqual((Object) str, (Object) RegionsEntry.RegionsSA.IN_ID.getLanguage()) ? RegionsEntry.RegionsSA.ID_ID.value() : regionsOS2.value();
    }

    public final String j() {
        return (String) h.getValue();
    }

    public final void k() {
        ULog.f6446a.g("HttpRequestUtil", "getPolicy Enter.");
        b();
        ContractEntry contractEntry = ContractEntry.f6691a;
        contractEntry.r();
        contractEntry.p();
    }

    public final String l() {
        return (String) f.getValue();
    }

    public final String m() {
        return (String) c.getValue();
    }

    public final String n() {
        return (String) d.getValue();
    }

    public final String o() {
        return (String) e.getValue();
    }

    public final String p() {
        return (String) g.getValue();
    }

    public final String q(String str) {
        Intrinsics.checkNotNullParameter(str, "deviceID");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("HttpRequestUtil", "getSnSign::deviceID is: " + str);
        String l = DigestUtils.l("RhdNS`Z?" + str);
        Intrinsics.checkNotNullExpressionValue(l, "sha256Hex(...)");
        return l;
    }

    public final void r(String str, String str2, Callback callback) {
        Request build = new Request.Builder().url(str).post(RequestBody.Companion.create(str2, MediaType.Companion.parse(HttpHeaders.Values.APPLICATION_JSON))).build();
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("HttpRequestUtil", "post: request->" + build);
        f().newCall(build).enqueue(callback);
    }

    public final void s(String str, String str2, String str3, String str4, Callback callback) {
        Intrinsics.checkNotNullParameter(str, "policyId");
        Intrinsics.checkNotNullParameter(str3, "deviceType");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("HttpRequestUtil", "queryPPExpire: policyId is->" + str + ", xjAccountId->" + str2);
        if (str2 != null) {
            DeviceInfo g2 = ControlUtils.f7858a.g();
            String serialNo = g2.getSerialNo();
            if ((serialNo == null || serialNo.length() == 0) && str4 == null && !Intrinsics.areEqual((Object) str, (Object) "myvu_pp")) {
                delegate.g("HttpRequestUtil", "queryPPExpire: serialNo is null");
                return;
            }
            String serialNo2 = g2.getSerialNo();
            if (serialNo2 != null && serialNo2.length() != 0) {
                str4 = g2.getSerialNo();
            } else if (str4 == null) {
                str4 = "";
            }
            JSONObject jSONObject = new JSONObject();
            if (!Intrinsics.areEqual((Object) str, (Object) "myvu_pp")) {
                jSONObject.put("iotDeviceId", f7890a.q(str4));
            }
            jSONObject.put("xjAccountId", str2);
            jSONObject.put("policyId", str);
            jSONObject.put("appId", NetConfig.f6666a.e());
            jSONObject.put("deviceType", str3);
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
            r(l(), jSONObject2, callback);
        }
    }

    public final Object t(String str, Continuation continuation) {
        DataStoreUtils.e.a().o("policy_operate_policy_info", JsonUtils.f7893a.d(new PolicyInfo(false, str)));
        Object v = v(str, continuation);
        return v == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? v : Unit.INSTANCE;
    }

    public final Object u(Continuation continuation) {
        String str = (String) DataStoreUtils.i(DataStoreUtils.e.a(), "policy_operate_policy_info", "", (Context) null, 4, (Object) null);
        if (!StringsKt.isBlank(str)) {
            PolicyInfo policyInfo = (PolicyInfo) new Gson().fromJson(str, PolicyInfo.class);
            if (!policyInfo.getReported()) {
                Object v = v(policyInfo.getAgree(), continuation);
                return v == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? v : Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
    }

    public final Object v(String str, Continuation continuation) {
        long currentTimeMillis = System.currentTimeMillis();
        ProtocolType protocolType = ProtocolType.CATEGORY_PP;
        NetConfig.Companion companion = NetConfig.f6666a;
        String x = x(protocolType, companion.e(), companion.h());
        String x2 = x(ProtocolType.CATEGORY_UP, companion.e(), companion.h());
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("businessId", AppUtils.f7842a.e());
        jSONObject.put("operation", str);
        jSONObject.put("type", "phone");
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("category", "up");
        jSONObject2.put("version", x2);
        Unit unit = Unit.INSTANCE;
        jSONArray.put(0, jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("category", "pp");
        jSONObject3.put("version", x);
        jSONArray.put(1, jSONObject3);
        jSONObject.put("baseInfoList", jSONArray);
        String jSONObject4 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject4, "toString(...)");
        String f2 = XJPackageUtil.f(MainApplication.k.f().getApplicationContext());
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("HttpRequestUtil", "recordRequest: " + jSONObject4 + " ppVersion:" + x + " upVersion:" + x2 + " versionName:" + f2);
        RequestBody create = RequestBody.Companion.create(jSONObject4, MediaType.Companion.parse("application/json; charset=utf-8"));
        Request.Builder addHeader = new Request.Builder().url(m()).addHeader("appId", companion.e()).addHeader("appSign", d(currentTimeMillis)).addHeader("reqTime", String.valueOf(currentTimeMillis));
        String str2 = Build.BRAND;
        Intrinsics.checkNotNullExpressionValue(str2, "BRAND");
        Request.Builder addHeader2 = addHeader.addHeader("X-model", str2);
        Intrinsics.checkNotNull(f2);
        f().newCall(addHeader2.addHeader("X-os-version", f2).post(create).build()).enqueue(new HttpRequestUtil$reportOperateRecordToServer$2());
        return Unit.INSTANCE;
    }

    public final void w(String str, Callback callback) {
        Intrinsics.checkNotNullParameter(str, "xjAccountId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("HttpRequestUtil", "requestAIState: xjAccountId->" + str);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("policyId", "aiup");
        jSONObject.put("xjAccountId", str);
        jSONObject.put("appId", NetConfig.f6666a.e());
        jSONObject.put("uuid", AppUtils.f7842a.e());
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
        r(n(), jSONObject2, callback);
    }

    public final String x(ProtocolType protocolType, String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        Request.Builder builder = new Request.Builder();
        String g2 = g();
        String bindKey = protocolType.getBindKey();
        Request.Builder addHeader = builder.url(g2 + "?category=" + bindKey).addHeader("X-brand", "XJ_AD");
        String str3 = Build.BRAND;
        Intrinsics.checkNotNullExpressionValue(str3, "BRAND");
        Request.Builder addHeader2 = addHeader.addHeader("X-model", str3).addHeader("X-os-version", String.valueOf(Build.VERSION.SDK_INT));
        String f2 = XJPackageUtil.f(MainApplication.k.f().getApplicationContext());
        Intrinsics.checkNotNullExpressionValue(f2, "getAppVersionName(...)");
        try {
            Response execute = f().newCall(addHeader2.addHeader("X-version-name", f2).addHeader("appId", str).addHeader("appSign", e(currentTimeMillis, str, str2)).addHeader("reqTime", String.valueOf(currentTimeMillis)).addHeader("X-client-language", h()).get().build()).execute();
            if (execute.code() == 200) {
                ResponseBody body = execute.body();
                Intrinsics.checkNotNull(body);
                String string = body.string();
                ULog.Delegate delegate = ULog.f6446a;
                String name = protocolType.name();
                delegate.a("HttpRequestUtil", "requestPolicyVersion -> onResponse()-> 请求协议信息->" + name + ", res->" + string);
                JSONObject jSONObject = new JSONObject(string);
                if (jSONObject.getInt("code") == 200) {
                    return jSONObject.getJSONObject("data").getJSONObject("data").get("version").toString();
                }
            }
        } catch (Exception e2) {
            ULog.Delegate delegate2 = ULog.f6446a;
            delegate2.c("HttpRequestUtil", "onResponse()-> 请求协议信息->" + protocolType + " failed, e->" + e2);
        }
        return "";
    }

    public final void y(String str, String str2, Callback callback) {
        Intrinsics.checkNotNullParameter(str, "xjAccountId");
        Intrinsics.checkNotNullParameter(str2, "state");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("HttpRequestUtil", "submitAIState: xjAccountId->" + str);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("xjAccountId", str);
        jSONObject.put("policyId", "aiup");
        jSONObject.put("appId", NetConfig.f6666a.e());
        jSONObject.put("status", str2);
        jSONObject.put("uuid", AppUtils.f7842a.e());
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
        r(o(), jSONObject2, callback);
    }

    public final void z(String str, String str2, long j2, Callback callback) {
        Intrinsics.checkNotNullParameter(str, "policyId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("HttpRequestUtil", "submitPPState: policyId is->" + str + ", xjAccountId->" + str2);
        if (str2 != null) {
            DeviceInfo g2 = ControlUtils.f7858a.g();
            String serialNo = g2.getSerialNo();
            if ((serialNo == null || serialNo.length() == 0) && !Intrinsics.areEqual((Object) str, (Object) "myvu_pp")) {
                delegate.c("HttpRequestUtil", "submitPPState: serialNo is null");
                return;
            }
            JSONObject jSONObject = new JSONObject();
            if (!Intrinsics.areEqual((Object) str, (Object) "myvu_pp")) {
                HttpRequestUtil httpRequestUtil = f7890a;
                String serialNo2 = g2.getSerialNo();
                Intrinsics.checkNotNull(serialNo2);
                jSONObject.put("iotDeviceId", httpRequestUtil.q(serialNo2));
            }
            jSONObject.put("xjAccountId", str2);
            jSONObject.put("policyId", str);
            jSONObject.put("appId", NetConfig.f6666a.e());
            jSONObject.put("agreeTime", j2);
            jSONObject.put("deviceType", DynamicAdapterUtils.f7879a.a());
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
            r(p(), jSONObject2, callback);
        }
    }
}
