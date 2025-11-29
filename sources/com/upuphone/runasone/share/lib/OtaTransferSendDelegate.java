package com.upuphone.runasone.share.lib;

import android.net.Uri;
import com.honey.account.m6.d;
import com.upuphone.runasone.share.api.IHubUupShareStatusCallback;
import com.upuphone.runasone.share.lib.utils.LogUtil;
import com.upuphone.runasone.share.lib.utils.Utils;
import com.upuphone.starrynet.tracker.StTracker;
import com.upuphone.starryshare.SenderService;
import com.upuphone.starryshare.bean.FileInfo;
import com.upuphone.starryshare.listener.IOtaShareListener;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class OtaTransferSendDelegate {
    public static final int SEND_TO_RECEIVER = 2;
    public static final String TAG = "OtaTransferSendDelegate";
    /* access modifiers changed from: private */
    public TransferHandler handler;
    private final Map<String, String> senderStorageMap;
    /* access modifiers changed from: private */
    public final Map<String, SenderService> senders;
    /* access modifiers changed from: private */
    public final Map<String, Uri[]> sourceUri;
    private final Map<String, Long> startSendTimeMap;

    public static class SingleTon {
        /* access modifiers changed from: private */
        public static final OtaTransferSendDelegate OTA_DELEGATE = new OtaTransferSendDelegate();

        private SingleTon() {
        }
    }

    public static OtaTransferSendDelegate getIntense() {
        return SingleTon.OTA_DELEGATE;
    }

    /* access modifiers changed from: private */
    public IHubUupShareStatusCallback getSendCallback(String str) {
        return UupShare.getInstance().mService.getCallbackByTaskId(str, 2);
    }

    public void callBackStart(String str, String str2) {
        LogUtil.i(TAG, "sender callBackStart:" + str);
        try {
            getSendCallback(str).onStart(str, str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        TransferHandler transferHandler = this.handler;
        transferHandler.sendMessageDelayed(transferHandler.obtainMessage(1, str), 30000);
    }

    public void cancel(String str) {
        SenderService senderService = this.senders.get(str);
        if (senderService != null) {
            LogUtil.i(TAG, "cancel " + str);
            senderService.e(str);
            this.senders.remove(str);
            this.sourceUri.remove(str);
        }
    }

    public void connectToServer(String str, String str2, int i) {
        LogUtil.i(TAG, "sender connectToServer");
        SenderService senderService = this.senders.get(str);
        if (senderService != null) {
            senderService.h(str2);
            senderService.i(i);
            senderService.j(str);
            this.senders.put(str, senderService);
        }
    }

    public void disconnect() {
        LogUtil.i(TAG, "sender disconnect");
        if (this.handler.hasMessages(1)) {
            this.handler.removeMessages(1);
        }
        Iterator<Map.Entry<String, SenderService>> it = this.senders.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            SenderService senderService = (SenderService) next.getValue();
            String str = (String) next.getKey();
            if (senderService != null) {
                LogUtil.d(TAG, " disconnect taskId" + str);
                it.remove();
                senderService.e((String) next.getKey());
            } else {
                return;
            }
        }
    }

    public String getFileInfos(String str) {
        Uri[] uriArr = this.sourceUri.get(str);
        if (uriArr == null) {
            return "";
        }
        String str2 = this.senderStorageMap.get(str);
        JSONArray jSONArray = new JSONArray();
        for (Uri uri : uriArr) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("size", new FileInfo(str, uri, UupShareService.getContext()).getSize());
                jSONObject.put("md5", Utils.getMD5Three(uri));
                jSONObject.put("storage", str2);
                jSONArray.put(jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONArray.toString();
    }

    public boolean isInSendMap(String str) {
        return this.senders.containsKey(str);
    }

    public void notifyCancel(String str) {
        try {
            LogUtil.i(TAG, "notifyCancel " + str);
            this.senders.remove(str);
            this.sourceUri.remove(str);
            getSendCallback(str).onFailure(str, false, 3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void notifyTimeOut(String str) {
        try {
            LogUtil.i(TAG, "notifyTimeOut " + str);
            this.senders.remove(str);
            this.sourceUri.remove(str);
            getSendCallback(str).onFailure(str, false, 3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void processReceiverFinishMessage(String str) {
        try {
            if (this.handler.hasMessages(7)) {
                this.handler.removeMessages(7);
            }
            long fileTotalSize = Utils.getInstance().getFileTotalSize(this.sourceUri.get(str));
            getSendCallback(str).onSuccess(str);
            UupShare.getInstance().mService.removeTaskIdInPackageMaps(str);
            this.senders.remove(str);
            this.sourceUri.remove(str);
            LogUtil.i(TAG, "syn receiver finish:" + str);
            HashMap hashMap = new HashMap();
            long currentTimeMillis = System.currentTimeMillis() - this.startSendTimeMap.getOrDefault(str, 0L).longValue();
            hashMap.put(RtspHeaders.Values.TIME, currentTimeMillis + "");
            hashMap.put("taskId", str);
            hashMap.put("size", "" + fileTotalSize);
            StTracker.getInstance().reportEvent("file_transfer_time_size_compare", hashMap);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("taskId", str);
            StTracker.getInstance().reportEvent("file_transfer_success", hashMap2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void processSendSuccessTimeOut(String str) {
        LogUtil.i(TAG, "processSendSuccessTimeOut" + str);
        try {
            LogUtil.i(TAG, "onFailuretaskId" + str + ",errorCode" + 3);
            getSendCallback(str).onFailure(str, true, 3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void putStorage(String str, String str2) {
        this.senderStorageMap.put(str, str2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00cb A[LOOP:1: B:35:0x00c5->B:37:0x00cb, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c0 A[EDGE_INSN: B:40:0x00c0->B:34:0x00c0 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void sendFiles(java.lang.String r14, java.lang.String r15) {
        /*
            r13 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "sendFiles"
            r0.append(r1)
            r0.append(r14)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "OtaTransferSendDelegate"
            com.upuphone.runasone.share.lib.utils.LogUtil.i(r1, r0)
            com.upuphone.runasone.share.lib.TransferHandler r0 = r13.handler
            r2 = 1
            boolean r0 = r0.hasMessages(r2)
            if (r0 == 0) goto L_0x0024
            com.upuphone.runasone.share.lib.TransferHandler r0 = r13.handler
            r0.removeMessages(r2)
        L_0x0024:
            java.util.Map<java.lang.String, android.net.Uri[]> r0 = r13.sourceUri
            boolean r0 = r0.containsKey(r14)
            if (r0 != 0) goto L_0x0033
            java.lang.String r13 = "不包含这个任务"
            com.upuphone.runasone.share.lib.utils.LogUtil.e(r1, r13)
            return
        L_0x0033:
            java.util.Map<java.lang.String, android.net.Uri[]> r0 = r13.sourceUri
            java.lang.Object r0 = r0.get(r14)
            android.net.Uri[] r0 = (android.net.Uri[]) r0
            if (r0 != 0) goto L_0x0044
            java.lang.String r13 = "待传输的文件为空"
            com.upuphone.runasone.share.lib.utils.LogUtil.e(r1, r13)
            return
        L_0x0044:
            java.util.Map<java.lang.String, com.upuphone.starryshare.SenderService> r2 = r13.senders
            java.lang.Object r2 = r2.get(r14)
            com.upuphone.starryshare.SenderService r2 = (com.upuphone.starryshare.SenderService) r2
            if (r2 != 0) goto L_0x0054
            java.lang.String r13 = "sendService 为空"
            com.upuphone.runasone.share.lib.utils.LogUtil.e(r1, r13)
            return
        L_0x0054:
            boolean r3 = android.text.TextUtils.isEmpty(r15)
            if (r3 != 0) goto L_0x0069
            org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0060 }
            r3.<init>(r15)     // Catch:{ JSONException -> 0x0060 }
            goto L_0x006a
        L_0x0060:
            r15 = move-exception
            r15.printStackTrace()
            java.lang.String r15 = "json序列化出错"
            com.upuphone.runasone.share.lib.utils.LogUtil.e(r1, r15)
        L_0x0069:
            r3 = 0
        L_0x006a:
            java.util.Map<java.lang.String, java.lang.String> r15 = r13.senderStorageMap
            java.lang.Object r15 = r15.get(r14)
            java.lang.String r15 = (java.lang.String) r15
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            int r4 = r0.length
            r5 = 0
            r6 = r5
        L_0x007a:
            r7 = 0
            java.lang.String r9 = ""
            if (r5 >= r4) goto L_0x00c0
            r10 = r0[r5]
            if (r3 != 0) goto L_0x0085
            goto L_0x008f
        L_0x0085:
            org.json.JSONObject r7 = r3.optJSONObject(r6)
            java.lang.String r8 = "beginStart"
            long r7 = r7.optLong(r8)
        L_0x008f:
            if (r3 != 0) goto L_0x0092
            goto L_0x009c
        L_0x0092:
            org.json.JSONObject r9 = r3.optJSONObject(r6)
            java.lang.String r11 = "md5"
            java.lang.String r9 = r9.optString(r11)
        L_0x009c:
            boolean r11 = android.text.TextUtils.isEmpty(r9)
            if (r11 == 0) goto L_0x00a6
            java.lang.String r9 = com.upuphone.runasone.share.lib.utils.Utils.getMD5Three(r10)
        L_0x00a6:
            com.upuphone.starryshare.bean.FileInfo r11 = new com.upuphone.starryshare.bean.FileInfo
            android.content.Context r12 = com.upuphone.runasone.share.lib.UupShareService.getContext()
            r11.<init>(r14, r10, r12)
            r11.setBeginOfFile(r7)
            r11.setDesStorage(r15)
            r11.setMd5(r9)
            r1.add(r11)
            int r6 = r6 + 1
            int r5 = r5 + 1
            goto L_0x007a
        L_0x00c0:
            java.util.Iterator r15 = r1.iterator()
            r3 = r7
        L_0x00c5:
            boolean r0 = r15.hasNext()
            if (r0 == 0) goto L_0x00d7
            java.lang.Object r0 = r15.next()
            com.upuphone.starryshare.bean.FileInfo r0 = (com.upuphone.starryshare.bean.FileInfo) r0
            long r5 = r0.getSize()
            long r3 = r3 + r5
            goto L_0x00c5
        L_0x00d7:
            java.util.HashMap r15 = new java.util.HashMap
            r15.<init>()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r3)
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            java.lang.String r3 = "size"
            r15.put(r3, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r3 = r1.size()
            r0.append(r3)
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            java.lang.String r3 = "num"
            r15.put(r3, r0)
            java.lang.String r0 = "taskId"
            r15.put(r0, r14)
            com.upuphone.starrynet.tracker.StTracker r3 = com.upuphone.starrynet.tracker.StTracker.getInstance()
            java.lang.String r4 = "file_transfer_size"
            r3.reportEvent(r4, r15)
            r2.l(r1)
            java.util.Map<java.lang.String, java.lang.Long> r13 = r13.startSendTimeMap
            java.lang.Long r15 = java.lang.Long.valueOf(r7)
            java.lang.Object r13 = r13.getOrDefault(r14, r15)
            java.lang.Long r13 = (java.lang.Long) r13
            long r1 = r13.longValue()
            long r3 = java.lang.System.currentTimeMillis()
            long r3 = r3 - r1
            java.util.HashMap r13 = new java.util.HashMap
            r13.<init>()
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            r15.append(r3)
            r15.append(r9)
            java.lang.String r15 = r15.toString()
            java.lang.String r1 = "time"
            r13.put(r1, r15)
            r13.put(r0, r14)
            com.upuphone.starrynet.tracker.StTracker r14 = com.upuphone.starrynet.tracker.StTracker.getInstance()
            java.lang.String r15 = "file_transfer_pre_cost"
            r14.reportEvent(r15, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.runasone.share.lib.OtaTransferSendDelegate.sendFiles(java.lang.String, java.lang.String):void");
    }

    public void setFiles(Uri[] uriArr, String str) {
        LogUtil.i(TAG, "sender setFiles " + str);
        this.startSendTimeMap.put(str, Long.valueOf(System.currentTimeMillis()));
        HashMap hashMap = new HashMap();
        hashMap.put("taskId", str);
        StTracker.getInstance().reportEvent("file_transfer_start", hashMap);
        this.sourceUri.put(str, uriArr);
        SenderService senderService = new SenderService(UupShareService.getContext());
        senderService.g(new d(str));
        senderService.k(new IOtaShareListener() {
            public void onFailure(String str, boolean z, int i) {
                try {
                    LogUtil.i(OtaTransferSendDelegate.TAG, "onFailuretaskId" + str + ",errorCode" + i);
                    OtaTransferSendDelegate.this.senders.remove(str);
                    OtaTransferSendDelegate.this.sourceUri.remove(str);
                    OtaTransferSendDelegate.this.getSendCallback(str).onFailure(str, z, i);
                    UupShare.getInstance().mService.removeTaskIdInPackageMaps(str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void onFinish(String str, Uri uri, Uri uri2) {
                try {
                    LogUtil.i(OtaTransferSendDelegate.TAG, "onFinishtaskId" + str + ",oldUri:" + uri.getPath() + " ,newUri" + uri2.getPath());
                    OtaTransferSendDelegate.this.getSendCallback(str).onFinish(str, uri, uri2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void onProgressChanged(String str, int i, Uri uri) {
                try {
                    LogUtil.i(OtaTransferSendDelegate.TAG, "onProgressChanged" + i + ",taskId:" + str);
                    OtaTransferSendDelegate.this.getSendCallback(str).onProgressChanged(str, i, uri);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void onStart(String str, String str2) {
                try {
                    OtaTransferSendDelegate.this.getSendCallback(str).onStart(str, str2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void onSuccess(String str) {
                LogUtil.i(OtaTransferSendDelegate.TAG, "onSuccess " + str);
                OtaTransferSendDelegate.this.handler.sendMessageDelayed(OtaTransferSendDelegate.this.handler.obtainMessage(7, str), 30000);
            }
        });
        this.senders.put(str, senderService);
    }

    private OtaTransferSendDelegate() {
        this.handler = new TransferHandler();
        this.sourceUri = new HashMap();
        this.senders = new HashMap();
        this.senderStorageMap = new HashMap();
        this.startSendTimeMap = new HashMap();
    }
}
