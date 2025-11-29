package com.scwang.smart.refresh.layout.listener;

import android.content.Context;
import com.scwang.smart.refresh.layout.api.RefreshHeader;
import com.scwang.smart.refresh.layout.api.RefreshLayout;

public interface DefaultRefreshHeaderCreator {
    RefreshHeader a(Context context, RefreshLayout refreshLayout);
}
