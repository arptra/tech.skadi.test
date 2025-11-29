package com.upuphone.ar.transcribe.phone.activity;

import androidx.viewpager2.widget.ViewPager2;
import com.upuphone.ar.transcribe.ext.LogExt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/upuphone/ar/transcribe/phone/activity/TranscribeAIActivity$mOnPageChangeCallback$1", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageSelected", "", "position", "", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TranscribeAIActivity$mOnPageChangeCallback$1 extends ViewPager2.OnPageChangeCallback {
    public void onPageSelected(int i) {
        super.onPageSelected(i);
        LogExt.g("PageChangeCallback position=" + i, "TranscribeAIActivity");
    }
}
