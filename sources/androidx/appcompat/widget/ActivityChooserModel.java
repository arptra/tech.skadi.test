package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

class ActivityChooserModel extends DataSetObservable {
    public static final String n = "ActivityChooserModel";
    public static final Object o = new Object();
    public static final Map p = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public final Object f264a = new Object();
    public final List b = new ArrayList();
    public final List c = new ArrayList();
    public final Context d;
    public final String e;
    public Intent f;
    public ActivitySorter g = new DefaultSorter();
    public int h = 50;
    public boolean i = true;
    public boolean j = false;
    public boolean k = true;
    public boolean l = false;
    public OnChooseActivityListener m;

    public interface ActivityChooserModelClient {
    }

    public static final class ActivityResolveInfo implements Comparable<ActivityResolveInfo> {

        /* renamed from: a  reason: collision with root package name */
        public final ResolveInfo f265a;
        public float b;

        public ActivityResolveInfo(ResolveInfo resolveInfo) {
            this.f265a = resolveInfo;
        }

        /* renamed from: a */
        public int compareTo(ActivityResolveInfo activityResolveInfo) {
            return Float.floatToIntBits(activityResolveInfo.b) - Float.floatToIntBits(this.b);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && ActivityResolveInfo.class == obj.getClass() && Float.floatToIntBits(this.b) == Float.floatToIntBits(((ActivityResolveInfo) obj).b);
        }

        public int hashCode() {
            return Float.floatToIntBits(this.b) + 31;
        }

        public String toString() {
            return "[" + "resolveInfo:" + this.f265a.toString() + "; weight:" + new BigDecimal((double) this.b) + "]";
        }
    }

    public interface ActivitySorter {
        void a(Intent intent, List list, List list2);
    }

    public static final class DefaultSorter implements ActivitySorter {

        /* renamed from: a  reason: collision with root package name */
        public final Map f266a = new HashMap();

