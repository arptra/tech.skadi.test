package com.meizu.common.scrollbarview;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.meizu.common.scrollview.MzNestedScrollView;
import com.meizu.common.scrollview.MzScrollView;
import flyme.support.v7.widget.MzRecyclerView;

public class MzScrollBarViewHelper {
    private static void bind(RecyclerView recyclerView, final MzScrollBarView mzScrollBarView) {
        mzScrollBarView.setScrollableView(recyclerView);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    MzScrollBarView.this.setScrollState(0);
                }
            }

            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                MzScrollBarView.this.awakenScrollBar();
            }
        });
        if (recyclerView instanceof MzRecyclerView) {
            ((MzRecyclerView) recyclerView).addOnOverScrollListener(new MzRecyclerView.OverScrollListener() {
                public void onOverScroll(View view, float f, float f2) {
                    MzScrollBarView.this.awakenScrollBar();
                }

                public void onOverScrollStateChanged(View view, int i) {
                }
            });
        }
    }

    public static void bindListView(@NonNull ListView listView, @NonNull MzScrollBarView mzScrollBarView) {
        bind(listView, mzScrollBarView);
    }

    public static void bindNestedScrollView(@NonNull NestedScrollView nestedScrollView, @NonNull MzScrollBarView mzScrollBarView) {
        bind(nestedScrollView, mzScrollBarView);
    }

    public static void bindRecyclerView(@NonNull RecyclerView recyclerView, @NonNull MzScrollBarView mzScrollBarView) {
        bind(recyclerView, mzScrollBarView);
    }

    @RequiresApi
    public static void bindScrollView(@NonNull ScrollView scrollView, @NonNull MzScrollBarView mzScrollBarView) {
        bind(scrollView, mzScrollBarView);
    }

    private static void bind(ListView listView, final MzScrollBarView mzScrollBarView) {
        mzScrollBarView.setScrollableView(listView);
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                MzScrollBarView.this.awakenScrollBar();
            }

            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    MzScrollBarView.this.setScrollState(0);
                }
            }
        });
    }

    @RequiresApi
    private static void bind(ScrollView scrollView, final MzScrollBarView mzScrollBarView) {
        mzScrollBarView.setScrollableView(scrollView);
        if (scrollView instanceof MzScrollView) {
            ((MzScrollView) scrollView).addOnOverScrollListener(new MzScrollView.OverScrollListener() {
                public void onOverScroll(View view, float f, float f2) {
                    MzScrollBarView.this.awakenScrollBar();
                }

                public void onOverScrollStateChanged(View view, int i) {
                }
            });
        }
        scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            public void onScrollChange(View view, int i, int i2, int i3, int i4) {
                MzScrollBarView.this.awakenScrollBar();
            }
        });
    }

    private static void bind(NestedScrollView nestedScrollView, final MzScrollBarView mzScrollBarView) {
        mzScrollBarView.setScrollableView(nestedScrollView);
        if (nestedScrollView instanceof MzNestedScrollView) {
            ((MzNestedScrollView) nestedScrollView).addOnOverScrollListener(new MzNestedScrollView.OverScrollListener() {
                public void onOverScroll(View view, float f, float f2) {
                    MzScrollBarView.this.awakenScrollBar();
                }

                public void onOverScrollStateChanged(View view, int i) {
                }
            });
        }
        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            public void onScrollChange(@NonNull NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                MzScrollBarView.this.awakenScrollBar();
            }
        });
    }
}
