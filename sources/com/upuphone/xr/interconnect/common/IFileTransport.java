package com.upuphone.xr.interconnect.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.upuphone.xr.interconnect.common.IFileReceiver;
import com.upuphone.xr.interconnect.common.IFileSendListener;
import com.upuphone.xr.interconnect.entity.StarryNetFile;

public interface IFileTransport extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.interconnect.common.IFileTransport";

    public static class Default implements IFileTransport {
        public IBinder asBinder() {
            return null;
        }

        public void cancel(String str) throws RemoteException {
        }

        public void registerFileReceiver(IFileReceiver iFileReceiver) throws RemoteException {
        }

        public void sendFile(StarryNetFile starryNetFile, IFileSendListener iFileSendListener) throws RemoteException {
        }

        public void unregisterFileReceiver(IFileReceiver iFileReceiver) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IFileTransport {
        static final int TRANSACTION_cancel = 2;
        static final int TRANSACTION_registerFileReceiver = 3;
        static final int TRANSACTION_sendFile = 1;
        static final int TRANSACTION_unregisterFileReceiver = 4;

        public static class Proxy implements IFileTransport {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void cancel(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IFileTransport.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IFileTransport.DESCRIPTOR;
            }

            public void registerFileReceiver(IFileReceiver iFileReceiver) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IFileTransport.DESCRIPTOR);
                    obtain.writeStrongInterface(iFileReceiver);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void sendFile(StarryNetFile starryNetFile, IFileSendListener iFileSendListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IFileTransport.DESCRIPTOR);
                    _Parcel.writeTypedObject(obtain, starryNetFile, 0);
                    obtain.writeStrongInterface(iFileSendListener);
                    this.mRemote.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void unregisterFileReceiver(IFileReceiver iFileReceiver) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IFileTransport.DESCRIPTOR);
                    obtain.writeStrongInterface(iFileReceiver);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IFileTransport.DESCRIPTOR);
        }

        public static IFileTransport asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IFileTransport.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IFileTransport)) ? new Proxy(iBinder) : (IFileTransport) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IFileTransport.DESCRIPTOR);
            }
            if (i != 1598968902) {
                if (i == 1) {
                    sendFile((StarryNetFile) _Parcel.readTypedObject(parcel, StarryNetFile.CREATOR), IFileSendListener.Stub.asInterface(parcel.readStrongBinder()));
                } else if (i == 2) {
                    cancel(parcel.readString());
                } else if (i == 3) {
                    registerFileReceiver(IFileReceiver.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                } else if (i != 4) {
                    return super.onTransact(i, parcel, parcel2, i2);
                } else {
                    unregisterFileReceiver(IFileReceiver.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                }
                return true;
            }
            parcel2.writeString(IFileTransport.DESCRIPTOR);
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

    void cancel(String str) throws RemoteException;

    void registerFileReceiver(IFileReceiver iFileReceiver) throws RemoteException;

    void sendFile(StarryNetFile starryNetFile, IFileSendListener iFileSendListener) throws RemoteException;

    void unregisterFileReceiver(IFileReceiver iFileReceiver) throws RemoteException;
}
