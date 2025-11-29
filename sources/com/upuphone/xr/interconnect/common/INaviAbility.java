package com.upuphone.xr.interconnect.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.upuphone.xr.interconnect.common.INaviActionResult;
import com.upuphone.xr.interconnect.common.INaviLocationCallback;
import com.upuphone.xr.interconnect.common.INaviPoiCallback;
import com.upuphone.xr.interconnect.entity.PoiResult;
import java.util.List;

public interface INaviAbility extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.interconnect.common.INaviAbility";

    public static class Default implements INaviAbility {
        public void PoiSearch(int i, String str, INaviPoiCallback iNaviPoiCallback) throws RemoteException {
        }

        public IBinder asBinder() {
            return null;
        }

        public void changeNavi(int i, INaviActionResult iNaviActionResult) throws RemoteException {
        }

        public void changeRoute(int i, INaviActionResult iNaviActionResult) throws RemoteException {
        }

        public List<String> findDeniedPermissions() throws RemoteException {
            return null;
        }

        public List<PoiResult> getFreqVisitedAddress() throws RemoteException {
            return null;
        }

        public double[] getLocation() throws RemoteException {
            return null;
        }

        public boolean hasAddress(int i) throws RemoteException {
            return false;
        }

        public boolean isNaviOpened() throws RemoteException {
            return false;
        }

        public boolean isNaviSpeakOn() throws RemoteException {
            return false;
        }

        public boolean isNaving() throws RemoteException {
            return false;
        }

        public boolean isTrafficEnabled() throws RemoteException {
            return false;
        }

        public boolean readTrafficInfo(int i) throws RemoteException {
            return false;
        }

        public boolean refreshNavi() throws RemoteException {
            return false;
        }

        public boolean saveNaviAddress(PoiResult poiResult, int i) throws RemoteException {
            return false;
        }

        public void setNaviSpeak(boolean z) throws RemoteException {
        }

        public void setTrafficEnabled(boolean z) throws RemoteException {
        }

        public void startLocation(INaviLocationCallback iNaviLocationCallback) throws RemoteException {
        }

        public void startNavi(int i, int i2, PoiResult poiResult, INaviActionResult iNaviActionResult) throws RemoteException {
        }

        public void startNaviToAddress(int i, INaviActionResult iNaviActionResult) throws RemoteException {
        }

        public void stopLocation(INaviLocationCallback iNaviLocationCallback) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements INaviAbility {
        static final int TRANSACTION_PoiSearch = 2;
        static final int TRANSACTION_changeNavi = 10;
        static final int TRANSACTION_changeRoute = 11;
        static final int TRANSACTION_findDeniedPermissions = 18;
        static final int TRANSACTION_getFreqVisitedAddress = 20;
        static final int TRANSACTION_getLocation = 9;
        static final int TRANSACTION_hasAddress = 3;
        static final int TRANSACTION_isNaviOpened = 6;
        static final int TRANSACTION_isNaviSpeakOn = 17;
        static final int TRANSACTION_isNaving = 1;
        static final int TRANSACTION_isTrafficEnabled = 16;
        static final int TRANSACTION_readTrafficInfo = 19;
        static final int TRANSACTION_refreshNavi = 13;
        static final int TRANSACTION_saveNaviAddress = 15;
        static final int TRANSACTION_setNaviSpeak = 14;
        static final int TRANSACTION_setTrafficEnabled = 12;
        static final int TRANSACTION_startLocation = 7;
        static final int TRANSACTION_startNavi = 5;
        static final int TRANSACTION_startNaviToAddress = 4;
        static final int TRANSACTION_stopLocation = 8;

        public static class Proxy implements INaviAbility {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public void PoiSearch(int i, String str, INaviPoiCallback iNaviPoiCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(INaviAbility.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeStrongInterface(iNaviPoiCallback);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void changeNavi(int i, INaviActionResult iNaviActionResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(INaviAbility.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeStrongInterface(iNaviActionResult);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void changeRoute(int i, INaviActionResult iNaviActionResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(INaviAbility.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeStrongInterface(iNaviActionResult);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<String> findDeniedPermissions() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(INaviAbility.DESCRIPTOR);
                    this.mRemote.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createStringArrayList();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<PoiResult> getFreqVisitedAddress() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(INaviAbility.DESCRIPTOR);
                    this.mRemote.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(PoiResult.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return INaviAbility.DESCRIPTOR;
            }

            public double[] getLocation() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(INaviAbility.DESCRIPTOR);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createDoubleArray();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean hasAddress(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(INaviAbility.DESCRIPTOR);
                    obtain.writeInt(i);
                    boolean z = false;
                    this.mRemote.transact(3, obtain, obtain2, 0);
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

            public boolean isNaviOpened() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(INaviAbility.DESCRIPTOR);
                    boolean z = false;
                    this.mRemote.transact(6, obtain, obtain2, 0);
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

            public boolean isNaviSpeakOn() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(INaviAbility.DESCRIPTOR);
                    boolean z = false;
                    this.mRemote.transact(17, obtain, obtain2, 0);
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

            public boolean isNaving() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(INaviAbility.DESCRIPTOR);
                    boolean z = false;
                    this.mRemote.transact(1, obtain, obtain2, 0);
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

            public boolean isTrafficEnabled() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(INaviAbility.DESCRIPTOR);
                    boolean z = false;
                    this.mRemote.transact(16, obtain, obtain2, 0);
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

            public boolean readTrafficInfo(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(INaviAbility.DESCRIPTOR);
                    obtain.writeInt(i);
                    boolean z = false;
                    this.mRemote.transact(19, obtain, obtain2, 0);
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

            public boolean refreshNavi() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(INaviAbility.DESCRIPTOR);
                    boolean z = false;
                    this.mRemote.transact(13, obtain, obtain2, 0);
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

            public boolean saveNaviAddress(PoiResult poiResult, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(INaviAbility.DESCRIPTOR);
                    boolean z = false;
                    _Parcel.writeTypedObject(obtain, poiResult, 0);
                    obtain.writeInt(i);
                    this.mRemote.transact(15, obtain, obtain2, 0);
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

            public void setNaviSpeak(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(INaviAbility.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setTrafficEnabled(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(INaviAbility.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void startLocation(INaviLocationCallback iNaviLocationCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(INaviAbility.DESCRIPTOR);
                    obtain.writeStrongInterface(iNaviLocationCallback);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void startNavi(int i, int i2, PoiResult poiResult, INaviActionResult iNaviActionResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(INaviAbility.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    _Parcel.writeTypedObject(obtain, poiResult, 0);
                    obtain.writeStrongInterface(iNaviActionResult);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void startNaviToAddress(int i, INaviActionResult iNaviActionResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(INaviAbility.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeStrongInterface(iNaviActionResult);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void stopLocation(INaviLocationCallback iNaviLocationCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(INaviAbility.DESCRIPTOR);
                    obtain.writeStrongInterface(iNaviLocationCallback);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, INaviAbility.DESCRIPTOR);
        }

        public static INaviAbility asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(INaviAbility.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof INaviAbility)) ? new Proxy(iBinder) : (INaviAbility) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(INaviAbility.DESCRIPTOR);
            }
            if (i != 1598968902) {
                boolean z = false;
                switch (i) {
                    case 1:
                        boolean isNaving = isNaving();
                        parcel2.writeNoException();
                        parcel2.writeInt(isNaving ? 1 : 0);
                        break;
                    case 2:
                        PoiSearch(parcel.readInt(), parcel.readString(), INaviPoiCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 3:
                        boolean hasAddress = hasAddress(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(hasAddress ? 1 : 0);
                        break;
                    case 4:
                        startNaviToAddress(parcel.readInt(), INaviActionResult.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 5:
                        startNavi(parcel.readInt(), parcel.readInt(), (PoiResult) _Parcel.readTypedObject(parcel, PoiResult.CREATOR), INaviActionResult.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 6:
                        boolean isNaviOpened = isNaviOpened();
                        parcel2.writeNoException();
                        parcel2.writeInt(isNaviOpened ? 1 : 0);
                        break;
                    case 7:
                        startLocation(INaviLocationCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 8:
                        stopLocation(INaviLocationCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 9:
                        double[] location = getLocation();
                        parcel2.writeNoException();
                        parcel2.writeDoubleArray(location);
                        break;
                    case 10:
                        changeNavi(parcel.readInt(), INaviActionResult.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 11:
                        changeRoute(parcel.readInt(), INaviActionResult.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 12:
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        setTrafficEnabled(z);
                        parcel2.writeNoException();
                        break;
                    case 13:
                        boolean refreshNavi = refreshNavi();
                        parcel2.writeNoException();
                        parcel2.writeInt(refreshNavi ? 1 : 0);
                        break;
                    case 14:
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        setNaviSpeak(z);
                        parcel2.writeNoException();
                        break;
                    case 15:
                        boolean saveNaviAddress = saveNaviAddress((PoiResult) _Parcel.readTypedObject(parcel, PoiResult.CREATOR), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(saveNaviAddress ? 1 : 0);
                        break;
                    case 16:
                        boolean isTrafficEnabled = isTrafficEnabled();
                        parcel2.writeNoException();
                        parcel2.writeInt(isTrafficEnabled ? 1 : 0);
                        break;
                    case 17:
                        boolean isNaviSpeakOn = isNaviSpeakOn();
                        parcel2.writeNoException();
                        parcel2.writeInt(isNaviSpeakOn ? 1 : 0);
                        break;
                    case 18:
                        List<String> findDeniedPermissions = findDeniedPermissions();
                        parcel2.writeNoException();
                        parcel2.writeStringList(findDeniedPermissions);
                        break;
                    case 19:
                        boolean readTrafficInfo = readTrafficInfo(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(readTrafficInfo ? 1 : 0);
                        break;
                    case 20:
                        List<PoiResult> freqVisitedAddress = getFreqVisitedAddress();
                        parcel2.writeNoException();
                        parcel2.writeTypedList(freqVisitedAddress);
                        break;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
                return true;
            }
            parcel2.writeString(INaviAbility.DESCRIPTOR);
            return true;
        }
    }

    public static class _Parcel {
        /* access modifiers changed from: private */
        public static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedObject(Parcel parcel, T t, int i) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
                return;
            }
            parcel.writeInt(0);
        }
    }

    void PoiSearch(int i, String str, INaviPoiCallback iNaviPoiCallback) throws RemoteException;

    void changeNavi(int i, INaviActionResult iNaviActionResult) throws RemoteException;

    void changeRoute(int i, INaviActionResult iNaviActionResult) throws RemoteException;

    List<String> findDeniedPermissions() throws RemoteException;

    List<PoiResult> getFreqVisitedAddress() throws RemoteException;

    double[] getLocation() throws RemoteException;

    boolean hasAddress(int i) throws RemoteException;

    boolean isNaviOpened() throws RemoteException;

    boolean isNaviSpeakOn() throws RemoteException;

    boolean isNaving() throws RemoteException;

    boolean isTrafficEnabled() throws RemoteException;

    boolean readTrafficInfo(int i) throws RemoteException;

    boolean refreshNavi() throws RemoteException;

    boolean saveNaviAddress(PoiResult poiResult, int i) throws RemoteException;

    void setNaviSpeak(boolean z) throws RemoteException;

    void setTrafficEnabled(boolean z) throws RemoteException;

    void startLocation(INaviLocationCallback iNaviLocationCallback) throws RemoteException;

    void startNavi(int i, int i2, PoiResult poiResult, INaviActionResult iNaviActionResult) throws RemoteException;

    void startNaviToAddress(int i, INaviActionResult iNaviActionResult) throws RemoteException;

    void stopLocation(INaviLocationCallback iNaviLocationCallback) throws RemoteException;
}
