package com.meizu.common.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.SpinnerAdapter;
import com.meizu.common.widget.AdapterView;

public abstract class AbsSpinner extends AdapterView<SpinnerAdapter> {
    SpinnerAdapter mAdapter;
    private DataSetObserver mDataSetObserver;
    int mHeightMeasureSpec;
    final RecycleBin mRecycler;
    int mSelectionBottomPadding;
    int mSelectionLeftPadding;
    int mSelectionRightPadding;
    int mSelectionTopPadding;
    final Rect mSpinnerPadding;
    private Rect mTouchFrame;
    int mWidthMeasureSpec;

    public class RecycleBin {
        private final SparseArray<View> mScrapHeap = new SparseArray<>();

        public RecycleBin() {
        }

        public void clear() {
            SparseArray<View> sparseArray = this.mScrapHeap;
            int size = sparseArray.size();
            for (int i = 0; i < size; i++) {
                View valueAt = sparseArray.valueAt(i);
                if (valueAt != null) {
                    AbsSpinner.this.removeDetachedView(valueAt, true);
                }
            }
            sparseArray.clear();
        }

        public View get(int i) {
            View view = this.mScrapHeap.get(i);
            if (view != null) {
                this.mScrapHeap.delete(i);
            }
            return view;
        }

        public void put(int i, View view) {
            this.mScrapHeap.put(i, view);
        }
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int position;
        long selectedId;

        public String toString() {
            return "AbsSpinner.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.selectedId + " position=" + this.position + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.selectedId);
            parcel.writeInt(this.position);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.selectedId = parcel.readLong();
            this.position = parcel.readInt();
        }
    }

    public AbsSpinner(Context context) {
        super(context);
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        this.mSpinnerPadding = new Rect();
        this.mRecycler = new RecycleBin();
        initAbsSpinner();
    }

    private void initAbsSpinner() {
        setFocusable(true);
        setWillNotDraw(false);
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.LayoutParams(-1, -2);
    }

    public int getChildHeight(View view) {
        return view.getMeasuredHeight();
    }

    public int getChildWidth(View view) {
        return view.getMeasuredWidth();
    }

    public int getCount() {
        return this.mItemCount;
    }

    public View getSelectedView() {
        int i;
        if (this.mItemCount <= 0 || (i = this.mSelectedPosition) < 0) {
            return null;
        }
        return getChildAt(i - this.mFirstPosition);
    }

