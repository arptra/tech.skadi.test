package com.upuphone.ar.fastrecord.phone.ui.viewmodel.history;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.honey.account.y3.a;
import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.bean.FastRecordLanguageBean;
import com.upuphone.ar.fastrecord.phone.datatrack.FastRecordDataTrackManager;
import com.upuphone.ar.fastrecord.phone.db.FastRecordDao;
import com.upuphone.ar.fastrecord.phone.db.RecordVoiceWordEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.starrynet.RecordConnectManager;
import com.upuphone.ar.fastrecord.phone.utils.RecordConstants;
import com.upuphone.ar.fastrecord.phone.utils.RecordDataSaveUtil;
import com.upuphone.ar.fastrecord.phone.utils.RecordFileUtils;
import com.upuphone.xr.interconnect.api.OperatorManager;
import com.upuphone.xr.interconnect.api.StarryNetDeviceInfoOperator;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.xjsd.xr.sapp.asr.UnifiedAsrHelper;
import com.xjsd.xr.sapp.asr.constants.AsrConstants;
import com.xjsd.xr.sapp.asr.dao.AsrRequestConfig;
import com.xjsd.xr.sapp.asr.dao.ResultExt;
import com.xjsd.xr.sapp.asr.dao.Src;
import com.xjsd.xr.sapp.asr.dao.TtsConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u0000 ~2\u00020\u0001:\u0001~B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020\nH\u0002J\u0016\u0010:\u001a\u00020\u00072\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00070<H\u0002J\b\u0010=\u001a\u00020\u0007H\u0002J\b\u0010>\u001a\u00020\u0007H\u0002J\u0010\u0010?\u001a\u00020\u00072\u0006\u00109\u001a\u00020\nH\u0002J\u0016\u0010@\u001a\u00020\u00072\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00070<H\u0002J\b\u0010B\u001a\u00020\u0007H\u0002J\b\u0010C\u001a\u00020\u0007H\u0002J(\u0010D\u001a\u00020\u00072\u0006\u0010E\u001a\u00020\n2\u0006\u0010F\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\nH\u0002J(\u0010I\u001a\u00020\u00072\u0006\u0010E\u001a\u00020\n2\u0006\u0010F\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\nH\u0002J(\u0010J\u001a\u00020\u00102\u0006\u0010E\u001a\u00020\n2\u0006\u0010F\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\nH\u0002J\u0014\u0010K\u001a\u00020\u00072\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00070<J\b\u0010L\u001a\u00020\u0007H\u0002J\b\u0010M\u001a\u00020\u0007H\u0002J\b\u0010N\u001a\u00020\nH\u0002J4\u0010O\u001a\u00020,2\"\u0010P\u001a\u001e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,0*j\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,`-2\u0006\u0010Q\u001a\u00020+H\u0002J4\u0010R\u001a\u00020,2\"\u0010P\u001a\u001e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u00040*j\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u0004`-2\u0006\u0010Q\u001a\u00020+H\u0002J\u0018\u0010S\u001a\u00020,2\u0006\u0010G\u001a\u00020\u00042\u0006\u0010T\u001a\u00020UH\u0002J\u0006\u0010V\u001a\u00020\u0004J\b\u0010W\u001a\u00020\nH\u0002J\u0006\u0010X\u001a\u00020\u0007J\u0006\u0010Y\u001a\u00020\u0007J\u0010\u0010Z\u001a\u00020\u00192\u0006\u0010[\u001a\u00020\nH\u0002J\b\u0010\\\u001a\u00020\u0007H\u0002J\b\u0010]\u001a\u00020\u0007H\u0002J\b\u0010^\u001a\u00020\u0007H\u0002J\u0012\u0010_\u001a\u00020\u00072\b\u0010T\u001a\u0004\u0018\u00010UH\u0002J\u0012\u0010`\u001a\u00020\u00072\b\u0010T\u001a\u0004\u0018\u00010UH\u0002J2\u0010a\u001a\u00020\u00072\u0006\u0010E\u001a\u00020\n2\u0006\u0010F\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\n2\b\u0010b\u001a\u0004\u0018\u00010cH\u0002J\u0012\u0010d\u001a\u00020\u00072\b\u0010b\u001a\u0004\u0018\u00010cH\u0002J2\u0010e\u001a\u00020\u00072\u0006\u0010E\u001a\u00020\n2\u0006\u0010F\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\n2\b\u0010b\u001a\u0004\u0018\u00010cH\u0002J\u0010\u0010f\u001a\u00020\u00072\u0006\u0010Q\u001a\u00020+H\u0002J\u0012\u0010g\u001a\u00020\u00072\b\u0010T\u001a\u0004\u0018\u00010UH\u0002J\u001a\u0010h\u001a\u00020\u00072\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006J \u0010i\u001a\u00020\u00072\u0018\u0010A\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\tJ\u001a\u0010j\u001a\u00020\u00072\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006J&\u0010k\u001a\u00020\u00072\u001e\u0010A\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\rJ\u0016\u0010l\u001a\u00020\u00072\u0006\u0010m\u001a\u00020\u00042\u0006\u0010n\u001a\u00020\u0019J.\u0010o\u001a\u00020\u00072\u0006\u0010[\u001a\u00020\n2\u0006\u0010p\u001a\u00020\n2\u0006\u0010q\u001a\u00020\n2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00070<H\u0002J\b\u0010r\u001a\u00020\u0007H\u0002J\b\u0010s\u001a\u00020\u0007H\u0002J\u0016\u0010t\u001a\u00020\u00072\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00070<H\u0002J\u0010\u0010u\u001a\u00020\u00072\u0006\u0010v\u001a\u00020\nH\u0002J\u0010\u0010w\u001a\u00020\u00072\u0006\u0010x\u001a\u00020\nH\u0002J\u0010\u0010y\u001a\u00020\u00072\u0006\u0010z\u001a\u00020\nH\u0002J\u0016\u0010{\u001a\u00020\u00072\u0006\u0010z\u001a\u00020\n2\u0006\u0010m\u001a\u00020\u0004J\u001e\u0010|\u001a\u00020\u00072\u0006\u0010z\u001a\u00020\n2\u0006\u0010}\u001a\u00020\n2\u0006\u0010m\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R(\u0010\f\u001a\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020!8BX\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R\u001b\u0010&\u001a\u00020!8BX\u0002¢\u0006\f\n\u0004\b(\u0010%\u001a\u0004\b'\u0010#R*\u0010)\u001a\u001e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,0*j\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,`-X\u0004¢\u0006\u0002\n\u0000R*\u0010.\u001a\u001e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,0*j\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,`-X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u000e¢\u0006\u0002\n\u0000R*\u00104\u001a\u001e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,0*j\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,`-X\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000¨\u0006"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/history/FastRecordHistoryAsrOperator;", "", "()V", "arsFileReadFinishTime", "", "asrEmptyCallback", "Lkotlin/Function1;", "", "asrFailCallback", "Lkotlin/Function2;", "", "asrFinishCallback", "asrProgressCallback", "Lkotlin/Function3;", "cacheOriginPhoneVoiceWordEntityList", "Ljava/util/ArrayList;", "Lcom/upuphone/ar/fastrecord/phone/db/RecordVoiceWordEntity;", "Lkotlin/collections/ArrayList;", "cacheOriginSceneVoiceWordEntityList", "cachePhoneVoiceWordEntityList", "cacheSceneVoiceWordEntityList", "checkFinishPrePareJob", "Lkotlinx/coroutines/Job;", "curCacheProgress", "endProximalState", "", "endRemoteState", "fileTotalTime", "isFinishComplianceFail", "isFinishPrePareAsrSocket", "isSaveFirstContent", "isSingleSocket", "mLongAudioAsrSingleSocketHelper", "Lcom/xjsd/xr/sapp/asr/UnifiedAsrHelper;", "getMLongAudioAsrSingleSocketHelper", "()Lcom/xjsd/xr/sapp/asr/UnifiedAsrHelper;", "mLongAudioAsrSingleSocketHelper$delegate", "Lkotlin/Lazy;", "mLongAudioAsrTwoSocketHelper", "getMLongAudioAsrTwoSocketHelper", "mLongAudioAsrTwoSocketHelper$delegate", "mPhoneProximalProgressHashMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "mPhoneRemoteProgressHashMap", "mRecordId", "mRecordVoiceHandle", "Landroid/os/Handler;", "mRecordVoiceHandleThread", "Landroid/os/HandlerThread;", "mSceneProgressHashMap", "recognizeId", "sendDownFileDataFinish", "sendUpFileDataFinish", "checkAsrForFailResultForScene", "code", "checkAsrResultForScene", "callbackForEmpty", "Lkotlin/Function0;", "checkSendFileState", "checkTwoEndState", "checkTwoTypeAsrForFailResult", "checkTwoTypeAsrResult", "callback", "clearPhoneWordCache", "clearSceneWordCache", "commandPhoneWordAfterSort", "content", "startTime", "endTime", "roles", "commandSceneWordAfterSort", "createNewVoiceWord", "createOrPostHandlerCommand", "endSingleAsrRequest", "endTwoAsrRequest", "getBindDevice", "getMapProgressAverageValue", "progressMap", "partNum", "getMapProgressAverageValueForScene", "getPartProgress", "asrSrc", "Lcom/xjsd/xr/sapp/asr/dao/Src;", "getRecordId", "getWebType", "initSingleAsr", "initTwoSocketAsr", "isAsrFailCode", "msgCode", "releaseSingleAsr", "releaseTwoAsr", "reportAsrTime", "savePhoneProximalProgressData", "savePhoneRemoteProgressData", "savePhoneTypeVoiceWord", "mResultExt", "Lcom/xjsd/xr/sapp/asr/dao/ResultExt;", "saveRecordIngDataShortHandContent", "saveSceneRecordVoiceWord", "sendPhoneProgressData", "sendSceneProgressData", "setEmptyCallBack", "setFailCallBack", "setFinishCallBack", "setProgressCallback", "setRecordInfo", "recordId", "singleSocket", "showComplianceFail", "msgContent", "action", "sortAllPhoneAsrResult", "sortAllSceneAsrResult", "startCheckFinishPrePareJob", "startPhoneDownSocket", "downPcmPath", "startPhoneUpSocket", "upPcmPath", "startSendSceneData", "pcmPath", "startSingleAsr", "startTwoSocketAsr", "pcmTwo", "Companion", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFastRecordHistoryAsrOperator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordHistoryAsrOperator.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/history/FastRecordHistoryAsrOperator\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,1092:1\n1855#2,2:1093\n1855#2,2:1099\n1002#2,2:1101\n1855#2,2:1103\n1002#2,2:1105\n1855#2,2:1107\n215#3,2:1095\n215#3,2:1097\n*S KotlinDebug\n*F\n+ 1 FastRecordHistoryAsrOperator.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/history/FastRecordHistoryAsrOperator\n*L\n341#1:1093,2\n607#1:1099,2\n723#1:1101,2\n724#1:1103,2\n735#1:1105,2\n736#1:1107,2\n583#1:1095,2\n594#1:1097,2\n*E\n"})
public final class FastRecordHistoryAsrOperator {
    private static final int ARI_MIN_VOICE_SINGLE_SIZE = 3200;
    @NotNull
    private static final String COMPLIANCE_FAIL_REQUEST_COED = "2001";
    @NotNull
    private static final String COMPLIANCE_FAIL_RESPONSE_COED = "2002";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int MAX_SPLIT_TIME = 2500;
    @NotNull
    public static final String NETWORK_CHANGE = "10011";
    @NotNull
    private static final String SCENE_CALL_BACK = "HISTORY_SCENE_CALL_BACK";
    @NotNull
    private static final String SINGLE_CALL_BACK = "HISTORY_SINGLE_CALL_BACK";
    private static final long SPLIT_READ_FILE_TIME = 5;
    @NotNull
    public static final String TAG = "FastRecordHistoryAsrOperator";
    /* access modifiers changed from: private */
    @Nullable
    public static StarryNetDevice connectDevice;
    /* access modifiers changed from: private */
    public long arsFileReadFinishTime;
    /* access modifiers changed from: private */
    @Nullable
    public Function1<? super Long, Unit> asrEmptyCallback;
    /* access modifiers changed from: private */
    @Nullable
    public Function2<? super Long, ? super String, Unit> asrFailCallback;
    @Nullable
    private Function1<? super Long, Unit> asrFinishCallback;
    @Nullable
    private Function3<? super Long, ? super Long, ? super Long, Unit> asrProgressCallback;
    @NotNull
    private final ArrayList<RecordVoiceWordEntity> cacheOriginPhoneVoiceWordEntityList = new ArrayList<>();
    @NotNull
    private final ArrayList<RecordVoiceWordEntity> cacheOriginSceneVoiceWordEntityList = new ArrayList<>();
    @NotNull
    private final ArrayList<RecordVoiceWordEntity> cachePhoneVoiceWordEntityList = new ArrayList<>();
    @NotNull
    private final ArrayList<RecordVoiceWordEntity> cacheSceneVoiceWordEntityList = new ArrayList<>();
    /* access modifiers changed from: private */
    @Nullable
    public Job checkFinishPrePareJob;
    private long curCacheProgress;
    /* access modifiers changed from: private */
    public boolean endProximalState;
    /* access modifiers changed from: private */
    public boolean endRemoteState;
    /* access modifiers changed from: private */
    public long fileTotalTime;
    private boolean isFinishComplianceFail;
    /* access modifiers changed from: private */
    public boolean isFinishPrePareAsrSocket;
    private boolean isSaveFirstContent;
    private boolean isSingleSocket;
    @NotNull
    private final Lazy mLongAudioAsrSingleSocketHelper$delegate = LazyKt.lazy(FastRecordHistoryAsrOperator$mLongAudioAsrSingleSocketHelper$2.INSTANCE);
    @NotNull
    private final Lazy mLongAudioAsrTwoSocketHelper$delegate = LazyKt.lazy(FastRecordHistoryAsrOperator$mLongAudioAsrTwoSocketHelper$2.INSTANCE);
    @NotNull
    private final HashMap<Integer, Float> mPhoneProximalProgressHashMap = new HashMap<>();
    @NotNull
    private final HashMap<Integer, Float> mPhoneRemoteProgressHashMap = new HashMap<>();
    /* access modifiers changed from: private */
    public long mRecordId;
    @Nullable
    private Handler mRecordVoiceHandle;
    @Nullable
    private HandlerThread mRecordVoiceHandleThread;
    @NotNull
    private final HashMap<Integer, Float> mSceneProgressHashMap = new HashMap<>();
    /* access modifiers changed from: private */
    @NotNull
    public String recognizeId = "";
    /* access modifiers changed from: private */
    public boolean sendDownFileDataFinish;
    /* access modifiers changed from: private */
    public boolean sendUpFileDataFinish;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/history/FastRecordHistoryAsrOperator$Companion;", "", "()V", "ARI_MIN_VOICE_SINGLE_SIZE", "", "COMPLIANCE_FAIL_REQUEST_COED", "", "COMPLIANCE_FAIL_RESPONSE_COED", "MAX_SPLIT_TIME", "NETWORK_CHANGE", "SCENE_CALL_BACK", "SINGLE_CALL_BACK", "SPLIT_READ_FILE_TIME", "", "TAG", "connectDevice", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "setConnectDevice", "", "device", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void setConnectDevice(@Nullable StarryNetDevice starryNetDevice) {
            FastRecordHistoryAsrOperator.connectDevice = starryNetDevice;
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    public final void checkAsrForFailResultForScene(String str) {
        Function2<? super Long, ? super String, Unit> function2 = this.asrFailCallback;
        if (function2 != null) {
            function2.invoke(Long.valueOf(this.mRecordId), str);
        }
        clearSceneWordCache();
        releaseSingleAsr();
    }

    /* access modifiers changed from: private */
    public final void checkAsrResultForScene(Function0<Unit> function0) {
        StringBuffer stringBuffer = new StringBuffer();
        sortAllSceneAsrResult();
        for (RecordVoiceWordEntity recordVoiceWordEntity : this.cacheSceneVoiceWordEntityList) {
            LogExt.logE("checkAsrResultForScene for each value = " + recordVoiceWordEntity, TAG);
            FastRecordManager.Companion.getInstance().fastRecordVoiceWordDao().insertDbNoSuspend(recordVoiceWordEntity);
            stringBuffer.append(recordVoiceWordEntity.getWordContent());
        }
        long length = (long) stringBuffer.toString().length();
        long j = this.mRecordId;
        LogExt.logE("checkAsrResultForScene mRecordId = " + j + ",value = " + stringBuffer + ",length = " + length, TAG);
        FastRecordManager.Companion companion = FastRecordManager.Companion;
        companion.getInstance().fastRecordDao().updateRecordOriginTextSizeByIdNormal(this.mRecordId, length);
        FastRecordDao fastRecordDao = companion.getInstance().fastRecordDao();
        long j2 = this.mRecordId;
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer2, "toString(...)");
        fastRecordDao.updateRecordOriginTextByIdNormal(j2, stringBuffer2);
        int findFastRecordNumberByIdNoSuspend = companion.getInstance().fastRecordVoiceWordDao().findFastRecordNumberByIdNoSuspend(this.mRecordId);
        LogExt.logE("checkAsrResultForScene count = " + findFastRecordNumberByIdNoSuspend, TAG);
        companion.getInstance().fastRecordDao().updateRecordIsFinishAsrByIdNormal(this.mRecordId, true);
        if (findFastRecordNumberByIdNoSuspend == 0) {
            LogExt.logE("checkAsrResultForScene updateRecordIsEmptyAsrById true", TAG);
            companion.getInstance().fastRecordDao().updateRecordIsEmptyAsrById(this.mRecordId, true);
            function0.invoke();
        } else {
            Function1<? super Long, Unit> function1 = this.asrFinishCallback;
            if (function1 != null) {
                function1.invoke(Long.valueOf(this.mRecordId));
            }
        }
        clearSceneWordCache();
        releaseSingleAsr();
    }

    /* access modifiers changed from: private */
    public final void checkSendFileState() {
        boolean z = this.sendUpFileDataFinish;
        boolean z2 = this.sendDownFileDataFinish;
        LogExt.logE("checkEndState sendUpFileDataFinish = " + z + ",sendDownFileDataFinish = " + z2, TAG);
        if (this.sendDownFileDataFinish && this.sendUpFileDataFinish) {
            LogExt.logE("mLongAudioAsrTwoSocketHelper sendEndMessage", TAG);
            getMLongAudioAsrTwoSocketHelper().sendEndMessage();
        }
    }

    /* access modifiers changed from: private */
    public final void checkTwoEndState() {
        boolean z = this.endRemoteState;
        boolean z2 = this.endProximalState;
        LogExt.logE("checkEndState endRemoteState = " + z + ",endProximalState = " + z2, TAG);
        if (this.endRemoteState && this.endProximalState) {
            createOrPostHandlerCommand(new FastRecordHistoryAsrOperator$checkTwoEndState$1(this));
        }
    }

    /* access modifiers changed from: private */
    public final void checkTwoTypeAsrForFailResult(String str) {
        LogExt.logE("checkTwoTypeAsrForFailResult is fail", TAG);
        Function2<? super Long, ? super String, Unit> function2 = this.asrFailCallback;
        if (function2 != null) {
            function2.invoke(Long.valueOf(this.mRecordId), str);
        }
        clearPhoneWordCache();
        releaseTwoAsr();
    }

    /* access modifiers changed from: private */
    public final void checkTwoTypeAsrResult(Function0<Unit> function0) {
        StringBuffer stringBuffer = new StringBuffer();
        sortAllPhoneAsrResult();
        for (RecordVoiceWordEntity recordVoiceWordEntity : this.cachePhoneVoiceWordEntityList) {
            LogExt.logE("checkTwoTypeAsrResult for each value = " + recordVoiceWordEntity, TAG);
            FastRecordManager.Companion.getInstance().fastRecordVoiceWordDao().insertDbNoSuspend(recordVoiceWordEntity);
            stringBuffer.append(recordVoiceWordEntity.getWordContent());
        }
        long length = (long) stringBuffer.toString().length();
        long j = this.mRecordId;
        LogExt.logE("checkTwoTypeAsrResult mRecordId = " + j + ",value = " + stringBuffer + ",length = " + length, TAG);
        FastRecordManager.Companion companion = FastRecordManager.Companion;
        companion.getInstance().fastRecordDao().updateRecordOriginTextSizeByIdNormal(this.mRecordId, length);
        FastRecordDao fastRecordDao = companion.getInstance().fastRecordDao();
        long j2 = this.mRecordId;
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer2, "toString(...)");
        fastRecordDao.updateRecordOriginTextByIdNormal(j2, stringBuffer2);
        int findFastRecordNumberByIdNoSuspend = companion.getInstance().fastRecordVoiceWordDao().findFastRecordNumberByIdNoSuspend(this.mRecordId);
        LogExt.logE("checkTwoTypeAsrResult count = " + findFastRecordNumberByIdNoSuspend, TAG);
        companion.getInstance().fastRecordDao().updateRecordIsFinishAsrByIdNormal(this.mRecordId, true);
        if (findFastRecordNumberByIdNoSuspend == 0) {
            LogExt.logE("checkTwoTypeAsrResult updateRecordIsEmptyAsrById true", TAG);
            companion.getInstance().fastRecordDao().updateRecordIsEmptyAsrById(this.mRecordId, true);
            function0.invoke();
        } else {
            Function1<? super Long, Unit> function1 = this.asrFinishCallback;
            if (function1 != null) {
                function1.invoke(Long.valueOf(this.mRecordId));
            }
        }
        clearPhoneWordCache();
        releaseTwoAsr();
    }

    private final void clearPhoneWordCache() {
        this.cachePhoneVoiceWordEntityList.clear();
        this.cacheOriginPhoneVoiceWordEntityList.clear();
        this.curCacheProgress = 0;
    }

    private final void clearSceneWordCache() {
        this.cacheSceneVoiceWordEntityList.clear();
        this.cacheOriginSceneVoiceWordEntityList.clear();
        this.curCacheProgress = 0;
    }

    private final void commandPhoneWordAfterSort(String str, long j, long j2, String str2) {
        if (this.cachePhoneVoiceWordEntityList.isEmpty()) {
            LogExt.logE("commandPhoneWordAfterSort cacheRecordVoiceWordEntityList.isEmpty() add first entity", TAG);
            this.cachePhoneVoiceWordEntityList.add(createNewVoiceWord(str, j, j2, str2));
            return;
        }
        RecordVoiceWordEntity recordVoiceWordEntity = (RecordVoiceWordEntity) CollectionsKt.last(this.cachePhoneVoiceWordEntityList);
        long endTime = recordVoiceWordEntity.getEndTime();
        String roles = recordVoiceWordEntity.getRoles();
        LogExt.logE("commandPhoneWordAfterSort last.endTime = " + endTime + ",startTime = " + j + ",last.roles = " + roles + ",roles = " + str2, TAG);
        if (j > recordVoiceWordEntity.getEndTime() + ((long) MAX_SPLIT_TIME) || !Intrinsics.areEqual((Object) recordVoiceWordEntity.getRoles(), (Object) str2)) {
            RecordVoiceWordEntity createNewVoiceWord = createNewVoiceWord(str, j, j2, str2);
            LogExt.logE("commandPhoneWordAfterSort is not null ,or roles change", TAG);
            this.cachePhoneVoiceWordEntityList.add(createNewVoiceWord);
            return;
        }
        recordVoiceWordEntity.setEndTime(j2);
        String wordContent = recordVoiceWordEntity.getWordContent();
        recordVoiceWordEntity.setWordContent(wordContent + str);
        String wordContent2 = recordVoiceWordEntity.getWordContent();
        LogExt.logE("commandPhoneWordAfterSort  add content = " + str + ",last.wordContent = " + wordContent2, TAG);
    }

    private final void commandSceneWordAfterSort(String str, long j, long j2, String str2) {
        if (this.cacheSceneVoiceWordEntityList.isEmpty()) {
            this.cacheSceneVoiceWordEntityList.add(createNewVoiceWord(str, j, j2, str2));
            return;
        }
        RecordVoiceWordEntity recordVoiceWordEntity = (RecordVoiceWordEntity) CollectionsKt.last(this.cacheSceneVoiceWordEntityList);
        long startTime = recordVoiceWordEntity.getStartTime();
        long endTime = recordVoiceWordEntity.getEndTime();
        long j3 = (long) MAX_SPLIT_TIME;
        LogExt.logE("commandSceneWordAfterSort last.endTime = " + startTime + ",startTime = " + j + ",last.endTime + MAX_SPLIT_TIME = " + (endTime + j3), TAG);
        if (j > recordVoiceWordEntity.getEndTime() + j3) {
            RecordVoiceWordEntity createNewVoiceWord = createNewVoiceWord(str, j, j2, str2);
            LogExt.logE("commandSceneWordAfterSort startTime > (last.endTime + MAX_SPLIT_TIME", TAG);
            this.cacheSceneVoiceWordEntityList.add(createNewVoiceWord);
            return;
        }
        recordVoiceWordEntity.setEndTime(j2);
        String wordContent = recordVoiceWordEntity.getWordContent();
        recordVoiceWordEntity.setWordContent(wordContent + str);
        String wordContent2 = recordVoiceWordEntity.getWordContent();
        LogExt.logE("commandSceneWordAfterSort  add content = " + str + ",last.wordContent = " + wordContent2, TAG);
    }

    private final RecordVoiceWordEntity createNewVoiceWord(String str, long j, long j2, String str2) {
        String str3 = str;
        RecordVoiceWordEntity recordVoiceWordEntity = r1;
        RecordVoiceWordEntity recordVoiceWordEntity2 = new RecordVoiceWordEntity(0, (String) null, 0, (String) null, 0, 0, (String) null, (String) null, false, false, false, (String) null, 4095, (DefaultConstructorMarker) null);
        RecordVoiceWordEntity recordVoiceWordEntity3 = recordVoiceWordEntity;
        recordVoiceWordEntity3.setRecordId(this.mRecordId);
        recordVoiceWordEntity3.setWordContent(str3);
        recordVoiceWordEntity3.setWordContentTemp(str3);
        recordVoiceWordEntity3.setStartTime(j);
        recordVoiceWordEntity3.setEndTime(j2);
        recordVoiceWordEntity3.setFinishWord(true);
        recordVoiceWordEntity3.setRoles(str2);
        return recordVoiceWordEntity3;
    }

    /* access modifiers changed from: private */
    public static final void createOrPostHandlerCommand$lambda$1(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$callback");
        function0.invoke();
    }

    private final void endSingleAsrRequest() {
        getMLongAudioAsrSingleSocketHelper().stopRequest();
    }

    private final void endTwoAsrRequest() {
        getMLongAudioAsrTwoSocketHelper().stopRequest();
    }

    private final String getBindDevice() {
        StarryNetDeviceInfoOperator deviceInfoOperator;
        StarryNetDevice bondedDevice;
        StarryNetDevice starryNetDevice = connectDevice;
        String str = null;
        String deviceId = starryNetDevice != null ? starryNetDevice.getDeviceId() : null;
        String str2 = "";
        if (deviceId == null) {
            deviceId = str2;
        }
        LogExt.logE("getBindDevice connectDevice connectDeviceId = " + deviceId, TAG);
        if (!TextUtils.isEmpty(deviceId)) {
            return deviceId;
        }
        OperatorManager operatorManager = RecordConnectManager.Companion.getInstance().getOperatorManager();
        if (!(operatorManager == null || (deviceInfoOperator = operatorManager.getDeviceInfoOperator()) == null || (bondedDevice = deviceInfoOperator.getBondedDevice()) == null)) {
            str = bondedDevice.getDeviceId();
        }
        if (str != null) {
            str2 = str;
        }
        LogExt.logE("getBindDevice bondedDevice connectDeviceId = " + str2, TAG);
        return str2;
    }

    /* access modifiers changed from: private */
    public final UnifiedAsrHelper getMLongAudioAsrSingleSocketHelper() {
        return (UnifiedAsrHelper) this.mLongAudioAsrSingleSocketHelper$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final UnifiedAsrHelper getMLongAudioAsrTwoSocketHelper() {
        return (UnifiedAsrHelper) this.mLongAudioAsrTwoSocketHelper$delegate.getValue();
    }

    private final float getMapProgressAverageValue(HashMap<Integer, Float> hashMap, int i) {
        float f = 0.0f;
        for (Map.Entry next : hashMap.entrySet()) {
            Object key = next.getKey();
            Object value = next.getValue();
            LogExt.logW("getMapProgressAverageValue foreach key = " + key + ",value = " + value + ",partNum = " + i, TAG);
            f += ((Number) next.getValue()).floatValue();
        }
        float f2 = f / ((float) i);
        LogExt.logW("getMapProgressAverageValue progressValue = " + f2 + ",partNum = " + i + ",totalProgressSize = " + f, TAG);
        return f2;
    }

    private final float getMapProgressAverageValueForScene(HashMap<Integer, Long> hashMap, int i) {
        float f = 0.0f;
        for (Map.Entry next : hashMap.entrySet()) {
            Object key = next.getKey();
            Object value = next.getValue();
            LogExt.logW("getMapProgressAverageValueForScene foreach key = " + key + ",value = " + value + ",partNum = " + i, TAG);
            f += ((Number) next.getValue()).floatValue();
        }
        LogExt.logW("getMapProgressAverageValueForScene partNum = " + i + ",totalProgressSize = " + f, TAG);
        return f;
    }

    private final float getPartProgress(long j, Src src) {
        long partNum = this.fileTotalTime / ((long) src.getPartNum());
        long partIndex = j - (((long) (src.getPartIndex() - 1)) * partNum);
        float f = ((float) partIndex) / ((float) partNum);
        LogExt.logW("getPartProgress partDuration = " + partNum + ",realEndTime = " + partIndex + ",endTime =" + j + ",partProgress = " + f, TAG);
        if (f > 1.0f) {
            return 1.0f;
        }
        return f;
    }

    private final String getWebType() {
        return AsrConstants.WEB_DOM_UAT;
    }

    /* access modifiers changed from: private */
    public final boolean isAsrFailCode(String str) {
        LogExt.logE("isAsrFailCode msgCode = " + str, TAG);
        return Intrinsics.areEqual((Object) COMPLIANCE_FAIL_REQUEST_COED, (Object) str) || Intrinsics.areEqual((Object) COMPLIANCE_FAIL_RESPONSE_COED, (Object) str);
    }

    private final void releaseSingleAsr() {
        endSingleAsrRequest();
        getMLongAudioAsrSingleSocketHelper().release();
        reportAsrTime();
    }

    private final void releaseTwoAsr() {
        endTwoAsrRequest();
        getMLongAudioAsrTwoSocketHelper().release();
        reportAsrTime();
    }

    private final void reportAsrTime() {
        long j = this.arsFileReadFinishTime;
        long j2 = this.mRecordId;
        String str = this.recognizeId;
        LogExt.logE("reportAsrTime arsFinishTime = " + j + ",mRecordId = " + j2 + ",recognizeId = " + str, TAG);
        long j3 = this.arsFileReadFinishTime;
        if (j3 > 0) {
            FastRecordDataTrackManager.reportTranscribingDataTrack(this.recognizeId, j3, this.mRecordId);
        }
    }

    /* access modifiers changed from: private */
    public final void savePhoneProximalProgressData(Src src) {
        long j = this.mRecordId;
        long j2 = this.fileTotalTime;
        LogExt.logE("sendPhoneProgressDataWhenDownSrcData asrSrc = " + src + ",mRecordId =" + j + ",fileTotalTime=" + j2, TAG);
        long endTime = src != null ? src.getEndTime() : 0;
        if (endTime == 0) {
            LogExt.logE("sendPhoneProgressDataWhenDownSrcData is 0 return", TAG);
        } else if (src == null) {
        } else {
            if (src.getPartNum() >= 1) {
                this.mPhoneProximalProgressHashMap.put(Integer.valueOf(src.getPartIndex()), Float.valueOf(getPartProgress(endTime, src)));
                sendPhoneProgressData(src.getPartNum());
                return;
            }
            Function3<? super Long, ? super Long, ? super Long, Unit> function3 = this.asrProgressCallback;
            if (function3 != null) {
                function3.invoke(Long.valueOf(this.mRecordId), Long.valueOf(this.fileTotalTime), Long.valueOf(endTime));
            }
        }
    }

    /* access modifiers changed from: private */
    public final void savePhoneRemoteProgressData(Src src) {
        long j = this.mRecordId;
        long j2 = this.fileTotalTime;
        LogExt.logE("sendPhoneProgressDataWhenUpSrcData asrSrc = " + src + ",mRecordId =" + j + ",fileTotalTime=" + j2, TAG);
        long endTime = src != null ? src.getEndTime() : 0;
        if (endTime == 0) {
            LogExt.logE("sendPhoneProgressDataWhenUpSrcData is 0 return", TAG);
        } else if (src == null) {
        } else {
            if (src.getPartNum() >= 1) {
                this.mPhoneRemoteProgressHashMap.put(Integer.valueOf(src.getPartIndex()), Float.valueOf(getPartProgress(endTime, src)));
                sendPhoneProgressData(src.getPartNum());
                return;
            }
            Function3<? super Long, ? super Long, ? super Long, Unit> function3 = this.asrProgressCallback;
            if (function3 != null) {
                function3.invoke(Long.valueOf(this.mRecordId), Long.valueOf(this.fileTotalTime), Long.valueOf(endTime));
            }
        }
    }

    /* access modifiers changed from: private */
    public final void savePhoneTypeVoiceWord(String str, long j, long j2, String str2, ResultExt resultExt) {
        if (str.length() == 0) {
            LogExt.logE("savePhoneTypeVoiceWord content is empty", TAG);
            return;
        }
        long j3 = this.mRecordId;
        long j4 = this.fileTotalTime;
        LogExt.logE("savePhoneTypeVoiceWord mRecordId = " + j3 + ",fileTotalTime = " + j4 + ",endTime = " + j2, TAG);
        this.cacheOriginPhoneVoiceWordEntityList.add(createNewVoiceWord(str, j, j2, str2));
        saveRecordIngDataShortHandContent(resultExt);
    }

    private final void saveRecordIngDataShortHandContent(ResultExt resultExt) {
        if (!this.isSaveFirstContent) {
            this.isSaveFirstContent = true;
            Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new FastRecordHistoryAsrOperator$saveRecordIngDataShortHandContent$1(this, resultExt, (Continuation<? super FastRecordHistoryAsrOperator$saveRecordIngDataShortHandContent$1>) null), 3, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final void saveSceneRecordVoiceWord(String str, long j, long j2, String str2, ResultExt resultExt) {
        if (str.length() == 0) {
            LogExt.logE("saveSceneRecordVoiceWord content is empty", TAG);
            return;
        }
        long j3 = this.mRecordId;
        long j4 = this.fileTotalTime;
        LogExt.logE("saveSceneRecordVoiceWord mRecordId = " + j3 + ",fileTotalTime = " + j4 + ",endTime = " + j2, TAG);
        this.cacheOriginSceneVoiceWordEntityList.add(createNewVoiceWord(str, j, j2, str2));
        saveRecordIngDataShortHandContent(resultExt);
    }

    private final void sendPhoneProgressData(int i) {
        float mapProgressAverageValue = getMapProgressAverageValue(this.mPhoneRemoteProgressHashMap, i);
        float mapProgressAverageValue2 = getMapProgressAverageValue(this.mPhoneProximalProgressHashMap, i);
        float max = Math.max(mapProgressAverageValue, mapProgressAverageValue2);
        float f = ((float) this.fileTotalTime) * max;
        LogExt.logW("sendPhoneProgressData upProgressData= " + mapProgressAverageValue + ",downProgressData = " + mapProgressAverageValue2 + ",lastProgress = " + max + ",totalProgressSize = " + f + ",partNum = " + i, TAG);
        Function3<? super Long, ? super Long, ? super Long, Unit> function3 = this.asrProgressCallback;
        if (function3 != null) {
            function3.invoke(Long.valueOf(this.mRecordId), Long.valueOf(this.fileTotalTime), Long.valueOf((long) f));
        }
    }

    /* access modifiers changed from: private */
    public final void sendSceneProgressData(Src src) {
        long j = this.mRecordId;
        long j2 = this.fileTotalTime;
        LogExt.logE("sendSceneProgressData asrSrc = " + src + ",mRecordId =" + j + ",fileTotalTime=" + j2, TAG);
        long endTime = src != null ? src.getEndTime() : 0;
        if (endTime == 0) {
            LogExt.logE("sendSceneProgressData is 0 return", TAG);
        } else if (src == null) {
        } else {
            if (src.getPartNum() >= 1) {
                this.mSceneProgressHashMap.put(Integer.valueOf(src.getPartIndex()), Float.valueOf(getPartProgress(endTime, src)));
                float mapProgressAverageValue = getMapProgressAverageValue(this.mSceneProgressHashMap, src.getPartNum());
                float f = ((float) this.fileTotalTime) * mapProgressAverageValue;
                int partNum = src.getPartNum();
                LogExt.logW("sendSceneProgressData lastProgress =" + mapProgressAverageValue + ",totalProgressSize =" + f + ",partNum = " + partNum, TAG);
                Function3<? super Long, ? super Long, ? super Long, Unit> function3 = this.asrProgressCallback;
                if (function3 != null) {
                    function3.invoke(Long.valueOf(this.mRecordId), Long.valueOf(this.fileTotalTime), Long.valueOf((long) f));
                    return;
                }
                return;
            }
            Function3<? super Long, ? super Long, ? super Long, Unit> function32 = this.asrProgressCallback;
            if (function32 != null) {
                function32.invoke(Long.valueOf(this.mRecordId), Long.valueOf(this.fileTotalTime), Long.valueOf(endTime));
            }
        }
    }

    /* access modifiers changed from: private */
    public final void showComplianceFail(String str, String str2, String str3, Function0<Unit> function0) {
        boolean z = this.isFinishComplianceFail;
        LogExt.logE("showComplianceFail isFinishComplianceFail = " + z + ",msgCode = " + str + ",msgContent = " + str2 + ",action = " + str3, TAG);
        if (!this.isFinishComplianceFail && isAsrFailCode(str)) {
            Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.c()), (CoroutineContext) null, (CoroutineStart) null, new FastRecordHistoryAsrOperator$showComplianceFail$1(str3, str2, str, (Continuation<? super FastRecordHistoryAsrOperator$showComplianceFail$1>) null), 3, (Object) null);
            this.isFinishComplianceFail = true;
            function0.invoke();
        }
    }

    private final void sortAllPhoneAsrResult() {
        ArrayList<RecordVoiceWordEntity> arrayList = this.cacheOriginPhoneVoiceWordEntityList;
        if (arrayList.size() > 1) {
            CollectionsKt.sortWith(arrayList, new FastRecordHistoryAsrOperator$sortAllPhoneAsrResult$$inlined$sortBy$1());
        }
        for (RecordVoiceWordEntity recordVoiceWordEntity : this.cacheOriginPhoneVoiceWordEntityList) {
            String wordContent = recordVoiceWordEntity.getWordContent();
            String str = wordContent == null ? "" : wordContent;
            long startTime = recordVoiceWordEntity.getStartTime();
            long endTime = recordVoiceWordEntity.getEndTime();
            String roles = recordVoiceWordEntity.getRoles();
            commandPhoneWordAfterSort(str, startTime, endTime, roles == null ? "" : roles);
        }
    }

    private final void sortAllSceneAsrResult() {
        ArrayList<RecordVoiceWordEntity> arrayList = this.cacheOriginSceneVoiceWordEntityList;
        if (arrayList.size() > 1) {
            CollectionsKt.sortWith(arrayList, new FastRecordHistoryAsrOperator$sortAllSceneAsrResult$$inlined$sortBy$1());
        }
        for (RecordVoiceWordEntity recordVoiceWordEntity : this.cacheOriginSceneVoiceWordEntityList) {
            String wordContent = recordVoiceWordEntity.getWordContent();
            String str = wordContent == null ? "" : wordContent;
            long startTime = recordVoiceWordEntity.getStartTime();
            long endTime = recordVoiceWordEntity.getEndTime();
            String roles = recordVoiceWordEntity.getRoles();
            commandSceneWordAfterSort(str, startTime, endTime, roles == null ? "" : roles);
        }
    }

    private final void startCheckFinishPrePareJob(Function0<Unit> function0) {
        Job job = this.checkFinishPrePareJob;
        if (job != null) {
            Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
        }
        this.checkFinishPrePareJob = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new FastRecordHistoryAsrOperator$startCheckFinishPrePareJob$1(this, function0, (Continuation<? super FastRecordHistoryAsrOperator$startCheckFinishPrePareJob$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void startPhoneDownSocket(String str) {
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new FastRecordHistoryAsrOperator$startPhoneDownSocket$1(str, this, (Continuation<? super FastRecordHistoryAsrOperator$startPhoneDownSocket$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void startPhoneUpSocket(String str) {
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new FastRecordHistoryAsrOperator$startPhoneUpSocket$1(str, this, (Continuation<? super FastRecordHistoryAsrOperator$startPhoneUpSocket$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void startSendSceneData(String str) {
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new FastRecordHistoryAsrOperator$startSendSceneData$1(str, this, (Continuation<? super FastRecordHistoryAsrOperator$startSendSceneData$1>) null), 3, (Object) null);
    }

    public final void createOrPostHandlerCommand(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "callback");
        if (this.mRecordVoiceHandleThread == null) {
            HandlerThread handlerThread = new HandlerThread("savePhoneTypeVoiceWord-thread");
            handlerThread.start();
            this.mRecordVoiceHandle = new Handler(handlerThread.getLooper());
            this.mRecordVoiceHandleThread = handlerThread;
        }
        Handler handler = this.mRecordVoiceHandle;
        if (handler != null) {
            handler.post(new a(function0));
        }
    }

    public final long getRecordId() {
        return this.mRecordId;
    }

    public final void initSingleAsr() {
        getMLongAudioAsrSingleSocketHelper().registerAsrResultCallback(SINGLE_CALL_BACK, new FastRecordHistoryAsrOperator$initSingleAsr$1(this));
    }

    public final void initTwoSocketAsr() {
        getMLongAudioAsrTwoSocketHelper().registerAsrResultCallback(SCENE_CALL_BACK, new FastRecordHistoryAsrOperator$initTwoSocketAsr$1(this));
    }

    public final void setEmptyCallBack(@NotNull Function1<? super Long, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        this.asrEmptyCallback = function1;
    }

    public final void setFailCallBack(@NotNull Function2<? super Long, ? super String, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "callback");
        this.asrFailCallback = function2;
    }

    public final void setFinishCallBack(@NotNull Function1<? super Long, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        this.asrFinishCallback = function1;
    }

    public final void setProgressCallback(@NotNull Function3<? super Long, ? super Long, ? super Long, Unit> function3) {
        Intrinsics.checkNotNullParameter(function3, "callback");
        this.asrProgressCallback = function3;
    }

    public final void setRecordInfo(long j, boolean z) {
        this.mRecordId = j;
        this.isSingleSocket = z;
    }

    public final void startSingleAsr(@NotNull String str, long j) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "pcmPath");
        String aiLanguageType = RecordDataSaveUtil.INSTANCE.getAiLanguageType();
        LogExt.logW("startSingleAsr language = " + aiLanguageType, TAG);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "cmn-Hans-CN";
        try {
            Result.Companion companion = Result.Companion;
            if (!TextUtils.isEmpty(aiLanguageType)) {
                objectRef.element = ((FastRecordLanguageBean) new Gson().fromJson(aiLanguageType, FastRecordLanguageBean.class)).getLangType();
            }
            Result.m20constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m20constructorimpl(ResultKt.createFailure(th));
        }
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new FastRecordHistoryAsrOperator$startSingleAsr$2(j, objectRef, (Continuation<? super FastRecordHistoryAsrOperator$startSingleAsr$2>) null), 3, (Object) null);
        long fileSize = RecordFileUtils.INSTANCE.getFileSize(str2);
        long j2 = fileSize / ((long) 32);
        LogExt.logW("startSingleAsr audioSize = " + fileSize + ",audioTotalDuration = " + j2, TAG);
        String webType = getWebType();
        T t = objectRef.element;
        FastRecordManager.Companion companion3 = FastRecordManager.Companion;
        String uuId = companion3.getInstance().getUuId();
        String bindDevice = getBindDevice();
        AsrRequestConfig.RequestData requestData = r22;
        AsrRequestConfig.RequestData requestData2 = new AsrRequestConfig.RequestData("pcm", 16000, 1, 2, (List) null, false, 48, (DefaultConstructorMarker) null);
        RecordDataSaveUtil recordDataSaveUtil = RecordDataSaveUtil.INSTANCE;
        String accountId = recordDataSaveUtil.getAccountId();
        AsrRequestConfig.RecognizeData recognizeData = r24;
        AsrRequestConfig.RecognizeData recognizeData2 = new AsrRequestConfig.RecognizeData(recordDataSaveUtil.getAccountId(), companion3.getInstance().getUuId(), RecordConstants.APP_NAME, String.valueOf(j), System.currentTimeMillis());
        String accountId2 = recordDataSaveUtil.getAccountId();
        LogExt.logE("startSingleAsr recognizeData = " + recognizeData2 + ",accountId = " + accountId2, TAG);
        AsrRequestConfig asrRequestConfig = new AsrRequestConfig(webType, (String) t, (String) t, uuId, bindDevice, AsrConstants.ASR_MICROSOFT, RecordConstants.APP_NAME, requestData, recognizeData, accountId, (TtsConfig) null, (Integer) null, (Integer) null, Long.valueOf(fileSize), Long.valueOf(j2), 7168, (DefaultConstructorMarker) null);
        StringBuilder sb = new StringBuilder();
        sb.append("startSingleAsr config = ");
        sb.append(asrRequestConfig);
        LogExt.logE(sb.toString(), TAG);
        UnifiedAsrHelper.startRequest$default(getMLongAudioAsrSingleSocketHelper(), asrRequestConfig, (AsrRequestConfig) null, 2, (Object) null);
        clearSceneWordCache();
        startCheckFinishPrePareJob(new FastRecordHistoryAsrOperator$startSingleAsr$3(this, str2));
    }

    public final void startTwoSocketAsr(@NotNull String str, @NotNull String str2, long j) {
        String str3 = str;
        String str4 = str2;
        Intrinsics.checkNotNullParameter(str3, "pcmPath");
        Intrinsics.checkNotNullParameter(str4, "pcmTwo");
        String aiLanguageType = RecordDataSaveUtil.INSTANCE.getAiLanguageType();
        LogExt.logW("startTwoSocketAsr language = " + aiLanguageType, TAG);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "cmn-Hans-CN";
        try {
            Result.Companion companion = Result.Companion;
            if (!TextUtils.isEmpty(aiLanguageType)) {
                objectRef.element = ((FastRecordLanguageBean) new Gson().fromJson(aiLanguageType, FastRecordLanguageBean.class)).getLangType();
            }
            Result.m20constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m20constructorimpl(ResultKt.createFailure(th));
        }
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new FastRecordHistoryAsrOperator$startTwoSocketAsr$2(j, objectRef, (Continuation<? super FastRecordHistoryAsrOperator$startTwoSocketAsr$2>) null), 3, (Object) null);
        long fileSize = RecordFileUtils.INSTANCE.getFileSize(str3);
        long j2 = fileSize / ((long) 32);
        LogExt.logW("startTwoSocketAsr audioSize = " + fileSize + ",audioTotalDuration = " + j2, TAG);
        String webType = getWebType();
        T t = objectRef.element;
        FastRecordManager.Companion companion3 = FastRecordManager.Companion;
        String uuId = companion3.getInstance().getUuId();
        String bindDevice = getBindDevice();
        AsrRequestConfig.RequestData requestData = r23;
        AsrRequestConfig.RequestData requestData2 = new AsrRequestConfig.RequestData("pcm", 16000, 1, 2, (List) null, false, 48, (DefaultConstructorMarker) null);
        RecordDataSaveUtil recordDataSaveUtil = RecordDataSaveUtil.INSTANCE;
        String accountId = recordDataSaveUtil.getAccountId();
        AsrRequestConfig.RecognizeData recognizeData = r25;
        AsrRequestConfig.RecognizeData recognizeData2 = new AsrRequestConfig.RecognizeData(recordDataSaveUtil.getAccountId(), companion3.getInstance().getUuId(), RecordConstants.APP_NAME, String.valueOf(j), System.currentTimeMillis());
        LogExt.logE("startTwoSocketAsr recognizeData = " + recognizeData2, TAG);
        AsrRequestConfig asrRequestConfig = new AsrRequestConfig(webType, (String) t, (String) t, uuId, bindDevice, AsrConstants.ASR_MICROSOFT, RecordConstants.APP_NAME, requestData, recognizeData, accountId, (TtsConfig) null, (Integer) null, (Integer) null, Long.valueOf(fileSize), Long.valueOf(j2), 7168, (DefaultConstructorMarker) null);
        LogExt.logW("startTwoSocketAsr config = " + asrRequestConfig, TAG);
        getMLongAudioAsrTwoSocketHelper().startRequest(asrRequestConfig, asrRequestConfig);
        clearPhoneWordCache();
        startCheckFinishPrePareJob(new FastRecordHistoryAsrOperator$startTwoSocketAsr$3(str3, this, str4));
    }
}
