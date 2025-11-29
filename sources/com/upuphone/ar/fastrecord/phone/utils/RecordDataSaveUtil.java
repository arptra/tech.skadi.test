package com.upuphone.ar.fastrecord.phone.utils;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.mmkv.MMKV;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.bean.CacheAmplitudeInfo;
import com.upuphone.ar.fastrecord.phone.bean.FastRecordLanguageBean;
import com.upuphone.ar.fastrecord.phone.db.FastRecordDao;
import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.starrynet.bean.glass.RecordGlassStatus;
import com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordSettingActivity;
import com.upuphone.ar.fastrecord.phone.ui.widget.RecordIngDetailSoundVisualizerView;
import com.upuphone.ar.fastrecord.phone.ui.widget.RecordItemSoundVisualizerView;
import com.upuphone.xr.interconnect.entity.NaviLocationInfo;
import java.lang.reflect.Type;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\rJ\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016J$\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\r2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00120\u001cJ\u0006\u0010\u001d\u001a\u00020\u0012J\u0006\u0010\u001e\u001a\u00020\u0012J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\rJ\u0006\u0010\"\u001a\u00020\u0004J\u0006\u0010#\u001a\u00020\u0004J\u0006\u0010$\u001a\u00020\u0019J\b\u0010%\u001a\u00020\u0019H\u0002J\u0006\u0010&\u001a\u00020\u0019J\u0006\u0010'\u001a\u00020\u0019J\b\u0010(\u001a\u0004\u0018\u00010)J\b\u0010*\u001a\u0004\u0018\u00010)J\u000e\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0004J\u000e\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u0004J\u000e\u0010/\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u00100\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019J1\u00101\u001a\u00020\u00122\u0006\u00102\u001a\u0002032!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u001204J\u0010\u00108\u001a\u00020\u00122\u0006\u00109\u001a\u00020)H\u0002J\u0010\u0010:\u001a\u00020\u00122\u0006\u00109\u001a\u00020)H\u0002J9\u0010;\u001a\u00020\u00122\u0006\u0010<\u001a\u00020 2\u0006\u00102\u001a\u0002032!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u001204J\u000e\u0010=\u001a\u00020\u00122\u0006\u0010>\u001a\u00020\u0004J\u000e\u0010?\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019J\u0016\u0010@\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010A\u001a\u00020\rJ!\u0010B\u001a\u00020\u00122\f\u0010C\u001a\b\u0012\u0004\u0012\u00020E0D2\u0006\u0010F\u001a\u00020E¢\u0006\u0002\u0010GR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/utils/RecordDataSaveUtil;", "", "()V", "ACCOUNT_ID", "", "AI_LANGUAGE_TYPE", "CACHE_NEED_TO_DETAIL_AFTER_CONNECT", "CACHE_PAUSE_AMP_FOR_DETAIL", "CACHE_PAUSE_AMP_FOR_ITEM", "HAS_DOWN_LOAD_ING_SIZE", "LANGUAGE_KEY", "MAX_RECORD_ID", "MIN_RECORD_ID", "", "TAG", "scope", "Lkotlinx/coroutines/CoroutineScope;", "addDownLoadCancelSize", "", "addSize", "byteToHexString", "bytes", "", "checkRecordTimeAndSetFinishState", "recordId", "", "recordStatus", "callback", "Lkotlin/Function0;", "clearCacheAmpData", "clearDownloadCancelSize", "createRecordEntity", "Lcom/upuphone/ar/fastrecord/phone/db/RecordEntity;", "type", "getAccountId", "getAiLanguageType", "getDownLoadCancelSize", "getMaxRecordId", "getMaxRecordIdAndSave", "getNeedToDetailAfterConnect", "getRecordAmplitudeForDetail", "Lcom/upuphone/ar/fastrecord/phone/bean/CacheAmplitudeInfo;", "getRecordAmplitudeForItem", "hashKeyFromUrl", "url", "saveAccountId", "accountId", "saveAmpData", "saveMaxRecordId", "saveOrCreateRecordItem", "mRecordGlassStatus", "Lcom/upuphone/ar/fastrecord/phone/starrynet/bean/glass/RecordGlassStatus;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "state", "saveRecordAmplitudeForDetail", "ampList", "saveRecordAmplitudeForItem", "saveRecordData", "mRecordEntity", "setAiLanguageType", "language", "setNeedToDetailAfterConnect", "updateRecordEntityStatus", "status", "zipFiles", "inputFileArray", "", "Ljava/io/File;", "outputFile", "([Ljava/io/File;Ljava/io/File;)V", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRecordDataSaveUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecordDataSaveUtil.kt\ncom/upuphone/ar/fastrecord/phone/utils/RecordDataSaveUtil\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,421:1\n13309#2:422\n13310#2:424\n1#3:423\n*S KotlinDebug\n*F\n+ 1 RecordDataSaveUtil.kt\ncom/upuphone/ar/fastrecord/phone/utils/RecordDataSaveUtil\n*L\n408#1:422\n408#1:424\n*E\n"})
public final class RecordDataSaveUtil {
    @NotNull
    private static final String ACCOUNT_ID = "account_id";
    @NotNull
    private static final String AI_LANGUAGE_TYPE = "asr_language_type";
    @NotNull
    private static final String CACHE_NEED_TO_DETAIL_AFTER_CONNECT = "need_to_detail_after_connect";
    @NotNull
    private static final String CACHE_PAUSE_AMP_FOR_DETAIL = "cache_amp_audio_detail";
    @NotNull
    private static final String CACHE_PAUSE_AMP_FOR_ITEM = "cache_amp_audio_item";
    @NotNull
    private static final String HAS_DOWN_LOAD_ING_SIZE = "has_down_load_ing_size";
    @NotNull
    public static final RecordDataSaveUtil INSTANCE = new RecordDataSaveUtil();
    @NotNull
    private static final String LANGUAGE_KEY = "LanguageKey";
    @NotNull
    private static final String MAX_RECORD_ID = "fast_record_max_id";
    private static final int MIN_RECORD_ID = 100;
    /* access modifiers changed from: private */
    @NotNull
    public static final String TAG = "RecordDataSaveUtil";
    @NotNull
    private static final CoroutineScope scope = CoroutineScopeKt.a(Dispatchers.b());

