package com.upuphone.star.launcher.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.upuphone.star.core.log.ULog;

public class WXEntryActivity extends Activity implements IWXAPIEventHandler {

    /* renamed from: a  reason: collision with root package name */
    public IWXAPI f6481a;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(this, "wxd24348f1821a2905");
        this.f6481a = createWXAPI;
        createWXAPI.handleIntent(getIntent(), this);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.f6481a.handleIntent(intent, this);
    }

    public void onReq(BaseReq baseReq) {
    }

    public void onResp(BaseResp baseResp) {
        ULog.i("WXEntryActivity", ">>>code = " + baseResp.errCode + ",type = " + baseResp.getType() + ",msg = " + baseResp.errStr);
        if (baseResp.getType() == 2) {
            Intent intent = new Intent("com.upuphone.star.launcher.action_share_result");
            if (baseResp.errCode == 0) {
                ULog.i("WXEntryActivity", "分享成功");
                intent.putExtra("share_success", true);
            } else {
                ULog.i("WXEntryActivity", "分享失败");
                intent.putExtra("share_success", false);
                intent.putExtra("error_msg", baseResp.errStr);
            }
            sendBroadcast(intent);
            finish();
        }
    }
}
