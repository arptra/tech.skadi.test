package com.upuphone.xr.interconnect.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.upuphone.xr.interconnect.entity.StarryNetFile;

public interface IFileReceiver extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.interconnect.common.IFileReceiver";

    public static class Default implements IFileReceiver {
        public IBinder asBinder() {
            return null;
        }

        public void onFail(String str, int i) throws RemoteException {
        }

        public void onFinish(String str, String str2) throws RemoteException {
        }

        public void onProgressChanged(String str, int i) throws RemoteException {
        }

        public void onStart(String str, StarryNetFile starryNetFile) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IFileReceiver {
        static final int TRANSACTION_onFail = 4;
        static final int TRANSACTION_onFinish = 3;
        static final int TRANSACTION_onProgressChanged = 2;
        static final int TRANSACTION_onStart = 1;

        public static class Proxy implements IFileReceiver {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IFileReceiver.DESCRIPTOR;
            }

            public void onFail(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IFileReceiver.DESCRIPTOR);
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
                    obtain.writeInterfaceToken(IFileReceiver.DESCRIPTOR);
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
                    obtain.writeInterfaceToken(IFileReceiver.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.mRemote.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onStart(String str, StarryNetFile starryNetFile) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IFileReceiver.DESCRIPTOR);
                    obtain.writeString(str);
                    _Parcel.writeTypedObject(obtain, starryNetFile, 0);
                    this.mRemote.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IFileReceiver.DESCRIPTOR);
        }

        public static IFileReceiver asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IFileReceiver.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IFileReceiver)) ? new Proxy(iBinder) : (IFileReceiver) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IFileReceiver.DESCRIPTOR);
            }
            if (i != 1598968902) {
                if (i == 1) {
                    onStart(parcel.readString(), (StarryNetFile) _Parcel.readTypedObject(parcel, StarryNetFile.CREATOR));
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
            parcel2.writeString(IFileReceiver.DESCRIPTOR);
            return true;
        }
    }

    public static class _Parcel {
        /* access modifiers changed from: private */
        public static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedObject(Parcel parcel, T t, int i) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
                return;
            }
            parcel.writeInt(0);
        }
    }

    void onFail(String str, int i) throws RemoteException;

    void onFinish(String str, String str2) throws RemoteException;

    void onProgressChanged(String str, int i) throws RemoteException;

    void onStart(String str, StarryNetFile starryNetFile) throws RemoteException;
}
