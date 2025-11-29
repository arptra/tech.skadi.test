package com.luck.picture.lib.loader;

import android.content.Context;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.text.TextUtils;
import android.util.Log;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.entity.MediaData;
import com.luck.picture.lib.interfaces.OnQueryAlbumListener;
import com.luck.picture.lib.interfaces.OnQueryAllAlbumListener;
import com.luck.picture.lib.interfaces.OnQueryDataResultListener;
import com.luck.picture.lib.interfaces.OnQueryFilterListener;
import com.luck.picture.lib.thread.PictureThreadUtils;
import com.luck.picture.lib.utils.MediaUtils;
import com.luck.picture.lib.utils.PictureFileUtils;
import com.luck.picture.lib.utils.SdkVersionUtils;
import com.luck.picture.lib.utils.SortUtils;
import com.luck.picture.lib.utils.ValueOf;
import java.util.ArrayList;
import java.util.List;

public final class LocalMediaPageLoader extends IBridgeMediaLoader {
    public LocalMediaPageLoader(Context context, SelectorConfig selectorConfig) {
        super(context, selectorConfig);
    }

    private String B(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append("media_type");
        sb.append("=?");
        sb.append(str3);
        sb.append(" OR ");
        sb.append("media_type");
        sb.append("=? AND ");
        sb.append(str);
        sb.append(") AND ");
        sb.append(str2);
        if (H()) {
            return sb.toString();
        }
        sb.append(")");
        sb.append(" GROUP BY (bucket_id");
        return sb.toString();
    }

    private String C(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (H()) {
            sb.append("media_type");
            sb.append("=?");
            sb.append(str2);
            sb.append(" AND ");
            sb.append(str);
            return sb.toString();
        }
        sb.append("(");
        sb.append("media_type");
        sb.append("=?");
        sb.append(str2);
        sb.append(") AND ");
        sb.append(str);
        sb.append(")");
        sb.append(" GROUP BY (bucket_id");
        return sb.toString();
    }

    private String D(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (H()) {
            sb.append("media_type");
            sb.append("=?");
            sb.append(str2);
            sb.append(" AND ");
            sb.append(str);
            return sb.toString();
        }
        sb.append("(");
        sb.append("media_type");
        sb.append("=?");
        sb.append(str2);
        sb.append(") AND ");
        sb.append(str);
        sb.append(")");
        sb.append(" GROUP BY (bucket_id");
        return sb.toString();
    }

    public static String[] E(int i, long j) {
        if (j == -1) {
            return new String[]{String.valueOf(i)};
        }
        return new String[]{String.valueOf(i), ValueOf.g(Long.valueOf(j))};
    }

    private String F(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (H()) {
            sb.append("media_type");
            sb.append("=?");
            sb.append(str2);
            sb.append(" AND ");
            sb.append(str);
            return sb.toString();
        }
        sb.append("(");
        sb.append("media_type");
        sb.append("=?");
        sb.append(str2);
        sb.append(") AND ");
        sb.append(str);
        sb.append(")");
        sb.append(" GROUP BY (bucket_id");
        return sb.toString();
    }

    public static String q(Cursor cursor) {
        return cursor.getString(cursor.getColumnIndexOrThrow("mime_type"));
    }

    public static String r(Cursor cursor) {
        return MediaUtils.l(cursor.getLong(cursor.getColumnIndexOrThrow("_id")), cursor.getString(cursor.getColumnIndexOrThrow("mime_type")));
    }

    public static String s(Cursor cursor) {
        return cursor.getString(cursor.getColumnIndexOrThrow("_data"));
    }

    public static String v(long j, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append("media_type");
        sb.append("=?");
        sb.append(str);
        sb.append(" OR ");
        sb.append("media_type");
        sb.append("=? AND ");
        sb.append(str2);
        sb.append(") AND ");
        if (j == -1) {
            sb.append(str3);
            return sb.toString();
        }
        sb.append("bucket_id");
        sb.append("=? AND ");
        sb.append(str3);
        return sb.toString();
    }

    public static String w(long j, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append("media_type");
        sb.append("=?");
        sb.append(str);
        sb.append(" AND ");
        sb.append(str2);
        sb.append(") AND ");
        if (j == -1) {
            sb.append(str3);
            return sb.toString();
        }
        sb.append("bucket_id");
        sb.append("=? AND ");
        sb.append(str3);
        return sb.toString();
    }

    public static String x(long j, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append("media_type");
        sb.append("=?");
        if (j == -1) {
            sb.append(str);
            sb.append(") AND ");
            sb.append(str2);
            return sb.toString();
        }
        sb.append(str);
        sb.append(") AND ");
        sb.append("bucket_id");
        sb.append("=? AND ");
        sb.append(str2);
        return sb.toString();
    }

    public static String y(long j, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append("media_type");
        sb.append("=?");
        sb.append(str);
        sb.append(" AND ");
        sb.append(str2);
        sb.append(") AND ");
        if (j == -1) {
            sb.append(str3);
            return sb.toString();
        }
        sb.append("bucket_id");
        sb.append("=? AND ");
        sb.append(str3);
        return sb.toString();
    }

    public String[] A() {
        int i = a().f9404a;
        if (i == 0) {
            return new String[]{String.valueOf(1), String.valueOf(3)};
        }
        if (i == 1) {
            return new String[]{String.valueOf(1)};
        }
        if (i == 2) {
            return new String[]{String.valueOf(3)};
        }
        if (i != 3) {
            return null;
        }
        return new String[]{String.valueOf(2)};
    }

