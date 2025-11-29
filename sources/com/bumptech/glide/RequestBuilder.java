package com.bumptech.glide;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.ErrorRequestCoordinator;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.SingleRequest;
import com.bumptech.glide.request.ThumbnailRequestCoordinator;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.signature.AndroidResourceSignature;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

public class RequestBuilder<TranscodeType> extends BaseRequestOptions<RequestBuilder<TranscodeType>> implements Cloneable, ModelTypes<RequestBuilder<TranscodeType>> {
    public static final RequestOptions O = ((RequestOptions) ((RequestOptions) ((RequestOptions) new RequestOptions().h(DiskCacheStrategy.c)).W(Priority.LOW)).f0(true));
    public final Context A;
    public final RequestManager B;
    public final Class C;
    public final Glide D;
    public final GlideContext E;
    public TransitionOptions F;
    public Object G;
    public List H;
    public RequestBuilder I;
    public RequestBuilder J;
    public Float K;
    public boolean L = true;
    public boolean M;
    public boolean N;

    /* renamed from: com.bumptech.glide.RequestBuilder$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f2427a;
        public static final /* synthetic */ int[] b;

        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0083 */
        static {
            /*
                com.bumptech.glide.Priority[] r0 = com.bumptech.glide.Priority.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                b = r0
                r1 = 1
                com.bumptech.glide.Priority r2 = com.bumptech.glide.Priority.LOW     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.bumptech.glide.Priority r3 = com.bumptech.glide.Priority.NORMAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.bumptech.glide.Priority r4 = com.bumptech.glide.Priority.HIGH     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = b     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.bumptech.glide.Priority r5 = com.bumptech.glide.Priority.IMMEDIATE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                android.widget.ImageView$ScaleType[] r4 = android.widget.ImageView.ScaleType.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f2427a = r4
                android.widget.ImageView$ScaleType r5 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = f2427a     // Catch:{ NoSuchFieldError -> 0x004e }
                android.widget.ImageView$ScaleType r4 = android.widget.ImageView.ScaleType.CENTER_INSIDE     // Catch:{ NoSuchFieldError -> 0x004e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = f2427a     // Catch:{ NoSuchFieldError -> 0x0058 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = f2427a     // Catch:{ NoSuchFieldError -> 0x0062 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_START     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                int[] r0 = f2427a     // Catch:{ NoSuchFieldError -> 0x006d }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_END     // Catch:{ NoSuchFieldError -> 0x006d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                int[] r0 = f2427a     // Catch:{ NoSuchFieldError -> 0x0078 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_XY     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f2427a     // Catch:{ NoSuchFieldError -> 0x0083 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER     // Catch:{ NoSuchFieldError -> 0x0083 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0083 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0083 }
            L_0x0083:
                int[] r0 = f2427a     // Catch:{ NoSuchFieldError -> 0x008f }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.MATRIX     // Catch:{ NoSuchFieldError -> 0x008f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008f }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x008f }
            L_0x008f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.RequestBuilder.AnonymousClass1.<clinit>():void");
        }
    }

    public RequestBuilder(Glide glide, RequestManager requestManager, Class cls, Context context) {
        this.D = glide;
        this.B = requestManager;
        this.C = cls;
        this.A = context;
        this.F = requestManager.p(cls);
        this.E = glide.i();
        v0(requestManager.n());
        b(requestManager.o());
    }

    public final boolean A0(BaseRequestOptions baseRequestOptions, Request request) {
        return !baseRequestOptions.F() && request.f();
    }

    public RequestBuilder B0(Uri uri) {
        return F0(uri, E0(uri));
    }

    public RequestBuilder C0(Object obj) {
        return E0(obj);
    }

    public RequestBuilder D0(String str) {
        return E0(str);
    }

    public final RequestBuilder E0(Object obj) {
        if (D()) {
            return f().E0(obj);
        }
        this.G = obj;
        this.M = true;
        return (RequestBuilder) b0();
    }

    public final RequestBuilder F0(Uri uri, RequestBuilder requestBuilder) {
        return (uri == null || !"android.resource".equals(uri.getScheme())) ? requestBuilder : p0(requestBuilder);
    }

    public final Request G0(Object obj, Target target, RequestListener requestListener, BaseRequestOptions baseRequestOptions, RequestCoordinator requestCoordinator, TransitionOptions transitionOptions, Priority priority, int i, int i2, Executor executor) {
        Context context = this.A;
        GlideContext glideContext = this.E;
        return SingleRequest.y(context, glideContext, obj, this.G, this.C, baseRequestOptions, i, i2, priority, target, requestListener, this.H, requestCoordinator, glideContext.f(), transitionOptions.c(), executor);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof RequestBuilder)) {
            return false;
        }
        RequestBuilder requestBuilder = (RequestBuilder) obj;
        return super.equals(requestBuilder) && Objects.equals(this.C, requestBuilder.C) && this.F.equals(requestBuilder.F) && Objects.equals(this.G, requestBuilder.G) && Objects.equals(this.H, requestBuilder.H) && Objects.equals(this.I, requestBuilder.I) && Objects.equals(this.J, requestBuilder.J) && Objects.equals(this.K, requestBuilder.K) && this.L == requestBuilder.L && this.M == requestBuilder.M;
    }

    public int hashCode() {
        return Util.r(this.M, Util.r(this.L, Util.q(this.K, Util.q(this.J, Util.q(this.I, Util.q(this.H, Util.q(this.G, Util.q(this.F, Util.q(this.C, super.hashCode())))))))));
    }

    public RequestBuilder n0(RequestListener requestListener) {
        if (D()) {
            return f().n0(requestListener);
        }
        if (requestListener != null) {
            if (this.H == null) {
                this.H = new ArrayList();
            }
            this.H.add(requestListener);
        }
        return (RequestBuilder) b0();
    }

    /* renamed from: o0 */
    public RequestBuilder b(BaseRequestOptions baseRequestOptions) {
        Preconditions.d(baseRequestOptions);
        return (RequestBuilder) super.b(baseRequestOptions);
    }

    public final RequestBuilder p0(RequestBuilder requestBuilder) {
        return (RequestBuilder) ((RequestBuilder) requestBuilder.g0(this.A.getTheme())).d0(AndroidResourceSignature.c(this.A));
    }

    public final Request q0(Target target, RequestListener requestListener, BaseRequestOptions baseRequestOptions, Executor executor) {
        return r0(new Object(), target, requestListener, (RequestCoordinator) null, this.F, baseRequestOptions.v(), baseRequestOptions.s(), baseRequestOptions.r(), baseRequestOptions, executor);
    }

    public final Request r0(Object obj, Target target, RequestListener requestListener, RequestCoordinator requestCoordinator, TransitionOptions transitionOptions, Priority priority, int i, int i2, BaseRequestOptions baseRequestOptions, Executor executor) {
        ErrorRequestCoordinator errorRequestCoordinator;
        ErrorRequestCoordinator errorRequestCoordinator2;
        if (this.J != null) {
            Object obj2 = obj;
            errorRequestCoordinator2 = new ErrorRequestCoordinator(obj, requestCoordinator);
            errorRequestCoordinator = errorRequestCoordinator2;
        } else {
            Object obj3 = obj;
            errorRequestCoordinator = null;
            errorRequestCoordinator2 = requestCoordinator;
        }
        Request s0 = s0(obj, target, requestListener, errorRequestCoordinator2, transitionOptions, priority, i, i2, baseRequestOptions, executor);
        if (errorRequestCoordinator == null) {
            return s0;
        }
        int s = this.J.s();
        int r = this.J.r();
        if (Util.v(i, i2) && !this.J.N()) {
            s = baseRequestOptions.s();
            r = baseRequestOptions.r();
        }
        RequestBuilder requestBuilder = this.J;
        errorRequestCoordinator.o(s0, requestBuilder.r0(obj, target, requestListener, errorRequestCoordinator, requestBuilder.F, requestBuilder.v(), s, r, this.J, executor));
        return errorRequestCoordinator;
    }

    public final Request s0(Object obj, Target target, RequestListener requestListener, RequestCoordinator requestCoordinator, TransitionOptions transitionOptions, Priority priority, int i, int i2, BaseRequestOptions baseRequestOptions, Executor executor) {
        Object obj2 = obj;
        RequestCoordinator requestCoordinator2 = requestCoordinator;
        Priority priority2 = priority;
        RequestBuilder requestBuilder = this.I;
        if (requestBuilder != null) {
            if (!this.N) {
                TransitionOptions transitionOptions2 = requestBuilder.L ? transitionOptions : requestBuilder.F;
                Priority v = requestBuilder.G() ? this.I.v() : u0(priority2);
                int s = this.I.s();
                int r = this.I.r();
                if (Util.v(i, i2) && !this.I.N()) {
                    s = baseRequestOptions.s();
                    r = baseRequestOptions.r();
                }
                int i3 = r;
                ThumbnailRequestCoordinator thumbnailRequestCoordinator = new ThumbnailRequestCoordinator(obj2, requestCoordinator2);
                Object obj3 = obj;
                Target target2 = target;
                RequestListener requestListener2 = requestListener;
                ThumbnailRequestCoordinator thumbnailRequestCoordinator2 = thumbnailRequestCoordinator;
                Request G0 = G0(obj3, target2, requestListener2, baseRequestOptions, thumbnailRequestCoordinator, transitionOptions, priority, i, i2, executor);
                this.N = true;
                RequestBuilder requestBuilder2 = this.I;
                Request r0 = requestBuilder2.r0(obj3, target2, requestListener2, thumbnailRequestCoordinator2, transitionOptions2, v, s, i3, requestBuilder2, executor);
                this.N = false;
                thumbnailRequestCoordinator2.n(G0, r0);
                return thumbnailRequestCoordinator2;
            }
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        } else if (this.K == null) {
            return G0(obj, target, requestListener, baseRequestOptions, requestCoordinator, transitionOptions, priority, i, i2, executor);
        } else {
            ThumbnailRequestCoordinator thumbnailRequestCoordinator3 = new ThumbnailRequestCoordinator(obj2, requestCoordinator2);
            Target target3 = target;
            RequestListener requestListener3 = requestListener;
            ThumbnailRequestCoordinator thumbnailRequestCoordinator4 = thumbnailRequestCoordinator3;
            TransitionOptions transitionOptions3 = transitionOptions;
            int i4 = i;
            int i5 = i2;
            Executor executor2 = executor;
            thumbnailRequestCoordinator3.n(G0(obj, target3, requestListener3, baseRequestOptions, thumbnailRequestCoordinator4, transitionOptions3, priority, i4, i5, executor2), G0(obj, target3, requestListener3, baseRequestOptions.clone().e0(this.K.floatValue()), thumbnailRequestCoordinator4, transitionOptions3, u0(priority2), i4, i5, executor2));
            return thumbnailRequestCoordinator3;
        }
    }

    /* renamed from: t0 */
    public RequestBuilder f() {
        RequestBuilder requestBuilder = (RequestBuilder) super.clone();
        requestBuilder.F = requestBuilder.F.clone();
        if (requestBuilder.H != null) {
            requestBuilder.H = new ArrayList(requestBuilder.H);
        }
        RequestBuilder requestBuilder2 = requestBuilder.I;
        if (requestBuilder2 != null) {
            requestBuilder.I = requestBuilder2.f();
        }
        RequestBuilder requestBuilder3 = requestBuilder.J;
        if (requestBuilder3 != null) {
            requestBuilder.J = requestBuilder3.f();
        }
        return requestBuilder;
    }

    public final Priority u0(Priority priority) {
        int i = AnonymousClass1.b[priority.ordinal()];
        if (i == 1) {
            return Priority.NORMAL;
        }
        if (i == 2) {
            return Priority.HIGH;
        }
        if (i == 3 || i == 4) {
            return Priority.IMMEDIATE;
        }
        throw new IllegalArgumentException("unknown priority: " + v());
    }

    public final void v0(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            n0((RequestListener) it.next());
        }
    }

