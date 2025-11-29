package io.flutter.plugins.webviewflutter;

import android.webkit.DownloadListener;
import androidx.annotation.NonNull;
import com.honey.account.hb.b;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public class DownloadListenerHostApiImpl implements GeneratedAndroidWebView.DownloadListenerHostApi {
    private final DownloadListenerCreator downloadListenerCreator;
    private final DownloadListenerFlutterApiImpl flutterApi;
    private final InstanceManager instanceManager;

    public static class DownloadListenerCreator {
        @NonNull
        public DownloadListenerImpl createDownloadListener(@NonNull DownloadListenerFlutterApiImpl downloadListenerFlutterApiImpl) {
            return new DownloadListenerImpl(downloadListenerFlutterApiImpl);
        }
    }

    public static class DownloadListenerImpl implements DownloadListener {
        private final DownloadListenerFlutterApiImpl flutterApi;

        public DownloadListenerImpl(@NonNull DownloadListenerFlutterApiImpl downloadListenerFlutterApiImpl) {
            this.flutterApi = downloadListenerFlutterApiImpl;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$onDownloadStart$0(Void voidR) {
        }

        public void onDownloadStart(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, long j) {
            this.flutterApi.onDownloadStart(this, str, str2, str3, str4, j, new b());
        }
    }

    public DownloadListenerHostApiImpl(@NonNull InstanceManager instanceManager2, @NonNull DownloadListenerCreator downloadListenerCreator2, @NonNull DownloadListenerFlutterApiImpl downloadListenerFlutterApiImpl) {
        this.instanceManager = instanceManager2;
        this.downloadListenerCreator = downloadListenerCreator2;
        this.flutterApi = downloadListenerFlutterApiImpl;
    }

    public void create(@NonNull Long l) {
        this.instanceManager.addDartCreatedInstance(this.downloadListenerCreator.createDownloadListener(this.flutterApi), l.longValue());
    }
}
