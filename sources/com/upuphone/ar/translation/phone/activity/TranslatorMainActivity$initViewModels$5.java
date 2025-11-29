package com.upuphone.ar.translation.phone.activity;

import android.widget.TextView;
import com.upuphone.ar.translation.phone.R;
import com.upuphone.ar.translation.phone.bean.NoteBean;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "", "Lcom/upuphone/ar/translation/phone/bean/NoteBean;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TranslatorMainActivity$initViewModels$5 extends Lambda implements Function1<List<? extends NoteBean>, Unit> {
    final /* synthetic */ TranslatorMainActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslatorMainActivity$initViewModels$5(TranslatorMainActivity translatorMainActivity) {
        super(1);
        this.this$0 = translatorMainActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<NoteBean>) (List) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(List<NoteBean> list) {
        Intrinsics.checkNotNull(list);
        if (!list.isEmpty()) {
            TextView textView = this.this$0.getMBinding().s;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = this.this$0.getString(R.string.tl_selected_options);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String format = String.format(string, Arrays.copyOf(new Object[]{String.valueOf(list.size())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            textView.setText(format);
            this.this$0.getMBinding().i.setEnabled(true);
            this.this$0.getMBinding().r.setEnabled(true);
            return;
        }
        this.this$0.getMBinding().s.setText(R.string.tl_select_options);
        this.this$0.getMBinding().i.setEnabled(false);
        this.this$0.getMBinding().r.setEnabled(false);
    }
}
