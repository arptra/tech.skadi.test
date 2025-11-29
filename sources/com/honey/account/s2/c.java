package com.honey.account.s2;

import androidx.dynamicanimation.animation.DynamicAnimation;
import com.meizu.common.notice.NoticePresenter;

public final /* synthetic */ class c implements DynamicAnimation.OnAnimationUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NoticePresenter f9225a;

    public /* synthetic */ c(NoticePresenter noticePresenter) {
        this.f9225a = noticePresenter;
    }

    public final void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f2) {
        this.f9225a.lambda$handleShowAnimation$0(dynamicAnimation, f, f2);
    }
}
