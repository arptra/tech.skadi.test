package com.upuphone.xr.sapp.fragment;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.utils.TouchpadUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J*\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J*\u0010\u000f\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0015"}, d2 = {"com/upuphone/xr/sapp/fragment/TouchpadFragment$initGestureDetector$1", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "onDoubleTap", "", "e", "Landroid/view/MotionEvent;", "onDown", "onFling", "e1", "e2", "velocityX", "", "velocityY", "onLongPress", "", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapConfirmed", "onSingleTapUp", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TouchpadFragment$initGestureDetector$1 extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TouchpadFragment f7010a;

    public TouchpadFragment$initGestureDetector$1(TouchpadFragment touchpadFragment) {
        this.f7010a = touchpadFragment;
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "e");
        ULog.Delegate delegate = ULog.f6446a;
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        delegate.g("TouchpadFragment", "GestureDetector SimpleOnGestureListener onDoubleTap, x: " + x + ", y: " + y);
        TouchpadUtil.f7927a.c("doubleClick");
        return super.onDoubleTap(motionEvent);
    }

    public boolean onDown(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "e");
        return false;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        Intrinsics.checkNotNullParameter(motionEvent2, "e2");
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "e");
        ULog.Delegate delegate = ULog.f6446a;
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        delegate.g("TouchpadFragment", "GestureDetector SimpleOnGestureListener onLongPress, x: " + x + ", y: " + y);
        TouchpadUtil.f7927a.c("longPress");
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        Intrinsics.checkNotNullParameter(motionEvent2, "e2");
        this.f7010a.m = true;
        this.f7010a.q = motionEvent2.getX();
        this.f7010a.r = motionEvent2.getY();
        return false;
    }

    public void onShowPress(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "e");
        ULog.Delegate delegate = ULog.f6446a;
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        delegate.g("TouchpadFragment", "GestureDetector SimpleOnGestureListener onShowPress, x: " + x + ", y: " + y);
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "e");
        ULog.Delegate delegate = ULog.f6446a;
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        delegate.g("TouchpadFragment", "GestureDetector SimpleOnGestureListener onSingleTapConfirmed, x: " + x + ", y: " + y);
        TouchpadUtil.f7927a.c("click");
        return super.onSingleTapConfirmed(motionEvent);
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "e");
        return false;
    }
}
