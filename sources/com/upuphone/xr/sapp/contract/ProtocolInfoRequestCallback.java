package com.upuphone.xr.sapp.contract;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.config.NetConfig;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00172\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0015\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0015\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0019\u0010\u0018J\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0015\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001a\u0010\u0018J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0015\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\u0018J\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0015\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001b\u0010\u0018J\u001f\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010\u001e\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010 ¨\u0006\""}, d2 = {"Lcom/upuphone/xr/sapp/contract/ProtocolInfoRequestCallback;", "Lokhttp3/Callback;", "", "category", "<init>", "(Ljava/lang/String;)V", "Lokhttp3/Call;", "call", "Ljava/io/IOException;", "e", "", "onFailure", "(Lokhttp3/Call;Ljava/io/IOException;)V", "Lokhttp3/Response;", "response", "onResponse", "(Lokhttp3/Call;Lokhttp3/Response;)V", "Lorg/json/JSONObject;", "json", "g", "(Lorg/json/JSONObject;)V", "policyCategory", "Lcom/upuphone/xr/sapp/contract/ProtocolType;", "b", "(Ljava/lang/String;)Lcom/upuphone/xr/sapp/contract/ProtocolType;", "d", "c", "f", "h", "(Ljava/lang/String;Lokhttp3/Call;)V", "a", "(Ljava/lang/String;Ljava/lang/String;)Lcom/upuphone/xr/sapp/contract/ProtocolType;", "Ljava/lang/String;", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ProtocolInfoRequestCallback implements Callback {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f6701a;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/contract/ProtocolInfoRequestCallback$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public ProtocolInfoRequestCallback(String str) {
        Intrinsics.checkNotNullParameter(str, "category");
        this.f6701a = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0033, code lost:
        if (r2.equals("llm") == false) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0051, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return f(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002a, code lost:
        if (r2.equals(com.upuphone.xr.sapp.contract.ProtocolCategory.MYVU) == false) goto L_0x0051;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.upuphone.xr.sapp.contract.ProtocolType a(java.lang.String r2, java.lang.String r3) {
        /*
            r1 = this;
            int r0 = r2.hashCode()
            switch(r0) {
                case -1076361931: goto L_0x0049;
                case -1076283000: goto L_0x003b;
                case 107245: goto L_0x002d;
                case 3367275: goto L_0x0024;
                case 97536331: goto L_0x0016;
                case 1350734343: goto L_0x0008;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x0051
        L_0x0008:
            java.lang.String r0 = "glass_air"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x0011
            goto L_0x0051
        L_0x0011:
            com.upuphone.xr.sapp.contract.ProtocolType r1 = r1.c(r3)
            goto L_0x0057
        L_0x0016:
            java.lang.String r0 = "flyme"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x001f
            goto L_0x0051
        L_0x001f:
            com.upuphone.xr.sapp.contract.ProtocolType r1 = r1.b(r3)
            goto L_0x0057
        L_0x0024:
            java.lang.String r0 = "myvu"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x0036
            goto L_0x0051
        L_0x002d:
            java.lang.String r0 = "llm"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x0036
            goto L_0x0051
        L_0x0036:
            com.upuphone.xr.sapp.contract.ProtocolType r1 = r1.f(r3)
            goto L_0x0057
        L_0x003b:
            java.lang.String r0 = "glass_view"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x0044
            goto L_0x0051
        L_0x0044:
            com.upuphone.xr.sapp.contract.ProtocolType r1 = r1.e(r3)
            goto L_0x0057
        L_0x0049:
            java.lang.String r0 = "glass_star"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x0053
        L_0x0051:
            r1 = 0
            goto L_0x0057
        L_0x0053:
            com.upuphone.xr.sapp.contract.ProtocolType r1 = r1.d(r3)
        L_0x0057:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.contract.ProtocolInfoRequestCallback.a(java.lang.String, java.lang.String):com.upuphone.xr.sapp.contract.ProtocolType");
    }

    public final ProtocolType b(String str) {
        ProtocolType protocolType = ProtocolType.ACCOUNT_AUP;
        if (Intrinsics.areEqual((Object) str, (Object) protocolType.getBindKey())) {
            return protocolType;
        }
        ProtocolType protocolType2 = ProtocolType.ACCOUNT_PP;
        if (Intrinsics.areEqual((Object) str, (Object) protocolType2.getBindKey())) {
            return protocolType2;
        }
        ProtocolType protocolType3 = ProtocolType.ACCOUNT_TISL;
        if (Intrinsics.areEqual((Object) str, (Object) protocolType3.getBindKey())) {
            return protocolType3;
        }
        ProtocolType protocolType4 = ProtocolType.ACCOUNT_PICL;
        if (Intrinsics.areEqual((Object) str, (Object) protocolType4.getBindKey())) {
            return protocolType4;
        }
        ProtocolType protocolType5 = ProtocolType.ACCOUNT_PCPI;
        if (Intrinsics.areEqual((Object) str, (Object) protocolType5.getBindKey())) {
            return protocolType5;
        }
        return null;
    }

    public final ProtocolType c(String str) {
        ProtocolType protocolType = ProtocolType.GLASS_AIR_UP;
        if (Intrinsics.areEqual((Object) str, (Object) protocolType.getBindKey())) {
            return protocolType;
        }
        ProtocolType protocolType2 = ProtocolType.GLASS_AIR_PP;
        if (Intrinsics.areEqual((Object) str, (Object) protocolType2.getBindKey())) {
            return protocolType2;
        }
        ProtocolType protocolType3 = ProtocolType.GLASS_AIR_TISL;
        if (Intrinsics.areEqual((Object) str, (Object) protocolType3.getBindKey())) {
            return protocolType3;
        }
        ProtocolType protocolType4 = ProtocolType.GLASS_AIR_PICL;
        if (Intrinsics.areEqual((Object) str, (Object) protocolType4.getBindKey())) {
            return protocolType4;
        }
        ProtocolType protocolType5 = ProtocolType.GLASS_AIR_PCPI;
        if (Intrinsics.areEqual((Object) str, (Object) protocolType5.getBindKey())) {
            return protocolType5;
        }
        return null;
    }

    public final ProtocolType d(String str) {
        ProtocolType protocolType = ProtocolType.GLASS_STAR_UP;
        if (Intrinsics.areEqual((Object) str, (Object) protocolType.getBindKey())) {
            return protocolType;
        }
        ProtocolType protocolType2 = ProtocolType.GLASS_STAR_PP;
        if (Intrinsics.areEqual((Object) str, (Object) protocolType2.getBindKey())) {
            return protocolType2;
        }
        ProtocolType protocolType3 = ProtocolType.GLASS_STAR_TISL;
        if (Intrinsics.areEqual((Object) str, (Object) protocolType3.getBindKey())) {
            return protocolType3;
        }
        ProtocolType protocolType4 = ProtocolType.GLASS_STAR_PICL;
        if (Intrinsics.areEqual((Object) str, (Object) protocolType4.getBindKey())) {
            return protocolType4;
        }
        ProtocolType protocolType5 = ProtocolType.GLASS_STAR_PCPI;
        if (Intrinsics.areEqual((Object) str, (Object) protocolType5.getBindKey())) {
            return protocolType5;
        }
        return null;
    }

    public final ProtocolType e(String str) {
        ProtocolType protocolType = ProtocolType.GLASS_VIEW_UP;
        if (Intrinsics.areEqual((Object) str, (Object) protocolType.getBindKey())) {
            return protocolType;
        }
        ProtocolType protocolType2 = ProtocolType.GLASS_VIEW_PP;
        if (Intrinsics.areEqual((Object) str, (Object) protocolType2.getBindKey())) {
            return protocolType2;
        }
        ProtocolType protocolType3 = ProtocolType.GLASS_VIEW_TISL;
        if (Intrinsics.areEqual((Object) str, (Object) protocolType3.getBindKey())) {
            return protocolType3;
        }
        ProtocolType protocolType4 = ProtocolType.GLASS_VIEW_PICL;
        if (Intrinsics.areEqual((Object) str, (Object) protocolType4.getBindKey())) {
            return protocolType4;
        }
        ProtocolType protocolType5 = ProtocolType.GLASS_VIEW_PCPI;
        if (Intrinsics.areEqual((Object) str, (Object) protocolType5.getBindKey())) {
            return protocolType5;
        }
        return null;
    }

    public final ProtocolType f(String str) {
        ProtocolType protocolType = ProtocolType.CATEGORY_AIUP;
        if (Intrinsics.areEqual((Object) str, (Object) protocolType.getBindKey())) {
            return protocolType;
        }
        ProtocolType protocolType2 = ProtocolType.CATEGORY_AIPP;
        if (Intrinsics.areEqual((Object) str, (Object) protocolType2.getBindKey())) {
            return protocolType2;
        }
        ProtocolType protocolType3 = ProtocolType.CATEGORY_UP;
        if (Intrinsics.areEqual((Object) str, (Object) protocolType3.getBindKey())) {
            return protocolType3;
        }
        ProtocolType protocolType4 = ProtocolType.CATEGORY_PP;
        if (Intrinsics.areEqual((Object) str, (Object) protocolType4.getBindKey())) {
            return protocolType4;
        }
        ProtocolType protocolType5 = ProtocolType.CATEGORY_TISL;
        if (Intrinsics.areEqual((Object) str, (Object) protocolType5.getBindKey())) {
            return protocolType5;
        }
        ProtocolType protocolType6 = ProtocolType.CATEGORY_UEIP;
        if (Intrinsics.areEqual((Object) str, (Object) protocolType6.getBindKey())) {
            return protocolType6;
        }
        ProtocolType protocolType7 = ProtocolType.CATEGORY_PICL;
        if (Intrinsics.areEqual((Object) str, (Object) protocolType7.getBindKey())) {
            return protocolType7;
        }
        ProtocolType protocolType8 = ProtocolType.CATEGORY_PCPI;
        if (Intrinsics.areEqual((Object) str, (Object) protocolType8.getBindKey())) {
            return protocolType8;
        }
        ProtocolType protocolType9 = ProtocolType.CATEGORY_AIGCIN;
        if (Intrinsics.areEqual((Object) str, (Object) protocolType9.getBindKey())) {
            return protocolType9;
        }
        return null;
    }

    public final void g(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject.getJSONObject("data").getJSONObject("data");
        Object obj = jSONObject2.get("policyUrl");
        Object obj2 = jSONObject2.get("version");
        String string = jSONObject2.getString("category");
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("policy_version", obj2);
        jSONObject3.put("policy_url", obj);
        String str = this.f6701a;
        Intrinsics.checkNotNull(string);
        ProtocolType a2 = a(str, string);
        if (a2 != null) {
            jSONObject3.put("policy_title", GlobalExtKt.h(a2.getTitleRes()));
            ULog.Delegate delegate = ULog.f6446a;
            String storeKey = a2.getStoreKey();
            delegate.g("RequestPrivacyInfoCallback", "持久化->" + storeKey + ", 数据->" + jSONObject3);
            DataStoreUtils.e.a().o(a2.getStoreKey(), jSONObject3.toString());
        }
    }

    public final void h(String str, Call call) {
        try {
            String s = NetConfig.f6666a.s();
            ProtocolType a2 = a(str, StringsKt.replace$default(call.request().url().toString(), s + "/internal/v1/policy?category=", "", false, 4, (Object) null));
            if (a2 != null) {
                DataStoreUtils.e.a().o(a2.getStoreKey(), "");
            }
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.c("RequestPrivacyInfoCallback", "resetProtocolUrl()->  e->" + e);
        }
    }

    public void onFailure(Call call, IOException iOException) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(iOException, "e");
        ULog.Delegate delegate = ULog.f6446a;
        String str = this.f6701a;
        Request request = call.request();
        delegate.g("RequestPrivacyInfoCallback", "onFailure()-> 请求协议信息->" + str + ", request->" + request + " failed, e->" + iOException);
    }

    public void onResponse(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        ULog.Delegate delegate = ULog.f6446a;
        String str = this.f6701a;
        Request request = call.request();
        int code = response.code();
        delegate.g("RequestPrivacyInfoCallback", "onResponse()-> 请求协议信息->" + str + ", request->" + request + ", response code->" + code);
        try {
            if (response.code() == 200) {
                ResponseBody body = response.body();
                Intrinsics.checkNotNull(body);
                String string = body.string();
                String str2 = this.f6701a;
                delegate.g("RequestPrivacyInfoCallback", "onResponse()-> 请求协议信息->" + str2 + ", res->" + string);
                JSONObject jSONObject = new JSONObject(string);
                if (jSONObject.getInt("code") == 200) {
                    g(jSONObject);
                } else {
                    h(this.f6701a, call);
                }
            } else {
                h(this.f6701a, call);
            }
        } catch (Exception e) {
            ULog.Delegate delegate2 = ULog.f6446a;
            String str3 = this.f6701a;
            Request request2 = call.request();
            delegate2.c("RequestPrivacyInfoCallback", "onResponse()-> 请求协议信息->" + str3 + ", request->" + request2 + " failed, e->" + e);
        }
    }
}