    private RecordDataSaveUtil() {
    }

    /* access modifiers changed from: private */
    public final long getMaxRecordId() {
        return MMKV.n().g(MAX_RECORD_ID, 100);
    }

    private final void saveRecordAmplitudeForDetail(CacheAmplitudeInfo cacheAmplitudeInfo) {
        String json = new Gson().toJson((Object) cacheAmplitudeInfo, (Type) CacheAmplitudeInfo.class);
        LogExt.logE("CACHE_PAUSE_AMP_FOR_DETAIL jsonString = " + json, TAG);
        MMKV.n().u(CACHE_PAUSE_AMP_FOR_DETAIL, json);
    }

    private final void saveRecordAmplitudeForItem(CacheAmplitudeInfo cacheAmplitudeInfo) {
        String json = new Gson().toJson((Object) cacheAmplitudeInfo, (Type) CacheAmplitudeInfo.class);
        LogExt.logE("CACHE_PAUSE_AMP_FOR_ITEM  jsonString = " + json, TAG);
        MMKV.n().u(CACHE_PAUSE_AMP_FOR_ITEM, json);
    }

    public final void addDownLoadCancelSize(int i) {
        MMKV.n().s(HAS_DOWN_LOAD_ING_SIZE, MMKV.n().g(HAS_DOWN_LOAD_ING_SIZE, 0) + ((long) i));
    }

    @NotNull
    public final String byteToHexString(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public final void checkRecordTimeAndSetFinishState(long j, int i, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "callback");
        LogExt.logE("checkRecordTimeAndSetFinishState  recordId = " + j + ",recordStatus = " + i, TAG);
        Job unused = BuildersKt__Builders_commonKt.d(scope, (CoroutineContext) null, (CoroutineStart) null, new RecordDataSaveUtil$checkRecordTimeAndSetFinishState$1(j, function0, i, (Continuation<? super RecordDataSaveUtil$checkRecordTimeAndSetFinishState$1>) null), 3, (Object) null);
    }

    public final void clearCacheAmpData() {
        MMKV.n().u(CACHE_PAUSE_AMP_FOR_ITEM, "");
        MMKV.n().u(CACHE_PAUSE_AMP_FOR_DETAIL, "");
    }

    public final void clearDownloadCancelSize() {
        MMKV.n().r(HAS_DOWN_LOAD_ING_SIZE, 0);
    }

