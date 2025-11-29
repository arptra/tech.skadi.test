package com.upuphone.ar.fastrecord.phone.starrynet;

import android.annotation.SuppressLint;
import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.gson.Gson;
import com.here.odnp.config.OdnpConfigStatic;
import com.meizu.common.widget.CircularProgressButton;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.listener.RecordOnInterConnectMsgListener;
import com.upuphone.ar.fastrecord.phone.starrynet.RecordConnectManager;
import com.upuphone.ar.fastrecord.phone.starrynet.bean.RecordInterConnectMessage;
import com.upuphone.ar.fastrecord.phone.starrynet.bean.glass.RecordCacheTag;
import com.upuphone.ar.fastrecord.phone.starrynet.bean.glass.RecordGlassAudioInfo;
import com.upuphone.ar.fastrecord.phone.starrynet.bean.glass.RecordGlassCacheInfo;
import com.upuphone.ar.fastrecord.phone.starrynet.bean.glass.RecordGlassError;
import com.upuphone.ar.fastrecord.phone.starrynet.bean.glass.RecordGlassStatus;
import com.upuphone.ar.fastrecord.phone.starrynet.bean.phone.RecordPhoneAckGetCache;
import com.upuphone.ar.fastrecord.phone.starrynet.bean.phone.RecordPhoneRecId;
import com.upuphone.ar.fastrecord.phone.starrynet.bean.phone.RecordPhoneRequestPreStart;
import com.upuphone.ar.fastrecord.phone.starrynet.bean.phone.RecordPhoneRequestRetryDownload;
import com.upuphone.ar.fastrecord.phone.utils.MemoryUtils;
import com.upuphone.ar.fastrecord.phone.utils.RecordDataSaveUtil;
import com.upuphone.ar.fastrecord.phone.utils.RecordOpusCodecUtils;
import com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils;
import com.upuphone.ar.fastrecord.phone.utils.ViewUtil;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 42\u00020\u0001:\u000245B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J(\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u000e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0004J\b\u0010\u0017\u001a\u00020\u0006H\u0002J$\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0017J\b\u0010\u001c\u001a\u00020\u0006H\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0002J\u0006\u0010\u001e\u001a\u00020\u0006J \u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000b2\b\b\u0002\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020\u0006J\u0006\u0010%\u001a\u00020\u0006J\u000e\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020#J\u0016\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020+J\u0006\u0010,\u001a\u00020\u0006J\u0006\u0010-\u001a\u00020\u0006J\u0016\u0010.\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\u000bJ\u0016\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u000bH@¢\u0006\u0002\u00102J\u0010\u00103\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/starrynet/RecordInterConnectHelper;", "Lcom/upuphone/ar/fastrecord/phone/listener/RecordOnInterConnectMsgListener;", "()V", "mContext", "Landroid/content/Context;", "checkCacheAmpData", "", "mRecordGlassStatus", "Lcom/upuphone/ar/fastrecord/phone/starrynet/bean/glass/RecordGlassStatus;", "commandPhoneVoiceData", "tag", "", "id", "type", "", "bytes", "", "commandRecordMuteData", "byteData", "audioInfo", "Lcom/upuphone/ar/fastrecord/phone/starrynet/bean/glass/RecordGlassCacheInfo;", "init", "context", "initInterConnect", "onInterConnectMessage", "msgCmd", "data", "", "onRemoteDie", "resetRecordIngData", "sendMsgEndRec", "sendMsgFinishCacheAck", "msgId", "sendSize", "needRetry", "", "sendMsgLowMemory", "sendMsgPause", "sendMsgPreStartRec", "isOpen", "sendMsgRecordId", "maxId", "listener", "Lcom/upuphone/xr/interconnect/listener/SendMessageListener;", "sendMsgResume", "sendMsgStartRec", "sendMsgStartRetryDownload", "hasGetDataSize", "setRecordIngTime", "recordId", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateState", "Companion", "SingleHolder", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRecordInterConnectHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecordInterConnectHelper.kt\ncom/upuphone/ar/fastrecord/phone/starrynet/RecordInterConnectHelper\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,452:1\n1864#2,3:453\n*S KotlinDebug\n*F\n+ 1 RecordInterConnectHelper.kt\ncom/upuphone/ar/fastrecord/phone/starrynet/RecordInterConnectHelper\n*L\n428#1:453,3\n*E\n"})
public final class RecordInterConnectHelper implements RecordOnInterConnectMsgListener {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long DELAY_SEND_CACHE_ACK = 2000;
    public static final int MAX_CANCEL_RECORD_ID = 100000000;
    @NotNull
    private static final String TAG = "FastRecordInterConnectHelper";
    @Nullable
    private Context mContext;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/starrynet/RecordInterConnectHelper$Companion;", "", "()V", "DELAY_SEND_CACHE_ACK", "", "MAX_CANCEL_RECORD_ID", "", "TAG", "", "getInstance", "Lcom/upuphone/ar/fastrecord/phone/starrynet/RecordInterConnectHelper;", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final RecordInterConnectHelper getInstance() {
            return SingleHolder.INSTANCE.getInstance();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/starrynet/RecordInterConnectHelper$SingleHolder;", "", "()V", "instance", "Lcom/upuphone/ar/fastrecord/phone/starrynet/RecordInterConnectHelper;", "getInstance", "()Lcom/upuphone/ar/fastrecord/phone/starrynet/RecordInterConnectHelper;", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class SingleHolder {
        @NotNull
        public static final SingleHolder INSTANCE = new SingleHolder();
        @NotNull
        @SuppressLint({"StaticFieldLeak"})
        private static final RecordInterConnectHelper instance = new RecordInterConnectHelper((DefaultConstructorMarker) null);

        private SingleHolder() {
        }

        @NotNull
        public final RecordInterConnectHelper getInstance() {
            return instance;
        }
    }

    public /* synthetic */ RecordInterConnectHelper(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final void checkCacheAmpData(RecordGlassStatus recordGlassStatus) {
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new RecordInterConnectHelper$checkCacheAmpData$1(this, recordGlassStatus, (Continuation<? super RecordInterConnectHelper$checkCacheAmpData$1>) null), 3, (Object) null);
    }

    private final void commandRecordMuteData(byte[] bArr, RecordGlassCacheInfo recordGlassCacheInfo) {
        ArrayList<RecordCacheTag> list = recordGlassCacheInfo.getList();
        if (list != null) {
            int i = 0;
            int i2 = 0;
            for (T next : list) {
                int i3 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                RecordCacheTag recordCacheTag = (RecordCacheTag) next;
                if (recordCacheTag.getType() == 0) {
                    byte[] sliceArray = ArraysKt.sliceArray(bArr, RangesKt.until(i2, i2 + OdnpConfigStatic.UPLOAD_LOW_PRIORITY_DURATION_MINUTES));
                    recordCacheTag.setByteArray(sliceArray);
                    i2 += sliceArray.length;
                    LogExt.logE("index = " + i + " ,recordCacheTag = " + recordCacheTag + ",bytesPhone size = " + sliceArray.length + ",start size = " + i2, TAG);
                } else {
                    byte[] sliceArray2 = ArraysKt.sliceArray(bArr, RangesKt.until(i2, i2 + CircularProgressButton.MorphingAnimation.DURATION_NORMAL));
                    recordCacheTag.setByteArray(sliceArray2);
                    i2 += sliceArray2.length;
                    LogExt.logE("index = " + i + " ,recordCacheTag = " + recordCacheTag + ",byteScene size = " + sliceArray2.length + ",start size = " + i2, TAG);
                }
                i = i3;
            }
        }
        RecordVoiceUtils.INSTANCE.savePhoneOrSceneCacheMuteData(recordGlassCacheInfo.getMsgId(), recordGlassCacheInfo.getSendSize(), recordGlassCacheInfo, bArr.length);
    }

    @JvmStatic
    @NotNull
    public static final RecordInterConnectHelper getInstance() {
        return Companion.getInstance();
    }

    private final void initInterConnect() {
        RecordConnectManager.Companion companion = RecordConnectManager.Companion;
        if (companion.getInstance().isInit()) {
            LogExt.logI("速记: 互联注册消息回调 等逻辑已经注册了", TAG);
            return;
        }
        LogExt.logI("速记: 互联注册消息回调,注册相关监听", TAG);
        companion.getInstance().initForCallback("recPhone", "recGlass");
        companion.getInstance().registerInterConnectMsgListener(this);
        companion.getInstance().registerRemoteAppDieListener(this);
    }

    private final void resetRecordIngData() {
        RecordOpusCodecUtils.Companion.getInstance().unInit();
        RecordVoiceUtils.INSTANCE.initAllRecordingTagData();
        FastRecordManager.Companion.getInstance().appViewModel().clearAmplitudeBeans();
    }

    public static /* synthetic */ void sendMsgFinishCacheAck$default(RecordInterConnectHelper recordInterConnectHelper, long j, long j2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        recordInterConnectHelper.sendMsgFinishCacheAck(j, j2, z);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setRecordIngTime(long r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r9 = this;
            boolean r0 = r12 instanceof com.upuphone.ar.fastrecord.phone.starrynet.RecordInterConnectHelper$setRecordIngTime$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            com.upuphone.ar.fastrecord.phone.starrynet.RecordInterConnectHelper$setRecordIngTime$1 r0 = (com.upuphone.ar.fastrecord.phone.starrynet.RecordInterConnectHelper$setRecordIngTime$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0014
            int r1 = r1 - r2
            r0.label = r1
        L_0x0012:
            r5 = r0
            goto L_0x001a
        L_0x0014:
            com.upuphone.ar.fastrecord.phone.starrynet.RecordInterConnectHelper$setRecordIngTime$1 r0 = new com.upuphone.ar.fastrecord.phone.starrynet.RecordInterConnectHelper$setRecordIngTime$1
            r0.<init>(r9, r12)
            goto L_0x0012
        L_0x001a:
            java.lang.Object r9 = r5.result
            java.lang.Object r12 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r5.label
            java.lang.String r8 = "FastRecordInterConnectHelper"
            r1 = 1
            if (r0 == 0) goto L_0x0035
            if (r0 != r1) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0063
        L_0x002d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r9)
            com.upuphone.ar.fastrecord.phone.FastRecordManager$Companion r9 = com.upuphone.ar.fastrecord.phone.FastRecordManager.Companion
            com.upuphone.ar.fastrecord.phone.FastRecordManager r0 = r9.getInstance()
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordAppViewModel r0 = r0.appViewModel()
            com.upuphone.ar.fastrecord.phone.db.RecordEntity r0 = r0.getRecordIngTimeData()
            if (r0 != 0) goto L_0x0098
            java.lang.String r0 = "checkCacheAmpData cur RecordIngData is null"
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r0, r8)
            com.upuphone.ar.fastrecord.phone.FastRecordManager r9 = r9.getInstance()
            com.upuphone.ar.fastrecord.phone.db.FastRecordDao r9 = r9.fastRecordDao()
            r5.label = r1
            r4 = 0
            r6 = 2
            r7 = 0
            r1 = r9
            r2 = r10
            java.lang.Object r9 = com.upuphone.ar.fastrecord.phone.db.FastRecordDao.DefaultImpls.findRecordEntityById$default(r1, r2, r4, r5, r6, r7)
            if (r9 != r12) goto L_0x0063
            return r12
        L_0x0063:
            com.upuphone.ar.fastrecord.phone.db.RecordEntity r9 = (com.upuphone.ar.fastrecord.phone.db.RecordEntity) r9
            if (r9 == 0) goto L_0x0098
            java.lang.String r10 = r9.getShortHandTitle()
            long r11 = r9.getTotalTime()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "checkCacheAmpData title = "
            r0.append(r1)
            r0.append(r10)
            java.lang.String r10 = ",totalTime = "
            r0.append(r10)
            r0.append(r11)
            java.lang.String r10 = r0.toString()
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r10, r8)
            com.upuphone.ar.fastrecord.phone.FastRecordManager$Companion r10 = com.upuphone.ar.fastrecord.phone.FastRecordManager.Companion
            com.upuphone.ar.fastrecord.phone.FastRecordManager r10 = r10.getInstance()
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordAppViewModel r10 = r10.appViewModel()
            r10.setRecordIngTimeEntity(r9)
        L_0x0098:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.starrynet.RecordInterConnectHelper.setRecordIngTime(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void updateState(RecordGlassStatus recordGlassStatus) {
        FastRecordManager.Companion.getInstance().appViewModel().updateStartRecordDetailIng(recordGlassStatus);
        RecordDataSaveUtil.INSTANCE.updateRecordEntityStatus(recordGlassStatus.getId(), recordGlassStatus.getState());
    }

    public final void commandPhoneVoiceData(long j, long j2, int i, @Nullable byte[] bArr) {
        byte[] bArr2;
        LogExt.logW("commandPhoneVoiceData tag = " + j + ",id = " + j2 + ",type = " + i, TAG);
        int recordIngState = FastRecordManager.Companion.getInstance().appViewModel().getRecordIngState();
        StringBuilder sb = new StringBuilder();
        sb.append("commandPhoneVoiceData RECORD_REMOTE_AUDIO_DATA state = ");
        sb.append(recordIngState);
        LogExt.logW(sb.toString(), TAG);
        if ((recordIngState == 1 || recordIngState == 4) && i == 0) {
            RecordGlassAudioInfo recordGlassAudioInfo = new RecordGlassAudioInfo(j, j2, i);
            RecordVoiceUtils recordVoiceUtils = RecordVoiceUtils.INSTANCE;
            if (bArr != null) {
                bArr2 = Arrays.copyOf(bArr, bArr.length);
                Intrinsics.checkNotNullExpressionValue(bArr2, "copyOf(...)");
            } else {
                bArr2 = null;
            }
            recordVoiceUtils.feedPhoneMuteData(bArr2, recordGlassAudioInfo);
        }
    }

    public final void init(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        LogExt.logI("速记启动: 互联消息 初始化", TAG);
        this.mContext = context;
        initInterConnect();
    }

    @SuppressLint({"SwitchIntDef"})
    public void onInterConnectMessage(int i, @Nullable String str, @Nullable byte[] bArr) {
        ArrayList<RecordCacheTag> list;
        LogExt.logI("onInterConnectMessage: msgCmd[" + i + ", data: " + str + "]", TAG);
        if (i == 1) {
            RecordGlassStatus recordGlassStatus = (RecordGlassStatus) new Gson().fromJson(str, RecordGlassStatus.class);
            int state = recordGlassStatus.getState();
            if (state != 1) {
                if (state != 2) {
                    if (state == 3) {
                        Intrinsics.checkNotNull(recordGlassStatus);
                        checkCacheAmpData(recordGlassStatus);
                        return;
                    } else if (state == 4) {
                        Intrinsics.checkNotNull(recordGlassStatus);
                        checkCacheAmpData(recordGlassStatus);
                        return;
                    } else if (state != 5) {
                        return;
                    }
                }
                ViewUtil.INSTANCE.cancelCheckMemoryJob();
                RecordDataSaveUtil.INSTANCE.checkRecordTimeAndSetFinishState(recordGlassStatus.getId(), recordGlassStatus.getState(), new RecordInterConnectHelper$onInterConnectMessage$2(recordGlassStatus, this));
            } else if (MemoryUtils.checkFreeDiskIsLack()) {
                LogExt.logE("START_REC checkFreeDiskIsLack sendMsgLowMemory", TAG);
                sendMsgLowMemory();
            } else {
                ViewUtil.INSTANCE.startCheckLowMemoryJob();
                resetRecordIngData();
                int type = recordGlassStatus.getType();
                LogExt.logW("start rec mRecordGlassStatus.type = " + type, TAG);
                RecordDataSaveUtil recordDataSaveUtil = RecordDataSaveUtil.INSTANCE;
                Intrinsics.checkNotNull(recordGlassStatus);
                recordDataSaveUtil.saveOrCreateRecordItem(recordGlassStatus, new RecordInterConnectHelper$onInterConnectMessage$1(recordGlassStatus, this));
                recordDataSaveUtil.clearCacheAmpData();
                recordDataSaveUtil.setNeedToDetailAfterConnect(-1);
            }
        } else if (i == 2) {
            FastRecordManager.Companion companion = FastRecordManager.Companion;
            int recordIngState = companion.getInstance().appViewModel().getRecordIngState();
            if (recordIngState == 1 || recordIngState == 4) {
                RecordGlassAudioInfo recordGlassAudioInfo = (RecordGlassAudioInfo) new Gson().fromJson(str, RecordGlassAudioInfo.class);
                byte[] bArr2 = null;
                if (companion.getInstance().appViewModel().getRecordIngType() == 0) {
                    RecordVoiceUtils recordVoiceUtils = RecordVoiceUtils.INSTANCE;
                    if (bArr != null) {
                        bArr2 = Arrays.copyOf(bArr, bArr.length);
                        Intrinsics.checkNotNullExpressionValue(bArr2, "copyOf(...)");
                    }
                    Intrinsics.checkNotNull(recordGlassAudioInfo);
                    recordVoiceUtils.feedPhoneMuteData(bArr2, recordGlassAudioInfo);
                    return;
                }
                RecordVoiceUtils recordVoiceUtils2 = RecordVoiceUtils.INSTANCE;
                if (bArr != null) {
                    bArr2 = Arrays.copyOf(bArr, bArr.length);
                    Intrinsics.checkNotNullExpressionValue(bArr2, "copyOf(...)");
                }
                Intrinsics.checkNotNull(recordGlassAudioInfo);
                recordVoiceUtils2.feedSceneData(bArr2, recordGlassAudioInfo);
                return;
            }
            LogExt.logW("record is finish", TAG);
        } else if (i == 3) {
            LogExt.logW("get cache data = " + str, TAG);
            RecordGlassCacheInfo recordGlassCacheInfo = (RecordGlassCacheInfo) new Gson().fromJson(str, RecordGlassCacheInfo.class);
            if (bArr == null || bArr.length == 0 || (list = recordGlassCacheInfo.getList()) == null || list.isEmpty()) {
                LogExt.logE("bytes == null || bytes.isEmpty() || audioInfo.list.isNullOrEmpty()", TAG);
                return;
            }
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            Intrinsics.checkNotNull(recordGlassCacheInfo);
            commandRecordMuteData(copyOf, recordGlassCacheInfo);
        } else if (i == 4 && ((RecordGlassError) new Gson().fromJson(str, RecordGlassError.class)).getErrorCode() == 1) {
            UToast.Companion companion2 = UToast.f6444a;
            FastRecordManager.Companion companion3 = FastRecordManager.Companion;
            Context appContext = companion3.getInstance().appContext();
            String string = companion3.getInstance().appContext().getString(R.string.fast_record_pause_by_ai_assist);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            companion2.d(appContext, string);
        }
    }

    public void onRemoteDie() {
        LogExt.logI("对端速记已经退出(非正常退出)", TAG);
    }

    public final void sendMsgEndRec() {
        RecordConnectManager.Companion.getInstance().sendMessage(new RecordInterConnectMessage(1002, (String) null));
    }

    public final void sendMsgFinishCacheAck(long j, long j2, boolean z) {
        RecordPhoneAckGetCache recordPhoneAckGetCache = new RecordPhoneAckGetCache(1, j, j2);
        LogExt.logE("sendMsgFinishCacheAck finishTag = " + recordPhoneAckGetCache, TAG);
        RecordConnectManager.Companion.getInstance().sendMessage(new RecordInterConnectMessage(1009, new Gson().toJson((Object) recordPhoneAckGetCache)), new RecordInterConnectHelper$sendMsgFinishCacheAck$1(z, this, j, j2));
    }

    public final void sendMsgLowMemory() {
        RecordConnectManager.Companion.getInstance().sendMessage(new RecordInterConnectMessage(1007, (String) null));
    }

    public final void sendMsgPause() {
        RecordConnectManager.Companion.getInstance().sendMessage(new RecordInterConnectMessage(1005, (String) null));
    }

    public final void sendMsgPreStartRec(boolean z) {
        RecordConnectManager.Companion.getInstance().sendMessage(new RecordInterConnectMessage(1003, new Gson().toJson((Object) new RecordPhoneRequestPreStart(z))));
    }

    public final void sendMsgRecordId(long j, @NotNull SendMessageListener sendMessageListener) {
        Intrinsics.checkNotNullParameter(sendMessageListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        RecordConnectManager.Companion.getInstance().sendMessage(new RecordInterConnectMessage(1008, new Gson().toJson((Object) new RecordPhoneRecId(j))), sendMessageListener);
    }

    public final void sendMsgResume() {
        RecordConnectManager.Companion.getInstance().sendMessage(new RecordInterConnectMessage(1006, (String) null));
    }

    public final void sendMsgStartRec() {
        RecordConnectManager.Companion.getInstance().sendMessage(new RecordInterConnectMessage(1001, new Gson().toJson((Object) new RecordPhoneRecId(RecordDataSaveUtil.INSTANCE.getMaxRecordIdAndSave()))));
    }

    public final void sendMsgStartRetryDownload(int i, long j) {
        RecordConnectManager.Companion.getInstance().sendMessage(new RecordInterConnectMessage(1004, new Gson().toJson((Object) new RecordPhoneRequestRetryDownload(i, j))));
    }

    private RecordInterConnectHelper() {
    }
}
