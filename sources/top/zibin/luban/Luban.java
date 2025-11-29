package top.zibin.luban;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.InputStream;
import top.zibin.luban.io.ArrayPoolProvide;

public class Luban implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    public String f3579a;
    public boolean b;
    public int c;
    public OnRenameListener d;
    public OnCompressListener e;
    public OnNewCompressListener f;
    public CompressionPredicate g;
    public Handler h;

    /* renamed from: top.zibin.luban.Luban$1  reason: invalid class name */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f3580a;
        public final /* synthetic */ InputStreamProvider b;
        public final /* synthetic */ Luban c;

        public void run() {
            try {
                this.c.h.sendMessage(this.c.h.obtainMessage(1));
                File a2 = this.c.c(this.f3580a, this.b);
                Message obtainMessage = this.c.h.obtainMessage(0);
                obtainMessage.arg1 = this.b.getIndex();
                obtainMessage.obj = a2;
                Bundle bundle = new Bundle();
                bundle.putString("source", this.b.getPath());
                obtainMessage.setData(bundle);
                this.c.h.sendMessage(obtainMessage);
            } catch (Exception unused) {
                Message obtainMessage2 = this.c.h.obtainMessage(2);
                obtainMessage2.arg1 = this.b.getIndex();
                Bundle bundle2 = new Bundle();
                bundle2.putString("source", this.b.getPath());
                obtainMessage2.setData(bundle2);
                this.c.h.sendMessage(obtainMessage2);
            }
        }
    }

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public Context f3581a;
        public boolean b;

        /* renamed from: top.zibin.luban.Luban$Builder$1  reason: invalid class name */
        class AnonymousClass1 extends InputStreamAdapter {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ File f3582a;
            public final /* synthetic */ int b;

            public InputStream a() {
                return ArrayPoolProvide.d().f(this.f3582a.getAbsolutePath());
            }

            public int getIndex() {
                return this.b;
            }

            public String getPath() {
                return this.f3582a.getAbsolutePath();
            }
        }

        /* renamed from: top.zibin.luban.Luban$Builder$2  reason: invalid class name */
        class AnonymousClass2 extends InputStreamAdapter {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f3583a;
            public final /* synthetic */ int b;

            public InputStream a() {
                return ArrayPoolProvide.d().f(this.f3583a);
            }

            public int getIndex() {
                return this.b;
            }

            public String getPath() {
                return this.f3583a;
            }
        }

        /* renamed from: top.zibin.luban.Luban$Builder$3  reason: invalid class name */
        class AnonymousClass3 extends InputStreamAdapter {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Uri f3584a;
            public final /* synthetic */ int b;
            public final /* synthetic */ Builder c;

            public InputStream a() {
                return this.c.b ? ArrayPoolProvide.d().e(this.c.f3581a.getContentResolver(), this.f3584a) : this.c.f3581a.getContentResolver().openInputStream(this.f3584a);
            }

            public int getIndex() {
                return this.b;
            }

            public String getPath() {
                boolean isContent = Checker.isContent(this.f3584a.toString());
                Uri uri = this.f3584a;
                return isContent ? uri.toString() : uri.getPath();
            }
        }

        /* renamed from: top.zibin.luban.Luban$Builder$4  reason: invalid class name */
        class AnonymousClass4 extends InputStreamAdapter {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f3585a;
            public final /* synthetic */ int b;

            public InputStream a() {
                return ArrayPoolProvide.d().f(this.f3585a);
            }

            public int getIndex() {
                return this.b;
            }

            public String getPath() {
                return this.f3585a;
            }
        }
    }

    public static File f(Context context, String str) {
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir != null) {
            File file = new File(externalCacheDir, str);
            if (file.mkdirs() || (file.exists() && file.isDirectory())) {
                return file;
            }
            return null;
        }
        if (Log.isLoggable("Luban", 6)) {
            Log.e("Luban", "default disk cache dir is null");
        }
        return null;
    }

    public final File c(Context context, InputStreamProvider inputStreamProvider) {
        try {
            return d(context, inputStreamProvider);
        } finally {
            inputStreamProvider.close();
        }
    }

    public final File d(Context context, InputStreamProvider inputStreamProvider) {
        Checker checker = Checker.SINGLE;
        File g2 = g(context, checker.extSuffix(inputStreamProvider));
        String b2 = Checker.isContent(inputStreamProvider.getPath()) ? LubanUtils.b(context, Uri.parse(inputStreamProvider.getPath())) : inputStreamProvider.getPath();
        OnRenameListener onRenameListener = this.d;
        if (onRenameListener != null) {
            g2 = h(context, onRenameListener.a(b2));
        }
        CompressionPredicate compressionPredicate = this.g;
        return compressionPredicate != null ? (!compressionPredicate.apply(b2) || !checker.needCompress(this.c, b2)) ? new File(b2) : new Engine(inputStreamProvider, g2, this.b).a() : checker.needCompress(this.c, b2) ? new Engine(inputStreamProvider, g2, this.b).a() : new File(b2);
    }

    public final File e(Context context) {
        return f(context, "luban_disk_cache");
    }

    public final File g(Context context, String str) {
        if (TextUtils.isEmpty(this.f3579a)) {
            this.f3579a = e(context).getAbsolutePath();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3579a);
        sb.append("/");
        sb.append(System.currentTimeMillis());
        sb.append((int) (Math.random() * 1000.0d));
        if (TextUtils.isEmpty(str)) {
            str = ".jpg";
        }
        sb.append(str);
        return new File(sb.toString());
    }

    public final File h(Context context, String str) {
        if (TextUtils.isEmpty(this.f3579a)) {
            this.f3579a = e(context).getAbsolutePath();
        }
        return new File(this.f3579a + "/" + str);
    }

    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            OnCompressListener onCompressListener = this.e;
            if (onCompressListener != null) {
                onCompressListener.a(message.arg1, (File) message.obj);
            }
            OnNewCompressListener onNewCompressListener = this.f;
            if (onNewCompressListener == null) {
                return false;
            }
            onNewCompressListener.a(message.getData().getString("source"), (File) message.obj);
            return false;
        } else if (i == 1) {
            OnCompressListener onCompressListener2 = this.e;
            if (onCompressListener2 != null) {
                onCompressListener2.onStart();
            }
            OnNewCompressListener onNewCompressListener2 = this.f;
            if (onNewCompressListener2 == null) {
                return false;
            }
            onNewCompressListener2.onStart();
            return false;
        } else if (i != 2) {
            return false;
        } else {
            OnCompressListener onCompressListener3 = this.e;
            if (onCompressListener3 != null) {
                onCompressListener3.b(message.arg1, (Throwable) message.obj);
            }
            OnNewCompressListener onNewCompressListener3 = this.f;
            if (onNewCompressListener3 == null) {
                return false;
            }
            onNewCompressListener3.b(message.getData().getString("source"), (Throwable) message.obj);
            return false;
        }
    }
}
