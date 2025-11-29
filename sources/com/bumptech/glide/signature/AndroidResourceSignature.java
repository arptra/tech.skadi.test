package com.bumptech.glide.signature;

import android.content.Context;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public final class AndroidResourceSignature implements Key {
    public final int b;
    public final Key c;

    public AndroidResourceSignature(int i, Key key) {
        this.b = i;
        this.c = key;
    }

    public static Key c(Context context) {
        return new AndroidResourceSignature(context.getResources().getConfiguration().uiMode & 48, ApplicationVersionSignature.c(context));
    }

    public void b(MessageDigest messageDigest) {
        this.c.b(messageDigest);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.b).array());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AndroidResourceSignature)) {
            return false;
        }
        AndroidResourceSignature androidResourceSignature = (AndroidResourceSignature) obj;
        return this.b == androidResourceSignature.b && this.c.equals(androidResourceSignature.c);
    }

    public int hashCode() {
        return Util.q(this.c, this.b);
    }
}
