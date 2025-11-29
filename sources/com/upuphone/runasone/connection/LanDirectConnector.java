package com.upuphone.runasone.connection;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.upuphone.runasone.service.StarrynetApiImpl;
import com.upuphone.runasone.utils.CommonThreadPool;
import com.upuphone.runasone.utils.LogUtil;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.SysActionManager;
import io.netty.channel.Channel;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class LanDirectConnector {
    /* access modifiers changed from: private */
    public static final LanDirectConnector directConnector = new LanDirectConnector();
    private final int EVENT_DISCONNECT;
    private final int EVENT_FINISH_GC;
    private final int EVENT_FINISH_GO;
    private final int EVENT_START_LISTENER;
    private final int EVENT_START_SWITCH_USER;
    private final int EVENT_TRY_CONNECT;
    private final int EVENT_TRY_CONNECT_AFTER_DIS;
    private final String TAG = "LanDirectConnector";
    private ConcurrentHashMap<String, StDevice> cacheDevices = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, StDevice> connectDevices = new ConcurrentHashMap<>();
    private boolean isPause = false;
    /* access modifiers changed from: private */
    public Handler selfHandler;
    private HandlerThread workThread;

    private LanDirectConnector() {
        HandlerThread handlerThread = new HandlerThread("LanDirectConnector.Thread");
        this.workThread = handlerThread;
        this.EVENT_START_LISTENER = 1;
        this.EVENT_START_SWITCH_USER = 2;
        this.EVENT_FINISH_GO = 3;
        this.EVENT_FINISH_GC = 4;
        this.EVENT_TRY_CONNECT = 5;
        this.EVENT_DISCONNECT = 6;
        this.EVENT_TRY_CONNECT_AFTER_DIS = 7;
        handlerThread.start();
        AnonymousClass1 r0 = new Handler(this.workThread.getLooper()) {
            public void handleMessage(@NonNull Message message) {
                switch (message.what) {
                    case 1:
                        LanDirectConnector.this.listenLife();
                        return;
                    case 2:
                        LanDirectConnector.this.switchUser();
                        return;
                    case 3:
                        Object[] objArr = (Object[]) message.obj;
                        objArr[3] = Boolean.valueOf(LanDirectConnector.this.doFinishConnectGo(((Integer) objArr[0]).intValue(), (String) objArr[1], (StDevice) objArr[2]));
                        synchronized (LanDirectConnector.directConnector) {
                            LanDirectConnector.directConnector.notifyAll();
                        }
                        return;
                    case 4:
                        LanDirectConnector.this.doFinishConnectGc((StDevice) message.obj);
                        return;
                    case 5:
                        LanDirectConnector.this.recoverConnect();
                        return;
                    case 6:
                        LanDirectConnector.this.doFinishDisConnect((StDevice) message.obj);
                        return;
                    case 7:
                        LanDirectConnector.this.connect((StDevice) message.obj);
                        return;
                    default:
                        return;
                }
            }
        };
        this.selfHandler = r0;
        r0.sendEmptyMessage(1);
    }

    /* access modifiers changed from: private */
    public void connect(StDevice stDevice) {
        if (this.isPause) {
            if (isDeviceValid(stDevice)) {
                this.cacheDevices.put(stDevice.getIdentifier2String(), stDevice);
                LogUtil.i("LanDirectConnector", (Object) "暂时中断连接2");
                return;
            }
            LogUtil.i("LanDirectConnector", (Object) "暂时中断连接3");
        } else if (!isDeviceValid(stDevice)) {
            LogUtil.i("LanDirectConnector", (Object) "传入的device不合法");
        } else if (this.connectDevices.get(stDevice.getIdentifier2String()) != null) {
            LogUtil.i("LanDirectConnector", (Object) "设备连接中或者已经连接，do nothing");
        } else {
            LogUtil.i("LanDirectConnector", (Object) "开始重连HUD设备");
            if (isReachable(stDevice, 5000)) {
                StarrynetApiImpl.getConnectImpl().onLanGcConnected(stDevice.getPort(), stDevice.getIpAddress(), stDevice);
                this.connectDevices.put(stDevice.getIdentifier2String(), stDevice);
                return;
            }
            removeMessage(7, stDevice);
            nextConnect(stDevice);
        }
    }

    /* access modifiers changed from: private */
    public void doFinishConnectGc(StDevice stDevice) {
        if (!this.isPause) {
            StDevice stDevice2 = this.connectDevices.get(stDevice.getIdentifier2String());
            if (stDevice2 == null || !equals(stDevice, stDevice2)) {
                boolean isLanGcConnected = StarrynetApiImpl.getConnectImpl().isLanGcConnected(stDevice);
                if (stDevice2 != null && !equals(stDevice, stDevice2) && isLanGcConnected) {
                    LogUtil.i("LanDirectConnector", (Object) "异常：IP或者端口号变了, 关闭当前连接");
                    StarrynetApiImpl.getConnectImpl().onLanDisconnected(stDevice2);
                }
                if (isReachable(stDevice, 5000)) {
                    StarrynetApiImpl.getConnectImpl().onLanGcConnected(stDevice.getPort(), stDevice.getIpAddress(), stDevice);
                    this.connectDevices.put(stDevice.getIdentifier2String(), stDevice);
                    return;
                }
                removeMessage(7, stDevice);
                nextConnect(stDevice);
            }
        } else if (isDeviceValid(stDevice)) {
            LogUtil.i("LanDirectConnector", (Object) "暂时中断连接1");
            this.cacheDevices.put(stDevice.getIdentifier2String(), stDevice);
        } else {
            LogUtil.i("LanDirectConnector", (Object) "暂时中断连接4");
        }
    }

    /* access modifiers changed from: private */
    public boolean doFinishConnectGo(int i, String str, StDevice stDevice) {
        if (isDeviceValid(stDevice) && this.connectDevices.get(stDevice.getIdentifier2String()) != null) {
            LogUtil.i("LanDirectConnector", (Object) "HUD 异常 Connect已经存在");
            return false;
        } else if (!isDeviceValid(stDevice)) {
            LogUtil.i("LanDirectConnector", (Object) "传入的device不合法");
            return false;
        } else {
            try {
                StarrynetApiImpl.getConnectImpl().onLanGoConnected(i, str, stDevice);
                this.connectDevices.put(stDevice.getIdentifier2String(), stDevice);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    /* access modifiers changed from: private */
    public void doFinishDisConnect(StDevice stDevice) {
        LogUtil.i("LanDirectConnector", (Object) "开始断开连接--onLanDisconnected");
        StarrynetApiImpl.getConnectImpl().onLanDisconnected(stDevice);
        StDevice remove = this.connectDevices.remove(stDevice.getIdentifier2String());
        if (remove == null) {
            LogUtil.d("LanDirectConnector", (Object) "不存在连接的设备！！！！");
        } else if (stDevice.getTerminalType() != 7 && stDevice.getTerminalType() != 10) {
            LogUtil.d("LanDirectConnector", (Object) "对端非HUD/WIN-PAD设备，不重连");
        } else if (StarryNetData.getInstance().getOwnDevice().getTerminalType() != 3) {
            LogUtil.d("LanDirectConnector", (Object) "本端非CSD设备，不重连");
        } else if (!hasMessage(7, remove)) {
            nextConnect(remove);
        }
    }

    private boolean equals(@NonNull StDevice stDevice, @NonNull StDevice stDevice2) {
        return stDevice.getPort() == stDevice2.getPort() && TextUtils.equals(stDevice.getIpAddress(), stDevice2.getIpAddress());
    }

    public static synchronized LanDirectConnector getInstance() {
        LanDirectConnector lanDirectConnector;
        synchronized (LanDirectConnector.class) {
            lanDirectConnector = directConnector;
        }
        return lanDirectConnector;
    }

    private boolean hasMessage(int i, StDevice stDevice) {
        try {
            Method declaredMethod = Handler.class.getDeclaredMethod("hasEqualMessages", new Class[]{Integer.TYPE, Object.class});
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(this.selfHandler, new Object[]{Integer.valueOf(i), stDevice});
            LogUtil.d("LanDirectConnector", (Object) "hasEqualMessages =" + invoke);
            return invoke != null && ((Boolean) invoke).booleanValue();
        } catch (Throwable th) {
            LogUtil.d("LanDirectConnector", (Object) "hasEqualMessages e=" + th.getMessage());
            return false;
        }
    }

    private boolean isDeviceValid(StDevice stDevice) {
        return (stDevice == null || stDevice.getIdentifier2String() == null) ? false : true;
    }

    private boolean isReachable(StDevice stDevice, int i) {
        return true;
    }

    /* access modifiers changed from: private */
    public void listenLife() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(SysActionManager.ACTION_USER_SWITCHED);
        StarryNetData.getInstance().getApplicationContext().registerReceiver(new BroadcastReceiver(SysActionManager.ACTION_USER_SWITCHED) {
            /* access modifiers changed from: private */
            public /* synthetic */ void lambda$onReceive$0() {
                LogUtil.i("LanDirectConnector", (Object) "User Switched!");
                LanDirectConnector.this.selfHandler.sendEmptyMessage(2);
            }

            public void onReceive(Context context, Intent intent) {
                if (SysActionManager.ACTION_USER_SWITCHED.equals(intent.getAction())) {
                    CommonThreadPool.execute(new a(this));
                }
            }
        }, intentFilter);
    }

    private void nextConnect(StDevice stDevice) {
        Message obtain = Message.obtain();
        obtain.obj = stDevice;
        obtain.what = 7;
        this.selfHandler.sendMessageDelayed(obtain, 5000);
    }

    /* access modifiers changed from: private */
    public void recoverConnect() {
        this.isPause = false;
        if (this.connectDevices.size() == 0 && this.cacheDevices.size() > 0) {
            for (Map.Entry<String, StDevice> value : this.cacheDevices.entrySet()) {
                connect((StDevice) value.getValue());
            }
        }
    }

    private void removeMessage(int i, StDevice stDevice) {
        try {
            Method declaredMethod = Handler.class.getDeclaredMethod("removeEqualMessages", new Class[]{Integer.TYPE, Object.class});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this.selfHandler, new Object[]{Integer.valueOf(i), stDevice});
            LogUtil.d("LanDirectConnector", (Object) "removeEqualMessages success");
        } catch (Throwable th) {
            th.printStackTrace();
            LogUtil.d("LanDirectConnector", (Object) "removeEqualMessages fail e=" + th.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public void switchUser() {
        if (!this.isPause) {
            this.isPause = true;
            if (this.connectDevices.size() > 0) {
                this.cacheDevices.clear();
                this.cacheDevices.putAll(this.connectDevices);
                for (Map.Entry<String, StDevice> value : this.connectDevices.entrySet()) {
                    StarrynetApiImpl.getConnectImpl().onLanDisconnected((StDevice) value.getValue());
                }
                this.connectDevices.clear();
            }
        } else {
            recoverConnect();
        }
        if (this.isPause) {
            this.selfHandler.sendEmptyMessageDelayed(5, 40000);
        } else {
            this.selfHandler.removeMessages(5);
        }
    }

    public void finishConnectGc(StDevice stDevice) {
        Message obtain = Message.obtain();
        obtain.obj = stDevice;
        obtain.what = 4;
        this.selfHandler.sendMessage(obtain);
    }

    public boolean finishConnectGo(Channel channel, StDevice stDevice) {
        SocketAddress remoteAddress = channel != null ? channel.remoteAddress() : null;
        if (remoteAddress == null || !(remoteAddress instanceof InetSocketAddress)) {
            LogUtil.i("LanDirectConnector", (Object) "HUD 异常 无法获取远程Host信息");
            return false;
        }
        InetSocketAddress inetSocketAddress = (InetSocketAddress) remoteAddress;
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null || !(address instanceof Inet4Address)) {
            LogUtil.i("LanDirectConnector", (Object) "HUD 异常 协议栈非IPv4");
            return false;
        }
        Message obtain = Message.obtain();
        Object[] objArr = {Integer.valueOf(inetSocketAddress.getPort()), address.getHostAddress(), stDevice, Boolean.FALSE};
        obtain.obj = objArr;
        obtain.what = 3;
        LanDirectConnector lanDirectConnector = directConnector;
        synchronized (lanDirectConnector) {
            this.selfHandler.sendMessage(obtain);
            try {
                long nanoTime = System.nanoTime();
                lanDirectConnector.wait(9500);
                LogUtil.i("LanDirectConnector", (Object) "等待返回结果结束,用时->>" + ((System.nanoTime() - nanoTime) / 1000000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return ((Boolean) objArr[3]).booleanValue();
    }

    public void finishDisConnect(StDevice stDevice) {
        Message obtain = Message.obtain();
        obtain.obj = stDevice;
        obtain.what = 6;
        this.selfHandler.sendMessage(obtain);
    }

    public String getStatus() {
        return "cache:" + this.cacheDevices.size() + " connected:" + this.connectDevices.size();
    }
}
