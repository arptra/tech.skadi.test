package com.upuphone.xr.interconnect.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import com.upuphone.xr.interconnect.business.databinder.DataBinderServer;
import com.upuphone.xr.interconnect.business.messenger.IpcMessageDispatcher;
import com.upuphone.xr.interconnect.common.IClient;
import com.upuphone.xr.interconnect.common.ICommonAggregate;
import com.upuphone.xr.interconnect.ipc.IpcClientManager;
import com.upuphone.xr.interconnect.util.log.ILog;

public class CommonAggregateImpl extends ICommonAggregate.Stub {
    private static final String TAG = "CommonAggregateService";
    private DataBinderServer dataBinderServer = new DataBinderServer();
    private AccountAbilityImpl mAccountAbility;
    private AppManagerImpl mAppManagerImpl;
    private DeviceInfoManagerImpl mDeviceInfoManager;
    private DeviceManagerImpl mDeviceManager;
    private DialerManagerImpl mDialerManager;
    private DlnaServerImpl mDlnaServerImpl;
    private FileTransportImpl mFileTransport;
    private GroupMessageTransportImpl mGroupMessageTransport;
    private IpcMessageDispatcher mMessageTransport;
    private NaviAbilityImpl mNaviAbilityImpl;
    private ResourceManagerImpl mResourceManager;
    private SappAbilityImpl mSappAbilityImpl;
    private TaskManagerImpl mTaskManager;
    private TransAbilityImpl mTransAbilityImpl;
    private VolumeChangeControllerImpl mVolumeChangeControllerImpl;
    private WifiManagerImpl mWifiManager;

    public class ClientDeathRecipient implements IBinder.DeathRecipient {
        private IBinder mBinder;
        private int pid;

        public ClientDeathRecipient(IBinder iBinder, int i) {
            this.mBinder = iBinder;
            this.pid = i;
        }

        public void binderDied() {
            ILog.i(CommonAggregateImpl.TAG, "client died,callingPid--" + this.pid);
            IpcClientManager.INSTANCE.remove(this.pid);
            this.mBinder.unlinkToDeath(this, 0);
        }
    }

    public IBinder queryService(int i) throws RemoteException {
        if (i == 0) {
            if (this.mDeviceManager == null) {
                this.mDeviceManager = new DeviceManagerImpl();
            }
            return this.mDeviceManager;
        } else if (i == 1) {
            if (this.mFileTransport == null) {
                this.mFileTransport = new FileTransportImpl();
            }
            return this.mFileTransport;
        } else if (i != 2) {
            switch (i) {
                case 5:
                    if (this.mGroupMessageTransport == null) {
                        this.mGroupMessageTransport = new GroupMessageTransportImpl();
                    }
                    return this.mGroupMessageTransport;
                case 6:
                    if (this.mVolumeChangeControllerImpl == null) {
                        this.mVolumeChangeControllerImpl = new VolumeChangeControllerImpl();
                    }
                    return this.mVolumeChangeControllerImpl;
                case 7:
                    if (this.mDlnaServerImpl == null) {
                        this.mDlnaServerImpl = new DlnaServerImpl();
                    }
                    return this.mDlnaServerImpl;
                case 8:
                    if (this.mSappAbilityImpl == null) {
                        this.mSappAbilityImpl = new SappAbilityImpl();
                    }
                    return this.mSappAbilityImpl;
                case 9:
                    if (this.mAppManagerImpl == null) {
                        this.mAppManagerImpl = new AppManagerImpl();
                    }
                    return this.mAppManagerImpl;
                case 10:
                    if (this.mNaviAbilityImpl == null) {
                        this.mNaviAbilityImpl = new NaviAbilityImpl();
                    }
                    return this.mNaviAbilityImpl;
                case 11:
                    if (this.mDeviceInfoManager == null) {
                        this.mDeviceInfoManager = new DeviceInfoManagerImpl();
                    }
                    return this.mDeviceInfoManager;
                case 12:
                    if (this.mWifiManager == null) {
                        this.mWifiManager = new WifiManagerImpl();
                    }
                    return this.mWifiManager;
                case 13:
                    if (this.mDialerManager == null) {
                        this.mDialerManager = new DialerManagerImpl();
                    }
                    return this.mDialerManager;
                case 14:
                    if (this.mAccountAbility == null) {
                        this.mAccountAbility = new AccountAbilityImpl();
                    }
                    return this.mAccountAbility;
                case 15:
                    return this.dataBinderServer;
                case 16:
                    if (this.mTaskManager == null) {
                        this.mTaskManager = new TaskManagerImpl();
                    }
                    return this.mTaskManager;
                case 17:
                    if (this.mResourceManager == null) {
                        this.mResourceManager = new ResourceManagerImpl();
                    }
                    return this.mResourceManager;
                case 18:
                    if (this.mTransAbilityImpl == null) {
                        this.mTransAbilityImpl = new TransAbilityImpl();
                    }
                    return this.mTransAbilityImpl;
                default:
                    ILog.w(TAG, "此服务类型--" + i + "不存在");
                    return null;
            }
        } else {
            if (this.mMessageTransport == null) {
                this.mMessageTransport = new IpcMessageDispatcher();
            }
            return this.mMessageTransport.getTransporter();
        }
    }

    public void register(IClient iClient, String str) throws RemoteException {
        int callingPid = Binder.getCallingPid();
        IBinder asBinder = iClient.asBinder();
        IpcClientManager.INSTANCE.add(callingPid, str);
        try {
            asBinder.linkToDeath(new ClientDeathRecipient(asBinder, callingPid), 0);
        } catch (RemoteException e) {
            ILog.e(TAG, "binder.linkToDeath异常", e);
        }
    }
}
