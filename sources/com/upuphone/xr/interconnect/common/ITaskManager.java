package com.upuphone.xr.interconnect.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.upuphone.xr.interconnect.common.ITaskExecutor;
import com.upuphone.xr.interconnect.entity.ResourceDescription;
import com.upuphone.xr.interconnect.entity.RunningTask;

public interface ITaskManager extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.interconnect.common.ITaskManager";
    public static final String TAG = "TaskManager";

    public static class Default implements ITaskManager {
        public IBinder asBinder() {
            return null;
        }

        public void performAction(String str, int i, String str2) throws RemoteException {
        }

        public RunningTask queryRunning(String str, String str2, ResourceDescription resourceDescription) throws RemoteException {
            return null;
        }

        public void registerExecutor(String str, ITaskExecutor iTaskExecutor) throws RemoteException {
        }

        public void removeRunning(int i) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ITaskManager {
        static final int TRANSACTION_performAction = 4;
        static final int TRANSACTION_queryRunning = 3;
        static final int TRANSACTION_registerExecutor = 1;
        static final int TRANSACTION_removeRunning = 2;

        public static class Proxy implements ITaskManager {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ITaskManager.DESCRIPTOR;
            }

            public void performAction(String str, int i, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ITaskManager.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    this.mRemote.transact(4, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public RunningTask queryRunning(String str, String str2, ResourceDescription resourceDescription) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ITaskManager.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    _Parcel.writeTypedObject(obtain, resourceDescription, 0);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return (RunningTask) _Parcel.readTypedObject(obtain2, RunningTask.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void registerExecutor(String str, ITaskExecutor iTaskExecutor) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ITaskManager.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeStrongInterface(iTaskExecutor);
                    this.mRemote.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void removeRunning(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ITaskManager.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ITaskManager.DESCRIPTOR);
        }

        public static ITaskManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(ITaskManager.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ITaskManager)) ? new Proxy(iBinder) : (ITaskManager) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(ITaskManager.DESCRIPTOR);
            }
            if (i != 1598968902) {
                if (i == 1) {
                    registerExecutor(parcel.readString(), ITaskExecutor.Stub.asInterface(parcel.readStrongBinder()));
                } else if (i == 2) {
                    removeRunning(parcel.readInt());
                } else if (i == 3) {
                    RunningTask queryRunning = queryRunning(parcel.readString(), parcel.readString(), (ResourceDescription) _Parcel.readTypedObject(parcel, ResourceDescription.CREATOR));
                    parcel2.writeNoException();
                    _Parcel.writeTypedObject(parcel2, queryRunning, 1);
                } else if (i != 4) {
                    return super.onTransact(i, parcel, parcel2, i2);
                } else {
                    performAction(parcel.readString(), parcel.readInt(), parcel.readString());
                }
                return true;
            }
            parcel2.writeString(ITaskManager.DESCRIPTOR);
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

    void performAction(String str, int i, String str2) throws RemoteException;

    RunningTask queryRunning(String str, String str2, ResourceDescription resourceDescription) throws RemoteException;

    void registerExecutor(String str, ITaskExecutor iTaskExecutor) throws RemoteException;

    void removeRunning(int i) throws RemoteException;
}
