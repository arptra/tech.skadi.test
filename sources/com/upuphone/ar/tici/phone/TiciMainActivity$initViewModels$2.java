package com.upuphone.ar.tici.phone;

import android.widget.ScrollView;
import android.widget.TextView;
import com.upuphone.ar.tici.phone.data.ParagraphProgress;
import com.upuphone.ar.tici.phone.data.TiciInfo;
import com.upuphone.ar.tici.phone.starrynet.msg.ParagraphItem;
import com.upuphone.ar.tici.phone.utils.CommonExtKt;
import com.upuphone.ar.tici.phone.utils.ParagraphHelper;
import com.upuphone.ar.tici.phone.utils.SpUtilKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "paragraphProgress", "Lcom/upuphone/ar/tici/phone/data/ParagraphProgress;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TiciMainActivity$initViewModels$2 extends Lambda implements Function1<ParagraphProgress, Unit> {
    final /* synthetic */ TiciMainActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciMainActivity$initViewModels$2(TiciMainActivity ticiMainActivity) {
        super(1);
        this.this$0 = ticiMainActivity;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$3(TiciMainActivity ticiMainActivity, TiciInfo ticiInfo, ParagraphItem paragraphItem) {
        Intrinsics.checkNotNullParameter(ticiMainActivity, "this$0");
        Intrinsics.checkNotNullParameter(ticiInfo, "$ticiInfo");
        Intrinsics.checkNotNullParameter(paragraphItem, "$paragraph");
        ParagraphHelper.Companion companion = ParagraphHelper.f5995a;
        TextView textView = ticiMainActivity.d1().p;
        Intrinsics.checkNotNullExpressionValue(textView, "ticiContent");
        Integer e = companion.e(textView, ticiInfo.getCurrentSourceText(), paragraphItem.getStart(), paragraphItem.getEnd(), ticiMainActivity.f);
        if (e != null) {
            int intValue = e.intValue();
            ScrollView scrollView = ticiMainActivity.d1().d;
            Intrinsics.checkNotNullExpressionValue(scrollView, "contentScrollView");
            TextView textView2 = ticiMainActivity.d1().p;
            Intrinsics.checkNotNullExpressionValue(textView2, "ticiContent");
            companion.g(scrollView, textView2, intValue);
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ParagraphProgress) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ParagraphProgress paragraphProgress) {
        boolean v0 = this.this$0.d.v0();
        CommonExtKt.e("curParagraphProgress, paragraphProgress: " + paragraphProgress + ", isAutoTiciRunning: " + v0, "TiciMainActivity");
        TiciInfo r = this.this$0.e1().r();
        if (r == null) {
            CommonExtKt.d("curParagraphProgress, currentTxtInfo is null", "TiciMainActivity", (Throwable) null, 2, (Object) null);
            return;
        }
        if (this.this$0.d1().u.getMax() != 1) {
            this.this$0.d1().u.setProgress(paragraphProgress.getProgress());
        } else if (r.getTotalParagraphSize() == 1) {
            this.this$0.d1().u.setProgress(1);
            CommonExtKt.d("curParagraphProgress, max=1, fix it", "TiciMainActivity", (Throwable) null, 2, (Object) null);
        } else {
            this.this$0.d1().u.setProgress(paragraphProgress.getProgress());
        }
        if (SpUtilKt.j() == 1) {
            this.this$0.d1().j.setProgress(0.0f);
            this.this$0.d1().k.setProgress(0.0f);
            if (v0) {
                this.this$0.d1().j.playAnimation();
            }
        }
        ParagraphItem paragraphItem = (ParagraphItem) CollectionsKt.getOrNull(r.getCurrentParagraphItems(), paragraphProgress.getPageInfo().getIndex());
        if (paragraphItem == null) {
            CommonExtKt.d("curParagraphProgress, index out of range", "TiciMainActivity", (Throwable) null, 2, (Object) null);
            return;
        }
        CommonExtKt.e("curParagraphProgress, paragraph: " + paragraphItem, "TiciMainActivity");
        this.this$0.d1().p.post(new b(this.this$0, r, paragraphItem));
    }
}
