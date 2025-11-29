package com.here.services.playback;

import android.location.Location;
import android.os.Bundle;
import com.here.posclient.Status;
import com.here.posclient.UpdateOptions;
import com.here.services.Api;
import com.here.services.HereLocationApiClient;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Locale;

public interface TestTrackSimulationApi {

    /* renamed from: com.here.services.playback.TestTrackSimulationApi$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$here$services$playback$TestTrackSimulationApi$Options$PositioningOptions;

        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|(3:21|22|24)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|24) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.here.services.playback.TestTrackSimulationApi$Options$PositioningOptions[] r0 = com.here.services.playback.TestTrackSimulationApi.Options.PositioningOptions.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$here$services$playback$TestTrackSimulationApi$Options$PositioningOptions = r0
                com.here.services.playback.TestTrackSimulationApi$Options$PositioningOptions r1 = com.here.services.playback.TestTrackSimulationApi.Options.PositioningOptions.NoCell     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$here$services$playback$TestTrackSimulationApi$Options$PositioningOptions     // Catch:{ NoSuchFieldError -> 0x001d }
                com.here.services.playback.TestTrackSimulationApi$Options$PositioningOptions r1 = com.here.services.playback.TestTrackSimulationApi.Options.PositioningOptions.NoGnss     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$here$services$playback$TestTrackSimulationApi$Options$PositioningOptions     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.here.services.playback.TestTrackSimulationApi$Options$PositioningOptions r1 = com.here.services.playback.TestTrackSimulationApi.Options.PositioningOptions.NoSensors     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$here$services$playback$TestTrackSimulationApi$Options$PositioningOptions     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.here.services.playback.TestTrackSimulationApi$Options$PositioningOptions r1 = com.here.services.playback.TestTrackSimulationApi.Options.PositioningOptions.NoWlan     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$here$services$playback$TestTrackSimulationApi$Options$PositioningOptions     // Catch:{ NoSuchFieldError -> 0x003e }
                com.here.services.playback.TestTrackSimulationApi$Options$PositioningOptions r1 = com.here.services.playback.TestTrackSimulationApi.Options.PositioningOptions.NoOnline     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$here$services$playback$TestTrackSimulationApi$Options$PositioningOptions     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.here.services.playback.TestTrackSimulationApi$Options$PositioningOptions r1 = com.here.services.playback.TestTrackSimulationApi.Options.PositioningOptions.NoCache     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$here$services$playback$TestTrackSimulationApi$Options$PositioningOptions     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.here.services.playback.TestTrackSimulationApi$Options$PositioningOptions r1 = com.here.services.playback.TestTrackSimulationApi.Options.PositioningOptions.NoOffline     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$here$services$playback$TestTrackSimulationApi$Options$PositioningOptions     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.here.services.playback.TestTrackSimulationApi$Options$PositioningOptions r1 = com.here.services.playback.TestTrackSimulationApi.Options.PositioningOptions.NoExternal     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$here$services$playback$TestTrackSimulationApi$Options$PositioningOptions     // Catch:{ NoSuchFieldError -> 0x006c }
                com.here.services.playback.TestTrackSimulationApi$Options$PositioningOptions r1 = com.here.services.playback.TestTrackSimulationApi.Options.PositioningOptions.NoFusion     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$here$services$playback$TestTrackSimulationApi$Options$PositioningOptions     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.here.services.playback.TestTrackSimulationApi$Options$PositioningOptions r1 = com.here.services.playback.TestTrackSimulationApi.Options.PositioningOptions.NoSensorFusion     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$here$services$playback$TestTrackSimulationApi$Options$PositioningOptions     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.here.services.playback.TestTrackSimulationApi$Options$PositioningOptions r1 = com.here.services.playback.TestTrackSimulationApi.Options.PositioningOptions.NoHDGnss     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.here.services.playback.TestTrackSimulationApi.AnonymousClass1.<clinit>():void");
        }
    }

    public interface Listener {
        void onFinished(Status status, Result result);

        void onProgressUpdated(int i);
    }

    public static class Options implements Api.Options.Required {
        private static final String EXT_IST = "ist";
        private static final String EXT_LTA = "xml";
        private static final String KEY_FILE = "file";
        private static final String KEY_FORMAT = "fileFormat";
        private static final String KEY_UPDATE_OPTIONS = "updateOptions";
        private final File mFile;
        private final FileFormat mFileFormat;
        private final UpdateOptions mUpdateOptions;

        public enum FileFormat {
            LTA,
            IST;

            public static FileFormat fromFile(File file) {
                String lowerCase = file.getName().toLowerCase(Locale.US);
                int lastIndexOf = lowerCase.lastIndexOf(46);
                if (lastIndexOf < 0) {
                    return null;
                }
                String substring = lowerCase.substring(lastIndexOf + 1);
                if (Options.EXT_IST.equals(substring)) {
                    return IST;
                }
                if (Options.EXT_LTA.equals(substring)) {
                    return LTA;
                }
                return null;
            }
        }

        public enum PositioningOptions {
            NoCell,
            NoGnss,
            NoSensors,
            NoWlan,
            NoOnline,
            NoCache,
            NoOffline,
            NoExternal,
            NoFusion,
            NoSensorFusion,
            NoHDGnss
        }

        public /* synthetic */ Options(UpdateOptions updateOptions, File file, FileFormat fileFormat, AnonymousClass1 r4) throws FileNotFoundException {
            this(updateOptions, file, fileFormat);
        }

