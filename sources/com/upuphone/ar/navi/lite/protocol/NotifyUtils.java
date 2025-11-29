package com.upuphone.ar.navi.lite.protocol;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.android.dingtalk.openauth.utils.DDAuthConstant;
import com.honey.account.constant.AccountConstantKt;
import com.honey.account.view.web.WebJs;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel;
import com.upuphone.ar.navi.lite.R;
import com.upuphone.ar.navi.lite.util.CLog;
import com.upuphone.ar.navi.lite.util.NaviUtil;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import java.io.ByteArrayOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NotifyUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5798a = ("NAVI-" + NotifyUtils.class.getSimpleName());
    public static int b = 0;

    public static String a(Context context, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("title", NaviUtil.L(context.getApplicationContext(), R.string.navi_app_name));
            jSONObject3.put("content", str);
            jSONObject3.put("sendPackage", "com.upuphone.ar.navi.lite");
            jSONObject3.put("id", "phone-com.upuphone.ar.navi.glass-" + str2);
            jSONObject3.put("interactionPromptTxt", NaviUtil.L(context.getApplicationContext(), R.string.navi_dialog_confirm) + " / " + NaviUtil.L(context.getApplicationContext(), R.string.navi_dialog_cancel));
            jSONObject2.put("data", jSONObject3);
            jSONObject2.put("notificationAction", "SHOW_DIALOG");
            jSONObject.put("data", jSONObject2);
            jSONObject.put(WebJs.ACTION, "notification");
            String str3 = f5798a;
            CLog.b(str3, "createDialogMessage is:" + jSONObject.toString());
        } catch (JSONException e) {
            String str4 = f5798a;
            CLog.b(str4, "createDialogMessage e is:" + e);
        }
        return jSONObject.toString() + "";
    }

    public static String b(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("type", 1);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put("phone-com.upuphone.ar.navi.glass-" + str);
            jSONObject3.put("ids", jSONArray);
            jSONObject2.put("data", jSONObject3);
            jSONObject2.put("notificationAction", "DISMISS_NOTIFICATION");
            jSONObject.put("data", jSONObject2);
            jSONObject.put(WebJs.ACTION, "notification");
            String str2 = f5798a;
            CLog.b(str2, "createDialogMessage is:" + jSONObject.toString());
        } catch (JSONException e) {
            String str3 = f5798a;
            CLog.b(str3, "createDialogMessage e is:" + e);
        }
        return jSONObject.toString() + "";
    }

    public static String c(Context context, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(WebJs.ACTION, DDAuthConstant.AUTH_LOGIN_TYPE_APP);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("launchMode", f() == 1 ? "window" : FastRecordMainViewModel.RECORD_TYPE_SCENE);
            jSONObject2.put(WebJs.ACTION, "open_app");
            jSONObject2.put(AccountConstantKt.REQUEST_HEADER_PKG, AssistantConstants.PKG_NAME_NAV);
            jSONObject2.put("show_status_bar", false);
            jSONObject2.put("ext", str);
            jSONObject2.put("app_name", context.getApplicationContext().getString(R.string.navi_app_name));
            jSONObject.put("data", jSONObject2);
            String str2 = f5798a;
            CLog.b(str2, "createBaseData is:" + jSONObject.toString());
        } catch (JSONException e) {
            String str3 = f5798a;
            CLog.b(str3, "createBaseData e is:" + e);
        }
        return jSONObject.toString() + "";
    }

    public static String d(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("data", str);
            jSONObject2.put("notificationAction", "SHOW_TOAST");
            jSONObject.put("data", jSONObject2);
            jSONObject.put(WebJs.ACTION, "notification");
            String str2 = f5798a;
            CLog.b(str2, "createToastMessage is:" + jSONObject.toString());
        } catch (JSONException e) {
            String str3 = f5798a;
            CLog.b(str3, "createToastMessage e is:" + e);
        }
        return jSONObject.toString() + "";
    }

    public static byte[] e(Context context, int i) {
        try {
            Bitmap bitmap = ((BitmapDrawable) context.getDrawable(i)).getBitmap();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            String str = f5798a;
            CLog.b(str, "getIconBytes  Exception is:" + e);
            return new byte[0];
        }
    }

    public static int f() {
        return b;
    }

    public static void g(int i) {
        String str = f5798a;
        CLog.b(str, "setLaunchMode ######## launchMode:" + i);
        b = i;
    }
}
