package com.here.services.positioning.upload.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface UploadListener extends IInterface {
    public static final String DESCRIPTOR = "com.here.services.positioning.upload.internal.UploadListener";

    public static class Default implements UploadListener {
        public IBinder asBinder() {
            return null;
        }

        public void onUploadFailed() throws RemoteException {
        }

        public void onUploaded() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements UploadListener {
        static final int TRANSACTION_onUploadFailed = 2;
        static final int TRANSACTION_onUploaded = 1;

        public static class Proxy implements UploadListener {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return UploadListener.DESCRIPTOR;
            }

            public void onUploadFailed() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(UploadListener.DESCRIPTOR);
                    this.mRemote.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onUploaded() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(UploadListener.DESCRIPTOR);
                    this.mRemote.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, UploadListener.DESCRIPTOR);
        }

        public static UploadListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(UploadListener.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof UploadListener)) ? new Proxy(iBinder) : (UploadListener) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(UploadListener.DESCRIPTOR);
            }
            if (i != 1598968902) {
                if (i == 1) {
                    onUploaded();
                } else if (i != 2) {
                    return super.onTransact(i, parcel, parcel2, i2);
                } else {
                    onUploadFailed();
                }
                return true;
            }
            parcel2.writeString(UploadListener.DESCRIPTOR);
            return true;
        }
    }

    void onUploadFailed() throws RemoteException;

    void onUploaded() throws RemoteException;
}
