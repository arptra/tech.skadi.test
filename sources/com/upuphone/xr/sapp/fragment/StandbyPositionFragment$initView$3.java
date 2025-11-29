package com.upuphone.xr.sapp.fragment;

import android.os.Message;
import com.upuphone.ar.translation.statemachine.annotation.MSG;
import com.upuphone.xr.sapp.view.CustomRadioGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/upuphone/xr/sapp/fragment/StandbyPositionFragment$initView$3", "Lcom/upuphone/xr/sapp/view/CustomRadioGroup$OnCheckedChangeListener;", "Lcom/upuphone/xr/sapp/view/CustomRadioGroup;", "group", "", "checkedId", "", "a", "(Lcom/upuphone/xr/sapp/view/CustomRadioGroup;I)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class StandbyPositionFragment$initView$3 implements CustomRadioGroup.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StandbyPositionFragment f7007a;

    public StandbyPositionFragment$initView$3(StandbyPositionFragment standbyPositionFragment) {
        this.f7007a = standbyPositionFragment;
    }

    public void a(CustomRadioGroup customRadioGroup, int i) {
        this.f7007a.A.removeMessages(MSG.REMOTE_MSG_TRANSLATE_RESULT_SHOW);
        Message obtainMessage = this.f7007a.A.obtainMessage(MSG.REMOTE_MSG_TRANSLATE_RESULT_SHOW);
        obtainMessage.arg1 = i;
        Intrinsics.checkNotNullExpressionValue(obtainMessage, "apply(...)");
        this.f7007a.A.sendMessageDelayed(obtainMessage, 500);
    }
}
