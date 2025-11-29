package com.share.connect.wifiap;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface WifiApObserver extends IInterface {

    public static class Default implements WifiApObserver {
        public IBinder asBinder() {
            return null;
        }

        public void onAcceptFailed() throws RemoteException {
        }

        public void onApCreateFailed() throws RemoteException {
        }

        public void onApCreated(String str, String str2, String str3, String str4, int i) throws RemoteException {
        }

        public void onConnected() throws RemoteException {
        }

        public void onDisconnected(boolean z) throws RemoteException {
        }

        public void onOpenFailed() throws RemoteException {
        }

        public void onOpenSuccess() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements WifiApObserver {
        private static final String DESCRIPTOR = "com.share.connect.wifiap.WifiApObserver";
        static final int TRANSACTION_onAcceptFailed = 7;
        static final int TRANSACTION_onApCreateFailed = 4;
        static final int TRANSACTION_onApCreated = 3;
        static final int TRANSACTION_onConnected = 5;
        static final int TRANSACTION_onDisconnected = 6;
        static final int TRANSACTION_onOpenFailed = 2;
        static final int TRANSACTION_onOpenSuccess = 1;

        public static class Proxy implements WifiApObserver {
            public static WifiApObserver sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public void onAcceptFailed() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(7, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onAcceptFailed();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onApCreateFailed() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(4, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onApCreateFailed();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onApCreated(String str, String str2, String str3, String str4, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onApCreated(str, str2, str3, str4, i);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onConnected() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(5, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onConnected();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onDisconnected(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(6, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onDisconnected(z);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onOpenFailed() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onOpenFailed();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onOpenSuccess() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onOpenSuccess();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static WifiApObserver asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof WifiApObserver)) ? new Proxy(iBinder) : (WifiApObserver) queryLocalInterface;
        }

        public static WifiApObserver getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(WifiApObserver wifiApObserver) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (wifiApObserver == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = wifiApObserver;
                return true;
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        onOpenSuccess();
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        onOpenFailed();
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        onApCreated(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        onApCreateFailed();
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        onConnected();
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        onDisconnected(parcel.readInt() != 0);
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface(DESCRIPTOR);
                        onAcceptFailed();
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }
    }

    void onAcceptFailed() throws RemoteException;

    void onApCreateFailed() throws RemoteException;

    void onApCreated(String str, String str2, String str3, String str4, int i) throws RemoteException;

    void onConnected() throws RemoteException;

    void onDisconnected(boolean z) throws RemoteException;

    void onOpenFailed() throws RemoteException;

    void onOpenSuccess() throws RemoteException;
}
