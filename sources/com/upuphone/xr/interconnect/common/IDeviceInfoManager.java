package com.upuphone.xr.interconnect.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.upuphone.xr.interconnect.common.IDeviceInfoCallback;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import java.util.List;

public interface IDeviceInfoManager extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.interconnect.common.IDeviceInfoManager";

    public static class Default implements IDeviceInfoManager {
        public IBinder asBinder() {
            return null;
        }

        public StarryNetDevice getBondedDevice() throws RemoteException {
            return null;
        }

        public StarryNetDevice getBondedGlassStarryNetDevice() throws RemoteException {
            return null;
        }

        public StarryNetDevice getBondedRingStarryNetDevice() throws RemoteException {
            return null;
        }

        public List<StarryNetDevice> getBondedStarryNetDeviceList() throws RemoteException {
            return null;
        }

        public String getConnectedDeviceType() throws RemoteException {
            return null;
        }

        public StarryNetDevice getConnectedGlassStarryNetDevice() throws RemoteException {
            return null;
        }

        public StarryNetDevice getConnectedRingStarryNetDevice() throws RemoteException {
            return null;
        }

        public List<StarryNetDevice> getConnectedStarryNetDeviceList() throws RemoteException {
            return null;
        }

        public void getDeviceInfo(IDeviceInfoCallback iDeviceInfoCallback) throws RemoteException {
        }

        public boolean isAir() throws RemoteException {
            return false;
        }

        public boolean isAirPro() throws RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements IDeviceInfoManager {
        static final int TRANSACTION_getBondedDevice = 5;
        static final int TRANSACTION_getBondedGlassStarryNetDevice = 6;
        static final int TRANSACTION_getBondedRingStarryNetDevice = 7;
        static final int TRANSACTION_getBondedStarryNetDeviceList = 10;
        static final int TRANSACTION_getConnectedDeviceType = 2;
        static final int TRANSACTION_getConnectedGlassStarryNetDevice = 8;
        static final int TRANSACTION_getConnectedRingStarryNetDevice = 9;
        static final int TRANSACTION_getConnectedStarryNetDeviceList = 11;
        static final int TRANSACTION_getDeviceInfo = 1;
        static final int TRANSACTION_isAir = 4;
        static final int TRANSACTION_isAirPro = 3;

        public static class Proxy implements IDeviceInfoManager {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public StarryNetDevice getBondedDevice() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDeviceInfoManager.DESCRIPTOR);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return (StarryNetDevice) _Parcel.readTypedObject(obtain2, StarryNetDevice.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public StarryNetDevice getBondedGlassStarryNetDevice() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDeviceInfoManager.DESCRIPTOR);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return (StarryNetDevice) _Parcel.readTypedObject(obtain2, StarryNetDevice.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public StarryNetDevice getBondedRingStarryNetDevice() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDeviceInfoManager.DESCRIPTOR);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return (StarryNetDevice) _Parcel.readTypedObject(obtain2, StarryNetDevice.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<StarryNetDevice> getBondedStarryNetDeviceList() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDeviceInfoManager.DESCRIPTOR);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(StarryNetDevice.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getConnectedDeviceType() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDeviceInfoManager.DESCRIPTOR);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public StarryNetDevice getConnectedGlassStarryNetDevice() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDeviceInfoManager.DESCRIPTOR);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return (StarryNetDevice) _Parcel.readTypedObject(obtain2, StarryNetDevice.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public StarryNetDevice getConnectedRingStarryNetDevice() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDeviceInfoManager.DESCRIPTOR);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return (StarryNetDevice) _Parcel.readTypedObject(obtain2, StarryNetDevice.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<StarryNetDevice> getConnectedStarryNetDeviceList() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDeviceInfoManager.DESCRIPTOR);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(StarryNetDevice.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getDeviceInfo(IDeviceInfoCallback iDeviceInfoCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDeviceInfoManager.DESCRIPTOR);
                    obtain.writeStrongInterface(iDeviceInfoCallback);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IDeviceInfoManager.DESCRIPTOR;
            }

            public boolean isAir() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDeviceInfoManager.DESCRIPTOR);
                    boolean z = false;
                    this.mRemote.transact(4, obtain, obtain2, 0);
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

            public boolean isAirPro() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDeviceInfoManager.DESCRIPTOR);
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
        }

        public Stub() {
            attachInterface(this, IDeviceInfoManager.DESCRIPTOR);
        }

        public static IDeviceInfoManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IDeviceInfoManager.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IDeviceInfoManager)) ? new Proxy(iBinder) : (IDeviceInfoManager) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IDeviceInfoManager.DESCRIPTOR);
            }
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        getDeviceInfo(IDeviceInfoCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 2:
                        String connectedDeviceType = getConnectedDeviceType();
                        parcel2.writeNoException();
                        parcel2.writeString(connectedDeviceType);
                        break;
                    case 3:
                        boolean isAirPro = isAirPro();
                        parcel2.writeNoException();
                        parcel2.writeInt(isAirPro ? 1 : 0);
                        break;
                    case 4:
                        boolean isAir = isAir();
                        parcel2.writeNoException();
                        parcel2.writeInt(isAir ? 1 : 0);
                        break;
                    case 5:
                        StarryNetDevice bondedDevice = getBondedDevice();
                        parcel2.writeNoException();
                        _Parcel.writeTypedObject(parcel2, bondedDevice, 1);
                        break;
                    case 6:
                        StarryNetDevice bondedGlassStarryNetDevice = getBondedGlassStarryNetDevice();
                        parcel2.writeNoException();
                        _Parcel.writeTypedObject(parcel2, bondedGlassStarryNetDevice, 1);
                        break;
                    case 7:
                        StarryNetDevice bondedRingStarryNetDevice = getBondedRingStarryNetDevice();
                        parcel2.writeNoException();
                        _Parcel.writeTypedObject(parcel2, bondedRingStarryNetDevice, 1);
                        break;
                    case 8:
                        StarryNetDevice connectedGlassStarryNetDevice = getConnectedGlassStarryNetDevice();
                        parcel2.writeNoException();
                        _Parcel.writeTypedObject(parcel2, connectedGlassStarryNetDevice, 1);
                        break;
                    case 9:
                        StarryNetDevice connectedRingStarryNetDevice = getConnectedRingStarryNetDevice();
                        parcel2.writeNoException();
                        _Parcel.writeTypedObject(parcel2, connectedRingStarryNetDevice, 1);
                        break;
                    case 10:
                        List<StarryNetDevice> bondedStarryNetDeviceList = getBondedStarryNetDeviceList();
                        parcel2.writeNoException();
                        parcel2.writeTypedList(bondedStarryNetDeviceList);
                        break;
                    case 11:
                        List<StarryNetDevice> connectedStarryNetDeviceList = getConnectedStarryNetDeviceList();
                        parcel2.writeNoException();
                        parcel2.writeTypedList(connectedStarryNetDeviceList);
                        break;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
                return true;
            }
            parcel2.writeString(IDeviceInfoManager.DESCRIPTOR);
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

    StarryNetDevice getBondedDevice() throws RemoteException;

    StarryNetDevice getBondedGlassStarryNetDevice() throws RemoteException;

    StarryNetDevice getBondedRingStarryNetDevice() throws RemoteException;

    List<StarryNetDevice> getBondedStarryNetDeviceList() throws RemoteException;

    String getConnectedDeviceType() throws RemoteException;

    StarryNetDevice getConnectedGlassStarryNetDevice() throws RemoteException;

    StarryNetDevice getConnectedRingStarryNetDevice() throws RemoteException;

    List<StarryNetDevice> getConnectedStarryNetDeviceList() throws RemoteException;

    void getDeviceInfo(IDeviceInfoCallback iDeviceInfoCallback) throws RemoteException;

    boolean isAir() throws RemoteException;

    boolean isAirPro() throws RemoteException;
}