        public void a(Intent intent, List list, List list2) {
            Map map = this.f266a;
            map.clear();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ActivityResolveInfo activityResolveInfo = (ActivityResolveInfo) list.get(i);
                activityResolveInfo.b = 0.0f;
                ActivityInfo activityInfo = activityResolveInfo.f265a.activityInfo;
                map.put(new ComponentName(activityInfo.packageName, activityInfo.name), activityResolveInfo);
            }
            float f = 1.0f;
            for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
                HistoricalRecord historicalRecord = (HistoricalRecord) list2.get(size2);
                ActivityResolveInfo activityResolveInfo2 = (ActivityResolveInfo) map.get(historicalRecord.f267a);
                if (activityResolveInfo2 != null) {
                    activityResolveInfo2.b += historicalRecord.c * f;
                    f *= 0.95f;
                }
            }
            Collections.sort(list);
        }
    }

    public static final class HistoricalRecord {

        /* renamed from: a  reason: collision with root package name */
        public final ComponentName f267a;
        public final long b;
        public final float c;

        public HistoricalRecord(String str, long j, float f) {
            this(ComponentName.unflattenFromString(str), j, f);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || HistoricalRecord.class != obj.getClass()) {
                return false;
            }
            HistoricalRecord historicalRecord = (HistoricalRecord) obj;
            ComponentName componentName = this.f267a;
            if (componentName == null) {
                if (historicalRecord.f267a != null) {
                    return false;
                }
            } else if (!componentName.equals(historicalRecord.f267a)) {
                return false;
            }
            return this.b == historicalRecord.b && Float.floatToIntBits(this.c) == Float.floatToIntBits(historicalRecord.c);
        }

        public int hashCode() {
            ComponentName componentName = this.f267a;
            int hashCode = componentName == null ? 0 : componentName.hashCode();
            long j = this.b;
            return ((((hashCode + 31) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + Float.floatToIntBits(this.c);
        }

        public String toString() {
            return "[" + "; activity:" + this.f267a + "; time:" + this.b + "; weight:" + new BigDecimal((double) this.c) + "]";
        }

        public HistoricalRecord(ComponentName componentName, long j, float f) {
            this.f267a = componentName;
            this.b = j;
            this.c = f;
        }
    }

    public interface OnChooseActivityListener {
        boolean a(ActivityChooserModel activityChooserModel, Intent intent);
    }

    public final class PersistHistoryAsyncTask extends AsyncTask<Object, Void, Void> {
        public PersistHistoryAsyncTask() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0074, code lost:
            if (r15 != null) goto L_0x0076;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            r15.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0096, code lost:
            if (r15 == null) goto L_0x00d7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b5, code lost:
            if (r15 == null) goto L_0x00d7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x00d4, code lost:
            if (r15 == null) goto L_0x00d7;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void doInBackground(java.lang.Object... r15) {
            /*
                r14 = this;
                java.lang.String r0 = "historical-record"
                java.lang.String r1 = "historical-records"
                java.lang.String r2 = "Error writing historical record file: "
                r3 = 0
                r4 = r15[r3]
                java.util.List r4 = (java.util.List) r4
                r5 = 1
                r15 = r15[r5]
                java.lang.String r15 = (java.lang.String) r15
                r6 = 0
                androidx.appcompat.widget.ActivityChooserModel r7 = androidx.appcompat.widget.ActivityChooserModel.this     // Catch:{ FileNotFoundException -> 0x00e2 }
                android.content.Context r7 = r7.d     // Catch:{ FileNotFoundException -> 0x00e2 }
                java.io.FileOutputStream r15 = r7.openFileOutput(r15, r3)     // Catch:{ FileNotFoundException -> 0x00e2 }
                org.xmlpull.v1.XmlSerializer r7 = android.util.Xml.newSerializer()
                r7.setOutput(r15, r6)     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                java.lang.String r8 = "UTF-8"
                java.lang.Boolean r9 = java.lang.Boolean.TRUE     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                r7.startDocument(r8, r9)     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                r7.startTag(r6, r1)     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                int r8 = r4.size()     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                r9 = r3
            L_0x002f:
                if (r9 >= r8) goto L_0x006a
                java.lang.Object r10 = r4.remove(r3)     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                androidx.appcompat.widget.ActivityChooserModel$HistoricalRecord r10 = (androidx.appcompat.widget.ActivityChooserModel.HistoricalRecord) r10     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                r7.startTag(r6, r0)     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                java.lang.String r11 = "activity"
                android.content.ComponentName r12 = r10.f267a     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                java.lang.String r12 = r12.flattenToString()     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                r7.attribute(r6, r11, r12)     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                java.lang.String r11 = "time"
                long r12 = r10.b     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                r7.attribute(r6, r11, r12)     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                java.lang.String r11 = "weight"
                float r10 = r10.c     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                r7.attribute(r6, r11, r10)     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                r7.endTag(r6, r0)     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                int r9 = r9 + 1
                goto L_0x002f
            L_0x0061:
                r0 = move-exception
                goto L_0x00d8
            L_0x0064:
                r0 = move-exception
                goto L_0x007a
            L_0x0066:
                r0 = move-exception
                goto L_0x0099
            L_0x0068:
                r0 = move-exception
                goto L_0x00b8
            L_0x006a:
                r7.endTag(r6, r1)     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                r7.endDocument()     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                androidx.appcompat.widget.ActivityChooserModel r14 = androidx.appcompat.widget.ActivityChooserModel.this
                r14.i = r5
                if (r15 == 0) goto L_0x00d7
            L_0x0076:
                r15.close()     // Catch:{ IOException -> 0x00d7 }
                goto L_0x00d7
            L_0x007a:
                java.lang.String r1 = androidx.appcompat.widget.ActivityChooserModel.n     // Catch:{ all -> 0x0061 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0061 }
                r3.<init>()     // Catch:{ all -> 0x0061 }
                r3.append(r2)     // Catch:{ all -> 0x0061 }
                androidx.appcompat.widget.ActivityChooserModel r2 = androidx.appcompat.widget.ActivityChooserModel.this     // Catch:{ all -> 0x0061 }
                java.lang.String r2 = r2.e     // Catch:{ all -> 0x0061 }
                r3.append(r2)     // Catch:{ all -> 0x0061 }
                java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0061 }
                android.util.Log.e(r1, r2, r0)     // Catch:{ all -> 0x0061 }
                androidx.appcompat.widget.ActivityChooserModel r14 = androidx.appcompat.widget.ActivityChooserModel.this
                r14.i = r5
                if (r15 == 0) goto L_0x00d7
                goto L_0x0076
            L_0x0099:
                java.lang.String r1 = androidx.appcompat.widget.ActivityChooserModel.n     // Catch:{ all -> 0x0061 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0061 }
                r3.<init>()     // Catch:{ all -> 0x0061 }
                r3.append(r2)     // Catch:{ all -> 0x0061 }
                androidx.appcompat.widget.ActivityChooserModel r2 = androidx.appcompat.widget.ActivityChooserModel.this     // Catch:{ all -> 0x0061 }
                java.lang.String r2 = r2.e     // Catch:{ all -> 0x0061 }
                r3.append(r2)     // Catch:{ all -> 0x0061 }
                java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0061 }
                android.util.Log.e(r1, r2, r0)     // Catch:{ all -> 0x0061 }
                androidx.appcompat.widget.ActivityChooserModel r14 = androidx.appcompat.widget.ActivityChooserModel.this
                r14.i = r5
                if (r15 == 0) goto L_0x00d7
                goto L_0x0076
            L_0x00b8:
                java.lang.String r1 = androidx.appcompat.widget.ActivityChooserModel.n     // Catch:{ all -> 0x0061 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0061 }
                r3.<init>()     // Catch:{ all -> 0x0061 }
                r3.append(r2)     // Catch:{ all -> 0x0061 }
                androidx.appcompat.widget.ActivityChooserModel r2 = androidx.appcompat.widget.ActivityChooserModel.this     // Catch:{ all -> 0x0061 }
                java.lang.String r2 = r2.e     // Catch:{ all -> 0x0061 }
                r3.append(r2)     // Catch:{ all -> 0x0061 }
                java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0061 }
                android.util.Log.e(r1, r2, r0)     // Catch:{ all -> 0x0061 }
                androidx.appcompat.widget.ActivityChooserModel r14 = androidx.appcompat.widget.ActivityChooserModel.this
                r14.i = r5
                if (r15 == 0) goto L_0x00d7
                goto L_0x0076
            L_0x00d7:
                return r6
            L_0x00d8:
                androidx.appcompat.widget.ActivityChooserModel r14 = androidx.appcompat.widget.ActivityChooserModel.this
                r14.i = r5
                if (r15 == 0) goto L_0x00e1
                r15.close()     // Catch:{ IOException -> 0x00e1 }
            L_0x00e1:
                throw r0
            L_0x00e2:
                r14 = move-exception
                java.lang.String r0 = androidx.appcompat.widget.ActivityChooserModel.n
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r2)
                r1.append(r15)
                java.lang.String r15 = r1.toString()
                android.util.Log.e(r0, r15, r14)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActivityChooserModel.PersistHistoryAsyncTask.doInBackground(java.lang.Object[]):java.lang.Void");
        }
    }

    public ActivityChooserModel(Context context, String str) {
        this.d = context.getApplicationContext();
        if (TextUtils.isEmpty(str) || str.endsWith(".xml")) {
            this.e = str;
            return;
        }
        this.e = str + ".xml";
    }

    public static ActivityChooserModel d(Context context, String str) {
        ActivityChooserModel activityChooserModel;
        synchronized (o) {
            try {
                Map map = p;
                activityChooserModel = (ActivityChooserModel) map.get(str);
                if (activityChooserModel == null) {
                    activityChooserModel = new ActivityChooserModel(context, str);
                    map.put(str, activityChooserModel);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return activityChooserModel;
    }

    public final boolean a(HistoricalRecord historicalRecord) {
        boolean add = this.c.add(historicalRecord);
        if (add) {
            this.k = true;
            l();
            k();
            p();
            notifyChanged();
        }
        return add;
    }

    public Intent b(int i2) {
        synchronized (this.f264a) {
            try {
                if (this.f == null) {
                    return null;
                }
                c();
                ActivityInfo activityInfo = ((ActivityResolveInfo) this.b.get(i2)).f265a.activityInfo;
                ComponentName componentName = new ComponentName(activityInfo.packageName, activityInfo.name);
                Intent intent = new Intent(this.f);
                intent.setComponent(componentName);
                if (this.m != null) {
                    if (this.m.a(this, new Intent(intent))) {
                        return null;
                    }
                }
                a(new HistoricalRecord(componentName, System.currentTimeMillis(), 1.0f));
                return intent;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c() {
        boolean j2 = j() | m();
        l();
        if (j2) {
            p();
            notifyChanged();
        }
    }

    public ResolveInfo e(int i2) {
        ResolveInfo resolveInfo;
        synchronized (this.f264a) {
            c();
            resolveInfo = ((ActivityResolveInfo) this.b.get(i2)).f265a;
        }
        return resolveInfo;
    }

    public int f() {
        int size;
        synchronized (this.f264a) {
            c();
            size = this.b.size();
        }
        return size;
    }

    public int g(ResolveInfo resolveInfo) {
        synchronized (this.f264a) {
            try {
                c();
                List list = this.b;
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (((ActivityResolveInfo) list.get(i2)).f265a == resolveInfo) {
                        return i2;
                    }
                }
                return -1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public ResolveInfo h() {
        synchronized (this.f264a) {
            try {
                c();
                if (this.b.isEmpty()) {
                    return null;
                }
                ResolveInfo resolveInfo = ((ActivityResolveInfo) this.b.get(0)).f265a;
                return resolveInfo;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int i() {
        int size;
        synchronized (this.f264a) {
            c();
            size = this.c.size();
        }
        return size;
    }

    public final boolean j() {
        if (!this.l || this.f == null) {
            return false;
        }
        this.l = false;
        this.b.clear();
        List<ResolveInfo> queryIntentActivities = this.d.getPackageManager().queryIntentActivities(this.f, 0);
        int size = queryIntentActivities.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.b.add(new ActivityResolveInfo(queryIntentActivities.get(i2)));
        }
        return true;
    }

    public final void k() {
        if (!this.j) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        } else if (this.k) {
            this.k = false;
            if (!TextUtils.isEmpty(this.e)) {
                new PersistHistoryAsyncTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[]{new ArrayList(this.c), this.e});
            }
        }
    }

    public final void l() {
        int size = this.c.size() - this.h;
        if (size > 0) {
            this.k = true;
            for (int i2 = 0; i2 < size; i2++) {
                HistoricalRecord historicalRecord = (HistoricalRecord) this.c.remove(0);
            }
        }
    }

    public final boolean m() {
        if (!this.i || !this.k || TextUtils.isEmpty(this.e)) {
            return false;
        }
        this.i = false;
        this.j = true;
        n();
        return true;
    }

    public final void n() {
        try {
            FileInputStream openFileInput = this.d.openFileInput(this.e);
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(openFileInput, "UTF-8");
                int i2 = 0;
                while (i2 != 1 && i2 != 2) {
                    i2 = newPullParser.next();
                }
                if ("historical-records".equals(newPullParser.getName())) {
                    List list = this.c;
                    list.clear();
                    while (true) {
                        int next = newPullParser.next();
                        if (next == 1) {
                            if (openFileInput == null) {
                                return;
                            }
                        } else if (!(next == 3 || next == 4)) {
                            if ("historical-record".equals(newPullParser.getName())) {
                                list.add(new HistoricalRecord(newPullParser.getAttributeValue((String) null, "activity"), Long.parseLong(newPullParser.getAttributeValue((String) null, RtspHeaders.Values.TIME)), Float.parseFloat(newPullParser.getAttributeValue((String) null, "weight"))));
                            } else {
                                throw new XmlPullParserException("Share records file not well-formed.");
                            }
                        }
                    }
                    try {
                        openFileInput.close();
                    } catch (IOException unused) {
                    }
                } else {
                    throw new XmlPullParserException("Share records file does not start with historical-records tag.");
                }
            } catch (XmlPullParserException e2) {
                String str = n;
                Log.e(str, "Error reading historical recrod file: " + this.e, e2);
                if (openFileInput == null) {
                }
            } catch (IOException e3) {
                String str2 = n;
                Log.e(str2, "Error reading historical recrod file: " + this.e, e3);
                if (openFileInput == null) {
                }
            } catch (Throwable th) {
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException unused3) {
        }
    }

    public void o(int i2) {
        synchronized (this.f264a) {
            try {
                c();
                ActivityResolveInfo activityResolveInfo = (ActivityResolveInfo) this.b.get(i2);
                ActivityResolveInfo activityResolveInfo2 = (ActivityResolveInfo) this.b.get(0);
                float f2 = activityResolveInfo2 != null ? (activityResolveInfo2.b - activityResolveInfo.b) + 5.0f : 1.0f;
                ActivityInfo activityInfo = activityResolveInfo.f265a.activityInfo;
                a(new HistoricalRecord(new ComponentName(activityInfo.packageName, activityInfo.name), System.currentTimeMillis(), f2));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean p() {
        if (this.g == null || this.f == null || this.b.isEmpty() || this.c.isEmpty()) {
            return false;
        }
        this.g.a(this.f, this.b, Collections.unmodifiableList(this.c));
        return true;
    }
}