    @NotNull
    public final RecordEntity createRecordEntity(long j, int i) {
        long j2 = j;
        int i2 = i;
        String str = TAG;
        LogExt.logW("createRecordEntity recordId = " + j2 + ",type = " + i2 + ",three info = " + Thread.currentThread().getName(), str);
        RecordEntity recordEntity = new RecordEntity(0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, (String) null, 0, 0, 0, 0, 0, 0, 0, 0, false, false, (String) null, false, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, false, false, false, false, (String) null, (String) null, (String) null, false, false, 0, (String) null, 0, 0, false, 0, false, false, false, 0, (String) null, (String) null, 0, 0, (String) null, (LinkedList) null, (ArrayList) null, (ArrayList) null, -1, 8388607, (DefaultConstructorMarker) null);
        recordEntity.setRecordId(j2);
        int i3 = (j2 > 100000000 ? 1 : (j2 == 100000000 ? 0 : -1));
        if (i3 > 0) {
            long j3 = j2 * ((long) 1000);
            recordEntity.setCreateTime(j3);
            recordEntity.setLastModified(j3);
        } else {
            recordEntity.setCreateTime(System.currentTimeMillis());
            recordEntity.setLastModified(System.currentTimeMillis());
        }
        boolean z = true;
        recordEntity.setRecordStatus(1);
        recordEntity.setAccountId(getAccountId());
        recordEntity.setNewRecordItem(true);
        recordEntity.setTotalTime(0);
        recordEntity.setType(i2);
        FastRecordManager.Companion companion = FastRecordManager.Companion;
        String str2 = null;
        List allRecordEntity$default = FastRecordDao.DefaultImpls.getAllRecordEntity$default(companion.getInstance().fastRecordDao(), (String) null, 1, (Object) null);
        FastRecordTitleHelper instance = FastRecordTitleHelper.Companion.getInstance();
        recordEntity.setShortHandTitle(instance != null ? instance.getTitle(i2, allRecordEntity$default) : null);
        companion.getInstance().appViewModel().setRecordIngTimeEntity(recordEntity);
        String str3 = "";
        if (MMKV.n().d(FastRecordSettingActivity.IS_START_LOCATION, false)) {
            NaviLocationInfo location = companion.getInstance().getLocation();
            if (i3 >= 0) {
                z = false;
            }
            LogExt.logW("getLocation = " + location + ",state = " + z, str);
            if (companion.getInstance().getLocation() == null || i3 >= 0) {
                recordEntity.setLocationShort(companion.getInstance().appContext().getString(R.string.fast_record_unkown_location));
                recordEntity.setLocation(companion.getInstance().appContext().getString(R.string.fast_record_unkown_location));
            } else {
                LogExt.logW("location is not null", str);
                NaviLocationInfo location2 = companion.getInstance().getLocation();
                String address = location2 != null ? location2.getAddress() : null;
                if (address != null) {
                    str3 = address;
                }
                String obj = StringsKt.trim((CharSequence) str3).toString();
                if (TextUtils.isEmpty(obj)) {
                    LogExt.logE("location is empty", str);
                    obj = companion.getInstance().appContext().getString(R.string.fast_record_unkown_location);
                    Intrinsics.checkNotNullExpressionValue(obj, "getString(...)");
                }
                recordEntity.setLocation(obj);
                NaviLocationInfo location3 = companion.getInstance().getLocation();
                String district = location3 != null ? location3.getDistrict() : null;
                NaviLocationInfo location4 = companion.getInstance().getLocation();
                if (location4 != null) {
                    str2 = location4.getStreet();
                }
                String obj2 = StringsKt.trim((CharSequence) district + str2).toString();
                if (TextUtils.isEmpty(obj2)) {
                    LogExt.logE("shortLocation is empty,location = " + obj, str);
                } else {
                    obj = obj2;
                }
                recordEntity.setLocationShort(obj);
                NaviLocationInfo location5 = companion.getInstance().getLocation();
                recordEntity.setLatitude((location5 != null ? Double.valueOf(location5.getLatitude()) : 0L).longValue());
                NaviLocationInfo location6 = companion.getInstance().getLocation();
                recordEntity.setLongitude((location6 != null ? Double.valueOf(location6.getLongitude()) : 0L).longValue());
                LogExt.logW("locationShort  = " + obj + ",mRecordEntity.location = " + recordEntity.getLocation(), str);
            }
        } else {
            recordEntity.setLocationShort(str3);
            recordEntity.setLocation(str3);
        }
        LogExt.logW("createRecordEntity mRecordEntity = " + recordEntity, str);
        return recordEntity;
    }

