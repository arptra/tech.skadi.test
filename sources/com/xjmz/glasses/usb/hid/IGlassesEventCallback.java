package com.xjmz.glasses.usb.hid;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IGlassesEventCallback extends IInterface {
    public static final String DESCRIPTOR = "com.xjmz.glasses.usb.hid.IGlassesEventCallback";

    public static class Default implements IGlassesEventCallback {
        public IBinder asBinder() {
            return null;
        }

        public void on7911StatusChanged(int i, int i2, int i3) throws RemoteException {
        }

        public void onBrightnessChanged(int i) throws RemoteException {
        }

        public void onHidChannelConnectionStatusChanged(int i) throws RemoteException {
        }

        public void onKeyEvent(int i, int i2) throws RemoteException {
        }

        public void onLog(String str) throws RemoteException {
        }

        public void onUpgradeProgressChanged(int i, int i2, int i3, int i4) throws RemoteException {
        }

        public void onWearingStatusChanged(boolean z) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IGlassesEventCallback {
        static final int TRANSACTION_on7911StatusChanged = 7;
        static final int TRANSACTION_onBrightnessChanged = 1;
        static final int TRANSACTION_onHidChannelConnectionStatusChanged = 6;
        static final int TRANSACTION_onKeyEvent = 4;
        static final int TRANSACTION_onLog = 5;
        static final int TRANSACTION_onUpgradeProgressChanged = 3;
        static final int TRANSACTION_onWearingStatusChanged = 2;

        public static class Proxy implements IGlassesEventCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IGlassesEventCallback.DESCRIPTOR;
            }

            public void on7911StatusChanged(int i, int i2, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesEventCallback.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onBrightnessChanged(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesEventCallback.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onHidChannelConnectionStatusChanged(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesEventCallback.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onKeyEvent(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesEventCallback.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onLog(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesEventCallback.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onUpgradeProgressChanged(int i, int i2, int i3, int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesEventCallback.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onWearingStatusChanged(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesEventCallback.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IGlassesEventCallback.DESCRIPTOR);
        }

        public static IGlassesEventCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IGlassesEventCallback.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IGlassesEventCallback)) ? new Proxy(iBinder) : (IGlassesEventCallback) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IGlassesEventCallback.DESCRIPTOR);
            }
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        onBrightnessChanged(parcel.readInt());
                        parcel2.writeNoException();
                        break;
                    case 2:
                        onWearingStatusChanged(parcel.readInt() != 0);
                        parcel2.writeNoException();
                        break;
                    case 3:
                        onUpgradeProgressChanged(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        break;
                    case 4:
                        onKeyEvent(parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        break;
                    case 5:
                        onLog(parcel.readString());
                        parcel2.writeNoException();
                        break;
                    case 6:
                        onHidChannelConnectionStatusChanged(parcel.readInt());
                        parcel2.writeNoException();
                        break;
                    case 7:
                        on7911StatusChanged(parcel.readInt(), parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        break;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
                return true;
            }
            parcel2.writeString(IGlassesEventCallback.DESCRIPTOR);
            return true;
        }
    }

    void on7911StatusChanged(int i, int i2, int i3) throws RemoteException;

    void onBrightnessChanged(int i) throws RemoteException;

    void onHidChannelConnectionStatusChanged(int i) throws RemoteException;

    void onKeyEvent(int i, int i2) throws RemoteException;

    void onLog(String str) throws RemoteException;

    void onUpgradeProgressChanged(int i, int i2, int i3, int i4) throws RemoteException;

    void onWearingStatusChanged(boolean z) throws RemoteException;
}
