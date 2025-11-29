package androidx.webkit;

import androidx.annotation.VisibleForTesting;

public final class WebViewAssetLoader {

    public static final class AssetsPathHandler implements PathHandler {
    }

    public static final class Builder {
    }

    public static final class InternalStoragePathHandler implements PathHandler {

        /* renamed from: a  reason: collision with root package name */
        public static final String[] f1960a = {"app_webview/", "databases/", "lib/", "shared_prefs/", "code_cache/"};
    }

    public interface PathHandler {
    }

    @VisibleForTesting
    public static class PathMatcher {
    }

    public static final class ResourcesPathHandler implements PathHandler {
    }
}