    public String G() {
        return TextUtils.isEmpty(a().b0) ? "date_modified DESC" : a().b0;
    }

    public final boolean H() {
        if (SdkVersionUtils.f()) {
            return true;
        }
        return a().E0;
    }

    public LocalMedia I(Cursor cursor, boolean z) {
        String str;
        int i;
        long j;
        Cursor cursor2 = cursor;
        String[] strArr = IBridgeMediaLoader.e;
        int columnIndexOrThrow = cursor2.getColumnIndexOrThrow(strArr[0]);
        int columnIndexOrThrow2 = cursor2.getColumnIndexOrThrow(strArr[1]);
        int columnIndexOrThrow3 = cursor2.getColumnIndexOrThrow(strArr[2]);
        int columnIndexOrThrow4 = cursor2.getColumnIndexOrThrow(strArr[3]);
        int columnIndexOrThrow5 = cursor2.getColumnIndexOrThrow(strArr[4]);
        int columnIndexOrThrow6 = cursor2.getColumnIndexOrThrow(strArr[5]);
        int columnIndexOrThrow7 = cursor2.getColumnIndexOrThrow(strArr[6]);
        int columnIndexOrThrow8 = cursor2.getColumnIndexOrThrow(strArr[7]);
        int columnIndexOrThrow9 = cursor2.getColumnIndexOrThrow(strArr[8]);
        int columnIndexOrThrow10 = cursor2.getColumnIndexOrThrow(strArr[9]);
        int columnIndexOrThrow11 = cursor2.getColumnIndexOrThrow(strArr[10]);
        int columnIndexOrThrow12 = cursor2.getColumnIndexOrThrow(strArr[11]);
        long j2 = cursor2.getLong(columnIndexOrThrow);
        String string = cursor2.getString(columnIndexOrThrow3);
        String string2 = cursor2.getString(columnIndexOrThrow2);
        String l = SdkVersionUtils.f() ? MediaUtils.l(j2, string) : string2;
        if (TextUtils.isEmpty(string)) {
            string = PictureMimeType.r();
        }
        if (a().f0) {
            if (PictureMimeType.h(string)) {
                if (!TextUtils.isEmpty(string2) && !PictureFileUtils.o(string2)) {
                    return null;
                }
            } else if (!PictureFileUtils.m(string2)) {
                return null;
            }
        }
        if (string.endsWith("image/*")) {
            string = MediaUtils.j(string2);
            str = l;
            if (!a().E && PictureMimeType.f(string)) {
                return null;
            }
        } else {
            str = l;
        }
        if (string.endsWith("image/*")) {
            return null;
        }
        if (!a().F && string.startsWith(PictureMimeType.s())) {
            return null;
        }
        if (!a().G && PictureMimeType.e(string)) {
            return null;
        }
        int i2 = cursor2.getInt(columnIndexOrThrow4);
        int i3 = cursor2.getInt(columnIndexOrThrow5);
        int i4 = cursor2.getInt(columnIndexOrThrow12);
        int i5 = i2;
        if (i4 == 90 || i4 == 270) {
            i = cursor2.getInt(columnIndexOrThrow5);
            i3 = cursor2.getInt(columnIndexOrThrow4);
        } else {
            i = i5;
        }
        long j3 = cursor2.getLong(columnIndexOrThrow6);
        long j4 = cursor2.getLong(columnIndexOrThrow7);
        String string3 = cursor2.getString(columnIndexOrThrow8);
        String string4 = cursor2.getString(columnIndexOrThrow9);
        long j5 = cursor2.getLong(columnIndexOrThrow10);
        String str2 = string3;
        long j6 = cursor2.getLong(columnIndexOrThrow11);
        if (TextUtils.isEmpty(string4)) {
            string4 = PictureMimeType.b(string2);
        }
        if (a().D0 && j4 > 0 && j4 < 1024) {
            return null;
        }
        if (PictureMimeType.i(string) || PictureMimeType.d(string)) {
            if (a().r > 0) {
                j = j6;
                if (j3 < ((long) a().r)) {
                    return null;
                }
            } else {
                j = j6;
            }
            if (a().q > 0 && j3 > ((long) a().q)) {
                return null;
            }
            if (a().D0 && j3 <= 0) {
                return null;
            }
        } else {
            j = j6;
        }
        LocalMedia obtain = z ? LocalMedia.obtain() : LocalMedia.create();
        obtain.setId(j2);
        obtain.setBucketId(j5);
        obtain.setPath(str);
        obtain.setRealPath(string2);
        obtain.setFileName(string4);
        obtain.setParentFolderName(str2);
        obtain.setDuration(j3);
        obtain.setChooseModel(a().f9404a);
        obtain.setMimeType(string);
        obtain.setWidth(i);
        obtain.setHeight(i3);
        obtain.setSize(j4);
        obtain.setDateAddedTime(j);
        OnQueryFilterListener onQueryFilterListener = this.b.k1;
        if (onQueryFilterListener == null || !onQueryFilterListener.a(obtain)) {
            return obtain;
        }
        return null;
    }

    public final void J(List list) {
        for (int i = 0; i < list.size(); i++) {
            LocalMediaFolder localMediaFolder = (LocalMediaFolder) list.get(i);
            if (localMediaFolder != null) {
                String p = p(localMediaFolder.getBucketId());
                if (!TextUtils.isEmpty(p)) {
                    localMediaFolder.setFirstImagePath(p);
                }
            }
        }
    }

