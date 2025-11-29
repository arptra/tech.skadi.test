package com.upuphone.xr.interconnect.main.dispatcher;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.upuphone.xr.interconnect.common.IFileReceiver;
import com.upuphone.xr.interconnect.entity.StarryNetFile;
import com.upuphone.xr.interconnect.util.DeDuplicateCopyOnWriteArrayList;
import com.upuphone.xr.interconnect.util.ExceptionLogUtil;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class FileTransportEventDispatcherImpl implements FileReceiverManager, FileTransportEventDispatcher {
    private static final String TAG = "FileTransportEventDispatcherImpl";
    private final Map<String, List<IFileReceiver>> mFileReceiversMap = new HashMap();

    public void addReceiver(@NonNull String str, @NonNull IFileReceiver iFileReceiver) {
        List list = this.mFileReceiversMap.get(str);
        if (list == null) {
            list = new DeDuplicateCopyOnWriteArrayList();
            this.mFileReceiversMap.put(str, list);
        }
        list.add(iFileReceiver);
        ILog.d(TAG, "模块--" + str + "注册文件接收器，接收器列表--" + this.mFileReceiversMap);
    }

    public void dispatchFailEvent(String str, String str2, int i) {
        List<IFileReceiver> list = this.mFileReceiversMap.get(str);
        if (list == null) {
            ILog.d(TAG, "未找到任何文件接收器处理fail事件");
            return;
        }
        for (IFileReceiver onFail : list) {
            try {
                onFail.onFail(str2, i);
            } catch (RemoteException e) {
                ExceptionLogUtil.print(TAG, e, "IFileReceiver", "onFail");
            }
        }
    }

    public void dispatchProgressChangedEvent(String str, String str2, int i) {
        List<IFileReceiver> list = this.mFileReceiversMap.get(str);
        if (list == null) {
            ILog.d(TAG, "未找到任何文件接收器处理progress change事件");
            return;
        }
        for (IFileReceiver onProgressChanged : list) {
            try {
                onProgressChanged.onProgressChanged(str2, i);
            } catch (RemoteException e) {
                ExceptionLogUtil.print(TAG, e, "IFileReceiver", "onProgressChanged");
            }
        }
    }

    public void dispatchStartEvent(String str, String str2, StarryNetFile starryNetFile) {
        List<IFileReceiver> list = this.mFileReceiversMap.get(str);
        if (list == null) {
            ILog.d(TAG, "未找到任何文件接收器处理start事件");
            return;
        }
        for (IFileReceiver onStart : list) {
            try {
                onStart.onStart(str2, starryNetFile);
            } catch (RemoteException e) {
                ExceptionLogUtil.print(TAG, e, "IFileReceiver", "onStart");
            }
        }
    }

    public void dispatchSuccessEvent(String str, String str2, String str3) {
        List<IFileReceiver> list = this.mFileReceiversMap.get(str);
        if (list == null) {
            ILog.d(TAG, "未找到任何文件接收器处理success事件");
            return;
        }
        for (IFileReceiver onFinish : list) {
            try {
                onFinish.onFinish(str2, str3);
            } catch (RemoteException e) {
                ExceptionLogUtil.print(TAG, e, "IFileReceiver", "onFinish");
            }
        }
    }

    public void removeReceiver(@NonNull String str, @NonNull IFileReceiver iFileReceiver) {
        List list = this.mFileReceiversMap.get(str);
        if (list != null) {
            list.remove(iFileReceiver);
        }
        ILog.d(TAG, "模块--" + str + "解注册文件接收器，接收器列表--" + this.mFileReceiversMap);
    }
}
