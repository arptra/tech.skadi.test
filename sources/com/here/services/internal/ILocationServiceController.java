package com.here.services.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public interface ILocationServiceController extends IInterface {
    public static final String DESCRIPTOR = "com.here.services.internal.ILocationServiceController";

    public static class Default implements ILocationServiceController {
        public IBinder asBinder() {
            return null;
        }

        public boolean updateOptions(Bundle bundle) throws RemoteException {
            return false;
        }

        public boolean updateUserConsentState(boolean z) throws RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements ILocationServiceController {
        static final int TRANSACTION_updateOptions = 1;
        static final int TRANSACTION_updateUserConsentState = 2;

        public static class Proxy implements ILocationServiceController {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ILocationServiceController.DESCRIPTOR;
            }

            public boolean updateOptions(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ILocationServiceController.DESCRIPTOR);
                    boolean z = false;
                    _Parcel.writeTypedObject(obtain, bundle, 0);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean updateUserConsentState(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ILocationServiceController.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    boolean z2 = false;
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z2 = true;
                    }
                    return z2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ILocationServiceController.DESCRIPTOR);
        }

        public static ILocationServiceController asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(ILocationServiceController.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ILocationServiceController)) ? new Proxy(iBinder) : (ILocationServiceController) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(ILocationServiceController.DESCRIPTOR);
            }
            if (i != 1598968902) {
                if (i == 1) {
                    boolean updateOptions = updateOptions((Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(updateOptions ? 1 : 0);
                } else if (i != 2) {
                    return super.onTransact(i, parcel, parcel2, i2);
                } else {
                    boolean updateUserConsentState = updateUserConsentState(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    parcel2.writeInt(updateUserConsentState ? 1 : 0);
                }
                return true;
            }
            parcel2.writeString(ILocationServiceController.DESCRIPTOR);
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

    boolean updateOptions(Bundle bundle) throws RemoteException;

    boolean updateUserConsentState(boolean z) throws RemoteException;
}
