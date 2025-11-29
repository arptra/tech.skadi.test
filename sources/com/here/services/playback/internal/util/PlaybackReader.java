package com.here.services.playback.internal.util;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Pair;
import com.here.odnp.cell.ICellManager;
import com.here.odnp.gnss.IGnssManager;
import com.here.odnp.posclient.util.DebugLocationExtras;
import com.here.odnp.util.Log;
import com.here.odnp.util.SafeHandler;
import com.here.odnp.util.TimeManager;
import com.here.odnp.wifi.IWifiManager;
import com.here.posclient.CellMeasurement;
import com.here.posclient.WifiMeasurement;
import com.here.services.playback.internal.PlaybackOptions;
import com.here.services.playback.internal.util.IPullParser;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import org.xmlpull.v1.XmlPullParserException;

public class PlaybackReader implements IPullParser.IListener {
    private static final String GL3_TYPE_VALUE_LAC = "lac";
    private static final String GL3_TYPE_VALUE_TAC = "tac";
    private static final String KEY_GL1 = "GL1";
    private static final String KEY_GL2 = "GL2";
    private static final String KEY_GL3 = "GL3";
    private static final String KEY_GL3_TYPE = "GL3TYPE";
    private static final String KEY_GL4 = "GL4";
    private static final String KEY_RAN_TYPE = "rantype";
    private static final String PLAYBACK_CELL_LOCATION_AVAILABLE_ACTION = "com.here.odnp.util.tst.PLAYBACK_CELL_LOCATION";
    private static final String TAG = "services.playback.internal.util.PlaybackReader";
    /* access modifiers changed from: private */
    public final Set<ICellManager.ICellListener> mCellListeners = new HashSet();
    /* access modifiers changed from: private */
    public volatile boolean mClosed;
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    public final Set<IGnssManager.IGnnsListener> mGnssListeners = new HashSet();
    /* access modifiers changed from: private */
    public SafeHandler mHandler;
    private HandlerThread mHandlerThread;
    /* access modifiers changed from: private */
    public volatile CellMeasurement mLastCellScanResult;
    /* access modifiers changed from: private */
    public volatile IWifiManager.WifiScanResultContainer mLastWifiScanResult;
    /* access modifiers changed from: private */
    public final IListener mListener;
    /* access modifiers changed from: private */
    public final IModeProcessor mModeProcessor;
    /* access modifiers changed from: private */
    public final IPullParser mParser;
    private final File mPlaybackFile;
    private final Random mRandom = new Random();
    private boolean mRepeat;
    /* access modifiers changed from: private */
    public final Set<MeasurementPushTask> mScheduledMeasurements = new HashSet();
    /* access modifiers changed from: private */
    public volatile boolean mStarted;
    /* access modifiers changed from: private */
    public final Set<IWifiManager.IWifiListener> mWifiListeners = new HashSet();

