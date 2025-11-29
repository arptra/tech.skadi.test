package com.google.android.datatransport.cct;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.cct.internal.AndroidClientInfo;
import com.google.android.datatransport.cct.internal.BatchedLogRequest;
import com.google.android.datatransport.cct.internal.ClientInfo;
import com.google.android.datatransport.cct.internal.LogEvent;
import com.google.android.datatransport.cct.internal.LogRequest;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;
import com.google.android.datatransport.cct.internal.QosTier;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.retries.Retries;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.firebase.encoders.DataEncoder;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;

final class CctTransportBackend implements TransportBackend {
    private static final String ACCEPT_ENCODING_HEADER_KEY = "Accept-Encoding";
    static final String API_KEY_HEADER_KEY = "X-Goog-Api-Key";
    private static final int CONNECTION_TIME_OUT = 30000;
    private static final String CONTENT_ENCODING_HEADER_KEY = "Content-Encoding";
    private static final String CONTENT_TYPE_HEADER_KEY = "Content-Type";
    private static final String GZIP_CONTENT_ENCODING = "gzip";
    private static final int INVALID_VERSION_CODE = -1;
    private static final String JSON_CONTENT_TYPE = "application/json";
    private static final String KEY_APPLICATION_BUILD = "application_build";
    private static final String KEY_COUNTRY = "country";
    private static final String KEY_DEVICE = "device";
    private static final String KEY_FINGERPRINT = "fingerprint";
    private static final String KEY_HARDWARE = "hardware";
    private static final String KEY_LOCALE = "locale";
    private static final String KEY_MANUFACTURER = "manufacturer";
    private static final String KEY_MCC_MNC = "mcc_mnc";
    @VisibleForTesting
    static final String KEY_MOBILE_SUBTYPE = "mobile-subtype";
    private static final String KEY_MODEL = "model";
    @VisibleForTesting
    static final String KEY_NETWORK_TYPE = "net-type";
    private static final String KEY_OS_BUILD = "os-uild";
    private static final String KEY_PRODUCT = "product";
    private static final String KEY_SDK_VERSION = "sdk-version";
    private static final String KEY_TIMEZONE_OFFSET = "tz-offset";
    private static final String LOG_TAG = "CctTransportBackend";
    private static final int READ_TIME_OUT = 40000;
    private final Context applicationContext;
    private final ConnectivityManager connectivityManager;
    private final DataEncoder dataEncoder;
    final URL endPoint;
    private final int readTimeout;
    private final Clock uptimeClock;
    private final Clock wallTimeClock;

    public static final class HttpRequest {
        @Nullable
        final String apiKey;
        final BatchedLogRequest requestBody;
        final URL url;

        public HttpRequest(URL url2, BatchedLogRequest batchedLogRequest, @Nullable String str) {
            this.url = url2;
            this.requestBody = batchedLogRequest;
            this.apiKey = str;
        }

        public HttpRequest withUrl(URL url2) {
            return new HttpRequest(url2, this.requestBody, this.apiKey);
        }
    }

    public static final class HttpResponse {
        final int code;
        final long nextRequestMillis;
        @Nullable
        final URL redirectUrl;

        public HttpResponse(int i, @Nullable URL url, long j) {
            this.code = i;
            this.redirectUrl = url;
            this.nextRequestMillis = j;
        }
    }

