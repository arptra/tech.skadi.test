package com.upuphone.xr.sapp.fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.upuphone.xr.sapp.monitor.notification.model.AppInfoModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/upuphone/xr/sapp/fragment/PhoneNotifyFragment$resetView$2$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PhoneNotifyFragment$resetView$2$1 extends RecyclerView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LinearLayoutManager f6998a;
    public final /* synthetic */ PhoneNotifyFragment b;

    public PhoneNotifyFragment$resetView$2$1(LinearLayoutManager linearLayoutManager, PhoneNotifyFragment phoneNotifyFragment) {
        this.f6998a = linearLayoutManager;
        this.b = phoneNotifyFragment;
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i, i2);
        int findFirstVisibleItemPosition = this.f6998a.findFirstVisibleItemPosition();
        if (findFirstVisibleItemPosition >= 0) {
            Object obj = this.b.m.get(findFirstVisibleItemPosition);
            Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
            this.b.U0().b.getNavigationLayout().setCurrentLetterFormScrolling(0, ((AppInfoModel) obj).getLetter());
        }
    }
}
