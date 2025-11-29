package com.upuphone.ar.translation.phone.helper;

import android.content.Context;
import com.upuphone.ar.translation.ext.InterconnectMsgCodExtKt;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.R;
import com.upuphone.ar.translation.phone.bean.NoteBean;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u00011B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\bJ\u0015\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\rJ\u0015\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\n0 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\n0 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010\"R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00100&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00100&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010(R\u0016\u0010-\u001a\u00020+8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010,R\u0016\u00100\u001a\u00020.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010/¨\u00062"}, d2 = {"Lcom/upuphone/ar/translation/phone/helper/RecordTitleHelper;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "i", "()V", "k", "Lcom/upuphone/ar/translation/phone/bean/NoteBean;", "noteBean", "e", "(Lcom/upuphone/ar/translation/phone/bean/NoteBean;)V", "l", "f", "", "transType", "", "h", "(I)Ljava/lang/String;", "", "g", "()Ljava/util/List;", "numStr", "", "j", "(Ljava/lang/String;)Z", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "", "b", "Ljava/util/List;", "mSimulRecordList", "c", "mDialogueRecordList", "", "d", "Ljava/util/Set;", "mSourceSet", "mTargetSet", "Lkotlinx/coroutines/CompletableJob;", "Lkotlinx/coroutines/CompletableJob;", "mIoJob", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "mIoCoroutineScope", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class RecordTitleHelper {
    public static final Companion h = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final Context f6302a;
    public List b = new ArrayList();
    public List c = new ArrayList();
    public Set d = new LinkedHashSet();
    public Set e = new LinkedHashSet();
    public CompletableJob f = SupervisorKt.b((Job) null, 1, (Object) null);
    public CoroutineScope g = CoroutineScopeKt.a(Dispatchers.b().plus(this.f));

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/translation/phone/helper/RecordTitleHelper$Companion;", "", "()V", "TAG", "", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public RecordTitleHelper(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f6302a = context;
    }

    public final void e(NoteBean noteBean) {
        Intrinsics.checkNotNullParameter(noteBean, "noteBean");
        LogExt.j("addRecordTitle noteBean=" + noteBean, "RecordTitleHelper");
        int transType = noteBean.getTransType();
        if (g().contains(Integer.valueOf(transType))) {
            if (transType == 2) {
                List list = this.b;
                NoteBean noteBean2 = new NoteBean();
                noteBean2.setId(noteBean.getId());
                noteBean2.setTitle(noteBean.getTitle());
                Unit unit = Unit.INSTANCE;
                list.add(0, noteBean2);
                return;
            }
            List list2 = this.c;
            NoteBean noteBean3 = new NoteBean();
            noteBean3.setId(noteBean.getId());
            noteBean3.setTitle(noteBean.getTitle());
            Unit unit2 = Unit.INSTANCE;
            list2.add(0, noteBean3);
        }
    }

    public final void f(NoteBean noteBean) {
        Intrinsics.checkNotNullParameter(noteBean, "noteBean");
        LogExt.j("deleteRecordTitle noteBean=" + noteBean, "RecordTitleHelper");
        int transType = noteBean.getTransType();
        if (g().contains(Integer.valueOf(transType))) {
            int i = 0;
            if (transType == 2) {
                for (NoteBean id : this.b) {
                    int i2 = i + 1;
                    if (noteBean.getId() == id.getId()) {
                        this.b.remove(i);
                        return;
                    }
                    i = i2;
                }
                return;
            }
            for (NoteBean id2 : this.c) {
                int i3 = i + 1;
                if (noteBean.getId() == id2.getId()) {
                    this.c.remove(i);
                    return;
                }
                i = i3;
            }
        }
    }

    public final List g() {
        return CollectionsKt.arrayListOf(2, 3);
    }

    public final String h(int i) {
        LogExt.j("getTitle transType=" + InterconnectMsgCodExtKt.k(i), "RecordTitleHelper");
        if (!g().contains(Integer.valueOf(i))) {
            return "";
        }
        this.d.clear();
        this.e.clear();
        if (i == 2) {
            String str = this.f6302a.getString(R.string.tl_simul_interpret) + " ";
            int i2 = 0;
            for (NoteBean title : this.b) {
                i2++;
                this.d.add(Integer.valueOf(i2));
                String title2 = title.getTitle();
                if (StringsKt.startsWith$default(title2, str, false, 2, (Object) null)) {
                    String substring = title2.substring(str.length());
                    Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                    if (j(substring)) {
                        this.e.add(Integer.valueOf(Integer.parseInt(substring)));
                    }
                }
            }
            if (this.d.isEmpty()) {
                return str + "1";
            }
            LogExt.j("getTitle mSourceSet[" + this.d + "], mTargetSet[" + this.e + "]", "RecordTitleHelper");
            List sorted = CollectionsKt.sorted(CollectionsKt.subtract(this.d, this.e));
            if (sorted.isEmpty()) {
                List sorted2 = CollectionsKt.sorted(this.d);
                return str + (((Number) sorted2.get(CollectionsKt.getLastIndex(sorted2))).intValue() + 1);
            }
            return str + sorted.get(0);
        }
        String str2 = this.f6302a.getString(R.string.tl_dialogue_trans) + " ";
        int i3 = 0;
        for (NoteBean title3 : this.c) {
            i3++;
            this.d.add(Integer.valueOf(i3));
            String title4 = title3.getTitle();
            if (StringsKt.startsWith$default(title4, str2, false, 2, (Object) null)) {
                String substring2 = title4.substring(str2.length());
                Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                if (j(substring2)) {
                    this.e.add(Integer.valueOf(Integer.parseInt(substring2)));
                }
            }
        }
        if (this.d.isEmpty()) {
            return str2 + "1";
        }
        List sorted3 = CollectionsKt.sorted(CollectionsKt.subtract(this.d, this.e));
        if (sorted3.isEmpty()) {
            List sorted4 = CollectionsKt.sorted(this.d);
            return str2 + (((Number) sorted4.get(CollectionsKt.getLastIndex(sorted4))).intValue() + 1);
        }
        return str2 + sorted3.get(0);
    }

    public final void i() {
        Job unused = BuildersKt__Builders_commonKt.d(this.g, (CoroutineContext) null, (CoroutineStart) null, new RecordTitleHelper$init$1(this, (Continuation<? super RecordTitleHelper$init$1>) null), 3, (Object) null);
    }

    public final boolean j(String str) {
        return !StringsKt.isBlank(str) && new Regex("\\d+").matches(str) && Integer.parseInt(str) > 0;
    }

    public final void k() {
        this.b.clear();
        this.c.clear();
        this.d.clear();
        this.e.clear();
        Job.DefaultImpls.a(this.f, (CancellationException) null, 1, (Object) null);
        CoroutineScopeKt.e(this.g, (CancellationException) null, 1, (Object) null);
    }

    public final void l(NoteBean noteBean) {
        Intrinsics.checkNotNullParameter(noteBean, "noteBean");
        LogExt.j("updateRecordTitle noteBean=" + noteBean, "RecordTitleHelper");
        int transType = noteBean.getTransType();
        if (g().contains(Integer.valueOf(transType))) {
            int i = 0;
            if (transType == 2) {
                for (NoteBean noteBean2 : this.b) {
                    int i2 = i + 1;
                    if (noteBean.getId() == noteBean2.getId()) {
                        noteBean2.setTitle(noteBean.getTitle());
                        this.b.set(i, noteBean2);
                        return;
                    }
                    i = i2;
                }
                return;
            }
            for (NoteBean noteBean3 : this.c) {
                int i3 = i + 1;
                if (noteBean.getId() == noteBean3.getId()) {
                    noteBean3.setTitle(noteBean.getTitle());
                    this.c.set(i, noteBean3);
                    return;
                }
                i = i3;
            }
        }
    }
}
