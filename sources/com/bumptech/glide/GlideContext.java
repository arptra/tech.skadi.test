package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.util.GlideSuppliers;
import java.util.List;
import java.util.Map;

public class GlideContext extends ContextWrapper {
    public static final TransitionOptions k = new GenericTransitionOptions();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayPool f2419a;
    public final GlideSuppliers.GlideSupplier b;
    public final ImageViewTargetFactory c;
    public final Glide.RequestOptionsFactory d;
    public final List e;
    public final Map f;
    public final Engine g;
    public final GlideExperiments h;
    public final int i;
    public RequestOptions j;

    public GlideContext(Context context, ArrayPool arrayPool, GlideSuppliers.GlideSupplier glideSupplier, ImageViewTargetFactory imageViewTargetFactory, Glide.RequestOptionsFactory requestOptionsFactory, Map map, List list, Engine engine, GlideExperiments glideExperiments, int i2) {
        super(context.getApplicationContext());
        this.f2419a = arrayPool;
        this.c = imageViewTargetFactory;
        this.d = requestOptionsFactory;
        this.e = list;
        this.f = map;
        this.g = engine;
        this.h = glideExperiments;
        this.i = i2;
        this.b = GlideSuppliers.a(glideSupplier);
    }

    public ViewTarget a(ImageView imageView, Class cls) {
        return this.c.a(imageView, cls);
    }

    public ArrayPool b() {
        return this.f2419a;
    }

    public List c() {
        return this.e;
    }

    public synchronized RequestOptions d() {
        try {
            if (this.j == null) {
                this.j = (RequestOptions) this.d.build().O();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.j;
    }

    public TransitionOptions e(Class cls) {
        TransitionOptions transitionOptions = (TransitionOptions) this.f.get(cls);
        if (transitionOptions == null) {
            for (Map.Entry entry : this.f.entrySet()) {
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    transitionOptions = (TransitionOptions) entry.getValue();
                }
            }
        }
        return transitionOptions == null ? k : transitionOptions;
    }

    public Engine f() {
        return this.g;
    }

    public GlideExperiments g() {
        return this.h;
    }

    public int h() {
        return this.i;
    }

    public Registry i() {
        return (Registry) this.b.get();
    }
}
