package com.meizu.account.oauth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.honey.account.constant.AccountConstantKt;
import com.meizu.account.oauth.data.AccountInfo;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.starrynet.common.StarryNetConstant;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

public class MzAuthenticator {
    /* access modifiers changed from: private */
    public static final String TAG = "MzAuthenticator";
    private AccountManagerFuture<Bundle> mAccountManagerFuture;
    private OnMzAuthListener mAuthListener;
    /* access modifiers changed from: private */
    public boolean mCanceled;
    /* access modifiers changed from: private */
    public final Context mContext;
    private String mScope;
    /* access modifiers changed from: private */
    public OnUserInfoListener mUserInfoListener;
    private UserInfoTask mUserInfoTask;

    public class UserInfoTask extends AsyncTask<String, Void, Map<String, Object>> {
        private UserInfoTask() {
        }

        public void onPreExecute() {
        }

        /* JADX WARNING: type inference failed for: r2v2 */
        /* JADX WARNING: type inference failed for: r2v3, types: [java.io.OutputStream] */
        /* JADX WARNING: type inference failed for: r2v4, types: [java.io.OutputStream] */
        /* JADX WARNING: type inference failed for: r2v5 */
        /* JADX WARNING: type inference failed for: r2v6 */
        /* JADX WARNING: type inference failed for: r2v7, types: [java.io.InputStream] */
        /* JADX WARNING: type inference failed for: r2v8 */
        /* JADX WARNING: type inference failed for: r2v9 */
        /* JADX WARNING: type inference failed for: r2v10 */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x0139, code lost:
            if (r4 == null) goto L_0x013c;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x012c A[SYNTHETIC, Splitter:B:67:0x012c] */
        /* JADX WARNING: Removed duplicated region for block: B:71:0x0131 A[SYNTHETIC, Splitter:B:71:0x0131] */
        /* JADX WARNING: Removed duplicated region for block: B:75:0x0136 A[SYNTHETIC, Splitter:B:75:0x0136] */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x0149 A[SYNTHETIC, Splitter:B:85:0x0149] */
        /* JADX WARNING: Removed duplicated region for block: B:89:0x014e A[SYNTHETIC, Splitter:B:89:0x014e] */
        /* JADX WARNING: Removed duplicated region for block: B:93:0x0153 A[SYNTHETIC, Splitter:B:93:0x0153] */
        /* JADX WARNING: Removed duplicated region for block: B:97:0x0158  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.util.Map<java.lang.String, java.lang.Object> doInBackground(java.lang.String... r12) {
            /*
                r11 = this;
                java.lang.String r0 = "value"
                java.util.HashMap r1 = new java.util.HashMap
                r1.<init>()
                r2 = -1000(0xfffffffffffffc18, float:NaN)
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                java.lang.String r3 = "code"
                r1.put(r3, r2)
                r2 = 0
                java.lang.String r4 = "https://i.flyme.cn/uc/oauth/member/getBasicInfo"
                boolean r5 = com.meizu.account.oauth.MzAccountUtil.isProductInternational()     // Catch:{ Exception -> 0x0024, all -> 0x001e }
                if (r5 == 0) goto L_0x002a
                java.lang.String r4 = "https://i.in.meizu.com/uc/oauth/member/getBasicInfo"
                goto L_0x002a
            L_0x001e:
                r11 = move-exception
                r12 = r2
                r3 = r12
                r4 = r3
                goto L_0x0147
            L_0x0024:
                r11 = move-exception
                r12 = r2
                r3 = r12
                r4 = r3
                goto L_0x0126
            L_0x002a:
                java.net.URL r5 = new java.net.URL     // Catch:{ Exception -> 0x0024, all -> 0x001e }
                r5.<init>(r4)     // Catch:{ Exception -> 0x0024, all -> 0x001e }
                java.net.URLConnection r4 = r5.openConnection()     // Catch:{ Exception -> 0x0024, all -> 0x001e }
                java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ Exception -> 0x0024, all -> 0x001e }
                java.lang.String r5 = "POST"
                r4.setRequestMethod(r5)     // Catch:{ Exception -> 0x0123, all -> 0x011f }
                r5 = 1
                r4.setInstanceFollowRedirects(r5)     // Catch:{ Exception -> 0x0123, all -> 0x011f }
                r5 = 30000(0x7530, float:4.2039E-41)
                r4.setConnectTimeout(r5)     // Catch:{ Exception -> 0x0123, all -> 0x011f }
                r4.setReadTimeout(r5)     // Catch:{ Exception -> 0x0123, all -> 0x011f }
                java.io.DataOutputStream r5 = new java.io.DataOutputStream     // Catch:{ Exception -> 0x0123, all -> 0x011f }
                java.io.OutputStream r6 = r4.getOutputStream()     // Catch:{ Exception -> 0x0123, all -> 0x011f }
                r5.<init>(r6)     // Catch:{ Exception -> 0x0123, all -> 0x011f }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
                r6.<init>()     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
                r7.<init>()     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
                java.lang.String r8 = "access_token="
                r7.append(r8)     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
                r8 = 0
                r12 = r12[r8]     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
                r7.append(r12)     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
                java.lang.String r12 = r7.toString()     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
                r6.append(r12)     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
                java.lang.String r12 = "&"
                r6.append(r12)     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
                java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
                r12.<init>()     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
                java.lang.String r7 = "lang="
                r12.append(r7)     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
                java.lang.String r7 = com.meizu.account.oauth.MzAccountUtil.getLocalLanguage()     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
                r12.append(r7)     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
                java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
                r6.append(r12)     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
                java.lang.String r12 = r6.toString()     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
                r5.writeBytes(r12)     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
                r5.flush()     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
                int r12 = r4.getResponseCode()     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
                java.lang.String r6 = "message"
                r7 = 200(0xc8, float:2.8E-43)
                if (r12 != r7) goto L_0x00e1
                java.io.InputStream r12 = r4.getInputStream()     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
                if (r12 == 0) goto L_0x00d5
                com.meizu.account.oauth.MzAuthenticator r11 = com.meizu.account.oauth.MzAuthenticator.this     // Catch:{ Exception -> 0x00c8, all -> 0x00c3 }
                java.lang.String r11 = r11.readInputStream(r12)     // Catch:{ Exception -> 0x00c8, all -> 0x00c3 }
                org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ Exception -> 0x00c8, all -> 0x00c3 }
                r8.<init>(r11)     // Catch:{ Exception -> 0x00c8, all -> 0x00c3 }
                int r11 = r8.optInt(r3)     // Catch:{ Exception -> 0x00c8, all -> 0x00c3 }
                java.lang.Integer r9 = java.lang.Integer.valueOf(r11)     // Catch:{ Exception -> 0x00c8, all -> 0x00c3 }
                r1.put(r3, r9)     // Catch:{ Exception -> 0x00c8, all -> 0x00c3 }
                if (r11 != r7) goto L_0x00cd
                org.json.JSONObject r11 = r8.optJSONObject(r0)     // Catch:{ Exception -> 0x00c8, all -> 0x00c3 }
                r1.put(r0, r11)     // Catch:{ Exception -> 0x00c8, all -> 0x00c3 }
                r11 = r2
                goto L_0x00d1
            L_0x00c3:
                r11 = move-exception
                r3 = r2
            L_0x00c5:
                r2 = r5
                goto L_0x0147
            L_0x00c8:
                r11 = move-exception
                r3 = r2
            L_0x00ca:
                r2 = r5
                goto L_0x0126
            L_0x00cd:
                java.lang.String r11 = r8.optString(r6)     // Catch:{ Exception -> 0x00c8, all -> 0x00c3 }
            L_0x00d1:
                r10 = r2
                r2 = r12
                r12 = r10
                goto L_0x010e
            L_0x00d5:
                r11 = r2
                r2 = r12
                r12 = r11
                goto L_0x010e
            L_0x00d9:
                r11 = move-exception
                r12 = r2
                r3 = r12
                goto L_0x00c5
            L_0x00dd:
                r11 = move-exception
                r12 = r2
                r3 = r12
                goto L_0x00ca
            L_0x00e1:
                java.io.InputStream r12 = r4.getErrorStream()     // Catch:{ Exception -> 0x00dd, all -> 0x00d9 }
                com.meizu.account.oauth.MzAuthenticator r11 = com.meizu.account.oauth.MzAuthenticator.this     // Catch:{ Exception -> 0x0106, all -> 0x0102 }
                java.lang.String r11 = r11.readInputStream(r12)     // Catch:{ Exception -> 0x0106, all -> 0x0102 }
                org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ Exception -> 0x0106, all -> 0x0102 }
                r7.<init>(r11)     // Catch:{ Exception -> 0x0106, all -> 0x0102 }
                boolean r11 = r7.has(r3)     // Catch:{ Exception -> 0x0106, all -> 0x0102 }
                if (r11 == 0) goto L_0x010a
                int r11 = r7.optInt(r3)     // Catch:{ Exception -> 0x0106, all -> 0x0102 }
                java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ Exception -> 0x0106, all -> 0x0102 }
                r1.put(r3, r11)     // Catch:{ Exception -> 0x0106, all -> 0x0102 }
                goto L_0x010a
            L_0x0102:
                r11 = move-exception
                r3 = r12
                r12 = r2
                goto L_0x00c5
            L_0x0106:
                r11 = move-exception
                r3 = r12
                r12 = r2
                goto L_0x00ca
            L_0x010a:
                java.lang.String r11 = r7.optString(r6)     // Catch:{ Exception -> 0x0106, all -> 0x0102 }
            L_0x010e:
                r5.close()     // Catch:{ IOException -> 0x0111 }
            L_0x0111:
                if (r2 == 0) goto L_0x0116
                r2.close()     // Catch:{ IOException -> 0x0116 }
            L_0x0116:
                if (r12 == 0) goto L_0x011b
                r12.close()     // Catch:{ IOException -> 0x011b }
            L_0x011b:
                r4.disconnect()
                goto L_0x013c
            L_0x011f:
                r11 = move-exception
                r12 = r2
                r3 = r12
                goto L_0x0147
            L_0x0123:
                r11 = move-exception
                r12 = r2
                r3 = r12
            L_0x0126:
                java.lang.String r11 = r11.getMessage()     // Catch:{ all -> 0x0146 }
                if (r2 == 0) goto L_0x012f
                r2.close()     // Catch:{ IOException -> 0x012f }
            L_0x012f:
                if (r12 == 0) goto L_0x0134
                r12.close()     // Catch:{ IOException -> 0x0134 }
            L_0x0134:
                if (r3 == 0) goto L_0x0139
                r3.close()     // Catch:{ IOException -> 0x0139 }
            L_0x0139:
                if (r4 == 0) goto L_0x013c
                goto L_0x011b
            L_0x013c:
                boolean r12 = android.text.TextUtils.isEmpty(r11)
                if (r12 != 0) goto L_0x0145
                r1.put(r0, r11)
            L_0x0145:
                return r1
            L_0x0146:
                r11 = move-exception
            L_0x0147:
                if (r2 == 0) goto L_0x014c
                r2.close()     // Catch:{ IOException -> 0x014c }
            L_0x014c:
                if (r12 == 0) goto L_0x0151
                r12.close()     // Catch:{ IOException -> 0x0151 }
            L_0x0151:
                if (r3 == 0) goto L_0x0156
                r3.close()     // Catch:{ IOException -> 0x0156 }
            L_0x0156:
                if (r4 == 0) goto L_0x015b
                r4.disconnect()
            L_0x015b:
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.account.oauth.MzAuthenticator.UserInfoTask.doInBackground(java.lang.String[]):java.util.Map");
        }

        public void onPostExecute(Map<String, Object> map) {
            String str;
            if (MzAuthenticator.this.mUserInfoListener != null) {
                int intValue = ((Integer) map.get("code")).intValue();
                if (intValue == 200) {
                    MzAuthenticator.this.mUserInfoListener.onSuccess((JSONObject) map.get(AccountConstantKt.RESPONSE_VALUE));
                    return;
                }
                if (map.containsKey(AccountConstantKt.RESPONSE_VALUE)) {
                    str = (String) map.get(AccountConstantKt.RESPONSE_VALUE);
                } else {
                    str = OAuthConstants.UNKOWN_ERROR_MSG;
                }
                MzAuthenticator.this.mUserInfoListener.onFailed(intValue, str);
            }
        }
    }

    public MzAuthenticator(Context context, String str) {
        if (context != null) {
            this.mContext = context.getApplicationContext();
            this.mScope = str;
            if (TextUtils.isEmpty(str)) {
                this.mScope = "basic";
                return;
            }
            return;
        }
        throw new IllegalArgumentException("context is null");
    }

    /* access modifiers changed from: private */
    public List<Object> getReturnMessage(Bundle bundle) {
        ArrayList arrayList = new ArrayList();
        String string = bundle.getString("errorMessage");
        int i = bundle.containsKey("errorCode") ? bundle.getInt("errorCode") : -1;
        String string2 = bundle.containsKey("cacheAccountName") ? bundle.getString("cacheAccountName") : null;
        if (i >= 0) {
            arrayList.add(Integer.valueOf(i));
            arrayList.add(string);
        } else if ("params not legal!".equalsIgnoreCase(string)) {
            arrayList.add(7);
            arrayList.add(this.mContext.getString(R.string.context_is_null));
        } else if ("get token failed!".equalsIgnoreCase(string)) {
            arrayList.add(2);
            arrayList.add(this.mContext.getString(R.string.get_token_failed));
        } else {
            if (("unknown type : " + this.mScope).equalsIgnoreCase(string)) {
                arrayList.add(8);
                arrayList.add(String.format(this.mContext.getString(R.string.scope_null_token), new Object[]{this.mScope}));
            } else if (TextUtils.isEmpty(string) || !string.startsWith("uid =") || !string.contains("not match package")) {
                arrayList.add(3);
                arrayList.add(string);
            } else {
                arrayList.add(9);
                arrayList.add(this.mContext.getString(R.string.uid_not_match));
            }
        }
        if (string2 == null) {
            string2 = "";
        }
        arrayList.add(string2);
        return arrayList;
    }

