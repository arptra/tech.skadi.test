package androidx.core.app;

import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Set;

class NotificationCompatJellybean {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f668a = new Object();
    public static final Object b = new Object();

    public static Bundle a(NotificationCompat.Action action) {
        Bundle bundle = new Bundle();
        IconCompat d = action.d();
        bundle.putInt("icon", d != null ? d.o() : 0);
        bundle.putCharSequence("title", action.h());
        bundle.putParcelable("actionIntent", action.a());
        Bundle bundle2 = action.c() != null ? new Bundle(action.c()) : new Bundle();
        bundle2.putBoolean("android.support.allowGeneratedReplies", action.b());
        bundle.putBundle("extras", bundle2);
        bundle.putParcelableArray("remoteInputs", c(action.e()));
        bundle.putBoolean("showsUserInterface", action.g());
        bundle.putInt("semanticAction", action.f());
        return bundle;
    }

    public static Bundle b(RemoteInput remoteInput) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", remoteInput.i());
        bundle.putCharSequence("label", remoteInput.h());
        bundle.putCharSequenceArray("choices", remoteInput.e());
        bundle.putBoolean("allowFreeFormInput", remoteInput.c());
        bundle.putBundle("extras", remoteInput.g());
        Set<String> d = remoteInput.d();
        if (d != null && !d.isEmpty()) {
            ArrayList arrayList = new ArrayList(d.size());
            for (String add : d) {
                arrayList.add(add);
            }
            bundle.putStringArrayList("allowedDataTypes", arrayList);
        }
        return bundle;
    }

    public static Bundle[] c(RemoteInput[] remoteInputArr) {
        if (remoteInputArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[remoteInputArr.length];
        for (int i = 0; i < remoteInputArr.length; i++) {
            bundleArr[i] = b(remoteInputArr[i]);
        }
        return bundleArr;
    }
}
