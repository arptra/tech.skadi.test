package com.luck.picture.lib.loader;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.interfaces.OnQueryAlbumListener;
import com.luck.picture.lib.interfaces.OnQueryAllAlbumListener;
import com.luck.picture.lib.interfaces.OnQueryDataResultListener;
import com.luck.picture.lib.interfaces.OnQueryFilterListener;
import com.luck.picture.lib.thread.PictureThreadUtils;
import com.luck.picture.lib.utils.MediaUtils;
import com.luck.picture.lib.utils.SdkVersionUtils;
import java.util.Iterator;
import java.util.List;

public final class LocalMediaLoader extends IBridgeMediaLoader {
    public LocalMediaLoader(Context context, SelectorConfig selectorConfig) {
        super(context, selectorConfig);
    }

    public static String m(String str, String str2, String str3) {
        return "(media_type=?" + str3 + " OR " + "media_type" + "=? AND " + str + ") AND " + str2;
    }

    public static String n(String str, String str2) {
        return "media_type=?" + str2 + " AND " + str;
    }

    public static String o(String str, String str2) {
        return "media_type=?" + str2 + " AND " + str;
    }

    public static String p(String str, String str2) {
        return "media_type=?" + str2 + " AND " + str;
    }

    public void f(final OnQueryAllAlbumListener onQueryAllAlbumListener) {
        PictureThreadUtils.h(new PictureThreadUtils.SimpleTask<List<LocalMediaFolder>>() {
            /* JADX WARNING: Code restructure failed: missing block: B:38:0x014c, code lost:
                if (r1.isClosed() != false) goto L_0x0165;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:39:0x014e, code lost:
                r1.close();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:46:0x0162, code lost:
                if (r1.isClosed() == false) goto L_0x014e;
             */
            /* renamed from: o */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.List f() {
                /*
                    r10 = this;
                    java.util.ArrayList r0 = new java.util.ArrayList
                    r0.<init>()
                    com.luck.picture.lib.loader.LocalMediaLoader r1 = com.luck.picture.lib.loader.LocalMediaLoader.this
                    android.content.Context r1 = r1.b()
                    android.content.ContentResolver r2 = r1.getContentResolver()
                    android.net.Uri r3 = com.luck.picture.lib.loader.IBridgeMediaLoader.d
                    java.lang.String[] r4 = com.luck.picture.lib.loader.IBridgeMediaLoader.e
                    com.luck.picture.lib.loader.LocalMediaLoader r1 = com.luck.picture.lib.loader.LocalMediaLoader.this
                    java.lang.String r5 = r1.k()
                    com.luck.picture.lib.loader.LocalMediaLoader r1 = com.luck.picture.lib.loader.LocalMediaLoader.this
                    java.lang.String[] r6 = r1.l()
                    com.luck.picture.lib.loader.LocalMediaLoader r1 = com.luck.picture.lib.loader.LocalMediaLoader.this
                    java.lang.String r7 = r1.q()
                    android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7)
                    if (r1 == 0) goto L_0x015c
                    com.luck.picture.lib.entity.LocalMediaFolder r2 = new com.luck.picture.lib.entity.LocalMediaFolder     // Catch:{ Exception -> 0x00d4 }
                    r2.<init>()     // Catch:{ Exception -> 0x00d4 }
                    java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x00d4 }
                    r3.<init>()     // Catch:{ Exception -> 0x00d4 }
                    int r4 = r1.getCount()     // Catch:{ Exception -> 0x00d4 }
                    if (r4 <= 0) goto L_0x015c
                    r1.moveToFirst()     // Catch:{ Exception -> 0x00d4 }
                L_0x003e:
                    com.luck.picture.lib.loader.LocalMediaLoader r4 = com.luck.picture.lib.loader.LocalMediaLoader.this     // Catch:{ Exception -> 0x00d4 }
                    r5 = 0
                    com.luck.picture.lib.entity.LocalMedia r4 = r4.r(r1, r5)     // Catch:{ Exception -> 0x00d4 }
                    if (r4 != 0) goto L_0x0048
                    goto L_0x0084
                L_0x0048:
                    com.luck.picture.lib.loader.LocalMediaLoader r6 = com.luck.picture.lib.loader.LocalMediaLoader.this     // Catch:{ Exception -> 0x00d4 }
                    java.lang.String r7 = r4.getPath()     // Catch:{ Exception -> 0x00d4 }
                    java.lang.String r8 = r4.getMimeType()     // Catch:{ Exception -> 0x00d4 }
                    java.lang.String r9 = r4.getParentFolderName()     // Catch:{ Exception -> 0x00d4 }
                    com.luck.picture.lib.entity.LocalMediaFolder r6 = r6.j(r7, r8, r9, r0)     // Catch:{ Exception -> 0x00d4 }
                    long r7 = r4.getBucketId()     // Catch:{ Exception -> 0x00d4 }
                    r6.setBucketId(r7)     // Catch:{ Exception -> 0x00d4 }
                    java.util.ArrayList r7 = r6.getData()     // Catch:{ Exception -> 0x00d4 }
                    r7.add(r4)     // Catch:{ Exception -> 0x00d4 }
                    int r7 = r6.getFolderTotalNum()     // Catch:{ Exception -> 0x00d4 }
                    int r7 = r7 + 1
                    r6.setFolderTotalNum(r7)     // Catch:{ Exception -> 0x00d4 }
                    long r7 = r4.getBucketId()     // Catch:{ Exception -> 0x00d4 }
                    r6.setBucketId(r7)     // Catch:{ Exception -> 0x00d4 }
                    r3.add(r4)     // Catch:{ Exception -> 0x00d4 }
                    int r4 = r2.getFolderTotalNum()     // Catch:{ Exception -> 0x00d4 }
                    int r4 = r4 + 1
                    r2.setFolderTotalNum(r4)     // Catch:{ Exception -> 0x00d4 }
                L_0x0084:
                    boolean r4 = r1.moveToNext()     // Catch:{ Exception -> 0x00d4 }
                    if (r4 != 0) goto L_0x003e
                    com.luck.picture.lib.loader.LocalMediaLoader r4 = com.luck.picture.lib.loader.LocalMediaLoader.this     // Catch:{ Exception -> 0x00d4 }
                    android.content.Context r4 = r4.b()     // Catch:{ Exception -> 0x00d4 }
                    com.luck.picture.lib.loader.LocalMediaLoader r6 = com.luck.picture.lib.loader.LocalMediaLoader.this     // Catch:{ Exception -> 0x00d4 }
                    com.luck.picture.lib.config.SelectorConfig r6 = r6.a()     // Catch:{ Exception -> 0x00d4 }
                    java.lang.String r6 = r6.Y     // Catch:{ Exception -> 0x00d4 }
                    com.luck.picture.lib.entity.LocalMediaFolder r4 = com.luck.picture.lib.loader.SandboxFileLoader.b(r4, r6)     // Catch:{ Exception -> 0x00d4 }
                    if (r4 == 0) goto L_0x00d9
                    r0.add(r4)     // Catch:{ Exception -> 0x00d4 }
                    int r6 = r2.getFolderTotalNum()     // Catch:{ Exception -> 0x00d4 }
                    int r7 = r4.getFolderTotalNum()     // Catch:{ Exception -> 0x00d4 }
                    int r6 = r6 + r7
                    r2.setFolderTotalNum(r6)     // Catch:{ Exception -> 0x00d4 }
                    java.util.ArrayList r6 = r4.getData()     // Catch:{ Exception -> 0x00d4 }
                    r2.setData(r6)     // Catch:{ Exception -> 0x00d4 }
                    java.util.ArrayList r6 = r4.getData()     // Catch:{ Exception -> 0x00d4 }
                    r3.addAll(r5, r6)     // Catch:{ Exception -> 0x00d4 }
                    int r4 = r4.getFolderTotalNum()     // Catch:{ Exception -> 0x00d4 }
                    r6 = 60
                    if (r6 <= r4) goto L_0x00d9
                    int r4 = r3.size()     // Catch:{ Exception -> 0x00d4 }
                    if (r4 <= r6) goto L_0x00d6
                    java.util.List r4 = r3.subList(r5, r6)     // Catch:{ Exception -> 0x00d4 }
                    com.luck.picture.lib.utils.SortUtils.f(r4)     // Catch:{ Exception -> 0x00d4 }
                    goto L_0x00d9
                L_0x00d1:
                    r10 = move-exception
                    goto L_0x0152
                L_0x00d4:
                    r10 = move-exception
                    goto L_0x0145
                L_0x00d6:
                    com.luck.picture.lib.utils.SortUtils.f(r3)     // Catch:{ Exception -> 0x00d4 }
                L_0x00d9:
                    int r4 = r3.size()     // Catch:{ Exception -> 0x00d4 }
                    if (r4 <= 0) goto L_0x015c
                    com.luck.picture.lib.utils.SortUtils.e(r0)     // Catch:{ Exception -> 0x00d4 }
                    r0.add(r5, r2)     // Catch:{ Exception -> 0x00d4 }
                    java.lang.Object r4 = r3.get(r5)     // Catch:{ Exception -> 0x00d4 }
                    com.luck.picture.lib.entity.LocalMedia r4 = (com.luck.picture.lib.entity.LocalMedia) r4     // Catch:{ Exception -> 0x00d4 }
                    java.lang.String r4 = r4.getPath()     // Catch:{ Exception -> 0x00d4 }
                    r2.setFirstImagePath(r4)     // Catch:{ Exception -> 0x00d4 }
                    java.lang.Object r4 = r3.get(r5)     // Catch:{ Exception -> 0x00d4 }
                    com.luck.picture.lib.entity.LocalMedia r4 = (com.luck.picture.lib.entity.LocalMedia) r4     // Catch:{ Exception -> 0x00d4 }
                    java.lang.String r4 = r4.getMimeType()     // Catch:{ Exception -> 0x00d4 }
                    r2.setFirstMimeType(r4)     // Catch:{ Exception -> 0x00d4 }
                    com.luck.picture.lib.loader.LocalMediaLoader r4 = com.luck.picture.lib.loader.LocalMediaLoader.this     // Catch:{ Exception -> 0x00d4 }
                    com.luck.picture.lib.config.SelectorConfig r4 = r4.a()     // Catch:{ Exception -> 0x00d4 }
                    java.lang.String r4 = r4.c0     // Catch:{ Exception -> 0x00d4 }
                    boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x00d4 }
                    if (r4 == 0) goto L_0x0131
                    com.luck.picture.lib.loader.LocalMediaLoader r4 = com.luck.picture.lib.loader.LocalMediaLoader.this     // Catch:{ Exception -> 0x00d4 }
                    com.luck.picture.lib.config.SelectorConfig r4 = r4.a()     // Catch:{ Exception -> 0x00d4 }
                    int r4 = r4.f9404a     // Catch:{ Exception -> 0x00d4 }
                    int r5 = com.luck.picture.lib.config.SelectMimeType.b()     // Catch:{ Exception -> 0x00d4 }
                    if (r4 != r5) goto L_0x0128
                    com.luck.picture.lib.loader.LocalMediaLoader r10 = com.luck.picture.lib.loader.LocalMediaLoader.this     // Catch:{ Exception -> 0x00d4 }
                    android.content.Context r10 = r10.b()     // Catch:{ Exception -> 0x00d4 }
                    int r4 = com.luck.picture.lib.R.string.ps_all_audio     // Catch:{ Exception -> 0x00d4 }
                L_0x0123:
                    java.lang.String r10 = r10.getString(r4)     // Catch:{ Exception -> 0x00d4 }
                    goto L_0x0139
                L_0x0128:
                    com.luck.picture.lib.loader.LocalMediaLoader r10 = com.luck.picture.lib.loader.LocalMediaLoader.this     // Catch:{ Exception -> 0x00d4 }
                    android.content.Context r10 = r10.b()     // Catch:{ Exception -> 0x00d4 }
                    int r4 = com.luck.picture.lib.R.string.ps_camera_roll     // Catch:{ Exception -> 0x00d4 }
                    goto L_0x0123
                L_0x0131:
                    com.luck.picture.lib.loader.LocalMediaLoader r10 = com.luck.picture.lib.loader.LocalMediaLoader.this     // Catch:{ Exception -> 0x00d4 }
                    com.luck.picture.lib.config.SelectorConfig r10 = r10.a()     // Catch:{ Exception -> 0x00d4 }
                    java.lang.String r10 = r10.c0     // Catch:{ Exception -> 0x00d4 }
                L_0x0139:
                    r2.setFolderName(r10)     // Catch:{ Exception -> 0x00d4 }
                    r4 = -1
                    r2.setBucketId(r4)     // Catch:{ Exception -> 0x00d4 }
                    r2.setData(r3)     // Catch:{ Exception -> 0x00d4 }
                    goto L_0x015c
                L_0x0145:
                    r10.printStackTrace()     // Catch:{ all -> 0x00d1 }
                    boolean r10 = r1.isClosed()
                    if (r10 != 0) goto L_0x0165
                L_0x014e:
                    r1.close()
                    goto L_0x0165
                L_0x0152:
                    boolean r0 = r1.isClosed()
                    if (r0 != 0) goto L_0x015b
                    r1.close()
                L_0x015b:
                    throw r10
                L_0x015c:
                    if (r1 == 0) goto L_0x0165
                    boolean r10 = r1.isClosed()
                    if (r10 != 0) goto L_0x0165
                    goto L_0x014e
                L_0x0165:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.loader.LocalMediaLoader.AnonymousClass1.f():java.util.List");
            }

            /* renamed from: p */
            public void l(List list) {
                PictureThreadUtils.d(this);
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
                return SandboxFileLoader.b(LocalMediaLoader.this.b(), LocalMediaLoader.this.a().Y);
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
    }

    public final LocalMediaFolder j(String str, String str2, String str3, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            LocalMediaFolder localMediaFolder = (LocalMediaFolder) it.next();
            String folderName = localMediaFolder.getFolderName();
            if (!TextUtils.isEmpty(folderName) && TextUtils.equals(folderName, str3)) {
                return localMediaFolder;
            }
        }
        LocalMediaFolder localMediaFolder2 = new LocalMediaFolder();
        localMediaFolder2.setFolderName(str3);
        localMediaFolder2.setFirstImagePath(str);
        localMediaFolder2.setFirstMimeType(str2);
        list.add(localMediaFolder2);
        return localMediaFolder2;
    }

    public String k() {
        String c = c();
        String d = d();
        String e = e();
        int i = a().f9404a;
        if (i == 0) {
            return m(c, d, e);
        }
        if (i == 1) {
            return o(d, e);
        }
        if (i == 2) {
            return p(c, e);
        }
        if (i != 3) {
            return null;
        }
        return n(c, e);
    }

    public String[] l() {
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

    public String q() {
        return TextUtils.isEmpty(a().b0) ? "date_modified DESC" : a().b0;
    }

    public LocalMedia r(Cursor cursor, boolean z) {
        long j;
        long j2;
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
        long j3 = cursor2.getLong(columnIndexOrThrow);
        int i = columnIndexOrThrow10;
        long j4 = cursor2.getLong(columnIndexOrThrow11);
        String string = cursor2.getString(columnIndexOrThrow3);
        String string2 = cursor2.getString(columnIndexOrThrow2);
        String l = SdkVersionUtils.f() ? MediaUtils.l(j3, string) : string2;
        if (TextUtils.isEmpty(string)) {
            string = PictureMimeType.r();
        }
        if (string.endsWith("image/*")) {
            string = MediaUtils.j(string2);
            j = j4;
            if (!a().E && PictureMimeType.f(string)) {
                return null;
            }
        } else {
            j = j4;
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
        if (i4 == 90 || i4 == 270) {
            i2 = cursor2.getInt(columnIndexOrThrow5);
            i3 = cursor2.getInt(columnIndexOrThrow4);
        }
        long j5 = cursor2.getLong(columnIndexOrThrow6);
        long j6 = cursor2.getLong(columnIndexOrThrow7);
        String string3 = cursor2.getString(columnIndexOrThrow8);
        String string4 = cursor2.getString(columnIndexOrThrow9);
        int i5 = i2;
        long j7 = cursor2.getLong(i);
        if (TextUtils.isEmpty(string4)) {
            string4 = PictureMimeType.b(string2);
        }
        if (a().D0 && j6 > 0 && j6 < 1024) {
            return null;
        }
        if (PictureMimeType.i(string) || PictureMimeType.d(string)) {
            if (a().r > 0) {
                j2 = j6;
                if (j5 < ((long) a().r)) {
                    return null;
                }
            } else {
                j2 = j6;
            }
            if (a().q > 0 && j5 > ((long) a().q)) {
                return null;
            }
            if (a().D0 && j5 <= 0) {
                return null;
            }
        } else {
            j2 = j6;
        }
        LocalMedia create = LocalMedia.create();
        create.setId(j3);
        create.setBucketId(j7);
        create.setPath(l);
        create.setRealPath(string2);
        create.setFileName(string4);
        create.setParentFolderName(string3);
        create.setDuration(j5);
        create.setChooseModel(a().f9404a);
        create.setMimeType(string);
        create.setWidth(i5);
        create.setHeight(i3);
        create.setSize(j2);
        create.setDateAddedTime(j);
        OnQueryFilterListener onQueryFilterListener = this.b.k1;
        if (onQueryFilterListener == null || !onQueryFilterListener.a(create)) {
            return create;
        }
        return null;
    }
}
