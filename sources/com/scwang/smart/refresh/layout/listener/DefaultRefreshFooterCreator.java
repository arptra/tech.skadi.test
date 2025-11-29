package com.scwang.smart.refresh.layout.listener;

import android.content.Context;
import com.scwang.smart.refresh.layout.api.RefreshFooter;
import com.scwang.smart.refresh.layout.api.RefreshLayout;

public interface DefaultRefreshFooterCreator {
    RefreshFooter a(Context context, RefreshLayout refreshLayout);
}
