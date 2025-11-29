package com.share.connect;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.share.connect.ShareLinkObserver;
import java.util.HashMap;
import java.util.Map;

public interface IShareLinkManager extends IInterface {

    public static class Default implements IShareLinkManager {
        public IBinder asBinder() {
            return null;
        }

        public void close() throws RemoteException {
        }

        public void connect(String str) throws RemoteException {
        }

        public void disconnect() throws RemoteException {
        }

        public void disconnectBle() throws RemoteException {
        }

        public void enableUsbDeviceScanning(boolean z) throws RemoteException {
        }

        public Map getDevicesSignal(int i, int i2) throws RemoteException {
            return null;
        }

        public boolean isDeviceInMatch(String str) throws RemoteException {
            return false;
        }

        public void open(boolean z, int i, int[] iArr, boolean z2, String str, String str2, boolean z3, boolean z4, String str3) throws RemoteException {
        }

        public void registerLinkObserver(ShareLinkObserver shareLinkObserver) throws RemoteException {
        }

        public void startScan() throws RemoteException {
        }

        public void stopAdvertise() throws RemoteException {
        }

        public void stopScan() throws RemoteException {
        }

        public void unregisterLinkObserver(ShareLinkObserver shareLinkObserver) throws RemoteException {
        }

        public void updateDayOrNightMode(int i) throws RemoteException {
        }

