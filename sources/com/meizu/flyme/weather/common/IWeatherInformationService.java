package com.meizu.flyme.weather.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.meizu.flyme.weather.common.IWeatherInformationCallback;

public interface IWeatherInformationService extends IInterface {
    public static final String DESCRIPTOR = "com.meizu.flyme.weather.common.IWeatherInformationService";

    public static class Default implements IWeatherInformationService {
        public IBinder asBinder() {
            return null;
        }

        public String checkCityName(String str) throws RemoteException {
            return null;
        }

        public String getCurrentWeatherInformationByCityID(String str) throws RemoteException {
            return null;
        }

        public String getForecastWeatherInformationByCityID(String str) throws RemoteException {
            return null;
        }

        public String getPositioningCityWeatherInfo() throws RemoteException {
            return null;
        }

        public String getWidgetCityWeatherInfo() throws RemoteException {
            return null;
        }

        public void setActionCallback(IWeatherInformationCallback iWeatherInformationCallback) throws RemoteException {
        }

        public void setWeatherInfomationCallback(IWeatherInformationCallback iWeatherInformationCallback) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IWeatherInformationService {
        static final int TRANSACTION_checkCityName = 3;
        static final int TRANSACTION_getCurrentWeatherInformationByCityID = 1;
        static final int TRANSACTION_getForecastWeatherInformationByCityID = 2;
        static final int TRANSACTION_getPositioningCityWeatherInfo = 6;
        static final int TRANSACTION_getWidgetCityWeatherInfo = 7;
        static final int TRANSACTION_setActionCallback = 5;
        static final int TRANSACTION_setWeatherInfomationCallback = 4;

        public static class Proxy implements IWeatherInformationService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String checkCityName(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IWeatherInformationService.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getCurrentWeatherInformationByCityID(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IWeatherInformationService.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getForecastWeatherInformationByCityID(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IWeatherInformationService.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IWeatherInformationService.DESCRIPTOR;
            }

            public String getPositioningCityWeatherInfo() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IWeatherInformationService.DESCRIPTOR);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getWidgetCityWeatherInfo() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IWeatherInformationService.DESCRIPTOR);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setActionCallback(IWeatherInformationCallback iWeatherInformationCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IWeatherInformationService.DESCRIPTOR);
                    obtain.writeStrongInterface(iWeatherInformationCallback);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setWeatherInfomationCallback(IWeatherInformationCallback iWeatherInformationCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IWeatherInformationService.DESCRIPTOR);
                    obtain.writeStrongInterface(iWeatherInformationCallback);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IWeatherInformationService.DESCRIPTOR);
        }

        public static IWeatherInformationService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IWeatherInformationService.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IWeatherInformationService)) ? new Proxy(iBinder) : (IWeatherInformationService) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IWeatherInformationService.DESCRIPTOR);
            }
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        String currentWeatherInformationByCityID = getCurrentWeatherInformationByCityID(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(currentWeatherInformationByCityID);
                        break;
                    case 2:
                        String forecastWeatherInformationByCityID = getForecastWeatherInformationByCityID(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(forecastWeatherInformationByCityID);
                        break;
                    case 3:
                        String checkCityName = checkCityName(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(checkCityName);
                        break;
                    case 4:
                        setWeatherInfomationCallback(IWeatherInformationCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 5:
                        setActionCallback(IWeatherInformationCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 6:
                        String positioningCityWeatherInfo = getPositioningCityWeatherInfo();
                        parcel2.writeNoException();
                        parcel2.writeString(positioningCityWeatherInfo);
                        break;
                    case 7:
                        String widgetCityWeatherInfo = getWidgetCityWeatherInfo();
                        parcel2.writeNoException();
                        parcel2.writeString(widgetCityWeatherInfo);
                        break;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
                return true;
            }
            parcel2.writeString(IWeatherInformationService.DESCRIPTOR);
            return true;
        }
    }

    String checkCityName(String str) throws RemoteException;

    String getCurrentWeatherInformationByCityID(String str) throws RemoteException;

    String getForecastWeatherInformationByCityID(String str) throws RemoteException;

    String getPositioningCityWeatherInfo() throws RemoteException;

    String getWidgetCityWeatherInfo() throws RemoteException;

    void setActionCallback(IWeatherInformationCallback iWeatherInformationCallback) throws RemoteException;

    void setWeatherInfomationCallback(IWeatherInformationCallback iWeatherInformationCallback) throws RemoteException;
}
