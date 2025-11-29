package com.upuphone.xr.sapp.fragment;

import android.graphics.drawable.Drawable;
import com.meizu.common.widget.CircularProgressButton;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.databinding.FragmentTouchpadBinding;
import com.upuphone.xr.sapp.entity.GlassScreenShotState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/xr/sapp/entity/GlassScreenShotState;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TouchpadFragment$initViewModel$1 extends Lambda implements Function1<GlassScreenShotState, Unit> {
    final /* synthetic */ TouchpadFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TouchpadFragment$initViewModel$1(TouchpadFragment touchpadFragment) {
        super(1);
        this.this$0 = touchpadFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GlassScreenShotState) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(GlassScreenShotState glassScreenShotState) {
        FragmentTouchpadBinding H0;
        CircularProgressButton circularProgressButton;
        CircularProgressButton circularProgressButton2;
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("TouchpadFragment", "screenShotState: " + glassScreenShotState);
        if (glassScreenShotState instanceof GlassScreenShotState.Idle) {
            TouchpadFragment.d1(this.this$0, 0, 1, (Object) null);
        } else if (glassScreenShotState instanceof GlassScreenShotState.Running) {
            FragmentTouchpadBinding H02 = this.this$0.j;
            if (H02 != null && (circularProgressButton2 = H02.d) != null) {
                circularProgressButton2.setBackground((Drawable) null);
                circularProgressButton2.setState(CircularProgressButton.State.PROGRESS, false, false);
                circularProgressButton2.setProgress(Math.max(((GlassScreenShotState.Running) glassScreenShotState).getProgress(), 1), false);
            }
        } else if ((glassScreenShotState instanceof GlassScreenShotState.Success) && (H0 = this.this$0.j) != null && (circularProgressButton = H0.d) != null) {
            circularProgressButton.setState(CircularProgressButton.State.COMPLETE, false, false);
        }
    }
}
