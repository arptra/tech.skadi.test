package com.here.services.playback;

import com.here.services.Api;
import com.here.services.HereLocationApiClient;
import com.here.services.playback.internal.PlaybackOptions;
import com.meizu.common.widget.MzContactsContract;
import java.io.File;
import java.io.FileNotFoundException;

public interface MeasurementPlaybackApi {
    public static final int ALL = -1;
    public static final int CELL = 1;
    public static final int GNSS = 4;
    public static final int WIFI = 2;

    /* renamed from: com.here.services.playback.MeasurementPlaybackApi$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$here$services$playback$MeasurementPlaybackApi$Mode;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.here.services.playback.MeasurementPlaybackApi$Mode[] r0 = com.here.services.playback.MeasurementPlaybackApi.Mode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$here$services$playback$MeasurementPlaybackApi$Mode = r0
                com.here.services.playback.MeasurementPlaybackApi$Mode r1 = com.here.services.playback.MeasurementPlaybackApi.Mode.Immediate     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$here$services$playback$MeasurementPlaybackApi$Mode     // Catch:{ NoSuchFieldError -> 0x001d }
                com.here.services.playback.MeasurementPlaybackApi$Mode r1 = com.here.services.playback.MeasurementPlaybackApi.Mode.Scheduling     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.here.services.playback.MeasurementPlaybackApi.AnonymousClass1.<clinit>():void");
        }
    }

    public interface Listener {

        public enum Error {
            General
        }

        void onPlaybackError(Error error);

        void onPlaybackFinished();

        void onPlaybackStarted();
    }

    public enum Mode {
        Immediate,
        Scheduling
    }

    public static class Options implements Api.Options.Optional {
        boolean mFastforwardLongBreaks = false;
        Mode mMode = Mode.Scheduling;
        File mPlaybackFile;
        boolean mRepeat = false;
        int mTechnologies = -1;

        public Options(String str) throws FileNotFoundException {
            File file = new File(str);
            this.mPlaybackFile = file;
            if (!file.exists()) {
                throw new FileNotFoundException("file '" + str + "' does not exist!");
            }
        }

        private static boolean isSet(int i, int i2) {
            return (i & i2) == i2;
        }

        private PlaybackOptions.Mode modeToPlaybackMode(Mode mode) {
            return AnonymousClass1.$SwitchMap$com$here$services$playback$MeasurementPlaybackApi$Mode[mode.ordinal()] != 1 ? PlaybackOptions.Mode.Scheduled : PlaybackOptions.Mode.Immediate;
        }

        private int technologiesToPlaybackTechnologies(int i) {
            boolean isSet = isSet(i, 1);
            if (isSet(i, 4)) {
                isSet |= true;
            }
            return isSet(i, 2) ? isSet | true ? 1 : 0 : isSet ? 1 : 0;
        }

        public PlaybackOptions asPlaybackOptions() throws FileNotFoundException {
            return new PlaybackOptions().setMode(modeToPlaybackMode(this.mMode)).setPlaybackFile(this.mPlaybackFile.getAbsolutePath()).setRepeat(this.mRepeat).setFastForwardLongBreaks(this.mFastforwardLongBreaks).setTechnologies(technologiesToPlaybackTechnologies(this.mTechnologies));
        }

        public Options setFastforwardLongBreaks(boolean z) {
            this.mFastforwardLongBreaks = z;
            return this;
        }

        public Options setMode(Mode mode) {
            this.mMode = mode;
            return this;
        }

        public Options setRepeat(boolean z) {
            this.mRepeat = z;
            return this;
        }

        public Options setTechnologies(int i) {
            this.mTechnologies = i;
            return this;
        }

        public String toString() {
            return "MeasurementPlaybackApi.Options[" + this.mMode + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML + "repeat:" + this.mRepeat + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML + "ff:" + this.mFastforwardLongBreaks + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML + "tech:" + Integer.toHexString(this.mTechnologies) + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML + this.mPlaybackFile.getAbsolutePath() + "]";
        }
    }

    void playback(HereLocationApiClient hereLocationApiClient, Options options, Listener listener);

    void stop(HereLocationApiClient hereLocationApiClient);
}
