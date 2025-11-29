package com.here.services.playback.internal;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.RemoteException;
import com.here.odnp.posclient.IPosClientManager;
import com.here.odnp.posclient.test.IPosClientTesterSession;
import com.here.odnp.util.Log;
import com.here.posclient.Status;
import com.here.services.playback.internal.cell.NullCellManager;
import com.here.services.playback.internal.cell.PlaybackCellManager;
import com.here.services.playback.internal.gnss.NullGnssManager;
import com.here.services.playback.internal.gnss.PlaybackGnssManager;
import com.here.services.playback.internal.util.PlaybackReader;
import com.here.services.playback.internal.util.TestTrackSimulator;
import com.here.services.playback.internal.wifi.NullWifiManager;
import com.here.services.playback.internal.wifi.PlaybackWifiManager;
import java.io.File;
import java.util.List;

public class PosClientPlaybackManager implements PlaybackReader.IListener {
    private static final String TAG = "services.playback.internal.PosClientPlaybackManager";
    private final Context mContext;
    private PlaybackOptions mPlaybackOptions;
    private final IPosClientManager mPosClientManager;
    private final IPosClientTesterSession mPosClientTesterSession;
    private TestTrackSimulator mSimulation;

    private PosClientPlaybackManager(IPosClientManager iPosClientManager) {
        Log.v(TAG, "PosClientPlaybackManager", new Object[0]);
        this.mPosClientManager = iPosClientManager;
        this.mContext = iPosClientManager.getContext();
        this.mPosClientTesterSession = iPosClientManager.createTesterSession();
    }

    public static PosClientPlaybackManager create(IPosClientManager iPosClientManager) {
        return new PosClientPlaybackManager(iPosClientManager);
    }

    private void reportPlaybackFinished(File file) {
        Log.v(TAG, "reportPlaybackFinished", new Object[0]);
        Intent intent = new Intent("com.here.odnp.test.playback-end");
        intent.putExtra("filename", file.getAbsolutePath());
        this.mContext.sendBroadcast(intent);
    }

    private void reportPlaybackStart(int i, File file) {
        Log.v(TAG, "reportPlaybackStart", new Object[0]);
        Intent intent = new Intent("com.here.odnp.test.playback-begin");
        intent.putExtra("filename", file.getAbsolutePath());
        intent.putExtra("technologies", i);
        this.mContext.sendBroadcast(intent);
    }

    public void close() {
        Log.v(TAG, "close", new Object[0]);
        IPosClientTesterSession iPosClientTesterSession = this.mPosClientTesterSession;
        if (iPosClientTesterSession != null) {
            iPosClientTesterSession.close();
        }
    }

    public void onPlaybackFinished() {
        Log.v(TAG, "onPlaybackFinished", new Object[0]);
        stopNetworkMeasurementPlayback();
    }

    public boolean startNetworkMeasurementPlayback(Bundle bundle) {
        PlaybackOptions fromBundle = PlaybackOptions.fromBundle(bundle);
        this.mPlaybackOptions = fromBundle;
        if (fromBundle == null) {
            return false;
        }
        if (!this.mPosClientTesterSession.open()) {
            Log.w(TAG, "startNetworkMeasurementPlayback: PosClientTesterSession.open failed", new Object[0]);
            return false;
        }
        try {
            PlaybackReader open = PlaybackReader.open(this.mContext, this.mPlaybackOptions, this);
            if (open == null) {
                Log.w(TAG, "Failed to open PlaybackReader", new Object[0]);
                return false;
            }
            this.mPosClientTesterSession.storeMeasurementManagers();
            int technologies = this.mPlaybackOptions.getTechnologies();
            if ((technologies & 1) != 0) {
                if (!this.mPosClientTesterSession.setCellManager(new PlaybackCellManager(open))) {
                    throw new RuntimeException("setCellManager(PlaybackCellManager) failed");
                }
            } else if (!this.mPosClientTesterSession.setCellManager(new NullCellManager())) {
                throw new RuntimeException("setCellManager(NullCellManager) failed");
            }
            if ((technologies & 2) != 0) {
                if (!this.mPosClientTesterSession.setWifiManager(new PlaybackWifiManager(open))) {
                    throw new RuntimeException("setWifiManager(PlaybackWifiManager) failed");
                }
            } else if (!this.mPosClientTesterSession.setWifiManager(new NullWifiManager())) {
                throw new RuntimeException("setWifiManager(NullWifiManager) failed");
            }
            if ((technologies & 4) != 0) {
                if (!this.mPosClientTesterSession.setGnssManager(new PlaybackGnssManager(open))) {
                    throw new RuntimeException("setGnssManager(PlaybackGnssManager) failed");
                }
            } else if (!this.mPosClientTesterSession.setGnssManager(new NullGnssManager())) {
                throw new RuntimeException("setGnssManager(NullGnssManager) failed");
            }
            this.mPosClientTesterSession.resetPositioningFilter();
            if (open.start()) {
                reportPlaybackStart(technologies, this.mPlaybackOptions.getPlaybackFile());
                return true;
            }
            Log.e(TAG, "startNetworkMeasurementPlayback: playbackReader.start() failed", new Object[0]);
            stopNetworkMeasurementPlayback();
            return false;
        } catch (Exception unused) {
            stopNetworkMeasurementPlayback();
            return false;
        }
    }

