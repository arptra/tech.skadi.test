package com.upuphone.ar.translation.phone.vm;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.android.dingtalk.openauth.utils.DDAuthConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 ,2\u00020\u0001:\u00010B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\nJ\u001b\u0010\u0010\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aR \u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u001e0\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001aR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001aR\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00060#8\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00060#8\u0006¢\u0006\f\n\u0004\b&\u0010%\u001a\u0004\b)\u0010'R#\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u001e0#8\u0006¢\u0006\f\n\u0004\b+\u0010%\u001a\u0004\b,\u0010'R\u001d\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00060#8\u0006¢\u0006\f\n\u0004\b)\u0010%\u001a\u0004\b.\u0010'¨\u00061"}, d2 = {"Lcom/upuphone/ar/translation/phone/vm/TranslatorRecordShareViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "Landroid/app/Application;", "app", "<init>", "(Landroid/app/Application;)V", "", "isSelectAll", "", "m", "(Z)V", "isMultiDeleted", "n", "", "Lcom/upuphone/ar/translation/phone/bean/NoteBean;", "list", "p", "(Ljava/util/List;)V", "q", "()V", "b", "Landroid/app/Application;", "getApp", "()Landroid/app/Application;", "Landroidx/lifecycle/MutableLiveData;", "c", "Landroidx/lifecycle/MutableLiveData;", "_mIsSelectAllRecord", "d", "_mMultiChoiceDeleted", "", "e", "_mMultiDeleteItems", "f", "_mSelectAll", "Landroidx/lifecycle/LiveData;", "g", "Landroidx/lifecycle/LiveData;", "h", "()Landroidx/lifecycle/LiveData;", "mIsSelectAllRecord", "j", "mMultiChoiceDeleted", "i", "k", "mMultiDeleteItems", "l", "mSelectAll", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TranslatorRecordShareViewModel extends AndroidViewModel {
    public static final Companion k = new Companion((DefaultConstructorMarker) null);
    public final Application b;
    public final MutableLiveData c;
    public final MutableLiveData d;
    public final MutableLiveData e;
    public final MutableLiveData f;
    public final LiveData g;
    public final LiveData h;
    public final LiveData i;
    public final LiveData j;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/translation/phone/vm/TranslatorRecordShareViewModel$Companion;", "", "()V", "TAG", "", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslatorRecordShareViewModel(@NotNull Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, DDAuthConstant.AUTH_LOGIN_TYPE_APP);
        this.b = application;
        MutableLiveData mutableLiveData = new MutableLiveData();
        this.c = mutableLiveData;
        MutableLiveData mutableLiveData2 = new MutableLiveData();
        this.d = mutableLiveData2;
        MutableLiveData mutableLiveData3 = new MutableLiveData();
        this.e = mutableLiveData3;
        MutableLiveData mutableLiveData4 = new MutableLiveData();
        this.f = mutableLiveData4;
        Intrinsics.checkNotNull(mutableLiveData, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Boolean>");
        this.g = mutableLiveData;
        Intrinsics.checkNotNull(mutableLiveData2, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Boolean>");
        this.h = mutableLiveData2;
        Intrinsics.checkNotNull(mutableLiveData3, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.collections.List<com.upuphone.ar.translation.phone.bean.NoteBean>>");
        this.i = mutableLiveData3;
        Intrinsics.checkNotNull(mutableLiveData4, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Boolean>");
        this.j = mutableLiveData4;
    }

    public final LiveData h() {
        return this.g;
    }

    public final LiveData j() {
        return this.h;
    }

    public final LiveData k() {
        return this.i;
    }

    public final LiveData l() {
        return this.j;
    }

    public final void m(boolean z) {
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.c(), (CoroutineStart) null, new TranslatorRecordShareViewModel$notifyIsSelectAllRecord$1(this, z, (Continuation<? super TranslatorRecordShareViewModel$notifyIsSelectAllRecord$1>) null), 2, (Object) null);
    }

    public final void n(boolean z) {
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.c(), (CoroutineStart) null, new TranslatorRecordShareViewModel$notifyMultiChoiceDeleted$1(this, z, (Continuation<? super TranslatorRecordShareViewModel$notifyMultiChoiceDeleted$1>) null), 2, (Object) null);
    }

    public final void p(List list) {
        Intrinsics.checkNotNullParameter(list, "list");
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.c(), (CoroutineStart) null, new TranslatorRecordShareViewModel$notifyMultiDeleteItems$1(this, list, (Continuation<? super TranslatorRecordShareViewModel$notifyMultiDeleteItems$1>) null), 2, (Object) null);
    }

    public final void q() {
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.c(), (CoroutineStart) null, new TranslatorRecordShareViewModel$selectAll$1(this, (Continuation<? super TranslatorRecordShareViewModel$selectAll$1>) null), 2, (Object) null);
    }
}
