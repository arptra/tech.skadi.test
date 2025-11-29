package a.a.a.a.a;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.android.dingtalk.openauth.AuthLoginParam;
import com.android.dingtalk.openauth.utils.DDAuthConstant;
import com.android.dingtalk.openauth.utils.DDAuthUtil;
import com.android.dingtalk.openauth.web.AuthWebviewActivity;
import com.upuphone.runasone.uupcast.CaptureType;

public class a {
    public static String a(Uri uri, String str) {
        try {
            String queryParameter = uri.getQueryParameter(str);
            if (!TextUtils.isEmpty(queryParameter)) {
                return queryParameter;
            }
        } catch (Exception e) {
            c.a("get redirect uri parameter fail, key : " + str + ", exception : " + e.getLocalizedMessage());
        }
        c.a("get redirect uri parameter fail, key : " + str + ", return empty");
        return "";
    }

    public static boolean b(Context context, AuthLoginParam authLoginParam, String str, String str2) {
        return c(context, authLoginParam, str, str2, new Intent("android.intent.action.VIEW", Uri.parse(DDAuthConstant.DD_APP_AUTH_SCHEME)));
    }

    public static boolean c(Context context, AuthLoginParam authLoginParam, String str, String str2, Intent intent) {
        intent.putExtra(DDAuthConstant.EXTRA_MESSAGE_APP_PACKAGE_NAME, str);
        intent.putExtra(DDAuthConstant.EXTRA_MESSAGE_APP_SIGNATURE, str2);
        intent.putExtra(DDAuthConstant.EXTRA_MESSAGE_APP_ID, authLoginParam.getAppId());
        intent.putExtra(DDAuthConstant.EXTRA_MESSAGE_AUTH_LOGIN_URL, DDAuthUtil.getAuthLoginUrl(context));
        intent.putExtra(DDAuthConstant.EXTRA_MESSAGE_REDIRECT_URI, authLoginParam.getRedirectUri());
        intent.putExtra(DDAuthConstant.EXTRA_MESSAGE_STATE, authLoginParam.getState());
        intent.putExtra(DDAuthConstant.EXTRA_MESSAGE_NONCE, authLoginParam.getNonce());
        intent.putExtra(DDAuthConstant.EXTRA_MESSAGE_SCOPE, authLoginParam.getScope());
        intent.putExtra(DDAuthConstant.EXTRA_MESSAGE_RESPONSE_TYPE, authLoginParam.getResponseType());
        intent.putExtra(DDAuthConstant.EXTRA_MESSAGE_PROMPT, authLoginParam.getPrompt());
        intent.putExtra(DDAuthConstant.EXTRA_MESSAGE_SDK_VERSION, 20210101);
        intent.putExtra(DDAuthConstant.EXTRA_MESSAGE_DEBUG, DDAuthUtil.isDebug(context));
        if (DDAuthUtil.isDebug(context)) {
            for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 0)) {
                c.a("startActivity, info = " + resolveInfo.activityInfo);
            }
        }
        if (context instanceof Activity) {
            intent.setFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_ENABLE_MAGIC_WINDOW);
        } else {
            intent.setFlags(402653184);
        }
        try {
            context.startActivity(intent);
            c.a("startActivity success, intent : " + intent);
            return true;
        } catch (Exception e) {
            c.a("startActivity fail : " + e.getLocalizedMessage());
            return false;
        }
    }

    public static boolean d(Context context, String str, Uri uri, String str2) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(str, str + ".ddauth.DDAuthActivity"));
        intent.addFlags(335544320);
        intent.putExtra("authCode", a(uri, "authCode"));
        intent.putExtra("state", a(uri, "state"));
        intent.putExtra("error", a(uri, "error"));
        intent.putExtra("type", str2);
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException unused) {
            c.a("callback to 3rd app failed, 3rd app callbackActivity not found");
            return false;
        } catch (Exception e) {
            c.a("callback to 3rd app failed, exception : " + e.getLocalizedMessage());
            return false;
        }
    }

    public static boolean e(Context context, AuthLoginParam authLoginParam, String str, String str2) {
        return c(context, authLoginParam, str, str2, new Intent(context, AuthWebviewActivity.class));
    }
}
