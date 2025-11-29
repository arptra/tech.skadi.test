package com.meizu.net.pedometerprovider.manager;

import android.content.Context;
import android.net.Uri;

public class UserManager {
    private static final String COL_ADDSHUTCUT = "addshutcat";
    private static final String COL_AGE = "age";
    private static final String COL_COUNT = "count";
    private static final String COL_GENDER = "gender";
    private static final String COL_HEIGHT = "height";
    private static final String COL_LASTUID = "uid";
    private static final String COL_TARGET = "target";
    private static final String COL_TIME = "time";
    private static final String COL_TOKEN = "token";
    private static final String COL_UID = "uid";
    private static final String COL_WEIGHT = "weight";
    private static final Uri CONTENT_URI;
    private static final String SETTING_TABLE_NAME = "settinginfo";
    private static final Uri SETTING_URI;
    private static final String TAG = "Pedo_Manager";
    private static final String URI_AUTHORITY = "com.meizu.net.pedometer";
    private static final String USER_TABLE_NAME = "userinfo";
    private static final Uri USER_URI;
    private static UserManager mInstance;
    private Context mContext;

    static {
        Uri parse = Uri.parse("content://com.meizu.net.pedometer/");
        CONTENT_URI = parse;
        USER_URI = Uri.parse(parse.toString() + USER_TABLE_NAME);
        SETTING_URI = Uri.parse(parse.toString() + SETTING_TABLE_NAME);
    }

