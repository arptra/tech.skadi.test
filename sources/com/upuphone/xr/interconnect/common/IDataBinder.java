package com.upuphone.xr.interconnect.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.upuphone.xr.interconnect.common.IDataBinderItemUpdateListener;
import com.upuphone.xr.interconnect.entity.DataBinderValue;
import java.util.List;

public interface IDataBinder extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.interconnect.common.IDataBinder";
    public static final String TAG = "DataBinder";

    public static class Default implements IDataBinder {
        public IBinder asBinder() {
            return null;
        }

        public DataBinderValue get(String str, String str2) throws RemoteException {
            return null;
        }

        public List<String> list(String str) throws RemoteException {
            return null;
        }

        public void set(String str, DataBinderValue dataBinderValue) throws RemoteException {
        }

        public void subscribe(String str, String str2, IDataBinderItemUpdateListener iDataBinderItemUpdateListener) throws RemoteException {
        }

        public void unset(String str) throws RemoteException {
        }

        public void unsubscribe(String str, String str2, IDataBinderItemUpdateListener iDataBinderItemUpdateListener) throws RemoteException {
        }
    }

    public @interface OperationType {
        public static final byte DELETE = 2;
        public static final byte UPDATE = 1;
    }

    public static abstract class Stub extends Binder implements IDataBinder {
        static final int TRANSACTION_get = 1;
        static final int TRANSACTION_list = 4;
        static final int TRANSACTION_set = 2;
        static final int TRANSACTION_subscribe = 5;
        static final int TRANSACTION_unset = 3;
        static final int TRANSACTION_unsubscribe = 6;

        public static class Proxy implements IDataBinder {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public DataBinderValue get(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDataBinder.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return (DataBinderValue) _Parcel.readTypedObject(obtain2, DataBinderValue.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IDataBinder.DESCRIPTOR;
            }

            public List<String> list(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDataBinder.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createStringArrayList();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void set(String str, DataBinderValue dataBinderValue) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDataBinder.DESCRIPTOR);
                    obtain.writeString(str);
                    _Parcel.writeTypedObject(obtain, dataBinderValue, 0);
                    this.mRemote.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void subscribe(String str, String str2, IDataBinderItemUpdateListener iDataBinderItemUpdateListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDataBinder.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongInterface(iDataBinderItemUpdateListener);
                    this.mRemote.transact(5, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void unset(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDataBinder.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(3, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void unsubscribe(String str, String str2, IDataBinderItemUpdateListener iDataBinderItemUpdateListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDataBinder.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongInterface(iDataBinderItemUpdateListener);
                    this.mRemote.transact(6, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IDataBinder.DESCRIPTOR);
        }

        public static IDataBinder asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IDataBinder.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IDataBinder)) ? new Proxy(iBinder) : (IDataBinder) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IDataBinder.DESCRIPTOR);
            }
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        DataBinderValue dataBinderValue = get(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        _Parcel.writeTypedObject(parcel2, dataBinderValue, 1);
                        break;
                    case 2:
                        set(parcel.readString(), (DataBinderValue) _Parcel.readTypedObject(parcel, DataBinderValue.CREATOR));
                        break;
                    case 3:
                        unset(parcel.readString());
                        break;
                    case 4:
                        List<String> list = list(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeStringList(list);
                        break;
                    case 5:
                        subscribe(parcel.readString(), parcel.readString(), IDataBinderItemUpdateListener.Stub.asInterface(parcel.readStrongBinder()));
                        break;
                    case 6:
                        unsubscribe(parcel.readString(), parcel.readString(), IDataBinderItemUpdateListener.Stub.asInterface(parcel.readStrongBinder()));
                        break;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
                return true;
            }
            parcel2.writeString(IDataBinder.DESCRIPTOR);
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

    DataBinderValue get(String str, String str2) throws RemoteException;

    List<String> list(String str) throws RemoteException;

    void set(String str, DataBinderValue dataBinderValue) throws RemoteException;

    void subscribe(String str, String str2, IDataBinderItemUpdateListener iDataBinderItemUpdateListener) throws RemoteException;

    void unset(String str) throws RemoteException;

    void unsubscribe(String str, String str2, IDataBinderItemUpdateListener iDataBinderItemUpdateListener) throws RemoteException;
}
