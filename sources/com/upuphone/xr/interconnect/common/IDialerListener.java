package com.upuphone.xr.interconnect.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IDialerListener extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.interconnect.common.IDialerListener";

    public static class Default implements IDialerListener {
        public IBinder asBinder() {
            return null;
        }

        public void onDialerStateChanged(String str, int i) throws RemoteException {
        }

        public void onSyncPhoneBookStateChanged(int i) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IDialerListener {
        static final int TRANSACTION_onDialerStateChanged = 1;
        static final int TRANSACTION_onSyncPhoneBookStateChanged = 2;

        public static class Proxy implements IDialerListener {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IDialerListener.DESCRIPTOR;
            }

            public void onDialerStateChanged(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDialerListener.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.mRemote.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onSyncPhoneBookStateChanged(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDialerListener.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IDialerListener.DESCRIPTOR);
        }

        public static IDialerListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IDialerListener.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IDialerListener)) ? new Proxy(iBinder) : (IDialerListener) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IDialerListener.DESCRIPTOR);
            }
            if (i != 1598968902) {
                if (i == 1) {
                    onDialerStateChanged(parcel.readString(), parcel.readInt());
                } else if (i != 2) {
                    return super.onTransact(i, parcel, parcel2, i2);
                } else {
                    onSyncPhoneBookStateChanged(parcel.readInt());
                }
                return true;
            }
            parcel2.writeString(IDialerListener.DESCRIPTOR);
            return true;
        }
    }

    void onDialerStateChanged(String str, int i) throws RemoteException;

    void onSyncPhoneBookStateChanged(int i) throws RemoteException;
}
