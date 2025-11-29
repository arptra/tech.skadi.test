package com.upuphone.ar.fastrecord.phone.ui.activity;

import android.widget.ProgressBar;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nFastRecordMainActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordMainActivity.kt\ncom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordMainActivity$initViewModel$6\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,558:1\n262#2,2:559\n*S KotlinDebug\n*F\n+ 1 FastRecordMainActivity.kt\ncom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordMainActivity$initViewModel$6\n*L\n448#1:559,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordMainActivity$initViewModel$6 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ FastRecordMainActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordMainActivity$initViewModel$6(FastRecordMainActivity fastRecordMainActivity) {
        super(1);
        this.this$0 = fastRecordMainActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Boolean) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Boolean bool) {
        if (Intrinsics.areEqual((Object) bool, (Object) Boolean.FALSE)) {
            LogExt.logE("recordConnectState is false", "FastRecordMainActivity");
            this.this$0.getLayout().b.getRoot().setVisibility(8);
            ProgressBar progressBar = this.this$0.getLayout().b.b;
            Intrinsics.checkNotNullExpressionValue(progressBar, "loadingProgress");
            progressBar.setVisibility(8);
        }
    }
}