    @NotNull
    public final String getAccountId() {
        String j = MMKV.n().j(ACCOUNT_ID);
        if (j == null) {
            j = "";
        }
        LogExt.logE("getAccountId accountId = " + j, TAG);
        return j;
    }

    @NotNull
    public final String getAiLanguageType() {
        FastRecordManager.Companion companion = FastRecordManager.Companion;
        String string = companion.getInstance().appContext().getString(R.string.fr_simultaneous_cn);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        FastRecordLanguageBean fastRecordLanguageBean = new FastRecordLanguageBean(string, "cmn-Hans-CN");
        String string2 = companion.getInstance().appContext().getString(R.string.fr_simultaneous_en);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        FastRecordLanguageBean fastRecordLanguageBean2 = new FastRecordLanguageBean(string2, "en-GB");
        Gson gson = new Gson();
        if (RecordConstants.INSTANCE.isIntlVersion()) {
            fastRecordLanguageBean = fastRecordLanguageBean2;
        }
        String json = gson.toJson((Object) fastRecordLanguageBean);
        LogExt.logE("getAiLanguageType jsonString = " + json, TAG);
        String k = MMKV.n().k(AI_LANGUAGE_TYPE, json);
        return k == null ? "cmn-Hans-CN" : k;
    }

    public final long getDownLoadCancelSize() {
        return MMKV.n().g(HAS_DOWN_LOAD_ING_SIZE, 0);
    }

    public final long getMaxRecordIdAndSave() {
        long g = MMKV.n().g(MAX_RECORD_ID, 100) + 1;
        saveMaxRecordId(g);
        return g;
    }

    public final long getNeedToDetailAfterConnect() {
        return MMKV.n().f(CACHE_NEED_TO_DETAIL_AFTER_CONNECT);
    }

    @Nullable
    public final CacheAmplitudeInfo getRecordAmplitudeForDetail() {
        String k = MMKV.n().k(CACHE_PAUSE_AMP_FOR_DETAIL, "");
        if (k == null || k.length() == 0) {
            return null;
        }
        LogExt.logW("CACHE_PAUSE_AMP_FOR_DETAIL json = " + k, TAG);
        return (CacheAmplitudeInfo) new Gson().fromJson(k, CacheAmplitudeInfo.class);
    }

    @Nullable
    public final CacheAmplitudeInfo getRecordAmplitudeForItem() {
        String k = MMKV.n().k(CACHE_PAUSE_AMP_FOR_ITEM, "");
        if (k == null || k.length() == 0) {
            return null;
        }
        LogExt.logW("CACHE_PAUSE_AMP_FOR_ITEM json = " + k, TAG);
        return (CacheAmplitudeInfo) new Gson().fromJson(k, CacheAmplitudeInfo.class);
    }

