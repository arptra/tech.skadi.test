package com.upuphone.xr.interconnect.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.upuphone.xr.interconnect.common.IMessageReceiver;
import com.upuphone.xr.interconnect.common.IMessageSendListener;
import com.upuphone.xr.interconnect.common.IRingMessageReceiver;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.entity.StarryNetRingMsgConfig;

public interface IMessageTransport extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.interconnect.common.IMessageTransport";

    public static class Default implements IMessageTransport {
        public IBinder asBinder() {
            return null;
        }

        public void registerMessageReceiver(IMessageReceiver iMessageReceiver) throws RemoteException {
        }

        public void registerRingMessageReceiver(IRingMessageReceiver iRingMessageReceiver) throws RemoteException {
        }

        public String sendMessage(StarryNetMessage starryNetMessage, IMessageSendListener iMessageSendListener) throws RemoteException {
            return null;
        }

        public String sendRingMessage(StarryNetRingMsgConfig starryNetRingMsgConfig, String str, byte[] bArr, IMessageSendListener iMessageSendListener) throws RemoteException {
            return null;
        }

        public void unregisterMessageReceiver(IMessageReceiver iMessageReceiver) throws RemoteException {
        }

        public void unregisterRingMessageReceiver(IRingMessageReceiver iRingMessageReceiver) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IMessageTransport {
        static final int TRANSACTION_registerMessageReceiver = 3;
        static final int TRANSACTION_registerRingMessageReceiver = 1;
        static final int TRANSACTION_sendMessage = 5;
        static final int TRANSACTION_sendRingMessage = 6;
        static final int TRANSACTION_unregisterMessageReceiver = 4;
        static final int TRANSACTION_unregisterRingMessageReceiver = 2;

        public static class Proxy implements IMessageTransport {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IMessageTransport.DESCRIPTOR;
            }

            public void registerMessageReceiver(IMessageReceiver iMessageReceiver) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMessageTransport.DESCRIPTOR);
                    obtain.writeStrongInterface(iMessageReceiver);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void registerRingMessageReceiver(IRingMessageReceiver iRingMessageReceiver) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMessageTransport.DESCRIPTOR);
                    obtain.writeStrongInterface(iRingMessageReceiver);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String sendMessage(StarryNetMessage starryNetMessage, IMessageSendListener iMessageSendListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMessageTransport.DESCRIPTOR);
                    _Parcel.writeTypedObject(obtain, starryNetMessage, 0);
                    obtain.writeStrongInterface(iMessageSendListener);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String sendRingMessage(StarryNetRingMsgConfig starryNetRingMsgConfig, String str, byte[] bArr, IMessageSendListener iMessageSendListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMessageTransport.DESCRIPTOR);
                    _Parcel.writeTypedObject(obtain, starryNetRingMsgConfig, 0);
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    obtain.writeStrongInterface(iMessageSendListener);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void unregisterMessageReceiver(IMessageReceiver iMessageReceiver) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMessageTransport.DESCRIPTOR);
                    obtain.writeStrongInterface(iMessageReceiver);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void unregisterRingMessageReceiver(IRingMessageReceiver iRingMessageReceiver) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMessageTransport.DESCRIPTOR);
                    obtain.writeStrongInterface(iRingMessageReceiver);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IMessageTransport.DESCRIPTOR);
        }

        public static IMessageTransport asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IMessageTransport.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IMessageTransport)) ? new Proxy(iBinder) : (IMessageTransport) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IMessageTransport.DESCRIPTOR);
            }
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        registerRingMessageReceiver(IRingMessageReceiver.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 2:
                        unregisterRingMessageReceiver(IRingMessageReceiver.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 3:
                        registerMessageReceiver(IMessageReceiver.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 4:
                        unregisterMessageReceiver(IMessageReceiver.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 5:
                        String sendMessage = sendMessage((StarryNetMessage) _Parcel.readTypedObject(parcel, StarryNetMessage.CREATOR), IMessageSendListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeString(sendMessage);
                        break;
                    case 6:
                        String sendRingMessage = sendRingMessage((StarryNetRingMsgConfig) _Parcel.readTypedObject(parcel, StarryNetRingMsgConfig.CREATOR), parcel.readString(), parcel.createByteArray(), IMessageSendListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeString(sendRingMessage);
                        break;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
                return true;
            }
            parcel2.writeString(IMessageTransport.DESCRIPTOR);
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

    void registerMessageReceiver(IMessageReceiver iMessageReceiver) throws RemoteException;

    void registerRingMessageReceiver(IRingMessageReceiver iRingMessageReceiver) throws RemoteException;

    String sendMessage(StarryNetMessage starryNetMessage, IMessageSendListener iMessageSendListener) throws RemoteException;

    String sendRingMessage(StarryNetRingMsgConfig starryNetRingMsgConfig, String str, byte[] bArr, IMessageSendListener iMessageSendListener) throws RemoteException;

    void unregisterMessageReceiver(IMessageReceiver iMessageReceiver) throws RemoteException;

    void unregisterRingMessageReceiver(IRingMessageReceiver iRingMessageReceiver) throws RemoteException;
}
