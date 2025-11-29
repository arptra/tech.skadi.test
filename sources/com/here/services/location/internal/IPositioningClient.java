package com.here.services.location.internal;

import android.location.Location;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.here.posclient.sensors.GeneralActivityResult;
import com.here.services.location.internal.PositionListener;

public interface IPositioningClient extends IInterface {
    public static final String DESCRIPTOR = "com.here.services.location.internal.IPositioningClient";

    public static class Default implements IPositioningClient {
        public IBinder asBinder() {
            return null;
        }

        public int availableFeatures() throws RemoteException {
            return 0;
        }

        public void clearPositioningData() throws RemoteException {
        }

        public int enabledFeatures() throws RemoteException {
            return 0;
        }

        public Location getLastPosition() throws RemoteException {
            return null;
        }

        public boolean injectActivity(GeneralActivityResult generalActivityResult) throws RemoteException {
            return false;
        }

        public boolean injectLocation(Location location) throws RemoteException {
            return false;
        }

        public boolean requestSingleUpdate(Bundle bundle, PositionListener positionListener) throws RemoteException {
            return false;
        }

        public boolean startInjectionUpdates(PositionListener positionListener) throws RemoteException {
            return false;
        }

        public boolean startPositionUpdates(Bundle bundle, PositionListener positionListener) throws RemoteException {
            return false;
        }

        public void stopPositionUpdates(PositionListener positionListener) throws RemoteException {
        }

        public void toggleFeature(String str, boolean z) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IPositioningClient {
        static final int TRANSACTION_availableFeatures = 10;
        static final int TRANSACTION_clearPositioningData = 8;
        static final int TRANSACTION_enabledFeatures = 11;
        static final int TRANSACTION_getLastPosition = 7;
        static final int TRANSACTION_injectActivity = 5;
        static final int TRANSACTION_injectLocation = 4;
        static final int TRANSACTION_requestSingleUpdate = 1;
        static final int TRANSACTION_startInjectionUpdates = 3;
        static final int TRANSACTION_startPositionUpdates = 2;
        static final int TRANSACTION_stopPositionUpdates = 6;
        static final int TRANSACTION_toggleFeature = 9;

        public static class Proxy implements IPositioningClient {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public int availableFeatures() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IPositioningClient.DESCRIPTOR);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void clearPositioningData() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IPositioningClient.DESCRIPTOR);
                    this.mRemote.transact(8, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public int enabledFeatures() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IPositioningClient.DESCRIPTOR);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IPositioningClient.DESCRIPTOR;
            }

            public Location getLastPosition() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IPositioningClient.DESCRIPTOR);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return (Location) _Parcel.readTypedObject(obtain2, Location.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean injectActivity(GeneralActivityResult generalActivityResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IPositioningClient.DESCRIPTOR);
                    boolean z = false;
                    _Parcel.writeTypedObject(obtain, generalActivityResult, 0);
                    this.mRemote.transact(5, obtain, obtain2, 0);
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

            public boolean injectLocation(Location location) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IPositioningClient.DESCRIPTOR);
                    boolean z = false;
                    _Parcel.writeTypedObject(obtain, location, 0);
                    this.mRemote.transact(4, obtain, obtain2, 0);
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

            public boolean requestSingleUpdate(Bundle bundle, PositionListener positionListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IPositioningClient.DESCRIPTOR);
                    boolean z = false;
                    _Parcel.writeTypedObject(obtain, bundle, 0);
                    obtain.writeStrongInterface(positionListener);
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

            public boolean startInjectionUpdates(PositionListener positionListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IPositioningClient.DESCRIPTOR);
                    obtain.writeStrongInterface(positionListener);
                    boolean z = false;
                    this.mRemote.transact(3, obtain, obtain2, 0);
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

            public boolean startPositionUpdates(Bundle bundle, PositionListener positionListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IPositioningClient.DESCRIPTOR);
                    boolean z = false;
                    _Parcel.writeTypedObject(obtain, bundle, 0);
                    obtain.writeStrongInterface(positionListener);
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

            public void stopPositionUpdates(PositionListener positionListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IPositioningClient.DESCRIPTOR);
                    obtain.writeStrongInterface(positionListener);
                    this.mRemote.transact(6, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void toggleFeature(String str, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IPositioningClient.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IPositioningClient.DESCRIPTOR);
        }

        public static IPositioningClient asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IPositioningClient.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IPositioningClient)) ? new Proxy(iBinder) : (IPositioningClient) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IPositioningClient.DESCRIPTOR);
            }
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        boolean requestSingleUpdate = requestSingleUpdate((Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR), PositionListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(requestSingleUpdate ? 1 : 0);
                        break;
                    case 2:
                        boolean startPositionUpdates = startPositionUpdates((Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR), PositionListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(startPositionUpdates ? 1 : 0);
                        break;
                    case 3:
                        boolean startInjectionUpdates = startInjectionUpdates(PositionListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(startInjectionUpdates ? 1 : 0);
                        break;
                    case 4:
                        boolean injectLocation = injectLocation((Location) _Parcel.readTypedObject(parcel, Location.CREATOR));
                        parcel2.writeNoException();
                        parcel2.writeInt(injectLocation ? 1 : 0);
                        break;
                    case 5:
                        boolean injectActivity = injectActivity((GeneralActivityResult) _Parcel.readTypedObject(parcel, GeneralActivityResult.CREATOR));
                        parcel2.writeNoException();
                        parcel2.writeInt(injectActivity ? 1 : 0);
                        break;
                    case 6:
                        stopPositionUpdates(PositionListener.Stub.asInterface(parcel.readStrongBinder()));
                        break;
                    case 7:
                        Location lastPosition = getLastPosition();
                        parcel2.writeNoException();
                        _Parcel.writeTypedObject(parcel2, lastPosition, 1);
                        break;
                    case 8:
                        clearPositioningData();
                        break;
                    case 9:
                        toggleFeature(parcel.readString(), parcel.readInt() != 0);
                        parcel2.writeNoException();
                        break;
                    case 10:
                        int availableFeatures = availableFeatures();
                        parcel2.writeNoException();
                        parcel2.writeInt(availableFeatures);
                        break;
                    case 11:
                        int enabledFeatures = enabledFeatures();
                        parcel2.writeNoException();
                        parcel2.writeInt(enabledFeatures);
                        break;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
                return true;
            }
            parcel2.writeString(IPositioningClient.DESCRIPTOR);
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

    int availableFeatures() throws RemoteException;

    void clearPositioningData() throws RemoteException;

    int enabledFeatures() throws RemoteException;

    Location getLastPosition() throws RemoteException;

    boolean injectActivity(GeneralActivityResult generalActivityResult) throws RemoteException;

    boolean injectLocation(Location location) throws RemoteException;

    boolean requestSingleUpdate(Bundle bundle, PositionListener positionListener) throws RemoteException;

    boolean startInjectionUpdates(PositionListener positionListener) throws RemoteException;

    boolean startPositionUpdates(Bundle bundle, PositionListener positionListener) throws RemoteException;

    void stopPositionUpdates(PositionListener positionListener) throws RemoteException;

    void toggleFeature(String str, boolean z) throws RemoteException;
}
