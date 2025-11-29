package com.here.services.playback.internal.cell;

import com.here.odnp.cell.ICellManager;
import com.here.odnp.util.Log;
import com.here.services.playback.internal.util.PlaybackReader;

public class PlaybackCellManager implements ICellManager {
    private static final String TAG = "services.playback.internal.cell.PlaybackCellManager";
    private ICellManager.ICellListener mCellListener;
    private final PlaybackReader mPlaybackReader;

    public PlaybackCellManager(PlaybackReader playbackReader) {
        Log.v(TAG, "PlaybackCellManager: '%s'", playbackReader.getPlaybackFileName());
        this.mPlaybackReader = playbackReader;
    }

    public void cancelCellScan() {
        Log.v(TAG, "cancelCellScan", new Object[0]);
        this.mPlaybackReader.cancelCellScan();
    }

    public void close() {
        Log.v(TAG, "close: listener: %s", this.mCellListener);
        this.mPlaybackReader.removeCellListener(this.mCellListener);
        this.mCellListener = null;
    }

    public boolean isCellNeighborSupported() {
        return true;
    }

    public boolean isCellSupported() {
        return true;
    }

    public void open(ICellManager.ICellListener iCellListener) {
        Log.v(TAG, "open: listener: %s", iCellListener);
        this.mCellListener = iCellListener;
        this.mPlaybackReader.addCellListener(iCellListener);
    }

    public boolean startCellScan() {
        Log.v(TAG, "startCellScan", new Object[0]);
        return this.mPlaybackReader.startCellScan();
    }
}
