package com.upuphone.ar.translation.phone.helper;

import android.content.ContentValues;
import android.content.Context;
import com.upuphone.ar.translation.constants.TranslatorConstants;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.ext.StringExtKt;
import com.upuphone.ar.translation.phone.bean.NoteBean;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.text.StringsKt;
import org.litepal.FluentQuery;
import org.litepal.LitePal;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ+\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u000f¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010 \u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\t¢\u0006\u0004\b \u0010!J%\u0010&\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\f2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#¢\u0006\u0004\b&\u0010'J\u001b\u0010(\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b(\u0010)J\u0015\u0010*\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b*\u0010+J\u0015\u0010,\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0006H\u0002¢\u0006\u0004\b.\u0010\u0003R\u0016\u00100\u001a\u00020#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010/¨\u00061"}, d2 = {"Lcom/upuphone/ar/translation/phone/helper/TranslatorLitePalHelper;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "g", "(Landroid/content/Context;)V", "", "keyWords", "", "Lcom/upuphone/ar/translation/phone/bean/NoteBean;", "c", "(Ljava/lang/String;)Ljava/util/List;", "", "transType", "pageSize", "offset", "i", "(III)Ljava/util/List;", "k", "()Ljava/util/List;", "h", "(II)Ljava/util/List;", "e", "(I)I", "d", "()I", "", "recordId", "title", "l", "(JLjava/lang/String;)V", "noteBean", "", "isTitleUpdated", "isRecordUpdated", "m", "(Lcom/upuphone/ar/translation/phone/bean/NoteBean;ZZ)V", "j", "(I)Ljava/util/List;", "f", "(J)Lcom/upuphone/ar/translation/phone/bean/NoteBean;", "b", "(J)I", "a", "Z", "mIsInit", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nTranslatorLitePalHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TranslatorLitePalHelper.kt\ncom/upuphone/ar/translation/phone/helper/TranslatorLitePalHelper\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 FluentQuery.kt\norg/litepal/extension/FluentQueryKt\n*L\n1#1,312:1\n37#2,2:313\n1549#3:315\n1620#3,3:316\n1054#3:319\n1549#3:320\n1620#3,3:321\n154#4:324\n154#4:325\n154#4:326\n*S KotlinDebug\n*F\n+ 1 TranslatorLitePalHelper.kt\ncom/upuphone/ar/translation/phone/helper/TranslatorLitePalHelper\n*L\n100#1:313,2\n106#1:315\n106#1:316,3\n122#1:319\n122#1:320\n122#1:321,3\n202#1:324\n217#1:325\n224#1:326\n*E\n"})
public final class TranslatorLitePalHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final TranslatorLitePalHelper f6309a = new TranslatorLitePalHelper();
    public static boolean b;

    public final void a() {
        Class<NoteBean> cls = NoteBean.class;
        for (NoteBean id : LitePal.where("accountId IS NULL").find(cls, false)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("accountId", TranslatorConstants.getAccountId());
            LitePal.update(cls, contentValues, id.getId());
        }
    }

    public final int b(long j) {
        return LitePal.delete(NoteBean.class, j);
    }

    public final List c(String str) {
        Intrinsics.checkNotNullParameter(str, "keyWords");
        LogExt.g("fuzzyQueryRecordList keyWords=" + str, "TranslatorLitePalHelper");
        List<String> e = StringExtKt.e(str);
        if (e.isEmpty()) {
            return new ArrayList();
        }
        StringBuilder sb = new StringBuilder("(accountId = ? or accountId IS NULL) and transType in (?, ?) and (");
        ArrayList arrayList = new ArrayList();
        arrayList.add(TranslatorConstants.getAccountId());
        arrayList.add("2");
        if (TranslatorConstants.isAirPro()) {
            arrayList.add("3");
        } else {
            arrayList.add("1");
        }
        sb.append("(");
        int i = 0;
        for (String str2 : e) {
            int i2 = i + 1;
            if (i > 0) {
                sb.append(" or ");
            }
            sb.append("title LIKE ?");
            arrayList.add("%" + str2 + "%");
            i = i2;
        }
        sb.append(")");
        sb.append(" or (");
        int i3 = 0;
        for (String str3 : e) {
            int i4 = i3 + 1;
            if (i3 > 0) {
                sb.append(" or ");
            }
            sb.append("srcContent LIKE ?");
            arrayList.add("%" + str3 + "%");
            i3 = i4;
        }
        sb.append(")");
        sb.append(" or (");
        int i5 = 0;
        for (String str4 : e) {
            int i6 = i5 + 1;
            if (i5 > 0) {
                sb.append(" or ");
            }
            sb.append("dstContent LIKE ?");
            arrayList.add("%" + str4 + "%");
            i5 = i6;
        }
        sb.append(")");
        sb.append(")");
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add(sb.toString());
        spreadBuilder.addSpread(arrayList.toArray(new String[0]));
        List<NoteBean> find = LitePal.where((String[]) spreadBuilder.toArray(new String[spreadBuilder.size()])).order("id desc").find(NoteBean.class, false);
        Intrinsics.checkNotNull(find);
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(find, 10));
        for (NoteBean noteBean : find) {
            int i7 = 0;
            for (String str5 : e) {
                if (StringsKt.contains((CharSequence) noteBean.getTitle(), (CharSequence) str5, true)) {
                    i7++;
                }
                if (StringsKt.contains((CharSequence) noteBean.getSrcContent(), (CharSequence) str5, true)) {
                    i7++;
                }
                if (StringsKt.contains((CharSequence) noteBean.getDstContent(), (CharSequence) str5, true)) {
                    i7++;
                }
            }
            arrayList2.add(new Pair(noteBean, Integer.valueOf(i7)));
        }
        List<Pair> sortedWith = CollectionsKt.sortedWith(arrayList2, new TranslatorLitePalHelper$fuzzyQueryRecordList$$inlined$sortedByDescending$1());
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(sortedWith, 10));
        for (Pair first : sortedWith) {
            arrayList3.add((NoteBean) first.getFirst());
        }
        return CollectionsKt.toMutableList(arrayList3);
    }

    public final int d() {
        Class<NoteBean> cls = NoteBean.class;
        if (TranslatorConstants.isAirPro()) {
            FluentQuery where = LitePal.where("(accountId = ? or accountId IS NULL) and transType in (?, ?)", TranslatorConstants.getAccountId(), "2", "3");
            Intrinsics.checkNotNullExpressionValue(where, "where(...)");
            return where.count((Class<?>) cls);
        }
        FluentQuery where2 = LitePal.where("(accountId = ? or accountId IS NULL) and transType in (?, ?)", TranslatorConstants.getAccountId(), "2", "1");
        Intrinsics.checkNotNullExpressionValue(where2, "where(...)");
        return where2.count((Class<?>) cls);
    }

    public final int e(int i) {
        FluentQuery where = LitePal.where("(accountId = ? or accountId IS NULL) and transType = ?", TranslatorConstants.getAccountId(), String.valueOf(i));
        Intrinsics.checkNotNullExpressionValue(where, "where(...)");
        return where.count((Class<?>) NoteBean.class);
    }

    public final NoteBean f(long j) {
        Object find = LitePal.find(NoteBean.class, j, false);
        Intrinsics.checkNotNullExpressionValue(find, "find(...)");
        return (NoteBean) find;
    }

    public final void g(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (b) {
            LogExt.j("Do not repeat initLitePal", "TranslatorLitePalHelper");
            return;
        }
        LogExt.j("initLitePal", "TranslatorLitePalHelper");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        LitePal.initialize(applicationContext);
    }

    public final List h(int i, int i2) {
        a();
        Class<NoteBean> cls = NoteBean.class;
        if (TranslatorConstants.isAirPro()) {
            List<NoteBean> find = LitePal.where("(accountId = ? or accountId IS NULL) and transType in (?, ?)", TranslatorConstants.getAccountId(), "2", "3").order("id desc").limit(i).offset(i2).find(cls, false);
            Intrinsics.checkNotNull(find);
            return find;
        }
        List<NoteBean> find2 = LitePal.where("(accountId = ? or accountId IS NULL) and transType in (?, ?)", TranslatorConstants.getAccountId(), "2", "1").order("id desc").limit(i).offset(i2).find(cls, false);
        Intrinsics.checkNotNull(find2);
        return find2;
    }

    public final List i(int i, int i2, int i3) {
        List<NoteBean> find = LitePal.where("(accountId = ? or accountId IS NULL) and transType = ?", TranslatorConstants.getAccountId(), String.valueOf(i)).order("id desc").limit(i2).offset(i3).find(NoteBean.class, false);
        Intrinsics.checkNotNullExpressionValue(find, "find(...)");
        return find;
    }

    public final List j(int i) {
        List<NoteBean> find = LitePal.select("id", "title").where("(accountId = ? or accountId IS NULL) and transType = ?", TranslatorConstants.getAccountId(), String.valueOf(i)).order("id desc").find(NoteBean.class, false);
        Intrinsics.checkNotNullExpressionValue(find, "find(...)");
        return find;
    }

    public final List k() {
        List<NoteBean> find = LitePal.where("transType = ?", "1").find(NoteBean.class, false);
        Intrinsics.checkNotNullExpressionValue(find, "find(...)");
        return find;
    }

    public final void l(long j, String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", str);
        LitePal.update(NoteBean.class, contentValues, j);
    }

    public final void m(NoteBean noteBean, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(noteBean, "noteBean");
        ContentValues contentValues = new ContentValues();
        if (z) {
            contentValues.put("title", noteBean.getTitle());
        }
        if (z2) {
            contentValues.put("srcContent", noteBean.getSrcContent());
            contentValues.put("dstContent", noteBean.getDstContent());
        }
        LitePal.update(NoteBean.class, contentValues, noteBean.getId());
    }
}
