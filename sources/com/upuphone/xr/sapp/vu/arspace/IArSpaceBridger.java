package com.upuphone.xr.sapp.vu.arspace;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.upuphone.xr.sapp.vu.arspace.IOnBrightnessChangeListener;
import com.upuphone.xr.sapp.vu.arspace.IOnCaptureScreenListener;
import com.upuphone.xr.sapp.vu.arspace.IOnCheckUrlResultListener;
import com.upuphone.xr.sapp.vu.arspace.IOnDataResultListener;
import com.upuphone.xr.sapp.vu.arspace.IOnDofModeChangeListener;
import com.upuphone.xr.sapp.vu.arspace.IOnGlassesWearStateChangeListener;
import com.upuphone.xr.sapp.vu.arspace.IOnInputTextListener;
import com.upuphone.xr.sapp.vu.arspace.IOnKeyListener;
import com.upuphone.xr.sapp.vu.arspace.IOnRecordScreenListener;
import com.upuphone.xr.sapp.vu.arspace.IOnRequestChangeLanguageListener;
import com.upuphone.xr.sapp.vu.arspace.IOnRequestExitArSpaceListener;
import com.upuphone.xr.sapp.vu.arspace.IOnRequestPermissionResultListener;
import java.util.Map;

public interface IArSpaceBridger extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.sapp.vu.arspace.IArSpaceBridger";

    public static class Default implements IArSpaceBridger {
        public void addOnBrightnessChangeListener(IOnBrightnessChangeListener iOnBrightnessChangeListener) throws RemoteException {
        }

        public void addOnCaptureScreenListener(IOnCaptureScreenListener iOnCaptureScreenListener) throws RemoteException {
        }

        public void addOnDofModeChangeListener(IOnDofModeChangeListener iOnDofModeChangeListener) throws RemoteException {
        }

        public void addOnGlassesWearStateChangeListener(IOnGlassesWearStateChangeListener iOnGlassesWearStateChangeListener) throws RemoteException {
        }

        public void addOnInputTextListener(IOnInputTextListener iOnInputTextListener) throws RemoteException {
        }

        public void addOnKeyListener(IOnKeyListener iOnKeyListener) throws RemoteException {
        }

        public void addOnRecordScreenListener(IOnRecordScreenListener iOnRecordScreenListener) throws RemoteException {
        }

        public void addOnRequestChangeLanguageListener(IOnRequestChangeLanguageListener iOnRequestChangeLanguageListener) throws RemoteException {
        }

        public void addOnRequestExitArSpaceListener(IOnRequestExitArSpaceListener iOnRequestExitArSpaceListener) throws RemoteException {
        }

        public void addOnRequestPermissionResultListener(IOnRequestPermissionResultListener iOnRequestPermissionResultListener) throws RemoteException {
        }

        public IBinder asBinder() {
            return null;
        }

        public void captureScreen() throws RemoteException {
        }

        public void checkUrl(String str, IOnCheckUrlResultListener iOnCheckUrlResultListener) throws RemoteException {
        }

        public void endInputText() throws RemoteException {
        }

        public void endScreenRecord() throws RemoteException {
        }

        public int getBrightness() throws RemoteException {
            return 0;
        }

        public int getDofMode() throws RemoteException {
            return 0;
        }

        public String getLanguage() throws RemoteException {
            return null;
        }

        public int getMaxBrightness() throws RemoteException {
            return 0;
        }

        public int getMinBrightness() throws RemoteException {
            return 0;
        }

        public boolean isGlassesWorn() throws RemoteException {
            return false;
        }

        public void onExitArSpace() throws RemoteException {
        }

        public void removeOnBrightnessChangeListener(IOnBrightnessChangeListener iOnBrightnessChangeListener) throws RemoteException {
        }

        public void removeOnCaptureScreenListener(IOnCaptureScreenListener iOnCaptureScreenListener) throws RemoteException {
        }

        public void removeOnDofModeChangeListener(IOnDofModeChangeListener iOnDofModeChangeListener) throws RemoteException {
        }

        public void removeOnGlassesWearStateChangeListener(IOnGlassesWearStateChangeListener iOnGlassesWearStateChangeListener) throws RemoteException {
        }

        public void removeOnInputTextListener(IOnInputTextListener iOnInputTextListener) throws RemoteException {
        }

        public void removeOnKeyListener(IOnKeyListener iOnKeyListener) throws RemoteException {
        }

        public void removeOnRecordScreenListener(IOnRecordScreenListener iOnRecordScreenListener) throws RemoteException {
        }

        public void removeOnRequestChangeLanguageListener(IOnRequestChangeLanguageListener iOnRequestChangeLanguageListener) throws RemoteException {
        }

        public void removeOnRequestExitArSpaceListener(IOnRequestExitArSpaceListener iOnRequestExitArSpaceListener) throws RemoteException {
        }

        public void removeOnRequestPermissionResultListener(IOnRequestPermissionResultListener iOnRequestPermissionResultListener) throws RemoteException {
        }

        public void reportEvent(String str, Map map) throws RemoteException {
        }

        public void requestData(String str, IOnDataResultListener iOnDataResultListener) throws RemoteException {
        }

        public void requestPermission(String str, String str2, String str3, String[] strArr) throws RemoteException {
        }

        public void setBrightness(int i) throws RemoteException {
        }

        public void setDofMode(int i) throws RemoteException {
        }

        public void startInputText(EditTextInfo editTextInfo) throws RemoteException {
        }

        public void startScreenRecord() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IArSpaceBridger {
        static final int TRANSACTION_addOnBrightnessChangeListener = 5;
        static final int TRANSACTION_addOnCaptureScreenListener = 13;
        static final int TRANSACTION_addOnDofModeChangeListener = 9;
        static final int TRANSACTION_addOnGlassesWearStateChangeListener = 33;
        static final int TRANSACTION_addOnInputTextListener = 18;
        static final int TRANSACTION_addOnKeyListener = 27;
        static final int TRANSACTION_addOnRecordScreenListener = 11;
        static final int TRANSACTION_addOnRequestChangeLanguageListener = 30;
        static final int TRANSACTION_addOnRequestExitArSpaceListener = 23;
        static final int TRANSACTION_addOnRequestPermissionResultListener = 36;
        static final int TRANSACTION_captureScreen = 17;
        static final int TRANSACTION_checkUrl = 26;
        static final int TRANSACTION_endInputText = 21;
        static final int TRANSACTION_endScreenRecord = 16;
        static final int TRANSACTION_getBrightness = 3;
        static final int TRANSACTION_getDofMode = 8;
        static final int TRANSACTION_getLanguage = 29;
        static final int TRANSACTION_getMaxBrightness = 1;
        static final int TRANSACTION_getMinBrightness = 2;
        static final int TRANSACTION_isGlassesWorn = 32;
        static final int TRANSACTION_onExitArSpace = 25;
        static final int TRANSACTION_removeOnBrightnessChangeListener = 6;
        static final int TRANSACTION_removeOnCaptureScreenListener = 14;
        static final int TRANSACTION_removeOnDofModeChangeListener = 10;
        static final int TRANSACTION_removeOnGlassesWearStateChangeListener = 34;
        static final int TRANSACTION_removeOnInputTextListener = 19;
        static final int TRANSACTION_removeOnKeyListener = 28;
        static final int TRANSACTION_removeOnRecordScreenListener = 12;
        static final int TRANSACTION_removeOnRequestChangeLanguageListener = 31;
        static final int TRANSACTION_removeOnRequestExitArSpaceListener = 24;
        static final int TRANSACTION_removeOnRequestPermissionResultListener = 37;
        static final int TRANSACTION_reportEvent = 38;
        static final int TRANSACTION_requestData = 22;
        static final int TRANSACTION_requestPermission = 35;
        static final int TRANSACTION_setBrightness = 4;
        static final int TRANSACTION_setDofMode = 7;
        static final int TRANSACTION_startInputText = 20;
        static final int TRANSACTION_startScreenRecord = 15;

        public static class Proxy implements IArSpaceBridger {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public void addOnBrightnessChangeListener(IOnBrightnessChangeListener iOnBrightnessChangeListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IArSpaceBridger.DESCRIPTOR);
                    obtain.writeStrongInterface(iOnBrightnessChangeListener);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void addOnCaptureScreenListener(IOnCaptureScreenListener iOnCaptureScreenListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IArSpaceBridger.DESCRIPTOR);
                    obtain.writeStrongInterface(iOnCaptureScreenListener);
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void addOnDofModeChangeListener(IOnDofModeChangeListener iOnDofModeChangeListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IArSpaceBridger.DESCRIPTOR);
                    obtain.writeStrongInterface(iOnDofModeChangeListener);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void addOnGlassesWearStateChangeListener(IOnGlassesWearStateChangeListener iOnGlassesWearStateChangeListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IArSpaceBridger.DESCRIPTOR);
                    obtain.writeStrongInterface(iOnGlassesWearStateChangeListener);
                    this.mRemote.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void addOnInputTextListener(IOnInputTextListener iOnInputTextListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IArSpaceBridger.DESCRIPTOR);
                    obtain.writeStrongInterface(iOnInputTextListener);
                    this.mRemote.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void addOnKeyListener(IOnKeyListener iOnKeyListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IArSpaceBridger.DESCRIPTOR);
                    obtain.writeStrongInterface(iOnKeyListener);
                    this.mRemote.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void addOnRecordScreenListener(IOnRecordScreenListener iOnRecordScreenListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IArSpaceBridger.DESCRIPTOR);
                    obtain.writeStrongInterface(iOnRecordScreenListener);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void addOnRequestChangeLanguageListener(IOnRequestChangeLanguageListener iOnRequestChangeLanguageListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IArSpaceBridger.DESCRIPTOR);
                    obtain.writeStrongInterface(iOnRequestChangeLanguageListener);
                    this.mRemote.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void addOnRequestExitArSpaceListener(IOnRequestExitArSpaceListener iOnRequestExitArSpaceListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IArSpaceBridger.DESCRIPTOR);
                    obtain.writeStrongInterface(iOnRequestExitArSpaceListener);
                    this.mRemote.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void addOnRequestPermissionResultListener(IOnRequestPermissionResultListener iOnRequestPermissionResultListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IArSpaceBridger.DESCRIPTOR);
                    obtain.writeStrongInterface(iOnRequestPermissionResultListener);
                    this.mRemote.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void captureScreen() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IArSpaceBridger.DESCRIPTOR);
                    this.mRemote.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void checkUrl(String str, IOnCheckUrlResultListener iOnCheckUrlResultListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IArSpaceBridger.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeStrongInterface(iOnCheckUrlResultListener);
                    this.mRemote.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void endInputText() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IArSpaceBridger.DESCRIPTOR);
                    this.mRemote.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void endScreenRecord() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IArSpaceBridger.DESCRIPTOR);
                    this.mRemote.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getBrightness() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IArSpaceBridger.DESCRIPTOR);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getDofMode() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IArSpaceBridger.DESCRIPTOR);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IArSpaceBridger.DESCRIPTOR;
            }

            public String getLanguage() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IArSpaceBridger.DESCRIPTOR);
                    this.mRemote.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getMaxBrightness() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IArSpaceBridger.DESCRIPTOR);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getMinBrightness() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IArSpaceBridger.DESCRIPTOR);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isGlassesWorn() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IArSpaceBridger.DESCRIPTOR);
                    boolean z = false;
                    this.mRemote.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onExitArSpace() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IArSpaceBridger.DESCRIPTOR);
                    this.mRemote.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void removeOnBrightnessChangeListener(IOnBrightnessChangeListener iOnBrightnessChangeListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IArSpaceBridger.DESCRIPTOR);
                    obtain.writeStrongInterface(iOnBrightnessChangeListener);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void removeOnCaptureScreenListener(IOnCaptureScreenListener iOnCaptureScreenListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IArSpaceBridger.DESCRIPTOR);
                    obtain.writeStrongInterface(iOnCaptureScreenListener);
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void removeOnDofModeChangeListener(IOnDofModeChangeListener iOnDofModeChangeListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IArSpaceBridger.DESCRIPTOR);
                    obtain.writeStrongInterface(iOnDofModeChangeListener);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void removeOnGlassesWearStateChangeListener(IOnGlassesWearStateChangeListener iOnGlassesWearStateChangeListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IArSpaceBridger.DESCRIPTOR);
                    obtain.writeStrongInterface(iOnGlassesWearStateChangeListener);
                    this.mRemote.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void removeOnInputTextListener(IOnInputTextListener iOnInputTextListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IArSpaceBridger.DESCRIPTOR);
                    obtain.writeStrongInterface(iOnInputTextListener);
                    this.mRemote.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void removeOnKeyListener(IOnKeyListener iOnKeyListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IArSpaceBridger.DESCRIPTOR);
                    obtain.writeStrongInterface(iOnKeyListener);
                    this.mRemote.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void removeOnRecordScreenListener(IOnRecordScreenListener iOnRecordScreenListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IArSpaceBridger.DESCRIPTOR);
                    obtain.writeStrongInterface(iOnRecordScreenListener);
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void removeOnRequestChangeLanguageListener(IOnRequestChangeLanguageListener iOnRequestChangeLanguageListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IArSpaceBridger.DESCRIPTOR);
                    obtain.writeStrongInterface(iOnRequestChangeLanguageListener);
                    this.mRemote.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void removeOnRequestExitArSpaceListener(IOnRequestExitArSpaceListener iOnRequestExitArSpaceListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IArSpaceBridger.DESCRIPTOR);
                    obtain.writeStrongInterface(iOnRequestExitArSpaceListener);
                    this.mRemote.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void removeOnRequestPermissionResultListener(IOnRequestPermissionResultListener iOnRequestPermissionResultListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IArSpaceBridger.DESCRIPTOR);
                    obtain.writeStrongInterface(iOnRequestPermissionResultListener);
                    this.mRemote.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void reportEvent(String str, Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IArSpaceBridger.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeMap(map);
                    this.mRemote.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void requestData(String str, IOnDataResultListener iOnDataResultListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IArSpaceBridger.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeStrongInterface(iOnDataResultListener);
                    this.mRemote.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void requestPermission(String str, String str2, String str3, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IArSpaceBridger.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeStringArray(strArr);
                    this.mRemote.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setBrightness(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IArSpaceBridger.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setDofMode(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IArSpaceBridger.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void startInputText(EditTextInfo editTextInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IArSpaceBridger.DESCRIPTOR);
                    _Parcel.d(obtain, editTextInfo, 0);
                    this.mRemote.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void startScreenRecord() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IArSpaceBridger.DESCRIPTOR);
                    this.mRemote.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IArSpaceBridger.DESCRIPTOR);
        }

        public static IArSpaceBridger asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IArSpaceBridger.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IArSpaceBridger)) ? new Proxy(iBinder) : (IArSpaceBridger) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IArSpaceBridger.DESCRIPTOR);
            }
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        int maxBrightness = getMaxBrightness();
                        parcel2.writeNoException();
                        parcel2.writeInt(maxBrightness);
                        break;
                    case 2:
                        int minBrightness = getMinBrightness();
                        parcel2.writeNoException();
                        parcel2.writeInt(minBrightness);
                        break;
                    case 3:
                        int brightness = getBrightness();
                        parcel2.writeNoException();
                        parcel2.writeInt(brightness);
                        break;
                    case 4:
                        setBrightness(parcel.readInt());
                        parcel2.writeNoException();
                        break;
                    case 5:
                        addOnBrightnessChangeListener(IOnBrightnessChangeListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 6:
                        removeOnBrightnessChangeListener(IOnBrightnessChangeListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 7:
                        setDofMode(parcel.readInt());
                        parcel2.writeNoException();
                        break;
                    case 8:
                        int dofMode = getDofMode();
                        parcel2.writeNoException();
                        parcel2.writeInt(dofMode);
                        break;
                    case 9:
                        addOnDofModeChangeListener(IOnDofModeChangeListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 10:
                        removeOnDofModeChangeListener(IOnDofModeChangeListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 11:
                        addOnRecordScreenListener(IOnRecordScreenListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 12:
                        removeOnRecordScreenListener(IOnRecordScreenListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 13:
                        addOnCaptureScreenListener(IOnCaptureScreenListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 14:
                        removeOnCaptureScreenListener(IOnCaptureScreenListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 15:
                        startScreenRecord();
                        parcel2.writeNoException();
                        break;
                    case 16:
                        endScreenRecord();
                        parcel2.writeNoException();
                        break;
                    case 17:
                        captureScreen();
                        parcel2.writeNoException();
                        break;
                    case 18:
                        addOnInputTextListener(IOnInputTextListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 19:
                        removeOnInputTextListener(IOnInputTextListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 20:
                        startInputText((EditTextInfo) _Parcel.c(parcel, EditTextInfo.CREATOR));
                        parcel2.writeNoException();
                        break;
                    case 21:
                        endInputText();
                        parcel2.writeNoException();
                        break;
                    case 22:
                        requestData(parcel.readString(), IOnDataResultListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 23:
                        addOnRequestExitArSpaceListener(IOnRequestExitArSpaceListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 24:
                        removeOnRequestExitArSpaceListener(IOnRequestExitArSpaceListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 25:
                        onExitArSpace();
                        parcel2.writeNoException();
                        break;
                    case 26:
                        checkUrl(parcel.readString(), IOnCheckUrlResultListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 27:
                        addOnKeyListener(IOnKeyListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 28:
                        removeOnKeyListener(IOnKeyListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 29:
                        String language = getLanguage();
                        parcel2.writeNoException();
                        parcel2.writeString(language);
                        break;
                    case 30:
                        addOnRequestChangeLanguageListener(IOnRequestChangeLanguageListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 31:
                        removeOnRequestChangeLanguageListener(IOnRequestChangeLanguageListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 32:
                        boolean isGlassesWorn = isGlassesWorn();
                        parcel2.writeNoException();
                        parcel2.writeInt(isGlassesWorn ? 1 : 0);
                        break;
                    case 33:
                        addOnGlassesWearStateChangeListener(IOnGlassesWearStateChangeListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 34:
                        removeOnGlassesWearStateChangeListener(IOnGlassesWearStateChangeListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 35:
                        requestPermission(parcel.readString(), parcel.readString(), parcel.readString(), parcel.createStringArray());
                        parcel2.writeNoException();
                        break;
                    case 36:
                        addOnRequestPermissionResultListener(IOnRequestPermissionResultListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 37:
                        removeOnRequestPermissionResultListener(IOnRequestPermissionResultListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 38:
                        reportEvent(parcel.readString(), parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        break;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
                return true;
            }
            parcel2.writeString(IArSpaceBridger.DESCRIPTOR);
            return true;
        }
    }

    public static class _Parcel {
        public static Object c(Parcel parcel, Parcelable.Creator creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        public static void d(Parcel parcel, Parcelable parcelable, int i) {
            if (parcelable != null) {
                parcel.writeInt(1);
                parcelable.writeToParcel(parcel, i);
                return;
            }
            parcel.writeInt(0);
        }
    }

    void addOnBrightnessChangeListener(IOnBrightnessChangeListener iOnBrightnessChangeListener) throws RemoteException;

    void addOnCaptureScreenListener(IOnCaptureScreenListener iOnCaptureScreenListener) throws RemoteException;

    void addOnDofModeChangeListener(IOnDofModeChangeListener iOnDofModeChangeListener) throws RemoteException;

    void addOnGlassesWearStateChangeListener(IOnGlassesWearStateChangeListener iOnGlassesWearStateChangeListener) throws RemoteException;

    void addOnInputTextListener(IOnInputTextListener iOnInputTextListener) throws RemoteException;

    void addOnKeyListener(IOnKeyListener iOnKeyListener) throws RemoteException;

    void addOnRecordScreenListener(IOnRecordScreenListener iOnRecordScreenListener) throws RemoteException;

    void addOnRequestChangeLanguageListener(IOnRequestChangeLanguageListener iOnRequestChangeLanguageListener) throws RemoteException;

    void addOnRequestExitArSpaceListener(IOnRequestExitArSpaceListener iOnRequestExitArSpaceListener) throws RemoteException;

    void addOnRequestPermissionResultListener(IOnRequestPermissionResultListener iOnRequestPermissionResultListener) throws RemoteException;

    void captureScreen() throws RemoteException;

    void checkUrl(String str, IOnCheckUrlResultListener iOnCheckUrlResultListener) throws RemoteException;

    void endInputText() throws RemoteException;

    void endScreenRecord() throws RemoteException;

    int getBrightness() throws RemoteException;

    int getDofMode() throws RemoteException;

    String getLanguage() throws RemoteException;

    int getMaxBrightness() throws RemoteException;

    int getMinBrightness() throws RemoteException;

    boolean isGlassesWorn() throws RemoteException;

    void onExitArSpace() throws RemoteException;

    void removeOnBrightnessChangeListener(IOnBrightnessChangeListener iOnBrightnessChangeListener) throws RemoteException;

    void removeOnCaptureScreenListener(IOnCaptureScreenListener iOnCaptureScreenListener) throws RemoteException;

    void removeOnDofModeChangeListener(IOnDofModeChangeListener iOnDofModeChangeListener) throws RemoteException;

    void removeOnGlassesWearStateChangeListener(IOnGlassesWearStateChangeListener iOnGlassesWearStateChangeListener) throws RemoteException;

    void removeOnInputTextListener(IOnInputTextListener iOnInputTextListener) throws RemoteException;

    void removeOnKeyListener(IOnKeyListener iOnKeyListener) throws RemoteException;

    void removeOnRecordScreenListener(IOnRecordScreenListener iOnRecordScreenListener) throws RemoteException;

    void removeOnRequestChangeLanguageListener(IOnRequestChangeLanguageListener iOnRequestChangeLanguageListener) throws RemoteException;

    void removeOnRequestExitArSpaceListener(IOnRequestExitArSpaceListener iOnRequestExitArSpaceListener) throws RemoteException;

    void removeOnRequestPermissionResultListener(IOnRequestPermissionResultListener iOnRequestPermissionResultListener) throws RemoteException;

    void reportEvent(String str, Map map) throws RemoteException;

    void requestData(String str, IOnDataResultListener iOnDataResultListener) throws RemoteException;

    void requestPermission(String str, String str2, String str3, String[] strArr) throws RemoteException;

    void setBrightness(int i) throws RemoteException;

    void setDofMode(int i) throws RemoteException;

    void startInputText(EditTextInfo editTextInfo) throws RemoteException;

    void startScreenRecord() throws RemoteException;
}
