package com.upuphone.ar.tici.phone;

import android.widget.SeekBar;
import com.airbnb.lottie.LottieAnimationView;
import com.meizu.common.widget.MzSeekBar;
import com.upuphone.ar.tici.phone.utils.CommonExtKt;
import com.upuphone.ar.tici.phone.utils.LottieExtKt;
import com.upuphone.ar.tici.phone.utils.SpUtilKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\f"}, d2 = {"com/upuphone/ar/tici/phone/TiciSettingActivity$initView$6$2", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "onProgressChanged", "", "seekBar", "Landroid/widget/SeekBar;", "progress", "", "fromUser", "", "onStartTrackingTouch", "onStopTrackingTouch", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TiciSettingActivity$initView$6$2 implements SeekBar.OnSeekBarChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TiciSettingActivity f5909a;
    public final /* synthetic */ MzSeekBar b;

    public TiciSettingActivity$initView$6$2(TiciSettingActivity ticiSettingActivity, MzSeekBar mzSeekBar) {
        this.f5909a = ticiSettingActivity;
        this.b = mzSeekBar;
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        CommonExtKt.e("onProgressChanged, progress: " + i + ", fromUser: " + z, "TiciSettingActivity");
        long I0 = this.f5909a.d1(i, this.b.getMax());
        StringBuilder sb = new StringBuilder();
        sb.append("onProgressChanged, speed: ");
        sb.append(I0);
        CommonExtKt.e(sb.toString(), "TiciSettingActivity");
        SpUtilKt.u(I0);
        this.f5909a.N0().g.k.setText(this.f5909a.k1(I0));
        LottieAnimationView lottieAnimationView = this.f5909a.N0().g.d;
        Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "lottieSpeedClock");
        LottieExtKt.e(lottieAnimationView, I0);
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
        CommonExtKt.e("onStartTrackingTouch", "TiciSettingActivity");
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        long I0 = this.f5909a.d1(this.b.getProgress(), this.b.getMax());
        CommonExtKt.e("onStopTrackingTouch: speed: " + I0, "TiciSettingActivity");
        TiciSettingActivity.j1(this.f5909a, 0, I0, 1, (Object) null);
    }
}
