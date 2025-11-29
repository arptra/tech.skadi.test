package com.sina.weibo.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.meizu.common.widget.MzContactsContract;
import com.sina.weibo.sdk.a;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AccessTokenHelper;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.common.UiError;
import com.sina.weibo.sdk.openapi.IWBAPI;
import com.sina.weibo.sdk.openapi.SdkListener;
import com.sina.weibo.sdk.share.ShareTransActivity;
import com.sina.weibo.sdk.share.WbShareCallback;
import com.sina.weibo.sdk.web.WebData;
import com.upuphone.runasone.api.ApiConstant;
import sdk.meizu.account.factor.authentication.sdk.constant.ConstantKt;

public final class e0 implements IWBAPI {

    /* renamed from: a  reason: collision with root package name */
    public Context f9975a;
    public z b = new z();
    public h0 c = new h0();

    public e0(Context context) {
        this.f9975a = context;
    }

    public final void authorize(Activity activity, WbAuthListener wbAuthListener) {
        a.C0037a a2;
        z zVar = this.b;
        zVar.getClass();
        n.a(n.f9990a, "authorize()");
        if (wbAuthListener != null) {
            zVar.f10000a = wbAuthListener;
            if (!g0.b(activity) || (a2 = a.a(activity)) == null || a2.b < 2055) {
                zVar.b(activity);
            } else {
                zVar.a(activity);
            }
        } else {
            throw new RuntimeException("listener can not be null.");
        }
    }

    public final void authorizeCallback(Activity activity, int i, int i2, Intent intent) {
        z zVar = this.b;
        zVar.getClass();
        n.a(n.f9990a, "authorizeCallback()");
        WbAuthListener wbAuthListener = zVar.f10000a;
        if (wbAuthListener != null) {
            if (32973 != i) {
                wbAuthListener.onError(new UiError(-7, "request code is error", "requestCode is error"));
            } else if (i2 == -1) {
                if (intent != null) {
                    String stringExtra = intent.getStringExtra("error");
                    String stringExtra2 = intent.getStringExtra("error_type");
                    String stringExtra3 = intent.getStringExtra("error_description");
                    if (TextUtils.isEmpty(stringExtra) && TextUtils.isEmpty(stringExtra2) && TextUtils.isEmpty(stringExtra3)) {
                        Oauth2AccessToken parseAccessToken = Oauth2AccessToken.parseAccessToken(intent.getExtras());
                        if (parseAccessToken != null) {
                            AccessTokenHelper.writeAccessToken(activity, parseAccessToken);
                            zVar.f10000a.onComplete(parseAccessToken);
                            return;
                        }
                        zVar.f10000a.onError(new UiError(-4, "oauth2AccessToken is null", "oauth2AccessToken is null"));
                    } else if ("access_denied".equals(stringExtra) || "OAuthAccessDeniedException".equals(stringExtra)) {
                        zVar.f10000a.onCancel();
                    } else {
                        zVar.f10000a.onError(new UiError(-5, stringExtra2, stringExtra3));
                    }
                }
            } else if (i2 == 0) {
                wbAuthListener.onCancel();
            } else {
                wbAuthListener.onError(new UiError(-6, "result code is error", "result code is error"));
            }
        }
    }

    public final void authorizeClient(Activity activity, WbAuthListener wbAuthListener) {
        z zVar = this.b;
        zVar.getClass();
        n.a(n.f9990a, "authorizeClient()");
        if (wbAuthListener != null) {
            zVar.f10000a = wbAuthListener;
            zVar.a(activity);
            return;
        }
        throw new RuntimeException("listener can not be null.");
    }

    public final void authorizeWeb(Activity activity, WbAuthListener wbAuthListener) {
        z zVar = this.b;
        zVar.getClass();
        n.a(n.f9990a, "authorizeWeb()");
        if (wbAuthListener != null) {
            zVar.f10000a = wbAuthListener;
            zVar.b(activity);
            return;
        }
        throw new RuntimeException("listener can not be null.");
    }

    public final void doResultIntent(Intent intent, WbShareCallback wbShareCallback) {
        Bundle extras;
        this.c.getClass();
        if (intent != null && wbShareCallback != null && (extras = intent.getExtras()) != null) {
            try {
                int i = extras.getInt("_weibo_resp_errcode", -1);
                if (i == 0) {
                    wbShareCallback.onComplete();
                } else if (i == 1) {
                    wbShareCallback.onCancel();
                } else if (i == 2) {
                    wbShareCallback.onError(new UiError(i, extras.getString("_weibo_resp_errstr"), "error from weibo client!"));
                }
            } catch (Exception e) {
                wbShareCallback.onError(new UiError(-1, e.getMessage(), e.getMessage()));
            }
        }
    }