        public void updatePinCode(String str) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IShareLinkManager {
        private static final String DESCRIPTOR = "com.share.connect.IShareLinkManager";
        static final int TRANSACTION_close = 2;
        static final int TRANSACTION_connect = 8;
        static final int TRANSACTION_disconnect = 9;
        static final int TRANSACTION_disconnectBle = 10;
        static final int TRANSACTION_enableUsbDeviceScanning = 7;
        static final int TRANSACTION_getDevicesSignal = 6;
        static final int TRANSACTION_isDeviceInMatch = 5;
        static final int TRANSACTION_open = 1;
        static final int TRANSACTION_registerLinkObserver = 11;
        static final int TRANSACTION_startScan = 3;
        static final int TRANSACTION_stopAdvertise = 13;
        static final int TRANSACTION_stopScan = 4;
        static final int TRANSACTION_unregisterLinkObserver = 12;
        static final int TRANSACTION_updateDayOrNightMode = 15;
        static final int TRANSACTION_updatePinCode = 14;

        public static class Proxy implements IShareLinkManager {
            public static IShareLinkManager sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void close() throws RemoteException {
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
                    Stub.getDefaultImpl().close();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void connect(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(8, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().connect(str);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void disconnect() throws RemoteException {
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
                    Stub.getDefaultImpl().disconnect();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void disconnectBle() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(10, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().disconnectBle();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void enableUsbDeviceScanning(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(7, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().enableUsbDeviceScanning(z);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Map getDevicesSignal(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDevicesSignal(i, i2);
                    }
                    obtain2.readException();
                    HashMap readHashMap = obtain2.readHashMap(getClass().getClassLoader());
                    obtain2.recycle();
                    obtain.recycle();
                    return readHashMap;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public boolean isDeviceInMatch(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    boolean z = false;
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isDeviceInMatch(str);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void open(boolean z, int i, int[] iArr, boolean z2, String str, String str2, boolean z3, boolean z4, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z5 = z;
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(i);
                    obtain.writeIntArray(iArr);
                    obtain.writeInt(z2 ? 1 : 0);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(z3 ? 1 : 0);
                    obtain.writeInt(z4 ? 1 : 0);
                    obtain.writeString(str3);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().open(z, i, iArr, z2, str, str2, z3, z4, str3);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void registerLinkObserver(ShareLinkObserver shareLinkObserver) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(shareLinkObserver != null ? shareLinkObserver.asBinder() : null);
                    if (this.mRemote.transact(11, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().registerLinkObserver(shareLinkObserver);
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            public void startScan() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().startScan();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void stopAdvertise() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(13, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().stopAdvertise();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void stopScan() throws RemoteException {
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
                    Stub.getDefaultImpl().stopScan();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void unregisterLinkObserver(ShareLinkObserver shareLinkObserver) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(shareLinkObserver != null ? shareLinkObserver.asBinder() : null);
                    if (this.mRemote.transact(12, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().unregisterLinkObserver(shareLinkObserver);
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            public void updateDayOrNightMode(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(15, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().updateDayOrNightMode(i);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void updatePinCode(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(14, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().updatePinCode(str);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IShareLinkManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IShareLinkManager)) ? new Proxy(iBinder) : (IShareLinkManager) queryLocalInterface;
        }

        public static IShareLinkManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IShareLinkManager iShareLinkManager) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iShareLinkManager == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iShareLinkManager;
                return true;
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            int i3 = i;
            Parcel parcel3 = parcel;
            Parcel parcel4 = parcel2;
            if (i3 != 1598968902) {
                boolean z = false;
                switch (i3) {
                    case 1:
                        parcel3.enforceInterface(DESCRIPTOR);
                        open(parcel.readInt() != 0, parcel.readInt(), parcel.createIntArray(), parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel3.enforceInterface(DESCRIPTOR);
                        close();
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel3.enforceInterface(DESCRIPTOR);
                        startScan();
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel3.enforceInterface(DESCRIPTOR);
                        stopScan();
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel3.enforceInterface(DESCRIPTOR);
                        boolean isDeviceInMatch = isDeviceInMatch(parcel.readString());
                        parcel2.writeNoException();
                        parcel4.writeInt(isDeviceInMatch ? 1 : 0);
                        return true;
                    case 6:
                        parcel3.enforceInterface(DESCRIPTOR);
                        Map devicesSignal = getDevicesSignal(parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel4.writeMap(devicesSignal);
                        return true;
                    case 7:
                        parcel3.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        enableUsbDeviceScanning(z);
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel3.enforceInterface(DESCRIPTOR);
                        connect(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel3.enforceInterface(DESCRIPTOR);
                        disconnect();
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        parcel3.enforceInterface(DESCRIPTOR);
                        disconnectBle();
                        parcel2.writeNoException();
                        return true;
                    case 11:
                        parcel3.enforceInterface(DESCRIPTOR);
                        registerLinkObserver(ShareLinkObserver.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 12:
                        parcel3.enforceInterface(DESCRIPTOR);
                        unregisterLinkObserver(ShareLinkObserver.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 13:
                        parcel3.enforceInterface(DESCRIPTOR);
                        stopAdvertise();
                        parcel2.writeNoException();
                        return true;
                    case 14:
                        parcel3.enforceInterface(DESCRIPTOR);
                        updatePinCode(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 15:
                        parcel3.enforceInterface(DESCRIPTOR);
                        updateDayOrNightMode(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel4.writeString(DESCRIPTOR);
                return true;
            }
        }
    }

    void close() throws RemoteException;

    void connect(String str) throws RemoteException;

    void disconnect() throws RemoteException;

    void disconnectBle() throws RemoteException;

    void enableUsbDeviceScanning(boolean z) throws RemoteException;

    Map getDevicesSignal(int i, int i2) throws RemoteException;

    boolean isDeviceInMatch(String str) throws RemoteException;

    void open(boolean z, int i, int[] iArr, boolean z2, String str, String str2, boolean z3, boolean z4, String str3) throws RemoteException;

    void registerLinkObserver(ShareLinkObserver shareLinkObserver) throws RemoteException;

    void startScan() throws RemoteException;

    void stopAdvertise() throws RemoteException;

    void stopScan() throws RemoteException;

    void unregisterLinkObserver(ShareLinkObserver shareLinkObserver) throws RemoteException;

    void updateDayOrNightMode(int i) throws RemoteException;

    void updatePinCode(String str) throws RemoteException;
}
