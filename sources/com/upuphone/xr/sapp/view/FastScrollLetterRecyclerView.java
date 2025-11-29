package com.upuphone.xr.sapp.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.meizu.common.fastscrollletter.IFastScrollLetterListView;
import flyme.support.v7.widget.MzRecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005B\u001b\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB#\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\nH\u0016¨\u0006\u000f"}, d2 = {"Lcom/upuphone/xr/sapp/view/FastScrollLetterRecyclerView;", "Lflyme/support/v7/widget/MzRecyclerView;", "Lcom/meizu/common/fastscrollletter/IFastScrollLetterListView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "setSelection", "", "position", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FastScrollLetterRecyclerView extends MzRecyclerView implements IFastScrollLetterListView {
    public FastScrollLetterRecyclerView(@Nullable Context context) {
        super(context);
    }

    public void setSelection(int i) {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) getLayoutManager();
        Intrinsics.checkNotNull(linearLayoutManager);
        linearLayoutManager.scrollToPositionWithOffset(i, 0);
    }

    public FastScrollLetterRecyclerView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FastScrollLetterRecyclerView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
