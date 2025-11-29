package com.upuphone.starrynetsdk.ability.cast;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import androidx.annotation.NonNull;
import com.upuphone.runasone.uupcast.SinkDisplayConfig;

public class CastSinkView extends SurfaceView implements View.OnTouchListener {
    private static final String TAG = "CastSinkView";
    /* access modifiers changed from: private */
    public SinkDisplayConfig displayConfig;
    /* access modifiers changed from: private */
    public boolean isSinking;
    /* access modifiers changed from: private */
    public OnSinkStateListener onSinkStateListener;
    /* access modifiers changed from: private */
    public boolean postpone;
    /* access modifiers changed from: private */
    public CastSinkAbility sinkAbility;
    private final SinkListener sinkListener;
    /* access modifiers changed from: private */
    public SurfaceHolder surfaceHolder;
    /* access modifiers changed from: private */
    public volatile String uibcTouchTag;

    public interface OnSinkStateListener {
        void onEnd(int i);

        void onStart();
    }

    public CastSinkView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void init() {
        getHolder().addCallback(new SurfaceHolder.Callback() {
            public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
                SurfaceHolder unused = CastSinkView.this.surfaceHolder = surfaceHolder;
                if (CastSinkView.this.postpone) {
                    CastSinkView castSinkView = CastSinkView.this;
                    castSinkView.startDisplay(castSinkView.displayConfig);
                }
            }

            public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
                Log.d(CastSinkView.TAG, "surfaceDestroyed...");
                if (CastSinkView.this.sinkAbility != null) {
                    CastSinkView.this.sinkAbility.stopDisplay();
                } else {
                    Log.d(CastSinkView.TAG, "surfaceDestroyed, sinkAbility is null");
                }
                boolean unused = CastSinkView.this.isSinking = false;
                String unused2 = CastSinkView.this.uibcTouchTag = null;
            }
        });
        setOnTouchListener(this);
    }

    public void installCastSinkAbility(@NonNull CastSinkAbility castSinkAbility) {
        this.sinkAbility = castSinkAbility;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        CastSinkAbility castSinkAbility = this.sinkAbility;
        if (castSinkAbility != null) {
            castSinkAbility.registerSinkListener(this.sinkListener);
        } else {
            Log.d(TAG, "onAttachedToWindow, sinkAbility is null");
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CastSinkAbility castSinkAbility = this.sinkAbility;
        if (castSinkAbility != null) {
            castSinkAbility.unregisterSinkListener(this.sinkListener);
        } else {
            Log.d(TAG, "onDetachedFromWindow, sinkAbility is null");
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.sinkAbility == null) {
            Log.d(TAG, "onTouch, sinkAbility is null");
            return true;
        }
        if (motionEvent.getAction() == 1) {
            view.performClick();
        }
        if (this.uibcTouchTag != null) {
            this.sinkAbility.uibcTouchEvent(this.uibcTouchTag, getMeasuredWidth(), getMeasuredHeight(), motionEvent);
        }
        return true;
    }

    public void setOnSinkStateListener(OnSinkStateListener onSinkStateListener2) {
        this.onSinkStateListener = onSinkStateListener2;
    }

    public void startDisplay(@NonNull SinkDisplayConfig sinkDisplayConfig) {
        if (this.sinkAbility == null) {
            throw new IllegalStateException("CastSinkAbility is not installed yet");
        } else if (!this.isSinking) {
            if (sinkDisplayConfig.getWidth() < 16 || sinkDisplayConfig.getHeight() < 16) {
                this.displayConfig = new SinkDisplayConfig.Builder(sinkDisplayConfig).setWidth(getMeasuredWidth()).setHeight(getMeasuredHeight()).build();
            } else {
                this.displayConfig = sinkDisplayConfig;
            }
            if (this.surfaceHolder != null) {
                Log.d(TAG, "startDisplay: captureType: " + this.displayConfig.getCaptureType() + ", displayFlag: " + this.displayConfig.getDisplayFlag() + ", densityDpi: " + this.displayConfig.getDensityDpi() + ", width: " + this.displayConfig.getWidth() + ", height: " + this.displayConfig.getHeight() + ", tag: " + this.displayConfig.getTag());
                int startDisplay = this.sinkAbility.startDisplay(this.surfaceHolder.getSurface(), this.displayConfig);
                if (startDisplay != 0) {
                    Log.e(TAG, "startDisplay failed, error code:" + startDisplay);
                    this.isSinking = false;
                    return;
                }
                this.isSinking = true;
                SinkDisplayConfig displayConfig2 = this.sinkAbility.getDisplayConfig();
                if (displayConfig2 != null) {
                    if ((displayConfig2.getDisplayFlag() & 16) != 0) {
                        this.uibcTouchTag = CastConst.UIBC_DEFAULT_DISPLAY_TAG;
                    } else {
                        this.uibcTouchTag = displayConfig2.getTag();
                    }
                    Log.d(TAG, "uibc touch tag is " + this.uibcTouchTag);
                    return;
                }
                Log.e(TAG, "get finial cast config failed, can not resolve uibc tag");
                return;
            }
            this.postpone = true;
        }
    }

    public void uibcCustomEvent(String str) {
        CastSinkAbility castSinkAbility = this.sinkAbility;
        if (castSinkAbility != null) {
            castSinkAbility.uibcCustomEvent(str);
        } else {
            Log.d(TAG, "uibcCustomEvent, sinkAbility is null");
        }
    }

    @Deprecated
    public void uibcKeyEvent(int i, int i2) {
        CastSinkAbility castSinkAbility = this.sinkAbility;
        if (castSinkAbility != null) {
            castSinkAbility.uibcKeyEvent("default", i, i2);
        } else {
            Log.d(TAG, "uibcKeyEvent, sinkAbility is null");
        }
    }

    public CastSinkView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CastSinkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.postpone = false;
        this.isSinking = false;
        this.uibcTouchTag = null;
        this.sinkListener = new SinkListener() {
            public void onSinkConnected() {
                if (CastSinkView.this.onSinkStateListener != null) {
                    CastSinkView.this.onSinkStateListener.onStart();
                }
            }

            public void onSinkDisconnected() {
                boolean unused = CastSinkView.this.isSinking = false;
                String unused2 = CastSinkView.this.uibcTouchTag = null;
                if (CastSinkView.this.onSinkStateListener != null) {
                    CastSinkView.this.onSinkStateListener.onEnd(0);
                }
            }

            public void onSinkError(int i) {
                boolean unused = CastSinkView.this.isSinking = false;
                String unused2 = CastSinkView.this.uibcTouchTag = null;
                if (CastSinkView.this.onSinkStateListener != null) {
                    CastSinkView.this.onSinkStateListener.onEnd(i);
                }
            }

            public void onSinkEvent(int i, @NonNull Bundle bundle) {
            }

            public void onSinkStart() {
            }

            public void onSyncSinkError(int i) {
                boolean unused = CastSinkView.this.isSinking = false;
                String unused2 = CastSinkView.this.uibcTouchTag = null;
                if (CastSinkView.this.onSinkStateListener != null) {
                    CastSinkView.this.onSinkStateListener.onEnd(i);
                }
            }
        };
        init();
    }

    public void uibcKeyEvent(String str, int i, int i2) {
        CastSinkAbility castSinkAbility = this.sinkAbility;
        if (castSinkAbility != null) {
            castSinkAbility.uibcKeyEvent(str, i, i2);
        } else {
            Log.d(TAG, "uibcKeyEvent, sinkAbility is null");
        }
    }
}
