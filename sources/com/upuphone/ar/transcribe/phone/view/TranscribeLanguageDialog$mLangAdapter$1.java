package com.upuphone.ar.transcribe.phone.view;

import android.view.View;
import com.meizu.common.widget.ScrollTextView;
import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.phone.bean.LanguageBean;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\"\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"com/upuphone/ar/transcribe/phone/view/TranscribeLanguageDialog$mLangAdapter$1", "Lcom/meizu/common/widget/ScrollTextView$IDataAdapter;", "getItemText", "", "position", "", "onChanged", "", "view", "Landroid/view/View;", "fromOld", "toNew", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TranscribeLanguageDialog$mLangAdapter$1 implements ScrollTextView.IDataAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TranscribeLanguageDialog f6138a;

    public TranscribeLanguageDialog$mLangAdapter$1(TranscribeLanguageDialog transcribeLanguageDialog) {
        this.f6138a = transcribeLanguageDialog;
    }

    public String getItemText(int i) {
        return ((LanguageBean) this.f6138a.g().get(i)).getLangName();
    }

    public void onChanged(View view, int i, int i2) {
        LogExt.d("onChanged fromOld=" + i + ", toNew=" + i2, "TranscribeLangDialog");
    }
}
