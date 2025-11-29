package com.xjmz.glasses.usb.hid;

import android.hardware.usb.UsbDevice;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.RemoteException;
import com.xjmz.glasses.usb.hid.IGlassesEventCallback;

public interface IGlassesHid extends IInterface {
    public static final String DESCRIPTOR = "com.xjmz.glasses.usb.hid.IGlassesHid";

    public static class Default implements IGlassesHid {
        public IBinder asBinder() {
            return null;
        }

        public void disconnect() throws RemoteException {
        }

        public int enableLog(boolean z) throws RemoteException {
            return 0;
        }

        public int enableMagSensor(boolean z) throws RemoteException {
            return 0;
        }

        public int eraseData() throws RemoteException {
            return 0;
        }

        public int get2D3DMode() throws RemoteException {
            return 0;
        }

        public String getAiDspVersion() throws RemoteException {
            return null;
        }

        public int getBrightnessLevel() throws RemoteException {
            return 0;
        }

        public String getCalibrationData() throws RemoteException {
            return null;
        }

        public String getDeviceName() throws RemoteException {
            return null;
        }

        public String getDisplayChipVersion() throws RemoteException {
            return null;
        }

        public int getDisplayStyleMode() throws RemoteException {
            return 0;
        }

        public int getHidChannelConnectionStatus() throws RemoteException {
            return 0;
        }

        public int getImuFrequency() throws RemoteException {
            return 0;
        }

        public String getMCUAPPVersion() throws RemoteException {
            return null;
        }

        public String getMCUBootVersion() throws RemoteException {
            return null;
        }

        public String getModel() throws RemoteException {
            return null;
        }

        public int getPid() throws RemoteException {
            return 0;
        }

        public int getShallowSleepTime() throws RemoteException {
            return 0;
        }

        public int getSleepTime() throws RemoteException {
            return 0;
        }

        public String getSn() throws RemoteException {
            return null;
        }

        public int getWearingStatus() throws RemoteException {
            return 0;
        }

        public void notifyUsbDetached(UsbDevice usbDevice) throws RemoteException {
        }

        public boolean openUsb(UsbDevice usbDevice) throws RemoteException {
            return false;
        }

        public boolean openUsbWithFd(ParcelFileDescriptor parcelFileDescriptor, UsbDevice usbDevice) throws RemoteException {
            return false;
        }

        public int reboot() throws RemoteException {
            return 0;
        }

        public void registerEventCallback(IGlassesEventCallback iGlassesEventCallback) throws RemoteException {
        }

        public int sendCalibrationDataToImu(String str) throws RemoteException {
            return 0;
        }

        public int set2D3DMode(int i) throws RemoteException {
            return 0;
        }

        public int setBrightness(int i) throws RemoteException {
            return 0;
        }

        public int setDeviceName(String str) throws RemoteException {
            return 0;
        }

        public int setDisplayStyleMode(int i) throws RemoteException {
            return 0;
        }

        public void setEndPoint(String str, String str2) throws RemoteException {
        }

        public int setFirmwareFilepath(String str, int i) throws RemoteException {
            return 0;
        }

        public int setImu(int i) throws RemoteException {
            return 0;
        }

        public int setImuConfig(int i) throws RemoteException {
            return 0;
        }

        public int setImuFrequency(int i) throws RemoteException {
            return 0;
        }

        public int setShallowSleepTime(int i) throws RemoteException {
            return 0;
        }

        public int setSleepTime(int i) throws RemoteException {
            return 0;
        }

        public int svHidGet7911CurrentResolution() throws RemoteException {
            return 0;
        }

        public int svHidGet7911Status(int[] iArr) throws RemoteException {
            return 0;
        }

        public int svHidGetActivateState() throws RemoteException {
            return 0;
        }

        public int svHidGetDuty() throws RemoteException {
            return 0;
        }

        public int svHidSetDuty(int i) throws RemoteException {
            return 0;
        }

        public void unregisterEventCallback(IGlassesEventCallback iGlassesEventCallback) throws RemoteException {
        }

