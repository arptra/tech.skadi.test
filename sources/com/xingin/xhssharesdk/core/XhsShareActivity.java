package com.xingin.xhssharesdk.core;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.xingin.xhssharesdk.XhsShareConstants$XhsShareNoteErrorCode;
import com.xingin.xhssharesdk.XhsShareConstants$XhsShareNoteNewErrorCode;
import com.xingin.xhssharesdk.XhsShareSdkTools;
import com.xingin.xhssharesdk.b.e;
import com.xingin.xhssharesdk.b.i;
import com.xingin.xhssharesdk.h.c;
import com.xingin.xhssharesdk.i.c;
import com.xingin.xhssharesdk.i.g;
import java.lang.ref.WeakReference;

@Keep
public class XhsShareActivity extends Activity {
    private static final String TAG = "XhsShare_XhsShareActivity";
    @Nullable
    private g mReceiver;
    private boolean waitingResume = false;

    public static class a implements com.xingin.xhssharesdk.h.a {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference f8169a;

        public a(XhsShareActivity xhsShareActivity) {
            this.f8169a = new WeakReference(xhsShareActivity);
        }

        public final void a(String str, Uri uri) {
            XhsShareActivity xhsShareActivity = (XhsShareActivity) this.f8169a.get();
            if (xhsShareActivity != null) {
                xhsShareActivity.openXhs(str, uri);
            }
        }

        public final void b(String str, int i, int i2, String str2, Throwable th) {
            XhsShareActivity xhsShareActivity = (XhsShareActivity) this.f8169a.get();
            if (xhsShareActivity != null) {
                xhsShareActivity.sendErrorAndFinish(str, i, i2, str2, th);
            }
        }
    }

    public static class b implements c {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference f8170a;

        public b(XhsShareActivity xhsShareActivity) {
            this.f8170a = new WeakReference(xhsShareActivity);
        }

        public final void a(com.xingin.xhssharesdk.m.b bVar) {
            XhsShareActivity xhsShareActivity = (XhsShareActivity) this.f8170a.get();
            String c = XhsShareSdk.f8171a != null ? XhsShareSdk.f8171a.c() : "";
            if (xhsShareActivity != null && TextUtils.equals(bVar.d, c)) {
                xhsShareActivity.handleShareResultFromXhs(bVar);
                xhsShareActivity.unregisterShareResultReceiver();
            }
        }
    }

    /* access modifiers changed from: private */
    public void handleShareResultFromXhs(com.xingin.xhssharesdk.m.b bVar) {
        if (bVar == null) {
            return;
        }
        if (!bVar.f8193a) {
            Pair<Integer, Integer> errorCodeFromXhsShareResult = XhsShareSdkTools.getErrorCodeFromXhsShareResult(bVar);
            sendErrorAndFinish(bVar.d, ((Integer) errorCodeFromXhsShareResult.first).intValue(), ((Integer) errorCodeFromXhsShareResult.second).intValue(), bVar.c, (Throwable) null);
        } else if (XhsShareSdk.f8171a != null) {
            XhsShareSdk.f8171a.i(bVar.d);
        }
    }

