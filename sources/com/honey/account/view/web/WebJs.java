package com.honey.account.view.web;

import android.content.Intent;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.honey.account.view.web.data.WebPayload;
import com.honey.account.view.web.data.WebResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J&\u0010\u0007\u001a\u00020\b\"\u0004\b\u0000\u0010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\t0\rH\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0015\u001a\u00020\u000bH\u0007J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/honey/account/view/web/WebJs;", "", "webView", "Landroid/webkit/WebView;", "webActivity", "Lcom/honey/account/view/web/WebActivity;", "(Landroid/webkit/WebView;Lcom/honey/account/view/web/WebActivity;)V", "callJs", "", "T", "cbName", "", "result", "Lcom/honey/account/view/web/data/WebResult;", "handleClosePage", "handleCompleteProcess", "payload", "Lcom/honey/account/view/web/data/WebPayload;", "handleIsEventExist", "handleOpenBrowser", "postMessage", "message", "undefined", "Companion", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class WebJs {
    @NotNull
    public static final String ACTION = "action";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String EVENT_NAME = "eventName";
    @NotNull
    private static final String TAG = "WebJs";
    @NotNull
    private final WebActivity webActivity;
    /* access modifiers changed from: private */
    @NotNull
    public final WebView webView;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/honey/account/view/web/WebJs$Companion;", "", "()V", "ACTION", "", "EVENT_NAME", "TAG", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                com.honey.account.view.web.WebEvent[] r0 = com.honey.account.view.web.WebEvent.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.honey.account.view.web.WebEvent r1 = com.honey.account.view.web.WebEvent.IS_EVENT_EXIST     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.honey.account.view.web.WebEvent r1 = com.honey.account.view.web.WebEvent.COMPLETE_PROCESS     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.honey.account.view.web.WebEvent r1 = com.honey.account.view.web.WebEvent.CLOSE_PAGE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.honey.account.view.web.WebEvent r1 = com.honey.account.view.web.WebEvent.OPEN_LINK_IN_BROWSER     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.honey.account.view.web.WebJs.WhenMappings.<clinit>():void");
        }
    }

    public WebJs(@NotNull WebView webView2, @NotNull WebActivity webActivity2) {
        Intrinsics.checkNotNullParameter(webView2, "webView");
        Intrinsics.checkNotNullParameter(webActivity2, "webActivity");
        this.webView = webView2;
        this.webActivity = webActivity2;
    }

    private final <T> void callJs(String str, WebResult<T> webResult) {
        if (str != null && str.length() != 0) {
            Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.c()), (CoroutineContext) null, (CoroutineStart) null, new WebJs$callJs$1(this, str, webResult, (Continuation<? super WebJs$callJs$1>) null), 3, (Object) null);
        }
    }

    private final void handleClosePage() {
        WebActivity webActivity2 = this.webActivity;
        webActivity2.setResult(0);
        webActivity2.finish();
    }

    private final void handleCompleteProcess(WebPayload webPayload) {
        JsonElement data;
        JsonObject asJsonObject;
        try {
            JsonElement data2 = webPayload.getData();
            if ((data2 == null || !data2.isJsonNull()) && (data = webPayload.getData()) != null && (asJsonObject = data.getAsJsonObject()) != null) {
                JsonElement jsonElement = asJsonObject.get(ACTION);
                String asString = jsonElement != null ? jsonElement.getAsString() : null;
                Log.i(TAG, "handleCompleteProcess, action: " + asString);
                JsonElement jsonElement2 = asJsonObject.get("cbName");
                callJs(jsonElement2 != null ? jsonElement2.getAsString() : null, new WebResult(true, (Object) null, (String) null, 6, (DefaultConstructorMarker) null));
                WebActivity webActivity2 = this.webActivity;
                Intent intent = new Intent();
                intent.putExtra(ACTION, asString);
                Unit unit = Unit.INSTANCE;
                webActivity2.setResult(-1, intent);
                webActivity2.finish();
            }
        } catch (Throwable th) {
            callJs(webPayload.getCbName(), new WebResult(false, null, th.getMessage()));
            Log.e(TAG, "handleCompleteProcess. ", th);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0026, code lost:
        r3 = (r3 = r3.getAsJsonObject()).get(EVENT_NAME);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object handleIsEventExist(com.honey.account.view.web.data.WebPayload r13) {
        /*
            r12 = this;
            r0 = 0
            r1 = 0
            java.lang.String r2 = r13.getCbName()     // Catch:{ all -> 0x0018 }
            if (r2 == 0) goto L_0x006b
            com.google.gson.JsonElement r3 = r13.getData()     // Catch:{ all -> 0x0018 }
            r4 = 1
            if (r3 == 0) goto L_0x001a
            boolean r3 = r3.isJsonNull()     // Catch:{ all -> 0x0018 }
            if (r3 != r4) goto L_0x001a
            java.lang.String r3 = ""
            goto L_0x0034
        L_0x0018:
            r2 = move-exception
            goto L_0x004f
        L_0x001a:
            com.google.gson.JsonElement r3 = r13.getData()     // Catch:{ all -> 0x0018 }
            if (r3 == 0) goto L_0x0033
            com.google.gson.JsonObject r3 = r3.getAsJsonObject()     // Catch:{ all -> 0x0018 }
            if (r3 == 0) goto L_0x0033
            java.lang.String r5 = "eventName"
            com.google.gson.JsonElement r3 = r3.get(r5)     // Catch:{ all -> 0x0018 }
            if (r3 == 0) goto L_0x0033
            java.lang.String r3 = r3.getAsString()     // Catch:{ all -> 0x0018 }
            goto L_0x0034
        L_0x0033:
            r3 = r1
        L_0x0034:
            com.honey.account.view.web.data.WebResult r11 = new com.honey.account.view.web.data.WebResult     // Catch:{ all -> 0x0018 }
            com.honey.account.view.web.WebEvent$Companion r5 = com.honey.account.view.web.WebEvent.Companion     // Catch:{ all -> 0x0018 }
            com.honey.account.view.web.WebEvent r3 = r5.parse(r3)     // Catch:{ all -> 0x0018 }
            if (r3 == 0) goto L_0x0040
            r6 = r4
            goto L_0x0041
        L_0x0040:
            r6 = r0
        L_0x0041:
            r9 = 6
            r10 = 0
            r7 = 0
            r8 = 0
            r5 = r11
            r5.<init>(r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0018 }
            r12.callJs(r2, r11)     // Catch:{ all -> 0x0018 }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0018 }
            goto L_0x006b
        L_0x004f:
            java.lang.String r13 = r13.getCbName()
            com.honey.account.view.web.data.WebResult r3 = new com.honey.account.view.web.data.WebResult
            java.lang.String r4 = r2.getMessage()
            r3.<init>(r0, r1, r4)
            r12.callJs(r13, r3)
            java.lang.String r12 = "WebJs"
            java.lang.String r13 = "handleIsEventExist. "
            int r12 = android.util.Log.e(r12, r13, r2)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r12)
        L_0x006b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.honey.account.view.web.WebJs.handleIsEventExist(com.honey.account.view.web.data.WebPayload):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
        r3 = (r3 = r3.getAsJsonObject()).get("url");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void handleOpenBrowser(com.honey.account.view.web.data.WebPayload r3) {
        /*
            r2 = this;
            com.google.gson.JsonElement r0 = r3.getData()
            if (r0 == 0) goto L_0x000e
            boolean r0 = r0.isJsonNull()
            r1 = 1
            if (r0 != r1) goto L_0x000e
            return
        L_0x000e:
            com.honey.account.view.web.WebActivity r2 = r2.webActivity
            com.google.gson.JsonElement r3 = r3.getData()
            if (r3 == 0) goto L_0x0029
            com.google.gson.JsonObject r3 = r3.getAsJsonObject()
            if (r3 == 0) goto L_0x0029
            java.lang.String r0 = "url"
            com.google.gson.JsonElement r3 = r3.get(r0)
            if (r3 == 0) goto L_0x0029
            java.lang.String r3 = r3.getAsString()
            goto L_0x002a
        L_0x0029:
            r3 = 0
        L_0x002a:
            java.lang.String r0 = ""
            com.honey.account.view.helper.ActivityGotoHelperKt.startAppByScheme(r2, r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.honey.account.view.web.WebJs.handleOpenBrowser(com.honey.account.view.web.data.WebPayload):void");
    }

    private final void undefined(WebPayload webPayload) {
        String cbName = webPayload.getCbName();
        if (cbName != null) {
            callJs(cbName, new WebResult(false, null, "can't support."));
        }
    }

    @JavascriptInterface
    @Nullable
    public final Object postMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        try {
            Log.i(TAG, "postMessage. " + str);
            WebPayload webPayload = (WebPayload) new Gson().fromJson(str, WebPayload.class);
            WebEvent parse = WebEvent.Companion.parse(webPayload.getEventName());
            int i = parse == null ? -1 : WhenMappings.$EnumSwitchMapping$0[parse.ordinal()];
            if (i == 1) {
                Intrinsics.checkNotNull(webPayload);
                return handleIsEventExist(webPayload);
            } else if (i == 2) {
                Intrinsics.checkNotNull(webPayload);
                handleCompleteProcess(webPayload);
                return Unit.INSTANCE;
            } else if (i == 3) {
                handleClosePage();
                return Unit.INSTANCE;
            } else if (i != 4) {
                Intrinsics.checkNotNull(webPayload);
                undefined(webPayload);
                return Unit.INSTANCE;
            } else {
                Intrinsics.checkNotNull(webPayload);
                handleOpenBrowser(webPayload);
                return Unit.INSTANCE;
            }
        } catch (Throwable th) {
            return Integer.valueOf(Log.e(TAG, "postMessage fail.", th));
        }
    }
}
