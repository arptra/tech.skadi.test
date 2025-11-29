package com.upuphone.ar.transcribe.phone.activity;

import androidx.fragment.app.FragmentActivity;
import com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean;
import com.upuphone.ar.transcribe.phone.vm.AiTodoViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class AiToDoFragment$initViews$4 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AiToDoFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AiToDoFragment$initViews$4(AiToDoFragment aiToDoFragment) {
        super(0);
        this.this$0 = aiToDoFragment;
    }

    public final void invoke() {
        String str;
        AiTodoViewModel access$getTodoViewModel = this.this$0.getTodoViewModel();
        FragmentActivity requireActivity = this.this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        TranscribeBean access$getNotebean$p = this.this$0.notebean;
        if (access$getNotebean$p == null || (str = access$getNotebean$p.getRecognizeId()) == null) {
            str = "";
        }
        access$getTodoViewModel.t(requireActivity, str);
    }
}
