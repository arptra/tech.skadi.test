package androidx.browser.browseractions;

import android.app.PendingIntent;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.browser.R;
import androidx.core.widget.TextViewCompat;
import java.util.List;

@Deprecated
class BrowserActionsFallbackMenuUi implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final Context f397a;
    public final Uri b;
    public final List c;
    public BrowserActionsFallMenuUiListener d;
    public BrowserActionsFallbackMenuDialog e;

    /* renamed from: androidx.browser.browseractions.BrowserActionsFallbackMenuUi$1  reason: invalid class name */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BrowserActionsFallbackMenuUi f398a;

        public void run() {
            ((ClipboardManager) this.f398a.f397a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("url", this.f398a.b.toString()));
            Toast.makeText(this.f398a.f397a, this.f398a.f397a.getString(R.string.copy_toast_msg), 0).show();
        }
    }

    /* renamed from: androidx.browser.browseractions.BrowserActionsFallbackMenuUi$2  reason: invalid class name */
    class AnonymousClass2 implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f399a;
        public final /* synthetic */ BrowserActionsFallbackMenuUi b;

        public void onShow(DialogInterface dialogInterface) {
            BrowserActionsFallMenuUiListener browserActionsFallMenuUiListener = this.b.d;
            if (browserActionsFallMenuUiListener == null) {
                Log.e("BrowserActionskMenuUi", "Cannot trigger menu item listener, it is null");
            } else {
                browserActionsFallMenuUiListener.a(this.f399a);
            }
        }
    }

    /* renamed from: androidx.browser.browseractions.BrowserActionsFallbackMenuUi$3  reason: invalid class name */
    class AnonymousClass3 implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TextView f400a;

        public void onClick(View view) {
            if (TextViewCompat.d(this.f400a) == Integer.MAX_VALUE) {
                this.f400a.setMaxLines(1);
                this.f400a.setEllipsize(TextUtils.TruncateAt.END);
                return;
            }
            this.f400a.setMaxLines(Integer.MAX_VALUE);
            this.f400a.setEllipsize((TextUtils.TruncateAt) null);
        }
    }

    @RestrictTo
    @VisibleForTesting
    public interface BrowserActionsFallMenuUiListener {
        void a(View view);
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        BrowserActionItem browserActionItem = (BrowserActionItem) this.c.get(i);
        if (browserActionItem.a() != null) {
            try {
                browserActionItem.a().send();
            } catch (PendingIntent.CanceledException e2) {
                Log.e("BrowserActionskMenuUi", "Failed to send custom item action", e2);
            }
        } else if (browserActionItem.d() != null) {
            browserActionItem.d().run();
        }
        BrowserActionsFallbackMenuDialog browserActionsFallbackMenuDialog = this.e;
        if (browserActionsFallbackMenuDialog == null) {
            Log.e("BrowserActionskMenuUi", "Cannot dismiss dialog, it has already been dismissed.");
        } else {
            browserActionsFallbackMenuDialog.dismiss();
        }
    }
}