    @NotNull
    public final String hashKeyFromUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            instance.update(bytes);
            byte[] digest = instance.digest();
            Intrinsics.checkNotNullExpressionValue(digest, "digest(...)");
            return byteToHexString(digest);
        } catch (NoSuchAlgorithmException unused) {
            return String.valueOf(str.hashCode());
        }
    }

    public final void saveAccountId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "accountId");
        LogExt.logE("saveAccountId accountId = " + str, TAG);
        MMKV.n().u(ACCOUNT_ID, str);
    }

    public final void saveAmpData(long j) {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(RecordItemSoundVisualizerView.Companion.getItemAmplitudeBeanToList());
        Unit unit = Unit.INSTANCE;
        saveRecordAmplitudeForItem(new CacheAmplitudeInfo(j, linkedList));
        LinkedList linkedList2 = new LinkedList();
        linkedList2.addAll(RecordIngDetailSoundVisualizerView.Companion.getDetailAmplitudeBeanToList());
        saveRecordAmplitudeForDetail(new CacheAmplitudeInfo(j, linkedList2));
    }

    public final void saveMaxRecordId(long j) {
        MMKV.n().s(MAX_RECORD_ID, j);
    }

    public final void saveOrCreateRecordItem(@NotNull RecordGlassStatus recordGlassStatus, @NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(recordGlassStatus, "mRecordGlassStatus");
        Intrinsics.checkNotNullParameter(function1, "callback");
        LogExt.logE("saveOrCreateRecordItem data = " + recordGlassStatus, TAG);
        Job unused = BuildersKt__Builders_commonKt.d(scope, (CoroutineContext) null, (CoroutineStart) null, new RecordDataSaveUtil$saveOrCreateRecordItem$1(recordGlassStatus, function1, (Continuation<? super RecordDataSaveUtil$saveOrCreateRecordItem$1>) null), 3, (Object) null);
    }

    public final void saveRecordData(@NotNull RecordEntity recordEntity, @NotNull RecordGlassStatus recordGlassStatus, @NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(recordEntity, "mRecordEntity");
        Intrinsics.checkNotNullParameter(recordGlassStatus, "mRecordGlassStatus");
        Intrinsics.checkNotNullParameter(function1, "callback");
        Job unused = BuildersKt__Builders_commonKt.d(scope, (CoroutineContext) null, (CoroutineStart) null, new RecordDataSaveUtil$saveRecordData$1(recordEntity, function1, recordGlassStatus, (Continuation<? super RecordDataSaveUtil$saveRecordData$1>) null), 3, (Object) null);
    }

    public final void setAiLanguageType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "language");
        MMKV.n().u(AI_LANGUAGE_TYPE, str);
    }

    public final void setNeedToDetailAfterConnect(long j) {
        MMKV.n().s(CACHE_NEED_TO_DETAIL_AFTER_CONNECT, j);
    }

    public final void updateRecordEntityStatus(long j, int i) {
        Job unused = BuildersKt__Builders_commonKt.d(scope, (CoroutineContext) null, (CoroutineStart) null, new RecordDataSaveUtil$updateRecordEntityStatus$1(j, i, (Continuation<? super RecordDataSaveUtil$updateRecordEntityStatus$1>) null), 3, (Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x005a, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x005b, code lost:
        kotlin.io.CloseableKt.closeFinally(r7, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x005e, code lost:
        throw r9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zipFiles(@org.jetbrains.annotations.NotNull java.io.File[] r8, @org.jetbrains.annotations.NotNull java.io.File r9) {
        /*
            r7 = this;
            java.lang.String r7 = "inputFileArray"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r7)
            java.lang.String r7 = "outputFile"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r7)
            java.util.zip.ZipOutputStream r7 = new java.util.zip.ZipOutputStream
            java.io.BufferedOutputStream r0 = new java.io.BufferedOutputStream
            java.io.FileOutputStream r1 = new java.io.FileOutputStream
            r1.<init>(r9)
            r0.<init>(r1)
            r7.<init>(r0)
            int r9 = r8.length     // Catch:{ all -> 0x004b }
            r0 = 0
            r1 = r0
        L_0x001c:
            r2 = 0
            if (r1 >= r9) goto L_0x0053
            r3 = r8[r1]     // Catch:{ all -> 0x004b }
            java.util.zip.ZipEntry r4 = new java.util.zip.ZipEntry     // Catch:{ all -> 0x004b }
            java.lang.String r5 = r3.getName()     // Catch:{ all -> 0x004b }
            r4.<init>(r5)     // Catch:{ all -> 0x004b }
            r7.putNextEntry(r4)     // Catch:{ all -> 0x004b }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ all -> 0x004b }
            r4.<init>(r3)     // Catch:{ all -> 0x004b }
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r3]     // Catch:{ all -> 0x0041 }
        L_0x0036:
            int r5 = r4.read(r3)     // Catch:{ all -> 0x0041 }
            r6 = -1
            if (r5 == r6) goto L_0x0043
            r7.write(r3, r0, r5)     // Catch:{ all -> 0x0041 }
            goto L_0x0036
        L_0x0041:
            r8 = move-exception
            goto L_0x004d
        L_0x0043:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0041 }
            kotlin.io.CloseableKt.closeFinally(r4, r2)     // Catch:{ all -> 0x004b }
            int r1 = r1 + 1
            goto L_0x001c
        L_0x004b:
            r8 = move-exception
            goto L_0x0059
        L_0x004d:
            throw r8     // Catch:{ all -> 0x004e }
        L_0x004e:
            r9 = move-exception
            kotlin.io.CloseableKt.closeFinally(r4, r8)     // Catch:{ all -> 0x004b }
            throw r9     // Catch:{ all -> 0x004b }
        L_0x0053:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x004b }
            kotlin.io.CloseableKt.closeFinally(r7, r2)
            return
        L_0x0059:
            throw r8     // Catch:{ all -> 0x005a }
        L_0x005a:
            r9 = move-exception
            kotlin.io.CloseableKt.closeFinally(r7, r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.utils.RecordDataSaveUtil.zipFiles(java.io.File[], java.io.File):void");
    }
}
