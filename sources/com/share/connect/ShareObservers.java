package com.share.connect;

import com.easy.logger.EasyLog;
import java.util.ArrayList;
import java.util.List;

class ShareObservers {

    /* renamed from: a  reason: collision with root package name */
    public final List f9879a = new ArrayList();

    public synchronized void a(ShareLinkObserver shareLinkObserver) {
        if (!this.f9879a.contains(shareLinkObserver)) {
            this.f9879a.add(shareLinkObserver);
        }
    }

    public synchronized void b() {
        this.f9879a.clear();
    }

    public synchronized void c() {
        EasyLog.e("ShareObservers", "notifyAuthSucceeded");
        for (ShareLinkObserver onAuthenticationOk : this.f9879a) {
            try {
                onAuthenticationOk.onAuthenticationOk();
            } catch (Exception e) {
                EasyLog.d("ShareObservers", "Observer.onAuthenticationOk() invoke failed.", e);
            }
        }
    }

    public synchronized void d(String str, int i) {
        EasyLog.e("ShareObservers", "notifyClientAddress: " + str + " " + i);
        for (ShareLinkObserver receivedClientAddress : this.f9879a) {
            try {
                receivedClientAddress.receivedClientAddress(str, i);
            } catch (Exception e) {
                EasyLog.d("ShareObservers", "Observer.receivedClientAddress(" + str + ", " + i + ") invoke failed.", e);
            }
        }
    }

    public synchronized void e(String str) {
        EasyLog.e("ShareObservers", "notifyClientBleAdd: " + str);
        for (ShareLinkObserver onReceivedClientBleMac : this.f9879a) {
            try {
                onReceivedClientBleMac.onReceivedClientBleMac(str);
            } catch (Exception e) {
                EasyLog.d("ShareObservers", "Observer.onReceivedClientBleMac(" + str + ") invoke failed.", e);
            }
        }
    }

    public synchronized void f(String str) {
        EasyLog.e("ShareObservers", "notifyClientConnectionType: " + str);
        for (ShareLinkObserver receivedClientConnectionType : this.f9879a) {
            try {
                receivedClientConnectionType.receivedClientConnectionType(str);
            } catch (Exception e) {
                EasyLog.d("ShareObservers", "Observer.receivedClientConnectionType(" + str + ") invoke failed.", e);
            }
        }
    }

    public synchronized void g(String str, String str2, String str3, String str4, int i) {
        EasyLog.e("ShareObservers", "notifyClientHello: " + str + " " + str2 + " " + str4 + " " + i);
        for (ShareLinkObserver receivedClientHello : this.f9879a) {
            try {
                receivedClientHello.receivedClientHello(str, str2, str3, str4, i);
            } catch (Exception e) {
                EasyLog.d("ShareObservers", "Observer.receiveClientHello(" + str + ", " + str2 + ", " + str4 + ", " + i + ") invoke failed.", e);
            }
        }
    }

    public synchronized void h(String str, String str2, String str3) {
        EasyLog.e("ShareObservers", "notifyClientInfo: " + str + " " + str2 + " " + str3);
        for (ShareLinkObserver receivedClientInfo : this.f9879a) {
            try {
                receivedClientInfo.receivedClientInfo(str, str2, str3);
            } catch (Exception e) {
                EasyLog.d("ShareObservers", "Observer.receivedClientInfo(" + str + ", " + str2 + ", " + str3 + ") invoke failed.", e);
            }
        }
    }

    public synchronized void i(int i) {
        EasyLog.e("ShareObservers", "notifyConnectFailed: " + i);
        for (ShareLinkObserver onConnectFailed : this.f9879a) {
            try {
                onConnectFailed.onConnectFailed(i);
            } catch (Exception e) {
                EasyLog.d("ShareObservers", "Observer.onConnectFailed(" + i + ") invoke failed.", e);
            }
        }
    }

    public synchronized void j() {
        EasyLog.e("ShareObservers", "notifyConnected: ");
        for (ShareLinkObserver onConnected : this.f9879a) {
            try {
                onConnected.onConnected();
            } catch (Exception e) {
                EasyLog.d("ShareObservers", "Observer.onConnected() invoke failed.", e);
            }
        }
    }

    public synchronized void k(Device device) {
        for (ShareLinkObserver onDeviceDiscover : this.f9879a) {
            try {
                onDeviceDiscover.onDeviceDiscover(false, device);
            } catch (Exception e) {
                EasyLog.d("ShareObservers", "Observer.onDeviceDiscover(false, " + device.getVin() + "...) invoke failed.", e);
            }
        }
    }

    public synchronized void l(Device device) {
        for (ShareLinkObserver onDeviceDiscover : this.f9879a) {
            try {
                onDeviceDiscover.onDeviceDiscover(true, device);
            } catch (Exception e) {
                EasyLog.d("ShareObservers", "Observer.onDeviceDiscover(true, " + device.getVin() + "...) invoke failed.", e);
            }
        }
    }

    public synchronized void m(boolean z) {
        EasyLog.e("ShareObservers", "notifyDisconnected isUserCloseWifi: " + z);
        for (ShareLinkObserver onDisconnected : this.f9879a) {
            try {
                onDisconnected.onDisconnected(z);
            } catch (Exception e) {
                EasyLog.d("ShareObservers", "Observer.onDisconnected() invoke failed.", e);
            }
        }
    }

    public synchronized void n(boolean z) {
        EasyLog.e("ShareObservers", "notifyNeedUserIntervention");
        for (ShareLinkObserver onUserInterventionNeeded : this.f9879a) {
            try {
                onUserInterventionNeeded.onUserInterventionNeeded(z);
            } catch (Exception e) {
                EasyLog.d("ShareObservers", "Observer.onUserInterventionNeeded() invoke failed.", e);
            }
        }
    }

    public synchronized void o(boolean z) {
        EasyLog.e("ShareObservers", "notifyOpenResult: " + z);
        for (ShareLinkObserver onOpenResult : this.f9879a) {
            try {
                onOpenResult.onOpenResult(z);
            } catch (Exception e) {
                EasyLog.d("ShareObservers", "Observer.onOpenResult(" + z + ") invoke failed.", e);
            }
        }
    }

    public synchronized void p(int i) {
        EasyLog.e("ShareObservers", "notifyProgress: " + i);
        for (ShareLinkObserver onProgress : this.f9879a) {
            try {
                onProgress.onProgress(i);
            } catch (Exception e) {
                EasyLog.d("ShareObservers", "Observer.onProgress(" + i + ") invoke failed.", e);
            }
        }
    }

    public synchronized void q(WifiOwnerConfig wifiOwnerConfig) {
        EasyLog.e("ShareObservers", "onReconfigureWifi");
        for (ShareLinkObserver onReconfigureWifi : this.f9879a) {
            try {
                onReconfigureWifi.onReconfigureWifi(wifiOwnerConfig);
            } catch (Exception e) {
                EasyLog.d("ShareObservers", "Observer.onApCreated() invoke failed.", e);
            }
        }
    }

    public synchronized int r(int i) {
        int i2;
        EasyLog.e("ShareObservers", "notifySelectWorkMode: " + i);
        i2 = 0;
        for (ShareLinkObserver onSelectWorkMode : this.f9879a) {
            try {
                i2 |= onSelectWorkMode.onSelectWorkMode(i);
            } catch (Exception e) {
                EasyLog.d("ShareObservers", "Observer.notifySelectWorkMode(" + i + ") invoke failed.", e);
            }
        }
        return i2;
    }

    public synchronized void s(ShareLinkObserver shareLinkObserver) {
        this.f9879a.remove(shareLinkObserver);
    }
}