        public int wakeUpVoiceAssistant() throws RemoteException {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements IGlassesHid {
        static final int TRANSACTION_disconnect = 34;
        static final int TRANSACTION_enableLog = 28;
        static final int TRANSACTION_enableMagSensor = 21;
        static final int TRANSACTION_eraseData = 31;
        static final int TRANSACTION_get2D3DMode = 10;
        static final int TRANSACTION_getAiDspVersion = 6;
        static final int TRANSACTION_getBrightnessLevel = 8;
        static final int TRANSACTION_getCalibrationData = 18;
        static final int TRANSACTION_getDeviceName = 24;
        static final int TRANSACTION_getDisplayChipVersion = 5;
        static final int TRANSACTION_getDisplayStyleMode = 12;
        static final int TRANSACTION_getHidChannelConnectionStatus = 33;
        static final int TRANSACTION_getImuFrequency = 20;
        static final int TRANSACTION_getMCUAPPVersion = 4;
        static final int TRANSACTION_getMCUBootVersion = 3;
        static final int TRANSACTION_getModel = 30;
        static final int TRANSACTION_getPid = 35;
        static final int TRANSACTION_getShallowSleepTime = 39;
        static final int TRANSACTION_getSleepTime = 14;
        static final int TRANSACTION_getSn = 29;
        static final int TRANSACTION_getWearingStatus = 22;
        static final int TRANSACTION_notifyUsbDetached = 40;
        static final int TRANSACTION_openUsb = 32;
        static final int TRANSACTION_openUsbWithFd = 37;
        static final int TRANSACTION_reboot = 27;
        static final int TRANSACTION_registerEventCallback = 1;
        static final int TRANSACTION_sendCalibrationDataToImu = 17;
        static final int TRANSACTION_set2D3DMode = 9;
        static final int TRANSACTION_setBrightness = 7;
        static final int TRANSACTION_setDeviceName = 23;
        static final int TRANSACTION_setDisplayStyleMode = 11;
        static final int TRANSACTION_setEndPoint = 36;
        static final int TRANSACTION_setFirmwareFilepath = 26;
        static final int TRANSACTION_setImu = 15;
        static final int TRANSACTION_setImuConfig = 16;
        static final int TRANSACTION_setImuFrequency = 19;
        static final int TRANSACTION_setShallowSleepTime = 38;
        static final int TRANSACTION_setSleepTime = 13;
        static final int TRANSACTION_svHidGet7911CurrentResolution = 41;
        static final int TRANSACTION_svHidGet7911Status = 43;
        static final int TRANSACTION_svHidGetActivateState = 42;
        static final int TRANSACTION_svHidGetDuty = 45;
        static final int TRANSACTION_svHidSetDuty = 44;
        static final int TRANSACTION_unregisterEventCallback = 2;
        static final int TRANSACTION_wakeUpVoiceAssistant = 25;

        public static class Proxy implements IGlassesHid {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void disconnect() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesHid.DESCRIPTOR);
                    this.mRemote.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int enableLog(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesHid.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int enableMagSensor(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesHid.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int eraseData() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesHid.DESCRIPTOR);
                    this.mRemote.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int get2D3DMode() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesHid.DESCRIPTOR);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getAiDspVersion() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesHid.DESCRIPTOR);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getBrightnessLevel() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesHid.DESCRIPTOR);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getCalibrationData() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesHid.DESCRIPTOR);
                    this.mRemote.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getDeviceName() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesHid.DESCRIPTOR);
                    this.mRemote.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getDisplayChipVersion() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesHid.DESCRIPTOR);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getDisplayStyleMode() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesHid.DESCRIPTOR);
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getHidChannelConnectionStatus() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesHid.DESCRIPTOR);
                    this.mRemote.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getImuFrequency() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesHid.DESCRIPTOR);
                    this.mRemote.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IGlassesHid.DESCRIPTOR;
            }

            public String getMCUAPPVersion() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesHid.DESCRIPTOR);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getMCUBootVersion() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesHid.DESCRIPTOR);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getModel() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesHid.DESCRIPTOR);
                    this.mRemote.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getPid() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesHid.DESCRIPTOR);
                    this.mRemote.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getShallowSleepTime() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesHid.DESCRIPTOR);
                    this.mRemote.transact(39, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getSleepTime() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesHid.DESCRIPTOR);
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getSn() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesHid.DESCRIPTOR);
                    this.mRemote.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getWearingStatus() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesHid.DESCRIPTOR);
                    this.mRemote.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void notifyUsbDetached(UsbDevice usbDevice) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesHid.DESCRIPTOR);
                    _Parcel.d(obtain, usbDevice, 0);
                    this.mRemote.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean openUsb(UsbDevice usbDevice) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesHid.DESCRIPTOR);
                    boolean z = false;
                    _Parcel.d(obtain, usbDevice, 0);
                    this.mRemote.transact(32, obtain, obtain2, 0);
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

            public boolean openUsbWithFd(ParcelFileDescriptor parcelFileDescriptor, UsbDevice usbDevice) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesHid.DESCRIPTOR);
                    boolean z = false;
                    _Parcel.d(obtain, parcelFileDescriptor, 0);
                    _Parcel.d(obtain, usbDevice, 0);
                    this.mRemote.transact(37, obtain, obtain2, 0);
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

            public int reboot() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesHid.DESCRIPTOR);
                    this.mRemote.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void registerEventCallback(IGlassesEventCallback iGlassesEventCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesHid.DESCRIPTOR);
                    obtain.writeStrongInterface(iGlassesEventCallback);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int sendCalibrationDataToImu(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesHid.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int set2D3DMode(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesHid.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int setBrightness(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesHid.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int setDeviceName(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesHid.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int setDisplayStyleMode(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesHid.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setEndPoint(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesHid.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int setFirmwareFilepath(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesHid.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.mRemote.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int setImu(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesHid.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int setImuConfig(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesHid.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int setImuFrequency(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesHid.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int setShallowSleepTime(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesHid.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int setSleepTime(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesHid.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int svHidGet7911CurrentResolution() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesHid.DESCRIPTOR);
                    this.mRemote.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int svHidGet7911Status(int[] iArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesHid.DESCRIPTOR);
                    if (iArr == null) {
                        obtain.writeInt(-1);
                    } else {
                        obtain.writeInt(iArr.length);
                    }
                    this.mRemote.transact(Stub.TRANSACTION_svHidGet7911Status, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.readIntArray(iArr);
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            public int svHidGetActivateState() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesHid.DESCRIPTOR);
                    this.mRemote.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int svHidGetDuty() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesHid.DESCRIPTOR);
                    this.mRemote.transact(45, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int svHidSetDuty(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesHid.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void unregisterEventCallback(IGlassesEventCallback iGlassesEventCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesHid.DESCRIPTOR);
                    obtain.writeStrongInterface(iGlassesEventCallback);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int wakeUpVoiceAssistant() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGlassesHid.DESCRIPTOR);
                    this.mRemote.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IGlassesHid.DESCRIPTOR);
        }

        public static IGlassesHid asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IGlassesHid.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IGlassesHid)) ? new Proxy(iBinder) : (IGlassesHid) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IGlassesHid.DESCRIPTOR);
            }
            if (i != 1598968902) {
                boolean z = false;
                switch (i) {
                    case 1:
                        registerEventCallback(IGlassesEventCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 2:
                        unregisterEventCallback(IGlassesEventCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 3:
                        String mCUBootVersion = getMCUBootVersion();
                        parcel2.writeNoException();
                        parcel2.writeString(mCUBootVersion);
                        break;
                    case 4:
                        String mCUAPPVersion = getMCUAPPVersion();
                        parcel2.writeNoException();
                        parcel2.writeString(mCUAPPVersion);
                        break;
                    case 5:
                        String displayChipVersion = getDisplayChipVersion();
                        parcel2.writeNoException();
                        parcel2.writeString(displayChipVersion);
                        break;
                    case 6:
                        String aiDspVersion = getAiDspVersion();
                        parcel2.writeNoException();
                        parcel2.writeString(aiDspVersion);
                        break;
                    case 7:
                        int brightness = setBrightness(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(brightness);
                        break;
                    case 8:
                        int brightnessLevel = getBrightnessLevel();
                        parcel2.writeNoException();
                        parcel2.writeInt(brightnessLevel);
                        break;
                    case 9:
                        int i3 = set2D3DMode(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(i3);
                        break;
                    case 10:
                        int i4 = get2D3DMode();
                        parcel2.writeNoException();
                        parcel2.writeInt(i4);
                        break;
                    case 11:
                        int displayStyleMode = setDisplayStyleMode(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(displayStyleMode);
                        break;
                    case 12:
                        int displayStyleMode2 = getDisplayStyleMode();
                        parcel2.writeNoException();
                        parcel2.writeInt(displayStyleMode2);
                        break;
                    case 13:
                        int sleepTime = setSleepTime(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(sleepTime);
                        break;
                    case 14:
                        int sleepTime2 = getSleepTime();
                        parcel2.writeNoException();
                        parcel2.writeInt(sleepTime2);
                        break;
                    case 15:
                        int imu = setImu(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(imu);
                        break;
                    case 16:
                        int imuConfig = setImuConfig(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(imuConfig);
                        break;
                    case 17:
                        int sendCalibrationDataToImu = sendCalibrationDataToImu(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(sendCalibrationDataToImu);
                        break;
                    case 18:
                        String calibrationData = getCalibrationData();
                        parcel2.writeNoException();
                        parcel2.writeString(calibrationData);
                        break;
                    case 19:
                        int imuFrequency = setImuFrequency(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(imuFrequency);
                        break;
                    case 20:
                        int imuFrequency2 = getImuFrequency();
                        parcel2.writeNoException();
                        parcel2.writeInt(imuFrequency2);
                        break;
                    case 21:
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        int enableMagSensor = enableMagSensor(z);
                        parcel2.writeNoException();
                        parcel2.writeInt(enableMagSensor);
                        break;
                    case 22:
                        int wearingStatus = getWearingStatus();
                        parcel2.writeNoException();
                        parcel2.writeInt(wearingStatus);
                        break;
                    case 23:
                        int deviceName = setDeviceName(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(deviceName);
                        break;
                    case 24:
                        String deviceName2 = getDeviceName();
                        parcel2.writeNoException();
                        parcel2.writeString(deviceName2);
                        break;
                    case 25:
                        int wakeUpVoiceAssistant = wakeUpVoiceAssistant();
                        parcel2.writeNoException();
                        parcel2.writeInt(wakeUpVoiceAssistant);
                        break;
                    case 26:
                        int firmwareFilepath = setFirmwareFilepath(parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(firmwareFilepath);
                        break;
                    case 27:
                        int reboot = reboot();
                        parcel2.writeNoException();
                        parcel2.writeInt(reboot);
                        break;
                    case 28:
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        int enableLog = enableLog(z);
                        parcel2.writeNoException();
                        parcel2.writeInt(enableLog);
                        break;
                    case 29:
                        String sn = getSn();
                        parcel2.writeNoException();
                        parcel2.writeString(sn);
                        break;
                    case 30:
                        String model = getModel();
                        parcel2.writeNoException();
                        parcel2.writeString(model);
                        break;
                    case 31:
                        int eraseData = eraseData();
                        parcel2.writeNoException();
                        parcel2.writeInt(eraseData);
                        break;
                    case 32:
                        boolean openUsb = openUsb((UsbDevice) _Parcel.c(parcel, UsbDevice.CREATOR));
                        parcel2.writeNoException();
                        parcel2.writeInt(openUsb ? 1 : 0);
                        break;
                    case 33:
                        int hidChannelConnectionStatus = getHidChannelConnectionStatus();
                        parcel2.writeNoException();
                        parcel2.writeInt(hidChannelConnectionStatus);
                        break;
                    case 34:
                        disconnect();
                        parcel2.writeNoException();
                        break;
                    case 35:
                        int pid = getPid();
                        parcel2.writeNoException();
                        parcel2.writeInt(pid);
                        break;
                    case 36:
                        setEndPoint(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        break;
                    case 37:
                        boolean openUsbWithFd = openUsbWithFd((ParcelFileDescriptor) _Parcel.c(parcel, ParcelFileDescriptor.CREATOR), (UsbDevice) _Parcel.c(parcel, UsbDevice.CREATOR));
                        parcel2.writeNoException();
                        parcel2.writeInt(openUsbWithFd ? 1 : 0);
                        break;
                    case 38:
                        int shallowSleepTime = setShallowSleepTime(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(shallowSleepTime);
                        break;
                    case 39:
                        int shallowSleepTime2 = getShallowSleepTime();
                        parcel2.writeNoException();
                        parcel2.writeInt(shallowSleepTime2);
                        break;
                    case 40:
                        notifyUsbDetached((UsbDevice) _Parcel.c(parcel, UsbDevice.CREATOR));
                        parcel2.writeNoException();
                        break;
                    case 41:
                        int svHidGet7911CurrentResolution = svHidGet7911CurrentResolution();
                        parcel2.writeNoException();
                        parcel2.writeInt(svHidGet7911CurrentResolution);
                        break;
                    case 42:
                        int svHidGetActivateState = svHidGetActivateState();
                        parcel2.writeNoException();
                        parcel2.writeInt(svHidGetActivateState);
                        break;
                    case TRANSACTION_svHidGet7911Status /*43*/:
                        int readInt = parcel.readInt();
                        int[] iArr = readInt < 0 ? null : new int[readInt];
                        int svHidGet7911Status = svHidGet7911Status(iArr);
                        parcel2.writeNoException();
                        parcel2.writeInt(svHidGet7911Status);
                        parcel2.writeIntArray(iArr);
                        break;
                    case 44:
                        int svHidSetDuty = svHidSetDuty(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(svHidSetDuty);
                        break;
                    case 45:
                        int svHidGetDuty = svHidGetDuty();
                        parcel2.writeNoException();
                        parcel2.writeInt(svHidGetDuty);
                        break;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
                return true;
            }
            parcel2.writeString(IGlassesHid.DESCRIPTOR);
            return true;
        }
    }

    public static class _Parcel {
        public static Object c(Parcel parcel, Parcelable.Creator creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        public static void d(Parcel parcel, Parcelable parcelable, int i) {
            if (parcelable != null) {
                parcel.writeInt(1);
                parcelable.writeToParcel(parcel, i);
                return;
            }
            parcel.writeInt(0);
        }
    }

    void disconnect() throws RemoteException;

    int enableLog(boolean z) throws RemoteException;

    int enableMagSensor(boolean z) throws RemoteException;

    int eraseData() throws RemoteException;

    int get2D3DMode() throws RemoteException;

    String getAiDspVersion() throws RemoteException;

    int getBrightnessLevel() throws RemoteException;

    String getCalibrationData() throws RemoteException;

    String getDeviceName() throws RemoteException;

    String getDisplayChipVersion() throws RemoteException;

    int getDisplayStyleMode() throws RemoteException;

    int getHidChannelConnectionStatus() throws RemoteException;

    int getImuFrequency() throws RemoteException;

    String getMCUAPPVersion() throws RemoteException;

    String getMCUBootVersion() throws RemoteException;

    String getModel() throws RemoteException;

    int getPid() throws RemoteException;

    int getShallowSleepTime() throws RemoteException;

    int getSleepTime() throws RemoteException;

    String getSn() throws RemoteException;

    int getWearingStatus() throws RemoteException;

    void notifyUsbDetached(UsbDevice usbDevice) throws RemoteException;

    boolean openUsb(UsbDevice usbDevice) throws RemoteException;

    boolean openUsbWithFd(ParcelFileDescriptor parcelFileDescriptor, UsbDevice usbDevice) throws RemoteException;

    int reboot() throws RemoteException;

    void registerEventCallback(IGlassesEventCallback iGlassesEventCallback) throws RemoteException;

    int sendCalibrationDataToImu(String str) throws RemoteException;

    int set2D3DMode(int i) throws RemoteException;

    int setBrightness(int i) throws RemoteException;

    int setDeviceName(String str) throws RemoteException;

    int setDisplayStyleMode(int i) throws RemoteException;

    void setEndPoint(String str, String str2) throws RemoteException;

    int setFirmwareFilepath(String str, int i) throws RemoteException;

    int setImu(int i) throws RemoteException;

    int setImuConfig(int i) throws RemoteException;

    int setImuFrequency(int i) throws RemoteException;

    int setShallowSleepTime(int i) throws RemoteException;

    int setSleepTime(int i) throws RemoteException;

    int svHidGet7911CurrentResolution() throws RemoteException;

    int svHidGet7911Status(int[] iArr) throws RemoteException;

    int svHidGetActivateState() throws RemoteException;

    int svHidGetDuty() throws RemoteException;

    int svHidSetDuty(int i) throws RemoteException;

    void unregisterEventCallback(IGlassesEventCallback iGlassesEventCallback) throws RemoteException;

    int wakeUpVoiceAssistant() throws RemoteException;
}