    private boolean isNeedRegisterReceiverWithOutsideActivity() {
        if (XhsShareSdk.f8171a != null) {
            return XhsShareSdk.f8171a.c.isNeedRegisterReceiverWithOutsideActivity();
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void openXhs(@NonNull String str, @NonNull Uri uri) {
        Intent intent = new Intent();
        intent.setData(uri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            XhsShareSdk.b(TAG, "Start Activity: " + uri);
            long j = 0;
            if (XhsShareSdk.f8171a != null) {
                com.xingin.xhssharesdk.i.a aVar = XhsShareSdk.f8171a.i;
                if (aVar != null) {
                    com.xingin.xhssharesdk.q.b bVar = aVar.b;
                    String str2 = aVar.f8180a;
                    if (!TextUtils.isEmpty(bVar.f8201a) && TextUtils.equals(str2, bVar.f8201a)) {
                        if (bVar.c != 0) {
                            XhsShareSdk.d("ShareTimelineTracker", "openShareTimestamp has be assigned!", (Throwable) null);
                        } else {
                            bVar.c = System.currentTimeMillis();
                        }
                    }
                }
                com.xingin.xhssharesdk.i.a aVar2 = XhsShareSdk.f8171a.i;
                com.xingin.xhssharesdk.q.b bVar2 = aVar2 != null ? aVar2.b : com.xingin.xhssharesdk.q.b.e;
                long j2 = bVar2.c;
                if (j2 > 0) {
                    long j3 = bVar2.b;
                    if (j3 > 0) {
                        long j4 = j2 - j3;
                        if (j4 >= 0) {
                            j = j4;
                        }
                    }
                }
                j = -1;
            }
            Context applicationContext = getApplicationContext();
            e h = e.h();
            i.a a2 = com.xingin.xhssharesdk.q.a.a(applicationContext);
            a2.b = 30757;
            a2.c = 3;
            a2.d.put("session_id", str);
            a2.d.put("time_consume", String.valueOf(j));
            h.d(a2);
            if (!isNeedRegisterReceiverWithOutsideActivity()) {
                registerShareResultReceiver();
            } else if (XhsShareSdk.f8171a != null) {
                com.xingin.xhssharesdk.i.c cVar = XhsShareSdk.f8171a;
                WeakReference weakReference = cVar.m;
                if (weakReference == null || weakReference.get() == null) {
                    cVar.n.w("XhsShare_Sdk", "registerShareResultReceiverWithOutsideActivity, OutsideActivity is NULL!", (Throwable) null);
                } else {
                    Activity activity = (Activity) cVar.m.get();
                    cVar.o = new g(new c.d());
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("com.xingin.xhs.action.VOLLEY_SHARE_RESULT");
                    try {
                        activity.registerReceiver(cVar.o, intentFilter);
                        cVar.j();
                    } catch (Throwable th) {
                        XhsShareSdk.d("XhsShare_Sdk", "registerShareResultReceiverWithOutsideActivity Error!", th);
                    }
                }
            }
            startActivity(intent);
            this.waitingResume = true;
            return;
        }
        sendErrorAndFinish(str, XhsShareConstants$XhsShareNoteNewErrorCode.INTENT_NOT_RESOLVE_ERROR, XhsShareConstants$XhsShareNoteErrorCode.INTENT_NOT_RESOLVE, "Intent.resolveActivity is false", (Throwable) null);
    }

    @SuppressLint({"UnspecifiedRegisterReceiverFlag"})
    private void registerShareResultReceiver() {
        if (this.mReceiver == null) {
            this.mReceiver = new g(new b(this));
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.xingin.xhs.action.VOLLEY_SHARE_RESULT");
        try {
            registerReceiver(this.mReceiver, intentFilter);
        } catch (Throwable th) {
            XhsShareSdk.d(TAG, "registerShareResultReceiver Error!", th);
        }
    }

    /* access modifiers changed from: private */
    public void sendErrorAndFinish(String str, int i, int i2, String str2, Throwable th) {
        XhsShareSdk.c(TAG, "[" + str + "][new: " + i + "][old:" + i2 + "]" + str2, th);
        if (XhsShareSdk.f8171a != null) {
            com.xingin.xhssharesdk.i.a aVar = XhsShareSdk.f8171a.i;
            if (aVar == null ? false : aVar.c) {
                XhsShareSdk.f8171a.g(str, i, i2, str2, th, true);
            }
        }
        finish();
    }

    /* access modifiers changed from: private */
    public void unregisterShareResultReceiver() {
        g gVar = this.mReceiver;
        if (gVar != null) {
            try {
                unregisterReceiver(gVar);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x023a  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0294  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x02b7  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x02e9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(@androidx.annotation.Nullable android.os.Bundle r25) {
        /*
            r24 = this;
            r0 = r24
            super.onCreate(r25)
            android.net.Uri r1 = r24.getReferrer()
            java.lang.String r1 = r1.toString()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "XhsShareActivity onCreate: savedInstanceState is "
            r2.<init>(r3)
            r3 = r25
            r2.append(r3)
            java.lang.String r3 = ", Referrer is "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            java.lang.String r2 = "XhsShare_XhsShareActivity"
            com.xingin.xhssharesdk.core.XhsShareSdk.b(r2, r1)
            int r1 = com.xingin.xhssharesdk.R.layout.activity_xhs_share
            r0.setContentView(r1)
            android.view.Window r1 = r24.getWindow()
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r1.addFlags(r3)
            android.view.Window r1 = r24.getWindow()
            r3 = 0
            r1.setStatusBarColor(r3)
            android.view.Window r1 = r24.getWindow()
            r1.setNavigationBarColor(r3)
            android.content.Intent r1 = r24.getIntent()
            if (r1 != 0) goto L_0x005e
            java.lang.String r5 = "The intent is NULL!"
            r6 = 0
            java.lang.String r2 = ""
            r3 = -20100010(0xfffffffffecd4c56, float:-1.3644405E38)
            r4 = -10000001(0xffffffffff67697f, float:-3.0759943E38)
            r1 = r24
            r1.sendErrorAndFinish(r2, r3, r4, r5, r6)
            return
        L_0x005e:
            java.lang.String r4 = "XHS_SHARE_FLAG"
            java.lang.String r4 = r1.getStringExtra(r4)
            java.lang.String r5 = "REDIRECT"
            boolean r4 = android.text.TextUtils.equals(r4, r5)
            if (r4 == 0) goto L_0x0075
            java.lang.String r1 = "onCreate - REDIRECT"
            com.xingin.xhssharesdk.core.XhsShareSdk.b(r2, r1)
            r24.finish()
            return
        L_0x0075:
            java.lang.String r4 = "XHS_SHARE_SESSION_ID"
            java.lang.String r4 = r1.getStringExtra(r4)
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            java.lang.String r6 = ""
            r7 = 0
            if (r5 == 0) goto L_0x008b
            java.lang.String r4 = "The sessionId is empty!"
            com.xingin.xhssharesdk.core.XhsShareSdk.d(r2, r4, r7)
            r11 = r6
            goto L_0x008c
        L_0x008b:
            r11 = r4
        L_0x008c:
            java.lang.String r2 = "XHS_SHARE_NOTE_KEY"
            android.os.Parcelable r1 = r1.getParcelableExtra(r2)
            r10 = r1
            com.xingin.xhssharesdk.model.sharedata.XhsNote r10 = (com.xingin.xhssharesdk.model.sharedata.XhsNote) r10
            if (r10 != 0) goto L_0x00a7
            java.lang.String r5 = "The Note is NULL!"
            r6 = 0
            r3 = -20100011(0xfffffffffecd4c55, float:-1.3644404E38)
            r4 = -10000001(0xffffffffff67697f, float:-3.0759943E38)
            r1 = r24
            r2 = r11
            r1.sendErrorAndFinish(r2, r3, r4, r5, r6)
            return
        L_0x00a7:
            com.xingin.xhssharesdk.i.c r1 = com.xingin.xhssharesdk.core.XhsShareSdk.f8171a
            if (r1 == 0) goto L_0x037f
            com.xingin.xhssharesdk.i.c r1 = com.xingin.xhssharesdk.core.XhsShareSdk.f8171a
            com.xingin.xhssharesdk.core.XhsShareActivity$a r14 = new com.xingin.xhssharesdk.core.XhsShareActivity$a
            r14.<init>(r0)
            com.xingin.xhssharesdk.i.a r2 = r1.i
            if (r2 != 0) goto L_0x00c7
            java.lang.String r12 = "[makeShareNoteDeeplink]CurrentShareContext is NULL!"
            r13 = 0
            r10 = -20100013(0xfffffffffecd4c53, float:-1.3644402E38)
            r0 = -10000001(0xffffffffff67697f, float:-3.0759943E38)
            r8 = r14
            r9 = r11
            r11 = r0
            r8.b(r9, r10, r11, r12, r13)
            goto L_0x038e
        L_0x00c7:
            java.lang.String r0 = r2.f8180a
            boolean r0 = android.text.TextUtils.equals(r0, r11)
            if (r0 != 0) goto L_0x00e0
            java.lang.String r12 = "[makeShareNoteDeeplink]SessionId is not equal!"
            r13 = 0
            r10 = -20100014(0xfffffffffecd4c52, float:-1.3644401E38)
            r0 = -10000001(0xffffffffff67697f, float:-3.0759943E38)
            r8 = r14
            r9 = r11
            r11 = r0
            r8.b(r9, r10, r11, r12, r13)
            goto L_0x038e
        L_0x00e0:
            android.content.Context r0 = r1.f8182a
            android.content.Context r0 = r0.getApplicationContext()
            com.xingin.xhssharesdk.model.other.VersionCheckResult r0 = com.xingin.xhssharesdk.XhsShareSdkTools.isSupportShareNote(r0)
            int r4 = r0.checkResultCode
            if (r4 == 0) goto L_0x0109
            r1 = -1
            if (r4 != r1) goto L_0x00f6
            r1 = -20100001(0xfffffffffecd4c5f, float:-1.3644414E38)
        L_0x00f4:
            r10 = r1
            goto L_0x00fa
        L_0x00f6:
            r1 = -20100002(0xfffffffffecd4c5e, float:-1.3644413E38)
            goto L_0x00f4
        L_0x00fa:
            java.lang.String r12 = r0.errorMessage
            java.lang.Throwable r13 = r0.exception
            r0 = -10000003(0xffffffffff67697d, float:-3.075994E38)
            r8 = r14
            r9 = r11
            r11 = r0
            r8.b(r9, r10, r11, r12, r13)
            goto L_0x038e
        L_0x0109:
            com.xingin.xhssharesdk.i.c$a r0 = r1.n
            java.lang.String r4 = "ReadTokenCheckInfoFromLocal."
            java.lang.String r5 = "XhsShare_Sdk"
            r0.d(r5, r4)
            android.content.Context r0 = r1.f8182a
            java.lang.String r4 = "XHS_SHARE_SDK_SP"
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r4, r3)
            java.lang.String r4 = "XHS_SHARE_SDK_SP_KEY_TOKEN_CHECK_INFO"
            java.lang.String r4 = r0.getString(r4, r7)
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 == 0) goto L_0x012e
            com.xingin.xhssharesdk.i.c$a r0 = r1.n
            java.lang.String r4 = "Get no TokenCheckInfo."
            r0.i(r5, r4)
            goto L_0x0149
        L_0x012e:
            com.xingin.xhssharesdk.m.a r0 = com.xingin.xhssharesdk.m.a.a(r4)     // Catch:{ JSONException -> 0x0134 }
            r4 = r0
            goto L_0x014a
        L_0x0134:
            r0 = move-exception
            r8 = r0
            com.xingin.xhssharesdk.i.c$a r0 = r1.n
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r12 = "Json to TokenCheckInfo error.\n json is "
            r9.<init>(r12)
            r9.append(r4)
            java.lang.String r4 = r9.toString()
            r0.w(r5, r4, r8)
        L_0x0149:
            r4 = r7
        L_0x014a:
            java.lang.String r8 = "Invoke getAppVersionName() Error!"
            r9 = -10000001(0xffffffffff67697f, float:-3.0759943E38)
            r12 = 1
            if (r4 != 0) goto L_0x0153
            goto L_0x0162
        L_0x0153:
            boolean r0 = r4.e
            if (r0 != 0) goto L_0x016f
            com.xingin.xhssharesdk.i.c$a r0 = r1.n
            java.lang.String r3 = "Last Token Check Error!"
            r0.d(r5, r3)
            int r0 = r4.f
            if (r0 != r9) goto L_0x0167
        L_0x0162:
            r25 = r10
        L_0x0164:
            r3 = r12
            goto L_0x0224
        L_0x0167:
            boolean r0 = r1.k
            r3 = r0 ^ 1
            r25 = r10
            goto L_0x0224
        L_0x016f:
            long r15 = java.lang.System.currentTimeMillis()
            r25 = r10
            long r9 = r4.d
            long r9 = r15 - r9
            r15 = 604800000(0x240c8400, double:2.988109026E-315)
            int r0 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r0 <= 0) goto L_0x0194
            com.xingin.xhssharesdk.i.c$a r0 = r1.n
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r13 = "Token expire! threshold: 604800000 current: "
            r3.<init>(r13)
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            r0.d(r5, r3)
            goto L_0x0164
        L_0x0194:
            java.lang.String r0 = r1.g
            if (r0 == 0) goto L_0x0199
            goto L_0x01aa
        L_0x0199:
            android.content.Context r0 = r1.f8182a     // Catch:{ NameNotFoundException -> 0x01a2 }
            java.lang.String r0 = com.xingin.xhssharesdk.XhsShareSdkTools.getCurrentAppVersionName(r0)     // Catch:{ NameNotFoundException -> 0x01a2 }
            r1.g = r0     // Catch:{ NameNotFoundException -> 0x01a2 }
            goto L_0x01a8
        L_0x01a2:
            r0 = move-exception
            com.xingin.xhssharesdk.i.c$a r9 = r1.n
            r9.w(r5, r8, r0)
        L_0x01a8:
            java.lang.String r0 = r1.g
        L_0x01aa:
            android.content.Context r9 = r1.f8182a
            java.lang.String r9 = com.xingin.xhssharesdk.XhsShareSdkTools.getCurrentAppPackageName(r9)
            java.lang.String r10 = com.xingin.xhssharesdk.XhsShareSdkTools.getSdkVersion()
            java.lang.String r13 = r4.b
            boolean r13 = android.text.TextUtils.equals(r9, r13)
            java.lang.String r15 = " current: "
            if (r13 != 0) goto L_0x01da
            com.xingin.xhssharesdk.i.c$a r0 = r1.n
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r10 = "AppPackage Changed! last: "
            r3.<init>(r10)
            java.lang.String r10 = r4.b
            r3.append(r10)
            r3.append(r15)
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            r0.d(r5, r3)
            goto L_0x0164
        L_0x01da:
            java.lang.String r9 = r4.f8192a
            boolean r9 = android.text.TextUtils.equals(r0, r9)
            if (r9 != 0) goto L_0x01ff
            com.xingin.xhssharesdk.i.c$a r3 = r1.n
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "AppVersion Changed! last: "
            r9.<init>(r10)
            java.lang.String r10 = r4.f8192a
            r9.append(r10)
            r9.append(r15)
            r9.append(r0)
            java.lang.String r0 = r9.toString()
            r3.d(r5, r0)
            goto L_0x0164
        L_0x01ff:
            java.lang.String r0 = r4.c
            boolean r0 = android.text.TextUtils.equals(r10, r0)
            if (r0 != 0) goto L_0x0224
            com.xingin.xhssharesdk.i.c$a r0 = r1.n
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r9 = "SdkVersion Changed! last: "
            r3.<init>(r9)
            java.lang.String r9 = r4.c
            r3.append(r9)
            r3.append(r15)
            r3.append(r10)
            java.lang.String r3 = r3.toString()
            r0.d(r5, r3)
            goto L_0x0164
        L_0x0224:
            com.xingin.xhssharesdk.i.c$a r0 = r1.n
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "Need Check Token? "
            r9.<init>(r10)
            r9.append(r3)
            java.lang.String r9 = r9.toString()
            r0.d(r5, r9)
            r9 = 3
            if (r3 == 0) goto L_0x0294
            java.lang.String r3 = r1.b
            android.content.Context r0 = r1.f8182a
            java.lang.String r4 = com.xingin.xhssharesdk.XhsShareSdkTools.getCurrentAppPackageName(r0)
            java.lang.String r0 = r1.g
            if (r0 == 0) goto L_0x0247
            goto L_0x0258
        L_0x0247:
            android.content.Context r0 = r1.f8182a     // Catch:{ NameNotFoundException -> 0x0250 }
            java.lang.String r0 = com.xingin.xhssharesdk.XhsShareSdkTools.getCurrentAppVersionName(r0)     // Catch:{ NameNotFoundException -> 0x0250 }
            r1.g = r0     // Catch:{ NameNotFoundException -> 0x0250 }
            goto L_0x0256
        L_0x0250:
            r0 = move-exception
            com.xingin.xhssharesdk.i.c$a r10 = r1.n
            r10.w(r5, r8, r0)
        L_0x0256:
            java.lang.String r0 = r1.g
        L_0x0258:
            java.lang.String r8 = com.xingin.xhssharesdk.XhsShareSdkTools.getSdkVersion()
            com.xingin.xhssharesdk.o.a r10 = new com.xingin.xhssharesdk.o.a
            long r15 = java.lang.System.currentTimeMillis()
            java.lang.String r13 = java.lang.String.valueOf(r15)
            r15 = r10
            r16 = r3
            r17 = r4
            r18 = r0
            r19 = r8
            r20 = r13
            r15.<init>(r16, r17, r18, r19, r20)
            com.xingin.xhssharesdk.m.a r3 = new com.xingin.xhssharesdk.m.a
            long r19 = java.lang.Long.parseLong(r13)
            r22 = 0
            r23 = 0
            r21 = 1
            r15 = r3
            r16 = r0
            r18 = r8
            r15.<init>(r16, r17, r18, r19, r21, r22, r23)
            r1.k = r12
            com.xingin.xhssharesdk.i.b r0 = new com.xingin.xhssharesdk.i.b
            r0.<init>(r1, r3)
            com.xingin.xhssharesdk.i.e.b(r10, r0)
            r12 = 2
            goto L_0x02a6
        L_0x0294:
            r1.d = r4
            boolean r0 = r4.e
            if (r0 != 0) goto L_0x02a6
            int r0 = r4.f
            r3 = -10000001(0xffffffffff67697f, float:-3.0759943E38)
            if (r0 == r3) goto L_0x02a6
            boolean r0 = r1.k
            if (r0 == 0) goto L_0x02a6
            r12 = r9
        L_0x02a6:
            com.xingin.xhssharesdk.i.c$a r0 = r1.n
            java.lang.String r3 = com.xingin.xhssharesdk.g.a.a(r12)
            java.lang.String r4 = "CheckToken Result is "
            java.lang.String r3 = r4.concat(r3)
            r0.d(r5, r3)
            if (r12 != r9) goto L_0x02e9
            com.xingin.xhssharesdk.m.a r0 = r1.d
            if (r0 == 0) goto L_0x02d9
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "["
            r0.<init>(r2)
            com.xingin.xhssharesdk.m.a r2 = r1.d
            int r2 = r2.f
            r0.append(r2)
            java.lang.String r2 = "],"
            r0.append(r2)
            com.xingin.xhssharesdk.m.a r1 = r1.d
            java.lang.String r1 = r1.g
            r0.append(r1)
            java.lang.String r6 = r0.toString()
        L_0x02d9:
            r12 = r6
            r0 = -10000007(0xffffffffff676979, float:-3.0759931E38)
            r13 = 0
            r10 = -20100008(0xfffffffffecd4c58, float:-1.3644407E38)
            r8 = r14
            r9 = r11
            r11 = r0
            r8.b(r9, r10, r11, r12, r13)
            goto L_0x038e
        L_0x02e9:
            boolean r0 = com.xingin.xhssharesdk.i.f.d(r25)
            if (r0 != 0) goto L_0x0300
            java.lang.String r12 = "The Image and Video is invalid!"
            r13 = 0
            r10 = -20100003(0xfffffffffecd4c5d, float:-1.3644412E38)
            r0 = -10000004(0xffffffffff67697c, float:-3.0759937E38)
            r8 = r14
            r9 = r11
            r11 = r0
            r8.b(r9, r10, r11, r12, r13)
            goto L_0x038e
        L_0x0300:
            java.io.File r0 = new java.io.File
            com.xingin.xhssharesdk.model.config.XhsShareGlobalConfig r3 = r1.c
            java.lang.String r3 = r3.getCacheDirPath()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L_0x0315
            android.content.Context r3 = r1.f8182a
            java.lang.String r3 = com.xingin.xhssharesdk.XhsShareSdkTools.getDefaultCacheDirPath(r3)
            goto L_0x031b
        L_0x0315:
            com.xingin.xhssharesdk.model.config.XhsShareGlobalConfig r3 = r1.c
            java.lang.String r3 = r3.getCacheDirPath()
        L_0x031b:
            r0.<init>(r3)
            boolean r3 = r0.exists()
            if (r3 != 0) goto L_0x0356
            boolean r0 = r0.mkdirs()
            if (r0 != 0) goto L_0x0356
            com.xingin.xhssharesdk.i.c$a r0 = r1.n
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Create cache dir error! The path is "
            r3.<init>(r4)
            com.xingin.xhssharesdk.model.config.XhsShareGlobalConfig r4 = r1.c
            java.lang.String r4 = r4.getCacheDirPath()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L_0x0346
            android.content.Context r4 = r1.f8182a
            java.lang.String r4 = com.xingin.xhssharesdk.XhsShareSdkTools.getDefaultCacheDirPath(r4)
            goto L_0x034c
        L_0x0346:
            com.xingin.xhssharesdk.model.config.XhsShareGlobalConfig r4 = r1.c
            java.lang.String r4 = r4.getCacheDirPath()
        L_0x034c:
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r0.w(r5, r3, r7)
        L_0x0356:
            com.xingin.xhssharesdk.i.c$e r0 = r1.h
            if (r0 == 0) goto L_0x036c
            boolean r0 = r0.isAlive()
            if (r0 == 0) goto L_0x036c
            com.xingin.xhssharesdk.i.c$a r0 = r1.n
            java.lang.String r3 = "The last ProcessDataThread is alive!!"
            r0.w(r5, r3, r7)
            com.xingin.xhssharesdk.i.c$e r0 = r1.h
            r0.interrupt()
        L_0x036c:
            com.xingin.xhssharesdk.i.c$e r0 = new com.xingin.xhssharesdk.i.c$e
            com.xingin.xhssharesdk.q.b r2 = r2.b
            long r12 = r2.b
            r8 = r0
            r9 = r1
            r10 = r25
            r8.<init>(r10, r11, r12, r14)
            r1.h = r0
            r0.start()
            goto L_0x038e
        L_0x037f:
            java.lang.String r5 = "XhsShare instance is null! Maybe not invoke [XhsShareSdk.registerApp]!"
            r6 = 0
            r3 = -20100012(0xfffffffffecd4c54, float:-1.3644403E38)
            r4 = -10000001(0xffffffffff67697f, float:-3.0759943E38)
            r1 = r24
            r2 = r11
            r1.sendErrorAndFinish(r2, r3, r4, r5, r6)
        L_0x038e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xingin.xhssharesdk.core.XhsShareActivity.onCreate(android.os.Bundle):void");
    }

    public void onDestroy() {
        super.onDestroy();
        XhsShareSdk.b(TAG, "XhsShareActivity onDestroy");
        unregisterShareResultReceiver();
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        String stringExtra = intent.getStringExtra("XHS_SHARE_FLAG");
        XhsShareSdk.b(TAG, "XhsShareActivity onNewIntent, flag is " + stringExtra);
        if (TextUtils.equals(stringExtra, "SHARE")) {
            sendErrorAndFinish("", XhsShareConstants$XhsShareNoteNewErrorCode.REPEAT_SHARE, XhsShareConstants$XhsShareNoteErrorCode.REPEAT_SHARE, "Last share not over yet!!", (Throwable) null);
        } else if (TextUtils.equals(stringExtra, "REDIRECT")) {
            XhsShareSdk.b(TAG, "onNewIntent - REDIRECT");
            finish();
        }
    }

    public void onRestoreInstanceState(@NonNull Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        XhsShareSdk.b(TAG, "XhsShareActivity onRestoreInstanceState: " + bundle);
    }

    public void onResume() {
        super.onResume();
        XhsShareSdk.b(TAG, "XhsShareActivity onResume, waitingResume is " + this.waitingResume);
        if (this.waitingResume && XhsShareSdk.f8171a != null) {
            StringBuilder sb = new StringBuilder("XhsShareActivity onResume, isSharing: ");
            com.xingin.xhssharesdk.i.a aVar = XhsShareSdk.f8171a.i;
            boolean z = false;
            sb.append(aVar == null ? false : aVar.c);
            XhsShareSdk.b(TAG, sb.toString());
            com.xingin.xhssharesdk.i.a aVar2 = XhsShareSdk.f8171a.i;
            if (aVar2 != null) {
                z = aVar2.c;
            }
            if (z) {
                sendErrorAndFinish(XhsShareSdk.f8171a.c(), XhsShareConstants$XhsShareNoteNewErrorCode.APP_RESUME_BEFORE_GET_SHARE_RESULT_FROM_XHS, XhsShareConstants$XhsShareNoteErrorCode.APP_RESUME_BEFORE_GET_SHARE_RESULT, "App resume before get share result!", (Throwable) null);
            } else {
                finish();
            }
        }
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        XhsShareSdk.b(TAG, "XhsShareActivity onSaveInstanceState!");
    }
}
