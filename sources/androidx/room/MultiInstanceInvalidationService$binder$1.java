package androidx.room;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.IMultiInstanceInvalidationService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007H\u0016¢\u0006\u0002\u0010\tJ\u001a\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u000f"}, d2 = {"androidx/room/MultiInstanceInvalidationService$binder$1", "Landroidx/room/IMultiInstanceInvalidationService$Stub;", "broadcastInvalidation", "", "clientId", "", "tables", "", "", "(I[Ljava/lang/String;)V", "registerCallback", "callback", "Landroidx/room/IMultiInstanceInvalidationCallback;", "name", "unregisterCallback", "room-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MultiInstanceInvalidationService$binder$1 extends IMultiInstanceInvalidationService.Stub {
    final /* synthetic */ MultiInstanceInvalidationService this$0;

    public MultiInstanceInvalidationService$binder$1(MultiInstanceInvalidationService multiInstanceInvalidationService) {
        this.this$0 = multiInstanceInvalidationService;
    }

    public void broadcastInvalidation(int i, @NotNull String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "tables");
        RemoteCallbackList a2 = this.this$0.a();
        MultiInstanceInvalidationService multiInstanceInvalidationService = this.this$0;
        synchronized (a2) {
            String str = (String) multiInstanceInvalidationService.b().get(Integer.valueOf(i));
            if (str == null) {
                Log.w("ROOM", "Remote invalidation client ID not registered");
                return;
            }
            int beginBroadcast = multiInstanceInvalidationService.a().beginBroadcast();
            int i2 = 0;
            while (i2 < beginBroadcast) {
                try {
                    Object broadcastCookie = multiInstanceInvalidationService.a().getBroadcastCookie(i2);
                    Intrinsics.checkNotNull(broadcastCookie, "null cannot be cast to non-null type kotlin.Int");
                    Integer num = (Integer) broadcastCookie;
                    int intValue = num.intValue();
                    String str2 = (String) multiInstanceInvalidationService.b().get(num);
                    if (i != intValue && Intrinsics.areEqual((Object) str, (Object) str2)) {
                        try {
                            ((IMultiInstanceInvalidationCallback) multiInstanceInvalidationService.a().getBroadcastItem(i2)).onInvalidation(strArr);
                        } catch (RemoteException e) {
                            Log.w("ROOM", "Error invoking a remote callback", e);
                        }
                    }
                    i2++;
                } catch (Throwable th) {
                    multiInstanceInvalidationService.a().finishBroadcast();
                    throw th;
                }
            }
            multiInstanceInvalidationService.a().finishBroadcast();
            Unit unit = Unit.INSTANCE;
        }
    }

    public int registerCallback(@NotNull IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, @Nullable String str) {
        Intrinsics.checkNotNullParameter(iMultiInstanceInvalidationCallback, "callback");
        int i = 0;
        if (str == null) {
            return 0;
        }
        RemoteCallbackList a2 = this.this$0.a();
        MultiInstanceInvalidationService multiInstanceInvalidationService = this.this$0;
        synchronized (a2) {
            try {
                multiInstanceInvalidationService.d(multiInstanceInvalidationService.c() + 1);
                int c = multiInstanceInvalidationService.c();
                if (multiInstanceInvalidationService.a().register(iMultiInstanceInvalidationCallback, Integer.valueOf(c))) {
                    multiInstanceInvalidationService.b().put(Integer.valueOf(c), str);
                    i = c;
                } else {
                    multiInstanceInvalidationService.d(multiInstanceInvalidationService.c() - 1);
                    multiInstanceInvalidationService.c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return i;
    }

    public void unregisterCallback(@NotNull IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, int i) {
        Intrinsics.checkNotNullParameter(iMultiInstanceInvalidationCallback, "callback");
        RemoteCallbackList a2 = this.this$0.a();
        MultiInstanceInvalidationService multiInstanceInvalidationService = this.this$0;
        synchronized (a2) {
            multiInstanceInvalidationService.a().unregister(iMultiInstanceInvalidationCallback);
            String str = (String) multiInstanceInvalidationService.b().remove(Integer.valueOf(i));
        }
    }
}
