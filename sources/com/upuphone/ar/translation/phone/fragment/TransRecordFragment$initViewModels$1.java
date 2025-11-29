package com.upuphone.ar.translation.phone.fragment;

import com.upuphone.ar.translation.phone.adapter.NoteListAdapter;
import com.upuphone.ar.translation.phone.bean.NoteBean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TransRecordFragment$initViewModels$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ TransRecordFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TransRecordFragment$initViewModels$1(TransRecordFragment transRecordFragment) {
        super(1);
        this.this$0 = transRecordFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Boolean) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Boolean bool) {
        Intrinsics.checkNotNull(bool);
        if (!bool.booleanValue()) {
            NoteListAdapter n0 = this.this$0.d;
            if (n0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecordAdapter");
                n0 = null;
            }
            if (n0.x0()) {
                NoteListAdapter n02 = this.this$0.d;
                if (n02 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRecordAdapter");
                    n02 = null;
                }
                n02.y0(false, false);
                this.this$0.z0().k(false);
                NoteListAdapter n03 = this.this$0.d;
                if (n03 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRecordAdapter");
                    n03 = null;
                }
                for (NoteBean noteBean : n03.getData()) {
                    NoteListAdapter n04 = this.this$0.d;
                    if (n04 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mRecordAdapter");
                        n04 = null;
                    }
                    int Q = n04.Q(noteBean);
                    noteBean.setDeleted(false);
                    NoteListAdapter n05 = this.this$0.d;
                    if (n05 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mRecordAdapter");
                        n05 = null;
                    }
                    n05.j0(Q, noteBean);
                }
            }
        }
    }
}
