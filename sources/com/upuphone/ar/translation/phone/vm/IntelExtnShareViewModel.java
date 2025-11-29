package com.upuphone.ar.translation.phone.vm;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.android.dingtalk.openauth.utils.DDAuthConstant;
import com.upuphone.ar.translation.phone.bean.NoteBean;
import com.upuphone.ar.translation.phone.fragment.SummaryFragment;
import com.upuphone.ar.translation.phone.fragment.ToDoFragment;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 32\u00020\u0001:\u0002=>B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u001a\u001a\u00020\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020\f0\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00130'8\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00130'8\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010)R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001c0'8\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010)R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020\u000f0'8\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u0010)R\u001d\u00105\u001a\b\u0012\u0004\u0012\u00020\u0013018\u0006¢\u0006\f\n\u0004\b\r\u00102\u001a\u0004\b3\u00104R\u001d\u00108\u001a\b\u0012\u0004\u0012\u00020\u0013018\u0006¢\u0006\f\n\u0004\b6\u00102\u001a\u0004\b7\u00104R\u001d\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001c018\u0006¢\u0006\f\n\u0004\b9\u00102\u001a\u0004\b9\u00104R\u001d\u0010<\u001a\b\u0012\u0004\u0012\u00020\u000f018\u0006¢\u0006\f\n\u0004\b;\u00102\u001a\u0004\b;\u00104¨\u0006?"}, d2 = {"Lcom/upuphone/ar/translation/phone/vm/IntelExtnShareViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "Landroid/app/Application;", "app", "<init>", "(Landroid/app/Application;)V", "", "onCleared", "()V", "Lcom/upuphone/ar/translation/phone/bean/NoteBean;", "noteBean", "", "Landroidx/fragment/app/Fragment;", "h", "(Lcom/upuphone/ar/translation/phone/bean/NoteBean;)Ljava/util/List;", "", "position", "p", "(I)V", "", "summary", "q", "(Ljava/lang/String;)V", "", "Lcom/upuphone/ar/translation/phone/bean/IntelExtnTodo;", "todoList", "r", "(Ljava/util/List;)V", "Lcom/upuphone/ar/translation/phone/vm/IntelExtnShareViewModel$ImeBean;", "imeBean", "n", "(Lcom/upuphone/ar/translation/phone/vm/IntelExtnShareViewModel$ImeBean;)V", "b", "Landroid/app/Application;", "getApp", "()Landroid/app/Application;", "c", "Ljava/util/List;", "mFragments", "Landroidx/lifecycle/MutableLiveData;", "d", "Landroidx/lifecycle/MutableLiveData;", "_mShareSummary", "e", "_mShareTodos", "f", "_mImeVisible", "g", "_mIntelExtnTabPosition", "Landroidx/lifecycle/LiveData;", "Landroidx/lifecycle/LiveData;", "l", "()Landroidx/lifecycle/LiveData;", "mShareSummary", "i", "m", "mShareTodos", "j", "mImeVisible", "k", "mIntelExtnTabPosition", "Companion", "ImeBean", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class IntelExtnShareViewModel extends AndroidViewModel {
    public static final Companion l = new Companion((DefaultConstructorMarker) null);
    public final Application b;
    public List c = new ArrayList();
    public final MutableLiveData d;
    public final MutableLiveData e;
    public final MutableLiveData f;
    public final MutableLiveData g;
    public final LiveData h;
    public final LiveData i;
    public final LiveData j;
    public final LiveData k;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/upuphone/ar/translation/phone/vm/IntelExtnShareViewModel$Companion;", "", "()V", "ON_HOUR_MILLIS", "", "TAG", "", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0014\u001a\u0004\b\u0010\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/upuphone/ar/translation/phone/vm/IntelExtnShareViewModel$ImeBean;", "", "", "imeVisible", "", "bottomMargin", "<init>", "(ZI)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "a", "Z", "b", "()Z", "I", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class ImeBean {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f6341a;
        public final int b;

        public ImeBean(boolean z, int i) {
            this.f6341a = z;
            this.b = i;
        }

        public final int a() {
            return this.b;
        }

        public final boolean b() {
            return this.f6341a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ImeBean)) {
                return false;
            }
            ImeBean imeBean = (ImeBean) obj;
            return this.f6341a == imeBean.f6341a && this.b == imeBean.b;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.f6341a) * 31) + Integer.hashCode(this.b);
        }

        public String toString() {
            boolean z = this.f6341a;
            int i = this.b;
            return "ImeBean(imeVisible=" + z + ", bottomMargin=" + i + ")";
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IntelExtnShareViewModel(@NotNull Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, DDAuthConstant.AUTH_LOGIN_TYPE_APP);
        this.b = application;
        MutableLiveData mutableLiveData = new MutableLiveData();
        this.d = mutableLiveData;
        MutableLiveData mutableLiveData2 = new MutableLiveData();
        this.e = mutableLiveData2;
        MutableLiveData mutableLiveData3 = new MutableLiveData();
        this.f = mutableLiveData3;
        MutableLiveData mutableLiveData4 = new MutableLiveData();
        this.g = mutableLiveData4;
        Intrinsics.checkNotNull(mutableLiveData, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.String>");
        this.h = mutableLiveData;
        Intrinsics.checkNotNull(mutableLiveData2, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.String>");
        this.i = mutableLiveData2;
        Intrinsics.checkNotNull(mutableLiveData3, "null cannot be cast to non-null type androidx.lifecycle.LiveData<com.upuphone.ar.translation.phone.vm.IntelExtnShareViewModel.ImeBean>");
        this.j = mutableLiveData3;
        Intrinsics.checkNotNull(mutableLiveData4, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Int>");
        this.k = mutableLiveData4;
    }

    public final List h(NoteBean noteBean) {
        if (!this.c.isEmpty()) {
            return this.c;
        }
        ArrayList arrayListOf = CollectionsKt.arrayListOf(SummaryFragment.e.a(noteBean), ToDoFragment.g.a(noteBean));
        this.c = arrayListOf;
        return arrayListOf;
    }

    public final LiveData j() {
        return this.j;
    }

    public final LiveData k() {
        return this.k;
    }

    public final LiveData l() {
        return this.h;
    }

    public final LiveData m() {
        return this.i;
    }

    public final void n(ImeBean imeBean) {
        Intrinsics.checkNotNullParameter(imeBean, "imeBean");
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.c(), (CoroutineStart) null, new IntelExtnShareViewModel$notifyImeVisible$1(this, imeBean, (Continuation<? super IntelExtnShareViewModel$notifyImeVisible$1>) null), 2, (Object) null);
    }

    public void onCleared() {
        super.onCleared();
        this.c.clear();
    }

    public final void p(int i2) {
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.c(), (CoroutineStart) null, new IntelExtnShareViewModel$notifyIntelExtnTabPosition$1(this, i2, (Continuation<? super IntelExtnShareViewModel$notifyIntelExtnTabPosition$1>) null), 2, (Object) null);
    }

    public final void q(String str) {
        Intrinsics.checkNotNullParameter(str, "summary");
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.c(), (CoroutineStart) null, new IntelExtnShareViewModel$notifyShareSummary$1(this, str, (Continuation<? super IntelExtnShareViewModel$notifyShareSummary$1>) null), 2, (Object) null);
    }

    public final void r(List list) {
        Intrinsics.checkNotNullParameter(list, "todoList");
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.c(), (CoroutineStart) null, new IntelExtnShareViewModel$notifyShareTodos$1(this, list, (Continuation<? super IntelExtnShareViewModel$notifyShareTodos$1>) null), 2, (Object) null);
    }
}
