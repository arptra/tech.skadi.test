package com.here.sdk.mapview;

import android.view.View;
import androidx.annotation.NonNull;
import com.here.sdk.core.Anchor2D;
import com.here.sdk.core.GeoCoordinates;
import com.here.sdk.core.Point2D;
import com.here.sdk.mapview.MapView;
import java.lang.ref.WeakReference;

class ViewPinImpl implements MapView.ViewPin {
    private Anchor2D mAnchorPoint = new Anchor2D(0.5d, 0.5d);
    private GeoCoordinates mGeoCoordinates;
    private View mView;
    private WeakReference<ViewPinsManager> mViewPinsManager;

    public ViewPinImpl(@NonNull ViewPinsManager viewPinsManager, @NonNull View view, @NonNull GeoCoordinates geoCoordinates) {
        this.mViewPinsManager = new WeakReference<>(viewPinsManager);
        this.mView = view;
        this.mGeoCoordinates = geoCoordinates;
    }

    public Anchor2D getAnchorPoint() {
        return this.mAnchorPoint;
    }

    public GeoCoordinates getGeoCoordinates() {
        return this.mGeoCoordinates;
    }

    public View getView() {
        return this.mView;
    }

    public void setAnchorPoint(@NonNull Anchor2D anchor2D) {
        this.mAnchorPoint = new Anchor2D(anchor2D.horizontal, anchor2D.vertical);
        updatePosition();
    }

    public void setGeoCoordinates(@NonNull GeoCoordinates geoCoordinates) {
        this.mGeoCoordinates = geoCoordinates;
        updatePosition();
    }

    public void unpin() {
        ViewPinsManager viewPinsManager = this.mViewPinsManager.get();
        if (viewPinsManager != null) {
            viewPinsManager.unpinView(getView());
        }
        this.mViewPinsManager = null;
    }

    public void updatePosition() {
        ViewPinsManager viewPinsManager = this.mViewPinsManager.get();
        if (viewPinsManager != null) {
            Point2D convertToScreenCoordinates = viewPinsManager.convertToScreenCoordinates(this.mGeoCoordinates);
            if (convertToScreenCoordinates == null) {
                this.mView.setVisibility(8);
                return;
            }
            this.mView.setTranslationX((float) (convertToScreenCoordinates.x + (-(((double) this.mView.getMeasuredWidth()) * this.mAnchorPoint.horizontal))));
            this.mView.setTranslationY((float) (convertToScreenCoordinates.y + (-(((double) this.mView.getMeasuredHeight()) * this.mAnchorPoint.vertical))));
            this.mView.setVisibility(0);
        }
    }
}
