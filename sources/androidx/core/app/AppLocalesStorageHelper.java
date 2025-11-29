package androidx.core.app;

import androidx.annotation.RestrictTo;

@RestrictTo
public class AppLocalesStorageHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f647a = new Object();

    /* JADX WARNING: Can't wrap try/catch for region: R(5:14|15|(2:40|41)|42|43) */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0044, code lost:
        if (r2 != null) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0053, code lost:
        if (r2 == null) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x005a, code lost:
        if (r1.isEmpty() == false) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x005d, code lost:
        r8.deleteFile("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x0056 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x0069 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:32:0x0056=Splitter:B:32:0x0056, B:42:0x0069=Splitter:B:42:0x0069} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r8) {
        /*
            java.lang.Object r0 = f647a
            monitor-enter(r0)
            java.lang.String r1 = ""
            java.lang.String r2 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            java.io.FileInputStream r2 = r8.openFileInput(r2)     // Catch:{ FileNotFoundException -> 0x006a }
            org.xmlpull.v1.XmlPullParser r3 = android.util.Xml.newPullParser()     // Catch:{ IOException | XmlPullParserException -> 0x004c }
            java.lang.String r4 = "UTF-8"
            r3.setInput(r2, r4)     // Catch:{ IOException | XmlPullParserException -> 0x004c }
            int r4 = r3.getDepth()     // Catch:{ IOException | XmlPullParserException -> 0x004c }
        L_0x0018:
            int r5 = r3.next()     // Catch:{ IOException | XmlPullParserException -> 0x004c }
            r6 = 1
            if (r5 == r6) goto L_0x0044
            r6 = 3
            if (r5 != r6) goto L_0x002b
            int r7 = r3.getDepth()     // Catch:{ IOException | XmlPullParserException -> 0x004c }
            if (r7 <= r4) goto L_0x0044
            goto L_0x002b
        L_0x0029:
            r8 = move-exception
            goto L_0x0064
        L_0x002b:
            if (r5 == r6) goto L_0x0018
            r6 = 4
            if (r5 != r6) goto L_0x0031
            goto L_0x0018
        L_0x0031:
            java.lang.String r5 = r3.getName()     // Catch:{ IOException | XmlPullParserException -> 0x004c }
            java.lang.String r6 = "locales"
            boolean r5 = r5.equals(r6)     // Catch:{ IOException | XmlPullParserException -> 0x004c }
            if (r5 == 0) goto L_0x0018
            java.lang.String r4 = "application_locales"
            r5 = 0
            java.lang.String r1 = r3.getAttributeValue(r5, r4)     // Catch:{ IOException | XmlPullParserException -> 0x004c }
        L_0x0044:
            if (r2 == 0) goto L_0x0056
        L_0x0046:
            r2.close()     // Catch:{ IOException -> 0x0056 }
            goto L_0x0056
        L_0x004a:
            r8 = move-exception
            goto L_0x006c
        L_0x004c:
            java.lang.String r3 = "AppLocalesStorageHelper"
            java.lang.String r4 = "Reading app Locales : Unable to parse through file :androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            android.util.Log.w(r3, r4)     // Catch:{ all -> 0x0029 }
            if (r2 == 0) goto L_0x0056
            goto L_0x0046
        L_0x0056:
            boolean r2 = r1.isEmpty()     // Catch:{ all -> 0x004a }
            if (r2 != 0) goto L_0x005d
            goto L_0x0062
        L_0x005d:
            java.lang.String r2 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            r8.deleteFile(r2)     // Catch:{ all -> 0x004a }
        L_0x0062:
            monitor-exit(r0)     // Catch:{ all -> 0x004a }
            return r1
        L_0x0064:
            if (r2 == 0) goto L_0x0069
            r2.close()     // Catch:{ IOException -> 0x0069 }
        L_0x0069:
            throw r8     // Catch:{ all -> 0x004a }
        L_0x006a:
            monitor-exit(r0)     // Catch:{ all -> 0x004a }
            return r1
        L_0x006c:
            monitor-exit(r0)     // Catch:{ all -> 0x004a }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.AppLocalesStorageHelper.a(android.content.Context):java.lang.String");
    }
}
