package androidx.media;

import android.media.session.MediaSessionManager;
import androidx.annotation.RequiresApi;
import androidx.media.MediaSessionManagerImplBase;

@RequiresApi
class MediaSessionManagerImplApi28 extends MediaSessionManagerImplApi21 {

    public static final class RemoteUserInfoImplApi28 extends MediaSessionManagerImplBase.RemoteUserInfoImplBase {
        public final MediaSessionManager.RemoteUserInfo d;

        public RemoteUserInfoImplApi28(String str, int i, int i2) {
            super(str, i, i2);
            this.d = new MediaSessionManager.RemoteUserInfo(str, i, i2);
        }

        public RemoteUserInfoImplApi28(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            super(remoteUserInfo.getPackageName(), remoteUserInfo.getPid(), remoteUserInfo.getUid());
            this.d = remoteUserInfo;
        }
    }
}
