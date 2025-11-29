package com.upuphone.xr.interconnect.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IMessageSendListener extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.interconnect.common.IMessageSendListener";

    public static class Default implements IMessageSendListener {
        public IBinder asBinder() {
            return null;
        }

        public void onFail(String str, int i) throws RemoteException {
        }

        public void onSuccess(String str) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IMessageSendListener {
        static final int TRANSACTION_onFail = 2;
        static final int TRANSACTION_onSuccess = 1;

        public static class Proxy implements IMessageSendListener {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IMessageSendListener.DESCRIPTOR;
            }

            public void onFail(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMessageSendListener.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.mRemote.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onSuccess(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMessageSendListener.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IMessageSendListener.DESCRIPTOR);
        }

        public static IMessageSendListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IMessageSendListener.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IMessageSendListener)) ? new Proxy(iBinder) : (IMessageSendListener) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IMessageSendListener.DESCRIPTOR);
            }
            if (i != 1598968902) {
                if (i == 1) {
                    onSuccess(parcel.readString());
                } else if (i != 2) {
                    return super.onTransact(i, parcel, parcel2, i2);
                } else {
                    onFail(parcel.readString(), parcel.readInt());
                }
                return true;
            }
            parcel2.writeString(IMessageSendListener.DESCRIPTOR);
            return true;
        }
    }

    void onFail(String str, int i) throws RemoteException;

    void onSuccess(String str) throws RemoteException;
}
