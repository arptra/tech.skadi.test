package com.upuphone.xr.interconnect.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.upuphone.xr.interconnect.common.IDeviceBondStateListener;
import com.upuphone.xr.interconnect.common.IDeviceConnectionListener;
import com.upuphone.xr.interconnect.common.IP2pAcquireCallback;
import com.upuphone.xr.interconnect.common.IP2pStateListener;
import com.upuphone.xr.interconnect.common.IRequestCallback;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import java.util.List;

public interface IDeviceManager extends IInterface {
    public static final int CONNECTION_LEVEL_BALANCE = 1;
    public static final int CONNECTION_LEVEL_ENHANCE = 2;
    public static final String DESCRIPTOR = "com.upuphone.xr.interconnect.common.IDeviceManager";

    public static class Default implements IDeviceManager {
        public void abandonConnectionLevel(String str, String str2, int i) throws RemoteException {
        }

        public IBinder asBinder() {
            return null;
        }

        public List<StarryNetDevice> getBondedDevices() throws RemoteException {
            return null;
        }

        public StarryNetDevice getConnectedDevice() throws RemoteException {
            return null;
        }

        public int getDeviceBondState(String str) throws RemoteException {
            return 0;
        }

        public int getP2pState() throws RemoteException {
            return 0;
        }

        public StarryNetDevice getSelfDevice() throws RemoteException {
            return null;
        }

        public void registerDeviceBondStateListener(IDeviceBondStateListener iDeviceBondStateListener) throws RemoteException {
        }

        public void registerDeviceConnectionListener(IDeviceConnectionListener iDeviceConnectionListener) throws RemoteException {
        }

        public void registerP2pStateListener(IP2pStateListener iP2pStateListener) throws RemoteException {
        }

        public void requestConnectionLevel(String str, String str2, int i, IRequestCallback iRequestCallback) throws RemoteException {
        }

        public void tryAcquireP2p(IP2pAcquireCallback iP2pAcquireCallback) throws RemoteException {
        }

        public void tryReleaseP2p() throws RemoteException {
        }

        public boolean unBondDevice(String str) throws RemoteException {
            return false;
        }

        public void unregisterDeviceBondStateListener(IDeviceBondStateListener iDeviceBondStateListener) throws RemoteException {
        }

        public void unregisterDeviceConnectionListener(IDeviceConnectionListener iDeviceConnectionListener) throws RemoteException {
        }

        public void unregisterP2pStateListener(IP2pStateListener iP2pStateListener) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IDeviceManager {
        static final int TRANSACTION_abandonConnectionLevel = 11;
        static final int TRANSACTION_getBondedDevices = 12;
        static final int TRANSACTION_getConnectedDevice = 2;
        static final int TRANSACTION_getDeviceBondState = 13;
        static final int TRANSACTION_getP2pState = 5;
        static final int TRANSACTION_getSelfDevice = 1;
        static final int TRANSACTION_registerDeviceBondStateListener = 15;
        static final int TRANSACTION_registerDeviceConnectionListener = 3;
        static final int TRANSACTION_registerP2pStateListener = 6;
        static final int TRANSACTION_requestConnectionLevel = 10;
        static final int TRANSACTION_tryAcquireP2p = 8;
        static final int TRANSACTION_tryReleaseP2p = 9;
        static final int TRANSACTION_unBondDevice = 14;
        static final int TRANSACTION_unregisterDeviceBondStateListener = 16;
        static final int TRANSACTION_unregisterDeviceConnectionListener = 4;
        static final int TRANSACTION_unregisterP2pStateListener = 7;

        public static class Proxy implements IDeviceManager {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public void abandonConnectionLevel(String str, String str2, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDeviceManager.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public List<StarryNetDevice> getBondedDevices() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDeviceManager.DESCRIPTOR);
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(StarryNetDevice.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public StarryNetDevice getConnectedDevice() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDeviceManager.DESCRIPTOR);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return (StarryNetDevice) _Parcel.readTypedObject(obtain2, StarryNetDevice.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getDeviceBondState(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDeviceManager.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IDeviceManager.DESCRIPTOR;
            }

            public int getP2pState() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDeviceManager.DESCRIPTOR);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public StarryNetDevice getSelfDevice() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDeviceManager.DESCRIPTOR);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return (StarryNetDevice) _Parcel.readTypedObject(obtain2, StarryNetDevice.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void registerDeviceBondStateListener(IDeviceBondStateListener iDeviceBondStateListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDeviceManager.DESCRIPTOR);
                    obtain.writeStrongInterface(iDeviceBondStateListener);
                    this.mRemote.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void registerDeviceConnectionListener(IDeviceConnectionListener iDeviceConnectionListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDeviceManager.DESCRIPTOR);
                    obtain.writeStrongInterface(iDeviceConnectionListener);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void registerP2pStateListener(IP2pStateListener iP2pStateListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDeviceManager.DESCRIPTOR);
                    obtain.writeStrongInterface(iP2pStateListener);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void requestConnectionLevel(String str, String str2, int i, IRequestCallback iRequestCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDeviceManager.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeStrongInterface(iRequestCallback);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void tryAcquireP2p(IP2pAcquireCallback iP2pAcquireCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDeviceManager.DESCRIPTOR);
                    obtain.writeStrongInterface(iP2pAcquireCallback);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void tryReleaseP2p() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDeviceManager.DESCRIPTOR);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean unBondDevice(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDeviceManager.DESCRIPTOR);
                    obtain.writeString(str);
                    boolean z = false;
                    this.mRemote.transact(14, obtain, obtain2, 0);
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

            public void unregisterDeviceBondStateListener(IDeviceBondStateListener iDeviceBondStateListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDeviceManager.DESCRIPTOR);
                    obtain.writeStrongInterface(iDeviceBondStateListener);
                    this.mRemote.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void unregisterDeviceConnectionListener(IDeviceConnectionListener iDeviceConnectionListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDeviceManager.DESCRIPTOR);
                    obtain.writeStrongInterface(iDeviceConnectionListener);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void unregisterP2pStateListener(IP2pStateListener iP2pStateListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDeviceManager.DESCRIPTOR);
                    obtain.writeStrongInterface(iP2pStateListener);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IDeviceManager.DESCRIPTOR);
        }

