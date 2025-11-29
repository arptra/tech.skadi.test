package com.share.connect.ble;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.share.connect.ble.BluetoothLeObserver;
import java.util.HashMap;
import java.util.Map;

public interface IBluetoothLe extends IInterface {

    public static class Default implements IBluetoothLe {
        public void allowProcessNewConnection() throws RemoteException {
        }

        public IBinder asBinder() {
            return null;
        }

        public void close() throws RemoteException {
        }

        public boolean connect(String str) throws RemoteException {
            return false;
        }

        public void connectDone() throws RemoteException {
        }

        public void disconnect() throws RemoteException {
        }

        public void disconnectWithoutState() throws RemoteException {
        }

        public Map getDevicesSignal(int i, int i2) throws RemoteException {
            return null;
        }

        public boolean isDeviceInMatch(String str) throws RemoteException {
            return false;
        }

        public void notifyServerInfo(String str, String str2, String str3, int i, int i2, String str4) throws RemoteException {
        }

        public void open(String str, String str2, String str3, String str4, String str5, String str6, boolean z, int i, String str7) throws RemoteException {
        }

        public void registerBluetoothLeObserver(BluetoothLeObserver bluetoothLeObserver) throws RemoteException {
        }

        public void setBandSupported(int i) throws RemoteException {
        }

        public void setP2pDeviceMac(String str) throws RemoteException {
        }

        public void startScan() throws RemoteException {
        }

        public void stopAdvertise() throws RemoteException {
        }

        public void stopScan() throws RemoteException {
        }

