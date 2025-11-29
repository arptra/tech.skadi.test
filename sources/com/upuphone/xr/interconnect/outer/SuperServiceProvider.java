package com.upuphone.xr.interconnect.outer;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.upuphone.xr.interconnect.common.IAccountAbility;
import com.upuphone.xr.interconnect.common.IAppManager;
import com.upuphone.xr.interconnect.common.IClient;
import com.upuphone.xr.interconnect.common.ICommonAggregate;
import com.upuphone.xr.interconnect.common.IDataBinderServer;
import com.upuphone.xr.interconnect.common.IDeviceInfoManager;
import com.upuphone.xr.interconnect.common.IDeviceManager;
import com.upuphone.xr.interconnect.common.IDialerManager;
import com.upuphone.xr.interconnect.common.IDlnaServer;
import com.upuphone.xr.interconnect.common.IFileTransport;
import com.upuphone.xr.interconnect.common.IGroupMessageTransport;
import com.upuphone.xr.interconnect.common.IMessageTransport;
import com.upuphone.xr.interconnect.common.INaviAbility;
import com.upuphone.xr.interconnect.common.IResourceManager;
import com.upuphone.xr.interconnect.common.ISappAbility;
import com.upuphone.xr.interconnect.common.ITaskManager;
import com.upuphone.xr.interconnect.common.ITransAbility;
import com.upuphone.xr.interconnect.common.IVolumeChangeController;
import com.upuphone.xr.interconnect.common.IWifiManager;

class SuperServiceProvider {
    private static final String REMOTE_SERVICE_CLASS_NAME = "com.upuphone.xr.interconnect.CommonAggregateService";
    private static final String REMOTE_SERVICE_INTENT_ACTION = "com.upuphone.xr.interconnect.CommonService";
    private static final String TAG = "SuperServiceProvider";
    /* access modifiers changed from: private */
    public boolean isConnected = false;
    private IAppManager mAppManager;
    /* access modifiers changed from: private */
    public IBinder.DeathRecipient mBinderDeathRecipient = new IBinder.DeathRecipient() {
        public void binderDied() {
            Log.w(SuperServiceProvider.TAG, "XR-SDK服务Died");
            if (SuperServiceProvider.this.mSuperServiceStateListener != null) {
                SuperServiceProvider.this.mSuperServiceStateListener.onServiceDied();
            }
            boolean unused = SuperServiceProvider.this.isConnected = false;
            SuperServiceProvider.this.mCommonAggregate.asBinder().unlinkToDeath(this, 0);
            ICommonAggregate unused2 = SuperServiceProvider.this.mCommonAggregate = null;
            IDeviceManager unused3 = SuperServiceProvider.this.mDeviceManager = null;
            IMessageTransport unused4 = SuperServiceProvider.this.mMessageTransport = null;
            IFileTransport unused5 = SuperServiceProvider.this.mFileTransport = null;
            IGroupMessageTransport unused6 = SuperServiceProvider.this.mGroupMessageTransport = null;
            IVolumeChangeController unused7 = SuperServiceProvider.this.mVolumeChangeController = null;
            IDlnaServer unused8 = SuperServiceProvider.this.mIDlnaServer = null;
            ISappAbility unused9 = SuperServiceProvider.this.mISappAbility = null;
            INaviAbility unused10 = SuperServiceProvider.this.mINaviAbility = null;
            ITransAbility unused11 = SuperServiceProvider.this.mITransAbility = null;
            SuperServiceProvider.this.mHandler.postDelayed(SuperServiceProvider.this.mConnectTask, 5000);
        }
    };
    /* access modifiers changed from: private */
    public ICommonAggregate mCommonAggregate;
    /* access modifiers changed from: private */
    public Runnable mConnectTask = new a(this);
    private Context mContext;
    private IDataBinderServer mDataBinder;
    private IDeviceInfoManager mDeviceInfoManager;
    /* access modifiers changed from: private */
    public IDeviceManager mDeviceManager;
    private IDialerManager mDialerManager;
    /* access modifiers changed from: private */
    public IFileTransport mFileTransport;
    /* access modifiers changed from: private */
    public IGroupMessageTransport mGroupMessageTransport;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler(Looper.getMainLooper());
    private IAccountAbility mIAccountAbility;
    /* access modifiers changed from: private */
    public IDlnaServer mIDlnaServer;
    /* access modifiers changed from: private */
    public INaviAbility mINaviAbility;
    /* access modifiers changed from: private */
    public ISappAbility mISappAbility;
    /* access modifiers changed from: private */
    public ITransAbility mITransAbility;
    /* access modifiers changed from: private */
    public IMessageTransport mMessageTransport;
    private IResourceManager mResourceManager;
    private String mServerPackageName;
    private ServiceConnection mServiceConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d(SuperServiceProvider.TAG, "onServiceConnected");
            boolean unused = SuperServiceProvider.this.isConnected = true;
            ICommonAggregate unused2 = SuperServiceProvider.this.mCommonAggregate = ICommonAggregate.Stub.asInterface(iBinder);
            try {
                SuperServiceProvider.this.mCommonAggregate.asBinder().linkToDeath(SuperServiceProvider.this.mBinderDeathRecipient, 0);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            try {
                String access$300 = SuperServiceProvider.this.moduleIdentifier;
                Log.d(SuperServiceProvider.TAG, "注册服务传参pkg=" + access$300);
                SuperServiceProvider.this.mCommonAggregate.register(new IClient.Stub() {
                    public void connectSuccess() throws RemoteException {
                    }
                }, access$300);
                if (SuperServiceProvider.this.mSuperServiceStateListener != null) {
                    SuperServiceProvider.this.mSuperServiceStateListener.onServiceConnected();
                }
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            Log.d(SuperServiceProvider.TAG, "onServiceDisconnected");
            boolean unused = SuperServiceProvider.this.isConnected = false;
        }
    };
    /* access modifiers changed from: private */
    public SuperServiceStateListener mSuperServiceStateListener;
    private ITaskManager mTaskManager;
    /* access modifiers changed from: private */
    public IVolumeChangeController mVolumeChangeController;
    private IWifiManager mWifiManager;
    /* access modifiers changed from: private */
    public String moduleIdentifier;

