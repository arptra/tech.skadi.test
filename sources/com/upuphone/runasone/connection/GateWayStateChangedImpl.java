package com.upuphone.runasone.connection;

import com.meizu.common.widget.MzContactsContract;
import com.upuphone.runasone.ability.EnumAbility;
import com.upuphone.runasone.connection.gateway.IGateWay;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.utils.LogUtil;
import java.util.Map;

public class GateWayStateChangedImpl implements IGateWay.OnGateWayStateChanged {
    private Map<String, StarryDevice> connectDevice;

    public GateWayStateChangedImpl(Map<String, StarryDevice> map) {
        this.connectDevice = map;
    }

    public void addStatus(StarryDevice starryDevice, int i) {
        if (starryDevice == null) {
            LogUtil.e("device = null");
            return;
        }
        LogUtil.d(starryDevice.getId() + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA + i);
        StarryDevice starryDevice2 = this.connectDevice.get(starryDevice.getId());
        if (starryDevice2 != null) {
            starryDevice2.setStarryDevice(starryDevice.getStarryDevice());
            starryDevice2.setTerminalType(starryDevice.getTerminalType());
            starryDevice = starryDevice2;
        }
        starryDevice.addStatus(i);
        starryDevice.increment((String) null, i);
        this.connectDevice.put(starryDevice.getId(), starryDevice);
        LogUtil.d("addStatus connect-status: " + Integer.toBinaryString(starryDevice.getStatus()));
    }

    public void onApConnected(StarryDevice starryDevice, String str) {
        addStatus(starryDevice, 4);
        StarryDevice starryDevice2 = this.connectDevice.get(starryDevice.getId());
        if (starryDevice2 == null || str == null) {
            LogUtil.d("peerDevice = null");
        } else {
            starryDevice2.setAddress(str);
        }
    }

    public void onApCreated(int i) {
        LogUtil.d("onApCreated : port:" + i);
    }

    public void onApDisconnected(StarryDevice starryDevice) {
        removeStatus(starryDevice, 4);
    }

    public void onApRemoved() {
        removeStatus(4);
        for (StarryDevice status : this.connectDevice.values()) {
            LogUtil.d("onApRemoved connect-status: " + Integer.toBinaryString(status.getStatus()));
        }
    }

    public void onBleConnected(StarryDevice starryDevice) {
        addStatus(starryDevice, 1);
    }

    public void onBleDisconnected(StarryDevice starryDevice) {
        removeStatus(starryDevice, 1);
    }

    public void onBleServerConnected(StarryDevice starryDevice) {
        addStatus(starryDevice, 1);
    }

    public void onBleServerDisconnected(StarryDevice starryDevice) {
        removeStatus(starryDevice, 1);
    }

    public void onConnected(int i, StarryDevice starryDevice) {
        if (starryDevice != null) {
            if (i == 512) {
                addStatus(starryDevice, 2048);
                StarryDevice starryDevice2 = this.connectDevice.get(starryDevice.getId());
                if (starryDevice2 != null) {
                    if (starryDevice2.getStarryDevice().getTerminalType() == 2) {
                        starryDevice2.getSupportAbility().clear();
                        starryDevice2.getSupportAbility().add(EnumAbility.CAST);
                        starryDevice2.getSupportAbility().add(EnumAbility.RELAY);
                        starryDevice2.getSupportAbility().add(EnumAbility.SHARE);
                    }
                    starryDevice2.getSupportAbility().add(EnumAbility.RELAY_AUDIO);
                }
            } else if (i == 16) {
                addStatus(starryDevice, 16);
            } else {
                StarryDevice starryDevice3 = this.connectDevice.get(starryDevice.getId());
                if (starryDevice3 != null && starryDevice3.getStarryDevice().getTerminalType() == 2) {
                    starryDevice3.getSupportAbility().clear();
                    starryDevice3.getSupportAbility().add(EnumAbility.CAST);
                    starryDevice3.getSupportAbility().add(EnumAbility.RELAY);
                    starryDevice3.getSupportAbility().add(EnumAbility.SHARE);
                    starryDevice3.getSupportAbility().add(EnumAbility.RELAY_AUDIO);
                }
            }
        }
    }

