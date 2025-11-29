package com.here.services.test.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public interface FingerprintStatsListener extends IInterface {
    public static final String DESCRIPTOR = "com.here.services.test.internal.FingerprintStatsListener";

    public static class Default implements FingerprintStatsListener {
        public IBinder asBinder() {
            return null;
        }

        public void onGetStatsCompleted(int i, Bundle bundle) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements FingerprintStatsListener {
        static final int TRANSACTION_onGetStatsCompleted = 1;

        public static class Proxy implements FingerprintStatsListener {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return FingerprintStatsListener.DESCRIPTOR;
            }

            public void onGetStatsCompleted(int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(FingerprintStatsListener.DESCRIPTOR);
                    obtain.writeInt(i);
                    _Parcel.writeTypedObject(obtain, bundle, 0);
                    this.mRemote.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, FingerprintStatsListener.DESCRIPTOR);
        }

        public static FingerprintStatsListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(FingerprintStatsListener.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof FingerprintStatsListener)) ? new Proxy(iBinder) : (FingerprintStatsListener) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(FingerprintStatsListener.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(FingerprintStatsListener.DESCRIPTOR);
                return true;
            } else if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                onGetStatsCompleted(parcel.readInt(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                return true;
            }
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

    void onGetStatsCompleted(int i, Bundle bundle) throws RemoteException;
}
