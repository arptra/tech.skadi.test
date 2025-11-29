package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.time.WallTime;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import javax.inject.Inject;

public class Uploader {
    private static final String LOG_TAG = "Uploader";
    private final BackendRegistry backendRegistry;
    private final Clock clock;
    private final Context context;
    private final EventStore eventStore;
    private final Executor executor;
    private final SynchronizationGuard guard;
    private final WorkScheduler workScheduler;

    @Inject
    public Uploader(Context context2, BackendRegistry backendRegistry2, EventStore eventStore2, WorkScheduler workScheduler2, Executor executor2, SynchronizationGuard synchronizationGuard, @WallTime Clock clock2) {
        this.context = context2;
        this.backendRegistry = backendRegistry2;
        this.eventStore = eventStore2;
        this.workScheduler = workScheduler2;
        this.executor = executor2;
        this.guard = synchronizationGuard;
        this.clock = clock2;
    }

    public static /* synthetic */ Object lambda$logAndUpdateState$3(Uploader uploader, BackendResponse backendResponse, Iterable iterable, TransportContext transportContext, int i) {
        if (backendResponse.getStatus() == BackendResponse.Status.TRANSIENT_ERROR) {
            uploader.eventStore.recordFailure(iterable);
            uploader.workScheduler.schedule(transportContext, i + 1);
            return null;
        }
        uploader.eventStore.recordSuccess(iterable);
        if (backendResponse.getStatus() == BackendResponse.Status.OK) {
            uploader.eventStore.recordNextCallTime(transportContext, uploader.clock.getTime() + backendResponse.getNextRequestWaitMillis());
        }
        if (!uploader.eventStore.hasPendingEventsFor(transportContext)) {
            return null;
        }
        uploader.workScheduler.schedule(transportContext, 1, true);
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0030, code lost:
        r5.run();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0033, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001e, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r2.workScheduler.schedule(r3, r4 + 1);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0027 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void lambda$upload$1(com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader r2, com.google.android.datatransport.runtime.TransportContext r3, int r4, java.lang.Runnable r5) {
        /*
            com.google.android.datatransport.runtime.synchronization.SynchronizationGuard r0 = r2.guard     // Catch:{ SynchronizationException -> 0x0027 }
            com.google.android.datatransport.runtime.scheduling.persistence.EventStore r1 = r2.eventStore     // Catch:{ SynchronizationException -> 0x0027 }
            r1.getClass()     // Catch:{ SynchronizationException -> 0x0027 }
            com.google.android.datatransport.runtime.synchronization.SynchronizationGuard$CriticalSection r1 = com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader$$Lambda$4.lambdaFactory$(r1)     // Catch:{ SynchronizationException -> 0x0027 }
            r0.runCriticalSection(r1)     // Catch:{ SynchronizationException -> 0x0027 }
            boolean r0 = r2.isNetworkAvailable()     // Catch:{ SynchronizationException -> 0x0027 }
            if (r0 != 0) goto L_0x0020
            com.google.android.datatransport.runtime.synchronization.SynchronizationGuard r0 = r2.guard     // Catch:{ SynchronizationException -> 0x0027 }
            com.google.android.datatransport.runtime.synchronization.SynchronizationGuard$CriticalSection r1 = com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader$$Lambda$5.lambdaFactory$(r2, r3, r4)     // Catch:{ SynchronizationException -> 0x0027 }
            r0.runCriticalSection(r1)     // Catch:{ SynchronizationException -> 0x0027 }
            goto L_0x0023
        L_0x001e:
            r2 = move-exception
            goto L_0x0030
        L_0x0020:
            r2.logAndUpdateState(r3, r4)     // Catch:{ SynchronizationException -> 0x0027 }
        L_0x0023:
            r5.run()
            goto L_0x002f
        L_0x0027:
            com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler r2 = r2.workScheduler     // Catch:{ all -> 0x001e }
            int r4 = r4 + 1
            r2.schedule(r3, r4)     // Catch:{ all -> 0x001e }
            goto L_0x0023
        L_0x002f:
            return
        L_0x0030:
            r5.run()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader.lambda$upload$1(com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader, com.google.android.datatransport.runtime.TransportContext, int, java.lang.Runnable):void");
    }

    public boolean isNetworkAvailable() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void logAndUpdateState(TransportContext transportContext, int i) {
        BackendResponse backendResponse;
        TransportBackend transportBackend = this.backendRegistry.get(transportContext.getBackendName());
        Iterable<PersistedEvent> iterable = (Iterable) this.guard.runCriticalSection(Uploader$$Lambda$2.lambdaFactory$(this, transportContext));
        if (iterable.iterator().hasNext()) {
            if (transportBackend == null) {
                Logging.d(LOG_TAG, "Unknown backend for %s, deleting event batch for it...", (Object) transportContext);
                backendResponse = BackendResponse.fatalError();
            } else {
                ArrayList arrayList = new ArrayList();
                for (PersistedEvent event : iterable) {
                    arrayList.add(event.getEvent());
                }
                backendResponse = transportBackend.send(BackendRequest.builder().setEvents(arrayList).setExtras(transportContext.getExtras()).build());
            }
            this.guard.runCriticalSection(Uploader$$Lambda$3.lambdaFactory$(this, backendResponse, iterable, transportContext, i));
        }
    }

    public void upload(TransportContext transportContext, int i, Runnable runnable) {
        this.executor.execute(Uploader$$Lambda$1.lambdaFactory$(this, transportContext, i, runnable));
    }
}
