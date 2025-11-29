package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;

class c extends AsyncTask<Void, Void, a> {

    /* renamed from: a  reason: collision with root package name */
    private String f9610a;
    private String b;
    private OAuthListener c;
    private int d;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public OAuthErrCode f9611a;
        public String b;
        public int c;
    }

    public c(String str, OAuthListener oAuthListener) {
        this.f9610a = str;
        this.c = oAuthListener;
        this.b = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", new Object[]{str});
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x015f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object doInBackground(java.lang.Object[] r11) {
        /*
            r10 = this;
            java.lang.Void[] r11 = (java.lang.Void[]) r11
            java.lang.Thread r11 = java.lang.Thread.currentThread()
            java.lang.String r0 = "OpenSdkNoopingTask"
            r11.setName(r0)
            java.lang.String r11 = r10.f9610a
            java.lang.String r0 = "MicroMsg.SDK.NoopingTask"
            if (r11 == 0) goto L_0x0186
            int r11 = r11.length()
            if (r11 != 0) goto L_0x0019
            goto L_0x0186
        L_0x0019:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r1 = "doInBackground start "
            r11.append(r1)
            boolean r1 = r10.isCancelled()
            r11.append(r1)
            java.lang.String r11 = r11.toString()
            com.tencent.mm.opensdk.utils.Log.i(r0, r11)
        L_0x0031:
            boolean r11 = r10.isCancelled()
            if (r11 != 0) goto L_0x0177
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r1 = r10.b
            r11.append(r1)
            int r1 = r10.d
            if (r1 != 0) goto L_0x0048
            java.lang.String r1 = ""
            goto L_0x005b
        L_0x0048:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "&last="
            r1.append(r2)
            int r2 = r10.d
            r1.append(r2)
            java.lang.String r1 = r1.toString()
        L_0x005b:
            r11.append(r1)
            java.lang.String r11 = r11.toString()
            long r1 = java.lang.System.currentTimeMillis()
            r3 = 60000(0xea60, float:8.4078E-41)
            byte[] r3 = com.tencent.mm.opensdk.channel.a.a.a((java.lang.String) r11, (int) r3)
            long r4 = java.lang.System.currentTimeMillis()
            com.tencent.mm.opensdk.diffdev.a.c$a r6 = new com.tencent.mm.opensdk.diffdev.a.c$a
            r6.<init>()
            java.lang.String r7 = "star parse NoopingResult"
            java.lang.String r8 = "MicroMsg.SDK.NoopingResult"
            com.tencent.mm.opensdk.utils.Log.d(r8, r7)
            if (r3 == 0) goto L_0x00fa
            int r7 = r3.length
            if (r7 != 0) goto L_0x0084
            goto L_0x00fa
        L_0x0084:
            java.lang.String r7 = new java.lang.String     // Catch:{ Exception -> 0x00ea }
            java.lang.String r9 = "utf-8"
            r7.<init>(r3, r9)     // Catch:{ Exception -> 0x00ea }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x00c4 }
            r3.<init>(r7)     // Catch:{ Exception -> 0x00c4 }
            java.lang.String r7 = "wx_errcode"
            int r7 = r3.getInt(r7)     // Catch:{ Exception -> 0x00c4 }
            r6.c = r7     // Catch:{ Exception -> 0x00c4 }
            java.lang.String r9 = "nooping uuidStatusCode = %d"
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ Exception -> 0x00c4 }
            java.lang.Object[] r7 = new java.lang.Object[]{r7}     // Catch:{ Exception -> 0x00c4 }
            java.lang.String r7 = java.lang.String.format(r9, r7)     // Catch:{ Exception -> 0x00c4 }
            com.tencent.mm.opensdk.utils.Log.d(r8, r7)     // Catch:{ Exception -> 0x00c4 }
            int r7 = r6.c     // Catch:{ Exception -> 0x00c4 }
            r9 = 408(0x198, float:5.72E-43)
            if (r7 == r9) goto L_0x00cf
            r9 = 500(0x1f4, float:7.0E-43)
            if (r7 == r9) goto L_0x00cc
            switch(r7) {
                case 402: goto L_0x00c9;
                case 403: goto L_0x00c6;
                case 404: goto L_0x00cf;
                case 405: goto L_0x00b7;
                default: goto L_0x00b6;
            }     // Catch:{ Exception -> 0x00c4 }
        L_0x00b6:
            goto L_0x00cc
        L_0x00b7:
            com.tencent.mm.opensdk.diffdev.OAuthErrCode r7 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_OK     // Catch:{ Exception -> 0x00c4 }
            r6.f9611a = r7     // Catch:{ Exception -> 0x00c4 }
            java.lang.String r7 = "wx_code"
            java.lang.String r3 = r3.getString(r7)     // Catch:{ Exception -> 0x00c4 }
            r6.b = r3     // Catch:{ Exception -> 0x00c4 }
            goto L_0x0102
        L_0x00c4:
            r3 = move-exception
            goto L_0x00d4
        L_0x00c6:
            com.tencent.mm.opensdk.diffdev.OAuthErrCode r3 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_Cancel     // Catch:{ Exception -> 0x00c4 }
            goto L_0x00d1
        L_0x00c9:
            com.tencent.mm.opensdk.diffdev.OAuthErrCode r3 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_Timeout     // Catch:{ Exception -> 0x00c4 }
            goto L_0x00d1
        L_0x00cc:
            com.tencent.mm.opensdk.diffdev.OAuthErrCode r3 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_NormalErr     // Catch:{ Exception -> 0x00c4 }
            goto L_0x00d1
        L_0x00cf:
            com.tencent.mm.opensdk.diffdev.OAuthErrCode r3 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_OK     // Catch:{ Exception -> 0x00c4 }
        L_0x00d1:
            r6.f9611a = r3     // Catch:{ Exception -> 0x00c4 }
            goto L_0x0102
        L_0x00d4:
            java.lang.String r3 = r3.getMessage()
            java.lang.Object[] r3 = new java.lang.Object[]{r3}
            java.lang.String r7 = "parse json fail, ex = %s"
            java.lang.String r3 = java.lang.String.format(r7, r3)
        L_0x00e2:
            com.tencent.mm.opensdk.utils.Log.e(r8, r3)
            com.tencent.mm.opensdk.diffdev.OAuthErrCode r3 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_NormalErr
        L_0x00e7:
            r6.f9611a = r3
            goto L_0x0102
        L_0x00ea:
            r3 = move-exception
            java.lang.String r3 = r3.getMessage()
            java.lang.Object[] r3 = new java.lang.Object[]{r3}
            java.lang.String r7 = "parse fail, build String fail, ex = %s"
            java.lang.String r3 = java.lang.String.format(r7, r3)
            goto L_0x00e2
        L_0x00fa:
            java.lang.String r3 = "parse fail, buf is null"
            com.tencent.mm.opensdk.utils.Log.e(r8, r3)
            com.tencent.mm.opensdk.diffdev.OAuthErrCode r3 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_NetworkErr
            goto L_0x00e7
        L_0x0102:
            com.tencent.mm.opensdk.diffdev.OAuthErrCode r3 = r6.f9611a
            java.lang.String r3 = r3.toString()
            int r7 = r6.c
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            long r4 = r4 - r1
            java.lang.Long r1 = java.lang.Long.valueOf(r4)
            java.lang.Object[] r11 = new java.lang.Object[]{r11, r3, r7, r1}
            java.lang.String r1 = "nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)"
            java.lang.String r11 = java.lang.String.format(r1, r11)
            com.tencent.mm.opensdk.utils.Log.d(r0, r11)
            com.tencent.mm.opensdk.diffdev.OAuthErrCode r11 = r6.f9611a
            com.tencent.mm.opensdk.diffdev.OAuthErrCode r1 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_OK
            if (r11 != r1) goto L_0x015f
            int r11 = r6.c
            r10.d = r11
            com.tencent.mm.opensdk.diffdev.a.d r1 = com.tencent.mm.opensdk.diffdev.a.d.UUID_SCANED
            int r1 = r1.a()
            if (r11 != r1) goto L_0x0139
            com.tencent.mm.opensdk.diffdev.OAuthListener r11 = r10.c
            r11.onQrcodeScanned()
            goto L_0x0031
        L_0x0139:
            int r11 = r6.c
            com.tencent.mm.opensdk.diffdev.a.d r1 = com.tencent.mm.opensdk.diffdev.a.d.UUID_KEEP_CONNECT
            int r1 = r1.a()
            if (r11 != r1) goto L_0x0145
            goto L_0x0031
        L_0x0145:
            int r11 = r6.c
            com.tencent.mm.opensdk.diffdev.a.d r1 = com.tencent.mm.opensdk.diffdev.a.d.UUID_CONFIRM
            int r1 = r1.a()
            if (r11 != r1) goto L_0x0031
            java.lang.String r10 = r6.b
            if (r10 == 0) goto L_0x0159
            int r10 = r10.length()
            if (r10 != 0) goto L_0x0193
        L_0x0159:
            java.lang.String r10 = "nooping fail, confirm with an empty code!!!"
            com.tencent.mm.opensdk.utils.Log.e(r0, r10)
            goto L_0x0190
        L_0x015f:
            java.lang.String r10 = r11.toString()
            int r11 = r6.c
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            java.lang.Object[] r10 = new java.lang.Object[]{r10, r11}
            java.lang.String r11 = "nooping fail, errCode = %s, uuidStatusCode = %d"
            java.lang.String r10 = java.lang.String.format(r11, r10)
            com.tencent.mm.opensdk.utils.Log.e(r0, r10)
            goto L_0x0193
        L_0x0177:
            java.lang.String r10 = "IDiffDevOAuth.stopAuth / detach invoked"
            com.tencent.mm.opensdk.utils.Log.i(r0, r10)
            com.tencent.mm.opensdk.diffdev.a.c$a r6 = new com.tencent.mm.opensdk.diffdev.a.c$a
            r6.<init>()
            com.tencent.mm.opensdk.diffdev.OAuthErrCode r10 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_Auth_Stopped
        L_0x0183:
            r6.f9611a = r10
            goto L_0x0193
        L_0x0186:
            java.lang.String r10 = "run fail, uuid is null"
            com.tencent.mm.opensdk.utils.Log.e(r0, r10)
            com.tencent.mm.opensdk.diffdev.a.c$a r6 = new com.tencent.mm.opensdk.diffdev.a.c$a
            r6.<init>()
        L_0x0190:
            com.tencent.mm.opensdk.diffdev.OAuthErrCode r10 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_NormalErr
            goto L_0x0183
        L_0x0193:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.opensdk.diffdev.a.c.doInBackground(java.lang.Object[]):java.lang.Object");
    }

    public void onPostExecute(Object obj) {
        a aVar = (a) obj;
        this.c.onAuthFinish(aVar.f9611a, aVar.b);
    }
}
