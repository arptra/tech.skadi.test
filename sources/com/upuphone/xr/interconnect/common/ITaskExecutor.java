package com.upuphone.xr.interconnect.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.upuphone.xr.interconnect.common.ITaskActionHandler;
import com.upuphone.xr.interconnect.entity.ResourceDescription;

public interface ITaskExecutor extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.interconnect.common.ITaskExecutor";

    public static class Default implements ITaskExecutor {
        public IBinder asBinder() {
            return null;
        }

        public boolean isTaskRunning(int i) throws RemoteException {
            return false;
        }

        public void onInterrupt() throws RemoteException {
        }

        public ITaskActionHandler onLaunch(int i, ResourceDescription resourceDescription) throws RemoteException {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ITaskExecutor {
        static final int TRANSACTION_isTaskRunning = 3;
        static final int TRANSACTION_onInterrupt = 2;
        static final int TRANSACTION_onLaunch = 1;

        public static class Proxy implements ITaskExecutor {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ITaskExecutor.DESCRIPTOR;
            }

            public boolean isTaskRunning(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ITaskExecutor.DESCRIPTOR);
                    obtain.writeInt(i);
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

            public void onInterrupt() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ITaskExecutor.DESCRIPTOR);
                    this.mRemote.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public ITaskActionHandler onLaunch(int i, ResourceDescription resourceDescription) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ITaskExecutor.DESCRIPTOR);
                    obtain.writeInt(i);
                    _Parcel.writeTypedObject(obtain, resourceDescription, 0);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return ITaskActionHandler.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ITaskExecutor.DESCRIPTOR);
        }

        public static ITaskExecutor asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(ITaskExecutor.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ITaskExecutor)) ? new Proxy(iBinder) : (ITaskExecutor) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(ITaskExecutor.DESCRIPTOR);
            }
            if (i != 1598968902) {
                if (i == 1) {
                    ITaskActionHandler onLaunch = onLaunch(parcel.readInt(), (ResourceDescription) _Parcel.readTypedObject(parcel, ResourceDescription.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeStrongInterface(onLaunch);
                } else if (i == 2) {
                    onInterrupt();
                } else if (i != 3) {
                    return super.onTransact(i, parcel, parcel2, i2);
                } else {
                    boolean isTaskRunning = isTaskRunning(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(isTaskRunning ? 1 : 0);
                }
                return true;
            }
            parcel2.writeString(ITaskExecutor.DESCRIPTOR);
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

    boolean isTaskRunning(int i) throws RemoteException;

    void onInterrupt() throws RemoteException;

    ITaskActionHandler onLaunch(int i, ResourceDescription resourceDescription) throws RemoteException;
}
