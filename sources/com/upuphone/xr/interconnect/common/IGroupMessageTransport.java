package com.upuphone.xr.interconnect.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.upuphone.xr.interconnect.common.IGroupMessageReceiver;
import com.upuphone.xr.interconnect.common.IGroupMessageSendCallback;

public interface IGroupMessageTransport extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.interconnect.common.IGroupMessageTransport";

    public static class Default implements IGroupMessageTransport {
        public IBinder asBinder() {
            return null;
        }

        public void disableGroupModel(int i) throws RemoteException {
        }

        public int sendGroupMsg(byte b, byte[] bArr, int i, IGroupMessageSendCallback iGroupMessageSendCallback) throws RemoteException {
            return 0;
        }

        public int waitGroupMsg(byte b, int i, IGroupMessageReceiver iGroupMessageReceiver) throws RemoteException {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements IGroupMessageTransport {
        static final int TRANSACTION_disableGroupModel = 3;
        static final int TRANSACTION_sendGroupMsg = 1;
        static final int TRANSACTION_waitGroupMsg = 2;

        public static class Proxy implements IGroupMessageTransport {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void disableGroupModel(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGroupMessageTransport.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IGroupMessageTransport.DESCRIPTOR;
            }

            public int sendGroupMsg(byte b, byte[] bArr, int i, IGroupMessageSendCallback iGroupMessageSendCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGroupMessageTransport.DESCRIPTOR);
                    obtain.writeByte(b);
                    obtain.writeByteArray(bArr);
                    obtain.writeInt(i);
                    obtain.writeStrongInterface(iGroupMessageSendCallback);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int waitGroupMsg(byte b, int i, IGroupMessageReceiver iGroupMessageReceiver) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGroupMessageTransport.DESCRIPTOR);
                    obtain.writeByte(b);
                    obtain.writeInt(i);
                    obtain.writeStrongInterface(iGroupMessageReceiver);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IGroupMessageTransport.DESCRIPTOR);
        }

        public static IGroupMessageTransport asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IGroupMessageTransport.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IGroupMessageTransport)) ? new Proxy(iBinder) : (IGroupMessageTransport) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IGroupMessageTransport.DESCRIPTOR);
            }
            if (i != 1598968902) {
                if (i == 1) {
                    int sendGroupMsg = sendGroupMsg(parcel.readByte(), parcel.createByteArray(), parcel.readInt(), IGroupMessageSendCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(sendGroupMsg);
                } else if (i == 2) {
                    int waitGroupMsg = waitGroupMsg(parcel.readByte(), parcel.readInt(), IGroupMessageReceiver.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(waitGroupMsg);
                } else if (i != 3) {
                    return super.onTransact(i, parcel, parcel2, i2);
                } else {
                    disableGroupModel(parcel.readInt());
                    parcel2.writeNoException();
                }
                return true;
            }
            parcel2.writeString(IGroupMessageTransport.DESCRIPTOR);
            return true;
        }
    }

    void disableGroupModel(int i) throws RemoteException;

    int sendGroupMsg(byte b, byte[] bArr, int i, IGroupMessageSendCallback iGroupMessageSendCallback) throws RemoteException;

    int waitGroupMsg(byte b, int i, IGroupMessageReceiver iGroupMessageReceiver) throws RemoteException;
}
