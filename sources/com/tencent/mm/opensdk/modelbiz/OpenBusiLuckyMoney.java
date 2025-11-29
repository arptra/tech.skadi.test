package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;

public class OpenBusiLuckyMoney {

    public static class Req extends BaseReq {
        private static final int MAX_URL_LENGHT = 10240;
        public String appId;
        public String nonceStr;
        public String packageExt;
        public String signType;
        public String signature;
        public String timeStamp;

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
            r0 = r2.signType;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x002d, code lost:
            r2 = r2.signature;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
            r0 = r2.timeStamp;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0017, code lost:
            r0 = r2.nonceStr;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean checkArgs() {
            /*
                r2 = this;
                java.lang.String r0 = r2.appId
                r1 = 0
                if (r0 == 0) goto L_0x003a
                int r0 = r0.length()
                if (r0 > 0) goto L_0x000c
                goto L_0x003a
            L_0x000c:
                java.lang.String r0 = r2.timeStamp
                if (r0 == 0) goto L_0x003a
                int r0 = r0.length()
                if (r0 > 0) goto L_0x0017
                goto L_0x003a
            L_0x0017:
                java.lang.String r0 = r2.nonceStr
                if (r0 == 0) goto L_0x003a
                int r0 = r0.length()
                if (r0 > 0) goto L_0x0022
                goto L_0x003a
            L_0x0022:
                java.lang.String r0 = r2.signType
                if (r0 == 0) goto L_0x003a
                int r0 = r0.length()
                if (r0 > 0) goto L_0x002d
                goto L_0x003a
            L_0x002d:
                java.lang.String r2 = r2.signature
                if (r2 == 0) goto L_0x003a
                int r2 = r2.length()
                if (r2 > 0) goto L_0x0038
                goto L_0x003a
            L_0x0038:
                r2 = 1
                return r2
            L_0x003a:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.opensdk.modelbiz.OpenBusiLuckyMoney.Req.checkArgs():boolean");
        }

        public int getType() {
            return 13;
        }

        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_open_busi_lucky_money_appid", this.appId);
            bundle.putString("_wxapi_open_busi_lucky_money_timeStamp", this.timeStamp);
            bundle.putString("_wxapi_open_busi_lucky_money_nonceStr", this.nonceStr);
            bundle.putString("_wxapi_open_busi_lucky_money_signType", this.signType);
            bundle.putString("_wxapi_open_busi_lucky_money_signature", this.signature);
            bundle.putString("_wxapi_open_busi_lucky_money_package", this.packageExt);
        }
    }
}
