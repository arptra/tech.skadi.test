package com.upuphone.ar.fastrecord.phone.ui.fragment;

import androidx.fragment.app.FragmentActivity;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.phone.http.HttpRequestManger;
import com.upuphone.star.common.phone.UToast;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordTodoFragment$initViewModel$3 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ FastRecordTodoFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordTodoFragment$initViewModel$3(FastRecordTodoFragment fastRecordTodoFragment) {
        super(1);
        this.this$0 = fastRecordTodoFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable String str) {
        String str2;
        this.this$0.showFailView();
        if (HttpRequestManger.INSTANCE.isRequestSensitive(str)) {
            str2 = this.this$0.requireActivity().getString(R.string.fr_extract_sensitive_req_tips);
        } else {
            str2 = this.this$0.requireActivity().getString(R.string.fr_extract_sensitive_rep_tips);
        }
        Intrinsics.checkNotNull(str2);
        UToast.Companion companion = UToast.f6444a;
        FragmentActivity requireActivity = this.this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        companion.d(requireActivity, str2);
    }
}