        public void unregisterBluetoothLeObserver(BluetoothLeObserver bluetoothLeObserver) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IBluetoothLe {
        private static final String DESCRIPTOR = "com.share.connect.ble.IBluetoothLe";
        static final int TRANSACTION_allowProcessNewConnection = 17;
        static final int TRANSACTION_close = 2;
        static final int TRANSACTION_connect = 7;
        static final int TRANSACTION_connectDone = 9;
        static final int TRANSACTION_disconnect = 8;
        static final int TRANSACTION_disconnectWithoutState = 10;
        static final int TRANSACTION_getDevicesSignal = 6;
        static final int TRANSACTION_isDeviceInMatch = 5;
        static final int TRANSACTION_notifyServerInfo = 15;
        static final int TRANSACTION_open = 1;
        static final int TRANSACTION_registerBluetoothLeObserver = 11;
        static final int TRANSACTION_setBandSupported = 13;
        static final int TRANSACTION_setP2pDeviceMac = 14;
        static final int TRANSACTION_startScan = 3;
        static final int TRANSACTION_stopAdvertise = 16;
        static final int TRANSACTION_stopScan = 4;
        static final int TRANSACTION_unregisterBluetoothLeObserver = 12;

        public static class Proxy implements IBluetoothLe {
            public static IBluetoothLe sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public void allowProcessNewConnection() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(17, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().allowProcessNewConnection();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
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

            public boolean connect(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    boolean z = false;
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().connect(str);
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

            public void connectDone() throws RemoteException {
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
                    Stub.getDefaultImpl().connectDone();
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
                    if (this.mRemote.transact(8, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
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

            public void disconnectWithoutState() throws RemoteException {
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
                    Stub.getDefaultImpl().disconnectWithoutState();
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

            public void notifyServerInfo(String str, String str2, String str3, int i, int i2, String str4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str4);
                    if (this.mRemote.transact(15, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().notifyServerInfo(str, str2, str3, i, i2, str4);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void open(String str, String str2, String str3, String str4, String str5, String str6, boolean z, int i, String str7) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    String str8 = str;
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    obtain.writeString(str5);
                    obtain.writeString(str6);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(i);
                    obtain.writeString(str7);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().open(str, str2, str3, str4, str5, str6, z, i, str7);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void registerBluetoothLeObserver(BluetoothLeObserver bluetoothLeObserver) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(bluetoothLeObserver != null ? bluetoothLeObserver.asBinder() : null);
                    if (this.mRemote.transact(11, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().registerBluetoothLeObserver(bluetoothLeObserver);
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            public void setBandSupported(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(13, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().setBandSupported(i);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setP2pDeviceMac(String str) throws RemoteException {
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
                    Stub.getDefaultImpl().setP2pDeviceMac(str);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
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
                    if (this.mRemote.transact(16, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
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

            public void unregisterBluetoothLeObserver(BluetoothLeObserver bluetoothLeObserver) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(bluetoothLeObserver != null ? bluetoothLeObserver.asBinder() : null);
                    if (this.mRemote.transact(12, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().unregisterBluetoothLeObserver(bluetoothLeObserver);
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IBluetoothLe asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IBluetoothLe)) ? new Proxy(iBinder) : (IBluetoothLe) queryLocalInterface;
        }

        public static IBluetoothLe getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IBluetoothLe iBluetoothLe) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iBluetoothLe == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iBluetoothLe;
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
                switch (i3) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        open(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        close();
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        startScan();
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        stopScan();
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean isDeviceInMatch = isDeviceInMatch(parcel.readString());
                        parcel2.writeNoException();
                        parcel4.writeInt(isDeviceInMatch ? 1 : 0);
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        Map devicesSignal = getDevicesSignal(parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel4.writeMap(devicesSignal);
                        return true;
                    case 7:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean connect = connect(parcel.readString());
                        parcel2.writeNoException();
                        parcel4.writeInt(connect ? 1 : 0);
                        return true;
                    case 8:
                        parcel.enforceInterface(DESCRIPTOR);
                        disconnect();
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface(DESCRIPTOR);
                        connectDone();
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        parcel.enforceInterface(DESCRIPTOR);
                        disconnectWithoutState();
                        parcel2.writeNoException();
                        return true;
                    case 11:
                        parcel.enforceInterface(DESCRIPTOR);
                        registerBluetoothLeObserver(BluetoothLeObserver.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 12:
                        parcel.enforceInterface(DESCRIPTOR);
                        unregisterBluetoothLeObserver(BluetoothLeObserver.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 13:
                        parcel.enforceInterface(DESCRIPTOR);
                        setBandSupported(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 14:
                        parcel.enforceInterface(DESCRIPTOR);
                        setP2pDeviceMac(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 15:
                        parcel.enforceInterface(DESCRIPTOR);
                        notifyServerInfo(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 16:
                        parcel.enforceInterface(DESCRIPTOR);
                        stopAdvertise();
                        parcel2.writeNoException();
                        return true;
                    case 17:
                        parcel.enforceInterface(DESCRIPTOR);
                        allowProcessNewConnection();
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

    void allowProcessNewConnection() throws RemoteException;

    void close() throws RemoteException;

    boolean connect(String str) throws RemoteException;

    void connectDone() throws RemoteException;

    void disconnect() throws RemoteException;

    void disconnectWithoutState() throws RemoteException;

    Map getDevicesSignal(int i, int i2) throws RemoteException;

    boolean isDeviceInMatch(String str) throws RemoteException;

    void notifyServerInfo(String str, String str2, String str3, int i, int i2, String str4) throws RemoteException;

    void open(String str, String str2, String str3, String str4, String str5, String str6, boolean z, int i, String str7) throws RemoteException;

    void registerBluetoothLeObserver(BluetoothLeObserver bluetoothLeObserver) throws RemoteException;

    void setBandSupported(int i) throws RemoteException;

    void setP2pDeviceMac(String str) throws RemoteException;

    void startScan() throws RemoteException;

    void stopAdvertise() throws RemoteException;

    void stopScan() throws RemoteException;

    void unregisterBluetoothLeObserver(BluetoothLeObserver bluetoothLeObserver) throws RemoteException;
}
