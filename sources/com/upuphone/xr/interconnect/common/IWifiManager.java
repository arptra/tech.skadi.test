package com.upuphone.xr.interconnect.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.upuphone.xr.interconnect.common.IWifiConnectCallback;
import com.upuphone.xr.interconnect.common.IWifiInfoCallback;

public interface IWifiManager extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.interconnect.common.IWifiManager";

    public static class Default implements IWifiManager {
        public IBinder asBinder() {
            return null;
        }

        public void connectWifi(String str, String str2, int i, IWifiConnectCallback iWifiConnectCallback) throws RemoteException {
        }

        public void getConnectedWifiInfo(IWifiInfoCallback iWifiInfoCallback) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IWifiManager {
        static final int TRANSACTION_connectWifi = 2;
        static final int TRANSACTION_getConnectedWifiInfo = 1;

        public static class Proxy implements IWifiManager {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void connectWifi(String str, String str2, int i, IWifiConnectCallback iWifiConnectCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IWifiManager.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeStrongInterface(iWifiConnectCallback);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getConnectedWifiInfo(IWifiInfoCallback iWifiInfoCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IWifiManager.DESCRIPTOR);
                    obtain.writeStrongInterface(iWifiInfoCallback);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IWifiManager.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, IWifiManager.DESCRIPTOR);
        }

        public static IWifiManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IWifiManager.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IWifiManager)) ? new Proxy(iBinder) : (IWifiManager) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IWifiManager.DESCRIPTOR);
            }
            if (i != 1598968902) {
                if (i == 1) {
                    getConnectedWifiInfo(IWifiInfoCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                } else if (i != 2) {
                    return super.onTransact(i, parcel, parcel2, i2);
                } else {
                    connectWifi(parcel.readString(), parcel.readString(), parcel.readInt(), IWifiConnectCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                }
                return true;
            }
            parcel2.writeString(IWifiManager.DESCRIPTOR);
            return true;
        }
    }

    void connectWifi(String str, String str2, int i, IWifiConnectCallback iWifiConnectCallback) throws RemoteException;

    void getConnectedWifiInfo(IWifiInfoCallback iWifiInfoCallback) throws RemoteException;
}
