package com.honey.account.s2;

import androidx.dynamicanimation.animation.DynamicAnimation;
import com.meizu.common.notice.NoticePresenter;

public final /* synthetic */ class a implements DynamicAnimation.OnAnimationUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NoticePresenter f9223a;

    public /* synthetic */ a(NoticePresenter noticePresenter) {
        this.f9223a = noticePresenter;
    }

    public final void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f2) {
        this.f9223a.lambda$handleHideAnimation$1(dynamicAnimation, f, f2);
    }
}
