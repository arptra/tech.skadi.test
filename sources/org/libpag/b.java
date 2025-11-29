package org.libpag;

abstract class b {
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00ab A[SYNTHETIC, Splitter:B:52:0x00ab] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00c3 A[SYNTHETIC, Splitter:B:64:0x00c3] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00d5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] a(java.lang.String r8) {
        /*
            java.lang.String r0 = "NetworkFetcher"
            byte[] r1 = org.libpag.PAGDiskCache.ReadFile(r8)
            if (r1 == 0) goto L_0x000c
            int r2 = r1.length
            if (r2 <= 0) goto L_0x000c
            return r1
        L_0x000c:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>()
            r2 = 0
            java.net.URL r3 = new java.net.URL     // Catch:{ IOException -> 0x008b, all -> 0x0088 }
            r3.<init>(r8)     // Catch:{ IOException -> 0x008b, all -> 0x0088 }
            java.net.URLConnection r3 = r3.openConnection()     // Catch:{ IOException -> 0x008b, all -> 0x0088 }
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ IOException -> 0x008b, all -> 0x0088 }
            java.lang.String r4 = "GET"
            r3.setRequestMethod(r4)     // Catch:{ IOException -> 0x0051, all -> 0x004e }
            r3.connect()     // Catch:{ IOException -> 0x0051, all -> 0x004e }
            int r4 = r3.getResponseCode()     // Catch:{ IOException -> 0x0051, all -> 0x004e }
            int r5 = r4 / 100
            r6 = 2
            if (r5 == r6) goto L_0x0054
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0051, all -> 0x004e }
            r8.<init>()     // Catch:{ IOException -> 0x0051, all -> 0x004e }
            java.lang.String r5 = "Error: HTTP response code "
            r8.append(r5)     // Catch:{ IOException -> 0x0051, all -> 0x004e }
            r8.append(r4)     // Catch:{ IOException -> 0x0051, all -> 0x004e }
            java.lang.String r8 = r8.toString()     // Catch:{ IOException -> 0x0051, all -> 0x004e }
            android.util.Log.e(r0, r8)     // Catch:{ IOException -> 0x0051, all -> 0x004e }
            r1.close()     // Catch:{ Exception -> 0x0046 }
            goto L_0x004a
        L_0x0046:
            r8 = move-exception
            r8.printStackTrace()
        L_0x004a:
            r3.disconnect()
            return r2
        L_0x004e:
            r8 = move-exception
            goto L_0x00c1
        L_0x0051:
            r8 = move-exception
            r4 = r2
            goto L_0x008e
        L_0x0054:
            java.io.InputStream r4 = r3.getInputStream()     // Catch:{ IOException -> 0x0051, all -> 0x004e }
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch:{ IOException -> 0x006b }
        L_0x005c:
            int r6 = r4.read(r5)     // Catch:{ IOException -> 0x006b }
            r7 = -1
            if (r6 == r7) goto L_0x006d
            r7 = 0
            r1.write(r5, r7, r6)     // Catch:{ IOException -> 0x006b }
            goto L_0x005c
        L_0x0068:
            r8 = move-exception
            r2 = r4
            goto L_0x00c1
        L_0x006b:
            r8 = move-exception
            goto L_0x008e
        L_0x006d:
            byte[] r5 = r1.toByteArray()     // Catch:{ IOException -> 0x006b }
            org.libpag.PAGDiskCache.WriteFile(r8, r5)     // Catch:{ IOException -> 0x006b }
            r4.close()     // Catch:{ Exception -> 0x0078 }
            goto L_0x007c
        L_0x0078:
            r8 = move-exception
            r8.printStackTrace()
        L_0x007c:
            r1.close()     // Catch:{ Exception -> 0x0080 }
            goto L_0x0084
        L_0x0080:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0084:
            r3.disconnect()
            return r5
        L_0x0088:
            r8 = move-exception
            r3 = r2
            goto L_0x00c1
        L_0x008b:
            r8 = move-exception
            r3 = r2
            r4 = r3
        L_0x008e:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0068 }
            r5.<init>()     // Catch:{ all -> 0x0068 }
            java.lang.String r6 = "Error: "
            r5.append(r6)     // Catch:{ all -> 0x0068 }
            java.lang.String r6 = r8.getMessage()     // Catch:{ all -> 0x0068 }
            r5.append(r6)     // Catch:{ all -> 0x0068 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0068 }
            android.util.Log.e(r0, r5)     // Catch:{ all -> 0x0068 }
            r8.printStackTrace()     // Catch:{ all -> 0x0068 }
            if (r4 == 0) goto L_0x00b3
            r4.close()     // Catch:{ Exception -> 0x00af }
            goto L_0x00b3
        L_0x00af:
            r8 = move-exception
            r8.printStackTrace()
        L_0x00b3:
            r1.close()     // Catch:{ Exception -> 0x00b7 }
            goto L_0x00bb
        L_0x00b7:
            r8 = move-exception
            r8.printStackTrace()
        L_0x00bb:
            if (r3 == 0) goto L_0x00c0
            r3.disconnect()
        L_0x00c0:
            return r2
        L_0x00c1:
            if (r2 == 0) goto L_0x00cb
            r2.close()     // Catch:{ Exception -> 0x00c7 }
            goto L_0x00cb
        L_0x00c7:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00cb:
            r1.close()     // Catch:{ Exception -> 0x00cf }
            goto L_0x00d3
        L_0x00cf:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00d3:
            if (r3 == 0) goto L_0x00d8
            r3.disconnect()
        L_0x00d8:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.libpag.b.a(java.lang.String):byte[]");
    }
}
