package com.upuphone.ar.fastrecord.phone.utils;

import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.db.FastRecordDao;
import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import com.upuphone.ar.fastrecord.phone.db.RecordVoiceEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\r2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fH\u0002J\u0018\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0014H\u0002J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0010H\u0002J \u0010\u001f\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u00102\b\b\u0002\u0010 \u001a\u00020\u0018H@¢\u0006\u0002\u0010!J \u0010\"\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u00102\b\b\u0002\u0010 \u001a\u00020\u0018H@¢\u0006\u0002\u0010!J\u0010\u0010#\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0010H\u0002J\u001e\u0010$\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u00102\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&H\u0002J \u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u0006H\u0002J\u0018\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020-H\u0002J\u001a\u00100\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u00102\b\b\u0002\u0010 \u001a\u00020\u0018H\u0002J\u001a\u00101\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u00102\b\b\u0002\u0010 \u001a\u00020\u0018H\u0002J\u001e\u00102\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u00102\f\u00103\u001a\b\u0012\u0004\u0012\u00020'0&H\u0002J4\u00104\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u00105\u001a\u00020\u00042\b\b\u0002\u0010 \u001a\u00020\u00182\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fJ\u0016\u00106\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0010H@¢\u0006\u0002\u00107R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000RB\u0010\u000b\u001a6\u0012\u0004\u0012\u00020\r\u0012,\u0012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f0\u000ej\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f`\u00120\fX\u000e¢\u0006\u0002\n\u0000R*\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00140\u000ej\b\u0012\u0004\u0012\u00020\u0014`\u00120\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/utils/RecordVoiceMergeUtil;", "", "()V", "ARI_MIN_CACHE_VOICE_SINGLE_SIZE", "", "PHONE_ALL_MERGE", "", "PHONE_DOWN_MERGE", "PHONE_UP_MERGE", "SCENE_MERGE", "TAG", "excessMergeVoiceHashMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/util/ArrayList;", "Lkotlin/Function1;", "Lcom/upuphone/ar/fastrecord/phone/db/RecordEntity;", "", "Lkotlin/collections/ArrayList;", "excessMergeVoiceJobHashMap", "Lkotlinx/coroutines/Job;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "addCallBack", "", "recordId", "callBack", "addToMergeJob", "job", "clearAllMergeJob", "record", "commandMergePhoneVoice", "needShoWTip", "(Lcom/upuphone/ar/fastrecord/phone/db/RecordEntity;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "commandMergeSceneVoice", "commandMergeVoiceCallBack", "mergeDownVoice", "recordVoiceListDownRecord", "", "Lcom/upuphone/ar/fastrecord/phone/db/RecordVoiceEntity;", "mergePcm", "upPcmPath", "downPcmPath", "lastPcmPath", "mergePcmChannels", "", "leftChannel", "rightChannel", "mergePhoneVoice", "mergeSceneVoice", "mergeUpVoice", "recordVoiceListUpRecord", "mergeVoice", "type", "mergeVoiceForShareFile", "(Lcom/upuphone/ar/fastrecord/phone/db/RecordEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRecordVoiceMergeUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecordVoiceMergeUtil.kt\ncom/upuphone/ar/fastrecord/phone/utils/RecordVoiceMergeUtil\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,448:1\n215#2:449\n216#2:452\n1855#3,2:450\n1864#3,3:453\n1855#3,2:456\n1864#3,3:459\n1864#3,3:462\n1#4:458\n*S KotlinDebug\n*F\n+ 1 RecordVoiceMergeUtil.kt\ncom/upuphone/ar/fastrecord/phone/utils/RecordVoiceMergeUtil\n*L\n139#1:449\n139#1:452\n143#1:450,2\n173#1:453,3\n259#1:456,2\n384#1:459,3\n422#1:462,3\n*E\n"})
public final class RecordVoiceMergeUtil {
    private static final int ARI_MIN_CACHE_VOICE_SINGLE_SIZE = 32000;
    @NotNull
    public static final RecordVoiceMergeUtil INSTANCE = new RecordVoiceMergeUtil();
    @NotNull
    private static final String PHONE_ALL_MERGE = "PHONE_ALL_MERGE";
    @NotNull
    private static final String PHONE_DOWN_MERGE = "PHONE_DOWN_MERGE";
    @NotNull
    private static final String PHONE_UP_MERGE = "PHONE_UP_MERGE";
    @NotNull
    private static final String SCENE_MERGE = "MERGE_SCENE_RECORD_TYPE";
    @NotNull
    private static final String TAG = "RecordVoiceMergeUtil";
    @NotNull
    private static ConcurrentHashMap<Long, ArrayList<Function1<RecordEntity, Unit>>> excessMergeVoiceHashMap = new ConcurrentHashMap<>();
    @NotNull
    private static ConcurrentHashMap<Long, ArrayList<Job>> excessMergeVoiceJobHashMap = new ConcurrentHashMap<>();
    @NotNull
    private static final CoroutineScope scope = CoroutineScopeKt.a(Dispatchers.b());

