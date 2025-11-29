package com.upuphone.ar.translation.phone.helper;

import android.content.Context;
import com.upuphone.ar.translation.TranslationApp;
import com.upuphone.ar.translation.ext.InterconnectMsgCodExtKt;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.interconnect.entity.TranslationState;
import com.upuphone.ar.translation.phone.bean.DialogueRunning;
import com.upuphone.ar.translation.phone.bean.OperateMessage;
import com.upuphone.ar.translation.phone.bean.SimulRunning;
import com.upuphone.ar.translation.utils.DateUtils;
import com.upuphone.ar.translation.utils.GsonUtils;
import com.upuphone.ar.translation.utils.PreferencesUtils;
import com.xjsd.xr.sapp.asr.dao.AsrResult;
import com.xjsd.xr.sapp.asr.dao.Dst;
import com.xjsd.xr.sapp.asr.dao.Src;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001e2\u00020\u0001:\u0001WB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0014¢\u0006\u0004\b\u0019\u0010\u0017J\u0017\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001e\u0010\u001cJ\u000f\u0010\u001f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001f\u0010\bJ\u000f\u0010 \u001a\u00020\u0006H\u0002¢\u0006\u0004\b \u0010\bJ\u0017\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0006H\u0002¢\u0006\u0004\b%\u0010\bJ\u0019\u0010'\u001a\u00020\u00062\b\u0010&\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\b'\u0010(J#\u0010,\u001a\u00020\u00062\b\u0010*\u001a\u0004\u0018\u00010)2\b\u0010+\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0004\b,\u0010-J\u0017\u0010/\u001a\u00020\u00062\u0006\u0010.\u001a\u00020!H\u0002¢\u0006\u0004\b/\u0010$J'\u00102\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00152\u0006\u0010.\u001a\u00020!2\u0006\u00101\u001a\u00020\rH\u0002¢\u0006\u0004\b2\u00103J'\u00105\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00152\u0006\u0010.\u001a\u00020!2\u0006\u00104\u001a\u00020\rH\u0002¢\u0006\u0004\b5\u00103J\u000f\u00106\u001a\u00020\u0006H\u0002¢\u0006\u0004\b6\u0010\bJ\u0017\u00109\u001a\u00020\u00062\u0006\u00108\u001a\u000207H\u0002¢\u0006\u0004\b9\u0010:J'\u0010;\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00152\u0006\u00108\u001a\u0002072\u0006\u00104\u001a\u00020\rH\u0002¢\u0006\u0004\b;\u0010<J'\u0010=\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00152\u0006\u00108\u001a\u0002072\u0006\u00101\u001a\u00020\rH\u0002¢\u0006\u0004\b=\u0010<J\u000f\u0010>\u001a\u00020\u0006H\u0002¢\u0006\u0004\b>\u0010\bJ\u000f\u0010?\u001a\u00020\u0006H\u0002¢\u0006\u0004\b?\u0010\bJ\u0019\u0010A\u001a\u00020\u00062\b\u0010@\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\bA\u0010BR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\bA\u0010C\u001a\u0004\bD\u0010ER\u0018\u0010G\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010FR\u0018\u0010H\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b>\u0010FR\u001c\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u0010IR\u0016\u0010L\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010KR\u0016\u0010M\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010KR\u0018\u0010O\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u0010NR\u001c\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00180\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010IR\u0016\u0010S\u001a\u00020Q8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u0010RR\u0016\u0010V\u001a\u00020T8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010U¨\u0006X"}, d2 = {"Lcom/upuphone/ar/translation/phone/helper/RunningRecordHelper;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "o", "()V", "Lcom/upuphone/ar/translation/interconnect/entity/TranslationState;", "translationState", "p", "(Lcom/upuphone/ar/translation/interconnect/entity/TranslationState;)V", "", "transType", "", "proximalJson", "remoteJson", "q", "(ILjava/lang/String;Ljava/lang/String;)V", "", "Lcom/upuphone/ar/translation/phone/bean/DialogueRunning;", "e", "()Ljava/util/List;", "Lcom/upuphone/ar/translation/phone/bean/SimulRunning;", "f", "transState", "l", "(I)V", "extCode", "k", "v", "w", "Lcom/xjsd/xr/sapp/asr/dao/Dst;", "asrDst", "j", "(Lcom/xjsd/xr/sapp/asr/dao/Dst;)V", "n", "simulItemBean", "b", "(Lcom/upuphone/ar/translation/phone/bean/SimulRunning;)V", "Lcom/xjsd/xr/sapp/asr/dao/AsrResult;", "proximalResult", "remoteResult", "h", "(Lcom/xjsd/xr/sapp/asr/dao/AsrResult;Lcom/xjsd/xr/sapp/asr/dao/AsrResult;)V", "dst", "g", "itemBean", "remoteIndex", "t", "(Lcom/upuphone/ar/translation/phone/bean/DialogueRunning;Lcom/xjsd/xr/sapp/asr/dao/Dst;I)V", "proximalIndex", "u", "d", "Lcom/xjsd/xr/sapp/asr/dao/Src;", "src", "i", "(Lcom/xjsd/xr/sapp/asr/dao/Src;)V", "r", "(Lcom/upuphone/ar/translation/phone/bean/DialogueRunning;Lcom/xjsd/xr/sapp/asr/dao/Src;I)V", "s", "c", "m", "dialogueRunning", "a", "(Lcom/upuphone/ar/translation/phone/bean/DialogueRunning;)V", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lcom/upuphone/ar/translation/phone/bean/DialogueRunning;", "mProximalItemBean", "mRemoteItemBean", "Ljava/util/List;", "mDialogueDataList", "I", "mProximalBreakLine", "mRemoteBreakLine", "Lcom/upuphone/ar/translation/phone/bean/SimulRunning;", "mSimulItemBean", "mSimulDataList", "", "Z", "mIsShowTransSrc", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mIsSimulLineBreak", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class RunningRecordHelper {
    public static final Companion k = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final Context f6303a;
    public DialogueRunning b;
    public DialogueRunning c;
    public List d = new ArrayList();
    public int e;
    public int f;
    public SimulRunning g;
    public List h = new ArrayList();
    public boolean i;
    public AtomicBoolean j = new AtomicBoolean(false);

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/upuphone/ar/translation/phone/helper/RunningRecordHelper$Companion;", "", "()V", "LINE_BREAK", "", "NO_LINE_BREAK", "TAG", "", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public RunningRecordHelper(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f6303a = context;
    }

    public final void a(DialogueRunning dialogueRunning) {
        if (dialogueRunning == null) {
            return;
        }
        if (dialogueRunning.getItemUpdateType() == 1) {
            LogExt.g("Dialogue add[" + dialogueRunning + "]", "RunningRecordHelper");
            this.d.add(dialogueRunning);
            TranslationApp.notifyVariousMsg$ar_translator_intlRelease(new OperateMessage(1003, dialogueRunning));
            return;
        }
        for (IndexedValue indexedValue : CollectionsKt.reversed(CollectionsKt.withIndex(this.d))) {
            int component1 = indexedValue.component1();
            DialogueRunning dialogueRunning2 = (DialogueRunning) indexedValue.component2();
            if (dialogueRunning.getItemUpdateIndex() == dialogueRunning2.getItemUpdateIndex()) {
                LogExt.g("Dialogue update[" + dialogueRunning + "], original=" + dialogueRunning2, "RunningRecordHelper");
                this.d.set(component1, dialogueRunning);
                TranslationApp.notifyVariousMsg$ar_translator_intlRelease(new OperateMessage(1003, dialogueRunning));
                return;
            }
        }
    }

    public final void b(SimulRunning simulRunning) {
        if (simulRunning == null) {
            return;
        }
        if (simulRunning.getItemUpdateType() == 1) {
            LogExt.g("Simul add[" + simulRunning + "]", "RunningRecordHelper");
            this.h.add(simulRunning);
            TranslationApp.notifyVariousMsg$ar_translator_intlRelease(new OperateMessage(1004, simulRunning));
            return;
        }
        for (IndexedValue indexedValue : CollectionsKt.reversed(CollectionsKt.withIndex(this.h))) {
            int component1 = indexedValue.component1();
            SimulRunning simulRunning2 = (SimulRunning) indexedValue.component2();
            if (simulRunning.getItemUpdateIndex() == simulRunning2.getItemUpdateIndex()) {
                LogExt.g("Simul update[" + simulRunning + "], original=" + simulRunning2, "RunningRecordHelper");
                this.h.set(component1, simulRunning);
                TranslationApp.notifyVariousMsg$ar_translator_intlRelease(new OperateMessage(1004, simulRunning));
                return;
            }
        }
    }

    public final void c() {
        DialogueRunning dialogueRunning = this.b;
        if (dialogueRunning != null && (!StringsKt.isBlank(dialogueRunning.getText())) && StringsKt.isBlank(dialogueRunning.getTempText())) {
            DialogueRunning dialogueRunning2 = new DialogueRunning(1, dialogueRunning.getText(), dialogueRunning.getTempText(), 2, dialogueRunning.getItemUpdateIndex(), true, 0, 64, (DefaultConstructorMarker) null);
            this.b = dialogueRunning2;
            a(dialogueRunning2);
        }
    }

    public final void d() {
        DialogueRunning dialogueRunning = this.c;
        if (dialogueRunning != null && (!StringsKt.isBlank(dialogueRunning.getText())) && StringsKt.isBlank(dialogueRunning.getTempText())) {
            DialogueRunning dialogueRunning2 = new DialogueRunning(2, dialogueRunning.getText(), dialogueRunning.getTempText(), 2, dialogueRunning.getItemUpdateIndex(), true, 0, 64, (DefaultConstructorMarker) null);
            this.c = dialogueRunning2;
            a(dialogueRunning2);
        }
    }

    public final List e() {
        return this.d;
    }

    public final List f() {
        return this.h;
    }

    public final void g(Dst dst) {
        Unit unit;
        String str;
        String str2;
        DialogueRunning dialogueRunning = this.b;
        if (dialogueRunning != null) {
            DialogueRunning dialogueRunning2 = this.c;
            int itemUpdateIndex = dialogueRunning2 != null ? dialogueRunning2.getItemUpdateIndex() : -1;
            int itemUpdateIndex2 = dialogueRunning.getItemUpdateIndex();
            if (itemUpdateIndex == -1 || itemUpdateIndex <= itemUpdateIndex2) {
                u(dialogueRunning, dst, itemUpdateIndex2);
            } else {
                t(dialogueRunning, dst, itemUpdateIndex);
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            if (dst.getType() == 0) {
                str2 = dst.getContent();
                str = "";
            } else {
                str = dst.getContent();
                str2 = "";
            }
            DialogueRunning dialogueRunning3 = this.c;
            this.b = new DialogueRunning(1, str2, str, 1, dialogueRunning3 != null ? dialogueRunning3.getItemUpdateIndex() + 1 : 0, false, 0, 96, (DefaultConstructorMarker) null);
        }
        a(this.b);
    }

    public final void h(AsrResult asrResult, AsrResult asrResult2) {
        Src src;
        Dst dst;
        if (!(asrResult == null || (dst = asrResult.getDst()) == null)) {
            g(dst);
        }
        if (asrResult2 != null && (src = asrResult2.getSrc()) != null) {
            i(src);
        }
    }

    public final void i(Src src) {
        Unit unit;
        String str;
        String str2;
        DialogueRunning dialogueRunning = this.c;
        if (dialogueRunning != null) {
            DialogueRunning dialogueRunning2 = this.b;
            int itemUpdateIndex = dialogueRunning2 != null ? dialogueRunning2.getItemUpdateIndex() : -1;
            int itemUpdateIndex2 = dialogueRunning.getItemUpdateIndex();
            if (itemUpdateIndex == -1 || itemUpdateIndex <= itemUpdateIndex2) {
                s(dialogueRunning, src, itemUpdateIndex2);
            } else {
                r(dialogueRunning, src, itemUpdateIndex);
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            if (src.getType() == 0) {
                str2 = src.getContent();
                str = "";
            } else {
                str = src.getContent();
                str2 = "";
            }
            DialogueRunning dialogueRunning3 = this.b;
            this.c = new DialogueRunning(2, str2, str, 1, dialogueRunning3 != null ? dialogueRunning3.getItemUpdateIndex() + 1 : 0, false, 0, 96, (DefaultConstructorMarker) null);
        }
        a(this.c);
    }

    public final void j(Dst dst) {
        Unit unit;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        SimulRunning simulRunning = this.g;
        if (simulRunning != null) {
            if (dst.getType() == 0) {
                String str9 = simulRunning.getSrc() + dst.getFinalSrc();
                str6 = "";
                str5 = str6;
                str8 = str9;
                str7 = simulRunning.getDst() + dst.getContent();
            } else {
                String src = simulRunning.getSrc();
                str8 = src;
                str6 = dst.getFinalSrc();
                str7 = simulRunning.getDst();
                str5 = dst.getContent();
            }
            SimulRunning simulRunning2 = new SimulRunning(str8, str7, str6, str5, 2, simulRunning.getItemUpdateIndex(), simulRunning.isDisplaySrc(), simulRunning.getRecordTime());
            b(simulRunning2);
            this.g = simulRunning2;
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            if (dst.getType() == 0) {
                str4 = dst.getFinalSrc();
                str2 = "";
                str = str2;
                str3 = dst.getContent();
            } else {
                str2 = dst.getFinalSrc();
                str4 = "";
                str3 = str4;
                str = dst.getContent();
            }
            SimulRunning simulRunning3 = new SimulRunning(str4, str3, str2, str, 1, 0, this.i, DateUtils.e());
            b(simulRunning3);
            this.g = simulRunning3;
        }
    }

    public final void k(int i2) {
        if (InterconnectMsgCodExtKt.d(i2)) {
            w();
        } else if (i2 == 14 || i2 == 19) {
            m();
            n();
        }
    }

    public final void l(int i2) {
        if (i2 == 2) {
            w();
        } else if (i2 == 4) {
            v();
            o();
        }
    }

    public final void m() {
        DialogueRunning dialogueRunning = this.b;
        int i2 = 0;
        if (dialogueRunning != null) {
            DialogueRunning dialogueRunning2 = this.c;
            int itemUpdateIndex = dialogueRunning2 != null ? dialogueRunning2.getItemUpdateIndex() : 0;
            int itemUpdateIndex2 = dialogueRunning.getItemUpdateIndex();
            if (itemUpdateIndex <= itemUpdateIndex2 && !StringsKt.isBlank(dialogueRunning.getText())) {
                if (!StringsKt.isBlank(dialogueRunning.getTempText())) {
                    a(new DialogueRunning(dialogueRunning.getSpeaker(), dialogueRunning.getText(), "", 2, dialogueRunning.getItemUpdateIndex(), true, 0, 64, (DefaultConstructorMarker) null));
                    DialogueRunning dialogueRunning3 = new DialogueRunning(1, "", dialogueRunning.getTempText(), 1, itemUpdateIndex2 + 1, false, 0, 96, (DefaultConstructorMarker) null);
                    this.b = dialogueRunning3;
                    a(dialogueRunning3);
                } else {
                    a(new DialogueRunning(dialogueRunning.getSpeaker(), dialogueRunning.getText(), dialogueRunning.getTempText(), 2, dialogueRunning.getItemUpdateIndex(), true, 0, 64, (DefaultConstructorMarker) null));
                    this.e = 1;
                }
            }
        }
        DialogueRunning dialogueRunning4 = this.c;
        if (dialogueRunning4 != null) {
            int itemUpdateIndex3 = dialogueRunning4.getItemUpdateIndex();
            DialogueRunning dialogueRunning5 = this.b;
            if (dialogueRunning5 != null) {
                i2 = dialogueRunning5.getItemUpdateIndex();
            }
            if (i2 <= itemUpdateIndex3) {
                int i3 = itemUpdateIndex3 + 1;
                if (!StringsKt.isBlank(dialogueRunning4.getText())) {
                    if (!StringsKt.isBlank(dialogueRunning4.getTempText())) {
                        a(new DialogueRunning(dialogueRunning4.getSpeaker(), dialogueRunning4.getText(), "", 2, dialogueRunning4.getItemUpdateIndex(), true, 0, 64, (DefaultConstructorMarker) null));
                        DialogueRunning dialogueRunning6 = new DialogueRunning(2, "", dialogueRunning4.getTempText(), 1, i3, false, 0, 96, (DefaultConstructorMarker) null);
                        this.c = dialogueRunning6;
                        a(dialogueRunning6);
                        return;
                    }
                    a(new DialogueRunning(dialogueRunning4.getSpeaker(), dialogueRunning4.getText(), dialogueRunning4.getTempText(), 2, dialogueRunning4.getItemUpdateIndex(), true, 0, 64, (DefaultConstructorMarker) null));
                    this.f = 1;
                }
            }
        }
    }

    public final void n() {
        SimulRunning simulRunning = this.g;
        if (simulRunning != null && !this.j.get() && !StringsKt.isBlank(simulRunning.getSrc())) {
            this.j.set(true);
            b(new SimulRunning(simulRunning.getSrc(), simulRunning.getDst(), "", "", 2, simulRunning.getItemUpdateIndex(), simulRunning.isDisplaySrc(), simulRunning.getRecordTime()));
            SimulRunning simulRunning2 = new SimulRunning("", "", simulRunning.getTempSrc(), simulRunning.getTempDst(), 1, simulRunning.getItemUpdateIndex() + 1, this.i, DateUtils.e());
            b(simulRunning2);
            this.g = simulRunning2;
            this.j.set(false);
        }
    }

    public final void o() {
        this.i = PreferencesUtils.n() == 3;
    }

    public final void p(TranslationState translationState) {
        Intrinsics.checkNotNullParameter(translationState, "translationState");
        int transState = translationState.getTransState();
        int extCode = translationState.getExtCode();
        if (extCode == -1) {
            l(transState);
        } else {
            k(extCode);
        }
    }

    public final void q(int i2, String str, String str2) {
        Class<AsrResult> cls = AsrResult.class;
        if (str != null) {
            h((AsrResult) GsonUtils.a(str, cls), (AsrResult) null);
        }
        if (str2 != null) {
            AsrResult asrResult = (AsrResult) GsonUtils.a(str2, cls);
            if (i2 == 2) {
                Dst dst = asrResult.getDst();
                if (dst != null) {
                    j(dst);
                    return;
                }
                return;
            }
            h((AsrResult) null, asrResult);
        }
    }

    public final void r(DialogueRunning dialogueRunning, Src src, int i2) {
        String text;
        String str;
        String str2;
        String str3 = "";
        if (!StringsKt.isBlank(dialogueRunning.getText())) {
            a(new DialogueRunning(dialogueRunning.getSpeaker(), dialogueRunning.getText(), "", 2, dialogueRunning.getItemUpdateIndex(), true, 0, 64, (DefaultConstructorMarker) null));
            if (src.getType() == 0) {
                str2 = src.getContent();
                str = str3;
            } else {
                str = src.getContent();
                str2 = str3;
            }
            this.c = new DialogueRunning(2, str2, str, 1, i2 + 1, false, 0, 96, (DefaultConstructorMarker) null);
            c();
        } else {
            if (src.getType() == 0) {
                text = dialogueRunning.getText() + src.getContent();
            } else {
                text = dialogueRunning.getText();
                str3 = src.getContent();
            }
            String str4 = text;
            String str5 = str3;
            this.c = new DialogueRunning(2, str4, str5, 2, dialogueRunning.getItemUpdateIndex(), (StringsKt.isBlank(str4) ^ true) && StringsKt.isBlank(str5), 0, 64, (DefaultConstructorMarker) null);
        }
        this.f = 0;
    }

    public final void s(DialogueRunning dialogueRunning, Src src, int i2) {
        String str;
        String str2;
        String str3;
        String str4 = "";
        if (this.f != 0) {
            a(new DialogueRunning(dialogueRunning.getSpeaker(), dialogueRunning.getText(), "", 2, dialogueRunning.getItemUpdateIndex(), true, 0, 64, (DefaultConstructorMarker) null));
            if (src.getType() == 0) {
                str3 = src.getContent();
                str2 = str4;
            } else {
                str2 = src.getContent();
                str3 = str4;
            }
            this.c = new DialogueRunning(2, str3, str2, 1, i2 + 1, false, 0, 96, (DefaultConstructorMarker) null);
            this.f = 0;
            return;
        }
        if (src.getType() == 0) {
            str = dialogueRunning.getText() + src.getContent();
        } else {
            String text = dialogueRunning.getText();
            str4 = src.getContent();
            str = text;
        }
        this.c = new DialogueRunning(2, str, str4, 2, dialogueRunning.getItemUpdateIndex(), false, 0, 96, (DefaultConstructorMarker) null);
    }

    public final void t(DialogueRunning dialogueRunning, Dst dst, int i2) {
        String text;
        String str;
        String str2;
        String str3 = "";
        if (!StringsKt.isBlank(dialogueRunning.getText())) {
            a(new DialogueRunning(dialogueRunning.getSpeaker(), dialogueRunning.getText(), "", 2, dialogueRunning.getItemUpdateIndex(), true, 0, 64, (DefaultConstructorMarker) null));
            if (dst.getType() == 0) {
                str2 = dst.getContent();
                str = str3;
            } else {
                str = dst.getContent();
                str2 = str3;
            }
            this.b = new DialogueRunning(1, str2, str, 1, i2 + 1, false, 0, 96, (DefaultConstructorMarker) null);
            d();
        } else {
            if (dst.getType() == 0) {
                text = dialogueRunning.getText() + dst.getContent();
            } else {
                text = dialogueRunning.getText();
                str3 = dst.getContent();
            }
            String str4 = text;
            String str5 = str3;
            this.b = new DialogueRunning(1, str4, str5, 2, dialogueRunning.getItemUpdateIndex(), (StringsKt.isBlank(str4) ^ true) && StringsKt.isBlank(str5), 0, 64, (DefaultConstructorMarker) null);
        }
        this.e = 0;
    }

    public final void u(DialogueRunning dialogueRunning, Dst dst, int i2) {
        String str;
        String str2;
        String str3;
        String str4 = "";
        if (this.e != 0) {
            a(new DialogueRunning(dialogueRunning.getSpeaker(), dialogueRunning.getText(), "", 2, dialogueRunning.getItemUpdateIndex(), true, 0, 64, (DefaultConstructorMarker) null));
            if (dst.getType() == 0) {
                str3 = dst.getContent();
                str2 = str4;
            } else {
                str2 = dst.getContent();
                str3 = str4;
            }
            this.b = new DialogueRunning(1, str3, str2, 1, i2 + 1, false, 0, 96, (DefaultConstructorMarker) null);
            this.e = 0;
            return;
        }
        if (dst.getType() == 0) {
            str = dialogueRunning.getText() + dst.getContent();
        } else {
            String text = dialogueRunning.getText();
            str4 = dst.getContent();
            str = text;
        }
        this.b = new DialogueRunning(1, str, str4, 2, dialogueRunning.getItemUpdateIndex(), false, 0, 96, (DefaultConstructorMarker) null);
    }

    public final void v() {
        this.d.clear();
        this.b = null;
        this.c = null;
        this.e = 0;
        this.f = 0;
        this.h.clear();
        this.g = null;
        this.j.set(false);
    }

    public final void w() {
        this.d.clear();
        this.b = null;
        this.c = null;
        this.e = 0;
        this.f = 0;
        this.h.clear();
        this.g = null;
        this.j.set(false);
    }
}
