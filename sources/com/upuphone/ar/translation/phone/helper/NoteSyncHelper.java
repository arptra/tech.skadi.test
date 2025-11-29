package com.upuphone.ar.translation.phone.helper;

import android.content.Context;
import com.honey.account.constant.AccountConstantKt;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.ar.translation.audio.debug.AudioDebugHelper;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.TranslationManager;
import com.upuphone.ar.translation.phone.bean.NoteBean;
import com.upuphone.ar.translation.phone.bean.TempStorageTransResult;
import com.upuphone.ar.translation.phone.bean.TransRecord;
import com.upuphone.ar.translation.statemachine.machine.TranslateStateManager;
import com.upuphone.ar.translation.utils.DateUtils;
import com.upuphone.ar.translation.utils.JsonUtils;
import com.upuphone.ar.translation.utils.PreferencesUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0007¢\u0006\u0004\b\r\u0010\u0003J\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J9\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ'\u0010\"\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\bH\u0002¢\u0006\u0004\b$\u0010\u0003J/\u0010%\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0015H\u0002¢\u0006\u0004\b%\u0010&J\u001f\u0010'\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0015H\u0002¢\u0006\u0004\b'\u0010(J\u001f\u0010)\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0015H\u0002¢\u0006\u0004\b)\u0010(J\u001f\u0010*\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0002¢\u0006\u0004\b*\u0010(J\u001f\u0010+\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0002¢\u0006\u0004\b+\u0010(J\u0017\u0010-\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\u0015H\u0002¢\u0006\u0004\b-\u0010.J\u001f\u00101\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\u00152\u0006\u00100\u001a\u00020\u0015H\u0002¢\u0006\u0004\b1\u00102J\u001b\u00105\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u000103H\u0007¢\u0006\u0004\b5\u00106J\u0011\u00107\u001a\u0004\u0018\u000103H\u0007¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\bH\u0007¢\u0006\u0004\b9\u0010\u0003J\u001b\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150:H\u0002¢\u0006\u0004\b;\u0010<J\u001b\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150:H\u0002¢\u0006\u0004\b=\u0010<J\u0013\u0010>\u001a\u00020\u001a*\u00020\u0015H\u0002¢\u0006\u0004\b>\u0010?J\u0013\u0010@\u001a\u00020\u001a*\u00020\u0015H\u0002¢\u0006\u0004\b@\u0010?J'\u0010C\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\u00152\u0006\u0010A\u001a\u00020\u00152\u0006\u0010B\u001a\u00020\u0015H\u0002¢\u0006\u0004\bC\u0010DJ\u0017\u0010E\u001a\u00020\u001a2\u0006\u0010B\u001a\u00020\u0015H\u0002¢\u0006\u0004\bE\u0010?J\u0017\u0010F\u001a\u00020\u001a2\u0006\u0010B\u001a\u00020\u0015H\u0002¢\u0006\u0004\bF\u0010?R\u0018\u0010H\u001a\u0004\u0018\u0001038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010GR\u001a\u0010L\u001a\b\u0012\u0004\u0012\u00020J0I8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010KR\u001a\u0010N\u001a\b\u0012\u0004\u0012\u00020J0I8\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010KR\u0016\u0010P\u001a\u00020\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010OR\u0016\u0010Q\u001a\u00020\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010OR\u0016\u0010R\u001a\u00020\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b;\u0010OR\u0016\u0010T\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b=\u0010SR\u0018\u0010V\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bC\u0010UR\u0016\u0010W\u001a\u00020\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u0010OR\u0016\u0010X\u001a\u00020\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010O¨\u0006Y"}, d2 = {"Lcom/upuphone/ar/translation/phone/helper/NoteSyncHelper;", "", "<init>", "()V", "", "finalType", "Lcom/upuphone/ar/translation/phone/bean/TempStorageTransResult;", "transResult", "", "y", "(ILcom/upuphone/ar/translation/phone/bean/TempStorageTransResult;)V", "f", "()Lcom/upuphone/ar/translation/phone/bean/TempStorageTransResult;", "t", "translateModel", "z", "(I)V", "Landroid/content/Context;", "context", "v", "(Landroid/content/Context;Lcom/upuphone/ar/translation/phone/bean/TempStorageTransResult;)V", "", "remoteSrc", "remoteDst", "proximalSrc", "proximalDst", "", "isEnd", "c", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "s", "()Z", "transType", "recognizeId", "u", "(Landroid/content/Context;ILjava/lang/String;)V", "x", "n", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "k", "(Ljava/lang/String;Ljava/lang/String;)V", "a", "l", "b", "sourceText", "e", "(Ljava/lang/String;)Ljava/lang/String;", "src", "dst", "w", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Lcom/upuphone/ar/translation/phone/bean/NoteBean;", "noteBean", "A", "(Lcom/upuphone/ar/translation/phone/bean/NoteBean;)Lcom/upuphone/ar/translation/phone/bean/NoteBean;", "j", "()Lcom/upuphone/ar/translation/phone/bean/NoteBean;", "m", "", "g", "()Ljava/util/Map;", "h", "p", "(Ljava/lang/String;)Z", "r", "srcFirstChar", "puncStr", "i", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "o", "q", "Lcom/upuphone/ar/translation/phone/bean/NoteBean;", "mNoteBean", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/upuphone/ar/translation/phone/bean/TransRecord;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "mSrcRecordList", "d", "mDstRecordList", "Z", "mIsSyncToPhone", "mIsSave", "mIsDisplayRemoteSrc", "I", "mTransType", "Lcom/upuphone/ar/translation/phone/bean/TempStorageTransResult;", "mFirstTransResult", "mFirstTransResultFinal", "mIsTelephoneTrans", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class NoteSyncHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final NoteSyncHelper f6301a = new NoteSyncHelper();
    public static NoteBean b;
    public static final CopyOnWriteArrayList c = new CopyOnWriteArrayList();
    public static final CopyOnWriteArrayList d = new CopyOnWriteArrayList();
    public static boolean e = true;
    public static boolean f;
    public static boolean g;
    public static int h;
    public static TempStorageTransResult i;
    public static boolean j;
    public static boolean k;

    public static final NoteBean A(NoteBean noteBean) {
        boolean z = f;
        LogExt.j("updateRecord isSave=" + z + ", noteBean=" + noteBean, "NoteSyncHelper");
        NoteBean noteBean2 = null;
        if (!f || noteBean == null) {
            return null;
        }
        noteBean.setRecordTime(DateUtils.e());
        int update = noteBean.update(noteBean.getId());
        if (b != null) {
            noteBean2 = noteBean;
        }
        b = noteBean2;
        long id = noteBean.getId();
        NoteBean noteBean3 = b;
        LogExt.j("updateRecord updateState=" + update + ", id=" + id + ", mNoteBean=" + noteBean3, "NoteSyncHelper");
        return noteBean;
    }

    public static /* synthetic */ void d(NoteSyncHelper noteSyncHelper, String str, String str2, String str3, String str4, boolean z, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            z = false;
        }
        noteSyncHelper.c(str, str2, str3, str4, z);
    }

    public static final NoteBean j() {
        return b;
    }

    public static final void m() {
        Unit unit = null;
        if (h == 3) {
            CopyOnWriteArrayList copyOnWriteArrayList = c;
            TransRecord transRecord = (TransRecord) CollectionsKt.lastOrNull(copyOnWriteArrayList);
            if (transRecord != null) {
                if (!StringsKt.isBlank(transRecord.getRContent())) {
                    TransRecord transRecord2 = new TransRecord();
                    transRecord2.setRContentDisplay(g);
                    copyOnWriteArrayList.add(transRecord2);
                    d.add(new TransRecord());
                }
                if (!StringsKt.isBlank(transRecord.getPContent())) {
                    TransRecord transRecord3 = new TransRecord();
                    transRecord3.setRContentDisplay(g);
                    copyOnWriteArrayList.add(transRecord3);
                    d.add(new TransRecord());
                }
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                LogExt.j("handleMuteTwoSecs 【对话翻译】原文为空不进行换行", "NoteSyncHelper");
                return;
            }
            return;
        }
        CopyOnWriteArrayList copyOnWriteArrayList2 = c;
        TransRecord transRecord4 = (TransRecord) CollectionsKt.lastOrNull(copyOnWriteArrayList2);
        if (transRecord4 != null) {
            if ((!StringsKt.isBlank(transRecord4.getRContent())) || (!StringsKt.isBlank(transRecord4.getPContent()))) {
                TransRecord transRecord5 = new TransRecord();
                transRecord5.setRContentDisplay(g);
                copyOnWriteArrayList2.add(transRecord5);
                d.add(new TransRecord());
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            LogExt.j("handleMuteTwoSecs 【同传翻译】原文为空不进行换行", "NoteSyncHelper");
        }
    }

    public static final void t() {
        LogExt.j("reset 重置翻译记录存储类各种数据", "NoteSyncHelper");
        i = null;
        b = null;
        c.clear();
        d.clear();
        e = false;
        f = false;
        g = false;
        h = 0;
        j = false;
        k = false;
    }

    public static final void v(Context context, TempStorageTransResult tempStorageTransResult) {
        boolean z;
        Context context2 = context;
        TempStorageTransResult tempStorageTransResult2 = tempStorageTransResult;
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(tempStorageTransResult2, "transResult");
        LogExt.j("saveFinalResult transResult=" + tempStorageTransResult2, "NoteSyncHelper");
        int transType = tempStorageTransResult.getTransType();
        String remoteSrc = tempStorageTransResult.getRemoteSrc();
        String remoteDst = tempStorageTransResult.getRemoteDst();
        String proximalSrc = tempStorageTransResult.getProximalSrc();
        String proximalDst = tempStorageTransResult.getProximalDst();
        boolean isFirstTemp = tempStorageTransResult.isFirstTemp();
        TranslateStateManager p = TranslationManager.q.a().p();
        if (p == null || !p.e()) {
            z = true;
            d(f6301a, remoteSrc, remoteDst, proximalSrc, proximalDst, false, 16, (Object) null);
        } else {
            LogExt.j("saveFinalResult Translation is not start", "NoteSyncHelper");
            f6301a.c(remoteSrc, remoteDst, proximalSrc, proximalDst, true);
            if (isFirstTemp) {
                z = true;
            } else {
                return;
            }
        }
        boolean z2 = b == null ? z : false;
        if (z2) {
            t();
            z(PreferencesUtils.n());
            h = transType;
            k = TelephoneTransHelper.f6305a.A();
        }
        if (transType == 3) {
            if (!StringsKt.isBlank(remoteSrc)) {
                f6301a.l(remoteSrc, remoteDst);
            }
            if (!StringsKt.isBlank(proximalSrc)) {
                f6301a.k(proximalSrc, proximalDst);
            }
        } else {
            f6301a.n(remoteSrc, remoteDst, proximalSrc, proximalDst);
        }
        NoteSyncHelper noteSyncHelper = f6301a;
        if (noteSyncHelper.s()) {
            LogExt.j("saveFinalResult 要保存的内容为空，不需要保存", "NoteSyncHelper");
        } else if (z2) {
            noteSyncHelper.u(context2, transType, tempStorageTransResult.getRecognizeId());
            f = z;
        } else {
            noteSyncHelper.x();
        }
    }

    public static final void z(int i2) {
        boolean z = i2 == 3;
        boolean z2 = g;
        LogExt.j("updateNoteBeanSingle updateSrc=" + z + ", currentSrc=" + z2, "NoteSyncHelper");
        if (z != g) {
            g = z;
            int i3 = h;
            if (i3 != 0 && i3 != 1) {
                m();
            }
        }
    }

    public final void a(String str, String str2) {
        String e2 = e(str2);
        String e3 = e(str);
        if ((!StringsKt.isBlank(e2)) && (!StringsKt.isBlank(e3))) {
            CopyOnWriteArrayList copyOnWriteArrayList = c;
            TransRecord transRecord = new TransRecord();
            transRecord.setRContentDisplay(g);
            transRecord.setPContent(e2);
            copyOnWriteArrayList.add(transRecord);
            CopyOnWriteArrayList copyOnWriteArrayList2 = d;
            TransRecord transRecord2 = new TransRecord();
            transRecord2.setPContent(e3);
            copyOnWriteArrayList2.add(transRecord2);
        }
    }

    public final void b(String str, String str2) {
        String e2 = e(str);
        String e3 = e(str2);
        if ((!StringsKt.isBlank(e3)) && (!StringsKt.isBlank(e2))) {
            CopyOnWriteArrayList copyOnWriteArrayList = c;
            TransRecord transRecord = new TransRecord();
            transRecord.setRContentDisplay(g);
            transRecord.setRContent(e2);
            copyOnWriteArrayList.add(transRecord);
            CopyOnWriteArrayList copyOnWriteArrayList2 = d;
            TransRecord transRecord2 = new TransRecord();
            transRecord2.setRContent(e3);
            copyOnWriteArrayList2.add(transRecord2);
        }
    }

    public final void c(String str, String str2, String str3, String str4, boolean z) {
        AudioDebugHelper.o(str, "remote_src_phone.txt", z);
        AudioDebugHelper.m(str2, "remote_dst_phone.txt", z);
        AudioDebugHelper.l(str3, "proximal_src_phone.txt", z);
        AudioDebugHelper.j(str4, "proximal_dst_phone.txt", z);
    }

    public final String e(String str) {
        return new Regex("^[,.:;?!'\"()、，。：；？！‘’“”（）]+").replace((CharSequence) str, "");
    }

    public final TempStorageTransResult f() {
        return i;
    }

    public final Map g() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("，", MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA);
        linkedHashMap.put("。", ".");
        linkedHashMap.put("：", AccountConstantKt.CODE_SEPARTOR);
        linkedHashMap.put("；", MzContactsContract.MzGroups.GROUP_SPLIT_MARK_VCARD);
        linkedHashMap.put("？", "?");
        linkedHashMap.put("！", "!");
        return linkedHashMap;
    }

    public final Map h() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA, "，");
        linkedHashMap.put(".", "。");
        linkedHashMap.put(AccountConstantKt.CODE_SEPARTOR, "：");
        linkedHashMap.put(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_VCARD, "；");
        linkedHashMap.put("?", "？");
        linkedHashMap.put("!", "！");
        return linkedHashMap;
    }

    public final String i(String str, String str2, String str3) {
        String str4;
        if (p(str2)) {
            if (o(str3) || (str4 = (String) h().get(str3)) == null) {
                return str3;
            }
        } else if (!r(str) || q(str3) || (str4 = (String) g().get(str3)) == null) {
            return str3;
        }
        return str4;
    }

    public final void k(String str, String str2) {
        Unit unit;
        CopyOnWriteArrayList copyOnWriteArrayList = c;
        TransRecord transRecord = (TransRecord) CollectionsKt.lastOrNull(copyOnWriteArrayList);
        if (transRecord != null) {
            if (!StringsKt.isBlank(transRecord.getPContent())) {
                int lastIndex = CollectionsKt.getLastIndex(copyOnWriteArrayList);
                Object last = CollectionsKt.last(copyOnWriteArrayList);
                TransRecord transRecord2 = (TransRecord) last;
                String pContent = transRecord2.getPContent();
                transRecord2.setPContent(pContent + str2);
                Unit unit2 = Unit.INSTANCE;
                copyOnWriteArrayList.set(lastIndex, last);
                CopyOnWriteArrayList copyOnWriteArrayList2 = d;
                int lastIndex2 = CollectionsKt.getLastIndex(copyOnWriteArrayList2);
                Object last2 = CollectionsKt.last(copyOnWriteArrayList2);
                TransRecord transRecord3 = (TransRecord) last2;
                String pContent2 = transRecord3.getPContent();
                transRecord3.setPContent(pContent2 + str);
                copyOnWriteArrayList2.set(lastIndex2, last2);
            } else if (StringsKt.isBlank(transRecord.getRContent())) {
                int lastIndex3 = CollectionsKt.getLastIndex(copyOnWriteArrayList);
                Object last3 = CollectionsKt.last(copyOnWriteArrayList);
                ((TransRecord) last3).setPContent(str2);
                Unit unit3 = Unit.INSTANCE;
                copyOnWriteArrayList.set(lastIndex3, last3);
                CopyOnWriteArrayList copyOnWriteArrayList3 = d;
                int lastIndex4 = CollectionsKt.getLastIndex(copyOnWriteArrayList3);
                Object last4 = CollectionsKt.last(copyOnWriteArrayList3);
                ((TransRecord) last4).setPContent(str);
                copyOnWriteArrayList3.set(lastIndex4, last4);
            } else {
                f6301a.a(str, str2);
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            a(str, str2);
        }
    }

    public final void l(String str, String str2) {
        Unit unit;
        CopyOnWriteArrayList copyOnWriteArrayList = c;
        TransRecord transRecord = (TransRecord) CollectionsKt.lastOrNull(copyOnWriteArrayList);
        if (transRecord != null) {
            if (!StringsKt.isBlank(transRecord.getRContent())) {
                int lastIndex = CollectionsKt.getLastIndex(copyOnWriteArrayList);
                Object last = CollectionsKt.last(copyOnWriteArrayList);
                TransRecord transRecord2 = (TransRecord) last;
                String rContent = transRecord2.getRContent();
                transRecord2.setRContent(rContent + str);
                Unit unit2 = Unit.INSTANCE;
                copyOnWriteArrayList.set(lastIndex, last);
                CopyOnWriteArrayList copyOnWriteArrayList2 = d;
                int lastIndex2 = CollectionsKt.getLastIndex(copyOnWriteArrayList2);
                Object last2 = CollectionsKt.last(copyOnWriteArrayList2);
                TransRecord transRecord3 = (TransRecord) last2;
                String rContent2 = transRecord3.getRContent();
                transRecord3.setRContent(rContent2 + str2);
                copyOnWriteArrayList2.set(lastIndex2, last2);
            } else if (StringsKt.isBlank(transRecord.getPContent())) {
                int lastIndex3 = CollectionsKt.getLastIndex(copyOnWriteArrayList);
                Object last3 = CollectionsKt.last(copyOnWriteArrayList);
                ((TransRecord) last3).setRContent(str);
                Unit unit3 = Unit.INSTANCE;
                copyOnWriteArrayList.set(lastIndex3, last3);
                CopyOnWriteArrayList copyOnWriteArrayList3 = d;
                int lastIndex4 = CollectionsKt.getLastIndex(copyOnWriteArrayList3);
                Object last4 = CollectionsKt.last(copyOnWriteArrayList3);
                ((TransRecord) last4).setRContent(str2);
                copyOnWriteArrayList3.set(lastIndex4, last4);
            } else {
                f6301a.b(str, str2);
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            b(str, str2);
        }
    }

    public final void n(String str, String str2, String str3, String str4) {
        CopyOnWriteArrayList copyOnWriteArrayList = c;
        if (copyOnWriteArrayList.isEmpty() || d.isEmpty()) {
            TransRecord transRecord = new TransRecord();
            transRecord.setRContentDisplay(g);
            copyOnWriteArrayList.add(transRecord);
            d.add(new TransRecord());
        }
        if (h != 1) {
            str = w(str, str2);
        }
        if ((!StringsKt.isBlank(str2)) && (!StringsKt.isBlank(str)) && StringsKt.isBlank(((TransRecord) CollectionsKt.last(copyOnWriteArrayList)).getRContent())) {
            str2 = e(str2);
            str = e(str);
        }
        if ((!StringsKt.isBlank(str4)) && (!StringsKt.isBlank(str3)) && StringsKt.isBlank(((TransRecord) CollectionsKt.last(copyOnWriteArrayList)).getPContent())) {
            str4 = e(str4);
            str3 = e(str3);
        }
        if ((!StringsKt.isBlank(str2)) && (!StringsKt.isBlank(str))) {
            int lastIndex = CollectionsKt.getLastIndex(copyOnWriteArrayList);
            Object last = CollectionsKt.last(copyOnWriteArrayList);
            TransRecord transRecord2 = (TransRecord) last;
            String rContent = transRecord2.getRContent();
            transRecord2.setRContent(rContent + str);
            Unit unit = Unit.INSTANCE;
            copyOnWriteArrayList.set(lastIndex, last);
            CopyOnWriteArrayList copyOnWriteArrayList2 = d;
            int lastIndex2 = CollectionsKt.getLastIndex(copyOnWriteArrayList2);
            Object last2 = CollectionsKt.last(copyOnWriteArrayList2);
            TransRecord transRecord3 = (TransRecord) last2;
            String rContent2 = transRecord3.getRContent();
            transRecord3.setRContent(rContent2 + str2);
            copyOnWriteArrayList2.set(lastIndex2, last2);
        }
        if ((!StringsKt.isBlank(str4)) && (!StringsKt.isBlank(str3))) {
            int lastIndex3 = CollectionsKt.getLastIndex(copyOnWriteArrayList);
            Object last3 = CollectionsKt.last(copyOnWriteArrayList);
            TransRecord transRecord4 = (TransRecord) last3;
            String pContent = transRecord4.getPContent();
            transRecord4.setPContent(pContent + str4);
            Unit unit2 = Unit.INSTANCE;
            copyOnWriteArrayList.set(lastIndex3, last3);
            CopyOnWriteArrayList copyOnWriteArrayList3 = d;
            int lastIndex4 = CollectionsKt.getLastIndex(copyOnWriteArrayList3);
            Object last4 = CollectionsKt.last(copyOnWriteArrayList3);
            TransRecord transRecord5 = (TransRecord) last4;
            String pContent2 = transRecord5.getPContent();
            transRecord5.setPContent(pContent2 + str3);
            copyOnWriteArrayList3.set(lastIndex4, last4);
        }
    }

    public final boolean o(String str) {
        return g().containsKey(str);
    }

    public final boolean p(String str) {
        if (str.length() > 1) {
            return false;
        }
        return Pattern.compile("[一-龥]").matcher(str).find();
    }

    public final boolean q(String str) {
        return h().containsKey(str);
    }

    public final boolean r(String str) {
        return Pattern.compile("[a-zA-Z]+").matcher(str).find();
    }

    public final boolean s() {
        CopyOnWriteArrayList copyOnWriteArrayList = c;
        if (!copyOnWriteArrayList.isEmpty()) {
            return StringsKt.isBlank(((TransRecord) copyOnWriteArrayList.get(0)).getRContent()) && StringsKt.isBlank(((TransRecord) copyOnWriteArrayList.get(0)).getPContent());
        }
        LogExt.j("isRecordIllegal list is null", "NoteSyncHelper");
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00db, code lost:
        if (r4 == null) goto L_0x00dd;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void u(android.content.Context r9, int r10, java.lang.String r11) {
        /*
            r8 = this;
            boolean r8 = com.upuphone.ar.translation.utils.PreferencesUtils.c()
            e = r8
            java.lang.String r0 = "NoteSyncHelper"
            if (r8 != 0) goto L_0x0010
            java.lang.String r8 = "save but isSyncToPhone is false"
            com.upuphone.ar.translation.ext.LogExt.j(r8, r0)
            return
        L_0x0010:
            com.upuphone.ar.translation.phone.bean.NoteBean r8 = new com.upuphone.ar.translation.phone.bean.NoteBean
            r8.<init>()
            b = r8
            long r1 = com.upuphone.ar.translation.utils.DateUtils.e()
            r8.setRecordTime(r1)
            com.upuphone.ar.translation.phone.bean.NoteBean r8 = b
            if (r8 != 0) goto L_0x0023
            goto L_0x002e
        L_0x0023:
            com.upuphone.ar.translation.utils.JsonUtils r1 = com.upuphone.ar.translation.utils.JsonUtils.f6365a
            java.util.concurrent.CopyOnWriteArrayList r2 = d
            java.lang.String r1 = r1.e(r2)
            r8.setDstContent(r1)
        L_0x002e:
            com.upuphone.ar.translation.phone.bean.NoteBean r8 = b
            if (r8 != 0) goto L_0x0033
            goto L_0x003e
        L_0x0033:
            com.upuphone.ar.translation.utils.JsonUtils r1 = com.upuphone.ar.translation.utils.JsonUtils.f6365a
            java.util.concurrent.CopyOnWriteArrayList r2 = c
            java.lang.String r1 = r1.e(r2)
            r8.setSrcContent(r1)
        L_0x003e:
            com.upuphone.ar.translation.phone.bean.NoteBean r8 = b
            if (r8 != 0) goto L_0x0043
            goto L_0x0046
        L_0x0043:
            r8.setTransType(r10)
        L_0x0046:
            com.upuphone.ar.translation.phone.bean.NoteBean r8 = b
            if (r8 != 0) goto L_0x004b
            goto L_0x005e
        L_0x004b:
            boolean r1 = com.upuphone.ar.translation.constants.TranslatorConstants.isAir()
            if (r1 != 0) goto L_0x005a
            boolean r1 = com.upuphone.ar.translation.constants.TranslatorConstants.isAirPro()
            if (r1 == 0) goto L_0x0058
            goto L_0x005a
        L_0x0058:
            r1 = 0
            goto L_0x005b
        L_0x005a:
            r1 = 1
        L_0x005b:
            r8.setXrType(r1)
        L_0x005e:
            com.upuphone.ar.translation.phone.bean.NoteBean r8 = b
            if (r8 != 0) goto L_0x0063
            goto L_0x0068
        L_0x0063:
            boolean r1 = k
            r8.setTelephoneTrans(r1)
        L_0x0068:
            com.upuphone.ar.translation.phone.bean.NoteBean r8 = b
            java.lang.String r1 = ""
            if (r8 != 0) goto L_0x006f
            goto L_0x0085
        L_0x006f:
            com.upuphone.ar.translation.phone.TranslationManager$Companion r2 = com.upuphone.ar.translation.phone.TranslationManager.q
            com.upuphone.ar.translation.phone.TranslationManager r2 = r2.a()
            com.upuphone.ar.translation.phone.helper.RecordTitleHelper r2 = r2.m()
            if (r2 == 0) goto L_0x0081
            java.lang.String r2 = r2.h(r10)
            if (r2 != 0) goto L_0x0082
        L_0x0081:
            r2 = r1
        L_0x0082:
            r8.setTitle(r2)
        L_0x0085:
            boolean r8 = com.upuphone.ar.translation.utils.PreferencesUtils.l()
            com.upuphone.ar.translation.phone.bean.NoteBean r2 = b
            java.lang.String r3 = "getString(...)"
            if (r2 != 0) goto L_0x0090
            goto L_0x00eb
        L_0x0090:
            if (r8 == 0) goto L_0x00e7
            com.upuphone.xr.interconnect.entity.NaviLocationInfo r4 = com.upuphone.ar.translation.constants.TranslatorConstants.getLocationInfo()
            if (r4 == 0) goto L_0x00dd
            java.lang.String r5 = r4.getDistrict()
            java.lang.String r6 = r4.getStreet()
            java.lang.String r4 = r4.getAddress()
            if (r5 == 0) goto L_0x00ac
            boolean r7 = kotlin.text.StringsKt.isBlank(r5)
            if (r7 == 0) goto L_0x00b5
        L_0x00ac:
            if (r6 == 0) goto L_0x00c5
            boolean r7 = kotlin.text.StringsKt.isBlank(r6)
            if (r7 == 0) goto L_0x00b5
            goto L_0x00c5
        L_0x00b5:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r5)
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            goto L_0x00db
        L_0x00c5:
            if (r4 == 0) goto L_0x00d2
            boolean r5 = kotlin.text.StringsKt.isBlank(r4)
            if (r5 == 0) goto L_0x00ce
            goto L_0x00d2
        L_0x00ce:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            goto L_0x00db
        L_0x00d2:
            int r4 = com.upuphone.ar.translation.phone.R.string.tl_unknown
            java.lang.String r4 = r9.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
        L_0x00db:
            if (r4 != 0) goto L_0x00e8
        L_0x00dd:
            int r4 = com.upuphone.ar.translation.phone.R.string.tl_unknown
            java.lang.String r4 = r9.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r3)
            goto L_0x00e8
        L_0x00e7:
            r4 = r1
        L_0x00e8:
            r2.setGeoLocation(r4)
        L_0x00eb:
            com.upuphone.ar.translation.phone.bean.NoteBean r2 = b
            if (r2 != 0) goto L_0x00f0
            goto L_0x0120
        L_0x00f0:
            if (r8 == 0) goto L_0x011d
            com.upuphone.xr.interconnect.entity.NaviLocationInfo r8 = com.upuphone.ar.translation.constants.TranslatorConstants.getLocationInfo()
            if (r8 == 0) goto L_0x0114
            java.lang.String r8 = r8.getAddress()
            if (r8 == 0) goto L_0x010a
            boolean r1 = kotlin.text.StringsKt.isBlank(r8)
            if (r1 == 0) goto L_0x0105
            goto L_0x010a
        L_0x0105:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
        L_0x0108:
            r1 = r8
            goto L_0x011d
        L_0x010a:
            int r8 = com.upuphone.ar.translation.phone.R.string.tl_unknown
            java.lang.String r8 = r9.getString(r8)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            goto L_0x0108
        L_0x0114:
            int r8 = com.upuphone.ar.translation.phone.R.string.tl_unknown
            java.lang.String r1 = r9.getString(r8)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
        L_0x011d:
            r2.setGeoAddress(r1)
        L_0x0120:
            com.upuphone.ar.translation.phone.bean.NoteBean r8 = b
            if (r8 != 0) goto L_0x0125
            goto L_0x0128
        L_0x0125:
            r8.setRecognizeId(r11)
        L_0x0128:
            com.upuphone.ar.translation.phone.bean.NoteBean r8 = b
            if (r8 != 0) goto L_0x012d
            goto L_0x0134
        L_0x012d:
            java.lang.String r9 = com.upuphone.ar.translation.constants.TranslatorConstants.getAccountId()
            r8.setAccountId(r9)
        L_0x0134:
            boolean r8 = com.upuphone.ar.translation.constants.TranslatorConstants.isAirPro()
            if (r8 == 0) goto L_0x0176
            com.upuphone.ar.translation.utils.LanguageUtils$StoredLanguage r8 = com.upuphone.ar.translation.utils.LanguageUtils.g()
            r9 = 2
            if (r10 == r9) goto L_0x015e
            r9 = 3
            if (r10 == r9) goto L_0x0145
            goto L_0x0176
        L_0x0145:
            com.upuphone.ar.translation.phone.bean.NoteBean r9 = b
            if (r9 != 0) goto L_0x014a
            goto L_0x0151
        L_0x014a:
            java.lang.String r10 = r8.b()
            r9.setSrcLanguage(r10)
        L_0x0151:
            com.upuphone.ar.translation.phone.bean.NoteBean r9 = b
            if (r9 != 0) goto L_0x0156
            goto L_0x0176
        L_0x0156:
            java.lang.String r8 = r8.a()
            r9.setDstLanguage(r8)
            goto L_0x0176
        L_0x015e:
            com.upuphone.ar.translation.phone.bean.NoteBean r9 = b
            if (r9 != 0) goto L_0x0163
            goto L_0x016a
        L_0x0163:
            java.lang.String r10 = r8.d()
            r9.setSrcLanguage(r10)
        L_0x016a:
            com.upuphone.ar.translation.phone.bean.NoteBean r9 = b
            if (r9 != 0) goto L_0x016f
            goto L_0x0176
        L_0x016f:
            java.lang.String r8 = r8.c()
            r9.setDstLanguage(r8)
        L_0x0176:
            com.upuphone.ar.translation.phone.bean.NoteBean r8 = b
            if (r8 == 0) goto L_0x0183
            boolean r8 = r8.save()
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            goto L_0x0184
        L_0x0183:
            r8 = 0
        L_0x0184:
            if (r8 == 0) goto L_0x01a0
            boolean r9 = r8.booleanValue()
            if (r9 != 0) goto L_0x018d
            goto L_0x01a0
        L_0x018d:
            com.upuphone.ar.translation.phone.bean.NoteBean r9 = b
            if (r9 == 0) goto L_0x01a0
            com.upuphone.ar.translation.phone.TranslationManager$Companion r10 = com.upuphone.ar.translation.phone.TranslationManager.q
            com.upuphone.ar.translation.phone.TranslationManager r10 = r10.a()
            com.upuphone.ar.translation.phone.helper.RecordTitleHelper r10 = r10.m()
            if (r10 == 0) goto L_0x01a0
            r10.e(r9)
        L_0x01a0:
            com.upuphone.ar.translation.phone.bean.NoteBean r9 = b
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "saveSuccess="
            r10.append(r11)
            r10.append(r8)
            java.lang.String r8 = ", noteBean="
            r10.append(r8)
            r10.append(r9)
            java.lang.String r8 = r10.toString()
            com.upuphone.ar.translation.ext.LogExt.j(r8, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.phone.helper.NoteSyncHelper.u(android.content.Context, int, java.lang.String):void");
    }

    public final String w(String str, String str2) {
        if (!StringsKt.isBlank(str2) && !StringsKt.isBlank(str)) {
            String substring = StringsKt.trimStart((CharSequence) str).toString().substring(0, 1);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            if (!o(substring) && !q(substring)) {
                String substring2 = StringsKt.trimStart((CharSequence) str2).toString().substring(0, 1);
                Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                if (!o(substring2) && !q(substring2)) {
                    return str;
                }
                String i2 = i(str, substring, substring2);
                LogExt.g("spliceSrcFirstPunc finalSrc=" + i2 + " " + str, "NoteSyncHelper");
                return i2 + " " + str;
            }
        }
        return str;
    }

    public final void x() {
        if (!e) {
            LogExt.j("update but isSyncToPhone is false", "NoteSyncHelper");
            return;
        }
        NoteBean noteBean = b;
        if (noteBean == null) {
            LogExt.j("更新翻译记录异常，数据库对象为空", "NoteSyncHelper");
        } else if (noteBean != null) {
            long id = noteBean.getId();
            NoteBean noteBean2 = b;
            if (noteBean2 != null) {
                noteBean2.setRecordTime(DateUtils.e());
            }
            NoteBean noteBean3 = b;
            if (noteBean3 != null) {
                noteBean3.setDstContent(JsonUtils.f6365a.e(d));
            }
            NoteBean noteBean4 = b;
            if (noteBean4 != null) {
                noteBean4.setSrcContent(JsonUtils.f6365a.e(c));
            }
            NoteBean noteBean5 = b;
            Integer valueOf = noteBean5 != null ? Integer.valueOf(noteBean5.update(id)) : null;
            NoteBean noteBean6 = b;
            LogExt.j("update updateState=" + valueOf + ", noteBean=" + noteBean6, "NoteSyncHelper");
        }
    }

    public final void y(int i2, TempStorageTransResult tempStorageTransResult) {
        Intrinsics.checkNotNullParameter(tempStorageTransResult, "transResult");
        if (!j) {
            if (i2 == 0) {
                j = true;
            }
            boolean z = j;
            LogExt.j("updateFirstTransResult finalType=" + i2 + ", firstTransResultFinal=" + z, "NoteSyncHelper");
            i = tempStorageTransResult;
        }
    }
}
