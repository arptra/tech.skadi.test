package androidx.activity.contextaware;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010#\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0003R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00118\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0012R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/activity/contextaware/ContextAwareHelper;", "", "<init>", "()V", "Landroid/content/Context;", "d", "()Landroid/content/Context;", "Landroidx/activity/contextaware/OnContextAvailableListener;", "listener", "", "a", "(Landroidx/activity/contextaware/OnContextAvailableListener;)V", "e", "context", "c", "(Landroid/content/Context;)V", "b", "", "Ljava/util/Set;", "listeners", "Landroid/content/Context;", "activity_release"}, k = 1, mv = {1, 8, 0})
public final class ContextAwareHelper {

    /* renamed from: a  reason: collision with root package name */
    public final Set f111a = new CopyOnWriteArraySet();
    public volatile Context b;

    public final void a(OnContextAvailableListener onContextAvailableListener) {
        Intrinsics.checkNotNullParameter(onContextAvailableListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Context context = this.b;
        if (context != null) {
            onContextAvailableListener.onContextAvailable(context);
        }
        this.f111a.add(onContextAvailableListener);
    }

    public final void b() {
        this.b = null;
    }

    public final void c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.b = context;
        for (OnContextAvailableListener onContextAvailable : this.f111a) {
            onContextAvailable.onContextAvailable(context);
        }
    }

    public final Context d() {
        return this.b;
    }

    public final void e(OnContextAvailableListener onContextAvailableListener) {
        Intrinsics.checkNotNullParameter(onContextAvailableListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f111a.remove(onContextAvailableListener);
    }
}