        public static FileFormat getFileFormat(Bundle bundle) {
            try {
                bundle.setClassLoader(FileFormat.class.getClassLoader());
                return (FileFormat) bundle.getSerializable(KEY_FORMAT);
            } catch (Exception unused) {
                return null;
            }
        }

        public static File getTestTrackFile(Bundle bundle) {
            try {
                return new File(bundle.getString(KEY_FILE));
            } catch (Exception unused) {
                return null;
            }
        }

        public static UpdateOptions getUpdateOptions(Bundle bundle) {
            try {
                bundle.setClassLoader(UpdateOptions.class.getClassLoader());
                return (UpdateOptions) bundle.getParcelable(KEY_UPDATE_OPTIONS);
            } catch (Exception unused) {
                return null;
            }
        }

        public Bundle asBundle() {
            Bundle bundle = new Bundle();
            bundle.putParcelable(KEY_UPDATE_OPTIONS, this.mUpdateOptions);
            bundle.putString(KEY_FILE, this.mFile.getAbsolutePath());
            bundle.putSerializable(KEY_FORMAT, this.mFileFormat);
            return bundle;
        }

        private Options(UpdateOptions updateOptions, File file, FileFormat fileFormat) throws FileNotFoundException {
            this.mUpdateOptions = updateOptions;
            this.mFile = file;
            if (file.exists()) {
                this.mFileFormat = fileFormat;
                return;
            }
            throw new FileNotFoundException();
        }

        public static class Builder {
            private File mFile;
            private FileFormat mFileFormat = FileFormat.IST;
            private boolean mFileFormatSet;
            private final UpdateOptions mUpdateOptions = new UpdateOptions().setHybridPositioningOptions();

            private void applyPositioningOptions(UpdateOptions updateOptions, PositioningOptions... positioningOptionsArr) {
                if (positioningOptionsArr != null) {
                    for (PositioningOptions ordinal : positioningOptionsArr) {
                        switch (AnonymousClass1.$SwitchMap$com$here$services$playback$TestTrackSimulationApi$Options$PositioningOptions[ordinal.ordinal()]) {
                            case 1:
                                updateOptions.disableTechnologies(12);
                                break;
                            case 2:
                                updateOptions.disableTechnologies(1);
                                break;
                            case 3:
                                updateOptions.disableTechnologies(256);
                                break;
                            case 4:
                                updateOptions.disableTechnologies(2);
                                break;
                            case 5:
                                updateOptions.disableSources(2);
                                break;
                            case 6:
                                updateOptions.disableSources(16);
                                break;
                            case 7:
                                updateOptions.disableSources(4);
                                break;
                            case 8:
                                updateOptions.disableSources(64);
                                break;
                            case 9:
                                updateOptions.disableSources(128);
                                break;
                            case 10:
                                updateOptions.disableSources(256);
                                break;
                            case 11:
                                updateOptions.disableSources(1024);
                                break;
                        }
                    }
                }
            }

            public Options build() throws FileNotFoundException {
                File file = this.mFile;
                if (file != null) {
                    if (this.mFileFormat == null) {
                        if (!this.mFileFormatSet) {
                            FileFormat fromFile = FileFormat.fromFile(file);
                            this.mFileFormat = fromFile;
                            if (fromFile == null) {
                                throw new IllegalArgumentException("unsupported file type");
                            }
                        } else {
                            throw new IllegalArgumentException("file format is null");
                        }
                    }
                    if (!this.mUpdateOptions.getTechnologySet().isEmpty()) {
                        UpdateOptions updateOptions = this.mUpdateOptions;
                        if (updateOptions.allowedSources != 0) {
                            return new Options(updateOptions, this.mFile, this.mFileFormat, (AnonymousClass1) null);
                        }
                        throw new IllegalArgumentException("no sources defined");
                    }
                    throw new IllegalArgumentException("no technologies defined");
                }
                throw new IllegalArgumentException("file is null");
            }

            public Builder setHybridPositioning(PositioningOptions... positioningOptionsArr) {
                applyPositioningOptions(this.mUpdateOptions.setHybridPositioningOptions(), positioningOptionsArr);
                return this;
            }

            public Builder setOptions(PositioningOptions... positioningOptionsArr) {
                applyPositioningOptions(this.mUpdateOptions, positioningOptionsArr);
                return this;
            }

            public Builder setOutdoorPositioning(PositioningOptions... positioningOptionsArr) {
                applyPositioningOptions(this.mUpdateOptions.setMediumPowerOptions(), positioningOptionsArr);
                return this;
            }

            public Builder setTestTrackFile(File file) {
                this.mFile = file;
                this.mFileFormat = null;
                this.mFileFormatSet = false;
                return this;
            }

            public Builder setTestTrackFile(File file, FileFormat fileFormat) {
                this.mFile = file;
                this.mFileFormat = fileFormat;
                this.mFileFormatSet = true;
                return this;
            }
        }
    }

    public interface Result {
        List<Location> getLocations();
    }

    boolean startSimulation(HereLocationApiClient hereLocationApiClient, Options options, Listener listener);

    void stopSimulation(HereLocationApiClient hereLocationApiClient);
}
