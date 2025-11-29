package com.upuphone.ar.tici.phone;

import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.upuphone.ar.tici.phone.data.ScanFileState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nTiciImportFileActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TiciImportFileActivity.kt\ncom/upuphone/ar/tici/phone/TiciImportFileActivity$initViewModels$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,197:1\n262#2,2:198\n262#2,2:200\n262#2,2:202\n262#2,2:204\n262#2,2:206\n262#2,2:208\n*S KotlinDebug\n*F\n+ 1 TiciImportFileActivity.kt\ncom/upuphone/ar/tici/phone/TiciImportFileActivity$initViewModels$1\n*L\n134#1:198,2\n135#1:200,2\n136#1:202,2\n140#1:204,2\n141#1:206,2\n143#1:208,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/ar/tici/phone/data/ScanFileState;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TiciImportFileActivity$initViewModels$1 extends Lambda implements Function1<ScanFileState, Unit> {
    final /* synthetic */ TiciImportFileActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciImportFileActivity$initViewModels$1(TiciImportFileActivity ticiImportFileActivity) {
        super(1);
        this.this$0 = ticiImportFileActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ScanFileState) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ScanFileState scanFileState) {
        int i = 0;
        if (scanFileState instanceof ScanFileState.Loading) {
            LinearLayout linearLayout = this.this$0.H0().f;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "layLoading");
            linearLayout.setVisibility(0);
            RecyclerView recyclerView = this.this$0.H0().c;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "filesRecyclerview");
            recyclerView.setVisibility(8);
            LinearLayout linearLayout2 = this.this$0.H0().e;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "layEmptyFile");
            linearLayout2.setVisibility(8);
        } else if (scanFileState instanceof ScanFileState.Success) {
            LinearLayout linearLayout3 = this.this$0.H0().f;
            Intrinsics.checkNotNullExpressionValue(linearLayout3, "layLoading");
            linearLayout3.setVisibility(8);
            RecyclerView recyclerView2 = this.this$0.H0().c;
            Intrinsics.checkNotNullExpressionValue(recyclerView2, "filesRecyclerview");
            recyclerView2.setVisibility(0);
            ScanFileState.Success success = (ScanFileState.Success) scanFileState;
            this.this$0.G0().refreshData(success.a());
            LinearLayout linearLayout4 = this.this$0.H0().e;
            Intrinsics.checkNotNullExpressionValue(linearLayout4, "layEmptyFile");
            if (!success.a().isEmpty()) {
                i = 8;
            }
            linearLayout4.setVisibility(i);
        }
    }
}
