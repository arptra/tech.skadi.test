package com.bumptech.glide.load.resource;

import android.content.Context;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import java.security.MessageDigest;

public final class UnitTransformation<T> implements Transformation<T> {
    public static final Transformation b = new UnitTransformation();

    public static UnitTransformation c() {
        return (UnitTransformation) b;
    }

    public Resource a(Context context, Resource resource, int i, int i2) {
        return resource;
    }

    public void b(MessageDigest messageDigest) {
    }
}
