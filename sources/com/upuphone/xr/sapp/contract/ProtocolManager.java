package com.upuphone.xr.sapp.contract;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.flyme.xjfms.ums.sign.jdk.dto.SignDTO;
import com.flyme.xjfms.ums.sign.jdk.service.SignServiceImpl;
import com.honey.account.constant.AccountConstantKt;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.config.NetConfig;
import com.upuphone.xr.sapp.contract.RegionsEntry;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 K2\u00020\u0001:\u0001NB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0003J/\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001c\u0010\u001bJ\u001f\u0010\u001e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\fH\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\fH\u0002¢\u0006\u0004\b\"\u0010!J\u000f\u0010#\u001a\u00020\fH\u0002¢\u0006\u0004\b#\u0010!J\u000f\u0010$\u001a\u00020\fH\u0002¢\u0006\u0004\b$\u0010!J\u000f\u0010%\u001a\u00020\fH\u0002¢\u0006\u0004\b%\u0010!J\u000f\u0010&\u001a\u00020\fH\u0002¢\u0006\u0004\b&\u0010!J\u000f\u0010'\u001a\u00020\fH\u0002¢\u0006\u0004\b'\u0010!J\u000f\u0010(\u001a\u00020\fH\u0002¢\u0006\u0004\b(\u0010!J\u000f\u0010)\u001a\u00020\fH\u0002¢\u0006\u0004\b)\u0010!J\u000f\u0010*\u001a\u00020\fH\u0002¢\u0006\u0004\b*\u0010!J\u000f\u0010+\u001a\u00020\fH\u0002¢\u0006\u0004\b+\u0010!J\u000f\u0010,\u001a\u00020\fH\u0002¢\u0006\u0004\b,\u0010!J\r\u0010-\u001a\u00020\u0004¢\u0006\u0004\b-\u0010\u0003J\u001d\u0010.\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b.\u0010/J\r\u00100\u001a\u00020\f¢\u0006\u0004\b0\u0010!J\r\u00101\u001a\u00020\f¢\u0006\u0004\b1\u0010!J\r\u00102\u001a\u00020\f¢\u0006\u0004\b2\u0010!J\r\u00104\u001a\u000203¢\u0006\u0004\b4\u00105J\u0015\u00106\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b6\u0010\u001bJ\u0015\u00109\u001a\u0002032\u0006\u00108\u001a\u000207¢\u0006\u0004\b9\u0010:R\u001b\u0010=\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b.\u0010;\u001a\u0004\b<\u0010!R\u001b\u0010A\u001a\u00020>8BX\u0002¢\u0006\f\n\u0004\b#\u0010;\u001a\u0004\b?\u0010@R\u001b\u0010C\u001a\u00020>8BX\u0002¢\u0006\f\n\u0004\b$\u0010;\u001a\u0004\bB\u0010@R\u001b\u0010E\u001a\u00020>8BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010;\u001a\u0004\bD\u0010@R\u001b\u0010G\u001a\u00020>8BX\u0002¢\u0006\f\n\u0004\b0\u0010;\u001a\u0004\bF\u0010@R\u001b\u0010I\u001a\u00020>8BX\u0002¢\u0006\f\n\u0004\b \u0010;\u001a\u0004\bH\u0010@R\u001b\u0010M\u001a\u00020J8BX\u0002¢\u0006\f\n\u0004\b\"\u0010;\u001a\u0004\bK\u0010L¨\u0006O"}, d2 = {"Lcom/upuphone/xr/sapp/contract/ProtocolManager;", "", "<init>", "()V", "", "F", "t", "n", "v", "k", "Lcom/upuphone/xr/sapp/contract/ProtocolType;", "protocolType", "", "appId", "signId", "Lokhttp3/Callback;", "callback", "L", "(Lcom/upuphone/xr/sapp/contract/ProtocolType;Ljava/lang/String;Ljava/lang/String;Lokhttp3/Callback;)V", "", "reqTime", "d", "(JLjava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "language", "A", "(Ljava/lang/String;)Ljava/lang/String;", "z", "(Lcom/upuphone/xr/sapp/contract/ProtocolType;)Ljava/lang/String;", "x", "defUrl", "C", "(Lcom/upuphone/xr/sapp/contract/ProtocolType;Ljava/lang/String;)Ljava/lang/String;", "f", "()Ljava/lang/String;", "g", "b", "c", "r", "s", "D", "E", "p", "q", "i", "j", "H", "a", "(Lcom/upuphone/xr/sapp/contract/ProtocolType;Lokhttp3/Callback;)V", "e", "y", "B", "", "J", "()Z", "I", "Landroid/content/Context;", "context", "K", "(Landroid/content/Context;)Z", "Lkotlin/Lazy;", "m", "GET_POLICY_URL", "Lcom/upuphone/xr/sapp/contract/ProtocolInfoRequestCallback;", "l", "()Lcom/upuphone/xr/sapp/contract/ProtocolInfoRequestCallback;", "flymePolicyCallback", "G", "myvuPolicyCallback", "u", "glassStarPolicyCallback", "o", "glassAirPolicyCallback", "w", "glassViewPolicyCallback", "Lokhttp3/OkHttpClient;", "h", "()Lokhttp3/OkHttpClient;", "client", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ProtocolManager {
    public static final Companion h = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final Lazy f6702a = LazyKt.lazy(ProtocolManager$GET_POLICY_URL$2.INSTANCE);
    public final Lazy b = LazyKt.lazy(ProtocolManager$flymePolicyCallback$2.INSTANCE);
    public final Lazy c = LazyKt.lazy(ProtocolManager$myvuPolicyCallback$2.INSTANCE);
    public final Lazy d = LazyKt.lazy(ProtocolManager$glassStarPolicyCallback$2.INSTANCE);
    public final Lazy e = LazyKt.lazy(ProtocolManager$glassAirPolicyCallback$2.INSTANCE);
    public final Lazy f = LazyKt.lazy(ProtocolManager$glassViewPolicyCallback$2.INSTANCE);
    public final Lazy g = LazyKt.lazy(ProtocolManager$client$2.INSTANCE);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/upuphone/xr/sapp/contract/ProtocolManager$Companion;", "", "()V", "GLASS_STAR_ID_VALUE", "", "GLASS_STAR_SIGN_VALUE", "POLICY_TITLE", "POLICY_URL", "POLICY_VERSION", "TAG", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|1|2|3|4|5|6|7|8|9|10|11|12|13|15) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.upuphone.xr.sapp.contract.ProtocolType[] r0 = com.upuphone.xr.sapp.contract.ProtocolType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.upuphone.xr.sapp.contract.ProtocolType r1 = com.upuphone.xr.sapp.contract.ProtocolType.GLASS_AIR_PP     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.upuphone.xr.sapp.contract.ProtocolType r1 = com.upuphone.xr.sapp.contract.ProtocolType.GLASS_AIR_UP     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.upuphone.xr.sapp.contract.ProtocolType r1 = com.upuphone.xr.sapp.contract.ProtocolType.GLASS_VIEW_PP     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.upuphone.xr.sapp.contract.ProtocolType r1 = com.upuphone.xr.sapp.contract.ProtocolType.GLASS_VIEW_UP     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.upuphone.xr.sapp.contract.ProtocolType r1 = com.upuphone.xr.sapp.contract.ProtocolType.CATEGORY_UP     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.upuphone.xr.sapp.contract.ProtocolType r1 = com.upuphone.xr.sapp.contract.ProtocolType.CATEGORY_PP     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.contract.ProtocolManager.WhenMappings.<clinit>():void");
        }
    }

    public final String A(String str) {
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
        if (Intrinsics.areEqual((Object) str, (Object) regionsSA2.getLanguage())) {
            return regionsSA2.value();
        }
        if (Intrinsics.areEqual((Object) str, (Object) RegionsEntry.RegionsSA.IN_ID.getLanguage())) {
            return RegionsEntry.RegionsSA.ID_ID.value();
        }
        RegionsEntry.RegionsOS regionsOS5 = RegionsEntry.RegionsOS.KO_KR;
        if (Intrinsics.areEqual((Object) str, (Object) regionsOS5.getLanguage())) {
            return regionsOS5.value();
        }
        RegionsEntry.RegionsOS regionsOS6 = RegionsEntry.RegionsOS.JA_JP;
        return Intrinsics.areEqual((Object) str, (Object) regionsOS6.getLanguage()) ? regionsOS6.value() : regionsOS2.value();
    }

    public final String B() {
        String country = GlobalExtKt.f().getResources().getConfiguration().locale.getCountry();
        Intrinsics.checkNotNull(country);
        return country;
    }

    public final String C(ProtocolType protocolType, String str) {
        switch (WhenMappings.$EnumSwitchMapping$0[protocolType.ordinal()]) {
            case 1:
            case 3:
                return b();
            case 2:
            case 4:
                return c();
            case 5:
                return g();
            case 6:
                return f();
            default:
                return str;
        }
    }

    public final String D() {
        return RegionsEntry.APP_PP.MY_MM.getPp();
    }

    public final String E() {
        return RegionsEntry.APP_UP.MY_MM.getUp();
    }

    public final void F() {
        ProtocolType protocolType = ProtocolType.CATEGORY_AIUP;
        NetConfig.Companion companion = NetConfig.f6666a;
        L(protocolType, companion.e(), companion.h(), G());
        L(ProtocolType.CATEGORY_AIPP, companion.e(), companion.h(), G());
        L(ProtocolType.CATEGORY_UP, companion.e(), companion.h(), G());
        L(ProtocolType.CATEGORY_PP, companion.e(), companion.h(), G());
        L(ProtocolType.CATEGORY_AIGCIN, companion.e(), companion.h(), G());
        L(ProtocolType.CATEGORY_PCPI, companion.e(), companion.h(), G());
        L(ProtocolType.CATEGORY_PICL, companion.e(), companion.h(), G());
        L(ProtocolType.CATEGORY_TISL, companion.e(), companion.h(), G());
        L(ProtocolType.CATEGORY_UEIP, companion.e(), companion.h(), G());
    }

    public final ProtocolInfoRequestCallback G() {
        return (ProtocolInfoRequestCallback) this.c.getValue();
    }

    public final void H() {
        F();
        t();
        n();
        v();
        k();
    }

    public final String I(ProtocolType protocolType) {
        Intrinsics.checkNotNullParameter(protocolType, "protocolType");
        String str = (String) DataStoreUtils.i(DataStoreUtils.e.a(), protocolType.getStoreKey(), "", (Context) null, 4, (Object) null);
        String y = y();
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("ProtocolManager", "[protocolType] protocolType->" + protocolType + "  localLanguage()=" + y);
        String z = z(protocolType);
        if (z.length() > 0) {
            return "file:////android_asset/" + z;
        }
        String x = x(protocolType);
        if (x.length() > 0) {
            return "file:////android_asset/" + x;
        }
        if (str.length() > 0) {
            try {
                String optString = new JSONObject(str).optString("policy_url");
                String C = C(protocolType, "");
                delegate.a("ProtocolManager", "[protocolType] url->" + optString + "  \nlocalUrl->" + C);
                if (K(GlobalExtKt.f()) || C.length() <= 0) {
                    Intrinsics.checkNotNull(optString);
                    return optString;
                }
                delegate.a("ProtocolManager", "[protocolType] load local url.");
                return "file:////android_asset/" + C;
            } catch (Exception e2) {
                ULog.Delegate delegate2 = ULog.f6446a;
                delegate2.a("ProtocolManager", "[protocolType] JSONObject Exception->" + e2);
            }
        }
        String C2 = C(protocolType, "");
        return "file:////android_asset/" + C2;
    }

    public final boolean J() {
        String str = (String) DataStoreUtils.i(DataStoreUtils.e.a(), "privacy_argreement_latest_region_key", "", (Context) null, 4, (Object) null);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("ProtocolManager", "[isModeLatestRegionAgree] region->" + str);
        if (Intrinsics.areEqual((Object) str, (Object) RegionsEntry.RegionsSA.TH_TH.getRegion()) ? true : Intrinsics.areEqual((Object) str, (Object) RegionsEntry.RegionsSA.ID_ID.getRegion())) {
            return true;
        }
        return Intrinsics.areEqual((Object) str, (Object) RegionsEntry.RegionsSA.FIL_PH.getRegion());
    }

    public final boolean K(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable();
    }

    public final void L(ProtocolType protocolType, String str, String str2, Callback callback) {
        long currentTimeMillis = System.currentTimeMillis();
        Request.Builder builder = new Request.Builder();
        String m = m();
        String bindKey = protocolType.getBindKey();
        Request.Builder addHeader = builder.url(m + "?category=" + bindKey).addHeader("X-brand", "XJ_AD");
        String str3 = Build.BRAND;
        Intrinsics.checkNotNullExpressionValue(str3, "BRAND");
        h().newCall(addHeader.addHeader("X-model", str3).addHeader("X-os-version", String.valueOf(Build.VERSION.SDK_INT)).addHeader("X-version-name", e()).addHeader("appId", str).addHeader("appSign", d(currentTimeMillis, str, str2)).addHeader("reqTime", String.valueOf(currentTimeMillis)).addHeader("X-client-language", y()).get().build()).enqueue(callback);
    }

    public final void a(ProtocolType protocolType, Callback callback) {
        Intrinsics.checkNotNullParameter(protocolType, "protocolType");
        Intrinsics.checkNotNullParameter(callback, "callback");
        long currentTimeMillis = System.currentTimeMillis();
        Request.Builder builder = new Request.Builder();
        String m = m();
        String bindKey = protocolType.getBindKey();
        Request.Builder addHeader = builder.url(m + "?category=" + bindKey).addHeader("X-brand", "XJ_AD");
        String str = Build.BRAND;
        Intrinsics.checkNotNullExpressionValue(str, "BRAND");
        Request.Builder addHeader2 = addHeader.addHeader("X-model", str).addHeader("X-os-version", String.valueOf(Build.VERSION.SDK_INT)).addHeader("X-version-name", e());
        NetConfig.Companion companion = NetConfig.f6666a;
        h().newCall(addHeader2.addHeader("appId", companion.e()).addHeader("appSign", d(currentTimeMillis, companion.e(), companion.h())).addHeader("reqTime", String.valueOf(currentTimeMillis)).addHeader("X-client-language", y()).get().build()).enqueue(callback);
    }

    public final String b() {
        Boolean bool = BuildConfig.f6575a;
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        if (!bool.booleanValue()) {
            return RegionsEntry.GLASS_PP.ZH_CN.getPp();
        }
        String y = y();
        return Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsZH.ZH_CN.value()) ? RegionsEntry.GLASS_PP.ZH_INTL.getPp() : Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsOS.MS_MY.value()) ? RegionsEntry.GLASS_PP.MS_MY.getPp() : Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsOS.MY_MM.value()) ? RegionsEntry.GLASS_PP.MY_MM.getPp() : Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsOS.VI_VN.value()) ? RegionsEntry.GLASS_PP.VI_VN.getPp() : Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsSA.TH_TH.value()) ? RegionsEntry.GLASS_PP.TH_TH.getPp() : Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsSA.ID_ID.value()) ? RegionsEntry.GLASS_PP.ID_ID.getPp() : Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsSA.FIL_PH.value()) ? RegionsEntry.GLASS_PP.FIL_PH.getPp() : Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsEU.DE_DE.value()) ? RegionsEntry.GLASS_PP.DE_DE.getPp() : Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsEU.FR_FR.value()) ? RegionsEntry.GLASS_PP.FR_FR.getPp() : Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsEU.IT_IT.value()) ? RegionsEntry.GLASS_PP.IT_IT.getPp() : Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsEA.TR_TR.value()) ? RegionsEntry.GLASS_PP.TR_TR.getPp() : Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsOS.KO_KR.value()) ? RegionsEntry.GLASS_PP.KO_KR.getPp() : Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsOS.JA_JP.value()) ? RegionsEntry.GLASS_PP.JA_JP.getPp() : RegionsEntry.GLASS_PP.EN_INTL.getPp();
    }

    public final String c() {
        Boolean bool = BuildConfig.f6575a;
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        if (!bool.booleanValue()) {
            return RegionsEntry.GLASS_UP.ZH_CN.getUp();
        }
        String y = y();
        return Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsZH.ZH_CN.value()) ? RegionsEntry.GLASS_UP.ZH_INTL.getUp() : Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsOS.MS_MY.value()) ? RegionsEntry.GLASS_UP.MS_MY.getUp() : Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsOS.MY_MM.value()) ? RegionsEntry.GLASS_UP.MY_MM.getUp() : Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsOS.VI_VN.value()) ? RegionsEntry.GLASS_UP.VI_VN.getUp() : Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsSA.TH_TH.value()) ? RegionsEntry.GLASS_UP.TH_TH.getUp() : Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsSA.ID_ID.value()) ? RegionsEntry.GLASS_UP.ID_ID.getUp() : Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsSA.FIL_PH.value()) ? RegionsEntry.GLASS_UP.FIL_PH.getUp() : Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsEU.DE_DE.value()) ? RegionsEntry.GLASS_UP.DE_DE.getUp() : Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsEU.FR_FR.value()) ? RegionsEntry.GLASS_UP.FR_FR.getUp() : Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsEU.IT_IT.value()) ? RegionsEntry.GLASS_UP.IT_IT.getUp() : Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsEA.TR_TR.value()) ? RegionsEntry.GLASS_UP.TR_TR.getUp() : Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsOS.KO_KR.value()) ? RegionsEntry.GLASS_UP.KO_KR.getUp() : Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsOS.JA_JP.value()) ? RegionsEntry.GLASS_UP.JA_JP.getUp() : RegionsEntry.GLASS_UP.en_INTL.getUp();
    }

    public final String d(long j, String str, String str2) {
        String a2 = new SignServiceImpl().a(new SignDTO(str, str2, Long.valueOf(j)));
        Intrinsics.checkNotNullExpressionValue(a2, "getSign(...)");
        return a2;
    }

    public final String e() {
        try {
            PackageManager packageManager = GlobalExtKt.f().getPackageManager();
            Intrinsics.checkNotNullExpressionValue(packageManager, "getPackageManager(...)");
            PackageInfo packageInfo = packageManager.getPackageInfo(GlobalExtKt.f().getPackageName(), 0);
            Intrinsics.checkNotNullExpressionValue(packageInfo, "getPackageInfo(...)");
            String str = packageInfo.versionName;
            Intrinsics.checkNotNullExpressionValue(str, "versionName");
            return str;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public final String f() {
        Boolean bool = BuildConfig.f6575a;
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        if (!bool.booleanValue()) {
            return RegionsEntry.APP_PP.ZH_CN.getPp();
        }
        String y = y();
        return Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsZH.ZH_CN.value()) ? RegionsEntry.APP_PP.ZH_INTL.getPp() : Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsOS.MS_MY.value()) ? RegionsEntry.APP_PP.MS_MY.getPp() : Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsOS.MY_MM.value()) ? RegionsEntry.APP_PP.MY_MM.getPp() : Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsOS.VI_VN.value()) ? RegionsEntry.APP_PP.VI_VN.getPp() : Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsSA.TH_TH.value()) ? RegionsEntry.APP_PP.TH_TH.getPp() : Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsSA.ID_ID.value()) ? RegionsEntry.APP_PP.ID_ID.getPp() : Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsSA.FIL_PH.value()) ? RegionsEntry.APP_PP.FIL_PH.getPp() : Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsEU.DE_DE.value()) ? RegionsEntry.APP_PP.DE_DE.getPp() : Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsEU.FR_FR.value()) ? RegionsEntry.APP_PP.FR_FR.getPp() : Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsEU.IT_IT.value()) ? RegionsEntry.APP_PP.IT_IT.getPp() : Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsEA.TR_TR.value()) ? RegionsEntry.APP_PP.TR_TR.getPp() : Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsOS.KO_KR.value()) ? RegionsEntry.APP_PP.KO_KR.getPp() : Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsOS.JA_JP.value()) ? RegionsEntry.APP_PP.JA_JP.getPp() : RegionsEntry.APP_PP.EN_INTL.getPp();
    }

    public final String g() {
        Boolean bool = BuildConfig.f6575a;
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        if (!bool.booleanValue()) {
            return RegionsEntry.APP_UP.ZH_CN.getUp();
        }
        String y = y();
        return Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsZH.ZH_CN.value()) ? RegionsEntry.APP_UP.ZH_INTL.getUp() : Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsOS.MS_MY.value()) ? RegionsEntry.APP_UP.MS_MY.getUp() : Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsOS.MY_MM.value()) ? RegionsEntry.APP_UP.MY_MM.getUp() : Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsOS.VI_VN.value()) ? RegionsEntry.APP_UP.VI_VN.getUp() : Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsSA.TH_TH.value()) ? RegionsEntry.APP_UP.TH_TH.getUp() : Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsSA.ID_ID.value()) ? RegionsEntry.APP_UP.ID_ID.getUp() : Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsSA.FIL_PH.value()) ? RegionsEntry.APP_UP.FIL_PH.getUp() : Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsEU.DE_DE.value()) ? RegionsEntry.APP_UP.DE_DE.getUp() : Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsEU.FR_FR.value()) ? RegionsEntry.APP_UP.FR_FR.getUp() : Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsEU.IT_IT.value()) ? RegionsEntry.APP_UP.IT_IT.getUp() : Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsEA.TR_TR.value()) ? RegionsEntry.APP_UP.TR_TR.getUp() : Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsOS.KO_KR.value()) ? RegionsEntry.APP_UP.KO_KR.getUp() : Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsOS.JA_JP.value()) ? RegionsEntry.APP_UP.JA_JP.getUp() : RegionsEntry.APP_UP.EN_INTL.getUp();
    }

    public final OkHttpClient h() {
        return (OkHttpClient) this.g.getValue();
    }

    public final String i() {
        return RegionsEntry.APP_PP.FIL_PH.getPp();
    }

    public final String j() {
        return RegionsEntry.APP_UP.FIL_PH.getUp();
    }

    public final void k() {
        ProtocolType protocolType = ProtocolType.ACCOUNT_AUP;
        NetConfig.Companion companion = NetConfig.f6666a;
        L(protocolType, companion.a(), companion.b(), l());
        L(ProtocolType.ACCOUNT_PP, companion.a(), companion.b(), l());
        L(ProtocolType.ACCOUNT_PCPI, companion.a(), companion.b(), l());
        L(ProtocolType.ACCOUNT_PICL, companion.a(), companion.b(), l());
        L(ProtocolType.ACCOUNT_TISL, companion.a(), companion.b(), l());
    }

    public final ProtocolInfoRequestCallback l() {
        return (ProtocolInfoRequestCallback) this.b.getValue();
    }

    public final String m() {
        return (String) this.f6702a.getValue();
    }

    public final void n() {
        ProtocolType protocolType = ProtocolType.GLASS_AIR_UP;
        NetConfig.Companion companion = NetConfig.f6666a;
        L(protocolType, companion.k(), companion.l(), o());
        L(ProtocolType.GLASS_AIR_PP, companion.k(), companion.l(), o());
        L(ProtocolType.GLASS_AIR_PCPI, companion.k(), companion.l(), o());
        L(ProtocolType.GLASS_AIR_PICL, companion.k(), companion.l(), o());
        L(ProtocolType.GLASS_AIR_TISL, companion.k(), companion.l(), o());
    }

    public final ProtocolInfoRequestCallback o() {
        return (ProtocolInfoRequestCallback) this.e.getValue();
    }

    public final String p() {
        return RegionsEntry.GLASS_PP.FIL_PH.getPp();
    }

    public final String q() {
        return RegionsEntry.GLASS_UP.FIL_PH.getUp();
    }

    public final String r() {
        return RegionsEntry.GLASS_PP.MY_MM.getPp();
    }

    public final String s() {
        return RegionsEntry.GLASS_UP.MY_MM.getUp();
    }

    public final void t() {
        L(ProtocolType.GLASS_STAR_UP, "36152120683616089700", "afb122a91138414fbaffd3735fd8b767", u());
        L(ProtocolType.GLASS_STAR_PP, "36152120683616089700", "afb122a91138414fbaffd3735fd8b767", u());
        L(ProtocolType.GLASS_STAR_PCPI, "36152120683616089700", "afb122a91138414fbaffd3735fd8b767", u());
        L(ProtocolType.GLASS_STAR_PICL, "36152120683616089700", "afb122a91138414fbaffd3735fd8b767", u());
        L(ProtocolType.GLASS_STAR_TISL, "36152120683616089700", "afb122a91138414fbaffd3735fd8b767", u());
    }

    public final ProtocolInfoRequestCallback u() {
        return (ProtocolInfoRequestCallback) this.d.getValue();
    }

    public final void v() {
        ProtocolType protocolType = ProtocolType.GLASS_VIEW_UP;
        NetConfig.Companion companion = NetConfig.f6666a;
        L(protocolType, companion.m(), companion.n(), w());
        L(ProtocolType.GLASS_VIEW_PP, companion.m(), companion.n(), w());
        L(ProtocolType.GLASS_VIEW_PCPI, companion.m(), companion.n(), w());
        L(ProtocolType.GLASS_VIEW_PICL, companion.m(), companion.n(), w());
        L(ProtocolType.GLASS_VIEW_TISL, companion.m(), companion.n(), w());
    }

    public final ProtocolInfoRequestCallback w() {
        return (ProtocolInfoRequestCallback) this.f.getValue();
    }

    public final String x(ProtocolType protocolType) {
        String y = y();
        Boolean bool = BuildConfig.f6575a;
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        if (!bool.booleanValue() || !Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsSA.FIL_PH.value())) {
            return "";
        }
        switch (WhenMappings.$EnumSwitchMapping$0[protocolType.ordinal()]) {
            case 1:
                return p();
            case 2:
                return q();
            case 3:
                return p();
            case 4:
                return q();
            case 5:
                return j();
            case 6:
                return i();
            default:
                return "";
        }
    }

    public final String y() {
        Locale locale = GlobalExtKt.f().getResources().getConfiguration().locale;
        String language = locale.getLanguage();
        String country = locale.getCountry();
        String str = language + AccountConstantKt.DEFAULT_SEGMENT + country;
        ContractEntry contractEntry = ContractEntry.f6691a;
        if (contractEntry.m()) {
            return contractEntry.h();
        }
        if (Intrinsics.areEqual((Object) country, (Object) "KR")) {
            language = "ko";
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
        return A(language);
    }

    public final String z(ProtocolType protocolType) {
        String y = y();
        Boolean bool = BuildConfig.f6575a;
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        if (!bool.booleanValue() || !Intrinsics.areEqual((Object) y, (Object) RegionsEntry.RegionsOS.MY_MM.value())) {
            return "";
        }
        switch (WhenMappings.$EnumSwitchMapping$0[protocolType.ordinal()]) {
            case 1:
                return r();
            case 2:
                return s();
            case 3:
                return r();
            case 4:
                return s();
            case 5:
                return E();
            case 6:
                return D();
            default:
                return "";
        }
    }
}
