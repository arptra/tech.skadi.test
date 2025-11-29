package com.upuphone.xr.sapp.vu.arspace;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.upuphone.xr.sapp.vu.arspace.IArSpaceBridger;
import com.upuphone.xr.sapp.vu.arspace.IOnBrightnessChangeListener;
import com.upuphone.xr.sapp.vu.arspace.IOnCaptureScreenListener;
import com.upuphone.xr.sapp.vu.arspace.IOnDataResultListener;
import com.upuphone.xr.sapp.vu.arspace.IOnDofModeChangeListener;
import com.upuphone.xr.sapp.vu.arspace.IOnGlassesWearStateChangeListener;
import com.upuphone.xr.sapp.vu.arspace.IOnInputTextListener;
import com.upuphone.xr.sapp.vu.arspace.IOnKeyListener;
import com.upuphone.xr.sapp.vu.arspace.IOnRecordScreenListener;
import com.upuphone.xr.sapp.vu.arspace.IOnRequestChangeLanguageListener;
import com.upuphone.xr.sapp.vu.arspace.IOnRequestExitArSpaceListener;
import com.upuphone.xr.sapp.vu.arspace.IOnRequestPermissionResultListener;
import com.xjsd.ai.assistant.protocol.VuiModelType;

public class ArSpaceBridger {

    /* renamed from: a  reason: collision with root package name */
    public IArSpaceBridger f8040a = null;
    public final Context b;
    public OnBrightnessChangeListener c;
    public final IOnBrightnessChangeListener d = new IOnBrightnessChangeListener.Stub() {
        public void onBrightnessChange(int i) throws RemoteException {
            if (ArSpaceBridger.this.c != null) {
                ArSpaceBridger.this.c.onBrightnessChange(i);
            }
        }
    };
    public OnDofModeChangeListener e;
    public final IOnDofModeChangeListener f = new IOnDofModeChangeListener.Stub() {
        public void onDofModeChanged(int i) throws RemoteException {
            if (ArSpaceBridger.this.e != null) {
                ArSpaceBridger.this.e.onDofModeChanged(i);
            }
        }
    };
    public OnRecordScreenListener g;
    public final IOnRecordScreenListener h = new IOnRecordScreenListener.Stub() {
        public void onPrepare(int i) throws RemoteException {
            if (ArSpaceBridger.this.g != null) {
                ArSpaceBridger.this.g.onPrepare(i);
            }
        }

        public void onRecordScreenEnd(String str) throws RemoteException {
            if (ArSpaceBridger.this.g != null) {
                ArSpaceBridger.this.g.onRecordScreenEnd(str);
            }
        }

        public void onRecordScreenStart() throws RemoteException {
            if (ArSpaceBridger.this.g != null) {
                ArSpaceBridger.this.g.onRecordScreenStart();
            }
        }
    };
    public OnCaptureScreenListener i;
    public final IOnCaptureScreenListener j = new IOnCaptureScreenListener.Stub() {
        public void onCaptureScreenEnd(String str) throws RemoteException {
            if (ArSpaceBridger.this.i != null) {
                ArSpaceBridger.this.i.onCaptureScreenEnd(str);
            }
        }

        public void onCaptureScreenStart() throws RemoteException {
            if (ArSpaceBridger.this.i != null) {
                ArSpaceBridger.this.i.onCaptureScreenStart();
            }
        }

        public void onPrepare(int i) throws RemoteException {
            if (ArSpaceBridger.this.i != null) {
                ArSpaceBridger.this.i.onPrepare(i);
            }
        }
    };
    public OnInputTextListener k;
    public final IOnInputTextListener l = new IOnInputTextListener.Stub() {
        public void onAction(String str, int i) throws RemoteException {
            if (ArSpaceBridger.this.k != null) {
                ArSpaceBridger.this.k.onAction(str, i);
            }
        }

        public void onSelectionChange(String str, int i, int i2) throws RemoteException {
            if (ArSpaceBridger.this.k != null) {
                ArSpaceBridger.this.k.onSelectionChange(str, i, i2);
            }
        }

        public void onTextChange(String str, String str2) throws RemoteException {
            if (ArSpaceBridger.this.k != null) {
                ArSpaceBridger.this.k.onTextChange(str, str2);
            }
        }
    };
    public OnKeyListener m;
    public OnKeyListener n;
    public final IOnKeyListener o = new IOnKeyListener.Stub() {
        public void onKeyEvent(int i, int i2, int i3) throws RemoteException {
            if (i == 1) {
                if (ArSpaceBridger.this.n != null) {
                    ArSpaceBridger.this.n.onKeyEvent(i2, i3);
                }
            } else if (ArSpaceBridger.this.m != null) {
                ArSpaceBridger.this.m.onKeyEvent(i2, i3);
            }
        }
    };
    public OnRequestExitArSpaceListener p;
    public final IOnRequestExitArSpaceListener q = new IOnRequestExitArSpaceListener.Stub() {
        public void onRequestExit(boolean z) throws RemoteException {
            if (ArSpaceBridger.this.p != null) {
                ArSpaceBridger.this.p.onRequestExit(z);
            }
        }
    };
    public OnRequestChangeLanguageListener r;
    public final IOnRequestChangeLanguageListener s = new IOnRequestChangeLanguageListener.Stub() {
        public void onRequestChangeLanguage(String str) throws RemoteException {
            if (ArSpaceBridger.this.r != null) {
                ArSpaceBridger.this.r.onRequestChangeLanguage(str);
            }
        }
    };
    public OnGlassesWearStateChangeListener t;
    public final IOnGlassesWearStateChangeListener u = new IOnGlassesWearStateChangeListener.Stub() {
        public void onGlassesWearStateChange(boolean z) throws RemoteException {
            if (ArSpaceBridger.this.t != null) {
                ArSpaceBridger.this.t.onGlassesWearStateChange(z);
            }
        }
    };
    public OnRequestPermissionResultListener v;
    public final IOnRequestPermissionResultListener w = new IOnRequestPermissionResultListener.Stub() {
        public void onRequestPermissionResult(String str, boolean z) throws RemoteException {
            if (ArSpaceBridger.this.v != null) {
                ArSpaceBridger.this.v.onRequestPermissionResult(str, z);
            }
        }
    };
    public final OnServiceConnectionListener x;
    public final ServiceConnection y;

