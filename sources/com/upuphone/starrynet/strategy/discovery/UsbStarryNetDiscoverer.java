package com.upuphone.starrynet.strategy.discovery;

import android.content.Context;
import android.hardware.usb.UsbAccessory;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.Utils;
import com.upuphone.starrynet.core.usb.UsbStarryManager;
import com.upuphone.starrynet.core.usb.listener.IUsbStarryDiscoverListener;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.bean.StDiscoveryDevice;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.discovery.iccoa.AOAPreambleParser;
import java.util.List;

public class UsbStarryNetDiscoverer {
    private static final String ICCOA_MANUFACTURER = "ICCOA";
    private static final String ICCOA_MODEL = "CarLink";
    private static final String TAG = "UsbStarryNetDiscoverer";
    private Context mContext = StarryNetData.getInstance().getApplicationContext();
    IUsbStarryDiscoverListener mIUsbStarryDiscoverListener = new IUsbStarryDiscoverListener() {
        public void onFound(UsbAccessory usbAccessory) {
            StLog.d(UsbStarryNetDiscoverer.TAG, "onFound：" + usbAccessory);
            if (UsbStarryNetDiscoverer.this.isIccoaDevice(usbAccessory)) {
                StDiscoveryDevice stDiscoveryDevice = new StDiscoveryDevice();
                AOAPreambleParser.init(usbAccessory.getSerial());
                String carId = AOAPreambleParser.getCarId();
                stDiscoveryDevice.setCarId(carId);
                stDiscoveryDevice.setCarProductId(AOAPreambleParser.getPid());
                stDiscoveryDevice.setCarVendorId(AOAPreambleParser.getVid());
                stDiscoveryDevice.setCarName(AOAPreambleParser.getCarName());
                stDiscoveryDevice.setCarPinCode(AOAPreambleParser.getPinCode());
                stDiscoveryDevice.setCarProtocolVersion(AOAPreambleParser.getVersion());
                stDiscoveryDevice.setCarVendorData(AOAPreambleParser.getVendorData());
                stDiscoveryDevice.setIdentifier(Utils.hexString2Bytes(carId));
                stDiscoveryDevice.setDeviceType((byte) 3);
                stDiscoveryDevice.setDiscType((byte) 16);
                stDiscoveryDevice.setUsbAccessory(usbAccessory);
                StarryDeviceManager.getInstance().discoveryDevice(stDiscoveryDevice);
            }
        }

        public void onLoseAll() {
            List<StDiscoveryDevice> discoveryDevices = StarryDeviceManager.getInstance().getDiscoveryDevices();
            StLog.d(UsbStarryNetDiscoverer.TAG, "onLoseAll discoveryDevices Count：" + discoveryDevices.size());
            for (StDiscoveryDevice next : discoveryDevices) {
                if (next.getDeviceType() == 3) {
                    byte discoveryType = next.getDiscoveryType();
                    if ((discoveryType & 16) != 0) {
                        if ((discoveryType & 1) != 0) {
                            next.setDiscType((byte) 1);
                            StLog.d(UsbStarryNetDiscoverer.TAG, "refound：" + next.getIdentifier2String() + " type is: " + 1);
                            StarryDeviceManager.getInstance().discoveryDevice(next);
                        } else {
                            StLog.d(UsbStarryNetDiscoverer.TAG, "onLose：" + next.getIdentifier2String());
                            StarryDeviceManager.getInstance().loseDevice(next.getIdentifier2String());
                        }
                    }
                }
            }
        }
    };

    public UsbStarryNetDiscoverer() {
        UsbStarryManager.getInstance().init(this.mContext, this.mIUsbStarryDiscoverListener);
    }

    public boolean isIccoaDevice(UsbAccessory usbAccessory) {
        return ICCOA_MANUFACTURER.equals(usbAccessory.getManufacturer()) && ICCOA_MODEL.equals(usbAccessory.getModel());
    }

    public void startDiscovery() {
        UsbStarryManager.getInstance().startDiscovery();
    }
}
