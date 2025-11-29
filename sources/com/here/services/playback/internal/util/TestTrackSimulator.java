package com.here.services.playback.internal.util;

import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.here.odnp.posclient.IPosClientManager;
import com.here.odnp.posclient.simulation.ISimulationSession;
import com.here.odnp.util.Log;
import com.here.odnp.util.ObjectHolder;
import com.here.odnp.wifi.IWifiManager;
import com.here.posclient.CellMeasurement;
import com.here.posclient.NetworkMeasurement;
import com.here.posclient.PositionEstimate;
import com.here.posclient.Status;
import com.here.posclient.StatusCallback;
import com.here.posclient.UpdateOptions;
import com.here.services.playback.TestTrackSimulationApi;
import com.here.services.playback.internal.util.IPullParser;
import com.here.services.playback.internal.wifi.SimulatedWlanMeasurement;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class TestTrackSimulator {
    private static final int MAX_MEAS_PER_IPC = 50;
    private static final int MEAS_PER_PASS = 50;
    private static final String TAG = "services.playback.internal.util.TestTrackSimulator";
    TestTrackSimulationApi.Options.FileFormat mFormat;
    /* access modifiers changed from: private */
    public final Handler mHandler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public final Listener mListener;
    private final IPosClientManager mManager;
    /* access modifiers changed from: private */
    public Runnable mParserTask;
    /* access modifiers changed from: private */
    public ProgressReader mReader;
    /* access modifiers changed from: private */
    public ISimulationSession mSession;
    /* access modifiers changed from: private */
    public final UpdateOptions mUpdateOptions;

    /* renamed from: com.here.services.playback.internal.util.TestTrackSimulator$4  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$here$services$playback$TestTrackSimulationApi$Options$FileFormat;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.here.services.playback.TestTrackSimulationApi$Options$FileFormat[] r0 = com.here.services.playback.TestTrackSimulationApi.Options.FileFormat.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$here$services$playback$TestTrackSimulationApi$Options$FileFormat = r0
                com.here.services.playback.TestTrackSimulationApi$Options$FileFormat r1 = com.here.services.playback.TestTrackSimulationApi.Options.FileFormat.IST     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$here$services$playback$TestTrackSimulationApi$Options$FileFormat     // Catch:{ NoSuchFieldError -> 0x001d }
                com.here.services.playback.TestTrackSimulationApi$Options$FileFormat r1 = com.here.services.playback.TestTrackSimulationApi.Options.FileFormat.LTA     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.here.services.playback.internal.util.TestTrackSimulator.AnonymousClass4.<clinit>():void");
        }
    }

    public interface Listener {
        void onError(Status status);

        void onParsingCompleted();

        void onParsingProgress(int i);

        void onSimulationCompleted(List<Location> list, boolean z);

        void onSimulationProgress(int i);

        void onStarted();
    }

    public static class ParserListener implements IPullParser.IListener {
        long mAvailableTechnologies;
        final List<Object> mMeasurements;
        final ObjectHolder<PositionEstimate> mReferencePosition;

        private ParserListener() {
            this.mMeasurements = new ArrayList();
            this.mReferencePosition = new ObjectHolder<>();
            this.mAvailableTechnologies = 0;
        }

        public void pushCell(long j, CellMeasurement cellMeasurement) {
            Long valueOf = Long.valueOf(j);
            NetworkMeasurement[] networkMeasurementArr = cellMeasurement.networkMeasurements;
            Log.v(TestTrackSimulator.TAG, "pushCell: %d size: %d", valueOf, Integer.valueOf(networkMeasurementArr == null ? 0 : networkMeasurementArr.length));
            this.mMeasurements.add(cellMeasurement);
            this.mAvailableTechnologies |= 4;
        }

        public void pushGnss(long j, Location location) {
            Log.v(TestTrackSimulator.TAG, "pushGnss: %d", Long.valueOf(j));
            if (this.mReferencePosition.get() == null) {
                this.mReferencePosition.set(PositionEstimate.fromAndroidLocation(location));
            }
        }

        public void pushWifi(long j, IWifiManager.WifiScanResultContainer wifiScanResultContainer) {
            Log.v(TestTrackSimulator.TAG, "pushWifi: %d size: %d", Long.valueOf(j), Integer.valueOf(wifiScanResultContainer.scanResultList.size()));
            this.mMeasurements.add(new SimulatedWlanMeasurement(j, wifiScanResultContainer));
            this.mAvailableTechnologies |= 2;
        }
    }

    public static class ProgressReader extends InputStreamReader {
        final FileChannel mChannel;

        public ProgressReader(FileInputStream fileInputStream) {
            super(fileInputStream, Charset.forName("UTF-8"));
            this.mChannel = fileInputStream.getChannel();
        }

        public int getProgress() {
            try {
                return (int) ((this.mChannel.position() * 100) / this.mChannel.size());
            } catch (IOException unused) {
                return -1;
            }
        }
    }

    public static class SimulationException extends Exception {
        public SimulationException(String str) {
            super(str);
        }
    }

    private TestTrackSimulator(IPosClientManager iPosClientManager, Listener listener, Bundle bundle) throws SimulationException {
        if (iPosClientManager != null) {
            this.mManager = iPosClientManager;
            if (listener != null) {
                this.mListener = listener;
                TestTrackSimulationApi.Options.FileFormat fileFormat = TestTrackSimulationApi.Options.getFileFormat(bundle);
                this.mFormat = fileFormat;
                if (fileFormat != null) {
                    UpdateOptions updateOptions = TestTrackSimulationApi.Options.getUpdateOptions(bundle);
                    this.mUpdateOptions = updateOptions;
                    if (updateOptions != null) {
                        try {
                            File testTrackFile = TestTrackSimulationApi.Options.getTestTrackFile(bundle);
                            if (!testTrackFile.canRead()) {
                                Log.e(TAG, "File: %s cannot read", testTrackFile);
                            }
                            this.mReader = new ProgressReader(new FileInputStream(testTrackFile));
                        } catch (FileNotFoundException unused) {
                            throw new SimulationException("failed to open test track file");
                        }
                    } else {
                        throw new SimulationException("no update options");
                    }
                } else {
                    throw new SimulationException("no file format");
                }
            } else {
                throw new SimulationException("listener is null");
            }
        } else {
            throw new SimulationException("manager is null");
        }
    }

    public static TestTrackSimulator create(IPosClientManager iPosClientManager, Listener listener, Bundle bundle) throws SimulationException {
        return new TestTrackSimulator(iPosClientManager, listener, bundle);
    }

    private IPullParser createParser(ProgressReader progressReader) {
        try {
            int i = AnonymousClass4.$SwitchMap$com$here$services$playback$TestTrackSimulationApi$Options$FileFormat[this.mFormat.ordinal()];
            if (i == 1) {
                return new IstPullParser((Reader) this.mReader);
            }
            if (i == 2) {
                return new LtaPullParser((Reader) this.mReader);
            }
            Log.e(TAG, "createParser: unsupported file format: %s", this.mFormat);
            return null;
        } catch (Exception e) {
            Log.e(TAG, "createParser: parser instantiation exception", e);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public synchronized boolean isSimulating() {
        return this.mSession != null;
    }

    /* access modifiers changed from: private */
    public List<Location> positionEstimatesToLocationList(List<PositionEstimate> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        for (PositionEstimate androidLocation : list) {
            Location androidLocation2 = PositionEstimate.toAndroidLocation(androidLocation);
            if (androidLocation2 != null) {
                arrayList.add(androidLocation2);
            }
        }
        Log.v(TAG, "positionEstimatesToLocationList: size: %d", Integer.valueOf(list.size()));
        return arrayList;
    }

    /* access modifiers changed from: private */
    public synchronized void simulateMeasurements(PositionEstimate positionEstimate, List<Object> list, UpdateOptions updateOptions) {
        try {
            ISimulationSession createSimulationSession = this.mManager.createSimulationSession();
            this.mSession = createSimulationSession;
            if (createSimulationSession != null) {
                if (!this.mHandler.post(new Runnable(list, new StatusCallback() {
                    public void onStatus(Status status) {
                        if (!status.equals(Status.Ok)) {
                            TestTrackSimulator.this.mListener.onError(status);
                            boolean unused = TestTrackSimulator.this.stopSimulation();
                        }
                    }
                }, positionEstimate, updateOptions) {
                    /* access modifiers changed from: private */
                    public final ISimulationSession mSimulationSession;
                    /* access modifiers changed from: private */
                    public int mStepTotal;
                    private final int mTotal;
                    final /* synthetic */ List val$measurements;
                    final /* synthetic */ PositionEstimate val$referencePosition;
                    final /* synthetic */ StatusCallback val$statusCallback;
                    final /* synthetic */ UpdateOptions val$updateOptions;

                    {
                        this.val$measurements = r2;
                        this.val$statusCallback = r3;
                        this.val$referencePosition = r4;
                        this.val$updateOptions = r5;
                        this.mSimulationSession = TestTrackSimulator.this.mSession;
                        this.mTotal = r2.size();
                    }

                    /* access modifiers changed from: private */
                    public Object[] removeCopyN(List<Object> list, int i) {
                        if (i < 1 || list == null || list.isEmpty()) {
                            this.mStepTotal = 0;
                            return new Object[0];
                        }
                        ArrayList arrayList = new ArrayList();
                        while (!list.isEmpty()) {
                            int i2 = i - 1;
                            if (i <= 0) {
                                break;
                            }
                            arrayList.add(list.remove(0));
                            i = i2;
                        }
                        this.mStepTotal = arrayList.size();
                        return arrayList.toArray();
                    }

                    /* access modifiers changed from: private */
                    public void reportCurrentProgress(int i) {
                        TestTrackSimulator.this.mListener.onSimulationProgress((((this.mTotal - this.val$measurements.size()) - i) * 100) / this.mTotal);
                    }

                    public void run() {
                        if (!this.mSimulationSession.startSimulation(new ISimulationSession.Listener() {
                            public void onFinished(int i, List<PositionEstimate> list) {
                                Status fromInt = Status.fromInt(i);
                                if (fromInt == Status.Ok) {
                                    boolean z = !AnonymousClass3.this.val$measurements.isEmpty();
                                    TestTrackSimulator.this.mListener.onSimulationCompleted(TestTrackSimulator.this.positionEstimatesToLocationList(list), z);
                                    if (z && TestTrackSimulator.this.isSimulating()) {
                                        ISimulationSession access$1400 = AnonymousClass3.this.mSimulationSession;
                                        AnonymousClass3 r4 = AnonymousClass3.this;
                                        if (!access$1400.continueSimulation(r4.removeCopyN(r4.val$measurements, 50), AnonymousClass3.this.val$statusCallback)) {
                                            AnonymousClass3.this.val$statusCallback.onStatus(Status.GeneralError);
                                            return;
                                        }
                                        return;
                                    }
                                } else {
                                    TestTrackSimulator.this.mListener.onError(fromInt);
                                }
                                boolean unused = TestTrackSimulator.this.stopSimulation();
                            }

                            public void onProgressUpdated(int i) {
                                AnonymousClass3.this.reportCurrentProgress(((100 - i) * AnonymousClass3.this.mStepTotal) / 100);
                            }
                        }, this.val$referencePosition, removeCopyN(this.val$measurements, 50), this.val$updateOptions)) {
                            TestTrackSimulator.this.mListener.onError(Status.GeneralError);
                        }
                    }
                })) {
                    this.mListener.onError(Status.GeneralError);
                }
            } else {
                this.mListener.onError(Status.InternalError);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public synchronized boolean stopSimulation() {
        ISimulationSession iSimulationSession = this.mSession;
        if (iSimulationSession == null) {
            return false;
        }
        iSimulationSession.stopSimulation();
        this.mSession = null;
        return true;
    }

    public synchronized boolean start() {
        final IPullParser createParser = createParser(this.mReader);
        if (createParser == null) {
            Log.e(TAG, "start: parser is null", new Object[0]);
            return false;
        }
        final ParserListener parserListener = new ParserListener();
        AnonymousClass1 r2 = new Runnable() {
            private int mPass;
            private int mProgress;

            /* JADX WARNING: Code restructure failed: missing block: B:39:0x00bb, code lost:
                if (r1 != false) goto L_?;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:40:0x00bd, code lost:
                com.here.services.playback.internal.util.TestTrackSimulator.access$100(r4.this$0).onError(com.here.posclient.Status.GeneralError);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
                return;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r4 = this;
                    int r0 = r4.mPass
                    r1 = 1
                    int r0 = r0 + r1
                    r4.mPass = r0
                    if (r0 != r1) goto L_0x0011
                    com.here.services.playback.internal.util.TestTrackSimulator r0 = com.here.services.playback.internal.util.TestTrackSimulator.this
                    com.here.services.playback.internal.util.TestTrackSimulator$Listener r0 = r0.mListener
                    r0.onStarted()
                L_0x0011:
                    r0 = 50
                L_0x0013:
                    if (r0 <= 0) goto L_0x0056
                    com.here.services.playback.internal.util.IPullParser r1 = r0
                    java.util.List r1 = r1.pullNextMeasurements()
                    java.util.Iterator r1 = r1.iterator()
                L_0x001f:
                    boolean r2 = r1.hasNext()
                    if (r2 == 0) goto L_0x0031
                    java.lang.Object r2 = r1.next()
                    com.here.services.playback.internal.util.IPullParser$Measurement r2 = (com.here.services.playback.internal.util.IPullParser.Measurement) r2
                    com.here.services.playback.internal.util.TestTrackSimulator$ParserListener r3 = r1
                    r2.dispatch(r3)
                    goto L_0x001f
                L_0x0031:
                    com.here.services.playback.internal.util.TestTrackSimulator r1 = com.here.services.playback.internal.util.TestTrackSimulator.this
                    com.here.services.playback.internal.util.TestTrackSimulator$ProgressReader r1 = r1.mReader
                    int r1 = r1.getProgress()
                    int r2 = r4.mProgress
                    if (r1 == r2) goto L_0x004a
                    com.here.services.playback.internal.util.TestTrackSimulator r2 = com.here.services.playback.internal.util.TestTrackSimulator.this
                    com.here.services.playback.internal.util.TestTrackSimulator$Listener r2 = r2.mListener
                    r2.onParsingProgress(r1)
                    r4.mProgress = r1
                L_0x004a:
                    com.here.services.playback.internal.util.IPullParser r1 = r0
                    boolean r1 = r1.isEof()
                    if (r1 == 0) goto L_0x0053
                    goto L_0x0056
                L_0x0053:
                    int r0 = r0 + -1
                    goto L_0x0013
                L_0x0056:
                    com.here.services.playback.internal.util.IPullParser r0 = r0
                    boolean r0 = r0.isEof()
                    if (r0 == 0) goto L_0x009b
                    com.here.services.playback.internal.util.TestTrackSimulator r0 = com.here.services.playback.internal.util.TestTrackSimulator.this
                    monitor-enter(r0)
                    com.here.services.playback.internal.util.TestTrackSimulator r1 = com.here.services.playback.internal.util.TestTrackSimulator.this     // Catch:{ all -> 0x0098 }
                    r2 = 0
                    java.lang.Runnable unused = r1.mParserTask = r2     // Catch:{ all -> 0x0098 }
                    monitor-exit(r0)     // Catch:{ all -> 0x0098 }
                    com.here.services.playback.internal.util.TestTrackSimulator r0 = com.here.services.playback.internal.util.TestTrackSimulator.this
                    com.here.services.playback.internal.util.TestTrackSimulator$Listener r0 = r0.mListener
                    r0.onParsingCompleted()
                    com.here.services.playback.internal.util.TestTrackSimulator r0 = com.here.services.playback.internal.util.TestTrackSimulator.this
                    com.here.posclient.UpdateOptions r0 = r0.mUpdateOptions
                    com.here.services.playback.internal.util.TestTrackSimulator$ParserListener r1 = r1
                    long r1 = r1.mAvailableTechnologies
                    r0.setAllowedTechnologies(r1)
                    com.here.services.playback.internal.util.TestTrackSimulator r0 = com.here.services.playback.internal.util.TestTrackSimulator.this
                    com.here.services.playback.internal.util.TestTrackSimulator$ParserListener r1 = r1
                    com.here.odnp.util.ObjectHolder<com.here.posclient.PositionEstimate> r1 = r1.mReferencePosition
                    java.lang.Object r1 = r1.get()
                    com.here.posclient.PositionEstimate r1 = (com.here.posclient.PositionEstimate) r1
                    com.here.services.playback.internal.util.TestTrackSimulator$ParserListener r2 = r1
                    java.util.List<java.lang.Object> r2 = r2.mMeasurements
                    com.here.services.playback.internal.util.TestTrackSimulator r4 = com.here.services.playback.internal.util.TestTrackSimulator.this
                    com.here.posclient.UpdateOptions r4 = r4.mUpdateOptions
                    r0.simulateMeasurements(r1, r2, r4)
                    return
                L_0x0098:
                    r4 = move-exception
                    monitor-exit(r0)     // Catch:{ all -> 0x0098 }
                    throw r4
                L_0x009b:
                    com.here.services.playback.internal.util.TestTrackSimulator r0 = com.here.services.playback.internal.util.TestTrackSimulator.this
                    monitor-enter(r0)
                    com.here.services.playback.internal.util.TestTrackSimulator r1 = com.here.services.playback.internal.util.TestTrackSimulator.this     // Catch:{ all -> 0x00a8 }
                    java.lang.Runnable r1 = r1.mParserTask     // Catch:{ all -> 0x00a8 }
                    if (r1 != 0) goto L_0x00aa
                    monitor-exit(r0)     // Catch:{ all -> 0x00a8 }
                    return
                L_0x00a8:
                    r4 = move-exception
                    goto L_0x00c9
                L_0x00aa:
                    com.here.services.playback.internal.util.TestTrackSimulator r1 = com.here.services.playback.internal.util.TestTrackSimulator.this     // Catch:{ all -> 0x00a8 }
                    android.os.Handler r1 = r1.mHandler     // Catch:{ all -> 0x00a8 }
                    com.here.services.playback.internal.util.TestTrackSimulator r2 = com.here.services.playback.internal.util.TestTrackSimulator.this     // Catch:{ all -> 0x00a8 }
                    java.lang.Runnable r2 = r2.mParserTask     // Catch:{ all -> 0x00a8 }
                    boolean r1 = r1.post(r2)     // Catch:{ all -> 0x00a8 }
                    monitor-exit(r0)     // Catch:{ all -> 0x00a8 }
                    if (r1 != 0) goto L_0x00c8
                    com.here.services.playback.internal.util.TestTrackSimulator r4 = com.here.services.playback.internal.util.TestTrackSimulator.this
                    com.here.services.playback.internal.util.TestTrackSimulator$Listener r4 = r4.mListener
                    com.here.posclient.Status r0 = com.here.posclient.Status.GeneralError
                    r4.onError(r0)
                L_0x00c8:
                    return
                L_0x00c9:
                    monitor-exit(r0)     // Catch:{ all -> 0x00a8 }
                    throw r4
                */
                throw new UnsupportedOperationException("Method not decompiled: com.here.services.playback.internal.util.TestTrackSimulator.AnonymousClass1.run():void");
            }
        };
        this.mParserTask = r2;
        return this.mHandler.post(r2);
    }

    public synchronized void stop() {
        try {
            Status status = null;
            if (this.mParserTask != null) {
                this.mParserTask = null;
                this.mHandler.removeCallbacksAndMessages((Object) null);
                status = Status.CancelError;
            }
            if (stopSimulation()) {
                status = Status.CancelError;
            }
            if (status != null) {
                this.mListener.onError(status);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
