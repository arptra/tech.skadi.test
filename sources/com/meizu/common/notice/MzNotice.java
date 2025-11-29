package com.meizu.common.notice;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import com.meizu.common.R;
import com.meizu.common.notice.NoticePresenter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class MzNotice {
    public static final int LENGTH_DEFAULT = 0;
    public static final int LENGTH_NEGATIVE = -1;
    private final NoticePresenter.NoticeParams P;
    private final NoticePresenter mPresenter;

    public static class Builder {
        NoticePresenter.NoticeParams P;

        public Builder(Context context) {
            this.P = new NoticePresenter.NoticeParams(context);
        }

        public MzNotice create() {
            return new MzNotice(this.P);
        }

        public Builder setDrawable(Drawable drawable) {
            this.P.drawable = drawable;
            return this;
        }

        public Builder setDuration(int i) {
            this.P.duration = i;
            return this;
        }

        public Builder setDynamic(boolean z) {
            this.P.dynamic = z;
            return this;
        }

        public Builder setNotice(String str) {
            this.P.notice = str;
            return this;
        }

        public Builder setNoticeTextColor(@ColorInt int i) {
            this.P.noticeColor = i;
            return this;
        }

        public Builder setNoticeTextSize(int i) {
            this.P.noticeTextSize = i;
            return this;
        }

        public Builder setTip(String str) {
            this.P.tips = str;
            return this;
        }

        public Builder setTipsTextColor(@ColorInt int i) {
            this.P.tipColor = i;
            return this;
        }

        public Builder setTipsTextSize(int i) {
            this.P.tipTextSize = i;
            return this;
        }

        public Builder setView(ViewGroup viewGroup) {
            NoticePresenter.NoticeParams noticeParams = this.P;
            noticeParams.view = viewGroup;
            noticeParams.hasCustomView = true;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Duration {
    }

    public void cancel() {
        this.mPresenter.hide();
    }

    public boolean isShowing() {
        return this.mPresenter.isShowing();
    }

    public void show() {
        this.mPresenter.show(this.P);
    }

    private MzNotice(NoticePresenter.NoticeParams noticeParams) {
        NoticePresenter noticePresenter = NoticePresenter.get();
        this.mPresenter = noticePresenter;
        noticeParams.yOffset = noticeParams.context.getResources().getDimensionPixelSize(R.dimen.mz_notice_margin_top);
        noticeParams.gravity = 48;
        this.P = noticeParams;
        noticePresenter.init(noticeParams.context);
    }
}
