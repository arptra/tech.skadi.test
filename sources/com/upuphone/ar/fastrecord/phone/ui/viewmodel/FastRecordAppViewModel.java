package com.upuphone.ar.fastrecord.phone.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.upuphone.ar.fastrecord.phone.bean.AmplitudeBean;
import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.starrynet.bean.glass.RecordGlassCacheInfo;
import com.upuphone.ar.fastrecord.phone.starrynet.bean.glass.RecordGlassStatus;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean.AsrDuringProgress;
import com.upuphone.ar.fastrecord.phone.ui.widget.RecordIngDetailSoundVisualizerView;
import com.upuphone.ar.fastrecord.phone.ui.widget.RecordItemSoundVisualizerView;
import com.upuphone.ar.fastrecord.phone.utils.RecordDataSaveUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 N2\u00020\u0001:\u0001NB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%J\u000e\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020\u0006J\u0010\u0010(\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010)\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J\u001e\u0010*\u001a\u00020#2\u0006\u0010+\u001a\u00020,2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020%0.H\u0002J\u0006\u0010/\u001a\u00020#J\u001a\u00100\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007J\u0016\u00101\u001a\u00020,2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020%0.H\u0002J\u0006\u0010\u0015\u001a\u00020\tJ\b\u00102\u001a\u0004\u0018\u00010\rJ\u0006\u00103\u001a\u00020 J\u001c\u00104\u001a\u00020#2\u0014\u00105\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020#06J\u0006\u00107\u001a\u00020,J\b\u00108\u001a\u0004\u0018\u00010\u000fJ\u0006\u00109\u001a\u00020,J\u0006\u0010:\u001a\u00020 J\u0016\u0010;\u001a\u00020\t2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020%0.H\u0002J\u0006\u0010<\u001a\u00020\tJ\u0010\u0010=\u001a\u00020#2\u0006\u0010>\u001a\u00020 H\u0002J&\u0010?\u001a\u00020#2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020,2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020%0CH\u0002J\u000e\u0010D\u001a\u00020#2\u0006\u0010E\u001a\u00020\tJ\u000e\u0010F\u001a\u00020#2\u0006\u0010G\u001a\u00020\u000fJ\u0016\u0010H\u001a\u00020#2\u0006\u0010I\u001a\u00020 2\u0006\u0010>\u001a\u00020 J\u000e\u0010J\u001a\u00020#2\u0006\u0010K\u001a\u00020\rJ\u0016\u0010L\u001a\u00020#2\u0006\u0010K\u001a\u00020\u000b2\u0006\u0010M\u001a\u00020,R(\u0010\u0003\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00070\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0004X\u0004¢\u0006\u0002\n\u0000R+\u0010\u0010\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00070\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0019\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0019\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0019\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R*\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 0\u001fj\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 `!X\u0004¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordAppViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_recordAsrDuringProgress", "Landroidx/lifecycle/MutableLiveData;", "Ljava/util/ArrayList;", "Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/bean/AsrDuringProgress;", "Lkotlin/collections/ArrayList;", "_recordConnectState", "", "_recordGlassCacheInfo", "Lcom/upuphone/ar/fastrecord/phone/starrynet/bean/glass/RecordGlassCacheInfo;", "_recordIngDetailInfo", "Lcom/upuphone/ar/fastrecord/phone/starrynet/bean/glass/RecordGlassStatus;", "_recordIngTimeEntity", "Lcom/upuphone/ar/fastrecord/phone/db/RecordEntity;", "recordAsrDuringProgress", "Landroidx/lifecycle/LiveData;", "getRecordAsrDuringProgress", "()Landroidx/lifecycle/LiveData;", "recordConnectState", "getRecordConnectState", "recordGlassCacheInfo", "getRecordGlassCacheInfo", "recordIngTime", "getRecordIngTime", "recordStartRecordDetailIng", "getRecordStartRecordDetailIng", "scope", "Lkotlinx/coroutines/CoroutineScope;", "timeMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "addAmplitudeBean", "", "data", "Lcom/upuphone/ar/fastrecord/phone/bean/AmplitudeBean;", "addAsrProgress", "asrResult", "addDetailAmplitudeBeanToList", "addItemAmplitudeBeanToList", "averageTime", "countData", "", "dataList", "Ljava/util/LinkedList;", "clearAmplitudeBeans", "getAsrProgressData", "getAverageTimeCount", "getRecordIngData", "getRecordIngId", "getRecordIngItem", "callBack", "Lkotlin/Function1;", "getRecordIngState", "getRecordIngTimeData", "getRecordIngType", "getRecordingEntityTime", "isAverageTime", "isRecordingDuring", "saveAndUpdateTime", "recordId", "setAmplitude", "amplitude", "", "time", "Ljava/util/concurrent/CopyOnWriteArrayList;", "setConnectState", "state", "setRecordIngTimeEntity", "entity", "updateRecordingTime", "addTime", "updateStartRecordDetailIng", "mRecordGlassStatus", "updateStartRecordGlassCacheInfo", "curDataSize", "Companion", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FastRecordAppViewModel extends ViewModel {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int MAX_AMP_INFO = 2000;
    @NotNull
    private static final String TAG = "FastRecordAppViewModel";
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<ArrayList<AsrDuringProgress>> _recordAsrDuringProgress;
    @NotNull
    private final MutableLiveData<Boolean> _recordConnectState;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<RecordGlassCacheInfo> _recordGlassCacheInfo;
    @NotNull
    private final MutableLiveData<RecordGlassStatus> _recordIngDetailInfo;
    @NotNull
    private final MutableLiveData<RecordEntity> _recordIngTimeEntity;
    @NotNull
    private final LiveData<ArrayList<AsrDuringProgress>> recordAsrDuringProgress;
    @NotNull
    private final LiveData<Boolean> recordConnectState;
    @NotNull
    private final LiveData<RecordGlassCacheInfo> recordGlassCacheInfo;
    @NotNull
    private final LiveData<RecordEntity> recordIngTime;
    @NotNull
    private final LiveData<RecordGlassStatus> recordStartRecordDetailIng;
    @NotNull
    private final CoroutineScope scope = CoroutineScopeKt.a(Dispatchers.b());
    @NotNull
    private final HashMap<Long, Long> timeMap = new HashMap<>();

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordAppViewModel$Companion;", "", "()V", "MAX_AMP_INFO", "", "TAG", "", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public FastRecordAppViewModel() {
        MutableLiveData<ArrayList<AsrDuringProgress>> mutableLiveData = new MutableLiveData<>();
        this._recordAsrDuringProgress = mutableLiveData;
        Intrinsics.checkNotNull(mutableLiveData, "null cannot be cast to non-null type androidx.lifecycle.LiveData<java.util.ArrayList<com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean.AsrDuringProgress>?{ kotlin.collections.TypeAliasesKt.ArrayList<com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean.AsrDuringProgress>? }>");
        this.recordAsrDuringProgress = mutableLiveData;
        MutableLiveData<RecordEntity> mutableLiveData2 = new MutableLiveData<>();
        this._recordIngTimeEntity = mutableLiveData2;
        Intrinsics.checkNotNull(mutableLiveData2, "null cannot be cast to non-null type androidx.lifecycle.LiveData<com.upuphone.ar.fastrecord.phone.db.RecordEntity?>");
        this.recordIngTime = mutableLiveData2;
        MutableLiveData<RecordGlassStatus> mutableLiveData3 = new MutableLiveData<>();
        this._recordIngDetailInfo = mutableLiveData3;
        Intrinsics.checkNotNull(mutableLiveData3, "null cannot be cast to non-null type androidx.lifecycle.LiveData<com.upuphone.ar.fastrecord.phone.starrynet.bean.glass.RecordGlassStatus?>");
        this.recordStartRecordDetailIng = mutableLiveData3;
        MutableLiveData<RecordGlassCacheInfo> mutableLiveData4 = new MutableLiveData<>();
        this._recordGlassCacheInfo = mutableLiveData4;
        Intrinsics.checkNotNull(mutableLiveData4, "null cannot be cast to non-null type androidx.lifecycle.LiveData<com.upuphone.ar.fastrecord.phone.starrynet.bean.glass.RecordGlassCacheInfo?>");
        this.recordGlassCacheInfo = mutableLiveData4;
        MutableLiveData<Boolean> mutableLiveData5 = new MutableLiveData<>();
        this._recordConnectState = mutableLiveData5;
        Intrinsics.checkNotNull(mutableLiveData5, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Boolean?>");
        this.recordConnectState = mutableLiveData5;
    }

    private final void addDetailAmplitudeBeanToList(AmplitudeBean amplitudeBean) {
        int amplitude = (int) amplitudeBean.getAmplitude();
        float amplitude2db = amplitude != 0 ? AmplitudeBean.Companion.amplitude2db(amplitude) : 1.0f;
        int size = RecordIngDetailSoundVisualizerView.Companion.getDetailAmplitudeBeanToList().size() - 2000;
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                RecordIngDetailSoundVisualizerView.Companion.getDetailAmplitudeBeanToList().remove(0);
            }
        }
        setAmplitude(amplitude2db, amplitudeBean.getTime(), RecordIngDetailSoundVisualizerView.Companion.getDetailAmplitudeBeanToList());
    }

    private final void addItemAmplitudeBeanToList(AmplitudeBean amplitudeBean) {
        int amplitude = (int) amplitudeBean.getAmplitude();
        float amplitude2db = amplitude != 0 ? AmplitudeBean.Companion.amplitude2db(amplitude) : 1.0f;
        int size = RecordItemSoundVisualizerView.Companion.getItemAmplitudeBeanToList().size() - 2000;
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                RecordItemSoundVisualizerView.Companion.getItemAmplitudeBeanToList().remove(0);
            }
        }
        setAmplitude(amplitude2db, amplitudeBean.getTime(), RecordItemSoundVisualizerView.Companion.getItemAmplitudeBeanToList());
    }

    private final void averageTime(int i, LinkedList<AmplitudeBean> linkedList) {
        int time = linkedList.get(linkedList.size() - 2).getTime();
        int time2 = (linkedList.get(linkedList.size() - 1).getTime() - time) / i;
        int size = linkedList.size() - 1;
        if (size >= 0) {
            while (true) {
                int i2 = size - 1;
                if (linkedList.get(size).getTime() == time) {
                    i--;
                    linkedList.get(size).setTime((time2 * i) + time);
                }
                if (linkedList.get(size).getTime() >= time && i2 >= 0) {
                    size = i2;
                } else {
                    return;
                }
            }
        }
    }

    private final int getAverageTimeCount(LinkedList<AmplitudeBean> linkedList) {
        int time = linkedList.get(linkedList.size() - 2).getTime();
        int size = linkedList.size() - 1;
        int i = 0;
        if (size >= 0) {
            while (true) {
                int i2 = size - 1;
                if (linkedList.get(size).getTime() == time) {
                    i++;
                }
                if (linkedList.get(size).getTime() < time || i2 < 0) {
                    break;
                }
                size = i2;
            }
        }
        return i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0009, code lost:
        r3 = r4.get(r4.size() - 2).getTime();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean isAverageTime(java.util.LinkedList<com.upuphone.ar.fastrecord.phone.bean.AmplitudeBean> r4) {
        /*
            r3 = this;
            int r3 = r4.size()
            r0 = 3
            r1 = 0
            if (r3 >= r0) goto L_0x0009
            return r1
        L_0x0009:
            int r3 = r4.size()
            int r3 = r3 + -2
            java.lang.Object r3 = r4.get(r3)
            com.upuphone.ar.fastrecord.phone.bean.AmplitudeBean r3 = (com.upuphone.ar.fastrecord.phone.bean.AmplitudeBean) r3
            int r3 = r3.getTime()
            int r0 = r4.size()
            r2 = 1
            int r0 = r0 - r2
            java.lang.Object r4 = r4.get(r0)
            com.upuphone.ar.fastrecord.phone.bean.AmplitudeBean r4 = (com.upuphone.ar.fastrecord.phone.bean.AmplitudeBean) r4
            int r4 = r4.getTime()
            if (r4 <= r3) goto L_0x002c
            r1 = r2
        L_0x002c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordAppViewModel.isAverageTime(java.util.LinkedList):boolean");
    }

    private final void saveAndUpdateTime(long j) {
        long j2;
        RecordEntity value = this._recordIngTimeEntity.getValue();
        if (value != null) {
            Long l = this.timeMap.get(Long.valueOf(j));
            if (l == null) {
                j2 = 0;
            } else {
                Intrinsics.checkNotNull(l);
                j2 = l.longValue();
            }
            value.setTotalTime(j2);
            long totalTime = value.getTotalTime();
            LogExt.logE("updateRecordingTime first time = " + totalTime, TAG);
            this._recordIngTimeEntity.postValue(value);
            Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordAppViewModel$saveAndUpdateTime$1$1(j, value, (Continuation<? super FastRecordAppViewModel$saveAndUpdateTime$1$1>) null), 3, (Object) null);
        }
    }

    private final void setAmplitude(float f, int i, CopyOnWriteArrayList<AmplitudeBean> copyOnWriteArrayList) {
        copyOnWriteArrayList.add(new AmplitudeBean(f, i, false));
    }

    public final void addAmplitudeBean(@NotNull AmplitudeBean amplitudeBean) {
        Intrinsics.checkNotNullParameter(amplitudeBean, "data");
        addItemAmplitudeBeanToList(amplitudeBean);
        addDetailAmplitudeBeanToList(amplitudeBean);
    }

    public final void addAsrProgress(@NotNull AsrDuringProgress asrDuringProgress) {
        Intrinsics.checkNotNullParameter(asrDuringProgress, "asrResult");
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.c()), (CoroutineContext) null, (CoroutineStart) null, new FastRecordAppViewModel$addAsrProgress$1(asrDuringProgress, this, (Continuation<? super FastRecordAppViewModel$addAsrProgress$1>) null), 3, (Object) null);
    }

    public final void clearAmplitudeBeans() {
        RecordIngDetailSoundVisualizerView.Companion.clearAmplitudeBeans();
        RecordItemSoundVisualizerView.Companion.clearAmplitudeBeans();
    }

    @Nullable
    public final ArrayList<AsrDuringProgress> getAsrProgressData() {
        return this._recordAsrDuringProgress.getValue();
    }

    @NotNull
    public final LiveData<ArrayList<AsrDuringProgress>> getRecordAsrDuringProgress() {
        return this.recordAsrDuringProgress;
    }

    @NotNull
    public final LiveData<Boolean> getRecordConnectState() {
        return this.recordConnectState;
    }

    @NotNull
    public final LiveData<RecordGlassCacheInfo> getRecordGlassCacheInfo() {
        return this.recordGlassCacheInfo;
    }

    @Nullable
    public final RecordGlassStatus getRecordIngData() {
        return this._recordIngDetailInfo.getValue();
    }

    public final long getRecordIngId() {
        RecordGlassStatus value = this._recordIngDetailInfo.getValue();
        if (value != null) {
            return value.getId();
        }
        return 0;
    }

    public final void getRecordIngItem(@NotNull Function1<? super RecordEntity, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callBack");
        if (this._recordIngDetailInfo.getValue() == null) {
            function1.invoke(null);
            return;
        }
        RecordGlassStatus value = this._recordIngDetailInfo.getValue();
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordAppViewModel$getRecordIngItem$1(value != null ? value.getId() : -1, this, function1, (Continuation<? super FastRecordAppViewModel$getRecordIngItem$1>) null), 3, (Object) null);
    }

    public final int getRecordIngState() {
        RecordGlassStatus value = this._recordIngDetailInfo.getValue();
        if (value != null) {
            return value.getState();
        }
        return -1;
    }

    @NotNull
    public final LiveData<RecordEntity> getRecordIngTime() {
        return this.recordIngTime;
    }

    @Nullable
    public final RecordEntity getRecordIngTimeData() {
        return this._recordIngTimeEntity.getValue();
    }

    public final int getRecordIngType() {
        RecordGlassStatus value = this._recordIngDetailInfo.getValue();
        if (value != null) {
            return value.getType();
        }
        return 0;
    }

    @NotNull
    public final LiveData<RecordGlassStatus> getRecordStartRecordDetailIng() {
        return this.recordStartRecordDetailIng;
    }

    public final long getRecordingEntityTime() {
        RecordEntity value = this._recordIngTimeEntity.getValue();
        if (value != null) {
            return value.getTotalTime();
        }
        return 0;
    }

    public final boolean isRecordingDuring() {
        int recordIngState = getRecordIngState();
        return 1 == recordIngState || 4 == recordIngState;
    }

    public final void setConnectState(boolean z) {
        this._recordConnectState.postValue(Boolean.valueOf(z));
    }

    public final void setRecordIngTimeEntity(@NotNull RecordEntity recordEntity) {
        Intrinsics.checkNotNullParameter(recordEntity, "entity");
        LogExt.logW("createRecordIngEntity entity = " + recordEntity, TAG);
        this._recordIngTimeEntity.postValue(recordEntity);
    }

    public final void updateRecordingTime(long j, long j2) {
        if (this.timeMap.containsKey(Long.valueOf(j2))) {
            Long l = this.timeMap.get(Long.valueOf(j2));
            if (l == null) {
                l = 0L;
            }
            if (j - l.longValue() > 1000) {
                this.timeMap.put(Long.valueOf(j2), Long.valueOf(j));
                saveAndUpdateTime(j2);
                return;
            }
            return;
        }
        this.timeMap.put(Long.valueOf(j2), Long.valueOf(j));
        saveAndUpdateTime(j2);
    }

    public final void updateStartRecordDetailIng(@NotNull RecordGlassStatus recordGlassStatus) {
        Intrinsics.checkNotNullParameter(recordGlassStatus, "mRecordGlassStatus");
        this._recordIngDetailInfo.postValue(recordGlassStatus);
    }

    public final void updateStartRecordGlassCacheInfo(@NotNull RecordGlassCacheInfo recordGlassCacheInfo2, int i) {
        Intrinsics.checkNotNullParameter(recordGlassCacheInfo2, "mRecordGlassStatus");
        if (recordGlassCacheInfo2.getFinish() == 1) {
            Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordAppViewModel$updateStartRecordGlassCacheInfo$1(this, recordGlassCacheInfo2, (Continuation<? super FastRecordAppViewModel$updateStartRecordGlassCacheInfo$1>) null), 3, (Object) null);
            return;
        }
        RecordDataSaveUtil.INSTANCE.addDownLoadCancelSize(i);
        this._recordGlassCacheInfo.postValue(recordGlassCacheInfo2);
    }

    /* renamed from: getRecordConnectState  reason: collision with other method in class */
    public final boolean m1665getRecordConnectState() {
        Boolean value = this._recordConnectState.getValue();
        if (value == null) {
            value = Boolean.FALSE;
        }
        boolean booleanValue = value.booleanValue();
        LogExt.logE("getRecordConnectState state = " + booleanValue, TAG);
        return booleanValue;
    }
}
