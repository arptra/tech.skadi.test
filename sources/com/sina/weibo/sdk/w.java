package com.sina.weibo.sdk;

public final class w {
    /* JADX WARNING: type inference failed for: r11v1, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r11v7, types: [java.io.BufferedInputStream, java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r11v9 */
    /* JADX WARNING: type inference failed for: r11v10 */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00ab, code lost:
        if (r4 != null) goto L_0x00b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b6, code lost:
        if (r4 != null) goto L_0x00b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00bf, code lost:
        if (android.text.TextUtils.isEmpty(r1) == false) goto L_0x00df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00c1, code lost:
        r1 = new java.lang.StringBuilder();
        r1.append(java.util.Calendar.getInstance().getTimeInMillis());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00d1, code lost:
        if (r12 != 0) goto L_0x00d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d3, code lost:
        r12 = "_sdk_temp.mp4";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00d6, code lost:
        r12 = "_sdk_temp.jpg";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00d8, code lost:
        r1.append(r12);
        r1 = r1.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00df, code lost:
        r11 = new java.io.BufferedInputStream(new java.io.FileInputStream(r10.getContentResolver().openFileDescriptor(r11, "r").getFileDescriptor()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        r10 = new java.io.File(android.os.Environment.getExternalStorageDirectory().getAbsolutePath() + r3 + r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x011a, code lost:
        if (r10.exists() == false) goto L_0x0124;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x011c, code lost:
        r10.delete();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0120, code lost:
        r10 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0121, code lost:
        r11 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0122, code lost:
        r10 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0124, code lost:
        r12 = new java.io.FileOutputStream(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        r1 = new byte[1444];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x012d, code lost:
        r2 = r11.read(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0132, code lost:
        if (r2 == -1) goto L_0x013d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0134, code lost:
        r12.write(r1, 0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0139, code lost:
        r10 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x013a, code lost:
        r11 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x013b, code lost:
        r10 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x013d, code lost:
        r10 = r10.getPath();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        r11.close();
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0148, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0149, code lost:
        com.sina.weibo.sdk.n.a(com.sina.weibo.sdk.n.b, "share util and exception(3)", r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0151, code lost:
        r2 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0153, code lost:
        r12 = null;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0157 A[SYNTHETIC, Splitter:B:75:0x0157] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x016e A[SYNTHETIC, Splitter:B:85:0x016e] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0176 A[Catch:{ Exception -> 0x0172 }] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r10, android.net.Uri r11, int r12) {
        /*
            java.lang.String r0 = "share util and exception(3)"
            java.lang.String r1 = "_display_name"
            r2 = 0
            com.sina.weibo.sdk.a$a r3 = com.sina.weibo.sdk.a.a(r10)     // Catch:{ Exception -> 0x0014, all -> 0x0010 }
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x0017
            java.lang.String r4 = r3.f9968a     // Catch:{ Exception -> 0x0014, all -> 0x0010 }
            goto L_0x0017
        L_0x0010:
            r10 = move-exception
            r12 = r2
            goto L_0x016a
        L_0x0014:
            r10 = move-exception
            goto L_0x015b
        L_0x0017:
            boolean r3 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0014, all -> 0x0010 }
            if (r3 == 0) goto L_0x001f
            java.lang.String r4 = "com.sina.weibo"
        L_0x001f:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0014, all -> 0x0010 }
            r3.<init>()     // Catch:{ Exception -> 0x0014, all -> 0x0010 }
            java.lang.String r5 = "/Android/data/"
            r3.append(r5)     // Catch:{ Exception -> 0x0014, all -> 0x0010 }
            r3.append(r4)     // Catch:{ Exception -> 0x0014, all -> 0x0010 }
            java.lang.String r4 = "/files/.composerTem/"
            r3.append(r4)     // Catch:{ Exception -> 0x0014, all -> 0x0010 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0014, all -> 0x0010 }
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x0014, all -> 0x0010 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0014, all -> 0x0010 }
            r5.<init>()     // Catch:{ Exception -> 0x0014, all -> 0x0010 }
            java.io.File r6 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x0014, all -> 0x0010 }
            java.lang.String r6 = r6.getAbsolutePath()     // Catch:{ Exception -> 0x0014, all -> 0x0010 }
            r5.append(r6)     // Catch:{ Exception -> 0x0014, all -> 0x0010 }
            r5.append(r3)     // Catch:{ Exception -> 0x0014, all -> 0x0010 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0014, all -> 0x0010 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0014, all -> 0x0010 }
            r4.mkdirs()     // Catch:{ Exception -> 0x0014, all -> 0x0010 }
            java.util.Calendar r4 = java.util.Calendar.getInstance()     // Catch:{ Exception -> 0x0014, all -> 0x0010 }
            java.lang.String r5 = "file"
            java.lang.String r6 = r11.getScheme()     // Catch:{ Exception -> 0x0081, all -> 0x007d }
            boolean r5 = r5.equals(r6)     // Catch:{ Exception -> 0x0081, all -> 0x007d }
            if (r5 == 0) goto L_0x0084
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0081, all -> 0x007d }
            r1.<init>()     // Catch:{ Exception -> 0x0081, all -> 0x007d }
            long r4 = r4.getTimeInMillis()     // Catch:{ Exception -> 0x0081, all -> 0x007d }
            r1.append(r4)     // Catch:{ Exception -> 0x0081, all -> 0x007d }
            java.lang.String r4 = r11.getLastPathSegment()     // Catch:{ Exception -> 0x0081, all -> 0x007d }
            r1.append(r4)     // Catch:{ Exception -> 0x0081, all -> 0x007d }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0081, all -> 0x007d }
            r4 = r2
            goto L_0x00ab
        L_0x007d:
            r10 = move-exception
            r4 = r2
            goto L_0x0155
        L_0x0081:
            r1 = move-exception
            r4 = r2
            goto L_0x00ae
        L_0x0084:
            android.content.ContentResolver r4 = r10.getContentResolver()     // Catch:{ Exception -> 0x0081, all -> 0x007d }
            java.lang.String[] r6 = new java.lang.String[]{r1}     // Catch:{ Exception -> 0x0081, all -> 0x007d }
            r8 = 0
            r9 = 0
            r7 = 0
            r5 = r11
            android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0081, all -> 0x007d }
            if (r4 == 0) goto L_0x00aa
            boolean r5 = r4.moveToFirst()     // Catch:{ Exception -> 0x00a8 }
            if (r5 == 0) goto L_0x00aa
            int r1 = r4.getColumnIndex(r1)     // Catch:{ Exception -> 0x00a8 }
            java.lang.String r1 = r4.getString(r1)     // Catch:{ Exception -> 0x00a8 }
            goto L_0x00ab
        L_0x00a5:
            r10 = move-exception
            goto L_0x0155
        L_0x00a8:
            r1 = move-exception
            goto L_0x00ae
        L_0x00aa:
            r1 = r2
        L_0x00ab:
            if (r4 == 0) goto L_0x00bb
            goto L_0x00b8
        L_0x00ae:
            java.lang.String r5 = com.sina.weibo.sdk.n.b     // Catch:{ all -> 0x00a5 }
            java.lang.String r6 = "share util and exception(1)"
            com.sina.weibo.sdk.n.a(r5, r6, r1)     // Catch:{ all -> 0x00a5 }
            r1 = r2
            if (r4 == 0) goto L_0x00bb
        L_0x00b8:
            r4.close()     // Catch:{ Exception -> 0x0014, all -> 0x0010 }
        L_0x00bb:
            boolean r4 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0014, all -> 0x0010 }
            if (r4 == 0) goto L_0x00df
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0014, all -> 0x0010 }
            r1.<init>()     // Catch:{ Exception -> 0x0014, all -> 0x0010 }
            java.util.Calendar r4 = java.util.Calendar.getInstance()     // Catch:{ Exception -> 0x0014, all -> 0x0010 }
            long r4 = r4.getTimeInMillis()     // Catch:{ Exception -> 0x0014, all -> 0x0010 }
            r1.append(r4)     // Catch:{ Exception -> 0x0014, all -> 0x0010 }
            if (r12 != 0) goto L_0x00d6
            java.lang.String r12 = "_sdk_temp.mp4"
            goto L_0x00d8
        L_0x00d6:
            java.lang.String r12 = "_sdk_temp.jpg"
        L_0x00d8:
            r1.append(r12)     // Catch:{ Exception -> 0x0014, all -> 0x0010 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0014, all -> 0x0010 }
        L_0x00df:
            android.content.ContentResolver r10 = r10.getContentResolver()     // Catch:{ Exception -> 0x0014, all -> 0x0010 }
            java.lang.String r12 = "r"
            android.os.ParcelFileDescriptor r10 = r10.openFileDescriptor(r11, r12)     // Catch:{ Exception -> 0x0014, all -> 0x0010 }
            java.io.FileDescriptor r10 = r10.getFileDescriptor()     // Catch:{ Exception -> 0x0014, all -> 0x0010 }
            java.io.BufferedInputStream r11 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0014, all -> 0x0010 }
            java.io.FileInputStream r12 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0014, all -> 0x0010 }
            r12.<init>(r10)     // Catch:{ Exception -> 0x0014, all -> 0x0010 }
            r11.<init>(r12)     // Catch:{ Exception -> 0x0014, all -> 0x0010 }
            java.io.File r10 = new java.io.File     // Catch:{ Exception -> 0x0122, all -> 0x0120 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0122, all -> 0x0120 }
            r12.<init>()     // Catch:{ Exception -> 0x0122, all -> 0x0120 }
            java.io.File r4 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x0122, all -> 0x0120 }
            java.lang.String r4 = r4.getAbsolutePath()     // Catch:{ Exception -> 0x0122, all -> 0x0120 }
            r12.append(r4)     // Catch:{ Exception -> 0x0122, all -> 0x0120 }
            r12.append(r3)     // Catch:{ Exception -> 0x0122, all -> 0x0120 }
            r12.append(r1)     // Catch:{ Exception -> 0x0122, all -> 0x0120 }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x0122, all -> 0x0120 }
            r10.<init>(r12)     // Catch:{ Exception -> 0x0122, all -> 0x0120 }
            boolean r12 = r10.exists()     // Catch:{ Exception -> 0x0122, all -> 0x0120 }
            if (r12 == 0) goto L_0x0124
            r10.delete()     // Catch:{ Exception -> 0x0122, all -> 0x0120 }
            goto L_0x0124
        L_0x0120:
            r10 = move-exception
            goto L_0x016c
        L_0x0122:
            r10 = move-exception
            goto L_0x0153
        L_0x0124:
            java.io.FileOutputStream r12 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0122, all -> 0x0120 }
            r12.<init>(r10)     // Catch:{ Exception -> 0x0122, all -> 0x0120 }
            r1 = 1444(0x5a4, float:2.023E-42)
            byte[] r1 = new byte[r1]     // Catch:{ Exception -> 0x013b, all -> 0x0139 }
        L_0x012d:
            int r2 = r11.read(r1)     // Catch:{ Exception -> 0x013b, all -> 0x0139 }
            r3 = -1
            if (r2 == r3) goto L_0x013d
            r3 = 0
            r12.write(r1, r3, r2)     // Catch:{ Exception -> 0x013b, all -> 0x0139 }
            goto L_0x012d
        L_0x0139:
            r10 = move-exception
            goto L_0x014f
        L_0x013b:
            r10 = move-exception
            goto L_0x0151
        L_0x013d:
            java.lang.String r10 = r10.getPath()     // Catch:{ Exception -> 0x013b, all -> 0x0139 }
            r11.close()     // Catch:{ Exception -> 0x0148 }
            r12.close()     // Catch:{ Exception -> 0x0148 }
            goto L_0x014e
        L_0x0148:
            r11 = move-exception
            java.lang.String r12 = com.sina.weibo.sdk.n.b
            com.sina.weibo.sdk.n.a(r12, r0, r11)
        L_0x014e:
            return r10
        L_0x014f:
            r2 = r12
            goto L_0x016c
        L_0x0151:
            r2 = r11
            goto L_0x015c
        L_0x0153:
            r12 = r2
            goto L_0x0151
        L_0x0155:
            if (r4 == 0) goto L_0x015a
            r4.close()     // Catch:{ Exception -> 0x0014, all -> 0x0010 }
        L_0x015a:
            throw r10     // Catch:{ Exception -> 0x0014, all -> 0x0010 }
        L_0x015b:
            r12 = r2
        L_0x015c:
            java.lang.String r11 = com.sina.weibo.sdk.n.b     // Catch:{ all -> 0x0169 }
            java.lang.String r1 = "share util and exception(2)"
            com.sina.weibo.sdk.n.a(r11, r1, r10)     // Catch:{ all -> 0x0169 }
            java.lang.Throwable r11 = new java.lang.Throwable     // Catch:{ all -> 0x0169 }
            r11.<init>(r10)     // Catch:{ all -> 0x0169 }
            throw r11     // Catch:{ all -> 0x0169 }
        L_0x0169:
            r10 = move-exception
        L_0x016a:
            r11 = r2
            goto L_0x014f
        L_0x016c:
            if (r11 == 0) goto L_0x0174
            r11.close()     // Catch:{ Exception -> 0x0172 }
            goto L_0x0174
        L_0x0172:
            r11 = move-exception
            goto L_0x017a
        L_0x0174:
            if (r2 == 0) goto L_0x017f
            r2.close()     // Catch:{ Exception -> 0x0172 }
            goto L_0x017f
        L_0x017a:
            java.lang.String r12 = com.sina.weibo.sdk.n.b
            com.sina.weibo.sdk.n.a(r12, r0, r11)
        L_0x017f:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.w.a(android.content.Context, android.net.Uri, int):java.lang.String");
    }
}
