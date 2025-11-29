package com.upuphone.xr.interconnect.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IResourceManager extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.interconnect.common.IResourceManager";
    public static final String TAG = "ResourceManager";

    public static class Default implements IResourceManager {
        public IBinder asBinder() {
            return null;
        }

        public byte getAvailability(String str, byte b, String str2) throws RemoteException {
            return 0;
        }

        public void open(String str, String str2, byte b, String str3) throws RemoteException {
        }

        public void registerOpener(byte b, String str) throws RemoteException {
        }

        public void setAvailability(byte b, String str, boolean z) throws RemoteException {
        }
    }

    public @interface ResourceAvailability {
        public static final byte AVAILABLE = 1;
        public static final byte UNAVAILABLE = 0;
        public static final byte UNKNOWN = -1;
    }

    public @interface ResourceType {
        public static final byte CASTABLE_APP = 1;
    }

    public static abstract class Stub extends Binder implements IResourceManager {
        static final int TRANSACTION_getAvailability = 1;
        static final int TRANSACTION_open = 4;
        static final int TRANSACTION_registerOpener = 3;
        static final int TRANSACTION_setAvailability = 2;

        public static class Proxy implements IResourceManager {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public byte getAvailability(String str, byte b, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IResourceManager.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeByte(b);
                    obtain.writeString(str2);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readByte();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IResourceManager.DESCRIPTOR;
            }

            public void open(String str, String str2, byte b, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IResourceManager.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeByte(b);
                    obtain.writeString(str3);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void registerOpener(byte b, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IResourceManager.DESCRIPTOR);
                    obtain.writeByte(b);
                    obtain.writeString(str);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setAvailability(byte b, String str, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IResourceManager.DESCRIPTOR);
                    obtain.writeByte(b);
                    obtain.writeString(str);
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
            attachInterface(this, IResourceManager.DESCRIPTOR);
        }

        public static IResourceManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IResourceManager.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IResourceManager)) ? new Proxy(iBinder) : (IResourceManager) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IResourceManager.DESCRIPTOR);
            }
            if (i != 1598968902) {
                if (i == 1) {
                    byte availability = getAvailability(parcel.readString(), parcel.readByte(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeByte(availability);
                } else if (i == 2) {
                    setAvailability(parcel.readByte(), parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                } else if (i == 3) {
                    registerOpener(parcel.readByte(), parcel.readString());
                    parcel2.writeNoException();
                } else if (i != 4) {
                    return super.onTransact(i, parcel, parcel2, i2);
                } else {
                    open(parcel.readString(), parcel.readString(), parcel.readByte(), parcel.readString());
                    parcel2.writeNoException();
                }
                return true;
            }
            parcel2.writeString(IResourceManager.DESCRIPTOR);
            return true;
        }
    }

    byte getAvailability(String str, byte b, String str2) throws RemoteException;

    void open(String str, String str2, byte b, String str3) throws RemoteException;

    void registerOpener(byte b, String str) throws RemoteException;

    void setAvailability(byte b, String str, boolean z) throws RemoteException;
}