    private RecordVoiceMergeUtil() {
    }

    private final boolean addCallBack(long j, Function1<? super RecordEntity, Unit> function1) {
        Integer num = null;
        if (!excessMergeVoiceHashMap.contains(Long.valueOf(j)) || excessMergeVoiceHashMap.get(Long.valueOf(j)) == null) {
            excessMergeVoiceHashMap.put(Long.valueOf(j), new ArrayList());
            ArrayList arrayList = excessMergeVoiceHashMap.get(Long.valueOf(j));
            if (arrayList != null) {
                arrayList.add(function1);
            }
            ArrayList arrayList2 = excessMergeVoiceHashMap.get(Long.valueOf(j));
            if (arrayList2 != null) {
                num = Integer.valueOf(arrayList2.size());
            }
            LogExt.logE("addCallBack contains true,size = " + num, TAG);
            return false;
        }
        ArrayList arrayList3 = excessMergeVoiceHashMap.get(Long.valueOf(j));
        if (arrayList3 != null) {
            arrayList3.add(function1);
        }
        ArrayList arrayList4 = excessMergeVoiceHashMap.get(Long.valueOf(j));
        if (arrayList4 != null) {
            num = Integer.valueOf(arrayList4.size());
        }
        LogExt.logE("addCallBack contains true,size = " + num, TAG);
        return true;
    }

    private final void addToMergeJob(long j, Job job) {
        Integer num = null;
        if (!excessMergeVoiceJobHashMap.contains(Long.valueOf(j)) || excessMergeVoiceJobHashMap.get(Long.valueOf(j)) == null) {
            excessMergeVoiceJobHashMap.put(Long.valueOf(j), new ArrayList());
            ArrayList arrayList = excessMergeVoiceJobHashMap.get(Long.valueOf(j));
            if (arrayList != null) {
                arrayList.add(job);
            }
            ArrayList arrayList2 = excessMergeVoiceJobHashMap.get(Long.valueOf(j));
            if (arrayList2 != null) {
                num = Integer.valueOf(arrayList2.size());
            }
            LogExt.logE("addToMergeJob contains true,size = " + num, TAG);
            return;
        }
        ArrayList arrayList3 = excessMergeVoiceJobHashMap.get(Long.valueOf(j));
        if (arrayList3 != null) {
            arrayList3.add(job);
        }
        ArrayList arrayList4 = excessMergeVoiceJobHashMap.get(Long.valueOf(j));
        if (arrayList4 != null) {
            num = Integer.valueOf(arrayList4.size());
        }
        LogExt.logE("addToMergeJob contains true,size = " + num, TAG);
    }

    private final void clearAllMergeJob(RecordEntity recordEntity) {
        Integer num = null;
        if (excessMergeVoiceJobHashMap.contains(Long.valueOf(recordEntity.getRecordId())) && excessMergeVoiceJobHashMap.get(Long.valueOf(recordEntity.getRecordId())) != null) {
            ArrayList<Job> arrayList = excessMergeVoiceJobHashMap.get(Long.valueOf(recordEntity.getRecordId()));
            if (arrayList != null) {
                for (Job a2 : arrayList) {
                    Job.DefaultImpls.a(a2, (CancellationException) null, 1, (Object) null);
                }
            }
            excessMergeVoiceJobHashMap.remove(Long.valueOf(recordEntity.getRecordId()));
            ArrayList arrayList2 = excessMergeVoiceJobHashMap.get(Long.valueOf(recordEntity.getRecordId()));
            Integer valueOf = arrayList2 != null ? Integer.valueOf(arrayList2.size()) : null;
            LogExt.logE("clearAllMergeJob contains true,size = " + valueOf, TAG);
        }
        if (excessMergeVoiceHashMap.contains(Long.valueOf(recordEntity.getRecordId())) && excessMergeVoiceHashMap.get(Long.valueOf(recordEntity.getRecordId())) != null) {
            excessMergeVoiceHashMap.remove(Long.valueOf(recordEntity.getRecordId()));
            ArrayList arrayList3 = excessMergeVoiceHashMap.get(Long.valueOf(recordEntity.getRecordId()));
            if (arrayList3 != null) {
                num = Integer.valueOf(arrayList3.size());
            }
            LogExt.logE("excessMergeVoiceHashMap contains true,size = " + num, TAG);
        }
    }

