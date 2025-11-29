package com.luck.picture.lib.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.interfaces.OnRecyclerViewPreloadMoreListener;
import com.luck.picture.lib.interfaces.OnRecyclerViewScrollListener;
import com.luck.picture.lib.interfaces.OnRecyclerViewScrollStateListener;

public class RecyclerPreloadView extends RecyclerView {

    /* renamed from: a  reason: collision with root package name */
    public boolean f9484a = false;
    public boolean b = false;
    public int c;
    public int d;
    public int e = 1;
    public OnRecyclerViewPreloadMoreListener f;
    public OnRecyclerViewScrollStateListener g;
    public OnRecyclerViewScrollListener h;

    public RecyclerPreloadView(@NonNull Context context) {
        super(context);
    }

    private void setLayoutManagerPosition(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            this.c = gridLayoutManager.findFirstVisibleItemPosition();
            this.d = gridLayoutManager.findLastVisibleItemPosition();
        } else if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            this.c = linearLayoutManager.findFirstVisibleItemPosition();
            this.d = linearLayoutManager.findLastVisibleItemPosition();
        }
    }

    public boolean a() {
        return this.b;
    }

    public int getFirstVisiblePosition() {
        return this.c;
    }

    public int getLastVisiblePosition() {
        return this.d;
    }

    public void onScrollStateChanged(int i) {
        OnRecyclerViewScrollStateListener onRecyclerViewScrollStateListener;
        super.onScrollStateChanged(i);
        if (i == 0 || i == 1) {
            setLayoutManagerPosition(getLayoutManager());
        }
        OnRecyclerViewScrollListener onRecyclerViewScrollListener = this.h;
        if (onRecyclerViewScrollListener != null) {
            onRecyclerViewScrollListener.a(i);
        }
        if (i == 0 && (onRecyclerViewScrollStateListener = this.g) != null) {
            onRecyclerViewScrollStateListener.a();
        }
    }

    public void onScrolled(int i, int i2) {
        super.onScrolled(i, i2);
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager != null) {
            setLayoutManagerPosition(layoutManager);
            if (this.f != null && this.b) {
                RecyclerView.Adapter adapter = getAdapter();
                if (adapter != null) {
                    if (layoutManager instanceof GridLayoutManager) {
                        GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
                        if (gridLayoutManager.findLastVisibleItemPosition() / gridLayoutManager.getSpanCount() >= (adapter.getItemCount() / gridLayoutManager.getSpanCount()) - this.e) {
                            if (!this.f9484a) {
                                this.f.N();
                                if (i2 > 0) {
                                    this.f9484a = true;
                                }
                            } else if (i2 == 0) {
                                this.f9484a = false;
                            }
                        }
                    }
                    this.f9484a = false;
                } else {
                    throw new RuntimeException("Adapter is null,Please check it!");
                }
            }
            OnRecyclerViewScrollListener onRecyclerViewScrollListener = this.h;
            if (onRecyclerViewScrollListener != null) {
                onRecyclerViewScrollListener.b(i, i2);
            }
            if (this.g == null) {
                return;
            }
            if (Math.abs(i2) < 150) {
                this.g.a();
            } else {
                this.g.b();
            }
        } else {
            throw new RuntimeException("LayoutManager is null,Please check it!");
        }
    }

    public void setEnabledLoadMore(boolean z) {
        this.b = z;
    }

    public void setLastVisiblePosition(int i) {
        this.d = i;
    }

    public void setOnRecyclerViewPreloadListener(OnRecyclerViewPreloadMoreListener onRecyclerViewPreloadMoreListener) {
        this.f = onRecyclerViewPreloadMoreListener;
    }

    public void setOnRecyclerViewScrollListener(OnRecyclerViewScrollListener onRecyclerViewScrollListener) {
        this.h = onRecyclerViewScrollListener;
    }

    public void setOnRecyclerViewScrollStateListener(OnRecyclerViewScrollStateListener onRecyclerViewScrollStateListener) {
        this.g = onRecyclerViewScrollStateListener;
    }

    public void setReachBottomRow(int i) {
        if (i < 1) {
            i = 1;
        }
        this.e = i;
    }

    public RecyclerPreloadView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RecyclerPreloadView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
