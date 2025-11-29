package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mm.opensdk.diffdev.IDiffDevOAuth;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a implements IDiffDevOAuth {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Handler f9605a = null;
    /* access modifiers changed from: private */
    public List<OAuthListener> b = new ArrayList();
    /* access modifiers changed from: private */
    public b c;
    private OAuthListener d = new C0035a();

    /* renamed from: com.tencent.mm.opensdk.diffdev.a.a$a  reason: collision with other inner class name */
    public class C0035a implements OAuthListener {

        /* renamed from: com.tencent.mm.opensdk.diffdev.a.a$a$a  reason: collision with other inner class name */
        public class C0036a implements Runnable {
            public C0036a() {
            }

            public void run() {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(a.this.b);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((OAuthListener) it.next()).onQrcodeScanned();
                }
            }
        }

        public C0035a() {
        }

        public void onAuthFinish(OAuthErrCode oAuthErrCode, String str) {
            Log.d("MicroMsg.SDK.ListenerWrapper", String.format("onAuthFinish, errCode = %s, authCode = %s", new Object[]{oAuthErrCode.toString(), str}));
            b unused = a.this.c = null;
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(a.this.b);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((OAuthListener) it.next()).onAuthFinish(oAuthErrCode, str);
            }
        }

        public void onAuthGotQrcode(String str, byte[] bArr) {
            Log.d("MicroMsg.SDK.ListenerWrapper", "onAuthGotQrcode, qrcodeImgPath = " + str);
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(a.this.b);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((OAuthListener) it.next()).onAuthGotQrcode(str, bArr);
            }
        }

        public void onQrcodeScanned() {
            Log.d("MicroMsg.SDK.ListenerWrapper", "onQrcodeScanned");
            if (a.this.f9605a != null) {
                a.this.f9605a.post(new C0036a());
            }
        }
    }

    public void addListener(OAuthListener oAuthListener) {
        if (!this.b.contains(oAuthListener)) {
            this.b.add(oAuthListener);
        }
    }

    public boolean auth(String str, String str2, String str3, String str4, String str5, OAuthListener oAuthListener) {
        String str6 = str;
        OAuthListener oAuthListener2 = oAuthListener;
        Log.i("MicroMsg.SDK.DiffDevOAuth", "start auth, appId = " + str);
        if (str6 == null || str.length() <= 0 || str2 == null || str2.length() <= 0) {
            Log.d("MicroMsg.SDK.DiffDevOAuth", String.format("auth fail, invalid argument, appId = %s, scope = %s", new Object[]{str, str2}));
            return false;
        }
        if (this.f9605a == null) {
            this.f9605a = new Handler(Looper.getMainLooper());
        }
        if (!this.b.contains(oAuthListener2)) {
            this.b.add(oAuthListener2);
        }
        if (this.c != null) {
            Log.d("MicroMsg.SDK.DiffDevOAuth", "auth, already running, no need to start auth again");
            return true;
        }
        b bVar = new b(str, str2, str3, str4, str5, this.d);
        this.c = bVar;
        bVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return true;
    }

    public void detach() {
        Log.i("MicroMsg.SDK.DiffDevOAuth", "detach");
        this.b.clear();
        stopAuth();
    }

    public void removeAllListeners() {
        this.b.clear();
    }

    public void removeListener(OAuthListener oAuthListener) {
        this.b.remove(oAuthListener);
    }

    public boolean stopAuth() {
        boolean z;
        Log.i("MicroMsg.SDK.DiffDevOAuth", "stopAuth");
        try {
            b bVar = this.c;
            z = bVar == null ? true : bVar.a();
        } catch (Exception e) {
            Log.w("MicroMsg.SDK.DiffDevOAuth", "stopAuth fail, ex = " + e.getMessage());
            z = false;
        }
        this.c = null;
        return z;
    }
}
