package com.here.services.playback.internal.util;

import android.location.Location;
import android.os.Bundle;
import com.here.odnp.util.Log;
import com.here.odnp.util.TimeManager;
import com.here.odnp.wifi.IWifiManager;
import com.here.posclient.CellMeasurement;
import com.here.posclient.NetworkMeasurement;
import com.here.posclient.NrNetworkMeasurement;
import com.here.posclient.WifiMeasurement;
import com.here.services.playback.internal.PlaybackOptions;
import com.here.services.playback.internal.util.IPullParser;
import com.honey.account.constant.AccountConstantKt;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class LtaPullParser implements IPullParser {
    private static final String A_BEARING = "bearing";
    private static final String A_CID = "cId";
    private static final String A_CSIRSRP = "csiRsrp";
    private static final String A_CSIRSRQ = "csiRsrq";
    private static final String A_CSISINR = "csiSinr";
    private static final String A_ENDTIME = "endTime";
    private static final String A_HACC = "hAcc";
    private static final String A_ID = "id";
    private static final String A_LAC = "LAC";
    private static final String A_LAT = "lat";
    private static final String A_LON = "lon";
    private static final String A_MAC = "MAC";
    private static final String A_MCC = "MCC";
    private static final String A_MCCSTR = "MCCStr";
    private static final String A_MNC = "MNC";
    private static final String A_MNCSTR = "MNCStr";
    private static final String A_NCI = "nCi";
    private static final String A_NRARFCN = "nrArfcn";
    private static final String A_PCI = "PhysCellID";
    private static final String A_POS = "pos";
    private static final String A_RX = "rx";
    private static final String A_SPEED = "speed";
    private static final String A_SSID = "SSID";
    private static final String A_SSRSRP = "ssRsrp";
    private static final String A_SSRSRQ = "ssRsrq";
    private static final String A_SSSINR = "ssSinr";
    private static final String A_STARTTIME = "startTime";
    private static final String A_TAC = "TAC";
    private static final String A_TIMESTAMP = "timestamp";
    private static final String E_CELL = "cell";
    private static final String E_COORDINATE = "coordinate";
    private static final String E_COORDINATE_ACCURACY = "coordinateAccuracy";
    private static final String E_GPS = "lfwGpsMeasurement";
    private static final String E_GSM = "gsm";
    private static final String E_LTE = "lte";
    private static final String E_NBCELLS = "neighbourCells";
    private static final String E_NR = "nr";
    private static final String E_ODNPMEASUREMENTS = "odnpMeasurement";
    private static final String E_ODNPPOS = "odnpMeas2Pos";
    private static final String E_TDSCDMA = "tdscdma";
    private static final String E_VELOCITY = "velocity";
    private static final String E_WCDMA = "wcdma";
    private static final String E_WIFI = "wifi";
    public static final int INVALID_RX_VALUE = Integer.MAX_VALUE;
    private static final String TAG = "services.playback.internal.util.LtaPullParser";
    private final SimpleDateFormat mDateFormat;
    private final XmlPullParser mParser;
    private final PlaybackOptions mPlaybackOptions;
    private TimeCalculatorBase mTimeCalculator;

    public static class LtaCellMeasurement extends IPullParser.Measurement {
        private final CellMeasurement mCellMeasurement;

        public LtaCellMeasurement(CellMeasurement cellMeasurement, long j, long j2) {
            super(IPullParser.Measurement.Type.Cell, j, j, j2);
            this.mCellMeasurement = cellMeasurement;
        }

        public void dispatch(IPullParser.IListener iListener) {
            if (iListener == null) {
                Log.e(LtaPullParser.TAG, "CellMeasurement.send: listener is null -> ignored", new Object[0]);
            } else {
                iListener.pushCell(getTimeStamp(), this.mCellMeasurement);
            }
        }
    }

    public static class LtaGnssMeasurement extends IPullParser.Measurement {
        private final Location mLocation;

        public LtaGnssMeasurement(long j, long j2, double d, double d2, float f, Double d3, Double d4) {
            super(IPullParser.Measurement.Type.Gnss, j, j, j2);
            Location location = new Location("gps");
            this.mLocation = location;
            location.setAccuracy(f);
            double d5 = d;
            location.setLatitude(d);
            location.setLongitude(d2);
            if (d3 != null) {
                location.setSpeed(d3.floatValue());
            }
            if (d4 != null) {
                location.setBearing(d4.floatValue());
            }
            location.setTime(TimeManager.currentTimeMillis() + TimeCalculatorBase.timeSinceBootDiff(j));
            long j3 = j;
            location.setElapsedRealtimeNanos(TimeUnit.MILLISECONDS.toNanos(j));
            Bundle bundle = new Bundle();
            bundle.putLong("com.here.services.location:measurementId", getId());
            location.setExtras(bundle);
            Log.v(LtaPullParser.TAG, "LtaGnssMeasurement: " + location, new Object[0]);
        }

        public void dispatch(IPullParser.IListener iListener) {
            if (iListener == null) {
                Log.e(LtaPullParser.TAG, "LtaGnssMeasurement.send: listener is null -> ignored", new Object[0]);
            } else {
                iListener.pushGnss(getTimeStamp(), this.mLocation);
            }
        }
    }

    public static class LtaWifiScanResult extends IPullParser.Measurement {
        private final List<WifiMeasurement> mWifiScanResults = new ArrayList();

        public LtaWifiScanResult(long j, long j2) {
            super(IPullParser.Measurement.Type.Wifi, j, j, j2);
        }

        public void addWifiScan(WifiMeasurement wifiMeasurement) {
            this.mWifiScanResults.add(wifiMeasurement);
        }

        public void dispatch(IPullParser.IListener iListener) {
            if (iListener == null) {
                Log.e(LtaPullParser.TAG, "LtaWifiScanResult.dispatch: listener is null -> ignored", new Object[0]);
            } else {
                iListener.pushWifi(getTimeStamp(), new IWifiManager.WifiScanResultContainer(getId(), true, this.mWifiScanResults));
            }
        }
    }

    private LtaPullParser(XmlPullParser xmlPullParser, PlaybackOptions playbackOptions) {
        this.mDateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss.SSS", Locale.US);
        this.mParser = xmlPullParser;
        this.mPlaybackOptions = playbackOptions;
    }

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

    private long getAdjustedTimeSinceBoot(long j) {
        if (this.mTimeCalculator == null) {
            this.mTimeCalculator = new TimeCalculator(j);
        }
        return this.mTimeCalculator.getAdjustedTimeSinceBoot(j);
    }

    private boolean isSet(int i, int i2) {
        return (i2 & i) == i2;
    }

    private void pullGpsMeasurement(List<IPullParser.Measurement> list) throws XmlPullParserException, IOException {
        Log.v(TAG, "pullGpsMeasurement", new Object[0]);
        try {
            Double d = null;
            long parseLong = Long.parseLong(this.mParser.getAttributeValue((String) null, "id"));
            long timeAttribute = getTimeAttribute(A_ENDTIME);
            Double d2 = null;
            Double d3 = null;
            Double d4 = null;
            Double d5 = null;
            while (true) {
                if (this.mParser.getEventType() == 1) {
                    break;
                }
                if (this.mParser.getEventType() == 2) {
                    if (E_COORDINATE.equalsIgnoreCase(this.mParser.getName())) {
                        d2 = Double.valueOf(getDoubleAttribute(A_LAT));
                        d3 = Double.valueOf(getDoubleAttribute(A_LON));
                    } else if (E_COORDINATE_ACCURACY.equalsIgnoreCase(this.mParser.getName())) {
                        d4 = Double.valueOf(getDoubleAttribute(A_HACC));
                    } else if (E_VELOCITY.equalsIgnoreCase(this.mParser.getName())) {
                        d5 = Double.valueOf(getDoubleAttribute(A_SPEED));
                        d = getOptionalDoubleAttribute(A_BEARING, d);
                    }
                }
                Double d6 = d5;
                this.mParser.next();
                if (this.mParser.getEventType() != 3 || !E_GPS.equalsIgnoreCase(this.mParser.getName())) {
                    List<IPullParser.Measurement> list2 = list;
                    d5 = d6;
                } else if (d2 != null && d3 != null && d4 != null && isSet(this.mPlaybackOptions.getTechnologies(), 4)) {
                    long adjustedTimeSinceBoot = getAdjustedTimeSinceBoot(timeAttribute);
                    double doubleValue = d2.doubleValue();
                    double doubleValue2 = d3.doubleValue();
                    LtaGnssMeasurement ltaGnssMeasurement = r5;
                    LtaGnssMeasurement ltaGnssMeasurement2 = new LtaGnssMeasurement(adjustedTimeSinceBoot, parseLong, doubleValue, doubleValue2, d4.floatValue(), d6, d);
                    list.add(ltaGnssMeasurement);
                }
            }
            pullToEndTag(E_GPS);
        } catch (Throwable th) {
            pullToEndTag(E_GPS);
            throw th;
        }
    }

    private void pullOdnpPosition(List<IPullParser.Measurement> list) throws XmlPullParserException, IOException {
        Log.v(TAG, "pullOdnpPosition", new Object[0]);
        try {
            Double d = null;
            long parseLong = Long.parseLong(this.mParser.getAttributeValue((String) null, "id"));
            long timeAttribute = getTimeAttribute(A_ENDTIME);
            Double d2 = null;
            Double d3 = null;
            Double d4 = null;
            Double d5 = null;
            while (true) {
                if (this.mParser.getEventType() == 1) {
                    break;
                }
                if (this.mParser.getEventType() == 2) {
                    if (E_COORDINATE.equalsIgnoreCase(this.mParser.getName())) {
                        d2 = Double.valueOf(getDoubleAttribute(A_LAT));
                        d3 = Double.valueOf(getDoubleAttribute(A_LON));
                    } else if (E_COORDINATE_ACCURACY.equalsIgnoreCase(this.mParser.getName())) {
                        d4 = Double.valueOf(Math.min(10.0d, getDoubleAttribute(A_HACC)));
                    } else if (E_VELOCITY.equalsIgnoreCase(this.mParser.getName())) {
                        d = getOptionalDoubleAttribute(A_BEARING, d);
                        d5 = Double.valueOf(getDoubleAttribute(A_SPEED));
                    }
                }
                Double d6 = d5;
                this.mParser.next();
                if (this.mParser.getEventType() != 3 || !E_ODNPPOS.equalsIgnoreCase(this.mParser.getName())) {
                    List<IPullParser.Measurement> list2 = list;
                    d5 = d6;
                } else if (d2 != null && d3 != null && d4 != null && isSet(this.mPlaybackOptions.getTechnologies(), 4)) {
                    long adjustedTimeSinceBoot = getAdjustedTimeSinceBoot(timeAttribute);
                    double doubleValue = d2.doubleValue();
                    double doubleValue2 = d3.doubleValue();
                    LtaGnssMeasurement ltaGnssMeasurement = r5;
                    LtaGnssMeasurement ltaGnssMeasurement2 = new LtaGnssMeasurement(adjustedTimeSinceBoot, parseLong, doubleValue, doubleValue2, d4.floatValue(), d6, d);
                    list.add(ltaGnssMeasurement);
                }
            }
            pullToEndTag(E_ODNPPOS);
        } catch (Throwable th) {
            pullToEndTag(E_ODNPPOS);
            throw th;
        }
    }

    public String getAttributeValue(String str) {
        return this.mParser.getAttributeValue((String) null, str);
    }

    public double getDoubleAttribute(String str) throws XmlPullParserException {
        try {
            return Double.parseDouble(this.mParser.getAttributeValue((String) null, str));
        } catch (NumberFormatException e) {
            throw new XmlPullParserException(e.getMessage());
        }
    }

    public int getIntAttribute(String str) throws XmlPullParserException {
        try {
            return Integer.parseInt(this.mParser.getAttributeValue((String) null, str));
        } catch (NumberFormatException e) {
            throw new XmlPullParserException(e.getMessage());
        }
    }

    public boolean getOptionalBooleanAttribute(String str, boolean z) {
        try {
            String attributeValue = this.mParser.getAttributeValue((String) null, str);
            return attributeValue == null ? z : Boolean.parseBoolean(attributeValue);
        } catch (Exception unused) {
            return z;
        }
    }

    public Double getOptionalDoubleAttribute(String str, Double d) {
        try {
            String attributeValue = this.mParser.getAttributeValue((String) null, str);
            return attributeValue == null ? d : Double.valueOf(attributeValue);
        } catch (Exception unused) {
            return d;
        }
    }

    public int getOptionalIntAttribute(String str, int i) {
        try {
            return Integer.parseInt(this.mParser.getAttributeValue((String) null, str));
        } catch (Exception unused) {
            return i;
        }
    }

    public long getOptionalLongAttribute(String str, long j) {
        try {
            return Long.parseLong(this.mParser.getAttributeValue((String) null, str));
        } catch (Exception unused) {
            return j;
        }
    }

    public long getOptionalTimeAttribute(String str, long j) {
        try {
            return getTimeAttribute(str);
        } catch (Exception unused) {
            return j;
        }
    }

    public long getTimeAttribute(String str) throws XmlPullParserException {
        try {
            TimeZone timeZone = TimeZone.getDefault();
            long time = this.mDateFormat.parse(this.mParser.getAttributeValue((String) null, str)).getTime();
            return time + ((long) timeZone.getOffset(time));
        } catch (ParseException e) {
            throw new XmlPullParserException(e.getMessage());
        }
    }

    public boolean isEof() {
        try {
            return this.mParser.getEventType() == 1;
        } catch (Exception unused) {
            return true;
        }
    }

    public LtaCellMeasurement pullGsmMeasurement(long j, long j2) throws XmlPullParserException, IOException {
        boolean z = false;
        Log.v(TAG, "pullGsmMeasurement", new Object[0]);
        CellMeasurement cellMeasurement = new CellMeasurement();
        cellMeasurement.type = CellMeasurement.RANType.GERAN;
        cellMeasurement.gciL1Value = getIntAttribute(A_MCC);
        cellMeasurement.gciL2Value = getIntAttribute(A_MNC);
        int optionalIntAttribute = getOptionalIntAttribute(A_LAC, -1);
        cellMeasurement.gciL3Value = optionalIntAttribute;
        cellMeasurement.hasGciL3Value = optionalIntAttribute != -1;
        int optionalIntAttribute2 = getOptionalIntAttribute(A_CID, -1);
        cellMeasurement.gciL4Value = optionalIntAttribute2;
        if (optionalIntAttribute2 != -1) {
            z = true;
        }
        cellMeasurement.hasGciL4Value = z;
        cellMeasurement.simulated = true;
        pullToEndTag(E_GSM);
        return new LtaCellMeasurement(cellMeasurement, j, j2);
    }

    public LtaCellMeasurement pullLteMeasurement(long j, long j2) throws XmlPullParserException, IOException {
        boolean z = false;
        Log.v(TAG, "pullLteMeasurement", new Object[0]);
        CellMeasurement cellMeasurement = new CellMeasurement();
        cellMeasurement.type = CellMeasurement.RANType.EUTRA;
        cellMeasurement.gciL1Value = getIntAttribute(A_MCC);
        cellMeasurement.gciL2Value = getIntAttribute(A_MNC);
        int optionalIntAttribute = getOptionalIntAttribute(A_TAC, -1);
        cellMeasurement.gciL3Value = optionalIntAttribute;
        cellMeasurement.hasGciL3Value = optionalIntAttribute != -1;
        int optionalIntAttribute2 = getOptionalIntAttribute(A_CID, -1);
        cellMeasurement.gciL4Value = optionalIntAttribute2;
        if (optionalIntAttribute2 != -1) {
            z = true;
        }
        cellMeasurement.hasGciL4Value = z;
        cellMeasurement.simulated = true;
        pullToEndTag(E_LTE);
        return new LtaCellMeasurement(cellMeasurement, j, j2);
    }

    public List<IPullParser.Measurement> pullNextMeasurements() {
        ArrayList arrayList = new ArrayList();
        while (!isEof() && arrayList.isEmpty()) {
            try {
                if (this.mParser.next() == 2) {
                    if (E_ODNPMEASUREMENTS.equalsIgnoreCase(this.mParser.getName())) {
                        pullOdnpMeasurement(arrayList);
                    } else if (E_GPS.equalsIgnoreCase(this.mParser.getName())) {
                        pullGpsMeasurement(arrayList);
                    } else if (this.mPlaybackOptions.isFlagSet(1) && E_ODNPPOS.equalsIgnoreCase(this.mParser.getName())) {
                        pullOdnpPosition(arrayList);
                    }
                }
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    public LtaCellMeasurement pullNrMeasurement(long j, long j2) throws XmlPullParserException, IOException {
        boolean z = false;
        Log.v(TAG, "pullNrMeasurement", new Object[0]);
        CellMeasurement cellMeasurement = new CellMeasurement();
        cellMeasurement.type = CellMeasurement.RANType.NR;
        cellMeasurement.gciL1Value = getIntAttribute(A_MCC);
        cellMeasurement.mccStr = getAttributeValue(A_MCCSTR);
        cellMeasurement.gciL2Value = getIntAttribute(A_MNC);
        cellMeasurement.mncStr = getAttributeValue(A_MNCSTR);
        int optionalIntAttribute = getOptionalIntAttribute(A_TAC, -1);
        cellMeasurement.gciL3Value = optionalIntAttribute;
        cellMeasurement.hasGciL3Value = optionalIntAttribute != -1;
        long optionalLongAttribute = getOptionalLongAttribute(A_NCI, -1);
        cellMeasurement.gclL4Value = optionalLongAttribute;
        cellMeasurement.hasGclL4Value = optionalLongAttribute != -1;
        int optionalIntAttribute2 = getOptionalIntAttribute(A_PCI, -1);
        cellMeasurement.lciL1Value = optionalIntAttribute2;
        cellMeasurement.hasLciL1Value = optionalIntAttribute2 != -1;
        int optionalIntAttribute3 = getOptionalIntAttribute(A_NRARFCN, -1);
        cellMeasurement.lciL2Value = optionalIntAttribute3;
        cellMeasurement.hasLciL2Value = optionalIntAttribute3 != -1;
        int optionalIntAttribute4 = getOptionalIntAttribute(A_SSRSRP, -1);
        cellMeasurement.lciL3Value = optionalIntAttribute4;
        cellMeasurement.hasLciL3Value = optionalIntAttribute4 != -1;
        int optionalIntAttribute5 = getOptionalIntAttribute(A_SSRSRQ, -1);
        cellMeasurement.lciL4Value = optionalIntAttribute5;
        cellMeasurement.hasLciL4Value = optionalIntAttribute5 != -1;
        int optionalIntAttribute6 = getOptionalIntAttribute(A_SSSINR, -1);
        cellMeasurement.lciL5Value = optionalIntAttribute6;
        cellMeasurement.hasLciL5Value = optionalIntAttribute6 != -1;
        int optionalIntAttribute7 = getOptionalIntAttribute(A_CSIRSRP, -1);
        cellMeasurement.lciL6Value = optionalIntAttribute7;
        cellMeasurement.hasLciL6Value = optionalIntAttribute7 != -1;
        int optionalIntAttribute8 = getOptionalIntAttribute(A_CSIRSRQ, -1);
        cellMeasurement.lciL7Value = optionalIntAttribute8;
        cellMeasurement.hasLciL7Value = optionalIntAttribute8 != -1;
        int optionalIntAttribute9 = getOptionalIntAttribute(A_CSISINR, -1);
        cellMeasurement.lciL8Value = optionalIntAttribute9;
        if (optionalIntAttribute9 != -1) {
            z = true;
        }
        cellMeasurement.hasLciL8Value = z;
        cellMeasurement.simulated = true;
        cellMeasurement.networkMeasurements = pullNrNwMeasurements();
        pullToEndTag(E_NR);
        return new LtaCellMeasurement(cellMeasurement, j, j2);
    }

    public NetworkMeasurement[] pullNrNwMeasurements() throws XmlPullParserException, IOException {
        int nextToken;
        while (!isEof() && (nextToken = this.mParser.nextToken()) != 2) {
            if (nextToken == 3) {
                break;
            }
        }
        if (this.mParser.getEventType() != 2 || !E_NBCELLS.equalsIgnoreCase(this.mParser.getName())) {
            Log.v(TAG, "pullNrNwMeasurements: no nr measurements", new Object[0]);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (!isEof()) {
            if (this.mParser.getEventType() != 2 || !E_CELL.equalsIgnoreCase(this.mParser.getName())) {
                this.mParser.next();
                if (this.mParser.getEventType() == 3 && E_NBCELLS.equalsIgnoreCase(this.mParser.getName())) {
                    break;
                }
            } else {
                int optionalIntAttribute = getOptionalIntAttribute(A_PCI, -1);
                int optionalIntAttribute2 = getOptionalIntAttribute(A_NRARFCN, -1);
                if (!(optionalIntAttribute == -1 || optionalIntAttribute2 == -1)) {
                    NrNetworkMeasurement nrNetworkMeasurement = new NrNetworkMeasurement(optionalIntAttribute, optionalIntAttribute2);
                    int optionalIntAttribute3 = getOptionalIntAttribute(A_SSRSRP, -1);
                    int optionalIntAttribute4 = getOptionalIntAttribute(A_SSRSRQ, -1);
                    int optionalIntAttribute5 = getOptionalIntAttribute(A_SSSINR, -1);
                    if (!(optionalIntAttribute3 == -1 || optionalIntAttribute4 == -1 || optionalIntAttribute5 == -1)) {
                        nrNetworkMeasurement.setSynchronizationSignal(optionalIntAttribute3, optionalIntAttribute4, optionalIntAttribute5);
                    }
                    int optionalIntAttribute6 = getOptionalIntAttribute(A_CSIRSRP, -1);
                    int optionalIntAttribute7 = getOptionalIntAttribute(A_CSIRSRQ, -1);
                    int optionalIntAttribute8 = getOptionalIntAttribute(A_CSISINR, -1);
                    if (!(optionalIntAttribute6 == -1 || optionalIntAttribute7 == -1 || optionalIntAttribute8 == -1)) {
                        nrNetworkMeasurement.setChannelStateSignal(optionalIntAttribute6, optionalIntAttribute7, optionalIntAttribute8);
                    }
                    arrayList.add(nrNetworkMeasurement);
                }
                pullToEndTag(E_CELL);
            }
        }
        Log.v(TAG, "pullNrNwMeasurements: %d measurements", Integer.valueOf(arrayList.size()));
        return (NetworkMeasurement[]) arrayList.toArray(new NetworkMeasurement[0]);
    }

    public void pullOdnpMeasurement(List<IPullParser.Measurement> list) throws XmlPullParserException, IOException {
        long parseLong = Long.parseLong(this.mParser.getAttributeValue((String) null, "id"));
        long max = Math.max(getTimeAttribute(A_STARTTIME), getTimeAttribute(A_ENDTIME));
        do {
            if (this.mParser.getEventType() == 2) {
                if (E_WCDMA.equalsIgnoreCase(this.mParser.getName())) {
                    LtaCellMeasurement pullWcdmaMeasurement = pullWcdmaMeasurement(getAdjustedTimeSinceBoot(max), parseLong);
                    if (isSet(this.mPlaybackOptions.getTechnologies(), 1)) {
                        list.add(pullWcdmaMeasurement);
                    }
                } else if (E_LTE.equalsIgnoreCase(this.mParser.getName())) {
                    LtaCellMeasurement pullLteMeasurement = pullLteMeasurement(getAdjustedTimeSinceBoot(max), parseLong);
                    if (isSet(this.mPlaybackOptions.getTechnologies(), 1)) {
                        list.add(pullLteMeasurement);
                    }
                } else if (E_GSM.equalsIgnoreCase(this.mParser.getName())) {
                    LtaCellMeasurement pullGsmMeasurement = pullGsmMeasurement(getAdjustedTimeSinceBoot(max), parseLong);
                    if (isSet(this.mPlaybackOptions.getTechnologies(), 1)) {
                        list.add(pullGsmMeasurement);
                    }
                } else if (E_TDSCDMA.equalsIgnoreCase(this.mParser.getName())) {
                    LtaCellMeasurement pullTdscdmaMeasurement = pullTdscdmaMeasurement(getAdjustedTimeSinceBoot(max), parseLong);
                    if (isSet(this.mPlaybackOptions.getTechnologies(), 1)) {
                        list.add(pullTdscdmaMeasurement);
                    }
                } else if (E_WIFI.equalsIgnoreCase(this.mParser.getName())) {
                    LtaWifiScanResult ltaWifiScanResult = new LtaWifiScanResult(getAdjustedTimeSinceBoot(max), parseLong);
                    if (isSet(this.mPlaybackOptions.getTechnologies(), 2)) {
                        list.add(ltaWifiScanResult);
                    }
                    pullWifiMeasurements(ltaWifiScanResult);
                } else if (E_NR.equalsIgnoreCase(this.mParser.getName())) {
                    LtaCellMeasurement pullNrMeasurement = pullNrMeasurement(getAdjustedTimeSinceBoot(max), parseLong);
                    if (isSet(this.mPlaybackOptions.getTechnologies(), 1)) {
                        list.add(pullNrMeasurement);
                    }
                } else {
                    this.mParser.next();
                }
            } else if (this.mParser.getEventType() != 3) {
                this.mParser.next();
            } else if (!E_ODNPMEASUREMENTS.equalsIgnoreCase(this.mParser.getName())) {
                this.mParser.next();
            } else {
                return;
            }
        } while (!isEof());
    }

    public LtaCellMeasurement pullTdscdmaMeasurement(long j, long j2) throws XmlPullParserException, IOException {
        boolean z = false;
        Log.v(TAG, "pullTdscdmaMeasurement", new Object[0]);
        CellMeasurement cellMeasurement = new CellMeasurement();
        cellMeasurement.type = CellMeasurement.RANType.UTRATDD;
        cellMeasurement.gciL1Value = getIntAttribute(A_MCC);
        cellMeasurement.gciL2Value = getIntAttribute(A_MNC);
        int optionalIntAttribute = getOptionalIntAttribute(A_LAC, -1);
        cellMeasurement.gciL3Value = optionalIntAttribute;
        cellMeasurement.hasGciL3Value = optionalIntAttribute != -1;
        int optionalIntAttribute2 = getOptionalIntAttribute(A_CID, -1);
        cellMeasurement.gciL4Value = optionalIntAttribute2;
        if (optionalIntAttribute2 != -1) {
            z = true;
        }
        cellMeasurement.hasGciL4Value = z;
        cellMeasurement.simulated = true;
        pullToEndTag(E_TDSCDMA);
        return new LtaCellMeasurement(cellMeasurement, j, j2);
    }

    public void pullToEndTag(String str) throws XmlPullParserException, IOException {
        Log.v(TAG, "pullToEndTag name: %s", str);
        if (!isEof()) {
            do {
                if (this.mParser.getEventType() != 3 || !str.equalsIgnoreCase(this.mParser.getName())) {
                    this.mParser.next();
                } else {
                    return;
                }
            } while (!isEof());
        }
    }

    public LtaCellMeasurement pullWcdmaMeasurement(long j, long j2) throws XmlPullParserException, IOException {
        boolean z = false;
        Log.v(TAG, "pullWcdmaMeasurement", new Object[0]);
        CellMeasurement cellMeasurement = new CellMeasurement();
        cellMeasurement.type = CellMeasurement.RANType.UTRAFDD;
        cellMeasurement.gciL1Value = getIntAttribute(A_MCC);
        cellMeasurement.gciL2Value = getIntAttribute(A_MNC);
        int optionalIntAttribute = getOptionalIntAttribute(A_LAC, -1);
        cellMeasurement.gciL3Value = optionalIntAttribute;
        cellMeasurement.hasGciL3Value = optionalIntAttribute != -1;
        int optionalIntAttribute2 = getOptionalIntAttribute(A_CID, -1);
        cellMeasurement.gciL4Value = optionalIntAttribute2;
        if (optionalIntAttribute2 != -1) {
            z = true;
        }
        cellMeasurement.hasGciL4Value = z;
        cellMeasurement.simulated = true;
        pullToEndTag(E_WCDMA);
        return new LtaCellMeasurement(cellMeasurement, j, j2);
    }

    public void pullWifiMeasurements(LtaWifiScanResult ltaWifiScanResult) throws XmlPullParserException, IOException {
        Log.v(TAG, "pullWifiMeasurements", new Object[0]);
        while (!isEof()) {
            if (this.mParser.getEventType() == 2) {
                if (E_WIFI.equalsIgnoreCase(this.mParser.getName())) {
                    if (!getOptionalBooleanAttribute(A_POS, true)) {
                        Log.v(TAG, "ignoring Wi-Fi AP with pos=\"false\"", new Object[0]);
                        this.mParser.next();
                    } else {
                        WifiMeasurement wifiMeasurement = new WifiMeasurement();
                        wifiMeasurement.bssid = WifiMeasurement.toMac64(formatBSSID(getAttributeValue(A_MAC)));
                        String attributeValue = getAttributeValue(A_SSID);
                        wifiMeasurement.ssid = attributeValue;
                        if (attributeValue == null || attributeValue.length() == 0) {
                            wifiMeasurement.ssid = wifiMeasurement.bssid;
                        }
                        wifiMeasurement.rxLevel = getOptionalIntAttribute(A_RX, Integer.MAX_VALUE);
                        long optionalLongAttribute = getOptionalLongAttribute(A_TIMESTAMP, Long.MIN_VALUE);
                        TimeUnit timeUnit = TimeUnit.SECONDS;
                        wifiMeasurement.elapsedRealtimeTimeStamp = timeUnit.toMillis(optionalLongAttribute);
                        wifiMeasurement.timeStamp = optionalLongAttribute;
                        wifiMeasurement.tsf = timeUnit.toMillis(optionalLongAttribute);
                        ltaWifiScanResult.addWifiScan(wifiMeasurement);
                    }
                } else {
                    return;
                }
            } else if (this.mParser.getEventType() == 3 && !E_WIFI.equalsIgnoreCase(this.mParser.getName())) {
                return;
            }
            this.mParser.next();
        }
    }

    public void setInput(Reader reader) throws Exception {
        this.mTimeCalculator = null;
        this.mParser.setInput(reader);
    }

    public LtaPullParser(PlaybackOptions playbackOptions) throws XmlPullParserException {
        this(XmlPullParserFactory.newInstance().newPullParser(), playbackOptions);
    }

    public LtaPullParser(Reader reader) throws XmlPullParserException {
        this(XmlPullParserFactory.newInstance().newPullParser(), new PlaybackOptions().setMode(PlaybackOptions.Mode.Immediate).setFlag(1));
        this.mParser.setInput(reader);
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
    }
}
