package androidx.media;

import android.text.TextUtils;
import androidx.core.util.ObjectsCompat;
import androidx.media.MediaSessionManager;

class MediaSessionManagerImplBase implements MediaSessionManager.MediaSessionManagerImpl {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f1459a = MediaSessionManager.f1457a;

    public static class RemoteUserInfoImplBase implements MediaSessionManager.RemoteUserInfoImpl {

        /* renamed from: a  reason: collision with root package name */
        public String f1460a;
        public int b;
        public int c;

        public RemoteUserInfoImplBase(String str, int i, int i2) {
            this.f1460a = str;
            this.b = i;
            this.c = i2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RemoteUserInfoImplBase)) {
                return false;
            }
            RemoteUserInfoImplBase remoteUserInfoImplBase = (RemoteUserInfoImplBase) obj;
            return (this.b == -1 || remoteUserInfoImplBase.b == -1) ? TextUtils.equals(this.f1460a, remoteUserInfoImplBase.f1460a) && this.c == remoteUserInfoImplBase.c : TextUtils.equals(this.f1460a, remoteUserInfoImplBase.f1460a) && this.b == remoteUserInfoImplBase.b && this.c == remoteUserInfoImplBase.c;
        }

        public int hashCode() {
            return ObjectsCompat.b(this.f1460a, Integer.valueOf(this.c));
        }
    }
}
