package androidx.room;

import android.os.RemoteCallbackList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"androidx/room/MultiInstanceInvalidationService$callbackList$1", "Landroid/os/RemoteCallbackList;", "Landroidx/room/IMultiInstanceInvalidationCallback;", "callback", "", "cookie", "", "a", "(Landroidx/room/IMultiInstanceInvalidationCallback;Ljava/lang/Object;)V", "room-runtime_release"}, k = 1, mv = {1, 8, 0})
public final class MultiInstanceInvalidationService$callbackList$1 extends RemoteCallbackList<IMultiInstanceInvalidationCallback> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MultiInstanceInvalidationService f1743a;

    public MultiInstanceInvalidationService$callbackList$1(MultiInstanceInvalidationService multiInstanceInvalidationService) {
        this.f1743a = multiInstanceInvalidationService;
    }

    /* renamed from: a */
    public void onCallbackDied(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, Object obj) {
        Intrinsics.checkNotNullParameter(iMultiInstanceInvalidationCallback, "callback");
        Intrinsics.checkNotNullParameter(obj, "cookie");
        this.f1743a.b().remove((Integer) obj);
    }
}
