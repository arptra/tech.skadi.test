package com.upuphone.xr.sapp.fragment;

import androidx.viewpager.widget.ViewPager;
import com.luck.picture.lib.entity.LocalMedia;
import com.upuphone.xr.sapp.databinding.FragmentMediaShowListBinding;
import com.upuphone.xr.sapp.fragment.MediaShowListFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"com/upuphone/xr/sapp/fragment/MediaShowListFragment$initView$3", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MediaShowListFragment$initView$3 implements ViewPager.OnPageChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MediaShowListFragment f6981a;

    public MediaShowListFragment$initView$3(MediaShowListFragment mediaShowListFragment) {
        this.f6981a = mediaShowListFragment;
    }

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    public void onPageSelected(int i) {
        this.f6981a.o = i;
        FragmentMediaShowListBinding D0 = this.f6981a.j;
        if (D0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            D0 = null;
        }
        D0.d.setSelected(((LocalMedia) this.f6981a.k.get(i)).isChecked());
        MediaShowListFragment.MediaShowAdapter E0 = this.f6981a.n;
        Intrinsics.checkNotNull(E0);
        E0.f();
    }
}