    public CctTransportBackend(Context context, Clock clock, Clock clock2, int i) {
        this.dataEncoder = BatchedLogRequest.createDataEncoder();
        this.applicationContext = context;
        this.connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        this.endPoint = parseUrlOrThrow(CCTDestination.DEFAULT_END_POINT);
        this.uptimeClock = clock2;
        this.wallTimeClock = clock;
        this.readTimeout = i;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x0117 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:56:0x0135 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x013b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.datatransport.cct.CctTransportBackend.HttpResponse doSend(com.google.android.datatransport.cct.CctTransportBackend.HttpRequest r12) throws java.io.IOException {
        /*
            r11 = this;
            java.net.URL r0 = r12.url
            java.lang.String r1 = "CctTransportBackend"
            java.lang.String r2 = "Making request to: %s"
            com.google.android.datatransport.runtime.logging.Logging.d((java.lang.String) r1, (java.lang.String) r2, (java.lang.Object) r0)
            java.net.URL r0 = r12.url
            java.net.URLConnection r0 = r0.openConnection()
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0
            r2 = 30000(0x7530, float:4.2039E-41)
            r0.setConnectTimeout(r2)
            int r2 = r11.readTimeout
            r0.setReadTimeout(r2)
            r2 = 1
            r0.setDoOutput(r2)
            r2 = 0
            r0.setInstanceFollowRedirects(r2)
            java.lang.String r2 = "POST"
            r0.setRequestMethod(r2)
            java.lang.String r2 = "2.3.3"
            java.lang.Object[] r2 = new java.lang.Object[]{r2}
            java.lang.String r3 = "datatransport/%s android/"
            java.lang.String r2 = java.lang.String.format(r3, r2)
            java.lang.String r3 = "User-Agent"
            r0.setRequestProperty(r3, r2)
            java.lang.String r2 = "Content-Encoding"
            java.lang.String r3 = "gzip"
            r0.setRequestProperty(r2, r3)
            java.lang.String r4 = "application/json"
            java.lang.String r5 = "Content-Type"
            r0.setRequestProperty(r5, r4)
            java.lang.String r4 = "Accept-Encoding"
            r0.setRequestProperty(r4, r3)
            java.lang.String r3 = r12.apiKey
            if (r3 == 0) goto L_0x0055
            java.lang.String r4 = "X-Goog-Api-Key"
            r0.setRequestProperty(r4, r3)
        L_0x0055:
            r3 = 0
            r6 = 0
            java.io.OutputStream r7 = r0.getOutputStream()     // Catch:{ ConnectException | UnknownHostException -> 0x007e, EncodingException | IOException -> 0x007b }
            java.util.zip.GZIPOutputStream r8 = new java.util.zip.GZIPOutputStream     // Catch:{ all -> 0x012f }
            r8.<init>(r7)     // Catch:{ all -> 0x012f }
            com.google.firebase.encoders.DataEncoder r11 = r11.dataEncoder     // Catch:{ all -> 0x0131 }
            com.google.android.datatransport.cct.internal.BatchedLogRequest r12 = r12.requestBody     // Catch:{ all -> 0x0131 }
            java.io.BufferedWriter r9 = new java.io.BufferedWriter     // Catch:{ all -> 0x0131 }
            java.io.OutputStreamWriter r10 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x0131 }
            r10.<init>(r8)     // Catch:{ all -> 0x0131 }
            r9.<init>(r10)     // Catch:{ all -> 0x0131 }
            r11.encode(r12, r9)     // Catch:{ all -> 0x0131 }
            r8.close()     // Catch:{ all -> 0x012f }
            if (r7 == 0) goto L_0x0081
            r7.close()     // Catch:{ ConnectException | UnknownHostException -> 0x007e, EncodingException | IOException -> 0x007b }
            goto L_0x0081
        L_0x007b:
            r11 = move-exception
            goto L_0x013c
        L_0x007e:
            r11 = move-exception
            goto L_0x0149
        L_0x0081:
            int r11 = r0.getResponseCode()
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r7 = "Status Code: "
            r12.append(r7)
            r12.append(r11)
            java.lang.String r12 = r12.toString()
            com.google.android.datatransport.runtime.logging.Logging.i(r1, r12)
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r7 = "Content-Type: "
            r12.append(r7)
            java.lang.String r5 = r0.getHeaderField(r5)
            r12.append(r5)
            java.lang.String r12 = r12.toString()
            com.google.android.datatransport.runtime.logging.Logging.i(r1, r12)
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r5 = "Content-Encoding: "
            r12.append(r5)
            java.lang.String r5 = r0.getHeaderField(r2)
            r12.append(r5)
            java.lang.String r12 = r12.toString()
            com.google.android.datatransport.runtime.logging.Logging.i(r1, r12)
            r12 = 302(0x12e, float:4.23E-43)
            if (r11 == r12) goto L_0x011e
            r12 = 301(0x12d, float:4.22E-43)
            if (r11 == r12) goto L_0x011e
            r12 = 307(0x133, float:4.3E-43)
            if (r11 != r12) goto L_0x00d6
            goto L_0x011e
        L_0x00d6:
            r12 = 200(0xc8, float:2.8E-43)
            if (r11 == r12) goto L_0x00e0
            com.google.android.datatransport.cct.CctTransportBackend$HttpResponse r12 = new com.google.android.datatransport.cct.CctTransportBackend$HttpResponse
            r12.<init>(r11, r6, r3)
            return r12
        L_0x00e0:
            java.io.InputStream r12 = r0.getInputStream()
            java.lang.String r0 = r0.getHeaderField(r2)     // Catch:{ all -> 0x0109 }
            java.io.InputStream r0 = maybeUnGzip(r12, r0)     // Catch:{ all -> 0x0109 }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ all -> 0x0111 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x0111 }
            r2.<init>(r0)     // Catch:{ all -> 0x0111 }
            r1.<init>(r2)     // Catch:{ all -> 0x0111 }
            com.google.android.datatransport.cct.internal.LogResponse r1 = com.google.android.datatransport.cct.internal.LogResponse.fromJson(r1)     // Catch:{ all -> 0x0111 }
            long r1 = r1.getNextRequestWaitMillis()     // Catch:{ all -> 0x0111 }
            com.google.android.datatransport.cct.CctTransportBackend$HttpResponse r3 = new com.google.android.datatransport.cct.CctTransportBackend$HttpResponse     // Catch:{ all -> 0x0111 }
            r3.<init>(r11, r6, r1)     // Catch:{ all -> 0x0111 }
            if (r0 == 0) goto L_0x010b
            r0.close()     // Catch:{ all -> 0x0109 }
            goto L_0x010b
        L_0x0109:
            r11 = move-exception
            goto L_0x0118
        L_0x010b:
            if (r12 == 0) goto L_0x0110
            r12.close()
        L_0x0110:
            return r3
        L_0x0111:
            r11 = move-exception
            if (r0 == 0) goto L_0x0117
            r0.close()     // Catch:{ all -> 0x0117 }
        L_0x0117:
            throw r11     // Catch:{ all -> 0x0109 }
        L_0x0118:
            if (r12 == 0) goto L_0x011d
            r12.close()     // Catch:{ all -> 0x011d }
        L_0x011d:
            throw r11
        L_0x011e:
            java.lang.String r12 = "Location"
            java.lang.String r12 = r0.getHeaderField(r12)
            com.google.android.datatransport.cct.CctTransportBackend$HttpResponse r0 = new com.google.android.datatransport.cct.CctTransportBackend$HttpResponse
            java.net.URL r1 = new java.net.URL
            r1.<init>(r12)
            r0.<init>(r11, r1, r3)
            return r0
        L_0x012f:
            r11 = move-exception
            goto L_0x0136
        L_0x0131:
            r11 = move-exception
            r8.close()     // Catch:{ all -> 0x0135 }
        L_0x0135:
            throw r11     // Catch:{ all -> 0x012f }
        L_0x0136:
            if (r7 == 0) goto L_0x013b
            r7.close()     // Catch:{ all -> 0x013b }
        L_0x013b:
            throw r11     // Catch:{ ConnectException | UnknownHostException -> 0x007e, EncodingException | IOException -> 0x007b }
        L_0x013c:
            java.lang.String r12 = "Couldn't encode request, returning with 400"
            com.google.android.datatransport.runtime.logging.Logging.e(r1, r12, r11)
            com.google.android.datatransport.cct.CctTransportBackend$HttpResponse r11 = new com.google.android.datatransport.cct.CctTransportBackend$HttpResponse
            r12 = 400(0x190, float:5.6E-43)
            r11.<init>(r12, r6, r3)
            return r11
        L_0x0149:
            java.lang.String r12 = "Couldn't open connection, returning with 500"
            com.google.android.datatransport.runtime.logging.Logging.e(r1, r12, r11)
            com.google.android.datatransport.cct.CctTransportBackend$HttpResponse r11 = new com.google.android.datatransport.cct.CctTransportBackend$HttpResponse
            r12 = 500(0x1f4, float:7.0E-43)
            r11.<init>(r12, r6, r3)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.cct.CctTransportBackend.doSend(com.google.android.datatransport.cct.CctTransportBackend$HttpRequest):com.google.android.datatransport.cct.CctTransportBackend$HttpResponse");
    }

    private static int getNetSubtypeValue(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return NetworkConnectionInfo.MobileSubtype.UNKNOWN_MOBILE_SUBTYPE.getValue();
        }
        int subtype = networkInfo.getSubtype();
        if (subtype == -1) {
            return NetworkConnectionInfo.MobileSubtype.COMBINED.getValue();
        }
        if (NetworkConnectionInfo.MobileSubtype.forNumber(subtype) != null) {
            return subtype;
        }
        return 0;
    }

    private static int getNetTypeValue(NetworkInfo networkInfo) {
        return networkInfo == null ? NetworkConnectionInfo.NetworkType.NONE.getValue() : networkInfo.getType();
    }

    private static int getPackageVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            Logging.e(LOG_TAG, "Unable to find version code for package", e);
            return -1;
        }
    }

    private BatchedLogRequest getRequestBody(BackendRequest backendRequest) {
        LogEvent.Builder builder;
        HashMap hashMap = new HashMap();
        for (EventInternal next : backendRequest.getEvents()) {
            String transportName = next.getTransportName();
            if (!hashMap.containsKey(transportName)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(next);
                hashMap.put(transportName, arrayList);
            } else {
                ((List) hashMap.get(transportName)).add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            EventInternal eventInternal = (EventInternal) ((List) entry.getValue()).get(0);
            LogRequest.Builder clientInfo = LogRequest.builder().setQosTier(QosTier.DEFAULT).setRequestTimeMs(this.wallTimeClock.getTime()).setRequestUptimeMs(this.uptimeClock.getTime()).setClientInfo(ClientInfo.builder().setClientType(ClientInfo.ClientType.ANDROID_FIREBASE).setAndroidClientInfo(AndroidClientInfo.builder().setSdkVersion(Integer.valueOf(eventInternal.getInteger(KEY_SDK_VERSION))).setModel(eventInternal.get("model")).setHardware(eventInternal.get(KEY_HARDWARE)).setDevice(eventInternal.get(KEY_DEVICE)).setProduct(eventInternal.get(KEY_PRODUCT)).setOsBuild(eventInternal.get(KEY_OS_BUILD)).setManufacturer(eventInternal.get(KEY_MANUFACTURER)).setFingerprint(eventInternal.get(KEY_FINGERPRINT)).setCountry(eventInternal.get("country")).setLocale(eventInternal.get(KEY_LOCALE)).setMccMnc(eventInternal.get(KEY_MCC_MNC)).setApplicationBuild(eventInternal.get(KEY_APPLICATION_BUILD)).build()).build());
            try {
                clientInfo.setSource(Integer.parseInt((String) entry.getKey()));
            } catch (NumberFormatException unused) {
                clientInfo.setSource((String) entry.getKey());
            }
            ArrayList arrayList3 = new ArrayList();
            for (EventInternal eventInternal2 : (List) entry.getValue()) {
                EncodedPayload encodedPayload = eventInternal2.getEncodedPayload();
                Encoding encoding = encodedPayload.getEncoding();
                if (encoding.equals(Encoding.of("proto"))) {
                    builder = LogEvent.protoBuilder(encodedPayload.getBytes());
                } else if (encoding.equals(Encoding.of("json"))) {
                    builder = LogEvent.jsonBuilder(new String(encodedPayload.getBytes(), Charset.forName("UTF-8")));
                } else {
                    Logging.w(LOG_TAG, "Received event of unsupported encoding %s. Skipping...", encoding);
                }
                builder.setEventTimeMs(eventInternal2.getEventMillis()).setEventUptimeMs(eventInternal2.getUptimeMillis()).setTimezoneOffsetSeconds(eventInternal2.getLong(KEY_TIMEZONE_OFFSET)).setNetworkConnectionInfo(NetworkConnectionInfo.builder().setNetworkType(NetworkConnectionInfo.NetworkType.forNumber(eventInternal2.getInteger(KEY_NETWORK_TYPE))).setMobileSubtype(NetworkConnectionInfo.MobileSubtype.forNumber(eventInternal2.getInteger(KEY_MOBILE_SUBTYPE))).build());
                if (eventInternal2.getCode() != null) {
                    builder.setEventCode(eventInternal2.getCode());
                }
                arrayList3.add(builder.build());
            }
            clientInfo.setLogEvents(arrayList3);
            arrayList2.add(clientInfo.build());
        }
        return BatchedLogRequest.create(arrayList2);
    }

    private static TelephonyManager getTelephonyManager(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    @VisibleForTesting
    public static long getTzOffset() {
        Calendar.getInstance();
        return (long) (TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000);
    }

    public static /* synthetic */ HttpRequest lambda$send$0(HttpRequest httpRequest, HttpResponse httpResponse) {
        URL url = httpResponse.redirectUrl;
        if (url == null) {
            return null;
        }
        Logging.d(LOG_TAG, "Following redirect to: %s", (Object) url);
        return httpRequest.withUrl(httpResponse.redirectUrl);
    }

    private static InputStream maybeUnGzip(InputStream inputStream, String str) throws IOException {
        return "gzip".equals(str) ? new GZIPInputStream(inputStream) : inputStream;
    }

    private static URL parseUrlOrThrow(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Invalid url: " + str, e);
        }
    }

    public EventInternal decorate(EventInternal eventInternal) {
        NetworkInfo activeNetworkInfo = this.connectivityManager.getActiveNetworkInfo();
        return eventInternal.toBuilder().addMetadata(KEY_SDK_VERSION, Build.VERSION.SDK_INT).addMetadata("model", Build.MODEL).addMetadata(KEY_HARDWARE, Build.HARDWARE).addMetadata(KEY_DEVICE, Build.DEVICE).addMetadata(KEY_PRODUCT, Build.PRODUCT).addMetadata(KEY_OS_BUILD, Build.ID).addMetadata(KEY_MANUFACTURER, Build.MANUFACTURER).addMetadata(KEY_FINGERPRINT, Build.FINGERPRINT).addMetadata(KEY_TIMEZONE_OFFSET, getTzOffset()).addMetadata(KEY_NETWORK_TYPE, getNetTypeValue(activeNetworkInfo)).addMetadata(KEY_MOBILE_SUBTYPE, getNetSubtypeValue(activeNetworkInfo)).addMetadata("country", Locale.getDefault().getCountry()).addMetadata(KEY_LOCALE, Locale.getDefault().getLanguage()).addMetadata(KEY_MCC_MNC, getTelephonyManager(this.applicationContext).getSimOperator()).addMetadata(KEY_APPLICATION_BUILD, Integer.toString(getPackageVersionCode(this.applicationContext))).build();
    }

    public BackendResponse send(BackendRequest backendRequest) {
        BatchedLogRequest requestBody = getRequestBody(backendRequest);
        URL url = this.endPoint;
        String str = null;
        if (backendRequest.getExtras() != null) {
            try {
                CCTDestination fromByteArray = CCTDestination.fromByteArray(backendRequest.getExtras());
                if (fromByteArray.getAPIKey() != null) {
                    str = fromByteArray.getAPIKey();
                }
                if (fromByteArray.getEndPoint() != null) {
                    url = parseUrlOrThrow(fromByteArray.getEndPoint());
                }
            } catch (IllegalArgumentException unused) {
                return BackendResponse.fatalError();
            }
        }
        try {
            HttpResponse httpResponse = (HttpResponse) Retries.retry(5, new HttpRequest(url, requestBody, str), CctTransportBackend$$Lambda$1.lambdaFactory$(this), CctTransportBackend$$Lambda$4.lambdaFactory$());
            int i = httpResponse.code;
            if (i == 200) {
                return BackendResponse.ok(httpResponse.nextRequestMillis);
            }
            if (i < 500) {
                if (i != 404) {
                    return BackendResponse.fatalError();
                }
            }
            return BackendResponse.transientError();
        } catch (IOException e) {
            Logging.e(LOG_TAG, "Could not make request to the backend", e);
            return BackendResponse.transientError();
        }
    }

    public CctTransportBackend(Context context, Clock clock, Clock clock2) {
        this(context, clock, clock2, READ_TIME_OUT);
    }
}
