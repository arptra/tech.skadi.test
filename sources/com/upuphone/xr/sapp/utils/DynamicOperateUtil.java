package com.upuphone.xr.sapp.utils;

import android.content.Context;
import androidx.collection.ArrayMapKt;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.honey.account.constant.AccountConstantKt;
import com.honey.account.view.web.WebJs;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.SuperAppServiceManager;
import com.upuphone.xr.interconnect.api.InfoOperator;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.datatrack.ReminderDataTrackEvent;
import com.upuphone.xr.sapp.monitor.starry.StarryMessageHelper;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b4\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u0003J\u000f\u0010\u000e\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0011\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0017J\u000f\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001c\u0010\u000fJ\u000f\u0010\u001d\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001d\u0010\u000fJ\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001e\u0010\u0007J\u0017\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001f\u0010\u0007J\u0017\u0010 \u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\"\u0010\u0007J!\u0010%\u001a\u0004\u0018\u00010\u00042\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0004H\u0002¢\u0006\u0004\b%\u0010&J\u001f\u0010)\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0004H\u0002¢\u0006\u0004\b)\u0010&J\u0017\u0010+\u001a\u00020\f2\b\u0010*\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b+\u0010,J\u0015\u0010.\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u0004¢\u0006\u0004\b.\u0010\u0007J\u0017\u0010/\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b/\u0010\u0007J\u001f\u00101\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u00100\u001a\u00020\b¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\u00020\f2\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b3\u0010,J\u0015\u00104\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b4\u0010,J\r\u00105\u001a\u00020\f¢\u0006\u0004\b5\u0010\u0003J\u001f\u00107\u001a\u0004\u0018\u00010\u00042\u0006\u00106\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004¢\u0006\u0004\b7\u0010&J\u001d\u00108\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b:\u0010;R\"\u0010@\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010<\u001a\u0004\b=\u0010\u000f\"\u0004\b>\u0010?R\"\u0010C\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\n\u0010<\u001a\u0004\bA\u0010\u000f\"\u0004\bB\u0010?R\"\u0010H\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010;\"\u0004\bG\u0010,R\"\u0010M\u001a\u00020\u00198\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b)\u0010I\u001a\u0004\bJ\u0010\u001b\"\u0004\bK\u0010LR\u0016\u0010P\u001a\u00020N8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u0010O¨\u0006Q"}, d2 = {"Lcom/upuphone/xr/sapp/utils/DynamicOperateUtil;", "", "<init>", "()V", "", "modelId", "l", "(Ljava/lang/String;)Ljava/lang/String;", "", "haveTici", "c", "(Z)Ljava/lang/String;", "", "D", "v", "()Z", "miniList", "b", "(Ljava/lang/String;)Z", "addData", "moreData", "appName", "k", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "o", "", "p", "()I", "t", "u", "i", "r", "s", "(Ljava/lang/String;)I", "x", "data", "key", "j", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "add", "more", "e", "glassDockId", "z", "(Ljava/lang/String;)V", "appPackage", "q", "m", "saveOldVersion", "A", "(Ljava/lang/String;Z)V", "H", "C", "w", "appList", "E", "y", "(Ljava/lang/String;Ljava/lang/String;)V", "f", "()Ljava/lang/String;", "Z", "getGlassVersionReady", "G", "(Z)V", "glassVersionReady", "g", "setGlassModelReady", "glassModelReady", "d", "Ljava/lang/String;", "getGlassModel", "setGlassModel", "glassModel", "I", "h", "F", "(I)V", "glassVersion", "Lcom/upuphone/xr/interconnect/api/InfoOperator;", "Lcom/upuphone/xr/interconnect/api/InfoOperator;", "infoOperator", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class DynamicOperateUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final DynamicOperateUtil f7880a = new DynamicOperateUtil();
    public static boolean b;
    public static boolean c;
    public static String d = "";
    public static int e;
    public static InfoOperator f;

    static {
        InfoOperator infoOperator = SuperAppServiceManager.getInstance().init(MainApplication.k.f().getPackageName()).getInfoOperator();
        Intrinsics.checkNotNullExpressionValue(infoOperator, "getInfoOperator(...)");
        f = infoOperator;
        infoOperator.getPeer().getVersion().subscribe(AnonymousClass1.INSTANCE);
    }

    public static /* synthetic */ void B(DynamicOperateUtil dynamicOperateUtil, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        dynamicOperateUtil.A(str, z);
    }

    public static /* synthetic */ String d(DynamicOperateUtil dynamicOperateUtil, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return dynamicOperateUtil.c(z);
    }

    public static /* synthetic */ String n(DynamicOperateUtil dynamicOperateUtil, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        return dynamicOperateUtil.m(str);
    }

    public final void A(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "miniList");
        ULog.Delegate delegate = ULog.f6446a;
        DynamicAdapterUtils dynamicAdapterUtils = DynamicAdapterUtils.f7879a;
        String a2 = dynamicAdapterUtils.a();
        delegate.g("DynamicOperateUtil", "saveMiniList getModelId=" + a2);
        String str2 = ModelIdExtKt.b(dynamicAdapterUtils.a()) ? "mini_desktop_air" : ModelIdExtKt.d(dynamicAdapterUtils.a()) ? "mini_desktop_air_pro" : "mini_desktop_star";
        DataStoreUtils.Companion companion = DataStoreUtils.e;
        companion.a().p(str2, str, true);
        if (z || !b(str)) {
            companion.a().p("app_list_saved_version", 0, true);
        } else {
            companion.a().p("app_list_saved_version", 1, true);
        }
    }

    public final void C(String str) {
        Intrinsics.checkNotNullParameter(str, "miniList");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(WebJs.ACTION, "change_dock_items");
        jsonObject.addProperty(AccountConstantKt.RESPONSE_VALUE, str);
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty(WebJs.ACTION, "system");
        jsonObject2.add("data", jsonObject);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("DynamicOperateUtil", "sendMiniListToGlass " + jsonObject2);
        StarryMessageHelper starryMessageHelper = StarryMessageHelper.f7799a;
        String jsonElement = jsonObject2.toString();
        Intrinsics.checkNotNullExpressionValue(jsonElement, "toString(...)");
        starryMessageHelper.k(jsonElement, new DynamicOperateUtil$sendMiniListToGlass$1());
        DataTrackUtil.f7875a.i(ReminderDataTrackEvent.APP_GLASSES_SETTING, MapsKt.toMap(ArrayMapKt.a(TuplesKt.to("applist_order", str))));
    }

    public final void D() {
        Object obj = new JSONObject(m(d)).get("added");
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
        String str = (String) obj;
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("DynamicOperateUtil", "sendStoreMiniListToGlass miniList: " + str);
        C(str);
    }

    public final String E(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "appList");
        Intrinsics.checkNotNullParameter(str2, "appName");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.o("DynamicOperateUtil", "setFirstAppToList  appLsit=" + str);
        if (str.length() == 0 || str2.length() == 0) {
            return str;
        }
        String j = j(str, "added");
        String j2 = j(str, "more");
        if (j == null || j.length() == 0) {
            return str;
        }
        if (j2 == null || j2.length() == 0) {
            j2 = "com.upuphone.star.launcher.universe";
        }
        return t() ? o(j, j2, str2) : k(j, j2, str2);
    }

    public final void F(int i) {
        e = i;
    }

    public final void G(boolean z) {
        b = z;
    }

    public final void H(String str) {
        Intrinsics.checkNotNullParameter(str, "modelId");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("DynamicOperateUtil", "updateGlassModel  modelId::" + str);
        c = true;
        d = str;
        if (b) {
            D();
        }
    }

    public final boolean b(String str) {
        if (str != null) {
            return StringsKt.contains$default((CharSequence) str, (CharSequence) "com.upuphone.ar.tici", false, 2, (Object) null);
        }
        return false;
    }

    public final String c(boolean z) {
        JSONObject jSONObject = new JSONObject();
        StringBuffer stringBuffer = new StringBuffer();
        Boolean bool = BuildConfig.b;
        Intrinsics.checkNotNullExpressionValue(bool, "THIRD_PLATFOM");
        if (bool.booleanValue()) {
            stringBuffer.append(AssistantConstants.PKG_NAME_MUSIC_PLAYER);
            stringBuffer.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML);
            stringBuffer.append(AssistantConstants.PKG_NAME_NAV);
            stringBuffer.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML);
            if (z) {
                stringBuffer.append("com.upuphone.ar.tici");
                stringBuffer.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML);
            }
            stringBuffer.append(AssistantConstants.PKG_NAME_TRANSLATION);
            stringBuffer.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML);
            DynamicAdapterUtils dynamicAdapterUtils = DynamicAdapterUtils.f7879a;
            if (ModelIdExtKt.d(dynamicAdapterUtils.a())) {
                stringBuffer.append("com.upuphone.ar.transcribe.glasses");
                stringBuffer.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML);
            }
            if (!BuildConfig.f6575a.booleanValue() && !ModelIdExtKt.d(dynamicAdapterUtils.a())) {
                stringBuffer.append("com.upuphone.xr.ringmanager");
                stringBuffer.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML);
            }
            stringBuffer.append("com.upuphone.star.launcher.setting");
            if (!ModelIdExtKt.b(dynamicAdapterUtils.a())) {
                stringBuffer.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML);
                stringBuffer.append("com.upuphone.star.launcher.user_guide");
            }
            jSONObject.put("added", stringBuffer.toString());
            stringBuffer.delete(0, stringBuffer.length());
            stringBuffer.append("com.upuphone.star.launcher.universe");
            jSONObject.put("more", stringBuffer.toString());
        } else {
            DynamicAdapterUtils dynamicAdapterUtils2 = DynamicAdapterUtils.f7879a;
            if (ModelIdExtKt.a(dynamicAdapterUtils2.a())) {
                stringBuffer.append(AssistantConstants.PKG_NAME_MUSIC_PLAYER);
                stringBuffer.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML);
                stringBuffer.append(AssistantConstants.PKG_NAME_NAV);
                stringBuffer.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML);
                if (z) {
                    stringBuffer.append("com.upuphone.ar.tici");
                    stringBuffer.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML);
                }
                stringBuffer.append(AssistantConstants.PKG_NAME_TRANSLATION);
                stringBuffer.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML);
                if (ModelIdExtKt.d(dynamicAdapterUtils2.a())) {
                    stringBuffer.append("com.upuphone.ar.transcribe.glasses");
                    stringBuffer.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML);
                }
                if (!BuildConfig.f6575a.booleanValue() && !ModelIdExtKt.d(dynamicAdapterUtils2.a())) {
                    stringBuffer.append("com.upuphone.xr.ringmanager");
                    stringBuffer.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML);
                }
                stringBuffer.append("com.upuphone.star.launcher.setting");
                if (ModelIdExtKt.d(dynamicAdapterUtils2.a())) {
                    stringBuffer.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML);
                    stringBuffer.append("com.upuphone.star.launcher.user_guide");
                }
                jSONObject.put("added", stringBuffer.toString());
                stringBuffer.delete(0, stringBuffer.length());
                stringBuffer.append("com.upuphone.star.launcher.universe");
                jSONObject.put("more", stringBuffer.toString());
            } else {
                stringBuffer.append(AssistantConstants.PKG_NAME_MUSIC_PLAYER);
                stringBuffer.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML);
                stringBuffer.append(AssistantConstants.PKG_NAME_NAV);
                stringBuffer.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML);
                stringBuffer.append(AssistantConstants.PKG_NAME_DOUYIN);
                stringBuffer.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML);
                stringBuffer.append(AssistantConstants.PKG_NAME_KUAISHOU);
                stringBuffer.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML);
                stringBuffer.append(AssistantConstants.PKG_NAME_TRANSLATION);
                stringBuffer.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML);
                if (z) {
                    stringBuffer.append("com.upuphone.ar.tici");
                    stringBuffer.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML);
                }
                if (!BuildConfig.f6575a.booleanValue() && !ModelIdExtKt.d(dynamicAdapterUtils2.a())) {
                    stringBuffer.append("com.upuphone.xr.ringmanager");
                    stringBuffer.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML);
                }
                stringBuffer.append("com.upuphone.star.launcher.setting");
                stringBuffer.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML);
                stringBuffer.append("com.upuphone.star.launcher.user_guide");
                jSONObject.put("added", stringBuffer.toString());
                stringBuffer.delete(0, stringBuffer.length());
                stringBuffer.append("com.upuphone.star.launcher.universe");
                jSONObject.put("more", stringBuffer.toString());
            }
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
        return jSONObject2;
    }

    public final String e(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("added", str);
        jSONObject.put("more", str2);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
        return jSONObject2;
    }

    public final String f() {
        String n = n(this, (String) null, 1, (Object) null);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.l("DynamicOperateUtil", "getFilterUpdateAppList  appLsit=" + n);
        if (!(n == null || n.length() == 0)) {
            String j = j(n, "added");
            String j2 = j(n, "more");
            if (!(j == null || j.length() == 0)) {
                if (j2 == null || j2.length() == 0) {
                    j2 = "com.upuphone.star.launcher.universe";
                }
                if (t() && u()) {
                    return e(i(j), j2);
                }
                if (t() && !u()) {
                    return e(r(j), j2);
                }
                if (!t()) {
                    return e(x(r(j)), j2);
                }
            }
        }
        return n;
    }

    public final boolean g() {
        return c;
    }

    public final int h() {
        return e;
    }

    public final String i(String str) {
        List list;
        if (str != null) {
            list = StringsKt.split$default((CharSequence) str, new String[]{MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML}, false, 0, 6, (Object) null);
        } else {
            list = null;
        }
        Intrinsics.checkNotNull(list, "null cannot be cast to non-null type java.util.ArrayList<kotlin.String>");
        ArrayList arrayList = (ArrayList) list;
        StringBuffer stringBuffer = new StringBuffer();
        int size = arrayList.size() - 1;
        if (size >= 0) {
            int i = 0;
            while (true) {
                Object obj = arrayList.get(i);
                Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                String str2 = (String) obj;
                if (AssistantConstants.PKG_NAME_MUSIC_PLAYER.equals(str2)) {
                    DataStoreUtils.e.a().p(AssistantConstants.PKG_NAME_MUSIC_PLAYER, Integer.valueOf(i), true);
                } else {
                    if ("com.upuphone.ar.transcribe.glasses".equals(str2)) {
                        DataStoreUtils.e.a().p("com.upuphone.ar.transcribe.glasses", Integer.valueOf(i), true);
                    }
                    stringBuffer.append(str2);
                    if (i < arrayList.size() - 1) {
                        stringBuffer.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML);
                    }
                }
                if (i == size) {
                    break;
                }
                i++;
            }
        }
        if (stringBuffer.length() - 1 == stringBuffer.lastIndexOf(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML)) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer2, "toString(...)");
        return stringBuffer2;
    }

    public final String j(String str, String str2) {
        try {
            JsonElement parseString = JsonParser.parseString(str);
            if (parseString instanceof JsonObject) {
                JsonObject jsonObject = (JsonObject) parseString;
                if (jsonObject.has(str2)) {
                    return jsonObject.get(str2).getAsString();
                }
            }
            return "";
        } catch (Exception e2) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.c("DynamicOperateUtil", "getKeyValue::e is: " + e2);
            return "";
        }
    }

    public final String k(String str, String str2, String str3) {
        List list;
        if (str != null) {
            list = StringsKt.split$default((CharSequence) str, new String[]{MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML}, false, 0, 6, (Object) null);
        } else {
            list = null;
        }
        Intrinsics.checkNotNull(list, "null cannot be cast to non-null type java.util.ArrayList<kotlin.String>");
        ArrayList arrayList = (ArrayList) list;
        arrayList.remove(str3);
        int i = 0;
        int intValue = ((Number) DataStoreUtils.j(DataStoreUtils.e.a(), str3, 0, true, (Context) null, 8, (Object) null)).intValue();
        ULog.f6446a.o("DynamicOperateUtil", "getLastestPositionAppList  addData=" + str + " appName=" + str3 + " appIndex=" + intValue);
        if (intValue == 0) {
            arrayList.add(0, str3);
        } else if (intValue >= arrayList.size()) {
            arrayList.add(str3);
        } else {
            arrayList.add(intValue, str3);
        }
        StringBuffer stringBuffer = new StringBuffer();
        int size = arrayList.size() - 1;
        if (size >= 0) {
            while (true) {
                Object obj = arrayList.get(i);
                Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                stringBuffer.append((String) obj);
                if (i < arrayList.size() - 1) {
                    stringBuffer.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML);
                }
                if (i == size) {
                    break;
                }
                i++;
            }
        }
        if (stringBuffer.length() - 1 == stringBuffer.lastIndexOf(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML)) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer2, "toString(...)");
        return e(stringBuffer2, str2);
    }

    public final String l(String str) {
        DynamicAdapterUtils dynamicAdapterUtils = DynamicAdapterUtils.f7879a;
        return (String) DataStoreUtils.j(DataStoreUtils.e.a(), ModelIdExtKt.b(dynamicAdapterUtils.a()) ? "mini_desktop_air" : ModelIdExtKt.d(dynamicAdapterUtils.a()) ? "mini_desktop_air_pro" : "mini_desktop_star", "", true, (Context) null, 8, (Object) null);
    }

    public final String m(String str) {
        Intrinsics.checkNotNullParameter(str, "modelId");
        String l = l(str);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("DynamicOperateUtil", "miniList : " + l);
        if ((!StringsKt.isBlank(l)) && StringsKt.contains$default((CharSequence) l, (CharSequence) "com.upuphone.xr.ringmanager", false, 2, (Object) null)) {
            Boolean bool = BuildConfig.f6575a;
            Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
            if (bool.booleanValue()) {
                l = "";
            }
        }
        if (e < 2) {
            if (!(!StringsKt.isBlank(l)) || !v() || b(l)) {
                delegate.g("DynamicOperateUtil", "old glass version need update list");
                String c2 = c(false);
                A(c2, true);
                return c2;
            }
            delegate.g("DynamicOperateUtil", "old glass version no need update list");
            return l;
        } else if (!StringsKt.isBlank(l) && !v() && b(l)) {
            return l;
        } else {
            delegate.g("DynamicOperateUtil", "miniList is null");
            String d2 = d(this, false, 1, (Object) null);
            B(this, d2, false, 2, (Object) null);
            return d2;
        }
    }

    public final String o(String str, String str2, String str3) {
        List list;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str3);
        stringBuffer.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML);
        if (str != null) {
            list = StringsKt.split$default((CharSequence) str, new String[]{MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML}, false, 0, 6, (Object) null);
        } else {
            list = null;
        }
        Intrinsics.checkNotNull(list, "null cannot be cast to non-null type java.util.ArrayList<kotlin.String>");
        ArrayList arrayList = (ArrayList) list;
        arrayList.remove(str3);
        int size = arrayList.size() - 1;
        if (size >= 0) {
            int i = 0;
            while (true) {
                stringBuffer.append((String) arrayList.get(i));
                stringBuffer.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML);
                if (i == size) {
                    break;
                }
                i++;
            }
        }
        if (stringBuffer.length() - 1 == stringBuffer.lastIndexOf(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML)) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer2, "toString(...)");
        return e(stringBuffer2, str2);
    }

    public final int p() {
        return ((Number) DataStoreUtils.j(DataStoreUtils.e.a(), "app_list_saved_version", 0, true, (Context) null, 8, (Object) null)).intValue();
    }

    public final String q(String str) {
        Intrinsics.checkNotNullParameter(str, "appPackage");
        int hashCode = str.hashCode();
        if (hashCode != -312782418) {
            if (hashCode != 465806113) {
                if (hashCode == 1640777725 && str.equals(AssistantConstants.PKG_NAME_TRANSLATION)) {
                    String string = GlobalExtKt.f().getString(R.string.translator);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    return string;
                }
            } else if (str.equals("com.upuphone.ar.transcribe.glasses")) {
                String string2 = GlobalExtKt.f().getString(R.string.app_transcribe);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                return string2;
            }
        } else if (str.equals("com.upuphone.ar.recorder")) {
            String string3 = GlobalExtKt.f().getString(R.string.app_recorder);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            return string3;
        }
        return "";
    }

    public final String r(String str) {
        List list;
        if (str != null) {
            list = StringsKt.split$default((CharSequence) str, new String[]{MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML}, false, 0, 6, (Object) null);
        } else {
            list = null;
        }
        Intrinsics.checkNotNull(list, "null cannot be cast to non-null type java.util.ArrayList<kotlin.String>");
        ArrayList arrayList = (ArrayList) list;
        StringBuffer stringBuffer = new StringBuffer();
        arrayList.remove(AssistantConstants.PKG_NAME_MUSIC_PLAYER);
        DataStoreUtils.Companion companion = DataStoreUtils.e;
        int i = 0;
        int intValue = ((Number) DataStoreUtils.j(companion.a(), AssistantConstants.PKG_NAME_MUSIC_PLAYER, 0, true, (Context) null, 8, (Object) null)).intValue();
        int intValue2 = ((Number) DataStoreUtils.j(companion.a(), "com.upuphone.ar.transcribe.glasses", 3, true, (Context) null, 8, (Object) null)).intValue();
        int s = s(str);
        ULog.f6446a.c("DynamicOperateUtil", "getShowMusic musicIndex=" + intValue + " transIndex=" + intValue2 + " curTransIndex=" + s);
        if (s == 0 && intValue <= intValue2) {
            intValue++;
        }
        if (intValue == 0) {
            arrayList.add(0, AssistantConstants.PKG_NAME_MUSIC_PLAYER);
        } else if (intValue >= arrayList.size()) {
            arrayList.add(AssistantConstants.PKG_NAME_MUSIC_PLAYER);
        } else {
            arrayList.add(intValue, AssistantConstants.PKG_NAME_MUSIC_PLAYER);
        }
        int size = arrayList.size() - 1;
        if (size >= 0) {
            while (true) {
                Object obj = arrayList.get(i);
                Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                stringBuffer.append((String) obj);
                if (i < arrayList.size() - 1) {
                    stringBuffer.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML);
                }
                if (i == size) {
                    break;
                }
                i++;
            }
        }
        if (stringBuffer.length() - 1 == stringBuffer.lastIndexOf(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML)) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer2, "toString(...)");
        return stringBuffer2;
    }

    public final int s(String str) {
        List list;
        if (str != null) {
            list = StringsKt.split$default((CharSequence) str, new String[]{MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML}, false, 0, 6, (Object) null);
        } else {
            list = null;
        }
        Intrinsics.checkNotNull(list, "null cannot be cast to non-null type java.util.ArrayList<kotlin.String>");
        ArrayList arrayList = (ArrayList) list;
        int size = arrayList.size() - 1;
        if (size >= 0) {
            int i = 0;
            while (true) {
                Object obj = arrayList.get(i);
                Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                if (!"com.upuphone.ar.transcribe.glasses".equals((String) obj)) {
                    if (i == size) {
                        break;
                    }
                    i++;
                } else {
                    return i;
                }
            }
        }
        return ((Number) DataStoreUtils.j(DataStoreUtils.e.a(), "com.upuphone.ar.transcribe.glasses", 3, true, (Context) null, 8, (Object) null)).intValue();
    }

    public final boolean t() {
        return ((Boolean) DataStoreUtils.j(DataStoreUtils.e.a(), "hearing_assist_status", Boolean.FALSE, true, (Context) null, 8, (Object) null)).booleanValue();
    }

    public final boolean u() {
        return ((Boolean) DataStoreUtils.j(DataStoreUtils.e.a(), "hearing_assist_music_status", Boolean.TRUE, true, (Context) null, 8, (Object) null)).booleanValue();
    }

    public final boolean v() {
        ULog.Delegate delegate = ULog.f6446a;
        int p = p();
        delegate.a("DynamicOperateUtil", "needUpdateAppList::getSavedAppListVersion() is: " + p + " and APP_LIST_VERSION is: 1");
        return 1 > p();
    }

    public final void w() {
        b = false;
        c = false;
    }

    public final String x(String str) {
        List list;
        int s = s(str);
        if (s != 0) {
            ULog.f6446a.c("DynamicOperateUtil", "resetTranscribePosition no need to reset ranscribe. transIndex=" + s);
            return str;
        }
        if (str != null) {
            list = StringsKt.split$default((CharSequence) str, new String[]{MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML}, false, 0, 6, (Object) null);
        } else {
            list = null;
        }
        Intrinsics.checkNotNull(list, "null cannot be cast to non-null type java.util.ArrayList<kotlin.String>");
        ArrayList arrayList = (ArrayList) list;
        StringBuffer stringBuffer = new StringBuffer();
        arrayList.remove("com.upuphone.ar.transcribe.glasses");
        int intValue = ((Number) DataStoreUtils.j(DataStoreUtils.e.a(), "com.upuphone.ar.transcribe.glasses", 3, true, (Context) null, 8, (Object) null)).intValue();
        ULog.f6446a.c("DynamicOperateUtil", "resetTranscribePosition transIndex=" + intValue);
        int i = 0;
        if (intValue == 0) {
            arrayList.add(0, "com.upuphone.ar.transcribe.glasses");
        } else if (intValue >= arrayList.size()) {
            arrayList.add("com.upuphone.ar.transcribe.glasses");
        } else {
            arrayList.add(intValue, "com.upuphone.ar.transcribe.glasses");
        }
        int size = arrayList.size() - 1;
        if (size >= 0) {
            while (true) {
                Object obj = arrayList.get(i);
                Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                stringBuffer.append((String) obj);
                if (i < arrayList.size() - 1) {
                    stringBuffer.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML);
                }
                if (i == size) {
                    break;
                }
                i++;
            }
        }
        if (stringBuffer.length() - 1 == stringBuffer.lastIndexOf(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML)) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer2, "toString(...)");
        return stringBuffer2;
    }

    public final void y(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "miniList");
        Intrinsics.checkNotNullParameter(str2, "appName");
        List split$default = StringsKt.split$default((CharSequence) str, new String[]{MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML}, false, 0, 6, (Object) null);
        Intrinsics.checkNotNull(split$default, "null cannot be cast to non-null type java.util.ArrayList<kotlin.String>");
        ArrayList arrayList = (ArrayList) split$default;
        int size = arrayList.size() - 1;
        if (size >= 0) {
            int i = 0;
            while (true) {
                Object obj = arrayList.get(i);
                Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                if (str2.equals((String) obj)) {
                    DataStoreUtils.e.a().p(str2, Integer.valueOf(i), true);
                }
                if (i != size) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public final void z(String str) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("DynamicOperateUtil", "receive glass dock ids, glassDockId:" + str);
        n(this, (String) null, 1, (Object) null);
    }
}
