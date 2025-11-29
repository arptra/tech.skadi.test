package com.here.services.playback.internal.util;

import android.location.Location;
import android.os.Bundle;
import com.here.odnp.util.Log;
import com.here.odnp.wifi.IWifiManager;
import com.here.posclient.WifiMeasurement;
import com.here.services.playback.internal.PlaybackOptions;
import com.here.services.playback.internal.util.IPullParser;
import com.honey.account.constant.AccountConstantKt;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.starrynet.strategy.utils.BleUtil;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.time.TimeZones;

public class IstPullParser implements IPullParser {
    private static final float DEF_GNSS_CEP68 = 10.0f;
    private static final String TAG = "services.playback.internal.util.IstPullParser";
    private boolean mEof;
    private final boolean mFastForwardLongBreaks;
    private boolean mGnnsReferenceAdded;
    private BufferedReader mInput;
    /* access modifiers changed from: private */
    public final SimpleDateFormat mSimpleDateFormat;
    private TimeCalculatorBase mTimeCalculator;

    public interface IMeasurementParser {
        boolean addGnssReference(String str, List<IPullParser.Measurement> list);

        boolean appendLine(String str, List<IPullParser.Measurement> list);

        IPullParser.Measurement getResult();
    }

    public static class IstGnssMeasurement extends IPullParser.Measurement {
        private final Location mLocation;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public IstGnssMeasurement(long j, long j2, long j3, double d, double d2, float f) {
            super(IPullParser.Measurement.Type.Gnss, j, j2, j3);
            long j4 = j;
            Location location = new Location("gps");
            this.mLocation = location;
            location.setAccuracy(f);
            location.setLatitude(d);
            location.setLongitude(d2);
            location.setTime(j);
            location.setElapsedRealtimeNanos(TimeUnit.MILLISECONDS.toNanos(j));
            Bundle bundle = new Bundle();
            bundle.putLong("com.here.services.location:measurementId", getId());
            location.setExtras(bundle);
        }

        public void dispatch(IPullParser.IListener iListener) {
            if (iListener == null) {
                Log.e(IstPullParser.TAG, "IstGnssMeasurement.send: listener is null -> ignored", new Object[0]);
            } else {
                iListener.pushGnss(getTimeStamp(), this.mLocation);
            }
        }
    }

    public static class IstWifiScanResult extends IPullParser.Measurement {
        private final List<WifiMeasurement> mResult = new ArrayList();

        public IstWifiScanResult(long j, long j2, long j3) {
            super(IPullParser.Measurement.Type.Wifi, j, j2, j3);
        }

        public void addWifiScanResult(WifiMeasurement wifiMeasurement) {
            this.mResult.add(wifiMeasurement);
        }

        public void dispatch(IPullParser.IListener iListener) {
            if (iListener == null) {
                Log.e(IstPullParser.TAG, "IstWifiScanResult.dispatch: listener is null -> ignored", new Object[0]);
            } else {
                iListener.pushWifi(getTimeStamp(), new IWifiManager.WifiScanResultContainer(getId(), true, this.mResult));
            }
        }
    }

    public abstract class MeasurementParserBase implements IMeasurementParser {
        private MeasurementParserBase() {
        }

        public boolean addGnssReference(String str, List<IPullParser.Measurement> list) {
            try {
                String[] split = str.split(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_VCARD);
                IstPullParser istPullParser = IstPullParser.this;
                return IstPullParser.this.addGnssMeasurement(list, split, istPullParser.getAdjustedTimeSinceBoot(istPullParser.mSimpleDateFormat.parse(split[4]).getTime()));
            } catch (ParseException unused) {
                return false;
            }
        }

        public IPullParser.Measurement getResult() {
            return onGetResult();
        }

        public abstract IPullParser.Measurement onGetResult();
    }

    public enum TimeHandlingMode {
        Adjusted,
        Raw
    }

    public class WifiMeasurementParser extends MeasurementParserBase {
        private final IstWifiScanResult mResult;

        public WifiMeasurementParser(long j, long j2, long j3) {
            super();
            this.mResult = new IstWifiScanResult(j, j2, j3);
        }

        private WifiMeasurement parseWifiAp(String str, long j) {
            WifiMeasurement wifiMeasurement = new WifiMeasurement();
            String[] split = str.split(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA);
            if (split.length < 7) {
                Log.e(IstPullParser.TAG, "ParseWifiAp: Invalid Wi-Fi MAC format: '%s'", str);
                wifiMeasurement.bssid = WifiMeasurement.toMac64(BleUtil.ALL_ZERO_ADDRESS);
                return wifiMeasurement;
            }
            wifiMeasurement.bssid = WifiMeasurement.toMac64(IstPullParser.formatBSSID(split[0].substring(1)));
            wifiMeasurement.ssid = split[2];
            wifiMeasurement.setFrequency(Integer.parseInt(split[4]));
            wifiMeasurement.rxLevel = Integer.parseInt(split[1]);
            wifiMeasurement.tsf = Long.parseLong(split[5]);
            wifiMeasurement.elapsedRealtimeTimeStamp = j;
            wifiMeasurement.timeStamp = j / 1000;
            return wifiMeasurement;
        }

