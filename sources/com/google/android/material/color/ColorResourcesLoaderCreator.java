package com.google.android.material.color;

import androidx.annotation.RequiresApi;

@RequiresApi
final class ColorResourcesLoaderCreator {
    private static final String TAG = "ColorResLoaderCreator";

    private ColorResourcesLoaderCreator() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0037, code lost:
        r5 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0059, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0062, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0063, code lost:
        if (r5 != null) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0069, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        r3.addSuppressed(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0072, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        r5.addSuppressed(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        android.system.Os.close(r6);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:10:0x002b, B:20:0x003e, B:22:0x0045, B:35:0x0065, B:41:0x006e] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x007b A[SYNTHETIC, Splitter:B:50:0x007b] */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.res.loader.ResourcesLoader create(@androidx.annotation.NonNull android.content.Context r5, @androidx.annotation.NonNull java.util.Map<java.lang.Integer, java.lang.Integer> r6) {
        /*
            java.lang.String r0 = "ColorResLoaderCreator"
            r1 = 0
            byte[] r5 = com.google.android.material.color.ColorResourcesTableCreator.create(r5, r6)     // Catch:{ Exception -> 0x0034 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0034 }
            r6.<init>()     // Catch:{ Exception -> 0x0034 }
            java.lang.String r2 = "Table created, length: "
            r6.append(r2)     // Catch:{ Exception -> 0x0034 }
            int r2 = r5.length     // Catch:{ Exception -> 0x0034 }
            r6.append(r2)     // Catch:{ Exception -> 0x0034 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0034 }
            android.util.Log.i(r0, r6)     // Catch:{ Exception -> 0x0034 }
            int r6 = r5.length     // Catch:{ Exception -> 0x0034 }
            if (r6 != 0) goto L_0x0020
            return r1
        L_0x0020:
            java.lang.String r6 = "temp.arsc"
            r2 = 0
            java.io.FileDescriptor r6 = android.system.Os.memfd_create(r6, r2)     // Catch:{ all -> 0x0077 }
            if (r6 != 0) goto L_0x0039
            java.lang.String r5 = "Cannot create memory file descriptor."
            android.util.Log.w(r0, r5)     // Catch:{ all -> 0x0037 }
            if (r6 == 0) goto L_0x0036
            android.system.Os.close(r6)     // Catch:{ Exception -> 0x0034 }
            goto L_0x0036
        L_0x0034:
            r5 = move-exception
            goto L_0x007f
        L_0x0036:
            return r1
        L_0x0037:
            r5 = move-exception
            goto L_0x0079
        L_0x0039:
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x0037 }
            r2.<init>(r6)     // Catch:{ all -> 0x0037 }
            r2.write(r5)     // Catch:{ all -> 0x0059 }
            android.os.ParcelFileDescriptor r5 = android.os.ParcelFileDescriptor.dup(r6)     // Catch:{ all -> 0x0059 }
            com.honey.account.h1.h.a()     // Catch:{ all -> 0x0062 }
            android.content.res.loader.ResourcesLoader r3 = com.honey.account.h1.g.a()     // Catch:{ all -> 0x0062 }
            android.content.res.loader.ResourcesProvider r4 = android.content.res.loader.ResourcesProvider.loadFromTable(r5, r1)     // Catch:{ all -> 0x0062 }
            r3.addProvider(r4)     // Catch:{ all -> 0x0062 }
            if (r5 == 0) goto L_0x005b
            r5.close()     // Catch:{ all -> 0x0059 }
            goto L_0x005b
        L_0x0059:
            r5 = move-exception
            goto L_0x006e
        L_0x005b:
            r2.close()     // Catch:{ all -> 0x0037 }
            android.system.Os.close(r6)     // Catch:{ Exception -> 0x0034 }
            return r3
        L_0x0062:
            r3 = move-exception
            if (r5 == 0) goto L_0x006d
            r5.close()     // Catch:{ all -> 0x0069 }
            goto L_0x006d
        L_0x0069:
            r5 = move-exception
            r3.addSuppressed(r5)     // Catch:{ all -> 0x0059 }
        L_0x006d:
            throw r3     // Catch:{ all -> 0x0059 }
        L_0x006e:
            r2.close()     // Catch:{ all -> 0x0072 }
            goto L_0x0076
        L_0x0072:
            r2 = move-exception
            r5.addSuppressed(r2)     // Catch:{ all -> 0x0037 }
        L_0x0076:
            throw r5     // Catch:{ all -> 0x0037 }
        L_0x0077:
            r5 = move-exception
            r6 = r1
        L_0x0079:
            if (r6 == 0) goto L_0x007e
            android.system.Os.close(r6)     // Catch:{ Exception -> 0x0034 }
        L_0x007e:
            throw r5     // Catch:{ Exception -> 0x0034 }
        L_0x007f:
            java.lang.String r6 = "Failed to create the ColorResourcesTableCreator."
            android.util.Log.e(r0, r6, r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.color.ColorResourcesLoaderCreator.create(android.content.Context, java.util.Map):android.content.res.loader.ResourcesLoader");
    }
}