    public boolean startSimulation(final ITestTrackSimulationListener iTestTrackSimulationListener, Bundle bundle) {
        stopSimulation();
        try {
            TestTrackSimulator create = TestTrackSimulator.create(this.mPosClientManager, new TestTrackSimulator.Listener() {
                private static final int TOTAL_PROGRESS = 200;
                int mParsingProgress;
                int mSimulationProgress;
                int mTotalProgress = -1;

                private void reportProgress() {
                    int i = ((this.mParsingProgress + this.mSimulationProgress) * 100) / 200;
                    if (i != this.mTotalProgress) {
                        try {
                            this.mTotalProgress = i;
                            iTestTrackSimulationListener.onProgressUpdated(i);
                        } catch (RemoteException e) {
                            Log.e(PosClientPlaybackManager.TAG, "reportProgress: exception %s", e);
                            shutdown();
                        }
                    }
                }

                private void shutdown() {
                    PosClientPlaybackManager.this.stopSimulation();
                }

                public void onError(Status status) {
                    try {
                        iTestTrackSimulationListener.onFinished(status.toInt(), new Bundle(), false);
                    } catch (RemoteException e) {
                        Log.e(PosClientPlaybackManager.TAG, "onError: exception %s", e);
                        shutdown();
                    }
                }

                public void onParsingCompleted() {
                    Log.v(PosClientPlaybackManager.TAG, "onParsingCompleted", new Object[0]);
                }

                public void onParsingProgress(int i) {
                    this.mParsingProgress = i;
                    reportProgress();
                }

                public void onSimulationCompleted(List<Location> list, boolean z) {
                    try {
                        iTestTrackSimulationListener.onFinished(Status.Ok.toInt(), new SimulationResult().setLocations(list).asBundle(), z);
                    } catch (RemoteException e) {
                        Log.e(PosClientPlaybackManager.TAG, "onSimulationCompleted: exception %s", e);
                        shutdown();
                    }
                }

                public void onSimulationProgress(int i) {
                    this.mSimulationProgress = i;
                    reportProgress();
                }

                public void onStarted() {
                    Log.v(PosClientPlaybackManager.TAG, "onStarted", new Object[0]);
                }
            }, bundle);
            this.mSimulation = create;
            return create.start();
        } catch (TestTrackSimulator.SimulationException e) {
            Log.e(TAG, "TestTrackSimulator.create error: %s", e);
            return false;
        }
    }

    public void stopNetworkMeasurementPlayback() {
        PlaybackOptions playbackOptions;
        try {
            if (!this.mPosClientTesterSession.open()) {
                Log.w(TAG, "stopNetworkMeasurementPlayback: PosClientTesterSession.open failed", new Object[0]);
                if (playbackOptions == null) {
                    return;
                }
                return;
            }
            Log.v(TAG, "stopNetworkMeasurementPlayback", new Object[0]);
            if (this.mPosClientTesterSession.restoreMeasurementManagers()) {
                this.mPosClientTesterSession.resetPositioningFilter();
            }
            PlaybackOptions playbackOptions2 = this.mPlaybackOptions;
            if (playbackOptions2 != null) {
                reportPlaybackFinished(playbackOptions2.getPlaybackFile());
                this.mPlaybackOptions = null;
            }
        } finally {
            playbackOptions = this.mPlaybackOptions;
            if (playbackOptions != null) {
                reportPlaybackFinished(playbackOptions.getPlaybackFile());
                this.mPlaybackOptions = null;
            }
        }
    }

    public void stopSimulation() {
        TestTrackSimulator testTrackSimulator = this.mSimulation;
        this.mSimulation = null;
        if (testTrackSimulator != null) {
            testTrackSimulator.stop();
        }
    }
}