    private synchronized void connectService() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(this.mServerPackageName, REMOTE_SERVICE_CLASS_NAME));
        intent.setAction(REMOTE_SERVICE_INTENT_ACTION);
        intent.setPackage(this.mServerPackageName);
        this.mContext.bindService(intent, this.mServiceConnection, 1);
        this.mHandler.postDelayed(this.mConnectTask, 5000);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        if (!this.isConnected) {
            Log.d(TAG, "再次尝试绑定XR-SDK服务");
            connectService();
        }
    }

    private IBinder queryService(@ServiceFlag int i) {
        if (this.mContext != null) {
            ICommonAggregate iCommonAggregate = this.mCommonAggregate;
            IBinder iBinder = null;
            if (iCommonAggregate != null) {
                try {
                    iBinder = iCommonAggregate.queryService(i);
                    if (iBinder == null) {
                        Log.d(TAG, "通过ICommonAggregate.queryService查询ServiceFlag--" + i + "对应的binder为空");
                    }
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            } else {
                Log.d(TAG, "由于ICommonAggregate为空，不能获取ServiceFlag--" + i + "对应的binder");
            }
            return iBinder;
        }
        throw new RuntimeException("Please invoke bind(Context context) first.");
    }

    public IAppManager getAppManager() {
        IAppManager iAppManager = this.mAppManager;
        if (iAppManager != null) {
            return iAppManager;
        }
        IBinder queryService = queryService(9);
        if (queryService == null) {
            return null;
        }
        IAppManager asInterface = IAppManager.Stub.asInterface(queryService);
        this.mAppManager = asInterface;
        return asInterface;
    }

    public IDataBinderServer getDataBinder() {
        IDataBinderServer iDataBinderServer = this.mDataBinder;
        if (iDataBinderServer != null) {
            return iDataBinderServer;
        }
        IBinder queryService = queryService(15);
        if (queryService == null) {
            return null;
        }
        IDataBinderServer asInterface = IDataBinderServer.Stub.asInterface(queryService);
        this.mDataBinder = asInterface;
        return asInterface;
    }

    public IDeviceInfoManager getDeviceInfoManager() {
        IDeviceInfoManager iDeviceInfoManager = this.mDeviceInfoManager;
        if (iDeviceInfoManager != null) {
            return iDeviceInfoManager;
        }
        IBinder queryService = queryService(11);
        if (queryService == null) {
            return null;
        }
        IDeviceInfoManager asInterface = IDeviceInfoManager.Stub.asInterface(queryService);
        this.mDeviceInfoManager = asInterface;
        return asInterface;
    }

    public IDeviceManager getDeviceManager() {
        IDeviceManager iDeviceManager = this.mDeviceManager;
        if (iDeviceManager != null) {
            return iDeviceManager;
        }
        IBinder queryService = queryService(0);
        if (queryService == null) {
            return null;
        }
        IDeviceManager asInterface = IDeviceManager.Stub.asInterface(queryService);
        this.mDeviceManager = asInterface;
        return asInterface;
    }

    public IDialerManager getDialerManager() {
        IDialerManager iDialerManager = this.mDialerManager;
        if (iDialerManager != null) {
            return iDialerManager;
        }
        IBinder queryService = queryService(13);
        if (queryService == null) {
            return null;
        }
        IDialerManager asInterface = IDialerManager.Stub.asInterface(queryService);
        this.mDialerManager = asInterface;
        return asInterface;
    }

    public IFileTransport getFileTransporter() {
        IFileTransport iFileTransport = this.mFileTransport;
        if (iFileTransport != null) {
            return iFileTransport;
        }
        IBinder queryService = queryService(1);
        if (queryService == null) {
            return null;
        }
        IFileTransport asInterface = IFileTransport.Stub.asInterface(queryService);
        this.mFileTransport = asInterface;
        return asInterface;
    }

    public IGroupMessageTransport getGroupMessenger() {
        IGroupMessageTransport iGroupMessageTransport = this.mGroupMessageTransport;
        if (iGroupMessageTransport != null) {
            return iGroupMessageTransport;
        }
        IBinder queryService = queryService(5);
        if (queryService == null) {
            return null;
        }
        IGroupMessageTransport asInterface = IGroupMessageTransport.Stub.asInterface(queryService);
        this.mGroupMessageTransport = asInterface;
        return asInterface;
    }

    public IAccountAbility getIAccountAbility() {
        IAccountAbility iAccountAbility = this.mIAccountAbility;
        if (iAccountAbility != null) {
            return iAccountAbility;
        }
        IBinder queryService = queryService(14);
        if (queryService == null) {
            return null;
        }
        IAccountAbility asInterface = IAccountAbility.Stub.asInterface(queryService);
        this.mIAccountAbility = asInterface;
        return asInterface;
    }

    public IDlnaServer getIDlnaServer() {
        IDlnaServer iDlnaServer = this.mIDlnaServer;
        if (iDlnaServer != null) {
            return iDlnaServer;
        }
        IBinder queryService = queryService(7);
        if (queryService == null) {
            return null;
        }
        IDlnaServer asInterface = IDlnaServer.Stub.asInterface(queryService);
        this.mIDlnaServer = asInterface;
        return asInterface;
    }

    public INaviAbility getINaviAbility() {
        INaviAbility iNaviAbility = this.mINaviAbility;
        if (iNaviAbility != null) {
            return iNaviAbility;
        }
        IBinder queryService = queryService(10);
        if (queryService == null) {
            return null;
        }
        INaviAbility asInterface = INaviAbility.Stub.asInterface(queryService);
        this.mINaviAbility = asInterface;
        return asInterface;
    }

    public ISappAbility getISappAbility() {
        ISappAbility iSappAbility = this.mISappAbility;
        if (iSappAbility != null) {
            return iSappAbility;
        }
        IBinder queryService = queryService(8);
        if (queryService == null) {
            return null;
        }
        ISappAbility asInterface = ISappAbility.Stub.asInterface(queryService);
        this.mISappAbility = asInterface;
        return asInterface;
    }

    public IMessageTransport getMessageTransporter() {
        IMessageTransport iMessageTransport = this.mMessageTransport;
        if (iMessageTransport != null) {
            return iMessageTransport;
        }
        IBinder queryService = queryService(2);
        if (queryService == null) {
            return null;
        }
        IMessageTransport asInterface = IMessageTransport.Stub.asInterface(queryService);
        this.mMessageTransport = asInterface;
        return asInterface;
    }

    public IResourceManager getResourceManager() {
        IResourceManager iResourceManager = this.mResourceManager;
        if (iResourceManager != null) {
            return iResourceManager;
        }
        IBinder queryService = queryService(17);
        if (queryService == null) {
            return null;
        }
        IResourceManager asInterface = IResourceManager.Stub.asInterface(queryService);
        this.mResourceManager = asInterface;
        return asInterface;
    }

    public ITaskManager getTaskManager() {
        ITaskManager iTaskManager = this.mTaskManager;
        if (iTaskManager != null) {
            return iTaskManager;
        }
        IBinder queryService = queryService(16);
        if (queryService == null) {
            return null;
        }
        ITaskManager asInterface = ITaskManager.Stub.asInterface(queryService);
        this.mTaskManager = asInterface;
        return asInterface;
    }

    public ITransAbility getTransAbility() {
        ITransAbility iTransAbility = this.mITransAbility;
        if (iTransAbility != null) {
            return iTransAbility;
        }
        IBinder queryService = queryService(18);
        if (queryService == null) {
            return null;
        }
        ITransAbility asInterface = ITransAbility.Stub.asInterface(queryService);
        this.mITransAbility = asInterface;
        return asInterface;
    }

    public IVolumeChangeController getVolumeChangeController() {
        IVolumeChangeController iVolumeChangeController = this.mVolumeChangeController;
        if (iVolumeChangeController != null) {
            return iVolumeChangeController;
        }
        IBinder queryService = queryService(6);
        if (queryService == null) {
            return null;
        }
        IVolumeChangeController asInterface = IVolumeChangeController.Stub.asInterface(queryService);
        this.mVolumeChangeController = asInterface;
        return asInterface;
    }

    public IWifiManager getWifiManager() {
        IWifiManager iWifiManager = this.mWifiManager;
        if (iWifiManager != null) {
            return iWifiManager;
        }
        IBinder queryService = queryService(12);
        if (queryService == null) {
            return null;
        }
        IWifiManager asInterface = IWifiManager.Stub.asInterface(queryService);
        this.mWifiManager = asInterface;
        return asInterface;
    }

    public void launch(Context context, String str, String str2) {
        this.mContext = context.getApplicationContext();
        if (TextUtils.isEmpty(str)) {
            str = this.mContext.getPackageName();
        }
        this.moduleIdentifier = str;
        this.mServerPackageName = str2;
        Log.d(TAG, "执行绑定XR-SDK服务");
        connectService();
    }

    public void setSuperAppServiceStateListener(SuperServiceStateListener superServiceStateListener) {
        this.mSuperServiceStateListener = superServiceStateListener;
    }
}
