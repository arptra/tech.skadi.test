package com.android.dingtalk.openauth;

import a.a.a.a.a.a;
import a.a.a.a.a.b;
import a.a.a.a.a.e;
import android.content.Context;
import android.text.TextUtils;
import com.android.dingtalk.openauth.utils.DDAuthUtil;

public class DDAuthApi implements IDDAuthApi {
    public Context mContext;
    public AuthLoginParam mParam;

    public DDAuthApi(Context context, AuthLoginParam authLoginParam) {
        if (context == null) {
            throw new b("Context is null");
        } else if (authLoginParam != null) {
            this.mContext = context;
            this.mParam = authLoginParam;
        } else {
            throw new b("AuthLoginParam is null");
        }
    }

    public void authLogin() {
        Context applicationContext = this.mContext.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        String altSignature = this.mParam.getAltSignature();
        if (!DDAuthUtil.isDebug(applicationContext) || TextUtils.isEmpty(altSignature)) {
            altSignature = e.a(applicationContext, packageName);
        }
        if (DDAuthUtil.isDDSupportAPI(applicationContext)) {
            a.b(this.mContext, this.mParam, packageName, altSignature);
        } else {
            a.e(this.mContext, this.mParam, packageName, altSignature);
        }
    }
}
