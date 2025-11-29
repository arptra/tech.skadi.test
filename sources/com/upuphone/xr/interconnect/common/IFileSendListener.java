package com.upuphone.xr.interconnect.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IFileSendListener extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.interconnect.common.IFileSendListener";

    public static class Default implements IFileSendListener {
        public IBinder asBinder() {
            return null;
        }

        public void onFail(String str, int i) throws RemoteException {
        }

        public void onFinish(String str, String str2) throws RemoteException {
        }

        public void onProgressChanged(String str, int i) throws RemoteException {
        }

        public void onStart(String str) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IFileSendListener {
        static final int TRANSACTION_onFail = 4;
        static final int TRANSACTION_onFinish = 3;
        static final int TRANSACTION_onProgressChanged = 2;
        static final int TRANSACTION_onStart = 1;

        public static class Proxy implements IFileSendListener {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IFileSendListener.DESCRIPTOR;
            }

            public void onFail(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IFileSendListener.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.mRemote.transact(4, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onFinish(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IFileSendListener.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(3, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onProgressChanged(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IFileSendListener.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.mRemote.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onStart(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IFileSendListener.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IFileSendListener.DESCRIPTOR);
        }

        public static IFileSendListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IFileSendListener.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IFileSendListener)) ? new Proxy(iBinder) : (IFileSendListener) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IFileSendListener.DESCRIPTOR);
            }
            if (i != 1598968902) {
                if (i == 1) {
                    onStart(parcel.readString());
                } else if (i == 2) {
                    onProgressChanged(parcel.readString(), parcel.readInt());
                } else if (i == 3) {
                    onFinish(parcel.readString(), parcel.readString());
                } else if (i != 4) {
                    return super.onTransact(i, parcel, parcel2, i2);
                } else {
                    onFail(parcel.readString(), parcel.readInt());
                }
                return true;
            }
            parcel2.writeString(IFileSendListener.DESCRIPTOR);
            return true;
        }
    }

    void onFail(String str, int i) throws RemoteException;

    void onFinish(String str, String str2) throws RemoteException;

    void onProgressChanged(String str, int i) throws RemoteException;

    void onStart(String str) throws RemoteException;
}
