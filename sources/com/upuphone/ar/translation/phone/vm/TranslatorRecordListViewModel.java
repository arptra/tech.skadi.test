package com.upuphone.ar.translation.phone.vm;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.android.dingtalk.openauth.utils.DDAuthConstant;
import com.upuphone.ar.fastrecord.phone.ui.fragment.FastRecordFragment;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.R;
import com.upuphone.ar.translation.phone.bean.NoteBean;
import com.upuphone.ar.translation.phone.helper.NoteSyncHelper;
import com.upuphone.ar.translation.phone.helper.TranslatorLitePalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00162\u00020\u0001:\u0001/B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u001b\u001a\u00020\u00062\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\t0!8\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020\t0%8\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001d\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006¢\u0006\f\n\u0004\b\u0018\u0010+\u001a\u0004\b,\u0010-¨\u00060"}, d2 = {"Lcom/upuphone/ar/translation/phone/vm/TranslatorRecordListViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "Landroid/app/Application;", "app", "<init>", "(Landroid/app/Application;)V", "", "onCleared", "()V", "", "isChoice", "k", "(Z)V", "", "recordType", "", "pageSize", "itemCount", "", "Lcom/upuphone/ar/translation/phone/bean/NoteBean;", "g", "(Ljava/lang/String;II)Ljava/util/List;", "f", "(Ljava/lang/String;)I", "e", "(Ljava/lang/String;I)I", "list", "l", "(Ljava/util/List;)V", "b", "Landroid/app/Application;", "getApp", "()Landroid/app/Application;", "Landroidx/lifecycle/MutableLiveData;", "c", "Landroidx/lifecycle/MutableLiveData;", "_mRecoverMultiChoiceDeleted", "Landroidx/lifecycle/LiveData;", "d", "Landroidx/lifecycle/LiveData;", "h", "()Landroidx/lifecycle/LiveData;", "mRecoverMultiChoiceDeleted", "Ljava/util/List;", "j", "()Ljava/util/List;", "mRecoverRecordList", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TranslatorRecordListViewModel extends AndroidViewModel {
    public static final Companion f = new Companion((DefaultConstructorMarker) null);
    public final Application b;
    public final MutableLiveData c;
    public final LiveData d;
    public final List e = new ArrayList();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/translation/phone/vm/TranslatorRecordListViewModel$Companion;", "", "()V", "TAG", "", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslatorRecordListViewModel(@NotNull Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, DDAuthConstant.AUTH_LOGIN_TYPE_APP);
        this.b = application;
        MutableLiveData mutableLiveData = new MutableLiveData();
        this.c = mutableLiveData;
        Intrinsics.checkNotNull(mutableLiveData, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Boolean>");
        this.d = mutableLiveData;
    }

    public final int e(String str, int i) {
        NoteBean j = NoteSyncHelper.j();
        if (j == null) {
            return i;
        }
        int i2 = 1;
        if (Intrinsics.areEqual((Object) str, (Object) "all_records")) {
            return i + 1;
        }
        if (Intrinsics.areEqual((Object) str, (Object) "simul_trans_records")) {
            i2 = 2;
        } else if (Intrinsics.areEqual((Object) str, (Object) "dialog_trans_records")) {
            i2 = 3;
        }
        return j.getTransType() == i2 ? i + 1 : i;
    }

    public final int f(String str) {
        Intrinsics.checkNotNullParameter(str, FastRecordFragment.RECORD_TYPE);
        int hashCode = str.hashCode();
        if (hashCode != 347469304) {
            if (hashCode != 1784971508) {
                if (hashCode == 2009189082 && str.equals("simul_trans_records")) {
                    return TranslatorLitePalHelper.f6309a.e(2);
                }
            } else if (str.equals("dialog_trans_records")) {
                return TranslatorLitePalHelper.f6309a.e(3);
            }
        } else if (str.equals("transcribe_records")) {
            return TranslatorLitePalHelper.f6309a.e(1);
        }
        return TranslatorLitePalHelper.f6309a.d();
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x009d A[LOOP:0: B:17:0x0097->B:19:0x009d, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00c1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List g(java.lang.String r6, int r7, int r8) {
        /*
            r5 = this;
            r0 = 1
            java.lang.String r1 = "recordType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r1)
            int r8 = r5.e(r6, r8)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "getDiaryFromDB "
            r1.append(r2)
            r1.append(r6)
            java.lang.String r3 = " loadOffset="
            r1.append(r3)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            java.lang.String r3 = "TransRecordFragment"
            com.upuphone.ar.translation.ext.LogExt.j(r1, r3)
            int r1 = r6.hashCode()
            r4 = 347469304(0x14b5f5f8, float:1.8373347E-26)
            if (r1 == r4) goto L_0x005e
            r4 = 1784971508(0x6a6480f4, float:6.9061013E25)
            if (r1 == r4) goto L_0x004d
            r4 = 2009189082(0x77c1cada, float:7.861153E33)
            if (r1 == r4) goto L_0x003c
            goto L_0x0067
        L_0x003c:
            java.lang.String r1 = "simul_trans_records"
            boolean r1 = r6.equals(r1)
            if (r1 != 0) goto L_0x0045
            goto L_0x0067
        L_0x0045:
            com.upuphone.ar.translation.phone.helper.TranslatorLitePalHelper r1 = com.upuphone.ar.translation.phone.helper.TranslatorLitePalHelper.f6309a
            r4 = 2
            java.util.List r7 = r1.i(r4, r7, r8)
            goto L_0x0074
        L_0x004d:
            java.lang.String r1 = "dialog_trans_records"
            boolean r1 = r6.equals(r1)
            if (r1 != 0) goto L_0x0056
            goto L_0x0067
        L_0x0056:
            com.upuphone.ar.translation.phone.helper.TranslatorLitePalHelper r1 = com.upuphone.ar.translation.phone.helper.TranslatorLitePalHelper.f6309a
            r4 = 3
            java.util.List r7 = r1.i(r4, r7, r8)
            goto L_0x0074
        L_0x005e:
            java.lang.String r1 = "transcribe_records"
            boolean r1 = r6.equals(r1)
            if (r1 != 0) goto L_0x006e
        L_0x0067:
            com.upuphone.ar.translation.phone.helper.TranslatorLitePalHelper r1 = com.upuphone.ar.translation.phone.helper.TranslatorLitePalHelper.f6309a
            java.util.List r7 = r1.h(r7, r8)
            goto L_0x0074
        L_0x006e:
            com.upuphone.ar.translation.phone.helper.TranslatorLitePalHelper r1 = com.upuphone.ar.translation.phone.helper.TranslatorLitePalHelper.f6309a
            java.util.List r7 = r1.i(r0, r7, r8)
        L_0x0074:
            int r8 = r7.size()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r2)
            r1.append(r6)
            java.lang.String r6 = ", record size="
            r1.append(r6)
            r1.append(r8)
            java.lang.String r6 = r1.toString()
            com.upuphone.ar.translation.ext.LogExt.g(r6, r3)
            java.util.Iterator r6 = r7.iterator()
            r8 = 0
        L_0x0097:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L_0x00bb
            int r1 = r8 + 1
            java.lang.Object r2 = r6.next()
            com.upuphone.ar.translation.phone.bean.NoteBean r2 = (com.upuphone.ar.translation.phone.bean.NoteBean) r2
            java.lang.String r3 = com.upuphone.ar.translation.phone.bean.NoteBeanExtKt.assembleContent(r2)
            r2.setContent(r3)
            java.lang.String r3 = ""
            r2.setSrcContent(r3)
            r2.setDstContent(r3)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r7.set(r8, r2)
            r8 = r1
            goto L_0x0097
        L_0x00bb:
            boolean r6 = com.upuphone.ar.translation.constants.TranslatorConstants.isAirPro()
            if (r6 == 0) goto L_0x00c4
            r5.l(r7)
        L_0x00c4:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.phone.vm.TranslatorRecordListViewModel.g(java.lang.String, int, int):java.util.List");
    }

    public final LiveData h() {
        return this.d;
    }

    public final List j() {
        return this.e;
    }

    public final void k(boolean z) {
        LogExt.j("notifyRecoverMultiChoiceDeleted isChoice=" + z, "TransRecordFragment");
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.c(), (CoroutineStart) null, new TranslatorRecordListViewModel$notifyRecoverMultiChoiceDeleted$1(this, z, (Continuation<? super TranslatorRecordListViewModel$notifyRecoverMultiChoiceDeleted$1>) null), 2, (Object) null);
    }

    public final void l(List list) {
        String str;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            NoteBean noteBean = (NoteBean) it.next();
            if (!(!StringsKt.isBlank(noteBean.getTitle()))) {
                int transType = noteBean.getTransType();
                if (transType == 2) {
                    str = this.b.getString(R.string.tl_simul_interpret);
                    Intrinsics.checkNotNull(str);
                } else if (transType != 3) {
                    str = "";
                } else {
                    str = this.b.getString(R.string.tl_dialogue_trans);
                    Intrinsics.checkNotNull(str);
                }
                noteBean.setTitle(str);
            }
        }
    }

    public void onCleared() {
        super.onCleared();
        this.e.clear();
    }
}
