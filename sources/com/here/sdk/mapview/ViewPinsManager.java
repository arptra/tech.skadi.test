package com.here.sdk.mapview;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.sdk.core.GeoCoordinates;
import com.here.sdk.core.Point2D;
import com.here.sdk.mapview.MapCamera;
import com.here.sdk.mapview.MapView;
import java.util.LinkedList;
import java.util.List;

class ViewPinsManager extends FrameLayout implements MapCameraListener {
    private static final FrameLayout.LayoutParams sOverlayParameter = new FrameLayout.LayoutParams(-2, -2);
    private GeoConverter mConverter;
    private int mHeight;
    private List<ViewPinImpl> mViewPins = new LinkedList();
    private int mWidth;

    public ViewPinsManager(Context context) {
        super(context);
    }

    private ViewPinImpl findViewPin(@NonNull View view) {
        for (ViewPinImpl next : this.mViewPins) {
            if (next.getView() == view) {
                return next;
            }
        }
        return null;
    }

    @Nullable
    public Point2D convertToScreenCoordinates(@NonNull GeoCoordinates geoCoordinates) {
        Point2D apply;
        GeoConverter geoConverter = this.mConverter;
        if (!(geoConverter == null || (apply = geoConverter.apply(geoCoordinates)) == null)) {
            double d = apply.x;
            if (d >= 0.0d && d < ((double) this.mWidth)) {
                double d2 = apply.y;
                if (d2 < 0.0d || d2 >= ((double) this.mHeight)) {
                    return null;
                }
                return apply;
            }
        }
        return null;
    }

    public List<ViewPinImpl> getViewPins() {
        return this.mViewPins;
    }

    public void onMapCameraUpdated(@NonNull MapCamera.State state) {
        updatePositions();
    }

    @Nullable
    public MapView.ViewPin pinView(@NonNull View view, @NonNull GeoCoordinates geoCoordinates) {
        if (view.getParent() != null || findViewPin(view) != null) {
            return null;
        }
        ViewPinImpl viewPinImpl = new ViewPinImpl(this, view, geoCoordinates);
        this.mViewPins.add(viewPinImpl);
        addView(view, sOverlayParameter);
        viewPinImpl.getView().measure(this.mWidth, this.mHeight);
        viewPinImpl.updatePosition();
        return viewPinImpl;
    }

    public void setup(GeoConverter geoConverter, int i, int i2) {
        this.mConverter = geoConverter;
        this.mWidth = i;
        this.mHeight = i2;
        measure(i, i2);
        for (ViewPinImpl next : this.mViewPins) {
            next.getView().measure(this.mWidth, this.mHeight);
            next.updatePosition();
        }
    }

    public void unpinView(@NonNull View view) {
        ViewPinImpl findViewPin = findViewPin(view);
        if (findViewPin != null) {
            this.mViewPins.remove(findViewPin);
            removeView(view);
        }
    }

    public void updatePositions() {
        for (ViewPinImpl updatePosition : this.mViewPins) {
            updatePosition.updatePosition();
        }
    }
}
