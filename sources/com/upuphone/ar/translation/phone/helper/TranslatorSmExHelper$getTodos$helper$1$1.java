package com.upuphone.ar.translation.phone.helper;

import android.content.Context;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.bean.NoteBean;
import com.xjsd.xr.sapp.asr.callback.ISmartExCallback;
import com.xjsd.xr.sapp.asr.callback.SmartExCallback;
import com.xjsd.xr.sapp.asr.dao.SensitivePayload;
import com.xjsd.xr.sapp.asr.dao.SmartExTodo;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"com/upuphone/ar/translation/phone/helper/TranslatorSmExHelper$getTodos$helper$1$1", "Lcom/xjsd/xr/sapp/asr/callback/SmartExCallback;", "onTodo", "", "exTodo", "Lcom/xjsd/xr/sapp/asr/dao/SmartExTodo;", "onTodoSensitive", "sensitive", "Lcom/xjsd/xr/sapp/asr/dao/SensitivePayload;", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TranslatorSmExHelper$getTodos$helper$1$1 extends SmartExCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TranslatorSmExHelper f6314a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Context c;
    public final /* synthetic */ NoteBean d;

    public TranslatorSmExHelper$getTodos$helper$1$1(TranslatorSmExHelper translatorSmExHelper, String str, Context context, NoteBean noteBean) {
        this.f6314a = translatorSmExHelper;
        this.b = str;
        this.c = context;
        this.d = noteBean;
    }

    public void onTodo(SmartExTodo smartExTodo) {
        super.onTodo(smartExTodo);
        ISmartExCallback iSmartExCallback = (ISmartExCallback) this.f6314a.c.get(this.b);
        LogExt.j("getTodos callback=" + iSmartExCallback + ", todos=" + smartExTodo, "TranslatorSmExHelper");
        if (iSmartExCallback != null) {
            iSmartExCallback.onTodo(smartExTodo);
        } else {
            TranslatorSmExHelper translatorSmExHelper = this.f6314a;
            Context context = this.c;
            NoteBean noteBean = this.d;
            if (smartExTodo != null) {
                translatorSmExHelper.l(context, smartExTodo, noteBean);
            }
        }
        this.f6314a.b.remove(this.b);
    }

    public void onTodoSensitive(SensitivePayload sensitivePayload) {
        super.onTodoSensitive(sensitivePayload);
        ISmartExCallback iSmartExCallback = (ISmartExCallback) this.f6314a.c.get(this.b);
        LogExt.j("getTodos callback=" + iSmartExCallback + ", sensitive=" + sensitivePayload, "TranslatorSmExHelper");
        if (iSmartExCallback != null) {
            iSmartExCallback.onTodoSensitive(sensitivePayload);
        }
        this.f6314a.b.remove(this.b);
    }
}
