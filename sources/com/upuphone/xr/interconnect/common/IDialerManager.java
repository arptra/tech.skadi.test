package com.upuphone.xr.interconnect.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.upuphone.xr.interconnect.common.IDialerListener;

public interface IDialerManager extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.interconnect.common.IDialerManager";

    public static class Default implements IDialerManager {
        public IBinder asBinder() {
            return null;
        }

        public void dial(int i, String str) throws RemoteException {
        }

        public void registerDialerListener(IDialerListener iDialerListener) throws RemoteException {
        }

        public void syncPhoneBook() throws RemoteException {
        }

        public void unregisterDialerListener(IDialerListener iDialerListener) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IDialerManager {
        static final int TRANSACTION_dial = 3;
        static final int TRANSACTION_registerDialerListener = 1;
        static final int TRANSACTION_syncPhoneBook = 4;
        static final int TRANSACTION_unregisterDialerListener = 2;

        public static class Proxy implements IDialerManager {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void dial(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDialerManager.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IDialerManager.DESCRIPTOR;
            }

            public void registerDialerListener(IDialerListener iDialerListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDialerManager.DESCRIPTOR);
                    obtain.writeStrongInterface(iDialerListener);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void syncPhoneBook() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDialerManager.DESCRIPTOR);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void unregisterDialerListener(IDialerListener iDialerListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDialerManager.DESCRIPTOR);
                    obtain.writeStrongInterface(iDialerListener);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IDialerManager.DESCRIPTOR);
        }

        public static IDialerManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IDialerManager.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IDialerManager)) ? new Proxy(iBinder) : (IDialerManager) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IDialerManager.DESCRIPTOR);
            }
            if (i != 1598968902) {
                if (i == 1) {
                    registerDialerListener(IDialerListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                } else if (i == 2) {
                    unregisterDialerListener(IDialerListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                } else if (i == 3) {
                    dial(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                } else if (i != 4) {
                    return super.onTransact(i, parcel, parcel2, i2);
                } else {
                    syncPhoneBook();
                    parcel2.writeNoException();
                }
                return true;
            }
            parcel2.writeString(IDialerManager.DESCRIPTOR);
            return true;
        }
    }

    void dial(int i, String str) throws RemoteException;

    void registerDialerListener(IDialerListener iDialerListener) throws RemoteException;

    void syncPhoneBook() throws RemoteException;

    void unregisterDialerListener(IDialerListener iDialerListener) throws RemoteException;
}
