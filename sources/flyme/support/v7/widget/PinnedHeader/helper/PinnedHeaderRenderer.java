package flyme.support.v7.widget.PinnedHeader.helper;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import flyme.support.v7.widget.MzRecyclerView;

public class PinnedHeaderRenderer {
    private final DimensionCalculator mDimensionCalculator;
    private final OrientationProvider mOrientationProvider;
    private final Rect mTempRect;

    public PinnedHeaderRenderer(OrientationProvider orientationProvider) {
        this(orientationProvider, new DimensionCalculator());
    }

    private void initClipRectForHeader(Rect rect, MzRecyclerView mzRecyclerView, View view) {
        this.mDimensionCalculator.initMargins(rect, view);
        if (this.mOrientationProvider.getOrientation(mzRecyclerView) == 1) {
            rect.set(mzRecyclerView.getPaddingLeft(), mzRecyclerView.getPaddingTop(), (mzRecyclerView.getWidth() - mzRecyclerView.getPaddingRight()) - rect.right, mzRecyclerView.getHeight() - mzRecyclerView.getPaddingBottom());
        } else {
            rect.set(mzRecyclerView.getPaddingLeft(), mzRecyclerView.getPaddingTop(), mzRecyclerView.getWidth() - mzRecyclerView.getPaddingRight(), (mzRecyclerView.getHeight() - mzRecyclerView.getPaddingBottom()) - rect.bottom);
        }
    }

    public void drawHeader(MzRecyclerView mzRecyclerView, Canvas canvas, View view, Rect rect) {
        canvas.save();
        if (mzRecyclerView.getLayoutManager().getClipToPadding()) {
            initClipRectForHeader(this.mTempRect, mzRecyclerView, view);
            canvas.clipRect(this.mTempRect);
        }
        canvas.translate((float) rect.left, (float) rect.top);
        view.draw(canvas);
        canvas.restore();
    }

    private PinnedHeaderRenderer(OrientationProvider orientationProvider, DimensionCalculator dimensionCalculator) {
        this.mTempRect = new Rect();
        this.mOrientationProvider = orientationProvider;
        this.mDimensionCalculator = dimensionCalculator;
    }
}
