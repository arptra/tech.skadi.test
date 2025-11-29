package androidx.media;

import android.media.session.MediaSessionManager;
import android.util.Log;
import androidx.media.MediaSessionManagerImplApi28;

public final class MediaSessionManager {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f1457a = Log.isLoggable("MediaSessionManager", 3);
    public static final Object b = new Object();

    public interface MediaSessionManagerImpl {
    }

    public interface RemoteUserInfoImpl {
    }

    public static final class RemoteUserInfo {

        /* renamed from: a  reason: collision with root package name */
        public RemoteUserInfoImpl f1458a;

        public RemoteUserInfo(String str, int i, int i2) {
            this.f1458a = new MediaSessionManagerImplApi28.RemoteUserInfoImplApi28(str, i, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RemoteUserInfo)) {
                return false;
            }
            return this.f1458a.equals(((RemoteUserInfo) obj).f1458a);
        }

        public int hashCode() {
            return this.f1458a.hashCode();
        }

        public RemoteUserInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            this.f1458a = new MediaSessionManagerImplApi28.RemoteUserInfoImplApi28(remoteUserInfo);
        }
    }
}