    /* access modifiers changed from: private */
    public void handleError(int i, String str, String str2) {
        OnMzAuthListener onMzAuthListener = this.mAuthListener;
        if (onMzAuthListener != null && !this.mCanceled) {
            onMzAuthListener.onError(i, str, str2);
        }
    }

    /* access modifiers changed from: private */
    public void handleIntent(Intent intent) {
        OnMzAuthListener onMzAuthListener = this.mAuthListener;
        if (onMzAuthListener != null && !this.mCanceled) {
            onMzAuthListener.onHandleIntent(intent);
        }
    }

    /* access modifiers changed from: private */
    public void handleSuccess(String str, String str2) {
        OnMzAuthListener onMzAuthListener = this.mAuthListener;
        if (onMzAuthListener != null && !this.mCanceled) {
            onMzAuthListener.onSuccess(str, str2);
        }
    }

    /* access modifiers changed from: private */
    public String readInputStream(InputStream inputStream) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return stringBuffer.toString();
            }
            stringBuffer.append(readLine);
            stringBuffer.append(StringUtils.LF);
        }
    }

    public void cancel() {
        this.mCanceled = true;
        this.mAuthListener = null;
        try {
            UserInfoTask userInfoTask = this.mUserInfoTask;
            if (userInfoTask != null && !userInfoTask.isCancelled()) {
                this.mUserInfoTask.cancel(true);
            }
            AccountManagerFuture<Bundle> accountManagerFuture = this.mAccountManagerFuture;
            if (accountManagerFuture != null) {
                accountManagerFuture.cancel(true);
            }
        } catch (Exception unused) {
        }
        this.mUserInfoListener = null;
    }

    public String[] getAuthToken(boolean z, Activity activity) throws MzAuthException {
        String str;
        AccountManager accountManager = AccountManager.get(this.mContext);
        Account account = MzAccountUtil.getAccount(this.mContext);
        if (account == null) {
            account = new Account(StarryNetConstant.DEVICE_NAME_UNKNOWN, MzContactsContract.MzAccounts.FLYME_ACCOUNT_TYPE);
        }
        Account account2 = account;
        Bundle bundle = new Bundle();
        if (z) {
            bundle.putBoolean("invalidateToken", true);
        }
        if (activity == null) {
            bundle.putBoolean("retry", false);
        }
        this.mCanceled = false;
        this.mAccountManagerFuture = accountManager.getAuthToken(account2, this.mScope, bundle, activity, (AccountManagerCallback) null, (Handler) null);
        long currentTimeMillis = System.currentTimeMillis();
        String[] strArr = new String[2];
        try {
            Bundle result = this.mAccountManagerFuture.getResult(30, TimeUnit.SECONDS);
            if (!this.mAccountManagerFuture.isDone() || this.mCanceled) {
                str = null;
            } else if (result.containsKey("authtoken")) {
                str = result.getString("authtoken");
                strArr[0] = str;
                strArr[1] = result.getString("authsecret");
            } else if (result.containsKey("intent")) {
                throw new MzAuthException((Intent) result.getParcelable("intent"));
            } else if (result.containsKey("errorMessage")) {
                List<Object> returnMessage = getReturnMessage(result);
                throw new MzAuthException(((Integer) returnMessage.get(0)).intValue(), (String) returnMessage.get(1), (String) returnMessage.get(2));
            } else {
                throw new MzAuthException(11, this.mContext.getString(R.string.unkown_error));
            }
            if (!TextUtils.isEmpty(str)) {
                return strArr;
            }
            if (!this.mAccountManagerFuture.isDone()) {
                throw new MzAuthException(6, this.mContext.getString(R.string.unsupport_operation));
            }
            throw new MzAuthException(8, String.format(this.mContext.getString(R.string.scope_null_token), new Object[]{this.mScope}));
        } catch (OperationCanceledException e) {
            long currentTimeMillis2 = System.currentTimeMillis();
            if (currentTimeMillis2 <= currentTimeMillis || (currentTimeMillis2 - currentTimeMillis) / 1000 <= 25) {
                throw new MzAuthException(4, this.mContext.getString(R.string.get_cancel), (Throwable) e);
            }
            throw new MzAuthException(10, this.mContext.getString(R.string.sync_timeout), (Throwable) e);
        } catch (Exception e2) {
            throw new MzAuthException(1, this.mContext.getString(R.string.error_is_throwed), (Throwable) e2);
        }
    }

    public Account getLocalAccount() {
        return MzAccountUtil.getAccount(this.mContext);
    }

    public String getLocalAccountId() {
        return MzAccountUtil.getAccountUid(this.mContext);
    }

    public AccountInfo getLocalAccountInfo() {
        return MzAccountUtil.getAccountInfo(this.mContext);
    }

    public void getUserInfo(String str, OnUserInfoListener onUserInfoListener) {
        if (!TextUtils.isEmpty(str)) {
            try {
                UserInfoTask userInfoTask = this.mUserInfoTask;
                if (userInfoTask != null && !userInfoTask.isCancelled()) {
                    this.mUserInfoTask.cancel(true);
                }
                this.mUserInfoListener = onUserInfoListener;
                UserInfoTask userInfoTask2 = new UserInfoTask();
                this.mUserInfoTask = userInfoTask2;
                userInfoTask2.execute(new String[]{str});
            } catch (Exception e) {
                if (onUserInfoListener != null) {
                    onUserInfoListener.onFailed(-1000, e.getMessage());
                }
            }
        } else {
            throw new IllegalArgumentException("token is null");
        }
    }

    public boolean isLoggedIn() {
        return MzAccountUtil.hasAccount(this.mContext);
    }

    public void getAuthToken(boolean z, Activity activity, OnMzAuthListener onMzAuthListener) {
        this.mAuthListener = onMzAuthListener;
        AccountManager accountManager = AccountManager.get(this.mContext);
        Account account = MzAccountUtil.getAccount(this.mContext);
        if (account == null) {
            account = new Account(StarryNetConstant.DEVICE_NAME_UNKNOWN, MzContactsContract.MzAccounts.FLYME_ACCOUNT_TYPE);
        }
        Account account2 = account;
        Bundle bundle = new Bundle();
        if (z) {
            bundle.putBoolean("invalidateToken", true);
        }
        this.mCanceled = false;
        if (activity == null) {
            bundle.putBoolean("retry", false);
        }
        this.mAccountManagerFuture = accountManager.getAuthToken(account2, this.mScope, bundle, activity, new AccountManagerCallback<Bundle>() {
            public void run(AccountManagerFuture<Bundle> accountManagerFuture) {
                if (MzAuthenticator.this.mCanceled) {
                    Log.d(MzAuthenticator.TAG, "op canceled.");
                    return;
                }
                String str = null;
                try {
                    Bundle result = accountManagerFuture.getResult();
                    if (result == null) {
                        MzAuthenticator mzAuthenticator = MzAuthenticator.this;
                        mzAuthenticator.handleError(5, mzAuthenticator.mContext.getString(R.string.future_result_is_null), (String) null);
                    } else if (result.containsKey("authtoken")) {
                        MzAuthenticator.this.handleSuccess(result.getString("authtoken"), result.getString("authsecret"));
                    } else if (result.containsKey("intent")) {
                        MzAuthenticator.this.handleIntent((Intent) result.getParcelable("intent"));
                    } else if (result.containsKey("errorMessage")) {
                        try {
                            List access$400 = MzAuthenticator.this.getReturnMessage(result);
                            int intValue = ((Integer) access$400.get(0)).intValue();
                            String str2 = (String) access$400.get(1);
                            String str3 = (String) access$400.get(2);
                            MzAuthenticator mzAuthenticator2 = MzAuthenticator.this;
                            if (!TextUtils.isEmpty(str3)) {
                                str = str3;
                            }
                            mzAuthenticator2.handleError(intValue, str2, str);
                        } catch (Exception unused) {
                        }
                    } else {
                        MzAuthenticator mzAuthenticator3 = MzAuthenticator.this;
                        mzAuthenticator3.handleError(11, mzAuthenticator3.mContext.getString(R.string.unkown_error), (String) null);
                    }
                } catch (OperationCanceledException unused2) {
                    MzAuthenticator mzAuthenticator4 = MzAuthenticator.this;
                    mzAuthenticator4.handleError(4, mzAuthenticator4.mContext.getString(R.string.get_cancel), (String) null);
                } catch (Exception e) {
                    MzAuthenticator mzAuthenticator5 = MzAuthenticator.this;
                    mzAuthenticator5.handleError(1, mzAuthenticator5.mContext.getString(R.string.error_is_throwed), (String) null);
                    String access$100 = MzAuthenticator.TAG;
                    Log.e(access$100, "[getAuthToken] " + e.getMessage());
                }
            }
        }, (Handler) null);
    }
}
