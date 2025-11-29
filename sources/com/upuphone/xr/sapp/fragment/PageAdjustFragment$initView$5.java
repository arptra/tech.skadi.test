package com.upuphone.xr.sapp.fragment;

import com.meizu.common.widget.StepSeekBar;
import com.upuphone.star.core.log.ULog;
import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u000b"}, d2 = {"com/upuphone/xr/sapp/fragment/PageAdjustFragment$initView$5", "Lcom/meizu/common/widget/StepSeekBar$OnStepSeekBarChangeListener;", "onProgressChanged", "", "seekBar", "Lcom/meizu/common/widget/StepSeekBar;", "progress", "", "onProgressDragging", "onStartTrackingTouch", "onStopTrackingTouch", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PageAdjustFragment$initView$5 implements StepSeekBar.OnStepSeekBarChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PageAdjustFragment f6989a;

    public PageAdjustFragment$initView$5(PageAdjustFragment pageAdjustFragment) {
        this.f6989a = pageAdjustFragment;
    }

    public void onProgressChanged(StepSeekBar stepSeekBar, int i) {
        Intrinsics.checkNotNullParameter(stepSeekBar, "seekBar");
    }

    public void onProgressDragging(StepSeekBar stepSeekBar, int i) {
        Intrinsics.checkNotNullParameter(stepSeekBar, "seekBar");
        this.f6989a.n.setRotate(new BigDecimal(((double) (stepSeekBar.getProgress() - 30)) * 0.1d).setScale(1, 1).doubleValue());
        ULog.Delegate delegate = ULog.f6446a;
        int progress = stepSeekBar.getProgress();
        double rotate = this.f6989a.n.getRotate();
        delegate.a("PageAdjustFragment", "onStopTrackingTouch progress:" + progress + " hor_bias:" + rotate);
        this.f6989a.P0();
    }

    public void onStartTrackingTouch(StepSeekBar stepSeekBar) {
    }

    public void onStopTrackingTouch(StepSeekBar stepSeekBar) {
        Intrinsics.checkNotNullParameter(stepSeekBar, "seekBar");
        this.f6989a.O0();
    }
}
