package io.flutter.plugins.webviewflutter;

import android.hardware.display.DisplayManager;
import android.os.Handler;
import java.util.ArrayList;
import java.util.Iterator;

class DisplayListenerProxy {
    private static final String TAG = "DisplayListenerProxy";
    private ArrayList<DisplayManager.DisplayListener> listenersBeforeWebView;

    private static ArrayList<DisplayManager.DisplayListener> yoinkDisplayListeners(DisplayManager displayManager) {
        return new ArrayList<>();
    }

    public void onPostWebViewInitialization(final DisplayManager displayManager) {
        final ArrayList<DisplayManager.DisplayListener> yoinkDisplayListeners = yoinkDisplayListeners(displayManager);
        yoinkDisplayListeners.removeAll(this.listenersBeforeWebView);
        if (!yoinkDisplayListeners.isEmpty()) {
            Iterator<DisplayManager.DisplayListener> it = yoinkDisplayListeners.iterator();
            while (it.hasNext()) {
                displayManager.unregisterDisplayListener(it.next());
                displayManager.registerDisplayListener(new DisplayManager.DisplayListener() {
                    public void onDisplayAdded(int i) {
                        Iterator it = yoinkDisplayListeners.iterator();
                        while (it.hasNext()) {
                            ((DisplayManager.DisplayListener) it.next()).onDisplayAdded(i);
                        }
                    }

                    public void onDisplayChanged(int i) {
                        if (displayManager.getDisplay(i) != null) {
                            Iterator it = yoinkDisplayListeners.iterator();
                            while (it.hasNext()) {
                                ((DisplayManager.DisplayListener) it.next()).onDisplayChanged(i);
                            }
                        }
                    }

                    public void onDisplayRemoved(int i) {
                        Iterator it = yoinkDisplayListeners.iterator();
                        while (it.hasNext()) {
                            ((DisplayManager.DisplayListener) it.next()).onDisplayRemoved(i);
                        }
                    }
                }, (Handler) null);
            }
        }
    }

    public void onPreWebViewInitialization(DisplayManager displayManager) {
        this.listenersBeforeWebView = yoinkDisplayListeners(displayManager);
    }
}
