package com.upuphone.ar.fastrecord.phone.ui.viewmodel.recording;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import com.upuphone.ar.fastrecord.phone.ext.FastRecordAppUtilsKt;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u0011J\u000e\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/recording/FastRecordDetailRecordIngViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_mCurFastRecordLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/upuphone/ar/fastrecord/phone/db/RecordEntity;", "curRecordData", "Landroidx/lifecycle/LiveData;", "getCurRecordData", "()Landroidx/lifecycle/LiveData;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "changeRecordFinishState", "", "state", "", "callBack", "Lkotlin/Function0;", "queryRecordAndUpdate", "recordId", "", "Companion", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FastRecordDetailRecordIngViewModel extends ViewModel {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String TAG = "FastRecordDetailRecordIngViewModel";
    /* access modifiers changed from: private */
    @NotNull
    public MutableLiveData<RecordEntity> _mCurFastRecordLiveData;
    @NotNull
    private final LiveData<RecordEntity> curRecordData;
    @NotNull
    private final CoroutineScope scope = CoroutineScopeKt.a(Dispatchers.b());

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/recording/FastRecordDetailRecordIngViewModel$Companion;", "", "()V", "TAG", "", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public FastRecordDetailRecordIngViewModel() {
        MutableLiveData<RecordEntity> mutableLiveData = new MutableLiveData<>();
        this._mCurFastRecordLiveData = mutableLiveData;
        this.curRecordData = FastRecordAppUtilsKt.asLiveData(mutableLiveData);
    }

    public final void changeRecordFinishState(int i, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "callBack");
        RecordEntity value = this._mCurFastRecordLiveData.getValue();
        LogExt.logE("changeRecordFinishState state = " + i + ",_mCurFastRecordLiveData.value = " + value, TAG);
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordDetailRecordIngViewModel$changeRecordFinishState$1(this, i, function0, (Continuation<? super FastRecordDetailRecordIngViewModel$changeRecordFinishState$1>) null), 3, (Object) null);
    }

    @NotNull
    public final LiveData<RecordEntity> getCurRecordData() {
        return this.curRecordData;
    }

    public final void queryRecordAndUpdate(long j) {
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordDetailRecordIngViewModel$queryRecordAndUpdate$1(j, this, (Continuation<? super FastRecordDetailRecordIngViewModel$queryRecordAndUpdate$1>) null), 3, (Object) null);
    }
}
