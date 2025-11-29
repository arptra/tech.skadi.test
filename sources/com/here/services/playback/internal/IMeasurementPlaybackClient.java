package com.here.services.playback.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.here.services.playback.internal.ITestTrackSimulationListener;

public interface IMeasurementPlaybackClient extends IInterface {
    public static final String DESCRIPTOR = "com.here.services.playback.internal.IMeasurementPlaybackClient";

    public static class Default implements IMeasurementPlaybackClient {
        public IBinder asBinder() {
            return null;
        }

        public boolean startNetworkMeasurementPlayback(Bundle bundle) throws RemoteException {
            return false;
        }

        public boolean startSimulation(ITestTrackSimulationListener iTestTrackSimulationListener, Bundle bundle) throws RemoteException {
            return false;
        }

        public void stopNetworkMeasurementPlayback() throws RemoteException {
        }

        public void stopSimulation() throws RemoteException {
        }

        public void unBind() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IMeasurementPlaybackClient {
        static final int TRANSACTION_startNetworkMeasurementPlayback = 3;
        static final int TRANSACTION_startSimulation = 1;
        static final int TRANSACTION_stopNetworkMeasurementPlayback = 4;
        static final int TRANSACTION_stopSimulation = 2;
        static final int TRANSACTION_unBind = 5;

        public static class Proxy implements IMeasurementPlaybackClient {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IMeasurementPlaybackClient.DESCRIPTOR;
            }

            public boolean startNetworkMeasurementPlayback(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMeasurementPlaybackClient.DESCRIPTOR);
                    boolean z = false;
                    _Parcel.writeTypedObject(obtain, bundle, 0);
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

            public boolean startSimulation(ITestTrackSimulationListener iTestTrackSimulationListener, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMeasurementPlaybackClient.DESCRIPTOR);
                    obtain.writeStrongInterface(iTestTrackSimulationListener);
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

            public void stopNetworkMeasurementPlayback() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMeasurementPlaybackClient.DESCRIPTOR);
                    this.mRemote.transact(4, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void stopSimulation() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMeasurementPlaybackClient.DESCRIPTOR);
                    this.mRemote.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void unBind() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMeasurementPlaybackClient.DESCRIPTOR);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IMeasurementPlaybackClient.DESCRIPTOR);
        }

        public static IMeasurementPlaybackClient asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IMeasurementPlaybackClient.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IMeasurementPlaybackClient)) ? new Proxy(iBinder) : (IMeasurementPlaybackClient) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IMeasurementPlaybackClient.DESCRIPTOR);
            }
            if (i != 1598968902) {
                if (i == 1) {
                    boolean startSimulation = startSimulation(ITestTrackSimulationListener.Stub.asInterface(parcel.readStrongBinder()), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(startSimulation ? 1 : 0);
                } else if (i == 2) {
                    stopSimulation();
                } else if (i == 3) {
                    boolean startNetworkMeasurementPlayback = startNetworkMeasurementPlayback((Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(startNetworkMeasurementPlayback ? 1 : 0);
                } else if (i == 4) {
                    stopNetworkMeasurementPlayback();
                } else if (i != 5) {
                    return super.onTransact(i, parcel, parcel2, i2);
                } else {
                    unBind();
                    parcel2.writeNoException();
                }
                return true;
            }
            parcel2.writeString(IMeasurementPlaybackClient.DESCRIPTOR);
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

    boolean startNetworkMeasurementPlayback(Bundle bundle) throws RemoteException;

    boolean startSimulation(ITestTrackSimulationListener iTestTrackSimulationListener, Bundle bundle) throws RemoteException;

    void stopNetworkMeasurementPlayback() throws RemoteException;

    void stopSimulation() throws RemoteException;

    void unBind() throws RemoteException;
}