    public void f(final OnQueryAllAlbumListener onQueryAllAlbumListener) {
        PictureThreadUtils.h(new PictureThreadUtils.SimpleTask<List<LocalMediaFolder>>() {
            /* JADX WARNING: Code restructure failed: missing block: B:102:0x02f5, code lost:
                if (r1.isClosed() == false) goto L_0x02e1;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:94:0x02df, code lost:
                if (r1.isClosed() != false) goto L_0x02f8;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:95:0x02e1, code lost:
                r1.close();
             */
            /* renamed from: o */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.List f() {
                /*
                    r17 = this;
                    r0 = r17
                    com.luck.picture.lib.loader.LocalMediaPageLoader r1 = com.luck.picture.lib.loader.LocalMediaPageLoader.this
                    android.content.Context r1 = r1.b()
                    android.content.ContentResolver r2 = r1.getContentResolver()
                    android.net.Uri r3 = com.luck.picture.lib.loader.IBridgeMediaLoader.d
                    com.luck.picture.lib.loader.LocalMediaPageLoader r1 = com.luck.picture.lib.loader.LocalMediaPageLoader.this
                    boolean r1 = r1.H()
                    if (r1 == 0) goto L_0x001a
                    java.lang.String[] r1 = com.luck.picture.lib.loader.IBridgeMediaLoader.e
                L_0x0018:
                    r4 = r1
                    goto L_0x001d
                L_0x001a:
                    java.lang.String[] r1 = com.luck.picture.lib.loader.IBridgeMediaLoader.f
                    goto L_0x0018
                L_0x001d:
                    com.luck.picture.lib.loader.LocalMediaPageLoader r1 = com.luck.picture.lib.loader.LocalMediaPageLoader.this
                    java.lang.String r5 = r1.z()
                    com.luck.picture.lib.loader.LocalMediaPageLoader r1 = com.luck.picture.lib.loader.LocalMediaPageLoader.this
                    java.lang.String[] r6 = r1.A()
                    com.luck.picture.lib.loader.LocalMediaPageLoader r1 = com.luck.picture.lib.loader.LocalMediaPageLoader.this
                    java.lang.String r7 = r1.G()
                    android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7)
                    if (r1 == 0) goto L_0x02ef
                    int r2 = r1.getCount()     // Catch:{ Exception -> 0x0079 }
                    java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x0079 }
                    r3.<init>()     // Catch:{ Exception -> 0x0079 }
                    if (r2 <= 0) goto L_0x02ef
                    com.luck.picture.lib.loader.LocalMediaPageLoader r2 = com.luck.picture.lib.loader.LocalMediaPageLoader.this     // Catch:{ Exception -> 0x0079 }
                    boolean r2 = r2.H()     // Catch:{ Exception -> 0x0079 }
                    java.lang.String r4 = "mime_type"
                    java.lang.String r5 = "bucket_display_name"
                    java.lang.String r6 = "bucket_id"
                    if (r2 == 0) goto L_0x0136
                    java.util.HashMap r2 = new java.util.HashMap     // Catch:{ Exception -> 0x0079 }
                    r2.<init>()     // Catch:{ Exception -> 0x0079 }
                    java.util.HashSet r8 = new java.util.HashSet     // Catch:{ Exception -> 0x0079 }
                    r8.<init>()     // Catch:{ Exception -> 0x0079 }
                L_0x0058:
                    boolean r9 = r1.moveToNext()     // Catch:{ Exception -> 0x0079 }
                    if (r9 == 0) goto L_0x0110
                    com.luck.picture.lib.loader.LocalMediaPageLoader r9 = com.luck.picture.lib.loader.LocalMediaPageLoader.this     // Catch:{ Exception -> 0x0079 }
                    com.luck.picture.lib.config.SelectorConfig r9 = r9.a()     // Catch:{ Exception -> 0x0079 }
                    boolean r9 = r9.E0     // Catch:{ Exception -> 0x0079 }
                    if (r9 == 0) goto L_0x007c
                    com.luck.picture.lib.loader.LocalMediaPageLoader r9 = com.luck.picture.lib.loader.LocalMediaPageLoader.this     // Catch:{ Exception -> 0x0079 }
                    r10 = 1
                    com.luck.picture.lib.entity.LocalMedia r9 = r9.I(r1, r10)     // Catch:{ Exception -> 0x0079 }
                    if (r9 != 0) goto L_0x0072
                    goto L_0x0058
                L_0x0072:
                    r9.recycle()     // Catch:{ Exception -> 0x0079 }
                    goto L_0x007c
                L_0x0076:
                    r0 = move-exception
                    goto L_0x02e5
                L_0x0079:
                    r0 = move-exception
                    goto L_0x02be
                L_0x007c:
                    int r9 = r1.getColumnIndexOrThrow(r6)     // Catch:{ Exception -> 0x0079 }
                    long r9 = r1.getLong(r9)     // Catch:{ Exception -> 0x0079 }
                    java.lang.Long r11 = java.lang.Long.valueOf(r9)     // Catch:{ Exception -> 0x0079 }
                    java.lang.Object r11 = r2.get(r11)     // Catch:{ Exception -> 0x0079 }
                    java.lang.Long r11 = (java.lang.Long) r11     // Catch:{ Exception -> 0x0079 }
                    r12 = 1
                    if (r11 != 0) goto L_0x0097
                    java.lang.Long r11 = java.lang.Long.valueOf(r12)     // Catch:{ Exception -> 0x0079 }
                    goto L_0x00a0
                L_0x0097:
                    long r14 = r11.longValue()     // Catch:{ Exception -> 0x0079 }
                    long r14 = r14 + r12
                    java.lang.Long r11 = java.lang.Long.valueOf(r14)     // Catch:{ Exception -> 0x0079 }
                L_0x00a0:
                    java.lang.Long r12 = java.lang.Long.valueOf(r9)     // Catch:{ Exception -> 0x0079 }
                    r2.put(r12, r11)     // Catch:{ Exception -> 0x0079 }
                    java.lang.Long r11 = java.lang.Long.valueOf(r9)     // Catch:{ Exception -> 0x0079 }
                    boolean r11 = r8.contains(r11)     // Catch:{ Exception -> 0x0079 }
                    if (r11 == 0) goto L_0x00b2
                    goto L_0x0058
                L_0x00b2:
                    com.luck.picture.lib.entity.LocalMediaFolder r11 = new com.luck.picture.lib.entity.LocalMediaFolder     // Catch:{ Exception -> 0x0079 }
                    r11.<init>()     // Catch:{ Exception -> 0x0079 }
                    r11.setBucketId(r9)     // Catch:{ Exception -> 0x0079 }
                    int r12 = r1.getColumnIndexOrThrow(r5)     // Catch:{ Exception -> 0x0079 }
                    java.lang.String r12 = r1.getString(r12)     // Catch:{ Exception -> 0x0079 }
                    int r13 = r1.getColumnIndexOrThrow(r4)     // Catch:{ Exception -> 0x0079 }
                    java.lang.String r13 = r1.getString(r13)     // Catch:{ Exception -> 0x0079 }
                    java.lang.Long r14 = java.lang.Long.valueOf(r9)     // Catch:{ Exception -> 0x0079 }
                    boolean r14 = r2.containsKey(r14)     // Catch:{ Exception -> 0x0079 }
                    if (r14 != 0) goto L_0x00d5
                    goto L_0x0058
                L_0x00d5:
                    java.lang.Long r14 = java.lang.Long.valueOf(r9)     // Catch:{ Exception -> 0x0079 }
                    java.lang.Object r14 = r2.get(r14)     // Catch:{ Exception -> 0x0079 }
                    java.lang.Long r14 = (java.lang.Long) r14     // Catch:{ Exception -> 0x0079 }
                    r14.longValue()     // Catch:{ Exception -> 0x0079 }
                    java.lang.String r15 = "_id"
                    int r15 = r1.getColumnIndexOrThrow(r15)     // Catch:{ Exception -> 0x0079 }
                    r16 = r8
                    long r7 = r1.getLong(r15)     // Catch:{ Exception -> 0x0079 }
                    r11.setFolderName(r12)     // Catch:{ Exception -> 0x0079 }
                    int r12 = com.luck.picture.lib.utils.ValueOf.c(r14)     // Catch:{ Exception -> 0x0079 }
                    r11.setFolderTotalNum(r12)     // Catch:{ Exception -> 0x0079 }
                    java.lang.String r7 = com.luck.picture.lib.utils.MediaUtils.l(r7, r13)     // Catch:{ Exception -> 0x0079 }
                    r11.setFirstImagePath(r7)     // Catch:{ Exception -> 0x0079 }
                    r11.setFirstMimeType(r13)     // Catch:{ Exception -> 0x0079 }
                    r3.add(r11)     // Catch:{ Exception -> 0x0079 }
                    java.lang.Long r7 = java.lang.Long.valueOf(r9)     // Catch:{ Exception -> 0x0079 }
                    r8 = r16
                    r8.add(r7)     // Catch:{ Exception -> 0x0079 }
                    goto L_0x0058
                L_0x0110:
                    java.util.Iterator r4 = r3.iterator()     // Catch:{ Exception -> 0x0079 }
                    r5 = 0
                L_0x0115:
                    boolean r6 = r4.hasNext()     // Catch:{ Exception -> 0x0079 }
                    if (r6 == 0) goto L_0x0185
                    java.lang.Object r6 = r4.next()     // Catch:{ Exception -> 0x0079 }
                    com.luck.picture.lib.entity.LocalMediaFolder r6 = (com.luck.picture.lib.entity.LocalMediaFolder) r6     // Catch:{ Exception -> 0x0079 }
                    long r7 = r6.getBucketId()     // Catch:{ Exception -> 0x0079 }
                    java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ Exception -> 0x0079 }
                    java.lang.Object r7 = r2.get(r7)     // Catch:{ Exception -> 0x0079 }
                    int r7 = com.luck.picture.lib.utils.ValueOf.c(r7)     // Catch:{ Exception -> 0x0079 }
                    r6.setFolderTotalNum(r7)     // Catch:{ Exception -> 0x0079 }
                    int r5 = r5 + r7
                    goto L_0x0115
                L_0x0136:
                    r1.moveToFirst()     // Catch:{ Exception -> 0x0079 }
                    r2 = 0
                L_0x013a:
                    java.lang.String r7 = "_data"
                    int r7 = r1.getColumnIndexOrThrow(r7)     // Catch:{ Exception -> 0x0079 }
                    java.lang.String r7 = r1.getString(r7)     // Catch:{ Exception -> 0x0079 }
                    int r8 = r1.getColumnIndexOrThrow(r5)     // Catch:{ Exception -> 0x0079 }
                    java.lang.String r8 = r1.getString(r8)     // Catch:{ Exception -> 0x0079 }
                    int r9 = r1.getColumnIndexOrThrow(r4)     // Catch:{ Exception -> 0x0079 }
                    java.lang.String r9 = r1.getString(r9)     // Catch:{ Exception -> 0x0079 }
                    int r10 = r1.getColumnIndexOrThrow(r6)     // Catch:{ Exception -> 0x0079 }
                    long r10 = r1.getLong(r10)     // Catch:{ Exception -> 0x0079 }
                    java.lang.String r12 = "count"
                    int r12 = r1.getColumnIndexOrThrow(r12)     // Catch:{ Exception -> 0x0079 }
                    int r12 = r1.getInt(r12)     // Catch:{ Exception -> 0x0079 }
                    com.luck.picture.lib.entity.LocalMediaFolder r13 = new com.luck.picture.lib.entity.LocalMediaFolder     // Catch:{ Exception -> 0x0079 }
                    r13.<init>()     // Catch:{ Exception -> 0x0079 }
                    r13.setBucketId(r10)     // Catch:{ Exception -> 0x0079 }
                    r13.setFirstImagePath(r7)     // Catch:{ Exception -> 0x0079 }
                    r13.setFolderName(r8)     // Catch:{ Exception -> 0x0079 }
                    r13.setFirstMimeType(r9)     // Catch:{ Exception -> 0x0079 }
                    r13.setFolderTotalNum(r12)     // Catch:{ Exception -> 0x0079 }
                    r3.add(r13)     // Catch:{ Exception -> 0x0079 }
                    int r2 = r2 + r12
                    boolean r7 = r1.moveToNext()     // Catch:{ Exception -> 0x0079 }
                    if (r7 != 0) goto L_0x013a
                    r5 = r2
                L_0x0185:
                    com.luck.picture.lib.entity.LocalMediaFolder r2 = new com.luck.picture.lib.entity.LocalMediaFolder     // Catch:{ Exception -> 0x0079 }
                    r2.<init>()     // Catch:{ Exception -> 0x0079 }
                    com.luck.picture.lib.loader.LocalMediaPageLoader r4 = com.luck.picture.lib.loader.LocalMediaPageLoader.this     // Catch:{ Exception -> 0x0079 }
                    android.content.Context r4 = r4.b()     // Catch:{ Exception -> 0x0079 }
                    com.luck.picture.lib.loader.LocalMediaPageLoader r6 = com.luck.picture.lib.loader.LocalMediaPageLoader.this     // Catch:{ Exception -> 0x0079 }
                    com.luck.picture.lib.config.SelectorConfig r6 = r6.a()     // Catch:{ Exception -> 0x0079 }
                    java.lang.String r6 = r6.Y     // Catch:{ Exception -> 0x0079 }
                    com.luck.picture.lib.entity.LocalMediaFolder r4 = com.luck.picture.lib.loader.SandboxFileLoader.b(r4, r6)     // Catch:{ Exception -> 0x0079 }
                    if (r4 == 0) goto L_0x0220
                    r3.add(r4)     // Catch:{ Exception -> 0x0079 }
                    java.lang.String r6 = r4.getFirstImagePath()     // Catch:{ Exception -> 0x0079 }
                    java.io.File r7 = new java.io.File     // Catch:{ Exception -> 0x0079 }
                    r7.<init>(r6)     // Catch:{ Exception -> 0x0079 }
                    long r6 = r7.lastModified()     // Catch:{ Exception -> 0x0079 }
                    int r8 = r4.getFolderTotalNum()     // Catch:{ Exception -> 0x0079 }
                    int r5 = r5 + r8
                    java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ Exception -> 0x0079 }
                    r8.<init>()     // Catch:{ Exception -> 0x0079 }
                    r2.setData(r8)     // Catch:{ Exception -> 0x0079 }
                    boolean r8 = r1.moveToFirst()     // Catch:{ Exception -> 0x0079 }
                    if (r8 == 0) goto L_0x023f
                    boolean r8 = com.luck.picture.lib.utils.SdkVersionUtils.f()     // Catch:{ Exception -> 0x0079 }
                    if (r8 == 0) goto L_0x01cc
                    java.lang.String r8 = com.luck.picture.lib.loader.LocalMediaPageLoader.r(r1)     // Catch:{ Exception -> 0x0079 }
                    goto L_0x01d0
                L_0x01cc:
                    java.lang.String r8 = com.luck.picture.lib.loader.LocalMediaPageLoader.s(r1)     // Catch:{ Exception -> 0x0079 }
                L_0x01d0:
                    r2.setFirstImagePath(r8)     // Catch:{ Exception -> 0x0079 }
                    java.lang.String r8 = com.luck.picture.lib.loader.LocalMediaPageLoader.q(r1)     // Catch:{ Exception -> 0x0079 }
                    r2.setFirstMimeType(r8)     // Catch:{ Exception -> 0x0079 }
                    java.lang.String r8 = r2.getFirstImagePath()     // Catch:{ Exception -> 0x0079 }
                    boolean r8 = com.luck.picture.lib.config.PictureMimeType.c(r8)     // Catch:{ Exception -> 0x0079 }
                    if (r8 == 0) goto L_0x0200
                    com.luck.picture.lib.loader.LocalMediaPageLoader r8 = com.luck.picture.lib.loader.LocalMediaPageLoader.this     // Catch:{ Exception -> 0x0079 }
                    android.content.Context r8 = r8.b()     // Catch:{ Exception -> 0x0079 }
                    java.lang.String r9 = r2.getFirstImagePath()     // Catch:{ Exception -> 0x0079 }
                    android.net.Uri r9 = android.net.Uri.parse(r9)     // Catch:{ Exception -> 0x0079 }
                    java.lang.String r8 = com.luck.picture.lib.utils.PictureFileUtils.h(r8, r9)     // Catch:{ Exception -> 0x0079 }
                    java.io.File r9 = new java.io.File     // Catch:{ Exception -> 0x0079 }
                    r9.<init>(r8)     // Catch:{ Exception -> 0x0079 }
                    long r8 = r9.lastModified()     // Catch:{ Exception -> 0x0079 }
                    goto L_0x020d
                L_0x0200:
                    java.io.File r8 = new java.io.File     // Catch:{ Exception -> 0x0079 }
                    java.lang.String r9 = r2.getFirstImagePath()     // Catch:{ Exception -> 0x0079 }
                    r8.<init>(r9)     // Catch:{ Exception -> 0x0079 }
                    long r8 = r8.lastModified()     // Catch:{ Exception -> 0x0079 }
                L_0x020d:
                    int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                    if (r6 <= 0) goto L_0x023f
                    java.lang.String r6 = r4.getFirstImagePath()     // Catch:{ Exception -> 0x0079 }
                    r2.setFirstImagePath(r6)     // Catch:{ Exception -> 0x0079 }
                    java.lang.String r4 = r4.getFirstMimeType()     // Catch:{ Exception -> 0x0079 }
                    r2.setFirstMimeType(r4)     // Catch:{ Exception -> 0x0079 }
                    goto L_0x023f
                L_0x0220:
                    boolean r4 = r1.moveToFirst()     // Catch:{ Exception -> 0x0079 }
                    if (r4 == 0) goto L_0x023f
                    boolean r4 = com.luck.picture.lib.utils.SdkVersionUtils.f()     // Catch:{ Exception -> 0x0079 }
                    if (r4 == 0) goto L_0x0231
                    java.lang.String r4 = com.luck.picture.lib.loader.LocalMediaPageLoader.r(r1)     // Catch:{ Exception -> 0x0079 }
                    goto L_0x0235
                L_0x0231:
                    java.lang.String r4 = com.luck.picture.lib.loader.LocalMediaPageLoader.s(r1)     // Catch:{ Exception -> 0x0079 }
                L_0x0235:
                    r2.setFirstImagePath(r4)     // Catch:{ Exception -> 0x0079 }
                    java.lang.String r4 = com.luck.picture.lib.loader.LocalMediaPageLoader.q(r1)     // Catch:{ Exception -> 0x0079 }
                    r2.setFirstMimeType(r4)     // Catch:{ Exception -> 0x0079 }
                L_0x023f:
                    if (r5 != 0) goto L_0x024b
                    boolean r0 = r1.isClosed()
                    if (r0 != 0) goto L_0x024a
                    r1.close()
                L_0x024a:
                    return r3
                L_0x024b:
                    com.luck.picture.lib.utils.SortUtils.e(r3)     // Catch:{ Exception -> 0x0079 }
                    r2.setFolderTotalNum(r5)     // Catch:{ Exception -> 0x0079 }
                    r4 = -1
                    r2.setBucketId(r4)     // Catch:{ Exception -> 0x0079 }
                    com.luck.picture.lib.loader.LocalMediaPageLoader r4 = com.luck.picture.lib.loader.LocalMediaPageLoader.this     // Catch:{ Exception -> 0x0079 }
                    com.luck.picture.lib.config.SelectorConfig r4 = r4.a()     // Catch:{ Exception -> 0x0079 }
                    java.lang.String r4 = r4.c0     // Catch:{ Exception -> 0x0079 }
                    boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0079 }
                    if (r4 == 0) goto L_0x0288
                    com.luck.picture.lib.loader.LocalMediaPageLoader r4 = com.luck.picture.lib.loader.LocalMediaPageLoader.this     // Catch:{ Exception -> 0x0079 }
                    com.luck.picture.lib.config.SelectorConfig r4 = r4.a()     // Catch:{ Exception -> 0x0079 }
                    int r4 = r4.f9404a     // Catch:{ Exception -> 0x0079 }
                    int r5 = com.luck.picture.lib.config.SelectMimeType.b()     // Catch:{ Exception -> 0x0079 }
                    if (r4 != r5) goto L_0x027f
                    com.luck.picture.lib.loader.LocalMediaPageLoader r4 = com.luck.picture.lib.loader.LocalMediaPageLoader.this     // Catch:{ Exception -> 0x0079 }
                    android.content.Context r4 = r4.b()     // Catch:{ Exception -> 0x0079 }
                    int r5 = com.luck.picture.lib.R.string.ps_all_audio     // Catch:{ Exception -> 0x0079 }
                L_0x027a:
                    java.lang.String r4 = r4.getString(r5)     // Catch:{ Exception -> 0x0079 }
                    goto L_0x0290
                L_0x027f:
                    com.luck.picture.lib.loader.LocalMediaPageLoader r4 = com.luck.picture.lib.loader.LocalMediaPageLoader.this     // Catch:{ Exception -> 0x0079 }
                    android.content.Context r4 = r4.b()     // Catch:{ Exception -> 0x0079 }
                    int r5 = com.luck.picture.lib.R.string.ps_camera_roll     // Catch:{ Exception -> 0x0079 }
                    goto L_0x027a
                L_0x0288:
                    com.luck.picture.lib.loader.LocalMediaPageLoader r4 = com.luck.picture.lib.loader.LocalMediaPageLoader.this     // Catch:{ Exception -> 0x0079 }
                    com.luck.picture.lib.config.SelectorConfig r4 = r4.a()     // Catch:{ Exception -> 0x0079 }
                    java.lang.String r4 = r4.c0     // Catch:{ Exception -> 0x0079 }
                L_0x0290:
                    r2.setFolderName(r4)     // Catch:{ Exception -> 0x0079 }
                    r7 = 0
                    r3.add(r7, r2)     // Catch:{ Exception -> 0x0079 }
                    com.luck.picture.lib.loader.LocalMediaPageLoader r2 = com.luck.picture.lib.loader.LocalMediaPageLoader.this     // Catch:{ Exception -> 0x0079 }
                    com.luck.picture.lib.config.SelectorConfig r2 = r2.a()     // Catch:{ Exception -> 0x0079 }
                    boolean r2 = r2.m0     // Catch:{ Exception -> 0x0079 }
                    if (r2 == 0) goto L_0x02b4
                    com.luck.picture.lib.loader.LocalMediaPageLoader r2 = com.luck.picture.lib.loader.LocalMediaPageLoader.this     // Catch:{ Exception -> 0x0079 }
                    com.luck.picture.lib.config.SelectorConfig r2 = r2.a()     // Catch:{ Exception -> 0x0079 }
                    int r2 = r2.f9404a     // Catch:{ Exception -> 0x0079 }
                    int r4 = com.luck.picture.lib.config.SelectMimeType.a()     // Catch:{ Exception -> 0x0079 }
                    if (r2 != r4) goto L_0x02b4
                    com.luck.picture.lib.loader.LocalMediaPageLoader r0 = com.luck.picture.lib.loader.LocalMediaPageLoader.this     // Catch:{ Exception -> 0x0079 }
                    r0.J(r3)     // Catch:{ Exception -> 0x0079 }
                L_0x02b4:
                    boolean r0 = r1.isClosed()
                    if (r0 != 0) goto L_0x02bd
                    r1.close()
                L_0x02bd:
                    return r3
                L_0x02be:
                    r0.printStackTrace()     // Catch:{ all -> 0x0076 }
                    java.lang.String r2 = com.luck.picture.lib.loader.IBridgeMediaLoader.c     // Catch:{ all -> 0x0076 }
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0076 }
                    r3.<init>()     // Catch:{ all -> 0x0076 }
                    java.lang.String r4 = "loadAllMedia Data Error: "
                    r3.append(r4)     // Catch:{ all -> 0x0076 }
                    java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0076 }
                    r3.append(r0)     // Catch:{ all -> 0x0076 }
                    java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0076 }
                    android.util.Log.i(r2, r0)     // Catch:{ all -> 0x0076 }
                    boolean r0 = r1.isClosed()
                    if (r0 != 0) goto L_0x02f8
                L_0x02e1:
                    r1.close()
                    goto L_0x02f8
                L_0x02e5:
                    boolean r2 = r1.isClosed()
                    if (r2 != 0) goto L_0x02ee
                    r1.close()
                L_0x02ee:
                    throw r0
                L_0x02ef:
                    if (r1 == 0) goto L_0x02f8
                    boolean r0 = r1.isClosed()
                    if (r0 != 0) goto L_0x02f8
                    goto L_0x02e1
                L_0x02f8:
                    java.util.ArrayList r0 = new java.util.ArrayList
                    r0.<init>()
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.loader.LocalMediaPageLoader.AnonymousClass3.f():java.util.List");
            }

            /* renamed from: p */
            public void l(List list) {
                PictureThreadUtils.d(this);
                LocalMedia.destroyPool();
                OnQueryAllAlbumListener onQueryAllAlbumListener = onQueryAllAlbumListener;
                if (onQueryAllAlbumListener != null) {
                    onQueryAllAlbumListener.a(list);
                }
            }
        });
    }

    public void g(final OnQueryAlbumListener onQueryAlbumListener) {
        PictureThreadUtils.h(new PictureThreadUtils.SimpleTask<LocalMediaFolder>() {
            /* renamed from: o */
            public LocalMediaFolder f() {
                return SandboxFileLoader.b(LocalMediaPageLoader.this.b(), LocalMediaPageLoader.this.a().Y);
            }

            /* renamed from: p */
            public void l(LocalMediaFolder localMediaFolder) {
                PictureThreadUtils.d(this);
                OnQueryAlbumListener onQueryAlbumListener = onQueryAlbumListener;
                if (onQueryAlbumListener != null) {
                    onQueryAlbumListener.a(localMediaFolder);
                }
            }
        });
    }

    public void h(long j, int i, int i2, OnQueryDataResultListener onQueryDataResultListener) {
        final long j2 = j;
        final int i3 = i2;
        final int i4 = i;
        final OnQueryDataResultListener onQueryDataResultListener2 = onQueryDataResultListener;
        PictureThreadUtils.h(new PictureThreadUtils.SimpleTask<MediaData>() {
            /* JADX WARNING: type inference failed for: r0v0, types: [android.os.CancellationSignal, android.database.Cursor] */
            /* renamed from: o */
            public MediaData f() {
                Cursor cursor;
                ArrayList a2;
                String str;
                ? r0 = 0;
                try {
                    boolean z = true;
                    if (SdkVersionUtils.g()) {
                        String i2 = LocalMediaPageLoader.this.t(j2);
                        String[] j2 = LocalMediaPageLoader.this.u(j2);
                        int i3 = i3;
                        cursor = LocalMediaPageLoader.this.b().getContentResolver().query(IBridgeMediaLoader.d, IBridgeMediaLoader.e, MediaUtils.a(i2, j2, i3, (i4 - 1) * i3, LocalMediaPageLoader.this.G()), r0);
                    } else {
                        if (i4 == -1) {
                            str = LocalMediaPageLoader.this.G();
                        } else {
                            str = LocalMediaPageLoader.this.G() + " limit " + i3 + " offset " + ((i4 - 1) * i3);
                        }
                        cursor = LocalMediaPageLoader.this.b().getContentResolver().query(IBridgeMediaLoader.d, IBridgeMediaLoader.e, LocalMediaPageLoader.this.t(j2), LocalMediaPageLoader.this.u(j2), str);
                    }
                    if (cursor != null) {
                        ArrayList arrayList = new ArrayList();
                        if (cursor.getCount() > 0) {
                            cursor.moveToFirst();
                            do {
                                LocalMedia I = LocalMediaPageLoader.this.I(cursor, false);
                                if (I != null) {
                                    arrayList.add(I);
                                }
                            } while (cursor.moveToNext());
                        }
                        if (j2 == -1 && i4 == 1 && (a2 = SandboxFileLoader.a(LocalMediaPageLoader.this.b(), LocalMediaPageLoader.this.a().Y)) != null) {
                            arrayList.addAll(a2);
                            SortUtils.f(arrayList);
                        }
                        if (cursor.getCount() <= 0) {
                            z = false;
                        }
                        MediaData mediaData = new MediaData(z, arrayList);
                        if (!cursor.isClosed()) {
                            cursor.close();
                        }
                        return mediaData;
                    }
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    return new MediaData();
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.i(IBridgeMediaLoader.c, "loadMedia Page Data Error: " + e.getMessage());
                    MediaData mediaData2 = new MediaData();
                    if (r0 != 0 && !r0.isClosed()) {
                        r0.close();
                    }
                    return mediaData2;
                } catch (Throwable th) {
                    if (r0 != 0 && !r0.isClosed()) {
                        r0.close();
                    }
                    throw th;
                }
            }

            /* renamed from: p */
            public void l(MediaData mediaData) {
                PictureThreadUtils.d(this);
                OnQueryDataResultListener onQueryDataResultListener = onQueryDataResultListener2;
                if (onQueryDataResultListener != null) {
                    ArrayList arrayList = mediaData.b;
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    onQueryDataResultListener.a(arrayList, mediaData.f9420a);
                }
            }
        });
    }

    public String p(long j) {
        Cursor cursor;
        Cursor cursor2;
        Cursor cursor3 = null;
        try {
            if (SdkVersionUtils.g()) {
                cursor2 = b().getContentResolver().query(IBridgeMediaLoader.d, new String[]{"_id", "mime_type", "_data"}, MediaUtils.a(t(j), u(j), 1, 0, G()), (CancellationSignal) null);
            } else {
                cursor2 = b().getContentResolver().query(IBridgeMediaLoader.d, new String[]{"_id", "mime_type", "_data"}, t(j), u(j), G() + " limit 1 offset 0");
            }
            if (cursor2 != null) {
                try {
                    if (cursor2.getCount() > 0) {
                        if (cursor2.moveToFirst()) {
                            String l = SdkVersionUtils.f() ? MediaUtils.l(cursor2.getLong(cursor2.getColumnIndexOrThrow("_id")), cursor2.getString(cursor2.getColumnIndexOrThrow("mime_type"))) : cursor2.getString(cursor2.getColumnIndexOrThrow("_data"));
                            if (!cursor2.isClosed()) {
                                cursor2.close();
                            }
                            return l;
                        }
                        if (!cursor2.isClosed()) {
                            cursor2.close();
                        }
                        return null;
                    }
                } catch (Exception e) {
                    Exception exc = e;
                    cursor = cursor2;
                    e = exc;
                    try {
                        e.printStackTrace();
                        cursor.close();
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        cursor3 = cursor;
                        if (cursor3 != null && !cursor3.isClosed()) {
                            cursor3.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    cursor3 = cursor2;
                    th = th2;
                    cursor3.close();
                    throw th;
                }
            }
            if (cursor2 != null && !cursor2.isClosed()) {
                cursor2.close();
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
            e.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            cursor3.close();
            throw th;
        }
        return null;
    }

    public final String t(long j) {
        String c = c();
        String d = d();
        String e = e();
        int i = a().f9404a;
        if (i == 0) {
            return v(j, e, c, d);
        }
        if (i == 1) {
            return x(j, e, d);
        }
        if (i == 2) {
            return y(j, e, c, d);
        }
        if (i != 3) {
            return null;
        }
        return w(j, e, c, d);
    }

    public final String[] u(long j) {
        int i = a().f9404a;
        if (i == 0) {
            return j == -1 ? new String[]{String.valueOf(1), String.valueOf(3)} : new String[]{String.valueOf(1), String.valueOf(3), ValueOf.g(Long.valueOf(j))};
        }
        if (i == 1) {
            return E(1, j);
        }
        if (i == 2) {
            return E(3, j);
        }
        if (i != 3) {
            return null;
        }
        return E(2, j);
    }

    public String z() {
        String c = c();
        String d = d();
        String e = e();
        int i = a().f9404a;
        if (i == 0) {
            return B(c, d, e);
        }
        if (i == 1) {
            return D(d, e);
        }
        if (i == 2) {
            return F(c, e);
        }
        if (i != 3) {
            return null;
        }
        return C(c, e);
    }
}
