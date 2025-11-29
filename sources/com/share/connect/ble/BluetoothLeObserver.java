package com.share.connect.ble;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.share.connect.Device;

public interface BluetoothLeObserver extends IInterface {

    public static class Default implements BluetoothLeObserver {
        public IBinder asBinder() {
            return null;
        }

        public void onClientInfoReceived(String str, String str2, String str3, int i, String str4, int i2, String str5, int i3) throws RemoteException {
        }

        public void onDeviceLost(Device device) throws RemoteException {
        }

        public void onDeviceMatch(Device device) throws RemoteException {
        }

        public void onFailure(int i, int i2) throws RemoteException {
        }

        public void onPinAvailable(String str) throws RemoteException {
        }

        public void onReceivedClientBleMac(String str) throws RemoteException {
        }

        public void onServerAddressSent() throws RemoteException {
        }

        public void onServerInfoReceived(String str, String str2, String str3, int i) throws RemoteException {
        }

        public void onSuccess(int i) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements BluetoothLeObserver {
        private static final String DESCRIPTOR = "com.share.connect.ble.BluetoothLeObserver";
        static final int TRANSACTION_onClientInfoReceived = 7;
        static final int TRANSACTION_onDeviceLost = 4;
        static final int TRANSACTION_onDeviceMatch = 3;
        static final int TRANSACTION_onFailure = 2;
        static final int TRANSACTION_onPinAvailable = 5;
        static final int TRANSACTION_onReceivedClientBleMac = 9;
        static final int TRANSACTION_onServerAddressSent = 8;
        static final int TRANSACTION_onServerInfoReceived = 6;
        static final int TRANSACTION_onSuccess = 1;

        public static class Proxy implements BluetoothLeObserver {
            public static BluetoothLeObserver sDefaultImpl;
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

            public void onClientInfoReceived(String str, String str2, String str3, int i, String str4, int i2, String str5, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    String str6 = str;
                    obtain.writeString(str);
                    String str7 = str2;
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeInt(i);
                    obtain.writeString(str4);
                    obtain.writeInt(i2);
                    obtain.writeString(str5);
                    obtain.writeInt(i3);
                    if (this.mRemote.transact(7, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onClientInfoReceived(str, str2, str3, i, str4, i2, str5, i3);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onDeviceLost(Device device) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (device != null) {
                        obtain.writeInt(1);
                        device.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(4, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onDeviceLost(device);
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            public void onDeviceMatch(Device device) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (device != null) {
                        obtain.writeInt(1);
                        device.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onDeviceMatch(device);
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            public void onFailure(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onFailure(i, i2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onPinAvailable(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(5, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onPinAvailable(str);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onReceivedClientBleMac(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(9, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onReceivedClientBleMac(str);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onServerAddressSent() throws RemoteException {
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
                    Stub.getDefaultImpl().onServerAddressSent();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onServerInfoReceived(String str, String str2, String str3, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(6, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onServerInfoReceived(str, str2, str3, i);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onSuccess(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onSuccess(i);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static BluetoothLeObserver asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof BluetoothLeObserver)) ? new Proxy(iBinder) : (BluetoothLeObserver) queryLocalInterface;
        }

        public static BluetoothLeObserver getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(BluetoothLeObserver bluetoothLeObserver) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (bluetoothLeObserver == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = bluetoothLeObserver;
                return true;
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                Device device = null;
                switch (i) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        onSuccess(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        onFailure(parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            device = Device.CREATOR.createFromParcel(parcel);
                        }
                        onDeviceMatch(device);
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            device = Device.CREATOR.createFromParcel(parcel);
                        }
                        onDeviceLost(device);
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        onPinAvailable(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        onServerInfoReceived(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface(DESCRIPTOR);
                        onClientInfoReceived(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface(DESCRIPTOR);
                        onServerAddressSent();
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface(DESCRIPTOR);
                        onReceivedClientBleMac(parcel.readString());
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

    void onClientInfoReceived(String str, String str2, String str3, int i, String str4, int i2, String str5, int i3) throws RemoteException;

    void onDeviceLost(Device device) throws RemoteException;

    void onDeviceMatch(Device device) throws RemoteException;

    void onFailure(int i, int i2) throws RemoteException;

    void onPinAvailable(String str) throws RemoteException;

    void onReceivedClientBleMac(String str) throws RemoteException;

    void onServerAddressSent() throws RemoteException;

    void onServerInfoReceived(String str, String str2, String str3, int i) throws RemoteException;

    void onSuccess(int i) throws RemoteException;
}
