package com.upuphone.ar.fastrecord.phone.ui.activity;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.starrynet.bean.glass.RecordGlassCacheInfo;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel;
import com.upuphone.ar.fastrecord.phone.utils.RecordDataSaveUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nFastRecordMainActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordMainActivity.kt\ncom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordMainActivity$initViewModel$5\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,558:1\n262#2,2:559\n262#2,2:561\n*S KotlinDebug\n*F\n+ 1 FastRecordMainActivity.kt\ncom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordMainActivity$initViewModel$5\n*L\n428#1:559,2\n433#1:561,2\n*E\n"})
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "cacheInfo", "Lcom/upuphone/ar/fastrecord/phone/starrynet/bean/glass/RecordGlassCacheInfo;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordMainActivity$initViewModel$5 extends Lambda implements Function1<RecordGlassCacheInfo, Unit> {
    final /* synthetic */ FastRecordMainActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordMainActivity$initViewModel$5(FastRecordMainActivity fastRecordMainActivity) {
        super(1);
        this.this$0 = fastRecordMainActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((RecordGlassCacheInfo) obj);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: type inference failed for: r1v2, types: [boolean] */
    public final void invoke(@Nullable RecordGlassCacheInfo recordGlassCacheInfo) {
        if (recordGlassCacheInfo != null) {
            FastRecordMainActivity fastRecordMainActivity = this.this$0;
            FastRecordManager.Companion companion = FastRecordManager.Companion;
            ? recordConnectState = companion.getInstance().appViewModel().getRecordConnectState();
            LogExt.logW("recordGlassCacheInfo value = " + recordGlassCacheInfo + ",connectState = " + recordConnectState, "FastRecordMainActivity");
            if (recordGlassCacheInfo.getFinish() == 1 || companion.getInstance().appViewModel().getRecordConnectState() == null) {
                fastRecordMainActivity.getLayout().b.getRoot().setVisibility(8);
                ProgressBar progressBar = fastRecordMainActivity.getLayout().b.b;
                Intrinsics.checkNotNullExpressionValue(progressBar, "loadingProgress");
                progressBar.setVisibility(8);
                FastRecordMainViewModel access$getViewModel$p = fastRecordMainActivity.viewModel;
                if (access$getViewModel$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    access$getViewModel$p = null;
                }
                access$getViewModel$p.reQueryFastRecordList();
                return;
            }
            fastRecordMainActivity.getLayout().b.getRoot().setVisibility(0);
            ProgressBar progressBar2 = fastRecordMainActivity.getLayout().b.b;
            Intrinsics.checkNotNullExpressionValue(progressBar2, "loadingProgress");
            progressBar2.setVisibility(0);
            RecordDataSaveUtil recordDataSaveUtil = RecordDataSaveUtil.INSTANCE;
            long downLoadCancelSize = recordDataSaveUtil.getDownLoadCancelSize() + recordGlassCacheInfo.getTotalSize();
            int downLoadCancelSize2 = (int) ((((float) recordDataSaveUtil.getDownLoadCancelSize()) / ((float) downLoadCancelSize)) * ((float) 100));
            LogExt.logW("recordGlassCacheInfo totalSize = " + downLoadCancelSize + ",progress = " + downLoadCancelSize2, "FastRecordMainActivity");
            TextView textView = fastRecordMainActivity.getLayout().b.d;
            StringBuilder sb = new StringBuilder();
            sb.append(downLoadCancelSize2);
            sb.append("%");
            textView.setText(sb.toString());
            fastRecordMainActivity.getLayout().b.b.setProgress(downLoadCancelSize2);
        }
    }
}
