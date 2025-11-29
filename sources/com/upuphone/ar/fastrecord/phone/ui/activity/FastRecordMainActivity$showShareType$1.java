package com.upuphone.ar.fastrecord.phone.ui.activity;

import com.upuphone.ar.fastrecord.phone.ui.dialog.FastRecordShareDialog;
import com.upuphone.ar.fastrecord.phone.utils.RecordConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordMainActivity$showShareType$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ FastRecordMainActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordMainActivity$showShareType$1(FastRecordMainActivity fastRecordMainActivity) {
        super(1);
        this.this$0 = fastRecordMainActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        FastRecordShareDialog fastRecordShareDialog = new FastRecordShareDialog(this.this$0);
        fastRecordShareDialog.setShowType(i);
        final FastRecordMainActivity fastRecordMainActivity = this.this$0;
        AnonymousClass1 r1 = new Function0<Unit>() {
            public final void invoke() {
                fastRecordMainActivity.shareByType(RecordConstants.SHARE_TYPE_VIDEO_WORD);
            }
        };
        final FastRecordMainActivity fastRecordMainActivity2 = this.this$0;
        AnonymousClass2 r2 = new Function0<Unit>() {
            public final void invoke() {
                fastRecordMainActivity2.shareByType(RecordConstants.SHARE_TYPE_VIDEO);
            }
        };
        final FastRecordMainActivity fastRecordMainActivity3 = this.this$0;
        FastRecordShareDialog.registerButtonClick$default(fastRecordShareDialog, r1, r2, new Function0<Unit>() {
            public final void invoke() {
                fastRecordMainActivity3.shareByType(RecordConstants.SHARE_TYPE_WORD);
            }
        }, (Function0) null, 8, (Object) null);
        fastRecordShareDialog.show();
    }
}
