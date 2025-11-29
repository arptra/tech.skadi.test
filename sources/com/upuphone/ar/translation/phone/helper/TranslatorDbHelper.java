package com.upuphone.ar.translation.phone.helper;

import android.content.Context;
import androidx.room.Room;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.dao.IntelExtnSummaryDao;
import com.upuphone.ar.translation.phone.dao.IntelExtnTodoDao;
import com.upuphone.ar.translation.phone.db.TranslatorDataBase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u000f8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\n\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/upuphone/ar/translation/phone/helper/TranslatorDbHelper;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "c", "(Landroid/content/Context;)V", "Lcom/upuphone/ar/translation/phone/dao/IntelExtnTodoDao;", "b", "()Lcom/upuphone/ar/translation/phone/dao/IntelExtnTodoDao;", "Lcom/upuphone/ar/translation/phone/dao/IntelExtnSummaryDao;", "a", "()Lcom/upuphone/ar/translation/phone/dao/IntelExtnSummaryDao;", "Lcom/upuphone/ar/translation/phone/db/TranslatorDataBase;", "Lcom/upuphone/ar/translation/phone/db/TranslatorDataBase;", "mDb", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TranslatorDbHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final TranslatorDbHelper f6307a = new TranslatorDbHelper();
    public static TranslatorDataBase b;

    public final IntelExtnSummaryDao a() {
        TranslatorDataBase translatorDataBase = b;
        if (translatorDataBase == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDb");
            translatorDataBase = null;
        }
        return translatorDataBase.d();
    }

    public final IntelExtnTodoDao b() {
        TranslatorDataBase translatorDataBase = b;
        if (translatorDataBase == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDb");
            translatorDataBase = null;
        }
        return translatorDataBase.e();
    }

    public final void c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        LogExt.j("初始化数据库帮助类", "TranslatorDbHelper");
        b = (TranslatorDataBase) Room.a(context, TranslatorDataBase.class, "MYVU-Translator").d();
    }
}
