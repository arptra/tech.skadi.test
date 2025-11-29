package com.here.services.positioning.analytics.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.here.services.positioning.analytics.internal.UsageTrackingListener;

public interface IUsageTrackingClient extends IInterface {
    public static final String DESCRIPTOR = "com.here.services.positioning.analytics.internal.IUsageTrackingClient";

    public static class Default implements IUsageTrackingClient {
        public IBinder asBinder() {
            return null;
        }

        public Bundle getSupportedTrackers() throws RemoteException {
            return null;
        }

        public int subscribe(UsageTrackingListener usageTrackingListener, Bundle bundle) throws RemoteException {
            return 0;
        }

        public int unsubscribe() throws RemoteException {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements IUsageTrackingClient {
        static final int TRANSACTION_getSupportedTrackers = 1;
        static final int TRANSACTION_subscribe = 2;
        static final int TRANSACTION_unsubscribe = 3;

        public static class Proxy implements IUsageTrackingClient {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IUsageTrackingClient.DESCRIPTOR;
            }

            public Bundle getSupportedTrackers() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IUsageTrackingClient.DESCRIPTOR);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return (Bundle) _Parcel.readTypedObject(obtain2, Bundle.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int subscribe(UsageTrackingListener usageTrackingListener, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IUsageTrackingClient.DESCRIPTOR);
                    obtain.writeStrongInterface(usageTrackingListener);
                    _Parcel.writeTypedObject(obtain, bundle, 0);
                    this.mRemote.transact(2, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken(IUsageTrackingClient.DESCRIPTOR);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IUsageTrackingClient.DESCRIPTOR);
        }

        public static IUsageTrackingClient asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IUsageTrackingClient.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IUsageTrackingClient)) ? new Proxy(iBinder) : (IUsageTrackingClient) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IUsageTrackingClient.DESCRIPTOR);
            }
            if (i != 1598968902) {
                if (i == 1) {
                    Bundle supportedTrackers = getSupportedTrackers();
                    parcel2.writeNoException();
                    _Parcel.writeTypedObject(parcel2, supportedTrackers, 1);
                } else if (i == 2) {
                    int subscribe = subscribe(UsageTrackingListener.Stub.asInterface(parcel.readStrongBinder()), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(subscribe);
                } else if (i != 3) {
                    return super.onTransact(i, parcel, parcel2, i2);
                } else {
                    int unsubscribe = unsubscribe();
                    parcel2.writeNoException();
                    parcel2.writeInt(unsubscribe);
                }
                return true;
            }
            parcel2.writeString(IUsageTrackingClient.DESCRIPTOR);
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

    Bundle getSupportedTrackers() throws RemoteException;

    int subscribe(UsageTrackingListener usageTrackingListener, Bundle bundle) throws RemoteException;

    int unsubscribe() throws RemoteException;
}