    private UserManager(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static synchronized UserManager getInstance(Context context) {
        UserManager userManager;
        synchronized (UserManager.class) {
            try {
                if (mInstance == null) {
                    mInstance = new UserManager(context);
                }
                userManager = mInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return userManager;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0040, code lost:
        if (r1 != null) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0042, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004c, code lost:
        if (r1 == null) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004f, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.meizu.net.pedometerprovider.manager.bean.SettInfo getSetingInfo() {
        /*
            r8 = this;
            com.meizu.net.pedometerprovider.manager.bean.SettInfo r0 = new com.meizu.net.pedometerprovider.manager.bean.SettInfo
            r0.<init>()
            r1 = 0
            android.content.Context r8 = r8.mContext     // Catch:{ Exception -> 0x004c, all -> 0x0038 }
            android.content.ContentResolver r2 = r8.getContentResolver()     // Catch:{ Exception -> 0x004c, all -> 0x0038 }
            android.net.Uri r3 = SETTING_URI     // Catch:{ Exception -> 0x004c, all -> 0x0038 }
            java.lang.String r8 = "addshutcat"
            java.lang.String r4 = "uid"
            java.lang.String[] r4 = new java.lang.String[]{r8, r4}     // Catch:{ Exception -> 0x004c, all -> 0x0038 }
            r6 = 0
            r7 = 0
            r5 = 0
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x004c, all -> 0x0038 }
            if (r1 == 0) goto L_0x0040
            int r8 = r1.getCount()     // Catch:{ Exception -> 0x004c, all -> 0x0038 }
            if (r8 == 0) goto L_0x0040
            r1.moveToFirst()     // Catch:{ Exception -> 0x004c, all -> 0x0038 }
            r8 = 0
            int r2 = r1.getInt(r8)     // Catch:{ Exception -> 0x004c, all -> 0x0038 }
            r3 = 1
            java.lang.String r4 = r1.getString(r3)     // Catch:{ Exception -> 0x004c, all -> 0x0038 }
            if (r2 != 0) goto L_0x003a
            r0.setShutcatAdd(r8)     // Catch:{ Exception -> 0x004c, all -> 0x0038 }
            goto L_0x003d
        L_0x0038:
            r8 = move-exception
            goto L_0x0046
        L_0x003a:
            r0.setShutcatAdd(r3)     // Catch:{ Exception -> 0x004c, all -> 0x0038 }
        L_0x003d:
            r0.setUid(r4)     // Catch:{ Exception -> 0x004c, all -> 0x0038 }
        L_0x0040:
            if (r1 == 0) goto L_0x004f
        L_0x0042:
            r1.close()
            goto L_0x004f
        L_0x0046:
            if (r1 == 0) goto L_0x004b
            r1.close()
        L_0x004b:
            throw r8
        L_0x004c:
            if (r1 == 0) goto L_0x004f
            goto L_0x0042
        L_0x004f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.net.pedometerprovider.manager.UserManager.getSetingInfo():com.meizu.net.pedometerprovider.manager.bean.SettInfo");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.meizu.net.pedometerprovider.manager.bean.UInfo getUserInfo() {
        /*
            r11 = this;
            com.meizu.net.pedometerprovider.manager.bean.UInfo r0 = new com.meizu.net.pedometerprovider.manager.bean.UInfo
            r0.<init>()
            r1 = 0
            android.content.Context r11 = r11.mContext     // Catch:{ Exception -> 0x007c, all -> 0x0075 }
            android.content.ContentResolver r2 = r11.getContentResolver()     // Catch:{ Exception -> 0x007c, all -> 0x0075 }
            android.net.Uri r3 = USER_URI     // Catch:{ Exception -> 0x007c, all -> 0x0075 }
            java.lang.String r4 = "uid"
            java.lang.String r5 = "gender"
            java.lang.String r6 = "weight"
            java.lang.String r7 = "height"
            java.lang.String r8 = "target"
            java.lang.String r9 = "age"
            java.lang.String r10 = "token"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5, r6, r7, r8, r9, r10}     // Catch:{ Exception -> 0x007c, all -> 0x0075 }
            r6 = 0
            r7 = 0
            r5 = 0
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x007c, all -> 0x0075 }
            if (r11 == 0) goto L_0x006f
            int r2 = r11.getCount()     // Catch:{ Exception -> 0x006d, all -> 0x006a }
            if (r2 != 0) goto L_0x0033
            r11.close()
            return r1
        L_0x0033:
            r11.moveToFirst()     // Catch:{ Exception -> 0x006d, all -> 0x006a }
            r1 = 0
            java.lang.String r1 = r11.getString(r1)     // Catch:{ Exception -> 0x006d, all -> 0x006a }
            r2 = 1
            int r2 = r11.getInt(r2)     // Catch:{ Exception -> 0x006d, all -> 0x006a }
            r3 = 2
            float r3 = r11.getFloat(r3)     // Catch:{ Exception -> 0x006d, all -> 0x006a }
            r4 = 3
            float r4 = r11.getFloat(r4)     // Catch:{ Exception -> 0x006d, all -> 0x006a }
            r5 = 4
            int r5 = r11.getInt(r5)     // Catch:{ Exception -> 0x006d, all -> 0x006a }
            r6 = 5
            int r6 = r11.getInt(r6)     // Catch:{ Exception -> 0x006d, all -> 0x006a }
            r0.setUserId(r1)     // Catch:{ Exception -> 0x006d, all -> 0x006a }
            r0.setGender(r2)     // Catch:{ Exception -> 0x006d, all -> 0x006a }
            r0.setWeight(r3)     // Catch:{ Exception -> 0x006d, all -> 0x006a }
            r0.setHeight(r4)     // Catch:{ Exception -> 0x006d, all -> 0x006a }
            r0.setTarget(r5)     // Catch:{ Exception -> 0x006d, all -> 0x006a }
            r0.setAge(r6)     // Catch:{ Exception -> 0x006d, all -> 0x006a }
            r11.close()
            return r0
        L_0x006a:
            r0 = move-exception
            r1 = r11
            goto L_0x0076
        L_0x006d:
            r1 = r11
            goto L_0x007c
        L_0x006f:
            if (r11 == 0) goto L_0x0074
            r11.close()
        L_0x0074:
            return r1
        L_0x0075:
            r0 = move-exception
        L_0x0076:
            if (r1 == 0) goto L_0x007b
            r1.close()
        L_0x007b:
            throw r0
        L_0x007c:
            if (r1 == 0) goto L_0x0081
            r1.close()
        L_0x0081:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.net.pedometerprovider.manager.UserManager.getUserInfo():com.meizu.net.pedometerprovider.manager.bean.UInfo");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0066  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void saveSettingInfo(com.meizu.net.pedometerprovider.manager.bean.SettInfo r11) {
        /*
            r10 = this;
            java.lang.String r0 = "uid"
            java.lang.String r1 = "addshutcat"
            r2 = 0
            android.content.Context r3 = r10.mContext     // Catch:{ Exception -> 0x0064, all -> 0x005d }
            android.content.ContentResolver r4 = r3.getContentResolver()     // Catch:{ Exception -> 0x0064, all -> 0x005d }
            android.net.Uri r3 = SETTING_URI     // Catch:{ Exception -> 0x0064, all -> 0x005d }
            java.lang.String[] r6 = new java.lang.String[]{r1, r0}     // Catch:{ Exception -> 0x0064, all -> 0x005d }
            r8 = 0
            r9 = 0
            r7 = 0
            r5 = r3
            android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0064, all -> 0x005d }
            if (r4 != 0) goto L_0x0021
            if (r4 == 0) goto L_0x0020
            r4.close()
        L_0x0020:
            return
        L_0x0021:
            r4.moveToFirst()     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            boolean r5 = r11.isShutcatAdd()     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            android.content.ContentValues r6 = new android.content.ContentValues     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            r6.<init>()     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            r6.put(r1, r5)     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            java.lang.String r1 = r11.getUid()     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            r6.put(r0, r1)     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            int r0 = r4.getCount()     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            if (r0 <= 0) goto L_0x0050
            android.content.Context r0 = r10.mContext     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            r0.update(r3, r6, r2, r2)     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            goto L_0x0059
        L_0x004b:
            r10 = move-exception
            r2 = r4
            goto L_0x005e
        L_0x004e:
            r2 = r4
            goto L_0x0064
        L_0x0050:
            android.content.Context r0 = r10.mContext     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            r0.insert(r3, r6)     // Catch:{ Exception -> 0x004e, all -> 0x004b }
        L_0x0059:
            r4.close()
            goto L_0x0069
        L_0x005d:
            r10 = move-exception
        L_0x005e:
            if (r2 == 0) goto L_0x0063
            r2.close()
        L_0x0063:
            throw r10
        L_0x0064:
            if (r2 == 0) goto L_0x0069
            r2.close()
        L_0x0069:
            android.content.Context r10 = r10.mContext
            com.meizu.net.pedometerprovider.manager.PedoManager r10 = com.meizu.net.pedometerprovider.manager.PedoManager.getInstance(r10)
            java.lang.String r11 = r11.getUid()
            r10.setUserId((java.lang.String) r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.net.pedometerprovider.manager.UserManager.saveSettingInfo(com.meizu.net.pedometerprovider.manager.bean.SettInfo):void");
    }
}
