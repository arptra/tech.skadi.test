package com.honey.account.utils.log;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.honey.account.h2.a;
import com.honey.account.h2.b;
import com.honey.account.utils.encrypt.EncryptBase64;
import com.honey.account.utils.system.FileUtilsKt;
import com.honey.account.utils.system.SystemUtilsKt;
import com.honey.account.utils.thread.IOExecutor;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel;
import com.upuphone.starrynet.payload.PayloadConstant;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import org.apache.commons.codec.language.Soundex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\tH\u0002J \u0010$\u001a\u00020 2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\tH\u0002J\b\u0010%\u001a\u00020 H\u0002J\u0016\u0010&\u001a\u00020 2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\tJ\u0016\u0010'\u001a\u00020 2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\tJ\u001e\u0010'\u001a\u00020 2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\t2\u0006\u0010(\u001a\u00020)J\"\u0010*\u001a\u0004\u0018\u00010\t2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\tH\u0002J\u0016\u0010+\u001a\u00020 2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\tJ\u000e\u0010,\u001a\u00020 2\u0006\u0010-\u001a\u00020.J>\u0010,\u001a\u00020 2\u0006\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\t2\b\b\u0002\u00101\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u00020\u00042\b\b\u0002\u00103\u001a\u00020\u00042\b\b\u0002\u00104\u001a\u00020\u0018J\u0006\u00105\u001a\u00020 J\b\u00106\u001a\u00020 H\u0002J\u0016\u00107\u001a\u00020 2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\t0\rj\b\u0012\u0004\u0012\u00020\t`\u000eX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/honey/account/utils/log/LogUtils;", "", "()V", "DEFAULT_CACHE_COUNT", "", "DEFAULT_CACHE_DURATION", "", "DEFAULT_FILE_STORAGE_COUNT", "TAG", "", "mCacheCounter", "mCacheDuration", "mCachedLogList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mDelayHandler", "Landroid/os/Handler;", "getMDelayHandler", "()Landroid/os/Handler;", "mDelayHandler$delegate", "Lkotlin/Lazy;", "mEncryptBase64", "Lcom/honey/account/utils/encrypt/EncryptBase64;", "mIsDebug", "", "mPid", "getMPid", "()Ljava/lang/String;", "mPid$delegate", "mSaveLog", "Lcom/honey/account/utils/log/SaveLog;", "addCached", "", "level", "tag", "msg", "addLogInfo", "checkLogCount", "d", "e", "tr", "", "getLogInfo", "i", "init", "context", "Landroid/content/Context;", "filePath", "encryptionKey", "cacheDuration", "cacheCounter", "storageCount", "isDebug", "save", "startDelayTimer", "w", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LogUtils {
    private static final int DEFAULT_CACHE_COUNT = 10;
    private static final long DEFAULT_CACHE_DURATION = 60000;
    private static final int DEFAULT_FILE_STORAGE_COUNT = 7;
    @NotNull
    public static final LogUtils INSTANCE = new LogUtils();
    @NotNull
    private static final String TAG = "LogUtils";
    private static int mCacheCounter;
    private static long mCacheDuration;
    @NotNull
    private static final ArrayList<String> mCachedLogList = new ArrayList<>();
    @NotNull
    private static final Lazy mDelayHandler$delegate = LazyKt.lazy(LogUtils$mDelayHandler$2.INSTANCE);
    @Nullable
    private static EncryptBase64 mEncryptBase64;
    private static boolean mIsDebug;
    @NotNull
    private static final Lazy mPid$delegate = LazyKt.lazy(LogUtils$mPid$2.INSTANCE);
    @Nullable
    private static SaveLog mSaveLog;

    private LogUtils() {
    }

    private final void addCached(String str, String str2, String str3) {
        SaveLog saveLog = mSaveLog;
        if (saveLog != null) {
            String mFilePath = saveLog != null ? saveLog.getMFilePath() : null;
            if (mFilePath != null && mFilePath.length() != 0) {
                synchronized (mCachedLogList) {
                    LogUtils logUtils = INSTANCE;
                    logUtils.startDelayTimer();
                    logUtils.addLogInfo(str, str2, str3);
                    logUtils.checkLogCount();
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
    }

    private final void addLogInfo(String str, String str2, String str3) {
        try {
            String logInfo = getLogInfo(str, str2, str3);
            if (logInfo != null) {
                mCachedLogList.add(logInfo);
            }
        } catch (Exception e) {
            Log.e(TAG, "add logInfo error " + e.getMessage());
        }
    }

    private final void checkLogCount() {
        if (mCachedLogList.size() >= mCacheCounter) {
            save();
        }
    }

    private final String getLogInfo(String str, String str2, String str3) {
        String str4 = (new SimpleDateFormat("MM-dd HH:mm:ss").format(new Date()) + ' ' + getMPid() + Soundex.SILENT_MARKER + Thread.currentThread().getId() + ' ' + str + '/') + str2 + ' ' + str3;
        EncryptBase64 encryptBase64 = mEncryptBase64;
        if (encryptBase64 == null) {
            return str4;
        }
        if (encryptBase64 == null) {
            return null;
        }
        byte[] bytes = str4.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return encryptBase64.encode(bytes);
    }

    private final Handler getMDelayHandler() {
        return (Handler) mDelayHandler$delegate.getValue();
    }

    private final String getMPid() {
        return (String) mPid$delegate.getValue();
    }

    public static /* synthetic */ void init$default(LogUtils logUtils, String str, String str2, long j, int i, int i2, boolean z, int i3, Object obj) {
        logUtils.init(str, str2, (i3 & 4) != 0 ? 60000 : j, (i3 & 8) != 0 ? 10 : i, (i3 & 16) != 0 ? 7 : i2, (i3 & 32) != 0 ? false : z);
    }

    /* access modifiers changed from: private */
    public static final void save$lambda$1() {
        Boolean bool;
        ArrayList arrayList;
        ArrayList<String> arrayList2 = mCachedLogList;
        synchronized (arrayList2) {
            bool = null;
            INSTANCE.getMDelayHandler().removeCallbacksAndMessages((Object) null);
            arrayList = new ArrayList(arrayList2);
            arrayList2.clear();
            Unit unit = Unit.INSTANCE;
        }
        SaveLog saveLog = mSaveLog;
        if (saveLog != null) {
            bool = Boolean.valueOf(saveLog.save(arrayList));
        }
        Intrinsics.checkNotNull(bool);
        if (!bool.booleanValue()) {
            Log.e(TAG, "save log fail.");
        }
    }

    private final void startDelayTimer() {
        if (mCachedLogList.size() == 0) {
            getMDelayHandler().postDelayed(new a(), mCacheDuration);
        }
    }

    /* access modifiers changed from: private */
    public static final void startDelayTimer$lambda$3() {
        INSTANCE.save();
    }

    public final void d(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        if (mIsDebug) {
            Log.d(str, str2);
        }
        addCached("D", str, str2);
    }

    public final void e(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        Log.e(str, str2);
        addCached(ExifInterface.LONGITUDE_EAST, str, str2);
    }

    public final void i(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        if (mIsDebug) {
            Log.i(str, str2);
        }
        addCached("I", str, str2);
    }

    public final void init(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String documentsPath = FileUtilsKt.getDocumentsPath(context);
        String processName = SystemUtilsKt.getProcessName(context);
        if (processName == null || processName.length() == 0) {
            processName = "default";
        } else if (Intrinsics.areEqual((Object) context.getPackageName(), (Object) processName)) {
            processName = FastRecordMainViewModel.RECORD_TYPE_ALL;
        } else {
            String packageName = context.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
            new Regex(packageName).replace((CharSequence) processName, "");
        }
        init$default(this, (documentsPath + "/log/") + processName, "lo", 0, 0, 0, false, 60, (Object) null);
    }

    public final void save() {
        SaveLog saveLog = mSaveLog;
        if (saveLog != null) {
            String mFilePath = saveLog != null ? saveLog.getMFilePath() : null;
            if (mFilePath != null && mFilePath.length() != 0) {
                IOExecutor.INSTANCE.execute(new b());
            }
        }
    }

    public final void w(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        Log.w(str, str2);
        addCached(ExifInterface.LONGITUDE_WEST, str, str2);
    }

    public final void e(@NotNull String str, @NotNull String str2, @NotNull Throwable th) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        Intrinsics.checkNotNullParameter(th, "tr");
        Log.e(str, str2);
        addCached(ExifInterface.LONGITUDE_EAST, str, str2 + 10 + Log.getStackTraceString(th));
    }

    public final void init(@NotNull String str, @NotNull String str2, long j, int i, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "filePath");
        Intrinsics.checkNotNullParameter(str2, "encryptionKey");
        mCacheDuration = j;
        mCacheCounter = i;
        if (str.length() > 0) {
            mSaveLog = new SaveLog(i2, str);
        }
        if (str2.length() > 0) {
            mEncryptBase64 = new EncryptBase64(str2);
        }
        mIsDebug = z;
    }
}
