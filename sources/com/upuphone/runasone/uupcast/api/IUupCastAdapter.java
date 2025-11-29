package com.upuphone.runasone.uupcast.api;

import com.google.gson.Gson;

public final class IUupCastAdapter {
    private final IUupCast adaptee;
    private final Gson gson = new Gson();

    public IUupCastAdapter(IUupCast iUupCast) {
        this.adaptee = iUupCast;
    }

    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r9v1, types: [com.upuphone.runasone.uupcast.api.ISinkAudioListener] */
    /* JADX WARNING: type inference failed for: r9v3, types: [com.upuphone.runasone.uupcast.api.ISinkListener] */
    /* JADX WARNING: type inference failed for: r9v5, types: [com.upuphone.runasone.uupcast.api.IDisplayListener] */
    /* JADX WARNING: type inference failed for: r9v7, types: [com.upuphone.runasone.uupcast.api.IDisplayListener] */
    /* JADX WARNING: type inference failed for: r9v9 */
    /* JADX WARNING: type inference failed for: r9v10 */
    /* JADX WARNING: type inference failed for: r9v11 */
    /* JADX WARNING: type inference failed for: r9v12 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void adapt(android.os.Bundle r21, android.os.Bundle r22) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r22
            java.lang.String r3 = "method"
            java.lang.String r3 = r1.getString(r3)
            java.lang.String r4 = "createCastSession"
            boolean r4 = r4.equals(r3)
            java.lang.String r5 = "role"
            java.lang.String r6 = "tag"
            java.lang.String r7 = "result"
            if (r4 == 0) goto L_0x0039
            java.lang.String r3 = "ownerApp"
            java.lang.String r3 = r1.getString(r3)
            java.lang.String r4 = "appUniteCode"
            java.lang.String r4 = r1.getString(r4)
            int r5 = r1.getInt(r5)
            java.lang.String r1 = r1.getString(r6)
            com.upuphone.runasone.uupcast.api.IUupCast r0 = r0.adaptee
            int r0 = r0.createCastSession(r3, r4, r5, r1)
            r2.putInt(r7, r0)
            goto L_0x04ad
        L_0x0039:
            java.lang.String r4 = "registerSyncCallbackCode"
            boolean r4 = r4.equals(r3)
            java.lang.String r8 = "sessionId"
            if (r4 == 0) goto L_0x005c
            int r3 = r1.getInt(r8)
            int r4 = r1.getInt(r5)
            java.lang.String r5 = "syncCallbackCode"
            int r1 = r1.getInt(r5)
            com.upuphone.runasone.uupcast.api.IUupCast r0 = r0.adaptee
            int r0 = r0.registerSyncCallbackCode(r3, r4, r1)
            r2.putInt(r7, r0)
            goto L_0x04ad
        L_0x005c:
            java.lang.String r4 = "registerDisplayListener"
            boolean r4 = r4.equals(r3)
            java.lang.String r5 = "packageName"
            r9 = 0
            java.lang.String r10 = "listener"
            java.lang.String r11 = "id"
            if (r4 == 0) goto L_0x008d
            int r3 = r1.getInt(r11)
            java.lang.String r4 = r1.getString(r5)
            android.os.IBinder r1 = r1.getBinder(r10)
            com.upuphone.hub.Hub r1 = com.upuphone.hub.Hub.Stub.asInterface(r1)
            if (r1 == 0) goto L_0x0082
            com.upuphone.runasone.uupcast.api.IDisplayListenerProxy r9 = new com.upuphone.runasone.uupcast.api.IDisplayListenerProxy
            r9.<init>(r1)
        L_0x0082:
            com.upuphone.runasone.uupcast.api.IUupCast r0 = r0.adaptee
            int r0 = r0.registerDisplayListener(r3, r4, r9)
            r2.putInt(r7, r0)
            goto L_0x04ad
        L_0x008d:
            java.lang.String r4 = "unregisterDisplayListener"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x00b8
            int r3 = r1.getInt(r11)
            java.lang.String r4 = r1.getString(r5)
            android.os.IBinder r1 = r1.getBinder(r10)
            com.upuphone.hub.Hub r1 = com.upuphone.hub.Hub.Stub.asInterface(r1)
            if (r1 == 0) goto L_0x00ad
            com.upuphone.runasone.uupcast.api.IDisplayListenerProxy r9 = new com.upuphone.runasone.uupcast.api.IDisplayListenerProxy
            r9.<init>(r1)
        L_0x00ad:
            com.upuphone.runasone.uupcast.api.IUupCast r0 = r0.adaptee
            int r0 = r0.unregisterDisplayListener(r3, r4, r9)
            r2.putInt(r7, r0)
            goto L_0x04ad
        L_0x00b8:
            java.lang.String r4 = "startDisplay"
            boolean r4 = r4.equals(r3)
            java.lang.String r12 = "config"
            if (r4 == 0) goto L_0x0101
            int r3 = r1.getInt(r11)
            java.lang.String r4 = r1.getString(r5)
            com.upuphone.runasone.uupcast.api.IUupCastAdapter$1 r5 = new com.upuphone.runasone.uupcast.api.IUupCastAdapter$1
            r5.<init>()
            java.lang.reflect.Type r5 = r5.getType()
            java.lang.String r6 = "deviceid"
            java.lang.String r6 = r1.getString(r6)
            com.google.gson.Gson r8 = r0.gson
            java.lang.Object r5 = r8.fromJson((java.lang.String) r6, (java.lang.reflect.Type) r5)
            com.upuphone.runasone.device.StarryDevice r5 = (com.upuphone.runasone.device.StarryDevice) r5
            com.upuphone.runasone.uupcast.api.IUupCastAdapter$2 r6 = new com.upuphone.runasone.uupcast.api.IUupCastAdapter$2
            r6.<init>()
            java.lang.reflect.Type r6 = r6.getType()
            java.lang.String r1 = r1.getString(r12)
            com.google.gson.Gson r8 = r0.gson
            java.lang.Object r1 = r8.fromJson((java.lang.String) r1, (java.lang.reflect.Type) r6)
            com.upuphone.runasone.uupcast.SourceDisplayConfig r1 = (com.upuphone.runasone.uupcast.SourceDisplayConfig) r1
            com.upuphone.runasone.uupcast.api.IUupCast r0 = r0.adaptee
            int r0 = r0.startDisplay(r3, r4, r5, r1)
            r2.putInt(r7, r0)
            goto L_0x04ad
        L_0x0101:
            java.lang.String r4 = "stopDisplay"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x0118
            int r1 = r1.getInt(r11)
            com.upuphone.runasone.uupcast.api.IUupCast r0 = r0.adaptee
            int r0 = r0.stopDisplay(r1)
            r2.putInt(r7, r0)
            goto L_0x04ad
        L_0x0118:
            java.lang.String r4 = "stopMultiDisplay"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x0146
            int r3 = r1.getInt(r11)
            com.upuphone.runasone.uupcast.api.IUupCastAdapter$3 r4 = new com.upuphone.runasone.uupcast.api.IUupCastAdapter$3
            r4.<init>()
            java.lang.reflect.Type r4 = r4.getType()
            java.lang.String r5 = "device"
            java.lang.String r1 = r1.getString(r5)
            com.google.gson.Gson r5 = r0.gson
            java.lang.Object r1 = r5.fromJson((java.lang.String) r1, (java.lang.reflect.Type) r4)
            com.upuphone.runasone.device.StarryDevice r1 = (com.upuphone.runasone.device.StarryDevice) r1
            com.upuphone.runasone.uupcast.api.IUupCast r0 = r0.adaptee
            int r0 = r0.stopMultiDisplay(r3, r1)
            r2.putInt(r7, r0)
            goto L_0x04ad
        L_0x0146:
            java.lang.String r4 = "resumeSource"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x0161
            int r3 = r1.getInt(r8)
            java.lang.String r1 = r1.getString(r6)
            com.upuphone.runasone.uupcast.api.IUupCast r0 = r0.adaptee
            int r0 = r0.resumeSource(r3, r1)
            r2.putInt(r7, r0)
            goto L_0x04ad
        L_0x0161:
            java.lang.String r4 = "pauseSource"
            boolean r4 = r4.equals(r3)
            java.lang.String r5 = "withAudio"
            if (r4 == 0) goto L_0x0183
            int r3 = r1.getInt(r8)
            java.lang.String r4 = r1.getString(r6)
            boolean r1 = r1.getBoolean(r5)
            com.upuphone.runasone.uupcast.api.IUupCast r0 = r0.adaptee
            int r0 = r0.pauseSource(r3, r4, r1)
            r2.putInt(r7, r0)
            goto L_0x04ad
        L_0x0183:
            java.lang.String r4 = "getDisplayState"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x019a
            int r1 = r1.getInt(r11)
            com.upuphone.runasone.uupcast.api.IUupCast r0 = r0.adaptee
            int r0 = r0.getDisplayState(r1)
            r2.putInt(r7, r0)
            goto L_0x04ad
        L_0x019a:
            java.lang.String r4 = "getDisplayID"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x01b1
            int r1 = r1.getInt(r11)
            com.upuphone.runasone.uupcast.api.IUupCast r0 = r0.adaptee
            int r0 = r0.getDisplayID(r1)
            r2.putInt(r7, r0)
            goto L_0x04ad
        L_0x01b1:
            java.lang.String r4 = "setUIBCChannel"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x01d4
            int r3 = r1.getInt(r11)
            java.lang.String r4 = "eventTag"
            java.lang.String r4 = r1.getString(r4)
            java.lang.String r5 = "displayid"
            int r1 = r1.getInt(r5)
            com.upuphone.runasone.uupcast.api.IUupCast r0 = r0.adaptee
            int r0 = r0.setUIBCChannel(r3, r4, r1)
            r2.putInt(r7, r0)
            goto L_0x04ad
        L_0x01d4:
            java.lang.String r4 = "enableAudioPolicy"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x01f1
            int r3 = r1.getInt(r8)
            java.lang.String r4 = "audioPolicy"
            int r1 = r1.getInt(r4)
            com.upuphone.runasone.uupcast.api.IUupCast r0 = r0.adaptee
            int r0 = r0.enableAudioPolicy(r3, r1)
            r2.putInt(r7, r0)
            goto L_0x04ad
        L_0x01f1:
            java.lang.String r4 = "enableRecordPhoneCallRing"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x020e
            int r3 = r1.getInt(r8)
            java.lang.String r4 = "enable"
            boolean r1 = r1.getBoolean(r4)
            com.upuphone.runasone.uupcast.api.IUupCast r0 = r0.adaptee
            int r0 = r0.enableRecordPhoneCallRing(r3, r1)
            r2.putInt(r7, r0)
            goto L_0x04ad
        L_0x020e:
            java.lang.String r4 = "sourceCheckFeatureSupported"
            boolean r4 = r4.equals(r3)
            java.lang.String r8 = "feature"
            if (r4 == 0) goto L_0x023e
            com.upuphone.runasone.uupcast.api.IUupCastAdapter$4 r3 = new com.upuphone.runasone.uupcast.api.IUupCastAdapter$4
            r3.<init>()
            java.lang.reflect.Type r3 = r3.getType()
            java.lang.String r4 = "deviceId"
            java.lang.String r4 = r1.getString(r4)
            com.google.gson.Gson r5 = r0.gson
            java.lang.Object r3 = r5.fromJson((java.lang.String) r4, (java.lang.reflect.Type) r3)
            com.upuphone.runasone.device.StarryDevice r3 = (com.upuphone.runasone.device.StarryDevice) r3
            java.lang.String r1 = r1.getString(r8)
            com.upuphone.runasone.uupcast.api.IUupCast r0 = r0.adaptee
            int r0 = r0.sourceCheckFeatureSupported(r3, r1)
            r2.putInt(r7, r0)
            goto L_0x04ad
        L_0x023e:
            java.lang.String r4 = "setDisplaySinkSurface"
            boolean r4 = r4.equals(r3)
            java.lang.String r13 = "surface"
            if (r4 == 0) goto L_0x025d
            int r3 = r1.getInt(r11)
            android.os.Parcelable r1 = r1.getParcelable(r13)
            android.view.Surface r1 = (android.view.Surface) r1
            com.upuphone.runasone.uupcast.api.IUupCast r0 = r0.adaptee
            int r0 = r0.setDisplaySinkSurface(r3, r1)
            r2.putInt(r7, r0)
            goto L_0x04ad
        L_0x025d:
            java.lang.String r4 = "setDisplaySinkConfig"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x0289
            int r3 = r1.getInt(r11)
            com.upuphone.runasone.uupcast.api.IUupCastAdapter$5 r4 = new com.upuphone.runasone.uupcast.api.IUupCastAdapter$5
            r4.<init>()
            java.lang.reflect.Type r4 = r4.getType()
            java.lang.String r1 = r1.getString(r12)
            com.google.gson.Gson r5 = r0.gson
            java.lang.Object r1 = r5.fromJson((java.lang.String) r1, (java.lang.reflect.Type) r4)
            com.upuphone.runasone.uupcast.SinkDisplayConfig r1 = (com.upuphone.runasone.uupcast.SinkDisplayConfig) r1
            com.upuphone.runasone.uupcast.api.IUupCast r0 = r0.adaptee
            int r0 = r0.setDisplaySinkConfig(r3, r1)
            r2.putInt(r7, r0)
            goto L_0x04ad
        L_0x0289:
            java.lang.String r4 = "registerSinkListener"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x02af
            int r3 = r1.getInt(r11)
            android.os.IBinder r1 = r1.getBinder(r10)
            com.upuphone.hub.Hub r1 = com.upuphone.hub.Hub.Stub.asInterface(r1)
            if (r1 == 0) goto L_0x02a4
            com.upuphone.runasone.uupcast.api.ISinkListenerProxy r9 = new com.upuphone.runasone.uupcast.api.ISinkListenerProxy
            r9.<init>(r1)
        L_0x02a4:
            com.upuphone.runasone.uupcast.api.IUupCast r0 = r0.adaptee
            int r0 = r0.registerSinkListener(r3, r9)
            r2.putInt(r7, r0)
            goto L_0x04ad
        L_0x02af:
            java.lang.String r4 = "unregisterSinkListener"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x02c7
            int r1 = r1.getInt(r11)
            com.upuphone.runasone.uupcast.api.IUupCast r0 = r0.adaptee
            int r0 = r0.unregisterSinkListener(r1)
            r2.putInt(r7, r0)
            goto L_0x04ad
        L_0x02c7:
            java.lang.String r4 = "displaySinkStart"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x02de
            int r1 = r1.getInt(r11)
            com.upuphone.runasone.uupcast.api.IUupCast r0 = r0.adaptee
            int r0 = r0.displaySinkStart(r1)
            r2.putInt(r7, r0)
            goto L_0x04ad
        L_0x02de:
            java.lang.String r4 = "displaySinkStop"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x02f5
            int r1 = r1.getInt(r11)
            com.upuphone.runasone.uupcast.api.IUupCast r0 = r0.adaptee
            int r0 = r0.displaySinkStop(r1)
            r2.putInt(r7, r0)
            goto L_0x04ad
        L_0x02f5:
            java.lang.String r4 = "uibcKeyEvent"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x031d
            int r3 = r1.getInt(r11)
            java.lang.String r4 = r1.getString(r6)
            java.lang.String r5 = "action"
            int r5 = r1.getInt(r5)
            java.lang.String r6 = "keycode"
            int r1 = r1.getInt(r6)
            com.upuphone.runasone.uupcast.api.IUupCast r0 = r0.adaptee
            int r0 = r0.uibcKeyEvent(r3, r4, r5, r1)
            r2.putInt(r7, r0)
            goto L_0x04ad
        L_0x031d:
            java.lang.String r4 = "uibcTouchEvent"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x0350
            int r15 = r1.getInt(r11)
            java.lang.String r16 = r1.getString(r6)
            java.lang.String r3 = "width"
            int r17 = r1.getInt(r3)
            java.lang.String r3 = "high"
            int r18 = r1.getInt(r3)
            java.lang.String r3 = "event"
            android.os.Parcelable r1 = r1.getParcelable(r3)
            r19 = r1
            android.view.MotionEvent r19 = (android.view.MotionEvent) r19
            com.upuphone.runasone.uupcast.api.IUupCast r14 = r0.adaptee
            int r0 = r14.uibcTouchEvent(r15, r16, r17, r18, r19)
            r2.putInt(r7, r0)
            goto L_0x04ad
        L_0x0350:
            java.lang.String r4 = "uibcCustomEvent"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x036e
            int r3 = r1.getInt(r11)
            java.lang.String r4 = "message"
            java.lang.String r1 = r1.getString(r4)
            com.upuphone.runasone.uupcast.api.IUupCast r0 = r0.adaptee
            int r0 = r0.uibcCustomEvent(r3, r1)
            r2.putInt(r7, r0)
            goto L_0x04ad
        L_0x036e:
            java.lang.String r4 = "getSinkDisplayConfig"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x038b
            int r1 = r1.getInt(r11)
            com.upuphone.runasone.uupcast.api.IUupCast r3 = r0.adaptee
            com.upuphone.runasone.uupcast.SinkDisplayConfig r1 = r3.getSinkDisplayConfig(r1)
            com.google.gson.Gson r0 = r0.gson
            java.lang.String r0 = r0.toJson((java.lang.Object) r1)
            r2.putString(r7, r0)
            goto L_0x04ad
        L_0x038b:
            java.lang.String r4 = "displaySinkPause"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x03aa
            int r3 = r1.getInt(r11)
            java.lang.String r4 = r1.getString(r6)
            boolean r1 = r1.getBoolean(r5)
            com.upuphone.runasone.uupcast.api.IUupCast r0 = r0.adaptee
            int r0 = r0.displaySinkPause(r3, r4, r1)
            r2.putInt(r7, r0)
            goto L_0x04ad
        L_0x03aa:
            java.lang.String r4 = "displaySinkResume"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x03c5
            int r3 = r1.getInt(r11)
            java.lang.String r1 = r1.getString(r6)
            com.upuphone.runasone.uupcast.api.IUupCast r0 = r0.adaptee
            int r0 = r0.displaySinkResume(r3, r1)
            r2.putInt(r7, r0)
            goto L_0x04ad
        L_0x03c5:
            java.lang.String r4 = "displaySinkSetOutputSurface"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x03e6
            int r3 = r1.getInt(r11)
            android.os.Parcelable r4 = r1.getParcelable(r13)
            android.view.Surface r4 = (android.view.Surface) r4
            java.lang.String r1 = r1.getString(r6)
            com.upuphone.runasone.uupcast.api.IUupCast r0 = r0.adaptee
            int r0 = r0.displaySinkSetOutputSurface(r3, r4, r1)
            r2.putInt(r7, r0)
            goto L_0x04ad
        L_0x03e6:
            java.lang.String r4 = "displaySinkAddVirtualDisplay"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x0418
            int r3 = r1.getInt(r11)
            android.os.Parcelable r4 = r1.getParcelable(r13)
            android.view.Surface r4 = (android.view.Surface) r4
            com.upuphone.runasone.uupcast.api.IUupCastAdapter$6 r5 = new com.upuphone.runasone.uupcast.api.IUupCastAdapter$6
            r5.<init>()
            java.lang.reflect.Type r5 = r5.getType()
            java.lang.String r1 = r1.getString(r12)
            com.google.gson.Gson r6 = r0.gson
            java.lang.Object r1 = r6.fromJson((java.lang.String) r1, (java.lang.reflect.Type) r5)
            com.upuphone.runasone.uupcast.SinkDisplayConfig r1 = (com.upuphone.runasone.uupcast.SinkDisplayConfig) r1
            com.upuphone.runasone.uupcast.api.IUupCast r0 = r0.adaptee
            int r0 = r0.displaySinkAddVirtualDisplay(r3, r4, r1)
            r2.putInt(r7, r0)
            goto L_0x04ad
        L_0x0418:
            java.lang.String r4 = "displaySinkRemoveVirtualDisplay"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x0433
            int r3 = r1.getInt(r11)
            java.lang.String r1 = r1.getString(r6)
            com.upuphone.runasone.uupcast.api.IUupCast r0 = r0.adaptee
            int r0 = r0.displaySinkRemoveVirtualDisplay(r3, r1)
            r2.putInt(r7, r0)
            goto L_0x04ad
        L_0x0433:
            java.lang.String r4 = "displaySinkRemoveVirtualDisplayEx"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x0453
            int r3 = r1.getInt(r11)
            java.lang.String r4 = r1.getString(r6)
            java.lang.String r5 = "exdata"
            byte[] r1 = r1.getByteArray(r5)
            com.upuphone.runasone.uupcast.api.IUupCast r0 = r0.adaptee
            int r0 = r0.displaySinkRemoveVirtualDisplayEx(r3, r4, r1)
            r2.putInt(r7, r0)
            goto L_0x04ad
        L_0x0453:
            java.lang.String r4 = "displaySinkSetAudioListener"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x0478
            int r3 = r1.getInt(r11)
            android.os.IBinder r1 = r1.getBinder(r10)
            com.upuphone.hub.Hub r1 = com.upuphone.hub.Hub.Stub.asInterface(r1)
            if (r1 == 0) goto L_0x046e
            com.upuphone.runasone.uupcast.api.ISinkAudioListenerProxy r9 = new com.upuphone.runasone.uupcast.api.ISinkAudioListenerProxy
            r9.<init>(r1)
        L_0x046e:
            com.upuphone.runasone.uupcast.api.IUupCast r0 = r0.adaptee
            int r0 = r0.displaySinkSetAudioListener(r3, r9)
            r2.putInt(r7, r0)
            goto L_0x04ad
        L_0x0478:
            java.lang.String r4 = "displaySinkReclaimAudioFocus"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x0494
            int r3 = r1.getInt(r11)
            java.lang.String r4 = "audioTypeMask"
            int r1 = r1.getInt(r4)
            com.upuphone.runasone.uupcast.api.IUupCast r0 = r0.adaptee
            int r0 = r0.displaySinkReclaimAudioFocus(r3, r1)
            r2.putInt(r7, r0)
            goto L_0x04ad
        L_0x0494:
            java.lang.String r4 = "sinkCheckFeatureSupported"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x04ae
            int r3 = r1.getInt(r11)
            java.lang.String r1 = r1.getString(r8)
            com.upuphone.runasone.uupcast.api.IUupCast r0 = r0.adaptee
            int r0 = r0.sinkCheckFeatureSupported(r3, r1)
            r2.putInt(r7, r0)
        L_0x04ad:
            return
        L_0x04ae:
            java.lang.UnsupportedOperationException r0 = new java.lang.UnsupportedOperationException
            java.lang.String r1 = "target method not found"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.runasone.uupcast.api.IUupCastAdapter.adapt(android.os.Bundle, android.os.Bundle):void");
    }
}
