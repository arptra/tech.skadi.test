package com.upuphone.ar.fastrecord.phone;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mmkv.MMKV;
import com.upuphone.ar.fastrecord.phone.db.FastRecordDao;
import com.upuphone.ar.fastrecord.phone.db.FastRecordPersonDao;
import com.upuphone.ar.fastrecord.phone.db.FastRecordPersonHistoryDao;
import com.upuphone.ar.fastrecord.phone.db.FastRecordSummaryDao;
import com.upuphone.ar.fastrecord.phone.db.FastRecordTagDao;
import com.upuphone.ar.fastrecord.phone.db.FastRecordTagHistoryDao;
import com.upuphone.ar.fastrecord.phone.db.FastRecordTodoItemDao;
import com.upuphone.ar.fastrecord.phone.db.FastRecordVoiceDao;
import com.upuphone.ar.fastrecord.phone.db.FastRecordVoiceWordDao;
import com.upuphone.ar.fastrecord.phone.db.RecordDatabase;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.starrynet.RecordConnectManager;
import com.upuphone.ar.fastrecord.phone.starrynet.RecordInterConnectHelper;
import com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordMainActivity;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordAppViewModel;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordHistoryAsrOperator;
import com.upuphone.ar.fastrecord.phone.utils.FastRecordTitleHelper;
import com.upuphone.ar.fastrecord.phone.utils.RecordDataSaveUtil;
import com.upuphone.ar.shorthand.phone.utils.RecordGsonUtils;
import com.upuphone.xr.interconnect.entity.AccountInfo;
import com.upuphone.xr.interconnect.entity.NaviLocationInfo;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.sapp.context.SdkContext;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 32\u00020\u0001:\u000234B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020#J\b\u0010$\u001a\u0004\u0018\u00010%J\u0006\u0010&\u001a\u00020'J\u000e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0004J\b\u0010+\u001a\u00020)H\u0002J\u0010\u0010,\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0004H\u0002J\u0010\u0010-\u001a\u00020)2\b\u0010.\u001a\u0004\u0018\u00010/J\u000e\u00100\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0004J\u000e\u00101\u001a\u00020)2\u0006\u00102\u001a\u00020'R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/FastRecordManager;", "", "()V", "appContext", "Landroid/content/Context;", "appViewModel", "Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordAppViewModel;", "getAppViewModel", "()Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordAppViewModel;", "appViewModel$delegate", "Lkotlin/Lazy;", "database", "Lcom/upuphone/ar/fastrecord/phone/db/RecordDatabase;", "getDatabase", "()Lcom/upuphone/ar/fastrecord/phone/db/RecordDatabase;", "database$delegate", "isInit", "", "fastRecordDao", "Lcom/upuphone/ar/fastrecord/phone/db/FastRecordDao;", "fastRecordPersonDao", "Lcom/upuphone/ar/fastrecord/phone/db/FastRecordPersonDao;", "fastRecordPersonHistoryDao", "Lcom/upuphone/ar/fastrecord/phone/db/FastRecordPersonHistoryDao;", "fastRecordSummaryDao", "Lcom/upuphone/ar/fastrecord/phone/db/FastRecordSummaryDao;", "fastRecordTagDao", "Lcom/upuphone/ar/fastrecord/phone/db/FastRecordTagDao;", "fastRecordTagHistoryDao", "Lcom/upuphone/ar/fastrecord/phone/db/FastRecordTagHistoryDao;", "fastRecordTodoItemDao", "Lcom/upuphone/ar/fastrecord/phone/db/FastRecordTodoItemDao;", "fastRecordVoice", "Lcom/upuphone/ar/fastrecord/phone/db/FastRecordVoiceDao;", "fastRecordVoiceWordDao", "Lcom/upuphone/ar/fastrecord/phone/db/FastRecordVoiceWordDao;", "getLocation", "Lcom/upuphone/xr/interconnect/entity/NaviLocationInfo;", "getUuId", "", "init", "", "context", "initAudioMulti", "initRecordTitle", "setConnectDevice", "device", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "startMainActivity", "syncAccountInfo", "info", "Companion", "SingleHolder", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FastRecordManager {
    @NotNull
    private static final String AUDIO_MULTI = "com.upuphone.ar.fastrecord";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String TAG = "FastRecordManager";
    @Nullable
    private Context appContext;
    @NotNull
    private final Lazy appViewModel$delegate = LazyKt.lazy(FastRecordManager$appViewModel$2.INSTANCE);
    @NotNull
    private final Lazy database$delegate = LazyKt.lazy(new FastRecordManager$database$2(this));
    private boolean isInit;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/FastRecordManager$Companion;", "", "()V", "AUDIO_MULTI", "", "TAG", "getInstance", "Lcom/upuphone/ar/fastrecord/phone/FastRecordManager;", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final FastRecordManager getInstance() {
            return SingleHolder.INSTANCE.getInstance();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/FastRecordManager$SingleHolder;", "", "()V", "instance", "Lcom/upuphone/ar/fastrecord/phone/FastRecordManager;", "getInstance", "()Lcom/upuphone/ar/fastrecord/phone/FastRecordManager;", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class SingleHolder {
        @NotNull
        public static final SingleHolder INSTANCE = new SingleHolder();
        @NotNull
        private static final FastRecordManager instance = new FastRecordManager();

        private SingleHolder() {
        }

        @NotNull
        public final FastRecordManager getInstance() {
            return instance;
        }
    }

    private final FastRecordAppViewModel getAppViewModel() {
        return (FastRecordAppViewModel) this.appViewModel$delegate.getValue();
    }

    private final RecordDatabase getDatabase() {
        return (RecordDatabase) this.database$delegate.getValue();
    }

    @JvmStatic
    @NotNull
    public static final FastRecordManager getInstance() {
        return Companion.getInstance();
    }

    private final void initAudioMulti() {
        SdkContext.f6675a.c().b("com.upuphone.ar.fastrecord", FastRecordManager$initAudioMulti$1.INSTANCE);
    }

    private final void initRecordTitle(Context context) {
        FastRecordTitleHelper.Companion.init(context);
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new FastRecordManager$initRecordTitle$1(this, (Continuation<? super FastRecordManager$initRecordTitle$1>) null), 3, (Object) null);
    }

    @NotNull
    public final Context appContext() {
        return SdkContext.f6675a.c().getContext();
    }

    @NotNull
    public final FastRecordAppViewModel appViewModel() {
        return getAppViewModel();
    }

    @NotNull
    public final FastRecordDao fastRecordDao() {
        return getDatabase().fastRecordDao();
    }

    @NotNull
    public final FastRecordPersonDao fastRecordPersonDao() {
        return getDatabase().fastRecordPersonDao();
    }

    @NotNull
    public final FastRecordPersonHistoryDao fastRecordPersonHistoryDao() {
        return getDatabase().fastRecordPersonHistoryDao();
    }

    @NotNull
    public final FastRecordSummaryDao fastRecordSummaryDao() {
        return getDatabase().fastRecordSummaryDao();
    }

    @NotNull
    public final FastRecordTagDao fastRecordTagDao() {
        return getDatabase().fastRecordTagDao();
    }

    @NotNull
    public final FastRecordTagHistoryDao fastRecordTagHistoryDao() {
        return getDatabase().fastRecordTagHistoryDao();
    }

    @NotNull
    public final FastRecordTodoItemDao fastRecordTodoItemDao() {
        return getDatabase().fastRecordTodoItemDao();
    }

    @NotNull
    public final FastRecordVoiceDao fastRecordVoice() {
        return getDatabase().fastRecordVoiceDao();
    }

    @NotNull
    public final FastRecordVoiceWordDao fastRecordVoiceWordDao() {
        return getDatabase().fastRecordVoiceWordDao();
    }

    @Nullable
    public final NaviLocationInfo getLocation() {
        return RecordConnectManager.Companion.getInstance().getLocation();
    }

    @NotNull
    public final String getUuId() {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        return uuid;
    }

    public final void init(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        boolean z = this.isInit;
        LogExt.logE("Init:: 速记管理类 isInit = " + z, TAG);
        if (!this.isInit) {
            LogExt.logE("Init:: 速记管理类 start", TAG);
            MMKV.y(context);
            Context applicationContext = context.getApplicationContext();
            this.appContext = applicationContext;
            if (applicationContext != null) {
                RecordInterConnectHelper.Companion.getInstance().init(applicationContext);
            }
            Companion.getInstance().initRecordTitle(context);
            initAudioMulti();
            this.isInit = true;
        }
    }

    public final void setConnectDevice(@Nullable StarryNetDevice starryNetDevice) {
        FastRecordHistoryAsrOperator.Companion.setConnectDevice(starryNetDevice);
    }

    public final void startMainActivity(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        LogExt.logW("startMainActivity", TAG);
        context.startActivity(new Intent(context, FastRecordMainActivity.class));
    }

    public final void syncAccountInfo(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "info");
        LogExt.logE("syncAccountInfo  info = " + str, TAG);
        if (!TextUtils.isEmpty(str)) {
            try {
                RecordDataSaveUtil recordDataSaveUtil = RecordDataSaveUtil.INSTANCE;
                String str2 = ((AccountInfo) RecordGsonUtils.a(str, AccountInfo.class)).id;
                Intrinsics.checkNotNullExpressionValue(str2, "id");
                recordDataSaveUtil.saveAccountId(str2);
            } catch (Exception e) {
                String message = e.getMessage();
                LogExt.logE("error info is " + message, TAG);
            }
        }
    }
}
