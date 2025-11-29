package com.upuphone.ar.translation.phone.vm;

import android.app.Activity;
import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.android.dingtalk.openauth.utils.DDAuthConstant;
import com.upuphone.ar.translation.constants.TranslatorConstants;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.R;
import com.upuphone.ar.translation.phone.bean.NoteBean;
import com.upuphone.ar.translation.phone.bean.NoteBeanExtKt;
import com.upuphone.ar.translation.phone.bean.RecordTabBean;
import com.upuphone.ar.translation.phone.fragment.TransRecordFragment;
import com.upuphone.star.common.phone.UToast;
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

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 )2\u00020\u0001:\u0001EB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u0013\u0010\u0011J#\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u0014\u0010\u0011J#\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u0015\u0010\u0011J\r\u0010\u0016\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\bJ\r\u0010\u0017\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\bJ\u0017\u0010\u001a\u001a\u00020\u00062\b\b\u0001\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010!\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u0018¢\u0006\u0004\b!\u0010\"J\u001b\u0010#\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b#\u0010$J\u0015\u0010&\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u0018¢\u0006\u0004\b&\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020/0.8\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u001a\u00104\u001a\b\u0012\u0004\u0012\u00020/0.8\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00101R\u001a\u00106\u001a\b\u0012\u0004\u0012\u00020\u00180.8\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00101R\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020/0.8\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00101R\u001d\u0010=\u001a\b\u0012\u0004\u0012\u00020/098\u0006¢\u0006\f\n\u0004\b\u0010\u0010:\u001a\u0004\b;\u0010<R\u001d\u0010@\u001a\b\u0012\u0004\u0012\u00020/098\u0006¢\u0006\f\n\u0004\b>\u0010:\u001a\u0004\b?\u0010<R\u001d\u0010B\u001a\b\u0012\u0004\u0012\u00020\u0018098\u0006¢\u0006\f\n\u0004\b\u0013\u0010:\u001a\u0004\bA\u0010<R\u001d\u0010D\u001a\b\u0012\u0004\u0012\u00020/098\u0006¢\u0006\f\n\u0004\b\u0015\u0010:\u001a\u0004\bC\u0010<¨\u0006F"}, d2 = {"Lcom/upuphone/ar/translation/phone/vm/TranslatorMainViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "Landroid/app/Application;", "app", "<init>", "(Landroid/app/Application;)V", "", "onCleared", "()V", "", "Lcom/upuphone/ar/translation/phone/bean/RecordTabBean;", "r", "()Ljava/util/List;", "Lcom/upuphone/ar/translation/phone/bean/NoteBean;", "noteBean", "recordTabs", "h", "(Lcom/upuphone/ar/translation/phone/bean/NoteBean;Ljava/util/List;)V", "delNoteBean", "j", "B", "k", "y", "A", "", "resId", "v", "(I)V", "Landroid/app/Activity;", "activity", "w", "(Landroid/app/Activity;)V", "deleteCount", "x", "(Landroid/app/Activity;I)V", "s", "(Ljava/util/List;)V", "position", "t", "b", "Landroid/app/Application;", "l", "()Landroid/app/Application;", "c", "Ljava/util/List;", "mRecordTabList", "Landroidx/lifecycle/MutableLiveData;", "", "d", "Landroidx/lifecycle/MutableLiveData;", "_mShowNotRoleVprintTip", "e", "_mNotifyRecordsDelete", "f", "_mRecordTabPosition", "g", "_mShowTelephoneUserTip", "Landroidx/lifecycle/LiveData;", "Landroidx/lifecycle/LiveData;", "p", "()Landroidx/lifecycle/LiveData;", "mShowNotRoleVprintTip", "i", "m", "mNotifyRecordsDelete", "n", "mRecordTabPosition", "q", "mShowTelephoneUserTip", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TranslatorMainViewModel extends AndroidViewModel {
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

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/translation/phone/vm/TranslatorMainViewModel$Companion;", "", "()V", "TAG", "", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslatorMainViewModel(@NotNull Application application) {
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
        Intrinsics.checkNotNull(mutableLiveData, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Boolean>");
        this.h = mutableLiveData;
        Intrinsics.checkNotNull(mutableLiveData2, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Boolean>");
        this.i = mutableLiveData2;
        Intrinsics.checkNotNull(mutableLiveData3, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Int>");
        this.j = mutableLiveData3;
        Intrinsics.checkNotNull(mutableLiveData4, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Boolean>");
        this.k = mutableLiveData4;
    }

    public final void A() {
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.c(), (CoroutineStart) null, new TranslatorMainViewModel$triggerShowTelephoneUserTip$1(this, (Continuation<? super TranslatorMainViewModel$triggerShowTelephoneUserTip$1>) null), 2, (Object) null);
    }

    public final void B(NoteBean noteBean, List list) {
        Intrinsics.checkNotNullParameter(noteBean, "noteBean");
        Intrinsics.checkNotNullParameter(list, "recordTabs");
        int transType = noteBean.getTransType();
        if (transType == 1) {
            LogExt.g("更新语音转写条目, noteBean=" + noteBean, "TranslatorMainViewModel");
            Iterator it = list.iterator();
            while (it.hasNext()) {
                RecordTabBean recordTabBean = (RecordTabBean) it.next();
                String component2 = recordTabBean.component2();
                TransRecordFragment component3 = recordTabBean.component3();
                if (!Intrinsics.areEqual((Object) component2, (Object) "simul_trans_records") && !Intrinsics.areEqual((Object) component2, (Object) "dialog_trans_records")) {
                    component3.K0(noteBean, Intrinsics.areEqual((Object) component2, (Object) "transcribe_records"));
                }
            }
        } else if (transType == 2) {
            LogExt.g("更新同传翻译条目, noteBean=" + noteBean, "TranslatorMainViewModel");
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                RecordTabBean recordTabBean2 = (RecordTabBean) it2.next();
                String component22 = recordTabBean2.component2();
                TransRecordFragment component32 = recordTabBean2.component3();
                if (!Intrinsics.areEqual((Object) component22, (Object) "transcribe_records") && !Intrinsics.areEqual((Object) component22, (Object) "dialog_trans_records")) {
                    component32.K0(noteBean, Intrinsics.areEqual((Object) component22, (Object) "simul_trans_records"));
                }
            }
        } else if (transType == 3) {
            LogExt.g("更新对话翻译条目, noteBean=" + noteBean, "TranslatorMainViewModel");
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                RecordTabBean recordTabBean3 = (RecordTabBean) it3.next();
                String component23 = recordTabBean3.component2();
                TransRecordFragment component33 = recordTabBean3.component3();
                if (!Intrinsics.areEqual((Object) component23, (Object) "simul_trans_records") && !Intrinsics.areEqual((Object) component23, (Object) "transcribe_records")) {
                    component33.K0(noteBean, Intrinsics.areEqual((Object) component23, (Object) "dialog_trans_records"));
                }
            }
        }
    }

    public final void h(NoteBean noteBean, List list) {
        Intrinsics.checkNotNullParameter(noteBean, "noteBean");
        Intrinsics.checkNotNullParameter(list, "recordTabs");
        int transType = noteBean.getTransType();
        if (transType == 1) {
            LogExt.g("start: 新增转写条目, noteBean=" + noteBean, "TranslatorMainViewModel");
            String assembleContent = NoteBeanExtKt.assembleContent(noteBean);
            if (StringsKt.isBlank(assembleContent)) {
                assembleContent = noteBean.getContent();
            }
            noteBean.setContent(assembleContent);
            noteBean.setSrcContent("");
            noteBean.setDstContent("");
            LogExt.g("end: 新增转写条目, noteBean=" + noteBean, "TranslatorMainViewModel");
            Iterator it = list.iterator();
            while (it.hasNext()) {
                RecordTabBean recordTabBean = (RecordTabBean) it.next();
                String component2 = recordTabBean.component2();
                TransRecordFragment component3 = recordTabBean.component3();
                if (!Intrinsics.areEqual((Object) component2, (Object) "simul_trans_records") && !Intrinsics.areEqual((Object) component2, (Object) "dialog_trans_records")) {
                    component3.w0(noteBean);
                }
            }
        } else if (transType == 2) {
            LogExt.g("start: 新增同传翻译条目, noteBean=" + noteBean, "TranslatorMainViewModel");
            String assembleContent2 = NoteBeanExtKt.assembleContent(noteBean);
            if (StringsKt.isBlank(assembleContent2)) {
                assembleContent2 = noteBean.getContent();
            }
            noteBean.setContent(assembleContent2);
            noteBean.setSrcContent("");
            noteBean.setDstContent("");
            LogExt.g("end: 新增同传翻译条目, noteBean=" + noteBean, "TranslatorMainViewModel");
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                RecordTabBean recordTabBean2 = (RecordTabBean) it2.next();
                String component22 = recordTabBean2.component2();
                TransRecordFragment component32 = recordTabBean2.component3();
                if (!Intrinsics.areEqual((Object) component22, (Object) "transcribe_records") && !Intrinsics.areEqual((Object) component22, (Object) "dialog_trans_records")) {
                    component32.w0(noteBean);
                }
            }
        } else if (transType == 3) {
            LogExt.g("start: 新增对话翻译条目, noteBean=" + noteBean, "TranslatorMainViewModel");
            String assembleContent3 = NoteBeanExtKt.assembleContent(noteBean);
            if (StringsKt.isBlank(assembleContent3)) {
                assembleContent3 = noteBean.getContent();
            }
            noteBean.setContent(assembleContent3);
            noteBean.setSrcContent("");
            noteBean.setDstContent("");
            LogExt.g("end: 新增对话翻译条目, noteBean=" + noteBean, "TranslatorMainViewModel");
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                RecordTabBean recordTabBean3 = (RecordTabBean) it3.next();
                String component23 = recordTabBean3.component2();
                TransRecordFragment component33 = recordTabBean3.component3();
                if (!Intrinsics.areEqual((Object) component23, (Object) "transcribe_records") && !Intrinsics.areEqual((Object) component23, (Object) "simul_trans_records")) {
                    component33.w0(noteBean);
                }
            }
        }
    }

    public final void j(NoteBean noteBean, List list) {
        Intrinsics.checkNotNullParameter(noteBean, "delNoteBean");
        Intrinsics.checkNotNullParameter(list, "recordTabs");
        int transType = noteBean.getTransType();
        if (transType == 1) {
            LogExt.g("删除语音转写条目, delNoteBean=" + noteBean, "TranslatorMainViewModel");
            Iterator it = list.iterator();
            while (it.hasNext()) {
                RecordTabBean recordTabBean = (RecordTabBean) it.next();
                String component2 = recordTabBean.component2();
                TransRecordFragment component3 = recordTabBean.component3();
                if (!Intrinsics.areEqual((Object) component2, (Object) "simul_trans_records") && !Intrinsics.areEqual((Object) component2, (Object) "dialog_trans_records")) {
                    component3.y0(noteBean, Intrinsics.areEqual((Object) component2, (Object) "transcribe_records"));
                }
            }
        } else if (transType == 2) {
            LogExt.g("删除同传翻译条目, delNoteBean=" + noteBean, "TranslatorMainViewModel");
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                RecordTabBean recordTabBean2 = (RecordTabBean) it2.next();
                String component22 = recordTabBean2.component2();
                TransRecordFragment component32 = recordTabBean2.component3();
                if (!Intrinsics.areEqual((Object) component22, (Object) "transcribe_records") && !Intrinsics.areEqual((Object) component22, (Object) "dialog_trans_records")) {
                    component32.y0(noteBean, Intrinsics.areEqual((Object) component22, (Object) "simul_trans_records"));
                }
            }
        } else if (transType == 3) {
            LogExt.g("删除对话翻译条目, delNoteBean=" + noteBean, "TranslatorMainViewModel");
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                RecordTabBean recordTabBean3 = (RecordTabBean) it3.next();
                String component23 = recordTabBean3.component2();
                TransRecordFragment component33 = recordTabBean3.component3();
                if (!Intrinsics.areEqual((Object) component23, (Object) "simul_trans_records") && !Intrinsics.areEqual((Object) component23, (Object) "transcribe_records")) {
                    component33.y0(noteBean, Intrinsics.areEqual((Object) component23, (Object) "dialog_trans_records"));
                }
            }
        }
    }

    public final void k(NoteBean noteBean, List list) {
        Intrinsics.checkNotNullParameter(noteBean, "noteBean");
        Intrinsics.checkNotNullParameter(list, "recordTabs");
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.c(), (CoroutineStart) null, new TranslatorMainViewModel$deleteRecordForDb$1(this, noteBean, list, (Continuation<? super TranslatorMainViewModel$deleteRecordForDb$1>) null), 2, (Object) null);
    }

    public final Application l() {
        return this.b;
    }

    public final LiveData m() {
        return this.i;
    }

    public final LiveData n() {
        return this.j;
    }

    public void onCleared() {
        super.onCleared();
        this.c.clear();
    }

    public final LiveData p() {
        return this.h;
    }

    public final LiveData q() {
        return this.k;
    }

    public final List r() {
        RecordTabBean recordTabBean;
        if (!this.c.isEmpty()) {
            for (RecordTabBean recordTabBean2 : this.c) {
                String tabType = recordTabBean2.getTabType();
                switch (tabType.hashCode()) {
                    case -744944220:
                        if (tabType.equals("all_records")) {
                            String string = this.b.getString(R.string.tl_record_tips);
                            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                            recordTabBean2.setTabName(string);
                            break;
                        } else {
                            break;
                        }
                    case 347469304:
                        if (tabType.equals("transcribe_records")) {
                            String string2 = this.b.getString(R.string.tl_speech_transcribe);
                            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                            recordTabBean2.setTabName(string2);
                            break;
                        } else {
                            break;
                        }
                    case 1784971508:
                        if (tabType.equals("dialog_trans_records")) {
                            String string3 = this.b.getString(R.string.tl_dialogue_trans);
                            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                            recordTabBean2.setTabName(string3);
                            break;
                        } else {
                            break;
                        }
                    case 2009189082:
                        if (tabType.equals("simul_trans_records")) {
                            String string4 = this.b.getString(R.string.tl_simul_interpret);
                            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                            recordTabBean2.setTabName(string4);
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this.c;
        }
        List list = this.c;
        String string5 = this.b.getString(R.string.tl_record_tips);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        TransRecordFragment.Companion companion = TransRecordFragment.h;
        list.add(new RecordTabBean(string5, "all_records", companion.a("all_records")));
        List list2 = this.c;
        String string6 = this.b.getString(R.string.tl_simul_interpret);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
        list2.add(new RecordTabBean(string6, "simul_trans_records", companion.a("simul_trans_records")));
        List list3 = this.c;
        if (TranslatorConstants.isAirPro()) {
            String string7 = this.b.getString(R.string.tl_dialogue_trans);
            Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
            recordTabBean = new RecordTabBean(string7, "dialog_trans_records", companion.a("dialog_trans_records"));
        } else {
            String string8 = this.b.getString(R.string.tl_speech_transcribe);
            Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
            recordTabBean = new RecordTabBean(string8, "transcribe_records", companion.a("transcribe_records"));
        }
        list3.add(recordTabBean);
        return this.c;
    }

    public final void s(List list) {
        Intrinsics.checkNotNullParameter(list, "recordTabs");
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.c(), (CoroutineStart) null, new TranslatorMainViewModel$notifyAllRecordData$1(list, (Continuation<? super TranslatorMainViewModel$notifyAllRecordData$1>) null), 2, (Object) null);
    }

    public final void t(int i2) {
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.c(), (CoroutineStart) null, new TranslatorMainViewModel$notifyRecordTabPosition$1(this, i2, (Continuation<? super TranslatorMainViewModel$notifyRecordTabPosition$1>) null), 2, (Object) null);
    }

    public final void v(int i2) {
        UToast.Companion companion = UToast.f6444a;
        Application application = this.b;
        String string = application.getString(i2);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        companion.e(application, string, 0);
    }

    public final void w(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.c(), (CoroutineStart) null, new TranslatorMainViewModel$shareDebugAudio$1(activity, (Continuation<? super TranslatorMainViewModel$shareDebugAudio$1>) null), 2, (Object) null);
    }

    public final void x(Activity activity, int i2) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.c(), (CoroutineStart) null, new TranslatorMainViewModel$showRecordDeleteDialog$1(this, i2, activity, (Continuation<? super TranslatorMainViewModel$showRecordDeleteDialog$1>) null), 2, (Object) null);
    }

    public final void y() {
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.c(), (CoroutineStart) null, new TranslatorMainViewModel$triggerShowNotRoleVprintTip$1(this, (Continuation<? super TranslatorMainViewModel$triggerShowNotRoleVprintTip$1>) null), 2, (Object) null);
    }
}
