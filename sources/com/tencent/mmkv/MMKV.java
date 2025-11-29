package com.tencent.mmkv;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.util.Log;
import androidx.annotation.Nullable;
import com.honey.account.constant.AccountConstantKt;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MMKV implements SharedPreferences, SharedPreferences.Editor {

    /* renamed from: a  reason: collision with root package name */
    public static final EnumMap f9615a;
    public static final EnumMap b;
    public static final MMKVLogLevel[] c;
    public static final Set d = new HashSet();
    public static String e = null;
    public static boolean f = true;
    public static final HashMap g = new HashMap();
    public static MMKVHandler h;
    public static boolean i = false;
    public static MMKVContentChangeNotification j;
    private final long nativeHandle;

    /* renamed from: com.tencent.mmkv.MMKV$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f9616a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.tencent.mmkv.MMKVLogLevel[] r0 = com.tencent.mmkv.MMKVLogLevel.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f9616a = r0
                com.tencent.mmkv.MMKVLogLevel r1 = com.tencent.mmkv.MMKVLogLevel.LevelDebug     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f9616a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tencent.mmkv.MMKVLogLevel r1 = com.tencent.mmkv.MMKVLogLevel.LevelWarning     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f9616a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.tencent.mmkv.MMKVLogLevel r1 = com.tencent.mmkv.MMKVLogLevel.LevelError     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f9616a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.tencent.mmkv.MMKVLogLevel r1 = com.tencent.mmkv.MMKVLogLevel.LevelNone     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f9616a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.tencent.mmkv.MMKVLogLevel r1 = com.tencent.mmkv.MMKVLogLevel.LevelInfo     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mmkv.MMKV.AnonymousClass1.<clinit>():void");
        }
    }

    public interface LibLoader {
        void a(String str);
    }

    static {
        EnumMap enumMap = new EnumMap(MMKVRecoverStrategic.class);
        f9615a = enumMap;
        enumMap.put(MMKVRecoverStrategic.OnErrorDiscard, 0);
        enumMap.put(MMKVRecoverStrategic.OnErrorRecover, 1);
        EnumMap enumMap2 = new EnumMap(MMKVLogLevel.class);
        b = enumMap2;
        MMKVLogLevel mMKVLogLevel = MMKVLogLevel.LevelDebug;
        enumMap2.put(mMKVLogLevel, 0);
        MMKVLogLevel mMKVLogLevel2 = MMKVLogLevel.LevelInfo;
        enumMap2.put(mMKVLogLevel2, 1);
        MMKVLogLevel mMKVLogLevel3 = MMKVLogLevel.LevelWarning;
        enumMap2.put(mMKVLogLevel3, 2);
        MMKVLogLevel mMKVLogLevel4 = MMKVLogLevel.LevelError;
        enumMap2.put(mMKVLogLevel4, 3);
        MMKVLogLevel mMKVLogLevel5 = MMKVLogLevel.LevelNone;
        enumMap2.put(mMKVLogLevel5, 4);
        c = new MMKVLogLevel[]{mMKVLogLevel, mMKVLogLevel2, mMKVLogLevel3, mMKVLogLevel4, mMKVLogLevel5};
    }

    public MMKV(long j2) {
        this.nativeHandle = j2;
    }

    public static int A(MMKVLogLevel mMKVLogLevel) {
        int i2 = AnonymousClass1.f9616a[mMKVLogLevel.ordinal()];
        if (i2 == 1) {
            return 0;
        }
        int i3 = 2;
        if (i2 != 2) {
            i3 = 3;
            if (i2 != 3) {
                i3 = 4;
                if (i2 != 4) {
                    return 1;
                }
            }
        }
        return i3;
    }

    public static MMKV B(String str, int i2, int i3, String str2) {
        long mMKVWithAshmemFD = getMMKVWithAshmemFD(str, i2, i3, str2);
        if (mMKVWithAshmemFD != 0) {
            return new MMKV(mMKVWithAshmemFD);
        }
        throw new RuntimeException("Fail to create an ashmem MMKV instance [" + str + "] in JNI");
    }

    public static MMKV C(Context context, String str, int i2, int i3, String str2) {
        MMKV mmkv;
        if (e != null) {
            String b2 = MMKVContentProvider.b(context, Process.myPid());
            if (b2 == null || b2.length() == 0) {
                F(MMKVLogLevel.LevelError, "process name detect fail, try again later");
                throw new IllegalStateException("process name detect fail, try again later");
            }
            if (b2.contains(AccountConstantKt.CODE_SEPARTOR)) {
                Uri a2 = MMKVContentProvider.a(context);
                if (a2 != null) {
                    MMKVLogLevel mMKVLogLevel = MMKVLogLevel.LevelInfo;
                    F(mMKVLogLevel, "getting parcelable mmkv in process, Uri = " + a2);
                    Bundle bundle = new Bundle();
                    bundle.putInt("KEY_SIZE", i2);
                    bundle.putInt("KEY_MODE", i3);
                    if (str2 != null) {
                        bundle.putString("KEY_CRYPT", str2);
                    }
                    Bundle call = context.getContentResolver().call(a2, "mmkvFromAshmemID", str, bundle);
                    if (call != null) {
                        call.setClassLoader(ParcelableMMKV.class.getClassLoader());
                        ParcelableMMKV parcelableMMKV = (ParcelableMMKV) call.getParcelable("KEY");
                        if (!(parcelableMMKV == null || (mmkv = parcelableMMKV.toMMKV()) == null)) {
                            F(mMKVLogLevel, mmkv.mmapID() + " fd = " + mmkv.ashmemFD() + ", meta fd = " + mmkv.ashmemMetaFD());
                            return mmkv;
                        }
                    }
                } else {
                    F(MMKVLogLevel.LevelError, "MMKVContentProvider has invalid authority");
                    throw new IllegalStateException("MMKVContentProvider has invalid authority");
                }
            }
            F(MMKVLogLevel.LevelInfo, "getting mmkv in main process");
            long mMKVWithIDAndSize = getMMKVWithIDAndSize(str, i2, i3 | 8, str2);
            if (mMKVWithIDAndSize != 0) {
                return new MMKV(mMKVWithIDAndSize);
            }
            throw new IllegalStateException("Fail to create an Ashmem MMKV instance [" + str + "]");
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public static MMKV D(String str, int i2, String str2, String str3) {
        if (e != null) {
            return a(getMMKVWithID(str, i2, str2, str3), str, i2);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public static void F(MMKVLogLevel mMKVLogLevel, String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement stackTraceElement = stackTrace[stackTrace.length - 1];
        Integer num = (Integer) b.get(mMKVLogLevel);
        mmkvLogImp(num == null ? 0 : num.intValue(), stackTraceElement.getFileName(), stackTraceElement.getLineNumber(), stackTraceElement.getMethodName(), str);
    }

    public static MMKV a(long j2, String str, int i2) {
        String str2;
        if (j2 == 0) {
            throw new RuntimeException("Fail to create an MMKV instance [" + str + "] in JNI");
        } else if (!f) {
            return new MMKV(j2);
        } else {
            Set set = d;
            synchronized (set) {
                try {
                    if (!set.contains(Long.valueOf(j2))) {
                        if (!checkProcessMode(j2)) {
                            if (i2 == 1) {
                                str2 = "Opening a multi-process MMKV instance [" + str + "] with SINGLE_PROCESS_MODE!";
                            } else {
                                str2 = ("Opening an MMKV instance [" + str + "] with MULTI_PROCESS_MODE, ") + "while it's already been opened with SINGLE_PROCESS_MODE by someone somewhere else!";
                            }
                            throw new IllegalArgumentException(str2);
                        }
                        set.add(Long.valueOf(j2));
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            return new MMKV(j2);
        }
    }

    private native long actualSize(long j2);

    public static native long backupAllToDirectory(String str);

    public static native boolean backupOneToDirectory(String str, String str2, @Nullable String str3);

    private static native boolean checkProcessMode(long j2);

    private native boolean containsKey(long j2, String str);

    private native long count(long j2);

    private static native long createNB(int i2);

    private native boolean decodeBool(long j2, String str, boolean z);

    @Nullable
    private native byte[] decodeBytes(long j2, String str);

    private native double decodeDouble(long j2, String str, double d2);

    private native float decodeFloat(long j2, String str, float f2);

    private native int decodeInt(long j2, String str, int i2);

    private native long decodeLong(long j2, String str, long j3);

    @Nullable
    private native String decodeString(long j2, String str, @Nullable String str2);

    @Nullable
    private native String[] decodeStringSet(long j2, String str);

    private static native void destroyNB(long j2, int i2);

    private native boolean encodeBool(long j2, String str, boolean z);

    private native boolean encodeBytes(long j2, String str, @Nullable byte[] bArr);

    private native boolean encodeDouble(long j2, String str, double d2);

    private native boolean encodeFloat(long j2, String str, float f2);

    private native boolean encodeInt(long j2, String str, int i2);

    private native boolean encodeLong(long j2, String str, long j3);

    private native boolean encodeSet(long j2, String str, @Nullable String[] strArr);

    private native boolean encodeString(long j2, String str, @Nullable String str2);

    private static native long getDefaultMMKV(int i2, @Nullable String str);

    private static native long getMMKVWithAshmemFD(String str, int i2, int i3, @Nullable String str2);

    private static native long getMMKVWithID(String str, int i2, @Nullable String str2, @Nullable String str3);

    private static native long getMMKVWithIDAndSize(String str, int i2, int i3, @Nullable String str2);

    public static native boolean isFileValid(String str, @Nullable String str2);

    private static native void jniInitialize(String str, String str2, int i2);

    private static void mmkvLogImp(int i2, String str, int i3, String str2, String str3) {
        MMKVHandler mMKVHandler = h;
        if (mMKVHandler == null || !i) {
            int i4 = AnonymousClass1.f9616a[c[i2].ordinal()];
            if (i4 == 1) {
                Log.d("MMKV", str3);
            } else if (i4 == 2) {
                Log.w("MMKV", str3);
            } else if (i4 == 3) {
                Log.e("MMKV", str3);
            } else if (i4 == 5) {
                Log.i("MMKV", str3);
            }
        } else {
            mMKVHandler.a(c[i2], str, i3, str2, str3);
        }
    }

    public static MMKV n() {
        if (e != null) {
            return a(getDefaultMMKV(1, (String) null), "DefaultMMKV", 1);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public static void o() {
        synchronized (d) {
            f = false;
        }
        Log.i("MMKV", "Disable checkProcessMode()");
    }

    private static void onContentChangedByOuterProcess(String str) {
        MMKVContentChangeNotification mMKVContentChangeNotification = j;
        if (mMKVContentChangeNotification != null) {
            mMKVContentChangeNotification.a(str);
        }
    }

    public static native void onExit();

    private static int onMMKVCRCCheckFail(String str) {
        MMKVRecoverStrategic mMKVRecoverStrategic = MMKVRecoverStrategic.OnErrorDiscard;
        MMKVHandler mMKVHandler = h;
        if (mMKVHandler != null) {
            mMKVRecoverStrategic = mMKVHandler.b(str);
        }
        MMKVLogLevel mMKVLogLevel = MMKVLogLevel.LevelInfo;
        F(mMKVLogLevel, "Recover strategic for " + str + " is " + mMKVRecoverStrategic);
        Integer num = (Integer) f9615a.get(mMKVRecoverStrategic);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    private static int onMMKVFileLengthError(String str) {
        MMKVRecoverStrategic mMKVRecoverStrategic = MMKVRecoverStrategic.OnErrorDiscard;
        MMKVHandler mMKVHandler = h;
        if (mMKVHandler != null) {
            mMKVRecoverStrategic = mMKVHandler.c(str);
        }
        MMKVLogLevel mMKVLogLevel = MMKVLogLevel.LevelInfo;
        F(mMKVLogLevel, "Recover strategic for " + str + " is " + mMKVRecoverStrategic);
        Integer num = (Integer) f9615a.get(mMKVRecoverStrategic);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static String p(String str, String str2, LibLoader libLoader, MMKVLogLevel mMKVLogLevel) {
        if (libLoader != null) {
            libLoader.a("mmkv");
        } else {
            System.loadLibrary("mmkv");
        }
        jniInitialize(str, str2, A(mMKVLogLevel));
        e = str;
        return str;
    }

    public static native int pageSize();

    public static void q() {
        synchronized (d) {
            f = true;
        }
        Log.i("MMKV", "Enable checkProcessMode()");
    }

    private native void removeValueForKey(long j2, String str);

    public static native long restoreAllFromDirectory(String str);

    public static native boolean restoreOneMMKVFromDirectory(String str, String str2, @Nullable String str3);

    private static native void setCallbackHandler(boolean z, boolean z2);

    private static native void setLogLevel(int i2);

    private static native void setWantsContentChangeNotify(boolean z);

    private native void sync(boolean z);

    private native long totalSize(long j2);

    private native int valueSize(long j2, String str, boolean z);

    public static native String version();

    private native int writeValueToNB(long j2, String str, long j3, int i2);

    public static String x() {
        return e;
    }

    public static String y(Context context) {
        return z(context, context.getFilesDir().getAbsolutePath() + "/mmkv", (LibLoader) null, MMKVLogLevel.LevelInfo);
    }

    public static String z(Context context, String str, LibLoader libLoader, MMKVLogLevel mMKVLogLevel) {
        if ((context.getApplicationInfo().flags & 2) == 0) {
            o();
        } else {
            q();
        }
        return p(str, context.getCacheDir().getAbsolutePath(), libLoader, mMKVLogLevel);
    }

    public void E(String str) {
        removeValueForKey(this.nativeHandle, str);
    }

    @Nullable
    public native String[] allKeys();

    public void apply() {
        sync(false);
    }

    public native int ashmemFD();

    public native int ashmemMetaFD();

    public boolean b(String str) {
        return containsKey(this.nativeHandle, str);
    }

    public boolean c(String str) {
        return decodeBool(this.nativeHandle, str, false);
    }

    public native void checkContentChangedByOuterProcess();

    public native void checkReSetCryptKey(@Nullable String str);

    public SharedPreferences.Editor clear() {
        clearAll();
        return this;
    }

    public native void clearAll();

    public native void clearMemoryCache();

    public native void close();

    public boolean commit() {
        sync(true);
        return true;
    }

    public boolean contains(String str) {
        return b(str);
    }

    @Nullable
    public native String cryptKey();

    public boolean d(String str, boolean z) {
        return decodeBool(this.nativeHandle, str, z);
    }

    public int e(String str, int i2) {
        return decodeInt(this.nativeHandle, str, i2);
    }

    public SharedPreferences.Editor edit() {
        return this;
    }

    public long f(String str) {
        return decodeLong(this.nativeHandle, str, 0);
    }

    public long g(String str, long j2) {
        return decodeLong(this.nativeHandle, str, j2);
    }

    public Map getAll() {
        throw new UnsupportedOperationException("Intentionally Not Supported. Use allKeys() instead, getAll() not implement because type-erasure inside mmkv");
    }

    public boolean getBoolean(String str, boolean z) {
        return decodeBool(this.nativeHandle, str, z);
    }

    public float getFloat(String str, float f2) {
        return decodeFloat(this.nativeHandle, str, f2);
    }

    public int getInt(String str, int i2) {
        return decodeInt(this.nativeHandle, str, i2);
    }

    public long getLong(String str, long j2) {
        return decodeLong(this.nativeHandle, str, j2);
    }

    public String getString(String str, String str2) {
        return decodeString(this.nativeHandle, str, str2);
    }

    public Set getStringSet(String str, Set set) {
        return l(str, set);
    }

    public Parcelable h(String str, Class cls) {
        return i(str, cls, (Parcelable) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: android.os.Parcelable$Creator} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.os.Parcelable i(java.lang.String r3, java.lang.Class r4, android.os.Parcelable r5) {
        /*
            r2 = this;
            if (r4 != 0) goto L_0x0003
            return r5
        L_0x0003:
            long r0 = r2.nativeHandle
            byte[] r2 = r2.decodeBytes(r0, r3)
            if (r2 != 0) goto L_0x000c
            return r5
        L_0x000c:
            android.os.Parcel r3 = android.os.Parcel.obtain()
            int r0 = r2.length
            r1 = 0
            r3.unmarshall(r2, r1, r0)
            r3.setDataPosition(r1)
            java.lang.String r2 = r4.toString()     // Catch:{ Exception -> 0x004c }
            java.util.HashMap r0 = g     // Catch:{ Exception -> 0x004c }
            monitor-enter(r0)     // Catch:{ Exception -> 0x004c }
            java.lang.Object r1 = r0.get(r2)     // Catch:{ all -> 0x003b }
            android.os.Parcelable$Creator r1 = (android.os.Parcelable.Creator) r1     // Catch:{ all -> 0x003b }
            if (r1 != 0) goto L_0x003d
            java.lang.String r1 = "CREATOR"
            java.lang.reflect.Field r4 = r4.getField(r1)     // Catch:{ all -> 0x003b }
            r1 = 0
            java.lang.Object r4 = r4.get(r1)     // Catch:{ all -> 0x003b }
            r1 = r4
            android.os.Parcelable$Creator r1 = (android.os.Parcelable.Creator) r1     // Catch:{ all -> 0x003b }
            if (r1 == 0) goto L_0x003d
            r0.put(r2, r1)     // Catch:{ all -> 0x003b }
            goto L_0x003d
        L_0x003b:
            r2 = move-exception
            goto L_0x0065
        L_0x003d:
            monitor-exit(r0)     // Catch:{ all -> 0x003b }
            if (r1 == 0) goto L_0x004e
            java.lang.Object r2 = r1.createFromParcel(r3)     // Catch:{ Exception -> 0x004c }
            android.os.Parcelable r2 = (android.os.Parcelable) r2     // Catch:{ Exception -> 0x004c }
            r3.recycle()
            return r2
        L_0x004a:
            r2 = move-exception
            goto L_0x0074
        L_0x004c:
            r2 = move-exception
            goto L_0x0067
        L_0x004e:
            java.lang.Exception r4 = new java.lang.Exception     // Catch:{ Exception -> 0x004c }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004c }
            r0.<init>()     // Catch:{ Exception -> 0x004c }
            java.lang.String r1 = "Parcelable protocol requires a non-null static Parcelable.Creator object called CREATOR on class "
            r0.append(r1)     // Catch:{ Exception -> 0x004c }
            r0.append(r2)     // Catch:{ Exception -> 0x004c }
            java.lang.String r2 = r0.toString()     // Catch:{ Exception -> 0x004c }
            r4.<init>(r2)     // Catch:{ Exception -> 0x004c }
            throw r4     // Catch:{ Exception -> 0x004c }
        L_0x0065:
            monitor-exit(r0)     // Catch:{ all -> 0x003b }
            throw r2     // Catch:{ Exception -> 0x004c }
        L_0x0067:
            com.tencent.mmkv.MMKVLogLevel r4 = com.tencent.mmkv.MMKVLogLevel.LevelError     // Catch:{ all -> 0x004a }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x004a }
            F(r4, r2)     // Catch:{ all -> 0x004a }
            r3.recycle()
            return r5
        L_0x0074:
            r3.recycle()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mmkv.MMKV.i(java.lang.String, java.lang.Class, android.os.Parcelable):android.os.Parcelable");
    }

    public String j(String str) {
        return decodeString(this.nativeHandle, str, (String) null);
    }

    public String k(String str, String str2) {
        return decodeString(this.nativeHandle, str, str2);
    }

    public Set l(String str, Set set) {
        return m(str, set, HashSet.class);
    }

    public native void lock();

    public Set m(String str, Set set, Class cls) {
        String[] decodeStringSet = decodeStringSet(this.nativeHandle, str);
        if (decodeStringSet == null) {
            return set;
        }
        try {
            Set set2 = (Set) cls.newInstance();
            set2.addAll(Arrays.asList(decodeStringSet));
            return set2;
        } catch (IllegalAccessException | InstantiationException unused) {
            return set;
        }
    }

    public native String mmapID();

    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        encodeBool(this.nativeHandle, str, z);
        return this;
    }

    public SharedPreferences.Editor putFloat(String str, float f2) {
        encodeFloat(this.nativeHandle, str, f2);
        return this;
    }

    public SharedPreferences.Editor putInt(String str, int i2) {
        encodeInt(this.nativeHandle, str, i2);
        return this;
    }

    public SharedPreferences.Editor putLong(String str, long j2) {
        encodeLong(this.nativeHandle, str, j2);
        return this;
    }

    public SharedPreferences.Editor putString(String str, String str2) {
        encodeString(this.nativeHandle, str, str2);
        return this;
    }

    public SharedPreferences.Editor putStringSet(String str, Set set) {
        v(str, set);
        return this;
    }

    public boolean r(String str, int i2) {
        return encodeInt(this.nativeHandle, str, i2);
    }

    public native boolean reKey(@Nullable String str);

    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        throw new UnsupportedOperationException("Intentionally Not implement in MMKV");
    }

    public SharedPreferences.Editor remove(String str) {
        E(str);
        return this;
    }

    public native void removeValuesForKeys(String[] strArr);

    public boolean s(String str, long j2) {
        return encodeLong(this.nativeHandle, str, j2);
    }

    public boolean t(String str, Parcelable parcelable) {
        if (parcelable == null) {
            return encodeBytes(this.nativeHandle, str, (byte[]) null);
        }
        Parcel obtain = Parcel.obtain();
        parcelable.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return encodeBytes(this.nativeHandle, str, marshall);
    }

    public native void trim();

    public native boolean tryLock();

    public boolean u(String str, String str2) {
        return encodeString(this.nativeHandle, str, str2);
    }

    public native void unlock();

    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        throw new UnsupportedOperationException("Intentionally Not implement in MMKV");
    }

    public boolean v(String str, Set set) {
        return encodeSet(this.nativeHandle, str, set == null ? null : (String[]) set.toArray(new String[0]));
    }

    public boolean w(String str, boolean z) {
        return encodeBool(this.nativeHandle, str, z);
    }
}
