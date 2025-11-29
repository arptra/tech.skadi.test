package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.resource.drawable.DrawableResource;

public class GifDrawableResource extends DrawableResource<GifDrawable> implements Initializable {
    public GifDrawableResource(GifDrawable gifDrawable) {
        super(gifDrawable);
    }

    public void a() {
        ((GifDrawable) this.f2658a).stop();
        ((GifDrawable) this.f2658a).k();
    }

    public int b() {
        return ((GifDrawable) this.f2658a).i();
    }

    public Class c() {
        return GifDrawable.class;
    }

    public void initialize() {
        ((GifDrawable) this.f2658a).e().prepareToDraw();
    }
}
