package com.bumptech.glide.load.model;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.InputStream;

public class ResourceLoader<Data> implements ModelLoader<Integer, Data> {

    /* renamed from: a  reason: collision with root package name */
    public final ModelLoader f2580a;
    public final Resources b;

    public static final class AssetFileDescriptorFactory implements ModelLoaderFactory<Integer, AssetFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        public final Resources f2581a;

        public AssetFileDescriptorFactory(Resources resources) {
            this.f2581a = resources;
        }

        public ModelLoader c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.f2581a, multiModelLoaderFactory.d(Uri.class, AssetFileDescriptor.class));
        }
    }

    @Deprecated
    public static class FileDescriptorFactory implements ModelLoaderFactory<Integer, ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        public final Resources f2582a;

        public ModelLoader c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.f2582a, multiModelLoaderFactory.d(Uri.class, ParcelFileDescriptor.class));
        }
    }

    public static class StreamFactory implements ModelLoaderFactory<Integer, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        public final Resources f2583a;

        public StreamFactory(Resources resources) {
            this.f2583a = resources;
        }

        public ModelLoader c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.f2583a, multiModelLoaderFactory.d(Uri.class, InputStream.class));
        }
    }

    public static class UriFactory implements ModelLoaderFactory<Integer, Uri> {

        /* renamed from: a  reason: collision with root package name */
        public final Resources f2584a;

        public UriFactory(Resources resources) {
            this.f2584a = resources;
        }

        public ModelLoader c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.f2584a, UnitModelLoader.c());
        }
    }

    public ResourceLoader(Resources resources, ModelLoader modelLoader) {
        this.b = resources;
        this.f2580a = modelLoader;
    }

    /* renamed from: c */
    public ModelLoader.LoadData a(Integer num, int i, int i2, Options options) {
        Uri d = d(num);
        if (d == null) {
            return null;
        }
        return this.f2580a.a(d, i, i2, options);
    }

    public final Uri d(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.b.getResourcePackageName(num.intValue()) + '/' + this.b.getResourceTypeName(num.intValue()) + '/' + this.b.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e) {
            if (!Log.isLoggable("ResourceLoader", 5)) {
                return null;
            }
            Log.w("ResourceLoader", "Received invalid resource id: " + num, e);
            return null;
        }
    }

    /* renamed from: e */
    public boolean b(Integer num) {
        return true;
    }
}
