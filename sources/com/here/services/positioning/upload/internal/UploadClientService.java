package com.here.services.positioning.upload.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.here.odnp.posclient.IPosClientManager;
import com.here.odnp.posclient.upload.IUploadSession;
import com.here.odnp.util.Log;
import com.here.posclient.upload.UploadListener;
import com.here.posclient.upload.UploadUtils;
import com.here.services.internal.IBoundService;
import com.here.services.positioning.upload.internal.IUploadClient;

public class UploadClientService extends IUploadClient.Stub implements IBoundService {
    private static final String TAG = "services.positioning.upload.internal.UploadClientService";
    private ListenerBridge mListenerBridge;
    private final IUploadSession mSession;

    public static class ListenerBridge implements UploadListener {
        private UploadListener mListener;

        public ListenerBridge(UploadListener uploadListener) {
            this.mListener = uploadListener;
        }

        public void onUploadDataAvailable(int i) {
            Log.i(UploadClientService.TAG, "onUploadDataAvailable, delay: " + i, new Object[0]);
        }

        public void onUploadFailed() {
            Log.i(UploadClientService.TAG, "onUploadFailed", new Object[0]);
            UploadListener uploadListener = this.mListener;
            if (uploadListener != null) {
                try {
                    uploadListener.onUploadFailed();
                } catch (RemoteException unused) {
                    this.mListener = null;
                }
            }
        }

        public void onUploaded() {
            Log.i(UploadClientService.TAG, "onUploaded", new Object[0]);
            UploadListener uploadListener = this.mListener;
            if (uploadListener != null) {
                try {
                    uploadListener.onUploaded();
                } catch (RemoteException unused) {
                    this.mListener = null;
                }
            }
        }
    }

    public UploadClientService(IPosClientManager iPosClientManager, Intent intent) {
        Log.i(TAG, "UploadClientService", new Object[0]);
        if (iPosClientManager != null) {
            this.mSession = iPosClientManager.createUploadSession();
            return;
        }
        throw new IllegalArgumentException("posClientManager is null");
    }

    public void cancelUpload() throws RemoteException {
        Log.i(TAG, "cancelUpload", new Object[0]);
        this.mSession.cancelUpload();
    }

    public int subscribe(UploadListener uploadListener) throws RemoteException {
        Log.i(TAG, "subscribe", new Object[0]);
        ListenerBridge listenerBridge = new ListenerBridge(uploadListener);
        this.mListenerBridge = listenerBridge;
        return this.mSession.subscribe(listenerBridge).toInt();
    }

    public void unBind() {
        try {
            if (this.mListenerBridge != null) {
                unsubscribe();
            }
        } catch (RemoteException e) {
            Log.e(TAG, "onUnbind error", e);
        }
    }

    public int unsubscribe() throws RemoteException {
        Log.i(TAG, "unsubscribe", new Object[0]);
        int i = this.mSession.unsubscribe(this.mListenerBridge).toInt();
        this.mListenerBridge = null;
        return i;
    }

    public int upload(Bundle bundle) throws RemoteException {
        Log.i(TAG, "upload", new Object[0]);
        return this.mSession.upload(UploadUtils.uploadOptionsFromBundle(bundle)).toInt();
    }
}