    public void onDisconnected(int i, StarryDevice starryDevice) {
        if (i == 512) {
            removeStatus(this.connectDevice.get(starryDevice.getId()), 2048);
        } else if (i == 16) {
            removeStatus(starryDevice, 16);
        }
    }

    public void onLanDisconnected(StarryDevice starryDevice) {
        removeStatus(starryDevice, 2);
    }

    public void onLanGcConnected(int i, String str, StarryDevice starryDevice) {
        addStatus(starryDevice, 2);
        StarryDevice starryDevice2 = this.connectDevice.get(starryDevice.getId());
        if (starryDevice2 != null) {
            starryDevice2.setPort(i);
            starryDevice2.setAddress(str);
            return;
        }
        LogUtil.d("peerDevice = null");
    }

    public void onLanGoConnected(StarryDevice starryDevice) {
        addStatus(starryDevice, 2);
    }

    public void onP2pGcConnected(int i, String str, StarryDevice starryDevice) {
        addStatus(starryDevice, 2);
        StarryDevice starryDevice2 = this.connectDevice.get(starryDevice.getId());
        if (starryDevice2 != null) {
            starryDevice2.setPort(i);
            starryDevice2.setAddress(str);
            return;
        }
        LogUtil.d("peerDevice = null");
    }

    public void onP2pGcDisconnected(StarryDevice starryDevice) {
        removeStatus(starryDevice, 2);
    }

    public void onP2pGoConnected(StarryDevice starryDevice) {
        addStatus(starryDevice, 2);
    }

    public void onP2pGoCreated(int i, String str) {
    }

    public void onP2pGoDisconnected(StarryDevice starryDevice) {
        removeStatus(starryDevice, 2);
    }

    public void onP2pGoRemoved() {
        removeStatus(2);
        for (StarryDevice status : this.connectDevice.values()) {
            LogUtil.d("onP2pGoRemoved connect-status: " + Integer.toBinaryString(status.getStatus()));
        }
    }

    public void onSppClientConnected(StarryDevice starryDevice) {
        addStatus(starryDevice, 32);
    }

    public void onSppClientDisconnected(StarryDevice starryDevice) {
        removeStatus(starryDevice, 32);
    }

    public void onSppServerConnected(StarryDevice starryDevice) {
        addStatus(starryDevice, 32);
    }

    public void onSppServerDisconnected(StarryDevice starryDevice) {
        removeStatus(starryDevice, 32);
    }

    public void onStaConnected(int i, String str, StarryDevice starryDevice) {
        addStatus(starryDevice, 4);
        StarryDevice starryDevice2 = this.connectDevice.get(starryDevice.getId());
        if (starryDevice2 != null) {
            starryDevice2.setPort(i);
            starryDevice2.setAddress(str);
            return;
        }
        LogUtil.d("peerDevice = null");
    }

    public void onStaDisconnected(StarryDevice starryDevice) {
        removeStatus(starryDevice, 4);
    }

    public void removeStatus(StarryDevice starryDevice, int i) {
        if (starryDevice == null) {
            LogUtil.e("device = null");
            return;
        }
        StarryDevice starryDevice2 = this.connectDevice.get(starryDevice.getId());
        if (starryDevice2 != null) {
            starryDevice2.removeStatus(i);
            starryDevice2.decrement((String) null, Integer.valueOf(i));
            LogUtil.d("removeStatus connect-status: " + Integer.toBinaryString(starryDevice2.getStatus()));
        }
    }

    public void reportOwnDevice(StarryDevice starryDevice) {
    }

    public void removeStatus(int i) {
        for (Map.Entry<String, StarryDevice> value : this.connectDevice.entrySet()) {
            StarryDevice starryDevice = (StarryDevice) value.getValue();
            if (!((starryDevice != null && i == 2 && (starryDevice.getTerminalType() == 7 || starryDevice.getTerminalType() == 10)) || starryDevice == null)) {
                starryDevice.removeStatus(i);
                starryDevice.decrement((String) null, Integer.valueOf(i));
            }
        }
    }
}