        public boolean appendLine(String str, List<IPullParser.Measurement> list) {
            if (!str.startsWith("\t")) {
                return false;
            }
            try {
                IstWifiScanResult istWifiScanResult = this.mResult;
                istWifiScanResult.addWifiScanResult(parseWifiAp(str, istWifiScanResult.getTimeStamp()));
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public IPullParser.Measurement onGetResult() {
            return this.mResult;
        }
    }

    public IstPullParser(Reader reader) {
        this.mTimeCalculator = new TimeCalculatorBase() {
            public void doFastForwardAdjustments(long j) {
            }

            public long getAdjustedCurrentTimeMillis(long j) {
                return j;
            }

            public long getAdjustedTimeSinceBoot(long j) {
                return j;
            }
        };
        this.mFastForwardLongBreaks = false;
        this.mEof = false;
        this.mInput = new BufferedReader(reader);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.US);
        this.mSimpleDateFormat = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(TimeZones.GMT_ID));
    }

    /* access modifiers changed from: private */
    public boolean addGnssMeasurement(List<IPullParser.Measurement> list, String[] strArr, long j) {
        try {
            long parseLong = Long.parseLong(strArr[0]);
            String[] split = strArr[2].split(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA);
            if (split.length != 0) {
                if (split[0].length() != 0) {
                    List<IPullParser.Measurement> list2 = list;
                    list2.add(new IstGnssMeasurement(j, j, parseLong, Double.parseDouble(split[0]), Double.parseDouble(split[1]), DEF_GNSS_CEP68));
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    private static byte[] convertStringToBytes(String str) {
        int i = 0;
        if (str == null || str.isEmpty() || (str.length() & 1) == 1) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length() / 2);
        while (i < str.length()) {
            int i2 = i + 2;
            byteArrayOutputStream.write((byte) Integer.valueOf(str.substring(i, i2), 16).intValue());
            i = i2;
        }
        return byteArrayOutputStream.toByteArray();
    }

    private void doFastForwardAdjustments(long j) {
        TimeCalculatorBase timeCalculatorBase = this.mTimeCalculator;
        if (timeCalculatorBase != null) {
            timeCalculatorBase.doFastForwardAdjustments(j);
        }
    }

    /* access modifiers changed from: private */
    public static String formatBSSID(String str) {
        if (str.indexOf(58) != -1) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        sb.append(str.substring(0, 2));
        int i2 = 0;
        while (i < 5) {
            int i3 = i2 + 2;
            sb.append(AccountConstantKt.CODE_SEPARTOR);
            sb.append(str.substring(i3, i2 + 4));
            i++;
            i2 = i3;
        }
        return sb.toString();
    }

    private long getAdjustedCurrentTimeMillis(long j) {
        if (this.mTimeCalculator == null) {
            this.mTimeCalculator = new TimeCalculator(j);
        }
        return this.mTimeCalculator.getAdjustedCurrentTimeMillis(j);
    }

    /* access modifiers changed from: private */
    public long getAdjustedTimeSinceBoot(long j) {
        if (this.mTimeCalculator == null) {
            this.mTimeCalculator = new TimeCalculator(j);
        }
        return this.mTimeCalculator.getAdjustedTimeSinceBoot(j);
    }

    public IMeasurementParser createMeasurementGenerator(String str, List<IPullParser.Measurement> list) {
        try {
            String[] split = str.split(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_VCARD);
            long parseLong = Long.parseLong(split[0]);
            long time = this.mSimpleDateFormat.parse(split[4]).getTime();
            if (this.mFastForwardLongBreaks) {
                doFastForwardAdjustments(time);
            }
            return new WifiMeasurementParser(time, getAdjustedTimeSinceBoot(time), parseLong);
        } catch (Exception e) {
            Log.e(TAG, "createMeasurementGenerator: line: '%s', error: '%s'", str, Log.getStackTraceString(e));
            return null;
        }
    }

    public boolean isEof() {
        return this.mEof;
    }

    public List<IPullParser.Measurement> pullNextMeasurements() {
        ArrayList arrayList = new ArrayList();
        IMeasurementParser iMeasurementParser = null;
        while (true) {
            try {
                this.mInput.mark(1024);
                String readLine = this.mInput.readLine();
                if (readLine == null) {
                    throw new IOException("end of file");
                } else if (!readLine.startsWith("MAP_CALIBRATION")) {
                    if (!readLine.startsWith("EXTENSION_")) {
                        if (iMeasurementParser == null) {
                            iMeasurementParser = createMeasurementGenerator(readLine, arrayList);
                            if (iMeasurementParser != null) {
                                if (!this.mGnnsReferenceAdded) {
                                    this.mGnnsReferenceAdded = iMeasurementParser.addGnssReference(readLine, arrayList);
                                }
                            }
                        } else if (!iMeasurementParser.appendLine(readLine, arrayList)) {
                            arrayList.add(iMeasurementParser.getResult());
                            this.mInput.reset();
                            break;
                        }
                    }
                }
            } catch (IOException unused) {
                this.mEof = true;
                if (iMeasurementParser != null) {
                    arrayList.add(iMeasurementParser.getResult());
                }
            }
        }
        return arrayList;
    }

    public void setInput(Reader reader) throws Exception {
        this.mGnnsReferenceAdded = false;
        this.mEof = false;
        this.mTimeCalculator = null;
        this.mInput = new BufferedReader(reader);
    }

    public IstPullParser(PlaybackOptions playbackOptions) {
        this.mFastForwardLongBreaks = playbackOptions.getFastForwardLongBreaks();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.US);
        this.mSimpleDateFormat = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(TimeZones.GMT_ID));
    }
}
