package com.upuphone.xr.sapp.vu.arspace;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IOnInputTextListener extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.sapp.vu.arspace.IOnInputTextListener";

    public static class Default implements IOnInputTextListener {
        public IBinder asBinder() {
            return null;
        }

        public void onAction(String str, int i) throws RemoteException {
        }

        public void onSelectionChange(String str, int i, int i2) throws RemoteException {
        }

        public void onTextChange(String str, String str2) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IOnInputTextListener {
        static final int TRANSACTION_onAction = 3;
        static final int TRANSACTION_onSelectionChange = 2;
        static final int TRANSACTION_onTextChange = 1;

        public static class Proxy implements IOnInputTextListener {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IOnInputTextListener.DESCRIPTOR;
            }

            public void onAction(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOnInputTextListener.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onSelectionChange(String str, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOnInputTextListener.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onTextChange(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOnInputTextListener.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IOnInputTextListener.DESCRIPTOR);
        }

        public static IOnInputTextListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IOnInputTextListener.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IOnInputTextListener)) ? new Proxy(iBinder) : (IOnInputTextListener) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IOnInputTextListener.DESCRIPTOR);
            }
            if (i != 1598968902) {
                if (i == 1) {
                    onTextChange(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                } else if (i == 2) {
                    onSelectionChange(parcel.readString(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                } else if (i != 3) {
                    return super.onTransact(i, parcel, parcel2, i2);
                } else {
                    onAction(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                }
                return true;
            }
            parcel2.writeString(IOnInputTextListener.DESCRIPTOR);
            return true;
        }
    }

    void onAction(String str, int i) throws RemoteException;

    void onSelectionChange(String str, int i, int i2) throws RemoteException;

    void onTextChange(String str, String str2) throws RemoteException;
}
