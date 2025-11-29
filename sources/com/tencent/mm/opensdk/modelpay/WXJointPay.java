package com.tencent.mm.opensdk.modelpay;

import android.os.Bundle;

public class WXJointPay {

    public static class JointPayReq extends PayReq {
        public boolean checkArgs() {
            return super.checkArgs();
        }

        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
        }

        public int getType() {
            return 27;
        }

        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
        }
    }

    public static class JointPayResp extends PayResp {
        public JointPayResp() {
        }

        public boolean checkArgs() {
            return super.checkArgs();
        }

        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
        }

        public int getType() {
            return 27;
        }

        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
        }

        public JointPayResp(Bundle bundle) {
            fromBundle(bundle);
        }
    }
}
