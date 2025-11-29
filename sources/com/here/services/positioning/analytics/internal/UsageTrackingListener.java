package com.here.services.positioning.analytics.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public interface UsageTrackingListener extends IInterface {
    public static final String DESCRIPTOR = "com.here.services.positioning.analytics.internal.UsageTrackingListener";

    public static class Default implements UsageTrackingListener {
        public IBinder asBinder() {
            return null;
        }

        public void onTrackerUpdated(Bundle bundle) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements UsageTrackingListener {
        static final int TRANSACTION_onTrackerUpdated = 1;

        public static class Proxy implements UsageTrackingListener {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return UsageTrackingListener.DESCRIPTOR;
            }

            public void onTrackerUpdated(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(UsageTrackingListener.DESCRIPTOR);
                    _Parcel.writeTypedObject(obtain, bundle, 0);
                    this.mRemote.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, UsageTrackingListener.DESCRIPTOR);
        }

        public static UsageTrackingListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(UsageTrackingListener.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof UsageTrackingListener)) ? new Proxy(iBinder) : (UsageTrackingListener) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(UsageTrackingListener.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(UsageTrackingListener.DESCRIPTOR);
                return true;
            } else if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                onTrackerUpdated((Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
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

    void onTrackerUpdated(Bundle bundle) throws RemoteException;
}
