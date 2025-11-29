package com.upuphone.ar.tici.phone;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.upuphone.ar.tici.phone.data.TiciInfo;
import com.upuphone.ar.tici.phone.data.TiciInfoKt;
import com.upuphone.ar.tici.phone.data.TiciInfoState;
import com.upuphone.ar.tici.phone.utils.CommonExtKt;
import com.upuphone.ar.tici.phone.utils.ParagraphHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nTiciMainActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TiciMainActivity.kt\ncom/upuphone/ar/tici/phone/TiciMainActivity$initViewModels$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,760:1\n262#2,2:761\n*S KotlinDebug\n*F\n+ 1 TiciMainActivity.kt\ncom/upuphone/ar/tici/phone/TiciMainActivity$initViewModels$1\n*L\n223#1:761,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/ar/tici/phone/data/TiciInfoState;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TiciMainActivity$initViewModels$1 extends Lambda implements Function1<TiciInfoState, Unit> {
    final /* synthetic */ TiciMainActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciMainActivity$initViewModels$1(TiciMainActivity ticiMainActivity) {
        super(1);
        this.this$0 = ticiMainActivity;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(TiciMainActivity ticiMainActivity) {
        Intrinsics.checkNotNullParameter(ticiMainActivity, "this$0");
        ParagraphHelper.Companion companion = ParagraphHelper.f5995a;
        TextView textView = ticiMainActivity.d1().p;
        Intrinsics.checkNotNullExpressionValue(textView, "ticiContent");
        List d = companion.d(textView);
        ticiMainActivity.f.clear();
        ticiMainActivity.f.addAll(d);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TiciInfoState) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(TiciInfoState ticiInfoState) {
        LinearLayout linearLayout = this.this$0.d1().g;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "layLoading");
        linearLayout.setVisibility(ticiInfoState instanceof TiciInfoState.Loading ? 0 : 8);
        TiciInfo r = this.this$0.e1().r();
        if (r == null) {
            CommonExtKt.d("lastTxtInfoState, currentTxtInfo is null", "TiciMainActivity", (Throwable) null, 2, (Object) null);
            return;
        }
        int size = r.getCurrentParagraphItems().size();
        int length = r.getCurrentSourceText().length();
        CommonExtKt.b("lastTxtInfoState, paragraphSize: " + size + ", sourceTextSize: " + length, "TiciMainActivity");
        this.this$0.d1().r.setText(TiciInfoKt.a(r));
        this.this$0.d1().p.setText(r.getCurrentSourceText());
        this.this$0.d1().p.post(new a(this.this$0));
        int totalParagraphSize = r.getTotalParagraphSize();
        if (totalParagraphSize > 1) {
            this.this$0.d1().u.setMax(totalParagraphSize - 1);
            return;
        }
        this.this$0.d1().u.setMax(1);
        CommonExtKt.d("lastTxtInfoState, max=1, fix it", "TiciMainActivity", (Throwable) null, 2, (Object) null);
    }
}
