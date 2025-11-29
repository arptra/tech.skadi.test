package com.here.services.radiomap.manager;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.odnp.util.Log;
import com.here.posclient.RadioMapManager;
import com.here.services.HereLocationApiClient;
import com.here.services.internal.ServiceController;
import com.here.services.radiomap.common.GeoArea;
import com.here.services.radiomap.internal.IRadioMapManager;
import com.here.services.radiomap.internal.RadioMapServicesController;
import com.here.services.radiomap.internal.Utility;
import com.here.services.radiomap.manager.RadioMapManagerApi;
import com.here.services.radiomap.manager.RadioMapManagerListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RadioMapManagerProvider implements RadioMapManagerApi {
    private static final String TAG = "services.radiomap.manager.RadioMapManagerProvider";
    private final Map<RadioMapManagerListener, ListenerProxy> mListenerProxies = new HashMap();
    private final ServiceController.Provider<RadioMapServicesController> mProvider;

    /* renamed from: com.here.services.radiomap.manager.RadioMapManagerProvider$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$here$services$radiomap$manager$RadioMapManagerApi$QueryOptions$Target;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.here.services.radiomap.manager.RadioMapManagerApi$QueryOptions$Target[] r0 = com.here.services.radiomap.manager.RadioMapManagerApi.QueryOptions.Target.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$here$services$radiomap$manager$RadioMapManagerApi$QueryOptions$Target = r0
                com.here.services.radiomap.manager.RadioMapManagerApi$QueryOptions$Target r1 = com.here.services.radiomap.manager.RadioMapManagerApi.QueryOptions.Target.Extend     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$here$services$radiomap$manager$RadioMapManagerApi$QueryOptions$Target     // Catch:{ NoSuchFieldError -> 0x001d }
                com.here.services.radiomap.manager.RadioMapManagerApi$QueryOptions$Target r1 = com.here.services.radiomap.manager.RadioMapManagerApi.QueryOptions.Target.Update     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$here$services$radiomap$manager$RadioMapManagerApi$QueryOptions$Target     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.here.services.radiomap.manager.RadioMapManagerApi$QueryOptions$Target r1 = com.here.services.radiomap.manager.RadioMapManagerApi.QueryOptions.Target.Local     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.here.services.radiomap.manager.RadioMapManagerProvider.AnonymousClass1.<clinit>():void");
        }
    }

    public static class ListenerProxy implements IRadioMapManager.IRadioMapActionListener {
        final Handler mHandler;
        final RadioMapManagerListener mListener;

        public ListenerProxy(RadioMapManagerListener radioMapManagerListener, Looper looper) {
            if (looper != null) {
                this.mHandler = new Handler(looper);
            } else {
                this.mHandler = new Handler();
            }
            this.mListener = radioMapManagerListener;
        }

        public void onRadioMapActionProgress(final int i) {
            this.mHandler.post(new Runnable() {
                public void run() {
                    ListenerProxy.this.mListener.onProgress(i);
                }
            });
        }

        public void onRadioMapQueryActionComplete(final int i, final long j) {
            this.mHandler.post(new Runnable() {
                public void run() {
                    Log.v(RadioMapManagerProvider.TAG, "onRadioMapStorageActionComplete: %d", Integer.valueOf(i));
                    ListenerProxy.this.mListener.onQueryCompleted(RadioMapManagerListener.Status.fromInt(i), j);
                }
            });
        }

        public void onRadioMapStorageActionComplete(final int i) {
            this.mHandler.post(new Runnable() {
                public void run() {
                    Log.v(RadioMapManagerProvider.TAG, "onRadioMapStorageActionComplete: %d", Integer.valueOf(i));
                    ListenerProxy.this.mListener.onUpdateCompleted(RadioMapManagerListener.Status.fromInt(i));
                }
            });
        }

        public void onSessionClosed() {
        }
    }

    public RadioMapManagerProvider(Context context, ServiceController.Provider<RadioMapServicesController> provider) {
        this.mProvider = provider;
    }

    private ListenerProxy getListenerProxy(RadioMapManagerListener radioMapManagerListener, Looper looper) {
        if (radioMapManagerListener != null) {
            ListenerProxy listenerProxy = this.mListenerProxies.get(radioMapManagerListener);
            if (listenerProxy != null) {
                return listenerProxy;
            }
            ListenerProxy listenerProxy2 = new ListenerProxy(radioMapManagerListener, looper);
            this.mListenerProxies.put(radioMapManagerListener, listenerProxy2);
            return listenerProxy2;
        }
        throw new IllegalArgumentException("listener is null");
    }

    private IRadioMapManager getRadioMapManager(HereLocationApiClient hereLocationApiClient) {
        RadioMapServicesController controller = this.mProvider.getController(hereLocationApiClient);
        if (controller != null) {
            return controller.getRadioMapManager();
        }
        Log.e(TAG, "getManager: controller is null, radio map manager instance not available", new Object[0]);
        return null;
    }

    @Nullable
    public static List<GeoArea> makeGeoArea(double d, double d2, double d3, double d4) {
        Utility.MeterInDegrees meterInDegrees = Utility.meterInDegrees(d);
        if (meterInDegrees == null) {
            return null;
        }
        double d5 = ((d3 * 1000.0d) / 2.0d) * meterInDegrees.sn;
        double d6 = ((d4 * 1000.0d) / 2.0d) * meterInDegrees.se;
        GeoArea geoArea = new GeoArea();
        geoArea.south = Math.max(d - d5, -90.0d);
        geoArea.north = Math.min(d + d5, 90.0d);
        geoArea.west = d2 - d6;
        geoArea.east = d2 + d6;
        ArrayList arrayList = new ArrayList();
        arrayList.add(geoArea);
        return arrayList;
    }

    private RadioMapManager.RadioMapQueryAction optionsAsAction(RadioMapManagerApi.QueryOptions queryOptions) {
        RadioMapManager.RadioMapQueryAction radioMapQueryAction = RadioMapManager.RadioMapQueryAction.LOCAL_SIZE;
        int i = AnonymousClass1.$SwitchMap$com$here$services$radiomap$manager$RadioMapManagerApi$QueryOptions$Target[queryOptions.mTarget.ordinal()];
        return i != 1 ? i != 2 ? radioMapQueryAction : RadioMapManager.RadioMapQueryAction.UPDATED_SIZE : RadioMapManager.RadioMapQueryAction.EXTENDED_SIZE;
    }

    private void startRadioMapAction(HereLocationApiClient hereLocationApiClient, List<GeoArea> list, RadioMapManagerApi.Options options, RadioMapManagerListener radioMapManagerListener, RadioMapManager.RadioMapStorageAction radioMapStorageAction, Looper looper) {
        IRadioMapManager radioMapManager = getRadioMapManager(hereLocationApiClient);
        if (radioMapManager != null) {
            radioMapManager.startRadioMapUpdate(list, radioMapStorageAction, options.asBundle(), getListenerProxy(radioMapManagerListener, looper));
        }
    }

    public void clear(@NonNull HereLocationApiClient hereLocationApiClient, @NonNull List<GeoArea> list, @NonNull RadioMapManagerApi.Options options, @NonNull RadioMapManagerListener radioMapManagerListener) {
        clear(hereLocationApiClient, list, options, radioMapManagerListener, (Looper) null);
    }

    public void clearAll(@NonNull HereLocationApiClient hereLocationApiClient, @NonNull RadioMapManagerApi.Options options, @NonNull RadioMapManagerListener radioMapManagerListener) {
        clearAll(hereLocationApiClient, options, radioMapManagerListener, (Looper) null);
    }

    public void extend(@NonNull HereLocationApiClient hereLocationApiClient, @NonNull List<GeoArea> list, @NonNull RadioMapManagerApi.Options options, @NonNull RadioMapManagerListener radioMapManagerListener) {
        extend(hereLocationApiClient, list, options, radioMapManagerListener, (Looper) null);
    }

    public void query(@NonNull HereLocationApiClient hereLocationApiClient, @NonNull List<GeoArea> list, @NonNull RadioMapManagerApi.QueryOptions queryOptions, @NonNull RadioMapManagerListener radioMapManagerListener) {
        query(hereLocationApiClient, list, queryOptions, radioMapManagerListener, (Looper) null);
    }

    public void refresh(@NonNull HereLocationApiClient hereLocationApiClient, @NonNull List<GeoArea> list, @NonNull RadioMapManagerApi.Options options, @NonNull RadioMapManagerListener radioMapManagerListener) {
        refresh(hereLocationApiClient, list, options, radioMapManagerListener, (Looper) null);
    }

    public void stop(@NonNull HereLocationApiClient hereLocationApiClient, @NonNull RadioMapManagerListener radioMapManagerListener) {
        if (radioMapManagerListener != null) {
            IRadioMapManager radioMapManager = getRadioMapManager(hereLocationApiClient);
            if (radioMapManager == null) {
                Log.e(TAG, "stop: IRadioMapManager is null", new Object[0]);
                return;
            }
            ListenerProxy remove = this.mListenerProxies.remove(radioMapManagerListener);
            if (remove == null) {
                Log.e(TAG, "stop: listener proxy is null, ignored.", new Object[0]);
            } else {
                radioMapManager.stopRadioMapAction(remove);
            }
        } else {
            throw new IllegalArgumentException("listener is null");
        }
    }

    public void update(@NonNull HereLocationApiClient hereLocationApiClient, @NonNull List<GeoArea> list, @NonNull RadioMapManagerApi.Options options, @NonNull RadioMapManagerListener radioMapManagerListener) {
        update(hereLocationApiClient, list, options, radioMapManagerListener, (Looper) null);
    }

    public void clear(@NonNull HereLocationApiClient hereLocationApiClient, @NonNull List<GeoArea> list, @NonNull RadioMapManagerApi.Options options, @NonNull RadioMapManagerListener radioMapManagerListener, @Nullable Looper looper) {
        if (options != null) {
            startRadioMapAction(hereLocationApiClient, list, options, radioMapManagerListener, RadioMapManager.RadioMapStorageAction.CLEAR, looper);
            return;
        }
        throw new IllegalArgumentException("options is null");
    }

    public void clearAll(@NonNull HereLocationApiClient hereLocationApiClient, @NonNull RadioMapManagerApi.Options options, @NonNull RadioMapManagerListener radioMapManagerListener, @Nullable Looper looper) {
        if (options != null) {
            startRadioMapAction(hereLocationApiClient, Collections.emptyList(), options.setClearAll(true), radioMapManagerListener, RadioMapManager.RadioMapStorageAction.CLEAR, looper);
            return;
        }
        throw new IllegalArgumentException("options is null");
    }

    public void extend(@NonNull HereLocationApiClient hereLocationApiClient, @NonNull List<GeoArea> list, @NonNull RadioMapManagerApi.Options options, @NonNull RadioMapManagerListener radioMapManagerListener, @Nullable Looper looper) {
        if (options != null) {
            startRadioMapAction(hereLocationApiClient, list, options, radioMapManagerListener, RadioMapManager.RadioMapStorageAction.EXTEND, looper);
            return;
        }
        throw new IllegalArgumentException("options is null");
    }

    public void query(@NonNull HereLocationApiClient hereLocationApiClient, @NonNull List<GeoArea> list, @NonNull RadioMapManagerApi.QueryOptions queryOptions, @NonNull RadioMapManagerListener radioMapManagerListener, @Nullable Looper looper) {
        if (queryOptions != null) {
            IRadioMapManager radioMapManager = getRadioMapManager(hereLocationApiClient);
            if (radioMapManager != null) {
                radioMapManager.startRadioMapQuery(list, queryOptions.getTechnologies(), optionsAsAction(queryOptions), getListenerProxy(radioMapManagerListener, looper));
                return;
            }
            return;
        }
        throw new IllegalArgumentException("options is null");
    }

    public void refresh(@NonNull HereLocationApiClient hereLocationApiClient, @NonNull List<GeoArea> list, @NonNull RadioMapManagerApi.Options options, @NonNull RadioMapManagerListener radioMapManagerListener, @Nullable Looper looper) {
        if (options != null) {
            startRadioMapAction(hereLocationApiClient, list, options.setUpdateOldOnly(true), radioMapManagerListener, RadioMapManager.RadioMapStorageAction.UPDATE, looper);
            return;
        }
        throw new IllegalArgumentException("options is null");
    }

    public void update(@NonNull HereLocationApiClient hereLocationApiClient, @NonNull List<GeoArea> list, @NonNull RadioMapManagerApi.Options options, @NonNull RadioMapManagerListener radioMapManagerListener, @Nullable Looper looper) {
        if (options != null) {
            startRadioMapAction(hereLocationApiClient, list, options, radioMapManagerListener, RadioMapManager.RadioMapStorageAction.UPDATE, looper);
            return;
        }
        throw new IllegalArgumentException("options is null");
    }
}
