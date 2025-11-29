package androidx.webkit;

import android.webkit.WebMessagePort;
import java.lang.reflect.InvocationHandler;

public abstract class WebMessagePortCompat {

    public static abstract class WebMessageCallbackCompat {
        public void a(WebMessagePortCompat webMessagePortCompat, WebMessageCompat webMessageCompat) {
        }
    }

    public abstract WebMessagePort a();

    public abstract InvocationHandler b();
}
