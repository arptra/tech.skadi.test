package com.honey.account.s2;

import androidx.dynamicanimation.animation.DynamicAnimation;
import com.meizu.common.notice.NoticePresenter;

public final /* synthetic */ class b implements DynamicAnimation.OnAnimationEndListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NoticePresenter f9224a;

    public /* synthetic */ b(NoticePresenter noticePresenter) {
        this.f9224a = noticePresenter;
    }

    public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z, float f, float f2) {
        this.f9224a.lambda$handleHideAnimation$2(dynamicAnimation, z, f, f2);
    }
}
