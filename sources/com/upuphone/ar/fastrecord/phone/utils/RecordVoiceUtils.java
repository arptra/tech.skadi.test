package com.upuphone.ar.fastrecord.phone.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.honey.account.c4.a;
import com.honey.account.c4.b;
import com.honey.account.c4.c;
import com.honey.account.c4.d;
import com.honey.account.constant.AccountConstantKt;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.bean.AmplitudeBean;
import com.upuphone.ar.fastrecord.phone.db.FastRecordDao;
import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import com.upuphone.ar.fastrecord.phone.db.RecordSummaryEntity;
import com.upuphone.ar.fastrecord.phone.db.RecordTodoItemEntity;
import com.upuphone.ar.fastrecord.phone.db.RecordVoiceEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.starrynet.RecordInterConnectHelper;
import com.upuphone.ar.fastrecord.phone.starrynet.bean.glass.RecordCacheTag;
import com.upuphone.ar.fastrecord.phone.starrynet.bean.glass.RecordGlassAudioInfo;
import com.upuphone.ar.fastrecord.phone.starrynet.bean.glass.RecordGlassCacheInfo;
import com.upuphone.ar.fastrecord.phone.utils.RecordOpusCodecUtils;
import com.upuphone.xr.sapp.context.SdkContext;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0018\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0006J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0010H\u0002JA\u0010'\u001a\u00020(2\u0016\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\u0012j\b\u0012\u0004\u0012\u00020\u000e`\u00132!\u0010*\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020(0+J&\u0010/\u001a\u00020\"2\u0016\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\u0012j\b\u0012\u0004\u0012\u00020\u000e`\u0013H@¢\u0006\u0002\u00100J\u0010\u00101\u001a\u00020(2\u0006\u00102\u001a\u000203H\u0002J@\u00104\u001a\u00020(2\u0006\u00105\u001a\u00020\t2\u0006\u00106\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\t2\u0006\u0010;\u001a\u00020\tH\u0002J0\u0010<\u001a\u00020\u00062\u0006\u00105\u001a\u00020\t2\u0006\u00106\u001a\u00020\u00062\u0016\u0010=\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0012j\b\u0012\u0004\u0012\u00020\t`\u0013H\u0002J\u0018\u0010>\u001a\u00020(2\b\u0010?\u001a\u0004\u0018\u00010\u00102\u0006\u0010@\u001a\u00020AJ\u0018\u0010B\u001a\u00020(2\b\u0010?\u001a\u0004\u0018\u00010\u00102\u0006\u0010@\u001a\u00020AJ,\u0010C\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0Dj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`E2\u0006\u0010F\u001a\u00020GH\u0002J<\u0010H\u001a\u00020\u00062\"\u0010I\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0Dj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t`E2\u0006\u0010J\u001a\u00020\u00062\u0006\u0010K\u001a\u00020\u0006H\u0002J\u0018\u0010L\u001a\u00020\u00062\u0006\u0010M\u001a\u00020\u00062\u0006\u0010N\u001a\u00020\tH\u0002J0\u0010O\u001a\u0012\u0012\u0004\u0012\u00020P0\u0012j\b\u0012\u0004\u0012\u00020P`\u00132\u0016\u0010Q\u001a\u0012\u0012\u0004\u0012\u00020P0\u0012j\b\u0012\u0004\u0012\u00020P`\u0013H\u0002J@\u0010R\u001a\u00020(2\u0006\u0010S\u001a\u00020T2\f\u0010U\u001a\b\u0012\u0004\u0012\u00020\u000e0V2\"\u0010*\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020W0\u0012j\b\u0012\u0004\u0012\u00020W`\u0013\u0012\u0004\u0012\u00020(0+J(\u0010X\u001a\u0004\u0018\u00010Y2\u0006\u0010S\u001a\u00020T2\u0006\u00105\u001a\u00020\t2\u0006\u0010J\u001a\u00020\u0006H@¢\u0006\u0002\u0010ZJT\u0010[\u001a\u00020(2\u0006\u0010S\u001a\u00020T2\u0006\u00105\u001a\u00020\t2\b\u0010\\\u001a\u0004\u0018\u00010\u00062\u0006\u0010M\u001a\u00020\u00062\u0006\u0010N\u001a\u00020\t2\"\u0010*\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020W0\u0012j\b\u0012\u0004\u0012\u00020W`\u0013\u0012\u0004\u0012\u00020(0+JV\u0010]\u001a\u00020(2\u0006\u0010S\u001a\u00020T2\b\u0010^\u001a\u0004\u0018\u00010\u00062\b\u0010M\u001a\u0004\u0018\u00010\u00062\u0006\u00105\u001a\u00020\t2\u0006\u0010N\u001a\u00020\t2\"\u0010*\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020W0\u0012j\b\u0012\u0004\u0012\u00020W`\u0013\u0012\u0004\u0012\u00020(0+JL\u0010_\u001a\u00020(2\u0006\u0010S\u001a\u00020T2\u0006\u00105\u001a\u00020\t2\b\u0010M\u001a\u0004\u0018\u00010\u00062\u0006\u0010N\u001a\u00020\t2\"\u0010*\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020W0\u0012j\b\u0012\u0004\u0012\u00020W`\u0013\u0012\u0004\u0012\u00020(0+J\u0012\u0010`\u001a\u00020\u00062\b\u0010a\u001a\u0004\u0018\u00010bH\u0002J\u0018\u0010c\u001a\u00020\u00062\u000e\u0010d\u001a\n\u0012\u0004\u0012\u00020P\u0018\u00010VH\u0002J@\u0010e\u001a\u00020(2\u0006\u0010S\u001a\u00020T2\f\u0010U\u001a\b\u0012\u0004\u0012\u00020\u000e0V2\"\u0010*\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020W0\u0012j\b\u0012\u0004\u0012\u00020W`\u0013\u0012\u0004\u0012\u00020(0+J@\u0010f\u001a\u00020(2\u0006\u0010S\u001a\u00020T2\f\u0010U\u001a\b\u0012\u0004\u0012\u00020\u000e0V2\"\u0010*\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020W0\u0012j\b\u0012\u0004\u0012\u00020W`\u0013\u0012\u0004\u0012\u00020(0+J\u0006\u0010g\u001a\u00020(J\b\u0010h\u001a\u00020(H\u0002J\u000e\u0010i\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0006J$\u0010j\u001a\u00020(2\u0006\u00102\u001a\u0002032\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020(0+H\u0002J\u0010\u0010k\u001a\u00020(2\u0006\u00105\u001a\u00020\tH\u0002J8\u0010l\u001a\u00020(2\u0006\u00102\u001a\u0002032\u0006\u0010?\u001a\u00020\u00102\u0006\u00106\u001a\u00020\u00062\u0016\u0010=\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0012j\b\u0012\u0004\u0012\u00020\t`\u0013H\u0002J\u0010\u0010m\u001a\u00020(2\u0006\u0010n\u001a\u000203H\u0002J\u0010\u0010o\u001a\u00020(2\u0006\u0010n\u001a\u000203H\u0002J\u0010\u0010p\u001a\u00020(2\u0006\u0010F\u001a\u00020GH\u0002J8\u0010q\u001a\u00020(2\u0006\u00105\u001a\u00020\t2\u0006\u0010?\u001a\u00020\u00102\u0006\u00106\u001a\u00020\u00062\u0016\u0010=\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0012j\b\u0012\u0004\u0012\u00020\t`\u0013H\u0002J&\u0010r\u001a\u00020(2\u0006\u0010s\u001a\u00020\t2\u0006\u0010t\u001a\u00020\t2\u0006\u0010F\u001a\u00020G2\u0006\u0010u\u001a\u00020\u0004J4\u0010v\u001a\u00020(2\"\u0010w\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0Dj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t`E2\u0006\u0010x\u001a\u00020\u0006H\u0002J\u0018\u0010y\u001a\u00020(2\u0006\u0010F\u001a\u00020G2\u0006\u0010u\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R*\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t0\u0012j\b\u0012\u0004\u0012\u00020\t`\u00130\rX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0012j\b\u0012\u0004\u0012\u00020\t`\u0013X\u000e¢\u0006\u0002\n\u0000R*\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t0\u0012j\b\u0012\u0004\u0012\u00020\t`\u00130\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0012j\b\u0012\u0004\u0012\u00020\t`\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006z"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/utils/RecordVoiceUtils;", "", "()V", "ARI_MIN_CACHE_RECORDING_PCM_SIZE", "", "AUDIO_FILE_SUFFIX", "", "ONE_MIS_SIZE", "SINGLE_TAG_TIME", "", "TAG", "WORD_FILE_SUFFIX", "cacheExistRecordMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/upuphone/ar/fastrecord/phone/db/RecordEntity;", "excessDownFeedCacheBytes", "", "excessPhoneDownloadingTagMap", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "excessPhoneFeedCacheTag", "excessSceneDownloadingTagMap", "excessSingleFeedCacheBytes", "excessSingleFeedCacheTag", "excessUpFeedCacheBytes", "mRecordReLoadVoiceCacheHandle", "Landroid/os/Handler;", "mRecordReLoadVoiceCacheHandleThread", "Landroid/os/HandlerThread;", "mRecordVoiceHandle", "mRecordVoiceHandleThread", "timeMap", "updateAmpDataTime", "aiLanguageSupport", "", "languageTYPE", "analyzeAudio", "", "pcmData", "checkFastRecordShareType", "", "recordIdList", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "type", "checkWordState", "(Ljava/util/ArrayList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createRecordEntityForCache", "mRecordCacheTag", "Lcom/upuphone/ar/fastrecord/phone/starrynet/bean/glass/RecordCacheTag;", "createVoiceEntity", "recordId", "byteRoleType", "recordPcmFilePath", "recordPlusFilePath", "dir", "startTag", "endTag", "createVoiceEntityAndSave", "tagInfo", "feedPhoneMuteData", "bytes", "mRecordGlassAudioInfo", "Lcom/upuphone/ar/fastrecord/phone/starrynet/bean/glass/RecordGlassAudioInfo;", "feedSceneData", "getCacheAudioMaxTag", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "audioInfo", "Lcom/upuphone/ar/fastrecord/phone/starrynet/bean/glass/RecordGlassCacheInfo;", "getFileNameAndHashMap", "hashNameMap", "fileName", "suffix", "getFileShareName", "recordTitle", "createTime", "getNormalTodoData", "Lcom/upuphone/ar/fastrecord/phone/db/RecordTodoItemEntity;", "toDoList", "getRecordListWordUirList", "context", "Landroid/content/Context;", "recordList", "", "Landroid/net/Uri;", "getRecordWordShareFile", "Ljava/io/File;", "(Landroid/content/Context;JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSingleRecordShareMuteTempPath", "wavPath", "getSingleRecordShareVideoPath", "tempPath", "getSingleRecordShareWordPath", "getSummaryShareText", "summaryData", "Lcom/upuphone/ar/fastrecord/phone/db/RecordSummaryEntity;", "getTodoShareText", "mTodoList", "getVideoUirForSelectRecord", "getWordAndVideoUirForSelectRecord", "initAllRecordingTagData", "initVoiceHandle", "isRtlLanguage", "queryRecordOrCreateForDownloading", "resetRecordState", "saveCachePcmData", "saveCachePhoneToFile", "recordCacheTag", "saveCacheSceneToFile", "saveOrUpdateTime", "savePcmData", "savePhoneOrSceneCacheMuteData", "msgId", "sendSize", "byteSize", "subNameHashMap", "nameMap", "key", "updateCacheDataTime", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRecordVoiceUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecordVoiceUtils.kt\ncom/upuphone/ar/fastrecord/phone/utils/RecordVoiceUtils\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,1189:1\n1855#2:1190\n1855#2,2:1191\n1856#2:1193\n1855#2,2:1194\n1864#2,3:1197\n1855#2,2:1200\n1855#2,2:1202\n1855#2,2:1206\n1855#2,2:1208\n1864#2,3:1210\n1#3:1196\n215#4,2:1204\n*S KotlinDebug\n*F\n+ 1 RecordVoiceUtils.kt\ncom/upuphone/ar/fastrecord/phone/utils/RecordVoiceUtils\n*L\n124#1:1190\n137#1:1191,2\n124#1:1193\n402#1:1194,2\n483#1:1197,3\n492#1:1200,2\n793#1:1202,2\n899#1:1206,2\n1125#1:1208,2\n774#1:1210,3\n832#1:1204,2\n*E\n"})
public final class RecordVoiceUtils {
    private static final int ARI_MIN_CACHE_RECORDING_PCM_SIZE = 3200;
    @NotNull
    private static final String AUDIO_FILE_SUFFIX = ".wav";
    @NotNull
    public static final RecordVoiceUtils INSTANCE = new RecordVoiceUtils();
    public static final int ONE_MIS_SIZE = 32;
    private static final long SINGLE_TAG_TIME = 60;
    @NotNull
    public static final String TAG = "FastRecord_VoiceUtils";
    @NotNull
    private static final String WORD_FILE_SUFFIX = ".txt";
    /* access modifiers changed from: private */
    @NotNull
    public static ConcurrentHashMap<Long, RecordEntity> cacheExistRecordMap = new ConcurrentHashMap<>();
    @NotNull
    private static byte[] excessDownFeedCacheBytes = new byte[0];
    /* access modifiers changed from: private */
    @NotNull
    public static ConcurrentHashMap<Long, ArrayList<Long>> excessPhoneDownloadingTagMap = new ConcurrentHashMap<>();
    @NotNull
    private static ArrayList<Long> excessPhoneFeedCacheTag = new ArrayList<>();
    /* access modifiers changed from: private */
    @NotNull
    public static ConcurrentHashMap<Long, ArrayList<Long>> excessSceneDownloadingTagMap = new ConcurrentHashMap<>();
    @NotNull
    private static byte[] excessSingleFeedCacheBytes = new byte[0];
    @NotNull
    private static ArrayList<Long> excessSingleFeedCacheTag = new ArrayList<>();
    @NotNull
    private static byte[] excessUpFeedCacheBytes = new byte[0];
    @Nullable
    private static Handler mRecordReLoadVoiceCacheHandle;
    @Nullable
    private static HandlerThread mRecordReLoadVoiceCacheHandleThread;
    @Nullable
    private static Handler mRecordVoiceHandle;
    @Nullable
    private static HandlerThread mRecordVoiceHandleThread;
    @NotNull
    private static ConcurrentHashMap<Long, Long> timeMap = new ConcurrentHashMap<>();
    private static long updateAmpDataTime;

