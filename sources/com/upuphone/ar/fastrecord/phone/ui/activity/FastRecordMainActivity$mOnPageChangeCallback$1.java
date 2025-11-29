package com.upuphone.ar.fastrecord.phone.ui.activity;

import androidx.viewpager.widget.ViewPager;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"com/upuphone/ar/fastrecord/phone/ui/activity/FastRecordMainActivity$mOnPageChangeCallback$1", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FastRecordMainActivity$mOnPageChangeCallback$1 implements ViewPager.OnPageChangeListener {
    final /* synthetic */ FastRecordMainActivity this$0;

    public FastRecordMainActivity$mOnPageChangeCallback$1(FastRecordMainActivity fastRecordMainActivity) {
        this.this$0 = fastRecordMainActivity;
    }

    public void onPageScrollStateChanged(int i) {
        LogExt.logE("onPageScrollStateChanged  " + i, "FastRecordMainActivity");
    }

    public void onPageScrolled(int i, float f, int i2) {
        LogExt.logE("onPageScrolled  " + i + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA + f + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA + i2, "FastRecordMainActivity");
    }

    public void onPageSelected(int i) {
        FastRecordMainViewModel access$getViewModel$p = this.this$0.viewModel;
        if (access$getViewModel$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            access$getViewModel$p = null;
        }
        Object obj = this.this$0.tabTypes.get(i);
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        access$getViewModel$p.setCurPage((String) obj);
    }
}
