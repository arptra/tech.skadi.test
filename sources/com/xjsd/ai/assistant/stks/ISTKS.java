package com.xjsd.ai.assistant.stks;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.xjsd.ai.assistant.stks.ISTKSCallback;

public interface ISTKS extends IInterface {

    public static class Default implements ISTKS {
        public IBinder asBinder() {
            return null;
        }

        public boolean exitHotWord(String str) throws RemoteException {
            return false;
        }

        public void registerConfirmHotWord(ISTKSCallback iSTKSCallback) throws RemoteException {
        }

        public boolean uploadHotWord(String str) throws RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements ISTKS {
        private static final String DESCRIPTOR = "com.xjsd.ai.assistant.stks.ISTKS";
        static final int TRANSACTION_exitHotWord = 2;
        static final int TRANSACTION_registerConfirmHotWord = 3;
        static final int TRANSACTION_uploadHotWord = 1;

        public static class Proxy implements ISTKS {
            public static ISTKS sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public boolean exitHotWord(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    boolean z = false;
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().exitHotWord(str);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public void registerConfirmHotWord(ISTKSCallback iSTKSCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iSTKSCallback != null ? iSTKSCallback.asBinder() : null);
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().registerConfirmHotWord(iSTKSCallback);
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            public boolean uploadHotWord(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    boolean z = false;
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().uploadHotWord(str);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ISTKS asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ISTKS)) ? new Proxy(iBinder) : (ISTKS) queryLocalInterface;
        }

        public static ISTKS getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ISTKS istks) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (istks == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = istks;
                return true;
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                boolean uploadHotWord = uploadHotWord(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(uploadHotWord ? 1 : 0);
                return true;
            } else if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                boolean exitHotWord = exitHotWord(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(exitHotWord ? 1 : 0);
                return true;
            } else if (i == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                registerConfirmHotWord(ISTKSCallback.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }
    }

    boolean exitHotWord(String str) throws RemoteException;

    void registerConfirmHotWord(ISTKSCallback iSTKSCallback) throws RemoteException;

    boolean uploadHotWord(String str) throws RemoteException;
}
