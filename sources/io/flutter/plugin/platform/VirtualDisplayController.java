package io.flutter.plugin.platform;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.os.Build;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import io.flutter.plugin.platform.SingleViewPresentation;

class VirtualDisplayController {
    private static String TAG = "VirtualDisplayController";
    private static VirtualDisplay.Callback callback = new VirtualDisplay.Callback() {
        public void onPaused() {
        }

        public void onResumed() {
        }
    };
    private final AccessibilityEventsDelegate accessibilityEventsDelegate;
    private final Context context;
    private final int densityDpi;
    private final View.OnFocusChangeListener focusChangeListener;
    @VisibleForTesting
    SingleViewPresentation presentation;
    private final PlatformViewRenderTarget renderTarget;
    private final int viewId;
    private VirtualDisplay virtualDisplay;

    public static class OneTimeOnDrawListener implements ViewTreeObserver.OnDrawListener {
        Runnable mOnDrawRunnable;
        final View mView;

        public OneTimeOnDrawListener(View view, Runnable runnable) {
            this.mView = view;
            this.mOnDrawRunnable = runnable;
        }

        public static void schedule(View view, Runnable runnable) {
            view.getViewTreeObserver().addOnDrawListener(new OneTimeOnDrawListener(view, runnable));
        }

        public void onDraw() {
            Runnable runnable = this.mOnDrawRunnable;
            if (runnable != null) {
                runnable.run();
                this.mOnDrawRunnable = null;
                this.mView.post(new Runnable() {
                    public void run() {
                        OneTimeOnDrawListener.this.mView.getViewTreeObserver().removeOnDrawListener(OneTimeOnDrawListener.this);
                    }
                });
            }
        }
    }

    private VirtualDisplayController(Context context2, AccessibilityEventsDelegate accessibilityEventsDelegate2, VirtualDisplay virtualDisplay2, PlatformView platformView, PlatformViewRenderTarget platformViewRenderTarget, View.OnFocusChangeListener onFocusChangeListener, int i, Object obj) {
        this.context = context2;
        this.accessibilityEventsDelegate = accessibilityEventsDelegate2;
        this.renderTarget = platformViewRenderTarget;
        this.focusChangeListener = onFocusChangeListener;
        this.viewId = i;
        this.virtualDisplay = virtualDisplay2;
        this.densityDpi = context2.getResources().getDisplayMetrics().densityDpi;
        SingleViewPresentation singleViewPresentation = new SingleViewPresentation(context2, this.virtualDisplay.getDisplay(), platformView, accessibilityEventsDelegate2, i, onFocusChangeListener);
        this.presentation = singleViewPresentation;
        singleViewPresentation.show();
    }

    public static VirtualDisplayController create(Context context2, AccessibilityEventsDelegate accessibilityEventsDelegate2, PlatformView platformView, PlatformViewRenderTarget platformViewRenderTarget, int i, int i2, int i3, Object obj, View.OnFocusChangeListener onFocusChangeListener) {
        if (i == 0 || i2 == 0) {
            return null;
        }
        Context context3 = context2;
        DisplayMetrics displayMetrics = context2.getResources().getDisplayMetrics();
        platformViewRenderTarget.resize(i, i2);
        VirtualDisplay createVirtualDisplay = ((DisplayManager) context2.getSystemService("display")).createVirtualDisplay("flutter-vd#" + i3, i, i2, displayMetrics.densityDpi, platformViewRenderTarget.getSurface(), 0, callback, (Handler) null);
        if (createVirtualDisplay == null) {
            return null;
        }
        return new VirtualDisplayController(context2, accessibilityEventsDelegate2, createVirtualDisplay, platformView, platformViewRenderTarget, onFocusChangeListener, i3, obj);
    }

    @TargetApi(31)
    private void resize31(View view, int i, int i2, Runnable runnable) {
        this.renderTarget.resize(i, i2);
        this.virtualDisplay.resize(i, i2, this.densityDpi);
        this.virtualDisplay.setSurface(this.renderTarget.getSurface());
        view.postDelayed(runnable, 0);
    }

    public void clearSurface() {
        this.virtualDisplay.setSurface((Surface) null);
    }

    public void dispatchTouchEvent(MotionEvent motionEvent) {
        SingleViewPresentation singleViewPresentation = this.presentation;
        if (singleViewPresentation != null) {
            singleViewPresentation.dispatchTouchEvent(motionEvent);
        }
    }

