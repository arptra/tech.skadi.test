package io.flutter.plugins.webviewflutter;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.honey.account.hb.x2;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.WeakHashMap;

public class InstanceManager {
    private static final long CLEAR_FINALIZED_WEAK_REFERENCES_INTERVAL = 3000;
    private static final long MIN_HOST_CREATED_IDENTIFIER = 65536;
    private static final String TAG = "InstanceManager";
    private final FinalizationListener finalizationListener;
    private final Handler handler;
    private boolean hasFinalizationListenerStopped;
    private final WeakHashMap<Object, Long> identifiers = new WeakHashMap<>();
    private long nextIdentifier;
    private final ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
    private final HashMap<Long, Object> strongInstances = new HashMap<>();
    private final HashMap<Long, WeakReference<Object>> weakInstances = new HashMap<>();
    private final HashMap<WeakReference<Object>, Long> weakReferencesToIdentifiers = new HashMap<>();

    public interface FinalizationListener {
        void onFinalize(long j);
    }

    private InstanceManager(FinalizationListener finalizationListener2) {
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.handler = handler2;
        this.nextIdentifier = 65536;
        this.hasFinalizationListenerStopped = false;
        this.finalizationListener = finalizationListener2;
        handler2.postDelayed(new x2(this), CLEAR_FINALIZED_WEAK_REFERENCES_INTERVAL);
    }

    private void addInstance(Object obj, long j) {
        if (j < 0) {
            throw new IllegalArgumentException(String.format("Identifier must be >= 0: %d", new Object[]{Long.valueOf(j)}));
        } else if (!this.weakInstances.containsKey(Long.valueOf(j))) {
            WeakReference weakReference = new WeakReference(obj, this.referenceQueue);
            this.identifiers.put(obj, Long.valueOf(j));
            this.weakInstances.put(Long.valueOf(j), weakReference);
            this.weakReferencesToIdentifiers.put(weakReference, Long.valueOf(j));
            this.strongInstances.put(Long.valueOf(j), obj);
        } else {
            throw new IllegalArgumentException(String.format("Identifier has already been added: %d", new Object[]{Long.valueOf(j)}));
        }
    }

    @NonNull
    public static InstanceManager create(@NonNull FinalizationListener finalizationListener2) {
        return new InstanceManager(finalizationListener2);
    }

    private void logWarningIfFinalizationListenerHasStopped() {
        if (hasFinalizationListenerStopped()) {
            Log.w(TAG, "The manager was used after calls to the FinalizationListener have been stopped.");
        }
    }

    /* access modifiers changed from: private */
    public void releaseAllFinalizedInstances() {
        if (!hasFinalizationListenerStopped()) {
            while (true) {
                WeakReference weakReference = (WeakReference) this.referenceQueue.poll();
                if (weakReference != null) {
                    Long remove = this.weakReferencesToIdentifiers.remove(weakReference);
                    if (remove != null) {
                        this.weakInstances.remove(remove);
                        this.strongInstances.remove(remove);
                        this.finalizationListener.onFinalize(remove.longValue());
                    }
                } else {
                    this.handler.postDelayed(new x2(this), CLEAR_FINALIZED_WEAK_REFERENCES_INTERVAL);
                    return;
                }
            }
        }
    }

    public void addDartCreatedInstance(@NonNull Object obj, long j) {
        logWarningIfFinalizationListenerHasStopped();
        addInstance(obj, j);
    }

    public long addHostCreatedInstance(@NonNull Object obj) {
        logWarningIfFinalizationListenerHasStopped();
        if (!containsInstance(obj)) {
            long j = this.nextIdentifier;
            this.nextIdentifier = 1 + j;
            addInstance(obj, j);
            return j;
        }
        throw new IllegalArgumentException("Instance of " + obj.getClass() + " has already been added.");
    }

    public void clear() {
        this.identifiers.clear();
        this.weakInstances.clear();
        this.strongInstances.clear();
        this.weakReferencesToIdentifiers.clear();
    }

    public boolean containsInstance(@Nullable Object obj) {
        logWarningIfFinalizationListenerHasStopped();
        return this.identifiers.containsKey(obj);
    }

    @Nullable
    public Long getIdentifierForStrongReference(@Nullable Object obj) {
        logWarningIfFinalizationListenerHasStopped();
        Long l = this.identifiers.get(obj);
        if (l != null) {
            this.strongInstances.put(l, obj);
        }
        return l;
    }

    @Nullable
    public <T> T getInstance(long j) {
        logWarningIfFinalizationListenerHasStopped();
        WeakReference weakReference = this.weakInstances.get(Long.valueOf(j));
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public boolean hasFinalizationListenerStopped() {
        return this.hasFinalizationListenerStopped;
    }

    @Nullable
    public <T> T remove(long j) {
        logWarningIfFinalizationListenerHasStopped();
        return this.strongInstances.remove(Long.valueOf(j));
    }

    public void stopFinalizationListener() {
        this.handler.removeCallbacks(new x2(this));
        this.hasFinalizationListenerStopped = true;
    }
}
