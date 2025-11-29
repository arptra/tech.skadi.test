package com.upuphone.ar.tici.phone;

import android.widget.SeekBar;
import com.upuphone.ar.tici.phone.utils.CommonExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"com/upuphone/ar/tici/phone/TiciMainActivity$initViews$8", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "onProgressChanged", "", "seekBar", "Landroid/widget/SeekBar;", "progress", "", "fromUser", "", "onStartTrackingTouch", "onStopTrackingTouch", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TiciMainActivity$initViews$8 implements SeekBar.OnSeekBarChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TiciMainActivity f5901a;

    public TiciMainActivity$initViews$8(TiciMainActivity ticiMainActivity) {
        this.f5901a = ticiMainActivity;
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        Intrinsics.checkNotNullParameter(seekBar, "seekBar");
        int progress = seekBar.getProgress();
        CommonExtKt.e("onProgressChanged-> " + progress + ", fromUser: " + z, "TiciMainActivity");
        if (this.f5901a.c1()) {
            CommonExtKt.e("onProgressChanged-> blockTiciProgress=true", "TiciMainActivity");
        } else if (z) {
            this.f5901a.e1().A(i, false);
        }
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        Intrinsics.checkNotNullParameter(seekBar, "seekBar");
        int progress = seekBar.getProgress();
        CommonExtKt.e("onStopTrackingTouch-> " + progress, "TiciMainActivity");
        if (this.f5901a.c1()) {
            CommonExtKt.e("onStopTrackingTouch-> blockTiciProgress=true", "TiciMainActivity");
        } else {
            this.f5901a.e1().A(seekBar.getProgress(), true);
        }
    }
}
