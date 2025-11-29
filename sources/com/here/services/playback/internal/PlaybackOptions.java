package com.here.services.playback.internal;

import android.os.Bundle;
import com.meizu.common.widget.MzContactsContract;
import java.io.File;
import java.io.FileNotFoundException;

public class PlaybackOptions {
    public static final int FLAG_SEND_ODNP_POS_AS_GNSS = 1;
    private static final String KEY_FAST_FORWARD = "fast_forward";
    private static final String KEY_MODE = "mode";
    private static final String KEY_PLAYBACK_FILE = "playback_file";
    private static final String KEY_REPEAT = "repeat";
    private static final String KEY_TECHNOLOGIES = "technologies";
    public static final int PLAYBACK_ALL = -1;
    public static final int PLAYBACK_CELL = 1;
    public static final int PLAYBACK_GNSS = 4;
    public static final int PLAYBACK_WIFI = 2;
    private static final String TAG = "odnp.test.PlaybackOptions";
    private boolean mFastForwardLongBreaks = false;
    private int mFlags;
    private Mode mMode = Mode.Scheduled;
    private File mPlaybackFile;
    private boolean mRepeat = false;
    private int mTechnologies = -1;

    public enum Mode {
        Immediate,
        Scheduled
    }

    public static PlaybackOptions fromBundle(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        PlaybackOptions playbackOptions = new PlaybackOptions();
        try {
            playbackOptions.setPlaybackFile(bundle.getString(KEY_PLAYBACK_FILE));
            playbackOptions.setTechnologies(bundle.getInt(KEY_TECHNOLOGIES, -1));
            playbackOptions.setRepeat(bundle.getBoolean(KEY_REPEAT, true));
            try {
                playbackOptions.setMode(Mode.valueOf(bundle.getString("mode")));
            } catch (Exception unused) {
            }
            playbackOptions.setFastForwardLongBreaks(bundle.getBoolean(KEY_FAST_FORWARD, false));
            return playbackOptions;
        } catch (FileNotFoundException unused2) {
            return null;
        }
    }

    public Bundle asBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_PLAYBACK_FILE, this.mPlaybackFile.getAbsolutePath());
        bundle.putInt(KEY_TECHNOLOGIES, this.mTechnologies);
        bundle.putBoolean(KEY_REPEAT, this.mRepeat);
        bundle.putString("mode", this.mMode.name());
        bundle.putBoolean(KEY_FAST_FORWARD, this.mFastForwardLongBreaks);
        return bundle;
    }

    public PlaybackOptions clearFlag(int i) {
        this.mFlags = (~i) & this.mFlags;
        return this;
    }

    public boolean getFastForwardLongBreaks() {
        return this.mMode == Mode.Scheduled && this.mFastForwardLongBreaks;
    }

    public Mode getMode() {
        return this.mMode;
    }

    public File getPlaybackFile() {
        return this.mPlaybackFile;
    }

    public boolean getRepeat() {
        return this.mRepeat;
    }

    public int getTechnologies() {
        return this.mTechnologies;
    }

    public boolean isFlagSet(int i) {
        return (this.mFlags & i) == i;
    }

    public PlaybackOptions setFastForwardLongBreaks(boolean z) {
        this.mFastForwardLongBreaks = z;
        return this;
    }

    public PlaybackOptions setFlag(int i) {
        this.mFlags = i | this.mFlags;
        return this;
    }

    public PlaybackOptions setMode(Mode mode) {
        this.mMode = mode;
        return this;
    }

    public PlaybackOptions setPlaybackFile(String str) throws FileNotFoundException {
        File file = new File(str);
        this.mPlaybackFile = file;
        if (file.exists()) {
            return this;
        }
        throw new FileNotFoundException(str);
    }

    public PlaybackOptions setRepeat(boolean z) {
        this.mRepeat = z;
        return this;
    }

    public PlaybackOptions setTechnologies(int i) {
        this.mTechnologies = i;
        return this;
    }

    public String toString() {
        return "PlaybackOptions[" + this.mMode + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML + "repeat:" + this.mRepeat + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML + "ff:" + this.mFastForwardLongBreaks + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML + "tech:" + Integer.toHexString(this.mTechnologies) + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML + this.mPlaybackFile.getAbsolutePath() + "]";
    }
}
