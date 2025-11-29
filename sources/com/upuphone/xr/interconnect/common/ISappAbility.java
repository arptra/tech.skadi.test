package com.upuphone.xr.interconnect.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.upuphone.xr.interconnect.common.IAIModelResult;
import com.upuphone.xr.interconnect.common.IPermissonResult;
import java.util.ArrayList;
import java.util.List;

public interface ISappAbility extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.interconnect.common.ISappAbility";

    public static class Default implements ISappAbility {
        public IBinder asBinder() {
            return null;
        }

        public boolean callAbility(String str, String str2) throws RemoteException {
            return false;
        }

        public void requestAIState(IAIModelResult iAIModelResult) throws RemoteException {
        }

        public void requestPermission(List<String> list, IPermissonResult iPermissonResult) throws RemoteException {
        }

        public void submitAIState(String str, IAIModelResult iAIModelResult) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ISappAbility {
        static final int TRANSACTION_callAbility = 1;
        static final int TRANSACTION_requestAIState = 4;
        static final int TRANSACTION_requestPermission = 2;
        static final int TRANSACTION_submitAIState = 3;

        public static class Proxy implements ISappAbility {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public boolean callAbility(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ISappAbility.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    boolean z = false;
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

            public String getInterfaceDescriptor() {
                return ISappAbility.DESCRIPTOR;
            }

            public void requestAIState(IAIModelResult iAIModelResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ISappAbility.DESCRIPTOR);
                    obtain.writeStrongInterface(iAIModelResult);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void requestPermission(List<String> list, IPermissonResult iPermissonResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ISappAbility.DESCRIPTOR);
                    obtain.writeStringList(list);
                    obtain.writeStrongInterface(iPermissonResult);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    obtain2.readStringList(list);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void submitAIState(String str, IAIModelResult iAIModelResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ISappAbility.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeStrongInterface(iAIModelResult);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ISappAbility.DESCRIPTOR);
        }

        public static ISappAbility asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(ISappAbility.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ISappAbility)) ? new Proxy(iBinder) : (ISappAbility) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(ISappAbility.DESCRIPTOR);
            }
            if (i != 1598968902) {
                if (i == 1) {
                    boolean callAbility = callAbility(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(callAbility ? 1 : 0);
                } else if (i == 2) {
                    ArrayList<String> createStringArrayList = parcel.createStringArrayList();
                    requestPermission(createStringArrayList, IPermissonResult.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeStringList(createStringArrayList);
                } else if (i == 3) {
                    submitAIState(parcel.readString(), IAIModelResult.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                } else if (i != 4) {
                    return super.onTransact(i, parcel, parcel2, i2);
                } else {
                    requestAIState(IAIModelResult.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                }
                return true;
            }
            parcel2.writeString(ISappAbility.DESCRIPTOR);
            return true;
        }
    }

    boolean callAbility(String str, String str2) throws RemoteException;

    void requestAIState(IAIModelResult iAIModelResult) throws RemoteException;

    void requestPermission(List<String> list, IPermissonResult iPermissonResult) throws RemoteException;

    void submitAIState(String str, IAIModelResult iAIModelResult) throws RemoteException;
}
