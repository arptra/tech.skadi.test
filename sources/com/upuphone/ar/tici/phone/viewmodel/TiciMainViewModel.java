package com.upuphone.ar.tici.phone.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModelKt;
import com.android.dingtalk.openauth.utils.DDAuthConstant;
import com.upuphone.ar.tici.phone.TiciApp;
import com.upuphone.ar.tici.phone.data.ParagraphProgress;
import com.upuphone.ar.tici.phone.data.TiciInfo;
import com.upuphone.ar.tici.phone.data.TiciInfoState;
import com.upuphone.ar.tici.phone.utils.CommonExtKt;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.sapp.utils.MathExtKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t*\u0001I\u0018\u0000 S2\u00020\u0001:\u0001TB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ9\u0010\u0013\u001a\u00020\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\fJ\u001f\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u000e2\b\b\u0002\u0010\u0018\u001a\u00020\u0010¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000e2\b\b\u0002\u0010\u001d\u001a\u00020\u0010¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u000e2\b\b\u0002\u0010\u0018\u001a\u00020\u0010¢\u0006\u0004\b!\u0010\u001aJ\r\u0010\"\u001a\u00020\u0006¢\u0006\u0004\b\"\u0010\bJ\u001f\u0010&\u001a\u00020%2\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u000eH\u0002¢\u0006\u0004\b&\u0010'R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020-0,8\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001d\u00106\u001a\b\u0012\u0004\u0012\u00020-018\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001a\u00109\u001a\b\u0012\u0004\u0012\u0002070,8\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u0010/R\u001d\u0010<\u001a\b\u0012\u0004\u0012\u000207018\u0006¢\u0006\f\n\u0004\b:\u00103\u001a\u0004\b;\u00105R\u001a\u0010>\u001a\b\u0012\u0004\u0012\u00020%0,8\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010/R\u001d\u0010A\u001a\b\u0012\u0004\u0012\u00020%018\u0006¢\u0006\f\n\u0004\b?\u00103\u001a\u0004\b@\u00105R\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00100,8\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010/R%\u0010G\u001a\u0010\u0012\f\u0012\n D*\u0004\u0018\u00010\u00100\u0010018\u0006¢\u0006\f\n\u0004\bE\u00103\u001a\u0004\bF\u00105R\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00100,8\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010/R\u0014\u0010K\u001a\u00020I8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010JR\u0013\u0010O\u001a\u0004\u0018\u00010L8F¢\u0006\u0006\u001a\u0004\bM\u0010NR\u0011\u0010R\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\bP\u0010Q¨\u0006U"}, d2 = {"Lcom/upuphone/ar/tici/phone/viewmodel/TiciMainViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "Landroid/app/Application;", "app", "<init>", "(Landroid/app/Application;)V", "", "onCleared", "()V", "", "ticiId", "w", "(J)V", "targetId", "", "targetPage", "", "restartIfReachLast", "showLoading", "E", "(Ljava/lang/Long;Ljava/lang/Integer;ZZ)V", "waitTime", "l", "offset", "needSendMsg", "B", "(IZ)V", "page", "index", "isMandatory", "x", "(IIZ)V", "progress", "A", "k", "cur", "max", "", "n", "(II)Ljava/lang/String;", "b", "Landroid/app/Application;", "getApp", "()Landroid/app/Application;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/upuphone/ar/tici/phone/data/TiciInfoState;", "c", "Landroidx/lifecycle/MutableLiveData;", "_lastTiciInfoState", "Landroidx/lifecycle/LiveData;", "d", "Landroidx/lifecycle/LiveData;", "t", "()Landroidx/lifecycle/LiveData;", "lastTiciInfoState", "Lcom/upuphone/ar/tici/phone/data/ParagraphProgress;", "e", "_curParagraphProgress", "f", "q", "curParagraphProgress", "g", "_percentText", "h", "v", "percentText", "i", "_hasConnect", "kotlin.jvm.PlatformType", "j", "s", "hasConnect", "_blockTiciProgress", "com/upuphone/ar/tici/phone/viewmodel/TiciMainViewModel$connectionListener$1", "Lcom/upuphone/ar/tici/phone/viewmodel/TiciMainViewModel$connectionListener$1;", "connectionListener", "Lcom/upuphone/ar/tici/phone/data/TiciInfo;", "r", "()Lcom/upuphone/ar/tici/phone/data/TiciInfo;", "currentTiciInfo", "p", "()Z", "blockTiciProgress", "m", "Companion", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
public final class TiciMainViewModel extends AndroidViewModel {
    public static final Companion m = new Companion((DefaultConstructorMarker) null);
    public final Application b;
    public final MutableLiveData c;
    public final LiveData d;
    public final MutableLiveData e;
    public final LiveData f;
    public final MutableLiveData g;
    public final LiveData h;
    public final MutableLiveData i;
    public final LiveData j;
    public final MutableLiveData k = new MutableLiveData();
    public final TiciMainViewModel$connectionListener$1 l = new TiciMainViewModel$connectionListener$1(this);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/tici/phone/viewmodel/TiciMainViewModel$Companion;", "", "()V", "TAG", "", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciMainViewModel(@NotNull Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, DDAuthConstant.AUTH_LOGIN_TYPE_APP);
        this.b = application;
        MutableLiveData mutableLiveData = new MutableLiveData();
        this.c = mutableLiveData;
        this.d = mutableLiveData;
        MutableLiveData mutableLiveData2 = new MutableLiveData();
        this.e = mutableLiveData2;
        Intrinsics.checkNotNull(mutableLiveData2, "null cannot be cast to non-null type androidx.lifecycle.LiveData<com.upuphone.ar.tici.phone.data.ParagraphProgress>");
        this.f = mutableLiveData2;
        MutableLiveData mutableLiveData3 = new MutableLiveData();
        this.g = mutableLiveData3;
        Intrinsics.checkNotNull(mutableLiveData3, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.String>");
        this.h = mutableLiveData3;
        MutableLiveData mutableLiveData4 = new MutableLiveData();
        this.i = mutableLiveData4;
        LiveData a2 = Transformations.a(mutableLiveData4);
        Intrinsics.checkNotNullExpressionValue(a2, "distinctUntilChanged(...)");
        this.j = a2;
    }

    public static /* synthetic */ void D(TiciMainViewModel ticiMainViewModel, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = true;
        }
        ticiMainViewModel.B(i2, z);
    }

    public static /* synthetic */ void F(TiciMainViewModel ticiMainViewModel, Long l2, Integer num, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            l2 = null;
        }
        if ((i2 & 2) != 0) {
            num = null;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        if ((i2 & 8) != 0) {
            z2 = false;
        }
        ticiMainViewModel.E(l2, num, z, z2);
    }

    public static /* synthetic */ void m(TiciMainViewModel ticiMainViewModel, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = 0;
        }
        ticiMainViewModel.l(j2);
    }

    public static /* synthetic */ void y(TiciMainViewModel ticiMainViewModel, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            z = false;
        }
        ticiMainViewModel.x(i2, i3, z);
    }

    public final void A(int i2, boolean z) {
        CommonExtKt.e("highlightByProgress, progress: " + i2 + ", needSendMsg: " + z, "TiciMainViewModel");
        if (TiciApp.b.n()) {
            CommonExtKt.d("highlightByProgress, isTiciStarting=true, return", "TiciMainViewModel", (Throwable) null, 2, (Object) null);
        } else if (i2 < 0) {
            CommonExtKt.e("highlightByProgress, reach first", "TiciMainViewModel");
        } else {
            TiciInfo r = r();
            if (r != null) {
                Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new TiciMainViewModel$highlightByProgress$1(i2, r, this, z, (Continuation<? super TiciMainViewModel$highlightByProgress$1>) null), 3, (Object) null);
            }
        }
    }

    public final void B(int i2, boolean z) {
        CommonExtKt.e("highlightWithOffset, offset: " + i2 + ", needSendMsg: " + z, "TiciMainViewModel");
        ParagraphProgress paragraphProgress = (ParagraphProgress) this.f.getValue();
        if (paragraphProgress != null) {
            A(paragraphProgress.getProgress() + i2, z);
        }
    }

    public final void E(Long l2, Integer num, boolean z, boolean z2) {
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new TiciMainViewModel$loadLastTiciContent$1(l2, num, z, z2, this, (Continuation<? super TiciMainViewModel$loadLastTiciContent$1>) null), 3, (Object) null);
    }

    public final void k() {
        TiciApp ticiApp = TiciApp.b;
        StarryNetDevice connectXrDevice = ticiApp.q().getConnectXrDevice();
        CommonExtKt.e("checkAndListenStarryConnect-> start: " + connectXrDevice, "TiciMainViewModel");
        if (connectXrDevice == null) {
            this.i.postValue(Boolean.FALSE);
        } else {
            this.i.postValue(Boolean.TRUE);
        }
        ticiApp.s(this.l);
    }

    public final void l(long j2) {
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new TiciMainViewModel$checkGlassTiciState$1(j2, (Continuation<? super TiciMainViewModel$checkGlassTiciState$1>) null), 3, (Object) null);
    }

    public final String n(int i2, int i3) {
        float f2 = (((float) i2) / ((float) i3)) * ((float) 100);
        CommonExtKt.b("computeProgress, cur: " + i2 + ", max: " + i3 + ", percent: " + f2, "TiciMainViewModel");
        String d2 = MathExtKt.d(MathExtKt.a(Float.valueOf(f2)));
        StringBuilder sb = new StringBuilder();
        sb.append(d2);
        sb.append("%");
        String sb2 = sb.toString();
        CommonExtKt.b("computeProgress, cur: " + i2 + ", max: " + i3 + ", percentText: " + sb2, "TiciMainViewModel");
        return sb2;
    }

    public void onCleared() {
        super.onCleared();
        TiciApp.b.v(this.l);
    }

    public final boolean p() {
        return Intrinsics.areEqual(this.k.getValue(), (Object) Boolean.TRUE);
    }

    public final LiveData q() {
        return this.f;
    }

    public final TiciInfo r() {
        TiciInfoState ticiInfoState = (TiciInfoState) this.c.getValue();
        if (ticiInfoState == null) {
            return null;
        }
        TiciInfoState.Success success = ticiInfoState instanceof TiciInfoState.Success ? (TiciInfoState.Success) ticiInfoState : null;
        if (success != null) {
            return success.a();
        }
        return null;
    }

    public final LiveData s() {
        return this.j;
    }

    public final LiveData t() {
        return this.d;
    }

    public final LiveData v() {
        return this.h;
    }

    public final void w(long j2) {
        F(this, Long.valueOf(j2), (Integer) null, false, false, 14, (Object) null);
    }

    public final void x(int i2, int i3, boolean z) {
        TiciInfo r = r();
        if (r != null) {
            Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new TiciMainViewModel$highlightByPage$1(i2, i3, z, r, this, (Continuation<? super TiciMainViewModel$highlightByPage$1>) null), 3, (Object) null);
        }
    }
}
