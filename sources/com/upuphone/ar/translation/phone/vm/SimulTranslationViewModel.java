package com.upuphone.ar.translation.phone.vm;

import android.app.Application;
import android.view.View;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import androidx.recyclerview.widget.RecyclerView;
import com.android.dingtalk.openauth.utils.DDAuthConstant;
import com.honey.account.i5.g;
import com.upuphone.ar.translation.TranslationApp;
import com.upuphone.ar.translation.constants.TranslatorConstants;
import com.upuphone.ar.translation.eventtrack.EventTrackingHelper;
import com.upuphone.ar.translation.eventtrack.event.ClickEvent;
import com.upuphone.ar.translation.ext.InterconnectMsgCodExtKt;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.TranslationManager;
import com.upuphone.ar.translation.phone.bean.LanguageBean;
import com.upuphone.ar.translation.phone.bean.TranslationLanguage;
import com.upuphone.ar.translation.phone.helper.InterConnectHelper;
import com.upuphone.ar.translation.phone.helper.SwitchLangHelper;
import com.upuphone.ar.translation.statemachine.machine.TranslateStateManager;
import com.upuphone.ar.translation.utils.LanguageUtils;
import com.upuphone.ar.translation.utils.NetworkUtils;
import com.upuphone.ar.translation.utils.PreferencesUtils;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.xr.sapp.context.IPhoneCallStatus;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 @2\u00020\u0001:\u0001AB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\b¢\u0006\u0004\b\u0013\u0010\u0012J\r\u0010\u0014\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u0012J\u001d\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000e¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\b¢\u0006\u0004\b\u0019\u0010\u0012J\u0017\u0010\u001c\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\b2\b\b\u0001\u0010!\u001a\u00020\u001a¢\u0006\u0004\b\"\u0010\u001dJ\r\u0010#\u001a\u00020\b¢\u0006\u0004\b#\u0010\u0012J\u0015\u0010&\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J\u0015\u0010)\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u001e¢\u0006\u0004\b)\u0010*J\r\u0010+\u001a\u00020\b¢\u0006\u0004\b+\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001a\u00103\u001a\b\u0012\u0004\u0012\u00020\u0006008\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\"\u00106\u001a\u0010\u0012\f\u0012\n 4*\u0004\u0018\u00010\u001e0\u001e008\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00102R\u001d\u0010<\u001a\b\u0012\u0004\u0012\u00020\u0006078\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u001d\u0010?\u001a\b\u0012\u0004\u0012\u00020\u001e078\u0006¢\u0006\f\n\u0004\b=\u00109\u001a\u0004\b>\u0010;¨\u0006B"}, d2 = {"Lcom/upuphone/ar/translation/phone/vm/SimulTranslationViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "Landroid/app/Application;", "app", "<init>", "(Landroid/app/Application;)V", "Lcom/upuphone/ar/translation/phone/bean/TranslationLanguage;", "language", "", "s", "(Lcom/upuphone/ar/translation/phone/bean/TranslationLanguage;)V", "A", "", "langType", "Lcom/upuphone/ar/translation/phone/bean/LanguageBean;", "k", "(Ljava/lang/String;)Lcom/upuphone/ar/translation/phone/bean/LanguageBean;", "p", "()V", "E", "j", "src", "dst", "F", "(Lcom/upuphone/ar/translation/phone/bean/LanguageBean;Lcom/upuphone/ar/translation/phone/bean/LanguageBean;)V", "w", "", "transType", "x", "(I)V", "", "r", "()Z", "strId", "D", "B", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "l", "(Landroidx/recyclerview/widget/RecyclerView;)I", "isRtl", "t", "(Z)V", "v", "b", "Landroid/app/Application;", "getApp", "()Landroid/app/Application;", "Landroidx/lifecycle/MutableLiveData;", "c", "Landroidx/lifecycle/MutableLiveData;", "_mTransLanguage", "kotlin.jvm.PlatformType", "d", "_mIsRecordRtl", "Landroidx/lifecycle/LiveData;", "e", "Landroidx/lifecycle/LiveData;", "n", "()Landroidx/lifecycle/LiveData;", "mTransLanguage", "f", "m", "mIsRecordRtl", "g", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class SimulTranslationViewModel extends AndroidViewModel {
    public static final Companion g = new Companion((DefaultConstructorMarker) null);
    public final Application b;
    public final MutableLiveData c;
    public final MutableLiveData d;
    public final LiveData e;
    public final LiveData f;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/translation/phone/vm/SimulTranslationViewModel$Companion;", "", "()V", "TAG", "", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SimulTranslationViewModel(@NotNull Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, DDAuthConstant.AUTH_LOGIN_TYPE_APP);
        this.b = application;
        MutableLiveData mutableLiveData = new MutableLiveData();
        this.c = mutableLiveData;
        MutableLiveData mutableLiveData2 = new MutableLiveData(Boolean.FALSE);
        this.d = mutableLiveData2;
        Intrinsics.checkNotNull(mutableLiveData, "null cannot be cast to non-null type androidx.lifecycle.LiveData<com.upuphone.ar.translation.phone.bean.TranslationLanguage>");
        this.e = mutableLiveData;
        Intrinsics.checkNotNull(mutableLiveData2, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Boolean>");
        this.f = mutableLiveData2;
    }

    private final void A(TranslationLanguage translationLanguage) {
        LogExt.j("setLanguage transLanguage=" + translationLanguage, "SimulTranslationViewModel");
        PreferencesUtils.p(2, translationLanguage.getSrc().getLangType(), translationLanguage.getDst().getLangType());
        InterConnectHelper.c.a().B(2, translationLanguage.getSrc().getLangType(), translationLanguage.getDst().getLangType());
    }

    /* access modifiers changed from: private */
    public final LanguageBean k(String str) {
        return new LanguageBean(LanguageUtils.e(this.b, str), str);
    }

    public static final void q(SimulTranslationViewModel simulTranslationViewModel, int i, String str, String str2) {
        Intrinsics.checkNotNullParameter(simulTranslationViewModel, "this$0");
        Intrinsics.checkNotNullParameter(str, "src");
        Intrinsics.checkNotNullParameter(str2, "dst");
        String k = InterconnectMsgCodExtKt.k(i);
        LogExt.j("SwitchLangHelper transType=" + k + ", src=" + str + ", dst=" + str2, "SimulTranslationViewModel");
        if (i == 2) {
            simulTranslationViewModel.s(new TranslationLanguage(simulTranslationViewModel.k(str), simulTranslationViewModel.k(str2)));
        }
    }

    /* access modifiers changed from: private */
    public final void s(TranslationLanguage translationLanguage) {
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.c(), (CoroutineStart) null, new SimulTranslationViewModel$notifyLanguage$1(translationLanguage, this, (Continuation<? super SimulTranslationViewModel$notifyLanguage$1>) null), 2, (Object) null);
    }

    public static /* synthetic */ void y(SimulTranslationViewModel simulTranslationViewModel, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 2;
        }
        simulTranslationViewModel.x(i);
    }

    public final void B() {
        String str;
        String str2;
        LanguageBean dst;
        LanguageBean src;
        PreferencesUtils.A(2);
        LanguageUtils.StoredLanguage g2 = LanguageUtils.g();
        TranslationLanguage translationLanguage = (TranslationLanguage) this.c.getValue();
        if (translationLanguage == null || (src = translationLanguage.getSrc()) == null || (str = src.getLangType()) == null) {
            str = g2.d();
        }
        if (translationLanguage == null || (dst = translationLanguage.getDst()) == null || (str2 = dst.getLangType()) == null) {
            str2 = g2.c();
        }
        TranslationManager.Companion companion = TranslationManager.q;
        TranslateStateManager p = companion.a().p();
        boolean z = false;
        boolean c2 = p != null ? p.c() : false;
        TranslateStateManager p2 = companion.a().p();
        if (p2 != null) {
            z = p2.e();
        }
        if (c2 || z) {
            LogExt.j("startTranslation 翻译服务已启动，开始同传翻译", "SimulTranslationViewModel");
            NetworkUtils.f6368a.e(this.b, new SimulTranslationViewModel$startTranslation$1(str, str2));
            return;
        }
        LogExt.j("startTranslation 翻译服务未启动，开始同传翻译", "SimulTranslationViewModel");
        TranslationApp.startService(this.b);
    }

    public final void D(int i) {
        UToast.f6444a.c(this.b, i, 0);
    }

    public final void E() {
        SwitchLangHelper.A("SimulTranslationViewModel");
    }

    public final void F(LanguageBean languageBean, LanguageBean languageBean2) {
        Intrinsics.checkNotNullParameter(languageBean, "src");
        Intrinsics.checkNotNullParameter(languageBean2, "dst");
        LogExt.g("updateLanguage src=" + languageBean + ", dst=" + languageBean2, "SimulTranslationViewModel");
        TranslationLanguage translationLanguage = new TranslationLanguage(languageBean, languageBean2);
        s(translationLanguage);
        A(translationLanguage);
    }

    public final void j() {
        TranslationLanguage translationLanguage = (TranslationLanguage) this.c.getValue();
        if (translationLanguage != null) {
            LanguageBean languageBean = new LanguageBean(translationLanguage.getSrc().getLangName(), translationLanguage.getSrc().getLangType());
            LanguageBean languageBean2 = new LanguageBean(translationLanguage.getDst().getLangName(), translationLanguage.getDst().getLangType());
            LogExt.g("exchangeLanguage tempSrc=" + languageBean + ", tempDst=" + languageBean2, "SimulTranslationViewModel");
            TranslationLanguage translationLanguage2 = new TranslationLanguage(languageBean2, languageBean);
            s(translationLanguage2);
            A(translationLanguage2);
        }
    }

    public final int l(RecyclerView recyclerView) {
        int childAdapterPosition;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        int childCount = recyclerView.getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            if (childAt.getVisibility() != 8 && (childAdapterPosition = recyclerView.getChildAdapterPosition(childAt)) >= i) {
                i = childAdapterPosition;
            }
        }
        return i;
    }

    public final LiveData m() {
        return this.f;
    }

    public final LiveData n() {
        return this.e;
    }

    public final void p() {
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.b(), (CoroutineStart) null, new SimulTranslationViewModel$init$1(this, (Continuation<? super SimulTranslationViewModel$init$1>) null), 2, (Object) null);
        SwitchLangHelper.j("SimulTranslationViewModel", new g(this));
    }

    public final boolean r() {
        return InterConnectHelper.c.a().j();
    }

    public final void t(boolean z) {
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.c(), (CoroutineStart) null, new SimulTranslationViewModel$notifyRecordRtl$1(this, z, (Continuation<? super SimulTranslationViewModel$notifyRecordRtl$1>) null), 2, (Object) null);
    }

    public final void v() {
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.b(), (CoroutineStart) null, new SimulTranslationViewModel$notifyRunningRecordRtl$1(this, (Continuation<? super SimulTranslationViewModel$notifyRunningRecordRtl$1>) null), 2, (Object) null);
    }

    public final void w() {
        EventTrackingHelper.f6200a.b(new ClickEvent(3, 0, 2, (DefaultConstructorMarker) null));
    }

    public final void x(int i) {
        int i2;
        int i3 = i;
        IPhoneCallStatus value = TranslatorConstants.getPhoneCallStatus().getValue();
        boolean z = false;
        if (value != null && value.getCallStatus() == 2) {
            z = true;
        }
        EventTrackingHelper eventTrackingHelper = EventTrackingHelper.f6200a;
        if (i3 != 1) {
            i2 = 4;
            if (i3 != 2 && i3 == 3) {
                i2 = z ? 13 : 11;
            }
        } else {
            i2 = 7;
        }
        eventTrackingHelper.b(new ClickEvent(i2, 0, 2, (DefaultConstructorMarker) null));
        if (z && i3 == 3) {
            eventTrackingHelper.e(new ClickEvent(13, 0, 2, (DefaultConstructorMarker) null));
        }
    }
}
