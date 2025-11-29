package com.chad.library.adapter.base.module;

import android.view.View;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
public final class BaseLoadMoreModule$setupViewHolder$1 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaseLoadMoreModule f2800a;

    public BaseLoadMoreModule$setupViewHolder$1(BaseLoadMoreModule baseLoadMoreModule) {
        this.f2800a = baseLoadMoreModule;
    }

    public final void onClick(View view) {
        if (this.f2800a.h() == LoadMoreStatus.Fail) {
            this.f2800a.o();
        } else if (this.f2800a.h() == LoadMoreStatus.Complete) {
            this.f2800a.o();
        } else if (this.f2800a.g() && this.f2800a.h() == LoadMoreStatus.End) {
            this.f2800a.o();
        }
    }
}