    static {
        Log.i("ArSpaceBridger", "version: 1.0.6");
    }

    public ArSpaceBridger(Context context, OnServiceConnectionListener onServiceConnectionListener) {
        boolean z;
        AnonymousClass11 r1 = new ServiceConnection() {
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Log.d("ArSpaceBridger", "onServiceConnected");
                ArSpaceBridger.this.f8040a = IArSpaceBridger.Stub.asInterface(iBinder);
                try {
                    ArSpaceBridger.this.f8040a.addOnBrightnessChangeListener(ArSpaceBridger.this.d);
                    ArSpaceBridger.this.f8040a.addOnDofModeChangeListener(ArSpaceBridger.this.f);
                    ArSpaceBridger.this.f8040a.addOnRecordScreenListener(ArSpaceBridger.this.h);
                    ArSpaceBridger.this.f8040a.addOnCaptureScreenListener(ArSpaceBridger.this.j);
                    ArSpaceBridger.this.f8040a.addOnInputTextListener(ArSpaceBridger.this.l);
                    ArSpaceBridger.this.f8040a.addOnRequestExitArSpaceListener(ArSpaceBridger.this.q);
                    ArSpaceBridger.this.f8040a.addOnKeyListener(ArSpaceBridger.this.o);
                    ArSpaceBridger.this.f8040a.addOnRequestChangeLanguageListener(ArSpaceBridger.this.s);
                    ArSpaceBridger.this.f8040a.addOnGlassesWearStateChangeListener(ArSpaceBridger.this.u);
                    ArSpaceBridger.this.f8040a.addOnRequestPermissionResultListener(ArSpaceBridger.this.w);
                } catch (Exception e) {
                    Log.e("ArSpaceBridger", "onServiceConnected error", e);
                }
                if (ArSpaceBridger.this.x != null) {
                    ArSpaceBridger.this.x.onServiceConnected();
                }
            }

            public void onServiceDisconnected(ComponentName componentName) {
                Log.d("ArSpaceBridger", "onServiceDisconnected");
                ArSpaceBridger.this.f8040a = null;
                if (ArSpaceBridger.this.x != null) {
                    ArSpaceBridger.this.x.a();
                }
            }
        };
        this.y = r1;
        this.b = context;
        this.x = onServiceConnectionListener;
        Intent intent = new Intent();
        try {
            intent.setPackage("com.upuphone.star.launcher");
            intent.setAction("com.upuphone.xr.sapp.AR_SPACE_SERVICE");
            boolean bindService = context.bindService(intent, r1, 1);
            Log.d("ArSpaceBridger", "bindService: " + bindService);
            z = !bindService;
        } catch (Exception e2) {
            Log.d("ArSpaceBridger", "Service not found, use moke service", e2);
            z = true;
        }
        if (z) {
            intent.setClassName(context.getPackageName(), "com.upuphone.xr.sapp.vu.arspace.ArSpaceMockService");
            context.bindService(intent, this.y, 1);
        }
    }

    public int A() {
        try {
            return this.f8040a.getBrightness();
        } catch (Exception e2) {
            Log.e("ArSpaceBridger", "getBrightness error", e2);
            return 0;
        }
    }

    public String B() {
        try {
            return this.f8040a.getLanguage();
        } catch (Exception e2) {
            Log.e("ArSpaceBridger", "getLanguage error", e2);
            return "";
        }
    }

    public void C(final OnDataResultListener onDataResultListener) {
        try {
            this.f8040a.requestData("sport", new IOnDataResultListener.Stub() {
                public void onResult(String str, int i, String str2) throws RemoteException {
                    OnDataResultListener onDataResultListener = onDataResultListener;
                    if (onDataResultListener != null) {
                        onDataResultListener.onResult(i, str2);
                    }
                }
            });
        } catch (Exception e2) {
            Log.e("ArSpaceBridger", "getWeather error", e2);
        }
    }

    public void D(final OnDataResultListener onDataResultListener) {
        try {
            this.f8040a.requestData(VuiModelType.WEATHER, new IOnDataResultListener.Stub() {
                public void onResult(String str, int i, String str2) throws RemoteException {
                    OnDataResultListener onDataResultListener = onDataResultListener;
                    if (onDataResultListener != null) {
                        onDataResultListener.onResult(i, str2);
                    }
                }
            });
        } catch (Exception e2) {
            Log.e("ArSpaceBridger", "getWeather error", e2);
        }
    }

    public void E() {
        try {
            this.f8040a.onExitArSpace();
        } catch (Exception e2) {
            Log.e("ArSpaceBridger", "exitArSpace error", e2);
        }
    }

    public void F(String str, String str2, String str3, String[] strArr) {
        try {
            this.f8040a.requestPermission(str, str2, str3, strArr);
        } catch (Exception e2) {
            Log.e("ArSpaceBridger", "requestPermission error", e2);
        }
    }

    public void G(int i2) {
        try {
            this.f8040a.setBrightness(i2);
        } catch (Exception e2) {
            Log.e("ArSpaceBridger", "setBrightness error", e2);
        }
    }

    public void H(OnKeyListener onKeyListener) {
        this.m = onKeyListener;
    }

    public void I(OnBrightnessChangeListener onBrightnessChangeListener) {
        this.c = onBrightnessChangeListener;
    }

    public void J(OnCaptureScreenListener onCaptureScreenListener) {
        this.i = onCaptureScreenListener;
    }

    public void K(OnGlassesWearStateChangeListener onGlassesWearStateChangeListener) {
        this.t = onGlassesWearStateChangeListener;
    }

    public void L(OnRequestExitArSpaceListener onRequestExitArSpaceListener) {
        this.p = onRequestExitArSpaceListener;
    }

    public void M(OnRequestPermissionResultListener onRequestPermissionResultListener) {
        this.v = onRequestPermissionResultListener;
    }

    public void N(OnKeyListener onKeyListener) {
        this.n = onKeyListener;
    }

    public void y() {
        try {
            this.f8040a.captureScreen();
        } catch (Exception e2) {
            Log.e("ArSpaceBridger", "takeScreenshot error", e2);
        }
    }

    public void z() {
        try {
            this.f8040a.removeOnBrightnessChangeListener(this.d);
            this.f8040a.removeOnDofModeChangeListener(this.f);
            this.f8040a.removeOnRecordScreenListener(this.h);
            this.f8040a.removeOnCaptureScreenListener(this.j);
            this.f8040a.removeOnInputTextListener(this.l);
            this.f8040a.removeOnRequestExitArSpaceListener(this.q);
            this.b.unbindService(this.y);
            this.f8040a = null;
        } catch (RemoteException e2) {
            throw new RuntimeException(e2);
        }
    }
}