    public abstract void layout(int i, boolean z);

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(AbsSpinner.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(AbsSpinner.class.getName());
    }

    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        SpinnerAdapter spinnerAdapter;
        int mode = View.MeasureSpec.getMode(i);
        Rect rect = this.mSpinnerPadding;
        int paddingLeft = getPaddingLeft();
        int i5 = this.mSelectionLeftPadding;
        if (paddingLeft > i5) {
            i5 = getPaddingLeft();
        }
        rect.left = i5;
        Rect rect2 = this.mSpinnerPadding;
        int paddingTop = getPaddingTop();
        int i6 = this.mSelectionTopPadding;
        if (paddingTop > i6) {
            i6 = getPaddingTop();
        }
        rect2.top = i6;
        Rect rect3 = this.mSpinnerPadding;
        int paddingRight = getPaddingRight();
        int i7 = this.mSelectionRightPadding;
        if (paddingRight > i7) {
            i7 = getPaddingRight();
        }
        rect3.right = i7;
        Rect rect4 = this.mSpinnerPadding;
        int paddingBottom = getPaddingBottom();
        int i8 = this.mSelectionBottomPadding;
        if (paddingBottom > i8) {
            i8 = getPaddingBottom();
        }
        rect4.bottom = i8;
        if (this.mDataChanged) {
            handleDataChanged();
        }
        int selectedItemPosition = getSelectedItemPosition();
        boolean z = true;
        if (selectedItemPosition < 0 || (spinnerAdapter = this.mAdapter) == null || selectedItemPosition >= spinnerAdapter.getCount()) {
            i4 = 0;
            i3 = 0;
        } else {
            View view = this.mRecycler.get(selectedItemPosition);
            if (view == null) {
                view = this.mAdapter.getView(selectedItemPosition, (View) null, this);
                if (view.getImportantForAccessibility() == 0) {
                    view.setImportantForAccessibility(1);
                }
            }
            this.mRecycler.put(selectedItemPosition, view);
            if (view.getLayoutParams() == null) {
                this.mBlockLayoutRequests = true;
                view.setLayoutParams(generateDefaultLayoutParams());
                this.mBlockLayoutRequests = false;
            }
            measureChild(view, i, i2);
            int childHeight = getChildHeight(view);
            Rect rect5 = this.mSpinnerPadding;
            i4 = childHeight + rect5.top + rect5.bottom;
            int childWidth = getChildWidth(view);
            Rect rect6 = this.mSpinnerPadding;
            i3 = childWidth + rect6.left + rect6.right;
            z = false;
        }
        if (z) {
            Rect rect7 = this.mSpinnerPadding;
            int i9 = rect7.top + rect7.bottom;
            if (mode == 0) {
                i3 = rect7.left + rect7.right;
            }
            i4 = i9;
        }
        int max = Math.max(i4, getSuggestedMinimumHeight());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(i3, getSuggestedMinimumWidth()), i, 0), View.resolveSizeAndState(max, i2, 0));
        this.mHeightMeasureSpec = i2;
        this.mWidthMeasureSpec = i;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        long j = savedState.selectedId;
        if (j >= 0) {
            this.mDataChanged = true;
            this.mNeedSync = true;
            this.mSyncRowId = j;
            this.mSyncPosition = savedState.position;
            this.mSyncMode = 0;
            requestLayout();
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        long selectedItemId = getSelectedItemId();
        savedState.selectedId = selectedItemId;
        if (selectedItemId >= 0) {
            savedState.position = getSelectedItemPosition();
        } else {
            savedState.position = -1;
        }
        return savedState;
    }

    public int pointToPosition(int i, int i2) {
        Rect rect = this.mTouchFrame;
        if (rect == null) {
            rect = new Rect();
            this.mTouchFrame = rect;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                childAt.getHitRect(rect);
                if (rect.contains(i, i2)) {
                    return this.mFirstPosition + childCount;
                }
            }
        }
        return -1;
    }

    public void recycleAllViews() {
        int childCount = getChildCount();
        RecycleBin recycleBin = this.mRecycler;
        int i = this.mFirstPosition;
        for (int i2 = 0; i2 < childCount; i2++) {
            recycleBin.put(i + i2, getChildAt(i2));
        }
    }

    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            super.requestLayout();
        }
    }

    public void resetList() {
        this.mDataChanged = false;
        this.mNeedSync = false;
        removeAllViewsInLayout();
        this.mOldSelectedPosition = -1;
        this.mOldSelectedRowId = Long.MIN_VALUE;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        invalidate();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000d, code lost:
        if (r2 <= ((r3 + getChildCount()) - 1)) goto L_0x0011;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setSelection(int r2, boolean r3) {
        /*
            r1 = this;
            if (r3 == 0) goto L_0x0010
            int r3 = r1.mFirstPosition
            if (r3 > r2) goto L_0x0010
            int r0 = r1.getChildCount()
            int r3 = r3 + r0
            r0 = 1
            int r3 = r3 - r0
            if (r2 > r3) goto L_0x0010
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            r1.setSelectionInt(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.AbsSpinner.setSelection(int, boolean):void");
    }

    public void setSelectionInt(int i, boolean z) {
        if (i != this.mOldSelectedPosition) {
            this.mBlockLayoutRequests = true;
            setNextSelectedPositionInt(i);
            layout(i - this.mSelectedPosition, z);
            this.mBlockLayoutRequests = false;
        }
    }

    public SpinnerAdapter getAdapter() {
        return this.mAdapter;
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        SpinnerAdapter spinnerAdapter2 = this.mAdapter;
        if (spinnerAdapter2 != null) {
            spinnerAdapter2.unregisterDataSetObserver(this.mDataSetObserver);
            resetList();
        }
        this.mAdapter = spinnerAdapter;
        int i = -1;
        this.mOldSelectedPosition = -1;
        this.mOldSelectedRowId = Long.MIN_VALUE;
        if (spinnerAdapter != null) {
            this.mOldItemCount = this.mItemCount;
            this.mItemCount = spinnerAdapter.getCount();
            checkFocus();
            AdapterView.AdapterDataSetObserver adapterDataSetObserver = new AdapterView.AdapterDataSetObserver();
            this.mDataSetObserver = adapterDataSetObserver;
            this.mAdapter.registerDataSetObserver(adapterDataSetObserver);
            if (this.mItemCount > 0) {
                i = 0;
            }
            setSelectedPositionInt(i);
            setNextSelectedPositionInt(i);
            if (this.mItemCount == 0) {
                checkSelectionChanged();
            }
        } else {
            checkFocus();
            resetList();
            checkSelectionChanged();
        }
        requestLayout();
    }

    public void setSelection(int i) {
        setNextSelectedPositionInt(i);
        requestLayout();
        invalidate();
    }

    public AbsSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AbsSpinner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        this.mSpinnerPadding = new Rect();
        this.mRecycler = new RecycleBin();
        initAbsSpinner();
    }
}
