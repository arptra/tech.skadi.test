package androidx.core.view.inputmethod;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.ViewCompat;
import com.honey.account.s.a;

@SuppressLint({"PrivateConstructorForUtilityClass"})
public final class InputConnectionCompat {

    /* renamed from: androidx.core.view.inputmethod.InputConnectionCompat$2  reason: invalid class name */
    public class AnonymousClass2 extends InputConnectionWrapper {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OnCommitContentListener f942a;

        public boolean performPrivateCommand(String str, Bundle bundle) {
            if (InputConnectionCompat.e(str, bundle, this.f942a)) {
                return true;
            }
            return super.performPrivateCommand(str, bundle);
        }
    }

    @RequiresApi
    public static class Api25Impl {
        @DoNotInline
        public static boolean a(InputConnection inputConnection, InputContentInfo inputContentInfo, int i, Bundle bundle) {
            return inputConnection.commitContent(inputContentInfo, i, bundle);
        }
    }

    public interface OnCommitContentListener {
        boolean a(InputContentInfoCompat inputContentInfoCompat, int i, Bundle bundle);
    }

    public static OnCommitContentListener b(View view) {
        Preconditions.h(view);
        return new a(view);
    }

    public static InputConnection c(View view, InputConnection inputConnection, EditorInfo editorInfo) {
        return d(inputConnection, editorInfo, b(view));
    }

    public static InputConnection d(InputConnection inputConnection, EditorInfo editorInfo, final OnCommitContentListener onCommitContentListener) {
        ObjectsCompat.d(inputConnection, "inputConnection must be non-null");
        ObjectsCompat.d(editorInfo, "editorInfo must be non-null");
        ObjectsCompat.d(onCommitContentListener, "onCommitContentListener must be non-null");
        return new InputConnectionWrapper(inputConnection, false) {
            public boolean commitContent(InputContentInfo inputContentInfo, int i, Bundle bundle) {
                if (onCommitContentListener.a(InputContentInfoCompat.f(inputContentInfo), i, bundle)) {
                    return true;
                }
                return super.commitContent(inputContentInfo, i, bundle);
            }
        };
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x007e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean e(java.lang.String r7, android.os.Bundle r8, androidx.core.view.inputmethod.InputConnectionCompat.OnCommitContentListener r9) {
        /*
            r0 = 0
            if (r8 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = "androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT"
            boolean r1 = android.text.TextUtils.equals(r1, r7)
            if (r1 == 0) goto L_0x000e
            r7 = r0
            goto L_0x0017
        L_0x000e:
            java.lang.String r1 = "android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT"
            boolean r7 = android.text.TextUtils.equals(r1, r7)
            if (r7 == 0) goto L_0x0082
            r7 = 1
        L_0x0017:
            r1 = 0
            if (r7 == 0) goto L_0x0020
            java.lang.String r2 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER"
            goto L_0x0022
        L_0x001d:
            r7 = move-exception
            r2 = r1
            goto L_0x007c
        L_0x0020:
            java.lang.String r2 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER"
        L_0x0022:
            android.os.Parcelable r2 = r8.getParcelable(r2)     // Catch:{ all -> 0x001d }
            android.os.ResultReceiver r2 = (android.os.ResultReceiver) r2     // Catch:{ all -> 0x001d }
            if (r7 == 0) goto L_0x002f
            java.lang.String r3 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI"
            goto L_0x0031
        L_0x002d:
            r7 = move-exception
            goto L_0x007c
        L_0x002f:
            java.lang.String r3 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI"
        L_0x0031:
            android.os.Parcelable r3 = r8.getParcelable(r3)     // Catch:{ all -> 0x002d }
            android.net.Uri r3 = (android.net.Uri) r3     // Catch:{ all -> 0x002d }
            if (r7 == 0) goto L_0x003c
            java.lang.String r4 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION"
            goto L_0x003e
        L_0x003c:
            java.lang.String r4 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION"
        L_0x003e:
            android.os.Parcelable r4 = r8.getParcelable(r4)     // Catch:{ all -> 0x002d }
            android.content.ClipDescription r4 = (android.content.ClipDescription) r4     // Catch:{ all -> 0x002d }
            if (r7 == 0) goto L_0x0049
            java.lang.String r5 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI"
            goto L_0x004b
        L_0x0049:
            java.lang.String r5 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI"
        L_0x004b:
            android.os.Parcelable r5 = r8.getParcelable(r5)     // Catch:{ all -> 0x002d }
            android.net.Uri r5 = (android.net.Uri) r5     // Catch:{ all -> 0x002d }
            if (r7 == 0) goto L_0x0056
            java.lang.String r6 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS"
            goto L_0x0058
        L_0x0056:
            java.lang.String r6 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS"
        L_0x0058:
            int r6 = r8.getInt(r6)     // Catch:{ all -> 0x002d }
            if (r7 == 0) goto L_0x0061
            java.lang.String r7 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS"
            goto L_0x0063
        L_0x0061:
            java.lang.String r7 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS"
        L_0x0063:
            android.os.Parcelable r7 = r8.getParcelable(r7)     // Catch:{ all -> 0x002d }
            android.os.Bundle r7 = (android.os.Bundle) r7     // Catch:{ all -> 0x002d }
            if (r3 == 0) goto L_0x0076
            if (r4 == 0) goto L_0x0076
            androidx.core.view.inputmethod.InputContentInfoCompat r8 = new androidx.core.view.inputmethod.InputContentInfoCompat     // Catch:{ all -> 0x002d }
            r8.<init>(r3, r4, r5)     // Catch:{ all -> 0x002d }
            boolean r0 = r9.a(r8, r6, r7)     // Catch:{ all -> 0x002d }
        L_0x0076:
            if (r2 == 0) goto L_0x007b
            r2.send(r0, r1)
        L_0x007b:
            return r0
        L_0x007c:
            if (r2 == 0) goto L_0x0081
            r2.send(r0, r1)
        L_0x0081:
            throw r7
        L_0x0082:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.inputmethod.InputConnectionCompat.e(java.lang.String, android.os.Bundle, androidx.core.view.inputmethod.InputConnectionCompat$OnCommitContentListener):boolean");
    }

    public static /* synthetic */ boolean f(View view, InputContentInfoCompat inputContentInfoCompat, int i, Bundle bundle) {
        if ((i & 1) != 0) {
            try {
                inputContentInfoCompat.d();
                Parcelable parcelable = (Parcelable) inputContentInfoCompat.e();
                bundle = bundle == null ? new Bundle() : new Bundle(bundle);
                bundle.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", parcelable);
            } catch (Exception e) {
                Log.w("InputConnectionCompat", "Can't insert content from IME; requestPermission() failed", e);
                return false;
            }
        }
        return ViewCompat.j0(view, new ContentInfoCompat.Builder(new ClipData(inputContentInfoCompat.b(), new ClipData.Item(inputContentInfoCompat.a())), 2).d(inputContentInfoCompat.c()).b(bundle).a()) == null;
    }
}
