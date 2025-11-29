package com.upuphone.xr.sapp.config;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.xjsd.xr.sapp.asr.utils.GsonHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/upuphone/xr/sapp/config/NetConfig;", "", "a", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class NetConfig {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f6666a;
    public static NetConfigEntity b;
    public static DetailNetConfigEntity c;
    public static final Gson d = new Gson();
    public static final String e = "{\n    \"china_prod\": {\n        \"nbsUrl\": \"https://xr-nbs.myvu.cn\",\n        \"kmUrl\": \"https://km.myvu.cn\",\n        \"mixtureUrl\": \"https://mixture.myvu.cn\",\n        \"surveyUrl\": \"https://survey.myvu.cn\",\n        \"policyUrl\": \"https://policy.flyme.com\",\n        \"asrUrl\": \"wss://km.myvu.cn/auth/central-manager/ws\",\n        \"aiRecordUrl\": \"https://airecords.myvu.cn\",\n        \"appId\": \"IKSoISndT\",\n        \"userKey\": \"082eae5f-5047-4b51-9f76-92d3afd7b6a5\",\n        \"userSecret\": \"2292b911-7688-42cc-9712-3f9ee47c41c8\",\n        \"xrDatatrack\": \"https://xr-nbs.myvu.cn/xr-datatrack\",\n        \"sArOta\": \"https://xr-nbs.myvu.cn/ar-ota\",\n        \"sAccountService\": \"https://xr-nbs.myvu.cn/account-service\",\n        \"sMyvuAuth\": \"https://gw.myvu.cn/auth\",\n        \"sNbsSurvey\": \"https://gw.myvu.cn/survey\",\n        \"sXrMenu\": \"https://xr-nbs.myvu.cn/xr-menu\",\n        \"sXrWeather\": \"https://xr-nbs.myvu.cn/xr-weather\",\n        \"sXrWeatherKm\": \"https://km.myvu.cn/xr-weather\",\n        \"sWeather\": \"https://xr-nbs.myvu.cn/weather\",\n        \"sWeatherKm\": \"https://km.myvu.cn/weather\",\n        \"sApisix\": \"https://xr-nbs.myvu.cn/auth\",\n        \"sApisixKm\": \"https://km.myvu.cn/auth\",\n        \"feedbackService\": \"https://gw.myvu.cn/feedback/client\",\n        \"cloudAdapterService\" : \"https://xr-nbs.myvu.cn/cloud-adapter\",\n        \"cloudCancelService\": \"https://account.flyme.cn/user/cancel\",\n        \"ak\": \"myvu-android\",\n        \"sk\": \"0716b566f23cd0e6\",\n        \"myvuConfigService\": \"https://xr-nbs.myvu.cn/myvu-config\",\n        \"myvuRecordService\": \"https://gw.myvu.cn/record\",\n        \"myvuFileService\": \"https://gw.myvu.cn/file\"\n    },\n    \"china_uat\": {\n        \"nbsUrl\": \"https://xr-nbs-uat.myvu.cn\",\n        \"kmUrl\": \"https://km-uat.myvu.cn\",\n        \"mixtureUrl\": \"https://mixture-uat.myvu.cn\",\n        \"surveyUrl\": \"https://survey-uat.myvu.cn\",\n        \"policyUrl\": \"https://policy.flyme.com\",\n        \"asrUrl\": \"wss://km-uat.myvu.cn/auth/central-manager/ws\",\n        \"aiRecordUrl\": \"https://airecords-uat.myvu.cn\",\n        \"appId\": \"IKSoISndT\",\n        \"userKey\": \"082eae5f-5047-4b51-9f76-92d3afd7b6a5\",\n        \"userSecret\": \"2292b911-7688-42cc-9712-3f9ee47c41c8\",\n        \"xrDatatrack\": \"https://xr-nbs-uat.myvu.cn/xr-datatrack\",\n        \"sArOta\": \"https://xr-nbs-uat.myvu.cn/ar-ota\",\n        \"sAccountService\": \"https://xr-nbs-uat.myvu.cn/account-service\",\n        \"sMyvuAuth\": \"https://gw-uat.myvu.cn/auth\",\n        \"sNbsSurvey\": \"https://gw-uat.myvu.cn/survey\",\n        \"sXrMenu\": \"https://xr-nbs-uat.myvu.cn/xr-menu\",\n        \"sXrWeather\": \"https://xr-nbs-uat.myvu.cn/xr-weather\",\n        \"sXrWeatherKm\": \"https://km-uat.myvu.cn/xr-weather\",\n        \"sWeather\": \"https://xr-nbs-uat.myvu.cn/weather\",\n        \"sWeatherKm\": \"https://km-uat.myvu.cn/weather\",\n        \"sApisix\": \"https://xr-nbs-uat.myvu.cn/auth\",\n        \"sApisixKm\": \"https://km-uat.myvu.cn/auth\",\n        \"feedbackService\": \"https://gw-uat.myvu.cn/feedback/client\",\n        \"cloudAdapterService\": \"https://xr-nbs-uat.myvu.cn/cloud-adapter\",\n        \"cloudCancelService\": \"https://account.flyme.cn/user/cancel\",\n        \"ak\": \"myvu-app\",\n        \"sk\": \"afc40ef9b01d8908\",\n        \"myvuConfigService\": \"https://xr-nbs-uat.myvu.cn/myvu-config\",\n        \"myvuRecordService\": \"https://gw-uat.myvu.cn/record\",\n        \"myvuFileService\": \"https://gw-uat.myvu.cn/file\"\n    },\n    \"intl_prod\": {\n        \"nbsUrl\": \"https://xr-nbs-global.myvu.cn\",\n        \"kmUrl\": \"https://kmglobal.myvu.cn\",\n        \"mixtureUrl\": \"https://mixture-global.myvu.cn\",\n        \"surveyUrl\": \"https://survey-global.myvu.cn\",\n        \"policyUrl\": \"https://policy-global.flyme.com\",\n        \"asrUrl\": \"wss://kmglobal.myvu.cn/auth/central-manager/ws\",\n        \"aiRecordUrl\": \"https://airecords-global.myvu.cn\",\n        \"appId\": \"elS8JURA\",\n        \"userKey\": \"a9fa9811-dfe2-461f-abeb-f80adbc4440f\",\n        \"userSecret\": \"d09b870d-c466-490a-81d9-b83153840b15\",\n        \"xrDatatrack\": \"https://xr-nbs-global.myvu.cn/xr-datatrack\",\n        \"sArOta\": \"https://xr-nbs-global.myvu.cn/ar-ota\",\n        \"sAccountService\": \"https://xr-nbs-global.myvu.cn/account-service\",\n        \"sMyvuAuth\": \"https://gw-global.myvu.cn/auth\",\n        \"sNbsSurvey\": \"https://gw-global.myvu.cn/survey\",\n        \"sXrMenu\": \"https://xr-nbs-global.myvu.cn/xr-menu\",\n        \"sXrWeather\": \"https://xr-nbs-global.myvu.cn/xr-weather\",\n        \"sXrWeatherKm\": \"https://kmglobal.myvu.cn/xr-weather\",\n        \"sWeather\": \"https://xr-nbs-global.myvu.cn/weather\",\n        \"sWeatherKm\": \"https://kmglobal.myvu.cn/weather\",\n        \"sApisix\": \"https://xr-nbs-global.myvu.cn/auth\",\n        \"sApisixKm\": \"https://kmglobal.myvu.cn/auth\",\n        \"feedbackService\": \"https://gw.myvu.cn/feedback/client\",\n        \"cloudAdapterService\": \"https://xr-nbs-global.myvu.cn/cloud-adapter\",\n        \"cloudCancelService\": \"https://account.in.meizu.com/usercancel\",\n        \"ak\": \"myvu-android\",\n        \"sk\": \"05993e4fc09d8922\",\n        \"myvuConfigService\": \"https://xr-nbs-global.myvu.cn/myvu-config\",\n        \"myvuRecordService\": \"https://gw.myvu.cn/record\",\n        \"myvuFileService\": \"https://gw.myvu.cn/file\"\n    },\n    \"intl_uat\": {\n        \"nbsUrl\": \"https://xr-nbs-global-uat.myvu.cn\",\n        \"kmUrl\": \"https://kmglobal-uat.myvu.cn\",\n        \"mixtureUrl\": \"https://mixture-global-uat.myvu.cn\",\n        \"surveyUrl\": \"https://survey-global-uat.myvu.cn\",\n        \"policyUrl\": \"https://policy-global.flyme.com\",\n        \"asrUrl\": \"wss://kmglobal-uat.myvu.cn/auth/central-manager/ws\",\n        \"aiRecordUrl\": \"https://airecords-global-uat.myvu.cn\",\n        \"appId\": \"XNS9EoTs\",\n        \"userKey\": \"05b59d2d-41b7-4f35-8a4d-a793ef28126b\",\n        \"userSecret\": \"3759dd24-71d7-42ea-9600-c133f4ac5651\",\n        \"xrDatatrack\": \"https://xr-nbs-global-uat.myvu.cn/xr-datatrack\",\n        \"sArOta\": \"https://xr-nbs-global-uat.myvu.cn/ar-ota\",\n        \"sAccountService\": \"https://xr-nbs-global-uat.myvu.cn/account-service\",\n        \"sMyvuAuth\": \"https://gw-global-uat.myvu.cn/auth\",\n        \"sNbsSurvey\": \"https://gw-global-uat.myvu.cn/survey\",\n        \"sXrMenu\": \"https://xr-nbs-global-uat.myvu.cn/xr-menu\",\n        \"sXrWeather\": \"https://xr-nbs-global-uat.myvu.cn/xr-weather\",\n        \"sXrWeatherKm\": \"https://kmglobal-uat.myvu.cn/xr-weather\",\n        \"sWeather\": \"https://xr-nbs-global-uat.myvu.cn/weather\",\n        \"sWeatherKm\": \"https://kmglobal-uat.myvu.cn/weather\",\n        \"sApisix\": \"https://xr-nbs-global-uat.myvu.cn/auth\",\n        \"sApisixKm\": \"https://kmglobal-uat.myvu.cn/auth\",\n        \"feedbackService\": \"https://gw.myvu.cn/feedback/client\",\n        \"cloudAdapterService\": \"https://xr-nbs-global-uat.myvu.cn/cloud-adapter\",\n        \"cloudCancelService\": \"https://account.in.meizu.com/usercancel\",\n        \"ak\": \"myvu-app\",\n        \"sk\": \"8124aaeeabc2d872\",\n        \"myvuConfigService\": \"https://xr-nbs-global-uat.myvu.cn/myvu-config\",\n        \"myvuRecordService\": \"https://gw-uat.myvu.cn/record\",\n        \"myvuFileService\": \"https://gw-uat.myvu.cn/file\"\n    }\n}";
    public static String f;
    public static String g;
    public static String h;
    public static String i;
    public static String j;
    public static final String k;
    public static final String l;
    public static final String m;
    public static final String n;
    public static final String o;
    public static final String p;
    public static final String q;
    public static final String r;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b?\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\u0006J\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\u000eH@¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0014\u0010\u0006J\u000f\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0018\u0010\u0006J\u000f\u0010\u0019\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0019\u0010\u0006J\u000f\u0010\u001a\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001a\u0010\u0006J\u000f\u0010\u001b\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001b\u0010\u0006J\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001f\u0010\u0006R(\u0010 \u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b \u0010!\u0012\u0004\b$\u0010\u0003\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\u0010R(\u0010%\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b%\u0010!\u0012\u0004\b(\u0010\u0003\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\u0010R(\u0010)\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b)\u0010!\u0012\u0004\b,\u0010\u0003\u001a\u0004\b*\u0010\u0006\"\u0004\b+\u0010\u0010R(\u0010-\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b-\u0010!\u0012\u0004\b0\u0010\u0003\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\u0010R(\u00101\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b1\u0010!\u0012\u0004\b4\u0010\u0003\u001a\u0004\b2\u0010\u0006\"\u0004\b3\u0010\u0010R \u00105\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0012\n\u0004\b5\u0010!\u0012\u0004\b7\u0010\u0003\u001a\u0004\b6\u0010\u0006R \u00108\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0012\n\u0004\b8\u0010!\u0012\u0004\b:\u0010\u0003\u001a\u0004\b9\u0010\u0006R \u0010;\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0012\n\u0004\b;\u0010!\u0012\u0004\b=\u0010\u0003\u001a\u0004\b<\u0010\u0006R \u0010>\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0012\n\u0004\b>\u0010!\u0012\u0004\b@\u0010\u0003\u001a\u0004\b?\u0010\u0006R \u0010A\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0012\n\u0004\bA\u0010!\u0012\u0004\bC\u0010\u0003\u001a\u0004\bB\u0010\u0006R \u0010D\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0012\n\u0004\bD\u0010!\u0012\u0004\bF\u0010\u0003\u001a\u0004\bE\u0010\u0006R \u0010G\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0012\n\u0004\bG\u0010!\u0012\u0004\bI\u0010\u0003\u001a\u0004\bH\u0010\u0006R \u0010J\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0012\n\u0004\bJ\u0010!\u0012\u0004\bL\u0010\u0003\u001a\u0004\bK\u0010\u0006R\u0014\u0010M\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\bM\u0010!R\u0014\u0010N\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\bN\u0010!R\u0014\u0010O\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\bO\u0010!R\u0014\u0010P\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\bP\u0010!R\u0014\u0010Q\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\bQ\u0010!R\u0014\u0010R\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010!R\u0016\u0010S\u001a\u00020\t8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bS\u0010TR\u0014\u0010V\u001a\u00020U8\u0002X\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010X\u001a\u00020\u00158\u0002@\u0002X.¢\u0006\u0006\n\u0004\bX\u0010Y¨\u0006Z"}, d2 = {"Lcom/upuphone/xr/sapp/config/NetConfig$Companion;", "", "<init>", "()V", "", "i", "()Ljava/lang/String;", "Lorg/json/JSONObject;", "netConfigs", "Lcom/upuphone/xr/sapp/config/DetailNetConfigEntity;", "z", "(Lorg/json/JSONObject;)Lcom/upuphone/xr/sapp/config/DetailNetConfigEntity;", "j", "envName", "", "A", "(Ljava/lang/String;)V", "x", "y", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "q", "Lcom/upuphone/xr/sapp/config/NetConfigEntity;", "r", "()Lcom/upuphone/xr/sapp/config/NetConfigEntity;", "p", "o", "w", "s", "serviceKey", "v", "(Ljava/lang/String;)Ljava/lang/String;", "u", "APP_KEY", "Ljava/lang/String;", "f", "setAPP_KEY", "getAPP_KEY$annotations", "APP_SECRET", "g", "setAPP_SECRET", "getAPP_SECRET$annotations", "APP_ID", "d", "setAPP_ID", "getAPP_ID$annotations", "AK", "c", "setAK", "getAK$annotations", "SK", "t", "setSK", "getSK$annotations", "APP_ID_VALUE", "e", "getAPP_ID_VALUE$annotations", "APP_SIGN_VALUE", "h", "getAPP_SIGN_VALUE$annotations", "GLASS_AIR_ID_VALUE", "k", "getGLASS_AIR_ID_VALUE$annotations", "GLASS_VIEW_SIGN_VALUE", "n", "getGLASS_VIEW_SIGN_VALUE$annotations", "GLASS_VIEW_ID_VALUE", "m", "getGLASS_VIEW_ID_VALUE$annotations", "GLASS_AIR_SIGN_VALUE", "l", "getGLASS_AIR_SIGN_VALUE$annotations", "ACCOUNT_ID_VALUE", "a", "getACCOUNT_ID_VALUE$annotations", "ACCOUNT_SIGN_VALUE", "b", "getACCOUNT_SIGN_VALUE$annotations", "SP_FILE_NAME", "SP_KEY_ENV", "SP_KEY_NET_CONFIG_DETAIL", "SP_KEY_NET_CONFIG_VER_DETAIL", "TAG", "defaultNetConfig", "detailNetConfigEntity", "Lcom/upuphone/xr/sapp/config/DetailNetConfigEntity;", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", "netConfigEntity", "Lcom/upuphone/xr/sapp/config/NetConfigEntity;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void A(String str) {
            Intrinsics.checkNotNullParameter(str, "envName");
            SharedPreferences.Editor edit = MainApplication.k.f().getSharedPreferences("net_config", 0).edit();
            edit.putString("env", str);
            edit.commit();
        }

        public final String a() {
            return NetConfig.q;
        }

        public final String b() {
            return NetConfig.r;
        }

        public final String c() {
            return NetConfig.i;
        }

        public final String d() {
            return NetConfig.h;
        }

        public final String e() {
            return NetConfig.k;
        }

        public final String f() {
            return NetConfig.f;
        }

        public final String g() {
            return NetConfig.g;
        }

        public final String h() {
            return NetConfig.l;
        }

        public final String i() {
            Boolean bool = BuildConfig.f6575a;
            Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
            return bool.booleanValue() ? "intl_prod" : "china_prod";
        }

        public final String j() {
            String string = MainApplication.k.f().getSharedPreferences("net_config", 0).getString("env", "");
            if (string != null && !StringsKt.isBlank(string)) {
                return string;
            }
            String i = i();
            A(i);
            return i;
        }

        public final String k() {
            return NetConfig.m;
        }

        public final String l() {
            return NetConfig.p;
        }

        public final String m() {
            return NetConfig.o;
        }

        public final String n() {
            return NetConfig.n;
        }

        public final String o() {
            NetConfigEntity p = NetConfig.b;
            if (p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("netConfigEntity");
                p = null;
            }
            String mixtureUrl = p.getMixtureUrl();
            return mixtureUrl == null ? "" : mixtureUrl;
        }

        public final String p() {
            NetConfigEntity p = NetConfig.b;
            if (p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("netConfigEntity");
                p = null;
            }
            String nbsUrl = p.getNbsUrl();
            return nbsUrl == null ? "" : nbsUrl;
        }

        public final String q() {
            Gson o = NetConfig.d;
            DetailNetConfigEntity j = NetConfig.c;
            if (j == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailNetConfigEntity");
                j = null;
            }
            String json = o.toJson((Object) j);
            ULog.Delegate delegate = ULog.f6446a;
            delegate.g("NetConfig", "getAllConfig-> " + json);
            Intrinsics.checkNotNull(json);
            return json;
        }

        public final NetConfigEntity r() {
            ULog.Delegate delegate = ULog.f6446a;
            NetConfigEntity p = NetConfig.b;
            if (p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("netConfigEntity");
                p = null;
            }
            delegate.g("NetConfig", "getNetConfigsEntity-> " + p);
            NetConfigEntity p2 = NetConfig.b;
            if (p2 != null) {
                return p2;
            }
            Intrinsics.throwUninitializedPropertyAccessException("netConfigEntity");
            return null;
        }

        public final String s() {
            NetConfigEntity p = NetConfig.b;
            if (p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("netConfigEntity");
                p = null;
            }
            String policyUrl = p.getPolicyUrl();
            return policyUrl == null ? "" : policyUrl;
        }

        public final String t() {
            return NetConfig.j;
        }

        public final String u() {
            ULog.Delegate delegate = ULog.f6446a;
            DetailNetConfigEntity j = NetConfig.c;
            DetailNetConfigEntity detailNetConfigEntity = null;
            if (j == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailNetConfigEntity");
                j = null;
            }
            delegate.a("NetConfig", "getS_CLOUD_ADAPTER url:" + j.getCloudAdapterService());
            DetailNetConfigEntity j2 = NetConfig.c;
            if (j2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailNetConfigEntity");
            } else {
                detailNetConfigEntity = j2;
            }
            return detailNetConfigEntity.getCloudAdapterService();
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.String v(java.lang.String r4) {
            /*
                r3 = this;
                java.lang.String r3 = "serviceKey"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r3)
                int r3 = r4.hashCode()
                r0 = 0
                java.lang.String r1 = "detailNetConfigEntity"
                switch(r3) {
                    case -2141430277: goto L_0x01d5;
                    case -1571860439: goto L_0x01bc;
                    case -1561410457: goto L_0x01a3;
                    case -1439283386: goto L_0x018a;
                    case -1025114341: goto L_0x016f;
                    case -1011856594: goto L_0x0154;
                    case -939110280: goto L_0x0139;
                    case -648602211: goto L_0x011e;
                    case -215087805: goto L_0x0103;
                    case -153582073: goto L_0x00e9;
                    case -16230023: goto L_0x00ce;
                    case 96469574: goto L_0x00b3;
                    case 452895398: goto L_0x0098;
                    case 583385448: goto L_0x007d;
                    case 796156784: goto L_0x0062;
                    case 951279323: goto L_0x0047;
                    case 1447819265: goto L_0x002c;
                    case 1610749388: goto L_0x0011;
                    default: goto L_0x000f;
                }
            L_0x000f:
                goto L_0x01dd
            L_0x0011:
                java.lang.String r3 = "sXrMenu"
                boolean r3 = r4.equals(r3)
                if (r3 != 0) goto L_0x001b
                goto L_0x01dd
            L_0x001b:
                com.upuphone.xr.sapp.config.DetailNetConfigEntity r3 = com.upuphone.xr.sapp.config.NetConfig.c
                if (r3 != 0) goto L_0x0025
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
                goto L_0x0026
            L_0x0025:
                r0 = r3
            L_0x0026:
                java.lang.String r3 = r0.getSXrMenu()
                goto L_0x01ef
            L_0x002c:
                java.lang.String r3 = "sWeather"
                boolean r3 = r4.equals(r3)
                if (r3 != 0) goto L_0x0036
                goto L_0x01dd
            L_0x0036:
                com.upuphone.xr.sapp.config.DetailNetConfigEntity r3 = com.upuphone.xr.sapp.config.NetConfig.c
                if (r3 != 0) goto L_0x0040
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
                goto L_0x0041
            L_0x0040:
                r0 = r3
            L_0x0041:
                java.lang.String r3 = r0.getSWeather()
                goto L_0x01ef
            L_0x0047:
                java.lang.String r3 = "sApisix"
                boolean r3 = r4.equals(r3)
                if (r3 != 0) goto L_0x0051
                goto L_0x01dd
            L_0x0051:
                com.upuphone.xr.sapp.config.DetailNetConfigEntity r3 = com.upuphone.xr.sapp.config.NetConfig.c
                if (r3 != 0) goto L_0x005b
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
                goto L_0x005c
            L_0x005b:
                r0 = r3
            L_0x005c:
                java.lang.String r3 = r0.getSApisix()
                goto L_0x01ef
            L_0x0062:
                java.lang.String r3 = "feedbackService"
                boolean r3 = r4.equals(r3)
                if (r3 != 0) goto L_0x006c
                goto L_0x01dd
            L_0x006c:
                com.upuphone.xr.sapp.config.DetailNetConfigEntity r3 = com.upuphone.xr.sapp.config.NetConfig.c
                if (r3 != 0) goto L_0x0076
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
                goto L_0x0077
            L_0x0076:
                r0 = r3
            L_0x0077:
                java.lang.String r3 = r0.getFeedbackService()
                goto L_0x01ef
            L_0x007d:
                java.lang.String r3 = "myvuConfigService"
                boolean r3 = r4.equals(r3)
                if (r3 != 0) goto L_0x0087
                goto L_0x01dd
            L_0x0087:
                com.upuphone.xr.sapp.config.DetailNetConfigEntity r3 = com.upuphone.xr.sapp.config.NetConfig.c
                if (r3 != 0) goto L_0x0091
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
                goto L_0x0092
            L_0x0091:
                r0 = r3
            L_0x0092:
                java.lang.String r3 = r0.getMyvuConfigService()
                goto L_0x01ef
            L_0x0098:
                java.lang.String r3 = "cloudCancelService"
                boolean r3 = r4.equals(r3)
                if (r3 != 0) goto L_0x00a2
                goto L_0x01dd
            L_0x00a2:
                com.upuphone.xr.sapp.config.DetailNetConfigEntity r3 = com.upuphone.xr.sapp.config.NetConfig.c
                if (r3 != 0) goto L_0x00ac
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
                goto L_0x00ad
            L_0x00ac:
                r0 = r3
            L_0x00ad:
                java.lang.String r3 = r0.getCloudCancelService()
                goto L_0x01ef
            L_0x00b3:
                java.lang.String r3 = "sNbsSurvey"
                boolean r3 = r4.equals(r3)
                if (r3 != 0) goto L_0x00bd
                goto L_0x01dd
            L_0x00bd:
                com.upuphone.xr.sapp.config.DetailNetConfigEntity r3 = com.upuphone.xr.sapp.config.NetConfig.c
                if (r3 != 0) goto L_0x00c7
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
                goto L_0x00c8
            L_0x00c7:
                r0 = r3
            L_0x00c8:
                java.lang.String r3 = r0.getSNbsSurvey()
                goto L_0x01ef
            L_0x00ce:
                java.lang.String r3 = "myvuRecordService"
                boolean r3 = r4.equals(r3)
                if (r3 != 0) goto L_0x00d8
                goto L_0x01dd
            L_0x00d8:
                com.upuphone.xr.sapp.config.DetailNetConfigEntity r3 = com.upuphone.xr.sapp.config.NetConfig.c
                if (r3 != 0) goto L_0x00e2
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
                goto L_0x00e3
            L_0x00e2:
                r0 = r3
            L_0x00e3:
                java.lang.String r3 = r0.getMyvuRecordService()
                goto L_0x01ef
            L_0x00e9:
                java.lang.String r3 = "xrDatatrack"
                boolean r3 = r4.equals(r3)
                if (r3 == 0) goto L_0x01dd
                com.upuphone.xr.sapp.config.DetailNetConfigEntity r3 = com.upuphone.xr.sapp.config.NetConfig.c
                if (r3 != 0) goto L_0x00fc
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
                goto L_0x00fd
            L_0x00fc:
                r0 = r3
            L_0x00fd:
                java.lang.String r3 = r0.getXrDatatrack()
                goto L_0x01ef
            L_0x0103:
                java.lang.String r3 = "sWeatherKm"
                boolean r3 = r4.equals(r3)
                if (r3 != 0) goto L_0x010d
                goto L_0x01dd
            L_0x010d:
                com.upuphone.xr.sapp.config.DetailNetConfigEntity r3 = com.upuphone.xr.sapp.config.NetConfig.c
                if (r3 != 0) goto L_0x0117
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
                goto L_0x0118
            L_0x0117:
                r0 = r3
            L_0x0118:
                java.lang.String r3 = r0.getSWeatherKm()
                goto L_0x01ef
            L_0x011e:
                java.lang.String r3 = "sApisixKm"
                boolean r3 = r4.equals(r3)
                if (r3 != 0) goto L_0x0128
                goto L_0x01dd
            L_0x0128:
                com.upuphone.xr.sapp.config.DetailNetConfigEntity r3 = com.upuphone.xr.sapp.config.NetConfig.c
                if (r3 != 0) goto L_0x0132
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
                goto L_0x0133
            L_0x0132:
                r0 = r3
            L_0x0133:
                java.lang.String r3 = r0.getSApisixKm()
                goto L_0x01ef
            L_0x0139:
                java.lang.String r3 = "sArOta"
                boolean r3 = r4.equals(r3)
                if (r3 != 0) goto L_0x0143
                goto L_0x01dd
            L_0x0143:
                com.upuphone.xr.sapp.config.DetailNetConfigEntity r3 = com.upuphone.xr.sapp.config.NetConfig.c
                if (r3 != 0) goto L_0x014d
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
                goto L_0x014e
            L_0x014d:
                r0 = r3
            L_0x014e:
                java.lang.String r3 = r0.getSArOta()
                goto L_0x01ef
            L_0x0154:
                java.lang.String r3 = "myvuFileService"
                boolean r3 = r4.equals(r3)
                if (r3 != 0) goto L_0x015e
                goto L_0x01dd
            L_0x015e:
                com.upuphone.xr.sapp.config.DetailNetConfigEntity r3 = com.upuphone.xr.sapp.config.NetConfig.c
                if (r3 != 0) goto L_0x0168
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
                goto L_0x0169
            L_0x0168:
                r0 = r3
            L_0x0169:
                java.lang.String r3 = r0.getMyvuFileService()
                goto L_0x01ef
            L_0x016f:
                java.lang.String r3 = "sAccountService"
                boolean r3 = r4.equals(r3)
                if (r3 != 0) goto L_0x0179
                goto L_0x01dd
            L_0x0179:
                com.upuphone.xr.sapp.config.DetailNetConfigEntity r3 = com.upuphone.xr.sapp.config.NetConfig.c
                if (r3 != 0) goto L_0x0183
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
                goto L_0x0184
            L_0x0183:
                r0 = r3
            L_0x0184:
                java.lang.String r3 = r0.getSAccountService()
                goto L_0x01ef
            L_0x018a:
                java.lang.String r3 = "sMyvuAuth"
                boolean r3 = r4.equals(r3)
                if (r3 != 0) goto L_0x0193
                goto L_0x01dd
            L_0x0193:
                com.upuphone.xr.sapp.config.DetailNetConfigEntity r3 = com.upuphone.xr.sapp.config.NetConfig.c
                if (r3 != 0) goto L_0x019d
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
                goto L_0x019e
            L_0x019d:
                r0 = r3
            L_0x019e:
                java.lang.String r3 = r0.getSMyvuAuth()
                goto L_0x01ef
            L_0x01a3:
                java.lang.String r3 = "sXrWeather"
                boolean r3 = r4.equals(r3)
                if (r3 != 0) goto L_0x01ac
                goto L_0x01dd
            L_0x01ac:
                com.upuphone.xr.sapp.config.DetailNetConfigEntity r3 = com.upuphone.xr.sapp.config.NetConfig.c
                if (r3 != 0) goto L_0x01b6
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
                goto L_0x01b7
            L_0x01b6:
                r0 = r3
            L_0x01b7:
                java.lang.String r3 = r0.getSXrWeather()
                goto L_0x01ef
            L_0x01bc:
                java.lang.String r3 = "sXrWeatherKm"
                boolean r3 = r4.equals(r3)
                if (r3 != 0) goto L_0x01c5
                goto L_0x01dd
            L_0x01c5:
                com.upuphone.xr.sapp.config.DetailNetConfigEntity r3 = com.upuphone.xr.sapp.config.NetConfig.c
                if (r3 != 0) goto L_0x01cf
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
                goto L_0x01d0
            L_0x01cf:
                r0 = r3
            L_0x01d0:
                java.lang.String r3 = r0.getSXrWeatherKm()
                goto L_0x01ef
            L_0x01d5:
                java.lang.String r3 = "cloudAdapterService"
                boolean r3 = r4.equals(r3)
                if (r3 != 0) goto L_0x01e0
            L_0x01dd:
                java.lang.String r3 = ""
                goto L_0x01ef
            L_0x01e0:
                com.upuphone.xr.sapp.config.DetailNetConfigEntity r3 = com.upuphone.xr.sapp.config.NetConfig.c
                if (r3 != 0) goto L_0x01ea
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
                goto L_0x01eb
            L_0x01ea:
                r0 = r3
            L_0x01eb:
                java.lang.String r3 = r0.getCloudAdapterService()
            L_0x01ef:
                com.upuphone.star.core.log.ULog$Delegate r0 = com.upuphone.star.core.log.ULog.f6446a
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "getServiceUrl -> serviceKey:"
                r1.append(r2)
                r1.append(r4)
                java.lang.String r4 = " url:"
                r1.append(r4)
                r1.append(r3)
                java.lang.String r4 = r1.toString()
                java.lang.String r1 = "NetConfig"
                r0.a(r1, r4)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.config.NetConfig.Companion.v(java.lang.String):java.lang.String");
        }

        public final String w() {
            NetConfigEntity p = NetConfig.b;
            if (p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("netConfigEntity");
                p = null;
            }
            String surveyUrl = p.getSurveyUrl();
            return surveyUrl == null ? "" : surveyUrl;
        }

        public final void x() {
            String j = j();
            JSONObject jSONObject = new JSONObject(NetConfig.e).getJSONObject(j);
            ULog.Delegate delegate = ULog.f6446a;
            delegate.g("NetConfig", "loadNetConfigs-> env: " + j + " \nnetConfigs: " + jSONObject);
            String str = (String) DataStoreUtils.i(DataStoreUtils.e.a(), "networkConfigDetail", "", (Context) null, 4, (Object) null);
            DetailNetConfigEntity detailNetConfigEntity = null;
            if (str.length() == 0) {
                delegate.g("NetConfig", "localNetConfig isEmpty");
                Intrinsics.checkNotNull(jSONObject);
                NetConfig.c = z(jSONObject);
                DetailNetConfigEntity j2 = NetConfig.c;
                if (j2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("detailNetConfigEntity");
                    j2 = null;
                }
                NetConfigEntity netConfigEntity = j2.getNetConfigEntity();
                Intrinsics.checkNotNull(netConfigEntity);
                NetConfig.b = netConfigEntity;
            } else {
                DetailNetConfigEntity detailNetConfigEntity2 = (DetailNetConfigEntity) GsonHelper.fromJson(str, DetailNetConfigEntity.class);
                NetConfigEntity netConfigEntity2 = detailNetConfigEntity2.getNetConfigEntity();
                Intrinsics.checkNotNull(netConfigEntity2);
                NetConfig.b = netConfigEntity2;
                NetConfig.c = detailNetConfigEntity2;
                DetailNetConfigEntity j3 = NetConfig.c;
                if (j3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("detailNetConfigEntity");
                    j3 = null;
                }
                delegate.g("NetConfig", "loadNetConfigs-localNetConfigEntity-> " + j3);
            }
            DetailNetConfigEntity j4 = NetConfig.c;
            if (j4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailNetConfigEntity");
            } else {
                detailNetConfigEntity = j4;
            }
            delegate.g("NetConfig", "loadNetConfigs-> " + detailNetConfigEntity);
        }

        /* JADX WARNING: type inference failed for: r0v15, types: [com.upuphone.xr.sapp.config.NetConfigEntity] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0070  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x0100  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object y(kotlin.coroutines.Continuation r26) {
            /*
                r25 = this;
                r0 = r25
                r1 = r26
                boolean r2 = r1 instanceof com.upuphone.xr.sapp.config.NetConfig$Companion$loadNetConfigsFromServer$1
                r3 = -2147483648(0xffffffff80000000, float:-0.0)
                if (r2 == 0) goto L_0x0017
                r2 = r1
                com.upuphone.xr.sapp.config.NetConfig$Companion$loadNetConfigsFromServer$1 r2 = (com.upuphone.xr.sapp.config.NetConfig$Companion$loadNetConfigsFromServer$1) r2
                int r4 = r2.label
                r5 = r4 & r3
                if (r5 == 0) goto L_0x0017
                int r4 = r4 - r3
                r2.label = r4
                goto L_0x001c
            L_0x0017:
                com.upuphone.xr.sapp.config.NetConfig$Companion$loadNetConfigsFromServer$1 r2 = new com.upuphone.xr.sapp.config.NetConfig$Companion$loadNetConfigsFromServer$1
                r2.<init>(r0, r1)
            L_0x001c:
                java.lang.Object r1 = r2.result
                java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r5 = r2.label
                r6 = 2
                r7 = 1
                if (r5 == 0) goto L_0x0041
                if (r5 == r7) goto L_0x0039
                if (r5 != r6) goto L_0x0031
                kotlin.ResultKt.throwOnFailure(r1)
                goto L_0x0248
            L_0x0031:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L_0x0039:
                java.lang.Object r0 = r2.L$0
                com.upuphone.xr.sapp.config.NetConfig$Companion r0 = (com.upuphone.xr.sapp.config.NetConfig.Companion) r0
                kotlin.ResultKt.throwOnFailure(r1)
                goto L_0x0054
            L_0x0041:
                kotlin.ResultKt.throwOnFailure(r1)
                com.upuphone.xr.sapp.config.RequestNetConfigHelper r1 = new com.upuphone.xr.sapp.config.RequestNetConfigHelper
                r1.<init>()
                r2.L$0 = r0
                r2.label = r7
                java.lang.Object r1 = r1.d(r2)
                if (r1 != r4) goto L_0x0054
                return r4
            L_0x0054:
                com.upuphone.xr.sapp.config.DetailNetConfigEntity r1 = (com.upuphone.xr.sapp.config.DetailNetConfigEntity) r1
                java.lang.String r5 = r0.j()
                org.json.JSONObject r7 = new org.json.JSONObject
                java.lang.String r8 = com.upuphone.xr.sapp.config.NetConfig.e
                r7.<init>(r8)
                org.json.JSONObject r7 = r7.getJSONObject(r5)
                java.lang.String r8 = "netConfigEntity"
                java.lang.String r9 = "detailNetConfigEntity"
                java.lang.String r10 = "NetConfig"
                r11 = 0
                if (r1 != 0) goto L_0x0100
                com.upuphone.star.core.log.ULog$Delegate r1 = com.upuphone.star.core.log.ULog.f6446a
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "loadNetConfigsFromServer-> env: "
                r2.append(r3)
                r2.append(r5)
                java.lang.String r3 = " \nnetConfigs: "
                r2.append(r3)
                r2.append(r7)
                java.lang.String r2 = r2.toString()
                r1.g(r10, r2)
                com.upuphone.xr.sapp.utils.DataStoreUtils$Companion r2 = com.upuphone.xr.sapp.utils.DataStoreUtils.e
                com.upuphone.xr.sapp.utils.DataStoreUtils r12 = r2.a()
                r16 = 4
                r17 = 0
                java.lang.String r13 = "networkConfigDetail"
                java.lang.String r14 = ""
                r15 = 0
                java.lang.Object r2 = com.upuphone.xr.sapp.utils.DataStoreUtils.i(r12, r13, r14, r15, r16, r17)
                java.lang.String r2 = (java.lang.String) r2
                int r3 = r2.length()
                if (r3 != 0) goto L_0x00c9
                kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
                com.upuphone.xr.sapp.config.DetailNetConfigEntity r0 = r0.z(r7)
                com.upuphone.xr.sapp.config.NetConfig.c = r0
                com.upuphone.xr.sapp.config.DetailNetConfigEntity r0 = com.upuphone.xr.sapp.config.NetConfig.c
                if (r0 != 0) goto L_0x00bd
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
                goto L_0x00be
            L_0x00bd:
                r11 = r0
            L_0x00be:
                com.upuphone.xr.sapp.config.NetConfigEntity r0 = r11.getNetConfigEntity()
                kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
                com.upuphone.xr.sapp.config.NetConfig.b = r0
                goto L_0x00fd
            L_0x00c9:
                java.lang.Class<com.upuphone.xr.sapp.config.DetailNetConfigEntity> r0 = com.upuphone.xr.sapp.config.DetailNetConfigEntity.class
                java.lang.Object r0 = com.xjsd.xr.sapp.asr.utils.GsonHelper.fromJson(r2, r0)
                com.upuphone.xr.sapp.config.DetailNetConfigEntity r0 = (com.upuphone.xr.sapp.config.DetailNetConfigEntity) r0
                com.upuphone.xr.sapp.config.NetConfigEntity r2 = r0.getNetConfigEntity()
                kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
                com.upuphone.xr.sapp.config.NetConfig.b = r2
                com.upuphone.xr.sapp.config.NetConfig.c = r0
                com.upuphone.xr.sapp.config.NetConfigEntity r0 = com.upuphone.xr.sapp.config.NetConfig.b
                if (r0 != 0) goto L_0x00e8
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
                goto L_0x00e9
            L_0x00e8:
                r11 = r0
            L_0x00e9:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "loadNetConfigsFromServer-localNetConfigEntity-> "
                r0.append(r2)
                r0.append(r11)
                java.lang.String r0 = r0.toString()
                r1.g(r10, r0)
            L_0x00fd:
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            L_0x0100:
                com.upuphone.xr.sapp.config.NetConfigEntity r5 = new com.upuphone.xr.sapp.config.NetConfigEntity
                com.upuphone.xr.sapp.config.NetConfigEntity r12 = r1.getNetConfigEntity()
                if (r12 == 0) goto L_0x010e
                java.lang.String r12 = r12.getNbsUrl()
                r13 = r12
                goto L_0x010f
            L_0x010e:
                r13 = r11
            L_0x010f:
                com.upuphone.xr.sapp.config.NetConfigEntity r12 = r1.getNetConfigEntity()
                if (r12 == 0) goto L_0x011b
                java.lang.String r12 = r12.getKmUrl()
                r14 = r12
                goto L_0x011c
            L_0x011b:
                r14 = r11
            L_0x011c:
                com.upuphone.xr.sapp.config.NetConfigEntity r12 = r1.getNetConfigEntity()
                if (r12 == 0) goto L_0x0128
                java.lang.String r12 = r12.getMixtureUrl()
                r15 = r12
                goto L_0x0129
            L_0x0128:
                r15 = r11
            L_0x0129:
                com.upuphone.xr.sapp.config.NetConfigEntity r12 = r1.getNetConfigEntity()
                if (r12 == 0) goto L_0x0136
                java.lang.String r12 = r12.getSurveyUrl()
                r16 = r12
                goto L_0x0138
            L_0x0136:
                r16 = r11
            L_0x0138:
                com.upuphone.xr.sapp.config.NetConfigEntity r12 = r1.getNetConfigEntity()
                if (r12 == 0) goto L_0x0145
                java.lang.String r12 = r12.getPolicyUrl()
                r17 = r12
                goto L_0x0147
            L_0x0145:
                r17 = r11
            L_0x0147:
                com.upuphone.xr.sapp.config.NetConfigEntity r12 = r1.getNetConfigEntity()
                if (r12 == 0) goto L_0x0154
                java.lang.String r12 = r12.getAsrUrl()
                r18 = r12
                goto L_0x0156
            L_0x0154:
                r18 = r11
            L_0x0156:
                com.upuphone.xr.sapp.config.NetConfigEntity r12 = r1.getNetConfigEntity()
                if (r12 == 0) goto L_0x0163
                java.lang.String r12 = r12.getAiRecordUrl()
                r19 = r12
                goto L_0x0165
            L_0x0163:
                r19 = r11
            L_0x0165:
                java.lang.String r12 = "appId"
                java.lang.String r20 = r7.optString(r12)
                java.lang.String r12 = "userKey"
                java.lang.String r21 = r7.optString(r12)
                java.lang.String r12 = "userSecret"
                java.lang.String r22 = r7.optString(r12)
                java.lang.String r23 = r0.c()
                java.lang.String r24 = r0.t()
                r12 = r5
                r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
                com.upuphone.xr.sapp.config.NetConfig.b = r5
                com.upuphone.xr.sapp.config.NetConfigEntity r0 = com.upuphone.xr.sapp.config.NetConfig.b
                if (r0 != 0) goto L_0x0192
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
                r0 = r11
            L_0x0192:
                r1.setNetConfigEntity(r0)
                com.upuphone.xr.sapp.config.NetConfig.c = r1
                com.upuphone.xr.sapp.utils.DataStoreUtils$Companion r0 = com.upuphone.xr.sapp.utils.DataStoreUtils.e
                com.upuphone.xr.sapp.utils.DataStoreUtils r12 = r0.a()
                java.lang.Integer r14 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r3)
                r16 = 4
                r17 = 0
                java.lang.String r13 = "networkConfigVerDetail"
                r15 = 0
                java.lang.Object r5 = com.upuphone.xr.sapp.utils.DataStoreUtils.i(r12, r13, r14, r15, r16, r17)
                java.lang.Number r5 = (java.lang.Number) r5
                int r5 = r5.intValue()
                if (r5 == r3) goto L_0x01bd
                com.upuphone.xr.sapp.config.RequestNetConfigHelper$Companion r3 = com.upuphone.xr.sapp.config.RequestNetConfigHelper.f6668a
                int r3 = r3.a()
                if (r5 >= r3) goto L_0x0200
            L_0x01bd:
                com.upuphone.star.core.log.ULog$Delegate r3 = com.upuphone.star.core.log.ULog.f6446a
                com.upuphone.xr.sapp.config.RequestNetConfigHelper$Companion r7 = com.upuphone.xr.sapp.config.RequestNetConfigHelper.f6668a
                int r8 = r7.a()
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>()
                java.lang.String r13 = "updateLocalNetConfigEntity-> last version:"
                r12.append(r13)
                r12.append(r5)
                java.lang.String r5 = " new version:"
                r12.append(r5)
                r12.append(r8)
                java.lang.String r5 = r12.toString()
                r3.g(r10, r5)
                com.upuphone.xr.sapp.utils.DataStoreUtils r3 = r0.a()
                int r5 = r7.a()
                java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r5)
                java.lang.String r7 = "networkConfigVerDetail"
                r3.o(r7, r5)
                java.lang.String r3 = com.xjsd.xr.sapp.asr.utils.GsonHelper.toJson(r1)
                com.upuphone.xr.sapp.utils.DataStoreUtils r0 = r0.a()
                java.lang.String r5 = "networkConfigDetail"
                r0.o(r5, r3)
            L_0x0200:
                com.upuphone.star.core.log.ULog$Delegate r0 = com.upuphone.star.core.log.ULog.f6446a
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r5 = "loadNetConfigsFromServer-> networkNetConfig:"
                r3.append(r5)
                r3.append(r1)
                java.lang.String r1 = r3.toString()
                r0.g(r10, r1)
                com.upuphone.xr.sapp.config.DetailNetConfigEntity r1 = com.upuphone.xr.sapp.config.NetConfig.c
                if (r1 != 0) goto L_0x0220
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
                r1 = r11
            L_0x0220:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r5 = "loadNetConfigsFromServer-> detailNetConfigEntity:"
                r3.append(r5)
                r3.append(r1)
                java.lang.String r1 = r3.toString()
                r0.g(r10, r1)
                kotlinx.coroutines.MainCoroutineDispatcher r0 = kotlinx.coroutines.Dispatchers.c()
                com.upuphone.xr.sapp.config.NetConfig$Companion$loadNetConfigsFromServer$2 r1 = new com.upuphone.xr.sapp.config.NetConfig$Companion$loadNetConfigsFromServer$2
                r1.<init>(r11)
                r2.L$0 = r11
                r2.label = r6
                java.lang.Object r0 = kotlinx.coroutines.BuildersKt.g(r0, r1, r2)
                if (r0 != r4) goto L_0x0248
                return r4
            L_0x0248:
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.config.NetConfig.Companion.y(kotlin.coroutines.Continuation):java.lang.Object");
        }

        public final DetailNetConfigEntity z(JSONObject jSONObject) {
            JSONObject jSONObject2 = jSONObject;
            NetConfigEntity netConfigEntity = r1;
            NetConfigEntity netConfigEntity2 = new NetConfigEntity(jSONObject2.optString("nbsUrl"), jSONObject2.optString("kmUrl"), jSONObject2.optString("mixtureUrl"), jSONObject2.optString("surveyUrl"), jSONObject2.optString("policyUrl"), jSONObject2.optString("asrUrl"), jSONObject2.optString("aiRecordUrl"), jSONObject2.optString("appId"), jSONObject2.optString("userKey"), jSONObject2.optString("userSecret"), jSONObject2.optString("ak"), jSONObject2.optString("sk"));
            String optString = jSONObject2.optString("xrDatatrack");
            String str = optString;
            Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
            String optString2 = jSONObject2.optString("sArOta");
            String str2 = optString2;
            Intrinsics.checkNotNullExpressionValue(optString2, "optString(...)");
            String optString3 = jSONObject2.optString("sAccountService");
            String str3 = optString3;
            Intrinsics.checkNotNullExpressionValue(optString3, "optString(...)");
            String optString4 = jSONObject2.optString("sMyvuAuth");
            String str4 = optString4;
            Intrinsics.checkNotNullExpressionValue(optString4, "optString(...)");
            String optString5 = jSONObject2.optString("sNbsSurvey");
            String str5 = optString5;
            Intrinsics.checkNotNullExpressionValue(optString5, "optString(...)");
            String optString6 = jSONObject2.optString("sXrMenu");
            String str6 = optString6;
            Intrinsics.checkNotNullExpressionValue(optString6, "optString(...)");
            String optString7 = jSONObject2.optString("sXrWeather");
            String str7 = optString7;
            Intrinsics.checkNotNullExpressionValue(optString7, "optString(...)");
            String optString8 = jSONObject2.optString("sXrWeatherKm");
            String str8 = optString8;
            Intrinsics.checkNotNullExpressionValue(optString8, "optString(...)");
            String optString9 = jSONObject2.optString("sWeather");
            String str9 = optString9;
            Intrinsics.checkNotNullExpressionValue(optString9, "optString(...)");
            String optString10 = jSONObject2.optString("sWeatherKm");
            String str10 = optString10;
            Intrinsics.checkNotNullExpressionValue(optString10, "optString(...)");
            String optString11 = jSONObject2.optString("sApisix");
            String str11 = optString11;
            Intrinsics.checkNotNullExpressionValue(optString11, "optString(...)");
            String optString12 = jSONObject2.optString("sApisixKm");
            String str12 = optString12;
            Intrinsics.checkNotNullExpressionValue(optString12, "optString(...)");
            String optString13 = jSONObject2.optString("feedbackService");
            String str13 = optString13;
            Intrinsics.checkNotNullExpressionValue(optString13, "optString(...)");
            String optString14 = jSONObject2.optString("cloudAdapterService");
            String str14 = optString14;
            Intrinsics.checkNotNullExpressionValue(optString14, "optString(...)");
            String optString15 = jSONObject2.optString("cloudCancelService");
            String str15 = optString15;
            Intrinsics.checkNotNullExpressionValue(optString15, "optString(...)");
            String optString16 = jSONObject2.optString("myvuConfigService");
            String str16 = optString16;
            Intrinsics.checkNotNullExpressionValue(optString16, "optString(...)");
            String optString17 = jSONObject2.optString("myvuRecordService");
            Intrinsics.checkNotNullExpressionValue(optString17, "optString(...)");
            String optString18 = jSONObject2.optString("myvuFileService");
            Intrinsics.checkNotNullExpressionValue(optString18, "optString(...)");
            return new DetailNetConfigEntity(netConfigEntity, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, optString17, optString18);
        }

        public Companion() {
        }
    }

    static {
        Companion companion = new Companion((DefaultConstructorMarker) null);
        f6666a = companion;
        f = "";
        g = "";
        h = "";
        i = "";
        j = "";
        Boolean bool = BuildConfig.f6575a;
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        k = bool.booleanValue() ? "56793477284872811830" : "36162630959229884400";
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        l = bool.booleanValue() ? "e847cec8ac8a4a13a89fab4b4ae30a87" : "9304ab6481524502ad56e66eecc25a70";
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        String str = "82694969009158162640";
        m = bool.booleanValue() ? "56794611280050711940" : str;
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        String str2 = "77751e6be6cf4556b96071cf7a1b1891";
        n = bool.booleanValue() ? "750b7749d97b49b192dd80e6be67944a" : str2;
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        if (bool.booleanValue()) {
            str = "56794611280050711940";
        }
        o = str;
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        if (bool.booleanValue()) {
            str2 = "750b7749d97b49b192dd80e6be67944a";
        }
        p = str2;
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        q = bool.booleanValue() ? "61028808626174682630" : "55801783128653156870";
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        r = bool.booleanValue() ? "3de2878ec02949d9a9a598073a2b1757" : "bfcd68c7c88a40f7b0ec4b4d387e3ec3";
        JSONObject jSONObject = new JSONObject("{\n    \"china_prod\": {\n        \"nbsUrl\": \"https://xr-nbs.myvu.cn\",\n        \"kmUrl\": \"https://km.myvu.cn\",\n        \"mixtureUrl\": \"https://mixture.myvu.cn\",\n        \"surveyUrl\": \"https://survey.myvu.cn\",\n        \"policyUrl\": \"https://policy.flyme.com\",\n        \"asrUrl\": \"wss://km.myvu.cn/auth/central-manager/ws\",\n        \"aiRecordUrl\": \"https://airecords.myvu.cn\",\n        \"appId\": \"IKSoISndT\",\n        \"userKey\": \"082eae5f-5047-4b51-9f76-92d3afd7b6a5\",\n        \"userSecret\": \"2292b911-7688-42cc-9712-3f9ee47c41c8\",\n        \"xrDatatrack\": \"https://xr-nbs.myvu.cn/xr-datatrack\",\n        \"sArOta\": \"https://xr-nbs.myvu.cn/ar-ota\",\n        \"sAccountService\": \"https://xr-nbs.myvu.cn/account-service\",\n        \"sMyvuAuth\": \"https://gw.myvu.cn/auth\",\n        \"sNbsSurvey\": \"https://gw.myvu.cn/survey\",\n        \"sXrMenu\": \"https://xr-nbs.myvu.cn/xr-menu\",\n        \"sXrWeather\": \"https://xr-nbs.myvu.cn/xr-weather\",\n        \"sXrWeatherKm\": \"https://km.myvu.cn/xr-weather\",\n        \"sWeather\": \"https://xr-nbs.myvu.cn/weather\",\n        \"sWeatherKm\": \"https://km.myvu.cn/weather\",\n        \"sApisix\": \"https://xr-nbs.myvu.cn/auth\",\n        \"sApisixKm\": \"https://km.myvu.cn/auth\",\n        \"feedbackService\": \"https://gw.myvu.cn/feedback/client\",\n        \"cloudAdapterService\" : \"https://xr-nbs.myvu.cn/cloud-adapter\",\n        \"cloudCancelService\": \"https://account.flyme.cn/user/cancel\",\n        \"ak\": \"myvu-android\",\n        \"sk\": \"0716b566f23cd0e6\",\n        \"myvuConfigService\": \"https://xr-nbs.myvu.cn/myvu-config\",\n        \"myvuRecordService\": \"https://gw.myvu.cn/record\",\n        \"myvuFileService\": \"https://gw.myvu.cn/file\"\n    },\n    \"china_uat\": {\n        \"nbsUrl\": \"https://xr-nbs-uat.myvu.cn\",\n        \"kmUrl\": \"https://km-uat.myvu.cn\",\n        \"mixtureUrl\": \"https://mixture-uat.myvu.cn\",\n        \"surveyUrl\": \"https://survey-uat.myvu.cn\",\n        \"policyUrl\": \"https://policy.flyme.com\",\n        \"asrUrl\": \"wss://km-uat.myvu.cn/auth/central-manager/ws\",\n        \"aiRecordUrl\": \"https://airecords-uat.myvu.cn\",\n        \"appId\": \"IKSoISndT\",\n        \"userKey\": \"082eae5f-5047-4b51-9f76-92d3afd7b6a5\",\n        \"userSecret\": \"2292b911-7688-42cc-9712-3f9ee47c41c8\",\n        \"xrDatatrack\": \"https://xr-nbs-uat.myvu.cn/xr-datatrack\",\n        \"sArOta\": \"https://xr-nbs-uat.myvu.cn/ar-ota\",\n        \"sAccountService\": \"https://xr-nbs-uat.myvu.cn/account-service\",\n        \"sMyvuAuth\": \"https://gw-uat.myvu.cn/auth\",\n        \"sNbsSurvey\": \"https://gw-uat.myvu.cn/survey\",\n        \"sXrMenu\": \"https://xr-nbs-uat.myvu.cn/xr-menu\",\n        \"sXrWeather\": \"https://xr-nbs-uat.myvu.cn/xr-weather\",\n        \"sXrWeatherKm\": \"https://km-uat.myvu.cn/xr-weather\",\n        \"sWeather\": \"https://xr-nbs-uat.myvu.cn/weather\",\n        \"sWeatherKm\": \"https://km-uat.myvu.cn/weather\",\n        \"sApisix\": \"https://xr-nbs-uat.myvu.cn/auth\",\n        \"sApisixKm\": \"https://km-uat.myvu.cn/auth\",\n        \"feedbackService\": \"https://gw-uat.myvu.cn/feedback/client\",\n        \"cloudAdapterService\": \"https://xr-nbs-uat.myvu.cn/cloud-adapter\",\n        \"cloudCancelService\": \"https://account.flyme.cn/user/cancel\",\n        \"ak\": \"myvu-app\",\n        \"sk\": \"afc40ef9b01d8908\",\n        \"myvuConfigService\": \"https://xr-nbs-uat.myvu.cn/myvu-config\",\n        \"myvuRecordService\": \"https://gw-uat.myvu.cn/record\",\n        \"myvuFileService\": \"https://gw-uat.myvu.cn/file\"\n    },\n    \"intl_prod\": {\n        \"nbsUrl\": \"https://xr-nbs-global.myvu.cn\",\n        \"kmUrl\": \"https://kmglobal.myvu.cn\",\n        \"mixtureUrl\": \"https://mixture-global.myvu.cn\",\n        \"surveyUrl\": \"https://survey-global.myvu.cn\",\n        \"policyUrl\": \"https://policy-global.flyme.com\",\n        \"asrUrl\": \"wss://kmglobal.myvu.cn/auth/central-manager/ws\",\n        \"aiRecordUrl\": \"https://airecords-global.myvu.cn\",\n        \"appId\": \"elS8JURA\",\n        \"userKey\": \"a9fa9811-dfe2-461f-abeb-f80adbc4440f\",\n        \"userSecret\": \"d09b870d-c466-490a-81d9-b83153840b15\",\n        \"xrDatatrack\": \"https://xr-nbs-global.myvu.cn/xr-datatrack\",\n        \"sArOta\": \"https://xr-nbs-global.myvu.cn/ar-ota\",\n        \"sAccountService\": \"https://xr-nbs-global.myvu.cn/account-service\",\n        \"sMyvuAuth\": \"https://gw-global.myvu.cn/auth\",\n        \"sNbsSurvey\": \"https://gw-global.myvu.cn/survey\",\n        \"sXrMenu\": \"https://xr-nbs-global.myvu.cn/xr-menu\",\n        \"sXrWeather\": \"https://xr-nbs-global.myvu.cn/xr-weather\",\n        \"sXrWeatherKm\": \"https://kmglobal.myvu.cn/xr-weather\",\n        \"sWeather\": \"https://xr-nbs-global.myvu.cn/weather\",\n        \"sWeatherKm\": \"https://kmglobal.myvu.cn/weather\",\n        \"sApisix\": \"https://xr-nbs-global.myvu.cn/auth\",\n        \"sApisixKm\": \"https://kmglobal.myvu.cn/auth\",\n        \"feedbackService\": \"https://gw.myvu.cn/feedback/client\",\n        \"cloudAdapterService\": \"https://xr-nbs-global.myvu.cn/cloud-adapter\",\n        \"cloudCancelService\": \"https://account.in.meizu.com/usercancel\",\n        \"ak\": \"myvu-android\",\n        \"sk\": \"05993e4fc09d8922\",\n        \"myvuConfigService\": \"https://xr-nbs-global.myvu.cn/myvu-config\",\n        \"myvuRecordService\": \"https://gw.myvu.cn/record\",\n        \"myvuFileService\": \"https://gw.myvu.cn/file\"\n    },\n    \"intl_uat\": {\n        \"nbsUrl\": \"https://xr-nbs-global-uat.myvu.cn\",\n        \"kmUrl\": \"https://kmglobal-uat.myvu.cn\",\n        \"mixtureUrl\": \"https://mixture-global-uat.myvu.cn\",\n        \"surveyUrl\": \"https://survey-global-uat.myvu.cn\",\n        \"policyUrl\": \"https://policy-global.flyme.com\",\n        \"asrUrl\": \"wss://kmglobal-uat.myvu.cn/auth/central-manager/ws\",\n        \"aiRecordUrl\": \"https://airecords-global-uat.myvu.cn\",\n        \"appId\": \"XNS9EoTs\",\n        \"userKey\": \"05b59d2d-41b7-4f35-8a4d-a793ef28126b\",\n        \"userSecret\": \"3759dd24-71d7-42ea-9600-c133f4ac5651\",\n        \"xrDatatrack\": \"https://xr-nbs-global-uat.myvu.cn/xr-datatrack\",\n        \"sArOta\": \"https://xr-nbs-global-uat.myvu.cn/ar-ota\",\n        \"sAccountService\": \"https://xr-nbs-global-uat.myvu.cn/account-service\",\n        \"sMyvuAuth\": \"https://gw-global-uat.myvu.cn/auth\",\n        \"sNbsSurvey\": \"https://gw-global-uat.myvu.cn/survey\",\n        \"sXrMenu\": \"https://xr-nbs-global-uat.myvu.cn/xr-menu\",\n        \"sXrWeather\": \"https://xr-nbs-global-uat.myvu.cn/xr-weather\",\n        \"sXrWeatherKm\": \"https://kmglobal-uat.myvu.cn/xr-weather\",\n        \"sWeather\": \"https://xr-nbs-global-uat.myvu.cn/weather\",\n        \"sWeatherKm\": \"https://kmglobal-uat.myvu.cn/weather\",\n        \"sApisix\": \"https://xr-nbs-global-uat.myvu.cn/auth\",\n        \"sApisixKm\": \"https://kmglobal-uat.myvu.cn/auth\",\n        \"feedbackService\": \"https://gw.myvu.cn/feedback/client\",\n        \"cloudAdapterService\": \"https://xr-nbs-global-uat.myvu.cn/cloud-adapter\",\n        \"cloudCancelService\": \"https://account.in.meizu.com/usercancel\",\n        \"ak\": \"myvu-app\",\n        \"sk\": \"8124aaeeabc2d872\",\n        \"myvuConfigService\": \"https://xr-nbs-global-uat.myvu.cn/myvu-config\",\n        \"myvuRecordService\": \"https://gw-uat.myvu.cn/record\",\n        \"myvuFileService\": \"https://gw-uat.myvu.cn/file\"\n    }\n}").getJSONObject(companion.j());
        String optString = jSONObject.optString("appId");
        Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
        h = optString;
        String optString2 = jSONObject.optString("userKey");
        Intrinsics.checkNotNullExpressionValue(optString2, "optString(...)");
        f = optString2;
        String optString3 = jSONObject.optString("userSecret");
        Intrinsics.checkNotNullExpressionValue(optString3, "optString(...)");
        g = optString3;
        String optString4 = jSONObject.optString("ak");
        Intrinsics.checkNotNullExpressionValue(optString4, "optString(...)");
        i = optString4;
        String optString5 = jSONObject.optString("sk");
        Intrinsics.checkNotNullExpressionValue(optString5, "optString(...)");
        j = optString5;
    }

    public static final String t(String str) {
        return f6666a.v(str);
    }

    public static final String u() {
        return f6666a.w();
    }
}
