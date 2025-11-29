package com.upuphone.ar.navi.lite.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.honey.account.o4.l;
import java.util.ArrayList;
import java.util.List;

public class ContentRecyclerView extends RecyclerView {

    /* renamed from: a  reason: collision with root package name */
    public final CompositeScrollListener f5820a = new CompositeScrollListener();

    public class CompositeScrollListener extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        public final List f5821a;

        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            for (RecyclerView.OnScrollListener onScrollStateChanged : new ArrayList(this.f5821a)) {
                onScrollStateChanged.onScrollStateChanged(recyclerView, i);
            }
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            for (RecyclerView.OnScrollListener onScrolled : new ArrayList(this.f5821a)) {
                onScrolled.onScrolled(recyclerView, i, i2);
            }
        }

        public CompositeScrollListener() {
            this.f5821a = new ArrayList();
        }
    }

    public ContentRecyclerView(Context context) {
        super(context);
        b();
    }

    private void b() {
        super.addOnScrollListener(this.f5820a);
        getViewTreeObserver().addOnGlobalLayoutListener(new l(this));
    }

    public final /* synthetic */ void c() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        ViewParent parent = getParent();
        while (true) {
            if (parent == null) {
                break;
            } else if (parent instanceof ScrollLayout) {
                ScrollLayout scrollLayout = (ScrollLayout) parent;
                int measuredHeight = scrollLayout.getMeasuredHeight() - scrollLayout.getMinOffset();
                if (layoutParams.height != measuredHeight) {
                    layoutParams.height = measuredHeight;
                } else {
                    return;
                }
            } else {
                parent = parent.getParent();
            }
        }
        setLayoutParams(layoutParams);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof ScrollLayout) {
                ((ScrollLayout) parent).setAssociatedRecyclerView(this);
                return;
            }
        }
    }

    public ContentRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public ContentRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }
}
