package com.here.services.positioning.upload.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.here.services.positioning.upload.internal.UploadListener;

public interface IUploadClient extends IInterface {
    public static final String DESCRIPTOR = "com.here.services.positioning.upload.internal.IUploadClient";

    public static class Default implements IUploadClient {
        public IBinder asBinder() {
            return null;
        }

        public void cancelUpload() throws RemoteException {
        }

        public int subscribe(UploadListener uploadListener) throws RemoteException {
            return 0;
        }

        public int unsubscribe() throws RemoteException {
            return 0;
        }

        public int upload(Bundle bundle) throws RemoteException {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements IUploadClient {
        static final int TRANSACTION_cancelUpload = 2;
        static final int TRANSACTION_subscribe = 3;
        static final int TRANSACTION_unsubscribe = 4;
        static final int TRANSACTION_upload = 1;

        public static class Proxy implements IUploadClient {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void cancelUpload() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IUploadClient.DESCRIPTOR);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IUploadClient.DESCRIPTOR;
            }

            public int subscribe(UploadListener uploadListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IUploadClient.DESCRIPTOR);
                    obtain.writeStrongInterface(uploadListener);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int unsubscribe() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IUploadClient.DESCRIPTOR);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int upload(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IUploadClient.DESCRIPTOR);
                    _Parcel.writeTypedObject(obtain, bundle, 0);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IUploadClient.DESCRIPTOR);
        }

        public static IUploadClient asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IUploadClient.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IUploadClient)) ? new Proxy(iBinder) : (IUploadClient) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IUploadClient.DESCRIPTOR);
            }
            if (i != 1598968902) {
                if (i == 1) {
                    int upload = upload((Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(upload);
                } else if (i == 2) {
                    cancelUpload();
                    parcel2.writeNoException();
                } else if (i == 3) {
                    int subscribe = subscribe(UploadListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(subscribe);
                } else if (i != 4) {
                    return super.onTransact(i, parcel, parcel2, i2);
                } else {
                    int unsubscribe = unsubscribe();
                    parcel2.writeNoException();
                    parcel2.writeInt(unsubscribe);
                }
                return true;
            }
            parcel2.writeString(IUploadClient.DESCRIPTOR);
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

    void cancelUpload() throws RemoteException;

    int subscribe(UploadListener uploadListener) throws RemoteException;

    int unsubscribe() throws RemoteException;

    int upload(Bundle bundle) throws RemoteException;
}
