package com.upuphone.myvu.myvu_share_plugin;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import androidx.core.content.FileProvider;
import com.honey.account.constant.AccountConstantKt;
import com.sina.weibo.sdk.openapi.IWBAPI;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.upuphone.runasone.uupcast.CaptureType;
import com.xingin.xhssharesdk.XhsShareSdkTools;
import com.xingin.xhssharesdk.callback.XhsShareRegisterCallback;
import com.xingin.xhssharesdk.core.XhsShareSdk;
import com.xingin.xhssharesdk.model.config.XhsShareGlobalConfig;
import com.xingin.xhssharesdk.model.other.VersionCheckResult;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0016\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JA\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0018\u0010\u0019J-\u0010\u001c\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ-\u0010!\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r¢\u0006\u0004\b!\u0010\"J\u0019\u0010$\u001a\u00020\r2\b\u0010#\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0011H\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b(\u0010)J\u001f\u0010+\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\rH\u0002¢\u0006\u0004\b+\u0010,¨\u0006-"}, d2 = {"Lcom/upuphone/myvu/myvu_share_plugin/ShareUtil;", "", "<init>", "()V", "", "platformCode", "Landroid/content/Context;", "context", "Lcom/tencent/mm/opensdk/openapi/IWXAPI;", "wxapi", "Lcom/sina/weibo/sdk/openapi/IWBAPI;", "wbapi", "", "", "e", "(ILandroid/content/Context;Lcom/tencent/mm/opensdk/openapi/IWXAPI;Lcom/sina/weibo/sdk/openapi/IWBAPI;)Ljava/util/Map;", "appId", "", "h", "(Ljava/lang/String;Lcom/tencent/mm/opensdk/openapi/IWXAPI;)Z", "appKey", "Lcom/xingin/xhssharesdk/callback/XhsShareRegisterCallback;", "callback", "", "g", "(Ljava/lang/String;Landroid/content/Context;Lcom/xingin/xhssharesdk/callback/XhsShareRegisterCallback;)V", "imagePath", "scene", "j", "(Lcom/tencent/mm/opensdk/openapi/IWXAPI;Ljava/lang/String;ILandroid/content/Context;)V", "path", "pkg", "cls", "i", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "type", "a", "(Ljava/lang/String;)Ljava/lang/String;", "b", "()Z", "c", "(Lcom/tencent/mm/opensdk/openapi/IWXAPI;)Z", "imgPath", "d", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;", "myvu_share_plugin_release"}, k = 1, mv = {1, 7, 1})
public final class ShareUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final ShareUtil f6433a = new ShareUtil();

    public static /* synthetic */ Map f(ShareUtil shareUtil, int i, Context context, IWXAPI iwxapi, IWBAPI iwbapi, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            iwxapi = null;
        }
        if ((i2 & 8) != 0) {
            iwbapi = null;
        }
        return shareUtil.e(i, context, iwxapi, iwbapi);
    }

    public final String a(String str) {
        if (str == null) {
            return String.valueOf(System.currentTimeMillis());
        }
        long currentTimeMillis = System.currentTimeMillis();
        return str + currentTimeMillis;
    }

    public final boolean b() {
        return true;
    }

    public final boolean c(IWXAPI iwxapi) {
        return iwxapi.getWXAppSupportAPI() >= 654314752;
    }

    public final String d(Context context, String str) {
        String packageName = context.getPackageName();
        Uri uriForFile = FileProvider.getUriForFile(context, packageName + ".shareFileProvider", new File(str));
        context.grantUriPermission("com.tencent.mm", uriForFile, 1);
        String uri = uriForFile.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "contentUri.toString()");
        return uri;
    }

    public final Map e(int i, Context context, IWXAPI iwxapi, IWBAPI iwbapi) {
        Intrinsics.checkNotNullParameter(context, "context");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (i != SharePlatform.qq.ordinal()) {
            if (i == SharePlatform.sinaWeiBo.ordinal()) {
                if (iwbapi != null) {
                    if (iwbapi.isWBAppInstalled()) {
                        linkedHashMap.put("isSupport", Boolean.TRUE);
                    } else {
                        linkedHashMap.put("isSupport", Boolean.FALSE);
                        linkedHashMap.put("error", "分享失败，未安装微博");
                    }
                }
            } else if (i == SharePlatform.littleRedBook.ordinal()) {
                VersionCheckResult isSupportShareNote = XhsShareSdkTools.isSupportShareNote(context);
                Intrinsics.checkNotNullExpressionValue(isSupportShareNote, "isSupportShareNote(context)");
                int i2 = isSupportShareNote.checkResultCode;
                if (i2 == -2) {
                    linkedHashMap.put("isSupport", Boolean.FALSE);
                    linkedHashMap.put("error", "分享失败，小红书版本过低");
                } else if (i2 == -1) {
                    linkedHashMap.put("isSupport", Boolean.FALSE);
                    linkedHashMap.put("error", "分享失败，未安装小红书");
                } else if (i2 == 0) {
                    linkedHashMap.put("isSupport", Boolean.TRUE);
                }
            } else if ((i == SharePlatform.wechatSession.ordinal() || i == SharePlatform.wechatTimeline.ordinal()) && iwxapi != null) {
                if (iwxapi.isWXAppInstalled()) {
                    linkedHashMap.put("isSupport", Boolean.TRUE);
                } else {
                    linkedHashMap.put("isSupport", Boolean.FALSE);
                    linkedHashMap.put("error", "分享失败，未安装微信");
                }
            }
        }
        return linkedHashMap;
    }

    public final void g(String str, Context context, XhsShareRegisterCallback xhsShareRegisterCallback) {
        Intrinsics.checkNotNullParameter(str, "appKey");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(xhsShareRegisterCallback, "callback");
        XhsShareGlobalConfig enableLog = new XhsShareGlobalConfig().setClearCacheWhenShareComplete(true).setEnableLog(true);
        String packageName = context.getPackageName();
        XhsShareSdk.registerApp(context, str, enableLog.setFileProviderAuthority(packageName + ".shareFileProvider"), xhsShareRegisterCallback);
    }

    public final boolean h(String str, IWXAPI iwxapi) {
        Intrinsics.checkNotNullParameter(str, "appId");
        Intrinsics.checkNotNullParameter(iwxapi, "wxapi");
        return iwxapi.registerApp(str);
    }

    public final void i(Context context, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "path");
        Intrinsics.checkNotNullParameter(str2, AccountConstantKt.REQUEST_HEADER_PKG);
        Intrinsics.checkNotNullParameter(str3, "cls");
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(str2, str3));
            intent.setAction("android.intent.action.SEND");
            intent.setFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
            String packageName = context.getPackageName();
            intent.putExtra("android.intent.extra.STREAM", FileProvider.getUriForFile(context, packageName + ".shareFileProvider", new File(str)));
            intent.setType("image/*");
            context.startActivity(intent);
        } catch (Exception e) {
            String message = e.getMessage();
            Log.e("ShareUtil", "系统分享失败,error:" + message);
        }
    }

    public final void j(IWXAPI iwxapi, String str, int i, Context context) {
        Intrinsics.checkNotNullParameter(iwxapi, "wxapi");
        Intrinsics.checkNotNullParameter(str, "imagePath");
        Intrinsics.checkNotNullParameter(context, "context");
        WXImageObject wXImageObject = new WXImageObject();
        if (!c(iwxapi) || !b()) {
            wXImageObject.setImagePath(str);
        } else {
            wXImageObject.setImagePath(d(context, str));
        }
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = a("img");
        req.message = wXMediaMessage;
        req.scene = i;
        iwxapi.sendReq(req);
    }
}
