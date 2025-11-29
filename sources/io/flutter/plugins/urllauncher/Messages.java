package io.flutter.plugins.urllauncher;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.honey.account.gb.a;
import com.honey.account.gb.b;
import com.honey.account.gb.c;
import com.honey.account.gb.d;
import com.honey.account.gb.e;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Map;

public class Messages {

    public static final class BrowserOptions {
        @NonNull
        private Boolean showTitle;

        public static final class Builder {
            @Nullable
            private Boolean showTitle;

            @NonNull
            public BrowserOptions build() {
                BrowserOptions browserOptions = new BrowserOptions();
                browserOptions.setShowTitle(this.showTitle);
                return browserOptions;
            }

            @NonNull
            public Builder setShowTitle(@NonNull Boolean bool) {
                this.showTitle = bool;
                return this;
            }
        }

        @NonNull
        public static BrowserOptions fromList(@NonNull ArrayList<Object> arrayList) {
            BrowserOptions browserOptions = new BrowserOptions();
            browserOptions.setShowTitle((Boolean) arrayList.get(0));
            return browserOptions;
        }

        @NonNull
        public Boolean getShowTitle() {
            return this.showTitle;
        }

        public void setShowTitle(@NonNull Boolean bool) {
            if (bool != null) {
                this.showTitle = bool;
                return;
            }
            throw new IllegalStateException("Nonnull field \"showTitle\" is null.");
        }

