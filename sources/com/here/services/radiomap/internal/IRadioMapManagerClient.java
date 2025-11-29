package com.here.services.radiomap.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.here.services.radiomap.common.GeoArea;
import com.here.services.radiomap.internal.RadioMapActionListener;

public interface IRadioMapManagerClient extends IInterface {
    public static final String DESCRIPTOR = "com.here.services.radiomap.internal.IRadioMapManagerClient";

    public static class Default implements IRadioMapManagerClient {
        public IBinder asBinder() {
            return null;
        }

        public void close() throws RemoteException {
        }

        public boolean startRadioMapQuery(GeoArea[] geoAreaArr, int i, String str, RadioMapActionListener radioMapActionListener) throws RemoteException {
            return false;
        }

        public boolean startRadioMapUpdate(GeoArea[] geoAreaArr, String str, Bundle bundle, RadioMapActionListener radioMapActionListener) throws RemoteException {
            return false;
        }

        public void stopRadioMapAction(RadioMapActionListener radioMapActionListener) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IRadioMapManagerClient {
        static final int TRANSACTION_close = 4;
        static final int TRANSACTION_startRadioMapQuery = 2;
        static final int TRANSACTION_startRadioMapUpdate = 1;
        static final int TRANSACTION_stopRadioMapAction = 3;

        public static class Proxy implements IRadioMapManagerClient {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void close() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IRadioMapManagerClient.DESCRIPTOR);
                    this.mRemote.transact(4, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IRadioMapManagerClient.DESCRIPTOR;
            }

            public boolean startRadioMapQuery(GeoArea[] geoAreaArr, int i, String str, RadioMapActionListener radioMapActionListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IRadioMapManagerClient.DESCRIPTOR);
                    boolean z = false;
                    obtain.writeTypedArray(geoAreaArr, 0);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeStrongInterface(radioMapActionListener);
                    this.mRemote.transact(2, obtain, obtain2, 0);
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

            public boolean startRadioMapUpdate(GeoArea[] geoAreaArr, String str, Bundle bundle, RadioMapActionListener radioMapActionListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IRadioMapManagerClient.DESCRIPTOR);
                    boolean z = false;
                    obtain.writeTypedArray(geoAreaArr, 0);
                    obtain.writeString(str);
                    _Parcel.writeTypedObject(obtain, bundle, 0);
                    obtain.writeStrongInterface(radioMapActionListener);
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

            public void stopRadioMapAction(RadioMapActionListener radioMapActionListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IRadioMapManagerClient.DESCRIPTOR);
                    obtain.writeStrongInterface(radioMapActionListener);
                    this.mRemote.transact(3, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IRadioMapManagerClient.DESCRIPTOR);
        }

        public static IRadioMapManagerClient asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IRadioMapManagerClient.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IRadioMapManagerClient)) ? new Proxy(iBinder) : (IRadioMapManagerClient) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IRadioMapManagerClient.DESCRIPTOR);
            }
            if (i != 1598968902) {
                if (i == 1) {
                    boolean startRadioMapUpdate = startRadioMapUpdate((GeoArea[]) parcel.createTypedArray(GeoArea.CREATOR), parcel.readString(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR), RadioMapActionListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(startRadioMapUpdate ? 1 : 0);
                } else if (i == 2) {
                    boolean startRadioMapQuery = startRadioMapQuery((GeoArea[]) parcel.createTypedArray(GeoArea.CREATOR), parcel.readInt(), parcel.readString(), RadioMapActionListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(startRadioMapQuery ? 1 : 0);
                } else if (i == 3) {
                    stopRadioMapAction(RadioMapActionListener.Stub.asInterface(parcel.readStrongBinder()));
                } else if (i != 4) {
                    return super.onTransact(i, parcel, parcel2, i2);
                } else {
                    close();
                }
                return true;
            }
            parcel2.writeString(IRadioMapManagerClient.DESCRIPTOR);
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

    void close() throws RemoteException;

    boolean startRadioMapQuery(GeoArea[] geoAreaArr, int i, String str, RadioMapActionListener radioMapActionListener) throws RemoteException;

    boolean startRadioMapUpdate(GeoArea[] geoAreaArr, String str, Bundle bundle, RadioMapActionListener radioMapActionListener) throws RemoteException;

    void stopRadioMapAction(RadioMapActionListener radioMapActionListener) throws RemoteException;
}
