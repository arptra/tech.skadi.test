package com.upuphone.xr.sapp.vu.arspace;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.upuphone.xr.sapp.vu.arspace.IArSpaceBridger;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ArSpaceMockService extends Service {

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentHashMap f8053a = new ConcurrentHashMap();
    public final ConcurrentHashMap b = new ConcurrentHashMap();
    public final ConcurrentHashMap c = new ConcurrentHashMap();
    public final ConcurrentHashMap d = new ConcurrentHashMap();
    public final ConcurrentHashMap e = new ConcurrentHashMap();
    public final ConcurrentHashMap f = new ConcurrentHashMap();
    public int g = 10;
    public int h = 0;

    public class ArSpaceBridgerImpl extends IArSpaceBridger.Stub {
        public ArSpaceBridgerImpl() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$addOnBrightnessChangeListener$1(IOnBrightnessChangeListener iOnBrightnessChangeListener) {
            ArSpaceMockService.this.f8053a.remove(iOnBrightnessChangeListener);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$addOnDofModeChangeListener$3(IOnDofModeChangeListener iOnDofModeChangeListener) {
            ArSpaceMockService.this.b.remove(iOnDofModeChangeListener);
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$setBrightness$0(int i, IOnBrightnessChangeListener iOnBrightnessChangeListener, IBinder.DeathRecipient deathRecipient) {
            try {
                iOnBrightnessChangeListener.onBrightnessChange(i);
            } catch (RemoteException e) {
                Log.e("ArSpaceMockService", "setBrightness: ", e);
            }
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$setDofMode$2(int i, IOnDofModeChangeListener iOnDofModeChangeListener, IBinder.DeathRecipient deathRecipient) {
            try {
                iOnDofModeChangeListener.onDofModeChanged(i);
            } catch (RemoteException e) {
                Log.e("ArSpaceMockService", "setDofMode: ", e);
            }
        }

        public void addOnBrightnessChangeListener(IOnBrightnessChangeListener iOnBrightnessChangeListener) {
            b bVar = new b(this, iOnBrightnessChangeListener);
            ArSpaceMockService.this.f8053a.put(iOnBrightnessChangeListener, bVar);
            try {
                iOnBrightnessChangeListener.asBinder().linkToDeath(bVar, 0);
            } catch (Exception e) {
                Log.e("ArSpaceMockService", "addOnBrightnessChangeListener: ", e);
            }
        }

        public void addOnCaptureScreenListener(IOnCaptureScreenListener iOnCaptureScreenListener) {
            Log.d("ArSpaceMockService", "addOnCaptureScreenListener: " + iOnCaptureScreenListener);
        }

        public void addOnDofModeChangeListener(IOnDofModeChangeListener iOnDofModeChangeListener) {
            Log.d("ArSpaceMockService", "addOnDofModeChangeListener: $listener");
            c cVar = new c(this, iOnDofModeChangeListener);
            ArSpaceMockService.this.b.put(iOnDofModeChangeListener, cVar);
            try {
                iOnDofModeChangeListener.asBinder().linkToDeath(cVar, 0);
            } catch (RemoteException e) {
                Log.e("ArSpaceMockService", "addOnDofModeChangeListener: ", e);
            }
        }

        public void addOnGlassesWearStateChangeListener(IOnGlassesWearStateChangeListener iOnGlassesWearStateChangeListener) throws RemoteException {
        }

        public void addOnInputTextListener(IOnInputTextListener iOnInputTextListener) {
            Log.d("ArSpaceMockService", "addOnInputTextChangeListener: " + iOnInputTextListener);
        }

        public void addOnKeyListener(IOnKeyListener iOnKeyListener) throws RemoteException {
            Log.d("ArSpaceMockService", "addOnKeyListener: $listener");
        }

        public void addOnRecordScreenListener(IOnRecordScreenListener iOnRecordScreenListener) {
            Log.d("ArSpaceMockService", "addOnRecordScreenListener: " + iOnRecordScreenListener);
        }

        public void addOnRequestChangeLanguageListener(IOnRequestChangeLanguageListener iOnRequestChangeLanguageListener) throws RemoteException {
        }

        public void addOnRequestExitArSpaceListener(IOnRequestExitArSpaceListener iOnRequestExitArSpaceListener) {
            Log.d("ArSpaceMockService", "addOnRequestExitArSpaceListener: $listener");
        }

        public void addOnRequestPermissionResultListener(IOnRequestPermissionResultListener iOnRequestPermissionResultListener) throws RemoteException {
        }

        public void captureScreen() {
            Log.d("ArSpaceMockService", "captureScreen");
        }

        public void checkUrl(String str, IOnCheckUrlResultListener iOnCheckUrlResultListener) throws RemoteException {
            Log.d("ArSpaceMockService", "checkUrl: $url, $listener");
            iOnCheckUrlResultListener.onResult(-1);
        }

        public void endInputText() {
            Log.d("ArSpaceMockService", "endInputText");
        }

        public void endScreenRecord() {
            Log.d("ArSpaceMockService", "endScreenRecord");
        }

        public int getBrightness() {
            return ArSpaceMockService.this.g;
        }

        public int getDofMode() {
            Log.d("ArSpaceMockService", "getDofMode");
            return ArSpaceMockService.this.h;
        }

        public String getLanguage() throws RemoteException {
            return "zh-CN";
        }

        public int getMaxBrightness() {
            return 20;
        }

        public int getMinBrightness() {
            return 0;
        }

        public boolean isGlassesWorn() throws RemoteException {
            return true;
        }

        public void onExitArSpace() {
            Log.d("ArSpaceMockService", "onExitArSpace");
        }

        public void removeOnBrightnessChangeListener(IOnBrightnessChangeListener iOnBrightnessChangeListener) {
            IBinder.DeathRecipient deathRecipient = (IBinder.DeathRecipient) ArSpaceMockService.this.f8053a.remove(iOnBrightnessChangeListener);
            if (deathRecipient != null) {
                iOnBrightnessChangeListener.asBinder().unlinkToDeath(deathRecipient, 0);
            }
        }

        public void removeOnCaptureScreenListener(IOnCaptureScreenListener iOnCaptureScreenListener) {
            Log.d("ArSpaceMockService", "removeOnCaptureScreenListener: " + iOnCaptureScreenListener);
        }

        public void removeOnDofModeChangeListener(IOnDofModeChangeListener iOnDofModeChangeListener) {
            Log.d("ArSpaceMockService", "removeOnDofModeChangeListener: " + iOnDofModeChangeListener);
            IBinder.DeathRecipient deathRecipient = (IBinder.DeathRecipient) ArSpaceMockService.this.b.remove(iOnDofModeChangeListener);
            if (deathRecipient != null) {
                iOnDofModeChangeListener.asBinder().unlinkToDeath(deathRecipient, 0);
            }
        }

        public void removeOnGlassesWearStateChangeListener(IOnGlassesWearStateChangeListener iOnGlassesWearStateChangeListener) throws RemoteException {
        }

        public void removeOnInputTextListener(IOnInputTextListener iOnInputTextListener) {
            Log.d("ArSpaceMockService", "removeOnInputTextChangeListener: " + iOnInputTextListener);
        }

        public void removeOnKeyListener(IOnKeyListener iOnKeyListener) throws RemoteException {
            Log.d("ArSpaceMockService", "removeOnKeyListener: $listener");
        }

        public void removeOnRecordScreenListener(IOnRecordScreenListener iOnRecordScreenListener) {
            Log.d("ArSpaceMockService", "removeOnRecordScreenListener: " + iOnRecordScreenListener);
        }

        public void removeOnRequestChangeLanguageListener(IOnRequestChangeLanguageListener iOnRequestChangeLanguageListener) throws RemoteException {
        }

        public void removeOnRequestExitArSpaceListener(IOnRequestExitArSpaceListener iOnRequestExitArSpaceListener) {
            Log.d("ArSpaceMockService", "removeOnRequestExitArSpaceListener: $listener");
        }

        public void removeOnRequestPermissionResultListener(IOnRequestPermissionResultListener iOnRequestPermissionResultListener) throws RemoteException {
        }

        public void reportEvent(String str, Map map) {
        }

        public void requestData(String str, IOnDataResultListener iOnDataResultListener) {
            Log.d("ArSpaceMockService", "requestData: $type, $listener");
            if (VuiModelType.WEATHER.equals(str)) {
                try {
                    iOnDataResultListener.onResult(VuiModelType.WEATHER, 0, "{\n    \"areaName\": \"徐汇区\",    \n    \"dayTempMax\": 21,       \n    \"dayTempMin\": 15,       \n    \"futureDay\": [          \n        {\n            \"date\": \"2024-04-11\",\n            \"dayTempMax\": 21,\n            \"dayTempMin\": 15,\n            \"iconCode\": \"2\",\n            \"weather\": \"阴\"\n        },\n        {\n            \"date\": \"2024-04-12\",\n            \"dayTempMax\": 19,\n            \"dayTempMin\": 15,\n            \"iconCode\": \"7\",\n            \"weather\": \"小雨\"\n        },\n        {\n            \"date\": \"2024-04-13\",\n            \"dayTempMax\": 22,\n            \"dayTempMin\": 16,\n            \"iconCode\": \"2\",\n            \"weather\": \"阴\"\n        },\n        {\n            \"date\": \"2024-04-14\",\n            \"dayTempMax\": 20,\n            \"dayTempMin\": 16,\n            \"iconCode\": \"7\",\n            \"weather\": \"小雨\"\n        },\n        {\n            \"date\": \"2024-04-15\",\n            \"dayTempMax\": 24,\n            \"dayTempMin\": 16,\n            \"iconCode\": \"2\",\n            \"weather\": \"阴\"\n        },\n        {\n            \"date\": \"2024-04-16\",\n            \"dayTempMax\": 22,\n            \"dayTempMin\": 13,\n            \"iconCode\": \"2\",\n            \"weather\": \"阴\"\n        },\n        {\n            \"date\": \"2024-04-17\",\n            \"dayTempMax\": 21,\n            \"dayTempMin\": 13,\n            \"iconCode\": \"1\",\n            \"weather\": \"多云\"\n        }\n    ],\n    \"iconCode\": \"1\",        \n    \"lastUpdate\": \"2024-04-11 13:55:08\",\n    \"sunriseTime\": \"2024-04-11 05:31:00\",    \n    \"sunsetTime\": \"2024-04-11 18:20:00\",     \n    \"temp\": 21,            \n    \"weather\": \"多云\"      \n}");
                } catch (RemoteException e) {
                    Log.e("ArSpaceMockService", "requestData: ", e);
                }
            } else if ("sport".equals(str)) {
                try {
                    iOnDataResultListener.onResult("sport", 0, "{\n    \"steps\": 1000,\n    \"calories\": 100,\n    \"distance\": 1\n}");
                } catch (RemoteException e2) {
                    Log.e("ArSpaceMockService", "requestData: ", e2);
                }
            } else {
                try {
                    iOnDataResultListener.onResult(str, -1, "");
                } catch (Exception e3) {
                    Log.e("ArSpaceMockService", "requestData: ", e3);
                }
            }
        }

        public void requestPermission(String str, String str2, String str3, String[] strArr) throws RemoteException {
        }

        public void setBrightness(int i) {
            Log.d("ArSpaceMockService", "setBrightness: " + i);
            int a2 = ArSpaceMockService.this.g;
            ArSpaceMockService.this.g = i;
            if (a2 != i) {
                ArSpaceMockService.this.f8053a.forEach(new d(i));
            }
        }

        public void setDofMode(int i) {
            Log.d("ArSpaceMockService", "setDofMode: " + i);
            int b = ArSpaceMockService.this.h;
            ArSpaceMockService.this.h = i;
            if (b != i) {
                ArSpaceMockService.this.b.forEach(new a(i));
            }
        }

        public void startInputText(EditTextInfo editTextInfo) {
            Log.d("ArSpaceMockService", "startInputText: $info");
        }

        public void startScreenRecord() {
            Log.d("ArSpaceMockService", "startScreenRecord");
        }
    }

    public IBinder onBind(Intent intent) {
        return new ArSpaceBridgerImpl();
    }

    public void onCreate() {
        super.onCreate();
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
