package com.bumptech.glide.load;

import android.content.Context;
import com.bumptech.glide.load.engine.Resource;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;

public class MultiTransformation<T> implements Transformation<T> {
    public final Collection b;

    public MultiTransformation(Transformation... transformationArr) {
        if (transformationArr.length != 0) {
            this.b = Arrays.asList(transformationArr);
            return;
        }
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }

    public Resource a(Context context, Resource resource, int i, int i2) {
        Resource resource2 = resource;
        for (Transformation a2 : this.b) {
            Resource a3 = a2.a(context, resource2, i, i2);
            if (resource2 != null && !resource2.equals(resource) && !resource2.equals(a3)) {
                resource2.a();
            }
            resource2 = a3;
        }
        return resource2;
    }

    public void b(MessageDigest messageDigest) {
        for (Transformation b2 : this.b) {
            b2.b(messageDigest);
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof MultiTransformation) {
            return this.b.equals(((MultiTransformation) obj).b);
        }
        return false;
    }

    public int hashCode() {
        return this.b.hashCode();
    }
}
