package com.upuphone.ar.translation.phone.helper;

import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.bean.NoteBean;
import com.xjsd.xr.sapp.asr.callback.ISmartExCallback;
import com.xjsd.xr.sapp.asr.callback.SmartExCallback;
import com.xjsd.xr.sapp.asr.dao.SensitivePayload;
import com.xjsd.xr.sapp.asr.dao.SmartExSummary;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"com/upuphone/ar/translation/phone/helper/TranslatorSmExHelper$getSummary$helper$1$1", "Lcom/xjsd/xr/sapp/asr/callback/SmartExCallback;", "onSummary", "", "summary", "Lcom/xjsd/xr/sapp/asr/dao/SmartExSummary;", "onSummarySensitive", "sensitive", "Lcom/xjsd/xr/sapp/asr/dao/SensitivePayload;", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TranslatorSmExHelper$getSummary$helper$1$1 extends SmartExCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TranslatorSmExHelper f6313a;
    public final /* synthetic */ String b;
    public final /* synthetic */ NoteBean c;

    public TranslatorSmExHelper$getSummary$helper$1$1(TranslatorSmExHelper translatorSmExHelper, String str, NoteBean noteBean) {
        this.f6313a = translatorSmExHelper;
        this.b = str;
        this.c = noteBean;
    }

    public void onSummary(SmartExSummary smartExSummary) {
        ISmartExCallback iSmartExCallback = (ISmartExCallback) this.f6313a.c.get(this.b);
        LogExt.j("getSummary callback=" + iSmartExCallback + ", summary=" + smartExSummary, "TranslatorSmExHelper");
        if (iSmartExCallback != null) {
            iSmartExCallback.onSummary(smartExSummary);
        } else {
            TranslatorSmExHelper translatorSmExHelper = this.f6313a;
            NoteBean noteBean = this.c;
            if (smartExSummary != null) {
                translatorSmExHelper.k(smartExSummary, noteBean);
            }
        }
        this.f6313a.b.remove(this.b);
    }

    public void onSummarySensitive(SensitivePayload sensitivePayload) {
        ISmartExCallback iSmartExCallback = (ISmartExCallback) this.f6313a.c.get(this.b);
        LogExt.j("getSummary callback=" + iSmartExCallback + ", sensitive=" + sensitivePayload, "TranslatorSmExHelper");
        if (iSmartExCallback != null) {
            iSmartExCallback.onSummarySensitive(sensitivePayload);
        }
        this.f6313a.b.remove(this.b);
    }
}
