package com.upuphone.xr.account;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.honey.account.HoneyAccountManager;
import com.honey.account.OnAuthListener;
import com.honey.account.n7.a;
import com.honey.account.n7.b;
import com.upuphone.xr.account.domain.constant.XJAccountError;
import com.upuphone.xr.account.interfaces.MzAuthListener;
import com.upuphone.xr.account.interfaces.XJAbstractAuthenticator;
import com.upuphone.xr.account.interfaces.XJPasswordListener;

public class XJAuthenticator extends XJAbstractAuthenticator {
    private static final String TAG = "xjAuth-intl";

    public XJAuthenticator(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        super(context, str, str2, str3, str4, str5, str6);
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            Log.d(TAG, "XJAbstractAuthenticator: params error: url " + str + " key " + str2 + " secret " + str3 + " id " + str4);
            throw new IllegalArgumentException("XJAbstractAuthenticator init params is null");
        }
        HoneyAccountManager.init(context, "MEIZU", "KuyDUGUXdhGd3n5RQnP1", "KCtAChra1c3HS8n48oMKyhUyBf5RUJ", "i9XVkoEdqD7gsflVe4ZL", "RwdVkdnA9EQKna0HBDpMCDqtIstLsK", new b());
        Log.d(TAG, "XJAuthenticator: init Intl");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$new$0() {
        return false;
    }

    public void getMzAuthToken(Boolean bool, final MzAuthListener mzAuthListener) {
        HoneyAccountManager.getAuthToken(bool.booleanValue(), new OnAuthListener() {
            public void onError(int i, @NonNull String str) {
                Log.i(XJAuthenticator.TAG, "code:" + i + ", msg: " + str);
                mzAuthListener.onOriginalError(i, 10011, XJAccountError.info(10011, str));
            }

            public void onHandleIntent(@NonNull Intent intent) {
                mzAuthListener.onHandleIntent(intent);
            }

            public void onSuccess(String str) {
                Log.d(XJAuthenticator.TAG, "onSuccess: mz token is " + str);
                mzAuthListener.onSuccess(str);
            }
        });
    }

    public void isSetPassword(XJPasswordListener xJPasswordListener) {
        HoneyAccountManager.isSelfModifyPassword(new a(xJPasswordListener));
    }

    public void logout() {
        HoneyAccountManager.logout();
    }

    public void showWxLogin(Boolean bool) {
    }

    public Intent skipPasswordPageIntent() {
        return HoneyAccountManager.getSetPasswordIntent();
    }
}