    public Target w0(Target target) {
        return y0(target, (RequestListener) null, Executors.b());
    }

    public final Target x0(Target target, RequestListener requestListener, BaseRequestOptions baseRequestOptions, Executor executor) {
        Preconditions.d(target);
        if (this.M) {
            Request q0 = q0(target, requestListener, baseRequestOptions, executor);
            Request c = target.c();
            if (!q0.g(c) || A0(baseRequestOptions, c)) {
                this.B.l(target);
                target.h(q0);
                this.B.y(target, q0);
                return target;
            }
            if (!((Request) Preconditions.d(c)).isRunning()) {
                c.i();
            }
            return target;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    public Target y0(Target target, RequestListener requestListener, Executor executor) {
        return x0(target, requestListener, this, executor);
    }

    public ViewTarget z0(ImageView imageView) {
        BaseRequestOptions baseRequestOptions;
        Util.b();
        Preconditions.d(imageView);
        if (!M() && K() && imageView.getScaleType() != null) {
            switch (AnonymousClass1.f2427a[imageView.getScaleType().ordinal()]) {
                case 1:
                    baseRequestOptions = clone().P();
                    break;
                case 2:
                    baseRequestOptions = clone().Q();
                    break;
                case 3:
                case 4:
                case 5:
                    baseRequestOptions = clone().R();
                    break;
                case 6:
                    baseRequestOptions = clone().Q();
                    break;
            }
        }
        baseRequestOptions = this;
        return (ViewTarget) x0(this.E.a(imageView, this.C), (RequestListener) null, baseRequestOptions, Executors.b());
    }
}
