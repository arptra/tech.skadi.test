package com.share.connect;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ShareLinkObserver extends IInterface {

    public static class Default implements ShareLinkObserver {
        public IBinder asBinder() {
            return null;
        }

        public void onAuthenticationOk() throws RemoteException {
        }

        public void onConnectFailed(int i) throws RemoteException {
        }

        public void onConnected() throws RemoteException {
        }

        public void onDeviceDiscover(boolean z, Device device) throws RemoteException {
        }

        public void onDisconnected(boolean z) throws RemoteException {
        }

        public void onOpenResult(boolean z) throws RemoteException {
        }

        public void onProgress(int i) throws RemoteException {
        }

        public void onReceivedClientBleMac(String str) throws RemoteException {
        }

        public void onReconfigureWifi(WifiOwnerConfig wifiOwnerConfig) throws RemoteException {
        }

        public void onScanResult(boolean z) throws RemoteException {
        }

        public int onSelectWorkMode(int i) throws RemoteException {
            return 0;
        }

        public void onUserInterventionNeeded(boolean z) throws RemoteException {
        }

        public void receivedClientAddress(String str, int i) throws RemoteException {
        }

        public void receivedClientConnectionType(String str) throws RemoteException {
        }

        public void receivedClientHello(String str, String str2, String str3, String str4, int i) throws RemoteException {
        }

        public void receivedClientInfo(String str, String str2, String str3) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ShareLinkObserver {
        private static final String DESCRIPTOR = "com.share.connect.ShareLinkObserver";
        static final int TRANSACTION_onAuthenticationOk = 9;
        static final int TRANSACTION_onConnectFailed = 12;
        static final int TRANSACTION_onConnected = 6;
        static final int TRANSACTION_onDeviceDiscover = 3;
        static final int TRANSACTION_onDisconnected = 11;
        static final int TRANSACTION_onOpenResult = 1;
        static final int TRANSACTION_onProgress = 13;
        static final int TRANSACTION_onReceivedClientBleMac = 16;
        static final int TRANSACTION_onReconfigureWifi = 10;
        static final int TRANSACTION_onScanResult = 2;
        static final int TRANSACTION_onSelectWorkMode = 15;
        static final int TRANSACTION_onUserInterventionNeeded = 14;
        static final int TRANSACTION_receivedClientAddress = 7;
        static final int TRANSACTION_receivedClientConnectionType = 5;
        static final int TRANSACTION_receivedClientHello = 8;
        static final int TRANSACTION_receivedClientInfo = 4;

        public static class Proxy implements ShareLinkObserver {
            public static ShareLinkObserver sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public void onAuthenticationOk() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(9, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onAuthenticationOk();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onConnectFailed(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(12, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onConnectFailed(i);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onConnected() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(6, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onConnected();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onDeviceDiscover(boolean z, Device device) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    if (device != null) {
                        obtain.writeInt(1);
                        device.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onDeviceDiscover(z, device);
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            public void onDisconnected(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(11, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onDisconnected(z);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onOpenResult(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onOpenResult(z);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onProgress(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(13, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onProgress(i);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onReceivedClientBleMac(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(16, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onReceivedClientBleMac(str);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onReconfigureWifi(WifiOwnerConfig wifiOwnerConfig) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (wifiOwnerConfig != null) {
                        obtain.writeInt(1);
                        wifiOwnerConfig.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(10, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            wifiOwnerConfig.readFromParcel(obtain2);
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onReconfigureWifi(wifiOwnerConfig);
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            public void onScanResult(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onScanResult(z);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int onSelectWorkMode(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(15, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().onSelectWorkMode(i);
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onUserInterventionNeeded(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(14, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onUserInterventionNeeded(z);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void receivedClientAddress(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(7, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().receivedClientAddress(str, i);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void receivedClientConnectionType(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(5, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().receivedClientConnectionType(str);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void receivedClientHello(String str, String str2, String str3, String str4, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(8, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().receivedClientHello(str, str2, str3, str4, i);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void receivedClientInfo(String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (this.mRemote.transact(4, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().receivedClientInfo(str, str2, str3);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ShareLinkObserver asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ShareLinkObserver)) ? new Proxy(iBinder) : (ShareLinkObserver) queryLocalInterface;
        }

        public static ShareLinkObserver getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ShareLinkObserver shareLinkObserver) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (shareLinkObserver == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = shareLinkObserver;
                return true;
            }
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: com.share.connect.WifiOwnerConfig} */
        /* JADX WARNING: type inference failed for: r0v1 */
        /* JADX WARNING: type inference failed for: r0v2, types: [com.share.connect.Device] */
        /* JADX WARNING: type inference failed for: r0v8 */
        /* JADX WARNING: type inference failed for: r0v9 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r11, android.os.Parcel r12, android.os.Parcel r13, int r14) throws android.os.RemoteException {
            /*
                r10 = this;
                r0 = 1598968902(0x5f4e5446, float:1.4867585E19)
                r1 = 1
                java.lang.String r2 = "com.share.connect.ShareLinkObserver"
                if (r11 == r0) goto L_0x0140
                r0 = 0
                r3 = 0
                switch(r11) {
                    case 1: goto L_0x012f;
                    case 2: goto L_0x011e;
                    case 3: goto L_0x00fe;
                    case 4: goto L_0x00e8;
                    case 5: goto L_0x00da;
                    case 6: goto L_0x00d0;
                    case 7: goto L_0x00be;
                    case 8: goto L_0x009f;
                    case 9: goto L_0x0095;
                    case 10: goto L_0x0070;
                    case 11: goto L_0x005f;
                    case 12: goto L_0x0051;
                    case 13: goto L_0x0043;
                    case 14: goto L_0x0032;
                    case 15: goto L_0x0020;
                    case 16: goto L_0x0012;
                    default: goto L_0x000d;
                }
            L_0x000d:
                boolean r10 = super.onTransact(r11, r12, r13, r14)
                return r10
            L_0x0012:
                r12.enforceInterface(r2)
                java.lang.String r11 = r12.readString()
                r10.onReceivedClientBleMac(r11)
                r13.writeNoException()
                return r1
            L_0x0020:
                r12.enforceInterface(r2)
                int r11 = r12.readInt()
                int r10 = r10.onSelectWorkMode(r11)
                r13.writeNoException()
                r13.writeInt(r10)
                return r1
            L_0x0032:
                r12.enforceInterface(r2)
                int r11 = r12.readInt()
                if (r11 == 0) goto L_0x003c
                r3 = r1
            L_0x003c:
                r10.onUserInterventionNeeded(r3)
                r13.writeNoException()
                return r1
            L_0x0043:
                r12.enforceInterface(r2)
                int r11 = r12.readInt()
                r10.onProgress(r11)
                r13.writeNoException()
                return r1
            L_0x0051:
                r12.enforceInterface(r2)
                int r11 = r12.readInt()
                r10.onConnectFailed(r11)
                r13.writeNoException()
                return r1
            L_0x005f:
                r12.enforceInterface(r2)
                int r11 = r12.readInt()
                if (r11 == 0) goto L_0x0069
                r3 = r1
            L_0x0069:
                r10.onDisconnected(r3)
                r13.writeNoException()
                return r1
            L_0x0070:
                r12.enforceInterface(r2)
                int r11 = r12.readInt()
                if (r11 == 0) goto L_0x0082
                android.os.Parcelable$Creator<com.share.connect.WifiOwnerConfig> r11 = com.share.connect.WifiOwnerConfig.CREATOR
                java.lang.Object r11 = r11.createFromParcel(r12)
                r0 = r11
                com.share.connect.WifiOwnerConfig r0 = (com.share.connect.WifiOwnerConfig) r0
            L_0x0082:
                r10.onReconfigureWifi(r0)
                r13.writeNoException()
                if (r0 == 0) goto L_0x0091
                r13.writeInt(r1)
                r0.writeToParcel(r13, r1)
                goto L_0x0094
            L_0x0091:
                r13.writeInt(r3)
            L_0x0094:
                return r1
            L_0x0095:
                r12.enforceInterface(r2)
                r10.onAuthenticationOk()
                r13.writeNoException()
                return r1
            L_0x009f:
                r12.enforceInterface(r2)
                java.lang.String r5 = r12.readString()
                java.lang.String r6 = r12.readString()
                java.lang.String r7 = r12.readString()
                java.lang.String r8 = r12.readString()
                int r9 = r12.readInt()
                r4 = r10
                r4.receivedClientHello(r5, r6, r7, r8, r9)
                r13.writeNoException()
                return r1
            L_0x00be:
                r12.enforceInterface(r2)
                java.lang.String r11 = r12.readString()
                int r12 = r12.readInt()
                r10.receivedClientAddress(r11, r12)
                r13.writeNoException()
                return r1
            L_0x00d0:
                r12.enforceInterface(r2)
                r10.onConnected()
                r13.writeNoException()
                return r1
            L_0x00da:
                r12.enforceInterface(r2)
                java.lang.String r11 = r12.readString()
                r10.receivedClientConnectionType(r11)
                r13.writeNoException()
                return r1
            L_0x00e8:
                r12.enforceInterface(r2)
                java.lang.String r11 = r12.readString()
                java.lang.String r14 = r12.readString()
                java.lang.String r12 = r12.readString()
                r10.receivedClientInfo(r11, r14, r12)
                r13.writeNoException()
                return r1
            L_0x00fe:
                r12.enforceInterface(r2)
                int r11 = r12.readInt()
                if (r11 == 0) goto L_0x0108
                r3 = r1
            L_0x0108:
                int r11 = r12.readInt()
                if (r11 == 0) goto L_0x0117
                android.os.Parcelable$Creator<com.share.connect.Device> r11 = com.share.connect.Device.CREATOR
                java.lang.Object r11 = r11.createFromParcel(r12)
                r0 = r11
                com.share.connect.Device r0 = (com.share.connect.Device) r0
            L_0x0117:
                r10.onDeviceDiscover(r3, r0)
                r13.writeNoException()
                return r1
            L_0x011e:
                r12.enforceInterface(r2)
                int r11 = r12.readInt()
                if (r11 == 0) goto L_0x0128
                r3 = r1
            L_0x0128:
                r10.onScanResult(r3)
                r13.writeNoException()
                return r1
            L_0x012f:
                r12.enforceInterface(r2)
                int r11 = r12.readInt()
                if (r11 == 0) goto L_0x0139
                r3 = r1
            L_0x0139:
                r10.onOpenResult(r3)
                r13.writeNoException()
                return r1
            L_0x0140:
                r13.writeString(r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.share.connect.ShareLinkObserver.Stub.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void onAuthenticationOk() throws RemoteException;

    void onConnectFailed(int i) throws RemoteException;

    void onConnected() throws RemoteException;

    void onDeviceDiscover(boolean z, Device device) throws RemoteException;

    void onDisconnected(boolean z) throws RemoteException;

    void onOpenResult(boolean z) throws RemoteException;

    void onProgress(int i) throws RemoteException;

    void onReceivedClientBleMac(String str) throws RemoteException;

    void onReconfigureWifi(WifiOwnerConfig wifiOwnerConfig) throws RemoteException;

    void onScanResult(boolean z) throws RemoteException;

    int onSelectWorkMode(int i) throws RemoteException;

    void onUserInterventionNeeded(boolean z) throws RemoteException;

    void receivedClientAddress(String str, int i) throws RemoteException;

    void receivedClientConnectionType(String str) throws RemoteException;

    void receivedClientHello(String str, String str2, String str3, String str4, int i) throws RemoteException;

    void receivedClientInfo(String str, String str2, String str3) throws RemoteException;
}
