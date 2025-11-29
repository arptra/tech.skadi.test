package com.upuphone.ar.translation.phone.helper;

import com.upuphone.ar.translation.TranslationApp;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.interconnect.entity.InterConnectDevice;
import com.upuphone.ar.translation.interconnect.listener.OnDeviceConnectedListener;
import com.upuphone.ar.translation.phone.bean.OperateMessage;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0017¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0017¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/upuphone/ar/translation/phone/helper/InterConnectHelper$mOnDeviceConnectedListener$1", "Lcom/upuphone/ar/translation/interconnect/listener/OnDeviceConnectedListener;", "Lcom/upuphone/ar/translation/interconnect/entity/InterConnectDevice;", "interConnectDevice", "", "a", "(Lcom/upuphone/ar/translation/interconnect/entity/InterConnectDevice;)V", "b", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class InterConnectHelper$mOnDeviceConnectedListener$1 implements OnDeviceConnectedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InterConnectHelper f6298a;

    public InterConnectHelper$mOnDeviceConnectedListener$1(InterConnectHelper interConnectHelper) {
        this.f6298a = interConnectHelper;
    }

    public void a(InterConnectDevice interConnectDevice) {
        LogExt.j("互联设备已连接！device=" + interConnectDevice, "InterConnectHelper");
        TranslationApp.notifyVariousMsg$ar_translator_intlRelease(new OperateMessage(101));
    }

    public void b(InterConnectDevice interConnectDevice) {
        LogExt.j("互联设备断开连接！device=" + interConnectDevice, "InterConnectHelper");
        TranslationApp.notifyVariousMsg$ar_translator_intlRelease(new OperateMessage(102));
        this.f6298a.E();
    }
}