    /* renamed from: com.here.services.playback.internal.util.PlaybackReader$13  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass13 {
        static final /* synthetic */ int[] $SwitchMap$com$here$services$playback$internal$PlaybackOptions$Mode;
        static final /* synthetic */ int[] $SwitchMap$com$here$services$playback$internal$util$IPullParser$Measurement$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|(2:1|2)|3|5|6|7|8|(3:9|10|12)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0023 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002e */
        static {
            /*
                com.here.services.playback.internal.PlaybackOptions$Mode[] r0 = com.here.services.playback.internal.PlaybackOptions.Mode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$here$services$playback$internal$PlaybackOptions$Mode = r0
                r1 = 1
                com.here.services.playback.internal.PlaybackOptions$Mode r2 = com.here.services.playback.internal.PlaybackOptions.Mode.Immediate     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                com.here.services.playback.internal.util.IPullParser$Measurement$Type[] r0 = com.here.services.playback.internal.util.IPullParser.Measurement.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$here$services$playback$internal$util$IPullParser$Measurement$Type = r0
                com.here.services.playback.internal.util.IPullParser$Measurement$Type r2 = com.here.services.playback.internal.util.IPullParser.Measurement.Type.Gnss     // Catch:{ NoSuchFieldError -> 0x0023 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0023 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0023 }
            L_0x0023:
                int[] r0 = $SwitchMap$com$here$services$playback$internal$util$IPullParser$Measurement$Type     // Catch:{ NoSuchFieldError -> 0x002e }
                com.here.services.playback.internal.util.IPullParser$Measurement$Type r1 = com.here.services.playback.internal.util.IPullParser.Measurement.Type.Wifi     // Catch:{ NoSuchFieldError -> 0x002e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r0 = $SwitchMap$com$here$services$playback$internal$util$IPullParser$Measurement$Type     // Catch:{ NoSuchFieldError -> 0x0039 }
                com.here.services.playback.internal.util.IPullParser$Measurement$Type r1 = com.here.services.playback.internal.util.IPullParser.Measurement.Type.Cell     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.here.services.playback.internal.util.PlaybackReader.AnonymousClass13.<clinit>():void");
        }
    }

    public abstract class AbstractModeProcessor implements IModeProcessor {
        public AbstractModeProcessor() {
        }

        public boolean isClosed() {
            return PlaybackReader.this.mClosed;
        }

        public boolean isClosedOrNotStarted() {
            return isClosed() || !isStarted();
        }

        public boolean isStarted() {
            return PlaybackReader.this.mStarted;
        }

        public abstract void onMeasurementPushed(IPullParser.Measurement.Type type);

        public abstract void onStart();

        public abstract void onStop();

        public void pushCell(long j, CellMeasurement cellMeasurement) {
            Log.v(PlaybackReader.TAG, "AbstractModeProcessor: pushCell", new Object[0]);
            pushCellMeasurement(cellMeasurement, 0);
            onMeasurementPushed(IPullParser.Measurement.Type.Cell);
        }

        public void pushCellMeasurement(CellMeasurement cellMeasurement, long j) {
            if (cellMeasurement != null) {
                try {
                    Log.v(PlaybackReader.TAG, "pushCellMeasurement: cellMeasurement: %s", cellMeasurement);
                    cellMeasurement.timeStamp = PlaybackReader.this.getRandomTimeStamp(j) / 1000;
                    for (ICellManager.ICellListener onCellMeasurementChanged : PlaybackReader.this.mCellListeners) {
                        onCellMeasurementChanged.onCellMeasurementChanged(cellMeasurement);
                    }
                } finally {
                    CellMeasurement unused = PlaybackReader.this.mLastCellScanResult = cellMeasurement;
                    PlaybackReader.this.mContext.sendBroadcast(PlaybackReader.this.createCellLocationIntent(cellMeasurement));
                }
            }
        }

        public void pushEmptyWifiScanResults() {
            IWifiManager.WifiScanResultContainer wifiScanResultContainer = new IWifiManager.WifiScanResultContainer(0, true, new ArrayList());
            try {
                Log.v(PlaybackReader.TAG, "pushEmptyWifiScanResults", new Object[0]);
                for (IWifiManager.IWifiListener onScanResultsAvailable : PlaybackReader.this.mWifiListeners) {
                    onScanResultsAvailable.onScanResultsAvailable(wifiScanResultContainer);
                }
            } finally {
                DebugLocationExtras.sendWifiScanResultDebugInfo(PlaybackReader.this.mContext, wifiScanResultContainer.scanResultList);
            }
        }

        public void pushGnss(long j, Location location) {
            Log.v(PlaybackReader.TAG, "AbstractModeProcessor: pushGnss", new Object[0]);
            Iterator it = new ArrayList(PlaybackReader.this.mGnssListeners).iterator();
            while (it.hasNext()) {
                ((IGnssManager.IGnnsListener) it.next()).onGnssLocationChanged(location, true);
            }
            onMeasurementPushed(IPullParser.Measurement.Type.Gnss);
        }

        public boolean pushPreviousCellMeasurement() {
            if (PlaybackReader.this.mLastCellScanResult == null) {
                PlaybackReader.this.pushCellScanError();
                return false;
            }
            pushCellMeasurement(PlaybackReader.this.mLastCellScanResult, 0);
            return true;
        }

        public boolean pushPreviousOrEmptyWifiScanResults() {
            Log.v(PlaybackReader.TAG, "pushPreviousWifiScanResults", new Object[0]);
            if (PlaybackReader.this.mLastWifiScanResult != null) {
                pushWifiScanResults(PlaybackReader.this.mLastWifiScanResult, 0);
                return true;
            } else if (isClosed()) {
                return false;
            } else {
                pushEmptyWifiScanResults();
                return true;
            }
        }

        public void pushWifi(long j, IWifiManager.WifiScanResultContainer wifiScanResultContainer) {
            pushWifiScanResults(wifiScanResultContainer, 0);
            onMeasurementPushed(IPullParser.Measurement.Type.Wifi);
        }

        public void pushWifiScanResults(IWifiManager.WifiScanResultContainer wifiScanResultContainer, long j) {
            if (wifiScanResultContainer != null) {
                try {
                    for (WifiMeasurement next : wifiScanResultContainer.scanResultList) {
                        if (next.tsf == Long.MIN_VALUE) {
                            next.tsf = PlaybackReader.this.getRandomTimeStamp(j);
                        }
                    }
                    for (IWifiManager.IWifiListener onScanResultsAvailable : PlaybackReader.this.mWifiListeners) {
                        onScanResultsAvailable.onScanResultsAvailable(wifiScanResultContainer);
                    }
                    IWifiManager.WifiScanResultContainer unused = PlaybackReader.this.mLastWifiScanResult = wifiScanResultContainer;
                    DebugLocationExtras.sendWifiScanResultDebugInfo(PlaybackReader.this.mContext, wifiScanResultContainer.scanResultList);
                } catch (Throwable th) {
                    IWifiManager.WifiScanResultContainer unused2 = PlaybackReader.this.mLastWifiScanResult = wifiScanResultContainer;
                    DebugLocationExtras.sendWifiScanResultDebugInfo(PlaybackReader.this.mContext, wifiScanResultContainer.scanResultList);
                    throw th;
                }
            }
        }

        public void start() {
            Log.v(PlaybackReader.TAG, "AbstractModeProcessor.start", new Object[0]);
            boolean unused = PlaybackReader.this.mStarted = true;
            boolean unused2 = PlaybackReader.this.mClosed = false;
            PlaybackReader.this.mScheduledMeasurements.clear();
            PlaybackReader.this.mHandler.removeCallbacks();
            PlaybackReader.this.mHandler.post(new Runnable() {
                public void run() {
                    AbstractModeProcessor.this.onStart();
                }
            });
        }

        public void stop() {
            boolean unused = PlaybackReader.this.mStarted = false;
            boolean unused2 = PlaybackReader.this.mClosed = true;
            onStop();
            PlaybackReader.this.mHandler.removeCallbacks();
            PlaybackReader.this.mScheduledMeasurements.clear();
        }
    }

    public interface IListener {
        void onPlaybackFinished();
    }

    public interface IModeProcessor extends IPullParser.IListener {
        void cancelCellScan();

        void cancelWifiScan();

        boolean isClosed();

        void start();

        boolean startCellScan();

        boolean startWifiScan();

        void stop();
    }

    public class ImmediateModeProcessor extends AbstractModeProcessor {
        private final List<IPullParser.Measurement> mPendingMeasurements = new ArrayList();

        public ImmediateModeProcessor() {
            super();
        }

        private void fetchNextMeasurements() {
            Log.v(PlaybackReader.TAG, "imp:fetchNextMeasurements", new Object[0]);
            if (isClosedOrNotStarted()) {
                Log.v(PlaybackReader.TAG, "imp:fetchNextMeasurements: closed or not started", new Object[0]);
            } else if (!PlaybackReader.this.mParser.isEof()) {
                this.mPendingMeasurements.addAll(PlaybackReader.this.mParser.pullNextMeasurements());
                ArrayList<IPullParser.Measurement> arrayList = new ArrayList<>();
                Iterator<IPullParser.Measurement> it = this.mPendingMeasurements.iterator();
                while (it.hasNext()) {
                    IPullParser.Measurement next = it.next();
                    if (next == null) {
                        it.remove();
                    } else if (AnonymousClass13.$SwitchMap$com$here$services$playback$internal$util$IPullParser$Measurement$Type[next.getType().ordinal()] == 1) {
                        it.remove();
                        arrayList.add(next);
                    }
                }
                for (IPullParser.Measurement dispatch : arrayList) {
                    dispatch.dispatch(this);
                }
            } else if (!PlaybackReader.this.onEof()) {
                Log.e(PlaybackReader.TAG, "imp:fetchNextMeasurements: error in onEof", new Object[0]);
                PlaybackReader.this.close();
            }
        }

        private boolean scheduleMeasurement(IPullParser.Measurement measurement, long j) {
            return PlaybackReader.this.mHandler.postAtTime(new MeasurementPushTask(measurement), j + SystemClock.uptimeMillis());
        }

        public void cancelCellScan() {
            Log.v(PlaybackReader.TAG, "imp:cancelCellScan", new Object[0]);
        }

        public void cancelWifiScan() {
            Log.v(PlaybackReader.TAG, "imp:cancelWifiScan", new Object[0]);
        }

        public void onMeasurementPushed(IPullParser.Measurement.Type type) {
            Log.v(PlaybackReader.TAG, "imp:onMeasurementPushed", new Object[0]);
            if (type != IPullParser.Measurement.Type.Gnss && this.mPendingMeasurements.isEmpty()) {
                fetchNextMeasurements();
            }
        }

        public void onStart() {
            Log.v(PlaybackReader.TAG, "imp:onStart", new Object[0]);
            fetchNextMeasurements();
        }

        public void onStop() {
        }

        public boolean startCellScan() {
            Log.v(PlaybackReader.TAG, "imp:startCellScan", new Object[0]);
            return (this.mPendingMeasurements.isEmpty() || this.mPendingMeasurements.get(0).getType() != IPullParser.Measurement.Type.Cell) ? pushPreviousCellMeasurement() : scheduleMeasurement(this.mPendingMeasurements.remove(0), 500);
        }

        public boolean startWifiScan() {
            Log.v(PlaybackReader.TAG, "imp:startWifiScan", new Object[0]);
            if (isClosedOrNotStarted()) {
                return false;
            }
            if (this.mPendingMeasurements.isEmpty()) {
                fetchNextMeasurements();
            }
            if (!this.mPendingMeasurements.isEmpty() && this.mPendingMeasurements.get(0).getType() == IPullParser.Measurement.Type.Wifi) {
                return scheduleMeasurement(this.mPendingMeasurements.remove(0), 500);
            }
            Log.v(PlaybackReader.TAG, "startWifiScan: pending measurements empty or not Wi-Fi", new Object[0]);
            return pushPreviousOrEmptyWifiScanResults();
        }
    }

    public class MeasurementPushTask implements Runnable {
        final IPullParser.Measurement mMeasurement;

        public MeasurementPushTask(IPullParser.Measurement measurement) {
            Math.max(0, measurement.getDueAt() - TimeManager.timeSinceBoot());
            this.mMeasurement = measurement;
            PlaybackReader.this.mScheduledMeasurements.add(this);
        }

        public boolean isCellMeasurement() {
            return this.mMeasurement.getType() == IPullParser.Measurement.Type.Cell;
        }

        public boolean isDueBefore(long j) {
            return this.mMeasurement.getDueAt() < j;
        }

        public boolean isWifiMeasurement() {
            return this.mMeasurement.getType() == IPullParser.Measurement.Type.Wifi;
        }

        public void run() {
            PlaybackReader.this.mScheduledMeasurements.remove(this);
            this.mMeasurement.dispatch(PlaybackReader.this);
        }
    }

    public class SchedulingModeProcessor extends AbstractModeProcessor {
        public SchedulingModeProcessor() {
            super();
        }

        private boolean scheduleNextMeasurements() {
            Log.v(PlaybackReader.TAG, "scheduleNextMeasurements", new Object[0]);
            if (isClosedOrNotStarted()) {
                Log.w(PlaybackReader.TAG, "scheduleNextMeasurements: error: closed or not started", new Object[0]);
                return false;
            } else if (PlaybackReader.this.mParser.isEof()) {
                if (!PlaybackReader.this.onEof()) {
                    Log.e(PlaybackReader.TAG, "scheduleNextMeasurements: error in onEof", new Object[0]);
                    PlaybackReader.this.close();
                }
                return false;
            } else {
                for (IPullParser.Measurement next : PlaybackReader.this.mParser.pullNextMeasurements()) {
                    if (!PlaybackReader.this.mHandler.postDelayed(new MeasurementPushTask(next), TimeCalculatorBase.timeSinceBootDiff(next.getDueAt()))) {
                        Log.w(PlaybackReader.TAG, "scheduleNextMeasurements: postAtTime failed", new Object[0]);
                        return false;
                    }
                }
                return true;
            }
        }

        public void cancelCellScan() {
        }

        public void cancelWifiScan() {
        }

        public void onMeasurementPushed(IPullParser.Measurement.Type type) {
            scheduleNextMeasurements();
        }

        public void onStart() {
            scheduleNextMeasurements();
        }

        public void onStop() {
        }

        public boolean startCellScan() {
            if (PlaybackReader.this.mScheduledMeasurements.isEmpty()) {
                scheduleNextMeasurements();
            }
            boolean access$1100 = PlaybackReader.this.scheduledMeasurementsContains(IPullParser.Measurement.Type.Cell);
            Log.i(PlaybackReader.TAG, "startCellScan: %s", Boolean.valueOf(access$1100));
            return access$1100;
        }

        public boolean startWifiScan() {
            if (PlaybackReader.this.mScheduledMeasurements.isEmpty()) {
                scheduleNextMeasurements();
            }
            boolean access$1100 = PlaybackReader.this.scheduledMeasurementsContains(IPullParser.Measurement.Type.Wifi);
            Log.i(PlaybackReader.TAG, "startWifiScan: %s", Boolean.valueOf(access$1100));
            return access$1100;
        }
    }

    private PlaybackReader(Context context, PlaybackOptions playbackOptions, IListener iListener) throws XmlPullParserException, FileNotFoundException, IOException {
        if (iListener == null) {
            throw new IllegalArgumentException("listener is null");
        } else if (playbackOptions.getPlaybackFile() != null) {
            HandlerThread handlerThread = new HandlerThread("PlaybackReader@" + hashCode());
            this.mHandlerThread = handlerThread;
            handlerThread.start();
            this.mHandler = new SafeHandler(this.mHandlerThread.getLooper());
            this.mContext = context;
            this.mListener = iListener;
            File playbackFile = playbackOptions.getPlaybackFile();
            this.mPlaybackFile = playbackFile;
            this.mRepeat = playbackOptions.getRepeat();
            if (playbackFile.getName().toLowerCase(Locale.US).endsWith(".ist")) {
                this.mParser = new IstPullParser(playbackOptions);
            } else {
                this.mParser = new LtaPullParser(playbackOptions);
            }
            initializeParser();
            if (AnonymousClass13.$SwitchMap$com$here$services$playback$internal$PlaybackOptions$Mode[playbackOptions.getMode().ordinal()] != 1) {
                Log.v(TAG, "using: SchedulingModeProcessor", new Object[0]);
                this.mModeProcessor = new SchedulingModeProcessor();
                return;
            }
            Log.v(TAG, "using: ImmediateModeProcessor", new Object[0]);
            this.mModeProcessor = new ImmediateModeProcessor();
        } else {
            throw new IllegalArgumentException("file is null");
        }
    }

    /* access modifiers changed from: private */
    public void closeIfNoListeners() {
        if (this.mGnssListeners.isEmpty() && this.mCellListeners.isEmpty() && this.mWifiListeners.isEmpty()) {
            Log.v(TAG, "closeIfNoListeners: no listeners left -> closing", new Object[0]);
            close();
        }
    }

    /* access modifiers changed from: private */
    public Intent createCellLocationIntent(CellMeasurement cellMeasurement) {
        Intent intent = new Intent(PLAYBACK_CELL_LOCATION_AVAILABLE_ACTION);
        if (cellMeasurement == null) {
            return intent;
        }
        Bundle bundle = new Bundle();
        bundle.putString(KEY_RAN_TYPE, cellMeasurement.type.name().toLowerCase(Locale.US));
        bundle.putInt(KEY_GL1, cellMeasurement.gciL1Value);
        bundle.putInt(KEY_GL2, cellMeasurement.gciL2Value);
        if (cellMeasurement.hasGciL3Value) {
            bundle.putInt(KEY_GL3, cellMeasurement.gciL3Value);
            if (cellMeasurement.type == CellMeasurement.RANType.EUTRA) {
                bundle.putString(KEY_GL3_TYPE, GL3_TYPE_VALUE_TAC);
            } else {
                bundle.putString(KEY_GL3_TYPE, GL3_TYPE_VALUE_LAC);
            }
        }
        if (cellMeasurement.hasGciL4Value) {
            bundle.putInt(KEY_GL4, cellMeasurement.gciL4Value);
        }
        intent.putExtras(bundle);
        return intent;
    }

    private void initializeParser() throws XmlPullParserException, FileNotFoundException {
        try {
            this.mParser.setInput(new InputStreamReader(new FileInputStream(this.mPlaybackFile), Charset.defaultCharset()));
        } catch (FileNotFoundException e) {
            onFileNotFound();
            throw e;
        } catch (XmlPullParserException e2) {
            throw e2;
        } catch (Exception unused) {
        }
    }

    public static PlaybackReader open(Context context, PlaybackOptions playbackOptions, IListener iListener) {
        try {
            return new PlaybackReader(context, playbackOptions, iListener);
        } catch (FileNotFoundException | IOException | XmlPullParserException unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public boolean scheduledMeasurementsContains(IPullParser.Measurement.Type type) {
        if (this.mScheduledMeasurements.isEmpty()) {
            return false;
        }
        for (MeasurementPushTask next : this.mScheduledMeasurements) {
            int i = AnonymousClass13.$SwitchMap$com$here$services$playback$internal$util$IPullParser$Measurement$Type[type.ordinal()];
            if (i != 2) {
                if (i == 3 && next.isCellMeasurement()) {
                    return true;
                }
            } else if (next.isWifiMeasurement()) {
                return true;
            }
        }
        return false;
    }

    public void addCellListener(final ICellManager.ICellListener iCellListener) {
        this.mHandler.post(new Runnable() {
            public void run() {
                PlaybackReader.this.mCellListeners.add(iCellListener);
            }
        });
    }

    public void addGnssListener(final IGnssManager.IGnnsListener iGnnsListener) {
        this.mHandler.post(new Runnable() {
            public void run() {
                PlaybackReader.this.mGnssListeners.add(iGnnsListener);
            }
        });
    }

    public void addWifiListener(final IWifiManager.IWifiListener iWifiListener) {
        this.mHandler.post(new Runnable() {
            public void run() {
                PlaybackReader.this.mWifiListeners.add(iWifiListener);
            }
        });
    }

    public void cancelCellScan() {
        Log.v(TAG, "cancelCellScan", new Object[0]);
        this.mHandler.post(new Runnable() {
            public void run() {
                PlaybackReader.this.mModeProcessor.cancelCellScan();
            }
        });
    }

    public void cancelWifiScan() {
        Log.v(TAG, "cancelWifiScan", new Object[0]);
        this.mHandler.post(new Runnable() {
            public void run() {
                PlaybackReader.this.mModeProcessor.cancelWifiScan();
            }
        });
    }

    public void close() {
        if (!this.mStarted) {
            Log.v(TAG, "close: not started -> ignored", new Object[0]);
            return;
        }
        Log.v(TAG, "close", new Object[0]);
        final ConditionVariable conditionVariable = new ConditionVariable();
        if (this.mHandler.post(new Runnable() {
            public void run() {
                PlaybackReader.this.mModeProcessor.stop();
                conditionVariable.open();
            }
        })) {
            conditionVariable.block();
        }
        this.mHandlerThread.quit();
        this.mHandlerThread = null;
    }

    public Pair<Long, List<WifiMeasurement>> getLastWifiScanResult() {
        ArrayList arrayList;
        long j;
        if (this.mLastWifiScanResult == null) {
            arrayList = new ArrayList();
            j = 0;
        } else {
            j = this.mLastWifiScanResult.measurementId;
            arrayList = new ArrayList(this.mLastWifiScanResult.scanResultList);
        }
        return new Pair<>(Long.valueOf(j), arrayList);
    }

    public String getPlaybackFileName() {
        return this.mPlaybackFile.getAbsolutePath();
    }

    public long getRandomTimeStamp(long j) {
        long currentTimeMillis = System.currentTimeMillis();
        return j == 0 ? currentTimeMillis : currentTimeMillis - (this.mRandom.nextLong() % j);
    }

    public boolean onEof() {
        if (this.mRepeat) {
            Log.v(TAG, "onEof: mRepeat == true => restarting playback", new Object[0]);
            try {
                initializeParser();
                return start();
            } catch (Exception unused) {
                return false;
            }
        } else {
            Log.v(TAG, "onEof: mRepeat == false => finished playback", new Object[0]);
            return this.mHandler.post(new Runnable() {
                public void run() {
                    PlaybackReader.this.mListener.onPlaybackFinished();
                }
            }, false);
        }
    }

    public void onFileNotFound() {
    }

    public void pushCell(long j, CellMeasurement cellMeasurement) {
        Log.v(TAG, "pushCell", new Object[0]);
        this.mModeProcessor.pushCell(j, cellMeasurement);
    }

    public void pushCellScanError() {
        Log.v(TAG, "pushCellScanError", new Object[0]);
        for (ICellManager.ICellListener onCellScanFailed : this.mCellListeners) {
            onCellScanFailed.onCellScanFailed();
        }
    }

    public void pushGnss(long j, Location location) {
        Log.v(TAG, "pushGnss", new Object[0]);
        this.mModeProcessor.pushGnss(j, location);
    }

    public void pushWifi(long j, IWifiManager.WifiScanResultContainer wifiScanResultContainer) {
        Log.v(TAG, "pushWifi", new Object[0]);
        this.mModeProcessor.pushWifi(j, wifiScanResultContainer);
    }

    public void pushWifiScanError() {
        Log.v(TAG, "pushWifiScanError", new Object[0]);
        for (IWifiManager.IWifiListener onWifiScanFailed : this.mWifiListeners) {
            onWifiScanFailed.onWifiScanFailed();
        }
    }

    public void removeCellListener(final ICellManager.ICellListener iCellListener) {
        this.mHandler.post(new Runnable() {
            public void run() {
                PlaybackReader.this.mCellListeners.remove(iCellListener);
                PlaybackReader.this.closeIfNoListeners();
            }
        });
    }

    public void removeGnssListener(final IGnssManager.IGnnsListener iGnnsListener) {
        this.mHandler.post(new Runnable() {
            public void run() {
                PlaybackReader.this.mGnssListeners.remove(iGnnsListener);
                PlaybackReader.this.closeIfNoListeners();
            }
        });
    }

    public void removeWifiListener(final IWifiManager.IWifiListener iWifiListener) {
        this.mHandler.post(new Runnable() {
            public void run() {
                PlaybackReader.this.mWifiListeners.remove(iWifiListener);
                PlaybackReader.this.closeIfNoListeners();
            }
        });
    }

    public boolean start() {
        this.mModeProcessor.start();
        return true;
    }

    public boolean startCellScan() {
        Log.v(TAG, "startCellScan", new Object[0]);
        return this.mHandler.post(new Runnable() {
            public void run() {
                if (!PlaybackReader.this.mModeProcessor.startCellScan()) {
                    PlaybackReader.this.pushCellScanError();
                }
            }
        });
    }

    public boolean startGnss() {
        Log.v(TAG, "startGnss (does not do anything currently)", new Object[0]);
        return true;
    }

    public boolean startWifiScan() {
        Log.v(TAG, "startWifiScan", new Object[0]);
        return this.mHandler.post(new Runnable() {
            public void run() {
                if (!PlaybackReader.this.mModeProcessor.startWifiScan()) {
                    PlaybackReader.this.pushWifiScanError();
                }
            }
        });
    }

    public void stopGnss() {
        Log.v(TAG, "stopGnss (does not do anything currently)", new Object[0]);
    }
}
