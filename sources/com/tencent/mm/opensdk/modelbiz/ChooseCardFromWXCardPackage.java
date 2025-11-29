package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;

public class ChooseCardFromWXCardPackage {
    private static final String TAG = "MicroMsg.ChooseCardFromWXCardPackage";

    public static class Req extends BaseReq {
        public String appId;
        public String canMultiSelect;
        public String cardId;
        public String cardSign;
        public String cardType;
        public String locationId;
        public String nonceStr;
        public String signType;
        public String timeStamp;

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
            r0 = r2.signType;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0017, code lost:
            r2 = r2.cardSign;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean checkArgs() {
            /*
                r2 = this;
                java.lang.String r0 = r2.appId
                r1 = 0
                if (r0 == 0) goto L_0x0024
                int r0 = r0.length()
                if (r0 > 0) goto L_0x000c
                goto L_0x0024
            L_0x000c:
                java.lang.String r0 = r2.signType
                if (r0 == 0) goto L_0x0024
                int r0 = r0.length()
                if (r0 > 0) goto L_0x0017
                goto L_0x0024
            L_0x0017:
                java.lang.String r2 = r2.cardSign
                if (r2 == 0) goto L_0x0024
                int r2 = r2.length()
                if (r2 > 0) goto L_0x0022
                goto L_0x0024
            L_0x0022:
                r2 = 1
                return r2
            L_0x0024:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.opensdk.modelbiz.ChooseCardFromWXCardPackage.Req.checkArgs():boolean");
        }

        public int getType() {
            return 16;
        }

        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_choose_card_from_wx_card_app_id", this.appId);
            bundle.putString("_wxapi_choose_card_from_wx_card_location_id", this.locationId);
            bundle.putString("_wxapi_choose_card_from_wx_card_sign_type", this.signType);
            bundle.putString("_wxapi_choose_card_from_wx_card_card_sign", this.cardSign);
            bundle.putString("_wxapi_choose_card_from_wx_card_time_stamp", this.timeStamp);
            bundle.putString("_wxapi_choose_card_from_wx_card_nonce_str", this.nonceStr);
            bundle.putString("_wxapi_choose_card_from_wx_card_card_id", this.cardId);
            bundle.putString("_wxapi_choose_card_from_wx_card_card_type", this.cardType);
            bundle.putString("_wxapi_choose_card_from_wx_card_can_multi_select", this.canMultiSelect);
        }
    }

    public static class Resp extends BaseResp {
        public String cardItemList;

        public Resp() {
        }

        public boolean checkArgs() {
            String str = this.cardItemList;
            return (str == null || str.length() == 0) ? false : true;
        }

        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            String string = bundle.getString("_wxapi_choose_card_from_wx_card_list");
            if (string == null || string.length() <= 0) {
                Log.i(ChooseCardFromWXCardPackage.TAG, "cardItemList is empty!");
            } else {
                this.cardItemList = string;
            }
        }

        public int getType() {
            return 16;
        }

        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_choose_card_from_wx_card_list", this.cardItemList);
        }

        public Resp(Bundle bundle) {
            fromBundle(bundle);
        }
    }
}
