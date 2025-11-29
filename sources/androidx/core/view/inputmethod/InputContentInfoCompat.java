package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.net.Uri;
import android.view.inputmethod.InputContentInfo;
import androidx.annotation.RequiresApi;

public final class InputContentInfoCompat {

    /* renamed from: a  reason: collision with root package name */
    public final InputContentInfoCompatImpl f943a;

    public static final class InputContentInfoCompatBaseImpl implements InputContentInfoCompatImpl {

        /* renamed from: a  reason: collision with root package name */
        public final Uri f945a;
        public final ClipDescription b;
        public final Uri c;

        public Object a() {
            return null;
        }

        public Uri b() {
            return this.f945a;
        }

        public void c() {
        }

        public Uri d() {
            return this.c;
        }

        public ClipDescription getDescription() {
            return this.b;
        }
    }

    public interface InputContentInfoCompatImpl {
        Object a();

        Uri b();

        void c();

        Uri d();

        ClipDescription getDescription();
    }

    public InputContentInfoCompat(Uri uri, ClipDescription clipDescription, Uri uri2) {
        this.f943a = new InputContentInfoCompatApi25Impl(uri, clipDescription, uri2);
    }

    public static InputContentInfoCompat f(Object obj) {
        if (obj == null) {
            return null;
        }
        return new InputContentInfoCompat(new InputContentInfoCompatApi25Impl(obj));
    }

    public Uri a() {
        return this.f943a.b();
    }

    public ClipDescription b() {
        return this.f943a.getDescription();
    }

    public Uri c() {
        return this.f943a.d();
    }

    public void d() {
        this.f943a.c();
    }

    public Object e() {
        return this.f943a.a();
    }

    @RequiresApi
    public static final class InputContentInfoCompatApi25Impl implements InputContentInfoCompatImpl {

        /* renamed from: a  reason: collision with root package name */
        public final InputContentInfo f944a;

        public InputContentInfoCompatApi25Impl(Object obj) {
            this.f944a = (InputContentInfo) obj;
        }

        public Object a() {
            return this.f944a;
        }

        public Uri b() {
            return this.f944a.getContentUri();
        }

        public void c() {
            this.f944a.requestPermission();
        }

        public Uri d() {
            return this.f944a.getLinkUri();
        }

        public ClipDescription getDescription() {
            return this.f944a.getDescription();
        }

        public InputContentInfoCompatApi25Impl(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.f944a = new InputContentInfo(uri, clipDescription, uri2);
        }
    }

    public InputContentInfoCompat(InputContentInfoCompatImpl inputContentInfoCompatImpl) {
        this.f943a = inputContentInfoCompatImpl;
    }
}
