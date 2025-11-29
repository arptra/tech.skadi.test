package com.mr.flutter.plugin.filepicker;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.util.Log;
import com.meizu.common.widget.MzContactsContract;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class FilePickerDelegate implements PluginRegistry.ActivityResultListener {
    public static final int j;
    public static final int k;

    /* renamed from: a  reason: collision with root package name */
    public final Activity f9807a;
    public MethodChannel.Result b;
    public boolean c;
    public boolean d;
    public String e;
    public int f;
    public String[] g;
    public EventChannel.EventSink h;
    public byte[] i;

    static {
        Class<FilePickerPlugin> cls = FilePickerPlugin.class;
        j = (cls.hashCode() + 43) & 65535;
        k = (cls.hashCode() + 83) & 65535;
    }

    public FilePickerDelegate(Activity activity) {
        this(activity, (MethodChannel.Result) null);
    }

    public static void k(MethodChannel.Result result) {
        result.error("already_active", "File picker is already active", (Object) null);
    }

    public final void i() {
        this.b = null;
    }

    public final void j(final boolean z) {
        if (this.h != null && !this.e.equals("dir")) {
            new Handler(Looper.getMainLooper()) {
                public void handleMessage(Message message) {
                    FilePickerDelegate.this.h.success(Boolean.valueOf(z));
                }
            }.obtainMessage().sendToTarget();
        }
    }

    public final void l(String str, String str2) {
        if (this.b != null) {
            j(false);
            this.b.error(str, str2, (Object) null);
            i();
        }
    }

    public final void m(Object obj) {
        j(false);
        if (this.b != null) {
            if (obj != null && !(obj instanceof String)) {
                ArrayList arrayList = new ArrayList();
                Iterator it = ((ArrayList) obj).iterator();
                while (it.hasNext()) {
                    arrayList.add(((FileInfo) it.next()).a());
                }
                obj = arrayList;
            }
            this.b.success(obj);
            i();
        }
    }

    public final ArrayList n(Bundle bundle) {
        return Build.VERSION.SDK_INT >= 33 ? bundle.getParcelableArrayList("selectedItems", Parcelable.class) : bundle.getParcelableArrayList("selectedItems");
    }

    public void o(String str, String str2, String str3, String[] strArr, byte[] bArr, MethodChannel.Result result) {
        if (!q(result)) {
            k(result);
            return;
        }
        Intent intent = new Intent("android.intent.action.CREATE_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        if (str != null && !str.isEmpty()) {
            intent.putExtra("android.intent.extra.TITLE", str);
        }
        this.i = bArr;
        if (str2 == null || "dir".equals(str2) || str2.split(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA).length != 1) {
            intent.setType("*/*");
        } else {
            intent.setType(str2);
        }
        if (str3 != null && !str3.isEmpty()) {
            intent.putExtra("android.provider.extra.INITIAL_URI", Uri.parse(str3));
        }
        if (strArr != null && strArr.length > 0) {
            intent.putExtra("android.intent.extra.MIME_TYPES", strArr);
        }
        if (intent.resolveActivity(this.f9807a.getPackageManager()) != null) {
            this.f9807a.startActivityForResult(intent, k);
            return;
        }
        Log.e("FilePickerDelegate", "Can't find a valid activity to handle the request. Make sure you've a file explorer installed.");
        l("invalid_format_type", "Can't handle the provided file type.");
    }

    public boolean onActivityResult(int i2, int i3, final Intent intent) {
        if (i2 == k) {
            if (i3 == -1) {
                if (intent == null) {
                    return false;
                }
                j(true);
                Uri data = intent.getData();
                if (data != null) {
                    String str = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + File.separator + FileUtils.f(data, this.f9807a);
                    try {
                        OutputStream openOutputStream = this.f9807a.getContentResolver().openOutputStream(data);
                        if (openOutputStream != null) {
                            openOutputStream.write(this.i);
                            openOutputStream.flush();
                            openOutputStream.close();
                        }
                        m(str);
                        return true;
                    } catch (IOException e2) {
                        Log.i("FilePickerDelegate", "Error while saving file", e2);
                        l("Error while saving file", e2.getMessage());
                    }
                }
            }
            if (i3 == 0) {
                Log.i("FilePickerDelegate", "User cancelled the save request");
                m((Object) null);
            }
            return false;
        } else if (this.e == null) {
            return false;
        } else {
            int i4 = j;
            if (i2 == i4 && i3 == -1) {
                j(true);
                new Thread(new Runnable() {
                    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0194, code lost:
                        r2 = (android.net.Uri) r2;
                     */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void run() {
                        /*
                            r10 = this;
                            android.content.Intent r0 = r9
                            java.lang.String r1 = "Unknown activity error, please fill an issue."
                            java.lang.String r2 = "unknown_activity"
                            if (r0 == 0) goto L_0x01de
                            java.util.ArrayList r0 = new java.util.ArrayList
                            r0.<init>()
                            android.content.Intent r3 = r9
                            android.content.ClipData r3 = r3.getClipData()
                            java.lang.String r4 = " - URI: "
                            java.lang.String r5 = "[MultiFilePick] File #"
                            java.lang.String r6 = "image/*"
                            r7 = 0
                            java.lang.String r8 = "FilePickerDelegate"
                            if (r3 == 0) goto L_0x009b
                            android.content.Intent r1 = r9
                            android.content.ClipData r1 = r1.getClipData()
                            int r1 = r1.getItemCount()
                        L_0x0028:
                            if (r7 >= r1) goto L_0x0094
                            android.content.Intent r2 = r9
                            android.content.ClipData r2 = r2.getClipData()
                            android.content.ClipData$Item r2 = r2.getItemAt(r7)
                            android.net.Uri r2 = r2.getUri()
                            com.mr.flutter.plugin.filepicker.FilePickerDelegate r3 = com.mr.flutter.plugin.filepicker.FilePickerDelegate.this
                            java.lang.String r3 = r3.e
                            boolean r3 = java.util.Objects.equals(r3, r6)
                            if (r3 == 0) goto L_0x0060
                            com.mr.flutter.plugin.filepicker.FilePickerDelegate r3 = com.mr.flutter.plugin.filepicker.FilePickerDelegate.this
                            int r3 = r3.f
                            if (r3 <= 0) goto L_0x0060
                            com.mr.flutter.plugin.filepicker.FilePickerDelegate r3 = com.mr.flutter.plugin.filepicker.FilePickerDelegate.this
                            int r3 = r3.f
                            com.mr.flutter.plugin.filepicker.FilePickerDelegate r9 = com.mr.flutter.plugin.filepicker.FilePickerDelegate.this
                            android.app.Activity r9 = r9.f9807a
                            android.content.Context r9 = r9.getApplicationContext()
                            android.net.Uri r2 = com.mr.flutter.plugin.filepicker.FileUtils.b(r2, r3, r9)
                        L_0x0060:
                            com.mr.flutter.plugin.filepicker.FilePickerDelegate r3 = com.mr.flutter.plugin.filepicker.FilePickerDelegate.this
                            android.app.Activity r3 = r3.f9807a
                            com.mr.flutter.plugin.filepicker.FilePickerDelegate r9 = com.mr.flutter.plugin.filepicker.FilePickerDelegate.this
                            boolean r9 = r9.d
                            com.mr.flutter.plugin.filepicker.FileInfo r3 = com.mr.flutter.plugin.filepicker.FileUtils.m(r3, r2, r9)
                            if (r3 == 0) goto L_0x0091
                            r0.add(r3)
                            java.lang.StringBuilder r3 = new java.lang.StringBuilder
                            r3.<init>()
                            r3.append(r5)
                            r3.append(r7)
                            r3.append(r4)
                            java.lang.String r2 = r2.getPath()
                            r3.append(r2)
                            java.lang.String r2 = r3.toString()
                            android.util.Log.d(r8, r2)
                        L_0x0091:
                            int r7 = r7 + 1
                            goto L_0x0028
                        L_0x0094:
                            com.mr.flutter.plugin.filepicker.FilePickerDelegate r10 = com.mr.flutter.plugin.filepicker.FilePickerDelegate.this
                            r10.m(r0)
                            goto L_0x01e3
                        L_0x009b:
                            android.content.Intent r3 = r9
                            android.net.Uri r3 = r3.getData()
                            java.lang.String r9 = "unknown_path"
                            if (r3 == 0) goto L_0x015e
                            android.content.Intent r1 = r9
                            android.net.Uri r1 = r1.getData()
                            com.mr.flutter.plugin.filepicker.FilePickerDelegate r2 = com.mr.flutter.plugin.filepicker.FilePickerDelegate.this
                            java.lang.String r2 = r2.e
                            boolean r2 = java.util.Objects.equals(r2, r6)
                            if (r2 == 0) goto L_0x00d3
                            com.mr.flutter.plugin.filepicker.FilePickerDelegate r2 = com.mr.flutter.plugin.filepicker.FilePickerDelegate.this
                            int r2 = r2.f
                            if (r2 <= 0) goto L_0x00d3
                            com.mr.flutter.plugin.filepicker.FilePickerDelegate r2 = com.mr.flutter.plugin.filepicker.FilePickerDelegate.this
                            int r2 = r2.f
                            com.mr.flutter.plugin.filepicker.FilePickerDelegate r3 = com.mr.flutter.plugin.filepicker.FilePickerDelegate.this
                            android.app.Activity r3 = r3.f9807a
                            android.content.Context r3 = r3.getApplicationContext()
                            android.net.Uri r1 = com.mr.flutter.plugin.filepicker.FileUtils.b(r1, r2, r3)
                        L_0x00d3:
                            com.mr.flutter.plugin.filepicker.FilePickerDelegate r2 = com.mr.flutter.plugin.filepicker.FilePickerDelegate.this
                            java.lang.String r2 = r2.e
                            java.lang.String r3 = "dir"
                            boolean r2 = r2.equals(r3)
                            if (r2 == 0) goto L_0x011b
                            java.lang.String r0 = android.provider.DocumentsContract.getTreeDocumentId(r1)
                            android.net.Uri r0 = android.provider.DocumentsContract.buildDocumentUriUsingTree(r1, r0)
                            java.lang.StringBuilder r1 = new java.lang.StringBuilder
                            r1.<init>()
                            java.lang.String r2 = "[SingleFilePick] File URI:"
                            r1.append(r2)
                            java.lang.String r2 = r0.toString()
                            r1.append(r2)
                            java.lang.String r1 = r1.toString()
                            android.util.Log.d(r8, r1)
                            com.mr.flutter.plugin.filepicker.FilePickerDelegate r1 = com.mr.flutter.plugin.filepicker.FilePickerDelegate.this
                            android.app.Activity r1 = r1.f9807a
                            java.lang.String r0 = com.mr.flutter.plugin.filepicker.FileUtils.g(r0, r1)
                            if (r0 == 0) goto L_0x0113
                            com.mr.flutter.plugin.filepicker.FilePickerDelegate r10 = com.mr.flutter.plugin.filepicker.FilePickerDelegate.this
                            r10.m(r0)
                            goto L_0x011a
                        L_0x0113:
                            com.mr.flutter.plugin.filepicker.FilePickerDelegate r10 = com.mr.flutter.plugin.filepicker.FilePickerDelegate.this
                            java.lang.String r0 = "Failed to retrieve directory path."
                            r10.l(r9, r0)
                        L_0x011a:
                            return
                        L_0x011b:
                            com.mr.flutter.plugin.filepicker.FilePickerDelegate r2 = com.mr.flutter.plugin.filepicker.FilePickerDelegate.this
                            android.app.Activity r2 = r2.f9807a
                            com.mr.flutter.plugin.filepicker.FilePickerDelegate r3 = com.mr.flutter.plugin.filepicker.FilePickerDelegate.this
                            boolean r3 = r3.d
                            com.mr.flutter.plugin.filepicker.FileInfo r1 = com.mr.flutter.plugin.filepicker.FileUtils.m(r2, r1, r3)
                            if (r1 == 0) goto L_0x0130
                            r0.add(r1)
                        L_0x0130:
                            boolean r1 = r0.isEmpty()
                            if (r1 != 0) goto L_0x0155
                            java.lang.StringBuilder r1 = new java.lang.StringBuilder
                            r1.<init>()
                            java.lang.String r2 = "File path:"
                            r1.append(r2)
                            java.lang.String r2 = r0.toString()
                            r1.append(r2)
                            java.lang.String r1 = r1.toString()
                            android.util.Log.d(r8, r1)
                            com.mr.flutter.plugin.filepicker.FilePickerDelegate r10 = com.mr.flutter.plugin.filepicker.FilePickerDelegate.this
                            r10.m(r0)
                            goto L_0x01e3
                        L_0x0155:
                            com.mr.flutter.plugin.filepicker.FilePickerDelegate r10 = com.mr.flutter.plugin.filepicker.FilePickerDelegate.this
                            java.lang.String r0 = "Failed to retrieve path."
                            r10.l(r9, r0)
                            goto L_0x01e3
                        L_0x015e:
                            android.content.Intent r3 = r9
                            android.os.Bundle r3 = r3.getExtras()
                            if (r3 == 0) goto L_0x01d8
                            android.content.Intent r1 = r9
                            android.os.Bundle r1 = r1.getExtras()
                            java.util.Set r2 = r1.keySet()
                            java.lang.String r3 = "selectedItems"
                            boolean r2 = r2.contains(r3)
                            if (r2 == 0) goto L_0x01d0
                            com.mr.flutter.plugin.filepicker.FilePickerDelegate r2 = com.mr.flutter.plugin.filepicker.FilePickerDelegate.this
                            java.util.ArrayList r1 = r2.n(r1)
                            if (r1 == 0) goto L_0x01ca
                            java.util.Iterator r1 = r1.iterator()
                        L_0x0184:
                            boolean r2 = r1.hasNext()
                            if (r2 == 0) goto L_0x01ca
                            java.lang.Object r2 = r1.next()
                            android.os.Parcelable r2 = (android.os.Parcelable) r2
                            boolean r3 = r2 instanceof android.net.Uri
                            if (r3 == 0) goto L_0x01c7
                            android.net.Uri r2 = (android.net.Uri) r2
                            com.mr.flutter.plugin.filepicker.FilePickerDelegate r3 = com.mr.flutter.plugin.filepicker.FilePickerDelegate.this
                            android.app.Activity r3 = r3.f9807a
                            com.mr.flutter.plugin.filepicker.FilePickerDelegate r6 = com.mr.flutter.plugin.filepicker.FilePickerDelegate.this
                            boolean r6 = r6.d
                            com.mr.flutter.plugin.filepicker.FileInfo r3 = com.mr.flutter.plugin.filepicker.FileUtils.m(r3, r2, r6)
                            if (r3 == 0) goto L_0x01c7
                            r0.add(r3)
                            java.lang.StringBuilder r3 = new java.lang.StringBuilder
                            r3.<init>()
                            r3.append(r5)
                            r3.append(r7)
                            r3.append(r4)
                            java.lang.String r2 = r2.getPath()
                            r3.append(r2)
                            java.lang.String r2 = r3.toString()
                            android.util.Log.d(r8, r2)
                        L_0x01c7:
                            int r7 = r7 + 1
                            goto L_0x0184
                        L_0x01ca:
                            com.mr.flutter.plugin.filepicker.FilePickerDelegate r10 = com.mr.flutter.plugin.filepicker.FilePickerDelegate.this
                            r10.m(r0)
                            goto L_0x01e3
                        L_0x01d0:
                            com.mr.flutter.plugin.filepicker.FilePickerDelegate r10 = com.mr.flutter.plugin.filepicker.FilePickerDelegate.this
                            java.lang.String r0 = "Failed to retrieve path from bundle."
                            r10.l(r9, r0)
                            goto L_0x01e3
                        L_0x01d8:
                            com.mr.flutter.plugin.filepicker.FilePickerDelegate r10 = com.mr.flutter.plugin.filepicker.FilePickerDelegate.this
                            r10.l(r2, r1)
                            goto L_0x01e3
                        L_0x01de:
                            com.mr.flutter.plugin.filepicker.FilePickerDelegate r10 = com.mr.flutter.plugin.filepicker.FilePickerDelegate.this
                            r10.l(r2, r1)
                        L_0x01e3:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.mr.flutter.plugin.filepicker.FilePickerDelegate.AnonymousClass1.run():void");
                    }
                }).start();
                return true;
            } else if (i2 == i4 && i3 == 0) {
                Log.i("FilePickerDelegate", "User cancelled the picker request");
                m((Object) null);
                return true;
            } else {
                if (i2 == i4) {
                    l("unknown_activity", "Unknown activity error, please fill an issue.");
                }
                return false;
            }
        }
    }

    public void p(EventChannel.EventSink eventSink) {
        this.h = eventSink;
    }

    public final boolean q(MethodChannel.Result result) {
        if (this.b != null) {
            return false;
        }
        this.b = result;
        return true;
    }

    public final void r() {
        Intent intent;
        String str = this.e;
        if (str != null) {
            if (str.equals("dir")) {
                intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
            } else {
                if (this.e.equals("image/*")) {
                    intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                } else {
                    intent = new Intent("android.intent.action.GET_CONTENT");
                    intent.addCategory("android.intent.category.OPENABLE");
                }
                Uri parse = Uri.parse(Environment.getExternalStorageDirectory().getPath() + File.separator);
                Log.d("FilePickerDelegate", "Selected type " + this.e);
                intent.setDataAndType(parse, this.e);
                intent.setType(this.e);
                intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", this.c);
                intent.putExtra("multi-pick", this.c);
                if (this.e.contains(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA)) {
                    this.g = this.e.split(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA);
                }
                String[] strArr = this.g;
                if (strArr != null) {
                    intent.putExtra("android.intent.extra.MIME_TYPES", strArr);
                }
            }
            if (intent.resolveActivity(this.f9807a.getPackageManager()) != null) {
                this.f9807a.startActivityForResult(intent, j);
                return;
            }
            Log.e("FilePickerDelegate", "Can't find a valid activity to handle the request. Make sure you've a file explorer installed.");
            l("invalid_format_type", "Can't handle the provided file type.");
        }
    }

    public void s(String str, boolean z, boolean z2, String[] strArr, int i2, MethodChannel.Result result) {
        if (!q(result)) {
            k(result);
            return;
        }
        this.e = str;
        this.c = z;
        this.d = z2;
        this.g = strArr;
        this.f = i2;
        r();
    }

    public FilePickerDelegate(Activity activity, MethodChannel.Result result) {
        this.c = false;
        this.d = false;
        this.f = 20;
        this.f9807a = activity;
        this.b = result;
    }
}
