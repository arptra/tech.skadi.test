package com.upuphone.ar.fastrecord.phone.ui.activity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/upuphone/ar/fastrecord/phone/ui/activity/FastRecordMainActivity$initViewPager$4", "Landroidx/fragment/app/FragmentPagerAdapter;", "getCount", "", "getItem", "Landroidx/fragment/app/Fragment;", "position", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FastRecordMainActivity$initViewPager$4 extends FragmentPagerAdapter {
    final /* synthetic */ FastRecordMainActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordMainActivity$initViewPager$4(FastRecordMainActivity fastRecordMainActivity, FragmentManager fragmentManager) {
        super(fragmentManager, 1);
        this.this$0 = fastRecordMainActivity;
    }

    public int getCount() {
        return this.this$0.tabTitles.size();
    }

    @NotNull
    public Fragment getItem(int i) {
        Object obj = this.this$0.fragments.get(i);
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        return (Fragment) obj;
    }
}