    public final boolean isAuthorizeResult(int i, int i2, Intent intent) {
        return i == 32973;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
        r0 = r3.getExtras();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isShareResult(int r1, int r2, android.content.Intent r3) {
        /*
            r0 = this;
            r0 = 10001(0x2711, float:1.4014E-41)
            if (r1 != r0) goto L_0x0016
            if (r3 == 0) goto L_0x0016
            android.os.Bundle r0 = r3.getExtras()
            if (r0 == 0) goto L_0x0016
            java.lang.String r1 = "_weibo_resp_errcode"
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L_0x0016
            r0 = 1
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.e0.isShareResult(int, int, android.content.Intent):boolean");
    }

    public final boolean isWBAppInstalled() {
        return g0.b(this.f9975a);
    }

    public final boolean isWBAppSupportMultipleImage() {
        return g0.a(this.f9975a);
    }

    public final void registerApp(Context context, AuthInfo authInfo, SdkListener sdkListener) {
        if (g0.f9981a) {
            return;
        }
        if (authInfo != null) {
            g0.b = authInfo;
            g0.f9981a = true;
            if (sdkListener != null) {
                sdkListener.onInitSuccess();
                return;
            }
            return;
        }
        throw new RuntimeException("authInfo must not be null.");
    }

    public final void setLoggerEnable(boolean z) {
        n.d = z;
    }

    public final void shareMessage(Activity activity, WeiboMultiMessage weiboMultiMessage, boolean z) {
        a.C0037a a2;
        h0 h0Var = this.c;
        h0Var.getClass();
        if (activity != null) {
            if (g0.b(activity) || !z) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - h0Var.f9982a >= 1000) {
                    h0Var.f9982a = currentTimeMillis;
                    if (z) {
                        h0.a(activity, weiboMultiMessage);
                        return;
                    }
                    a.C0037a a3 = a.a(activity);
                    if (g0.b(activity) && a3 != null && (a2 = a.a(activity)) != null && a2.b >= 2055) {
                        h0.a(activity, weiboMultiMessage);
                    } else if (g0.f9981a) {
                        AuthInfo authInfo = g0.b;
                        if (authInfo != null) {
                            String str = null;
                            WebData webData = new WebData(authInfo, 1, (String) null, (String) null);
                            String str2 = System.currentTimeMillis() + "";
                            String packageName = activity.getPackageName();
                            Oauth2AccessToken readAccessToken = AccessTokenHelper.readAccessToken(activity);
                            if (readAccessToken != null) {
                                String accessToken = readAccessToken.getAccessToken();
                                if (!TextUtils.isEmpty(readAccessToken.getAccessToken())) {
                                    str = accessToken;
                                }
                            }
                            Bundle bundle = new Bundle();
                            bundle.putParcelable("web_data", webData);
                            int i = webData.b;
                            if (i == 1) {
                                bundle.putInt("web_type", 1);
                            } else if (i == 2) {
                                bundle.putInt("web_type", 2);
                            } else if (i == 3) {
                                bundle.putInt("web_type", 3);
                            }
                            bundle.putString("_weibo_transaction", str2);
                            if (weiboMultiMessage != null) {
                                weiboMultiMessage.writeToBundle(bundle);
                            }
                            bundle.putString(ApiConstant.KEY_TOKEN, str);
                            bundle.putString(ConstantKt.FACTOR_PARAMS_PACKAGE_NAME, packageName);
                            Intent intent = new Intent(activity, ShareTransActivity.class);
                            intent.putExtra("start_flag", 1001);
                            intent.putExtra("start_web_activity", "com.sina.weibo.sdk.web.WebActivity");
                            intent.putExtras(bundle);
                            activity.startActivityForResult(intent, MzContactsContract.MzSearchSnippetColumns.SEARCH_WEIGHT_TOKENS);
                        }
                    } else {
                        throw new RuntimeException("please init sdk before use it. Wb.install()");
                    }
                }
            }
        }
    }

    public final void registerApp(Context context, AuthInfo authInfo) {
        registerApp(context, authInfo, (SdkListener) null);
    }
}