    public static /* synthetic */ Object commandMergePhoneVoice$default(RecordVoiceMergeUtil recordVoiceMergeUtil, RecordEntity recordEntity, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return recordVoiceMergeUtil.commandMergePhoneVoice(recordEntity, z, continuation);
    }

    /* access modifiers changed from: private */
    public final Object commandMergeSceneVoice(RecordEntity recordEntity, boolean z, Continuation<? super Unit> continuation) {
        FastRecordManager.Companion companion = FastRecordManager.Companion;
        List<RecordVoiceEntity> findVoiceEntityByIdAndRoleAsc = companion.getInstance().fastRecordVoice().findVoiceEntityByIdAndRoleAsc(recordEntity.getRecordId(), RecordConstants.SCENE_RECORD_TYPE);
        if (findVoiceEntityByIdAndRoleAsc == null || findVoiceEntityByIdAndRoleAsc.isEmpty()) {
            LogExt.logE("mergeSceneVoice recordVoiceListForSceneRecord.isNullOrEmpty()", TAG);
            return Unit.INSTANCE;
        }
        LogExt.logE("mergeSceneVoice record = " + recordEntity, TAG);
        RecordFileUtils recordFileUtils = RecordFileUtils.INSTANCE;
        String createVoiceDirForRecord = recordFileUtils.createVoiceDirForRecord(companion.getInstance().appContext(), recordEntity.getRecordId(), SCENE_MERGE);
        recordEntity.setCacheFileDir(createVoiceDirForRecord);
        String createVoicePcmFilePath = recordFileUtils.createVoicePcmFilePath(String.valueOf(recordEntity.getRecordId()), createVoiceDirForRecord);
        int i = 0;
        for (T next : findVoiceEntityByIdAndRoleAsc) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            RecordVoiceEntity recordVoiceEntity = (RecordVoiceEntity) next;
            LogExt.logE("mergeSceneVoice index = " + i + ", recordVoiceEntity = " + recordVoiceEntity + " all merge to recordPcmFilePath", TAG);
            RecordFileUtils.INSTANCE.fileAppendFile(recordVoiceEntity.getCachePcmFilePath(), createVoicePcmFilePath);
            i = i2;
        }
        recordEntity.setCacheLastMergeAllScenePcmChannelPath(createVoicePcmFilePath);
        RecordFileUtils recordFileUtils2 = RecordFileUtils.INSTANCE;
        String createWavTempVoiceFilePath = recordFileUtils2.createWavTempVoiceFilePath(String.valueOf(recordEntity.getRecordId()), createVoiceDirForRecord);
        PcmToWavUtil pcmToWavUtil = new PcmToWavUtil(16000, 16, 2);
        LogExt.logE("wavFilePath = " + createWavTempVoiceFilePath + ",cacheLastMergeAllScenePcmChannelPath = " + createVoicePcmFilePath + " ,isSingle true,title = " + recordEntity.getShortHandTitle(), TAG);
        long fileSize = recordFileUtils2.getFileSize(createVoicePcmFilePath);
        long j = fileSize / ((long) 32);
        LogExt.logE("mergeSceneVoice fileSize = " + fileSize + ",time = " + j, TAG);
        recordEntity.setTotalTime(j);
        if (recordEntity.getTotalTime() < 1000) {
            recordEntity.setTotalTime(1000);
        }
        pcmToWavUtil.pcmToWav(createVoicePcmFilePath, createWavTempVoiceFilePath, Boxing.boxBoolean(true));
        recordEntity.setCacheLastWavChannelPath(createWavTempVoiceFilePath);
        recordEntity.setFinishFileMerge(true);
        recordEntity.setTwoChannelType(false);
        if (!recordEntity.isFinishAsr()) {
            recordEntity.setFinishAsr(false);
        }
        if (z) {
            recordEntity.setChangeVoice(true);
        }
        LogExt.logE("mergeSceneVoice record value = " + recordEntity, TAG);
        FastRecordDao fastRecordDao = FastRecordManager.Companion.getInstance().fastRecordDao();
        long recordId = recordEntity.getRecordId();
        String cacheFileDir = recordEntity.getCacheFileDir();
        String str = cacheFileDir == null ? "" : cacheFileDir;
        String cacheLastMergeAllScenePcmChannelPath = recordEntity.getCacheLastMergeAllScenePcmChannelPath();
        String str2 = cacheLastMergeAllScenePcmChannelPath == null ? "" : cacheLastMergeAllScenePcmChannelPath;
        long totalTime = recordEntity.getTotalTime();
        String cacheLastWavChannelPath = recordEntity.getCacheLastWavChannelPath();
        Object updateSceneRecordAfterMergeFile = fastRecordDao.updateSceneRecordAfterMergeFile(recordId, str, str2, totalTime, cacheLastWavChannelPath == null ? "" : cacheLastWavChannelPath, recordEntity.isFinishFileMerge(), recordEntity.isTwoChannelType(), recordEntity.isFinishAsr(), continuation);
        return updateSceneRecordAfterMergeFile == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? updateSceneRecordAfterMergeFile : Unit.INSTANCE;
    }

    public static /* synthetic */ Object commandMergeSceneVoice$default(RecordVoiceMergeUtil recordVoiceMergeUtil, RecordEntity recordEntity, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return recordVoiceMergeUtil.commandMergeSceneVoice(recordEntity, z, continuation);
    }

    /* access modifiers changed from: private */
    public final void commandMergeVoiceCallBack(RecordEntity recordEntity) {
        for (Map.Entry next : excessMergeVoiceHashMap.entrySet()) {
            long recordId = recordEntity.getRecordId();
            LogExt.logE("commandMergeVoiceCallBack cur record = " + recordId, TAG);
            Object key = next.getKey();
            LogExt.logE("commandMergeVoiceCallBack hash map record = " + key, TAG);
            if (((Number) next.getKey()).longValue() == recordEntity.getRecordId()) {
                for (Function1 invoke : (Iterable) next.getValue()) {
                    invoke.invoke(recordEntity);
                }
            }
        }
    }

    private final void mergeDownVoice(RecordEntity recordEntity, List<RecordVoiceEntity> list) {
        RecordFileUtils recordFileUtils = RecordFileUtils.INSTANCE;
        String createVoiceDirForRecord = recordFileUtils.createVoiceDirForRecord(FastRecordManager.Companion.getInstance().appContext(), recordEntity.getRecordId(), PHONE_DOWN_MERGE);
        String createVoicePcmFilePath = recordFileUtils.createVoicePcmFilePath(String.valueOf(recordEntity.getRecordId()), createVoiceDirForRecord);
        recordEntity.setCacheFileDir(createVoiceDirForRecord);
        int i = 0;
        for (T next : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            RecordVoiceEntity recordVoiceEntity = (RecordVoiceEntity) next;
            LogExt.logE("mergeDownVoice index = " + i + ", recordVoiceEntity = " + recordVoiceEntity + " all merge to recordPcmFilePath", TAG);
            RecordFileUtils.INSTANCE.fileAppendFile(recordVoiceEntity.getCachePcmFilePath(), createVoicePcmFilePath);
            i = i2;
        }
        RecordFileUtils recordFileUtils2 = RecordFileUtils.INSTANCE;
        long recordId = recordEntity.getRecordId();
        String createWavTempVoiceFilePath = recordFileUtils2.createWavTempVoiceFilePath(recordId + "_down", createVoiceDirForRecord);
        new PcmToWavUtil(16000, 16, 2).pcmToWav(createVoicePcmFilePath, createWavTempVoiceFilePath, Boolean.TRUE);
        LogExt.logE("mergeDownVoice wavFilePath = " + createWavTempVoiceFilePath + ",cacheLastMergeAllScenePcmChannelPath = " + createVoicePcmFilePath + " ,isSingle true", TAG);
        recordEntity.setCacheLastDownMergePcmChannelPath(createVoicePcmFilePath);
        recordEntity.setCacheLastDownMergeWavChannelPath(createWavTempVoiceFilePath);
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void mergePcm(java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            r6 = this;
            java.lang.String r0 = "RecordVoiceMergeUtil"
            r1 = 32000(0x7d00, float:4.4842E-41)
            byte[] r2 = new byte[r1]
            byte[] r1 = new byte[r1]
            r3 = 0
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0070, all -> 0x006c }
            r4.<init>(r7)     // Catch:{ Exception -> 0x0070, all -> 0x006c }
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0068, all -> 0x0064 }
            r7.<init>(r8)     // Catch:{ Exception -> 0x0068, all -> 0x0064 }
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0061, all -> 0x005e }
            r5 = 1
            r8.<init>(r9, r5)     // Catch:{ Exception -> 0x0061, all -> 0x005e }
            r9 = 0
        L_0x001a:
            int r3 = r4.read(r2)     // Catch:{ Exception -> 0x0035, all -> 0x0031 }
            if (r3 <= 0) goto L_0x0038
            int r9 = r7.read(r1)     // Catch:{ Exception -> 0x0035, all -> 0x0031 }
            if (r9 <= 0) goto L_0x0038
            byte[] r3 = r6.mergePcmChannels(r2, r1)     // Catch:{ Exception -> 0x0035, all -> 0x0031 }
            r8.write(r3)     // Catch:{ Exception -> 0x0035, all -> 0x0031 }
            r8.flush()     // Catch:{ Exception -> 0x0035, all -> 0x0031 }
            goto L_0x001a
        L_0x0031:
            r6 = move-exception
        L_0x0032:
            r3 = r4
            goto L_0x009a
        L_0x0035:
            r6 = move-exception
        L_0x0036:
            r3 = r4
            goto L_0x0073
        L_0x0038:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0035, all -> 0x0031 }
            r6.<init>()     // Catch:{ Exception -> 0x0035, all -> 0x0031 }
            java.lang.String r1 = "mergePcm upSize = "
            r6.append(r1)     // Catch:{ Exception -> 0x0035, all -> 0x0031 }
            r6.append(r3)     // Catch:{ Exception -> 0x0035, all -> 0x0031 }
            java.lang.String r1 = ",downSize = "
            r6.append(r1)     // Catch:{ Exception -> 0x0035, all -> 0x0031 }
            r6.append(r9)     // Catch:{ Exception -> 0x0035, all -> 0x0031 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0035, all -> 0x0031 }
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r6, r0)     // Catch:{ Exception -> 0x0035, all -> 0x0031 }
            r4.close()
            r7.close()
        L_0x005a:
            r8.close()
            goto L_0x0098
        L_0x005e:
            r6 = move-exception
            r8 = r3
            goto L_0x0032
        L_0x0061:
            r6 = move-exception
            r8 = r3
            goto L_0x0036
        L_0x0064:
            r6 = move-exception
            r7 = r3
            r8 = r7
            goto L_0x0032
        L_0x0068:
            r6 = move-exception
            r7 = r3
            r8 = r7
            goto L_0x0036
        L_0x006c:
            r6 = move-exception
            r7 = r3
            r8 = r7
            goto L_0x009a
        L_0x0070:
            r6 = move-exception
            r7 = r3
            r8 = r7
        L_0x0073:
            java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x0099 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0099 }
            r9.<init>()     // Catch:{ all -> 0x0099 }
            java.lang.String r1 = "mergePcm error = "
            r9.append(r1)     // Catch:{ all -> 0x0099 }
            r9.append(r6)     // Catch:{ all -> 0x0099 }
            java.lang.String r6 = r9.toString()     // Catch:{ all -> 0x0099 }
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r6, r0)     // Catch:{ all -> 0x0099 }
            if (r3 == 0) goto L_0x0090
            r3.close()
        L_0x0090:
            if (r7 == 0) goto L_0x0095
            r7.close()
        L_0x0095:
            if (r8 == 0) goto L_0x0098
            goto L_0x005a
        L_0x0098:
            return
        L_0x0099:
            r6 = move-exception
        L_0x009a:
            if (r3 == 0) goto L_0x009f
            r3.close()
        L_0x009f:
            if (r7 == 0) goto L_0x00a4
            r7.close()
        L_0x00a4:
            if (r8 == 0) goto L_0x00a9
            r8.close()
        L_0x00a9:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.utils.RecordVoiceMergeUtil.mergePcm(java.lang.String, java.lang.String, java.lang.String):void");
    }

    private final byte[] mergePcmChannels(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(bArr.length * 2)];
        int i = 0;
        IntProgression step = RangesKt.step((IntProgression) RangesKt.until(0, bArr.length), 2);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
            while (true) {
                bArr3[i] = bArr[first];
                int i2 = first + 1;
                bArr3[i + 1] = bArr[i2];
                int i3 = i + 3;
                bArr3[i + 2] = bArr2[first];
                i += 4;
                bArr3[i3] = bArr2[i2];
                if (first == last) {
                    break;
                }
                first += step2;
            }
        }
        return bArr3;
    }

    private final Job mergePhoneVoice(RecordEntity recordEntity, boolean z) {
        return BuildersKt__Builders_commonKt.d(scope, (CoroutineContext) null, (CoroutineStart) null, new RecordVoiceMergeUtil$mergePhoneVoice$1(recordEntity, z, (Continuation<? super RecordVoiceMergeUtil$mergePhoneVoice$1>) null), 3, (Object) null);
    }

    public static /* synthetic */ Job mergePhoneVoice$default(RecordVoiceMergeUtil recordVoiceMergeUtil, RecordEntity recordEntity, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return recordVoiceMergeUtil.mergePhoneVoice(recordEntity, z);
    }

    private final Job mergeSceneVoice(RecordEntity recordEntity, boolean z) {
        return BuildersKt__Builders_commonKt.d(scope, (CoroutineContext) null, (CoroutineStart) null, new RecordVoiceMergeUtil$mergeSceneVoice$1(recordEntity, z, (Continuation<? super RecordVoiceMergeUtil$mergeSceneVoice$1>) null), 3, (Object) null);
    }

    public static /* synthetic */ Job mergeSceneVoice$default(RecordVoiceMergeUtil recordVoiceMergeUtil, RecordEntity recordEntity, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return recordVoiceMergeUtil.mergeSceneVoice(recordEntity, z);
    }

    private final void mergeUpVoice(RecordEntity recordEntity, List<RecordVoiceEntity> list) {
        RecordFileUtils recordFileUtils = RecordFileUtils.INSTANCE;
        String createVoiceDirForRecord = recordFileUtils.createVoiceDirForRecord(FastRecordManager.Companion.getInstance().appContext(), recordEntity.getRecordId(), PHONE_UP_MERGE);
        String createVoicePcmFilePath = recordFileUtils.createVoicePcmFilePath(String.valueOf(recordEntity.getRecordId()), createVoiceDirForRecord);
        recordEntity.setCacheFileDir(createVoiceDirForRecord);
        int i = 0;
        for (T next : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            RecordVoiceEntity recordVoiceEntity = (RecordVoiceEntity) next;
            LogExt.logE("mergeUpVoice index = " + i + ", recordVoiceEntity = " + recordVoiceEntity + " all merge to recordPcmFilePath", TAG);
            RecordFileUtils.INSTANCE.fileAppendFile(recordVoiceEntity.getCachePcmFilePath(), createVoicePcmFilePath);
            i = i2;
        }
        RecordFileUtils recordFileUtils2 = RecordFileUtils.INSTANCE;
        long recordId = recordEntity.getRecordId();
        String createWavTempVoiceFilePath = recordFileUtils2.createWavTempVoiceFilePath(recordId + "_up", createVoiceDirForRecord);
        new PcmToWavUtil(16000, 16, 2).pcmToWav(createVoicePcmFilePath, createWavTempVoiceFilePath, Boolean.TRUE);
        LogExt.logE("mergeUpVoice wavFilePath = " + createWavTempVoiceFilePath + ",cacheLastMergeAllScenePcmChannelPath = " + createVoicePcmFilePath + " ,isSingle true", TAG);
        recordEntity.setCacheLastUpMergePcmChannelPath(createVoicePcmFilePath);
        recordEntity.setCacheLastUpMergeWavChannelPath(createWavTempVoiceFilePath);
    }

    public static /* synthetic */ void mergeVoice$default(RecordVoiceMergeUtil recordVoiceMergeUtil, RecordEntity recordEntity, int i, boolean z, Function1 function1, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        recordVoiceMergeUtil.mergeVoice(recordEntity, i, z, function1);
    }

    @Nullable
    public final Object commandMergePhoneVoice(@NotNull RecordEntity recordEntity, boolean z, @NotNull Continuation<? super Unit> continuation) {
        RecordEntity recordEntity2 = recordEntity;
        boolean z2 = z;
        FastRecordManager.Companion companion = FastRecordManager.Companion;
        List<RecordVoiceEntity> findVoiceEntityByIdAndRoleAsc = companion.getInstance().fastRecordVoice().findVoiceEntityByIdAndRoleAsc(recordEntity.getRecordId(), RecordConstants.UP_RECORD_TYPE);
        List<RecordVoiceEntity> findVoiceEntityByIdAndRoleAsc2 = companion.getInstance().fastRecordVoice().findVoiceEntityByIdAndRoleAsc(recordEntity.getRecordId(), RecordConstants.DOWN_RECORD_TYPE);
        if (findVoiceEntityByIdAndRoleAsc != null && !findVoiceEntityByIdAndRoleAsc.isEmpty()) {
            mergeUpVoice(recordEntity2, findVoiceEntityByIdAndRoleAsc);
        }
        if (findVoiceEntityByIdAndRoleAsc2 != null && !findVoiceEntityByIdAndRoleAsc2.isEmpty()) {
            mergeDownVoice(recordEntity2, findVoiceEntityByIdAndRoleAsc2);
        }
        RecordFileUtils recordFileUtils = RecordFileUtils.INSTANCE;
        String createVoiceDirForRecord = recordFileUtils.createVoiceDirForRecord(companion.getInstance().appContext(), recordEntity.getRecordId(), PHONE_ALL_MERGE);
        long recordId = recordEntity.getRecordId();
        String createVoicePcmFilePath = recordFileUtils.createVoicePcmFilePath(recordId + "_merge", createVoiceDirForRecord);
        String cacheLastUpMergePcmChannelPath = recordEntity.getCacheLastUpMergePcmChannelPath();
        if (cacheLastUpMergePcmChannelPath == null) {
            cacheLastUpMergePcmChannelPath = "";
        }
        String cacheLastDownMergePcmChannelPath = recordEntity.getCacheLastDownMergePcmChannelPath();
        if (cacheLastDownMergePcmChannelPath == null) {
            cacheLastDownMergePcmChannelPath = "";
        }
        mergePcm(cacheLastUpMergePcmChannelPath, cacheLastDownMergePcmChannelPath, createVoicePcmFilePath);
        long fileSize = recordFileUtils.getFileSize(cacheLastUpMergePcmChannelPath);
        long j = fileSize / ((long) 32);
        LogExt.logE("mergePhoneVoice fileSize = " + fileSize + ",time = " + j, TAG);
        recordEntity2.setTotalTime(j);
        if (recordEntity.getTotalTime() < 1000) {
            recordEntity2.setTotalTime(1000);
        }
        long recordId2 = recordEntity.getRecordId();
        String createWavTempVoiceFilePath = recordFileUtils.createWavTempVoiceFilePath(recordId2 + "_merge", createVoiceDirForRecord);
        new PcmToWavUtil(16000, 12, 2).pcmToWav(createVoicePcmFilePath, createWavTempVoiceFilePath, Boxing.boxBoolean(false));
        recordEntity2.setCacheLastWavChannelPath(createWavTempVoiceFilePath);
        recordEntity2.setFinishFileMerge(true);
        recordEntity2.setTwoChannelType(true);
        recordEntity2.setFinishAsr(false);
        LogExt.logE("mergePhoneVoice needShoWTip = " + z2 + ",wavMergeFilePath = " + createWavTempVoiceFilePath, TAG);
        if (!recordEntity.isFinishAsr()) {
            recordEntity2.setFinishAsr(false);
        }
        boolean isFinishAsr = recordEntity.isFinishAsr();
        LogExt.logE("mergeSceneVoice needShoWTip = " + z2 + ",record.isFinishAsr = " + isFinishAsr, TAG);
        if (z2) {
            recordEntity2.setChangeVoice(true);
        }
        FastRecordDao fastRecordDao = companion.getInstance().fastRecordDao();
        long recordId3 = recordEntity.getRecordId();
        String cacheFileDir = recordEntity.getCacheFileDir();
        String str = cacheFileDir == null ? "" : cacheFileDir;
        String cacheLastUpMergePcmChannelPath2 = recordEntity.getCacheLastUpMergePcmChannelPath();
        String str2 = cacheLastUpMergePcmChannelPath2 == null ? "" : cacheLastUpMergePcmChannelPath2;
        String cacheLastUpMergeWavChannelPath = recordEntity.getCacheLastUpMergeWavChannelPath();
        String str3 = cacheLastUpMergeWavChannelPath == null ? "" : cacheLastUpMergeWavChannelPath;
        String cacheLastDownMergePcmChannelPath2 = recordEntity.getCacheLastDownMergePcmChannelPath();
        String str4 = cacheLastDownMergePcmChannelPath2 == null ? "" : cacheLastDownMergePcmChannelPath2;
        String cacheLastDownMergeWavChannelPath = recordEntity.getCacheLastDownMergeWavChannelPath();
        String str5 = cacheLastDownMergeWavChannelPath == null ? "" : cacheLastDownMergeWavChannelPath;
        long totalTime = recordEntity.getTotalTime();
        String cacheLastWavChannelPath = recordEntity.getCacheLastWavChannelPath();
        Object updatePhoneRecordAfterMergeFile = fastRecordDao.updatePhoneRecordAfterMergeFile(recordId3, str, str2, str3, str4, str5, totalTime, cacheLastWavChannelPath == null ? "" : cacheLastWavChannelPath, recordEntity.isFinishFileMerge(), recordEntity.isTwoChannelType(), recordEntity.isFinishAsr(), continuation);
        return updatePhoneRecordAfterMergeFile == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? updatePhoneRecordAfterMergeFile : Unit.INSTANCE;
    }

    public final void mergeVoice(@NotNull RecordEntity recordEntity, int i, boolean z, @NotNull Function1<? super RecordEntity, Unit> function1) {
        Intrinsics.checkNotNullParameter(recordEntity, "record");
        Intrinsics.checkNotNullParameter(function1, "callBack");
        long recordId = recordEntity.getRecordId();
        LogExt.logE("mergeVoice needShoWTip=" + z + ",type=" + i + ",recordId = " + recordId, TAG);
        if (z) {
            clearAllMergeJob(recordEntity);
        }
        if (addCallBack(recordEntity.getRecordId(), function1)) {
            LogExt.logE("mergeVoice isExist return", TAG);
            return;
        }
        long recordId2 = recordEntity.getRecordId();
        LogExt.logE("recordId = " + recordId2 + ",type = " + i, TAG);
        if (1 == i) {
            addToMergeJob(recordEntity.getRecordId(), mergeSceneVoice(recordEntity, z));
            return;
        }
        addToMergeJob(recordEntity.getRecordId(), mergePhoneVoice(recordEntity, z));
    }

    @Nullable
    public final Object mergeVoiceForShareFile(@NotNull RecordEntity recordEntity, @NotNull Continuation<? super Unit> continuation) {
        long recordId = recordEntity.getRecordId();
        int type = recordEntity.getType();
        LogExt.logE("mergeVoiceForShareFile recordId = " + recordId + ",type = " + type, TAG);
        if (1 == recordEntity.getType()) {
            Object commandMergeSceneVoice$default = commandMergeSceneVoice$default(this, recordEntity, false, continuation, 2, (Object) null);
            return commandMergeSceneVoice$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? commandMergeSceneVoice$default : Unit.INSTANCE;
        }
        Object commandMergeSceneVoice$default2 = commandMergeSceneVoice$default(this, recordEntity, false, continuation, 2, (Object) null);
        return commandMergeSceneVoice$default2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? commandMergeSceneVoice$default2 : Unit.INSTANCE;
    }
}
