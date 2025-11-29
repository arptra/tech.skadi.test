package com.upuphone.ar.translation.phone.vm;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.android.dingtalk.openauth.utils.DDAuthConstant;
import com.upuphone.ar.translation.TranslationApp;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.R;
import com.upuphone.ar.translation.phone.bean.IntelExtnSummary;
import com.upuphone.ar.translation.phone.bean.NoteBean;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.starrynet.payload.PayloadConstant;
import com.upuphone.xr.audio.record.ai.bean.AiFeedBackRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 22\u00020\u0001:\u0001<B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\nJ\u0017\u0010\u0013\u001a\u00020\b2\b\b\u0001\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0015¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u001c2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\bH\u0014¢\u0006\u0004\b\u001f\u0010 R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0%8\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u001c\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0%8\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010(R\u001c\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010,0%8\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010(R\u001f\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0/8\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u001f\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0/8\u0006¢\u0006\f\n\u0004\b5\u00101\u001a\u0004\b5\u00103R\u001f\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010,0/8\u0006¢\u0006\f\n\u0004\b7\u00101\u001a\u0004\b7\u00103R\u0018\u0010;\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u0010:¨\u0006="}, d2 = {"Lcom/upuphone/ar/translation/phone/vm/IntelExtnSummaryViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "Landroid/app/Application;", "app", "<init>", "(Landroid/app/Application;)V", "Lcom/upuphone/ar/translation/phone/bean/NoteBean;", "noteBean", "", "m", "(Lcom/upuphone/ar/translation/phone/bean/NoteBean;)V", "Lcom/upuphone/ar/translation/phone/bean/IntelExtnSummary;", "summary", "n", "(Lcom/upuphone/ar/translation/phone/bean/IntelExtnSummary;)V", "s", "l", "", "stringResId", "q", "(I)V", "", "msg", "r", "(Ljava/lang/String;)V", "Lcom/upuphone/xr/audio/record/ai/bean/AiFeedBackRequest;", "k", "(Lcom/upuphone/ar/translation/phone/bean/NoteBean;Ljava/lang/String;)Lcom/upuphone/xr/audio/record/ai/bean/AiFeedBackRequest;", "", "p", "(Lcom/upuphone/ar/translation/phone/bean/NoteBean;)Z", "onCleared", "()V", "b", "Landroid/app/Application;", "getApp", "()Landroid/app/Application;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/xjsd/xr/sapp/asr/dao/SmartExSummary;", "c", "Landroidx/lifecycle/MutableLiveData;", "_mResIntelExtnSummary", "d", "_mIntelExtnSummary", "Lcom/xjsd/xr/sapp/asr/dao/SensitivePayload;", "e", "_mResIntelExtnSensitive", "Landroidx/lifecycle/LiveData;", "f", "Landroidx/lifecycle/LiveData;", "j", "()Landroidx/lifecycle/LiveData;", "mResIntelExtnSummary", "g", "mIntelExtnSummary", "h", "mResIntelExtnSensitive", "i", "Lcom/upuphone/ar/translation/phone/bean/NoteBean;", "mNoteBeanByServer", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class IntelExtnSummaryViewModel extends AndroidViewModel {
    public static final Companion j = new Companion((DefaultConstructorMarker) null);
    public final Application b;
    public final MutableLiveData c;
    public final MutableLiveData d;
    public final MutableLiveData e;
    public final LiveData f;
    public final LiveData g;
    public final LiveData h;
    public NoteBean i;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/translation/phone/vm/IntelExtnSummaryViewModel$Companion;", "", "()V", "TAG", "", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IntelExtnSummaryViewModel(@NotNull Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, DDAuthConstant.AUTH_LOGIN_TYPE_APP);
        this.b = application;
        MutableLiveData mutableLiveData = new MutableLiveData();
        this.c = mutableLiveData;
        MutableLiveData mutableLiveData2 = new MutableLiveData();
        this.d = mutableLiveData2;
        MutableLiveData mutableLiveData3 = new MutableLiveData();
        this.e = mutableLiveData3;
        Intrinsics.checkNotNull(mutableLiveData, "null cannot be cast to non-null type androidx.lifecycle.LiveData<com.xjsd.xr.sapp.asr.dao.SmartExSummary?>");
        this.f = mutableLiveData;
        Intrinsics.checkNotNull(mutableLiveData2, "null cannot be cast to non-null type androidx.lifecycle.LiveData<com.upuphone.ar.translation.phone.bean.IntelExtnSummary?>");
        this.g = mutableLiveData2;
        Intrinsics.checkNotNull(mutableLiveData3, "null cannot be cast to non-null type androidx.lifecycle.LiveData<com.xjsd.xr.sapp.asr.dao.SensitivePayload?>");
        this.h = mutableLiveData3;
    }

    public final LiveData g() {
        return this.g;
    }

    public final LiveData h() {
        return this.h;
    }

    public final LiveData j() {
        return this.f;
    }

    public final AiFeedBackRequest k(NoteBean noteBean, String str) {
        String str2;
        Intrinsics.checkNotNullParameter(noteBean, "noteBean");
        Intrinsics.checkNotNullParameter(str, "summary");
        String recognizeId = noteBean.getRecognizeId();
        String str3 = this.b.getString(R.string.tl_summary) + StringUtils.LF + str;
        IntelExtnSummary intelExtnSummary = (IntelExtnSummary) this.d.getValue();
        if (intelExtnSummary == null || (str2 = intelExtnSummary.getRequestId()) == null) {
            str2 = "";
        }
        return new AiFeedBackRequest(3, recognizeId, str3, str2);
    }

    public final void l(NoteBean noteBean) {
        Intrinsics.checkNotNullParameter(noteBean, "noteBean");
        LogExt.j("getSummaryByDb noteBean=" + noteBean, "IntelExtnSummaryViewModel");
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.c(), (CoroutineStart) null, new IntelExtnSummaryViewModel$getSummaryByDb$1(this, noteBean, (Continuation<? super IntelExtnSummaryViewModel$getSummaryByDb$1>) null), 2, (Object) null);
    }

    public final void m(NoteBean noteBean) {
        Intrinsics.checkNotNullParameter(noteBean, "noteBean");
        this.i = noteBean;
        TranslationApp translationApp = TranslationApp.INSTANCE;
        translationApp.getSmartExHelper$ar_translator_intlRelease().h(1, noteBean, new IntelExtnSummaryViewModel$getSummaryByServer$1(this));
        translationApp.getSmartExHelper$ar_translator_intlRelease().e(noteBean);
    }

    public final void n(IntelExtnSummary intelExtnSummary) {
        Intrinsics.checkNotNullParameter(intelExtnSummary, "summary");
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.c(), (CoroutineStart) null, new IntelExtnSummaryViewModel$insertSummary$1(this, intelExtnSummary, (Continuation<? super IntelExtnSummaryViewModel$insertSummary$1>) null), 2, (Object) null);
    }

    public void onCleared() {
        super.onCleared();
        NoteBean noteBean = this.i;
        if (noteBean != null) {
            TranslationApp.INSTANCE.getSmartExHelper$ar_translator_intlRelease().j(1, noteBean);
        }
    }

    public final boolean p(NoteBean noteBean) {
        if (noteBean != null) {
            return TranslationApp.INSTANCE.getSmartExHelper$ar_translator_intlRelease().g(1, noteBean);
        }
        return false;
    }

    public final void q(int i2) {
        UToast.f6444a.b(this.b, i2);
    }

    public final void r(String str) {
        Intrinsics.checkNotNullParameter(str, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        UToast.f6444a.d(this.b, str);
    }

    public final void s(IntelExtnSummary intelExtnSummary) {
        Intrinsics.checkNotNullParameter(intelExtnSummary, "summary");
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.c(), (CoroutineStart) null, new IntelExtnSummaryViewModel$updateSummary$1(intelExtnSummary, this, (Continuation<? super IntelExtnSummaryViewModel$updateSummary$1>) null), 2, (Object) null);
    }
}
