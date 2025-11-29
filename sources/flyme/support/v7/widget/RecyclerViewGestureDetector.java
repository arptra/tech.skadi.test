package flyme.support.v7.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public class RecyclerViewGestureDetector {
    private static final int LONGPRESS_TIMEOUT = ViewConfiguration.getLongPressTimeout();
    private static final int LONG_PRESS = 2;
    private static final int SHOW_PRESS = 1;
    private static final int TAP_TIMEOUT = 150;
    private boolean mAlwaysInTapRegion;
    /* access modifiers changed from: private */
    public MotionEvent mCurrentDownEvent;
    private float mDownFocusX;
    private float mDownFocusY;
    private final Handler mHandler;
    private boolean mInLongPress;
    private boolean mIsLongpressEnabled;
    private float mLastFocusX;
    private float mLastFocusY;
    /* access modifiers changed from: private */
    public final OnGestureListener mListener;
    private int mMaximumFlingVelocity;
    private int mMinimumFlingVelocity;
    private MotionEvent mPreviousUpEvent;
    private int mTouchSlopSquare;
    private VelocityTracker mVelocityTracker;

    public interface OnGestureListener {
        boolean onDown(MotionEvent motionEvent);

        boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2);

        void onLongPress(MotionEvent motionEvent);

        boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2);

        void onShowPress(MotionEvent motionEvent);

        boolean onSingleTapUp(MotionEvent motionEvent);
    }

    public RecyclerViewGestureDetector(Context context, OnGestureListener onGestureListener) {
        this(context, onGestureListener, (Handler) null);
    }

    private void cancel() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mVelocityTracker.recycle();
        this.mVelocityTracker = null;
        this.mAlwaysInTapRegion = false;
        this.mInLongPress = false;
    }

    private void cancelTaps() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mAlwaysInTapRegion = false;
        this.mInLongPress = false;
    }

    /* access modifiers changed from: private */
    public void dispatchLongPress() {
        this.mInLongPress = true;
        this.mListener.onLongPress(this.mCurrentDownEvent);
    }

    private void init(Context context) {
        int i;
        if (this.mListener != null) {
            this.mIsLongpressEnabled = true;
            if (context == null) {
                i = ViewConfiguration.getTouchSlop();
                this.mMinimumFlingVelocity = ViewConfiguration.getMinimumFlingVelocity();
                this.mMaximumFlingVelocity = ViewConfiguration.getMaximumFlingVelocity();
            } else {
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
                this.mMinimumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
                this.mMaximumFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
                i = scaledTouchSlop;
            }
            this.mTouchSlopSquare = i * i;
            return;
        }
        throw new NullPointerException("OnGestureListener must not be null");
    }

    public boolean isLongpressEnabled() {
        return this.mIsLongpressEnabled;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int i = action & 255;
        boolean z = false;
        boolean z2 = i == 6;
        int actionIndex = z2 ? motionEvent.getActionIndex() : -1;
        int pointerCount = motionEvent.getPointerCount();
        float f = 0.0f;
        float f2 = 0.0f;
        for (int i2 = 0; i2 < pointerCount; i2++) {
            if (actionIndex != i2) {
                f += motionEvent.getX(i2);
                f2 += motionEvent.getY(i2);
            }
        }
        float f3 = (float) (z2 ? pointerCount - 1 : pointerCount);
        float f4 = f / f3;
        float f5 = f2 / f3;
        if (i == 0) {
            this.mLastFocusX = f4;
            this.mDownFocusX = f4;
            this.mLastFocusY = f5;
            this.mDownFocusY = f5;
            MotionEvent motionEvent2 = this.mCurrentDownEvent;
            if (motionEvent2 != null) {
                motionEvent2.recycle();
            }
            this.mCurrentDownEvent = MotionEvent.obtain(motionEvent);
            this.mAlwaysInTapRegion = true;
            this.mInLongPress = false;
            if (this.mIsLongpressEnabled) {
                this.mHandler.removeMessages(2);
                this.mHandler.sendEmptyMessageAtTime(2, SystemClock.uptimeMillis() + 150 + ((long) LONGPRESS_TIMEOUT));
            }
            this.mHandler.sendEmptyMessageAtTime(1, this.mCurrentDownEvent.getDownTime() + 150);
            return this.mListener.onDown(motionEvent);
        } else if (i == 1) {
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            if (this.mInLongPress) {
                this.mInLongPress = false;
            } else if (this.mAlwaysInTapRegion) {
                z = this.mListener.onSingleTapUp(motionEvent);
            } else {
                VelocityTracker velocityTracker = this.mVelocityTracker;
                int pointerId = motionEvent.getPointerId(0);
                velocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumFlingVelocity);
                float yVelocity = velocityTracker.getYVelocity(pointerId);
                float xVelocity = velocityTracker.getXVelocity(pointerId);
                if (Math.abs(yVelocity) > ((float) this.mMinimumFlingVelocity) || Math.abs(xVelocity) > ((float) this.mMinimumFlingVelocity)) {
                    z = this.mListener.onFling(this.mCurrentDownEvent, motionEvent, xVelocity, yVelocity);
                }
            }
            MotionEvent motionEvent3 = this.mPreviousUpEvent;
            if (motionEvent3 != null) {
                motionEvent3.recycle();
            }
            this.mPreviousUpEvent = obtain;
            VelocityTracker velocityTracker2 = this.mVelocityTracker;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.mVelocityTracker = null;
            }
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            return z;
        } else if (i == 2) {
            float f6 = this.mLastFocusX - f4;
            float f7 = this.mLastFocusY - f5;
            if (this.mAlwaysInTapRegion) {
                int i3 = (int) (f4 - this.mDownFocusX);
                int i4 = (int) (f5 - this.mDownFocusY);
                if ((i3 * i3) + (i4 * i4) <= this.mTouchSlopSquare) {
                    return false;
                }
                boolean onScroll = this.mListener.onScroll(this.mCurrentDownEvent, motionEvent, f6, f7);
                this.mLastFocusX = f4;
                this.mLastFocusY = f5;
                this.mAlwaysInTapRegion = false;
                this.mHandler.removeMessages(1);
                this.mHandler.removeMessages(2);
                return onScroll;
            } else if (Math.abs(f6) < 1.0f && Math.abs(f7) < 1.0f) {
                return false;
            } else {
                boolean onScroll2 = this.mListener.onScroll(this.mCurrentDownEvent, motionEvent, f6, f7);
                this.mLastFocusX = f4;
                this.mLastFocusY = f5;
                return onScroll2;
            }
        } else if (i == 3) {
            cancel();
            return false;
        } else if (i == 5) {
            this.mLastFocusX = f4;
            this.mDownFocusX = f4;
            this.mLastFocusY = f5;
            this.mDownFocusY = f5;
            cancelTaps();
            return false;
        } else if (i != 6) {
            return false;
        } else {
            this.mLastFocusX = f4;
            this.mDownFocusX = f4;
            this.mLastFocusY = f5;
            this.mDownFocusY = f5;
            this.mVelocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumFlingVelocity);
            int actionIndex2 = motionEvent.getActionIndex();
            int pointerId2 = motionEvent.getPointerId(actionIndex2);
            float xVelocity2 = this.mVelocityTracker.getXVelocity(pointerId2);
            float yVelocity2 = this.mVelocityTracker.getYVelocity(pointerId2);
            for (int i5 = 0; i5 < pointerCount; i5++) {
                if (i5 != actionIndex2) {
                    int pointerId3 = motionEvent.getPointerId(i5);
                    if ((this.mVelocityTracker.getXVelocity(pointerId3) * xVelocity2) + (this.mVelocityTracker.getYVelocity(pointerId3) * yVelocity2) < 0.0f) {
                        this.mVelocityTracker.clear();
                        return false;
                    }
                }
            }
            return false;
        }
    }

    public void setIsLongpressEnabled(boolean z) {
        this.mIsLongpressEnabled = z;
    }

    public class GestureHandler extends Handler {
        public GestureHandler() {
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                RecyclerViewGestureDetector.this.mListener.onShowPress(RecyclerViewGestureDetector.this.mCurrentDownEvent);
            } else if (i == 2) {
                RecyclerViewGestureDetector.this.dispatchLongPress();
            } else {
                throw new RuntimeException("Unknown message " + message);
            }
        }

        public GestureHandler(Handler handler) {
            super(handler.getLooper());
        }
    }

    public RecyclerViewGestureDetector(Context context, OnGestureListener onGestureListener, Handler handler) {
        if (handler != null) {
            this.mHandler = new GestureHandler(handler);
        } else {
            this.mHandler = new GestureHandler();
        }
        this.mListener = onGestureListener;
        init(context);
    }
}