    static {
        SdkContext.f6675a.b().c().observeForever(new RecordVoiceUtils$sam$androidx_lifecycle_Observer$0(AnonymousClass1.INSTANCE));
    }

    private RecordVoiceUtils() {
    }

    private final float analyzeAudio(byte[] bArr) {
        float calculateAmplitude = (float) RecordOpusUtil.calculateAmplitude(bArr);
        FastRecordManager.Companion companion = FastRecordManager.Companion;
        companion.getInstance().appViewModel().addAmplitudeBean(new AmplitudeBean(calculateAmplitude, (int) companion.getInstance().appViewModel().getRecordingEntityTime(), false, 4, (DefaultConstructorMarker) null));
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - updateAmpDataTime > 1000) {
            updateAmpDataTime = currentTimeMillis;
            RecordEntity recordIngTimeData = companion.getInstance().appViewModel().getRecordIngTimeData();
            long recordId = recordIngTimeData != null ? recordIngTimeData.getRecordId() : 0;
            LogExt.logE("analyzeAudio saveAmpData recordId = " + recordId, TAG);
            RecordDataSaveUtil.INSTANCE.saveAmpData(recordId);
        }
        return calculateAmplitude;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object checkWordState(java.util.ArrayList<com.upuphone.ar.fastrecord.phone.db.RecordEntity> r17, kotlin.coroutines.Continuation<? super java.lang.Boolean> r18) {
        /*
            r16 = this;
            r0 = r18
            boolean r1 = r0 instanceof com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils$checkWordState$1
            if (r1 == 0) goto L_0x0015
            r1 = r0
            com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils$checkWordState$1 r1 = (com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils$checkWordState$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0015
            int r2 = r2 - r3
            r1.label = r2
            goto L_0x001c
        L_0x0015:
            com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils$checkWordState$1 r1 = new com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils$checkWordState$1
            r2 = r16
            r1.<init>(r2, r0)
        L_0x001c:
            java.lang.Object r0 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 2
            r5 = 1
            if (r3 == 0) goto L_0x0061
            if (r3 == r5) goto L_0x004a
            if (r3 != r4) goto L_0x0042
            java.lang.Object r3 = r1.L$3
            com.upuphone.ar.fastrecord.phone.db.RecordSummaryEntity r3 = (com.upuphone.ar.fastrecord.phone.db.RecordSummaryEntity) r3
            java.lang.Object r6 = r1.L$2
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r7 = r1.L$1
            java.util.Iterator r7 = (java.util.Iterator) r7
            java.lang.Object r8 = r1.L$0
            kotlin.jvm.internal.Ref$BooleanRef r8 = (kotlin.jvm.internal.Ref.BooleanRef) r8
            kotlin.ResultKt.throwOnFailure(r0)
            r13 = r8
            goto L_0x00dd
        L_0x0042:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x004a:
            java.lang.Object r3 = r1.L$3
            java.util.List r3 = (java.util.List) r3
            java.lang.Object r6 = r1.L$2
            com.upuphone.ar.fastrecord.phone.db.RecordEntity r6 = (com.upuphone.ar.fastrecord.phone.db.RecordEntity) r6
            java.lang.Object r7 = r1.L$1
            java.util.Iterator r7 = (java.util.Iterator) r7
            java.lang.Object r8 = r1.L$0
            kotlin.jvm.internal.Ref$BooleanRef r8 = (kotlin.jvm.internal.Ref.BooleanRef) r8
            kotlin.ResultKt.throwOnFailure(r0)
            r14 = r3
            r3 = r7
            r13 = r8
            goto L_0x00b1
        L_0x0061:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlin.jvm.internal.Ref$BooleanRef r0 = new kotlin.jvm.internal.Ref$BooleanRef
            r0.<init>()
            java.util.Iterator r3 = r17.iterator()
        L_0x006d:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x018f
            java.lang.Object r6 = r3.next()
            r13 = r6
            com.upuphone.ar.fastrecord.phone.db.RecordEntity r13 = (com.upuphone.ar.fastrecord.phone.db.RecordEntity) r13
            com.upuphone.ar.fastrecord.phone.FastRecordManager$Companion r6 = com.upuphone.ar.fastrecord.phone.FastRecordManager.Companion
            com.upuphone.ar.fastrecord.phone.FastRecordManager r7 = r6.getInstance()
            com.upuphone.ar.fastrecord.phone.db.FastRecordVoiceWordDao r7 = r7.fastRecordVoiceWordDao()
            long r8 = r13.getRecordId()
            java.util.List r14 = r7.findFastRecordOrderByStartTime(r8)
            com.upuphone.ar.fastrecord.phone.FastRecordManager r6 = r6.getInstance()
            com.upuphone.ar.fastrecord.phone.db.FastRecordSummaryDao r6 = r6.fastRecordSummaryDao()
            long r7 = r13.getRecordId()
            r1.L$0 = r0
            r1.L$1 = r3
            r1.L$2 = r13
            r1.L$3 = r14
            r1.label = r5
            r9 = 0
            r11 = 2
            r12 = 0
            r10 = r1
            java.lang.Object r6 = com.upuphone.ar.fastrecord.phone.db.FastRecordSummaryDao.DefaultImpls.queryNoFinishByRecordId$default(r6, r7, r9, r10, r11, r12)
            if (r6 != r2) goto L_0x00ad
            return r2
        L_0x00ad:
            r15 = r13
            r13 = r0
            r0 = r6
            r6 = r15
        L_0x00b1:
            com.upuphone.ar.fastrecord.phone.db.RecordSummaryEntity r0 = (com.upuphone.ar.fastrecord.phone.db.RecordSummaryEntity) r0
            com.upuphone.ar.fastrecord.phone.FastRecordManager$Companion r7 = com.upuphone.ar.fastrecord.phone.FastRecordManager.Companion
            com.upuphone.ar.fastrecord.phone.FastRecordManager r7 = r7.getInstance()
            com.upuphone.ar.fastrecord.phone.db.FastRecordTodoItemDao r7 = r7.fastRecordTodoItemDao()
            long r8 = r6.getRecordId()
            r1.L$0 = r13
            r1.L$1 = r3
            r1.L$2 = r14
            r1.L$3 = r0
            r1.label = r4
            r10 = 0
            r11 = 2
            r12 = 0
            r6 = r7
            r7 = r8
            r9 = r10
            r10 = r1
            java.lang.Object r6 = com.upuphone.ar.fastrecord.phone.db.FastRecordTodoItemDao.DefaultImpls.queryAllNoFinishByRecordId$default(r6, r7, r9, r10, r11, r12)
            if (r6 != r2) goto L_0x00d9
            return r2
        L_0x00d9:
            r7 = r3
            r3 = r0
            r0 = r6
            r6 = r14
        L_0x00dd:
            java.util.List r0 = (java.util.List) r0
            r8 = 0
            if (r6 == 0) goto L_0x00eb
            boolean r9 = r6.isEmpty()
            if (r9 == 0) goto L_0x00e9
            goto L_0x00eb
        L_0x00e9:
            r9 = r8
            goto L_0x00ec
        L_0x00eb:
            r9 = r5
        L_0x00ec:
            r9 = r9 ^ r5
            if (r0 == 0) goto L_0x00f8
            boolean r10 = r0.isEmpty()
            if (r10 == 0) goto L_0x00f6
            goto L_0x00f8
        L_0x00f6:
            r10 = r8
            goto L_0x00f9
        L_0x00f8:
            r10 = r5
        L_0x00f9:
            r10 = r10 ^ r5
            if (r3 == 0) goto L_0x00fe
            r11 = r5
            goto L_0x00ff
        L_0x00fe:
            r11 = r8
        L_0x00ff:
            if (r3 == 0) goto L_0x0106
            java.lang.String r12 = r3.getContent()
            goto L_0x0107
        L_0x0106:
            r12 = 0
        L_0x0107:
            if (r12 == 0) goto L_0x010f
            int r12 = r12.length()
            if (r12 != 0) goto L_0x0110
        L_0x010f:
            r8 = r5
        L_0x0110:
            r8 = r8 ^ r5
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r14 = "checkFastRecordShareType voiceWordList state "
            r12.append(r14)
            r12.append(r9)
            java.lang.String r9 = ",mTodoList state "
            r12.append(r9)
            r12.append(r10)
            java.lang.String r9 = ",mRecordSummaryEntity state "
            r12.append(r9)
            r12.append(r11)
            java.lang.String r9 = ", mRecordSummaryEntity content state "
            r12.append(r9)
            r12.append(r8)
            java.lang.String r8 = r12.toString()
            java.lang.String r9 = "FastRecord_VoiceUtils"
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logW(r8, r9)
            if (r6 == 0) goto L_0x016a
            java.util.Iterator r8 = r6.iterator()
        L_0x0145:
            boolean r10 = r8.hasNext()
            if (r10 == 0) goto L_0x016a
            java.lang.Object r10 = r8.next()
            com.upuphone.ar.fastrecord.phone.db.RecordVoiceWordEntity r10 = (com.upuphone.ar.fastrecord.phone.db.RecordVoiceWordEntity) r10
            java.lang.String r10 = r10.getWordContent()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "checkFastRecordShareType value = "
            r11.append(r12)
            r11.append(r10)
            java.lang.String r10 = r11.toString()
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r10, r9)
            goto L_0x0145
        L_0x016a:
            if (r6 == 0) goto L_0x0172
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L_0x0189
        L_0x0172:
            if (r0 == 0) goto L_0x017a
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0189
        L_0x017a:
            if (r3 == 0) goto L_0x018b
            java.lang.String r0 = r3.getContent()
            if (r0 == 0) goto L_0x018b
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0189
            goto L_0x018b
        L_0x0189:
            r13.element = r5
        L_0x018b:
            r3 = r7
            r0 = r13
            goto L_0x006d
        L_0x018f:
            boolean r0 = r0.element
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils.checkWordState(java.util.ArrayList, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void createRecordEntityForCache(RecordCacheTag recordCacheTag) {
        LogExt.logE("createRecordEntityForCache cacheRecordEntity == null", TAG);
        FastRecordManager.Companion companion = FastRecordManager.Companion;
        RecordEntity findRecordEntityByIdNormal = companion.getInstance().fastRecordDao().findRecordEntityByIdNormal(recordCacheTag.getId());
        if (findRecordEntityByIdNormal == null) {
            LogExt.logE("createRecordEntityForCache record == null", TAG);
            RecordEntity createRecordEntity = RecordDataSaveUtil.INSTANCE.createRecordEntity(recordCacheTag.getId(), recordCacheTag.getType());
            createRecordEntity.setDownloading(true);
            companion.getInstance().fastRecordDao().insertForCacheDownloading(createRecordEntity);
            cacheExistRecordMap.put(Long.valueOf(recordCacheTag.getId()), createRecordEntity);
            return;
        }
        LogExt.logE("createRecordEntityForCache record info is " + findRecordEntityByIdNormal, TAG);
        cacheExistRecordMap.put(Long.valueOf(recordCacheTag.getId()), findRecordEntityByIdNormal);
    }

    private final void createVoiceEntity(long j, String str, String str2, String str3, String str4, long j2, long j3) {
        String str5 = str2;
        RecordVoiceEntity recordVoiceEntity = r1;
        RecordVoiceEntity recordVoiceEntity2 = new RecordVoiceEntity(0, (String) null, 0, (String) null, (String) null, (String) null, 0, 0, (String) null, (String) null, 1023, (DefaultConstructorMarker) null);
        recordVoiceEntity.setRecordId(j);
        recordVoiceEntity.setRole(str);
        recordVoiceEntity.setStartTag(j2);
        recordVoiceEntity.setEndTag(j3);
        RecordVoiceEntity recordVoiceEntity3 = recordVoiceEntity;
        String str6 = str2;
        recordVoiceEntity3.setCachePcmFilePath(str6);
        recordVoiceEntity3.setCacheOPlusFilePath(str3);
        recordVoiceEntity3.setCacheFileDir(str4);
        LogExt.logW("savePcmData insert recordPcmFilePath = " + str6 + " mRecordVoiceEntity = " + recordVoiceEntity3, TAG);
        FastRecordManager.Companion.getInstance().fastRecordVoice().insert(recordVoiceEntity3);
    }

    private final String createVoiceEntityAndSave(long j, String str, ArrayList<Long> arrayList) {
        long j2 = j;
        ArrayList<Long> arrayList2 = arrayList;
        Long l = arrayList2.get(0);
        Intrinsics.checkNotNullExpressionValue(l, "get(...)");
        long longValue = l.longValue();
        Long l2 = arrayList2.get(arrayList.size() - 1);
        Intrinsics.checkNotNullExpressionValue(l2, "get(...)");
        long longValue2 = l2.longValue();
        RecordFileUtils recordFileUtils = RecordFileUtils.INSTANCE;
        String dirOrCreateForRecord = recordFileUtils.getDirOrCreateForRecord(FastRecordManager.Companion.getInstance().appContext(), j2, str);
        String createVoicePcmFilePath = recordFileUtils.createVoicePcmFilePath(j2 + AccountConstantKt.DEFAULT_SEGMENT + longValue, dirOrCreateForRecord);
        String str2 = createVoicePcmFilePath;
        createVoiceEntity(j, str, createVoicePcmFilePath, "", dirOrCreateForRecord, longValue, longValue2);
        StringBuilder sb = new StringBuilder();
        sb.append("savePcmData create new file add save pcm  recordPcmFilePath = ");
        sb.append(str2);
        sb.append(" ,recordId = ");
        sb.append(j2);
        sb.append(",byteRoleType = ");
        String str3 = str2;
        sb.append(str);
        sb.append(",mkdir = ");
        sb.append(dirOrCreateForRecord);
        sb.append("，startTag = ");
        sb.append(longValue);
        sb.append(",endTag = ");
        sb.append(longValue2);
        LogExt.logW(sb.toString(), TAG);
        return str3;
    }

    /* access modifiers changed from: private */
    public static final void feedPhoneMuteData$lambda$21$lambda$20(RecordGlassAudioInfo recordGlassAudioInfo, byte[] bArr) {
        Intrinsics.checkNotNullParameter(recordGlassAudioInfo, "$mRecordGlassAudioInfo");
        FastRecordManager.Companion.getInstance().appViewModel().updateRecordingTime(recordGlassAudioInfo.getTag() * 60, recordGlassAudioInfo.getId());
        excessPhoneFeedCacheTag.add(Long.valueOf(recordGlassAudioInfo.getTag()));
        int length = bArr.length;
        byte[] sliceArray = ArraysKt.sliceArray(bArr, RangesKt.until(0, length / 2));
        RecordOpusCodecUtils.Companion companion = RecordOpusCodecUtils.Companion;
        byte[] decodePhoneRemoteFrame = companion.getInstance().decodePhoneRemoteFrame(sliceArray, true);
        byte[] bArr2 = excessUpFeedCacheBytes;
        byte[] copyOf = Arrays.copyOf(decodePhoneRemoteFrame, decodePhoneRemoteFrame.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        byte[] plus = ArraysKt.plus(bArr2, copyOf);
        excessUpFeedCacheBytes = plus;
        if (plus.length >= ARI_MIN_CACHE_RECORDING_PCM_SIZE) {
            RecordVoiceUtils recordVoiceUtils = INSTANCE;
            long id = recordGlassAudioInfo.getId();
            byte[] bArr3 = excessUpFeedCacheBytes;
            byte[] copyOf2 = Arrays.copyOf(bArr3, bArr3.length);
            Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(...)");
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(excessPhoneFeedCacheTag);
            Unit unit = Unit.INSTANCE;
            recordVoiceUtils.savePcmData(id, copyOf2, RecordConstants.UP_RECORD_TYPE, arrayList);
            excessUpFeedCacheBytes = new byte[0];
        }
        byte[] decodePhoneProximalFrame = companion.getInstance().decodePhoneProximalFrame(ArraysKt.sliceArray(bArr, RangesKt.until(bArr.length / 2, length)), true);
        RecordVoiceUtils recordVoiceUtils2 = INSTANCE;
        byte[] copyOf3 = Arrays.copyOf(decodePhoneRemoteFrame, decodePhoneRemoteFrame.length);
        Intrinsics.checkNotNullExpressionValue(copyOf3, "copyOf(...)");
        byte[] copyOf4 = Arrays.copyOf(decodePhoneProximalFrame, decodePhoneProximalFrame.length);
        Intrinsics.checkNotNullExpressionValue(copyOf4, "copyOf(...)");
        recordVoiceUtils2.analyzeAudio(ArraysKt.plus(copyOf3, copyOf4));
        byte[] bArr4 = excessDownFeedCacheBytes;
        byte[] copyOf5 = Arrays.copyOf(decodePhoneProximalFrame, decodePhoneProximalFrame.length);
        Intrinsics.checkNotNullExpressionValue(copyOf5, "copyOf(...)");
        byte[] plus2 = ArraysKt.plus(bArr4, copyOf5);
        excessDownFeedCacheBytes = plus2;
        if (plus2.length >= ARI_MIN_CACHE_RECORDING_PCM_SIZE) {
            long id2 = recordGlassAudioInfo.getId();
            byte[] bArr5 = excessDownFeedCacheBytes;
            byte[] copyOf6 = Arrays.copyOf(bArr5, bArr5.length);
            Intrinsics.checkNotNullExpressionValue(copyOf6, "copyOf(...)");
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(excessPhoneFeedCacheTag);
            Unit unit2 = Unit.INSTANCE;
            recordVoiceUtils2.savePcmData(id2, copyOf6, RecordConstants.DOWN_RECORD_TYPE, arrayList2);
            excessDownFeedCacheBytes = new byte[0];
        }
    }

    /* access modifiers changed from: private */
    public static final void feedSceneData$lambda$24$lambda$23(RecordGlassAudioInfo recordGlassAudioInfo, byte[] bArr) {
        Intrinsics.checkNotNullParameter(recordGlassAudioInfo, "$mRecordGlassAudioInfo");
        FastRecordManager.Companion.getInstance().appViewModel().updateRecordingTime(recordGlassAudioInfo.getTag() * 60, recordGlassAudioInfo.getId());
        int length = bArr.length;
        LogExt.logW("single voice data bytes size = " + length, TAG);
        byte[] decodeScreenFrame = RecordOpusCodecUtils.Companion.getInstance().decodeScreenFrame(bArr, true);
        RecordVoiceUtils recordVoiceUtils = INSTANCE;
        byte[] copyOf = Arrays.copyOf(decodeScreenFrame, decodeScreenFrame.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        recordVoiceUtils.analyzeAudio(copyOf);
        excessSingleFeedCacheBytes = ArraysKt.plus(excessSingleFeedCacheBytes, decodeScreenFrame);
        excessSingleFeedCacheTag.add(Long.valueOf(recordGlassAudioInfo.getTag()));
        if (excessSingleFeedCacheBytes.length >= ARI_MIN_CACHE_RECORDING_PCM_SIZE) {
            long id = recordGlassAudioInfo.getId();
            byte[] bArr2 = excessSingleFeedCacheBytes;
            byte[] copyOf2 = Arrays.copyOf(bArr2, bArr2.length);
            Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(...)");
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(excessSingleFeedCacheTag);
            Unit unit = Unit.INSTANCE;
            recordVoiceUtils.savePcmData(id, copyOf2, RecordConstants.SCENE_RECORD_TYPE, arrayList);
            excessSingleFeedCacheBytes = new byte[0];
        }
    }

    private final HashMap<Long, Long> getCacheAudioMaxTag(RecordGlassCacheInfo recordGlassCacheInfo) {
        HashMap<Long, Long> hashMap = new HashMap<>();
        ArrayList<RecordCacheTag> list = recordGlassCacheInfo.getList();
        if (list != null) {
            for (RecordCacheTag recordCacheTag : list) {
                if (hashMap.containsKey(Long.valueOf(recordCacheTag.getId()))) {
                    Long l = hashMap.get(Long.valueOf(recordCacheTag.getId()));
                    if (l == null) {
                        l = 0L;
                    }
                    Intrinsics.checkNotNull(l);
                    if (l.longValue() < recordCacheTag.getTag()) {
                        hashMap.put(Long.valueOf(recordCacheTag.getId()), Long.valueOf(recordCacheTag.getTag()));
                    }
                } else {
                    hashMap.put(Long.valueOf(recordCacheTag.getId()), Long.valueOf(recordCacheTag.getTag()));
                }
            }
        }
        LogExt.logE("getCacheAudioMaxTag max tag = " + hashMap, TAG);
        return hashMap;
    }

    /* access modifiers changed from: private */
    public final String getFileNameAndHashMap(HashMap<String, Long> hashMap, String str, String str2) {
        if (hashMap.containsKey(str)) {
            Long l = hashMap.get(str);
            LogExt.logE("getFileNameAndHashMap value = " + l, TAG);
            if (l != null) {
                hashMap.put(str, Long.valueOf(l.longValue() + 1));
            } else {
                hashMap.put(str, 0L);
            }
        } else {
            hashMap.put(str, 0L);
            LogExt.logE("getFileNameAndHashMap value = 1", TAG);
        }
        Long l2 = hashMap.get(str);
        if (l2 != null && l2.longValue() == 0) {
            return str + str2;
        }
        Long l3 = hashMap.get(str);
        return str + AccountConstantKt.DEFAULT_SEGMENT + l3 + str2;
    }

    /* access modifiers changed from: private */
    public final String getFileShareName(String str, long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(instance.getTime());
        LogExt.logE("getWordShareName recordTitle = " + str + ",lastDayInfo = " + format, TAG);
        String replace$default = StringsKt.replace$default(str, "/", "\\", false, 4, (Object) null);
        return replace$default + AccountConstantKt.DEFAULT_SEGMENT + format;
    }

    private final ArrayList<RecordTodoItemEntity> getNormalTodoData(ArrayList<RecordTodoItemEntity> arrayList) {
        ArrayList<RecordTodoItemEntity> arrayList2 = new ArrayList<>();
        for (RecordTodoItemEntity add : arrayList) {
            arrayList2.add(add);
        }
        return arrayList2;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00c6 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0145 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getRecordWordShareFile(android.content.Context r17, long r18, java.lang.String r20, kotlin.coroutines.Continuation<? super java.io.File> r21) {
        /*
            r16 = this;
            r0 = r16
            r8 = r18
            r1 = r21
            boolean r2 = r1 instanceof com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils$getRecordWordShareFile$1
            if (r2 == 0) goto L_0x001a
            r2 = r1
            com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils$getRecordWordShareFile$1 r2 = (com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils$getRecordWordShareFile$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x001a
            int r3 = r3 - r4
            r2.label = r3
        L_0x0018:
            r10 = r2
            goto L_0x0020
        L_0x001a:
            com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils$getRecordWordShareFile$1 r2 = new com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils$getRecordWordShareFile$1
            r2.<init>(r0, r1)
            goto L_0x0018
        L_0x0020:
            java.lang.Object r1 = r10.result
            java.lang.Object r11 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r10.label
            r12 = 2
            r3 = 1
            if (r2 == 0) goto L_0x006c
            if (r2 == r3) goto L_0x0051
            if (r2 != r12) goto L_0x0049
            java.lang.Object r0 = r10.L$4
            com.upuphone.ar.fastrecord.phone.db.RecordSummaryEntity r0 = (com.upuphone.ar.fastrecord.phone.db.RecordSummaryEntity) r0
            java.lang.Object r2 = r10.L$3
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r3 = r10.L$2
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r4 = r10.L$1
            android.content.Context r4 = (android.content.Context) r4
            java.lang.Object r5 = r10.L$0
            com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils r5 = (com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils) r5
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x00cc
        L_0x0049:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0051:
            long r2 = r10.J$0
            java.lang.Object r0 = r10.L$3
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r4 = r10.L$2
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r10.L$1
            android.content.Context r5 = (android.content.Context) r5
            java.lang.Object r6 = r10.L$0
            com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils r6 = (com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils) r6
            kotlin.ResultKt.throwOnFailure(r1)
            r15 = r4
            r14 = r5
            r4 = r2
            r2 = r0
            r0 = r6
            goto L_0x00a4
        L_0x006c:
            kotlin.ResultKt.throwOnFailure(r1)
            com.upuphone.ar.fastrecord.phone.FastRecordManager$Companion r1 = com.upuphone.ar.fastrecord.phone.FastRecordManager.Companion
            com.upuphone.ar.fastrecord.phone.FastRecordManager r2 = r1.getInstance()
            com.upuphone.ar.fastrecord.phone.db.FastRecordVoiceWordDao r2 = r2.fastRecordVoiceWordDao()
            java.util.List r13 = r2.findFastRecordOrderByStartTime(r8)
            com.upuphone.ar.fastrecord.phone.FastRecordManager r1 = r1.getInstance()
            com.upuphone.ar.fastrecord.phone.db.FastRecordSummaryDao r1 = r1.fastRecordSummaryDao()
            r10.L$0 = r0
            r14 = r17
            r10.L$1 = r14
            r15 = r20
            r10.L$2 = r15
            r10.L$3 = r13
            r10.J$0 = r8
            r10.label = r3
            r4 = 0
            r6 = 2
            r7 = 0
            r2 = r18
            r5 = r10
            java.lang.Object r1 = com.upuphone.ar.fastrecord.phone.db.FastRecordSummaryDao.DefaultImpls.queryNoFinishByRecordId$default(r1, r2, r4, r5, r6, r7)
            if (r1 != r11) goto L_0x00a2
            return r11
        L_0x00a2:
            r4 = r8
            r2 = r13
        L_0x00a4:
            com.upuphone.ar.fastrecord.phone.db.RecordSummaryEntity r1 = (com.upuphone.ar.fastrecord.phone.db.RecordSummaryEntity) r1
            com.upuphone.ar.fastrecord.phone.FastRecordManager$Companion r3 = com.upuphone.ar.fastrecord.phone.FastRecordManager.Companion
            com.upuphone.ar.fastrecord.phone.FastRecordManager r3 = r3.getInstance()
            com.upuphone.ar.fastrecord.phone.db.FastRecordTodoItemDao r3 = r3.fastRecordTodoItemDao()
            r10.L$0 = r0
            r10.L$1 = r14
            r10.L$2 = r15
            r10.L$3 = r2
            r10.L$4 = r1
            r10.label = r12
            r6 = 0
            r8 = 2
            r9 = 0
            r7 = r10
            java.lang.Object r3 = com.upuphone.ar.fastrecord.phone.db.FastRecordTodoItemDao.DefaultImpls.queryAllNoFinishByRecordId$default(r3, r4, r6, r7, r8, r9)
            if (r3 != r11) goto L_0x00c7
            return r11
        L_0x00c7:
            r5 = r0
            r0 = r1
            r1 = r3
            r4 = r14
            r3 = r15
        L_0x00cc:
            java.util.List r1 = (java.util.List) r1
            java.lang.String r1 = r5.getTodoShareText(r1)
            java.lang.CharSequence r1 = kotlin.text.StringsKt.trim((java.lang.CharSequence) r1)
            java.lang.String r1 = r1.toString()
            java.lang.String r0 = r5.getSummaryShareText(r0)
            java.lang.CharSequence r0 = kotlin.text.StringsKt.trim((java.lang.CharSequence) r0)
            java.lang.String r0 = r0.toString()
            java.lang.StringBuffer r5 = new java.lang.StringBuffer
            r5.<init>()
            java.lang.String r6 = "FastRecord_VoiceUtils"
            java.lang.String r7 = "\n"
            if (r2 == 0) goto L_0x0120
            java.util.Iterator r2 = r2.iterator()
        L_0x00f5:
            boolean r8 = r2.hasNext()
            if (r8 == 0) goto L_0x0120
            java.lang.Object r8 = r2.next()
            com.upuphone.ar.fastrecord.phone.db.RecordVoiceWordEntity r8 = (com.upuphone.ar.fastrecord.phone.db.RecordVoiceWordEntity) r8
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "item info = "
            r9.append(r10)
            r9.append(r8)
            java.lang.String r9 = r9.toString()
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r9, r6)
            java.lang.String r8 = r8.getWordContent()
            r5.append(r8)
            r5.append(r7)
            goto L_0x00f5
        L_0x0120:
            java.lang.String r2 = r5.toString()
            java.lang.String r5 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            java.lang.CharSequence r2 = kotlin.text.StringsKt.trim((java.lang.CharSequence) r2)
            java.lang.String r2 = r2.toString()
            int r8 = r2.length()
            r9 = 0
            if (r8 != 0) goto L_0x0146
            int r8 = r1.length()
            if (r8 != 0) goto L_0x0146
            int r8 = r0.length()
            if (r8 != 0) goto L_0x0146
            return r9
        L_0x0146:
            java.lang.StringBuffer r8 = new java.lang.StringBuffer
            r8.<init>()
            int r10 = r1.length()
            java.lang.String r11 = "getString(...)"
            if (r10 <= 0) goto L_0x0154
            goto L_0x015a
        L_0x0154:
            int r10 = r0.length()
            if (r10 <= 0) goto L_0x0198
        L_0x015a:
            com.upuphone.ar.fastrecord.phone.FastRecordManager$Companion r10 = com.upuphone.ar.fastrecord.phone.FastRecordManager.Companion
            com.upuphone.ar.fastrecord.phone.FastRecordManager r10 = r10.getInstance()
            android.content.Context r10 = r10.appContext()
            int r12 = com.upuphone.ar.fastrecord.R.string.fr_extract_statement
            java.lang.String r10 = r10.getString(r12)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r11)
            java.lang.String r12 = "/*"
            r8.append(r12)
            r8.append(r10)
            java.lang.String r10 = "*/"
            r8.append(r10)
            r8.append(r7)
            int r10 = r1.length()
            if (r10 <= 0) goto L_0x018c
            r8.append(r1)
            r8.append(r7)
            r8.append(r7)
        L_0x018c:
            int r1 = r0.length()
            if (r1 <= 0) goto L_0x0198
            r8.append(r0)
            r8.append(r7)
        L_0x0198:
            int r0 = r2.length()
            if (r0 <= 0) goto L_0x01bf
            com.upuphone.ar.fastrecord.phone.FastRecordManager$Companion r0 = com.upuphone.ar.fastrecord.phone.FastRecordManager.Companion
            com.upuphone.ar.fastrecord.phone.FastRecordManager r0 = r0.getInstance()
            android.content.Context r0 = r0.appContext()
            int r1 = com.upuphone.ar.fastrecord.R.string.fast_record_asr_title_content
            java.lang.String r0 = r0.getString(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r11)
            r8.append(r7)
            r8.append(r0)
            java.lang.String r0 = ":\n"
            r8.append(r0)
            r8.append(r2)
        L_0x01bf:
            com.upuphone.ar.fastrecord.phone.utils.RecordFileUtils r0 = com.upuphone.ar.fastrecord.phone.utils.RecordFileUtils.INSTANCE
            java.io.File r0 = r0.getTempShareFile(r4, r3)
            boolean r1 = r0.exists()
            if (r1 == 0) goto L_0x01ce
            r0.delete()
        L_0x01ce:
            r0.createNewFile()
            java.io.BufferedWriter r1 = new java.io.BufferedWriter
            java.io.FileWriter r2 = new java.io.FileWriter
            r2.<init>(r0)
            r1.<init>(r2)
            java.lang.String r2 = r8.toString()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "wordValue = "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logW(r3, r6)
            r1.write(r2)     // Catch:{ all -> 0x0200 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0200 }
            kotlin.io.CloseableKt.closeFinally(r1, r9)
            return r0
        L_0x0200:
            r0 = move-exception
            r2 = r0
            throw r2     // Catch:{ all -> 0x0203 }
        L_0x0203:
            r0 = move-exception
            r3 = r0
            kotlin.io.CloseableKt.closeFinally(r1, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils.getRecordWordShareFile(android.content.Context, long, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final String getSummaryShareText(RecordSummaryEntity recordSummaryEntity) {
        StringBuilder sb = new StringBuilder();
        boolean z = recordSummaryEntity != null;
        String contentTemp = recordSummaryEntity != null ? recordSummaryEntity.getContentTemp() : null;
        LogExt.logE("getSummaryShareText data is null  " + z + ", contentTemp = " + contentTemp, TAG);
        if (recordSummaryEntity != null && !TextUtils.isEmpty(recordSummaryEntity.getContentTemp())) {
            String string = FastRecordManager.Companion.getInstance().appContext().getString(R.string.fast_record_summary_total_type);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            sb.append(StringUtils.LF);
            sb.append(string);
            sb.append(AccountConstantKt.CODE_SEPARTOR);
            sb.append(StringUtils.LF);
            sb.append(recordSummaryEntity.getContentTemp());
            sb.append(StringUtils.LF);
        }
        LogExt.logE("getSummaryShareText  sb.toString()=" + sb, TAG);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    /* access modifiers changed from: private */
    public final String getTodoShareText(List<RecordTodoItemEntity> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String string = FastRecordManager.Companion.getInstance().appContext().getString(R.string.fast_record_summary_dealt_type);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        sb.append(string);
        sb.append(AccountConstantKt.CODE_SEPARTOR);
        sb.append(StringUtils.LF);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        int i = 0;
        for (T next : getNormalTodoData(arrayList)) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            sb.append(((RecordTodoItemEntity) next).getContentTemp());
            sb.append(StringUtils.LF);
            i = i2;
        }
        LogExt.logE("getTodoShareText  sb.toString()=" + sb, TAG);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    /* access modifiers changed from: private */
    public static final void initAllRecordingTagData$lambda$8() {
        LogExt.logE("initAllRecordingTagData", TAG);
        excessPhoneFeedCacheTag = new ArrayList<>();
        excessSingleFeedCacheTag = new ArrayList<>();
    }

    private final void initVoiceHandle() {
        if (mRecordVoiceHandleThread == null) {
            HandlerThread handlerThread = new HandlerThread("RecordVoiceUtils-thread");
            handlerThread.start();
            mRecordVoiceHandle = new Handler(handlerThread.getLooper());
            mRecordVoiceHandleThread = handlerThread;
        }
    }

    private final void queryRecordOrCreateForDownloading(RecordCacheTag recordCacheTag, Function1<? super RecordEntity, Unit> function1) {
        LogExt.logE("queryRecordOrCreateForDownloading mRecordCacheTag = " + recordCacheTag, TAG);
        if (cacheExistRecordMap.contains(Long.valueOf(recordCacheTag.getId()))) {
            long id = recordCacheTag.getId();
            LogExt.logE("cacheExistRecordMap contains " + id, TAG);
            if (cacheExistRecordMap.get(Long.valueOf(recordCacheTag.getId())) == null) {
                createRecordEntityForCache(recordCacheTag);
            }
            RecordEntity recordEntity = cacheExistRecordMap.get(Long.valueOf(recordCacheTag.getId()));
            if (recordEntity != null) {
                function1.invoke(recordEntity);
                return;
            }
            return;
        }
        long id2 = recordCacheTag.getId();
        LogExt.logE("cacheExistRecordMap do not contains " + id2, TAG);
        createRecordEntityForCache(recordCacheTag);
        RecordEntity recordEntity2 = cacheExistRecordMap.get(Long.valueOf(recordCacheTag.getId()));
        if (recordEntity2 != null) {
            function1.invoke(recordEntity2);
        }
    }

    private final void resetRecordState(long j) {
        FastRecordManager.Companion companion = FastRecordManager.Companion;
        RecordEntity findRecordEntityByIdNormal = companion.getInstance().fastRecordDao().findRecordEntityByIdNormal(j);
        if (findRecordEntityByIdNormal != null) {
            boolean isFinishFileMerge = findRecordEntityByIdNormal.isFinishFileMerge();
            LogExt.logW("updateCacheDataTime mRecordEntity != null isFinishFileMerge is " + isFinishFileMerge, TAG);
            if (findRecordEntityByIdNormal.isFinishFileMerge()) {
                findRecordEntityByIdNormal.setFinishFileMerge(false);
                companion.getInstance().fastRecordDao().updateRecordFinishFileMergeState(findRecordEntityByIdNormal.getRecordId(), false);
                return;
            }
            return;
        }
        RecordEntity createRecordEntity = RecordDataSaveUtil.INSTANCE.createRecordEntity(j, 1);
        createRecordEntity.setDownloading(true);
        createRecordEntity.setFinishFileMerge(false);
        Long l = timeMap.get(Long.valueOf(j));
        createRecordEntity.setTotalTime(l == null ? 0 : l.longValue());
        companion.getInstance().fastRecordDao().insertForCacheDownloading(createRecordEntity);
        long totalTime = createRecordEntity.getTotalTime();
        LogExt.logW("updateCacheDataTime mRecordEntity == null createRecordEntity  item  totalTime =  " + totalTime, TAG);
    }

    /* access modifiers changed from: private */
    public final void saveCachePcmData(RecordCacheTag recordCacheTag, byte[] bArr, String str, ArrayList<Long> arrayList) {
        long id = recordCacheTag.getId();
        int size = arrayList.size();
        LogExt.logW("saveCachePcmData recordId = " + id + ",byteRoleType = " + str + ", tagInfo size = " + size, TAG);
        List<RecordVoiceEntity> findVoiceEntityByIdAndRoleAsc = FastRecordManager.Companion.getInstance().fastRecordVoice().findVoiceEntityByIdAndRoleAsc(recordCacheTag.getId(), str);
        if (findVoiceEntityByIdAndRoleAsc == null || findVoiceEntityByIdAndRoleAsc.isEmpty()) {
            String createVoiceEntityAndSave = createVoiceEntityAndSave(recordCacheTag.getId(), str, arrayList);
            long id2 = recordCacheTag.getId();
            LogExt.logW("saveCachePcmData create new file add save pcm data when no db data recordPcmFilePath = " + createVoiceEntityAndSave + " ,recordId = " + id2 + ",byteRoleType = " + str, TAG);
            RecordFileUtils.INSTANCE.saveVoiceData(createVoiceEntityAndSave, bArr);
            return;
        }
        RecordVoiceEntity recordVoiceEntity = null;
        for (RecordVoiceEntity recordVoiceEntity2 : findVoiceEntityByIdAndRoleAsc) {
            long startTag = recordVoiceEntity2.getStartTag();
            if (arrayList.contains(Long.valueOf(startTag))) {
                LogExt.logW("saveCachePcmData tempTagInfoString.contains(dbStartTag.toString()),dbStartTag = " + startTag, TAG);
                recordVoiceEntity = recordVoiceEntity2;
            }
        }
        if (recordVoiceEntity == null) {
            String createVoiceEntityAndSave2 = createVoiceEntityAndSave(recordCacheTag.getId(), str, arrayList);
            LogExt.logW("saveCachePcmData mRecordVoiceEntity == null createVoiceEntityAndSave recordPcmFilePath = " + createVoiceEntityAndSave2, TAG);
            RecordFileUtils.INSTANCE.saveVoiceData(createVoiceEntityAndSave2, bArr);
            return;
        }
        String cachePcmFilePath = recordVoiceEntity.getCachePcmFilePath();
        LogExt.logW("saveCachePcmData  database exist db RecordVoiceEntity.cachePcmFilePath = " + cachePcmFilePath, TAG);
        if (cachePcmFilePath != null) {
            RecordFileUtils.INSTANCE.saveVoiceData(cachePcmFilePath, bArr);
        }
    }

    private final void saveCachePhoneToFile(RecordCacheTag recordCacheTag) {
        if (excessPhoneDownloadingTagMap.get(Long.valueOf(recordCacheTag.getId())) == null) {
            LogExt.logE("saveCachePhoneToFile tagList == null", TAG);
            excessPhoneDownloadingTagMap.put(Long.valueOf(recordCacheTag.getId()), new ArrayList());
        }
        ArrayList arrayList = excessPhoneDownloadingTagMap.get(Long.valueOf(recordCacheTag.getId()));
        if (arrayList != null) {
            arrayList.add(Long.valueOf(recordCacheTag.getTag()));
        }
        queryRecordOrCreateForDownloading(recordCacheTag, new RecordVoiceUtils$saveCachePhoneToFile$1(recordCacheTag));
    }

    private final void saveCacheSceneToFile(RecordCacheTag recordCacheTag) {
        if (excessSceneDownloadingTagMap.get(Long.valueOf(recordCacheTag.getId())) == null) {
            LogExt.logE("saveCacheSceneToFile tagList == null", TAG);
            excessSceneDownloadingTagMap.put(Long.valueOf(recordCacheTag.getId()), new ArrayList());
        }
        ArrayList arrayList = excessSceneDownloadingTagMap.get(Long.valueOf(recordCacheTag.getId()));
        if (arrayList != null) {
            arrayList.add(Long.valueOf(recordCacheTag.getTag()));
        }
        ArrayList<Long> arrayList2 = excessSceneDownloadingTagMap.get(Long.valueOf(recordCacheTag.getId()));
        LogExt.logE("saveCacheSceneToFile recordCacheTag list = " + arrayList2, TAG);
        queryRecordOrCreateForDownloading(recordCacheTag, new RecordVoiceUtils$saveCacheSceneToFile$1(recordCacheTag));
    }

    private final void saveOrUpdateTime(RecordGlassCacheInfo recordGlassCacheInfo) {
        for (Map.Entry next : getCacheAudioMaxTag(recordGlassCacheInfo).entrySet()) {
            long longValue = ((Number) next.getKey()).longValue();
            long longValue2 = ((Number) next.getValue()).longValue();
            LogExt.logE("saveOrUpdateTime recordId = " + longValue + ",tag = " + longValue2, TAG);
            INSTANCE.resetRecordState(longValue);
            if (!timeMap.containsKey(Long.valueOf(longValue))) {
                RecordEntity findRecordEntityByIdNormal = FastRecordManager.Companion.getInstance().fastRecordDao().findRecordEntityByIdNormal(longValue);
                long totalTime = findRecordEntityByIdNormal != null ? findRecordEntityByIdNormal.getTotalTime() : 0;
                LogExt.logE("containsKey not findRecordEntityByIdNormal,recordId = " + longValue + ",totalTime = " + totalTime, TAG);
                timeMap.put(Long.valueOf(longValue), Long.valueOf(findRecordEntityByIdNormal != null ? findRecordEntityByIdNormal.getTotalTime() : 0));
            }
            Long l = timeMap.get(Long.valueOf(longValue));
            long j = longValue2 * 60;
            LogExt.logE("timeMap[recordId] = " + l + ",tag * SINGLE_TAG_TIME = " + j, TAG);
            Long l2 = timeMap.get(Long.valueOf(longValue));
            if (l2 == null) {
                l2 = 0L;
            }
            Intrinsics.checkNotNull(l2);
            if (l2.longValue() < j) {
                timeMap.put(Long.valueOf(longValue), Long.valueOf(j));
                FastRecordDao fastRecordDao = FastRecordManager.Companion.getInstance().fastRecordDao();
                Long l3 = timeMap.get(Long.valueOf(longValue));
                if (l3 == null) {
                    l3 = 0L;
                }
                Intrinsics.checkNotNull(l3);
                fastRecordDao.updateRecordTotalTime(longValue, l3.longValue());
            }
        }
    }

    private final void savePcmData(long j, byte[] bArr, String str, ArrayList<Long> arrayList) {
        int size = arrayList.size();
        LogExt.logW("savePcmData recordId = " + j + ",byteRoleType = " + str + ", tagInfo size = " + size, TAG);
        List<RecordVoiceEntity> findVoiceEntityByIdAndRoleAsc = FastRecordManager.Companion.getInstance().fastRecordVoice().findVoiceEntityByIdAndRoleAsc(j, str);
        if (findVoiceEntityByIdAndRoleAsc == null || findVoiceEntityByIdAndRoleAsc.isEmpty()) {
            String createVoiceEntityAndSave = createVoiceEntityAndSave(j, str, arrayList);
            LogExt.logW("savePcmData create new file add save pcm data when no db data recordPcmFilePath = " + createVoiceEntityAndSave + " ,recordId = " + j + ",byteRoleType = " + str, TAG);
            RecordFileUtils.INSTANCE.saveVoiceData(createVoiceEntityAndSave, bArr);
            return;
        }
        RecordVoiceEntity recordVoiceEntity = null;
        for (RecordVoiceEntity recordVoiceEntity2 : findVoiceEntityByIdAndRoleAsc) {
            long startTag = recordVoiceEntity2.getStartTag();
            if (arrayList.contains(Long.valueOf(startTag))) {
                LogExt.logW("savePcmData tempTagInfoString.contains(dbStartTag.toString()),dbStartTag = " + startTag, TAG);
                recordVoiceEntity = recordVoiceEntity2;
            }
        }
        if (recordVoiceEntity == null) {
            String createVoiceEntityAndSave2 = createVoiceEntityAndSave(j, str, arrayList);
            LogExt.logW("savePcmData mRecordVoiceEntity == null createVoiceEntityAndSave recordPcmFilePath = " + createVoiceEntityAndSave2, TAG);
            RecordFileUtils.INSTANCE.saveVoiceData(createVoiceEntityAndSave2, bArr);
            return;
        }
        String cachePcmFilePath = recordVoiceEntity.getCachePcmFilePath();
        LogExt.logW("savePcmData  database exist db RecordVoiceEntity.cacheOPlusFilePath = " + cachePcmFilePath, TAG);
        if (cachePcmFilePath != null) {
            RecordFileUtils.INSTANCE.saveVoiceData(cachePcmFilePath, bArr);
        }
    }

    /* access modifiers changed from: private */
    public static final void savePhoneOrSceneCacheMuteData$lambda$13(RecordGlassCacheInfo recordGlassCacheInfo, int i, long j, long j2) {
        RecordGlassCacheInfo recordGlassCacheInfo2 = recordGlassCacheInfo;
        Intrinsics.checkNotNullParameter(recordGlassCacheInfo, "$audioInfo");
        ArrayList<RecordCacheTag> list = recordGlassCacheInfo.getList();
        if (list != null) {
            int i2 = 0;
            for (T next : list) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                RecordCacheTag recordCacheTag = (RecordCacheTag) next;
                if (recordCacheTag.getType() == 0) {
                    long id = recordCacheTag.getId();
                    long tag = recordCacheTag.getTag();
                    int length = recordCacheTag.getByteArray().length;
                    LogExt.logE("saveCachePhoneToFile id = " + id + ",tag = " + tag + ",size = " + length, TAG);
                    INSTANCE.saveCachePhoneToFile(recordCacheTag);
                } else {
                    long id2 = recordCacheTag.getId();
                    long tag2 = recordCacheTag.getTag();
                    int length2 = recordCacheTag.getByteArray().length;
                    LogExt.logE("saveCacheSceneToFile id = " + id2 + ",tag = " + tag2 + ",size = " + length2, TAG);
                    INSTANCE.saveCacheSceneToFile(recordCacheTag);
                }
                i2 = i3;
            }
        }
        int i4 = i;
        INSTANCE.updateCacheDataTime(recordGlassCacheInfo, i);
        RecordInterConnectHelper.sendMsgFinishCacheAck$default(RecordInterConnectHelper.Companion.getInstance(), j, j2, false, 4, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void subNameHashMap(HashMap<String, Long> hashMap, String str) {
        Long l;
        if (hashMap.containsKey(str) && (l = hashMap.get(str)) != null) {
            if (l.longValue() == 0) {
                hashMap.remove(str);
            } else {
                hashMap.put(str, Long.valueOf(l.longValue() - 1));
            }
        }
    }

    private final void updateCacheDataTime(RecordGlassCacheInfo recordGlassCacheInfo, int i) {
        saveOrUpdateTime(recordGlassCacheInfo);
        LogExt.logE("updateStartRecordGlassCacheInfo audioInfo = " + recordGlassCacheInfo + ",size = " + i, TAG);
        FastRecordManager.Companion.getInstance().appViewModel().updateStartRecordGlassCacheInfo(recordGlassCacheInfo, i);
    }

    public final boolean aiLanguageSupport(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "languageTYPE");
        return Intrinsics.areEqual((Object) "de-DE", (Object) str) || Intrinsics.areEqual((Object) "cmn-Hans-CN", (Object) str) || Intrinsics.areEqual((Object) "en-GB", (Object) str) || Intrinsics.areEqual((Object) "ja-JP", (Object) str);
    }

    public final void checkFastRecordShareType(@NotNull ArrayList<RecordEntity> arrayList, @NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(arrayList, "recordIdList");
        Intrinsics.checkNotNullParameter(function1, "callback");
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new RecordVoiceUtils$checkFastRecordShareType$1(arrayList, booleanRef, booleanRef2, function1, (Continuation<? super RecordVoiceUtils$checkFastRecordShareType$1>) null), 3, (Object) null);
    }

    public final void feedPhoneMuteData(@Nullable byte[] bArr, @NotNull RecordGlassAudioInfo recordGlassAudioInfo) {
        Handler handler;
        Intrinsics.checkNotNullParameter(recordGlassAudioInfo, "mRecordGlassAudioInfo");
        initVoiceHandle();
        if (bArr != null && (handler = mRecordVoiceHandle) != null) {
            handler.post(new a(recordGlassAudioInfo, bArr));
        }
    }

    public final void feedSceneData(@Nullable byte[] bArr, @NotNull RecordGlassAudioInfo recordGlassAudioInfo) {
        Handler handler;
        Intrinsics.checkNotNullParameter(recordGlassAudioInfo, "mRecordGlassAudioInfo");
        initVoiceHandle();
        if (bArr != null && (handler = mRecordVoiceHandle) != null) {
            handler.post(new c(recordGlassAudioInfo, bArr));
        }
    }

    public final void getRecordListWordUirList(@NotNull Context context, @NotNull List<RecordEntity> list, @NotNull Function1<? super ArrayList<Uri>, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "recordList");
        Intrinsics.checkNotNullParameter(function1, "callback");
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new RecordVoiceUtils$getRecordListWordUirList$1(list, context, function1, (Continuation<? super RecordVoiceUtils$getRecordListWordUirList$1>) null), 3, (Object) null);
    }

    public final void getSingleRecordShareMuteTempPath(@NotNull Context context, long j, @Nullable String str, @NotNull String str2, long j2, @NotNull Function1<? super ArrayList<Uri>, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "context");
        String str3 = str2;
        Intrinsics.checkNotNullParameter(str3, "recordTitle");
        Function1<? super ArrayList<Uri>, Unit> function12 = function1;
        Intrinsics.checkNotNullParameter(function12, "callback");
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new RecordVoiceUtils$getSingleRecordShareMuteTempPath$1(j, context, str3, j2, str, function12, (Continuation<? super RecordVoiceUtils$getSingleRecordShareMuteTempPath$1>) null), 3, (Object) null);
    }

    public final void getSingleRecordShareVideoPath(@NotNull Context context, @Nullable String str, @Nullable String str2, long j, long j2, @NotNull Function1<? super ArrayList<Uri>, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "context");
        Function1<? super ArrayList<Uri>, Unit> function12 = function1;
        Intrinsics.checkNotNullParameter(function12, "callback");
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new RecordVoiceUtils$getSingleRecordShareVideoPath$1(str, context, str2, j2, function12, (Continuation<? super RecordVoiceUtils$getSingleRecordShareVideoPath$1>) null), 3, (Object) null);
    }

    public final void getSingleRecordShareWordPath(@NotNull Context context, long j, @Nullable String str, long j2, @NotNull Function1<? super ArrayList<Uri>, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "context");
        Function1<? super ArrayList<Uri>, Unit> function12 = function1;
        Intrinsics.checkNotNullParameter(function12, "callback");
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new RecordVoiceUtils$getSingleRecordShareWordPath$1(context, j, str, j2, function12, (Continuation<? super RecordVoiceUtils$getSingleRecordShareWordPath$1>) null), 3, (Object) null);
    }

    public final void getVideoUirForSelectRecord(@NotNull Context context, @NotNull List<RecordEntity> list, @NotNull Function1<? super ArrayList<Uri>, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "recordList");
        Intrinsics.checkNotNullParameter(function1, "callback");
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new RecordVoiceUtils$getVideoUirForSelectRecord$1(list, context, function1, (Continuation<? super RecordVoiceUtils$getVideoUirForSelectRecord$1>) null), 3, (Object) null);
    }

    public final void getWordAndVideoUirForSelectRecord(@NotNull Context context, @NotNull List<RecordEntity> list, @NotNull Function1<? super ArrayList<Uri>, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "recordList");
        Intrinsics.checkNotNullParameter(function1, "callback");
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new RecordVoiceUtils$getWordAndVideoUirForSelectRecord$1(list, context, function1, (Continuation<? super RecordVoiceUtils$getWordAndVideoUirForSelectRecord$1>) null), 3, (Object) null);
    }

    public final void initAllRecordingTagData() {
        excessSceneDownloadingTagMap = new ConcurrentHashMap<>();
        excessPhoneDownloadingTagMap = new ConcurrentHashMap<>();
        initVoiceHandle();
        Handler handler = mRecordVoiceHandle;
        if (handler != null) {
            handler.post(new b());
        }
    }

    public final boolean isRtlLanguage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "languageTYPE");
        return Intrinsics.areEqual((Object) "ar-SA", (Object) str);
    }

    public final void savePhoneOrSceneCacheMuteData(long j, long j2, @NotNull RecordGlassCacheInfo recordGlassCacheInfo, int i) {
        Intrinsics.checkNotNullParameter(recordGlassCacheInfo, "audioInfo");
        if (mRecordReLoadVoiceCacheHandleThread == null) {
            HandlerThread handlerThread = new HandlerThread("RecordVoiceUtils-thread");
            handlerThread.start();
            mRecordReLoadVoiceCacheHandle = new Handler(handlerThread.getLooper());
            mRecordReLoadVoiceCacheHandleThread = handlerThread;
        }
        Handler handler = mRecordReLoadVoiceCacheHandle;
        if (handler != null) {
            handler.post(new d(recordGlassCacheInfo, i, j, j2));
        }
    }
}