        @NonNull
        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(1);
            arrayList.add(this.showTitle);
            return arrayList;
        }
    }

    public static class FlutterError extends RuntimeException {
        public final String code;
        public final Object details;

        public FlutterError(@NonNull String str, @Nullable String str2, @Nullable Object obj) {
            super(str2);
            this.code = str;
            this.details = obj;
        }
    }

    public interface UrlLauncherApi {
        @NonNull
        static MessageCodec<Object> getCodec() {
            return UrlLauncherApiCodec.INSTANCE;
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$0(UrlLauncherApi urlLauncherApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                arrayList.add(0, urlLauncherApi.canLaunchUrl((String) ((ArrayList) obj).get(0)));
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$1(UrlLauncherApi urlLauncherApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            try {
                arrayList.add(0, urlLauncherApi.launchUrl((String) arrayList2.get(0), (Map) arrayList2.get(1)));
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$2(UrlLauncherApi urlLauncherApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            try {
                arrayList.add(0, urlLauncherApi.openUrlInApp((String) arrayList2.get(0), (Boolean) arrayList2.get(1), (WebViewOptions) arrayList2.get(2), (BrowserOptions) arrayList2.get(3)));
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$3(UrlLauncherApi urlLauncherApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                arrayList.add(0, urlLauncherApi.supportsCustomTabs());
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$4(UrlLauncherApi urlLauncherApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                urlLauncherApi.closeWebView();
                arrayList.add(0, (Object) null);
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        static void setup(@NonNull BinaryMessenger binaryMessenger, @Nullable UrlLauncherApi urlLauncherApi) {
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.url_launcher_android.UrlLauncherApi.canLaunchUrl", getCodec());
            if (urlLauncherApi != null) {
                basicMessageChannel.setMessageHandler(new a(urlLauncherApi));
            } else {
                basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.url_launcher_android.UrlLauncherApi.launchUrl", getCodec());
            if (urlLauncherApi != null) {
                basicMessageChannel2.setMessageHandler(new b(urlLauncherApi));
            } else {
                basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.url_launcher_android.UrlLauncherApi.openUrlInApp", getCodec());
            if (urlLauncherApi != null) {
                basicMessageChannel3.setMessageHandler(new c(urlLauncherApi));
            } else {
                basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.url_launcher_android.UrlLauncherApi.supportsCustomTabs", getCodec());
            if (urlLauncherApi != null) {
                basicMessageChannel4.setMessageHandler(new d(urlLauncherApi));
            } else {
                basicMessageChannel4.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.url_launcher_android.UrlLauncherApi.closeWebView", getCodec());
            if (urlLauncherApi != null) {
                basicMessageChannel5.setMessageHandler(new e(urlLauncherApi));
            } else {
                basicMessageChannel5.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
        }

        @NonNull
        Boolean canLaunchUrl(@NonNull String str);

        void closeWebView();

        @NonNull
        Boolean launchUrl(@NonNull String str, @NonNull Map<String, String> map);

        @NonNull
        Boolean openUrlInApp(@NonNull String str, @NonNull Boolean bool, @NonNull WebViewOptions webViewOptions, @NonNull BrowserOptions browserOptions);

        @NonNull
        Boolean supportsCustomTabs();
    }

    public static class UrlLauncherApiCodec extends StandardMessageCodec {
        public static final UrlLauncherApiCodec INSTANCE = new UrlLauncherApiCodec();

        private UrlLauncherApiCodec() {
        }

        public Object readValueOfType(byte b, @NonNull ByteBuffer byteBuffer) {
            return b != Byte.MIN_VALUE ? b != -127 ? super.readValueOfType(b, byteBuffer) : WebViewOptions.fromList((ArrayList) readValue(byteBuffer)) : BrowserOptions.fromList((ArrayList) readValue(byteBuffer));
        }

        public void writeValue(@NonNull ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (obj instanceof BrowserOptions) {
                byteArrayOutputStream.write(128);
                writeValue(byteArrayOutputStream, ((BrowserOptions) obj).toList());
            } else if (obj instanceof WebViewOptions) {
                byteArrayOutputStream.write(129);
                writeValue(byteArrayOutputStream, ((WebViewOptions) obj).toList());
            } else {
                super.writeValue(byteArrayOutputStream, obj);
            }
        }
    }

    public static final class WebViewOptions {
        @NonNull
        private Boolean enableDomStorage;
        @NonNull
        private Boolean enableJavaScript;
        @NonNull
        private Map<String, String> headers;

        public static final class Builder {
            @Nullable
            private Boolean enableDomStorage;
            @Nullable
            private Boolean enableJavaScript;
            @Nullable
            private Map<String, String> headers;

            @NonNull
            public WebViewOptions build() {
                WebViewOptions webViewOptions = new WebViewOptions();
                webViewOptions.setEnableJavaScript(this.enableJavaScript);
                webViewOptions.setEnableDomStorage(this.enableDomStorage);
                webViewOptions.setHeaders(this.headers);
                return webViewOptions;
            }

            @NonNull
            public Builder setEnableDomStorage(@NonNull Boolean bool) {
                this.enableDomStorage = bool;
                return this;
            }

            @NonNull
            public Builder setEnableJavaScript(@NonNull Boolean bool) {
                this.enableJavaScript = bool;
                return this;
            }

            @NonNull
            public Builder setHeaders(@NonNull Map<String, String> map) {
                this.headers = map;
                return this;
            }
        }

        @NonNull
        public static WebViewOptions fromList(@NonNull ArrayList<Object> arrayList) {
            WebViewOptions webViewOptions = new WebViewOptions();
            webViewOptions.setEnableJavaScript((Boolean) arrayList.get(0));
            webViewOptions.setEnableDomStorage((Boolean) arrayList.get(1));
            webViewOptions.setHeaders((Map) arrayList.get(2));
            return webViewOptions;
        }

        @NonNull
        public Boolean getEnableDomStorage() {
            return this.enableDomStorage;
        }

        @NonNull
        public Boolean getEnableJavaScript() {
            return this.enableJavaScript;
        }

        @NonNull
        public Map<String, String> getHeaders() {
            return this.headers;
        }

        public void setEnableDomStorage(@NonNull Boolean bool) {
            if (bool != null) {
                this.enableDomStorage = bool;
                return;
            }
            throw new IllegalStateException("Nonnull field \"enableDomStorage\" is null.");
        }

        public void setEnableJavaScript(@NonNull Boolean bool) {
            if (bool != null) {
                this.enableJavaScript = bool;
                return;
            }
            throw new IllegalStateException("Nonnull field \"enableJavaScript\" is null.");
        }

        public void setHeaders(@NonNull Map<String, String> map) {
            if (map != null) {
                this.headers = map;
                return;
            }
            throw new IllegalStateException("Nonnull field \"headers\" is null.");
        }

        @NonNull
        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(3);
            arrayList.add(this.enableJavaScript);
            arrayList.add(this.enableDomStorage);
            arrayList.add(this.headers);
            return arrayList;
        }
    }

    @NonNull
    public static ArrayList<Object> wrapError(@NonNull Throwable th) {
        ArrayList<Object> arrayList = new ArrayList<>(3);
        if (th instanceof FlutterError) {
            FlutterError flutterError = (FlutterError) th;
            arrayList.add(flutterError.code);
            arrayList.add(flutterError.getMessage());
            arrayList.add(flutterError.details);
        } else {
            arrayList.add(th.toString());
            arrayList.add(th.getClass().getSimpleName());
            arrayList.add("Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th));
        }
        return arrayList;
    }
}
