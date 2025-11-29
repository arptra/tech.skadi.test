package com.meizu.common.notice;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.meizu.common.notice.NoticePresenter;
import java.util.concurrent.CopyOnWriteArrayList;

@RestrictTo
public class NoticeQueue {
    private final CopyOnWriteArrayList<NoticePresenter.NoticeParams> mList = new CopyOnWriteArrayList<>();

    public void add(@NonNull NoticePresenter.NoticeParams noticeParams) {
        this.mList.add(noticeParams);
    }

    public boolean isEmpty() {
        return this.mList.isEmpty();
    }

    public NoticePresenter.NoticeParams take() {
        if (this.mList.size() > 0) {
            return this.mList.remove(0);
        }
        return null;
    }
}