        public static IDeviceManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IDeviceManager.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IDeviceManager)) ? new Proxy(iBinder) : (IDeviceManager) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IDeviceManager.DESCRIPTOR);
            }
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        StarryNetDevice selfDevice = getSelfDevice();
                        parcel2.writeNoException();
                        _Parcel.writeTypedObject(parcel2, selfDevice, 1);
                        break;
                    case 2:
                        StarryNetDevice connectedDevice = getConnectedDevice();
                        parcel2.writeNoException();
                        _Parcel.writeTypedObject(parcel2, connectedDevice, 1);
                        break;
                    case 3:
                        registerDeviceConnectionListener(IDeviceConnectionListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 4:
                        unregisterDeviceConnectionListener(IDeviceConnectionListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 5:
                        int p2pState = getP2pState();
                        parcel2.writeNoException();
                        parcel2.writeInt(p2pState);
                        break;
                    case 6:
                        registerP2pStateListener(IP2pStateListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 7:
                        unregisterP2pStateListener(IP2pStateListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 8:
                        tryAcquireP2p(IP2pAcquireCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 9:
                        tryReleaseP2p();
                        parcel2.writeNoException();
                        break;
                    case 10:
                        requestConnectionLevel(parcel.readString(), parcel.readString(), parcel.readInt(), IRequestCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 11:
                        abandonConnectionLevel(parcel.readString(), parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        break;
                    case 12:
                        List<StarryNetDevice> bondedDevices = getBondedDevices();
                        parcel2.writeNoException();
                        parcel2.writeTypedList(bondedDevices);
                        break;
                    case 13:
                        int deviceBondState = getDeviceBondState(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(deviceBondState);
                        break;
                    case 14:
                        boolean unBondDevice = unBondDevice(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(unBondDevice ? 1 : 0);
                        break;
                    case 15:
                        registerDeviceBondStateListener(IDeviceBondStateListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 16:
                        unregisterDeviceBondStateListener(IDeviceBondStateListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
                return true;
            }
            parcel2.writeString(IDeviceManager.DESCRIPTOR);
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

    void abandonConnectionLevel(String str, String str2, int i) throws RemoteException;

    List<StarryNetDevice> getBondedDevices() throws RemoteException;

    StarryNetDevice getConnectedDevice() throws RemoteException;

    int getDeviceBondState(String str) throws RemoteException;

    int getP2pState() throws RemoteException;

    StarryNetDevice getSelfDevice() throws RemoteException;

    void registerDeviceBondStateListener(IDeviceBondStateListener iDeviceBondStateListener) throws RemoteException;

    void registerDeviceConnectionListener(IDeviceConnectionListener iDeviceConnectionListener) throws RemoteException;

    void registerP2pStateListener(IP2pStateListener iP2pStateListener) throws RemoteException;

    void requestConnectionLevel(String str, String str2, int i, IRequestCallback iRequestCallback) throws RemoteException;

    void tryAcquireP2p(IP2pAcquireCallback iP2pAcquireCallback) throws RemoteException;

    void tryReleaseP2p() throws RemoteException;

    boolean unBondDevice(String str) throws RemoteException;

    void unregisterDeviceBondStateListener(IDeviceBondStateListener iDeviceBondStateListener) throws RemoteException;

    void unregisterDeviceConnectionListener(IDeviceConnectionListener iDeviceConnectionListener) throws RemoteException;

    void unregisterP2pStateListener(IP2pStateListener iP2pStateListener) throws RemoteException;
}
