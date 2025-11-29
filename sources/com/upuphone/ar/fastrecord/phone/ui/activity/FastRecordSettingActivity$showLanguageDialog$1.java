package com.upuphone.ar.fastrecord.phone.ui.activity;

import com.google.gson.Gson;
import com.upuphone.ar.fastrecord.phone.bean.FastRecordLanguageBean;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.utils.RecordDataSaveUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "languageBean", "Lcom/upuphone/ar/fastrecord/phone/bean/FastRecordLanguageBean;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordSettingActivity$showLanguageDialog$1 extends Lambda implements Function1<FastRecordLanguageBean, Unit> {
    final /* synthetic */ FastRecordSettingActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordSettingActivity$showLanguageDialog$1(FastRecordSettingActivity fastRecordSettingActivity) {
        super(1);
        this.this$0 = fastRecordSettingActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((FastRecordLanguageBean) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull FastRecordLanguageBean fastRecordLanguageBean) {
        Intrinsics.checkNotNullParameter(fastRecordLanguageBean, "languageBean");
        LogExt.logE("showLanguageDialog data = " + fastRecordLanguageBean, "FastRecordSettingActivity");
        this.this$0.mFastRecordLanguage = fastRecordLanguageBean;
        FastRecordLanguageBean access$getMFastRecordLanguage$p = this.this$0.mFastRecordLanguage;
        if (access$getMFastRecordLanguage$p != null) {
            FastRecordSettingActivity fastRecordSettingActivity = this.this$0;
            RecordDataSaveUtil recordDataSaveUtil = RecordDataSaveUtil.INSTANCE;
            String json = new Gson().toJson((Object) access$getMFastRecordLanguage$p);
            Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
            recordDataSaveUtil.setAiLanguageType(json);
            fastRecordSettingActivity.getLayout().k.setText(access$getMFastRecordLanguage$p.getLangName());
        }
    }
}
