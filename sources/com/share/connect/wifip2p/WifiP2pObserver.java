package com.share.connect.wifip2p;

import android.net.wifi.p2p.WifiP2pGroup;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface WifiP2pObserver extends IInterface {

    public static class Default implements WifiP2pObserver {
        public IBinder asBinder() {
            return null;
        }

        public void onAcceptFailed() throws RemoteException {
        }

        public void onConnectFailed() throws RemoteException {
        }

        public void onConnected() throws RemoteException {
        }

        public void onCreateGroupFailed() throws RemoteException {
        }

        public void onDeviceChanged(String str) throws RemoteException {
        }

        public void onDisconnected(boolean z) throws RemoteException {
        }

        public void onGroupCreated(WifiP2pGroup wifiP2pGroup, int i) throws RemoteException {
        }

        public void onOpenFailed() throws RemoteException {
        }

        public void onOpenSuccess() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements WifiP2pObserver {
        private static final String DESCRIPTOR = "com.share.connect.wifip2p.WifiP2pObserver";
        static final int TRANSACTION_onAcceptFailed = 8;
        static final int TRANSACTION_onConnectFailed = 9;
        static final int TRANSACTION_onConnected = 5;
        static final int TRANSACTION_onCreateGroupFailed = 7;
        static final int TRANSACTION_onDeviceChanged = 3;
        static final int TRANSACTION_onDisconnected = 6;
        static final int TRANSACTION_onGroupCreated = 4;
        static final int TRANSACTION_onOpenFailed = 2;
        static final int TRANSACTION_onOpenSuccess = 1;

        public static class Proxy implements WifiP2pObserver {
            public static WifiP2pObserver sDefaultImpl;
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
                    if (this.mRemote.transact(8, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
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

            public void onConnectFailed() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(9, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onConnectFailed();
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

            public void onCreateGroupFailed() throws RemoteException {
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
                    Stub.getDefaultImpl().onCreateGroupFailed();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onDeviceChanged(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onDeviceChanged(str);
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

            public void onGroupCreated(WifiP2pGroup wifiP2pGroup, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (wifiP2pGroup != null) {
                        obtain.writeInt(1);
                        wifiP2pGroup.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    if (this.mRemote.transact(4, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onGroupCreated(wifiP2pGroup, i);
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
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

        public static WifiP2pObserver asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof WifiP2pObserver)) ? new Proxy(iBinder) : (WifiP2pObserver) queryLocalInterface;
        }

        public static WifiP2pObserver getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(WifiP2pObserver wifiP2pObserver) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (wifiP2pObserver == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = wifiP2pObserver;
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
                        onDeviceChanged(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        onGroupCreated(parcel.readInt() != 0 ? (WifiP2pGroup) WifiP2pGroup.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
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
                        onCreateGroupFailed();
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface(DESCRIPTOR);
                        onAcceptFailed();
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface(DESCRIPTOR);
                        onConnectFailed();
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

    void onConnectFailed() throws RemoteException;

    void onConnected() throws RemoteException;

    void onCreateGroupFailed() throws RemoteException;

    void onDeviceChanged(String str) throws RemoteException;

    void onDisconnected(boolean z) throws RemoteException;

    void onGroupCreated(WifiP2pGroup wifiP2pGroup, int i) throws RemoteException;

    void onOpenFailed() throws RemoteException;

    void onOpenSuccess() throws RemoteException;
}