    public void dispose() {
        this.presentation.cancel();
        this.presentation.detachState();
        this.virtualDisplay.release();
        this.renderTarget.release();
    }

    public int getRenderTargetHeight() {
        PlatformViewRenderTarget platformViewRenderTarget = this.renderTarget;
        if (platformViewRenderTarget != null) {
            return platformViewRenderTarget.getHeight();
        }
        return 0;
    }

    public int getRenderTargetWidth() {
        PlatformViewRenderTarget platformViewRenderTarget = this.renderTarget;
        if (platformViewRenderTarget != null) {
            return platformViewRenderTarget.getWidth();
        }
        return 0;
    }

    public View getView() {
        SingleViewPresentation singleViewPresentation = this.presentation;
        if (singleViewPresentation == null) {
            return null;
        }
        return singleViewPresentation.getView().getView();
    }

    public void onFlutterViewAttached(@NonNull View view) {
        SingleViewPresentation singleViewPresentation = this.presentation;
        if (singleViewPresentation != null && singleViewPresentation.getView() != null) {
            this.presentation.getView().onFlutterViewAttached(view);
        }
    }

    public void onFlutterViewDetached() {
        SingleViewPresentation singleViewPresentation = this.presentation;
        if (singleViewPresentation != null && singleViewPresentation.getView() != null) {
            this.presentation.getView().onFlutterViewDetached();
        }
    }

    public void onInputConnectionLocked() {
        SingleViewPresentation singleViewPresentation = this.presentation;
        if (singleViewPresentation != null && singleViewPresentation.getView() != null) {
            this.presentation.getView().onInputConnectionLocked();
        }
    }

    public void onInputConnectionUnlocked() {
        SingleViewPresentation singleViewPresentation = this.presentation;
        if (singleViewPresentation != null && singleViewPresentation.getView() != null) {
            this.presentation.getView().onInputConnectionUnlocked();
        }
    }

    public void resetSurface() {
        int renderTargetWidth = getRenderTargetWidth();
        int renderTargetHeight = getRenderTargetHeight();
        boolean isFocused = getView().isFocused();
        SingleViewPresentation.PresentationState detachState = this.presentation.detachState();
        this.virtualDisplay.setSurface((Surface) null);
        this.virtualDisplay.release();
        this.virtualDisplay = ((DisplayManager) this.context.getSystemService("display")).createVirtualDisplay("flutter-vd#" + this.viewId, renderTargetWidth, renderTargetHeight, this.densityDpi, this.renderTarget.getSurface(), 0, callback, (Handler) null);
        SingleViewPresentation singleViewPresentation = new SingleViewPresentation(this.context, this.virtualDisplay.getDisplay(), this.accessibilityEventsDelegate, detachState, this.focusChangeListener, isFocused);
        singleViewPresentation.show();
        this.presentation.cancel();
        this.presentation = singleViewPresentation;
    }

    public void resize(int i, int i2, Runnable runnable) {
        int i3 = i2;
        final Runnable runnable2 = runnable;
        if (i == getRenderTargetWidth() && i3 == getRenderTargetHeight()) {
            getView().postDelayed(runnable2, 0);
        } else if (Build.VERSION.SDK_INT >= 31) {
            resize31(getView(), i, i2, runnable2);
        } else {
            boolean isFocused = getView().isFocused();
            SingleViewPresentation.PresentationState detachState = this.presentation.detachState();
            this.virtualDisplay.setSurface((Surface) null);
            this.virtualDisplay.release();
            this.renderTarget.resize(i, i2);
            this.virtualDisplay = ((DisplayManager) this.context.getSystemService("display")).createVirtualDisplay("flutter-vd#" + this.viewId, i, i2, this.densityDpi, this.renderTarget.getSurface(), 0, callback, (Handler) null);
            final View view = getView();
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                public void onViewAttachedToWindow(View view) {
                    OneTimeOnDrawListener.schedule(view, new Runnable() {
                        public void run() {
                            AnonymousClass2 r3 = AnonymousClass2.this;
                            view.postDelayed(runnable2, 128);
                        }
                    });
                    view.removeOnAttachStateChangeListener(this);
                }

                public void onViewDetachedFromWindow(View view) {
                }
            });
            SingleViewPresentation singleViewPresentation = new SingleViewPresentation(this.context, this.virtualDisplay.getDisplay(), this.accessibilityEventsDelegate, detachState, this.focusChangeListener, isFocused);
            singleViewPresentation.show();
            this.presentation.cancel();
            this.presentation = singleViewPresentation;
        }
    }
}
