package com.bumptech.glide.load.model;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;
import com.bumptech.glide.signature.ObjectKey;
import java.io.IOException;
import java.io.InputStream;

public final class DirectResourceLoader<DataT> implements ModelLoader<Integer, DataT> {

    /* renamed from: a  reason: collision with root package name */
    public final Context f2556a;
    public final ResourceOpener b;

    public static final class AssetFileDescriptorFactory implements ModelLoaderFactory<Integer, AssetFileDescriptor>, ResourceOpener<AssetFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        public final Context f2557a;

        public AssetFileDescriptorFactory(Context context) {
            this.f2557a = context;
        }

        public Class a() {
            return AssetFileDescriptor.class;
        }

        public ModelLoader c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new DirectResourceLoader(this.f2557a, this);
        }

        /* renamed from: d */
        public void close(AssetFileDescriptor assetFileDescriptor) {
            assetFileDescriptor.close();
        }

        /* renamed from: e */
        public AssetFileDescriptor b(Resources.Theme theme, Resources resources, int i) {
            return resources.openRawResourceFd(i);
        }
    }

    public static final class DrawableFactory implements ModelLoaderFactory<Integer, Drawable>, ResourceOpener<Drawable> {

        /* renamed from: a  reason: collision with root package name */
        public final Context f2558a;

        public DrawableFactory(Context context) {
            this.f2558a = context;
        }

        public Class a() {
            return Drawable.class;
        }

        public ModelLoader c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new DirectResourceLoader(this.f2558a, this);
        }

        /* renamed from: d */
        public void close(Drawable drawable) {
        }

        /* renamed from: e */
        public Drawable b(Resources.Theme theme, Resources resources, int i) {
            return DrawableDecoderCompat.a(this.f2558a, i, theme);
        }
    }

    public static final class InputStreamFactory implements ModelLoaderFactory<Integer, InputStream>, ResourceOpener<InputStream> {

        /* renamed from: a  reason: collision with root package name */
        public final Context f2559a;

        public InputStreamFactory(Context context) {
            this.f2559a = context;
        }

        public Class a() {
            return InputStream.class;
        }

        public ModelLoader c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new DirectResourceLoader(this.f2559a, this);
        }

        /* renamed from: d */
        public void close(InputStream inputStream) {
            inputStream.close();
        }

        /* renamed from: e */
        public InputStream b(Resources.Theme theme, Resources resources, int i) {
            return resources.openRawResource(i);
        }
    }

    public static final class ResourceDataFetcher<DataT> implements DataFetcher<DataT> {

        /* renamed from: a  reason: collision with root package name */
        public final Resources.Theme f2560a;
        public final Resources b;
        public final ResourceOpener c;
        public final int d;
        public Object e;

        public ResourceDataFetcher(Resources.Theme theme, Resources resources, ResourceOpener resourceOpener, int i) {
            this.f2560a = theme;
            this.b = resources;
            this.c = resourceOpener;
            this.d = i;
        }

        public Class a() {
            return this.c.a();
        }

        public void b() {
            Object obj = this.e;
            if (obj != null) {
                try {
                    this.c.close(obj);
                } catch (IOException unused) {
                }
            }
        }

        public DataSource c() {
            return DataSource.LOCAL;
        }

        public void cancel() {
        }

        public void d(Priority priority, DataFetcher.DataCallback dataCallback) {
            try {
                Object b2 = this.c.b(this.f2560a, this.b, this.d);
                this.e = b2;
                dataCallback.e(b2);
            } catch (Resources.NotFoundException e2) {
                dataCallback.f(e2);
            }
        }
    }

    public interface ResourceOpener<DataT> {
        Class a();

        Object b(Resources.Theme theme, Resources resources, int i);

        void close(Object obj);
    }

    public DirectResourceLoader(Context context, ResourceOpener resourceOpener) {
        this.f2556a = context.getApplicationContext();
        this.b = resourceOpener;
    }

    public static ModelLoaderFactory c(Context context) {
        return new AssetFileDescriptorFactory(context);
    }

    public static ModelLoaderFactory e(Context context) {
        return new DrawableFactory(context);
    }

    public static ModelLoaderFactory g(Context context) {
        return new InputStreamFactory(context);
    }

    /* renamed from: d */
    public ModelLoader.LoadData a(Integer num, int i, int i2, Options options) {
        Resources.Theme theme = (Resources.Theme) options.c(ResourceDrawableDecoder.b);
        return new ModelLoader.LoadData(new ObjectKey(num), new ResourceDataFetcher(theme, theme != null ? theme.getResources() : this.f2556a.getResources(), this.b, num.intValue()));
    }

    /* renamed from: f */
    public boolean b(Integer num) {
        return true;
    }
}
